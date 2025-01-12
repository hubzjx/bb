package com.google.zxing.qrcode.detector;

import com.google.zxing.p;
/* loaded from: classes.dex */
public final class a extends p {

    /* renamed from: c  reason: collision with root package name */
    private final float f5873c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(float f6, float f7, float f8) {
        super(f6, f7);
        this.f5873c = f8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(float f6, float f7, float f8) {
        if (Math.abs(f7 - d()) > f6 || Math.abs(f8 - c()) > f6) {
            return false;
        }
        float abs = Math.abs(f6 - this.f5873c);
        return abs <= 1.0f || abs <= this.f5873c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a g(float f6, float f7, float f8) {
        return new a((c() + f7) / 2.0f, (d() + f6) / 2.0f, (this.f5873c + f8) / 2.0f);
    }
}
