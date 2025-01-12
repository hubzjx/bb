package g;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
final class j$J extends AbstractC0289j$d {

    /* renamed from: j  reason: collision with root package name */
    private final j$D f10009j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$J(j$D j_d, AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j) {
        super(abstractC0350j$s0, j_j);
        this.f10009j = j_d;
    }

    j$J(j$J j_j, e.j$J j_j2) {
        super(j_j, j_j2);
        this.f10009j = j_j.f10009j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.AbstractC0297j$f
    public final Object a() {
        boolean z5;
        AbstractC0350j$s0 abstractC0350j$s0 = this.f10154a;
        j$y3 j_y3 = (j$y3) this.f10009j.f9974d.get();
        abstractC0350j$s0.s0(this.f10155b, j_y3);
        Object obj = j_y3.get();
        if (!this.f10009j.f9971a) {
            if (obj != null) {
                AtomicReference atomicReference = this.f10133h;
                while (!atomicReference.compareAndSet(null, obj) && atomicReference.get() == null) {
                }
            }
            return null;
        } else if (obj != null) {
            j$J j_j = this;
            while (true) {
                if (j_j != null) {
                    AbstractC0297j$f c6 = j_j.c();
                    if (c6 != null && c6.f10157d != j_j) {
                        z5 = false;
                        break;
                    }
                    j_j = c6;
                } else {
                    z5 = true;
                    break;
                }
            }
            if (z5) {
                AtomicReference atomicReference2 = this.f10133h;
                while (!atomicReference2.compareAndSet(null, obj) && atomicReference2.get() == null) {
                }
            } else {
                h();
            }
            return obj;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.AbstractC0297j$f
    public final AbstractC0297j$f d(e.j$J j_j) {
        return new j$J(this, j_j);
    }

    @Override // g.AbstractC0289j$d
    protected final Object i() {
        return this.f10009j.f9972b;
    }

    @Override // g.AbstractC0297j$f, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        boolean z5;
        if (this.f10009j.f9971a) {
            j$J j_j = (j$J) this.f10157d;
            j$J j_j2 = null;
            while (true) {
                if (j_j == j_j2) {
                    break;
                }
                Object b6 = j_j.b();
                if (b6 == null || !this.f10009j.f9973c.l(b6)) {
                    j_j2 = j_j;
                    j_j = (j$J) this.f10158e;
                } else {
                    e(b6);
                    j$J j_j3 = this;
                    while (true) {
                        if (j_j3 != null) {
                            AbstractC0297j$f c6 = j_j3.c();
                            if (c6 != null && c6.f10157d != j_j3) {
                                z5 = false;
                                break;
                            }
                            j_j3 = c6;
                        } else {
                            z5 = true;
                            break;
                        }
                    }
                    if (z5) {
                        AtomicReference atomicReference = this.f10133h;
                        while (!atomicReference.compareAndSet(null, b6) && atomicReference.get() == null) {
                        }
                    } else {
                        h();
                    }
                }
            }
        }
        super.onCompletion(countedCompleter);
    }
}
