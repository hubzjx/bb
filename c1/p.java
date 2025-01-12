package c1;

import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public abstract class p {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public long f3221a;
    }

    private static boolean a(com.google.android.exoplayer2.util.y yVar, s sVar, int i6) {
        int j6 = j(yVar, i6);
        return j6 != -1 && j6 <= sVar.f3226b;
    }

    private static boolean b(com.google.android.exoplayer2.util.y yVar, int i6) {
        return yVar.A() == s0.v(yVar.c(), i6, yVar.d() - 1, 0);
    }

    private static boolean c(com.google.android.exoplayer2.util.y yVar, s sVar, boolean z5, a aVar) {
        try {
            long H = yVar.H();
            if (!z5) {
                H *= sVar.f3226b;
            }
            aVar.f3221a = H;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(com.google.android.exoplayer2.util.y yVar, s sVar, int i6, a aVar) {
        int d6 = yVar.d();
        long C = yVar.C();
        long j6 = C >>> 16;
        if (j6 != i6) {
            return false;
        }
        return g((int) (15 & (C >> 4)), sVar) && f((int) ((C >> 1) & 7), sVar) && !(((C & 1) > 1L ? 1 : ((C & 1) == 1L ? 0 : -1)) == 0) && c(yVar, sVar, ((j6 & 1) > 1L ? 1 : ((j6 & 1) == 1L ? 0 : -1)) == 0, aVar) && a(yVar, sVar, (int) ((C >> 12) & 15)) && e(yVar, sVar, (int) ((C >> 8) & 15)) && b(yVar, d6);
    }

    private static boolean e(com.google.android.exoplayer2.util.y yVar, s sVar, int i6) {
        int i7 = sVar.f3229e;
        if (i6 == 0) {
            return true;
        }
        if (i6 <= 11) {
            return i6 == sVar.f3230f;
        } else if (i6 == 12) {
            return yVar.A() * 1000 == i7;
        } else if (i6 <= 14) {
            int G = yVar.G();
            if (i6 == 14) {
                G *= 10;
            }
            return G == i7;
        } else {
            return false;
        }
    }

    private static boolean f(int i6, s sVar) {
        return i6 == 0 || i6 == sVar.f3233i;
    }

    private static boolean g(int i6, s sVar) {
        return i6 <= 7 ? i6 == sVar.f3231g - 1 : i6 <= 10 && sVar.f3231g == 2;
    }

    public static boolean h(j jVar, s sVar, int i6, a aVar) {
        long m5 = jVar.m();
        byte[] bArr = new byte[2];
        jVar.n(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i6) {
            jVar.g();
            jVar.o((int) (m5 - jVar.p()));
            return false;
        }
        com.google.android.exoplayer2.util.y yVar = new com.google.android.exoplayer2.util.y(16);
        System.arraycopy(bArr, 0, yVar.c(), 0, 2);
        yVar.L(l.a(jVar, yVar.c(), 2, 14));
        jVar.g();
        jVar.o((int) (m5 - jVar.p()));
        return d(yVar, sVar, i6, aVar);
    }

    public static long i(j jVar, s sVar) {
        jVar.g();
        jVar.o(1);
        byte[] bArr = new byte[1];
        jVar.n(bArr, 0, 1);
        boolean z5 = (bArr[0] & 1) == 1;
        jVar.o(2);
        int i6 = z5 ? 7 : 6;
        com.google.android.exoplayer2.util.y yVar = new com.google.android.exoplayer2.util.y(i6);
        yVar.L(l.a(jVar, yVar.c(), 0, i6));
        jVar.g();
        a aVar = new a();
        if (c(yVar, sVar, z5, aVar)) {
            return aVar.f3221a;
        }
        throw new f1();
    }

    public static int j(com.google.android.exoplayer2.util.y yVar, int i6) {
        switch (i6) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i6 - 2);
            case 6:
                return yVar.A() + 1;
            case 7:
                return yVar.G() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i6 - 8);
            default:
                return -1;
        }
    }
}
