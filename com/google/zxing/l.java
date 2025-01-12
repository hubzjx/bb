package com.google.zxing;
/* loaded from: classes.dex */
public final class l extends i {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f5836c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5837d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5838e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5839f;

    /* renamed from: g  reason: collision with root package name */
    private final int f5840g;

    public l(int i6, int i7, int[] iArr) {
        super(i6, i7);
        this.f5837d = i6;
        this.f5838e = i7;
        this.f5839f = 0;
        this.f5840g = 0;
        int i8 = i6 * i7;
        this.f5836c = new byte[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = iArr[i9];
            this.f5836c[i9] = (byte) (((((i10 >> 16) & 255) + ((i10 >> 7) & 510)) + (i10 & 255)) / 4);
        }
    }

    @Override // com.google.zxing.i
    public byte[] b() {
        int d6 = d();
        int a6 = a();
        int i6 = this.f5837d;
        if (d6 == i6 && a6 == this.f5838e) {
            return this.f5836c;
        }
        int i7 = d6 * a6;
        byte[] bArr = new byte[i7];
        int i8 = (this.f5840g * i6) + this.f5839f;
        if (d6 == i6) {
            System.arraycopy(this.f5836c, i8, bArr, 0, i7);
            return bArr;
        }
        for (int i9 = 0; i9 < a6; i9++) {
            System.arraycopy(this.f5836c, i8, bArr, i9 * d6, d6);
            i8 += this.f5837d;
        }
        return bArr;
    }

    @Override // com.google.zxing.i
    public byte[] c(int i6, byte[] bArr) {
        if (i6 < 0 || i6 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i6);
        }
        int d6 = d();
        if (bArr == null || bArr.length < d6) {
            bArr = new byte[d6];
        }
        System.arraycopy(this.f5836c, ((i6 + this.f5840g) * this.f5837d) + this.f5839f, bArr, 0, d6);
        return bArr;
    }
}
