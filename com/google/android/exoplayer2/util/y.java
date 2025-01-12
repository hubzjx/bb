package com.google.android.exoplayer2.util;

import java.nio.charset.Charset;
import okhttp3.HttpUrl;
import okio.Utf8;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f4692a;

    /* renamed from: b  reason: collision with root package name */
    private int f4693b;

    /* renamed from: c  reason: collision with root package name */
    private int f4694c;

    public y() {
        this.f4692a = s0.f4678f;
    }

    public int A() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        this.f4693b = i6 + 1;
        return bArr[i6] & 255;
    }

    public int B() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        int i7 = i6 + 1;
        int i8 = (bArr[i7] & 255) | ((bArr[i6] & 255) << 8);
        this.f4693b = i7 + 1 + 2;
        return i8;
    }

    public long C() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = i8 + 1;
        this.f4693b = i9 + 1;
        return ((bArr[i6] & 255) << 24) | ((bArr[i7] & 255) << 16) | ((bArr[i8] & 255) << 8) | (bArr[i9] & 255);
    }

    public int D() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = ((bArr[i6] & 255) << 16) | ((bArr[i7] & 255) << 8);
        this.f4693b = i8 + 1;
        return (bArr[i8] & 255) | i9;
    }

    public int E() {
        int k6 = k();
        if (k6 >= 0) {
            return k6;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(k6);
        throw new IllegalStateException(sb.toString());
    }

    public long F() {
        long t5 = t();
        if (t5 >= 0) {
            return t5;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(t5);
        throw new IllegalStateException(sb.toString());
    }

    public int G() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        int i7 = i6 + 1;
        this.f4693b = i7 + 1;
        return (bArr[i7] & 255) | ((bArr[i6] & 255) << 8);
    }

    public long H() {
        int i6;
        int i7;
        byte b6;
        int i8;
        long j6 = this.f4692a[this.f4693b];
        int i9 = 7;
        while (true) {
            if (i9 < 0) {
                break;
            }
            if (((1 << i9) & j6) != 0) {
                i9--;
            } else if (i9 < 6) {
                j6 &= i8 - 1;
                i7 = 7 - i9;
            } else if (i9 == 7) {
                i7 = 1;
            }
        }
        i7 = 0;
        if (i7 == 0) {
            StringBuilder sb = new StringBuilder(55);
            sb.append("Invalid UTF-8 sequence first byte: ");
            sb.append(j6);
            throw new NumberFormatException(sb.toString());
        }
        for (i6 = 1; i6 < i7; i6++) {
            if ((this.f4692a[this.f4693b + i6] & 192) != 128) {
                StringBuilder sb2 = new StringBuilder(62);
                sb2.append("Invalid UTF-8 sequence continuation byte: ");
                sb2.append(j6);
                throw new NumberFormatException(sb2.toString());
            }
            j6 = (j6 << 6) | (b6 & Utf8.REPLACEMENT_BYTE);
        }
        this.f4693b += i7;
        return j6;
    }

    public void I(int i6) {
        K(b() < i6 ? new byte[i6] : this.f4692a, i6);
    }

    public void J(byte[] bArr) {
        K(bArr, bArr.length);
    }

    public void K(byte[] bArr, int i6) {
        this.f4692a = bArr;
        this.f4694c = i6;
        this.f4693b = 0;
    }

    public void L(int i6) {
        a.a(i6 >= 0 && i6 <= this.f4692a.length);
        this.f4694c = i6;
    }

    public void M(int i6) {
        a.a(i6 >= 0 && i6 <= this.f4694c);
        this.f4693b = i6;
    }

    public void N(int i6) {
        M(this.f4693b + i6);
    }

    public int a() {
        return this.f4694c - this.f4693b;
    }

    public int b() {
        return this.f4692a.length;
    }

    public byte[] c() {
        return this.f4692a;
    }

    public int d() {
        return this.f4693b;
    }

    public int e() {
        return this.f4694c;
    }

    public char f() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        return (char) ((bArr[i6 + 1] & 255) | ((bArr[i6] & 255) << 8));
    }

    public int g() {
        return this.f4692a[this.f4693b] & 255;
    }

    public void h(x xVar, int i6) {
        i(xVar.f4688a, 0, i6);
        xVar.p(0);
    }

    public void i(byte[] bArr, int i6, int i7) {
        System.arraycopy(this.f4692a, this.f4693b, bArr, i6, i7);
        this.f4693b += i7;
    }

    public double j() {
        return Double.longBitsToDouble(t());
    }

    public int k() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = ((bArr[i6] & 255) << 24) | ((bArr[i7] & 255) << 16);
        int i10 = i8 + 1;
        int i11 = i9 | ((bArr[i8] & 255) << 8);
        this.f4693b = i10 + 1;
        return (bArr[i10] & 255) | i11;
    }

    public int l() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = (((bArr[i6] & 255) << 24) >> 8) | ((bArr[i7] & 255) << 8);
        this.f4693b = i8 + 1;
        return (bArr[i8] & 255) | i9;
    }

    public String m() {
        if (a() == 0) {
            return null;
        }
        int i6 = this.f4693b;
        while (i6 < this.f4694c && !s0.o0(this.f4692a[i6])) {
            i6++;
        }
        int i7 = this.f4693b;
        if (i6 - i7 >= 3) {
            byte[] bArr = this.f4692a;
            if (bArr[i7] == -17 && bArr[i7 + 1] == -69 && bArr[i7 + 2] == -65) {
                this.f4693b = i7 + 3;
            }
        }
        byte[] bArr2 = this.f4692a;
        int i8 = this.f4693b;
        String F = s0.F(bArr2, i8, i6 - i8);
        this.f4693b = i6;
        int i9 = this.f4694c;
        if (i6 == i9) {
            return F;
        }
        byte[] bArr3 = this.f4692a;
        if (bArr3[i6] == 13) {
            int i10 = i6 + 1;
            this.f4693b = i10;
            if (i10 == i9) {
                return F;
            }
        }
        int i11 = this.f4693b;
        if (bArr3[i11] == 10) {
            this.f4693b = i11 + 1;
        }
        return F;
    }

    public int n() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = (bArr[i6] & 255) | ((bArr[i7] & 255) << 8);
        int i10 = i8 + 1;
        int i11 = i9 | ((bArr[i8] & 255) << 16);
        this.f4693b = i10 + 1;
        return ((bArr[i10] & 255) << 24) | i11;
    }

    public long o() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = i8 + 1;
        int i10 = i9 + 1;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        this.f4693b = i13 + 1;
        return (bArr[i6] & 255) | ((bArr[i7] & 255) << 8) | ((bArr[i8] & 255) << 16) | ((bArr[i9] & 255) << 24) | ((bArr[i10] & 255) << 32) | ((bArr[i11] & 255) << 40) | ((bArr[i12] & 255) << 48) | ((bArr[i13] & 255) << 56);
    }

    public short p() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        int i7 = i6 + 1;
        this.f4693b = i7 + 1;
        return (short) (((bArr[i7] & 255) << 8) | (bArr[i6] & 255));
    }

    public long q() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = i8 + 1;
        this.f4693b = i9 + 1;
        return (bArr[i6] & 255) | ((bArr[i7] & 255) << 8) | ((bArr[i8] & 255) << 16) | ((bArr[i9] & 255) << 24);
    }

    public int r() {
        int n5 = n();
        if (n5 >= 0) {
            return n5;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(n5);
        throw new IllegalStateException(sb.toString());
    }

    public int s() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        int i7 = i6 + 1;
        this.f4693b = i7 + 1;
        return ((bArr[i7] & 255) << 8) | (bArr[i6] & 255);
    }

    public long t() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = i8 + 1;
        int i10 = i9 + 1;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        this.f4693b = i13 + 1;
        return ((bArr[i6] & 255) << 56) | ((bArr[i7] & 255) << 48) | ((bArr[i8] & 255) << 40) | ((bArr[i9] & 255) << 32) | ((bArr[i10] & 255) << 24) | ((bArr[i11] & 255) << 16) | ((bArr[i12] & 255) << 8) | (bArr[i13] & 255);
    }

    public String u() {
        if (a() == 0) {
            return null;
        }
        int i6 = this.f4693b;
        while (i6 < this.f4694c && this.f4692a[i6] != 0) {
            i6++;
        }
        byte[] bArr = this.f4692a;
        int i7 = this.f4693b;
        String F = s0.F(bArr, i7, i6 - i7);
        this.f4693b = i6;
        if (i6 < this.f4694c) {
            this.f4693b = i6 + 1;
        }
        return F;
    }

    public String v(int i6) {
        if (i6 == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        int i7 = this.f4693b;
        int i8 = (i7 + i6) - 1;
        String F = s0.F(this.f4692a, i7, (i8 >= this.f4694c || this.f4692a[i8] != 0) ? i6 : i6 - 1);
        this.f4693b += i6;
        return F;
    }

    public short w() {
        byte[] bArr = this.f4692a;
        int i6 = this.f4693b;
        int i7 = i6 + 1;
        this.f4693b = i7 + 1;
        return (short) ((bArr[i7] & 255) | ((bArr[i6] & 255) << 8));
    }

    public String x(int i6) {
        return y(i6, com.google.common.base.b.f5585c);
    }

    public String y(int i6, Charset charset) {
        String str = new String(this.f4692a, this.f4693b, i6, charset);
        this.f4693b += i6;
        return str;
    }

    public int z() {
        return (A() << 21) | (A() << 14) | (A() << 7) | A();
    }

    public y(int i6) {
        this.f4692a = new byte[i6];
        this.f4694c = i6;
    }

    public y(byte[] bArr) {
        this.f4692a = bArr;
        this.f4694c = bArr.length;
    }

    public y(byte[] bArr, int i6) {
        this.f4692a = bArr;
        this.f4694c = i6;
    }
}
