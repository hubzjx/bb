package com.google.zxing.qrcode.detector;

import com.google.zxing.k;
import com.google.zxing.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final s3.b f5874a;

    /* renamed from: c  reason: collision with root package name */
    private final int f5876c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5877d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5878e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5879f;

    /* renamed from: g  reason: collision with root package name */
    private final float f5880g;

    /* renamed from: b  reason: collision with root package name */
    private final List f5875b = new ArrayList(5);

    /* renamed from: h  reason: collision with root package name */
    private final int[] f5881h = new int[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(s3.b bVar, int i6, int i7, int i8, int i9, float f6, q qVar) {
        this.f5874a = bVar;
        this.f5876c = i6;
        this.f5877d = i7;
        this.f5878e = i8;
        this.f5879f = i9;
        this.f5880g = f6;
    }

    private static float a(int[] iArr, int i6) {
        return (i6 - iArr[2]) - (iArr[1] / 2.0f);
    }

    private float b(int i6, int i7, int i8, int i9) {
        s3.b bVar = this.f5874a;
        int g6 = bVar.g();
        int[] iArr = this.f5881h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i10 = i6;
        while (i10 >= 0 && bVar.e(i7, i10)) {
            int i11 = iArr[1];
            if (i11 > i8) {
                break;
            }
            iArr[1] = i11 + 1;
            i10--;
        }
        if (i10 >= 0 && iArr[1] <= i8) {
            while (i10 >= 0 && !bVar.e(i7, i10)) {
                int i12 = iArr[0];
                if (i12 > i8) {
                    break;
                }
                iArr[0] = i12 + 1;
                i10--;
            }
            if (iArr[0] > i8) {
                return Float.NaN;
            }
            int i13 = i6 + 1;
            while (i13 < g6 && bVar.e(i7, i13)) {
                int i14 = iArr[1];
                if (i14 > i8) {
                    break;
                }
                iArr[1] = i14 + 1;
                i13++;
            }
            if (i13 != g6 && iArr[1] <= i8) {
                while (i13 < g6 && !bVar.e(i7, i13)) {
                    int i15 = iArr[2];
                    if (i15 > i8) {
                        break;
                    }
                    iArr[2] = i15 + 1;
                    i13++;
                }
                int i16 = iArr[2];
                if (i16 <= i8 && Math.abs(((iArr[0] + iArr[1]) + i16) - i9) * 5 < i9 * 2 && d(iArr)) {
                    return a(iArr, i13);
                }
            }
        }
        return Float.NaN;
    }

    private boolean d(int[] iArr) {
        float f6 = this.f5880g;
        float f7 = f6 / 2.0f;
        for (int i6 = 0; i6 < 3; i6++) {
            if (Math.abs(f6 - iArr[i6]) >= f7) {
                return false;
            }
        }
        return true;
    }

    private a e(int[] iArr, int i6, int i7) {
        int i8 = iArr[0] + iArr[1] + iArr[2];
        float a6 = a(iArr, i7);
        float b6 = b(i6, (int) a6, iArr[1] * 2, i8);
        if (Float.isNaN(b6)) {
            return null;
        }
        float f6 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (a aVar : this.f5875b) {
            if (aVar.f(f6, b6, a6)) {
                return aVar.g(b6, a6, f6);
            }
        }
        this.f5875b.add(new a(a6, b6, f6));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a c() {
        a e6;
        a e7;
        int i6 = this.f5876c;
        int i7 = this.f5879f;
        int i8 = this.f5878e + i6;
        int i9 = this.f5877d + (i7 / 2);
        int[] iArr = new int[3];
        for (int i10 = 0; i10 < i7; i10++) {
            int i11 = ((i10 & 1) == 0 ? (i10 + 1) / 2 : -((i10 + 1) / 2)) + i9;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i12 = i6;
            while (i12 < i8 && !this.f5874a.e(i12, i11)) {
                i12++;
            }
            int i13 = 0;
            while (i12 < i8) {
                if (!this.f5874a.e(i12, i11)) {
                    if (i13 == 1) {
                        i13++;
                    }
                    iArr[i13] = iArr[i13] + 1;
                } else if (i13 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i13 != 2) {
                    i13++;
                    iArr[i13] = iArr[i13] + 1;
                } else if (d(iArr) && (e7 = e(iArr, i11, i12)) != null) {
                    return e7;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i13 = 1;
                }
                i12++;
            }
            if (d(iArr) && (e6 = e(iArr, i11, i8)) != null) {
                return e6;
            }
        }
        if (this.f5875b.isEmpty()) {
            throw k.getNotFoundInstance();
        }
        return (a) this.f5875b.get(0);
    }
}
