package g;

import e.AbstractC0227j$a;
import f.InterfaceC0257j$e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$G2 extends j$I2 implements e.j$F {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ j$H2 f9992g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j$G2(j$H2 j_h2, int i6, int i7, int i8, int i9) {
        super(j_h2, i6, i7, i8, i9);
        this.f9992g = j_h2;
    }

    @Override // g.j$I2
    final void a(int i6, Object obj, Object obj2) {
        ((f.j$E) obj2).f(((long[]) obj)[i6]);
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.f(this, interfaceC0257j$e);
    }

    @Override // g.j$I2
    final e.j$H d(Object obj, int i6, int i7) {
        return e.j$X.l((long[]) obj, i6, i7 + i6);
    }

    @Override // g.j$I2
    final e.j$H e(int i6, int i7, int i8, int i9) {
        return new j$G2(this.f9992g, i6, i7, i8, i9);
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.s(this, interfaceC0257j$e);
    }
}
