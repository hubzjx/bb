package com.google.zxing.qrcode.detector;

import com.google.zxing.p;
/* loaded from: classes.dex */
public final class d extends p {

    /* renamed from: c  reason: collision with root package name */
    private final float f5883c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5884d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(float f6, float f7, float f8) {
        this(f6, f7, f8, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(float f6, float f7, float f8) {
        if (Math.abs(f7 - d()) > f6 || Math.abs(f8 - c()) > f6) {
            return false;
        }
        float abs = Math.abs(f6 - this.f5883c);
        return abs <= 1.0f || abs <= this.f5883c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d g(float f6, float f7, float f8) {
        int i6 = this.f5884d;
        int i7 = i6 + 1;
        float c6 = (i6 * c()) + f7;
        float f9 = i7;
        return new d(c6 / f9, ((this.f5884d * d()) + f6) / f9, ((this.f5884d * this.f5883c) + f8) / f9, i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f5884d;
    }

    public float i() {
        return this.f5883c;
    }

    private d(float f6, float f7, float f8, int i6) {
        super(f6, f7);
        this.f5883c = f8;
        this.f5884d = i6;
    }
}
