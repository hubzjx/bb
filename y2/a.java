package y2;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import e3.b;
/* loaded from: classes.dex */
public abstract class a {
    public static int a(Context context, int i6, int i7) {
        TypedValue a6 = b.a(context, i6);
        return a6 != null ? a6.data : i7;
    }

    public static int b(Context context, int i6, String str) {
        return b.c(context, i6, str);
    }

    public static int c(View view, int i6) {
        return b.d(view, i6);
    }

    public static int d(View view, int i6, int i7) {
        return a(view.getContext(), i6, i7);
    }

    public static boolean e(int i6) {
        return i6 != 0 && w.a.b(i6) > 0.5d;
    }

    public static int f(int i6, int i7) {
        return w.a.e(i7, i6);
    }

    public static int g(int i6, int i7, float f6) {
        return f(i6, w.a.h(i7, Math.round(Color.alpha(i7) * f6)));
    }

    public static int h(View view, int i6, int i7, float f6) {
        return g(c(view, i6), c(view, i7), f6);
    }
}
