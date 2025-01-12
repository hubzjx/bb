package g;

import e.AbstractC0227j$a;
import f.InterfaceC0257j$e;
import f.InterfaceC0272j$t;
/* loaded from: classes2.dex */
final class j$c3 extends j$R2 implements e.j$D {
    j$c3(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, boolean z5) {
        super(abstractC0350j$s0, j_j, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$c3(AbstractC0350j$s0 abstractC0350j$s0, C0276j$a c0276j$a, boolean z5) {
        super(abstractC0350j$s0, c0276j$a, z5);
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.e(this, interfaceC0257j$e);
    }

    @Override // g.j$R2
    final void f() {
        j$F2 j_f2 = new j$F2();
        this.f10085h = j_f2;
        this.f10082e = this.f10079b.t0(new j$b3(j_f2, 0));
        this.f10083f = new C0276j$a(5, this);
    }

    @Override // e.j$H
    /* renamed from: g */
    public final boolean tryAdvance(InterfaceC0272j$t interfaceC0272j$t) {
        interfaceC0272j$t.getClass();
        boolean a6 = a();
        if (a6) {
            j$F2 j_f2 = (j$F2) this.f10085h;
            long j6 = this.f10084g;
            int y5 = j_f2.y(j6);
            interfaceC0272j$t.e((j_f2.f10143c == 0 && y5 == 0) ? ((int[]) j_f2.f10013e)[(int) j6] : ((int[][]) j_f2.f10014f)[y5][(int) (j6 - j_f2.f10144d[y5])]);
        }
        return a6;
    }

    @Override // g.j$R2
    final j$R2 h(e.j$J j_j) {
        return new j$c3(this.f10079b, j_j, this.f10078a);
    }

    @Override // e.j$H
    /* renamed from: l */
    public final void forEachRemaining(InterfaceC0272j$t interfaceC0272j$t) {
        if (this.f10085h != null || this.f10086i) {
            do {
            } while (tryAdvance(interfaceC0272j$t));
            return;
        }
        interfaceC0272j$t.getClass();
        e();
        j$b3 j_b3 = new j$b3(interfaceC0272j$t, 1);
        this.f10079b.s0(this.f10081d, j_b3);
        this.f10086i = true;
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.q(this, interfaceC0257j$e);
    }

    @Override // g.j$R2, e.j$J
    public final e.j$D trySplit() {
        return (e.j$D) super.trySplit();
    }
}
