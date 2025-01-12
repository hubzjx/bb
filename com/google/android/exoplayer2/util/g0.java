package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.h1;
/* loaded from: classes.dex */
public final class g0 implements p {

    /* renamed from: a  reason: collision with root package name */
    private final c f4615a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4616b;

    /* renamed from: c  reason: collision with root package name */
    private long f4617c;

    /* renamed from: d  reason: collision with root package name */
    private long f4618d;

    /* renamed from: e  reason: collision with root package name */
    private h1 f4619e = h1.f3777d;

    public g0(c cVar) {
        this.f4615a = cVar;
    }

    public void a(long j6) {
        this.f4617c = j6;
        if (this.f4616b) {
            this.f4618d = this.f4615a.c();
        }
    }

    @Override // com.google.android.exoplayer2.util.p
    public h1 b() {
        return this.f4619e;
    }

    public void c() {
        if (this.f4616b) {
            return;
        }
        this.f4618d = this.f4615a.c();
        this.f4616b = true;
    }

    public void d() {
        if (this.f4616b) {
            a(z());
            this.f4616b = false;
        }
    }

    @Override // com.google.android.exoplayer2.util.p
    public void h(h1 h1Var) {
        if (this.f4616b) {
            a(z());
        }
        this.f4619e = h1Var;
    }

    @Override // com.google.android.exoplayer2.util.p
    public long z() {
        long j6 = this.f4617c;
        if (this.f4616b) {
            long c6 = this.f4615a.c() - this.f4618d;
            h1 h1Var = this.f4619e;
            return j6 + (h1Var.f3778a == 1.0f ? com.google.android.exoplayer2.p.a(c6) : h1Var.a(c6));
        }
        return j6;
    }
}
