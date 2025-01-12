package k4;
/* loaded from: classes.dex */
public abstract class c {
    private static final int a(int i6, int i7, int i8) {
        return c(c(i6, i8) - c(i7, i8), i8);
    }

    public static final int b(int i6, int i7, int i8) {
        if (i8 > 0) {
            return i6 >= i7 ? i7 : i7 - a(i7, i6, i8);
        } else if (i8 < 0) {
            return i6 <= i7 ? i7 : i7 + a(i6, i7, -i8);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    private static final int c(int i6, int i7) {
        int i8 = i6 % i7;
        return i8 >= 0 ? i8 : i8 + i7;
    }
}
