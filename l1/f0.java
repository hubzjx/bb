package l1;

import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
final class f0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f11483a;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11486d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11487e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11488f;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.k0 f11484b = new com.google.android.exoplayer2.util.k0(0);

    /* renamed from: g  reason: collision with root package name */
    private long f11489g = -9223372036854775807L;

    /* renamed from: h  reason: collision with root package name */
    private long f11490h = -9223372036854775807L;

    /* renamed from: i  reason: collision with root package name */
    private long f11491i = -9223372036854775807L;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11485c = new com.google.android.exoplayer2.util.y();

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(int i6) {
        this.f11483a = i6;
    }

    private int a(c1.j jVar) {
        this.f11485c.J(s0.f4678f);
        this.f11486d = true;
        jVar.g();
        return 0;
    }

    private int f(c1.j jVar, c1.w wVar, int i6) {
        int min = (int) Math.min(this.f11483a, jVar.a());
        long j6 = 0;
        if (jVar.p() != j6) {
            wVar.f3247a = j6;
            return 1;
        }
        this.f11485c.I(min);
        jVar.g();
        jVar.n(this.f11485c.c(), 0, min);
        this.f11489g = g(this.f11485c, i6);
        this.f11487e = true;
        return 0;
    }

    private long g(com.google.android.exoplayer2.util.y yVar, int i6) {
        int e6 = yVar.e();
        for (int d6 = yVar.d(); d6 < e6; d6++) {
            if (yVar.c()[d6] == 71) {
                long b6 = j0.b(yVar, d6, i6);
                if (b6 != -9223372036854775807L) {
                    return b6;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int h(c1.j jVar, c1.w wVar, int i6) {
        long a6 = jVar.a();
        int min = (int) Math.min(this.f11483a, a6);
        long j6 = a6 - min;
        if (jVar.p() != j6) {
            wVar.f3247a = j6;
            return 1;
        }
        this.f11485c.I(min);
        jVar.g();
        jVar.n(this.f11485c.c(), 0, min);
        this.f11490h = i(this.f11485c, i6);
        this.f11488f = true;
        return 0;
    }

    private long i(com.google.android.exoplayer2.util.y yVar, int i6) {
        int d6 = yVar.d();
        int e6 = yVar.e();
        while (true) {
            e6--;
            if (e6 < d6) {
                return -9223372036854775807L;
            }
            if (yVar.c()[e6] == 71) {
                long b6 = j0.b(yVar, e6, i6);
                if (b6 != -9223372036854775807L) {
                    return b6;
                }
            }
        }
    }

    public long b() {
        return this.f11491i;
    }

    public com.google.android.exoplayer2.util.k0 c() {
        return this.f11484b;
    }

    public boolean d() {
        return this.f11486d;
    }

    public int e(c1.j jVar, c1.w wVar, int i6) {
        if (i6 <= 0) {
            return a(jVar);
        }
        if (this.f11488f) {
            if (this.f11490h == -9223372036854775807L) {
                return a(jVar);
            }
            if (this.f11487e) {
                long j6 = this.f11489g;
                if (j6 == -9223372036854775807L) {
                    return a(jVar);
                }
                this.f11491i = this.f11484b.b(this.f11490h) - this.f11484b.b(j6);
                return a(jVar);
            }
            return f(jVar, wVar, i6);
        }
        return h(jVar, wVar, i6);
    }
}
