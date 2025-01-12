package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes.dex */
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        kotlin.jvm.internal.l.d(bufferedSource, "source");
        kotlin.jvm.internal.l.d(inflater, "inflater");
        this.source = bufferedSource;
        this.inflater = inflater;
    }

    private final void releaseBytesAfterInflate() {
        int i6 = this.bufferBytesHeldByInflater;
        if (i6 == 0) {
            return;
        }
        int remaining = i6 - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "sink");
        do {
            long readOrInflate = readOrInflate(buffer, j6);
            if (readOrInflate > 0) {
                return readOrInflate;
            }
            if (this.inflater.finished() || this.inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.source.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public final long readOrInflate(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "sink");
        int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        } else if (!this.closed) {
            if (i6 == 0) {
                return 0L;
            }
            try {
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                int min = (int) Math.min(j6, 8192 - writableSegment$okio.limit);
                refill();
                int inflate = this.inflater.inflate(writableSegment$okio.data, writableSegment$okio.limit, min);
                releaseBytesAfterInflate();
                if (inflate > 0) {
                    writableSegment$okio.limit += inflate;
                    long j7 = inflate;
                    buffer.setSize$okio(buffer.size() + j7);
                    return j7;
                }
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    buffer.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                return 0L;
            } catch (DataFormatException e6) {
                throw new IOException(e6);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public final boolean refill() {
        if (this.inflater.needsInput()) {
            if (this.source.exhausted()) {
                return true;
            }
            Segment segment = this.source.getBuffer().head;
            kotlin.jvm.internal.l.b(segment);
            int i6 = segment.limit;
            int i7 = segment.pos;
            int i8 = i6 - i7;
            this.bufferBytesHeldByInflater = i8;
            this.inflater.setInput(segment.data, i7, i8);
            return false;
        }
        return false;
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.buffer(source), inflater);
        kotlin.jvm.internal.l.d(source, "source");
        kotlin.jvm.internal.l.d(inflater, "inflater");
    }
}
