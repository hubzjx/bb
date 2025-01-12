package com.google.android.exoplayer2.audio;
/* loaded from: classes.dex */
public abstract class j1 {
    public static int a(int i6, int i7) {
        if (i6 != 1) {
            if (i6 == 3) {
                return i7 == 32 ? 4 : 0;
            } else if (i6 != 65534) {
                return 0;
            }
        }
        return com.google.android.exoplayer2.util.s0.Y(i7);
    }
}
