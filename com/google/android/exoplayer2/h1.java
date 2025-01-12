package com.google.android.exoplayer2;
/* loaded from: classes.dex */
public final class h1 {

    /* renamed from: d  reason: collision with root package name */
    public static final h1 f3777d = new h1(1.0f);

    /* renamed from: a  reason: collision with root package name */
    public final float f3778a;

    /* renamed from: b  reason: collision with root package name */
    public final float f3779b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3780c;

    public h1(float f6) {
        this(f6, 1.0f);
    }

    public long a(long j6) {
        return j6 * this.f3780c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h1.class != obj.getClass()) {
            return false;
        }
        h1 h1Var = (h1) obj;
        return this.f3778a == h1Var.f3778a && this.f3779b == h1Var.f3779b;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f3778a)) * 31) + Float.floatToRawIntBits(this.f3779b);
    }

    public String toString() {
        return com.google.android.exoplayer2.util.s0.D("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f3778a), Float.valueOf(this.f3779b));
    }

    public h1(float f6, float f7) {
        com.google.android.exoplayer2.util.a.a(f6 > 0.0f);
        com.google.android.exoplayer2.util.a.a(f7 > 0.0f);
        this.f3778a = f6;
        this.f3779b = f7;
        this.f3780c = Math.round(f6 * 1000.0f);
    }
}
