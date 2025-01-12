package s3;

import java.lang.reflect.Array;
/* loaded from: classes.dex */
public final class j extends h {

    /* renamed from: e  reason: collision with root package name */
    private b f13288e;

    public j(com.google.zxing.i iVar) {
        super(iVar);
    }

    private static int[][] e(byte[] bArr, int i6, int i7, int i8, int i9) {
        int i10 = 8;
        int i11 = i9 - 8;
        int i12 = i8 - 8;
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, i7, i6);
        int i13 = 0;
        while (i13 < i7) {
            int i14 = i13 << 3;
            if (i14 > i11) {
                i14 = i11;
            }
            int i15 = 0;
            while (i15 < i6) {
                int i16 = i15 << 3;
                if (i16 > i12) {
                    i16 = i12;
                }
                int i17 = (i14 * i8) + i16;
                int i18 = 255;
                int i19 = 0;
                int i20 = 0;
                int i21 = 0;
                while (i19 < i10) {
                    int i22 = i21;
                    int i23 = 0;
                    while (i23 < i10) {
                        int i24 = bArr[i17 + i23] & 255;
                        i20 += i24;
                        if (i24 < i18) {
                            i18 = i24;
                        }
                        if (i24 > i22) {
                            i22 = i24;
                        }
                        i23++;
                        i10 = 8;
                    }
                    if (i22 - i18 <= 24) {
                        i19++;
                        i17 += i8;
                        i21 = i22;
                        i10 = 8;
                    }
                    while (true) {
                        i19++;
                        i17 += i8;
                        if (i19 < 8) {
                            int i25 = 0;
                            for (int i26 = 8; i25 < i26; i26 = 8) {
                                i20 += bArr[i17 + i25] & 255;
                                i25++;
                            }
                        }
                    }
                    i19++;
                    i17 += i8;
                    i21 = i22;
                    i10 = 8;
                }
                int i27 = i20 >> 6;
                if (i21 - i18 <= 24) {
                    i27 = i18 / 2;
                    if (i13 > 0 && i15 > 0) {
                        int[] iArr2 = iArr[i13 - 1];
                        int i28 = i15 - 1;
                        int i29 = ((iArr2[i15] + (iArr[i13][i28] * 2)) + iArr2[i28]) / 4;
                        if (i18 < i29) {
                            i27 = i29;
                        }
                        iArr[i13][i15] = i27;
                        i15++;
                        i10 = 8;
                    }
                }
                iArr[i13][i15] = i27;
                i15++;
                i10 = 8;
            }
            i13++;
            i10 = 8;
        }
        return iArr;
    }

    private static void f(byte[] bArr, int i6, int i7, int i8, int i9, int[][] iArr, b bVar) {
        int i10 = i9 - 8;
        int i11 = i8 - 8;
        for (int i12 = 0; i12 < i7; i12++) {
            int i13 = i12 << 3;
            int i14 = i13 > i10 ? i10 : i13;
            int g6 = g(i12, 2, i7 - 3);
            for (int i15 = 0; i15 < i6; i15++) {
                int i16 = i15 << 3;
                int i17 = i16 > i11 ? i11 : i16;
                int g7 = g(i15, 2, i6 - 3);
                int i18 = 0;
                for (int i19 = -2; i19 <= 2; i19++) {
                    int[] iArr2 = iArr[g6 + i19];
                    i18 += iArr2[g7 - 2] + iArr2[g7 - 1] + iArr2[g7] + iArr2[g7 + 1] + iArr2[g7 + 2];
                }
                h(bArr, i17, i14, i18 / 25, i8, bVar);
            }
        }
    }

    private static int g(int i6, int i7, int i8) {
        return i6 < i7 ? i7 : i6 > i8 ? i8 : i6;
    }

    private static void h(byte[] bArr, int i6, int i7, int i8, int i9, b bVar) {
        int i10 = (i7 * i9) + i6;
        int i11 = 0;
        while (i11 < 8) {
            for (int i12 = 0; i12 < 8; i12++) {
                if ((bArr[i10 + i12] & 255) <= i8) {
                    bVar.j(i6 + i12, i7 + i11);
                }
            }
            i11++;
            i10 += i9;
        }
    }

    @Override // s3.h, com.google.zxing.b
    public b a() {
        b a6;
        b bVar = this.f13288e;
        if (bVar != null) {
            return bVar;
        }
        com.google.zxing.i b6 = b();
        int d6 = b6.d();
        int a7 = b6.a();
        if (d6 < 40 || a7 < 40) {
            a6 = super.a();
        } else {
            byte[] b7 = b6.b();
            int i6 = d6 >> 3;
            if ((d6 & 7) != 0) {
                i6++;
            }
            int i7 = i6;
            int i8 = a7 >> 3;
            if ((a7 & 7) != 0) {
                i8++;
            }
            int i9 = i8;
            int[][] e6 = e(b7, i7, i9, d6, a7);
            a6 = new b(d6, a7);
            f(b7, i7, i9, d6, a7, e6, a6);
        }
        this.f13288e = a6;
        return this.f13288e;
    }
}
