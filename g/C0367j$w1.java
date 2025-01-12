package g;

import e.C0240j$n;
import f.InterfaceC0259j$g;
/* renamed from: g.j$w1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0367j$w1 implements j$K1, j$Y1 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10295a;

    /* renamed from: b  reason: collision with root package name */
    private double f10296b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ InterfaceC0259j$g f10297c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0367j$w1(InterfaceC0259j$g interfaceC0259j$g) {
        this.f10297c = interfaceC0259j$g;
    }

    @Override // g.InterfaceC0284j$b2
    public final void d(double d6) {
        if (this.f10295a) {
            this.f10295a = false;
        } else {
            d6 = this.f10297c.k(this.f10296b, d6);
        }
        this.f10296b = d6;
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
        return this.f10295a ? C0240j$n.a() : C0240j$n.d(this.f10296b);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void h() {
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        this.f10295a = true;
        this.f10296b = 0.0d;
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
        C0367j$w1 c0367j$w1 = (C0367j$w1) j_k1;
        if (c0367j$w1.f10295a) {
            return;
        }
        d(c0367j$w1.f10296b);
    }
}
