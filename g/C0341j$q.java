package g;

import f.InterfaceC0261j$i;
/* renamed from: g.j$q  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0341j$q implements InterfaceC0261j$i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10244a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0284j$b2 f10245b;

    public /* synthetic */ C0341j$q(int i6, InterfaceC0284j$b2 interfaceC0284j$b2) {
        this.f10244a = i6;
        this.f10245b = interfaceC0284j$b2;
    }

    @Override // f.InterfaceC0261j$i
    public final void d(double d6) {
        int i6 = this.f10244a;
        InterfaceC0284j$b2 interfaceC0284j$b2 = this.f10245b;
        switch (i6) {
            case 0:
                interfaceC0284j$b2.d(d6);
                return;
            default:
                ((C0345j$r) interfaceC0284j$b2).f10094a.d(d6);
                return;
        }
    }
}
