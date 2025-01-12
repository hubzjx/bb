package e0;

import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class g {
    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    public static void c(ViewGroup.MarginLayoutParams marginLayoutParams, int i6) {
        marginLayoutParams.setMarginEnd(i6);
    }

    public static void d(ViewGroup.MarginLayoutParams marginLayoutParams, int i6) {
        marginLayoutParams.setMarginStart(i6);
    }
}
