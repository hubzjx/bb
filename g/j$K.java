package g;

import f.InterfaceC0261j$i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$K extends j$O implements j$Y1 {

    /* renamed from: b  reason: collision with root package name */
    final InterfaceC0261j$i f10015b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$K(InterfaceC0261j$i interfaceC0261j$i, boolean z5) {
        super(z5);
        this.f10015b = interfaceC0261j$i;
    }

    @Override // g.j$O, g.InterfaceC0284j$b2
    public final void d(double d6) {
        this.f10015b.d(d6);
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        s((Double) obj);
    }

    @Override // g.j$Y1
    public final /* synthetic */ void s(Double d6) {
        AbstractC0350j$s0.m(this, d6);
    }
}
