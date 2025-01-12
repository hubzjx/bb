package g;

import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$X0 extends j$W0 implements InterfaceC0358j$u0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j$X0(long j6) {
        super(j6);
    }

    @Override // g.InterfaceC0358j$u0, g.InterfaceC0366j$w0
    public final /* bridge */ /* synthetic */ j$B0 a() {
        a();
        return this;
    }

    @Override // g.InterfaceC0358j$u0, g.InterfaceC0366j$w0
    public final InterfaceC0374j$y0 a() {
        int i6 = this.f10099b;
        int[] iArr = this.f10098a;
        if (i6 >= iArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.f10099b), Integer.valueOf(iArr.length)));
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void d(double d6) {
        AbstractC0350j$s0.j();
        throw null;
    }

    @Override // g.InterfaceC0284j$b2
    public final void e(int i6) {
        int i7 = this.f10099b;
        int[] iArr = this.f10098a;
        if (i7 >= iArr.length) {
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(iArr.length)));
        }
        this.f10099b = i7 + 1;
        iArr[i7] = i6;
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void f(long j6) {
        AbstractC0350j$s0.t();
        throw null;
    }

    @Override // g.InterfaceC0284j$b2
    public final void h() {
        int i6 = this.f10099b;
        int[] iArr = this.f10098a;
        if (i6 < iArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.f10099b), Integer.valueOf(iArr.length)));
        }
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        int[] iArr = this.f10098a;
        if (j6 != iArr.length) {
            throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j6), Integer.valueOf(iArr.length)));
        }
        this.f10099b = 0;
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        m((Integer) obj);
    }

    @Override // g.j$Z1
    public final /* synthetic */ void m(Integer num) {
        AbstractC0350j$s0.o(this, num);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ boolean o() {
        return false;
    }

    @Override // g.j$W0
    public final String toString() {
        int[] iArr = this.f10098a;
        return String.format("IntFixedNodeBuilder[%d][%s]", Integer.valueOf(iArr.length - this.f10099b), Arrays.toString(iArr));
    }
}
