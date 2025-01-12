package g;

import f.InterfaceC0270j$r;
/* loaded from: classes2.dex */
final class j$E1 implements j$K1, j$Z1 {

    /* renamed from: a  reason: collision with root package name */
    private int f9980a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f9981b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ InterfaceC0270j$r f9982c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$E1(int i6, InterfaceC0270j$r interfaceC0270j$r) {
        this.f9981b = i6;
        this.f9982c = interfaceC0270j$r;
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void d(double d6) {
        AbstractC0350j$s0.j();
        throw null;
    }

    @Override // g.InterfaceC0284j$b2
    public final void e(int i6) {
        this.f9980a = this.f9982c.g(this.f9980a, i6);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void f(long j6) {
        AbstractC0350j$s0.t();
        throw null;
    }

    @Override // f.j$V
    public final Object get() {
        return Integer.valueOf(this.f9980a);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void h() {
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        this.f9980a = this.f9981b;
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
        e(((j$E1) j_k1).f9980a);
    }
}
