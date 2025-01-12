package g;
/* loaded from: classes2.dex */
abstract class j$O implements j$x3, j$y3 {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f10029a;

    /* JADX INFO: Access modifiers changed from: protected */
    public j$O(boolean z5) {
        this.f10029a = z5;
    }

    public /* synthetic */ void d(double d6) {
        AbstractC0350j$s0.j();
        throw null;
    }

    public /* synthetic */ void e(int i6) {
        AbstractC0350j$s0.s();
        throw null;
    }

    public /* synthetic */ void f(long j6) {
        AbstractC0350j$s0.t();
        throw null;
    }

    @Override // g.j$x3
    public final Object g(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j) {
        abstractC0350j$s0.s0(j_j, this);
        return null;
    }

    @Override // f.j$V
    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void h() {
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ void i(long j6) {
    }

    @Override // g.j$x3
    public final int k() {
        if (this.f10029a) {
            return 0;
        }
        return j$P2.f10063w;
    }

    @Override // g.j$x3
    public final Object l(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j) {
        (this.f10029a ? new j$P(abstractC0350j$s0, j_j, this) : new j$Q(abstractC0350j$s0, j_j, abstractC0350j$s0.t0(this))).invoke();
        return null;
    }

    @Override // g.InterfaceC0284j$b2
    public final /* synthetic */ boolean o() {
        return false;
    }
}
