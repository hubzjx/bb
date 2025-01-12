package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: f  reason: collision with root package name */
    public static final e f3351f = new b().a();

    /* renamed from: a  reason: collision with root package name */
    public final int f3352a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3353b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3354c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3355d;

    /* renamed from: e  reason: collision with root package name */
    private AudioAttributes f3356e;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private int f3357a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f3358b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f3359c = 1;

        /* renamed from: d  reason: collision with root package name */
        private int f3360d = 1;

        public e a() {
            return new e(this.f3357a, this.f3358b, this.f3359c, this.f3360d);
        }
    }

    private e(int i6, int i7, int i8, int i9) {
        this.f3352a = i6;
        this.f3353b = i7;
        this.f3354c = i8;
        this.f3355d = i9;
    }

    public AudioAttributes a() {
        if (this.f3356e == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f3352a).setFlags(this.f3353b).setUsage(this.f3354c);
            if (com.google.android.exoplayer2.util.s0.f4673a >= 29) {
                usage.setAllowedCapturePolicy(this.f3355d);
            }
            this.f3356e = usage.build();
        }
        return this.f3356e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f3352a == eVar.f3352a && this.f3353b == eVar.f3353b && this.f3354c == eVar.f3354c && this.f3355d == eVar.f3355d;
    }

    public int hashCode() {
        return ((((((527 + this.f3352a) * 31) + this.f3353b) * 31) + this.f3354c) * 31) + this.f3355d;
    }
}
