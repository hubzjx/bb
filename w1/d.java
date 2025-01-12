package w1;

import com.google.android.exoplayer2.s1;
import w1.t;
/* loaded from: classes.dex */
public final class d implements t, t.a {

    /* renamed from: a  reason: collision with root package name */
    public final t f13795a;

    /* renamed from: b  reason: collision with root package name */
    private t.a f13796b;

    /* renamed from: c  reason: collision with root package name */
    private a[] f13797c = new a[0];

    /* renamed from: d  reason: collision with root package name */
    private long f13798d;

    /* renamed from: e  reason: collision with root package name */
    long f13799e;

    /* renamed from: f  reason: collision with root package name */
    long f13800f;

    /* loaded from: classes.dex */
    private final class a implements r0 {

        /* renamed from: a  reason: collision with root package name */
        public final r0 f13801a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f13802b;

        public a(r0 r0Var) {
            this.f13801a = r0Var;
        }

        public void a() {
            this.f13802b = false;
        }

        @Override // w1.r0
        public void b() {
            this.f13801a.b();
        }

        @Override // w1.r0
        public int e(com.google.android.exoplayer2.t0 t0Var, com.google.android.exoplayer2.decoder.j jVar, boolean z5) {
            if (d.this.k()) {
                return -3;
            }
            if (this.f13802b) {
                jVar.setFlags(4);
                return -4;
            }
            int e6 = this.f13801a.e(t0Var, jVar, z5);
            if (e6 == -5) {
                com.google.android.exoplayer2.s0 s0Var = (com.google.android.exoplayer2.s0) com.google.android.exoplayer2.util.a.e(t0Var.f4441b);
                int i6 = s0Var.D;
                if (i6 != 0 || s0Var.E != 0) {
                    d dVar = d.this;
                    if (dVar.f13799e != 0) {
                        i6 = 0;
                    }
                    t0Var.f4441b = s0Var.e().M(i6).N(dVar.f13800f == Long.MIN_VALUE ? s0Var.E : 0).E();
                }
                return -5;
            }
            d dVar2 = d.this;
            long j6 = dVar2.f13800f;
            if (j6 == Long.MIN_VALUE || ((e6 != -4 || jVar.f3602d < j6) && !(e6 == -3 && dVar2.f() == Long.MIN_VALUE && !jVar.f3601c))) {
                return e6;
            }
            jVar.clear();
            jVar.setFlags(4);
            this.f13802b = true;
            return -4;
        }

        @Override // w1.r0
        public boolean g() {
            return !d.this.k() && this.f13801a.g();
        }

        @Override // w1.r0
        public int r(long j6) {
            if (d.this.k()) {
                return -3;
            }
            return this.f13801a.r(j6);
        }
    }

    public d(t tVar, boolean z5, long j6, long j7) {
        this.f13795a = tVar;
        this.f13798d = z5 ? j6 : -9223372036854775807L;
        this.f13799e = j6;
        this.f13800f = j7;
    }

    private s1 e(long j6, s1 s1Var) {
        long s5 = com.google.android.exoplayer2.util.s0.s(s1Var.f4100a, 0L, j6 - this.f13799e);
        long j7 = s1Var.f4101b;
        long j8 = this.f13800f;
        long s6 = com.google.android.exoplayer2.util.s0.s(j7, 0L, j8 == Long.MIN_VALUE ? Long.MAX_VALUE : j8 - j6);
        return (s5 == s1Var.f4100a && s6 == s1Var.f4101b) ? s1Var : new s1(s5, s6);
    }

    private static boolean r(long j6, o2.j[] jVarArr) {
        if (j6 != 0) {
            for (o2.j jVar : jVarArr) {
                if (jVar != null) {
                    com.google.android.exoplayer2.s0 l6 = jVar.l();
                    if (!com.google.android.exoplayer2.util.q.a(l6.f4056n, l6.f4053k)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // w1.t, w1.s0
    public boolean a() {
        return this.f13795a.a();
    }

    @Override // w1.t
    public long c(long j6, s1 s1Var) {
        long j7 = this.f13799e;
        if (j6 == j7) {
            return j7;
        }
        return this.f13795a.c(j6, e(j6, s1Var));
    }

    @Override // w1.t, w1.s0
    public long d() {
        long d6 = this.f13795a.d();
        if (d6 != Long.MIN_VALUE) {
            long j6 = this.f13800f;
            if (j6 == Long.MIN_VALUE || d6 < j6) {
                return d6;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // w1.t, w1.s0
    public long f() {
        long f6 = this.f13795a.f();
        if (f6 != Long.MIN_VALUE) {
            long j6 = this.f13800f;
            if (j6 == Long.MIN_VALUE || f6 < j6) {
                return f6;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // w1.t.a
    public void g(t tVar) {
        ((t.a) com.google.android.exoplayer2.util.a.e(this.f13796b)).g(this);
    }

    @Override // w1.t, w1.s0
    public boolean h(long j6) {
        return this.f13795a.h(j6);
    }

    @Override // w1.t, w1.s0
    public void i(long j6) {
        this.f13795a.i(j6);
    }

    boolean k() {
        return this.f13798d != -9223372036854775807L;
    }

    @Override // w1.t
    public long l() {
        if (k()) {
            long j6 = this.f13798d;
            this.f13798d = -9223372036854775807L;
            long l6 = l();
            return l6 != -9223372036854775807L ? l6 : j6;
        }
        long l7 = this.f13795a.l();
        if (l7 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z5 = true;
        com.google.android.exoplayer2.util.a.g(l7 >= this.f13799e);
        long j7 = this.f13800f;
        if (j7 != Long.MIN_VALUE && l7 > j7) {
            z5 = false;
        }
        com.google.android.exoplayer2.util.a.g(z5);
        return l7;
    }

    @Override // w1.t
    public y0 n() {
        return this.f13795a.n();
    }

    @Override // w1.t
    public void o(t.a aVar, long j6) {
        this.f13796b = aVar;
        this.f13795a.o(this, j6);
    }

    @Override // w1.s0.a
    /* renamed from: p */
    public void j(t tVar) {
        ((t.a) com.google.android.exoplayer2.util.a.e(this.f13796b)).j(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (r2 > r4) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    @Override // w1.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long q(o2.j[] jVarArr, boolean[] zArr, r0[] r0VarArr, boolean[] zArr2, long j6) {
        long j7;
        boolean z5;
        this.f13797c = new a[r0VarArr.length];
        r0[] r0VarArr2 = new r0[r0VarArr.length];
        int i6 = 0;
        while (true) {
            r0 r0Var = null;
            if (i6 >= r0VarArr.length) {
                break;
            }
            a[] aVarArr = this.f13797c;
            a aVar = (a) r0VarArr[i6];
            aVarArr[i6] = aVar;
            if (aVar != null) {
                r0Var = aVar.f13801a;
            }
            r0VarArr2[i6] = r0Var;
            i6++;
        }
        long q5 = this.f13795a.q(jVarArr, zArr, r0VarArr2, zArr2, j6);
        if (k()) {
            long j8 = this.f13799e;
            if (j6 == j8 && r(j8, jVarArr)) {
                j7 = q5;
                this.f13798d = j7;
                if (q5 != j6) {
                    if (q5 >= this.f13799e) {
                        long j9 = this.f13800f;
                        if (j9 != Long.MIN_VALUE) {
                        }
                    }
                    z5 = false;
                    com.google.android.exoplayer2.util.a.g(z5);
                    for (int i7 = 0; i7 < r0VarArr.length; i7++) {
                        r0 r0Var2 = r0VarArr2[i7];
                        if (r0Var2 == null) {
                            this.f13797c[i7] = null;
                        } else {
                            a[] aVarArr2 = this.f13797c;
                            a aVar2 = aVarArr2[i7];
                            if (aVar2 == null || aVar2.f13801a != r0Var2) {
                                aVarArr2[i7] = new a(r0Var2);
                            }
                        }
                        r0VarArr[i7] = this.f13797c[i7];
                    }
                    return q5;
                }
                z5 = true;
                com.google.android.exoplayer2.util.a.g(z5);
                while (i7 < r0VarArr.length) {
                }
                return q5;
            }
        }
        j7 = -9223372036854775807L;
        this.f13798d = j7;
        if (q5 != j6) {
        }
        z5 = true;
        com.google.android.exoplayer2.util.a.g(z5);
        while (i7 < r0VarArr.length) {
        }
        return q5;
    }

    @Override // w1.t
    public void s() {
        this.f13795a.s();
    }

    @Override // w1.t
    public void t(long j6, boolean z5) {
        this.f13795a.t(j6, z5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
        if (r0 > r7) goto L18;
     */
    @Override // w1.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long u(long j6) {
        a[] aVarArr;
        this.f13798d = -9223372036854775807L;
        boolean z5 = false;
        for (a aVar : this.f13797c) {
            if (aVar != null) {
                aVar.a();
            }
        }
        long u5 = this.f13795a.u(j6);
        if (u5 != j6) {
            if (u5 >= this.f13799e) {
                long j7 = this.f13800f;
                if (j7 != Long.MIN_VALUE) {
                }
            }
            com.google.android.exoplayer2.util.a.g(z5);
            return u5;
        }
        z5 = true;
        com.google.android.exoplayer2.util.a.g(z5);
        return u5;
    }

    public void v(long j6, long j7) {
        this.f13799e = j6;
        this.f13800f = j7;
    }
}
