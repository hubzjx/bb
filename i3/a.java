package i3;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import h.d;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f11031a = {16842752, u2.a.theme};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f11032b = {u2.a.materialThemeOverlay};

    private static int a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f11031a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    private static int b(Context context, AttributeSet attributeSet, int i6, int i7) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f11032b, i6, i7);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i6, int i7) {
        int b6 = b(context, attributeSet, i6, i7);
        boolean z5 = (context instanceof d) && ((d) context).c() == b6;
        if (b6 == 0 || z5) {
            return context;
        }
        d dVar = new d(context, b6);
        int a6 = a(context, attributeSet);
        if (a6 != 0) {
            dVar.getTheme().applyStyle(a6, true);
        }
        return dVar;
    }
}
