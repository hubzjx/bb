package e0;

import android.graphics.Rect;
import android.view.Gravity;
/* loaded from: classes.dex */
public abstract class d {
    public static void a(int i6, int i7, int i8, Rect rect, Rect rect2, int i9) {
        Gravity.apply(i6, i7, i8, rect, rect2, i9);
    }

    public static int b(int i6, int i7) {
        return Gravity.getAbsoluteGravity(i6, i7);
    }
}
