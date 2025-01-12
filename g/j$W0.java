package g;

import f.InterfaceC0257j$e;
import f.InterfaceC0272j$t;
import f.InterfaceC0274j$v;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j$W0 implements InterfaceC0374j$y0 {

    /* renamed from: a  reason: collision with root package name */
    final int[] f10098a;

    /* renamed from: b  reason: collision with root package name */
    int f10099b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$W0(long j6) {
        if (j6 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f10098a = new int[(int) j6];
        this.f10099b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$W0(int[] iArr) {
        this.f10098a = iArr;
        this.f10099b = iArr.length;
    }

    @Override // g.j$B0
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0350j$s0.z(this, interfaceC0257j$e);
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
        return this.f10099b;
    }

    @Override // g.j$A0
    public final Object k() {
        int[] iArr = this.f10098a;
        int length = iArr.length;
        int i6 = this.f10099b;
        return length == i6 ? iArr : Arrays.copyOf(iArr, i6);
    }

    @Override // g.j$A0
    public final void l(Object obj) {
        InterfaceC0272j$t interfaceC0272j$t = (InterfaceC0272j$t) obj;
        for (int i6 = 0; i6 < this.f10099b; i6++) {
            interfaceC0272j$t.e(this.f10098a[i6]);
        }
    }

    @Override // g.j$B0
    public final /* synthetic */ Object[] n(InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.u(this, interfaceC0274j$v);
    }

    @Override // g.j$B0
    public final /* synthetic */ j$B0 r(long j6, long j7, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.C(this, j6, j7);
    }

    @Override // g.j$A0, g.j$B0
    public final e.j$H spliterator() {
        return e.j$X.k(this.f10098a, 0, this.f10099b);
    }

    @Override // g.j$A0, g.j$B0
    public final e.j$J spliterator() {
        return e.j$X.k(this.f10098a, 0, this.f10099b);
    }

    @Override // g.j$B0
    public final /* synthetic */ int t() {
        return 0;
    }

    public String toString() {
        int[] iArr = this.f10098a;
        return String.format("IntArrayNode[%d][%s]", Integer.valueOf(iArr.length - this.f10099b), Arrays.toString(iArr));
    }

    @Override // g.j$A0
    public final void u(int i6, Object obj) {
        int i7 = this.f10099b;
        System.arraycopy(this.f10098a, 0, (int[]) obj, i6, i7);
    }

    @Override // g.j$B0
    /* renamed from: w */
    public final /* synthetic */ void p(Integer[] numArr, int i6) {
        AbstractC0350j$s0.w(this, numArr, i6);
    }
}
