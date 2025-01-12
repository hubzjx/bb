package com.google.android.exoplayer2;
/* loaded from: classes.dex */
public abstract class o implements n1, p1 {

    /* renamed from: a  reason: collision with root package name */
    private final int f3926a;

    /* renamed from: c  reason: collision with root package name */
    private q1 f3928c;

    /* renamed from: d  reason: collision with root package name */
    private int f3929d;

    /* renamed from: e  reason: collision with root package name */
    private int f3930e;

    /* renamed from: f  reason: collision with root package name */
    private w1.r0 f3931f;

    /* renamed from: g  reason: collision with root package name */
    private s0[] f3932g;

    /* renamed from: h  reason: collision with root package name */
    private long f3933h;

    /* renamed from: k  reason: collision with root package name */
    private long f3934k;

    /* renamed from: m  reason: collision with root package name */
    private boolean f3936m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f3937n;

    /* renamed from: b  reason: collision with root package name */
    private final t0 f3927b = new t0();

    /* renamed from: l  reason: collision with root package name */
    private long f3935l = Long.MIN_VALUE;

    public o(int i6) {
        this.f3926a = i6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final t A(Exception exc, s0 s0Var) {
        int i6;
        if (s0Var != null && !this.f3937n) {
            this.f3937n = true;
            try {
                i6 = o1.d(a(s0Var));
            } catch (t unused) {
            } finally {
                this.f3937n = false;
            }
            return t.createForRenderer(exc, f(), D(), s0Var, i6);
        }
        i6 = 4;
        return t.createForRenderer(exc, f(), D(), s0Var, i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final q1 B() {
        return (q1) com.google.android.exoplayer2.util.a.e(this.f3928c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final t0 C() {
        this.f3927b.a();
        return this.f3927b;
    }

    protected final int D() {
        return this.f3929d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final s0[] E() {
        return (s0[]) com.google.android.exoplayer2.util.a.e(this.f3932g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean F() {
        return l() ? this.f3936m : ((w1.r0) com.google.android.exoplayer2.util.a.e(this.f3931f)).g();
    }

    protected abstract void G();

    protected void H(boolean z5, boolean z6) {
    }

    protected abstract void I(long j6, boolean z5);

    protected void J() {
    }

    protected void K() {
    }

    protected void L() {
    }

    protected abstract void M(s0[] s0VarArr, long j6, long j7);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int N(t0 t0Var, com.google.android.exoplayer2.decoder.j jVar, boolean z5) {
        int e6 = ((w1.r0) com.google.android.exoplayer2.util.a.e(this.f3931f)).e(t0Var, jVar, z5);
        if (e6 == -4) {
            if (jVar.isEndOfStream()) {
                this.f3935l = Long.MIN_VALUE;
                return this.f3936m ? -4 : -3;
            }
            long j6 = jVar.f3602d + this.f3933h;
            jVar.f3602d = j6;
            this.f3935l = Math.max(this.f3935l, j6);
        } else if (e6 == -5) {
            s0 s0Var = (s0) com.google.android.exoplayer2.util.a.e(t0Var.f4441b);
            if (s0Var.f4060r != Long.MAX_VALUE) {
                t0Var.f4441b = s0Var.e().i0(s0Var.f4060r + this.f3933h).E();
            }
        }
        return e6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O(long j6) {
        return ((w1.r0) com.google.android.exoplayer2.util.a.e(this.f3931f)).r(j6 - this.f3933h);
    }

    @Override // com.google.android.exoplayer2.n1
    public final void c() {
        com.google.android.exoplayer2.util.a.g(this.f3930e == 0);
        this.f3927b.a();
        J();
    }

    @Override // com.google.android.exoplayer2.n1
    public final void e() {
        com.google.android.exoplayer2.util.a.g(this.f3930e == 1);
        this.f3927b.a();
        this.f3930e = 0;
        this.f3931f = null;
        this.f3932g = null;
        this.f3936m = false;
        G();
    }

    @Override // com.google.android.exoplayer2.n1
    public final int getState() {
        return this.f3930e;
    }

    @Override // com.google.android.exoplayer2.n1, com.google.android.exoplayer2.p1
    public final int i() {
        return this.f3926a;
    }

    @Override // com.google.android.exoplayer2.n1
    public final void j(int i6) {
        this.f3929d = i6;
    }

    @Override // com.google.android.exoplayer2.n1
    public final void k(s0[] s0VarArr, w1.r0 r0Var, long j6, long j7) {
        com.google.android.exoplayer2.util.a.g(!this.f3936m);
        this.f3931f = r0Var;
        this.f3935l = j7;
        this.f3932g = s0VarArr;
        this.f3933h = j7;
        M(s0VarArr, j6, j7);
    }

    @Override // com.google.android.exoplayer2.n1
    public final boolean l() {
        return this.f3935l == Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.n1
    public final void m(q1 q1Var, s0[] s0VarArr, w1.r0 r0Var, long j6, boolean z5, boolean z6, long j7, long j8) {
        com.google.android.exoplayer2.util.a.g(this.f3930e == 0);
        this.f3928c = q1Var;
        this.f3930e = 1;
        this.f3934k = j6;
        H(z5, z6);
        k(s0VarArr, r0Var, j7, j8);
        I(j6, z5);
    }

    public int n() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.k1.b
    public void p(int i6, Object obj) {
    }

    @Override // com.google.android.exoplayer2.n1
    public final w1.r0 q() {
        return this.f3931f;
    }

    @Override // com.google.android.exoplayer2.n1
    public /* synthetic */ void r(float f6) {
        m1.a(this, f6);
    }

    @Override // com.google.android.exoplayer2.n1
    public final void s() {
        this.f3936m = true;
    }

    @Override // com.google.android.exoplayer2.n1
    public final void start() {
        com.google.android.exoplayer2.util.a.g(this.f3930e == 1);
        this.f3930e = 2;
        K();
    }

    @Override // com.google.android.exoplayer2.n1
    public final void stop() {
        com.google.android.exoplayer2.util.a.g(this.f3930e == 2);
        this.f3930e = 1;
        L();
    }

    @Override // com.google.android.exoplayer2.n1
    public final void t() {
        ((w1.r0) com.google.android.exoplayer2.util.a.e(this.f3931f)).b();
    }

    @Override // com.google.android.exoplayer2.n1
    public final long u() {
        return this.f3935l;
    }

    @Override // com.google.android.exoplayer2.n1
    public final void v(long j6) {
        this.f3936m = false;
        this.f3934k = j6;
        this.f3935l = j6;
        I(j6, false);
    }

    @Override // com.google.android.exoplayer2.n1
    public final boolean w() {
        return this.f3936m;
    }

    @Override // com.google.android.exoplayer2.n1
    public com.google.android.exoplayer2.util.p x() {
        return null;
    }

    @Override // com.google.android.exoplayer2.n1
    public final p1 y() {
        return this;
    }
}
