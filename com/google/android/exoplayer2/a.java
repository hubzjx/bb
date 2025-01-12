package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.y1;
/* loaded from: classes.dex */
public abstract class a extends y1 {

    /* renamed from: b  reason: collision with root package name */
    private final int f3301b;

    /* renamed from: c  reason: collision with root package name */
    private final w1.t0 f3302c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3303d;

    public a(boolean z5, w1.t0 t0Var) {
        this.f3303d = z5;
        this.f3302c = t0Var;
        this.f3301b = t0Var.a();
    }

    private int A(int i6, boolean z5) {
        if (z5) {
            return this.f3302c.c(i6);
        }
        if (i6 < this.f3301b - 1) {
            return i6 + 1;
        }
        return -1;
    }

    private int B(int i6, boolean z5) {
        if (z5) {
            return this.f3302c.f(i6);
        }
        if (i6 > 0) {
            return i6 - 1;
        }
        return -1;
    }

    public static Object u(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object v(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object x(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    protected abstract y1 C(int i6);

    @Override // com.google.android.exoplayer2.y1
    public int a(boolean z5) {
        if (this.f3301b == 0) {
            return -1;
        }
        if (this.f3303d) {
            z5 = false;
        }
        int e6 = z5 ? this.f3302c.e() : 0;
        while (C(e6).p()) {
            e6 = A(e6, z5);
            if (e6 == -1) {
                return -1;
            }
        }
        return z(e6) + C(e6).a(z5);
    }

    @Override // com.google.android.exoplayer2.y1
    public final int b(Object obj) {
        int b6;
        if (obj instanceof Pair) {
            Object v5 = v(obj);
            Object u5 = u(obj);
            int r5 = r(v5);
            if (r5 == -1 || (b6 = C(r5).b(u5)) == -1) {
                return -1;
            }
            return y(r5) + b6;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.y1
    public int c(boolean z5) {
        int i6 = this.f3301b;
        if (i6 == 0) {
            return -1;
        }
        if (this.f3303d) {
            z5 = false;
        }
        int g6 = z5 ? this.f3302c.g() : i6 - 1;
        while (C(g6).p()) {
            g6 = B(g6, z5);
            if (g6 == -1) {
                return -1;
            }
        }
        return z(g6) + C(g6).c(z5);
    }

    @Override // com.google.android.exoplayer2.y1
    public int e(int i6, int i7, boolean z5) {
        if (this.f3303d) {
            if (i7 == 1) {
                i7 = 2;
            }
            z5 = false;
        }
        int t5 = t(i6);
        int z6 = z(t5);
        int e6 = C(t5).e(i6 - z6, i7 != 2 ? i7 : 0, z5);
        if (e6 != -1) {
            return z6 + e6;
        }
        int A = A(t5, z5);
        while (A != -1 && C(A).p()) {
            A = A(A, z5);
        }
        if (A != -1) {
            return z(A) + C(A).a(z5);
        }
        if (i7 == 2) {
            return a(z5);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.y1
    public final y1.b g(int i6, y1.b bVar, boolean z5) {
        int s5 = s(i6);
        int z6 = z(s5);
        C(s5).g(i6 - y(s5), bVar, z5);
        bVar.f4829c += z6;
        if (z5) {
            bVar.f4828b = x(w(s5), com.google.android.exoplayer2.util.a.e(bVar.f4828b));
        }
        return bVar;
    }

    @Override // com.google.android.exoplayer2.y1
    public final y1.b h(Object obj, y1.b bVar) {
        Object v5 = v(obj);
        Object u5 = u(obj);
        int r5 = r(v5);
        int z5 = z(r5);
        C(r5).h(u5, bVar);
        bVar.f4829c += z5;
        bVar.f4828b = obj;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.y1
    public final Object l(int i6) {
        int s5 = s(i6);
        return x(w(s5), C(s5).l(i6 - y(s5)));
    }

    @Override // com.google.android.exoplayer2.y1
    public final y1.c n(int i6, y1.c cVar, long j6) {
        int t5 = t(i6);
        int z5 = z(t5);
        int y5 = y(t5);
        C(t5).n(i6 - z5, cVar, j6);
        Object w5 = w(t5);
        if (!y1.c.f4833q.equals(cVar.f4835a)) {
            w5 = x(w5, cVar.f4835a);
        }
        cVar.f4835a = w5;
        cVar.f4846l += y5;
        cVar.f4847m += y5;
        return cVar;
    }

    protected abstract int r(Object obj);

    protected abstract int s(int i6);

    protected abstract int t(int i6);

    protected abstract Object w(int i6);

    protected abstract int y(int i6);

    protected abstract int z(int i6);
}
