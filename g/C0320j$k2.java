package g;

import f.InterfaceC0274j$v;
import java.util.concurrent.CountedCompleter;
/* renamed from: g.j$k2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0320j$k2 extends AbstractC0289j$d {

    /* renamed from: j  reason: collision with root package name */
    private final AbstractC0285j$c f10191j;

    /* renamed from: k  reason: collision with root package name */
    private final InterfaceC0274j$v f10192k;

    /* renamed from: l  reason: collision with root package name */
    private final long f10193l;

    /* renamed from: m  reason: collision with root package name */
    private final long f10194m;

    /* renamed from: n  reason: collision with root package name */
    private long f10195n;

    /* renamed from: o  reason: collision with root package name */
    private volatile boolean f10196o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0320j$k2(AbstractC0285j$c abstractC0285j$c, AbstractC0285j$c abstractC0285j$c2, e.j$J j_j, InterfaceC0274j$v interfaceC0274j$v, long j6, long j7) {
        super(abstractC0285j$c2, j_j);
        this.f10191j = abstractC0285j$c;
        this.f10192k = interfaceC0274j$v;
        this.f10193l = j6;
        this.f10194m = j7;
    }

    C0320j$k2(C0320j$k2 c0320j$k2, e.j$J j_j) {
        super(c0320j$k2, j_j);
        this.f10191j = c0320j$k2.f10191j;
        this.f10192k = c0320j$k2.f10192k;
        this.f10193l = c0320j$k2.f10193l;
        this.f10194m = c0320j$k2.f10194m;
    }

    private long j(long j6) {
        if (this.f10196o) {
            return this.f10195n;
        }
        C0320j$k2 c0320j$k2 = (C0320j$k2) this.f10157d;
        C0320j$k2 c0320j$k22 = (C0320j$k2) this.f10158e;
        if (c0320j$k2 == null || c0320j$k22 == null) {
            return this.f10195n;
        }
        long j7 = c0320j$k2.j(j6);
        return j7 >= j6 ? j7 : j7 + c0320j$k22.j(j6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.AbstractC0297j$f
    public final Object a() {
        if (c() == null) {
            InterfaceC0366j$w0 n02 = this.f10191j.n0(j$P2.f10049i.e(this.f10191j.f10119j) ? this.f10191j.W(this.f10155b) : -1L, this.f10192k);
            InterfaceC0284j$b2 H0 = this.f10191j.H0(this.f10154a.c0(), n02);
            AbstractC0350j$s0 abstractC0350j$s0 = this.f10154a;
            abstractC0350j$s0.S(this.f10155b, abstractC0350j$s0.t0(H0));
            return n02.a();
        }
        AbstractC0350j$s0 abstractC0350j$s02 = this.f10154a;
        InterfaceC0366j$w0 n03 = abstractC0350j$s02.n0(-1L, this.f10192k);
        abstractC0350j$s02.s0(this.f10155b, n03);
        j$B0 a6 = n03.a();
        this.f10195n = a6.count();
        this.f10196o = true;
        this.f10155b = null;
        return a6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.AbstractC0297j$f
    public final AbstractC0297j$f d(e.j$J j_j) {
        return new C0320j$k2(this, j_j);
    }

    @Override // g.AbstractC0289j$d
    protected final void g() {
        this.f10134i = true;
        if (this.f10196o) {
            e(i());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g.AbstractC0289j$d
    /* renamed from: k */
    public final j$U0 i() {
        return AbstractC0350j$s0.V(this.f10191j.z0());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    @Override // g.AbstractC0297j$f, java.util.concurrent.CountedCompleter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onCompletion(CountedCompleter countedCompleter) {
        C0320j$k2 c0320j$k2;
        j$B0 Q;
        AbstractC0297j$f abstractC0297j$f = this.f10157d;
        boolean z5 = true;
        if (!(abstractC0297j$f == null)) {
            this.f10195n = ((C0320j$k2) abstractC0297j$f).f10195n + ((C0320j$k2) this.f10158e).f10195n;
            if (this.f10134i) {
                this.f10195n = 0L;
            } else if (this.f10195n != 0) {
                Q = ((C0320j$k2) this.f10157d).f10195n == 0 ? (j$B0) ((C0320j$k2) this.f10158e).b() : AbstractC0350j$s0.Q(this.f10191j.z0(), (j$B0) ((C0320j$k2) this.f10157d).b(), (j$B0) ((C0320j$k2) this.f10158e).b());
                j$B0 j_b0 = Q;
                if (c() != null) {
                    j_b0 = j_b0.r(this.f10193l, this.f10194m >= 0 ? Math.min(j_b0.count(), this.f10193l + this.f10194m) : this.f10195n, this.f10192k);
                }
                e(j_b0);
                this.f10196o = true;
            }
            Q = i();
            j$B0 j_b02 = Q;
            if (c() != null) {
            }
            e(j_b02);
            this.f10196o = true;
        }
        if (this.f10194m >= 0) {
            if (!(c() == null)) {
                long j6 = this.f10193l + this.f10194m;
                long j7 = this.f10196o ? this.f10195n : j(j6);
                if (j7 < j6) {
                    C0320j$k2 c0320j$k22 = (C0320j$k2) c();
                    C0320j$k2 c0320j$k23 = this;
                    while (true) {
                        if (c0320j$k22 != null) {
                            if (c0320j$k23 == c0320j$k22.f10158e && (c0320j$k2 = (C0320j$k2) c0320j$k22.f10157d) != null) {
                                j7 += c0320j$k2.j(j6);
                                if (j7 >= j6) {
                                    break;
                                }
                            }
                            c0320j$k23 = c0320j$k22;
                            c0320j$k22 = (C0320j$k2) c0320j$k22.c();
                        } else if (j7 < j6) {
                            z5 = false;
                        }
                    }
                }
                if (z5) {
                    h();
                }
            }
        }
        super.onCompletion(countedCompleter);
    }
}
