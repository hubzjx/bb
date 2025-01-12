package c1;

import java.io.EOFException;
import s1.h;
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f3242a = new com.google.android.exoplayer2.util.y(10);

    public n1.a a(j jVar, h.a aVar) {
        n1.a aVar2 = null;
        int i6 = 0;
        while (true) {
            try {
                jVar.n(this.f3242a.c(), 0, 10);
                this.f3242a.M(0);
                if (this.f3242a.D() != 4801587) {
                    break;
                }
                this.f3242a.N(3);
                int z5 = this.f3242a.z();
                int i7 = z5 + 10;
                if (aVar2 == null) {
                    byte[] bArr = new byte[i7];
                    System.arraycopy(this.f3242a.c(), 0, bArr, 0, 10);
                    jVar.n(bArr, 10, z5);
                    aVar2 = new s1.h(aVar).e(bArr, i7);
                } else {
                    jVar.o(z5);
                }
                i6 += i7;
            } catch (EOFException unused) {
            }
        }
        jVar.g();
        jVar.o(i6);
        return aVar2;
    }
}
