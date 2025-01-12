package g;

import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$g1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0303j$g1 extends C0299j$f1 implements InterfaceC0362j$v0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0303j$g1(long j6) {
        super(j6);
    }

    @Override // g.InterfaceC0362j$v0, g.InterfaceC0366j$w0
    public final /* bridge */ /* synthetic */ j$B0 a() {
        a();
        return this;
    }

    @Override // g.InterfaceC0362j$v0, g.InterfaceC0366j$w0
    public final InterfaceC0378j$z0 a() {
        int i6 = this.f10161b;
        long[] jArr = this.f10160a;
        if (i6 >= jArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.f10161b), Integer.valueOf(jArr.length)));
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
    public final void f(long j6) {
        int i6 = this.f10161b;
        long[] jArr = this.f10160a;
        if (i6 >= jArr.length) {
            throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(jArr.length)));
        }
        this.f10161b = i6 + 1;
        jArr[i6] = j6;
    }

    @Override // g.InterfaceC0284j$b2
    public final void h() {
        int i6 = this.f10161b;
        long[] jArr = this.f10160a;
        if (i6 < jArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.f10161b), Integer.valueOf(jArr.length)));
        }
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        long[] jArr = this.f10160a;
        if (j6 != jArr.length) {
            throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j6), Integer.valueOf(jArr.length)));
        }
        this.f10161b = 0;
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        q((Long) obj);
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ boolean o() {
        return false;
    }

    @Override // g.InterfaceC0279j$a2
    public final /* synthetic */ void q(Long l6) {
        AbstractC0350j$s0.q(this, l6);
    }

    @Override // g.C0299j$f1
    public final String toString() {
        long[] jArr = this.f10160a;
        return String.format("LongFixedNodeBuilder[%d][%s]", Integer.valueOf(jArr.length - this.f10161b), Arrays.toString(jArr));
    }
}
