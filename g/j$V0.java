package g;

import f.InterfaceC0274j$v;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$V0 extends j$D0 implements InterfaceC0366j$w0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j$V0(long j6, InterfaceC0274j$v interfaceC0274j$v) {
        super(j6, interfaceC0274j$v);
    }

    @Override // g.InterfaceC0366j$w0
    public final j$B0 a() {
        int i6 = this.f9976b;
        Object[] objArr = this.f9975a;
        if (i6 >= objArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.f9976b), Integer.valueOf(objArr.length)));
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
        int i6 = this.f9976b;
        Object[] objArr = this.f9975a;
        if (i6 < objArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.f9976b), Integer.valueOf(objArr.length)));
        }
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        Object[] objArr = this.f9975a;
        if (j6 != objArr.length) {
            throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j6), Integer.valueOf(objArr.length)));
        }
        this.f9976b = 0;
    }

    @Override // f.InterfaceC0257j$e
    public final void j(Object obj) {
        int i6 = this.f9976b;
        Object[] objArr = this.f9975a;
        if (i6 >= objArr.length) {
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(objArr.length)));
        }
        this.f9976b = i6 + 1;
        objArr[i6] = obj;
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ boolean o() {
        return false;
    }

    @Override // g.j$D0
    public final String toString() {
        Object[] objArr = this.f9975a;
        return String.format("FixedNodeBuilder[%d][%s]", Integer.valueOf(objArr.length - this.f9976b), Arrays.toString(objArr));
    }
}
