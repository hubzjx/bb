package g;

import f.InterfaceC0255j$c;
/* renamed from: g.j$s1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0351j$s1 extends j$L1 implements j$K1, InterfaceC0279j$a2 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f.j$V f10269b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f.j$R f10270c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ InterfaceC0255j$c f10271d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0351j$s1(f.j$V j_v, f.j$R j_r, InterfaceC0255j$c interfaceC0255j$c) {
        this.f10269b = j_v;
        this.f10270c = j_r;
        this.f10271d = interfaceC0255j$c;
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
        this.f10270c.l(this.f10019a, j6);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void h() {
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        this.f10019a = this.f10269b.get();
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
        this.f10019a = this.f10271d.p(this.f10019a, ((C0351j$s1) j_k1).f10019a);
    }
}
