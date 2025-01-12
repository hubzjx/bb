package g;

import f.InterfaceC0272j$t;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$R implements InterfaceC0272j$t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10076a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0284j$b2 f10077b;

    public /* synthetic */ j$R(int i6, InterfaceC0284j$b2 interfaceC0284j$b2) {
        this.f10076a = i6;
        this.f10077b = interfaceC0284j$b2;
    }

    @Override // f.InterfaceC0272j$t
    public final void e(int i6) {
        int i7 = this.f10076a;
        InterfaceC0284j$b2 interfaceC0284j$b2 = this.f10077b;
        switch (i7) {
            case 0:
                interfaceC0284j$b2.e(i6);
                return;
            default:
                ((j$T) interfaceC0284j$b2).f10096a.e(i6);
                return;
        }
    }
}
