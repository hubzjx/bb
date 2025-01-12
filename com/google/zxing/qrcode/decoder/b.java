package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.j;
/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f5854a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f5855b;

    private b(int i6, byte[] bArr) {
        this.f5854a = i6;
        this.f5855b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b[] b(byte[] bArr, j jVar, f fVar) {
        if (bArr.length == jVar.h()) {
            j.b f6 = jVar.f(fVar);
            j.a[] a6 = f6.a();
            int i6 = 0;
            for (j.a aVar : a6) {
                i6 += aVar.a();
            }
            b[] bVarArr = new b[i6];
            int i7 = 0;
            for (j.a aVar2 : a6) {
                int i8 = 0;
                while (i8 < aVar2.a()) {
                    int b6 = aVar2.b();
                    bVarArr[i7] = new b(b6, new byte[f6.b() + b6]);
                    i8++;
                    i7++;
                }
            }
            int length = bVarArr[0].f5855b.length;
            int i9 = i6 - 1;
            while (i9 >= 0 && bVarArr[i9].f5855b.length != length) {
                i9--;
            }
            int i10 = i9 + 1;
            int b7 = length - f6.b();
            int i11 = 0;
            for (int i12 = 0; i12 < b7; i12++) {
                int i13 = 0;
                while (i13 < i7) {
                    bVarArr[i13].f5855b[i12] = bArr[i11];
                    i13++;
                    i11++;
                }
            }
            int i14 = i10;
            while (i14 < i7) {
                bVarArr[i14].f5855b[b7] = bArr[i11];
                i14++;
                i11++;
            }
            int length2 = bVarArr[0].f5855b.length;
            while (b7 < length2) {
                int i15 = 0;
                while (i15 < i7) {
                    bVarArr[i15].f5855b[i15 < i10 ? b7 : b7 + 1] = bArr[i11];
                    i15++;
                    i11++;
                }
                b7++;
            }
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return this.f5855b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f5854a;
    }
}
