package okio;

import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class OutputStreamSink implements Sink {
    private final OutputStream out;
    private final Timeout timeout;

    public OutputStreamSink(OutputStream outputStream, Timeout timeout) {
        kotlin.jvm.internal.l.d(outputStream, "out");
        kotlin.jvm.internal.l.d(timeout, "timeout");
        this.out = outputStream;
        this.timeout = timeout;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.out.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "sink(" + this.out + ')';
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "source");
        _UtilKt.checkOffsetAndCount(buffer.size(), 0L, j6);
        while (j6 > 0) {
            this.timeout.throwIfReached();
            Segment segment = buffer.head;
            kotlin.jvm.internal.l.b(segment);
            int min = (int) Math.min(j6, segment.limit - segment.pos);
            this.out.write(segment.data, segment.pos, min);
            segment.pos += min;
            long j7 = min;
            j6 -= j7;
            buffer.setSize$okio(buffer.size() - j7);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }
}
