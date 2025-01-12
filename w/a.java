package w;

import android.graphics.Color;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal f13688a = new ThreadLocal();

    public static void a(int i6, int i7, int i8, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d6 = i6 / 255.0d;
        double pow = d6 < 0.04045d ? d6 / 12.92d : Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
        double d7 = i7 / 255.0d;
        double pow2 = d7 < 0.04045d ? d7 / 12.92d : Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
        double d8 = i8 / 255.0d;
        double pow3 = d8 < 0.04045d ? d8 / 12.92d : Math.pow((d8 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * 100.0d;
        dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * 100.0d;
        dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * 100.0d;
    }

    public static double b(int i6) {
        double[] g6 = g();
        c(i6, g6);
        return g6[1] / 100.0d;
    }

    public static void c(int i6, double[] dArr) {
        a(Color.red(i6), Color.green(i6), Color.blue(i6), dArr);
    }

    private static int d(int i6, int i7) {
        return 255 - (((255 - i7) * (255 - i6)) / 255);
    }

    public static int e(int i6, int i7) {
        int alpha = Color.alpha(i7);
        int alpha2 = Color.alpha(i6);
        int d6 = d(alpha2, alpha);
        return Color.argb(d6, f(Color.red(i6), alpha2, Color.red(i7), alpha, d6), f(Color.green(i6), alpha2, Color.green(i7), alpha, d6), f(Color.blue(i6), alpha2, Color.blue(i7), alpha, d6));
    }

    private static int f(int i6, int i7, int i8, int i9, int i10) {
        if (i10 == 0) {
            return 0;
        }
        return (((i6 * 255) * i7) + ((i8 * i9) * (255 - i7))) / (i10 * 255);
    }

    private static double[] g() {
        ThreadLocal threadLocal = f13688a;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr == null) {
            double[] dArr2 = new double[3];
            threadLocal.set(dArr2);
            return dArr2;
        }
        return dArr;
    }

    public static int h(int i6, int i7) {
        if (i7 < 0 || i7 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i6 & 16777215) | (i7 << 24);
    }
}
