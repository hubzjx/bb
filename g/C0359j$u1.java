package g;

import f.InterfaceC0259j$g;
/* renamed from: g.j$u1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0359j$u1 implements j$K1, j$Y1 {

    /* renamed from: a  reason: collision with root package name */
    private double f10283a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ double f10284b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ InterfaceC0259j$g f10285c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0359j$u1(double d6, InterfaceC0259j$g interfaceC0259j$g) {
        this.f10284b = d6;
        this.f10285c = interfaceC0259j$g;
    }

    @Override // g.InterfaceC0284j$b2
    public final void d(double d6) {
        this.f10283a = this.f10285c.k(this.f10283a, d6);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void e(int i6) {
        AbstractC0350j$s0.s();
        throw null;
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void f(long j6) {
        AbstractC0350j$s0.t();
        throw null;
    }

    @Override // f.j$V
    public final Object get() {
        return Double.valueOf(this.f10283a);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void h() {
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        this.f10283a = this.f10284b;
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        s((Double) obj);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ boolean o() {
        return false;
    }

    @Override // g.j$Y1
    public final /* synthetic */ void s(Double d6) {
        AbstractC0350j$s0.m(this, d6);
    }

    @Override // g.j$K1
    public final void v(j$K1 j_k1) {
        d(((C0359j$u1) j_k1).f10283a);
    }
}
