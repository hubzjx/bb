package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class Timeout {
    public static final Companion Companion = new Companion(null);
    public static final Timeout NONE = new Timeout() { // from class: okio.Timeout$Companion$NONE$1
        @Override // okio.Timeout
        public Timeout deadlineNanoTime(long j6) {
            return this;
        }

        @Override // okio.Timeout
        public void throwIfReached() {
        }

        @Override // okio.Timeout
        public Timeout timeout(long j6, TimeUnit timeUnit) {
            kotlin.jvm.internal.l.d(timeUnit, "unit");
            return this;
        }
    };
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final long minTimeout(long j6, long j7) {
            return (j6 != 0 && (j7 == 0 || j6 < j7)) ? j6 : j7;
        }
    }

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final Timeout deadline(long j6, TimeUnit timeUnit) {
        kotlin.jvm.internal.l.d(timeUnit, "unit");
        if (j6 > 0) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j6));
        }
        throw new IllegalArgumentException(("duration <= 0: " + j6).toString());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(Timeout timeout, p4.a aVar) {
        kotlin.jvm.internal.l.d(timeout, "other");
        kotlin.jvm.internal.l.d(aVar, "block");
        long timeoutNanos = timeoutNanos();
        long minTimeout = Companion.minTimeout(timeout.timeoutNanos(), timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(minTimeout, timeUnit);
        if (!hasDeadline()) {
            if (timeout.hasDeadline()) {
                deadlineNanoTime(timeout.deadlineNanoTime());
            }
            try {
                T t5 = (T) aVar.invoke();
                kotlin.jvm.internal.k.b(1);
                timeout(timeoutNanos, timeUnit);
                if (timeout.hasDeadline()) {
                    clearDeadline();
                }
                kotlin.jvm.internal.k.a(1);
                return t5;
            } catch (Throwable th) {
                kotlin.jvm.internal.k.b(1);
                timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout.hasDeadline()) {
                    clearDeadline();
                }
                kotlin.jvm.internal.k.a(1);
                throw th;
            }
        }
        long deadlineNanoTime = deadlineNanoTime();
        if (timeout.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), timeout.deadlineNanoTime()));
        }
        try {
            T t6 = (T) aVar.invoke();
            kotlin.jvm.internal.k.b(1);
            timeout(timeoutNanos, timeUnit);
            if (timeout.hasDeadline()) {
                deadlineNanoTime(deadlineNanoTime);
            }
            kotlin.jvm.internal.k.a(1);
            return t6;
        } catch (Throwable th2) {
            kotlin.jvm.internal.k.b(1);
            timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout.hasDeadline()) {
                deadlineNanoTime(deadlineNanoTime);
            }
            kotlin.jvm.internal.k.a(1);
            throw th2;
        }
    }

    public void throwIfReached() {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public Timeout timeout(long j6, TimeUnit timeUnit) {
        kotlin.jvm.internal.l.d(timeUnit, "unit");
        if (j6 >= 0) {
            this.timeoutNanos = timeUnit.toNanos(j6);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j6).toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object obj) {
        kotlin.jvm.internal.l.d(obj, "monitor");
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            long j6 = 0;
            if (!hasDeadline && timeoutNanos == 0) {
                obj.wait();
                return;
            }
            long nanoTime = System.nanoTime();
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - nanoTime;
            }
            if (timeoutNanos > 0) {
                long j7 = timeoutNanos / 1000000;
                Long.signum(j7);
                obj.wait(j7, (int) (timeoutNanos - (1000000 * j7)));
                j6 = System.nanoTime() - nanoTime;
            }
            if (j6 >= timeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public Timeout deadlineNanoTime(long j6) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j6;
        return this;
    }
}
