package g;

import f.InterfaceC0257j$e;
import f.InterfaceC0274j$v;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j$D0 implements j$B0 {

    /* renamed from: a  reason: collision with root package name */
    final Object[] f9975a;

    /* renamed from: b  reason: collision with root package name */
    int f9976b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$D0(long j6, InterfaceC0274j$v interfaceC0274j$v) {
        if (j6 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f9975a = (Object[]) interfaceC0274j$v.r((int) j6);
        this.f9976b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$D0(Object[] objArr) {
        this.f9975a = objArr;
        this.f9976b = objArr.length;
    }

    @Override // g.j$B0
    public final void b(InterfaceC0257j$e interfaceC0257j$e) {
        for (int i6 = 0; i6 < this.f9976b; i6++) {
            interfaceC0257j$e.j(this.f9975a[i6]);
        }
    }

    @Override // g.j$B0
    public final j$B0 c(int i6) {
        throw new IndexOutOfBoundsException();
    }

    @Override // g.j$B0
    public final long count() {
        return this.f9976b;
    }

    @Override // g.j$B0
    public final Object[] n(InterfaceC0274j$v interfaceC0274j$v) {
        Object[] objArr = this.f9975a;
        if (objArr.length == this.f9976b) {
            return objArr;
        }
        throw new IllegalStateException();
    }

    @Override // g.j$B0
    public final void p(Object[] objArr, int i6) {
        System.arraycopy(this.f9975a, 0, objArr, i6, this.f9976b);
    }

    @Override // g.j$B0
    public final /* synthetic */ j$B0 r(long j6, long j7, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.E(this, j6, j7, interfaceC0274j$v);
    }

    @Override // g.j$B0
    public final e.j$J spliterator() {
        return e.j$X.m(this.f9975a, 0, this.f9976b);
    }

    @Override // g.j$B0
    public final /* synthetic */ int t() {
        return 0;
    }

    public String toString() {
        Object[] objArr = this.f9975a;
        return String.format("ArrayNode[%d][%s]", Integer.valueOf(objArr.length - this.f9976b), Arrays.toString(objArr));
    }
}
