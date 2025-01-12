package okio;

import java.io.InterruptedIOException;
/* loaded from: classes.dex */
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler() {
        this(System.nanoTime());
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j6, long j7, long j8, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j7 = throttler.waitByteCount;
        }
        long j9 = j7;
        if ((i6 & 4) != 0) {
            j8 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j6, j9, j8);
    }

    private final long bytesToNanos(long j6) {
        return (j6 * 1000000000) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long j6) {
        return (j6 * this.bytesPerSecond) / 1000000000;
    }

    private final void waitNanos(long j6) {
        long j7 = j6 / 1000000;
        wait(j7, (int) (j6 - (1000000 * j7)));
    }

    public final long byteCountOrWaitNanos$okio(long j6, long j7) {
        long bytesToNanos;
        if (this.bytesPerSecond == 0) {
            return j7;
        }
        long max = Math.max(this.allocatedUntil - j6, 0L);
        long nanosToBytes = this.maxByteCount - nanosToBytes(max);
        if (nanosToBytes >= j7) {
            j6 += max;
            bytesToNanos = bytesToNanos(j7);
        } else {
            long j8 = this.waitByteCount;
            if (nanosToBytes >= j8) {
                this.allocatedUntil = j6 + bytesToNanos(this.maxByteCount);
                return nanosToBytes;
            }
            j7 = Math.min(j8, j7);
            long bytesToNanos2 = max + bytesToNanos(j7 - this.maxByteCount);
            if (bytesToNanos2 != 0) {
                return -bytesToNanos2;
            }
            bytesToNanos = bytesToNanos(this.maxByteCount);
        }
        this.allocatedUntil = j6 + bytesToNanos;
        return j7;
    }

    public final void bytesPerSecond(long j6) {
        bytesPerSecond$default(this, j6, 0L, 0L, 6, null);
    }

    public final Sink sink(final Sink sink) {
        kotlin.jvm.internal.l.d(sink, "sink");
        return new ForwardingSink(sink) { // from class: okio.Throttler$sink$1
            @Override // okio.ForwardingSink, okio.Sink
            public void write(Buffer buffer, long j6) {
                kotlin.jvm.internal.l.d(buffer, "source");
                while (j6 > 0) {
                    try {
                        long take$okio = this.take$okio(j6);
                        super.write(buffer, take$okio);
                        j6 -= take$okio;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException("interrupted");
                    }
                }
            }
        };
    }

    public final Source source(final Source source) {
        kotlin.jvm.internal.l.d(source, "source");
        return new ForwardingSource(source) { // from class: okio.Throttler$source$1
            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j6) {
                kotlin.jvm.internal.l.d(buffer, "sink");
                try {
                    return super.read(buffer, this.take$okio(j6));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    public final long take$okio(long j6) {
        long byteCountOrWaitNanos$okio;
        if (j6 > 0) {
            synchronized (this) {
                while (true) {
                    byteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), j6);
                    if (byteCountOrWaitNanos$okio < 0) {
                        waitNanos(-byteCountOrWaitNanos$okio);
                    }
                }
            }
            return byteCountOrWaitNanos$okio;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public Throttler(long j6) {
        this.allocatedUntil = j6;
        this.waitByteCount = 8192L;
        this.maxByteCount = 262144L;
    }

    public final void bytesPerSecond(long j6, long j7) {
        bytesPerSecond$default(this, j6, j7, 0L, 4, null);
    }

    public final void bytesPerSecond(long j6, long j7, long j8) {
        synchronized (this) {
            if (!(j6 >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(j7 > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(j8 >= j7)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.bytesPerSecond = j6;
            this.waitByteCount = j7;
            this.maxByteCount = j8;
            notifyAll();
            h4.q qVar = h4.q.f10774a;
        }
    }
}
