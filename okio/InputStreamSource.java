package okio;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InputStreamSource implements Source {
    private final InputStream input;
    private final Timeout timeout;

    public InputStreamSource(InputStream inputStream, Timeout timeout) {
        kotlin.jvm.internal.l.d(inputStream, "input");
        kotlin.jvm.internal.l.d(timeout, "timeout");
        this.input = inputStream;
        this.timeout = timeout;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.input.close();
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "sink");
        int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        if (i6 == 0) {
            return 0L;
        }
        if (!(i6 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        try {
            this.timeout.throwIfReached();
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int read = this.input.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j6, 8192 - writableSegment$okio.limit));
            if (read != -1) {
                writableSegment$okio.limit += read;
                long j7 = read;
                buffer.setSize$okio(buffer.size() + j7);
                return j7;
            } else if (writableSegment$okio.pos == writableSegment$okio.limit) {
                buffer.head = writableSegment$okio.pop();
                SegmentPool.recycle(writableSegment$okio);
                return -1L;
            } else {
                return -1L;
            }
        } catch (AssertionError e6) {
            if (Okio.isAndroidGetsocknameError(e6)) {
                throw new IOException(e6);
            }
            throw e6;
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "source(" + this.input + ')';
    }
}
