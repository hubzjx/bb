package com.google.android.exoplayer2;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.w0;
import x1.a;
/* loaded from: classes.dex */
public abstract class y1 {

    /* renamed from: a  reason: collision with root package name */
    public static final y1 f4826a = new a();

    /* loaded from: classes.dex */
    class a extends y1 {
        a() {
        }

        @Override // com.google.android.exoplayer2.y1
        public int b(Object obj) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.y1
        public b g(int i6, b bVar, boolean z5) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.y1
        public int i() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.y1
        public Object l(int i6) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.y1
        public c n(int i6, c cVar, long j6) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.y1
        public int o() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Object f4827a;

        /* renamed from: b  reason: collision with root package name */
        public Object f4828b;

        /* renamed from: c  reason: collision with root package name */
        public int f4829c;

        /* renamed from: d  reason: collision with root package name */
        public long f4830d;

        /* renamed from: e  reason: collision with root package name */
        private long f4831e;

        /* renamed from: f  reason: collision with root package name */
        private x1.a f4832f = x1.a.f14181f;

        public int a(int i6) {
            return this.f4832f.f14184c[i6].f14187a;
        }

        public long b(int i6, int i7) {
            a.C0225a c0225a = this.f4832f.f14184c[i6];
            if (c0225a.f14187a != -1) {
                return c0225a.f14190d[i7];
            }
            return -9223372036854775807L;
        }

        public int c(long j6) {
            return this.f4832f.a(j6, this.f4830d);
        }

        public int d(long j6) {
            return this.f4832f.b(j6, this.f4830d);
        }

        public long e(int i6) {
            return this.f4832f.f14183b[i6];
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return com.google.android.exoplayer2.util.s0.c(this.f4827a, bVar.f4827a) && com.google.android.exoplayer2.util.s0.c(this.f4828b, bVar.f4828b) && this.f4829c == bVar.f4829c && this.f4830d == bVar.f4830d && this.f4831e == bVar.f4831e && com.google.android.exoplayer2.util.s0.c(this.f4832f, bVar.f4832f);
        }

        public long f() {
            return this.f4832f.f14185d;
        }

        public long g() {
            return this.f4830d;
        }

        public int h(int i6) {
            return this.f4832f.f14184c[i6].a();
        }

        public int hashCode() {
            Object obj = this.f4827a;
            int hashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f4828b;
            int hashCode2 = obj2 != null ? obj2.hashCode() : 0;
            long j6 = this.f4830d;
            long j7 = this.f4831e;
            return ((((((((hashCode + hashCode2) * 31) + this.f4829c) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + this.f4832f.hashCode();
        }

        public int i(int i6, int i7) {
            return this.f4832f.f14184c[i6].b(i7);
        }

        public long j() {
            return p.b(this.f4831e);
        }

        public long k() {
            return this.f4831e;
        }

        public boolean l(int i6, int i7) {
            a.C0225a c0225a = this.f4832f.f14184c[i6];
            return (c0225a.f14187a == -1 || c0225a.f14189c[i7] == 0) ? false : true;
        }

        public b m(Object obj, Object obj2, int i6, long j6, long j7) {
            return n(obj, obj2, i6, j6, j7, x1.a.f14181f);
        }

        public b n(Object obj, Object obj2, int i6, long j6, long j7, x1.a aVar) {
            this.f4827a = obj;
            this.f4828b = obj2;
            this.f4829c = i6;
            this.f4830d = j6;
            this.f4831e = j7;
            this.f4832f = aVar;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: q  reason: collision with root package name */
        public static final Object f4833q = new Object();

        /* renamed from: r  reason: collision with root package name */
        private static final w0 f4834r = new w0.b().c("com.google.android.exoplayer2.Timeline").g(Uri.EMPTY).a();

        /* renamed from: b  reason: collision with root package name */
        public Object f4836b;

        /* renamed from: d  reason: collision with root package name */
        public Object f4838d;

        /* renamed from: e  reason: collision with root package name */
        public long f4839e;

        /* renamed from: f  reason: collision with root package name */
        public long f4840f;

        /* renamed from: g  reason: collision with root package name */
        public long f4841g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f4842h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f4843i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f4844j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f4845k;

        /* renamed from: l  reason: collision with root package name */
        public int f4846l;

        /* renamed from: m  reason: collision with root package name */
        public int f4847m;

        /* renamed from: n  reason: collision with root package name */
        public long f4848n;

        /* renamed from: o  reason: collision with root package name */
        public long f4849o;

        /* renamed from: p  reason: collision with root package name */
        public long f4850p;

        /* renamed from: a  reason: collision with root package name */
        public Object f4835a = f4833q;

        /* renamed from: c  reason: collision with root package name */
        public w0 f4837c = f4834r;

        public long a() {
            return p.b(this.f4848n);
        }

        public long b() {
            return this.f4848n;
        }

        public long c() {
            return p.b(this.f4849o);
        }

        public long d() {
            return this.f4850p;
        }

        public c e(Object obj, w0 w0Var, Object obj2, long j6, long j7, long j8, boolean z5, boolean z6, boolean z7, long j9, long j10, int i6, int i7, long j11) {
            w0.e eVar;
            this.f4835a = obj;
            this.f4837c = w0Var != null ? w0Var : f4834r;
            this.f4836b = (w0Var == null || (eVar = w0Var.f4702b) == null) ? null : eVar.f4747h;
            this.f4838d = obj2;
            this.f4839e = j6;
            this.f4840f = j7;
            this.f4841g = j8;
            this.f4842h = z5;
            this.f4843i = z6;
            this.f4844j = z7;
            this.f4848n = j9;
            this.f4849o = j10;
            this.f4846l = i6;
            this.f4847m = i7;
            this.f4850p = j11;
            this.f4845k = false;
            return this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !c.class.equals(obj.getClass())) {
                return false;
            }
            c cVar = (c) obj;
            return com.google.android.exoplayer2.util.s0.c(this.f4835a, cVar.f4835a) && com.google.android.exoplayer2.util.s0.c(this.f4837c, cVar.f4837c) && com.google.android.exoplayer2.util.s0.c(this.f4838d, cVar.f4838d) && this.f4839e == cVar.f4839e && this.f4840f == cVar.f4840f && this.f4841g == cVar.f4841g && this.f4842h == cVar.f4842h && this.f4843i == cVar.f4843i && this.f4844j == cVar.f4844j && this.f4845k == cVar.f4845k && this.f4848n == cVar.f4848n && this.f4849o == cVar.f4849o && this.f4846l == cVar.f4846l && this.f4847m == cVar.f4847m && this.f4850p == cVar.f4850p;
        }

        public int hashCode() {
            int hashCode = (((217 + this.f4835a.hashCode()) * 31) + this.f4837c.hashCode()) * 31;
            Object obj = this.f4838d;
            int hashCode2 = obj == null ? 0 : obj.hashCode();
            long j6 = this.f4839e;
            long j7 = this.f4840f;
            long j8 = this.f4841g;
            long j9 = this.f4848n;
            long j10 = this.f4849o;
            long j11 = this.f4850p;
            return ((((((((((((((((((((((((hashCode + hashCode2) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.f4842h ? 1 : 0)) * 31) + (this.f4843i ? 1 : 0)) * 31) + (this.f4844j ? 1 : 0)) * 31) + (this.f4845k ? 1 : 0)) * 31) + ((int) (j9 ^ (j9 >>> 32)))) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.f4846l) * 31) + this.f4847m) * 31) + ((int) (j11 ^ (j11 >>> 32)));
        }
    }

    public int a(boolean z5) {
        return p() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z5) {
        if (p()) {
            return -1;
        }
        return o() - 1;
    }

    public final int d(int i6, b bVar, c cVar, int i7, boolean z5) {
        int i8 = f(i6, bVar).f4829c;
        if (m(i8, cVar).f4847m == i6) {
            int e6 = e(i8, i7, z5);
            if (e6 == -1) {
                return -1;
            }
            return m(e6, cVar).f4846l;
        }
        return i6 + 1;
    }

    public int e(int i6, int i7, boolean z5) {
        if (i7 == 0) {
            if (i6 == c(z5)) {
                return -1;
            }
            return i6 + 1;
        } else if (i7 != 1) {
            if (i7 == 2) {
                return i6 == c(z5) ? a(z5) : i6 + 1;
            }
            throw new IllegalStateException();
        } else {
            return i6;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y1) {
            y1 y1Var = (y1) obj;
            if (y1Var.o() == o() && y1Var.i() == i()) {
                c cVar = new c();
                b bVar = new b();
                c cVar2 = new c();
                b bVar2 = new b();
                for (int i6 = 0; i6 < o(); i6++) {
                    if (!m(i6, cVar).equals(y1Var.m(i6, cVar2))) {
                        return false;
                    }
                }
                for (int i7 = 0; i7 < i(); i7++) {
                    if (!g(i7, bVar, true).equals(y1Var.g(i7, bVar2, true))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final b f(int i6, b bVar) {
        return g(i6, bVar, false);
    }

    public abstract b g(int i6, b bVar, boolean z5);

    public b h(Object obj, b bVar) {
        return g(b(obj), bVar, true);
    }

    public int hashCode() {
        int i6;
        c cVar = new c();
        b bVar = new b();
        int o5 = 217 + o();
        int i7 = 0;
        while (true) {
            i6 = o5 * 31;
            if (i7 >= o()) {
                break;
            }
            o5 = i6 + m(i7, cVar).hashCode();
            i7++;
        }
        int i8 = i6 + i();
        for (int i9 = 0; i9 < i(); i9++) {
            i8 = (i8 * 31) + g(i9, bVar, true).hashCode();
        }
        return i8;
    }

    public abstract int i();

    public final Pair j(c cVar, b bVar, int i6, long j6) {
        return (Pair) com.google.android.exoplayer2.util.a.e(k(cVar, bVar, i6, j6, 0L));
    }

    public final Pair k(c cVar, b bVar, int i6, long j6, long j7) {
        com.google.android.exoplayer2.util.a.c(i6, 0, o());
        n(i6, cVar, j7);
        if (j6 == -9223372036854775807L) {
            j6 = cVar.b();
            if (j6 == -9223372036854775807L) {
                return null;
            }
        }
        int i7 = cVar.f4846l;
        long d6 = cVar.d() + j6;
        while (true) {
            long g6 = g(i7, bVar, true).g();
            if (g6 == -9223372036854775807L || d6 < g6 || i7 >= cVar.f4847m) {
                break;
            }
            d6 -= g6;
            i7++;
        }
        return Pair.create(com.google.android.exoplayer2.util.a.e(bVar.f4828b), Long.valueOf(d6));
    }

    public abstract Object l(int i6);

    public final c m(int i6, c cVar) {
        return n(i6, cVar, 0L);
    }

    public abstract c n(int i6, c cVar, long j6);

    public abstract int o();

    public final boolean p() {
        return o() == 0;
    }

    public final boolean q(int i6, b bVar, c cVar, int i7, boolean z5) {
        return d(i6, bVar, cVar, i7, z5) == -1;
    }
}
