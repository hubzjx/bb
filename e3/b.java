package e3;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
/* loaded from: classes.dex */
public abstract class b {
    public static TypedValue a(Context context, int i6) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i6, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(Context context, int i6, boolean z5) {
        TypedValue a6 = a(context, i6);
        return (a6 == null || a6.type != 18) ? z5 : a6.data != 0;
    }

    public static int c(Context context, int i6, String str) {
        TypedValue a6 = a(context, i6);
        if (a6 != null) {
            return a6.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i6)));
    }

    public static int d(View view, int i6) {
        return c(view.getContext(), i6, view.getClass().getCanonicalName());
    }
}
