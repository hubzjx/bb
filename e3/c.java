package e3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.widget.c2;
/* loaded from: classes.dex */
public abstract class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i6) {
        int resourceId;
        ColorStateList c6;
        return (!typedArray.hasValue(i6) || (resourceId = typedArray.getResourceId(i6, 0)) == 0 || (c6 = e.b.c(context, resourceId)) == null) ? typedArray.getColorStateList(i6) : c6;
    }

    public static ColorStateList b(Context context, c2 c2Var, int i6) {
        int n5;
        ColorStateList c6;
        return (!c2Var.s(i6) || (n5 = c2Var.n(i6, 0)) == 0 || (c6 = e.b.c(context, n5)) == null) ? c2Var.c(i6) : c6;
    }

    public static int c(Context context, TypedArray typedArray, int i6, int i7) {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(i6, typedValue) && typedValue.type == 2) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i7);
            obtainStyledAttributes.recycle();
            return dimensionPixelSize;
        }
        return typedArray.getDimensionPixelSize(i6, i7);
    }

    public static Drawable d(Context context, TypedArray typedArray, int i6) {
        int resourceId;
        Drawable d6;
        return (!typedArray.hasValue(i6) || (resourceId = typedArray.getResourceId(i6, 0)) == 0 || (d6 = e.b.d(context, resourceId)) == null) ? typedArray.getDrawable(i6) : d6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(TypedArray typedArray, int i6, int i7) {
        return typedArray.hasValue(i6) ? i6 : i7;
    }

    public static d f(Context context, TypedArray typedArray, int i6) {
        int resourceId;
        if (!typedArray.hasValue(i6) || (resourceId = typedArray.getResourceId(i6, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }

    public static boolean g(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean h(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
