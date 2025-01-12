package com.google.android.exoplayer2.audio;

import java.nio.ShortBuffer;
import java.util.Arrays;
/* loaded from: classes.dex */
final class g1 {

    /* renamed from: a  reason: collision with root package name */
    private final int f3377a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3378b;

    /* renamed from: c  reason: collision with root package name */
    private final float f3379c;

    /* renamed from: d  reason: collision with root package name */
    private final float f3380d;

    /* renamed from: e  reason: collision with root package name */
    private final float f3381e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3382f;

    /* renamed from: g  reason: collision with root package name */
    private final int f3383g;

    /* renamed from: h  reason: collision with root package name */
    private final int f3384h;

    /* renamed from: i  reason: collision with root package name */
    private final short[] f3385i;

    /* renamed from: j  reason: collision with root package name */
    private short[] f3386j;

    /* renamed from: k  reason: collision with root package name */
    private int f3387k;

    /* renamed from: l  reason: collision with root package name */
    private short[] f3388l;

    /* renamed from: m  reason: collision with root package name */
    private int f3389m;

    /* renamed from: n  reason: collision with root package name */
    private short[] f3390n;

    /* renamed from: o  reason: collision with root package name */
    private int f3391o;

    /* renamed from: p  reason: collision with root package name */
    private int f3392p;

    /* renamed from: q  reason: collision with root package name */
    private int f3393q;

    /* renamed from: r  reason: collision with root package name */
    private int f3394r;

    /* renamed from: s  reason: collision with root package name */
    private int f3395s;

    /* renamed from: t  reason: collision with root package name */
    private int f3396t;

    /* renamed from: u  reason: collision with root package name */
    private int f3397u;

    /* renamed from: v  reason: collision with root package name */
    private int f3398v;

    public g1(int i6, int i7, float f6, float f7, int i8) {
        this.f3377a = i6;
        this.f3378b = i7;
        this.f3379c = f6;
        this.f3380d = f7;
        this.f3381e = i6 / i8;
        this.f3382f = i6 / 400;
        int i9 = i6 / 65;
        this.f3383g = i9;
        int i10 = i9 * 2;
        this.f3384h = i10;
        this.f3385i = new short[i10];
        this.f3386j = new short[i10 * i7];
        this.f3388l = new short[i10 * i7];
        this.f3390n = new short[i10 * i7];
    }

    private void a(float f6, int i6) {
        int i7;
        int i8;
        if (this.f3389m == i6) {
            return;
        }
        int i9 = this.f3377a;
        int i10 = (int) (i9 / f6);
        while (true) {
            if (i10 <= 16384 && i9 <= 16384) {
                break;
            }
            i10 /= 2;
            i9 /= 2;
        }
        n(i6);
        int i11 = 0;
        while (true) {
            int i12 = this.f3391o;
            if (i11 >= i12 - 1) {
                t(i12 - 1);
                return;
            }
            while (true) {
                i7 = this.f3392p;
                int i13 = (i7 + 1) * i10;
                i8 = this.f3393q;
                if (i13 <= i8 * i9) {
                    break;
                }
                this.f3388l = f(this.f3388l, this.f3389m, 1);
                int i14 = 0;
                while (true) {
                    int i15 = this.f3378b;
                    if (i14 < i15) {
                        this.f3388l[(this.f3389m * i15) + i14] = m(this.f3390n, (i15 * i11) + i14, i9, i10);
                        i14++;
                    }
                }
                this.f3393q++;
                this.f3389m++;
            }
            int i16 = i7 + 1;
            this.f3392p = i16;
            if (i16 == i9) {
                this.f3392p = 0;
                com.google.android.exoplayer2.util.a.g(i8 == i10);
                this.f3393q = 0;
            }
            i11++;
        }
    }

    private void b(float f6) {
        int v5;
        int i6 = this.f3387k;
        if (i6 < this.f3384h) {
            return;
        }
        int i7 = 0;
        do {
            if (this.f3394r > 0) {
                v5 = c(i7);
            } else {
                int g6 = g(this.f3386j, i7);
                int i8 = (f6 > 1.0d ? 1 : (f6 == 1.0d ? 0 : -1));
                short[] sArr = this.f3386j;
                v5 = i8 > 0 ? g6 + v(sArr, i7, f6, g6) : l(sArr, i7, f6, g6);
            }
            i7 += v5;
        } while (this.f3384h + i7 <= i6);
        u(i7);
    }

    private int c(int i6) {
        int min = Math.min(this.f3384h, this.f3394r);
        d(this.f3386j, i6, min);
        this.f3394r -= min;
        return min;
    }

    private void d(short[] sArr, int i6, int i7) {
        short[] f6 = f(this.f3388l, this.f3389m, i7);
        this.f3388l = f6;
        int i8 = this.f3378b;
        System.arraycopy(sArr, i6 * i8, f6, this.f3389m * i8, i8 * i7);
        this.f3389m += i7;
    }

    private void e(short[] sArr, int i6, int i7) {
        int i8 = this.f3384h / i7;
        int i9 = this.f3378b;
        int i10 = i7 * i9;
        int i11 = i6 * i9;
        for (int i12 = 0; i12 < i8; i12++) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                i13 += sArr[(i12 * i10) + i11 + i14];
            }
            this.f3385i[i12] = (short) (i13 / i10);
        }
    }

    private short[] f(short[] sArr, int i6, int i7) {
        int length = sArr.length;
        int i8 = this.f3378b;
        int i9 = length / i8;
        return i6 + i7 <= i9 ? sArr : Arrays.copyOf(sArr, (((i9 * 3) / 2) + i7) * i8);
    }

    private int g(short[] sArr, int i6) {
        int i7;
        int i8 = this.f3377a;
        int i9 = i8 > 4000 ? i8 / 4000 : 1;
        if (this.f3378b == 1 && i9 == 1) {
            i7 = h(sArr, i6, this.f3382f, this.f3383g);
        } else {
            e(sArr, i6, i9);
            int h6 = h(this.f3385i, 0, this.f3382f / i9, this.f3383g / i9);
            if (i9 != 1) {
                int i10 = h6 * i9;
                int i11 = i9 * 4;
                int i12 = i10 - i11;
                int i13 = i10 + i11;
                int i14 = this.f3382f;
                if (i12 < i14) {
                    i12 = i14;
                }
                int i15 = this.f3383g;
                if (i13 > i15) {
                    i13 = i15;
                }
                if (this.f3378b == 1) {
                    i7 = h(sArr, i6, i12, i13);
                } else {
                    e(sArr, i6, 1);
                    i7 = h(this.f3385i, 0, i12, i13);
                }
            } else {
                i7 = h6;
            }
        }
        int i16 = p(this.f3397u, this.f3398v) ? this.f3395s : i7;
        this.f3396t = this.f3397u;
        this.f3395s = i7;
        return i16;
    }

    private int h(short[] sArr, int i6, int i7, int i8) {
        int i9 = i6 * this.f3378b;
        int i10 = 255;
        int i11 = 1;
        int i12 = 0;
        int i13 = 0;
        while (i7 <= i8) {
            int i14 = 0;
            for (int i15 = 0; i15 < i7; i15++) {
                i14 += Math.abs(sArr[i9 + i15] - sArr[(i9 + i7) + i15]);
            }
            if (i14 * i12 < i11 * i7) {
                i12 = i7;
                i11 = i14;
            }
            if (i14 * i10 > i13 * i7) {
                i10 = i7;
                i13 = i14;
            }
            i7++;
        }
        this.f3397u = i11 / i12;
        this.f3398v = i13 / i10;
        return i12;
    }

    private int l(short[] sArr, int i6, float f6, int i7) {
        int i8;
        if (f6 < 0.5f) {
            i8 = (int) ((i7 * f6) / (1.0f - f6));
        } else {
            this.f3394r = (int) ((i7 * ((2.0f * f6) - 1.0f)) / (1.0f - f6));
            i8 = i7;
        }
        int i9 = i7 + i8;
        short[] f7 = f(this.f3388l, this.f3389m, i9);
        this.f3388l = f7;
        int i10 = this.f3378b;
        System.arraycopy(sArr, i6 * i10, f7, this.f3389m * i10, i10 * i7);
        o(i8, this.f3378b, this.f3388l, this.f3389m + i7, sArr, i6 + i7, sArr, i6);
        this.f3389m += i9;
        return i8;
    }

    private short m(short[] sArr, int i6, int i7, int i8) {
        short s5 = sArr[i6];
        short s6 = sArr[i6 + this.f3378b];
        int i9 = this.f3393q * i7;
        int i10 = this.f3392p;
        int i11 = i10 * i8;
        int i12 = (i10 + 1) * i8;
        int i13 = i12 - i9;
        int i14 = i12 - i11;
        return (short) (((s5 * i13) + ((i14 - i13) * s6)) / i14);
    }

    private void n(int i6) {
        int i7 = this.f3389m - i6;
        short[] f6 = f(this.f3390n, this.f3391o, i7);
        this.f3390n = f6;
        short[] sArr = this.f3388l;
        int i8 = this.f3378b;
        System.arraycopy(sArr, i6 * i8, f6, this.f3391o * i8, i8 * i7);
        this.f3389m = i6;
        this.f3391o += i7;
    }

    private static void o(int i6, int i7, short[] sArr, int i8, short[] sArr2, int i9, short[] sArr3, int i10) {
        for (int i11 = 0; i11 < i7; i11++) {
            int i12 = (i8 * i7) + i11;
            int i13 = (i10 * i7) + i11;
            int i14 = (i9 * i7) + i11;
            for (int i15 = 0; i15 < i6; i15++) {
                sArr[i12] = (short) (((sArr2[i14] * (i6 - i15)) + (sArr3[i13] * i15)) / i6);
                i12 += i7;
                i14 += i7;
                i13 += i7;
            }
        }
    }

    private boolean p(int i6, int i7) {
        return i6 != 0 && this.f3395s != 0 && i7 <= i6 * 3 && i6 * 2 > this.f3396t * 3;
    }

    private void q() {
        int i6 = this.f3389m;
        float f6 = this.f3379c;
        float f7 = this.f3380d;
        float f8 = f6 / f7;
        float f9 = this.f3381e * f7;
        double d6 = f8;
        if (d6 > 1.00001d || d6 < 0.99999d) {
            b(f8);
        } else {
            d(this.f3386j, 0, this.f3387k);
            this.f3387k = 0;
        }
        if (f9 != 1.0f) {
            a(f9, i6);
        }
    }

    private void t(int i6) {
        if (i6 == 0) {
            return;
        }
        short[] sArr = this.f3390n;
        int i7 = this.f3378b;
        System.arraycopy(sArr, i6 * i7, sArr, 0, (this.f3391o - i6) * i7);
        this.f3391o -= i6;
    }

    private void u(int i6) {
        int i7 = this.f3387k - i6;
        short[] sArr = this.f3386j;
        int i8 = this.f3378b;
        System.arraycopy(sArr, i6 * i8, sArr, 0, i8 * i7);
        this.f3387k = i7;
    }

    private int v(short[] sArr, int i6, float f6, int i7) {
        int i8;
        if (f6 >= 2.0f) {
            i8 = (int) (i7 / (f6 - 1.0f));
        } else {
            this.f3394r = (int) ((i7 * (2.0f - f6)) / (f6 - 1.0f));
            i8 = i7;
        }
        short[] f7 = f(this.f3388l, this.f3389m, i8);
        this.f3388l = f7;
        o(i8, this.f3378b, f7, this.f3389m, sArr, i6, sArr, i6 + i7);
        this.f3389m += i8;
        return i8;
    }

    public void i() {
        this.f3387k = 0;
        this.f3389m = 0;
        this.f3391o = 0;
        this.f3392p = 0;
        this.f3393q = 0;
        this.f3394r = 0;
        this.f3395s = 0;
        this.f3396t = 0;
        this.f3397u = 0;
        this.f3398v = 0;
    }

    public void j(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f3378b, this.f3389m);
        shortBuffer.put(this.f3388l, 0, this.f3378b * min);
        int i6 = this.f3389m - min;
        this.f3389m = i6;
        short[] sArr = this.f3388l;
        int i7 = this.f3378b;
        System.arraycopy(sArr, min * i7, sArr, 0, i6 * i7);
    }

    public int k() {
        return this.f3389m * this.f3378b * 2;
    }

    public void r() {
        int i6;
        int i7 = this.f3387k;
        float f6 = this.f3379c;
        float f7 = this.f3380d;
        int i8 = this.f3389m + ((int) ((((i7 / (f6 / f7)) + this.f3391o) / (this.f3381e * f7)) + 0.5f));
        this.f3386j = f(this.f3386j, i7, (this.f3384h * 2) + i7);
        int i9 = 0;
        while (true) {
            i6 = this.f3384h;
            int i10 = this.f3378b;
            if (i9 >= i6 * 2 * i10) {
                break;
            }
            this.f3386j[(i10 * i7) + i9] = 0;
            i9++;
        }
        this.f3387k += i6 * 2;
        q();
        if (this.f3389m > i8) {
            this.f3389m = i8;
        }
        this.f3387k = 0;
        this.f3394r = 0;
        this.f3391o = 0;
    }

    public void s(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i6 = this.f3378b;
        int i7 = remaining / i6;
        short[] f6 = f(this.f3386j, this.f3387k, i7);
        this.f3386j = f6;
        shortBuffer.get(f6, this.f3387k * this.f3378b, ((i6 * i7) * 2) / 2);
        this.f3387k += i7;
        q();
    }
}
