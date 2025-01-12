package g;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$w  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0365j$w extends AbstractC0377j$z {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f10294t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0365j$w(AbstractC0285j$c abstractC0285j$c, int i6, int i7) {
        super(abstractC0285j$c, i6);
        this.f10294t = i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0285j$c
    public final InterfaceC0284j$b2 H0(int i6, InterfaceC0284j$b2 interfaceC0284j$b2) {
        switch (this.f10294t) {
            case 0:
                return interfaceC0284j$b2;
            case 1:
                return new j$T(this, interfaceC0284j$b2, 2);
            default:
                return new C0290j$d0(this, interfaceC0284j$b2, 0);
        }
    }
}
