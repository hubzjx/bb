package g;

import java.util.concurrent.CountedCompleter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j$M1 extends AbstractC0297j$f {

    /* renamed from: h  reason: collision with root package name */
    private final AbstractC0350j$s0 f10022h;

    j$M1(j$M1 j_m1, e.j$J j_j) {
        super(j_m1, j_j);
        this.f10022h = j_m1.f10022h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$M1(AbstractC0350j$s0 abstractC0350j$s0, AbstractC0350j$s0 abstractC0350j$s02, e.j$J j_j) {
        super(abstractC0350j$s02, j_j);
        this.f10022h = abstractC0350j$s0;
    }

    @Override // g.AbstractC0297j$f
    protected final Object a() {
        AbstractC0350j$s0 abstractC0350j$s0 = this.f10154a;
        j$K1 q02 = this.f10022h.q0();
        abstractC0350j$s0.s0(this.f10155b, q02);
        return q02;
    }

    @Override // g.AbstractC0297j$f
    protected final AbstractC0297j$f d(e.j$J j_j) {
        return new j$M1(this, j_j);
    }

    @Override // g.AbstractC0297j$f, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        AbstractC0297j$f abstractC0297j$f = this.f10157d;
        if (!(abstractC0297j$f == null)) {
            j$K1 j_k1 = (j$K1) ((j$M1) abstractC0297j$f).b();
            j_k1.v((j$K1) ((j$M1) this.f10158e).b());
            e(j_k1);
        }
        super.onCompletion(countedCompleter);
    }
}
