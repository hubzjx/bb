package g;

import e.AbstractC0227j$a;
import f.InterfaceC0257j$e;
import f.InterfaceC0261j$i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$C2 extends j$I2 implements e.j$B {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ j$D2 f9970g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j$C2(j$D2 j_d2, int i6, int i7, int i8, int i9) {
        super(j_d2, i6, i7, i8, i9);
        this.f9970g = j_d2;
    }

    @Override // g.j$I2
    final void a(int i6, Object obj, Object obj2) {
        ((InterfaceC0261j$i) obj2).d(((double[]) obj)[i6]);
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.d(this, interfaceC0257j$e);
    }

    @Override // g.j$I2
    final e.j$H d(Object obj, int i6, int i7) {
        return e.j$X.j((double[]) obj, i6, i7 + i6);
    }

    @Override // g.j$I2
    final e.j$H e(int i6, int i7, int i8, int i9) {
        return new j$C2(this.f9970g, i6, i7, i8, i9);
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.o(this, interfaceC0257j$e);
    }
}
