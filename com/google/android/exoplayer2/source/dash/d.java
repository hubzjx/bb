package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.decoder.j;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.t0;
import w1.r0;
/* loaded from: classes.dex */
final class d implements r0 {

    /* renamed from: a  reason: collision with root package name */
    private final s0 f4202a;

    /* renamed from: c  reason: collision with root package name */
    private long[] f4204c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4205d;

    /* renamed from: e  reason: collision with root package name */
    private a2.e f4206e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4207f;

    /* renamed from: g  reason: collision with root package name */
    private int f4208g;

    /* renamed from: b  reason: collision with root package name */
    private final p1.c f4203b = new p1.c();

    /* renamed from: h  reason: collision with root package name */
    private long f4209h = -9223372036854775807L;

    public d(a2.e eVar, s0 s0Var, boolean z5) {
        this.f4202a = s0Var;
        this.f4206e = eVar;
        this.f4204c = eVar.f79b;
        d(eVar, z5);
    }

    public String a() {
        return this.f4206e.a();
    }

    @Override // w1.r0
    public void b() {
    }

    public void c(long j6) {
        boolean z5 = true;
        int e6 = com.google.android.exoplayer2.util.s0.e(this.f4204c, j6, true, false);
        this.f4208g = e6;
        if (!((this.f4205d && e6 == this.f4204c.length) ? false : false)) {
            j6 = -9223372036854775807L;
        }
        this.f4209h = j6;
    }

    public void d(a2.e eVar, boolean z5) {
        int i6 = this.f4208g;
        long j6 = i6 == 0 ? -9223372036854775807L : this.f4204c[i6 - 1];
        this.f4205d = z5;
        this.f4206e = eVar;
        long[] jArr = eVar.f79b;
        this.f4204c = jArr;
        long j7 = this.f4209h;
        if (j7 != -9223372036854775807L) {
            c(j7);
        } else if (j6 != -9223372036854775807L) {
            this.f4208g = com.google.android.exoplayer2.util.s0.e(jArr, j6, false, false);
        }
    }

    @Override // w1.r0
    public int e(t0 t0Var, j jVar, boolean z5) {
        if (z5 || !this.f4207f) {
            t0Var.f4441b = this.f4202a;
            this.f4207f = true;
            return -5;
        }
        int i6 = this.f4208g;
        if (i6 == this.f4204c.length) {
            if (this.f4205d) {
                return -3;
            }
            jVar.setFlags(4);
            return -4;
        }
        this.f4208g = i6 + 1;
        byte[] a6 = this.f4203b.a(this.f4206e.f78a[i6]);
        jVar.f(a6.length);
        jVar.f3600b.put(a6);
        jVar.f3602d = this.f4204c[i6];
        jVar.setFlags(1);
        return -4;
    }

    @Override // w1.r0
    public boolean g() {
        return true;
    }

    @Override // w1.r0
    public int r(long j6) {
        int max = Math.max(this.f4208g, com.google.android.exoplayer2.util.s0.e(this.f4204c, j6, true, false));
        int i6 = max - this.f4208g;
        this.f4208g = max;
        return i6;
    }
}
