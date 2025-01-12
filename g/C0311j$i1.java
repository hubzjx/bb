package g;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$i1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0311j$i1 extends AbstractC0327j$m1 implements j$Y1 {

    /* renamed from: h  reason: collision with root package name */
    private final double[] f10178h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0311j$i1(e.j$J j_j, AbstractC0350j$s0 abstractC0350j$s0, double[] dArr) {
        super(dArr.length, j_j, abstractC0350j$s0);
        this.f10178h = dArr;
    }

    C0311j$i1(C0311j$i1 c0311j$i1, e.j$J j_j, long j6, long j7) {
        super(c0311j$i1, j_j, j6, j7, c0311j$i1.f10178h.length);
        this.f10178h = c0311j$i1.f10178h;
    }

    @Override // g.AbstractC0327j$m1
    final AbstractC0327j$m1 b(e.j$J j_j, long j6, long j7) {
        return new C0311j$i1(this, j_j, j6, j7);
    }

    @Override // g.AbstractC0327j$m1, g.InterfaceC0284j$b2
    public final void d(double d6) {
        int i6 = this.f10213f;
        if (i6 >= this.f10214g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f10213f));
        }
        double[] dArr = this.f10178h;
        this.f10213f = i6 + 1;
        dArr[i6] = d6;
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        s((Double) obj);
    }

    @Override // g.j$Y1
    public final /* synthetic */ void s(Double d6) {
        AbstractC0350j$s0.m(this, d6);
    }
}
