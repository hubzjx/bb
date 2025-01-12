package g;

import f.InterfaceC0257j$e;
import f.InterfaceC0274j$v;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$n1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0331j$n1 extends j$K2 implements j$B0, InterfaceC0366j$w0 {
    @Override // g.InterfaceC0366j$w0
    public final j$B0 a() {
        return this;
    }

    @Override // g.j$K2, g.j$B0
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        super.b(interfaceC0257j$e);
    }

    @Override // g.j$B0
    public final j$B0 c(int i6) {
        throw new IndexOutOfBoundsException();
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void d(double d6) {
        AbstractC0350j$s0.j();
        throw null;
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
        w(j6);
    }

    @Override // g.j$K2, f.InterfaceC0257j$e
    public final void j(Object obj) {
        super.j(obj);
    }

    @Override // g.j$B0
    public final Object[] n(InterfaceC0274j$v interfaceC0274j$v) {
        long count = count();
        if (count < 2147483639) {
            Object[] objArr = (Object[]) interfaceC0274j$v.r((int) count);
            p(objArr, 0);
            return objArr;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ boolean o() {
        return false;
    }

    @Override // g.j$B0
    public final void p(Object[] objArr, int i6) {
        long j6 = i6;
        long count = count() + j6;
        if (count > objArr.length || count < j6) {
            throw new IndexOutOfBoundsException("does not fit");
        }
        if (this.f10143c == 0) {
            System.arraycopy(this.f10016e, 0, objArr, i6, this.f10142b);
            return;
        }
        for (int i7 = 0; i7 < this.f10143c; i7++) {
            Object[] objArr2 = this.f10017f[i7];
            System.arraycopy(objArr2, 0, objArr, i6, objArr2.length);
            i6 += this.f10017f[i7].length;
        }
        int i8 = this.f10142b;
        if (i8 > 0) {
            System.arraycopy(this.f10016e, 0, objArr, i6, i8);
        }
    }

    @Override // g.j$B0
    public final /* synthetic */ j$B0 r(long j6, long j7, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.E(this, j6, j7, interfaceC0274j$v);
    }

    @Override // g.j$K2, java.lang.Iterable
    public final e.j$J spliterator() {
        return super.spliterator();
    }

    @Override // g.j$B0
    public final /* synthetic */ int t() {
        return 0;
    }
}
