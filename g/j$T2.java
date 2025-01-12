package g;

import f.InterfaceC0272j$t;
/* loaded from: classes2.dex */
final class j$T2 extends j$V2 implements InterfaceC0272j$t {

    /* renamed from: c  reason: collision with root package name */
    final int[] f10092c = new int[128];

    @Override // g.j$V2
    public final void b(Object obj, long j6) {
        InterfaceC0272j$t interfaceC0272j$t = (InterfaceC0272j$t) obj;
        for (int i6 = 0; i6 < j6; i6++) {
            interfaceC0272j$t.e(this.f10092c[i6]);
        }
    }

    @Override // f.InterfaceC0272j$t
    public final void e(int i6) {
        int i7 = this.f10097b;
        this.f10097b = i7 + 1;
        this.f10092c[i7] = i6;
    }
}
