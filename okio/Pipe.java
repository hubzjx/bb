package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class Pipe {
    private final Buffer buffer = new Buffer();
    private boolean canceled;
    private Sink foldedSink;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j6) {
        this.maxBufferSize = j6;
        if (j6 >= 1) {
            this.sink = new Sink() { // from class: okio.Pipe$sink$1
                private final Timeout timeout = new Timeout();

                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    Buffer buffer$okio = Pipe.this.getBuffer$okio();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer$okio) {
                        if (pipe.getSinkClosed$okio()) {
                            return;
                        }
                        Sink foldedSink$okio = pipe.getFoldedSink$okio();
                        if (foldedSink$okio == null) {
                            if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                                throw new IOException("source is closed");
                            }
                            pipe.setSinkClosed$okio(true);
                            pipe.getBuffer$okio().notifyAll();
                            foldedSink$okio = null;
                        }
                        h4.q qVar = h4.q.f10774a;
                        if (foldedSink$okio != null) {
                            Pipe pipe2 = Pipe.this;
                            Timeout timeout = foldedSink$okio.timeout();
                            Timeout timeout2 = pipe2.sink().timeout();
                            long timeoutNanos = timeout.timeoutNanos();
                            long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            timeout.timeout(minTimeout, timeUnit);
                            if (!timeout.hasDeadline()) {
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                                }
                                try {
                                    foldedSink$okio.close();
                                    timeout.timeout(timeoutNanos, timeUnit);
                                    if (timeout2.hasDeadline()) {
                                        timeout.clearDeadline();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                    if (timeout2.hasDeadline()) {
                                        timeout.clearDeadline();
                                    }
                                    throw th;
                                }
                            }
                            long deadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink$okio.close();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                            } catch (Throwable th2) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                                throw th2;
                            }
                        }
                    }
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() {
                    Sink foldedSink$okio;
                    Buffer buffer$okio = Pipe.this.getBuffer$okio();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer$okio) {
                        if (!(!pipe.getSinkClosed$okio())) {
                            throw new IllegalStateException("closed".toString());
                        }
                        if (pipe.getCanceled$okio()) {
                            throw new IOException("canceled");
                        }
                        foldedSink$okio = pipe.getFoldedSink$okio();
                        if (foldedSink$okio == null) {
                            if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                                throw new IOException("source is closed");
                            }
                            foldedSink$okio = null;
                        }
                        h4.q qVar = h4.q.f10774a;
                    }
                    if (foldedSink$okio != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe2.sink().timeout();
                        long timeoutNanos = timeout.timeoutNanos();
                        long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(minTimeout, timeUnit);
                        if (!timeout.hasDeadline()) {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink$okio.flush();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                                throw th;
                            }
                        }
                        long deadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            foldedSink$okio.flush();
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                        } catch (Throwable th2) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                            throw th2;
                        }
                    }
                }

                @Override // okio.Sink
                public Timeout timeout() {
                    return this.timeout;
                }

                /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
                    r1 = h4.q.f10774a;
                 */
                @Override // okio.Sink
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void write(Buffer buffer, long j7) {
                    Sink sink;
                    kotlin.jvm.internal.l.d(buffer, "source");
                    Buffer buffer$okio = Pipe.this.getBuffer$okio();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer$okio) {
                        if (!(!pipe.getSinkClosed$okio())) {
                            throw new IllegalStateException("closed".toString());
                        }
                        if (!pipe.getCanceled$okio()) {
                            while (true) {
                                if (j7 <= 0) {
                                    sink = null;
                                    break;
                                }
                                sink = pipe.getFoldedSink$okio();
                                if (sink != null) {
                                    break;
                                } else if (pipe.getSourceClosed$okio()) {
                                    throw new IOException("source is closed");
                                } else {
                                    long maxBufferSize$okio = pipe.getMaxBufferSize$okio() - pipe.getBuffer$okio().size();
                                    if (maxBufferSize$okio == 0) {
                                        this.timeout.waitUntilNotified(pipe.getBuffer$okio());
                                        if (pipe.getCanceled$okio()) {
                                            throw new IOException("canceled");
                                        }
                                    } else {
                                        long min = Math.min(maxBufferSize$okio, j7);
                                        pipe.getBuffer$okio().write(buffer, min);
                                        j7 -= min;
                                        pipe.getBuffer$okio().notifyAll();
                                    }
                                }
                            }
                        } else {
                            throw new IOException("canceled");
                        }
                    }
                    if (sink != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout timeout = sink.timeout();
                        Timeout timeout2 = pipe2.sink().timeout();
                        long timeoutNanos = timeout.timeoutNanos();
                        long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(minTimeout, timeUnit);
                        if (!timeout.hasDeadline()) {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                sink.write(buffer, j7);
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                                throw th;
                            }
                        }
                        long deadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            sink.write(buffer, j7);
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                        } catch (Throwable th2) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                            throw th2;
                        }
                    }
                }
            };
            this.source = new Source() { // from class: okio.Pipe$source$1
                private final Timeout timeout = new Timeout();

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    Buffer buffer$okio = Pipe.this.getBuffer$okio();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer$okio) {
                        pipe.setSourceClosed$okio(true);
                        pipe.getBuffer$okio().notifyAll();
                        h4.q qVar = h4.q.f10774a;
                    }
                }

                @Override // okio.Source
                public long read(Buffer buffer, long j7) {
                    kotlin.jvm.internal.l.d(buffer, "sink");
                    Buffer buffer$okio = Pipe.this.getBuffer$okio();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer$okio) {
                        if (!pipe.getSourceClosed$okio()) {
                            if (pipe.getCanceled$okio()) {
                                throw new IOException("canceled");
                            }
                            while (pipe.getBuffer$okio().size() == 0) {
                                if (pipe.getSinkClosed$okio()) {
                                    return -1L;
                                }
                                this.timeout.waitUntilNotified(pipe.getBuffer$okio());
                                if (pipe.getCanceled$okio()) {
                                    throw new IOException("canceled");
                                }
                            }
                            long read = pipe.getBuffer$okio().read(buffer, j7);
                            pipe.getBuffer$okio().notifyAll();
                            return read;
                        }
                        throw new IllegalStateException("closed".toString());
                    }
                }

                @Override // okio.Source
                public Timeout timeout() {
                    return this.timeout;
                }
            };
            return;
        }
        throw new IllegalArgumentException(("maxBufferSize < 1: " + j6).toString());
    }

    private final void forward(Sink sink, p4.l lVar) {
        Timeout timeout = sink.timeout();
        Timeout timeout2 = sink().timeout();
        long timeoutNanos = timeout.timeoutNanos();
        long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(minTimeout, timeUnit);
        if (timeout.hasDeadline()) {
            long deadlineNanoTime = timeout.deadlineNanoTime();
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                lVar.invoke(sink);
                h4.q qVar = h4.q.f10774a;
                kotlin.jvm.internal.k.b(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
            } catch (Throwable th) {
                kotlin.jvm.internal.k.b(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                kotlin.jvm.internal.k.a(1);
                throw th;
            }
        } else {
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                lVar.invoke(sink);
                h4.q qVar2 = h4.q.f10774a;
                kotlin.jvm.internal.k.b(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
            } catch (Throwable th2) {
                kotlin.jvm.internal.k.b(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                kotlin.jvm.internal.k.a(1);
                throw th2;
            }
        }
        kotlin.jvm.internal.k.a(1);
    }

    /* renamed from: -deprecated_sink  reason: not valid java name */
    public final Sink m182deprecated_sink() {
        return this.sink;
    }

    /* renamed from: -deprecated_source  reason: not valid java name */
    public final Source m183deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        synchronized (this.buffer) {
            this.canceled = true;
            this.buffer.clear();
            this.buffer.notifyAll();
            h4.q qVar = h4.q.f10774a;
        }
    }

    public final void fold(Sink sink) {
        boolean z5;
        Buffer buffer;
        kotlin.jvm.internal.l.d(sink, "sink");
        while (true) {
            synchronized (this.buffer) {
                if (!(this.foldedSink == null)) {
                    throw new IllegalStateException("sink already folded".toString());
                }
                if (this.canceled) {
                    this.foldedSink = sink;
                    throw new IOException("canceled");
                } else if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    return;
                } else {
                    z5 = this.sinkClosed;
                    buffer = new Buffer();
                    Buffer buffer2 = this.buffer;
                    buffer.write(buffer2, buffer2.size());
                    this.buffer.notifyAll();
                    h4.q qVar = h4.q.f10774a;
                }
            }
            try {
                sink.write(buffer, buffer.size());
                if (z5) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th) {
                synchronized (this.buffer) {
                    this.sourceClosed = true;
                    this.buffer.notifyAll();
                    h4.q qVar2 = h4.q.f10774a;
                    throw th;
                }
            }
        }
    }

    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z5) {
        this.canceled = z5;
    }

    public final void setFoldedSink$okio(Sink sink) {
        this.foldedSink = sink;
    }

    public final void setSinkClosed$okio(boolean z5) {
        this.sinkClosed = z5;
    }

    public final void setSourceClosed$okio(boolean z5) {
        this.sourceClosed = z5;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
