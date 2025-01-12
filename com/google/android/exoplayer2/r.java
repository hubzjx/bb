package com.google.android.exoplayer2;
/* loaded from: classes.dex */
final class r implements com.google.android.exoplayer2.util.p {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.g0 f4026a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4027b;

    /* renamed from: c  reason: collision with root package name */
    private n1 f4028c;

    /* renamed from: d  reason: collision with root package name */
    private com.google.android.exoplayer2.util.p f4029d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4030e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4031f;

    /* loaded from: classes.dex */
    public interface a {
        void d(h1 h1Var);
    }

    public r(a aVar, com.google.android.exoplayer2.util.c cVar) {
        this.f4027b = aVar;
        this.f4026a = new com.google.android.exoplayer2.util.g0(cVar);
    }

    private boolean e(boolean z5) {
        n1 n1Var = this.f4028c;
        return n1Var == null || n1Var.d() || (!this.f4028c.g() && (z5 || this.f4028c.l()));
    }

    private void j(boolean z5) {
        if (e(z5)) {
            this.f4030e = true;
            if (this.f4031f) {
                this.f4026a.c();
                return;
            }
            return;
        }
        com.google.android.exoplayer2.util.p pVar = (com.google.android.exoplayer2.util.p) com.google.android.exoplayer2.util.a.e(this.f4029d);
        long z6 = pVar.z();
        if (this.f4030e) {
            if (z6 < this.f4026a.z()) {
                this.f4026a.d();
                return;
            }
            this.f4030e = false;
            if (this.f4031f) {
                this.f4026a.c();
            }
        }
        this.f4026a.a(z6);
        h1 b6 = pVar.b();
        if (b6.equals(this.f4026a.b())) {
            return;
        }
        this.f4026a.h(b6);
        this.f4027b.d(b6);
    }

    public void a(n1 n1Var) {
        if (n1Var == this.f4028c) {
            this.f4029d = null;
            this.f4028c = null;
            this.f4030e = true;
        }
    }

    @Override // com.google.android.exoplayer2.util.p
    public h1 b() {
        com.google.android.exoplayer2.util.p pVar = this.f4029d;
        return pVar != null ? pVar.b() : this.f4026a.b();
    }

    public void c(n1 n1Var) {
        com.google.android.exoplayer2.util.p pVar;
        com.google.android.exoplayer2.util.p x5 = n1Var.x();
        if (x5 == null || x5 == (pVar = this.f4029d)) {
            return;
        }
        if (pVar != null) {
            throw t.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.f4029d = x5;
        this.f4028c = n1Var;
        x5.h(this.f4026a.b());
    }

    public void d(long j6) {
        this.f4026a.a(j6);
    }

    public void f() {
        this.f4031f = true;
        this.f4026a.c();
    }

    public void g() {
        this.f4031f = false;
        this.f4026a.d();
    }

    @Override // com.google.android.exoplayer2.util.p
    public void h(h1 h1Var) {
        com.google.android.exoplayer2.util.p pVar = this.f4029d;
        if (pVar != null) {
            pVar.h(h1Var);
            h1Var = this.f4029d.b();
        }
        this.f4026a.h(h1Var);
    }

    public long i(boolean z5) {
        j(z5);
        return z();
    }

    @Override // com.google.android.exoplayer2.util.p
    public long z() {
        return this.f4030e ? this.f4026a.z() : ((com.google.android.exoplayer2.util.p) com.google.android.exoplayer2.util.a.e(this.f4029d)).z();
    }
}
