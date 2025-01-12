package g;

import f.InterfaceC0261j$i;
/* loaded from: classes2.dex */
final class j$S2 extends j$V2 implements InterfaceC0261j$i {

    /* renamed from: c  reason: collision with root package name */
    final double[] f10088c = new double[128];

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.j$V2
    public final void b(Object obj, long j6) {
        InterfaceC0261j$i interfaceC0261j$i = (InterfaceC0261j$i) obj;
        for (int i6 = 0; i6 < j6; i6++) {
            interfaceC0261j$i.d(this.f10088c[i6]);
        }
    }

    @Override // f.InterfaceC0261j$i
    public final void d(double d6) {
        int i6 = this.f10097b;
        this.f10097b = i6 + 1;
        this.f10088c[i6] = d6;
    }
}
