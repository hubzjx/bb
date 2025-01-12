package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class AsyncTimeout extends Timeout {
    public static final Companion Companion = new Companion(null);
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
            synchronized (AsyncTimeout.class) {
                if (asyncTimeout.inQueue) {
                    asyncTimeout.inQueue = false;
                    for (AsyncTimeout asyncTimeout2 = AsyncTimeout.head; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.next) {
                        if (asyncTimeout2.next == asyncTimeout) {
                            asyncTimeout2.next = asyncTimeout.next;
                            asyncTimeout.next = null;
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005b A[Catch: all -> 0x009b, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000b, B:8:0x0014, B:9:0x0024, B:12:0x0030, B:13:0x0039, B:18:0x004a, B:19:0x0052, B:21:0x005b, B:24:0x006b, B:25:0x0070, B:27:0x0080, B:28:0x0085, B:17:0x0043, B:31:0x0089, B:32:0x008e, B:33:0x008f, B:34:0x009a), top: B:38:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0080 A[Catch: all -> 0x009b, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000b, B:8:0x0014, B:9:0x0024, B:12:0x0030, B:13:0x0039, B:18:0x004a, B:19:0x0052, B:21:0x005b, B:24:0x006b, B:25:0x0070, B:27:0x0080, B:28:0x0085, B:17:0x0043, B:31:0x0089, B:32:0x008e, B:33:0x008f, B:34:0x009a), top: B:38:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0070 A[EDGE_INSN: B:40:0x0070->B:25:0x0070 ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void scheduleTimeout(AsyncTimeout asyncTimeout, long j6, boolean z5) {
            AsyncTimeout asyncTimeout2;
            synchronized (AsyncTimeout.class) {
                if (!(!asyncTimeout.inQueue)) {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
                asyncTimeout.inQueue = true;
                if (AsyncTimeout.head == null) {
                    AsyncTimeout.head = new AsyncTimeout();
                    new Watchdog().start();
                }
                long nanoTime = System.nanoTime();
                int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
                if (i6 != 0 && z5) {
                    j6 = Math.min(j6, asyncTimeout.deadlineNanoTime() - nanoTime);
                } else if (i6 == 0) {
                    if (!z5) {
                        throw new AssertionError();
                    }
                    asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
                    long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
                    asyncTimeout2 = AsyncTimeout.head;
                    while (true) {
                        kotlin.jvm.internal.l.b(asyncTimeout2);
                        if (asyncTimeout2.next != null) {
                            break;
                        }
                        AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                        kotlin.jvm.internal.l.b(asyncTimeout3);
                        if (remainingNanos < asyncTimeout3.remainingNanos(nanoTime)) {
                            break;
                        }
                        asyncTimeout2 = asyncTimeout2.next;
                    }
                    asyncTimeout.next = asyncTimeout2.next;
                    asyncTimeout2.next = asyncTimeout;
                    if (asyncTimeout2 == AsyncTimeout.head) {
                        AsyncTimeout.class.notify();
                    }
                    h4.q qVar = h4.q.f10774a;
                }
                asyncTimeout.timeoutAt = j6 + nanoTime;
                long remainingNanos2 = asyncTimeout.remainingNanos(nanoTime);
                asyncTimeout2 = AsyncTimeout.head;
                while (true) {
                    kotlin.jvm.internal.l.b(asyncTimeout2);
                    if (asyncTimeout2.next != null) {
                    }
                    asyncTimeout2 = asyncTimeout2.next;
                }
                asyncTimeout.next = asyncTimeout2.next;
                asyncTimeout2.next = asyncTimeout;
                if (asyncTimeout2 == AsyncTimeout.head) {
                }
                h4.q qVar2 = h4.q.f10774a;
            }
        }

        public final AsyncTimeout awaitTimeout$okio() {
            AsyncTimeout asyncTimeout = AsyncTimeout.head;
            kotlin.jvm.internal.l.b(asyncTimeout);
            AsyncTimeout asyncTimeout2 = asyncTimeout.next;
            long nanoTime = System.nanoTime();
            if (asyncTimeout2 == null) {
                AsyncTimeout.class.wait(AsyncTimeout.IDLE_TIMEOUT_MILLIS);
                AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
                kotlin.jvm.internal.l.b(asyncTimeout3);
                if (asyncTimeout3.next != null || System.nanoTime() - nanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long remainingNanos = asyncTimeout2.remainingNanos(nanoTime);
            if (remainingNanos > 0) {
                long j6 = remainingNanos / 1000000;
                AsyncTimeout.class.wait(j6, (int) (remainingNanos - (1000000 * j6)));
                return null;
            }
            AsyncTimeout asyncTimeout4 = AsyncTimeout.head;
            kotlin.jvm.internal.l.b(asyncTimeout4);
            asyncTimeout4.next = asyncTimeout2.next;
            asyncTimeout2.next = null;
            return asyncTimeout2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AsyncTimeout awaitTimeout$okio;
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        awaitTimeout$okio = AsyncTimeout.Companion.awaitTimeout$okio();
                        if (awaitTimeout$okio == AsyncTimeout.head) {
                            AsyncTimeout.head = null;
                            return;
                        }
                        h4.q qVar = h4.q.f10774a;
                    }
                    if (awaitTimeout$okio != null) {
                        awaitTimeout$okio.timedOut();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingNanos(long j6) {
        return this.timeoutAt - j6;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            Companion.scheduleTimeout(this, timeoutNanos, hasDeadline);
        }
    }

    public final boolean exit() {
        return Companion.cancelScheduledTimeout(this);
    }

    protected IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(final Sink sink) {
        kotlin.jvm.internal.l.d(sink, "sink");
        return new Sink() { // from class: okio.AsyncTimeout$sink$1
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Sink sink2 = sink;
                asyncTimeout.enter();
                try {
                    sink2.close();
                    h4.q qVar = h4.q.f10774a;
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e6) {
                    if (!asyncTimeout.exit()) {
                        throw e6;
                    }
                    throw asyncTimeout.access$newTimeoutException(e6);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Sink sink2 = sink;
                asyncTimeout.enter();
                try {
                    sink2.flush();
                    h4.q qVar = h4.q.f10774a;
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e6) {
                    if (!asyncTimeout.exit()) {
                        throw e6;
                    }
                    throw asyncTimeout.access$newTimeoutException(e6);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Sink
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ')';
            }

            @Override // okio.Sink
            public void write(Buffer buffer, long j6) {
                kotlin.jvm.internal.l.d(buffer, "source");
                _UtilKt.checkOffsetAndCount(buffer.size(), 0L, j6);
                while (true) {
                    long j7 = 0;
                    if (j6 <= 0) {
                        return;
                    }
                    Segment segment = buffer.head;
                    while (true) {
                        kotlin.jvm.internal.l.b(segment);
                        if (j7 >= 65536) {
                            break;
                        }
                        j7 += segment.limit - segment.pos;
                        if (j7 >= j6) {
                            j7 = j6;
                            break;
                        }
                        segment = segment.next;
                    }
                    AsyncTimeout asyncTimeout = AsyncTimeout.this;
                    Sink sink2 = sink;
                    asyncTimeout.enter();
                    try {
                        sink2.write(buffer, j7);
                        h4.q qVar = h4.q.f10774a;
                        if (asyncTimeout.exit()) {
                            throw asyncTimeout.access$newTimeoutException(null);
                        }
                        j6 -= j7;
                    } catch (IOException e6) {
                        if (!asyncTimeout.exit()) {
                            throw e6;
                        }
                        throw asyncTimeout.access$newTimeoutException(e6);
                    } finally {
                        asyncTimeout.exit();
                    }
                }
            }
        };
    }

    public final Source source(final Source source) {
        kotlin.jvm.internal.l.d(source, "source");
        return new Source() { // from class: okio.AsyncTimeout$source$1
            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Source source2 = source;
                asyncTimeout.enter();
                try {
                    source2.close();
                    h4.q qVar = h4.q.f10774a;
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e6) {
                    if (!asyncTimeout.exit()) {
                        throw e6;
                    }
                    throw asyncTimeout.access$newTimeoutException(e6);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Source
            public long read(Buffer buffer, long j6) {
                kotlin.jvm.internal.l.d(buffer, "sink");
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Source source2 = source;
                asyncTimeout.enter();
                try {
                    long read = source2.read(buffer, j6);
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                    return read;
                } catch (IOException e6) {
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(e6);
                    }
                    throw e6;
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Source
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ')';
            }
        };
    }

    protected void timedOut() {
    }

    public final <T> T withTimeout(p4.a aVar) {
        kotlin.jvm.internal.l.d(aVar, "block");
        enter();
        try {
            try {
                T t5 = (T) aVar.invoke();
                kotlin.jvm.internal.k.b(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                kotlin.jvm.internal.k.a(1);
                return t5;
            } catch (IOException e6) {
                if (exit()) {
                    throw access$newTimeoutException(e6);
                }
                throw e6;
            }
        } catch (Throwable th) {
            kotlin.jvm.internal.k.b(1);
            exit();
            kotlin.jvm.internal.k.a(1);
            throw th;
        }
    }
}
