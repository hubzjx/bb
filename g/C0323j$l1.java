package g;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$l1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0323j$l1 extends AbstractC0327j$m1 {

    /* renamed from: h  reason: collision with root package name */
    private final Object[] f10202h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0323j$l1(e.j$J j_j, AbstractC0350j$s0 abstractC0350j$s0, Object[] objArr) {
        super(objArr.length, j_j, abstractC0350j$s0);
        this.f10202h = objArr;
    }

    C0323j$l1(C0323j$l1 c0323j$l1, e.j$J j_j, long j6, long j7) {
        super(c0323j$l1, j_j, j6, j7, c0323j$l1.f10202h.length);
        this.f10202h = c0323j$l1.f10202h;
    }

    @Override // g.AbstractC0327j$m1
    final AbstractC0327j$m1 b(e.j$J j_j, long j6, long j7) {
        return new C0323j$l1(this, j_j, j6, j7);
    }

    @Override // f.InterfaceC0257j$e
    public final void j(Object obj) {
        int i6 = this.f10213f;
        if (i6 >= this.f10214g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f10213f));
        }
        Object[] objArr = this.f10202h;
        this.f10213f = i6 + 1;
        objArr[i6] = obj;
    }
}
