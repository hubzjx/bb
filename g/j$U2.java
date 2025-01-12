package g;
/* loaded from: classes2.dex */
final class j$U2 extends j$V2 implements f.j$E {

    /* renamed from: c  reason: collision with root package name */
    final long[] f10095c = new long[128];

    @Override // g.j$V2
    public final void b(Object obj, long j6) {
        f.j$E j_e = (f.j$E) obj;
        for (int i6 = 0; i6 < j6; i6++) {
            j_e.f(this.f10095c[i6]);
        }
    }

    @Override // f.j$E
    public final void f(long j6) {
        int i6 = this.f10097b;
        this.f10097b = i6 + 1;
        this.f10095c[i6] = j6;
    }
}
