package g;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$v  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0361j$v extends AbstractC0302j$g0 {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f10288t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ Object f10289u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0361j$v(AbstractC0285j$c abstractC0285j$c, int i6, Object obj, int i7) {
        super(abstractC0285j$c, i6);
        this.f10288t = i7;
        this.f10289u = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0285j$c
    public final InterfaceC0284j$b2 H0(int i6, InterfaceC0284j$b2 interfaceC0284j$b2) {
        switch (this.f10288t) {
            case 0:
                return new C0345j$r(this, interfaceC0284j$b2, 3);
            case 1:
                return new j$T(this, interfaceC0284j$b2, 5);
            case 2:
                return new C0290j$d0(this, interfaceC0284j$b2, 1);
            case 3:
                return new C0290j$d0(this, interfaceC0284j$b2, 5);
            case 4:
                return new C0290j$d0(this, interfaceC0284j$b2, 6);
            case 5:
                return new C0290j$d0(this, interfaceC0284j$b2, 7);
            case 6:
                return new C0329j$n(this, interfaceC0284j$b2);
            default:
                return new j$N1(this, interfaceC0284j$b2, 4);
        }
    }
}
