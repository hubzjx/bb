package l1;

import com.google.android.exoplayer2.audio.c;
import com.google.android.exoplayer2.s0;
import l1.i0;
/* loaded from: classes.dex */
public final class f implements m {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.x f11470a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11471b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11472c;

    /* renamed from: d  reason: collision with root package name */
    private String f11473d;

    /* renamed from: e  reason: collision with root package name */
    private c1.a0 f11474e;

    /* renamed from: f  reason: collision with root package name */
    private int f11475f;

    /* renamed from: g  reason: collision with root package name */
    private int f11476g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11477h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11478i;

    /* renamed from: j  reason: collision with root package name */
    private long f11479j;

    /* renamed from: k  reason: collision with root package name */
    private s0 f11480k;

    /* renamed from: l  reason: collision with root package name */
    private int f11481l;

    /* renamed from: m  reason: collision with root package name */
    private long f11482m;

    public f() {
        this(null);
    }

    private boolean b(com.google.android.exoplayer2.util.y yVar, byte[] bArr, int i6) {
        int min = Math.min(yVar.a(), i6 - this.f11476g);
        yVar.i(bArr, this.f11476g, min);
        int i7 = this.f11476g + min;
        this.f11476g = i7;
        return i7 == i6;
    }

    private void g() {
        this.f11470a.p(0);
        c.b d6 = com.google.android.exoplayer2.audio.c.d(this.f11470a);
        s0 s0Var = this.f11480k;
        if (s0Var == null || d6.f3334c != s0Var.A || d6.f3333b != s0Var.B || !"audio/ac4".equals(s0Var.f4056n)) {
            s0 E = new s0.b().S(this.f11473d).e0("audio/ac4").H(d6.f3334c).f0(d6.f3333b).V(this.f11472c).E();
            this.f11480k = E;
            this.f11474e.e(E);
        }
        this.f11481l = d6.f3335d;
        this.f11479j = (d6.f3336e * 1000000) / this.f11480k.B;
    }

    private boolean h(com.google.android.exoplayer2.util.y yVar) {
        int A;
        while (true) {
            if (yVar.a() <= 0) {
                return false;
            }
            if (this.f11477h) {
                A = yVar.A();
                this.f11477h = A == 172;
                if (A == 64 || A == 65) {
                    break;
                }
            } else {
                this.f11477h = yVar.A() == 172;
            }
        }
        this.f11478i = A == 65;
        return true;
    }

    @Override // l1.m
    public void a() {
        this.f11475f = 0;
        this.f11476g = 0;
        this.f11477h = false;
        this.f11478i = false;
    }

    @Override // l1.m
    public void c(com.google.android.exoplayer2.util.y yVar) {
        com.google.android.exoplayer2.util.a.i(this.f11474e);
        while (yVar.a() > 0) {
            int i6 = this.f11475f;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2) {
                        int min = Math.min(yVar.a(), this.f11481l - this.f11476g);
                        this.f11474e.a(yVar, min);
                        int i7 = this.f11476g + min;
                        this.f11476g = i7;
                        int i8 = this.f11481l;
                        if (i7 == i8) {
                            this.f11474e.d(this.f11482m, 1, i8, 0, null);
                            this.f11482m += this.f11479j;
                            this.f11475f = 0;
                        }
                    }
                } else if (b(yVar, this.f11471b.c(), 16)) {
                    g();
                    this.f11471b.M(0);
                    this.f11474e.a(this.f11471b, 16);
                    this.f11475f = 2;
                }
            } else if (h(yVar)) {
                this.f11475f = 1;
                this.f11471b.c()[0] = -84;
                this.f11471b.c()[1] = (byte) (this.f11478i ? 65 : 64);
                this.f11476g = 2;
            }
        }
    }

    @Override // l1.m
    public void d() {
    }

    @Override // l1.m
    public void e(long j6, int i6) {
        this.f11482m = j6;
    }

    @Override // l1.m
    public void f(c1.k kVar, i0.d dVar) {
        dVar.a();
        this.f11473d = dVar.b();
        this.f11474e = kVar.e(dVar.c(), 1);
    }

    public f(String str) {
        com.google.android.exoplayer2.util.x xVar = new com.google.android.exoplayer2.util.x(new byte[16]);
        this.f11470a = xVar;
        this.f11471b = new com.google.android.exoplayer2.util.y(xVar.f4688a);
        this.f11475f = 0;
        this.f11476g = 0;
        this.f11477h = false;
        this.f11478i = false;
        this.f11472c = str;
    }
}
