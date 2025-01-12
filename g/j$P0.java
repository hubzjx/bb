package g;

import f.InterfaceC0261j$i;
import f.InterfaceC0274j$v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$P0 extends j$D2 implements InterfaceC0370j$x0, InterfaceC0354j$t0 {
    @Override // g.j$D2
    public final e.j$B C() {
        return super.spliterator();
    }

    @Override // g.j$B0
    /* renamed from: D */
    public final /* synthetic */ void p(Double[] dArr, int i6) {
        AbstractC0350j$s0.v(this, dArr, i6);
    }

    @Override // g.InterfaceC0354j$t0, g.InterfaceC0366j$w0
    public final j$B0 a() {
        return this;
    }

    @Override // g.InterfaceC0354j$t0, g.InterfaceC0366j$w0
    public final InterfaceC0370j$x0 a() {
        return this;
    }

    @Override // g.j$A0, g.j$B0
    public final j$A0 c(int i6) {
        throw new IndexOutOfBoundsException();
    }

    @Override // g.j$A0, g.j$B0
    public final /* bridge */ /* synthetic */ j$B0 c(int i6) {
        c(i6);
        throw null;
    }

    @Override // g.j$D2, f.InterfaceC0261j$i
    public final void d(double d6) {
        super.d(d6);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void e(int i6) {
        AbstractC0350j$s0.s();
        throw null;
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void f(long j6) {
        AbstractC0350j$s0.t();
        throw null;
    }

    @Override // g.InterfaceC0284j$b2
    public final void h() {
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        clear();
        z(j6);
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        s((Double) obj);
    }

    @Override // g.j$J2, g.j$A0
    public final Object k() {
        return (double[]) super.k();
    }

    @Override // g.j$J2, g.j$A0
    public final void l(Object obj) {
        super.l((InterfaceC0261j$i) obj);
    }

    @Override // g.j$B0
    public final /* synthetic */ Object[] n(InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.u(this, interfaceC0274j$v);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ boolean o() {
        return false;
    }

    @Override // g.j$B0
    public final /* synthetic */ j$B0 r(long j6, long j7, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.B(this, j6, j7);
    }

    @Override // g.j$Y1
    public final /* synthetic */ void s(Double d6) {
        AbstractC0350j$s0.m(this, d6);
    }

    @Override // g.j$D2, g.j$J2, java.lang.Iterable
    public final e.j$H spliterator() {
        return super.spliterator();
    }

    @Override // g.j$D2, g.j$J2, java.lang.Iterable
    public final e.j$J spliterator() {
        return super.spliterator();
    }

    @Override // g.j$B0
    public final /* synthetic */ int t() {
        return 0;
    }

    @Override // g.j$J2, g.j$A0
    public final void u(int i6, Object obj) {
        super.u(i6, (double[]) obj);
    }
}
