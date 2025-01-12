package t3;
/* loaded from: classes.dex */
public abstract class a {
    public static float a(float f6, float f7, float f8, float f9) {
        float f10 = f6 - f8;
        float f11 = f7 - f9;
        return (float) Math.sqrt((f10 * f10) + (f11 * f11));
    }

    public static float b(int i6, int i7, int i8, int i9) {
        int i10 = i6 - i8;
        int i11 = i7 - i9;
        return (float) Math.sqrt((i10 * i10) + (i11 * i11));
    }

    public static int c(float f6) {
        return (int) (f6 + (f6 < 0.0f ? -0.5f : 0.5f));
    }
}
