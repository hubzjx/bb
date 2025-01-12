package g;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$j1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0315j$j1 extends AbstractC0327j$m1 implements j$Z1 {

    /* renamed from: h  reason: collision with root package name */
    private final int[] f10183h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0315j$j1(e.j$J j_j, AbstractC0350j$s0 abstractC0350j$s0, int[] iArr) {
        super(iArr.length, j_j, abstractC0350j$s0);
        this.f10183h = iArr;
    }

    C0315j$j1(C0315j$j1 c0315j$j1, e.j$J j_j, long j6, long j7) {
        super(c0315j$j1, j_j, j6, j7, c0315j$j1.f10183h.length);
        this.f10183h = c0315j$j1.f10183h;
    }

    @Override // g.AbstractC0327j$m1
    final AbstractC0327j$m1 b(e.j$J j_j, long j6, long j7) {
        return new C0315j$j1(this, j_j, j6, j7);
    }

    @Override // g.AbstractC0327j$m1, g.InterfaceC0284j$b2
    public final void e(int i6) {
        int i7 = this.f10213f;
        if (i7 >= this.f10214g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f10213f));
        }
        int[] iArr = this.f10183h;
        this.f10213f = i7 + 1;
        iArr[i7] = i6;
    }

    @Override // f.InterfaceC0257j$e
    public final /* bridge */ /* synthetic */ void j(Object obj) {
        m((Integer) obj);
    }

    @Override // g.j$Z1
    public final /* synthetic */ void m(Integer num) {
        AbstractC0350j$s0.o(this, num);
    }
}
