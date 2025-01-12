package g;

import f.InterfaceC0255j$c;
/* loaded from: classes2.dex */
final class j$G1 extends j$L1 implements j$K1, j$Z1 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f.j$V f9989b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f.j$P f9990c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ InterfaceC0255j$c f9991d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$G1(f.j$V j_v, f.j$P j_p, InterfaceC0255j$c interfaceC0255j$c) {
        this.f9989b = j_v;
        this.f9990c = j_p;
        this.f9991d = interfaceC0255j$c;
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void d(double d6) {
        AbstractC0350j$s0.j();
        throw null;
    }

    @Override // g.InterfaceC0284j$b2
    public final void e(int i6) {
        this.f9990c.p(i6, this.f10019a);
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
        this.f10019a = this.f9989b.get();
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        m((Integer) obj);
    }

    @Override // g.j$Z1
    public final /* synthetic */ void m(Integer num) {
        AbstractC0350j$s0.o(this, num);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ boolean o() {
        return false;
    }

    @Override // g.j$K1
    public final void v(j$K1 j_k1) {
        this.f10019a = this.f9991d.p(this.f10019a, ((j$G1) j_k1).f10019a);
    }
}
