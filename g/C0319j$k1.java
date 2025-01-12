package g;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$k1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0319j$k1 extends AbstractC0327j$m1 implements InterfaceC0279j$a2 {

    /* renamed from: h  reason: collision with root package name */
    private final long[] f10190h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0319j$k1(e.j$J j_j, AbstractC0350j$s0 abstractC0350j$s0, long[] jArr) {
        super(jArr.length, j_j, abstractC0350j$s0);
        this.f10190h = jArr;
    }

    C0319j$k1(C0319j$k1 c0319j$k1, e.j$J j_j, long j6, long j7) {
        super(c0319j$k1, j_j, j6, j7, c0319j$k1.f10190h.length);
        this.f10190h = c0319j$k1.f10190h;
    }

    @Override // g.AbstractC0327j$m1
    final AbstractC0327j$m1 b(e.j$J j_j, long j6, long j7) {
        return new C0319j$k1(this, j_j, j6, j7);
    }

    @Override // g.AbstractC0327j$m1, g.InterfaceC0284j$b2
    public final void f(long j6) {
        int i6 = this.f10213f;
        if (i6 >= this.f10214g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f10213f));
        }
        long[] jArr = this.f10190h;
        this.f10213f = i6 + 1;
        jArr[i6] = j6;
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        q((Long) obj);
    }

    @Override // g.InterfaceC0279j$a2
    public final /* synthetic */ void q(Long l6) {
        AbstractC0350j$s0.q(this, l6);
    }
}
