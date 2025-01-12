package g;

import f.InterfaceC0257j$e;
import f.InterfaceC0261j$i;
import f.InterfaceC0274j$v;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j$N0 implements InterfaceC0370j$x0 {

    /* renamed from: a  reason: collision with root package name */
    final double[] f10024a;

    /* renamed from: b  reason: collision with root package name */
    int f10025b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$N0(long j6) {
        if (j6 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f10024a = new double[(int) j6];
        this.f10025b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$N0(double[] dArr) {
        this.f10024a = dArr;
        this.f10025b = dArr.length;
    }

    @Override // g.j$B0
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0350j$s0.y(this, interfaceC0257j$e);
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

    @Override // g.j$B0
    public final long count() {
        return this.f10025b;
    }

    @Override // g.j$A0
    public final Object k() {
        double[] dArr = this.f10024a;
        int length = dArr.length;
        int i6 = this.f10025b;
        return length == i6 ? dArr : Arrays.copyOf(dArr, i6);
    }

    @Override // g.j$A0
    public final void l(Object obj) {
        InterfaceC0261j$i interfaceC0261j$i = (InterfaceC0261j$i) obj;
        for (int i6 = 0; i6 < this.f10025b; i6++) {
            interfaceC0261j$i.d(this.f10024a[i6]);
        }
    }

    @Override // g.j$B0
    public final /* synthetic */ Object[] n(InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.u(this, interfaceC0274j$v);
    }

    @Override // g.j$B0
    public final /* synthetic */ j$B0 r(long j6, long j7, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.B(this, j6, j7);
    }

    @Override // g.j$A0, g.j$B0
    public final e.j$H spliterator() {
        return e.j$X.j(this.f10024a, 0, this.f10025b);
    }

    @Override // g.j$A0, g.j$B0
    public final e.j$J spliterator() {
        return e.j$X.j(this.f10024a, 0, this.f10025b);
    }

    @Override // g.j$B0
    public final /* synthetic */ int t() {
        return 0;
    }

    public String toString() {
        double[] dArr = this.f10024a;
        return String.format("DoubleArrayNode[%d][%s]", Integer.valueOf(dArr.length - this.f10025b), Arrays.toString(dArr));
    }

    @Override // g.j$A0
    public final void u(int i6, Object obj) {
        int i7 = this.f10025b;
        System.arraycopy(this.f10024a, 0, (double[]) obj, i6, i7);
    }

    @Override // g.j$B0
    /* renamed from: w */
    public final /* synthetic */ void p(Double[] dArr, int i6) {
        AbstractC0350j$s0.v(this, dArr, i6);
    }
}
