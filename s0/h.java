package s0;

import android.graphics.Color;
/* loaded from: classes.dex */
public abstract class h {
    public static int a(float f6, int i6) {
        return (b(f6) << 24) | (i6 & 16777215);
    }

    public static int b(float f6) {
        return Math.round(f6 * 255.0f);
    }

    public static int c(int i6, float f6) {
        Color.colorToHSV(i6, r0);
        float[] fArr = {0.0f, 0.0f, f6};
        return Color.HSVToColor(fArr);
    }

    public static float d(int i6) {
        return Color.alpha(i6) / 255.0f;
    }

    public static String e(int i6, boolean z5) {
        return String.format(z5 ? "#%08X" : "#%06X", Integer.valueOf(i6 & (z5 ? -1 : 16777215))).toUpperCase();
    }

    public static float f(int i6) {
        float[] fArr = new float[3];
        Color.colorToHSV(i6, fArr);
        return fArr[2];
    }
}
