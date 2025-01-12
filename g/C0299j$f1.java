package g;

import f.InterfaceC0257j$e;
import f.InterfaceC0274j$v;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$f1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0299j$f1 implements InterfaceC0378j$z0 {

    /* renamed from: a  reason: collision with root package name */
    final long[] f10160a;

    /* renamed from: b  reason: collision with root package name */
    int f10161b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0299j$f1(long j6) {
        if (j6 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f10160a = new long[(int) j6];
        this.f10161b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0299j$f1(long[] jArr) {
        this.f10160a = jArr;
        this.f10161b = jArr.length;
    }

    @Override // g.j$B0
    public final /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        AbstractC0350j$s0.A(this, interfaceC0257j$e);
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
        return this.f10161b;
    }

    @Override // g.j$A0
    public final Object k() {
        long[] jArr = this.f10160a;
        int length = jArr.length;
        int i6 = this.f10161b;
        return length == i6 ? jArr : Arrays.copyOf(jArr, i6);
    }

    @Override // g.j$A0
    public final void l(Object obj) {
        f.j$E j_e = (f.j$E) obj;
        for (int i6 = 0; i6 < this.f10161b; i6++) {
            j_e.f(this.f10160a[i6]);
        }
    }

    @Override // g.j$B0
    public final /* synthetic */ Object[] n(InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.u(this, interfaceC0274j$v);
    }

    @Override // g.j$B0
    public final /* synthetic */ j$B0 r(long j6, long j7, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.D(this, j6, j7);
    }

    @Override // g.j$A0, g.j$B0
    public final e.j$H spliterator() {
        return e.j$X.l(this.f10160a, 0, this.f10161b);
    }

    @Override // g.j$A0, g.j$B0
    public final e.j$J spliterator() {
        return e.j$X.l(this.f10160a, 0, this.f10161b);
    }

    @Override // g.j$B0
    public final /* synthetic */ int t() {
        return 0;
    }

    public String toString() {
        long[] jArr = this.f10160a;
        return String.format("LongArrayNode[%d][%s]", Integer.valueOf(jArr.length - this.f10161b), Arrays.toString(jArr));
    }

    @Override // g.j$A0
    public final void u(int i6, Object obj) {
        int i7 = this.f10161b;
        System.arraycopy(this.f10160a, 0, (long[]) obj, i6, i7);
    }

    @Override // g.j$B0
    /* renamed from: w */
    public final /* synthetic */ void p(Long[] lArr, int i6) {
        AbstractC0350j$s0.x(this, lArr, i6);
    }
}
