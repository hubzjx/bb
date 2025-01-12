package g;

import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$O0 extends j$N0 implements InterfaceC0354j$t0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j$O0(long j6) {
        super(j6);
    }

    @Override // g.InterfaceC0354j$t0, g.InterfaceC0366j$w0
    public final /* bridge */ /* synthetic */ j$B0 a() {
        a();
        return this;
    }

    @Override // g.InterfaceC0354j$t0, g.InterfaceC0366j$w0
    public final InterfaceC0370j$x0 a() {
        int i6 = this.f10025b;
        double[] dArr = this.f10024a;
        if (i6 >= dArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.f10025b), Integer.valueOf(dArr.length)));
    }

    @Override // g.InterfaceC0284j$b2
    public final void d(double d6) {
        int i6 = this.f10025b;
        double[] dArr = this.f10024a;
        if (i6 >= dArr.length) {
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(dArr.length)));
        }
        this.f10025b = i6 + 1;
        dArr[i6] = d6;
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
        int i6 = this.f10025b;
        double[] dArr = this.f10024a;
        if (i6 < dArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.f10025b), Integer.valueOf(dArr.length)));
        }
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        double[] dArr = this.f10024a;
        if (j6 != dArr.length) {
            throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j6), Integer.valueOf(dArr.length)));
        }
        this.f10025b = 0;
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        s((Double) obj);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ boolean o() {
        return false;
    }

    @Override // g.j$Y1
    public final /* synthetic */ void s(Double d6) {
        AbstractC0350j$s0.m(this, d6);
    }

    @Override // g.j$N0
    public final String toString() {
        double[] dArr = this.f10024a;
        return String.format("DoubleFixedNodeBuilder[%d][%s]", Integer.valueOf(dArr.length - this.f10025b), Arrays.toString(dArr));
    }
}
