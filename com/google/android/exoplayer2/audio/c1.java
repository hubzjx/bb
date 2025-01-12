package com.google.android.exoplayer2.audio;
/* loaded from: classes.dex */
public abstract class c1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f3337a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f3338b = {44100, 48000, 32000};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f3339c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f3340d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f3341e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f3342f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f3343g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f3344a;

        /* renamed from: b  reason: collision with root package name */
        public String f3345b;

        /* renamed from: c  reason: collision with root package name */
        public int f3346c;

        /* renamed from: d  reason: collision with root package name */
        public int f3347d;

        /* renamed from: e  reason: collision with root package name */
        public int f3348e;

        /* renamed from: f  reason: collision with root package name */
        public int f3349f;

        /* renamed from: g  reason: collision with root package name */
        public int f3350g;

        /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(int i6) {
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            if (!c1.l(i6) || (i7 = (i6 >>> 19) & 3) == 1 || (i8 = (i6 >>> 17) & 3) == 0 || (i9 = (i6 >>> 12) & 15) == 0 || i9 == 15 || (i10 = (i6 >>> 10) & 3) == 3) {
                return false;
            }
            this.f3344a = i7;
            this.f3345b = c1.f3337a[3 - i8];
            int i13 = c1.f3338b[i10];
            this.f3347d = i13;
            if (i7 != 2) {
                if (i7 == 0) {
                    i11 = i13 / 4;
                }
                int i14 = (i6 >>> 9) & 1;
                this.f3350g = c1.k(i7, i8);
                if (i8 != 3) {
                    int i15 = i7 == 3 ? c1.f3339c[i9 - 1] : c1.f3340d[i9 - 1];
                    this.f3349f = i15;
                    i12 = (((i15 * 12) / this.f3347d) + i14) * 4;
                } else {
                    if (i7 != 3) {
                        int i16 = c1.f3343g[i9 - 1];
                        this.f3349f = i16;
                        this.f3346c = (((i8 == 1 ? 72 : 144) * i16) / this.f3347d) + i14;
                        this.f3348e = ((i6 >> 6) & 3) == 3 ? 1 : 2;
                        return true;
                    }
                    int i17 = i8 == 2 ? c1.f3341e[i9 - 1] : c1.f3342f[i9 - 1];
                    this.f3349f = i17;
                    i12 = ((i17 * 144) / this.f3347d) + i14;
                }
                this.f3346c = i12;
                this.f3348e = ((i6 >> 6) & 3) == 3 ? 1 : 2;
                return true;
            }
            i11 = i13 / 2;
            this.f3347d = i11;
            int i142 = (i6 >>> 9) & 1;
            this.f3350g = c1.k(i7, i8);
            if (i8 != 3) {
            }
            this.f3346c = i12;
            this.f3348e = ((i6 >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }
    }

    public static int j(int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        if (!l(i6) || (i7 = (i6 >>> 19) & 3) == 1 || (i8 = (i6 >>> 17) & 3) == 0 || (i9 = (i6 >>> 12) & 15) == 0 || i9 == 15 || (i10 = (i6 >>> 10) & 3) == 3) {
            return -1;
        }
        int i11 = f3338b[i10];
        if (i7 == 2) {
            i11 /= 2;
        } else if (i7 == 0) {
            i11 /= 4;
        }
        int i12 = (i6 >>> 9) & 1;
        if (i8 == 3) {
            return ((((i7 == 3 ? f3339c[i9 - 1] : f3340d[i9 - 1]) * 12) / i11) + i12) * 4;
        }
        int i13 = i7 == 3 ? i8 == 2 ? f3341e[i9 - 1] : f3342f[i9 - 1] : f3343g[i9 - 1];
        if (i7 == 3) {
            return ((i13 * 144) / i11) + i12;
        }
        return (((i8 == 1 ? 72 : 144) * i13) / i11) + i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i6, int i7) {
        if (i7 == 1) {
            return i6 == 3 ? 1152 : 576;
        } else if (i7 != 2) {
            if (i7 == 3) {
                return 384;
            }
            throw new IllegalArgumentException();
        } else {
            return 1152;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(int i6) {
        return (i6 & (-2097152)) == -2097152;
    }

    public static int m(int i6) {
        int i7;
        int i8;
        if (!l(i6) || (i7 = (i6 >>> 19) & 3) == 1 || (i8 = (i6 >>> 17) & 3) == 0) {
            return -1;
        }
        int i9 = (i6 >>> 12) & 15;
        int i10 = (i6 >>> 10) & 3;
        if (i9 == 0 || i9 == 15 || i10 == 3) {
            return -1;
        }
        return k(i7, i8);
    }
}
