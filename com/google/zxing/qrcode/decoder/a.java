package com.google.zxing.qrcode.decoder;
/* loaded from: classes.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private final s3.b f5850a;

    /* renamed from: b  reason: collision with root package name */
    private j f5851b;

    /* renamed from: c  reason: collision with root package name */
    private g f5852c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5853d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(s3.b bVar) {
        int g6 = bVar.g();
        if (g6 < 21 || (g6 & 3) != 1) {
            throw com.google.zxing.h.getFormatInstance();
        }
        this.f5850a = bVar;
    }

    private int a(int i6, int i7, int i8) {
        return this.f5853d ? this.f5850a.e(i7, i6) : this.f5850a.e(i6, i7) ? (i8 << 1) | 1 : i8 << 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int i6 = 0;
        while (i6 < this.f5850a.i()) {
            int i7 = i6 + 1;
            for (int i8 = i7; i8 < this.f5850a.g(); i8++) {
                if (this.f5850a.e(i6, i8) != this.f5850a.e(i8, i6)) {
                    this.f5850a.d(i8, i6);
                    this.f5850a.d(i6, i8);
                }
            }
            i6 = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] c() {
        g d6 = d();
        j e6 = e();
        c cVar = c.values()[d6.c()];
        int g6 = this.f5850a.g();
        cVar.unmaskBitMatrix(this.f5850a, g6);
        s3.b a6 = e6.a();
        byte[] bArr = new byte[e6.h()];
        int i6 = g6 - 1;
        boolean z5 = true;
        int i7 = i6;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i7 > 0) {
            if (i7 == 6) {
                i7--;
            }
            for (int i11 = 0; i11 < g6; i11++) {
                int i12 = z5 ? i6 - i11 : i11;
                for (int i13 = 0; i13 < 2; i13++) {
                    int i14 = i7 - i13;
                    if (!a6.e(i14, i12)) {
                        i9++;
                        i10 <<= 1;
                        if (this.f5850a.e(i14, i12)) {
                            i10 |= 1;
                        }
                        if (i9 == 8) {
                            bArr[i8] = (byte) i10;
                            i8++;
                            i9 = 0;
                            i10 = 0;
                        }
                    }
                }
            }
            z5 = !z5;
            i7 -= 2;
        }
        if (i8 == e6.h()) {
            return bArr;
        }
        throw com.google.zxing.h.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g d() {
        g gVar = this.f5852c;
        if (gVar != null) {
            return gVar;
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < 6; i8++) {
            i7 = a(i8, 8, i7);
        }
        int a6 = a(8, 7, a(8, 8, a(7, 8, i7)));
        for (int i9 = 5; i9 >= 0; i9--) {
            a6 = a(8, i9, a6);
        }
        int g6 = this.f5850a.g();
        int i10 = g6 - 7;
        for (int i11 = g6 - 1; i11 >= i10; i11--) {
            i6 = a(8, i11, i6);
        }
        for (int i12 = g6 - 8; i12 < g6; i12++) {
            i6 = a(i12, 8, i6);
        }
        g a7 = g.a(a6, i6);
        this.f5852c = a7;
        if (a7 != null) {
            return a7;
        }
        throw com.google.zxing.h.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j e() {
        j jVar = this.f5851b;
        if (jVar != null) {
            return jVar;
        }
        int g6 = this.f5850a.g();
        int i6 = (g6 - 17) / 4;
        if (i6 <= 6) {
            return j.i(i6);
        }
        int i7 = g6 - 11;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 5; i10 >= 0; i10--) {
            for (int i11 = g6 - 9; i11 >= i7; i11--) {
                i9 = a(i11, i10, i9);
            }
        }
        j c6 = j.c(i9);
        if (c6 != null && c6.e() == g6) {
            this.f5851b = c6;
            return c6;
        }
        for (int i12 = 5; i12 >= 0; i12--) {
            for (int i13 = g6 - 9; i13 >= i7; i13--) {
                i8 = a(i12, i13, i8);
            }
        }
        j c7 = j.c(i8);
        if (c7 == null || c7.e() != g6) {
            throw com.google.zxing.h.getFormatInstance();
        }
        this.f5851b = c7;
        return c7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.f5852c == null) {
            return;
        }
        c.values()[this.f5852c.c()].unmaskBitMatrix(this.f5850a, this.f5850a.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(boolean z5) {
        this.f5851b = null;
        this.f5852c = null;
        this.f5853d = z5;
    }
}
