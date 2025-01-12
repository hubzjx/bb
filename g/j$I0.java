package g;

import f.InterfaceC0257j$e;
import f.InterfaceC0274j$v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$I0 extends j$L0 implements InterfaceC0370j$x0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j$I0(InterfaceC0370j$x0 interfaceC0370j$x0, InterfaceC0370j$x0 interfaceC0370j$x02) {
        super(interfaceC0370j$x0, interfaceC0370j$x02);
    }

    @Override // g.j$B0
    /* renamed from: a */
    public final /* synthetic */ void p(Double[] dArr, int i6) {
        AbstractC0350j$s0.v(this, dArr, i6);
    }

    @Override // g.j$B0
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0350j$s0.y(this, interfaceC0257j$e);
    }

    @Override // g.j$A0
    public final Object g(int i6) {
        return new double[i6];
    }

    @Override // g.j$B0
    public final /* synthetic */ j$B0 r(long j6, long j7, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.B(this, j6, j7);
    }

    @Override // g.j$B0
    public final e.j$H spliterator() {
        return new j$Z0(this);
    }

    @Override // g.j$B0
    public final e.j$J spliterator() {
        return new j$Z0(this);
    }
}
