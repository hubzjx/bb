package g;

import f.InterfaceC0255j$c;
import j$.util.function.BiFunction;
/* renamed from: g.j$y1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0375j$y1 extends j$L1 implements j$K1 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Object f10306b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ BiFunction f10307c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ InterfaceC0255j$c f10308d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0375j$y1(Object obj, BiFunction biFunction, InterfaceC0255j$c interfaceC0255j$c) {
        this.f10306b = obj;
        this.f10307c = biFunction;
        this.f10308d = interfaceC0255j$c;
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
        this.f10019a = this.f10306b;
    }

    @Override // f.InterfaceC0257j$e
    public final void j(Object obj) {
        this.f10019a = this.f10307c.p(this.f10019a, obj);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ boolean o() {
        return false;
    }

    @Override // g.j$K1
    public final void v(j$K1 j_k1) {
        this.f10019a = this.f10308d.p(this.f10019a, ((C0375j$y1) j_k1).f10019a);
    }
}
