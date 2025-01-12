package l1;

import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.s0;
import java.util.Collections;
import l1.i0;
import okio.Segment;
/* loaded from: classes.dex */
public final class s implements m {

    /* renamed from: a  reason: collision with root package name */
    private final String f11717a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11718b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.x f11719c;

    /* renamed from: d  reason: collision with root package name */
    private c1.a0 f11720d;

    /* renamed from: e  reason: collision with root package name */
    private String f11721e;

    /* renamed from: f  reason: collision with root package name */
    private s0 f11722f;

    /* renamed from: g  reason: collision with root package name */
    private int f11723g;

    /* renamed from: h  reason: collision with root package name */
    private int f11724h;

    /* renamed from: i  reason: collision with root package name */
    private int f11725i;

    /* renamed from: j  reason: collision with root package name */
    private int f11726j;

    /* renamed from: k  reason: collision with root package name */
    private long f11727k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11728l;

    /* renamed from: m  reason: collision with root package name */
    private int f11729m;

    /* renamed from: n  reason: collision with root package name */
    private int f11730n;

    /* renamed from: o  reason: collision with root package name */
    private int f11731o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f11732p;

    /* renamed from: q  reason: collision with root package name */
    private long f11733q;

    /* renamed from: r  reason: collision with root package name */
    private int f11734r;

    /* renamed from: s  reason: collision with root package name */
    private long f11735s;

    /* renamed from: t  reason: collision with root package name */
    private int f11736t;

    /* renamed from: u  reason: collision with root package name */
    private String f11737u;

    public s(String str) {
        this.f11717a = str;
        com.google.android.exoplayer2.util.y yVar = new com.google.android.exoplayer2.util.y((int) Segment.SHARE_MINIMUM);
        this.f11718b = yVar;
        this.f11719c = new com.google.android.exoplayer2.util.x(yVar.c());
    }

    private static long b(com.google.android.exoplayer2.util.x xVar) {
        return xVar.h((xVar.h(2) + 1) * 8);
    }

    private void g(com.google.android.exoplayer2.util.x xVar) {
        if (!xVar.g()) {
            this.f11728l = true;
            l(xVar);
        } else if (!this.f11728l) {
            return;
        }
        if (this.f11729m != 0) {
            throw new f1();
        }
        if (this.f11730n != 0) {
            throw new f1();
        }
        k(xVar, j(xVar));
        if (this.f11732p) {
            xVar.r((int) this.f11733q);
        }
    }

    private int h(com.google.android.exoplayer2.util.x xVar) {
        int b6 = xVar.b();
        a.b f6 = com.google.android.exoplayer2.audio.a.f(xVar, true);
        this.f11737u = f6.f3316c;
        this.f11734r = f6.f3314a;
        this.f11736t = f6.f3315b;
        return b6 - xVar.b();
    }

    private void i(com.google.android.exoplayer2.util.x xVar) {
        int i6;
        int h6 = xVar.h(3);
        this.f11731o = h6;
        if (h6 == 0) {
            i6 = 8;
        } else if (h6 != 1) {
            if (h6 == 3 || h6 == 4 || h6 == 5) {
                xVar.r(6);
                return;
            } else if (h6 != 6 && h6 != 7) {
                throw new IllegalStateException();
            } else {
                xVar.r(1);
                return;
            }
        } else {
            i6 = 9;
        }
        xVar.r(i6);
    }

    private int j(com.google.android.exoplayer2.util.x xVar) {
        int h6;
        if (this.f11731o == 0) {
            int i6 = 0;
            do {
                h6 = xVar.h(8);
                i6 += h6;
            } while (h6 == 255);
            return i6;
        }
        throw new f1();
    }

    private void k(com.google.android.exoplayer2.util.x xVar, int i6) {
        int e6 = xVar.e();
        if ((e6 & 7) == 0) {
            this.f11718b.M(e6 >> 3);
        } else {
            xVar.i(this.f11718b.c(), 0, i6 * 8);
            this.f11718b.M(0);
        }
        this.f11720d.a(this.f11718b, i6);
        this.f11720d.d(this.f11727k, 1, i6, 0, null);
        this.f11727k += this.f11735s;
    }

    private void l(com.google.android.exoplayer2.util.x xVar) {
        boolean g6;
        int h6 = xVar.h(1);
        int h7 = h6 == 1 ? xVar.h(1) : 0;
        this.f11729m = h7;
        if (h7 != 0) {
            throw new f1();
        }
        if (h6 == 1) {
            b(xVar);
        }
        if (!xVar.g()) {
            throw new f1();
        }
        this.f11730n = xVar.h(6);
        int h8 = xVar.h(4);
        int h9 = xVar.h(3);
        if (h8 != 0 || h9 != 0) {
            throw new f1();
        }
        if (h6 == 0) {
            int e6 = xVar.e();
            int h10 = h(xVar);
            xVar.p(e6);
            byte[] bArr = new byte[(h10 + 7) / 8];
            xVar.i(bArr, 0, h10);
            s0 E = new s0.b().S(this.f11721e).e0("audio/mp4a-latm").I(this.f11737u).H(this.f11736t).f0(this.f11734r).T(Collections.singletonList(bArr)).V(this.f11717a).E();
            if (!E.equals(this.f11722f)) {
                this.f11722f = E;
                this.f11735s = 1024000000 / E.B;
                this.f11720d.e(E);
            }
        } else {
            xVar.r(((int) b(xVar)) - h(xVar));
        }
        i(xVar);
        boolean g7 = xVar.g();
        this.f11732p = g7;
        this.f11733q = 0L;
        if (g7) {
            if (h6 == 1) {
                this.f11733q = b(xVar);
            } else {
                do {
                    g6 = xVar.g();
                    this.f11733q = (this.f11733q << 8) + xVar.h(8);
                } while (g6);
            }
        }
        if (xVar.g()) {
            xVar.r(8);
        }
    }

    private void m(int i6) {
        this.f11718b.I(i6);
        this.f11719c.n(this.f11718b.c());
    }

    @Override // l1.m
    public void a() {
        this.f11723g = 0;
        this.f11728l = false;
    }

    @Override // l1.m
    public void c(com.google.android.exoplayer2.util.y yVar) {
        com.google.android.exoplayer2.util.a.i(this.f11720d);
        while (yVar.a() > 0) {
            int i6 = this.f11723g;
            if (i6 != 0) {
                if (i6 == 1) {
                    int A = yVar.A();
                    if ((A & 224) == 224) {
                        this.f11726j = A;
                        this.f11723g = 2;
                    } else if (A != 86) {
                        this.f11723g = 0;
                    }
                } else if (i6 == 2) {
                    int A2 = ((this.f11726j & (-225)) << 8) | yVar.A();
                    this.f11725i = A2;
                    if (A2 > this.f11718b.c().length) {
                        m(this.f11725i);
                    }
                    this.f11724h = 0;
                    this.f11723g = 3;
                } else if (i6 != 3) {
                    throw new IllegalStateException();
                } else {
                    int min = Math.min(yVar.a(), this.f11725i - this.f11724h);
                    yVar.i(this.f11719c.f4688a, this.f11724h, min);
                    int i7 = this.f11724h + min;
                    this.f11724h = i7;
                    if (i7 == this.f11725i) {
                        this.f11719c.p(0);
                        g(this.f11719c);
                        this.f11723g = 0;
                    }
                }
            } else if (yVar.A() == 86) {
                this.f11723g = 1;
            }
        }
    }

    @Override // l1.m
    public void d() {
    }

    @Override // l1.m
    public void e(long j6, int i6) {
        this.f11727k = j6;
    }

    @Override // l1.m
    public void f(c1.k kVar, i0.d dVar) {
        dVar.a();
        this.f11720d = kVar.e(dVar.c(), 1);
        this.f11721e = dVar.b();
    }
}
