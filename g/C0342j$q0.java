package g;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$q0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0342j$q0 implements j$x3 {

    /* renamed from: a  reason: collision with root package name */
    final EnumC0338j$p0 f10246a;

    /* renamed from: b  reason: collision with root package name */
    final f.j$V f10247b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0342j$q0(int i6, EnumC0338j$p0 enumC0338j$p0, C0321j$l c0321j$l) {
        this.f10246a = enumC0338j$p0;
        this.f10247b = c0321j$l;
    }

    @Override // g.j$x3
    public final Object g(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j) {
        AbstractC0334j$o0 abstractC0334j$o0 = (AbstractC0334j$o0) this.f10247b.get();
        abstractC0350j$s0.s0(j_j, abstractC0334j$o0);
        return Boolean.valueOf(abstractC0334j$o0.f10228b);
    }

    @Override // g.j$x3
    public final int k() {
        return j$P2.f10066z | j$P2.f10063w;
    }

    @Override // g.j$x3
    public final Object l(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j) {
        return (Boolean) new C0346j$r0(this, abstractC0350j$s0, j_j).invoke();
    }
}
