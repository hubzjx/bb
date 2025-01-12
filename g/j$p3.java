package g;

import e.AbstractC0227j$a;
import f.InterfaceC0257j$e;
import f.InterfaceC0272j$t;
/* loaded from: classes2.dex */
final class j$p3 extends j$r3 implements e.j$D, InterfaceC0272j$t {

    /* renamed from: e  reason: collision with root package name */
    int f10243e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$p3(e.j$D j_d, long j6, long j7) {
        super(j_d, j6, j7);
    }

    j$p3(e.j$D j_d, j$p3 j_p3) {
        super(j_d, j_p3);
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.e(this, interfaceC0257j$e);
    }

    @Override // f.InterfaceC0272j$t
    public final void e(int i6) {
        this.f10243e = i6;
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.q(this, interfaceC0257j$e);
    }

    @Override // g.j$t3
    protected final e.j$J u(e.j$J j_j) {
        return new j$p3((e.j$D) j_j, this);
    }

    @Override // g.j$r3
    protected final void x(Object obj) {
        ((InterfaceC0272j$t) obj).e(this.f10243e);
    }

    @Override // g.j$r3
    protected final j$V2 y() {
        return new j$T2();
    }
}
