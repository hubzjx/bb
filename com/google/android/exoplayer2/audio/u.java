package com.google.android.exoplayer2.audio;
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final int f3538a;

    /* renamed from: b  reason: collision with root package name */
    public final float f3539b;

    public u(int i6, float f6) {
        this.f3538a = i6;
        this.f3539b = f6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        return this.f3538a == uVar.f3538a && Float.compare(uVar.f3539b, this.f3539b) == 0;
    }

    public int hashCode() {
        return ((527 + this.f3538a) * 31) + Float.floatToIntBits(this.f3539b);
    }
}
