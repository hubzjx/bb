package com.google.zxing;

import io.jsonwebtoken.JwtParser;
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private final int f5833a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5834b;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(int i6, int i7) {
        this.f5833a = i6;
        this.f5834b = i7;
    }

    public final int a() {
        return this.f5834b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i6, byte[] bArr);

    public final int d() {
        return this.f5833a;
    }

    public final String toString() {
        int i6 = this.f5833a;
        byte[] bArr = new byte[i6];
        StringBuilder sb = new StringBuilder(this.f5834b * (i6 + 1));
        for (int i7 = 0; i7 < this.f5834b; i7++) {
            bArr = c(i7, bArr);
            for (int i8 = 0; i8 < this.f5833a; i8++) {
                int i9 = bArr[i8] & 255;
                sb.append(i9 < 64 ? '#' : i9 < 128 ? '+' : i9 < 192 ? JwtParser.SEPARATOR_CHAR : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
