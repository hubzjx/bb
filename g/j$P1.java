package g;

import j$.util.function.Function;
/* loaded from: classes2.dex */
final class j$P1 extends j$S1 {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f10044t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ Function f10045u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j$P1(j$T1 j_t1, int i6, Function function, int i7) {
        super(j_t1, i6);
        this.f10044t = i7;
        this.f10045u = function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0285j$c
    public final InterfaceC0284j$b2 H0(int i6, InterfaceC0284j$b2 interfaceC0284j$b2) {
        switch (this.f10044t) {
            case 0:
                return new j$N1(this, interfaceC0284j$b2, 2);
            default:
                return new j$N1(this, interfaceC0284j$b2, 6);
        }
    }
}
