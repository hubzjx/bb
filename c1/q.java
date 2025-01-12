package c1;

import c1.s;
import com.google.android.exoplayer2.f1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class q {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public s f3222a;

        public a(s sVar) {
            this.f3222a = sVar;
        }
    }

    public static boolean a(j jVar) {
        com.google.android.exoplayer2.util.y yVar = new com.google.android.exoplayer2.util.y(4);
        jVar.n(yVar.c(), 0, 4);
        return yVar.C() == 1716281667;
    }

    public static int b(j jVar) {
        jVar.g();
        com.google.android.exoplayer2.util.y yVar = new com.google.android.exoplayer2.util.y(2);
        jVar.n(yVar.c(), 0, 2);
        int G = yVar.G();
        int i6 = G >> 2;
        jVar.g();
        if (i6 == 16382) {
            return G;
        }
        throw new f1("First frame does not start with sync code.");
    }

    public static n1.a c(j jVar, boolean z5) {
        n1.a a6 = new u().a(jVar, z5 ? null : s1.h.f13147b);
        if (a6 == null || a6.h() == 0) {
            return null;
        }
        return a6;
    }

    public static n1.a d(j jVar, boolean z5) {
        jVar.g();
        long m5 = jVar.m();
        n1.a c6 = c(jVar, z5);
        jVar.h((int) (jVar.m() - m5));
        return c6;
    }

    public static boolean e(j jVar, a aVar) {
        s b6;
        jVar.g();
        com.google.android.exoplayer2.util.x xVar = new com.google.android.exoplayer2.util.x(new byte[4]);
        jVar.n(xVar.f4688a, 0, 4);
        boolean g6 = xVar.g();
        int h6 = xVar.h(7);
        int h7 = xVar.h(24) + 4;
        if (h6 == 0) {
            b6 = i(jVar);
        } else {
            s sVar = aVar.f3222a;
            if (sVar == null) {
                throw new IllegalArgumentException();
            }
            if (h6 == 3) {
                b6 = sVar.c(g(jVar, h7));
            } else if (h6 == 4) {
                b6 = sVar.d(k(jVar, h7));
            } else if (h6 != 6) {
                jVar.h(h7);
                return g6;
            } else {
                b6 = sVar.b(Collections.singletonList(f(jVar, h7)));
            }
        }
        aVar.f3222a = b6;
        return g6;
    }

    private static q1.a f(j jVar, int i6) {
        com.google.android.exoplayer2.util.y yVar = new com.google.android.exoplayer2.util.y(i6);
        jVar.readFully(yVar.c(), 0, i6);
        yVar.N(4);
        int k6 = yVar.k();
        String y5 = yVar.y(yVar.k(), com.google.common.base.b.f5583a);
        String x5 = yVar.x(yVar.k());
        int k7 = yVar.k();
        int k8 = yVar.k();
        int k9 = yVar.k();
        int k10 = yVar.k();
        int k11 = yVar.k();
        byte[] bArr = new byte[k11];
        yVar.i(bArr, 0, k11);
        return new q1.a(k6, y5, x5, k7, k8, k9, k10, bArr);
    }

    private static s.a g(j jVar, int i6) {
        com.google.android.exoplayer2.util.y yVar = new com.google.android.exoplayer2.util.y(i6);
        jVar.readFully(yVar.c(), 0, i6);
        return h(yVar);
    }

    public static s.a h(com.google.android.exoplayer2.util.y yVar) {
        yVar.N(1);
        int D = yVar.D();
        long d6 = yVar.d() + D;
        int i6 = D / 18;
        long[] jArr = new long[i6];
        long[] jArr2 = new long[i6];
        int i7 = 0;
        while (true) {
            if (i7 >= i6) {
                break;
            }
            long t5 = yVar.t();
            if (t5 == -1) {
                jArr = Arrays.copyOf(jArr, i7);
                jArr2 = Arrays.copyOf(jArr2, i7);
                break;
            }
            jArr[i7] = t5;
            jArr2[i7] = yVar.t();
            yVar.N(2);
            i7++;
        }
        yVar.N((int) (d6 - yVar.d()));
        return new s.a(jArr, jArr2);
    }

    private static s i(j jVar) {
        byte[] bArr = new byte[38];
        jVar.readFully(bArr, 0, 38);
        return new s(bArr, 4);
    }

    public static void j(j jVar) {
        com.google.android.exoplayer2.util.y yVar = new com.google.android.exoplayer2.util.y(4);
        jVar.readFully(yVar.c(), 0, 4);
        if (yVar.C() != 1716281667) {
            throw new f1("Failed to read FLAC stream marker.");
        }
    }

    private static List k(j jVar, int i6) {
        com.google.android.exoplayer2.util.y yVar = new com.google.android.exoplayer2.util.y(i6);
        jVar.readFully(yVar.c(), 0, i6);
        yVar.N(4);
        return Arrays.asList(c0.i(yVar, false, false).f3170b);
    }
}
