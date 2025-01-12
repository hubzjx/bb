package g;

import e.AbstractC0227j$a;
import f.InterfaceC0257j$e;
import f.InterfaceC0261j$i;
/* renamed from: g.j$a3  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0280j$a3 extends j$R2 implements e.j$B {
    C0280j$a3(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, boolean z5) {
        super(abstractC0350j$s0, j_j, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0280j$a3(AbstractC0350j$s0 abstractC0350j$s0, C0276j$a c0276j$a, boolean z5) {
        super(abstractC0350j$s0, c0276j$a, z5);
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.d(this, interfaceC0257j$e);
    }

    @Override // g.j$R2
    final void f() {
        j$D2 j_d2 = new j$D2();
        this.f10085h = j_d2;
        this.f10082e = this.f10079b.t0(new j$Z2(j_d2, 0));
        this.f10083f = new C0276j$a(4, this);
    }

    @Override // g.j$R2
    final j$R2 h(e.j$J j_j) {
        return new C0280j$a3(this.f10079b, j_j, this.f10078a);
    }

    @Override // e.j$H
    /* renamed from: k */
    public final void forEachRemaining(InterfaceC0261j$i interfaceC0261j$i) {
        if (this.f10085h != null || this.f10086i) {
            do {
            } while (tryAdvance(interfaceC0261j$i));
            return;
        }
        interfaceC0261j$i.getClass();
        e();
        j$Z2 j_z2 = new j$Z2(interfaceC0261j$i, 1);
        this.f10079b.s0(this.f10081d, j_z2);
        this.f10086i = true;
    }

    @Override // e.j$H
    /* renamed from: n */
    public final boolean tryAdvance(InterfaceC0261j$i interfaceC0261j$i) {
        interfaceC0261j$i.getClass();
        boolean a6 = a();
        if (a6) {
            j$D2 j_d2 = (j$D2) this.f10085h;
            long j6 = this.f10084g;
            int y5 = j_d2.y(j6);
            interfaceC0261j$i.d((j_d2.f10143c == 0 && y5 == 0) ? ((double[]) j_d2.f10013e)[(int) j6] : ((double[][]) j_d2.f10014f)[y5][(int) (j6 - j_d2.f10144d[y5])]);
        }
        return a6;
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.o(this, interfaceC0257j$e);
    }

    @Override // g.j$R2, e.j$J
    public final e.j$B trySplit() {
        return (e.j$B) super.trySplit();
    }
}
