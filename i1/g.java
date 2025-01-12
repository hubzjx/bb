package i1;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import c1.a0;
import c1.t;
import c1.w;
import c1.x;
import com.google.android.exoplayer2.drm.k;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.y;
import i1.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import okio.Segment;
/* loaded from: classes.dex */
public class g implements c1.i {
    public static final c1.o I = new c1.o() { // from class: i1.f
        @Override // c1.o
        public final c1.i[] a() {
            c1.i[] n5;
            n5 = g.n();
            return n5;
        }

        @Override // c1.o
        public /* synthetic */ c1.i[] b(Uri uri, Map map) {
            return c1.n.a(this, uri, map);
        }
    };
    private static final byte[] J = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final s0 K = new s0.b().e0("application/x-emsg").E();
    private int A;
    private int B;
    private int C;
    private boolean D;
    private c1.k E;
    private a0[] F;
    private a0[] G;
    private boolean H;

    /* renamed from: a  reason: collision with root package name */
    private final int f10911a;

    /* renamed from: b  reason: collision with root package name */
    private final o f10912b;

    /* renamed from: c  reason: collision with root package name */
    private final List f10913c;

    /* renamed from: d  reason: collision with root package name */
    private final SparseArray f10914d;

    /* renamed from: e  reason: collision with root package name */
    private final y f10915e;

    /* renamed from: f  reason: collision with root package name */
    private final y f10916f;

    /* renamed from: g  reason: collision with root package name */
    private final y f10917g;

    /* renamed from: h  reason: collision with root package name */
    private final byte[] f10918h;

    /* renamed from: i  reason: collision with root package name */
    private final y f10919i;

    /* renamed from: j  reason: collision with root package name */
    private final k0 f10920j;

    /* renamed from: k  reason: collision with root package name */
    private final p1.c f10921k;

    /* renamed from: l  reason: collision with root package name */
    private final y f10922l;

    /* renamed from: m  reason: collision with root package name */
    private final ArrayDeque f10923m;

    /* renamed from: n  reason: collision with root package name */
    private final ArrayDeque f10924n;

    /* renamed from: o  reason: collision with root package name */
    private final a0 f10925o;

    /* renamed from: p  reason: collision with root package name */
    private int f10926p;

    /* renamed from: q  reason: collision with root package name */
    private int f10927q;

    /* renamed from: r  reason: collision with root package name */
    private long f10928r;

    /* renamed from: s  reason: collision with root package name */
    private int f10929s;

    /* renamed from: t  reason: collision with root package name */
    private y f10930t;

    /* renamed from: u  reason: collision with root package name */
    private long f10931u;

    /* renamed from: v  reason: collision with root package name */
    private int f10932v;

    /* renamed from: w  reason: collision with root package name */
    private long f10933w;

    /* renamed from: x  reason: collision with root package name */
    private long f10934x;

    /* renamed from: y  reason: collision with root package name */
    private long f10935y;

    /* renamed from: z  reason: collision with root package name */
    private b f10936z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f10937a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10938b;

        public a(long j6, int i6) {
            this.f10937a = j6;
            this.f10938b = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final a0 f10939a;

        /* renamed from: d  reason: collision with root package name */
        public r f10942d;

        /* renamed from: e  reason: collision with root package name */
        public c f10943e;

        /* renamed from: f  reason: collision with root package name */
        public int f10944f;

        /* renamed from: g  reason: collision with root package name */
        public int f10945g;

        /* renamed from: h  reason: collision with root package name */
        public int f10946h;

        /* renamed from: i  reason: collision with root package name */
        public int f10947i;

        /* renamed from: l  reason: collision with root package name */
        private boolean f10950l;

        /* renamed from: b  reason: collision with root package name */
        public final q f10940b = new q();

        /* renamed from: c  reason: collision with root package name */
        public final y f10941c = new y();

        /* renamed from: j  reason: collision with root package name */
        private final y f10948j = new y(1);

        /* renamed from: k  reason: collision with root package name */
        private final y f10949k = new y();

        public b(a0 a0Var, r rVar, c cVar) {
            this.f10939a = a0Var;
            this.f10942d = rVar;
            this.f10943e = cVar;
            j(rVar, cVar);
        }

        public int c() {
            int i6 = !this.f10950l ? this.f10942d.f11027g[this.f10944f] : this.f10940b.f11013l[this.f10944f] ? 1 : 0;
            return g() != null ? i6 | 1073741824 : i6;
        }

        public long d() {
            return !this.f10950l ? this.f10942d.f11023c[this.f10944f] : this.f10940b.f11008g[this.f10946h];
        }

        public long e() {
            return !this.f10950l ? this.f10942d.f11026f[this.f10944f] : this.f10940b.c(this.f10944f);
        }

        public int f() {
            return !this.f10950l ? this.f10942d.f11024d[this.f10944f] : this.f10940b.f11010i[this.f10944f];
        }

        public p g() {
            if (this.f10950l) {
                int i6 = ((c) com.google.android.exoplayer2.util.s0.j(this.f10940b.f11002a)).f10900a;
                p pVar = this.f10940b.f11016o;
                if (pVar == null) {
                    pVar = this.f10942d.f11021a.a(i6);
                }
                if (pVar == null || !pVar.f10997a) {
                    return null;
                }
                return pVar;
            }
            return null;
        }

        public boolean h() {
            this.f10944f++;
            if (this.f10950l) {
                int i6 = this.f10945g + 1;
                this.f10945g = i6;
                int[] iArr = this.f10940b.f11009h;
                int i7 = this.f10946h;
                if (i6 == iArr[i7]) {
                    this.f10946h = i7 + 1;
                    this.f10945g = 0;
                    return false;
                }
                return true;
            }
            return false;
        }

        public int i(int i6, int i7) {
            y yVar;
            p g6 = g();
            if (g6 == null) {
                return 0;
            }
            int i8 = g6.f11000d;
            if (i8 != 0) {
                yVar = this.f10940b.f11017p;
            } else {
                byte[] bArr = (byte[]) com.google.android.exoplayer2.util.s0.j(g6.f11001e);
                this.f10949k.K(bArr, bArr.length);
                y yVar2 = this.f10949k;
                i8 = bArr.length;
                yVar = yVar2;
            }
            boolean g7 = this.f10940b.g(this.f10944f);
            boolean z5 = g7 || i7 != 0;
            this.f10948j.c()[0] = (byte) ((z5 ? 128 : 0) | i8);
            this.f10948j.M(0);
            this.f10939a.f(this.f10948j, 1, 1);
            this.f10939a.f(yVar, i8, 1);
            if (z5) {
                if (!g7) {
                    this.f10941c.I(8);
                    byte[] c6 = this.f10941c.c();
                    c6[0] = 0;
                    c6[1] = 1;
                    c6[2] = (byte) ((i7 >> 8) & 255);
                    c6[3] = (byte) (i7 & 255);
                    c6[4] = (byte) ((i6 >> 24) & 255);
                    c6[5] = (byte) ((i6 >> 16) & 255);
                    c6[6] = (byte) ((i6 >> 8) & 255);
                    c6[7] = (byte) (i6 & 255);
                    this.f10939a.f(this.f10941c, 8, 1);
                    return i8 + 1 + 8;
                }
                y yVar3 = this.f10940b.f11017p;
                int G = yVar3.G();
                yVar3.N(-2);
                int i9 = (G * 6) + 2;
                if (i7 != 0) {
                    this.f10941c.I(i9);
                    byte[] c7 = this.f10941c.c();
                    yVar3.i(c7, 0, i9);
                    int i10 = (((c7[2] & 255) << 8) | (c7[3] & 255)) + i7;
                    c7[2] = (byte) ((i10 >> 8) & 255);
                    c7[3] = (byte) (i10 & 255);
                    yVar3 = this.f10941c;
                }
                this.f10939a.f(yVar3, i9, 1);
                return i8 + 1 + i9;
            }
            return i8 + 1;
        }

        public void j(r rVar, c cVar) {
            this.f10942d = rVar;
            this.f10943e = cVar;
            this.f10939a.e(rVar.f11021a.f10991f);
            k();
        }

        public void k() {
            this.f10940b.f();
            this.f10944f = 0;
            this.f10946h = 0;
            this.f10945g = 0;
            this.f10947i = 0;
            this.f10950l = false;
        }

        public void l(long j6) {
            int i6 = this.f10944f;
            while (true) {
                q qVar = this.f10940b;
                if (i6 >= qVar.f11007f || qVar.c(i6) >= j6) {
                    return;
                }
                if (this.f10940b.f11013l[i6]) {
                    this.f10947i = i6;
                }
                i6++;
            }
        }

        public void m() {
            p g6 = g();
            if (g6 == null) {
                return;
            }
            y yVar = this.f10940b.f11017p;
            int i6 = g6.f11000d;
            if (i6 != 0) {
                yVar.N(i6);
            }
            if (this.f10940b.g(this.f10944f)) {
                yVar.N(yVar.G() * 6);
            }
        }

        public void n(com.google.android.exoplayer2.drm.k kVar) {
            p a6 = this.f10942d.f11021a.a(((c) com.google.android.exoplayer2.util.s0.j(this.f10940b.f11002a)).f10900a);
            this.f10939a.e(this.f10942d.f11021a.f10991f.e().L(kVar.g(a6 != null ? a6.f10998b : null)).E());
        }
    }

    public g() {
        this(0);
    }

    private static void A(y yVar, int i6, q qVar) {
        yVar.M(i6 + 8);
        int b6 = i1.a.b(yVar.k());
        if ((b6 & 1) != 0) {
            throw new f1("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z5 = (b6 & 2) != 0;
        int E = yVar.E();
        if (E == 0) {
            Arrays.fill(qVar.f11015n, 0, qVar.f11007f, false);
        } else if (E == qVar.f11007f) {
            Arrays.fill(qVar.f11015n, 0, E, z5);
            qVar.d(yVar.a());
            qVar.b(yVar);
        } else {
            int i7 = qVar.f11007f;
            StringBuilder sb = new StringBuilder(80);
            sb.append("Senc sample count ");
            sb.append(E);
            sb.append(" is different from fragment sample count");
            sb.append(i7);
            throw new f1(sb.toString());
        }
    }

    private static void B(y yVar, q qVar) {
        A(yVar, 0, qVar);
    }

    private static Pair C(y yVar, long j6) {
        long F;
        long F2;
        yVar.M(8);
        int c6 = i1.a.c(yVar.k());
        yVar.N(4);
        long C = yVar.C();
        if (c6 == 0) {
            F = yVar.C();
            F2 = yVar.C();
        } else {
            F = yVar.F();
            F2 = yVar.F();
        }
        long j7 = F;
        long j8 = j6 + F2;
        long F0 = com.google.android.exoplayer2.util.s0.F0(j7, 1000000L, C);
        yVar.N(2);
        int G = yVar.G();
        int[] iArr = new int[G];
        long[] jArr = new long[G];
        long[] jArr2 = new long[G];
        long[] jArr3 = new long[G];
        long j9 = j7;
        long j10 = F0;
        int i6 = 0;
        while (i6 < G) {
            int k6 = yVar.k();
            if ((k6 & Integer.MIN_VALUE) != 0) {
                throw new f1("Unhandled indirect reference");
            }
            long C2 = yVar.C();
            iArr[i6] = k6 & Integer.MAX_VALUE;
            jArr[i6] = j8;
            jArr3[i6] = j10;
            long j11 = j9 + C2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i7 = G;
            int[] iArr2 = iArr;
            long F02 = com.google.android.exoplayer2.util.s0.F0(j11, 1000000L, C);
            jArr4[i6] = F02 - jArr5[i6];
            yVar.N(4);
            j8 += iArr2[i6];
            i6++;
            iArr = iArr2;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            G = i7;
            j9 = j11;
            j10 = F02;
        }
        return Pair.create(Long.valueOf(F0), new c1.d(iArr, jArr, jArr2, jArr3));
    }

    private static long D(y yVar) {
        yVar.M(8);
        return i1.a.c(yVar.k()) == 1 ? yVar.F() : yVar.C();
    }

    private static b E(y yVar, SparseArray sparseArray) {
        yVar.M(8);
        int b6 = i1.a.b(yVar.k());
        b l6 = l(sparseArray, yVar.k());
        if (l6 == null) {
            return null;
        }
        if ((b6 & 1) != 0) {
            long F = yVar.F();
            q qVar = l6.f10940b;
            qVar.f11004c = F;
            qVar.f11005d = F;
        }
        c cVar = l6.f10943e;
        l6.f10940b.f11002a = new c((b6 & 2) != 0 ? yVar.k() - 1 : cVar.f10900a, (b6 & 8) != 0 ? yVar.k() : cVar.f10901b, (b6 & 16) != 0 ? yVar.k() : cVar.f10902c, (b6 & 32) != 0 ? yVar.k() : cVar.f10903d);
        return l6;
    }

    private static void F(a.C0178a c0178a, SparseArray sparseArray, int i6, byte[] bArr) {
        b E = E(((a.b) com.google.android.exoplayer2.util.a.e(c0178a.g(1952868452))).f10874b, sparseArray);
        if (E == null) {
            return;
        }
        q qVar = E.f10940b;
        long j6 = qVar.f11019r;
        boolean z5 = qVar.f11020s;
        E.k();
        E.f10950l = true;
        a.b g6 = c0178a.g(1952867444);
        if (g6 == null || (i6 & 2) != 0) {
            qVar.f11019r = j6;
            qVar.f11020s = z5;
        } else {
            qVar.f11019r = D(g6.f10874b);
            qVar.f11020s = true;
        }
        I(c0178a, E, i6);
        p a6 = E.f10942d.f11021a.a(((c) com.google.android.exoplayer2.util.a.e(qVar.f11002a)).f10900a);
        a.b g7 = c0178a.g(1935763834);
        if (g7 != null) {
            y((p) com.google.android.exoplayer2.util.a.e(a6), g7.f10874b, qVar);
        }
        a.b g8 = c0178a.g(1935763823);
        if (g8 != null) {
            x(g8.f10874b, qVar);
        }
        a.b g9 = c0178a.g(1936027235);
        if (g9 != null) {
            B(g9.f10874b, qVar);
        }
        z(c0178a, a6 != null ? a6.f10998b : null, qVar);
        int size = c0178a.f10872c.size();
        for (int i7 = 0; i7 < size; i7++) {
            a.b bVar = (a.b) c0178a.f10872c.get(i7);
            if (bVar.f10870a == 1970628964) {
                J(bVar.f10874b, qVar, bArr);
            }
        }
    }

    private static Pair G(y yVar) {
        yVar.M(12);
        return Pair.create(Integer.valueOf(yVar.k()), new c(yVar.k() - 1, yVar.k(), yVar.k(), yVar.k()));
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int H(b bVar, int i6, int i7, y yVar, int i8) {
        long j6;
        long j7;
        int i9;
        int i10;
        boolean z5;
        int i11;
        boolean z6;
        int i12;
        boolean z7;
        boolean z8;
        b bVar2 = bVar;
        yVar.M(8);
        int b6 = i1.a.b(yVar.k());
        o oVar = bVar2.f10942d.f11021a;
        q qVar = bVar2.f10940b;
        c cVar = (c) com.google.android.exoplayer2.util.s0.j(qVar.f11002a);
        qVar.f11009h[i6] = yVar.E();
        long[] jArr = qVar.f11008g;
        long j8 = qVar.f11004c;
        jArr[i6] = j8;
        if ((b6 & 1) != 0) {
            jArr[i6] = j8 + yVar.k();
        }
        boolean z9 = (b6 & 4) != 0;
        int i13 = cVar.f10903d;
        if (z9) {
            i13 = yVar.k();
        }
        boolean z10 = (b6 & 256) != 0;
        boolean z11 = (b6 & 512) != 0;
        boolean z12 = (b6 & Segment.SHARE_MINIMUM) != 0;
        boolean z13 = (b6 & 2048) != 0;
        long[] jArr2 = oVar.f10993h;
        if (jArr2 == null || jArr2.length != 1) {
            j6 = 0;
        } else {
            j6 = 0;
            if (jArr2[0] == 0) {
                j7 = com.google.android.exoplayer2.util.s0.F0(((long[]) com.google.android.exoplayer2.util.s0.j(oVar.f10994i))[0], 1000000L, oVar.f10988c);
                int[] iArr = qVar.f11010i;
                int[] iArr2 = qVar.f11011j;
                long[] jArr3 = qVar.f11012k;
                boolean[] zArr = qVar.f11013l;
                int i14 = i13;
                boolean z14 = (oVar.f10987b == 2 || (i7 & 1) == 0) ? false : true;
                i9 = i8 + qVar.f11009h[i6];
                boolean z15 = z14;
                long j9 = oVar.f10988c;
                long j10 = j7;
                long j11 = qVar.f11019r;
                i10 = i8;
                while (i10 < i9) {
                    int e6 = e(z10 ? yVar.k() : cVar.f10901b);
                    if (z11) {
                        z5 = z10;
                        i11 = yVar.k();
                    } else {
                        z5 = z10;
                        i11 = cVar.f10902c;
                    }
                    int e7 = e(i11);
                    if (z12) {
                        z6 = z9;
                        i12 = yVar.k();
                    } else if (i10 == 0 && z9) {
                        z6 = z9;
                        i12 = i14;
                    } else {
                        z6 = z9;
                        i12 = cVar.f10903d;
                    }
                    boolean z16 = z13;
                    if (z13) {
                        z7 = z11;
                        z8 = z12;
                        iArr2[i10] = (int) ((yVar.k() * 1000000) / j9);
                    } else {
                        z7 = z11;
                        z8 = z12;
                        iArr2[i10] = 0;
                    }
                    long F0 = com.google.android.exoplayer2.util.s0.F0(j11, 1000000L, j9) - j10;
                    jArr3[i10] = F0;
                    if (!qVar.f11020s) {
                        jArr3[i10] = F0 + bVar2.f10942d.f11028h;
                    }
                    iArr[i10] = e7;
                    zArr[i10] = ((i12 >> 16) & 1) == 0 && (!z15 || i10 == 0);
                    j11 += e6;
                    i10++;
                    bVar2 = bVar;
                    z10 = z5;
                    j9 = j9;
                    z9 = z6;
                    z13 = z16;
                    z11 = z7;
                    z12 = z8;
                }
                qVar.f11019r = j11;
                return i9;
            }
        }
        j7 = j6;
        int[] iArr3 = qVar.f11010i;
        int[] iArr22 = qVar.f11011j;
        long[] jArr32 = qVar.f11012k;
        boolean[] zArr2 = qVar.f11013l;
        int i142 = i13;
        if (oVar.f10987b == 2) {
        }
        i9 = i8 + qVar.f11009h[i6];
        boolean z152 = z14;
        long j92 = oVar.f10988c;
        long j102 = j7;
        long j112 = qVar.f11019r;
        i10 = i8;
        while (i10 < i9) {
        }
        qVar.f11019r = j112;
        return i9;
    }

    private static void I(a.C0178a c0178a, b bVar, int i6) {
        List list = c0178a.f10872c;
        int size = list.size();
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            a.b bVar2 = (a.b) list.get(i9);
            if (bVar2.f10870a == 1953658222) {
                y yVar = bVar2.f10874b;
                yVar.M(12);
                int E = yVar.E();
                if (E > 0) {
                    i8 += E;
                    i7++;
                }
            }
        }
        bVar.f10946h = 0;
        bVar.f10945g = 0;
        bVar.f10944f = 0;
        bVar.f10940b.e(i7, i8);
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            a.b bVar3 = (a.b) list.get(i12);
            if (bVar3.f10870a == 1953658222) {
                i11 = H(bVar, i10, i6, bVar3.f10874b, i11);
                i10++;
            }
        }
    }

    private static void J(y yVar, q qVar, byte[] bArr) {
        yVar.M(8);
        yVar.i(bArr, 0, 16);
        if (Arrays.equals(bArr, J)) {
            A(yVar, 16, qVar);
        }
    }

    private void K(long j6) {
        while (!this.f10923m.isEmpty() && ((a.C0178a) this.f10923m.peek()).f10871b == j6) {
            p((a.C0178a) this.f10923m.pop());
        }
        f();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean L(c1.j jVar) {
        long p5;
        if (this.f10929s == 0) {
            if (!jVar.d(this.f10922l.c(), 0, 8, true)) {
                return false;
            }
            this.f10929s = 8;
            this.f10922l.M(0);
            this.f10928r = this.f10922l.C();
            this.f10927q = this.f10922l.k();
        }
        long j6 = this.f10928r;
        if (j6 != 1) {
            if (j6 == 0) {
                long a6 = jVar.a();
                if (a6 == -1 && !this.f10923m.isEmpty()) {
                    a6 = ((a.C0178a) this.f10923m.peek()).f10871b;
                }
                if (a6 != -1) {
                    p5 = (a6 - jVar.p()) + this.f10929s;
                }
            }
            if (this.f10928r < this.f10929s) {
                long p6 = jVar.p() - this.f10929s;
                int i6 = this.f10927q;
                if ((i6 == 1836019558 || i6 == 1835295092) && !this.H) {
                    this.E.r(new x.b(this.f10934x, p6));
                    this.H = true;
                }
                if (this.f10927q == 1836019558) {
                    int size = this.f10914d.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        q qVar = ((b) this.f10914d.valueAt(i7)).f10940b;
                        qVar.f11003b = p6;
                        qVar.f11005d = p6;
                        qVar.f11004c = p6;
                    }
                }
                int i8 = this.f10927q;
                if (i8 == 1835295092) {
                    this.f10936z = null;
                    this.f10931u = p6 + this.f10928r;
                    this.f10926p = 2;
                    return true;
                }
                if (P(i8)) {
                    long p7 = (jVar.p() + this.f10928r) - 8;
                    this.f10923m.push(new a.C0178a(this.f10927q, p7));
                    if (this.f10928r == this.f10929s) {
                        K(p7);
                    } else {
                        f();
                    }
                } else {
                    if (Q(this.f10927q)) {
                        if (this.f10929s != 8) {
                            throw new f1("Leaf atom defines extended atom size (unsupported).");
                        }
                        long j7 = this.f10928r;
                        if (j7 > 2147483647L) {
                            throw new f1("Leaf atom with length > 2147483647 (unsupported).");
                        }
                        y yVar = new y((int) j7);
                        System.arraycopy(this.f10922l.c(), 0, yVar.c(), 0, 8);
                        this.f10930t = yVar;
                    } else if (this.f10928r > 2147483647L) {
                        throw new f1("Skipping atom with length > 2147483647 (unsupported).");
                    } else {
                        this.f10930t = null;
                    }
                    this.f10926p = 1;
                }
                return true;
            }
            throw new f1("Atom size less than header length (unsupported).");
        }
        jVar.readFully(this.f10922l.c(), 8, 8);
        this.f10929s += 8;
        p5 = this.f10922l.F();
        this.f10928r = p5;
        if (this.f10928r < this.f10929s) {
        }
    }

    private void M(c1.j jVar) {
        int i6 = ((int) this.f10928r) - this.f10929s;
        y yVar = this.f10930t;
        if (yVar != null) {
            jVar.readFully(yVar.c(), 8, i6);
            r(new a.b(this.f10927q, yVar), jVar.p());
        } else {
            jVar.h(i6);
        }
        K(jVar.p());
    }

    private void N(c1.j jVar) {
        int size = this.f10914d.size();
        b bVar = null;
        long j6 = Long.MAX_VALUE;
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = ((b) this.f10914d.valueAt(i6)).f10940b;
            if (qVar.f11018q) {
                long j7 = qVar.f11005d;
                if (j7 < j6) {
                    bVar = (b) this.f10914d.valueAt(i6);
                    j6 = j7;
                }
            }
        }
        if (bVar == null) {
            this.f10926p = 3;
            return;
        }
        int p5 = (int) (j6 - jVar.p());
        if (p5 < 0) {
            throw new f1("Offset to encryption data was negative.");
        }
        jVar.h(p5);
        bVar.f10940b.a(jVar);
    }

    private boolean O(c1.j jVar) {
        int b6;
        int i6;
        b bVar = this.f10936z;
        if (bVar == null) {
            bVar = k(this.f10914d);
            if (bVar == null) {
                int p5 = (int) (this.f10931u - jVar.p());
                if (p5 >= 0) {
                    jVar.h(p5);
                    f();
                    return false;
                }
                throw new f1("Offset to end of mdat was negative.");
            }
            int d6 = (int) (bVar.d() - jVar.p());
            if (d6 < 0) {
                com.google.android.exoplayer2.util.n.h("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                d6 = 0;
            }
            jVar.h(d6);
            this.f10936z = bVar;
        }
        int i7 = 4;
        int i8 = 1;
        if (this.f10926p == 3) {
            int f6 = bVar.f();
            this.A = f6;
            if (bVar.f10944f < bVar.f10947i) {
                jVar.h(f6);
                bVar.m();
                if (!bVar.h()) {
                    this.f10936z = null;
                }
                this.f10926p = 3;
                return true;
            }
            if (bVar.f10942d.f11021a.f10992g == 1) {
                this.A = f6 - 8;
                jVar.h(8);
            }
            if ("audio/ac4".equals(bVar.f10942d.f11021a.f10991f.f4056n)) {
                this.B = bVar.i(this.A, 7);
                com.google.android.exoplayer2.audio.c.a(this.A, this.f10919i);
                bVar.f10939a.a(this.f10919i, 7);
                i6 = this.B + 7;
            } else {
                i6 = bVar.i(this.A, 0);
            }
            this.B = i6;
            this.A += this.B;
            this.f10926p = 4;
            this.C = 0;
        }
        o oVar = bVar.f10942d.f11021a;
        a0 a0Var = bVar.f10939a;
        long e6 = bVar.e();
        k0 k0Var = this.f10920j;
        if (k0Var != null) {
            e6 = k0Var.a(e6);
        }
        long j6 = e6;
        if (oVar.f10995j == 0) {
            while (true) {
                int i9 = this.B;
                int i10 = this.A;
                if (i9 >= i10) {
                    break;
                }
                this.B += a0Var.b(jVar, i10 - i9, false);
            }
        } else {
            byte[] c6 = this.f10916f.c();
            c6[0] = 0;
            c6[1] = 0;
            c6[2] = 0;
            int i11 = oVar.f10995j;
            int i12 = i11 + 1;
            int i13 = 4 - i11;
            while (this.B < this.A) {
                int i14 = this.C;
                if (i14 == 0) {
                    jVar.readFully(c6, i13, i12);
                    this.f10916f.M(0);
                    int k6 = this.f10916f.k();
                    if (k6 < i8) {
                        throw new f1("Invalid NAL length");
                    }
                    this.C = k6 - 1;
                    this.f10915e.M(0);
                    a0Var.a(this.f10915e, i7);
                    a0Var.a(this.f10916f, i8);
                    this.D = this.G.length > 0 && com.google.android.exoplayer2.util.r.g(oVar.f10991f.f4056n, c6[i7]);
                    this.B += 5;
                    this.A += i13;
                } else {
                    if (this.D) {
                        this.f10917g.I(i14);
                        jVar.readFully(this.f10917g.c(), 0, this.C);
                        a0Var.a(this.f10917g, this.C);
                        b6 = this.C;
                        int k7 = com.google.android.exoplayer2.util.r.k(this.f10917g.c(), this.f10917g.e());
                        this.f10917g.M("video/hevc".equals(oVar.f10991f.f4056n) ? 1 : 0);
                        this.f10917g.L(k7);
                        c1.c.a(j6, this.f10917g, this.G);
                    } else {
                        b6 = a0Var.b(jVar, i14, false);
                    }
                    this.B += b6;
                    this.C -= b6;
                    i7 = 4;
                    i8 = 1;
                }
            }
        }
        int c7 = bVar.c();
        p g6 = bVar.g();
        a0Var.d(j6, c7, this.A, 0, g6 != null ? g6.f10999c : null);
        u(j6);
        if (!bVar.h()) {
            this.f10936z = null;
        }
        this.f10926p = 3;
        return true;
    }

    private static boolean P(int i6) {
        return i6 == 1836019574 || i6 == 1953653099 || i6 == 1835297121 || i6 == 1835626086 || i6 == 1937007212 || i6 == 1836019558 || i6 == 1953653094 || i6 == 1836475768 || i6 == 1701082227;
    }

    private static boolean Q(int i6) {
        return i6 == 1751411826 || i6 == 1835296868 || i6 == 1836476516 || i6 == 1936286840 || i6 == 1937011556 || i6 == 1937011827 || i6 == 1668576371 || i6 == 1937011555 || i6 == 1937011578 || i6 == 1937013298 || i6 == 1937007471 || i6 == 1668232756 || i6 == 1937011571 || i6 == 1952867444 || i6 == 1952868452 || i6 == 1953196132 || i6 == 1953654136 || i6 == 1953658222 || i6 == 1886614376 || i6 == 1935763834 || i6 == 1935763823 || i6 == 1936027235 || i6 == 1970628964 || i6 == 1935828848 || i6 == 1936158820 || i6 == 1701606260 || i6 == 1835362404 || i6 == 1701671783;
    }

    private static int e(int i6) {
        if (i6 >= 0) {
            return i6;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected negtive value: ");
        sb.append(i6);
        throw new f1(sb.toString());
    }

    private void f() {
        this.f10926p = 0;
        this.f10929s = 0;
    }

    private c i(SparseArray sparseArray, int i6) {
        return (c) (sparseArray.size() == 1 ? sparseArray.valueAt(0) : com.google.android.exoplayer2.util.a.e((c) sparseArray.get(i6)));
    }

    private static com.google.android.exoplayer2.drm.k j(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i6 = 0; i6 < size; i6++) {
            a.b bVar = (a.b) list.get(i6);
            if (bVar.f10870a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] c6 = bVar.f10874b.c();
                UUID f6 = m.f(c6);
                if (f6 == null) {
                    com.google.android.exoplayer2.util.n.h("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new k.b(f6, "video/mp4", c6));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new com.google.android.exoplayer2.drm.k(arrayList);
    }

    private static b k(SparseArray sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j6 = Long.MAX_VALUE;
        for (int i6 = 0; i6 < size; i6++) {
            b bVar2 = (b) sparseArray.valueAt(i6);
            if ((bVar2.f10950l || bVar2.f10944f != bVar2.f10942d.f11022b) && (!bVar2.f10950l || bVar2.f10946h != bVar2.f10940b.f11006e)) {
                long d6 = bVar2.d();
                if (d6 < j6) {
                    bVar = bVar2;
                    j6 = d6;
                }
            }
        }
        return bVar;
    }

    private static b l(SparseArray sparseArray, int i6) {
        return (b) (sparseArray.size() == 1 ? sparseArray.valueAt(0) : sparseArray.get(i6));
    }

    private void m() {
        int i6;
        a0[] a0VarArr = new a0[2];
        this.F = a0VarArr;
        a0 a0Var = this.f10925o;
        int i7 = 0;
        if (a0Var != null) {
            a0VarArr[0] = a0Var;
            i6 = 1;
        } else {
            i6 = 0;
        }
        int i8 = 100;
        if ((this.f10911a & 4) != 0) {
            a0VarArr[i6] = this.E.e(100, 4);
            i8 = androidx.constraintlayout.widget.g.T0;
            i6++;
        }
        a0[] a0VarArr2 = (a0[]) com.google.android.exoplayer2.util.s0.y0(this.F, i6);
        this.F = a0VarArr2;
        for (a0 a0Var2 : a0VarArr2) {
            a0Var2.e(K);
        }
        this.G = new a0[this.f10913c.size()];
        while (i7 < this.G.length) {
            a0 e6 = this.E.e(i8, 3);
            e6.e((s0) this.f10913c.get(i7));
            this.G[i7] = e6;
            i7++;
            i8++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c1.i[] n() {
        return new c1.i[]{new g()};
    }

    private void p(a.C0178a c0178a) {
        int i6 = c0178a.f10870a;
        if (i6 == 1836019574) {
            t(c0178a);
        } else if (i6 == 1836019558) {
            s(c0178a);
        } else if (this.f10923m.isEmpty()) {
        } else {
            ((a.C0178a) this.f10923m.peek()).d(c0178a);
        }
    }

    private void q(y yVar) {
        long F0;
        String str;
        long F02;
        String str2;
        long C;
        long j6;
        a0[] a0VarArr;
        if (this.F.length == 0) {
            return;
        }
        yVar.M(8);
        int c6 = i1.a.c(yVar.k());
        if (c6 == 0) {
            String str3 = (String) com.google.android.exoplayer2.util.a.e(yVar.u());
            String str4 = (String) com.google.android.exoplayer2.util.a.e(yVar.u());
            long C2 = yVar.C();
            F0 = com.google.android.exoplayer2.util.s0.F0(yVar.C(), 1000000L, C2);
            long j7 = this.f10935y;
            long j8 = j7 != -9223372036854775807L ? j7 + F0 : -9223372036854775807L;
            str = str3;
            F02 = com.google.android.exoplayer2.util.s0.F0(yVar.C(), 1000L, C2);
            str2 = str4;
            C = yVar.C();
            j6 = j8;
        } else if (c6 != 1) {
            StringBuilder sb = new StringBuilder(46);
            sb.append("Skipping unsupported emsg version: ");
            sb.append(c6);
            com.google.android.exoplayer2.util.n.h("FragmentedMp4Extractor", sb.toString());
            return;
        } else {
            long C3 = yVar.C();
            j6 = com.google.android.exoplayer2.util.s0.F0(yVar.F(), 1000000L, C3);
            long F03 = com.google.android.exoplayer2.util.s0.F0(yVar.C(), 1000L, C3);
            long C4 = yVar.C();
            str = (String) com.google.android.exoplayer2.util.a.e(yVar.u());
            F02 = F03;
            C = C4;
            str2 = (String) com.google.android.exoplayer2.util.a.e(yVar.u());
            F0 = -9223372036854775807L;
        }
        byte[] bArr = new byte[yVar.a()];
        yVar.i(bArr, 0, yVar.a());
        y yVar2 = new y(this.f10921k.a(new p1.a(str, str2, F02, C, bArr)));
        int a6 = yVar2.a();
        for (a0 a0Var : this.F) {
            yVar2.M(0);
            a0Var.a(yVar2, a6);
        }
        if (j6 == -9223372036854775807L) {
            this.f10924n.addLast(new a(F0, a6));
            this.f10932v += a6;
            return;
        }
        k0 k0Var = this.f10920j;
        if (k0Var != null) {
            j6 = k0Var.a(j6);
        }
        for (a0 a0Var2 : this.F) {
            a0Var2.d(j6, 1, a6, 0, null);
        }
    }

    private void r(a.b bVar, long j6) {
        if (!this.f10923m.isEmpty()) {
            ((a.C0178a) this.f10923m.peek()).e(bVar);
            return;
        }
        int i6 = bVar.f10870a;
        if (i6 != 1936286840) {
            if (i6 == 1701671783) {
                q(bVar.f10874b);
                return;
            }
            return;
        }
        Pair C = C(bVar.f10874b, j6);
        this.f10935y = ((Long) C.first).longValue();
        this.E.r((x) C.second);
        this.H = true;
    }

    private void s(a.C0178a c0178a) {
        w(c0178a, this.f10914d, this.f10911a, this.f10918h);
        com.google.android.exoplayer2.drm.k j6 = j(c0178a.f10872c);
        if (j6 != null) {
            int size = this.f10914d.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((b) this.f10914d.valueAt(i6)).n(j6);
            }
        }
        if (this.f10933w != -9223372036854775807L) {
            int size2 = this.f10914d.size();
            for (int i7 = 0; i7 < size2; i7++) {
                ((b) this.f10914d.valueAt(i7)).l(this.f10933w);
            }
            this.f10933w = -9223372036854775807L;
        }
    }

    private void t(a.C0178a c0178a) {
        int i6 = 0;
        com.google.android.exoplayer2.util.a.h(this.f10912b == null, "Unexpected moov box.");
        com.google.android.exoplayer2.drm.k j6 = j(c0178a.f10872c);
        a.C0178a c0178a2 = (a.C0178a) com.google.android.exoplayer2.util.a.e(c0178a.f(1836475768));
        SparseArray sparseArray = new SparseArray();
        int size = c0178a2.f10872c.size();
        long j7 = -9223372036854775807L;
        for (int i7 = 0; i7 < size; i7++) {
            a.b bVar = (a.b) c0178a2.f10872c.get(i7);
            int i8 = bVar.f10870a;
            if (i8 == 1953654136) {
                Pair G = G(bVar.f10874b);
                sparseArray.put(((Integer) G.first).intValue(), (c) G.second);
            } else if (i8 == 1835362404) {
                j7 = v(bVar.f10874b);
            }
        }
        List x5 = i1.b.x(c0178a, new t(), j7, j6, (this.f10911a & 16) != 0, false, new com.google.common.base.e() { // from class: i1.e
            @Override // com.google.common.base.e
            public final Object apply(Object obj) {
                return g.this.o((o) obj);
            }
        });
        int size2 = x5.size();
        if (this.f10914d.size() != 0) {
            com.google.android.exoplayer2.util.a.g(this.f10914d.size() == size2);
            while (i6 < size2) {
                r rVar = (r) x5.get(i6);
                o oVar = rVar.f11021a;
                ((b) this.f10914d.get(oVar.f10986a)).j(rVar, i(sparseArray, oVar.f10986a));
                i6++;
            }
            return;
        }
        while (i6 < size2) {
            r rVar2 = (r) x5.get(i6);
            o oVar2 = rVar2.f11021a;
            this.f10914d.put(oVar2.f10986a, new b(this.E.e(i6, oVar2.f10987b), rVar2, i(sparseArray, oVar2.f10986a)));
            this.f10934x = Math.max(this.f10934x, oVar2.f10990e);
            i6++;
        }
        this.E.g();
    }

    private void u(long j6) {
        while (!this.f10924n.isEmpty()) {
            a aVar = (a) this.f10924n.removeFirst();
            this.f10932v -= aVar.f10938b;
            long j7 = aVar.f10937a + j6;
            k0 k0Var = this.f10920j;
            if (k0Var != null) {
                j7 = k0Var.a(j7);
            }
            for (a0 a0Var : this.F) {
                a0Var.d(j7, 1, aVar.f10938b, this.f10932v, null);
            }
        }
    }

    private static long v(y yVar) {
        yVar.M(8);
        return i1.a.c(yVar.k()) == 0 ? yVar.C() : yVar.F();
    }

    private static void w(a.C0178a c0178a, SparseArray sparseArray, int i6, byte[] bArr) {
        int size = c0178a.f10873d.size();
        for (int i7 = 0; i7 < size; i7++) {
            a.C0178a c0178a2 = (a.C0178a) c0178a.f10873d.get(i7);
            if (c0178a2.f10870a == 1953653094) {
                F(c0178a2, sparseArray, i6, bArr);
            }
        }
    }

    private static void x(y yVar, q qVar) {
        yVar.M(8);
        int k6 = yVar.k();
        if ((i1.a.b(k6) & 1) == 1) {
            yVar.N(8);
        }
        int E = yVar.E();
        if (E == 1) {
            qVar.f11005d += i1.a.c(k6) == 0 ? yVar.C() : yVar.F();
            return;
        }
        StringBuilder sb = new StringBuilder(40);
        sb.append("Unexpected saio entry count: ");
        sb.append(E);
        throw new f1(sb.toString());
    }

    private static void y(p pVar, y yVar, q qVar) {
        int i6;
        int i7 = pVar.f11000d;
        yVar.M(8);
        if ((i1.a.b(yVar.k()) & 1) == 1) {
            yVar.N(8);
        }
        int A = yVar.A();
        int E = yVar.E();
        if (E > qVar.f11007f) {
            int i8 = qVar.f11007f;
            StringBuilder sb = new StringBuilder(78);
            sb.append("Saiz sample count ");
            sb.append(E);
            sb.append(" is greater than fragment sample count");
            sb.append(i8);
            throw new f1(sb.toString());
        }
        if (A == 0) {
            boolean[] zArr = qVar.f11015n;
            i6 = 0;
            for (int i9 = 0; i9 < E; i9++) {
                int A2 = yVar.A();
                i6 += A2;
                zArr[i9] = A2 > i7;
            }
        } else {
            i6 = (A * E) + 0;
            Arrays.fill(qVar.f11015n, 0, E, A > i7);
        }
        Arrays.fill(qVar.f11015n, E, qVar.f11007f, false);
        if (i6 > 0) {
            qVar.d(i6);
        }
    }

    private static void z(a.C0178a c0178a, String str, q qVar) {
        byte[] bArr = null;
        y yVar = null;
        y yVar2 = null;
        for (int i6 = 0; i6 < c0178a.f10872c.size(); i6++) {
            a.b bVar = (a.b) c0178a.f10872c.get(i6);
            y yVar3 = bVar.f10874b;
            int i7 = bVar.f10870a;
            if (i7 == 1935828848) {
                yVar3.M(12);
                if (yVar3.k() == 1936025959) {
                    yVar = yVar3;
                }
            } else if (i7 == 1936158820) {
                yVar3.M(12);
                if (yVar3.k() == 1936025959) {
                    yVar2 = yVar3;
                }
            }
        }
        if (yVar == null || yVar2 == null) {
            return;
        }
        yVar.M(8);
        int c6 = i1.a.c(yVar.k());
        yVar.N(4);
        if (c6 == 1) {
            yVar.N(4);
        }
        if (yVar.k() != 1) {
            throw new f1("Entry count in sbgp != 1 (unsupported).");
        }
        yVar2.M(8);
        int c7 = i1.a.c(yVar2.k());
        yVar2.N(4);
        if (c7 == 1) {
            if (yVar2.C() == 0) {
                throw new f1("Variable length description in sgpd found (unsupported)");
            }
        } else if (c7 >= 2) {
            yVar2.N(4);
        }
        if (yVar2.C() != 1) {
            throw new f1("Entry count in sgpd != 1 (unsupported).");
        }
        yVar2.N(1);
        int A = yVar2.A();
        int i8 = (A & 240) >> 4;
        int i9 = A & 15;
        boolean z5 = yVar2.A() == 1;
        if (z5) {
            int A2 = yVar2.A();
            byte[] bArr2 = new byte[16];
            yVar2.i(bArr2, 0, 16);
            if (A2 == 0) {
                int A3 = yVar2.A();
                bArr = new byte[A3];
                yVar2.i(bArr, 0, A3);
            }
            qVar.f11014m = true;
            qVar.f11016o = new p(z5, str, A2, bArr2, i8, i9, bArr);
        }
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(c1.k kVar) {
        this.E = kVar;
        f();
        m();
        o oVar = this.f10912b;
        if (oVar != null) {
            this.f10914d.put(0, new b(kVar.e(0, oVar.f10987b), new r(this.f10912b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new c(0, 0, 0, 0)));
            this.E.g();
        }
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        int size = this.f10914d.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((b) this.f10914d.valueAt(i6)).k();
        }
        this.f10924n.clear();
        this.f10932v = 0;
        this.f10933w = j7;
        this.f10923m.clear();
        f();
    }

    @Override // c1.i
    public int g(c1.j jVar, w wVar) {
        while (true) {
            int i6 = this.f10926p;
            if (i6 != 0) {
                if (i6 == 1) {
                    M(jVar);
                } else if (i6 == 2) {
                    N(jVar);
                } else if (O(jVar)) {
                    return 0;
                }
            } else if (!L(jVar)) {
                return -1;
            }
        }
    }

    @Override // c1.i
    public boolean h(c1.j jVar) {
        return n.b(jVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public o o(o oVar) {
        return oVar;
    }

    public g(int i6) {
        this(i6, null);
    }

    public g(int i6, k0 k0Var) {
        this(i6, k0Var, null, Collections.emptyList());
    }

    public g(int i6, k0 k0Var, o oVar) {
        this(i6, k0Var, oVar, Collections.emptyList());
    }

    public g(int i6, k0 k0Var, o oVar, List list) {
        this(i6, k0Var, oVar, list, null);
    }

    public g(int i6, k0 k0Var, o oVar, List list, a0 a0Var) {
        this.f10911a = i6 | (oVar != null ? 8 : 0);
        this.f10920j = k0Var;
        this.f10912b = oVar;
        this.f10913c = Collections.unmodifiableList(list);
        this.f10925o = a0Var;
        this.f10921k = new p1.c();
        this.f10922l = new y(16);
        this.f10915e = new y(com.google.android.exoplayer2.util.r.f4652a);
        this.f10916f = new y(5);
        this.f10917g = new y();
        byte[] bArr = new byte[16];
        this.f10918h = bArr;
        this.f10919i = new y(bArr);
        this.f10923m = new ArrayDeque();
        this.f10924n = new ArrayDeque();
        this.f10914d = new SparseArray();
        this.f10934x = -9223372036854775807L;
        this.f10933w = -9223372036854775807L;
        this.f10935y = -9223372036854775807L;
        this.E = c1.k.f3219i;
        this.F = new a0[0];
        this.G = new a0[0];
    }
}
