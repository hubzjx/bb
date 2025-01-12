package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.t0;
import w1.r0;
/* loaded from: classes.dex */
final class m implements r0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f4331a;

    /* renamed from: b  reason: collision with root package name */
    private final q f4332b;

    /* renamed from: c  reason: collision with root package name */
    private int f4333c = -1;

    public m(q qVar, int i6) {
        this.f4332b = qVar;
        this.f4331a = i6;
    }

    private boolean c() {
        int i6 = this.f4333c;
        return (i6 == -1 || i6 == -3 || i6 == -2) ? false : true;
    }

    public void a() {
        com.google.android.exoplayer2.util.a.a(this.f4333c == -1);
        this.f4333c = this.f4332b.y(this.f4331a);
    }

    @Override // w1.r0
    public void b() {
        int i6 = this.f4333c;
        if (i6 == -2) {
            throw new s(this.f4332b.n().e(this.f4331a).e(0).f4056n);
        }
        if (i6 == -1) {
            this.f4332b.T();
        } else if (i6 != -3) {
            this.f4332b.U(i6);
        }
    }

    public void d() {
        if (this.f4333c != -1) {
            this.f4332b.n0(this.f4331a);
            this.f4333c = -1;
        }
    }

    @Override // w1.r0
    public int e(t0 t0Var, com.google.android.exoplayer2.decoder.j jVar, boolean z5) {
        if (this.f4333c == -3) {
            jVar.addFlag(4);
            return -4;
        } else if (c()) {
            return this.f4332b.c0(this.f4333c, t0Var, jVar, z5);
        } else {
            return -3;
        }
    }

    @Override // w1.r0
    public boolean g() {
        return this.f4333c == -3 || (c() && this.f4332b.Q(this.f4333c));
    }

    @Override // w1.r0
    public int r(long j6) {
        if (c()) {
            return this.f4332b.m0(this.f4333c, j6);
        }
        return 0;
    }
}
