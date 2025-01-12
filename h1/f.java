package h1;

import android.net.Uri;
import c1.a0;
import c1.j;
import c1.k;
import c1.n;
import c1.o;
import c1.t;
import c1.u;
import c1.w;
import com.google.android.exoplayer2.audio.c1;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import h1.g;
import java.io.EOFException;
import java.util.Map;
import n1.a;
import okio.internal._BufferKt;
import s1.h;
import s1.m;
/* loaded from: classes.dex */
public final class f implements c1.i {

    /* renamed from: u  reason: collision with root package name */
    public static final o f10602u = new o() { // from class: h1.d
        @Override // c1.o
        public final c1.i[] a() {
            c1.i[] p5;
            p5 = f.p();
            return p5;
        }

        @Override // c1.o
        public /* synthetic */ c1.i[] b(Uri uri, Map map) {
            return n.a(this, uri, map);
        }
    };

    /* renamed from: v  reason: collision with root package name */
    private static final h.a f10603v = new h.a() { // from class: h1.e
        @Override // s1.h.a
        public final boolean a(int i6, int i7, int i8, int i9, int i10) {
            boolean q5;
            q5 = f.q(i6, i7, i8, i9, i10);
            return q5;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f10604a;

    /* renamed from: b  reason: collision with root package name */
    private final long f10605b;

    /* renamed from: c  reason: collision with root package name */
    private final y f10606c;

    /* renamed from: d  reason: collision with root package name */
    private final c1.a f10607d;

    /* renamed from: e  reason: collision with root package name */
    private final t f10608e;

    /* renamed from: f  reason: collision with root package name */
    private final u f10609f;

    /* renamed from: g  reason: collision with root package name */
    private final a0 f10610g;

    /* renamed from: h  reason: collision with root package name */
    private k f10611h;

    /* renamed from: i  reason: collision with root package name */
    private a0 f10612i;

    /* renamed from: j  reason: collision with root package name */
    private a0 f10613j;

    /* renamed from: k  reason: collision with root package name */
    private int f10614k;

    /* renamed from: l  reason: collision with root package name */
    private n1.a f10615l;

    /* renamed from: m  reason: collision with root package name */
    private long f10616m;

    /* renamed from: n  reason: collision with root package name */
    private long f10617n;

    /* renamed from: o  reason: collision with root package name */
    private long f10618o;

    /* renamed from: p  reason: collision with root package name */
    private int f10619p;

    /* renamed from: q  reason: collision with root package name */
    private g f10620q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10621r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f10622s;

    /* renamed from: t  reason: collision with root package name */
    private long f10623t;

    public f() {
        this(0);
    }

    private void f() {
        com.google.android.exoplayer2.util.a.i(this.f10612i);
        s0.j(this.f10611h);
    }

    private g i(j jVar) {
        long m5;
        long j6;
        g s5 = s(jVar);
        c r5 = r(this.f10615l, jVar.p());
        if (this.f10621r) {
            return new g.a();
        }
        if ((this.f10604a & 2) != 0) {
            if (r5 != null) {
                m5 = r5.j();
                j6 = r5.e();
            } else if (s5 != null) {
                m5 = s5.j();
                j6 = s5.e();
            } else {
                m5 = m(this.f10615l);
                j6 = -1;
            }
            s5 = new b(m5, jVar.p(), j6);
        } else if (r5 != null) {
            s5 = r5;
        } else if (s5 == null) {
            s5 = null;
        }
        return (s5 == null || !(s5.f() || (this.f10604a & 1) == 0)) ? l(jVar) : s5;
    }

    private long j(long j6) {
        return this.f10616m + ((j6 * 1000000) / this.f10607d.f3347d);
    }

    private g l(j jVar) {
        jVar.n(this.f10606c.c(), 0, 4);
        this.f10606c.M(0);
        this.f10607d.a(this.f10606c.k());
        return new a(jVar.a(), jVar.p(), this.f10607d);
    }

    private static long m(n1.a aVar) {
        if (aVar != null) {
            int h6 = aVar.h();
            for (int i6 = 0; i6 < h6; i6++) {
                a.b g6 = aVar.g(i6);
                if (g6 instanceof m) {
                    m mVar = (m) g6;
                    if (mVar.f13152a.equals("TLEN")) {
                        return p.a(Long.parseLong(mVar.f13164c));
                    }
                }
            }
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    private static int n(y yVar, int i6) {
        if (yVar.e() >= i6 + 4) {
            yVar.M(i6);
            int k6 = yVar.k();
            if (k6 == 1483304551 || k6 == 1231971951) {
                return k6;
            }
        }
        if (yVar.e() >= 40) {
            yVar.M(36);
            return yVar.k() == 1447187017 ? 1447187017 : 0;
        }
        return 0;
    }

    private static boolean o(int i6, long j6) {
        return ((long) (i6 & (-128000))) == (j6 & (-128000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c1.i[] p() {
        return new c1.i[]{new f()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean q(int i6, int i7, int i8, int i9, int i10) {
        return (i7 == 67 && i8 == 79 && i9 == 77 && (i10 == 77 || i6 == 2)) || (i7 == 77 && i8 == 76 && i9 == 76 && (i10 == 84 || i6 == 2));
    }

    private static c r(n1.a aVar, long j6) {
        if (aVar != null) {
            int h6 = aVar.h();
            for (int i6 = 0; i6 < h6; i6++) {
                a.b g6 = aVar.g(i6);
                if (g6 instanceof s1.k) {
                    return c.a(j6, (s1.k) g6, m(aVar));
                }
            }
            return null;
        }
        return null;
    }

    private g s(j jVar) {
        int i6;
        y yVar = new y(this.f10607d.f3346c);
        jVar.n(yVar.c(), 0, this.f10607d.f3346c);
        c1.a aVar = this.f10607d;
        int i7 = aVar.f3344a & 1;
        int i8 = aVar.f3348e;
        if (i7 != 0) {
            if (i8 != 1) {
                i6 = 36;
            }
            i6 = 21;
        } else {
            if (i8 == 1) {
                i6 = 13;
            }
            i6 = 21;
        }
        int n5 = n(yVar, i6);
        if (n5 != 1483304551 && n5 != 1231971951) {
            if (n5 != 1447187017) {
                jVar.g();
                return null;
            }
            h a6 = h.a(jVar.a(), jVar.p(), this.f10607d, yVar);
            jVar.h(this.f10607d.f3346c);
            return a6;
        }
        i a7 = i.a(jVar.a(), jVar.p(), this.f10607d, yVar);
        if (a7 != null && !this.f10608e.a()) {
            jVar.g();
            jVar.o(i6 + 141);
            jVar.n(this.f10606c.c(), 0, 3);
            this.f10606c.M(0);
            this.f10608e.d(this.f10606c.D());
        }
        jVar.h(this.f10607d.f3346c);
        return (a7 == null || a7.f() || n5 != 1231971951) ? a7 : l(jVar);
    }

    private boolean t(j jVar) {
        g gVar = this.f10620q;
        if (gVar != null) {
            long e6 = gVar.e();
            if (e6 != -1 && jVar.m() > e6 - 4) {
                return true;
            }
        }
        try {
            return !jVar.l(this.f10606c.c(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private int u(j jVar) {
        if (this.f10614k == 0) {
            try {
                w(jVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f10620q == null) {
            g i6 = i(jVar);
            this.f10620q = i6;
            this.f10611h.r(i6);
            this.f10613j.e(new s0.b().e0(this.f10607d.f3345b).W(_BufferKt.SEGMENTING_THRESHOLD).H(this.f10607d.f3348e).f0(this.f10607d.f3347d).M(this.f10608e.f3240a).N(this.f10608e.f3241b).X((this.f10604a & 4) != 0 ? null : this.f10615l).E());
            this.f10618o = jVar.p();
        } else if (this.f10618o != 0) {
            long p5 = jVar.p();
            long j6 = this.f10618o;
            if (p5 < j6) {
                jVar.h((int) (j6 - p5));
            }
        }
        return v(jVar);
    }

    private int v(j jVar) {
        c1.a aVar;
        if (this.f10619p == 0) {
            jVar.g();
            if (t(jVar)) {
                return -1;
            }
            this.f10606c.M(0);
            int k6 = this.f10606c.k();
            if (!o(k6, this.f10614k) || c1.j(k6) == -1) {
                jVar.h(1);
                this.f10614k = 0;
                return 0;
            }
            this.f10607d.a(k6);
            if (this.f10616m == -9223372036854775807L) {
                this.f10616m = this.f10620q.b(jVar.p());
                if (this.f10605b != -9223372036854775807L) {
                    this.f10616m += this.f10605b - this.f10620q.b(0L);
                }
            }
            this.f10619p = this.f10607d.f3346c;
            g gVar = this.f10620q;
            if (gVar instanceof b) {
                b bVar = (b) gVar;
                bVar.c(j(this.f10617n + aVar.f3350g), jVar.p() + this.f10607d.f3346c);
                if (this.f10622s && bVar.a(this.f10623t)) {
                    this.f10622s = false;
                    this.f10613j = this.f10612i;
                }
            }
        }
        int b6 = this.f10613j.b(jVar, this.f10619p, true);
        if (b6 == -1) {
            return -1;
        }
        int i6 = this.f10619p - b6;
        this.f10619p = i6;
        if (i6 > 0) {
            return 0;
        }
        this.f10613j.d(j(this.f10617n), 1, this.f10607d.f3346c, 0, null);
        this.f10617n += this.f10607d.f3350g;
        this.f10619p = 0;
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x009d, code lost:
        if (r13 == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009f, code lost:
        r12.h(r2 + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
        r12.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a7, code lost:
        r11.f10614k = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a9, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean w(j jVar, boolean z5) {
        int i6;
        int i7;
        int j6;
        int i8 = z5 ? 32768 : 131072;
        jVar.g();
        if (jVar.p() == 0) {
            n1.a a6 = this.f10609f.a(jVar, (this.f10604a & 4) == 0 ? null : f10603v);
            this.f10615l = a6;
            if (a6 != null) {
                this.f10608e.c(a6);
            }
            i7 = (int) jVar.m();
            if (!z5) {
                jVar.h(i7);
            }
            i6 = 0;
        } else {
            i6 = 0;
            i7 = 0;
        }
        int i9 = 0;
        int i10 = 0;
        while (true) {
            if (!t(jVar)) {
                this.f10606c.M(0);
                int k6 = this.f10606c.k();
                if ((i6 == 0 || o(k6, i6)) && (j6 = c1.j(k6)) != -1) {
                    i9++;
                    if (i9 != 1) {
                        if (i9 == 4) {
                            break;
                        }
                    } else {
                        this.f10607d.a(k6);
                        i6 = k6;
                    }
                    jVar.o(j6 - 4);
                } else {
                    int i11 = i10 + 1;
                    if (i10 == i8) {
                        if (z5) {
                            return false;
                        }
                        throw new f1("Searched too many bytes.");
                    }
                    if (z5) {
                        jVar.g();
                        jVar.o(i7 + i11);
                    } else {
                        jVar.h(1);
                    }
                    i10 = i11;
                    i6 = 0;
                    i9 = 0;
                }
            } else if (i9 <= 0) {
                throw new EOFException();
            }
        }
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(k kVar) {
        this.f10611h = kVar;
        a0 e6 = kVar.e(0, 1);
        this.f10612i = e6;
        this.f10613j = e6;
        this.f10611h.g();
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        this.f10614k = 0;
        this.f10616m = -9223372036854775807L;
        this.f10617n = 0L;
        this.f10619p = 0;
        this.f10623t = j7;
        g gVar = this.f10620q;
        if (!(gVar instanceof b) || ((b) gVar).a(j7)) {
            return;
        }
        this.f10622s = true;
        this.f10613j = this.f10610g;
    }

    @Override // c1.i
    public int g(j jVar, w wVar) {
        f();
        int u5 = u(jVar);
        if (u5 == -1 && (this.f10620q instanceof b)) {
            long j6 = j(this.f10617n);
            if (this.f10620q.j() != j6) {
                ((b) this.f10620q).d(j6);
                this.f10611h.r(this.f10620q);
            }
        }
        return u5;
    }

    @Override // c1.i
    public boolean h(j jVar) {
        return w(jVar, true);
    }

    public void k() {
        this.f10621r = true;
    }

    public f(int i6) {
        this(i6, -9223372036854775807L);
    }

    public f(int i6, long j6) {
        this.f10604a = i6;
        this.f10605b = j6;
        this.f10606c = new y(10);
        this.f10607d = new c1.a();
        this.f10608e = new t();
        this.f10616m = -9223372036854775807L;
        this.f10609f = new u();
        c1.h hVar = new c1.h();
        this.f10610g = hVar;
        this.f10613j = hVar;
    }
}
