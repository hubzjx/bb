package g;
/* loaded from: classes2.dex */
abstract class j$C0 implements j$B0 {

    /* renamed from: a  reason: collision with root package name */
    protected final j$B0 f9964a;

    /* renamed from: b  reason: collision with root package name */
    protected final j$B0 f9965b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9966c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$C0(j$B0 j_b0, j$B0 j_b02) {
        this.f9964a = j_b0;
        this.f9965b = j_b02;
        this.f9966c = j_b0.count() + j_b02.count();
    }

    @Override // g.j$B0
    public /* bridge */ /* synthetic */ j$A0 c(int i6) {
        return (j$A0) c(i6);
    }

    @Override // g.j$B0
    public final j$B0 c(int i6) {
        if (i6 == 0) {
            return this.f9964a;
        }
        if (i6 == 1) {
            return this.f9965b;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // g.j$B0
    public final long count() {
        return this.f9966c;
    }

    @Override // g.j$B0
    public final int t() {
        return 2;
    }
}
