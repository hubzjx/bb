package w1;

import android.net.Uri;
import android.os.Handler;
import c1.x;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.s1;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import q2.c0;
import q2.d0;
import q2.o;
import w1.e0;
import w1.o;
import w1.q0;
import w1.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n0 implements t, c1.k, d0.b, d0.f, q0.b {
    private static final Map O = K();
    private static final com.google.android.exoplayer2.s0 P = new s0.b().S("icy").e0("application/x-icy").E();
    private c1.x A;
    private boolean C;
    private boolean E;
    private boolean F;
    private int G;
    private long I;
    private boolean K;
    private int L;
    private boolean M;
    private boolean N;

    /* renamed from: a  reason: collision with root package name */
    private final Uri f13884a;

    /* renamed from: b  reason: collision with root package name */
    private final q2.l f13885b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.v f13886c;

    /* renamed from: d  reason: collision with root package name */
    private final q2.c0 f13887d;

    /* renamed from: e  reason: collision with root package name */
    private final e0.a f13888e;

    /* renamed from: f  reason: collision with root package name */
    private final t.a f13889f;

    /* renamed from: g  reason: collision with root package name */
    private final b f13890g;

    /* renamed from: h  reason: collision with root package name */
    private final q2.b f13891h;

    /* renamed from: k  reason: collision with root package name */
    private final String f13892k;

    /* renamed from: l  reason: collision with root package name */
    private final long f13893l;

    /* renamed from: n  reason: collision with root package name */
    private final j0 f13895n;

    /* renamed from: s  reason: collision with root package name */
    private t.a f13900s;

    /* renamed from: t  reason: collision with root package name */
    private r1.b f13901t;

    /* renamed from: w  reason: collision with root package name */
    private boolean f13904w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f13905x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f13906y;

    /* renamed from: z  reason: collision with root package name */
    private e f13907z;

    /* renamed from: m  reason: collision with root package name */
    private final q2.d0 f13894m = new q2.d0("Loader:ProgressiveMediaPeriod");

    /* renamed from: o  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.f f13896o = new com.google.android.exoplayer2.util.f();

    /* renamed from: p  reason: collision with root package name */
    private final Runnable f13897p = new Runnable() { // from class: w1.k0
        @Override // java.lang.Runnable
        public final void run() {
            n0.this.S();
        }
    };

    /* renamed from: q  reason: collision with root package name */
    private final Runnable f13898q = new Runnable() { // from class: w1.l0
        @Override // java.lang.Runnable
        public final void run() {
            n0.this.Q();
        }
    };

    /* renamed from: r  reason: collision with root package name */
    private final Handler f13899r = com.google.android.exoplayer2.util.s0.x();

    /* renamed from: v  reason: collision with root package name */
    private d[] f13903v = new d[0];

    /* renamed from: u  reason: collision with root package name */
    private q0[] f13902u = new q0[0];
    private long J = -9223372036854775807L;
    private long H = -1;
    private long B = -9223372036854775807L;
    private int D = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a implements d0.e, o.a {

        /* renamed from: b  reason: collision with root package name */
        private final Uri f13909b;

        /* renamed from: c  reason: collision with root package name */
        private final q2.g0 f13910c;

        /* renamed from: d  reason: collision with root package name */
        private final j0 f13911d;

        /* renamed from: e  reason: collision with root package name */
        private final c1.k f13912e;

        /* renamed from: f  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.f f13913f;

        /* renamed from: h  reason: collision with root package name */
        private volatile boolean f13915h;

        /* renamed from: j  reason: collision with root package name */
        private long f13917j;

        /* renamed from: m  reason: collision with root package name */
        private c1.a0 f13920m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f13921n;

        /* renamed from: g  reason: collision with root package name */
        private final c1.w f13914g = new c1.w();

        /* renamed from: i  reason: collision with root package name */
        private boolean f13916i = true;

        /* renamed from: l  reason: collision with root package name */
        private long f13919l = -1;

        /* renamed from: a  reason: collision with root package name */
        private final long f13908a = p.a();

        /* renamed from: k  reason: collision with root package name */
        private q2.o f13918k = j(0);

        public a(Uri uri, q2.l lVar, j0 j0Var, c1.k kVar, com.google.android.exoplayer2.util.f fVar) {
            this.f13909b = uri;
            this.f13910c = new q2.g0(lVar);
            this.f13911d = j0Var;
            this.f13912e = kVar;
            this.f13913f = fVar;
        }

        private q2.o j(long j6) {
            return new o.b().i(this.f13909b).h(j6).f(n0.this.f13892k).b(6).e(n0.O).a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(long j6, long j7) {
            this.f13914g.f3247a = j6;
            this.f13917j = j7;
            this.f13916i = true;
            this.f13921n = false;
        }

        @Override // q2.d0.e
        public void a() {
            int i6 = 0;
            while (i6 == 0 && !this.f13915h) {
                try {
                    long j6 = this.f13914g.f3247a;
                    q2.o j7 = j(j6);
                    this.f13918k = j7;
                    long b6 = this.f13910c.b(j7);
                    this.f13919l = b6;
                    if (b6 != -1) {
                        this.f13919l = b6 + j6;
                    }
                    n0.this.f13901t = r1.b.e(this.f13910c.f());
                    q2.h hVar = this.f13910c;
                    if (n0.this.f13901t != null && n0.this.f13901t.f12924f != -1) {
                        hVar = new o(this.f13910c, n0.this.f13901t.f12924f, this);
                        c1.a0 N = n0.this.N();
                        this.f13920m = N;
                        N.e(n0.P);
                    }
                    long j8 = j6;
                    this.f13911d.c(hVar, this.f13909b, this.f13910c.f(), j6, this.f13919l, this.f13912e);
                    if (n0.this.f13901t != null) {
                        this.f13911d.f();
                    }
                    if (this.f13916i) {
                        this.f13911d.d(j8, this.f13917j);
                        this.f13916i = false;
                    }
                    while (true) {
                        long j9 = j8;
                        while (i6 == 0 && !this.f13915h) {
                            try {
                                this.f13913f.a();
                                i6 = this.f13911d.b(this.f13914g);
                                j8 = this.f13911d.e();
                                if (j8 > n0.this.f13893l + j9) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.f13913f.b();
                        n0.this.f13899r.post(n0.this.f13898q);
                    }
                    if (i6 == 1) {
                        i6 = 0;
                    } else if (this.f13911d.e() != -1) {
                        this.f13914g.f3247a = this.f13911d.e();
                    }
                    com.google.android.exoplayer2.util.s0.o(this.f13910c);
                } catch (Throwable th) {
                    if (i6 != 1 && this.f13911d.e() != -1) {
                        this.f13914g.f3247a = this.f13911d.e();
                    }
                    com.google.android.exoplayer2.util.s0.o(this.f13910c);
                    throw th;
                }
            }
        }

        @Override // w1.o.a
        public void b(com.google.android.exoplayer2.util.y yVar) {
            long max = !this.f13921n ? this.f13917j : Math.max(n0.this.M(), this.f13917j);
            int a6 = yVar.a();
            c1.a0 a0Var = (c1.a0) com.google.android.exoplayer2.util.a.e(this.f13920m);
            a0Var.a(yVar, a6);
            a0Var.d(max, 1, a6, 0, null);
            this.f13921n = true;
        }

        @Override // q2.d0.e
        public void c() {
            this.f13915h = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void q(long j6, boolean z5, boolean z6);
    }

    /* loaded from: classes.dex */
    private final class c implements r0 {

        /* renamed from: a  reason: collision with root package name */
        private final int f13923a;

        public c(int i6) {
            this.f13923a = i6;
        }

        @Override // w1.r0
        public void b() {
            n0.this.W(this.f13923a);
        }

        @Override // w1.r0
        public int e(com.google.android.exoplayer2.t0 t0Var, com.google.android.exoplayer2.decoder.j jVar, boolean z5) {
            return n0.this.b0(this.f13923a, t0Var, jVar, z5);
        }

        @Override // w1.r0
        public boolean g() {
            return n0.this.P(this.f13923a);
        }

        @Override // w1.r0
        public int r(long j6) {
            return n0.this.f0(this.f13923a, j6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f13925a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f13926b;

        public d(int i6, boolean z5) {
            this.f13925a = i6;
            this.f13926b = z5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f13925a == dVar.f13925a && this.f13926b == dVar.f13926b;
        }

        public int hashCode() {
            return (this.f13925a * 31) + (this.f13926b ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final y0 f13927a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f13928b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f13929c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean[] f13930d;

        public e(y0 y0Var, boolean[] zArr) {
            this.f13927a = y0Var;
            this.f13928b = zArr;
            int i6 = y0Var.f14101a;
            this.f13929c = new boolean[i6];
            this.f13930d = new boolean[i6];
        }
    }

    public n0(Uri uri, q2.l lVar, c1.o oVar, com.google.android.exoplayer2.drm.v vVar, t.a aVar, q2.c0 c0Var, e0.a aVar2, b bVar, q2.b bVar2, String str, int i6) {
        this.f13884a = uri;
        this.f13885b = lVar;
        this.f13886c = vVar;
        this.f13889f = aVar;
        this.f13887d = c0Var;
        this.f13888e = aVar2;
        this.f13890g = bVar;
        this.f13891h = bVar2;
        this.f13892k = str;
        this.f13893l = i6;
        this.f13895n = new w1.c(oVar);
    }

    private void H() {
        com.google.android.exoplayer2.util.a.g(this.f13905x);
        com.google.android.exoplayer2.util.a.e(this.f13907z);
        com.google.android.exoplayer2.util.a.e(this.A);
    }

    private boolean I(a aVar, int i6) {
        c1.x xVar;
        if (this.H != -1 || ((xVar = this.A) != null && xVar.j() != -9223372036854775807L)) {
            this.L = i6;
            return true;
        }
        if (this.f13905x && !h0()) {
            this.K = true;
            return false;
        }
        this.F = this.f13905x;
        this.I = 0L;
        this.L = 0;
        for (q0 q0Var : this.f13902u) {
            q0Var.R();
        }
        aVar.k(0L, 0L);
        return true;
    }

    private void J(a aVar) {
        if (this.H == -1) {
            this.H = aVar.f13919l;
        }
    }

    private static Map K() {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(hashMap);
    }

    private int L() {
        int i6 = 0;
        for (q0 q0Var : this.f13902u) {
            i6 += q0Var.D();
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long M() {
        long j6 = Long.MIN_VALUE;
        for (q0 q0Var : this.f13902u) {
            j6 = Math.max(j6, q0Var.w());
        }
        return j6;
    }

    private boolean O() {
        return this.J != -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        if (this.N) {
            return;
        }
        ((t.a) com.google.android.exoplayer2.util.a.e(this.f13900s)).j(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        if (this.N || this.f13905x || !this.f13904w || this.A == null) {
            return;
        }
        for (q0 q0Var : this.f13902u) {
            if (q0Var.C() == null) {
                return;
            }
        }
        this.f13896o.b();
        int length = this.f13902u.length;
        x0[] x0VarArr = new x0[length];
        boolean[] zArr = new boolean[length];
        for (int i6 = 0; i6 < length; i6++) {
            com.google.android.exoplayer2.s0 s0Var = (com.google.android.exoplayer2.s0) com.google.android.exoplayer2.util.a.e(this.f13902u[i6].C());
            String str = s0Var.f4056n;
            boolean n5 = com.google.android.exoplayer2.util.q.n(str);
            boolean z5 = n5 || com.google.android.exoplayer2.util.q.q(str);
            zArr[i6] = z5;
            this.f13906y = z5 | this.f13906y;
            r1.b bVar = this.f13901t;
            if (bVar != null) {
                if (n5 || this.f13903v[i6].f13926b) {
                    n1.a aVar = s0Var.f4054l;
                    s0Var = s0Var.e().X(aVar == null ? new n1.a(bVar) : aVar.e(bVar)).E();
                }
                if (n5 && s0Var.f4050f == -1 && s0Var.f4051g == -1 && bVar.f12919a != -1) {
                    s0Var = s0Var.e().G(bVar.f12919a).E();
                }
            }
            x0VarArr[i6] = new x0(s0Var.f(this.f13886c.d(s0Var)));
        }
        this.f13907z = new e(new y0(x0VarArr), zArr);
        this.f13905x = true;
        ((t.a) com.google.android.exoplayer2.util.a.e(this.f13900s)).g(this);
    }

    private void T(int i6) {
        H();
        e eVar = this.f13907z;
        boolean[] zArr = eVar.f13930d;
        if (zArr[i6]) {
            return;
        }
        com.google.android.exoplayer2.s0 e6 = eVar.f13927a.e(i6).e(0);
        this.f13888e.i(com.google.android.exoplayer2.util.q.j(e6.f4056n), e6, 0, null, this.I);
        zArr[i6] = true;
    }

    private void U(int i6) {
        H();
        boolean[] zArr = this.f13907z.f13928b;
        if (this.K && zArr[i6]) {
            if (this.f13902u[i6].H(false)) {
                return;
            }
            this.J = 0L;
            this.K = false;
            this.F = true;
            this.I = 0L;
            this.L = 0;
            for (q0 q0Var : this.f13902u) {
                q0Var.R();
            }
            ((t.a) com.google.android.exoplayer2.util.a.e(this.f13900s)).j(this);
        }
    }

    private c1.a0 a0(d dVar) {
        int length = this.f13902u.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (dVar.equals(this.f13903v[i6])) {
                return this.f13902u[i6];
            }
        }
        q0 q0Var = new q0(this.f13891h, this.f13899r.getLooper(), this.f13886c, this.f13889f);
        q0Var.Z(this);
        int i7 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.f13903v, i7);
        dVarArr[length] = dVar;
        this.f13903v = (d[]) com.google.android.exoplayer2.util.s0.k(dVarArr);
        q0[] q0VarArr = (q0[]) Arrays.copyOf(this.f13902u, i7);
        q0VarArr[length] = q0Var;
        this.f13902u = (q0[]) com.google.android.exoplayer2.util.s0.k(q0VarArr);
        return q0Var;
    }

    private boolean d0(boolean[] zArr, long j6) {
        int length = this.f13902u.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (!this.f13902u[i6].V(j6, false) && (zArr[i6] || !this.f13906y)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public void R(c1.x xVar) {
        this.A = this.f13901t == null ? xVar : new x.b(-9223372036854775807L);
        this.B = xVar.j();
        boolean z5 = this.H == -1 && xVar.j() == -9223372036854775807L;
        this.C = z5;
        this.D = z5 ? 7 : 1;
        this.f13890g.q(this.B, xVar.f(), this.C);
        if (this.f13905x) {
            return;
        }
        S();
    }

    private void g0() {
        a aVar = new a(this.f13884a, this.f13885b, this.f13895n, this, this.f13896o);
        if (this.f13905x) {
            com.google.android.exoplayer2.util.a.g(O());
            long j6 = this.B;
            if (j6 != -9223372036854775807L && this.J > j6) {
                this.M = true;
                this.J = -9223372036854775807L;
                return;
            }
            aVar.k(((c1.x) com.google.android.exoplayer2.util.a.e(this.A)).i(this.J).f3248a.f3254b, this.J);
            for (q0 q0Var : this.f13902u) {
                q0Var.X(this.J);
            }
            this.J = -9223372036854775807L;
        }
        this.L = L();
        this.f13888e.A(new p(aVar.f13908a, aVar.f13918k, this.f13894m.n(aVar, this, this.f13887d.d(this.D))), 1, -1, null, 0, null, aVar.f13917j, this.B);
    }

    private boolean h0() {
        return this.F || O();
    }

    c1.a0 N() {
        return a0(new d(0, true));
    }

    boolean P(int i6) {
        return !h0() && this.f13902u[i6].H(this.M);
    }

    void V() {
        this.f13894m.k(this.f13887d.d(this.D));
    }

    void W(int i6) {
        this.f13902u[i6].J();
        V();
    }

    @Override // q2.d0.b
    /* renamed from: X */
    public void p(a aVar, long j6, long j7, boolean z5) {
        q2.g0 g0Var = aVar.f13910c;
        p pVar = new p(aVar.f13908a, aVar.f13918k, g0Var.r(), g0Var.s(), j6, j7, g0Var.q());
        this.f13887d.a(aVar.f13908a);
        this.f13888e.r(pVar, 1, -1, null, 0, null, aVar.f13917j, this.B);
        if (z5) {
            return;
        }
        J(aVar);
        for (q0 q0Var : this.f13902u) {
            q0Var.R();
        }
        if (this.G > 0) {
            ((t.a) com.google.android.exoplayer2.util.a.e(this.f13900s)).j(this);
        }
    }

    @Override // q2.d0.b
    /* renamed from: Y */
    public void m(a aVar, long j6, long j7) {
        c1.x xVar;
        if (this.B == -9223372036854775807L && (xVar = this.A) != null) {
            boolean f6 = xVar.f();
            long M = M();
            long j8 = M == Long.MIN_VALUE ? 0L : M + 10000;
            this.B = j8;
            this.f13890g.q(j8, f6, this.C);
        }
        q2.g0 g0Var = aVar.f13910c;
        p pVar = new p(aVar.f13908a, aVar.f13918k, g0Var.r(), g0Var.s(), j6, j7, g0Var.q());
        this.f13887d.a(aVar.f13908a);
        this.f13888e.u(pVar, 1, -1, null, 0, null, aVar.f13917j, this.B);
        J(aVar);
        this.M = true;
        ((t.a) com.google.android.exoplayer2.util.a.e(this.f13900s)).j(this);
    }

    @Override // q2.d0.b
    /* renamed from: Z */
    public d0.c k(a aVar, long j6, long j7, IOException iOException, int i6) {
        boolean z5;
        a aVar2;
        d0.c h6;
        J(aVar);
        q2.g0 g0Var = aVar.f13910c;
        p pVar = new p(aVar.f13908a, aVar.f13918k, g0Var.r(), g0Var.s(), j6, j7, g0Var.q());
        long b6 = this.f13887d.b(new c0.a(pVar, new s(1, -1, null, 0, null, com.google.android.exoplayer2.p.b(aVar.f13917j), com.google.android.exoplayer2.p.b(this.B)), iOException, i6));
        if (b6 == -9223372036854775807L) {
            h6 = q2.d0.f12729g;
        } else {
            int L = L();
            if (L > this.L) {
                aVar2 = aVar;
                z5 = true;
            } else {
                z5 = false;
                aVar2 = aVar;
            }
            h6 = I(aVar2, L) ? q2.d0.h(z5, b6) : q2.d0.f12728f;
        }
        boolean z6 = !h6.c();
        this.f13888e.w(pVar, 1, -1, null, 0, null, aVar.f13917j, this.B, iOException, z6);
        if (z6) {
            this.f13887d.a(aVar.f13908a);
        }
        return h6;
    }

    @Override // w1.t, w1.s0
    public boolean a() {
        return this.f13894m.j() && this.f13896o.c();
    }

    @Override // w1.q0.b
    public void b(com.google.android.exoplayer2.s0 s0Var) {
        this.f13899r.post(this.f13897p);
    }

    int b0(int i6, com.google.android.exoplayer2.t0 t0Var, com.google.android.exoplayer2.decoder.j jVar, boolean z5) {
        if (h0()) {
            return -3;
        }
        T(i6);
        int N = this.f13902u[i6].N(t0Var, jVar, z5, this.M);
        if (N == -3) {
            U(i6);
        }
        return N;
    }

    @Override // w1.t
    public long c(long j6, s1 s1Var) {
        H();
        if (this.A.f()) {
            x.a i6 = this.A.i(j6);
            return s1Var.a(j6, i6.f3248a.f3253a, i6.f3249b.f3253a);
        }
        return 0L;
    }

    public void c0() {
        if (this.f13905x) {
            for (q0 q0Var : this.f13902u) {
                q0Var.M();
            }
        }
        this.f13894m.m(this);
        this.f13899r.removeCallbacksAndMessages(null);
        this.f13900s = null;
        this.N = true;
    }

    @Override // w1.t, w1.s0
    public long d() {
        if (this.G == 0) {
            return Long.MIN_VALUE;
        }
        return f();
    }

    @Override // c1.k
    public c1.a0 e(int i6, int i7) {
        return a0(new d(i6, false));
    }

    @Override // w1.t, w1.s0
    public long f() {
        long j6;
        H();
        boolean[] zArr = this.f13907z.f13928b;
        if (this.M) {
            return Long.MIN_VALUE;
        }
        if (O()) {
            return this.J;
        }
        if (this.f13906y) {
            int length = this.f13902u.length;
            j6 = Long.MAX_VALUE;
            for (int i6 = 0; i6 < length; i6++) {
                if (zArr[i6] && !this.f13902u[i6].G()) {
                    j6 = Math.min(j6, this.f13902u[i6].w());
                }
            }
        } else {
            j6 = Long.MAX_VALUE;
        }
        if (j6 == Long.MAX_VALUE) {
            j6 = M();
        }
        return j6 == Long.MIN_VALUE ? this.I : j6;
    }

    int f0(int i6, long j6) {
        if (h0()) {
            return 0;
        }
        T(i6);
        q0 q0Var = this.f13902u[i6];
        int B = q0Var.B(j6, this.M);
        q0Var.a0(B);
        if (B == 0) {
            U(i6);
        }
        return B;
    }

    @Override // c1.k
    public void g() {
        this.f13904w = true;
        this.f13899r.post(this.f13897p);
    }

    @Override // w1.t, w1.s0
    public boolean h(long j6) {
        if (this.M || this.f13894m.i() || this.K) {
            return false;
        }
        if (this.f13905x && this.G == 0) {
            return false;
        }
        boolean d6 = this.f13896o.d();
        if (this.f13894m.j()) {
            return d6;
        }
        g0();
        return true;
    }

    @Override // w1.t, w1.s0
    public void i(long j6) {
    }

    @Override // q2.d0.f
    public void j() {
        for (q0 q0Var : this.f13902u) {
            q0Var.P();
        }
        this.f13895n.a();
    }

    @Override // w1.t
    public long l() {
        if (this.F) {
            if (this.M || L() > this.L) {
                this.F = false;
                return this.I;
            }
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    @Override // w1.t
    public y0 n() {
        H();
        return this.f13907z.f13927a;
    }

    @Override // w1.t
    public void o(t.a aVar, long j6) {
        this.f13900s = aVar;
        this.f13896o.d();
        g0();
    }

    @Override // w1.t
    public long q(o2.j[] jVarArr, boolean[] zArr, r0[] r0VarArr, boolean[] zArr2, long j6) {
        o2.j jVar;
        H();
        e eVar = this.f13907z;
        y0 y0Var = eVar.f13927a;
        boolean[] zArr3 = eVar.f13929c;
        int i6 = this.G;
        int i7 = 0;
        for (int i8 = 0; i8 < jVarArr.length; i8++) {
            r0 r0Var = r0VarArr[i8];
            if (r0Var != null && (jVarArr[i8] == null || !zArr[i8])) {
                int i9 = ((c) r0Var).f13923a;
                com.google.android.exoplayer2.util.a.g(zArr3[i9]);
                this.G--;
                zArr3[i9] = false;
                r0VarArr[i8] = null;
            }
        }
        boolean z5 = !this.E ? j6 == 0 : i6 != 0;
        for (int i10 = 0; i10 < jVarArr.length; i10++) {
            if (r0VarArr[i10] == null && (jVar = jVarArr[i10]) != null) {
                com.google.android.exoplayer2.util.a.g(jVar.length() == 1);
                com.google.android.exoplayer2.util.a.g(jVar.f(0) == 0);
                int f6 = y0Var.f(jVar.k());
                com.google.android.exoplayer2.util.a.g(!zArr3[f6]);
                this.G++;
                zArr3[f6] = true;
                r0VarArr[i10] = new c(f6);
                zArr2[i10] = true;
                if (!z5) {
                    q0 q0Var = this.f13902u[f6];
                    z5 = (q0Var.V(j6, true) || q0Var.z() == 0) ? false : true;
                }
            }
        }
        if (this.G == 0) {
            this.K = false;
            this.F = false;
            if (this.f13894m.j()) {
                q0[] q0VarArr = this.f13902u;
                int length = q0VarArr.length;
                while (i7 < length) {
                    q0VarArr[i7].o();
                    i7++;
                }
                this.f13894m.f();
            } else {
                q0[] q0VarArr2 = this.f13902u;
                int length2 = q0VarArr2.length;
                while (i7 < length2) {
                    q0VarArr2[i7].R();
                    i7++;
                }
            }
        } else if (z5) {
            j6 = u(j6);
            while (i7 < r0VarArr.length) {
                if (r0VarArr[i7] != null) {
                    zArr2[i7] = true;
                }
                i7++;
            }
        }
        this.E = true;
        return j6;
    }

    @Override // c1.k
    public void r(final c1.x xVar) {
        this.f13899r.post(new Runnable() { // from class: w1.m0
            @Override // java.lang.Runnable
            public final void run() {
                n0.this.R(xVar);
            }
        });
    }

    @Override // w1.t
    public void s() {
        V();
        if (this.M && !this.f13905x) {
            throw new f1("Loading finished before preparation is complete.");
        }
    }

    @Override // w1.t
    public void t(long j6, boolean z5) {
        H();
        if (O()) {
            return;
        }
        boolean[] zArr = this.f13907z.f13929c;
        int length = this.f13902u.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f13902u[i6].n(j6, z5, zArr[i6]);
        }
    }

    @Override // w1.t
    public long u(long j6) {
        H();
        boolean[] zArr = this.f13907z.f13928b;
        if (!this.A.f()) {
            j6 = 0;
        }
        this.F = false;
        this.I = j6;
        if (O()) {
            this.J = j6;
            return j6;
        } else if (this.D == 7 || !d0(zArr, j6)) {
            this.K = false;
            this.J = j6;
            this.M = false;
            if (this.f13894m.j()) {
                this.f13894m.f();
            } else {
                this.f13894m.g();
                for (q0 q0Var : this.f13902u) {
                    q0Var.R();
                }
            }
            return j6;
        } else {
            return j6;
        }
    }
}
