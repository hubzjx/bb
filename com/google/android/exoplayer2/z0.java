package com.google.android.exoplayer2;

import w1.v;
/* loaded from: classes.dex */
final class z0 {

    /* renamed from: a  reason: collision with root package name */
    public final v.a f4852a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4853b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4854c;

    /* renamed from: d  reason: collision with root package name */
    public final long f4855d;

    /* renamed from: e  reason: collision with root package name */
    public final long f4856e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f4857f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f4858g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f4859h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(v.a aVar, long j6, long j7, long j8, long j9, boolean z5, boolean z6, boolean z7) {
        this.f4852a = aVar;
        this.f4853b = j6;
        this.f4854c = j7;
        this.f4855d = j8;
        this.f4856e = j9;
        this.f4857f = z5;
        this.f4858g = z6;
        this.f4859h = z7;
    }

    public z0 a(long j6) {
        return j6 == this.f4854c ? this : new z0(this.f4852a, this.f4853b, j6, this.f4855d, this.f4856e, this.f4857f, this.f4858g, this.f4859h);
    }

    public z0 b(long j6) {
        return j6 == this.f4853b ? this : new z0(this.f4852a, j6, this.f4854c, this.f4855d, this.f4856e, this.f4857f, this.f4858g, this.f4859h);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z0.class != obj.getClass()) {
            return false;
        }
        z0 z0Var = (z0) obj;
        return this.f4853b == z0Var.f4853b && this.f4854c == z0Var.f4854c && this.f4855d == z0Var.f4855d && this.f4856e == z0Var.f4856e && this.f4857f == z0Var.f4857f && this.f4858g == z0Var.f4858g && this.f4859h == z0Var.f4859h && com.google.android.exoplayer2.util.s0.c(this.f4852a, z0Var.f4852a);
    }

    public int hashCode() {
        return ((((((((((((((527 + this.f4852a.hashCode()) * 31) + ((int) this.f4853b)) * 31) + ((int) this.f4854c)) * 31) + ((int) this.f4855d)) * 31) + ((int) this.f4856e)) * 31) + (this.f4857f ? 1 : 0)) * 31) + (this.f4858g ? 1 : 0)) * 31) + (this.f4859h ? 1 : 0);
    }
}
