package g;

import f.InterfaceC0261j$i;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$Z2 implements j$Y1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10109a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0261j$i f10110b;

    public /* synthetic */ j$Z2(InterfaceC0261j$i interfaceC0261j$i, int i6) {
        this.f10109a = i6;
        this.f10110b = interfaceC0261j$i;
    }

    @Override // g.InterfaceC0284j$b2
    public final void d(double d6) {
        int i6 = this.f10109a;
        InterfaceC0261j$i interfaceC0261j$i = this.f10110b;
        switch (i6) {
            case 0:
                ((j$D2) interfaceC0261j$i).d(d6);
                return;
            default:
                interfaceC0261j$i.d(d6);
                return;
        }
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void e(int i6) {
        switch (this.f10109a) {
            case 0:
                AbstractC0350j$s0.s();
                throw null;
            default:
                AbstractC0350j$s0.s();
                throw null;
        }
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void f(long j6) {
        switch (this.f10109a) {
            case 0:
                AbstractC0350j$s0.t();
                throw null;
            default:
                AbstractC0350j$s0.t();
                throw null;
        }
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void h() {
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void i(long j6) {
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        switch (this.f10109a) {
            case 0:
                s((Double) obj);
                return;
            default:
                s((Double) obj);
                return;
        }
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ boolean o() {
        return false;
    }

    @Override // g.j$Y1
    public final /* synthetic */ void s(Double d6) {
        switch (this.f10109a) {
            case 0:
                AbstractC0350j$s0.m(this, d6);
                return;
            default:
                AbstractC0350j$s0.m(this, d6);
                return;
        }
    }
}
