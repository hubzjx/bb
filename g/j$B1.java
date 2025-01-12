package g;

import f.InterfaceC0255j$c;
import j$.util.function.BiConsumer;
/* loaded from: classes2.dex */
final class j$B1 extends j$L1 implements j$K1 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f.j$V f9955b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ BiConsumer f9956c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ InterfaceC0255j$c f9957d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$B1(f.j$V j_v, BiConsumer biConsumer, InterfaceC0255j$c interfaceC0255j$c) {
        this.f9955b = j_v;
        this.f9956c = biConsumer;
        this.f9957d = interfaceC0255j$c;
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
    public final /* synthetic */ void f(long j6) {
        AbstractC0350j$s0.t();
        throw null;
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void h() {
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        this.f10019a = this.f9955b.get();
    }

    @Override // f.InterfaceC0257j$e
    public final void j(Object obj) {
        this.f9956c.n(this.f10019a, obj);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ boolean o() {
        return false;
    }

    @Override // g.j$K1
    public final void v(j$K1 j_k1) {
        this.f10019a = this.f9957d.p(this.f10019a, ((j$B1) j_k1).f10019a);
    }
}
