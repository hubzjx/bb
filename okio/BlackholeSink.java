package okio;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class BlackholeSink implements Sink {
    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j6) {
        kotlin.jvm.internal.l.d(buffer, "source");
        buffer.skip(j6);
    }
}
