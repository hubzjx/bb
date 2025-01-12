package g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$D implements j$x3 {

    /* renamed from: a  reason: collision with root package name */
    final boolean f9971a;

    /* renamed from: b  reason: collision with root package name */
    final Object f9972b;

    /* renamed from: c  reason: collision with root package name */
    final f.j$T f9973c;

    /* renamed from: d  reason: collision with root package name */
    final f.j$V f9974d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$D(boolean z5, int i6, Object obj, j$F0 j_f0, C0281j$b c0281j$b) {
        this.f9971a = z5;
        this.f9972b = obj;
        this.f9973c = j_f0;
        this.f9974d = c0281j$b;
    }

    @Override // g.j$x3
    public final Object g(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j) {
        j$y3 j_y3 = (j$y3) this.f9974d.get();
        abstractC0350j$s0.s0(j_j, j_y3);
        Object obj = j_y3.get();
        return obj != null ? obj : this.f9972b;
    }

    @Override // g.j$x3
    public final int k() {
        return j$P2.f10066z | (this.f9971a ? 0 : j$P2.f10063w);
    }

    @Override // g.j$x3
    public final Object l(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j) {
        return new j$J(this, abstractC0350j$s0, j_j).invoke();
    }
}
