package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.e1;
import com.google.android.exoplayer2.k1;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.y1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import o2.m;
import w1.t;
import w1.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q0 implements Handler.Callback, t.a, m.a, e1.d, r.a, k1.a {
    private boolean A;
    private boolean B;
    private boolean C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    private h J;
    private long K;
    private int L;
    private boolean M;
    private long N;
    private boolean O = true;

    /* renamed from: a  reason: collision with root package name */
    private final n1[] f3976a;

    /* renamed from: b  reason: collision with root package name */
    private final p1[] f3977b;

    /* renamed from: c  reason: collision with root package name */
    private final o2.m f3978c;

    /* renamed from: d  reason: collision with root package name */
    private final o2.n f3979d;

    /* renamed from: e  reason: collision with root package name */
    private final v0 f3980e;

    /* renamed from: f  reason: collision with root package name */
    private final q2.e f3981f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.l f3982g;

    /* renamed from: h  reason: collision with root package name */
    private final HandlerThread f3983h;

    /* renamed from: k  reason: collision with root package name */
    private final Looper f3984k;

    /* renamed from: l  reason: collision with root package name */
    private final y1.c f3985l;

    /* renamed from: m  reason: collision with root package name */
    private final y1.b f3986m;

    /* renamed from: n  reason: collision with root package name */
    private final long f3987n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f3988o;

    /* renamed from: p  reason: collision with root package name */
    private final r f3989p;

    /* renamed from: q  reason: collision with root package name */
    private final ArrayList f3990q;

    /* renamed from: r  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.c f3991r;

    /* renamed from: s  reason: collision with root package name */
    private final f f3992s;

    /* renamed from: t  reason: collision with root package name */
    private final b1 f3993t;

    /* renamed from: u  reason: collision with root package name */
    private final e1 f3994u;

    /* renamed from: v  reason: collision with root package name */
    private s1 f3995v;

    /* renamed from: w  reason: collision with root package name */
    private g1 f3996w;

    /* renamed from: x  reason: collision with root package name */
    private e f3997x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f3998y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f3999z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements n1.a {
        a() {
        }

        @Override // com.google.android.exoplayer2.n1.a
        public void a() {
            q0.this.f3982g.b(2);
        }

        @Override // com.google.android.exoplayer2.n1.a
        public void b(long j6) {
            if (j6 >= 2000) {
                q0.this.G = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final List f4001a;

        /* renamed from: b  reason: collision with root package name */
        private final w1.t0 f4002b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4003c;

        /* renamed from: d  reason: collision with root package name */
        private final long f4004d;

        private b(List list, w1.t0 t0Var, int i6, long j6) {
            this.f4001a = list;
            this.f4002b = t0Var;
            this.f4003c = i6;
            this.f4004d = j6;
        }

        /* synthetic */ b(List list, w1.t0 t0Var, int i6, long j6, a aVar) {
            this(list, t0Var, i6, j6);
        }
    }

    /* loaded from: classes.dex */
    private static class c {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        public final k1 f4005a;

        /* renamed from: b  reason: collision with root package name */
        public int f4006b;

        /* renamed from: c  reason: collision with root package name */
        public long f4007c;

        /* renamed from: d  reason: collision with root package name */
        public Object f4008d;

        public d(k1 k1Var) {
            this.f4005a = k1Var;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(d dVar) {
            Object obj = this.f4008d;
            if ((obj == null) != (dVar.f4008d == null)) {
                return obj != null ? -1 : 1;
            } else if (obj == null) {
                return 0;
            } else {
                int i6 = this.f4006b - dVar.f4006b;
                return i6 != 0 ? i6 : com.google.android.exoplayer2.util.s0.p(this.f4007c, dVar.f4007c);
            }
        }

        public void b(int i6, long j6, Object obj) {
            this.f4006b = i6;
            this.f4007c = j6;
            this.f4008d = obj;
        }
    }

    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        private boolean f4009a;

        /* renamed from: b  reason: collision with root package name */
        public g1 f4010b;

        /* renamed from: c  reason: collision with root package name */
        public int f4011c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4012d;

        /* renamed from: e  reason: collision with root package name */
        public int f4013e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4014f;

        /* renamed from: g  reason: collision with root package name */
        public int f4015g;

        public e(g1 g1Var) {
            this.f4010b = g1Var;
        }

        public void b(int i6) {
            this.f4009a |= i6 > 0;
            this.f4011c += i6;
        }

        public void c(int i6) {
            this.f4009a = true;
            this.f4014f = true;
            this.f4015g = i6;
        }

        public void d(g1 g1Var) {
            this.f4009a |= this.f4010b != g1Var;
            this.f4010b = g1Var;
        }

        public void e(int i6) {
            if (this.f4012d && this.f4013e != 4) {
                com.google.android.exoplayer2.util.a.a(i6 == 4);
                return;
            }
            this.f4009a = true;
            this.f4012d = true;
            this.f4013e = i6;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(e eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final v.a f4016a;

        /* renamed from: b  reason: collision with root package name */
        public final long f4017b;

        /* renamed from: c  reason: collision with root package name */
        public final long f4018c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f4019d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f4020e;

        public g(v.a aVar, long j6, long j7, boolean z5, boolean z6) {
            this.f4016a = aVar;
            this.f4017b = j6;
            this.f4018c = j7;
            this.f4019d = z5;
            this.f4020e = z6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class h {

        /* renamed from: a  reason: collision with root package name */
        public final y1 f4021a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4022b;

        /* renamed from: c  reason: collision with root package name */
        public final long f4023c;

        public h(y1 y1Var, int i6, long j6) {
            this.f4021a = y1Var;
            this.f4022b = i6;
            this.f4023c = j6;
        }
    }

    public q0(n1[] n1VarArr, o2.m mVar, o2.n nVar, v0 v0Var, q2.e eVar, int i6, boolean z5, y0.a aVar, s1 s1Var, boolean z6, Looper looper, com.google.android.exoplayer2.util.c cVar, f fVar) {
        this.f3992s = fVar;
        this.f3976a = n1VarArr;
        this.f3978c = mVar;
        this.f3979d = nVar;
        this.f3980e = v0Var;
        this.f3981f = eVar;
        this.D = i6;
        this.E = z5;
        this.f3995v = s1Var;
        this.f3999z = z6;
        this.f3991r = cVar;
        this.f3987n = v0Var.j();
        this.f3988o = v0Var.d();
        g1 j6 = g1.j(nVar);
        this.f3996w = j6;
        this.f3997x = new e(j6);
        this.f3977b = new p1[n1VarArr.length];
        for (int i7 = 0; i7 < n1VarArr.length; i7++) {
            n1VarArr[i7].j(i7);
            this.f3977b[i7] = n1VarArr[i7].y();
        }
        this.f3989p = new r(this, cVar);
        this.f3990q = new ArrayList();
        this.f3985l = new y1.c();
        this.f3986m = new y1.b();
        mVar.b(this, eVar);
        this.M = true;
        Handler handler = new Handler(looper);
        this.f3993t = new b1(aVar, handler);
        this.f3994u = new e1(this, aVar, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f3983h = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f3984k = looper2;
        this.f3982g = cVar.b(looper2, this);
    }

    private long A(long j6) {
        y0 j7 = this.f3993t.j();
        if (j7 == null) {
            return 0L;
        }
        return Math.max(0L, j6 - j7.y(this.K));
    }

    private void A0() {
        n1[] n1VarArr;
        for (n1 n1Var : this.f3976a) {
            if (n1Var.q() != null) {
                n1Var.s();
            }
        }
    }

    private void B(w1.t tVar) {
        if (this.f3993t.u(tVar)) {
            this.f3993t.x(this.K);
            O();
        }
    }

    private void B0(boolean z5, AtomicBoolean atomicBoolean) {
        n1[] n1VarArr;
        if (this.F != z5) {
            this.F = z5;
            if (!z5) {
                for (n1 n1Var : this.f3976a) {
                    if (!J(n1Var)) {
                        n1Var.c();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void C(boolean z5) {
        y0 j6 = this.f3993t.j();
        v.a aVar = j6 == null ? this.f3996w.f3761b : j6.f4816f.f4852a;
        boolean z6 = !this.f3996w.f3768i.equals(aVar);
        if (z6) {
            this.f3996w = this.f3996w.b(aVar);
        }
        g1 g1Var = this.f3996w;
        g1Var.f3773n = j6 == null ? g1Var.f3775p : j6.i();
        this.f3996w.f3774o = z();
        if ((z6 || z5) && j6 != null && j6.f4814d) {
            Y0(j6.n(), j6.o());
        }
    }

    private void C0(b bVar) {
        this.f3997x.b(1);
        if (bVar.f4003c != -1) {
            this.J = new h(new l1(bVar.f4001a, bVar.f4002b), bVar.f4003c, bVar.f4004d);
        }
        D(this.f3994u.B(bVar.f4001a, bVar.f4002b));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.google.android.exoplayer2.y1$b] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.google.android.exoplayer2.y1] */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.google.android.exoplayer2.q0] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.google.android.exoplayer2.g1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void D(y1 y1Var) {
        y1 y1Var2;
        long u02;
        g1 g1Var = this.f3996w;
        h hVar = this.J;
        b1 b1Var = this.f3993t;
        int i6 = this.D;
        boolean z5 = this.E;
        y1.c cVar = this.f3985l;
        ?? r15 = this.f3986m;
        g n02 = n0(y1Var, g1Var, hVar, b1Var, i6, z5, cVar, r15);
        v.a aVar = n02.f4016a;
        long j6 = n02.f4018c;
        boolean z6 = n02.f4019d;
        long j7 = n02.f4017b;
        boolean z7 = (this.f3996w.f3761b.equals(aVar) && j7 == this.f3996w.f3775p) ? false : true;
        try {
            if (n02.f4020e) {
                if (this.f3996w.f3763d != 1) {
                    O0(4);
                }
                h0(false, false, false, true);
            }
            try {
                if (z7) {
                    y1Var2 = y1Var;
                    if (!y1Var.p()) {
                        for (y0 o5 = this.f3993t.o(); o5 != null; o5 = o5.j()) {
                            if (o5.f4816f.f4852a.equals(aVar)) {
                                o5.f4816f = this.f3993t.q(y1Var2, o5.f4816f);
                            }
                        }
                        u02 = u0(aVar, j7, z6);
                        if (!z7 || j6 != this.f3996w.f3762c) {
                            this.f3996w = G(aVar, u02, j6);
                        }
                        i0();
                        m0(y1Var2, this.f3996w.f3760a);
                        this.f3996w = this.f3996w.i(y1Var2);
                        if (!y1Var.p()) {
                            this.J = null;
                        }
                        C(false);
                    }
                } else {
                    y1Var2 = y1Var;
                    if (!this.f3993t.E(y1Var, this.K, w())) {
                        s0(false);
                    }
                }
                u02 = j7;
                if (!z7) {
                }
                this.f3996w = G(aVar, u02, j6);
                i0();
                m0(y1Var2, this.f3996w.f3760a);
                this.f3996w = this.f3996w.i(y1Var2);
                if (!y1Var.p()) {
                }
                C(false);
            } catch (Throwable th) {
                th = th;
                if (z7 || j6 != this.f3996w.f3762c) {
                    this.f3996w = G(aVar, j7, j6);
                }
                i0();
                m0(r15, this.f3996w.f3760a);
                this.f3996w = this.f3996w.i(r15);
                if (!y1Var.p()) {
                    this.J = null;
                }
                C(false);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r15 = y1Var;
        }
    }

    private void E(w1.t tVar) {
        if (this.f3993t.u(tVar)) {
            y0 j6 = this.f3993t.j();
            j6.p(this.f3989p.b().f3778a, this.f3996w.f3760a);
            Y0(j6.n(), j6.o());
            if (j6 == this.f3993t.o()) {
                j0(j6.f4816f.f4853b);
                r();
                g1 g1Var = this.f3996w;
                this.f3996w = G(g1Var.f3761b, j6.f4816f.f4853b, g1Var.f3762c);
            }
            O();
        }
    }

    private void E0(boolean z5) {
        if (z5 == this.H) {
            return;
        }
        this.H = z5;
        g1 g1Var = this.f3996w;
        int i6 = g1Var.f3763d;
        if (z5 || i6 == 4 || i6 == 1) {
            this.f3996w = g1Var.d(z5);
        } else {
            this.f3982g.b(2);
        }
    }

    private void F(h1 h1Var, boolean z5) {
        n1[] n1VarArr;
        this.f3997x.b(z5 ? 1 : 0);
        this.f3996w = this.f3996w.g(h1Var);
        b1(h1Var.f3778a);
        for (n1 n1Var : this.f3976a) {
            if (n1Var != null) {
                n1Var.r(h1Var.f3778a);
            }
        }
    }

    private void F0(boolean z5) {
        this.f3999z = z5;
        i0();
        if (!this.A || this.f3993t.p() == this.f3993t.o()) {
            return;
        }
        s0(true);
        C(false);
    }

    private g1 G(v.a aVar, long j6, long j7) {
        w1.y0 y0Var;
        o2.n nVar;
        this.M = (!this.M && j6 == this.f3996w.f3775p && aVar.equals(this.f3996w.f3761b)) ? false : true;
        i0();
        g1 g1Var = this.f3996w;
        w1.y0 y0Var2 = g1Var.f3766g;
        o2.n nVar2 = g1Var.f3767h;
        if (this.f3994u.s()) {
            y0 o5 = this.f3993t.o();
            y0Var2 = o5 == null ? w1.y0.f14100d : o5.n();
            nVar2 = o5 == null ? this.f3979d : o5.o();
        } else if (!aVar.equals(this.f3996w.f3761b)) {
            y0Var = w1.y0.f14100d;
            nVar = this.f3979d;
            return this.f3996w.c(aVar, j6, j7, z(), y0Var, nVar);
        }
        nVar = nVar2;
        y0Var = y0Var2;
        return this.f3996w.c(aVar, j6, j7, z(), y0Var, nVar);
    }

    private boolean H() {
        y0 p5 = this.f3993t.p();
        if (p5.f4814d) {
            int i6 = 0;
            while (true) {
                n1[] n1VarArr = this.f3976a;
                if (i6 >= n1VarArr.length) {
                    return true;
                }
                n1 n1Var = n1VarArr[i6];
                w1.r0 r0Var = p5.f4813c[i6];
                if (n1Var.q() != r0Var || (r0Var != null && !n1Var.l())) {
                    break;
                }
                i6++;
            }
            return false;
        }
        return false;
    }

    private void H0(boolean z5, int i6, boolean z6, int i7) {
        this.f3997x.b(z6 ? 1 : 0);
        this.f3997x.c(i7);
        this.f3996w = this.f3996w.e(z5, i6);
        this.B = false;
        if (!R0()) {
            W0();
            a1();
            return;
        }
        int i8 = this.f3996w.f3763d;
        if (i8 == 3) {
            U0();
        } else if (i8 != 2) {
            return;
        }
        this.f3982g.b(2);
    }

    private boolean I() {
        y0 j6 = this.f3993t.j();
        return (j6 == null || j6.k() == Long.MIN_VALUE) ? false : true;
    }

    private static boolean J(n1 n1Var) {
        return n1Var.getState() != 0;
    }

    private void J0(h1 h1Var) {
        this.f3989p.h(h1Var);
        z0(this.f3989p.b(), true);
    }

    private boolean K() {
        y0 o5 = this.f3993t.o();
        long j6 = o5.f4816f.f4856e;
        return o5.f4814d && (j6 == -9223372036854775807L || this.f3996w.f3775p < j6 || !R0());
    }

    private void K0(int i6) {
        this.D = i6;
        if (!this.f3993t.F(this.f3996w.f3760a, i6)) {
            s0(true);
        }
        C(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean L() {
        return Boolean.valueOf(this.f3998y);
    }

    private void L0(s1 s1Var) {
        this.f3995v = s1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean M() {
        return Boolean.valueOf(this.f3998y);
    }

    private void M0(boolean z5) {
        this.E = z5;
        if (!this.f3993t.G(this.f3996w.f3760a, z5)) {
            s0(true);
        }
        C(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(k1 k1Var) {
        try {
            n(k1Var);
        } catch (t e6) {
            com.google.android.exoplayer2.util.n.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e6);
            throw new RuntimeException(e6);
        }
    }

    private void N0(w1.t0 t0Var) {
        this.f3997x.b(1);
        D(this.f3994u.C(t0Var));
    }

    private void O() {
        boolean Q0 = Q0();
        this.C = Q0;
        if (Q0) {
            this.f3993t.j().d(this.K);
        }
        X0();
    }

    private void O0(int i6) {
        g1 g1Var = this.f3996w;
        if (g1Var.f3763d != i6) {
            this.f3996w = g1Var.h(i6);
        }
    }

    private void P() {
        this.f3997x.d(this.f3996w);
        if (this.f3997x.f4009a) {
            this.f3992s.a(this.f3997x);
            this.f3997x = new e(this.f3996w);
        }
    }

    private boolean P0() {
        y0 o5;
        y0 j6;
        return R0() && !this.A && (o5 = this.f3993t.o()) != null && (j6 = o5.j()) != null && this.K >= j6.m() && j6.f4817g;
    }

    private void Q(long j6, long j7) {
        if (this.H && this.G) {
            return;
        }
        q0(j6, j7);
    }

    private boolean Q0() {
        if (I()) {
            y0 j6 = this.f3993t.j();
            return this.f3980e.f(j6 == this.f3993t.o() ? j6.y(this.K) : j6.y(this.K) - j6.f4816f.f4853b, A(j6.k()), this.f3989p.b().f3778a);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r1 > 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
        r3 = (com.google.android.exoplayer2.q0.d) r7.f3990q.get(r1 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
        if (r3 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        r4 = r3.f4006b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r4 > r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        if (r4 != r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
        if (r3.f4007c <= r8) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (r1 <= 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (r1 >= r7.f3990q.size()) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
        r3 = (com.google.android.exoplayer2.q0.d) r7.f3990q.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
        if (r3 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
        if (r3.f4008d == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
        r4 = r3.f4006b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
        if (r4 < r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
        if (r4 != r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
        if (r3.f4007c > r8) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
        if (r1 >= r7.f3990q.size()) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
        if (r3 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008b, code lost:
        if (r3.f4008d == null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008f, code lost:
        if (r3.f4006b != r0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0091, code lost:
        r4 = r3.f4007c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0095, code lost:
        if (r4 <= r8) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
        if (r4 > r10) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
        x0(r3.f4005a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a6, code lost:
        if (r3.f4005a.b() != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ae, code lost:
        if (r3.f4005a.j() == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b1, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b4, code lost:
        r7.f3990q.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00bf, code lost:
        if (r1 >= r7.f3990q.size()) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c1, code lost:
        r3 = (com.google.android.exoplayer2.q0.d) r7.f3990q.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ca, code lost:
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cc, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d3, code lost:
        if (r3.f4005a.b() != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00dd, code lost:
        r7.f3990q.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e2, code lost:
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e3, code lost:
        r7.L = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e5, code lost:
        return;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0044 -> B:14:0x0045). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0055 -> B:12:0x0039). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0069 -> B:27:0x006a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0084 -> B:25:0x0060). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void R(long j6, long j7) {
        if (this.f3990q.isEmpty() || this.f3996w.f3761b.b()) {
            return;
        }
        if (this.M) {
            j6--;
            this.M = false;
        }
        g1 g1Var = this.f3996w;
        int b6 = g1Var.f3760a.b(g1Var.f3761b.f14051a);
        int min = Math.min(this.L, this.f3990q.size());
    }

    private boolean R0() {
        g1 g1Var = this.f3996w;
        return g1Var.f3769j && g1Var.f3770k == 0;
    }

    private void S() {
        z0 n5;
        this.f3993t.x(this.K);
        if (this.f3993t.C() && (n5 = this.f3993t.n(this.K, this.f3996w)) != null) {
            y0 g6 = this.f3993t.g(this.f3977b, this.f3978c, this.f3980e.g(), this.f3994u, n5, this.f3979d);
            g6.f4811a.o(this, n5.f4853b);
            if (this.f3993t.o() == g6) {
                j0(g6.m());
            }
            C(false);
        }
        if (!this.C) {
            O();
            return;
        }
        this.C = I();
        X0();
    }

    private boolean S0(boolean z5) {
        if (this.I == 0) {
            return K();
        }
        if (z5) {
            if (this.f3996w.f3765f) {
                y0 j6 = this.f3993t.j();
                return (j6.q() && j6.f4816f.f4859h) || this.f3980e.c(z(), this.f3989p.b().f3778a, this.B);
            }
            return true;
        }
        return false;
    }

    private void T() {
        boolean z5 = false;
        while (P0()) {
            if (z5) {
                P();
            }
            y0 o5 = this.f3993t.o();
            z0 z0Var = this.f3993t.b().f4816f;
            this.f3996w = G(z0Var.f4852a, z0Var.f4853b, z0Var.f4854c);
            this.f3997x.e(o5.f4816f.f4857f ? 0 : 3);
            i0();
            a1();
            z5 = true;
        }
    }

    private static boolean T0(g1 g1Var, y1.b bVar, y1.c cVar) {
        v.a aVar = g1Var.f3761b;
        y1 y1Var = g1Var.f3760a;
        return aVar.b() || y1Var.p() || y1Var.m(y1Var.h(aVar.f14051a, bVar).f4829c, cVar).f4845k;
    }

    private void U() {
        y0 p5 = this.f3993t.p();
        if (p5 == null) {
            return;
        }
        int i6 = 0;
        if (p5.j() != null && !this.A) {
            if (H()) {
                if (p5.j().f4814d || this.K >= p5.j().m()) {
                    o2.n o5 = p5.o();
                    y0 c6 = this.f3993t.c();
                    o2.n o6 = c6.o();
                    if (c6.f4814d && c6.f4811a.l() != -9223372036854775807L) {
                        A0();
                        return;
                    }
                    for (int i7 = 0; i7 < this.f3976a.length; i7++) {
                        boolean c7 = o5.c(i7);
                        boolean c8 = o6.c(i7);
                        if (c7 && !this.f3976a[i7].w()) {
                            boolean z5 = this.f3977b[i7].i() == 6;
                            q1 q1Var = o5.f12478b[i7];
                            q1 q1Var2 = o6.f12478b[i7];
                            if (!c8 || !q1Var2.equals(q1Var) || z5) {
                                this.f3976a[i7].s();
                            }
                        }
                    }
                }
            }
        } else if (p5.f4816f.f4859h || this.A) {
            while (true) {
                n1[] n1VarArr = this.f3976a;
                if (i6 >= n1VarArr.length) {
                    return;
                }
                n1 n1Var = n1VarArr[i6];
                w1.r0 r0Var = p5.f4813c[i6];
                if (r0Var != null && n1Var.q() == r0Var && n1Var.l()) {
                    n1Var.s();
                }
                i6++;
            }
        }
    }

    private void U0() {
        n1[] n1VarArr;
        this.B = false;
        this.f3989p.f();
        for (n1 n1Var : this.f3976a) {
            if (J(n1Var)) {
                n1Var.start();
            }
        }
    }

    private void V() {
        y0 p5 = this.f3993t.p();
        if (p5 == null || this.f3993t.o() == p5 || p5.f4817g || !f0()) {
            return;
        }
        r();
    }

    private void V0(boolean z5, boolean z6) {
        h0(z5 || !this.F, false, true, false);
        this.f3997x.b(z6 ? 1 : 0);
        this.f3980e.h();
        O0(1);
    }

    private void W() {
        D(this.f3994u.i());
    }

    private void W0() {
        n1[] n1VarArr;
        this.f3989p.g();
        for (n1 n1Var : this.f3976a) {
            if (J(n1Var)) {
                t(n1Var);
            }
        }
    }

    private void X(c cVar) {
        this.f3997x.b(1);
        throw null;
    }

    private void X0() {
        y0 j6 = this.f3993t.j();
        boolean z5 = this.C || (j6 != null && j6.f4811a.a());
        g1 g1Var = this.f3996w;
        if (z5 != g1Var.f3765f) {
            this.f3996w = g1Var.a(z5);
        }
    }

    private void Y() {
        o2.j[] b6;
        for (y0 o5 = this.f3993t.o(); o5 != null; o5 = o5.j()) {
            for (o2.j jVar : o5.o().f12479c.b()) {
                if (jVar != null) {
                    jVar.q();
                }
            }
        }
    }

    private void Y0(w1.y0 y0Var, o2.n nVar) {
        this.f3980e.i(this.f3976a, y0Var, nVar.f12479c);
    }

    private void Z0() {
        if (this.f3996w.f3760a.p() || !this.f3994u.s()) {
            return;
        }
        S();
        U();
        V();
        T();
    }

    private void a1() {
        y0 o5 = this.f3993t.o();
        if (o5 == null) {
            return;
        }
        long l6 = o5.f4814d ? o5.f4811a.l() : -9223372036854775807L;
        if (l6 != -9223372036854775807L) {
            j0(l6);
            if (l6 != this.f3996w.f3775p) {
                g1 g1Var = this.f3996w;
                this.f3996w = G(g1Var.f3761b, l6, g1Var.f3762c);
                this.f3997x.e(4);
            }
        } else {
            long i6 = this.f3989p.i(o5 != this.f3993t.p());
            this.K = i6;
            long y5 = o5.y(i6);
            R(this.f3996w.f3775p, y5);
            this.f3996w.f3775p = y5;
        }
        this.f3996w.f3773n = this.f3993t.j().i();
        this.f3996w.f3774o = z();
    }

    private void b0() {
        this.f3997x.b(1);
        h0(false, false, false, true);
        this.f3980e.b();
        O0(this.f3996w.f3760a.p() ? 4 : 2);
        this.f3994u.v(this.f3981f.c());
        this.f3982g.b(2);
    }

    private void b1(float f6) {
        o2.j[] b6;
        for (y0 o5 = this.f3993t.o(); o5 != null; o5 = o5.j()) {
            for (o2.j jVar : o5.o().f12479c.b()) {
                if (jVar != null) {
                    jVar.o(f6);
                }
            }
        }
    }

    private synchronized void c1(com.google.common.base.m mVar) {
        boolean z5 = false;
        while (!((Boolean) mVar.get()).booleanValue()) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z5 = true;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
    }

    private void d0() {
        h0(true, false, true, false);
        this.f3980e.e();
        O0(1);
        this.f3983h.quit();
        synchronized (this) {
            this.f3998y = true;
            notifyAll();
        }
    }

    private synchronized void d1(com.google.common.base.m mVar, long j6) {
        long c6 = this.f3991r.c() + j6;
        boolean z5 = false;
        while (!((Boolean) mVar.get()).booleanValue() && j6 > 0) {
            try {
                wait(j6);
            } catch (InterruptedException unused) {
                z5 = true;
            }
            j6 = c6 - this.f3991r.c();
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
    }

    private void e0(int i6, int i7, w1.t0 t0Var) {
        this.f3997x.b(1);
        D(this.f3994u.z(i6, i7, t0Var));
    }

    private boolean f0() {
        y0 p5 = this.f3993t.p();
        o2.n o5 = p5.o();
        int i6 = 0;
        boolean z5 = false;
        while (true) {
            n1[] n1VarArr = this.f3976a;
            if (i6 >= n1VarArr.length) {
                return !z5;
            }
            n1 n1Var = n1VarArr[i6];
            if (J(n1Var)) {
                boolean z6 = n1Var.q() != p5.f4813c[i6];
                if (!o5.c(i6) || z6) {
                    if (!n1Var.w()) {
                        n1Var.k(v(o5.f12479c.a(i6)), p5.f4813c[i6], p5.m(), p5.l());
                    } else if (n1Var.d()) {
                        o(n1Var);
                    } else {
                        z5 = true;
                    }
                }
            }
            i6++;
        }
    }

    private void g0() {
        float f6 = this.f3989p.b().f3778a;
        y0 p5 = this.f3993t.p();
        boolean z5 = true;
        for (y0 o5 = this.f3993t.o(); o5 != null && o5.f4814d; o5 = o5.j()) {
            o2.n v5 = o5.v(f6, this.f3996w.f3760a);
            int i6 = 0;
            if (!v5.a(o5.o())) {
                b1 b1Var = this.f3993t;
                if (z5) {
                    y0 o6 = b1Var.o();
                    boolean y5 = this.f3993t.y(o6);
                    boolean[] zArr = new boolean[this.f3976a.length];
                    long b6 = o6.b(v5, this.f3996w.f3775p, y5, zArr);
                    g1 g1Var = this.f3996w;
                    g1 G = G(g1Var.f3761b, b6, g1Var.f3762c);
                    this.f3996w = G;
                    if (G.f3763d != 4 && b6 != G.f3775p) {
                        this.f3997x.e(4);
                        j0(b6);
                    }
                    boolean[] zArr2 = new boolean[this.f3976a.length];
                    while (true) {
                        n1[] n1VarArr = this.f3976a;
                        if (i6 >= n1VarArr.length) {
                            break;
                        }
                        n1 n1Var = n1VarArr[i6];
                        boolean J = J(n1Var);
                        zArr2[i6] = J;
                        w1.r0 r0Var = o6.f4813c[i6];
                        if (J) {
                            if (r0Var != n1Var.q()) {
                                o(n1Var);
                            } else if (zArr[i6]) {
                                n1Var.v(this.K);
                            }
                        }
                        i6++;
                    }
                    s(zArr2);
                } else {
                    b1Var.y(o5);
                    if (o5.f4814d) {
                        o5.a(v5, Math.max(o5.f4816f.f4853b, o5.y(this.K)), false);
                    }
                }
                C(true);
                if (this.f3996w.f3763d != 4) {
                    O();
                    a1();
                    this.f3982g.b(2);
                    return;
                }
                return;
            }
            if (o5 == p5) {
                z5 = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h0(boolean z5, boolean z6, boolean z7, boolean z8) {
        v.a aVar;
        long j6;
        long j7;
        boolean z9;
        this.f3982g.e(2);
        this.B = false;
        this.f3989p.g();
        this.K = 0L;
        for (n1 n1Var : this.f3976a) {
            try {
                o(n1Var);
            } catch (t | RuntimeException e6) {
                com.google.android.exoplayer2.util.n.d("ExoPlayerImplInternal", "Disable failed.", e6);
            }
        }
        if (z5) {
            for (n1 n1Var2 : this.f3976a) {
                try {
                    n1Var2.c();
                } catch (RuntimeException e7) {
                    com.google.android.exoplayer2.util.n.d("ExoPlayerImplInternal", "Reset failed.", e7);
                }
            }
        }
        this.I = 0;
        g1 g1Var = this.f3996w;
        v.a aVar2 = g1Var.f3761b;
        long j8 = g1Var.f3775p;
        long j9 = T0(this.f3996w, this.f3986m, this.f3985l) ? this.f3996w.f3762c : this.f3996w.f3775p;
        if (z6) {
            this.J = null;
            Pair x5 = x(this.f3996w.f3760a);
            v.a aVar3 = (v.a) x5.first;
            long longValue = ((Long) x5.second).longValue();
            if (!aVar3.equals(this.f3996w.f3761b)) {
                z9 = true;
                aVar = aVar3;
                j6 = longValue;
                j7 = -9223372036854775807L;
                this.f3993t.f();
                this.C = false;
                g1 g1Var2 = this.f3996w;
                this.f3996w = new g1(g1Var2.f3760a, aVar, j7, g1Var2.f3763d, z8 ? null : g1Var2.f3764e, false, !z9 ? w1.y0.f14100d : g1Var2.f3766g, !z9 ? this.f3979d : g1Var2.f3767h, aVar, g1Var2.f3769j, g1Var2.f3770k, g1Var2.f3771l, j6, 0L, j6, this.H);
                if (z7) {
                    return;
                }
                this.f3994u.x();
                return;
            }
            aVar = aVar3;
            j6 = longValue;
            j7 = -9223372036854775807L;
        } else {
            aVar = aVar2;
            j6 = j8;
            j7 = j9;
        }
        z9 = false;
        this.f3993t.f();
        this.C = false;
        g1 g1Var22 = this.f3996w;
        this.f3996w = new g1(g1Var22.f3760a, aVar, j7, g1Var22.f3763d, z8 ? null : g1Var22.f3764e, false, !z9 ? w1.y0.f14100d : g1Var22.f3766g, !z9 ? this.f3979d : g1Var22.f3767h, aVar, g1Var22.f3769j, g1Var22.f3770k, g1Var22.f3771l, j6, 0L, j6, this.H);
        if (z7) {
        }
    }

    private void i0() {
        y0 o5 = this.f3993t.o();
        this.A = o5 != null && o5.f4816f.f4858g && this.f3999z;
    }

    private void j0(long j6) {
        n1[] n1VarArr;
        y0 o5 = this.f3993t.o();
        if (o5 != null) {
            j6 = o5.z(j6);
        }
        this.K = j6;
        this.f3989p.d(j6);
        for (n1 n1Var : this.f3976a) {
            if (J(n1Var)) {
                n1Var.v(this.K);
            }
        }
        Y();
    }

    private static void k0(y1 y1Var, d dVar, y1.c cVar, y1.b bVar) {
        int i6 = y1Var.m(y1Var.h(dVar.f4008d, bVar).f4829c, cVar).f4847m;
        Object obj = y1Var.g(i6, bVar, true).f4828b;
        long j6 = bVar.f4830d;
        dVar.b(i6, j6 != -9223372036854775807L ? j6 - 1 : Long.MAX_VALUE, obj);
    }

    private void l(b bVar, int i6) {
        this.f3997x.b(1);
        e1 e1Var = this.f3994u;
        if (i6 == -1) {
            i6 = e1Var.q();
        }
        D(e1Var.f(i6, bVar.f4001a, bVar.f4002b));
    }

    private static boolean l0(d dVar, y1 y1Var, y1 y1Var2, int i6, boolean z5, y1.c cVar, y1.b bVar) {
        Object obj = dVar.f4008d;
        if (obj == null) {
            Pair o02 = o0(y1Var, new h(dVar.f4005a.g(), dVar.f4005a.i(), dVar.f4005a.e() == Long.MIN_VALUE ? -9223372036854775807L : p.a(dVar.f4005a.e())), false, i6, z5, cVar, bVar);
            if (o02 == null) {
                return false;
            }
            dVar.b(y1Var.b(o02.first), ((Long) o02.second).longValue(), o02.first);
            if (dVar.f4005a.e() == Long.MIN_VALUE) {
                k0(y1Var, dVar, cVar, bVar);
            }
            return true;
        }
        int b6 = y1Var.b(obj);
        if (b6 == -1) {
            return false;
        }
        if (dVar.f4005a.e() == Long.MIN_VALUE) {
            k0(y1Var, dVar, cVar, bVar);
            return true;
        }
        dVar.f4006b = b6;
        y1Var2.h(dVar.f4008d, bVar);
        if (y1Var2.m(bVar.f4829c, cVar).f4845k) {
            Pair j6 = y1Var.j(cVar, bVar, y1Var.h(dVar.f4008d, bVar).f4829c, dVar.f4007c + bVar.k());
            dVar.b(y1Var.b(j6.first), ((Long) j6.second).longValue(), j6.first);
        }
        return true;
    }

    private void m0(y1 y1Var, y1 y1Var2) {
        if (y1Var.p() && y1Var2.p()) {
            return;
        }
        for (int size = this.f3990q.size() - 1; size >= 0; size--) {
            if (!l0((d) this.f3990q.get(size), y1Var, y1Var2, this.D, this.E, this.f3985l, this.f3986m)) {
                ((d) this.f3990q.get(size)).f4005a.k(false);
                this.f3990q.remove(size);
            }
        }
        Collections.sort(this.f3990q);
    }

    private void n(k1 k1Var) {
        if (k1Var.j()) {
            return;
        }
        try {
            k1Var.f().p(k1Var.h(), k1Var.d());
        } finally {
            k1Var.k(true);
        }
    }

    private static g n0(y1 y1Var, g1 g1Var, h hVar, b1 b1Var, int i6, boolean z5, y1.c cVar, y1.b bVar) {
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z6;
        boolean z7;
        boolean z8;
        b1 b1Var2;
        long j6;
        int i11;
        int i12;
        boolean z9;
        int i13;
        boolean z10;
        if (y1Var.p()) {
            return new g(g1.k(), 0L, -9223372036854775807L, false, true);
        }
        v.a aVar = g1Var.f3761b;
        Object obj = aVar.f14051a;
        boolean T0 = T0(g1Var, bVar, cVar);
        long j7 = T0 ? g1Var.f3762c : g1Var.f3775p;
        boolean z11 = true;
        if (hVar != null) {
            i7 = -1;
            Pair o02 = o0(y1Var, hVar, true, i6, z5, cVar, bVar);
            if (o02 == null) {
                i13 = y1Var.a(z5);
                z9 = false;
                z10 = true;
            } else {
                if (hVar.f4023c == -9223372036854775807L) {
                    i12 = y1Var.h(o02.first, bVar).f4829c;
                } else {
                    obj = o02.first;
                    j7 = ((Long) o02.second).longValue();
                    i12 = -1;
                }
                z9 = g1Var.f3763d == 4;
                i13 = i12;
                z10 = false;
            }
            i8 = i13;
            z8 = z9;
            z7 = z10;
        } else {
            i7 = -1;
            if (g1Var.f3760a.p()) {
                i9 = y1Var.a(z5);
            } else if (y1Var.b(obj) == -1) {
                Object p02 = p0(cVar, bVar, i6, z5, obj, g1Var.f3760a, y1Var);
                if (p02 == null) {
                    i10 = y1Var.a(z5);
                    z6 = true;
                } else {
                    i10 = y1Var.h(p02, bVar).f4829c;
                    z6 = false;
                }
                i8 = i10;
                z7 = z6;
                z8 = false;
            } else {
                if (T0) {
                    if (j7 == -9223372036854775807L) {
                        i9 = y1Var.h(obj, bVar).f4829c;
                    } else {
                        g1Var.f3760a.h(aVar.f14051a, bVar);
                        Pair j8 = y1Var.j(cVar, bVar, y1Var.h(obj, bVar).f4829c, j7 + bVar.k());
                        obj = j8.first;
                        j7 = ((Long) j8.second).longValue();
                    }
                }
                i8 = -1;
                z8 = false;
                z7 = false;
            }
            i8 = i9;
            z8 = false;
            z7 = false;
        }
        if (i8 != i7) {
            Pair j9 = y1Var.j(cVar, bVar, i8, -9223372036854775807L);
            obj = j9.first;
            b1Var2 = b1Var;
            j6 = ((Long) j9.second).longValue();
            j7 = -9223372036854775807L;
        } else {
            b1Var2 = b1Var;
            j6 = j7;
        }
        v.a z12 = b1Var2.z(y1Var, obj, j6);
        if ((!aVar.f14051a.equals(obj) || aVar.b() || z12.b() || !(z12.f14055e == i7 || ((i11 = aVar.f14055e) != i7 && z12.f14052b >= i11))) ? false : false) {
            z12 = aVar;
        }
        if (z12.b()) {
            if (z12.equals(aVar)) {
                j6 = g1Var.f3775p;
            } else {
                y1Var.h(z12.f14051a, bVar);
                j6 = z12.f14053c == bVar.h(z12.f14052b) ? bVar.f() : 0L;
            }
        }
        return new g(z12, j6, j7, z8, z7);
    }

    private void o(n1 n1Var) {
        if (J(n1Var)) {
            this.f3989p.a(n1Var);
            t(n1Var);
            n1Var.e();
            this.I--;
        }
    }

    private static Pair o0(y1 y1Var, h hVar, boolean z5, int i6, boolean z6, y1.c cVar, y1.b bVar) {
        Pair j6;
        Object p02;
        y1 y1Var2 = hVar.f4021a;
        if (y1Var.p()) {
            return null;
        }
        y1 y1Var3 = y1Var2.p() ? y1Var : y1Var2;
        try {
            j6 = y1Var3.j(cVar, bVar, hVar.f4022b, hVar.f4023c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (y1Var.equals(y1Var3)) {
            return j6;
        }
        if (y1Var.b(j6.first) != -1) {
            y1Var3.h(j6.first, bVar);
            return y1Var3.m(bVar.f4829c, cVar).f4845k ? y1Var.j(cVar, bVar, y1Var.h(j6.first, bVar).f4829c, hVar.f4023c) : j6;
        }
        if (z5 && (p02 = p0(cVar, bVar, i6, z6, j6.first, y1Var3, y1Var)) != null) {
            return y1Var.j(cVar, bVar, y1Var.h(p02, bVar).f4829c, -9223372036854775807L);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p() {
        boolean z5;
        boolean z6;
        int i6;
        boolean z7;
        g1 g1Var;
        int i7;
        long a6 = this.f3991r.a();
        Z0();
        int i8 = this.f3996w.f3763d;
        if (i8 == 1 || i8 == 4) {
            this.f3982g.e(2);
            return;
        }
        y0 o5 = this.f3993t.o();
        if (o5 == null) {
            q0(a6, 10L);
            return;
        }
        com.google.android.exoplayer2.util.l0.a("doSomeWork");
        a1();
        if (o5.f4814d) {
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            o5.f4811a.t(this.f3996w.f3775p - this.f3987n, this.f3988o);
            int i9 = 0;
            z5 = true;
            z6 = true;
            while (true) {
                n1[] n1VarArr = this.f3976a;
                if (i9 >= n1VarArr.length) {
                    break;
                }
                n1 n1Var = n1VarArr[i9];
                if (J(n1Var)) {
                    n1Var.o(this.K, elapsedRealtime);
                    z5 = z5 && n1Var.d();
                    boolean z8 = o5.f4813c[i9] != n1Var.q();
                    boolean z9 = z8 || (!z8 && n1Var.l()) || n1Var.g() || n1Var.d();
                    z6 = z6 && z9;
                    if (!z9) {
                        n1Var.t();
                    }
                }
                i9++;
            }
        } else {
            o5.f4811a.s();
            z5 = true;
            z6 = true;
        }
        long j6 = o5.f4816f.f4856e;
        boolean z10 = z5 && o5.f4814d && (j6 == -9223372036854775807L || j6 <= this.f3996w.f3775p);
        if (z10 && this.A) {
            this.A = false;
            H0(false, this.f3996w.f3770k, false, 5);
        }
        if (z10 && o5.f4816f.f4859h) {
            O0(4);
            W0();
        } else if (this.f3996w.f3763d == 2 && S0(z6)) {
            O0(3);
            if (R0()) {
                U0();
            }
        } else if (this.f3996w.f3763d == 3 && (this.I != 0 ? !z6 : !K())) {
            this.B = R0();
            i6 = 2;
            O0(2);
            W0();
            if (this.f3996w.f3763d == i6) {
                int i10 = 0;
                while (true) {
                    n1[] n1VarArr2 = this.f3976a;
                    if (i10 >= n1VarArr2.length) {
                        break;
                    }
                    if (J(n1VarArr2[i10]) && this.f3976a[i10].q() == o5.f4813c[i10]) {
                        this.f3976a[i10].t();
                    }
                    i10++;
                }
                if (this.O) {
                    g1 g1Var2 = this.f3996w;
                    if (!g1Var2.f3765f && g1Var2.f3774o < 500000 && I()) {
                        throw new IllegalStateException("Playback stuck buffering and not loading");
                    }
                }
            }
            z7 = this.H;
            g1Var = this.f3996w;
            if (z7 != g1Var.f3772m) {
                this.f3996w = g1Var.d(z7);
            }
            if ((!R0() && this.f3996w.f3763d == 3) || (i7 = this.f3996w.f3763d) == 2) {
                Q(a6, 10L);
            } else if (this.I != 0 || i7 == 4) {
                this.f3982g.e(2);
            } else {
                q0(a6, 1000L);
            }
            this.G = false;
            com.google.android.exoplayer2.util.l0.c();
        }
        i6 = 2;
        if (this.f3996w.f3763d == i6) {
        }
        z7 = this.H;
        g1Var = this.f3996w;
        if (z7 != g1Var.f3772m) {
        }
        if (!R0()) {
        }
        if (this.I != 0) {
        }
        this.f3982g.e(2);
        this.G = false;
        com.google.android.exoplayer2.util.l0.c();
    }

    static Object p0(y1.c cVar, y1.b bVar, int i6, boolean z5, Object obj, y1 y1Var, y1 y1Var2) {
        int b6 = y1Var.b(obj);
        int i7 = y1Var.i();
        int i8 = b6;
        int i9 = -1;
        for (int i10 = 0; i10 < i7 && i9 == -1; i10++) {
            i8 = y1Var.d(i8, bVar, cVar, i6, z5);
            if (i8 == -1) {
                break;
            }
            i9 = y1Var2.b(y1Var.l(i8));
        }
        if (i9 == -1) {
            return null;
        }
        return y1Var2.l(i9);
    }

    private void q(int i6, boolean z5) {
        n1 n1Var = this.f3976a[i6];
        if (J(n1Var)) {
            return;
        }
        y0 p5 = this.f3993t.p();
        boolean z6 = p5 == this.f3993t.o();
        o2.n o5 = p5.o();
        q1 q1Var = o5.f12478b[i6];
        s0[] v5 = v(o5.f12479c.a(i6));
        boolean z7 = R0() && this.f3996w.f3763d == 3;
        boolean z8 = !z5 && z7;
        this.I++;
        n1Var.m(q1Var, v5, p5.f4813c[i6], this.K, z8, z6, p5.m(), p5.l());
        n1Var.p(androidx.constraintlayout.widget.g.V0, new a());
        this.f3989p.c(n1Var);
        if (z7) {
            n1Var.start();
        }
    }

    private void q0(long j6, long j7) {
        this.f3982g.e(2);
        this.f3982g.d(2, j6 + j7);
    }

    private void r() {
        s(new boolean[this.f3976a.length]);
    }

    private void s(boolean[] zArr) {
        y0 p5 = this.f3993t.p();
        o2.n o5 = p5.o();
        for (int i6 = 0; i6 < this.f3976a.length; i6++) {
            if (!o5.c(i6)) {
                this.f3976a[i6].c();
            }
        }
        for (int i7 = 0; i7 < this.f3976a.length; i7++) {
            if (o5.c(i7)) {
                q(i7, zArr[i7]);
            }
        }
        p5.f4817g = true;
    }

    private void s0(boolean z5) {
        v.a aVar = this.f3993t.o().f4816f.f4852a;
        long v02 = v0(aVar, this.f3996w.f3775p, true, false);
        if (v02 != this.f3996w.f3775p) {
            this.f3996w = G(aVar, v02, this.f3996w.f3762c);
            if (z5) {
                this.f3997x.e(4);
            }
        }
    }

    private void t(n1 n1Var) {
        if (n1Var.getState() == 2) {
            n1Var.stop();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void t0(h hVar) {
        long j6;
        v.a z5;
        boolean z6;
        long j7;
        long j8;
        long j9;
        g1 g1Var;
        int i6;
        this.f3997x.b(1);
        Pair o02 = o0(this.f3996w.f3760a, hVar, true, this.D, this.E, this.f3985l, this.f3986m);
        if (o02 == null) {
            Pair x5 = x(this.f3996w.f3760a);
            v.a aVar = (v.a) x5.first;
            long longValue = ((Long) x5.second).longValue();
            z6 = !this.f3996w.f3760a.p();
            z5 = aVar;
            j7 = longValue;
            j6 = -9223372036854775807L;
        } else {
            Object obj = o02.first;
            long longValue2 = ((Long) o02.second).longValue();
            j6 = hVar.f4023c == -9223372036854775807L ? -9223372036854775807L : longValue2;
            z5 = this.f3993t.z(this.f3996w.f3760a, obj, longValue2);
            if (z5.b()) {
                this.f3996w.f3760a.h(z5.f14051a, this.f3986m);
                j7 = this.f3986m.h(z5.f14052b) == z5.f14053c ? this.f3986m.f() : 0L;
                z6 = true;
            } else {
                z6 = hVar.f4023c == -9223372036854775807L;
                j7 = longValue2;
            }
        }
        try {
            if (this.f3996w.f3760a.p()) {
                this.J = hVar;
            } else if (o02 != null) {
                if (z5.equals(this.f3996w.f3761b)) {
                    y0 o5 = this.f3993t.o();
                    long c6 = (o5 == null || !o5.f4814d || j7 == 0) ? j7 : o5.f4811a.c(j7, this.f3995v);
                    long j10 = c6;
                    if (p.b(c6) == p.b(this.f3996w.f3775p) && ((i6 = (g1Var = this.f3996w).f3763d) == 2 || i6 == 3)) {
                        this.f3996w = G(z5, g1Var.f3775p, j6);
                        if (z6) {
                            this.f3997x.e(2);
                            return;
                        }
                        return;
                    }
                    j8 = j10;
                } else {
                    j8 = j7;
                }
                long u02 = u0(z5, j8, this.f3996w.f3763d == 4);
                z6 |= j7 != u02;
                j9 = u02;
                this.f3996w = G(z5, j9, j6);
                if (z6) {
                    return;
                }
                this.f3997x.e(2);
                return;
            } else {
                if (this.f3996w.f3763d != 1) {
                    O0(4);
                }
                h0(false, true, false, true);
            }
            j9 = j7;
            this.f3996w = G(z5, j9, j6);
            if (z6) {
            }
        } catch (Throwable th) {
            this.f3996w = G(z5, j7, j6);
            if (z6) {
                this.f3997x.e(2);
            }
            throw th;
        }
    }

    private long u0(v.a aVar, long j6, boolean z5) {
        return v0(aVar, j6, this.f3993t.o() != this.f3993t.p(), z5);
    }

    private static s0[] v(o2.j jVar) {
        int length = jVar != null ? jVar.length() : 0;
        s0[] s0VarArr = new s0[length];
        for (int i6 = 0; i6 < length; i6++) {
            s0VarArr[i6] = jVar.c(i6);
        }
        return s0VarArr;
    }

    private long v0(v.a aVar, long j6, boolean z5, boolean z6) {
        W0();
        this.B = false;
        if (z6 || this.f3996w.f3763d == 3) {
            O0(2);
        }
        y0 o5 = this.f3993t.o();
        y0 y0Var = o5;
        while (y0Var != null && !aVar.equals(y0Var.f4816f.f4852a)) {
            y0Var = y0Var.j();
        }
        if (z5 || o5 != y0Var || (y0Var != null && y0Var.z(j6) < 0)) {
            for (n1 n1Var : this.f3976a) {
                o(n1Var);
            }
            if (y0Var != null) {
                while (this.f3993t.o() != y0Var) {
                    this.f3993t.b();
                }
                this.f3993t.y(y0Var);
                y0Var.x(0L);
                r();
            }
        }
        b1 b1Var = this.f3993t;
        if (y0Var != null) {
            b1Var.y(y0Var);
            if (y0Var.f4814d) {
                long j7 = y0Var.f4816f.f4856e;
                if (j7 != -9223372036854775807L && j6 >= j7) {
                    j6 = Math.max(0L, j7 - 1);
                }
                if (y0Var.f4815e) {
                    long u5 = y0Var.f4811a.u(j6);
                    y0Var.f4811a.t(u5 - this.f3987n, this.f3988o);
                    j6 = u5;
                }
            } else {
                y0Var.f4816f = y0Var.f4816f.b(j6);
            }
            j0(j6);
            O();
        } else {
            b1Var.f();
            j0(j6);
        }
        C(false);
        this.f3982g.b(2);
        return j6;
    }

    private long w() {
        y0 p5 = this.f3993t.p();
        if (p5 == null) {
            return 0L;
        }
        long l6 = p5.l();
        if (!p5.f4814d) {
            return l6;
        }
        int i6 = 0;
        while (true) {
            n1[] n1VarArr = this.f3976a;
            if (i6 >= n1VarArr.length) {
                return l6;
            }
            if (J(n1VarArr[i6]) && this.f3976a[i6].q() == p5.f4813c[i6]) {
                long u5 = this.f3976a[i6].u();
                if (u5 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                l6 = Math.max(u5, l6);
            }
            i6++;
        }
    }

    private void w0(k1 k1Var) {
        if (k1Var.e() == -9223372036854775807L) {
            x0(k1Var);
        } else if (this.f3996w.f3760a.p()) {
            this.f3990q.add(new d(k1Var));
        } else {
            d dVar = new d(k1Var);
            y1 y1Var = this.f3996w.f3760a;
            if (!l0(dVar, y1Var, y1Var, this.D, this.E, this.f3985l, this.f3986m)) {
                k1Var.k(false);
                return;
            }
            this.f3990q.add(dVar);
            Collections.sort(this.f3990q);
        }
    }

    private Pair x(y1 y1Var) {
        if (y1Var.p()) {
            return Pair.create(g1.k(), 0L);
        }
        Pair j6 = y1Var.j(this.f3985l, this.f3986m, y1Var.a(this.E), -9223372036854775807L);
        v.a z5 = this.f3993t.z(y1Var, j6.first, 0L);
        long longValue = ((Long) j6.second).longValue();
        if (z5.b()) {
            y1Var.h(z5.f14051a, this.f3986m);
            longValue = z5.f14053c == this.f3986m.h(z5.f14052b) ? this.f3986m.f() : 0L;
        }
        return Pair.create(z5, Long.valueOf(longValue));
    }

    private void x0(k1 k1Var) {
        if (k1Var.c().getLooper() != this.f3984k) {
            this.f3982g.f(15, k1Var).sendToTarget();
            return;
        }
        n(k1Var);
        int i6 = this.f3996w.f3763d;
        if (i6 == 3 || i6 == 2) {
            this.f3982g.b(2);
        }
    }

    private void y0(final k1 k1Var) {
        Handler c6 = k1Var.c();
        if (c6.getLooper().getThread().isAlive()) {
            c6.post(new Runnable() { // from class: com.google.android.exoplayer2.p0
                @Override // java.lang.Runnable
                public final void run() {
                    q0.this.N(k1Var);
                }
            });
            return;
        }
        com.google.android.exoplayer2.util.n.h("TAG", "Trying to send message on a dead thread.");
        k1Var.k(false);
    }

    private long z() {
        return A(this.f3996w.f3773n);
    }

    private void z0(h1 h1Var, boolean z5) {
        this.f3982g.c(16, z5 ? 1 : 0, 0, h1Var).sendToTarget();
    }

    public void D0(List list, int i6, long j6, w1.t0 t0Var) {
        this.f3982g.f(17, new b(list, t0Var, i6, j6, null)).sendToTarget();
    }

    public void G0(boolean z5, int i6) {
        this.f3982g.a(1, z5 ? 1 : 0, i6).sendToTarget();
    }

    public void I0(h1 h1Var) {
        this.f3982g.f(4, h1Var).sendToTarget();
    }

    @Override // w1.s0.a
    /* renamed from: Z */
    public void j(w1.t tVar) {
        this.f3982g.f(9, tVar).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.k1.a
    public synchronized void a(k1 k1Var) {
        if (!this.f3998y && this.f3983h.isAlive()) {
            this.f3982g.f(14, k1Var).sendToTarget();
            return;
        }
        com.google.android.exoplayer2.util.n.h("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        k1Var.k(false);
    }

    public void a0() {
        this.f3982g.g(0).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.e1.d
    public void c() {
        this.f3982g.b(22);
    }

    public synchronized boolean c0() {
        if (!this.f3998y && this.f3983h.isAlive()) {
            this.f3982g.b(7);
            if (this.N > 0) {
                d1(new com.google.common.base.m() { // from class: com.google.android.exoplayer2.n0
                    @Override // com.google.common.base.m
                    public final Object get() {
                        Boolean L;
                        L = q0.this.L();
                        return L;
                    }
                }, this.N);
            } else {
                c1(new com.google.common.base.m() { // from class: com.google.android.exoplayer2.o0
                    @Override // com.google.common.base.m
                    public final Object get() {
                        Boolean M;
                        M = q0.this.M();
                        return M;
                    }
                });
            }
            return this.f3998y;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.r.a
    public void d(h1 h1Var) {
        z0(h1Var, false);
    }

    @Override // w1.t.a
    public void g(w1.t tVar) {
        this.f3982g.f(8, tVar).sendToTarget();
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fa  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        t e6;
        y0 p5;
        try {
            switch (message.what) {
                case 0:
                    b0();
                    break;
                case 1:
                    H0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    p();
                    break;
                case 3:
                    t0((h) message.obj);
                    break;
                case 4:
                    J0((h1) message.obj);
                    break;
                case 5:
                    L0((s1) message.obj);
                    break;
                case 6:
                    V0(false, true);
                    break;
                case 7:
                    d0();
                    return true;
                case 8:
                    E((w1.t) message.obj);
                    break;
                case 9:
                    B((w1.t) message.obj);
                    break;
                case 10:
                    g0();
                    break;
                case 11:
                    K0(message.arg1);
                    break;
                case 12:
                    M0(message.arg1 != 0);
                    break;
                case 13:
                    B0(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    w0((k1) message.obj);
                    break;
                case 15:
                    y0((k1) message.obj);
                    break;
                case 16:
                    F((h1) message.obj, message.arg1 != 0);
                    break;
                case 17:
                    C0((b) message.obj);
                    break;
                case 18:
                    l((b) message.obj, message.arg1);
                    break;
                case 19:
                    android.support.v4.media.a.a(message.obj);
                    X(null);
                    break;
                case 20:
                    e0(message.arg1, message.arg2, (w1.t0) message.obj);
                    break;
                case 21:
                    N0((w1.t0) message.obj);
                    break;
                case 22:
                    W();
                    break;
                case 23:
                    F0(message.arg1 != 0);
                    break;
                case 24:
                    E0(message.arg1 == 1);
                    break;
                default:
                    return false;
            }
            P();
        } catch (t e7) {
            e6 = e7;
            if (e6.type == 1 && (p5 = this.f3993t.p()) != null) {
                e6 = e6.copyWithMediaPeriodId(p5.f4816f.f4852a);
            }
            com.google.android.exoplayer2.util.n.d("ExoPlayerImplInternal", "Playback error", e6);
            V0(true, false);
            this.f3996w = this.f3996w.f(e6);
            P();
            return true;
        } catch (IOException e8) {
            e6 = t.createForSource(e8);
            y0 o5 = this.f3993t.o();
            if (o5 != null) {
                e6 = e6.copyWithMediaPeriodId(o5.f4816f.f4852a);
            }
            com.google.android.exoplayer2.util.n.d("ExoPlayerImplInternal", "Playback error", e6);
            V0(false, false);
            this.f3996w = this.f3996w.f(e6);
            P();
            return true;
        } catch (OutOfMemoryError e9) {
            e = e9;
            e6 = !(e instanceof OutOfMemoryError) ? t.createForOutOfMemory((OutOfMemoryError) e) : t.createForUnexpected((RuntimeException) e);
            com.google.android.exoplayer2.util.n.d("ExoPlayerImplInternal", "Playback error", e6);
            V0(true, false);
            this.f3996w = this.f3996w.f(e6);
            P();
            return true;
        } catch (RuntimeException e10) {
            e = e10;
            if (!(e instanceof OutOfMemoryError)) {
            }
            com.google.android.exoplayer2.util.n.d("ExoPlayerImplInternal", "Playback error", e6);
            V0(true, false);
            this.f3996w = this.f3996w.f(e6);
            P();
            return true;
        }
        return true;
    }

    public void r0(y1 y1Var, int i6, long j6) {
        this.f3982g.f(3, new h(y1Var, i6, j6)).sendToTarget();
    }

    public void u() {
        this.O = false;
    }

    public Looper y() {
        return this.f3984k;
    }
}
