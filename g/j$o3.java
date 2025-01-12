package g;

import e.AbstractC0227j$a;
import f.InterfaceC0257j$e;
import f.InterfaceC0261j$i;
/* loaded from: classes2.dex */
final class j$o3 extends j$r3 implements e.j$B, InterfaceC0261j$i {

    /* renamed from: e  reason: collision with root package name */
    double f10231e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$o3(e.j$B j_b, long j6, long j7) {
        super(j_b, j6, j7);
    }

    j$o3(e.j$B j_b, j$o3 j_o3) {
        super(j_b, j_o3);
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.d(this, interfaceC0257j$e);
    }

    @Override // f.InterfaceC0261j$i
    public final void d(double d6) {
        this.f10231e = d6;
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.o(this, interfaceC0257j$e);
    }

    @Override // g.j$t3
    protected final e.j$J u(e.j$J j_j) {
        return new j$o3((e.j$B) j_j, this);
    }

    @Override // g.j$r3
    protected final void x(Object obj) {
        ((InterfaceC0261j$i) obj).d(this.f10231e);
    }

    @Override // g.j$r3
    protected final j$V2 y() {
        return new j$S2();
    }
}
