package com.google.android.exoplayer2.util;

import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f4688a;

    /* renamed from: b  reason: collision with root package name */
    private int f4689b;

    /* renamed from: c  reason: collision with root package name */
    private int f4690c;

    /* renamed from: d  reason: collision with root package name */
    private int f4691d;

    public x() {
        this.f4688a = s0.f4678f;
    }

    private void a() {
        int i6;
        int i7 = this.f4689b;
        a.g(i7 >= 0 && (i7 < (i6 = this.f4691d) || (i7 == i6 && this.f4690c == 0)));
    }

    public int b() {
        return ((this.f4691d - this.f4689b) * 8) - this.f4690c;
    }

    public void c() {
        if (this.f4690c == 0) {
            return;
        }
        this.f4690c = 0;
        this.f4689b++;
        a();
    }

    public int d() {
        a.g(this.f4690c == 0);
        return this.f4689b;
    }

    public int e() {
        return (this.f4689b * 8) + this.f4690c;
    }

    public void f(int i6, int i7) {
        if (i7 < 32) {
            i6 &= (1 << i7) - 1;
        }
        int min = Math.min(8 - this.f4690c, i7);
        int i8 = this.f4690c;
        int i9 = (8 - i8) - min;
        byte[] bArr = this.f4688a;
        int i10 = this.f4689b;
        byte b6 = (byte) (((65280 >> i8) | ((1 << i9) - 1)) & bArr[i10]);
        bArr[i10] = b6;
        int i11 = i7 - min;
        bArr[i10] = (byte) (b6 | ((i6 >>> i11) << i9));
        int i12 = i10 + 1;
        while (i11 > 8) {
            this.f4688a[i12] = (byte) (i6 >>> (i11 - 8));
            i11 -= 8;
            i12++;
        }
        int i13 = 8 - i11;
        byte[] bArr2 = this.f4688a;
        byte b7 = (byte) (bArr2[i12] & ((1 << i13) - 1));
        bArr2[i12] = b7;
        bArr2[i12] = (byte) (((i6 & ((1 << i11) - 1)) << i13) | b7);
        r(i7);
        a();
    }

    public boolean g() {
        boolean z5 = (this.f4688a[this.f4689b] & (128 >> this.f4690c)) != 0;
        q();
        return z5;
    }

    public int h(int i6) {
        int i7;
        if (i6 == 0) {
            return 0;
        }
        this.f4690c += i6;
        int i8 = 0;
        while (true) {
            i7 = this.f4690c;
            if (i7 <= 8) {
                break;
            }
            int i9 = i7 - 8;
            this.f4690c = i9;
            byte[] bArr = this.f4688a;
            int i10 = this.f4689b;
            this.f4689b = i10 + 1;
            i8 |= (bArr[i10] & 255) << i9;
        }
        byte[] bArr2 = this.f4688a;
        int i11 = this.f4689b;
        int i12 = ((-1) >>> (32 - i6)) & (i8 | ((bArr2[i11] & 255) >> (8 - i7)));
        if (i7 == 8) {
            this.f4690c = 0;
            this.f4689b = i11 + 1;
        }
        a();
        return i12;
    }

    public void i(byte[] bArr, int i6, int i7) {
        int i8 = (i7 >> 3) + i6;
        while (i6 < i8) {
            byte[] bArr2 = this.f4688a;
            int i9 = this.f4689b;
            int i10 = i9 + 1;
            this.f4689b = i10;
            byte b6 = bArr2[i9];
            int i11 = this.f4690c;
            byte b7 = (byte) (b6 << i11);
            bArr[i6] = b7;
            bArr[i6] = (byte) (((255 & bArr2[i10]) >> (8 - i11)) | b7);
            i6++;
        }
        int i12 = i7 & 7;
        if (i12 == 0) {
            return;
        }
        byte b8 = (byte) (bArr[i8] & (255 >> i12));
        bArr[i8] = b8;
        int i13 = this.f4690c;
        if (i13 + i12 > 8) {
            byte[] bArr3 = this.f4688a;
            int i14 = this.f4689b;
            this.f4689b = i14 + 1;
            bArr[i8] = (byte) (b8 | ((bArr3[i14] & 255) << i13));
            this.f4690c = i13 - 8;
        }
        int i15 = this.f4690c + i12;
        this.f4690c = i15;
        byte[] bArr4 = this.f4688a;
        int i16 = this.f4689b;
        bArr[i8] = (byte) (((byte) (((255 & bArr4[i16]) >> (8 - i15)) << (8 - i12))) | bArr[i8]);
        if (i15 == 8) {
            this.f4690c = 0;
            this.f4689b = i16 + 1;
        }
        a();
    }

    public long j(int i6) {
        return i6 <= 32 ? s0.T0(h(i6)) : s0.R0(h(i6 - 32), h(32));
    }

    public void k(byte[] bArr, int i6, int i7) {
        a.g(this.f4690c == 0);
        System.arraycopy(this.f4688a, this.f4689b, bArr, i6, i7);
        this.f4689b += i7;
        a();
    }

    public String l(int i6, Charset charset) {
        byte[] bArr = new byte[i6];
        k(bArr, 0, i6);
        return new String(bArr, charset);
    }

    public void m(y yVar) {
        o(yVar.c(), yVar.e());
        p(yVar.d() * 8);
    }

    public void n(byte[] bArr) {
        o(bArr, bArr.length);
    }

    public void o(byte[] bArr, int i6) {
        this.f4688a = bArr;
        this.f4689b = 0;
        this.f4690c = 0;
        this.f4691d = i6;
    }

    public void p(int i6) {
        int i7 = i6 / 8;
        this.f4689b = i7;
        this.f4690c = i6 - (i7 * 8);
        a();
    }

    public void q() {
        int i6 = this.f4690c + 1;
        this.f4690c = i6;
        if (i6 == 8) {
            this.f4690c = 0;
            this.f4689b++;
        }
        a();
    }

    public void r(int i6) {
        int i7 = i6 / 8;
        int i8 = this.f4689b + i7;
        this.f4689b = i8;
        int i9 = this.f4690c + (i6 - (i7 * 8));
        this.f4690c = i9;
        if (i9 > 7) {
            this.f4689b = i8 + 1;
            this.f4690c = i9 - 8;
        }
        a();
    }

    public void s(int i6) {
        a.g(this.f4690c == 0);
        this.f4689b += i6;
        a();
    }

    public x(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public x(byte[] bArr, int i6) {
        this.f4688a = bArr;
        this.f4691d = i6;
    }
}
