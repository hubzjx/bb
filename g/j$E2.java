package g;

import e.AbstractC0227j$a;
import f.InterfaceC0257j$e;
import f.InterfaceC0272j$t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$E2 extends j$I2 implements e.j$D {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ j$F2 f9983g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j$E2(j$F2 j_f2, int i6, int i7, int i8, int i9) {
        super(j_f2, i6, i7, i8, i9);
        this.f9983g = j_f2;
    }

    @Override // g.j$I2
    final void a(int i6, Object obj, Object obj2) {
        ((InterfaceC0272j$t) obj2).e(((int[]) obj)[i6]);
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.e(this, interfaceC0257j$e);
    }

    @Override // g.j$I2
    final e.j$H d(Object obj, int i6, int i7) {
        return e.j$X.k((int[]) obj, i6, i7 + i6);
    }

    @Override // g.j$I2
    final e.j$H e(int i6, int i7, int i8, int i9) {
        return new j$E2(this.f9983g, i6, i7, i8, i9);
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.q(this, interfaceC0257j$e);
    }
}
