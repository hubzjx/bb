package g;
/* renamed from: g.j$t  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0353j$t extends j$S1 {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f10273t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ Object f10274u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0353j$t(AbstractC0285j$c abstractC0285j$c, int i6, Object obj, int i7) {
        super(abstractC0285j$c, i6);
        this.f10273t = i7;
        this.f10274u = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0285j$c
    public final InterfaceC0284j$b2 H0(int i6, InterfaceC0284j$b2 interfaceC0284j$b2) {
        switch (this.f10273t) {
            case 0:
                return new C0345j$r(this, interfaceC0284j$b2, 1);
            case 1:
                return new j$T(this, interfaceC0284j$b2, 4);
            case 2:
                return new C0290j$d0(this, interfaceC0284j$b2, 2);
            case 3:
                return new j$N1(this, interfaceC0284j$b2, 0);
            default:
                return new j$N1(this, interfaceC0284j$b2, 1);
        }
    }
}
