package g;

import e.C0242j$p;
/* loaded from: classes2.dex */
final class j$J1 implements j$K1, InterfaceC0279j$a2 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10010a;

    /* renamed from: b  reason: collision with root package name */
    private long f10011b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f.j$C f10012c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$J1(f.j$C j_c) {
        this.f10012c = j_c;
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void d(double d6) {
        AbstractC0350j$s0.j();
        throw null;
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void e(int i6) {
        AbstractC0350j$s0.s();
        throw null;
    }

    @Override // g.InterfaceC0284j$b2
    public final void f(long j6) {
        if (this.f10010a) {
            this.f10010a = false;
        } else {
            j6 = this.f10012c.k(this.f10011b, j6);
        }
        this.f10011b = j6;
    }

    @Override // f.j$V
    public final Object get() {
        return this.f10010a ? C0242j$p.a() : C0242j$p.d(this.f10011b);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void h() {
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        this.f10010a = true;
        this.f10011b = 0L;
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        q((Long) obj);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ boolean o() {
        return false;
    }

    @Override // g.InterfaceC0279j$a2
    public final /* synthetic */ void q(Long l6) {
        AbstractC0350j$s0.q(this, l6);
    }

    @Override // g.j$K1
    public final void v(j$K1 j_k1) {
        j$J1 j_j1 = (j$J1) j_k1;
        if (j_j1.f10010a) {
            return;
        }
        f(j_j1.f10011b);
    }
}
