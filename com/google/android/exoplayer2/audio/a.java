package com.google.android.exoplayer2.audio;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f3312a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f3313b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f3314a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3315b;

        /* renamed from: c  reason: collision with root package name */
        public final String f3316c;

        private b(int i6, int i7, String str) {
            this.f3314a = i6;
            this.f3315b = i7;
            this.f3316c = str;
        }
    }

    public static byte[] a(int i6, int i7) {
        int i8 = 0;
        int i9 = 0;
        int i10 = -1;
        while (true) {
            int[] iArr = f3312a;
            if (i9 >= iArr.length) {
                break;
            }
            if (i6 == iArr[i9]) {
                i10 = i9;
            }
            i9++;
        }
        int i11 = -1;
        while (true) {
            int[] iArr2 = f3313b;
            if (i8 >= iArr2.length) {
                break;
            }
            if (i7 == iArr2[i8]) {
                i11 = i8;
            }
            i8++;
        }
        if (i6 == -1 || i11 == -1) {
            StringBuilder sb = new StringBuilder(67);
            sb.append("Invalid sample rate or number of channels: ");
            sb.append(i6);
            sb.append(", ");
            sb.append(i7);
            throw new IllegalArgumentException(sb.toString());
        }
        return b(2, i10, i11);
    }

    public static byte[] b(int i6, int i7, int i8) {
        return new byte[]{(byte) (((i6 << 3) & 248) | ((i7 >> 1) & 7)), (byte) (((i7 << 7) & 128) | ((i8 << 3) & b.j.J0))};
    }

    private static int c(com.google.android.exoplayer2.util.x xVar) {
        int h6 = xVar.h(5);
        return h6 == 31 ? xVar.h(6) + 32 : h6;
    }

    public static int d(int i6) {
        if (i6 != 2) {
            if (i6 != 5) {
                if (i6 != 29) {
                    if (i6 != 42) {
                        if (i6 != 22) {
                            return i6 != 23 ? 0 : 15;
                        }
                        return 1073741824;
                    }
                    return 16;
                }
                return 12;
            }
            return 11;
        }
        return 10;
    }

    private static int e(com.google.android.exoplayer2.util.x xVar) {
        int h6 = xVar.h(4);
        if (h6 == 15) {
            return xVar.h(24);
        }
        com.google.android.exoplayer2.util.a.a(h6 < 13);
        return f3312a[h6];
    }

    public static b f(com.google.android.exoplayer2.util.x xVar, boolean z5) {
        int c6 = c(xVar);
        int e6 = e(xVar);
        int h6 = xVar.h(4);
        StringBuilder sb = new StringBuilder(19);
        sb.append("mp4a.40.");
        sb.append(c6);
        String sb2 = sb.toString();
        if (c6 == 5 || c6 == 29) {
            e6 = e(xVar);
            c6 = c(xVar);
            if (c6 == 22) {
                h6 = xVar.h(4);
            }
        }
        if (z5) {
            if (c6 != 1 && c6 != 2 && c6 != 3 && c6 != 4 && c6 != 6 && c6 != 7 && c6 != 17) {
                switch (c6) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        StringBuilder sb3 = new StringBuilder(42);
                        sb3.append("Unsupported audio object type: ");
                        sb3.append(c6);
                        throw new com.google.android.exoplayer2.f1(sb3.toString());
                }
            }
            h(xVar, c6, h6);
            switch (c6) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int h7 = xVar.h(2);
                    if (h7 == 2 || h7 == 3) {
                        StringBuilder sb4 = new StringBuilder(33);
                        sb4.append("Unsupported epConfig: ");
                        sb4.append(h7);
                        throw new com.google.android.exoplayer2.f1(sb4.toString());
                    }
            }
        }
        int i6 = f3313b[h6];
        com.google.android.exoplayer2.util.a.a(i6 != -1);
        return new b(e6, i6, sb2);
    }

    public static b g(byte[] bArr) {
        return f(new com.google.android.exoplayer2.util.x(bArr), false);
    }

    private static void h(com.google.android.exoplayer2.util.x xVar, int i6, int i7) {
        if (xVar.g()) {
            com.google.android.exoplayer2.util.n.h("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (xVar.g()) {
            xVar.r(14);
        }
        boolean g6 = xVar.g();
        if (i7 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i6 == 6 || i6 == 20) {
            xVar.r(3);
        }
        if (g6) {
            if (i6 == 22) {
                xVar.r(16);
            }
            if (i6 == 17 || i6 == 19 || i6 == 20 || i6 == 23) {
                xVar.r(3);
            }
            xVar.r(1);
        }
    }
}
