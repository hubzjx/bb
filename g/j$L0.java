package g;

import f.InterfaceC0274j$v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class j$L0 extends j$C0 implements j$A0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j$L0(j$A0 j_a0, j$A0 j_a02) {
        super(j_a0, j_a02);
    }

    @Override // g.j$A0
    public final Object k() {
        long count = count();
        if (count < 2147483639) {
            Object g6 = g((int) count);
            u(0, g6);
            return g6;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // g.j$A0
    public final void l(Object obj) {
        ((j$A0) this.f9964a).l(obj);
        ((j$A0) this.f9965b).l(obj);
    }

    @Override // g.j$B0
    public final /* synthetic */ Object[] n(InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.u(this, interfaceC0274j$v);
    }

    public final String toString() {
        return count() < 32 ? String.format("%s[%s.%s]", getClass().getName(), this.f9964a, this.f9965b) : String.format("%s[size=%d]", getClass().getName(), Long.valueOf(count()));
    }

    @Override // g.j$A0
    public final void u(int i6, Object obj) {
        j$B0 j_b0 = this.f9964a;
        ((j$A0) j_b0).u(i6, obj);
        ((j$A0) this.f9965b).u(i6 + ((int) ((j$A0) j_b0).count()), obj);
    }
}
