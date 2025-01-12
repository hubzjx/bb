package g;

import f.InterfaceC0274j$v;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$c  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0285j$c extends AbstractC0350j$s0 implements InterfaceC0305j$h {

    /* renamed from: h  reason: collision with root package name */
    private final AbstractC0285j$c f10117h;

    /* renamed from: i  reason: collision with root package name */
    private final AbstractC0285j$c f10118i;

    /* renamed from: j  reason: collision with root package name */
    protected final int f10119j;

    /* renamed from: k  reason: collision with root package name */
    private AbstractC0285j$c f10120k;

    /* renamed from: l  reason: collision with root package name */
    private int f10121l;

    /* renamed from: m  reason: collision with root package name */
    private int f10122m;

    /* renamed from: n  reason: collision with root package name */
    private e.j$J f10123n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10124o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f10125p;

    /* renamed from: q  reason: collision with root package name */
    private Runnable f10126q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10127r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0285j$c(e.j$J j_j, int i6, boolean z5) {
        this.f10118i = null;
        this.f10123n = j_j;
        this.f10117h = this;
        int i7 = j$P2.f10052l & i6;
        this.f10119j = i7;
        this.f10122m = (~(i7 << 1)) & j$P2.f10057q;
        this.f10121l = 0;
        this.f10127r = z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0285j$c(AbstractC0285j$c abstractC0285j$c, int i6) {
        if (abstractC0285j$c.f10124o) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        abstractC0285j$c.f10124o = true;
        abstractC0285j$c.f10120k = this;
        this.f10118i = abstractC0285j$c;
        this.f10119j = j$P2.f10053m & i6;
        this.f10122m = j$P2.a(i6, abstractC0285j$c.f10122m);
        AbstractC0285j$c abstractC0285j$c2 = abstractC0285j$c.f10117h;
        this.f10117h = abstractC0285j$c2;
        if (G0()) {
            abstractC0285j$c2.f10125p = true;
        }
        this.f10121l = abstractC0285j$c.f10121l + 1;
    }

    private e.j$J K0(int i6) {
        int i7;
        int i8;
        AbstractC0285j$c abstractC0285j$c = this.f10117h;
        e.j$J j_j = abstractC0285j$c.f10123n;
        if (j_j != null) {
            abstractC0285j$c.f10123n = null;
            if (abstractC0285j$c.f10127r && abstractC0285j$c.f10125p) {
                AbstractC0285j$c abstractC0285j$c2 = abstractC0285j$c.f10120k;
                int i9 = 1;
                while (abstractC0285j$c != this) {
                    int i10 = abstractC0285j$c2.f10119j;
                    if (abstractC0285j$c2.G0()) {
                        if (j$P2.f10050j.d(i10)) {
                            i10 &= ~j$P2.f10066z;
                        }
                        j_j = abstractC0285j$c2.F0(abstractC0285j$c, j_j);
                        if (j_j.hasCharacteristics(64)) {
                            i7 = (~j$P2.f10065y) & i10;
                            i8 = j$P2.f10064x;
                        } else {
                            i7 = (~j$P2.f10064x) & i10;
                            i8 = j$P2.f10065y;
                        }
                        i10 = i8 | i7;
                        i9 = 0;
                    }
                    abstractC0285j$c2.f10121l = i9;
                    abstractC0285j$c2.f10122m = j$P2.a(i10, abstractC0285j$c.f10122m);
                    i9++;
                    AbstractC0285j$c abstractC0285j$c3 = abstractC0285j$c2;
                    abstractC0285j$c2 = abstractC0285j$c2.f10120k;
                    abstractC0285j$c = abstractC0285j$c3;
                }
            }
            if (i6 != 0) {
                this.f10122m = j$P2.a(i6, this.f10122m);
            }
            return j_j;
        }
        throw new IllegalStateException("source already consumed or closed");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int A0() {
        AbstractC0285j$c abstractC0285j$c = this;
        while (abstractC0285j$c.f10121l > 0) {
            abstractC0285j$c = abstractC0285j$c.f10118i;
        }
        return abstractC0285j$c.z0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean B0() {
        return j$P2.f10048h.d(this.f10122m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ e.j$J C0() {
        return K0(0);
    }

    public final InterfaceC0305j$h D0(final Runnable runnable) {
        AbstractC0285j$c abstractC0285j$c = this.f10117h;
        final Runnable runnable2 = abstractC0285j$c.f10126q;
        if (runnable2 != null) {
            runnable = new Runnable() { // from class: g.j$w3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        runnable2.run();
                        runnable.run();
                    } catch (Throwable th) {
                        try {
                            runnable.run();
                        } catch (Throwable th2) {
                            try {
                                th.addSuppressed(th2);
                            } catch (Throwable unused) {
                            }
                        }
                        throw th;
                    }
                }
            };
        }
        abstractC0285j$c.f10126q = runnable;
        return this;
    }

    j$B0 E0(e.j$J j_j, InterfaceC0274j$v interfaceC0274j$v, AbstractC0285j$c abstractC0285j$c) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    e.j$J F0(AbstractC0285j$c abstractC0285j$c, e.j$J j_j) {
        return E0(j_j, new C0281j$b(0), abstractC0285j$c).spliterator();
    }

    abstract boolean G0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract InterfaceC0284j$b2 H0(int i6, InterfaceC0284j$b2 interfaceC0284j$b2);

    public final InterfaceC0305j$h I0() {
        this.f10117h.f10127r = true;
        return this;
    }

    public final InterfaceC0305j$h J0() {
        this.f10117h.f10127r = false;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final e.j$J L0() {
        AbstractC0285j$c abstractC0285j$c = this.f10117h;
        if (this == abstractC0285j$c) {
            if (this.f10124o) {
                throw new IllegalStateException("stream has already been operated upon or closed");
            }
            this.f10124o = true;
            e.j$J j_j = abstractC0285j$c.f10123n;
            if (j_j != null) {
                abstractC0285j$c.f10123n = null;
                return j_j;
            }
            throw new IllegalStateException("source already consumed or closed");
        }
        throw new IllegalStateException();
    }

    abstract e.j$J M0(AbstractC0350j$s0 abstractC0350j$s0, C0276j$a c0276j$a, boolean z5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final e.j$J N0(e.j$J j_j) {
        return this.f10121l == 0 ? j_j : M0(this, new C0276j$a(0, j_j), this.f10117h.f10127r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0350j$s0
    public final void R(e.j$J j_j, InterfaceC0284j$b2 interfaceC0284j$b2) {
        interfaceC0284j$b2.getClass();
        if (j$P2.f10050j.d(this.f10122m)) {
            S(j_j, interfaceC0284j$b2);
            return;
        }
        interfaceC0284j$b2.i(j_j.getExactSizeIfKnown());
        j_j.b(interfaceC0284j$b2);
        interfaceC0284j$b2.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0350j$s0
    public final void S(e.j$J j_j, InterfaceC0284j$b2 interfaceC0284j$b2) {
        AbstractC0285j$c abstractC0285j$c = this;
        while (abstractC0285j$c.f10121l > 0) {
            abstractC0285j$c = abstractC0285j$c.f10118i;
        }
        interfaceC0284j$b2.i(j_j.getExactSizeIfKnown());
        abstractC0285j$c.y0(j_j, interfaceC0284j$b2);
        interfaceC0284j$b2.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0350j$s0
    public final long W(e.j$J j_j) {
        if (j$P2.f10049i.d(this.f10122m)) {
            return j_j.getExactSizeIfKnown();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0350j$s0
    public final int c0() {
        return this.f10122m;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.f10124o = true;
        this.f10123n = null;
        AbstractC0285j$c abstractC0285j$c = this.f10117h;
        Runnable runnable = abstractC0285j$c.f10126q;
        if (runnable != null) {
            abstractC0285j$c.f10126q = null;
            runnable.run();
        }
    }

    public final boolean isParallel() {
        return this.f10117h.f10127r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0350j$s0
    public final InterfaceC0284j$b2 s0(e.j$J j_j, InterfaceC0284j$b2 interfaceC0284j$b2) {
        interfaceC0284j$b2.getClass();
        R(j_j, t0(interfaceC0284j$b2));
        return interfaceC0284j$b2;
    }

    public e.j$J spliterator() {
        if (this.f10124o) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.f10124o = true;
        AbstractC0285j$c abstractC0285j$c = this.f10117h;
        if (this == abstractC0285j$c) {
            e.j$J j_j = abstractC0285j$c.f10123n;
            if (j_j != null) {
                abstractC0285j$c.f10123n = null;
                return j_j;
            }
            throw new IllegalStateException("source already consumed or closed");
        }
        return M0(this, new C0276j$a(1, this), abstractC0285j$c.f10127r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0350j$s0
    public final InterfaceC0284j$b2 t0(InterfaceC0284j$b2 interfaceC0284j$b2) {
        interfaceC0284j$b2.getClass();
        for (AbstractC0285j$c abstractC0285j$c = this; abstractC0285j$c.f10121l > 0; abstractC0285j$c = abstractC0285j$c.f10118i) {
            interfaceC0284j$b2 = abstractC0285j$c.H0(abstractC0285j$c.f10118i.f10122m, interfaceC0284j$b2);
        }
        return interfaceC0284j$b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j$B0 u0(e.j$J j_j, boolean z5, InterfaceC0274j$v interfaceC0274j$v) {
        if (this.f10117h.f10127r) {
            return x0(this, j_j, z5, interfaceC0274j$v);
        }
        InterfaceC0366j$w0 n02 = n0(W(j_j), interfaceC0274j$v);
        s0(j_j, n02);
        return n02.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object v0(j$x3 j_x3) {
        if (this.f10124o) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.f10124o = true;
        return this.f10117h.f10127r ? j_x3.l(this, K0(j_x3.k())) : j_x3.g(this, K0(j_x3.k()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j$B0 w0(InterfaceC0274j$v interfaceC0274j$v) {
        if (this.f10124o) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.f10124o = true;
        if (this.f10117h.f10127r && this.f10118i != null && G0()) {
            this.f10121l = 0;
            AbstractC0285j$c abstractC0285j$c = this.f10118i;
            return E0(abstractC0285j$c.K0(0), interfaceC0274j$v, abstractC0285j$c);
        }
        return u0(K0(0), true, interfaceC0274j$v);
    }

    abstract j$B0 x0(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, boolean z5, InterfaceC0274j$v interfaceC0274j$v);

    abstract void y0(e.j$J j_j, InterfaceC0284j$b2 interfaceC0284j$b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int z0();
}
