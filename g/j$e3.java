package g;

import e.AbstractC0227j$a;
import f.InterfaceC0257j$e;
/* loaded from: classes2.dex */
final class j$e3 extends j$R2 implements e.j$F {
    j$e3(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, boolean z5) {
        super(abstractC0350j$s0, j_j, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$e3(AbstractC0350j$s0 abstractC0350j$s0, C0276j$a c0276j$a, boolean z5) {
        super(abstractC0350j$s0, c0276j$a, z5);
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.f(this, interfaceC0257j$e);
    }

    @Override // e.j$H
    /* renamed from: c */
    public final void forEachRemaining(f.j$E j_e) {
        if (this.f10085h != null || this.f10086i) {
            do {
            } while (tryAdvance(j_e));
            return;
        }
        j_e.getClass();
        e();
        j$d3 j_d3 = new j$d3(j_e, 1);
        this.f10079b.s0(this.f10081d, j_d3);
        this.f10086i = true;
    }

    @Override // g.j$R2
    final void f() {
        j$H2 j_h2 = new j$H2();
        this.f10085h = j_h2;
        this.f10082e = this.f10079b.t0(new j$d3(j_h2, 0));
        this.f10083f = new C0276j$a(6, this);
    }

    @Override // g.j$R2
    final j$R2 h(e.j$J j_j) {
        return new j$e3(this.f10079b, j_j, this.f10078a);
    }

    @Override // e.j$H
    /* renamed from: p */
    public final boolean tryAdvance(f.j$E j_e) {
        j_e.getClass();
        boolean a6 = a();
        if (a6) {
            j$H2 j_h2 = (j$H2) this.f10085h;
            long j6 = this.f10084g;
            int y5 = j_h2.y(j6);
            j_e.f((j_h2.f10143c == 0 && y5 == 0) ? ((long[]) j_h2.f10013e)[(int) j6] : ((long[][]) j_h2.f10014f)[y5][(int) (j6 - j_h2.f10144d[y5])]);
        }
        return a6;
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.s(this, interfaceC0257j$e);
    }

    @Override // g.j$R2, e.j$J
    public final e.j$F trySplit() {
        return (e.j$F) super.trySplit();
    }
}
