package com.google.android.exoplayer2;
/* loaded from: classes.dex */
public abstract /* synthetic */ class o1 {
    public static int a(int i6) {
        return b(i6, 0, 0);
    }

    public static int b(int i6, int i7, int i8) {
        return i6 | i7 | i8;
    }

    public static int c(int i6) {
        return i6 & 24;
    }

    public static int d(int i6) {
        return i6 & 7;
    }

    public static String e(int i6) {
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 == 4) {
                            return "YES";
                        }
                        throw new IllegalStateException();
                    }
                    return "NO_EXCEEDS_CAPABILITIES";
                }
                return "NO_UNSUPPORTED_DRM";
            }
            return "NO_UNSUPPORTED_TYPE";
        }
        return "NO";
    }

    public static int f(int i6) {
        return i6 & 32;
    }
}
