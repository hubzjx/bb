package g;

import f.InterfaceC0255j$c;
/* renamed from: g.j$x1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0371j$x1 extends j$L1 implements j$K1, j$Y1 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f.j$V f10301b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f.j$N f10302c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ InterfaceC0255j$c f10303d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0371j$x1(f.j$V j_v, f.j$N j_n, InterfaceC0255j$c interfaceC0255j$c) {
        this.f10301b = j_v;
        this.f10302c = j_n;
        this.f10303d = interfaceC0255j$c;
    }

    @Override // g.InterfaceC0284j$b2
    public final void d(double d6) {
        this.f10302c.b(this.f10019a, d6);
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

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void h() {
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        this.f10019a = this.f10301b.get();
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
        this.f10019a = this.f10303d.p(this.f10019a, ((C0371j$x1) j_k1).f10019a);
    }
}
