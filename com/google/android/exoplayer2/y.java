package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.google.android.exoplayer2.e1;
import com.google.android.exoplayer2.j1;
import com.google.android.exoplayer2.k1;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.q0;
import com.google.android.exoplayer2.y;
import com.google.android.exoplayer2.y1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeoutException;
import w1.t0;
import w1.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y extends n {
    private boolean A;
    private g1 B;
    private int C;
    private int D;
    private long E;

    /* renamed from: b  reason: collision with root package name */
    final o2.n f4763b;

    /* renamed from: c  reason: collision with root package name */
    private final n1[] f4764c;

    /* renamed from: d  reason: collision with root package name */
    private final o2.m f4765d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f4766e;

    /* renamed from: f  reason: collision with root package name */
    private final q0.f f4767f;

    /* renamed from: g  reason: collision with root package name */
    private final q0 f4768g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f4769h;

    /* renamed from: i  reason: collision with root package name */
    private final CopyOnWriteArrayList f4770i;

    /* renamed from: j  reason: collision with root package name */
    private final y1.b f4771j;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayDeque f4772k;

    /* renamed from: l  reason: collision with root package name */
    private final List f4773l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f4774m;

    /* renamed from: n  reason: collision with root package name */
    private final w1.g0 f4775n;

    /* renamed from: o  reason: collision with root package name */
    private final y0.a f4776o;

    /* renamed from: p  reason: collision with root package name */
    private final Looper f4777p;

    /* renamed from: q  reason: collision with root package name */
    private final q2.e f4778q;

    /* renamed from: r  reason: collision with root package name */
    private int f4779r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f4780s;

    /* renamed from: t  reason: collision with root package name */
    private int f4781t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f4782u;

    /* renamed from: v  reason: collision with root package name */
    private int f4783v;

    /* renamed from: w  reason: collision with root package name */
    private int f4784w;

    /* renamed from: x  reason: collision with root package name */
    private s1 f4785x;

    /* renamed from: y  reason: collision with root package name */
    private w1.t0 f4786y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f4787z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a implements c1 {

        /* renamed from: a  reason: collision with root package name */
        private final Object f4788a;

        /* renamed from: b  reason: collision with root package name */
        private y1 f4789b;

        public a(Object obj, y1 y1Var) {
            this.f4788a = obj;
            this.f4789b = y1Var;
        }

        @Override // com.google.android.exoplayer2.c1
        public Object a() {
            return this.f4788a;
        }

        @Override // com.google.android.exoplayer2.c1
        public y1 b() {
            return this.f4789b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final g1 f4790a;

        /* renamed from: b  reason: collision with root package name */
        private final CopyOnWriteArrayList f4791b;

        /* renamed from: c  reason: collision with root package name */
        private final o2.m f4792c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f4793d;

        /* renamed from: e  reason: collision with root package name */
        private final int f4794e;

        /* renamed from: f  reason: collision with root package name */
        private final int f4795f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f4796g;

        /* renamed from: h  reason: collision with root package name */
        private final int f4797h;

        /* renamed from: k  reason: collision with root package name */
        private final w0 f4798k;

        /* renamed from: l  reason: collision with root package name */
        private final int f4799l;

        /* renamed from: m  reason: collision with root package name */
        private final boolean f4800m;

        /* renamed from: n  reason: collision with root package name */
        private final boolean f4801n;

        /* renamed from: o  reason: collision with root package name */
        private final boolean f4802o;

        /* renamed from: p  reason: collision with root package name */
        private final boolean f4803p;

        /* renamed from: q  reason: collision with root package name */
        private final boolean f4804q;

        /* renamed from: r  reason: collision with root package name */
        private final boolean f4805r;

        /* renamed from: s  reason: collision with root package name */
        private final boolean f4806s;

        /* renamed from: t  reason: collision with root package name */
        private final boolean f4807t;

        /* renamed from: u  reason: collision with root package name */
        private final boolean f4808u;

        /* renamed from: v  reason: collision with root package name */
        private final boolean f4809v;

        /* renamed from: w  reason: collision with root package name */
        private final boolean f4810w;

        public b(g1 g1Var, g1 g1Var2, CopyOnWriteArrayList copyOnWriteArrayList, o2.m mVar, boolean z5, int i6, int i7, boolean z6, int i8, w0 w0Var, int i9, boolean z7) {
            this.f4790a = g1Var;
            this.f4791b = new CopyOnWriteArrayList(copyOnWriteArrayList);
            this.f4792c = mVar;
            this.f4793d = z5;
            this.f4794e = i6;
            this.f4795f = i7;
            this.f4796g = z6;
            this.f4797h = i8;
            this.f4798k = w0Var;
            this.f4799l = i9;
            this.f4800m = z7;
            this.f4801n = g1Var2.f3763d != g1Var.f3763d;
            t tVar = g1Var2.f3764e;
            t tVar2 = g1Var.f3764e;
            this.f4802o = (tVar == tVar2 || tVar2 == null) ? false : true;
            this.f4803p = g1Var2.f3765f != g1Var.f3765f;
            this.f4804q = !g1Var2.f3760a.equals(g1Var.f3760a);
            this.f4805r = g1Var2.f3767h != g1Var.f3767h;
            this.f4806s = g1Var2.f3769j != g1Var.f3769j;
            this.f4807t = g1Var2.f3770k != g1Var.f3770k;
            this.f4808u = n(g1Var2) != n(g1Var);
            this.f4809v = !g1Var2.f3771l.equals(g1Var.f3771l);
            this.f4810w = g1Var2.f3772m != g1Var.f3772m;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A(j1.a aVar) {
            aVar.e(this.f4790a.f3770k);
        }

        private static boolean n(g1 g1Var) {
            return g1Var.f3763d == 3 && g1Var.f3769j && g1Var.f3770k == 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(j1.a aVar) {
            aVar.C(this.f4790a.f3760a, this.f4795f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(j1.a aVar) {
            aVar.i(this.f4794e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(j1.a aVar) {
            aVar.V(n(this.f4790a));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(j1.a aVar) {
            aVar.d(this.f4790a.f3771l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(j1.a aVar) {
            aVar.P(this.f4790a.f3772m);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(j1.a aVar) {
            aVar.w(this.f4798k, this.f4797h);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(j1.a aVar) {
            aVar.r(this.f4790a.f3764e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(j1.a aVar) {
            g1 g1Var = this.f4790a;
            aVar.g(g1Var.f3766g, g1Var.f3767h.f12479c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(j1.a aVar) {
            aVar.s(this.f4790a.f3765f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(j1.a aVar) {
            g1 g1Var = this.f4790a;
            aVar.f(g1Var.f3769j, g1Var.f3763d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(j1.a aVar) {
            aVar.E(this.f4790a.f3763d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(j1.a aVar) {
            aVar.F(this.f4790a.f3769j, this.f4799l);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4804q) {
                y.I(this.f4791b, new n.b() { // from class: com.google.android.exoplayer2.z
                    @Override // com.google.android.exoplayer2.n.b
                    public final void a(j1.a aVar) {
                        y.b.this.o(aVar);
                    }
                });
            }
            if (this.f4793d) {
                y.I(this.f4791b, new n.b() { // from class: com.google.android.exoplayer2.i0
                    @Override // com.google.android.exoplayer2.n.b
                    public final void a(j1.a aVar) {
                        y.b.this.p(aVar);
                    }
                });
            }
            if (this.f4796g) {
                y.I(this.f4791b, new n.b() { // from class: com.google.android.exoplayer2.j0
                    @Override // com.google.android.exoplayer2.n.b
                    public final void a(j1.a aVar) {
                        y.b.this.t(aVar);
                    }
                });
            }
            if (this.f4802o) {
                y.I(this.f4791b, new n.b() { // from class: com.google.android.exoplayer2.k0
                    @Override // com.google.android.exoplayer2.n.b
                    public final void a(j1.a aVar) {
                        y.b.this.u(aVar);
                    }
                });
            }
            if (this.f4805r) {
                this.f4792c.c(this.f4790a.f3767h.f12480d);
                y.I(this.f4791b, new n.b() { // from class: com.google.android.exoplayer2.l0
                    @Override // com.google.android.exoplayer2.n.b
                    public final void a(j1.a aVar) {
                        y.b.this.v(aVar);
                    }
                });
            }
            if (this.f4803p) {
                y.I(this.f4791b, new n.b() { // from class: com.google.android.exoplayer2.m0
                    @Override // com.google.android.exoplayer2.n.b
                    public final void a(j1.a aVar) {
                        y.b.this.w(aVar);
                    }
                });
            }
            if (this.f4801n || this.f4806s) {
                y.I(this.f4791b, new n.b() { // from class: com.google.android.exoplayer2.a0
                    @Override // com.google.android.exoplayer2.n.b
                    public final void a(j1.a aVar) {
                        y.b.this.x(aVar);
                    }
                });
            }
            if (this.f4801n) {
                y.I(this.f4791b, new n.b() { // from class: com.google.android.exoplayer2.b0
                    @Override // com.google.android.exoplayer2.n.b
                    public final void a(j1.a aVar) {
                        y.b.this.y(aVar);
                    }
                });
            }
            if (this.f4806s) {
                y.I(this.f4791b, new n.b() { // from class: com.google.android.exoplayer2.c0
                    @Override // com.google.android.exoplayer2.n.b
                    public final void a(j1.a aVar) {
                        y.b.this.z(aVar);
                    }
                });
            }
            if (this.f4807t) {
                y.I(this.f4791b, new n.b() { // from class: com.google.android.exoplayer2.d0
                    @Override // com.google.android.exoplayer2.n.b
                    public final void a(j1.a aVar) {
                        y.b.this.A(aVar);
                    }
                });
            }
            if (this.f4808u) {
                y.I(this.f4791b, new n.b() { // from class: com.google.android.exoplayer2.e0
                    @Override // com.google.android.exoplayer2.n.b
                    public final void a(j1.a aVar) {
                        y.b.this.q(aVar);
                    }
                });
            }
            if (this.f4809v) {
                y.I(this.f4791b, new n.b() { // from class: com.google.android.exoplayer2.f0
                    @Override // com.google.android.exoplayer2.n.b
                    public final void a(j1.a aVar) {
                        y.b.this.r(aVar);
                    }
                });
            }
            if (this.f4800m) {
                y.I(this.f4791b, new n.b() { // from class: com.google.android.exoplayer2.g0
                    @Override // com.google.android.exoplayer2.n.b
                    public final void a(j1.a aVar) {
                        aVar.u();
                    }
                });
            }
            if (this.f4810w) {
                y.I(this.f4791b, new n.b() { // from class: com.google.android.exoplayer2.h0
                    @Override // com.google.android.exoplayer2.n.b
                    public final void a(j1.a aVar) {
                        y.b.this.s(aVar);
                    }
                });
            }
        }
    }

    public y(n1[] n1VarArr, o2.m mVar, w1.g0 g0Var, v0 v0Var, q2.e eVar, y0.a aVar, boolean z5, s1 s1Var, boolean z6, com.google.android.exoplayer2.util.c cVar, Looper looper) {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = com.google.android.exoplayer2.util.s0.f4677e;
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 30 + String.valueOf(str).length());
        sb.append("Init ");
        sb.append(hexString);
        sb.append(" [");
        sb.append("ExoPlayerLib/2.12.1");
        sb.append("] [");
        sb.append(str);
        sb.append("]");
        com.google.android.exoplayer2.util.n.f("ExoPlayerImpl", sb.toString());
        com.google.android.exoplayer2.util.a.g(n1VarArr.length > 0);
        this.f4764c = (n1[]) com.google.android.exoplayer2.util.a.e(n1VarArr);
        this.f4765d = (o2.m) com.google.android.exoplayer2.util.a.e(mVar);
        this.f4775n = g0Var;
        this.f4778q = eVar;
        this.f4776o = aVar;
        this.f4774m = z5;
        this.f4785x = s1Var;
        this.f4787z = z6;
        this.f4777p = looper;
        this.f4779r = 0;
        this.f4770i = new CopyOnWriteArrayList();
        this.f4773l = new ArrayList();
        this.f4786y = new t0.a(0);
        o2.n nVar = new o2.n(new q1[n1VarArr.length], new o2.j[n1VarArr.length], null);
        this.f4763b = nVar;
        this.f4771j = new y1.b();
        this.C = -1;
        this.f4766e = new Handler(looper);
        q0.f fVar = new q0.f() { // from class: com.google.android.exoplayer2.u
            @Override // com.google.android.exoplayer2.q0.f
            public final void a(q0.e eVar2) {
                y.this.K(eVar2);
            }
        };
        this.f4767f = fVar;
        this.B = g1.j(nVar);
        this.f4772k = new ArrayDeque();
        if (aVar != null) {
            aVar.f0(this);
            u(aVar);
            eVar.h(new Handler(looper), aVar);
        }
        q0 q0Var = new q0(n1VarArr, mVar, nVar, v0Var, eVar, this.f4779r, this.f4780s, aVar, s1Var, z6, looper, cVar, fVar);
        this.f4768g = q0Var;
        this.f4769h = new Handler(q0Var.y());
    }

    private int C() {
        if (this.B.f3760a.p()) {
            return this.C;
        }
        g1 g1Var = this.B;
        return g1Var.f3760a.h(g1Var.f3761b.f14051a, this.f4771j).f4829c;
    }

    private Pair E(y1 y1Var, int i6, long j6) {
        if (y1Var.p()) {
            this.C = i6;
            if (j6 == -9223372036854775807L) {
                j6 = 0;
            }
            this.E = j6;
            this.D = 0;
            return null;
        }
        if (i6 == -1 || i6 >= y1Var.o()) {
            i6 = y1Var.a(this.f4780s);
            j6 = y1Var.m(i6, this.f3922a).a();
        }
        return y1Var.j(this.f3922a, this.f4771j, i6, p.a(j6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public void J(q0.e eVar) {
        int i6 = this.f4781t - eVar.f4011c;
        this.f4781t = i6;
        if (eVar.f4012d) {
            this.f4782u = true;
            this.f4783v = eVar.f4013e;
        }
        if (eVar.f4014f) {
            this.f4784w = eVar.f4015g;
        }
        if (i6 == 0) {
            y1 y1Var = eVar.f4010b.f3760a;
            if (!this.B.f3760a.p() && y1Var.p()) {
                this.C = -1;
                this.E = 0L;
                this.D = 0;
            }
            if (!y1Var.p()) {
                List D = ((l1) y1Var).D();
                com.google.android.exoplayer2.util.a.g(D.size() == this.f4773l.size());
                for (int i7 = 0; i7 < D.size(); i7++) {
                    ((a) this.f4773l.get(i7)).f4789b = (y1) D.get(i7);
                }
            }
            boolean z5 = this.f4782u;
            this.f4782u = false;
            b0(eVar.f4010b, z5, this.f4783v, 1, this.f4784w, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(CopyOnWriteArrayList copyOnWriteArrayList, n.b bVar) {
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            ((n.a) it.next()).a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(final q0.e eVar) {
        this.f4766e.post(new Runnable() { // from class: com.google.android.exoplayer2.w
            @Override // java.lang.Runnable
            public final void run() {
                y.this.J(eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M(j1.a aVar) {
        aVar.r(t.createForTimeout(new TimeoutException("Player release timed out."), 1));
    }

    private g1 N(g1 g1Var, y1 y1Var, Pair pair) {
        long j6;
        g1 b6;
        int i6;
        com.google.android.exoplayer2.util.a.a(y1Var.p() || pair != null);
        y1 y1Var2 = g1Var.f3760a;
        g1 i7 = g1Var.i(y1Var);
        if (y1Var.p()) {
            v.a k6 = g1.k();
            g1 b7 = i7.c(k6, p.a(this.E), p.a(this.E), 0L, w1.y0.f14100d, this.f4763b).b(k6);
            b7.f3773n = b7.f3775p;
            return b7;
        }
        Object obj = i7.f3761b.f14051a;
        boolean z5 = !obj.equals(((Pair) com.google.android.exoplayer2.util.s0.j(pair)).first);
        v.a aVar = z5 ? new v.a(pair.first) : i7.f3761b;
        long longValue = ((Long) pair.second).longValue();
        long a6 = p.a(b());
        if (!y1Var2.p()) {
            a6 -= y1Var2.h(obj, this.f4771j).k();
        }
        if (z5 || longValue < a6) {
            com.google.android.exoplayer2.util.a.g(!aVar.b());
            j6 = longValue;
            b6 = i7.c(aVar, longValue, longValue, 0L, z5 ? w1.y0.f14100d : i7.f3766g, z5 ? this.f4763b : i7.f3767h).b(aVar);
        } else if (i6 == 0) {
            int b8 = y1Var.b(i7.f3768i.f14051a);
            if (b8 == -1 || y1Var.f(b8, this.f4771j).f4829c != y1Var.h(aVar.f14051a, this.f4771j).f4829c) {
                y1Var.h(aVar.f14051a, this.f4771j);
                long b9 = aVar.b() ? this.f4771j.b(aVar.f14052b, aVar.f14053c) : this.f4771j.f4830d;
                g1 b10 = i7.c(aVar, i7.f3775p, i7.f3775p, b9 - i7.f3775p, i7.f3766g, i7.f3767h).b(aVar);
                b10.f3773n = b9;
                return b10;
            }
            return i7;
        } else {
            com.google.android.exoplayer2.util.a.g(!aVar.b());
            long max = Math.max(0L, i7.f3774o - (longValue - a6));
            j6 = i7.f3773n;
            if (i7.f3768i.equals(i7.f3761b)) {
                j6 = longValue + max;
            }
            b6 = i7.c(aVar, longValue, longValue, max, i7.f3766g, i7.f3767h);
        }
        b6.f3773n = j6;
        return b6;
    }

    private void O(final n.b bVar) {
        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this.f4770i);
        P(new Runnable() { // from class: com.google.android.exoplayer2.x
            @Override // java.lang.Runnable
            public final void run() {
                y.I(copyOnWriteArrayList, bVar);
            }
        });
    }

    private void P(Runnable runnable) {
        boolean z5 = !this.f4772k.isEmpty();
        this.f4772k.addLast(runnable);
        if (z5) {
            return;
        }
        while (!this.f4772k.isEmpty()) {
            ((Runnable) this.f4772k.peekFirst()).run();
            this.f4772k.removeFirst();
        }
    }

    private long Q(v.a aVar, long j6) {
        long b6 = p.b(j6);
        this.B.f3760a.h(aVar.f14051a, this.f4771j);
        return b6 + this.f4771j.j();
    }

    private void T(int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            this.f4773l.remove(i8);
        }
        this.f4786y = this.f4786y.b(i6, i7);
        if (this.f4773l.isEmpty()) {
            this.A = false;
        }
    }

    private void Y(List list, int i6, long j6, boolean z5) {
        int i7;
        long j7;
        c0(list, true);
        int C = C();
        long k6 = k();
        this.f4781t++;
        if (!this.f4773l.isEmpty()) {
            T(0, this.f4773l.size());
        }
        List v5 = v(0, list);
        y1 w5 = w();
        if (!w5.p() && i6 >= w5.o()) {
            throw new u0(w5, i6, j6);
        }
        if (z5) {
            j7 = -9223372036854775807L;
            i7 = w5.a(this.f4780s);
        } else if (i6 == -1) {
            i7 = C;
            j7 = k6;
        } else {
            i7 = i6;
            j7 = j6;
        }
        g1 N = N(this.B, w5, E(w5, i7, j7));
        int i8 = N.f3763d;
        if (i7 != -1 && i8 != 1) {
            i8 = (w5.p() || i7 >= w5.o()) ? 4 : 2;
        }
        g1 h6 = N.h(i8);
        this.f4768g.D0(v5, i7, p.a(j7), this.f4786y);
        b0(h6, false, 4, 0, 1, false);
    }

    private void b0(g1 g1Var, boolean z5, int i6, int i7, int i8, boolean z6) {
        w0 w0Var;
        g1 g1Var2 = this.B;
        this.B = g1Var;
        Pair z7 = z(g1Var, g1Var2, z5, i6, !g1Var2.f3760a.equals(g1Var.f3760a));
        boolean booleanValue = ((Boolean) z7.first).booleanValue();
        int intValue = ((Integer) z7.second).intValue();
        if (!booleanValue || g1Var.f3760a.p()) {
            w0Var = null;
        } else {
            w0Var = g1Var.f3760a.m(g1Var.f3760a.h(g1Var.f3761b.f14051a, this.f4771j).f4829c, this.f3922a).f4837c;
        }
        P(new b(g1Var, g1Var2, this.f4770i, this.f4765d, z5, i6, i7, booleanValue, intValue, w0Var, i8, z6));
    }

    private void c0(List list, boolean z5) {
        if (this.A && !z5 && !list.isEmpty()) {
            throw new IllegalStateException();
        }
        int size = list.size() + (z5 ? 0 : this.f4773l.size());
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (((w1.v) com.google.android.exoplayer2.util.a.e((w1.v) list.get(i6))) instanceof x1.b) {
                if (size > 1) {
                    throw new IllegalArgumentException();
                }
                this.A = true;
            }
        }
    }

    private List v(int i6, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < list.size(); i7++) {
            e1.c cVar = new e1.c((w1.v) list.get(i7), this.f4774m);
            arrayList.add(cVar);
            this.f4773l.add(i7 + i6, new a(cVar.f3754b, cVar.f3753a.O()));
        }
        this.f4786y = this.f4786y.d(i6, arrayList.size());
        return arrayList;
    }

    private y1 w() {
        return new l1(this.f4773l, this.f4786y);
    }

    private List x(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            arrayList.add(this.f4775n.c((w0) list.get(i6)));
        }
        return arrayList;
    }

    private Pair z(g1 g1Var, g1 g1Var2, boolean z5, int i6, boolean z6) {
        y1 y1Var = g1Var2.f3760a;
        y1 y1Var2 = g1Var.f3760a;
        if (y1Var2.p() && y1Var.p()) {
            return new Pair(Boolean.FALSE, -1);
        }
        int i7 = 3;
        if (y1Var2.p() != y1Var.p()) {
            return new Pair(Boolean.TRUE, 3);
        }
        Object obj = y1Var.m(y1Var.h(g1Var2.f3761b.f14051a, this.f4771j).f4829c, this.f3922a).f4835a;
        Object obj2 = y1Var2.m(y1Var2.h(g1Var.f3761b.f14051a, this.f4771j).f4829c, this.f3922a).f4835a;
        int i8 = this.f3922a.f4846l;
        if (obj.equals(obj2)) {
            return (z5 && i6 == 0 && y1Var2.b(g1Var.f3761b.f14051a) == i8) ? new Pair(Boolean.TRUE, 0) : new Pair(Boolean.FALSE, -1);
        }
        if (z5 && i6 == 0) {
            i7 = 1;
        } else if (z5 && i6 == 1) {
            i7 = 2;
        } else if (!z6) {
            throw new IllegalStateException();
        }
        return new Pair(Boolean.TRUE, Integer.valueOf(i7));
    }

    public void A() {
        this.f4768g.u();
    }

    public Looper B() {
        return this.f4777p;
    }

    public long D() {
        if (a()) {
            g1 g1Var = this.B;
            v.a aVar = g1Var.f3761b;
            g1Var.f3760a.h(aVar.f14051a, this.f4771j);
            return p.b(this.f4771j.b(aVar.f14052b, aVar.f14053c));
        }
        return l();
    }

    public boolean F() {
        return this.B.f3769j;
    }

    public int G() {
        return this.B.f3763d;
    }

    public void R() {
        g1 g1Var = this.B;
        if (g1Var.f3763d != 1) {
            return;
        }
        g1 f6 = g1Var.f(null);
        g1 h6 = f6.h(f6.f3760a.p() ? 4 : 2);
        this.f4781t++;
        this.f4768g.a0();
        b0(h6, false, 4, 1, 1, false);
    }

    public void S() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = com.google.android.exoplayer2.util.s0.f4677e;
        String b6 = r0.b();
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 36 + String.valueOf(str).length() + String.valueOf(b6).length());
        sb.append("Release ");
        sb.append(hexString);
        sb.append(" [");
        sb.append("ExoPlayerLib/2.12.1");
        sb.append("] [");
        sb.append(str);
        sb.append("] [");
        sb.append(b6);
        sb.append("]");
        com.google.android.exoplayer2.util.n.f("ExoPlayerImpl", sb.toString());
        if (!this.f4768g.c0()) {
            O(new n.b() { // from class: com.google.android.exoplayer2.v
                @Override // com.google.android.exoplayer2.n.b
                public final void a(j1.a aVar) {
                    y.M(aVar);
                }
            });
        }
        this.f4766e.removeCallbacksAndMessages(null);
        y0.a aVar = this.f4776o;
        if (aVar != null) {
            this.f4778q.b(aVar);
        }
        g1 h6 = this.B.h(1);
        this.B = h6;
        g1 b7 = h6.b(h6.f3761b);
        this.B = b7;
        b7.f3773n = b7.f3775p;
        this.B.f3774o = 0L;
    }

    public void U(w1.v vVar) {
        V(Collections.singletonList(vVar));
    }

    public void V(List list) {
        X(list, true);
    }

    public void W(List list, int i6, long j6) {
        Y(list, i6, j6, false);
    }

    public void X(List list, boolean z5) {
        Y(list, -1, -9223372036854775807L, z5);
    }

    public void Z(boolean z5, int i6, int i7) {
        g1 g1Var = this.B;
        if (g1Var.f3769j == z5 && g1Var.f3770k == i6) {
            return;
        }
        this.f4781t++;
        g1 e6 = g1Var.e(z5, i6);
        this.f4768g.G0(z5, i6);
        b0(e6, false, 4, 0, i7, false);
    }

    @Override // com.google.android.exoplayer2.j1
    public boolean a() {
        return this.B.f3761b.b();
    }

    public void a0(h1 h1Var) {
        if (h1Var == null) {
            h1Var = h1.f3777d;
        }
        if (this.B.f3771l.equals(h1Var)) {
            return;
        }
        g1 g6 = this.B.g(h1Var);
        this.f4781t++;
        this.f4768g.I0(h1Var);
        b0(g6, false, 4, 0, 1, false);
    }

    @Override // com.google.android.exoplayer2.j1
    public long b() {
        if (a()) {
            g1 g1Var = this.B;
            g1Var.f3760a.h(g1Var.f3761b.f14051a, this.f4771j);
            g1 g1Var2 = this.B;
            return g1Var2.f3762c == -9223372036854775807L ? g1Var2.f3760a.m(j(), this.f3922a).a() : this.f4771j.j() + p.b(this.B.f3762c);
        }
        return k();
    }

    @Override // com.google.android.exoplayer2.j1
    public long c() {
        return p.b(this.B.f3774o);
    }

    @Override // com.google.android.exoplayer2.j1
    public void d(int i6, long j6) {
        y1 y1Var = this.B.f3760a;
        if (i6 < 0 || (!y1Var.p() && i6 >= y1Var.o())) {
            throw new u0(y1Var, i6, j6);
        }
        this.f4781t++;
        if (a()) {
            com.google.android.exoplayer2.util.n.h("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.f4767f.a(new q0.e(this.B));
            return;
        }
        g1 N = N(this.B.h(G() != 1 ? 2 : 1), y1Var, E(y1Var, i6, j6));
        this.f4768g.r0(y1Var, i6, p.a(j6));
        b0(N, true, 1, 0, 1, true);
    }

    @Override // com.google.android.exoplayer2.j1
    public int e() {
        if (this.B.f3760a.p()) {
            return this.D;
        }
        g1 g1Var = this.B;
        return g1Var.f3760a.b(g1Var.f3761b.f14051a);
    }

    @Override // com.google.android.exoplayer2.j1
    public int f() {
        if (a()) {
            return this.B.f3761b.f14052b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.j1
    public void g(List list, boolean z5) {
        X(x(list), z5);
    }

    @Override // com.google.android.exoplayer2.j1
    public int h() {
        if (a()) {
            return this.B.f3761b.f14053c;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.j1
    public y1 i() {
        return this.B.f3760a;
    }

    @Override // com.google.android.exoplayer2.j1
    public int j() {
        int C = C();
        if (C == -1) {
            return 0;
        }
        return C;
    }

    @Override // com.google.android.exoplayer2.j1
    public long k() {
        if (this.B.f3760a.p()) {
            return this.E;
        }
        if (this.B.f3761b.b()) {
            return p.b(this.B.f3775p);
        }
        g1 g1Var = this.B;
        return Q(g1Var.f3761b, g1Var.f3775p);
    }

    public void u(j1.a aVar) {
        com.google.android.exoplayer2.util.a.e(aVar);
        this.f4770i.addIfAbsent(new n.a(aVar));
    }

    public k1 y(k1.b bVar) {
        return new k1(this.f4768g, bVar, this.B.f3760a, j(), this.f4769h);
    }
}
