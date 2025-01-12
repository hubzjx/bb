package com.google.android.exoplayer2.util;

import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f4652a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f4653b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c  reason: collision with root package name */
    private static final Object f4654c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static int[] f4655d = new int[10];

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f4656a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4657b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f4658c;

        public a(int i6, int i7, boolean z5) {
            this.f4656a = i6;
            this.f4657b = i7;
            this.f4658c = z5;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f4659a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4660b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4661c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4662d;

        /* renamed from: e  reason: collision with root package name */
        public final int f4663e;

        /* renamed from: f  reason: collision with root package name */
        public final int f4664f;

        /* renamed from: g  reason: collision with root package name */
        public final float f4665g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f4666h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f4667i;

        /* renamed from: j  reason: collision with root package name */
        public final int f4668j;

        /* renamed from: k  reason: collision with root package name */
        public final int f4669k;

        /* renamed from: l  reason: collision with root package name */
        public final int f4670l;

        /* renamed from: m  reason: collision with root package name */
        public final boolean f4671m;

        public b(int i6, int i7, int i8, int i9, int i10, int i11, float f6, boolean z5, boolean z6, int i12, int i13, int i14, boolean z7) {
            this.f4659a = i6;
            this.f4660b = i7;
            this.f4661c = i8;
            this.f4662d = i9;
            this.f4663e = i10;
            this.f4664f = i11;
            this.f4665g = f6;
            this.f4666h = z5;
            this.f4667i = z6;
            this.f4668j = i12;
            this.f4669k = i13;
            this.f4670l = i14;
            this.f4671m = z7;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = i6 + 1;
            if (i8 >= position) {
                byteBuffer.clear();
                return;
            }
            int i9 = byteBuffer.get(i6) & 255;
            if (i7 == 3) {
                if (i9 == 1 && (byteBuffer.get(i8) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i6 - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i9 == 0) {
                i7++;
            }
            if (i9 != 0) {
                i7 = 0;
            }
            i6 = i8;
        }
    }

    public static int c(byte[] bArr, int i6, int i7, boolean[] zArr) {
        int i8 = i7 - i6;
        com.google.android.exoplayer2.util.a.g(i8 >= 0);
        if (i8 == 0) {
            return i7;
        }
        if (zArr[0]) {
            a(zArr);
            return i6 - 3;
        } else if (i8 > 1 && zArr[1] && bArr[i6] == 1) {
            a(zArr);
            return i6 - 2;
        } else if (i8 > 2 && zArr[2] && bArr[i6] == 0 && bArr[i6 + 1] == 1) {
            a(zArr);
            return i6 - 1;
        } else {
            int i9 = i7 - 1;
            int i10 = i6 + 2;
            while (i10 < i9) {
                byte b6 = bArr[i10];
                if ((b6 & 254) == 0) {
                    int i11 = i10 - 2;
                    if (bArr[i11] == 0 && bArr[i10 - 1] == 0 && b6 == 1) {
                        a(zArr);
                        return i11;
                    }
                    i10 -= 2;
                }
                i10 += 3;
            }
            zArr[0] = i8 <= 2 ? !(i8 != 2 ? !(zArr[1] && bArr[i9] == 1) : !(zArr[2] && bArr[i7 + (-2)] == 0 && bArr[i9] == 1)) : bArr[i7 + (-3)] == 0 && bArr[i7 + (-2)] == 0 && bArr[i9] == 1;
            zArr[1] = i8 <= 1 ? zArr[2] && bArr[i9] == 0 : bArr[i7 + (-2)] == 0 && bArr[i9] == 0;
            zArr[2] = bArr[i9] == 0;
            return i7;
        }
    }

    private static int d(byte[] bArr, int i6, int i7) {
        while (i6 < i7 - 2) {
            if (bArr[i6] == 0 && bArr[i6 + 1] == 0 && bArr[i6 + 2] == 3) {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    public static int e(byte[] bArr, int i6) {
        return (bArr[i6 + 3] & 126) >> 1;
    }

    public static int f(byte[] bArr, int i6) {
        return bArr[i6 + 3] & 31;
    }

    public static boolean g(String str, byte b6) {
        if ("video/avc".equals(str) && (b6 & 31) == 6) {
            return true;
        }
        return "video/hevc".equals(str) && ((b6 & 126) >> 1) == 39;
    }

    public static a h(byte[] bArr, int i6, int i7) {
        z zVar = new z(bArr, i6, i7);
        zVar.l(8);
        int h6 = zVar.h();
        int h7 = zVar.h();
        zVar.k();
        return new a(h6, h7, zVar.d());
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b i(byte[] bArr, int i6, int i7) {
        int h6;
        boolean d6;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        boolean d7;
        float f6;
        int e6;
        int i10;
        z zVar = new z(bArr, i6, i7);
        zVar.l(8);
        int e7 = zVar.e(8);
        int e8 = zVar.e(8);
        int e9 = zVar.e(8);
        int h7 = zVar.h();
        if (e7 == 100 || e7 == 110 || e7 == 122 || e7 == 244 || e7 == 44 || e7 == 83 || e7 == 86 || e7 == 118 || e7 == 128 || e7 == 138) {
            h6 = zVar.h();
            d6 = h6 == 3 ? zVar.d() : false;
            zVar.h();
            zVar.h();
            zVar.k();
            if (zVar.d()) {
                int i11 = h6 != 3 ? 8 : 12;
                int i12 = 0;
                while (i12 < i11) {
                    if (zVar.d()) {
                        j(zVar, i12 < 6 ? 16 : 64);
                    }
                    i12++;
                }
            }
        } else {
            h6 = 1;
            d6 = false;
        }
        int h8 = zVar.h() + 4;
        int h9 = zVar.h();
        if (h9 == 0) {
            i9 = zVar.h() + 4;
            i8 = h6;
            z5 = d6;
        } else if (h9 == 1) {
            boolean d8 = zVar.d();
            zVar.g();
            zVar.g();
            z5 = d6;
            long h10 = zVar.h();
            i8 = h6;
            for (int i13 = 0; i13 < h10; i13++) {
                zVar.h();
            }
            z6 = d8;
            i9 = 0;
            zVar.h();
            zVar.k();
            int h11 = zVar.h() + 1;
            d7 = zVar.d();
            int h12 = (2 - (d7 ? 1 : 0)) * (zVar.h() + 1);
            if (!d7) {
                zVar.k();
            }
            zVar.k();
            int i14 = h11 * 16;
            int i15 = h12 * 16;
            if (zVar.d()) {
                int h13 = zVar.h();
                int h14 = zVar.h();
                int h15 = zVar.h();
                int h16 = zVar.h();
                if (i8 == 0) {
                    i10 = 2 - (d7 ? 1 : 0);
                } else {
                    int i16 = i8;
                    r9 = i16 == 3 ? 1 : 2;
                    i10 = (2 - (d7 ? 1 : 0)) * (i16 == 1 ? 2 : 1);
                }
                i14 -= (h13 + h14) * r9;
                i15 -= (h15 + h16) * i10;
            }
            int i17 = i14;
            int i18 = i15;
            float f7 = 1.0f;
            if (zVar.d() && zVar.d()) {
                e6 = zVar.e(8);
                if (e6 != 255) {
                    int e10 = zVar.e(16);
                    int e11 = zVar.e(16);
                    if (e10 != 0 && e11 != 0) {
                        f7 = e10 / e11;
                    }
                    f6 = f7;
                } else {
                    float[] fArr = f4653b;
                    if (e6 < fArr.length) {
                        f6 = fArr[e6];
                    } else {
                        StringBuilder sb = new StringBuilder(46);
                        sb.append("Unexpected aspect_ratio_idc value: ");
                        sb.append(e6);
                        n.h("NalUnitUtil", sb.toString());
                    }
                }
                return new b(e7, e8, e9, h7, i17, i18, f6, z5, d7, h8, h9, i9, z6);
            }
            f6 = 1.0f;
            return new b(e7, e8, e9, h7, i17, i18, f6, z5, d7, h8, h9, i9, z6);
        } else {
            i8 = h6;
            z5 = d6;
            i9 = 0;
        }
        z6 = false;
        zVar.h();
        zVar.k();
        int h112 = zVar.h() + 1;
        d7 = zVar.d();
        int h122 = (2 - (d7 ? 1 : 0)) * (zVar.h() + 1);
        if (!d7) {
        }
        zVar.k();
        int i142 = h112 * 16;
        int i152 = h122 * 16;
        if (zVar.d()) {
        }
        int i172 = i142;
        int i182 = i152;
        float f72 = 1.0f;
        if (zVar.d()) {
            e6 = zVar.e(8);
            if (e6 != 255) {
            }
            return new b(e7, e8, e9, h7, i172, i182, f6, z5, d7, h8, h9, i9, z6);
        }
        f6 = 1.0f;
        return new b(e7, e8, e9, h7, i172, i182, f6, z5, d7, h8, h9, i9, z6);
    }

    private static void j(z zVar, int i6) {
        int i7 = 8;
        int i8 = 8;
        for (int i9 = 0; i9 < i6; i9++) {
            if (i7 != 0) {
                i7 = ((zVar.g() + i8) + 256) % 256;
            }
            if (i7 != 0) {
                i8 = i7;
            }
        }
    }

    public static int k(byte[] bArr, int i6) {
        int i7;
        synchronized (f4654c) {
            int i8 = 0;
            int i9 = 0;
            while (i8 < i6) {
                try {
                    i8 = d(bArr, i8, i6);
                    if (i8 < i6) {
                        int[] iArr = f4655d;
                        if (iArr.length <= i9) {
                            f4655d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f4655d[i9] = i8;
                        i8 += 3;
                        i9++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i7 = i6 - i9;
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < i9; i12++) {
                int i13 = f4655d[i12] - i11;
                System.arraycopy(bArr, i11, bArr, i10, i13);
                int i14 = i10 + i13;
                int i15 = i14 + 1;
                bArr[i14] = 0;
                i10 = i15 + 1;
                bArr[i15] = 0;
                i11 += i13 + 3;
            }
            System.arraycopy(bArr, i11, bArr, i10, i7 - i10);
        }
        return i7;
    }
}
