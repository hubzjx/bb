package com.google.android.exoplayer2;
/* loaded from: classes.dex */
public final class s1 {

    /* renamed from: c  reason: collision with root package name */
    public static final s1 f4095c;

    /* renamed from: d  reason: collision with root package name */
    public static final s1 f4096d;

    /* renamed from: e  reason: collision with root package name */
    public static final s1 f4097e;

    /* renamed from: f  reason: collision with root package name */
    public static final s1 f4098f;

    /* renamed from: g  reason: collision with root package name */
    public static final s1 f4099g;

    /* renamed from: a  reason: collision with root package name */
    public final long f4100a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4101b;

    static {
        s1 s1Var = new s1(0L, 0L);
        f4095c = s1Var;
        f4096d = new s1(Long.MAX_VALUE, Long.MAX_VALUE);
        f4097e = new s1(Long.MAX_VALUE, 0L);
        f4098f = new s1(0L, Long.MAX_VALUE);
        f4099g = s1Var;
    }

    public s1(long j6, long j7) {
        com.google.android.exoplayer2.util.a.a(j6 >= 0);
        com.google.android.exoplayer2.util.a.a(j7 >= 0);
        this.f4100a = j6;
        this.f4101b = j7;
    }

    public long a(long j6, long j7, long j8) {
        long j9 = this.f4100a;
        if (j9 == 0 && this.f4101b == 0) {
            return j6;
        }
        long O0 = com.google.android.exoplayer2.util.s0.O0(j6, j9, Long.MIN_VALUE);
        long b6 = com.google.android.exoplayer2.util.s0.b(j6, this.f4101b, Long.MAX_VALUE);
        boolean z5 = true;
        boolean z6 = O0 <= j7 && j7 <= b6;
        z5 = (O0 > j8 || j8 > b6) ? false : false;
        return (z6 && z5) ? Math.abs(j7 - j6) <= Math.abs(j8 - j6) ? j7 : j8 : z6 ? j7 : z5 ? j8 : O0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s1.class != obj.getClass()) {
            return false;
        }
        s1 s1Var = (s1) obj;
        return this.f4100a == s1Var.f4100a && this.f4101b == s1Var.f4101b;
    }

    public int hashCode() {
        return (((int) this.f4100a) * 31) + ((int) this.f4101b);
    }
}
