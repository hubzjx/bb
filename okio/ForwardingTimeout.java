package okio;

import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class ForwardingTimeout extends Timeout {
    private Timeout delegate;

    public ForwardingTimeout(Timeout timeout) {
        kotlin.jvm.internal.l.d(timeout, "delegate");
        this.delegate = timeout;
    }

    @Override // okio.Timeout
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // okio.Timeout
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    public final Timeout delegate() {
        return this.delegate;
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    public final ForwardingTimeout setDelegate(Timeout timeout) {
        kotlin.jvm.internal.l.d(timeout, "delegate");
        this.delegate = timeout;
        return this;
    }

    @Override // okio.Timeout
    public void throwIfReached() {
        this.delegate.throwIfReached();
    }

    @Override // okio.Timeout
    public Timeout timeout(long j6, TimeUnit timeUnit) {
        kotlin.jvm.internal.l.d(timeUnit, "unit");
        return this.delegate.timeout(j6, timeUnit);
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @Override // okio.Timeout
    public Timeout deadlineNanoTime(long j6) {
        return this.delegate.deadlineNanoTime(j6);
    }

    /* renamed from: setDelegate  reason: collision with other method in class */
    public final /* synthetic */ void m178setDelegate(Timeout timeout) {
        kotlin.jvm.internal.l.d(timeout, "<set-?>");
        this.delegate = timeout;
    }
}
