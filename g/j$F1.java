package g;

import e.C0241j$o;
import f.InterfaceC0270j$r;
/* loaded from: classes2.dex */
final class j$F1 implements j$K1, j$Z1 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f9985a;

    /* renamed from: b  reason: collision with root package name */
    private int f9986b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ InterfaceC0270j$r f9987c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$F1(InterfaceC0270j$r interfaceC0270j$r) {
        this.f9987c = interfaceC0270j$r;
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void d(double d6) {
        AbstractC0350j$s0.j();
        throw null;
    }

    @Override // g.InterfaceC0284j$b2
    public final void e(int i6) {
        if (this.f9985a) {
            this.f9985a = false;
        } else {
            i6 = this.f9987c.g(this.f9986b, i6);
        }
        this.f9986b = i6;
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void f(long j6) {
        AbstractC0350j$s0.t();
        throw null;
    }

    @Override // f.j$V
    public final Object get() {
        return this.f9985a ? C0241j$o.a() : C0241j$o.d(this.f9986b);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void h() {
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        this.f9985a = true;
        this.f9986b = 0;
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
        j$F1 j_f1 = (j$F1) j_k1;
        if (j_f1.f9985a) {
            return;
        }
        e(j_f1.f9986b);
    }
}
