package g;

import e.AbstractC0227j$a;
import f.InterfaceC0257j$e;
/* loaded from: classes2.dex */
final class j$q3 extends j$r3 implements e.j$F, f.j$E {

    /* renamed from: e  reason: collision with root package name */
    long f10251e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$q3(e.j$F j_f, long j6, long j7) {
        super(j_f, j6, j7);
    }

    j$q3(e.j$F j_f, j$q3 j_q3) {
        super(j_f, j_q3);
    }

    @Override // e.j$J
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0227j$a.f(this, interfaceC0257j$e);
    }

    @Override // f.j$E
    public final void f(long j6) {
        this.f10251e = j6;
    }

    @Override // e.j$J
    public final /* synthetic */ boolean r(InterfaceC0257j$e interfaceC0257j$e) {
        return AbstractC0227j$a.s(this, interfaceC0257j$e);
    }

    @Override // g.j$t3
    protected final e.j$J u(e.j$J j_j) {
        return new j$q3((e.j$F) j_j, this);
    }

    @Override // g.j$r3
    protected final void x(Object obj) {
        ((f.j$E) obj).f(this.f10251e);
    }

    @Override // g.j$r3
    protected final j$V2 y() {
        return new j$U2();
    }
}
