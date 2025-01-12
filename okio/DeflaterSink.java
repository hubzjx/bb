package okio;

import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
/* loaded from: classes.dex */
public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        kotlin.jvm.internal.l.d(bufferedSink, "sink");
        kotlin.jvm.internal.l.d(deflater, "deflater");
        this.sink = bufferedSink;
        this.deflater = deflater;
    }

    @IgnoreJRERequirement
    private final void deflate(boolean z5) {
        Segment writableSegment$okio;
        Buffer buffer = this.sink.getBuffer();
        while (true) {
            writableSegment$okio = buffer.writableSegment$okio(1);
            Deflater deflater = this.deflater;
            byte[] bArr = writableSegment$okio.data;
            int i6 = writableSegment$okio.limit;
            int i7 = 8192 - i6;
            int deflate = z5 ? deflater.deflate(bArr, i6, i7, 2) : deflater.deflate(bArr, i6, i7);
            if (deflate > 0) {
                writableSegment$okio.limit += deflate;
                buffer.setSize$okio(buffer.size() + deflate);
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        try {
            finishDeflate$okio();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public final void finishDeflate$okio() {
        this.deflater.finish();
        deflate(false);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        deflate(true);
        this.sink.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "source");
        _UtilKt.checkOffsetAndCount(buffer.size(), 0L, j6);
        while (j6 > 0) {
            Segment segment = buffer.head;
            kotlin.jvm.internal.l.b(segment);
            int min = (int) Math.min(j6, segment.limit - segment.pos);
            this.deflater.setInput(segment.data, segment.pos, min);
            deflate(false);
            long j7 = min;
            buffer.setSize$okio(buffer.size() - j7);
            int i6 = segment.pos + min;
            segment.pos = i6;
            if (i6 == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            j6 -= j7;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.buffer(sink), deflater);
        kotlin.jvm.internal.l.d(sink, "sink");
        kotlin.jvm.internal.l.d(deflater, "deflater");
    }
}
