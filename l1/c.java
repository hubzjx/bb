package l1;

import com.google.android.exoplayer2.audio.b;
import com.google.android.exoplayer2.s0;
import l1.i0;
/* loaded from: classes.dex */
public final class c implements m {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.x f11442a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11443b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11444c;

    /* renamed from: d  reason: collision with root package name */
    private String f11445d;

    /* renamed from: e  reason: collision with root package name */
    private c1.a0 f11446e;

    /* renamed from: f  reason: collision with root package name */
    private int f11447f;

    /* renamed from: g  reason: collision with root package name */
    private int f11448g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11449h;

    /* renamed from: i  reason: collision with root package name */
    private long f11450i;

    /* renamed from: j  reason: collision with root package name */
    private s0 f11451j;

    /* renamed from: k  reason: collision with root package name */
    private int f11452k;

    /* renamed from: l  reason: collision with root package name */
    private long f11453l;

    public c() {
        this(null);
    }

    private boolean b(com.google.android.exoplayer2.util.y yVar, byte[] bArr, int i6) {
        int min = Math.min(yVar.a(), i6 - this.f11448g);
        yVar.i(bArr, this.f11448g, min);
        int i7 = this.f11448g + min;
        this.f11448g = i7;
        return i7 == i6;
    }

    private void g() {
        this.f11442a.p(0);
        b.C0036b e6 = com.google.android.exoplayer2.audio.b.e(this.f11442a);
        s0 s0Var = this.f11451j;
        if (s0Var == null || e6.f3327d != s0Var.A || e6.f3326c != s0Var.B || !com.google.android.exoplayer2.util.s0.c(e6.f3324a, s0Var.f4056n)) {
            s0 E = new s0.b().S(this.f11445d).e0(e6.f3324a).H(e6.f3327d).f0(e6.f3326c).V(this.f11444c).E();
            this.f11451j = E;
            this.f11446e.e(E);
        }
        this.f11452k = e6.f3328e;
        this.f11450i = (e6.f3329f * 1000000) / this.f11451j.B;
    }

    private boolean h(com.google.android.exoplayer2.util.y yVar) {
        while (true) {
            boolean z5 = false;
            if (yVar.a() <= 0) {
                return false;
            }
            if (this.f11449h) {
                int A = yVar.A();
                if (A == 119) {
                    this.f11449h = false;
                    return true;
                }
                if (A != 11) {
                    this.f11449h = z5;
                }
                z5 = true;
                this.f11449h = z5;
            } else {
                if (yVar.A() != 11) {
                    this.f11449h = z5;
                }
                z5 = true;
                this.f11449h = z5;
            }
        }
    }

    @Override // l1.m
    public void a() {
        this.f11447f = 0;
        this.f11448g = 0;
        this.f11449h = false;
    }

    @Override // l1.m
    public void c(com.google.android.exoplayer2.util.y yVar) {
        com.google.android.exoplayer2.util.a.i(this.f11446e);
        while (yVar.a() > 0) {
            int i6 = this.f11447f;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2) {
                        int min = Math.min(yVar.a(), this.f11452k - this.f11448g);
                        this.f11446e.a(yVar, min);
                        int i7 = this.f11448g + min;
                        this.f11448g = i7;
                        int i8 = this.f11452k;
                        if (i7 == i8) {
                            this.f11446e.d(this.f11453l, 1, i8, 0, null);
                            this.f11453l += this.f11450i;
                            this.f11447f = 0;
                        }
                    }
                } else if (b(yVar, this.f11443b.c(), 128)) {
                    g();
                    this.f11443b.M(0);
                    this.f11446e.a(this.f11443b, 128);
                    this.f11447f = 2;
                }
            } else if (h(yVar)) {
                this.f11447f = 1;
                this.f11443b.c()[0] = 11;
                this.f11443b.c()[1] = 119;
                this.f11448g = 2;
            }
        }
    }

    @Override // l1.m
    public void d() {
    }

    @Override // l1.m
    public void e(long j6, int i6) {
        this.f11453l = j6;
    }

    @Override // l1.m
    public void f(c1.k kVar, i0.d dVar) {
        dVar.a();
        this.f11445d = dVar.b();
        this.f11446e = kVar.e(dVar.c(), 1);
    }

    public c(String str) {
        com.google.android.exoplayer2.util.x xVar = new com.google.android.exoplayer2.util.x(new byte[128]);
        this.f11442a = xVar;
        this.f11443b = new com.google.android.exoplayer2.util.y(xVar.f4688a);
        this.f11447f = 0;
        this.f11444c = str;
    }
}
