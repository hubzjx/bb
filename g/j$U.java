package g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$U extends AbstractC0302j$g0 {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f10093t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j$U(AbstractC0285j$c abstractC0285j$c, int i6, int i7) {
        super(abstractC0285j$c, i6);
        this.f10093t = i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0285j$c
    public final InterfaceC0284j$b2 H0(int i6, InterfaceC0284j$b2 interfaceC0284j$b2) {
        switch (this.f10093t) {
            case 0:
                return new j$T(this, interfaceC0284j$b2, 0);
            default:
                return interfaceC0284j$b2;
        }
    }
}
