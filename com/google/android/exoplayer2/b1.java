package com.google.android.exoplayer2;

import android.os.Handler;
import android.util.Pair;
import com.google.android.exoplayer2.y1;
import com.google.common.collect.y;
import w1.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: a  reason: collision with root package name */
    private final y1.b f3560a = new y1.b();

    /* renamed from: b  reason: collision with root package name */
    private final y1.c f3561b = new y1.c();

    /* renamed from: c  reason: collision with root package name */
    private final y0.a f3562c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f3563d;

    /* renamed from: e  reason: collision with root package name */
    private long f3564e;

    /* renamed from: f  reason: collision with root package name */
    private int f3565f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3566g;

    /* renamed from: h  reason: collision with root package name */
    private y0 f3567h;

    /* renamed from: i  reason: collision with root package name */
    private y0 f3568i;

    /* renamed from: j  reason: collision with root package name */
    private y0 f3569j;

    /* renamed from: k  reason: collision with root package name */
    private int f3570k;

    /* renamed from: l  reason: collision with root package name */
    private Object f3571l;

    /* renamed from: m  reason: collision with root package name */
    private long f3572m;

    public b1(y0.a aVar, Handler handler) {
        this.f3562c = aVar;
        this.f3563d = handler;
    }

    private static v.a A(y1 y1Var, Object obj, long j6, long j7, y1.b bVar) {
        y1Var.h(obj, bVar);
        int d6 = bVar.d(j6);
        return d6 == -1 ? new v.a(obj, j7, bVar.c(j6)) : new v.a(obj, d6, bVar.h(d6), j7);
    }

    private long B(y1 y1Var, Object obj) {
        int b6;
        int i6 = y1Var.h(obj, this.f3560a).f4829c;
        Object obj2 = this.f3571l;
        if (obj2 == null || (b6 = y1Var.b(obj2)) == -1 || y1Var.f(b6, this.f3560a).f4829c != i6) {
            y0 y0Var = this.f3567h;
            while (true) {
                if (y0Var == null) {
                    y0Var = this.f3567h;
                    while (y0Var != null) {
                        int b7 = y1Var.b(y0Var.f4812b);
                        if (b7 == -1 || y1Var.f(b7, this.f3560a).f4829c != i6) {
                            y0Var = y0Var.j();
                        }
                    }
                    long j6 = this.f3564e;
                    this.f3564e = 1 + j6;
                    if (this.f3567h == null) {
                        this.f3571l = obj;
                        this.f3572m = j6;
                    }
                    return j6;
                } else if (y0Var.f4812b.equals(obj)) {
                    break;
                } else {
                    y0Var = y0Var.j();
                }
            }
            return y0Var.f4816f.f4852a.f14054d;
        }
        return this.f3572m;
    }

    private boolean D(y1 y1Var) {
        y0 y0Var = this.f3567h;
        if (y0Var == null) {
            return true;
        }
        int b6 = y1Var.b(y0Var.f4812b);
        while (true) {
            b6 = y1Var.d(b6, this.f3560a, this.f3561b, this.f3565f, this.f3566g);
            while (y0Var.j() != null && !y0Var.f4816f.f4857f) {
                y0Var = y0Var.j();
            }
            y0 j6 = y0Var.j();
            if (b6 == -1 || j6 == null || y1Var.b(j6.f4812b) != b6) {
                break;
            }
            y0Var = j6;
        }
        boolean y5 = y(y0Var);
        y0Var.f4816f = q(y1Var, y0Var.f4816f);
        return !y5;
    }

    private boolean d(long j6, long j7) {
        return j6 == -9223372036854775807L || j6 == j7;
    }

    private boolean e(z0 z0Var, z0 z0Var2) {
        return z0Var.f4853b == z0Var2.f4853b && z0Var.f4852a.equals(z0Var2.f4852a);
    }

    private z0 h(g1 g1Var) {
        return k(g1Var.f3760a, g1Var.f3761b, g1Var.f3762c, g1Var.f3775p);
    }

    private z0 i(y1 y1Var, y0 y0Var, long j6) {
        long j7;
        z0 z0Var = y0Var.f4816f;
        long l6 = (y0Var.l() + z0Var.f4856e) - j6;
        if (z0Var.f4857f) {
            long j8 = 0;
            int d6 = y1Var.d(y1Var.b(z0Var.f4852a.f14051a), this.f3560a, this.f3561b, this.f3565f, this.f3566g);
            if (d6 == -1) {
                return null;
            }
            int i6 = y1Var.g(d6, this.f3560a, true).f4829c;
            Object obj = this.f3560a.f4828b;
            long j9 = z0Var.f4852a.f14054d;
            if (y1Var.m(i6, this.f3561b).f4846l == d6) {
                Pair k6 = y1Var.k(this.f3561b, this.f3560a, i6, -9223372036854775807L, Math.max(0L, l6));
                if (k6 == null) {
                    return null;
                }
                obj = k6.first;
                long longValue = ((Long) k6.second).longValue();
                y0 j10 = y0Var.j();
                if (j10 == null || !j10.f4812b.equals(obj)) {
                    j9 = this.f3564e;
                    this.f3564e = 1 + j9;
                } else {
                    j9 = j10.f4816f.f4852a.f14054d;
                }
                j7 = longValue;
                j8 = -9223372036854775807L;
            } else {
                j7 = 0;
            }
            return k(y1Var, A(y1Var, obj, j7, j9, this.f3560a), j8, j7);
        }
        v.a aVar = z0Var.f4852a;
        y1Var.h(aVar.f14051a, this.f3560a);
        if (!aVar.b()) {
            int d7 = this.f3560a.d(z0Var.f4855d);
            if (d7 == -1) {
                Object obj2 = aVar.f14051a;
                long j11 = z0Var.f4856e;
                return m(y1Var, obj2, j11, j11, aVar.f14054d);
            }
            int h6 = this.f3560a.h(d7);
            if (this.f3560a.l(d7, h6)) {
                return l(y1Var, aVar.f14051a, d7, h6, z0Var.f4856e, aVar.f14054d);
            }
            return null;
        }
        int i7 = aVar.f14052b;
        int a6 = this.f3560a.a(i7);
        if (a6 == -1) {
            return null;
        }
        int i8 = this.f3560a.i(i7, aVar.f14053c);
        if (i8 < a6) {
            if (this.f3560a.l(i7, i8)) {
                return l(y1Var, aVar.f14051a, i7, i8, z0Var.f4854c, aVar.f14054d);
            }
            return null;
        }
        long j12 = z0Var.f4854c;
        if (j12 == -9223372036854775807L) {
            y1.c cVar = this.f3561b;
            y1.b bVar = this.f3560a;
            Pair k7 = y1Var.k(cVar, bVar, bVar.f4829c, -9223372036854775807L, Math.max(0L, l6));
            if (k7 == null) {
                return null;
            }
            j12 = ((Long) k7.second).longValue();
        }
        return m(y1Var, aVar.f14051a, j12, z0Var.f4854c, aVar.f14054d);
    }

    private z0 k(y1 y1Var, v.a aVar, long j6, long j7) {
        y1Var.h(aVar.f14051a, this.f3560a);
        if (aVar.b()) {
            if (this.f3560a.l(aVar.f14052b, aVar.f14053c)) {
                return l(y1Var, aVar.f14051a, aVar.f14052b, aVar.f14053c, j6, aVar.f14054d);
            }
            return null;
        }
        return m(y1Var, aVar.f14051a, j7, j6, aVar.f14054d);
    }

    private z0 l(y1 y1Var, Object obj, int i6, int i7, long j6, long j7) {
        v.a aVar = new v.a(obj, i6, i7, j7);
        long b6 = y1Var.h(aVar.f14051a, this.f3560a).b(aVar.f14052b, aVar.f14053c);
        long f6 = i7 == this.f3560a.h(i6) ? this.f3560a.f() : 0L;
        return new z0(aVar, (b6 == -9223372036854775807L || f6 < b6) ? f6 : Math.max(0L, b6 - 1), j6, -9223372036854775807L, b6, false, false, false);
    }

    private z0 m(y1 y1Var, Object obj, long j6, long j7, long j8) {
        long j9 = j6;
        y1Var.h(obj, this.f3560a);
        int c6 = this.f3560a.c(j9);
        v.a aVar = new v.a(obj, j8, c6);
        boolean r5 = r(aVar);
        boolean t5 = t(y1Var, aVar);
        boolean s5 = s(y1Var, aVar, r5);
        long e6 = c6 != -1 ? this.f3560a.e(c6) : -9223372036854775807L;
        long j10 = (e6 == -9223372036854775807L || e6 == Long.MIN_VALUE) ? this.f3560a.f4830d : e6;
        if (j10 != -9223372036854775807L && j9 >= j10) {
            j9 = Math.max(0L, j10 - 1);
        }
        return new z0(aVar, j9, j7, e6, j10, r5, t5, s5);
    }

    private boolean r(v.a aVar) {
        return !aVar.b() && aVar.f14055e == -1;
    }

    private boolean s(y1 y1Var, v.a aVar, boolean z5) {
        int b6 = y1Var.b(aVar.f14051a);
        return !y1Var.m(y1Var.f(b6, this.f3560a).f4829c, this.f3561b).f4843i && y1Var.q(b6, this.f3560a, this.f3561b, this.f3565f, this.f3566g) && z5;
    }

    private boolean t(y1 y1Var, v.a aVar) {
        if (r(aVar)) {
            return y1Var.m(y1Var.h(aVar.f14051a, this.f3560a).f4829c, this.f3561b).f4847m == y1Var.b(aVar.f14051a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(y.a aVar, v.a aVar2) {
        this.f3562c.g0(aVar.j(), aVar2);
    }

    private void w() {
        if (this.f3562c != null) {
            final y.a builder = com.google.common.collect.y.builder();
            for (y0 y0Var = this.f3567h; y0Var != null; y0Var = y0Var.j()) {
                builder.a(y0Var.f4816f.f4852a);
            }
            y0 y0Var2 = this.f3568i;
            final v.a aVar = y0Var2 == null ? null : y0Var2.f4816f.f4852a;
            this.f3563d.post(new Runnable() { // from class: com.google.android.exoplayer2.a1
                @Override // java.lang.Runnable
                public final void run() {
                    b1.this.v(builder, aVar);
                }
            });
        }
    }

    public boolean C() {
        y0 y0Var = this.f3569j;
        return y0Var == null || (!y0Var.f4816f.f4859h && y0Var.q() && this.f3569j.f4816f.f4856e != -9223372036854775807L && this.f3570k < 100);
    }

    public boolean E(y1 y1Var, long j6, long j7) {
        z0 z0Var;
        y0 y0Var = this.f3567h;
        y0 y0Var2 = null;
        while (y0Var != null) {
            z0 z0Var2 = y0Var.f4816f;
            if (y0Var2 != null) {
                z0 i6 = i(y1Var, y0Var2, j6);
                if (i6 != null && e(z0Var2, i6)) {
                    z0Var = i6;
                }
                return !y(y0Var2);
            }
            z0Var = q(y1Var, z0Var2);
            y0Var.f4816f = z0Var.a(z0Var2.f4854c);
            if (!d(z0Var2.f4856e, z0Var.f4856e)) {
                long j8 = z0Var.f4856e;
                return (y(y0Var) || (y0Var == this.f3568i && ((j7 > Long.MIN_VALUE ? 1 : (j7 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j7 > ((j8 > (-9223372036854775807L) ? 1 : (j8 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : y0Var.z(j8)) ? 1 : (j7 == ((j8 > (-9223372036854775807L) ? 1 : (j8 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : y0Var.z(j8)) ? 0 : -1)) >= 0))) ? false : true;
            }
            y0Var2 = y0Var;
            y0Var = y0Var.j();
        }
        return true;
    }

    public boolean F(y1 y1Var, int i6) {
        this.f3565f = i6;
        return D(y1Var);
    }

    public boolean G(y1 y1Var, boolean z5) {
        this.f3566g = z5;
        return D(y1Var);
    }

    public y0 b() {
        y0 y0Var = this.f3567h;
        if (y0Var == null) {
            return null;
        }
        if (y0Var == this.f3568i) {
            this.f3568i = y0Var.j();
        }
        this.f3567h.t();
        int i6 = this.f3570k - 1;
        this.f3570k = i6;
        if (i6 == 0) {
            this.f3569j = null;
            y0 y0Var2 = this.f3567h;
            this.f3571l = y0Var2.f4812b;
            this.f3572m = y0Var2.f4816f.f4852a.f14054d;
        }
        this.f3567h = this.f3567h.j();
        w();
        return this.f3567h;
    }

    public y0 c() {
        y0 y0Var = this.f3568i;
        com.google.android.exoplayer2.util.a.g((y0Var == null || y0Var.j() == null) ? false : true);
        this.f3568i = this.f3568i.j();
        w();
        return this.f3568i;
    }

    public void f() {
        if (this.f3570k == 0) {
            return;
        }
        y0 y0Var = (y0) com.google.android.exoplayer2.util.a.i(this.f3567h);
        this.f3571l = y0Var.f4812b;
        this.f3572m = y0Var.f4816f.f4852a.f14054d;
        while (y0Var != null) {
            y0Var.t();
            y0Var = y0Var.j();
        }
        this.f3567h = null;
        this.f3569j = null;
        this.f3568i = null;
        this.f3570k = 0;
        w();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (r1 != (-9223372036854775807L)) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public y0 g(p1[] p1VarArr, o2.m mVar, q2.b bVar, e1 e1Var, z0 z0Var, o2.n nVar) {
        long l6;
        y0 y0Var = this.f3569j;
        if (y0Var == null) {
            if (z0Var.f4852a.b()) {
                l6 = z0Var.f4854c;
            }
            l6 = 0;
        } else {
            l6 = (y0Var.l() + this.f3569j.f4816f.f4856e) - z0Var.f4853b;
        }
        y0 y0Var2 = new y0(p1VarArr, l6, mVar, bVar, e1Var, z0Var, nVar);
        y0 y0Var3 = this.f3569j;
        if (y0Var3 != null) {
            y0Var3.w(y0Var2);
        } else {
            this.f3567h = y0Var2;
            this.f3568i = y0Var2;
        }
        this.f3571l = null;
        this.f3569j = y0Var2;
        this.f3570k++;
        w();
        return y0Var2;
    }

    public y0 j() {
        return this.f3569j;
    }

    public z0 n(long j6, g1 g1Var) {
        y0 y0Var = this.f3569j;
        return y0Var == null ? h(g1Var) : i(g1Var.f3760a, y0Var, j6);
    }

    public y0 o() {
        return this.f3567h;
    }

    public y0 p() {
        return this.f3568i;
    }

    public z0 q(y1 y1Var, z0 z0Var) {
        long j6;
        v.a aVar = z0Var.f4852a;
        boolean r5 = r(aVar);
        boolean t5 = t(y1Var, aVar);
        boolean s5 = s(y1Var, aVar, r5);
        y1Var.h(z0Var.f4852a.f14051a, this.f3560a);
        if (aVar.b()) {
            j6 = this.f3560a.b(aVar.f14052b, aVar.f14053c);
        } else {
            j6 = z0Var.f4855d;
            if (j6 == -9223372036854775807L || j6 == Long.MIN_VALUE) {
                j6 = this.f3560a.g();
            }
        }
        return new z0(aVar, z0Var.f4853b, z0Var.f4854c, z0Var.f4855d, j6, r5, t5, s5);
    }

    public boolean u(w1.t tVar) {
        y0 y0Var = this.f3569j;
        return y0Var != null && y0Var.f4811a == tVar;
    }

    public void x(long j6) {
        y0 y0Var = this.f3569j;
        if (y0Var != null) {
            y0Var.s(j6);
        }
    }

    public boolean y(y0 y0Var) {
        boolean z5 = false;
        com.google.android.exoplayer2.util.a.g(y0Var != null);
        if (y0Var.equals(this.f3569j)) {
            return false;
        }
        this.f3569j = y0Var;
        while (y0Var.j() != null) {
            y0Var = y0Var.j();
            if (y0Var == this.f3568i) {
                this.f3568i = this.f3567h;
                z5 = true;
            }
            y0Var.t();
            this.f3570k--;
        }
        this.f3569j.w(null);
        w();
        return z5;
    }

    public v.a z(y1 y1Var, Object obj, long j6) {
        return A(y1Var, obj, j6, B(y1Var, obj), this.f3560a);
    }
}
