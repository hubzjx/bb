package l1;

import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.s0;
import java.util.Arrays;
import java.util.Collections;
import l1.i0;
import okio.Segment;
/* loaded from: classes.dex */
public final class i implements m {

    /* renamed from: v  reason: collision with root package name */
    private static final byte[] f11532v = {73, 68, 51};

    /* renamed from: a  reason: collision with root package name */
    private final boolean f11533a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.x f11534b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11535c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11536d;

    /* renamed from: e  reason: collision with root package name */
    private String f11537e;

    /* renamed from: f  reason: collision with root package name */
    private c1.a0 f11538f;

    /* renamed from: g  reason: collision with root package name */
    private c1.a0 f11539g;

    /* renamed from: h  reason: collision with root package name */
    private int f11540h;

    /* renamed from: i  reason: collision with root package name */
    private int f11541i;

    /* renamed from: j  reason: collision with root package name */
    private int f11542j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11543k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11544l;

    /* renamed from: m  reason: collision with root package name */
    private int f11545m;

    /* renamed from: n  reason: collision with root package name */
    private int f11546n;

    /* renamed from: o  reason: collision with root package name */
    private int f11547o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f11548p;

    /* renamed from: q  reason: collision with root package name */
    private long f11549q;

    /* renamed from: r  reason: collision with root package name */
    private int f11550r;

    /* renamed from: s  reason: collision with root package name */
    private long f11551s;

    /* renamed from: t  reason: collision with root package name */
    private c1.a0 f11552t;

    /* renamed from: u  reason: collision with root package name */
    private long f11553u;

    public i(boolean z5) {
        this(z5, null);
    }

    private void b() {
        com.google.android.exoplayer2.util.a.e(this.f11538f);
        s0.j(this.f11552t);
        s0.j(this.f11539g);
    }

    private void g(com.google.android.exoplayer2.util.y yVar) {
        if (yVar.a() == 0) {
            return;
        }
        this.f11534b.f4688a[0] = yVar.c()[yVar.d()];
        this.f11534b.p(2);
        int h6 = this.f11534b.h(4);
        int i6 = this.f11546n;
        if (i6 != -1 && h6 != i6) {
            q();
            return;
        }
        if (!this.f11544l) {
            this.f11544l = true;
            this.f11545m = this.f11547o;
            this.f11546n = h6;
        }
        t();
    }

    private boolean h(com.google.android.exoplayer2.util.y yVar, int i6) {
        yVar.M(i6 + 1);
        if (w(yVar, this.f11534b.f4688a, 1)) {
            this.f11534b.p(4);
            int h6 = this.f11534b.h(1);
            int i7 = this.f11545m;
            if (i7 == -1 || h6 == i7) {
                if (this.f11546n != -1) {
                    if (!w(yVar, this.f11534b.f4688a, 1)) {
                        return true;
                    }
                    this.f11534b.p(2);
                    if (this.f11534b.h(4) != this.f11546n) {
                        return false;
                    }
                    yVar.M(i6 + 2);
                }
                if (w(yVar, this.f11534b.f4688a, 4)) {
                    this.f11534b.p(14);
                    int h7 = this.f11534b.h(13);
                    if (h7 < 7) {
                        return false;
                    }
                    byte[] c6 = yVar.c();
                    int e6 = yVar.e();
                    int i8 = i6 + h7;
                    if (i8 >= e6) {
                        return true;
                    }
                    byte b6 = c6[i8];
                    if (b6 == -1) {
                        int i9 = i8 + 1;
                        if (i9 == e6) {
                            return true;
                        }
                        return l((byte) -1, c6[i9]) && ((c6[i9] & 8) >> 3) == h6;
                    } else if (b6 != 73) {
                        return false;
                    } else {
                        int i10 = i8 + 1;
                        if (i10 == e6) {
                            return true;
                        }
                        if (c6[i10] != 68) {
                            return false;
                        }
                        int i11 = i8 + 2;
                        return i11 == e6 || c6[i11] == 51;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean i(com.google.android.exoplayer2.util.y yVar, byte[] bArr, int i6) {
        int min = Math.min(yVar.a(), i6 - this.f11541i);
        yVar.i(bArr, this.f11541i, min);
        int i7 = this.f11541i + min;
        this.f11541i = i7;
        return i7 == i6;
    }

    private void j(com.google.android.exoplayer2.util.y yVar) {
        int i6;
        byte[] c6 = yVar.c();
        int d6 = yVar.d();
        int e6 = yVar.e();
        while (d6 < e6) {
            int i7 = d6 + 1;
            int i8 = c6[d6] & 255;
            if (this.f11542j == 512 && l((byte) -1, (byte) i8) && (this.f11544l || h(yVar, i7 - 2))) {
                this.f11547o = (i8 & 8) >> 3;
                this.f11543k = (i8 & 1) == 0;
                if (this.f11544l) {
                    t();
                } else {
                    r();
                }
                yVar.M(i7);
                return;
            }
            int i9 = this.f11542j;
            int i10 = i8 | i9;
            if (i10 != 329) {
                if (i10 == 511) {
                    this.f11542j = 512;
                } else if (i10 == 836) {
                    i6 = Segment.SHARE_MINIMUM;
                } else if (i10 == 1075) {
                    u();
                    yVar.M(i7);
                    return;
                } else if (i9 != 256) {
                    this.f11542j = 256;
                    i7--;
                }
                d6 = i7;
            } else {
                i6 = 768;
            }
            this.f11542j = i6;
            d6 = i7;
        }
        yVar.M(d6);
    }

    private boolean l(byte b6, byte b7) {
        return m(((b6 & 255) << 8) | (b7 & 255));
    }

    public static boolean m(int i6) {
        return (i6 & 65526) == 65520;
    }

    private void n() {
        this.f11534b.p(0);
        if (this.f11548p) {
            this.f11534b.r(10);
        } else {
            int h6 = this.f11534b.h(2) + 1;
            if (h6 != 2) {
                StringBuilder sb = new StringBuilder(61);
                sb.append("Detected audio object type: ");
                sb.append(h6);
                sb.append(", but assuming AAC LC.");
                com.google.android.exoplayer2.util.n.h("AdtsReader", sb.toString());
                h6 = 2;
            }
            this.f11534b.r(5);
            byte[] b6 = com.google.android.exoplayer2.audio.a.b(h6, this.f11546n, this.f11534b.h(3));
            a.b g6 = com.google.android.exoplayer2.audio.a.g(b6);
            com.google.android.exoplayer2.s0 E = new s0.b().S(this.f11537e).e0("audio/mp4a-latm").I(g6.f3316c).H(g6.f3315b).f0(g6.f3314a).T(Collections.singletonList(b6)).V(this.f11536d).E();
            this.f11549q = 1024000000 / E.B;
            this.f11538f.e(E);
            this.f11548p = true;
        }
        this.f11534b.r(4);
        int h7 = (this.f11534b.h(13) - 2) - 5;
        if (this.f11543k) {
            h7 -= 2;
        }
        v(this.f11538f, this.f11549q, 0, h7);
    }

    private void o() {
        this.f11539g.a(this.f11535c, 10);
        this.f11535c.M(6);
        v(this.f11539g, 0L, 10, this.f11535c.z() + 10);
    }

    private void p(com.google.android.exoplayer2.util.y yVar) {
        int min = Math.min(yVar.a(), this.f11550r - this.f11541i);
        this.f11552t.a(yVar, min);
        int i6 = this.f11541i + min;
        this.f11541i = i6;
        int i7 = this.f11550r;
        if (i6 == i7) {
            this.f11552t.d(this.f11551s, 1, i7, 0, null);
            this.f11551s += this.f11553u;
            s();
        }
    }

    private void q() {
        this.f11544l = false;
        s();
    }

    private void r() {
        this.f11540h = 1;
        this.f11541i = 0;
    }

    private void s() {
        this.f11540h = 0;
        this.f11541i = 0;
        this.f11542j = 256;
    }

    private void t() {
        this.f11540h = 3;
        this.f11541i = 0;
    }

    private void u() {
        this.f11540h = 2;
        this.f11541i = f11532v.length;
        this.f11550r = 0;
        this.f11535c.M(0);
    }

    private void v(c1.a0 a0Var, long j6, int i6, int i7) {
        this.f11540h = 4;
        this.f11541i = i6;
        this.f11552t = a0Var;
        this.f11553u = j6;
        this.f11550r = i7;
    }

    private boolean w(com.google.android.exoplayer2.util.y yVar, byte[] bArr, int i6) {
        if (yVar.a() < i6) {
            return false;
        }
        yVar.i(bArr, 0, i6);
        return true;
    }

    @Override // l1.m
    public void a() {
        q();
    }

    @Override // l1.m
    public void c(com.google.android.exoplayer2.util.y yVar) {
        b();
        while (yVar.a() > 0) {
            int i6 = this.f11540h;
            if (i6 == 0) {
                j(yVar);
            } else if (i6 == 1) {
                g(yVar);
            } else if (i6 != 2) {
                if (i6 == 3) {
                    if (i(yVar, this.f11534b.f4688a, this.f11543k ? 7 : 5)) {
                        n();
                    }
                } else if (i6 != 4) {
                    throw new IllegalStateException();
                } else {
                    p(yVar);
                }
            } else if (i(yVar, this.f11535c.c(), 10)) {
                o();
            }
        }
    }

    @Override // l1.m
    public void d() {
    }

    @Override // l1.m
    public void e(long j6, int i6) {
        this.f11551s = j6;
    }

    @Override // l1.m
    public void f(c1.k kVar, i0.d dVar) {
        dVar.a();
        this.f11537e = dVar.b();
        c1.a0 e6 = kVar.e(dVar.c(), 1);
        this.f11538f = e6;
        this.f11552t = e6;
        if (!this.f11533a) {
            this.f11539g = new c1.h();
            return;
        }
        dVar.a();
        c1.a0 e7 = kVar.e(dVar.c(), 4);
        this.f11539g = e7;
        e7.e(new s0.b().S(dVar.b()).e0("application/id3").E());
    }

    public long k() {
        return this.f11549q;
    }

    public i(boolean z5, String str) {
        this.f11534b = new com.google.android.exoplayer2.util.x(new byte[7]);
        this.f11535c = new com.google.android.exoplayer2.util.y(Arrays.copyOf(f11532v, 10));
        s();
        this.f11545m = -1;
        this.f11546n = -1;
        this.f11549q = -9223372036854775807L;
        this.f11533a = z5;
        this.f11536d = str;
    }
}
