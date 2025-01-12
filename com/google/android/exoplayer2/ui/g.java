package com.google.android.exoplayer2.ui;
/* loaded from: classes.dex */
abstract class g {
    public static float a(int i6, float f6, int i7, int i8) {
        float f7;
        if (f6 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i6 == 0) {
            f7 = i8;
        } else if (i6 != 1) {
            if (i6 != 2) {
                return -3.4028235E38f;
            }
            return f6;
        } else {
            f7 = i7;
        }
        return f6 * f7;
    }
}
