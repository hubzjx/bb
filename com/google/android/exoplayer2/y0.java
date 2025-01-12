package com.google.android.exoplayer2;

import w1.v;
/* loaded from: classes.dex */
final class y0 {

    /* renamed from: a  reason: collision with root package name */
    public final w1.t f4811a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f4812b;

    /* renamed from: c  reason: collision with root package name */
    public final w1.r0[] f4813c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4814d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4815e;

    /* renamed from: f  reason: collision with root package name */
    public z0 f4816f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4817g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f4818h;

    /* renamed from: i  reason: collision with root package name */
    private final p1[] f4819i;

    /* renamed from: j  reason: collision with root package name */
    private final o2.m f4820j;

    /* renamed from: k  reason: collision with root package name */
    private final e1 f4821k;

    /* renamed from: l  reason: collision with root package name */
    private y0 f4822l;

    /* renamed from: m  reason: collision with root package name */
    private w1.y0 f4823m;

    /* renamed from: n  reason: collision with root package name */
    private o2.n f4824n;

    /* renamed from: o  reason: collision with root package name */
    private long f4825o;

    public y0(p1[] p1VarArr, long j6, o2.m mVar, q2.b bVar, e1 e1Var, z0 z0Var, o2.n nVar) {
        this.f4819i = p1VarArr;
        this.f4825o = j6;
        this.f4820j = mVar;
        this.f4821k = e1Var;
        v.a aVar = z0Var.f4852a;
        this.f4812b = aVar.f14051a;
        this.f4816f = z0Var;
        this.f4823m = w1.y0.f14100d;
        this.f4824n = nVar;
        this.f4813c = new w1.r0[p1VarArr.length];
        this.f4818h = new boolean[p1VarArr.length];
        this.f4811a = e(aVar, e1Var, bVar, z0Var.f4853b, z0Var.f4855d);
    }

    private void c(w1.r0[] r0VarArr) {
        int i6 = 0;
        while (true) {
            p1[] p1VarArr = this.f4819i;
            if (i6 >= p1VarArr.length) {
                return;
            }
            if (p1VarArr[i6].i() == 6 && this.f4824n.c(i6)) {
                r0VarArr[i6] = new w1.l();
            }
            i6++;
        }
    }

    private static w1.t e(v.a aVar, e1 e1Var, q2.b bVar, long j6, long j7) {
        w1.t h6 = e1Var.h(aVar, bVar, j6);
        return (j7 == -9223372036854775807L || j7 == Long.MIN_VALUE) ? h6 : new w1.d(h6, true, 0L, j7);
    }

    private void f() {
        if (!r()) {
            return;
        }
        int i6 = 0;
        while (true) {
            o2.n nVar = this.f4824n;
            if (i6 >= nVar.f12477a) {
                return;
            }
            boolean c6 = nVar.c(i6);
            o2.j a6 = this.f4824n.f12479c.a(i6);
            if (c6 && a6 != null) {
                a6.e();
            }
            i6++;
        }
    }

    private void g(w1.r0[] r0VarArr) {
        int i6 = 0;
        while (true) {
            p1[] p1VarArr = this.f4819i;
            if (i6 >= p1VarArr.length) {
                return;
            }
            if (p1VarArr[i6].i() == 6) {
                r0VarArr[i6] = null;
            }
            i6++;
        }
    }

    private void h() {
        if (!r()) {
            return;
        }
        int i6 = 0;
        while (true) {
            o2.n nVar = this.f4824n;
            if (i6 >= nVar.f12477a) {
                return;
            }
            boolean c6 = nVar.c(i6);
            o2.j a6 = this.f4824n.f12479c.a(i6);
            if (c6 && a6 != null) {
                a6.d();
            }
            i6++;
        }
    }

    private boolean r() {
        return this.f4822l == null;
    }

    private static void u(long j6, e1 e1Var, w1.t tVar) {
        try {
            if (j6 == -9223372036854775807L || j6 == Long.MIN_VALUE) {
                e1Var.y(tVar);
            } else {
                e1Var.y(((w1.d) tVar).f13795a);
            }
        } catch (RuntimeException e6) {
            com.google.android.exoplayer2.util.n.d("MediaPeriodHolder", "Period release failed.", e6);
        }
    }

    public long a(o2.n nVar, long j6, boolean z5) {
        return b(nVar, j6, z5, new boolean[this.f4819i.length]);
    }

    public long b(o2.n nVar, long j6, boolean z5, boolean[] zArr) {
        int i6 = 0;
        while (true) {
            boolean z6 = true;
            if (i6 >= nVar.f12477a) {
                break;
            }
            boolean[] zArr2 = this.f4818h;
            if (z5 || !nVar.b(this.f4824n, i6)) {
                z6 = false;
            }
            zArr2[i6] = z6;
            i6++;
        }
        g(this.f4813c);
        f();
        this.f4824n = nVar;
        h();
        o2.k kVar = nVar.f12479c;
        long q5 = this.f4811a.q(kVar.b(), this.f4818h, this.f4813c, zArr, j6);
        c(this.f4813c);
        this.f4815e = false;
        int i7 = 0;
        while (true) {
            w1.r0[] r0VarArr = this.f4813c;
            if (i7 >= r0VarArr.length) {
                return q5;
            }
            if (r0VarArr[i7] != null) {
                com.google.android.exoplayer2.util.a.g(nVar.c(i7));
                if (this.f4819i[i7].i() != 6) {
                    this.f4815e = true;
                }
            } else {
                com.google.android.exoplayer2.util.a.g(kVar.a(i7) == null);
            }
            i7++;
        }
    }

    public void d(long j6) {
        com.google.android.exoplayer2.util.a.g(r());
        this.f4811a.h(y(j6));
    }

    public long i() {
        if (this.f4814d) {
            long f6 = this.f4815e ? this.f4811a.f() : Long.MIN_VALUE;
            return f6 == Long.MIN_VALUE ? this.f4816f.f4856e : f6;
        }
        return this.f4816f.f4853b;
    }

    public y0 j() {
        return this.f4822l;
    }

    public long k() {
        if (this.f4814d) {
            return this.f4811a.d();
        }
        return 0L;
    }

    public long l() {
        return this.f4825o;
    }

    public long m() {
        return this.f4816f.f4853b + this.f4825o;
    }

    public w1.y0 n() {
        return this.f4823m;
    }

    public o2.n o() {
        return this.f4824n;
    }

    public void p(float f6, y1 y1Var) {
        this.f4814d = true;
        this.f4823m = this.f4811a.n();
        o2.n v5 = v(f6, y1Var);
        z0 z0Var = this.f4816f;
        long j6 = z0Var.f4853b;
        long j7 = z0Var.f4856e;
        if (j7 != -9223372036854775807L && j6 >= j7) {
            j6 = Math.max(0L, j7 - 1);
        }
        long a6 = a(v5, j6, false);
        long j8 = this.f4825o;
        z0 z0Var2 = this.f4816f;
        this.f4825o = j8 + (z0Var2.f4853b - a6);
        this.f4816f = z0Var2.b(a6);
    }

    public boolean q() {
        return this.f4814d && (!this.f4815e || this.f4811a.f() == Long.MIN_VALUE);
    }

    public void s(long j6) {
        com.google.android.exoplayer2.util.a.g(r());
        if (this.f4814d) {
            this.f4811a.i(y(j6));
        }
    }

    public void t() {
        f();
        u(this.f4816f.f4855d, this.f4821k, this.f4811a);
    }

    public o2.n v(float f6, y1 y1Var) {
        o2.j[] b6;
        o2.n d6 = this.f4820j.d(this.f4819i, n(), this.f4816f.f4852a, y1Var);
        for (o2.j jVar : d6.f12479c.b()) {
            if (jVar != null) {
                jVar.o(f6);
            }
        }
        return d6;
    }

    public void w(y0 y0Var) {
        if (y0Var == this.f4822l) {
            return;
        }
        f();
        this.f4822l = y0Var;
        h();
    }

    public void x(long j6) {
        this.f4825o = j6;
    }

    public long y(long j6) {
        return j6 - l();
    }

    public long z(long j6) {
        return j6 + l();
    }
}
