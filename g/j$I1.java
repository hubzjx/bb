package g;
/* loaded from: classes2.dex */
final class j$I1 implements j$K1, InterfaceC0279j$a2 {

    /* renamed from: a  reason: collision with root package name */
    private long f10000a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f10001b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f.j$C f10002c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$I1(long j6, f.j$C j_c) {
        this.f10001b = j6;
        this.f10002c = j_c;
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
        this.f10000a = this.f10002c.k(this.f10000a, j6);
    }

    @Override // f.j$V
    public final Object get() {
        return Long.valueOf(this.f10000a);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void h() {
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        this.f10000a = this.f10001b;
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
        f(((j$I1) j_k1).f10000a);
    }
}
