package h1;

import c1.x;
import com.google.android.exoplayer2.audio.c1;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
/* loaded from: classes.dex */
final class h implements g {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f10624a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f10625b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10626c;

    /* renamed from: d  reason: collision with root package name */
    private final long f10627d;

    private h(long[] jArr, long[] jArr2, long j6, long j7) {
        this.f10624a = jArr;
        this.f10625b = jArr2;
        this.f10626c = j6;
        this.f10627d = j7;
    }

    public static h a(long j6, long j7, c1.a aVar, y yVar) {
        int A;
        yVar.N(10);
        int k6 = yVar.k();
        if (k6 <= 0) {
            return null;
        }
        int i6 = aVar.f3347d;
        long F0 = s0.F0(k6, (i6 >= 32000 ? 1152 : 576) * 1000000, i6);
        int G = yVar.G();
        int G2 = yVar.G();
        int G3 = yVar.G();
        yVar.N(2);
        long j8 = j7 + aVar.f3346c;
        long[] jArr = new long[G];
        long[] jArr2 = new long[G];
        int i7 = 0;
        long j9 = j7;
        while (i7 < G) {
            int i8 = G2;
            long j10 = j8;
            jArr[i7] = (i7 * F0) / G;
            jArr2[i7] = Math.max(j9, j10);
            if (G3 == 1) {
                A = yVar.A();
            } else if (G3 == 2) {
                A = yVar.G();
            } else if (G3 == 3) {
                A = yVar.D();
            } else if (G3 != 4) {
                return null;
            } else {
                A = yVar.E();
            }
            j9 += A * i8;
            i7++;
            j8 = j10;
            G2 = i8;
        }
        if (j6 != -1 && j6 != j9) {
            StringBuilder sb = new StringBuilder(67);
            sb.append("VBRI data size mismatch: ");
            sb.append(j6);
            sb.append(", ");
            sb.append(j9);
            n.h("VbriSeeker", sb.toString());
        }
        return new h(jArr, jArr2, F0, j9);
    }

    @Override // h1.g
    public long b(long j6) {
        return this.f10624a[s0.i(this.f10625b, j6, true, true)];
    }

    @Override // h1.g
    public long e() {
        return this.f10627d;
    }

    @Override // c1.x
    public boolean f() {
        return true;
    }

    @Override // c1.x
    public x.a i(long j6) {
        int i6 = s0.i(this.f10624a, j6, true, true);
        c1.y yVar = new c1.y(this.f10624a[i6], this.f10625b[i6]);
        if (yVar.f3253a >= j6 || i6 == this.f10624a.length - 1) {
            return new x.a(yVar);
        }
        int i7 = i6 + 1;
        return new x.a(yVar, new c1.y(this.f10624a[i7], this.f10625b[i7]));
    }

    @Override // c1.x
    public long j() {
        return this.f10626c;
    }
}
