package w1;

import android.util.Pair;
import com.google.android.exoplayer2.y1;
import w1.v;
/* loaded from: classes.dex */
public final class r extends g {

    /* renamed from: l  reason: collision with root package name */
    private final v f14014l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f14015m;

    /* renamed from: n  reason: collision with root package name */
    private final y1.c f14016n;

    /* renamed from: o  reason: collision with root package name */
    private final y1.b f14017o;

    /* renamed from: p  reason: collision with root package name */
    private a f14018p;

    /* renamed from: q  reason: collision with root package name */
    private q f14019q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f14020r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f14021s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f14022t;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends n {

        /* renamed from: e  reason: collision with root package name */
        public static final Object f14023e = new Object();

        /* renamed from: c  reason: collision with root package name */
        private final Object f14024c;

        /* renamed from: d  reason: collision with root package name */
        private final Object f14025d;

        private a(y1 y1Var, Object obj, Object obj2) {
            super(y1Var);
            this.f14024c = obj;
            this.f14025d = obj2;
        }

        public static a t(com.google.android.exoplayer2.w0 w0Var) {
            return new a(new b(w0Var), y1.c.f4833q, f14023e);
        }

        public static a u(y1 y1Var, Object obj, Object obj2) {
            return new a(y1Var, obj, obj2);
        }

        @Override // w1.n, com.google.android.exoplayer2.y1
        public int b(Object obj) {
            Object obj2;
            y1 y1Var = this.f13883b;
            if (f14023e.equals(obj) && (obj2 = this.f14025d) != null) {
                obj = obj2;
            }
            return y1Var.b(obj);
        }

        @Override // w1.n, com.google.android.exoplayer2.y1
        public y1.b g(int i6, y1.b bVar, boolean z5) {
            this.f13883b.g(i6, bVar, z5);
            if (com.google.android.exoplayer2.util.s0.c(bVar.f4828b, this.f14025d) && z5) {
                bVar.f4828b = f14023e;
            }
            return bVar;
        }

        @Override // w1.n, com.google.android.exoplayer2.y1
        public Object l(int i6) {
            Object l6 = this.f13883b.l(i6);
            return com.google.android.exoplayer2.util.s0.c(l6, this.f14025d) ? f14023e : l6;
        }

        @Override // w1.n, com.google.android.exoplayer2.y1
        public y1.c n(int i6, y1.c cVar, long j6) {
            this.f13883b.n(i6, cVar, j6);
            if (com.google.android.exoplayer2.util.s0.c(cVar.f4835a, this.f14024c)) {
                cVar.f4835a = y1.c.f4833q;
            }
            return cVar;
        }

        public a s(y1 y1Var) {
            return new a(y1Var, this.f14024c, this.f14025d);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends y1 {

        /* renamed from: b  reason: collision with root package name */
        private final com.google.android.exoplayer2.w0 f14026b;

        public b(com.google.android.exoplayer2.w0 w0Var) {
            this.f14026b = w0Var;
        }

        @Override // com.google.android.exoplayer2.y1
        public int b(Object obj) {
            return obj == a.f14023e ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.y1
        public y1.b g(int i6, y1.b bVar, boolean z5) {
            return bVar.m(z5 ? 0 : null, z5 ? a.f14023e : null, 0, -9223372036854775807L, 0L);
        }

        @Override // com.google.android.exoplayer2.y1
        public int i() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.y1
        public Object l(int i6) {
            return a.f14023e;
        }

        @Override // com.google.android.exoplayer2.y1
        public y1.c n(int i6, y1.c cVar, long j6) {
            cVar.e(y1.c.f4833q, this.f14026b, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, false, 0L, -9223372036854775807L, 0, 0, 0L);
            cVar.f4845k = true;
            return cVar;
        }

        @Override // com.google.android.exoplayer2.y1
        public int o() {
            return 1;
        }
    }

    public r(v vVar, boolean z5) {
        this.f14014l = vVar;
        this.f14015m = z5 && vVar.f();
        this.f14016n = new y1.c();
        this.f14017o = new y1.b();
        y1 g6 = vVar.g();
        if (g6 == null) {
            this.f14018p = a.t(vVar.a());
            return;
        }
        this.f14018p = a.u(g6, null, null);
        this.f14022t = true;
    }

    private Object L(Object obj) {
        return (this.f14018p.f14025d == null || !this.f14018p.f14025d.equals(obj)) ? obj : a.f14023e;
    }

    private Object M(Object obj) {
        return (this.f14018p.f14025d == null || !obj.equals(a.f14023e)) ? obj : this.f14018p.f14025d;
    }

    private void Q(long j6) {
        q qVar = this.f14019q;
        int b6 = this.f14018p.b(qVar.f13977b.f14051a);
        if (b6 == -1) {
            return;
        }
        long j7 = this.f14018p.f(b6, this.f14017o).f4830d;
        if (j7 != -9223372036854775807L && j6 >= j7) {
            j6 = Math.max(0L, j7 - 1);
        }
        qVar.w(j6);
    }

    @Override // w1.g, w1.a
    public void A(q2.i0 i0Var) {
        super.A(i0Var);
        if (this.f14015m) {
            return;
        }
        this.f14020r = true;
        J(null, this.f14014l);
    }

    @Override // w1.g, w1.a
    public void C() {
        this.f14021s = false;
        this.f14020r = false;
        super.C();
    }

    @Override // w1.v
    /* renamed from: K */
    public q o(v.a aVar, q2.b bVar, long j6) {
        q qVar = new q(this.f14014l, aVar, bVar, j6);
        if (this.f14021s) {
            qVar.e(aVar.a(M(aVar.f14051a)));
        } else {
            this.f14019q = qVar;
            if (!this.f14020r) {
                this.f14020r = true;
                J(null, this.f14014l);
            }
        }
        return qVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.g
    /* renamed from: N */
    public v.a E(Void r12, v.a aVar) {
        return aVar.a(L(aVar.f14051a));
    }

    public y1 O() {
        return this.f14018p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // w1.g
    /* renamed from: P */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void I(Void r12, v vVar, y1 y1Var) {
        long j6;
        q qVar;
        v.a a6;
        if (this.f14021s) {
            this.f14018p = this.f14018p.s(y1Var);
            q qVar2 = this.f14019q;
            if (qVar2 != null) {
                Q(qVar2.k());
            }
        } else if (y1Var.p()) {
            this.f14018p = this.f14022t ? this.f14018p.s(y1Var) : a.u(y1Var, y1.c.f4833q, a.f14023e);
        } else {
            y1Var.m(0, this.f14016n);
            long b6 = this.f14016n.b();
            q qVar3 = this.f14019q;
            if (qVar3 != null) {
                long p5 = qVar3.p();
                if (p5 != 0) {
                    j6 = p5;
                    y1.c cVar = this.f14016n;
                    Object obj = cVar.f4835a;
                    Pair j7 = y1Var.j(cVar, this.f14017o, 0, j6);
                    Object obj2 = j7.first;
                    long longValue = ((Long) j7.second).longValue();
                    this.f14018p = !this.f14022t ? this.f14018p.s(y1Var) : a.u(y1Var, obj, obj2);
                    qVar = this.f14019q;
                    if (qVar != null) {
                        Q(longValue);
                        v.a aVar = qVar.f13977b;
                        a6 = aVar.a(M(aVar.f14051a));
                        this.f14022t = true;
                        this.f14021s = true;
                        B(this.f14018p);
                        if (a6 == null) {
                            ((q) com.google.android.exoplayer2.util.a.e(this.f14019q)).e(a6);
                            return;
                        }
                        return;
                    }
                }
            }
            j6 = b6;
            y1.c cVar2 = this.f14016n;
            Object obj3 = cVar2.f4835a;
            Pair j72 = y1Var.j(cVar2, this.f14017o, 0, j6);
            Object obj22 = j72.first;
            long longValue2 = ((Long) j72.second).longValue();
            this.f14018p = !this.f14022t ? this.f14018p.s(y1Var) : a.u(y1Var, obj3, obj22);
            qVar = this.f14019q;
            if (qVar != null) {
            }
        }
        a6 = null;
        this.f14022t = true;
        this.f14021s = true;
        B(this.f14018p);
        if (a6 == null) {
        }
    }

    @Override // w1.v
    public com.google.android.exoplayer2.w0 a() {
        return this.f14014l.a();
    }

    @Override // w1.g, w1.v
    public void e() {
    }

    @Override // w1.v
    public void i(t tVar) {
        ((q) tVar).x();
        if (tVar == this.f14019q) {
            this.f14019q = null;
        }
    }
}
