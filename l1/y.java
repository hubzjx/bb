package l1;

import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
final class y {

    /* renamed from: c  reason: collision with root package name */
    private boolean f11774c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11775d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11776e;

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.k0 f11772a = new com.google.android.exoplayer2.util.k0(0);

    /* renamed from: f  reason: collision with root package name */
    private long f11777f = -9223372036854775807L;

    /* renamed from: g  reason: collision with root package name */
    private long f11778g = -9223372036854775807L;

    /* renamed from: h  reason: collision with root package name */
    private long f11779h = -9223372036854775807L;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11773b = new com.google.android.exoplayer2.util.y();

    private static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    private int b(c1.j jVar) {
        this.f11773b.J(s0.f4678f);
        this.f11774c = true;
        jVar.g();
        return 0;
    }

    private int f(byte[] bArr, int i6) {
        return (bArr[i6 + 3] & 255) | ((bArr[i6] & 255) << 24) | ((bArr[i6 + 1] & 255) << 16) | ((bArr[i6 + 2] & 255) << 8);
    }

    private int h(c1.j jVar, c1.w wVar) {
        int min = (int) Math.min(20000L, jVar.a());
        long j6 = 0;
        if (jVar.p() != j6) {
            wVar.f3247a = j6;
            return 1;
        }
        this.f11773b.I(min);
        jVar.g();
        jVar.n(this.f11773b.c(), 0, min);
        this.f11777f = i(this.f11773b);
        this.f11775d = true;
        return 0;
    }

    private long i(com.google.android.exoplayer2.util.y yVar) {
        int e6 = yVar.e();
        for (int d6 = yVar.d(); d6 < e6 - 3; d6++) {
            if (f(yVar.c(), d6) == 442) {
                yVar.M(d6 + 4);
                long l6 = l(yVar);
                if (l6 != -9223372036854775807L) {
                    return l6;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int j(c1.j jVar, c1.w wVar) {
        long a6 = jVar.a();
        int min = (int) Math.min(20000L, a6);
        long j6 = a6 - min;
        if (jVar.p() != j6) {
            wVar.f3247a = j6;
            return 1;
        }
        this.f11773b.I(min);
        jVar.g();
        jVar.n(this.f11773b.c(), 0, min);
        this.f11778g = k(this.f11773b);
        this.f11776e = true;
        return 0;
    }

    private long k(com.google.android.exoplayer2.util.y yVar) {
        int d6 = yVar.d();
        for (int e6 = yVar.e() - 4; e6 >= d6; e6--) {
            if (f(yVar.c(), e6) == 442) {
                yVar.M(e6 + 4);
                long l6 = l(yVar);
                if (l6 != -9223372036854775807L) {
                    return l6;
                }
            }
        }
        return -9223372036854775807L;
    }

    public static long l(com.google.android.exoplayer2.util.y yVar) {
        int d6 = yVar.d();
        if (yVar.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        yVar.i(bArr, 0, 9);
        yVar.M(d6);
        if (a(bArr)) {
            return m(bArr);
        }
        return -9223372036854775807L;
    }

    private static long m(byte[] bArr) {
        byte b6 = bArr[0];
        byte b7 = bArr[2];
        return (((b6 & 56) >> 3) << 30) | ((b6 & 3) << 28) | ((bArr[1] & 255) << 20) | (((b7 & 248) >> 3) << 15) | ((b7 & 3) << 13) | ((bArr[3] & 255) << 5) | ((bArr[4] & 248) >> 3);
    }

    public long c() {
        return this.f11779h;
    }

    public com.google.android.exoplayer2.util.k0 d() {
        return this.f11772a;
    }

    public boolean e() {
        return this.f11774c;
    }

    public int g(c1.j jVar, c1.w wVar) {
        if (this.f11776e) {
            if (this.f11778g == -9223372036854775807L) {
                return b(jVar);
            }
            if (this.f11775d) {
                long j6 = this.f11777f;
                if (j6 == -9223372036854775807L) {
                    return b(jVar);
                }
                this.f11779h = this.f11772a.b(this.f11778g) - this.f11772a.b(j6);
                return b(jVar);
            }
            return h(jVar, wVar);
        }
        return j(jVar, wVar);
    }
}
