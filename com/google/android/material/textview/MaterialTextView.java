package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.n0;
import e3.b;
import e3.c;
import u2.a;
import u2.j;
/* loaded from: classes.dex */
public class MaterialTextView extends n0 {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    private void f(Resources.Theme theme, int i6) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i6, j.S2);
        int i7 = i(getContext(), obtainStyledAttributes, j.U2, j.V2);
        obtainStyledAttributes.recycle();
        if (i7 >= 0) {
            setLineHeight(i7);
        }
    }

    private static boolean g(Context context) {
        return b.b(context, a.textAppearanceLineHeightEnabled, true);
    }

    private static int h(Resources.Theme theme, AttributeSet attributeSet, int i6, int i7) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, j.W2, i6, i7);
        int resourceId = obtainStyledAttributes.getResourceId(j.X2, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int i(Context context, TypedArray typedArray, int... iArr) {
        int i6 = -1;
        for (int i7 = 0; i7 < iArr.length && i6 < 0; i7++) {
            i6 = c.c(context, typedArray, iArr[i7], -1);
        }
        return i6;
    }

    private static boolean j(Context context, Resources.Theme theme, AttributeSet attributeSet, int i6, int i7) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, j.W2, i6, i7);
        int i8 = i(context, obtainStyledAttributes, j.Y2, j.Z2);
        obtainStyledAttributes.recycle();
        return i8 != -1;
    }

    @Override // androidx.appcompat.widget.n0, android.widget.TextView
    public void setTextAppearance(Context context, int i6) {
        super.setTextAppearance(context, i6);
        if (g(context)) {
            f(context.getTheme(), i6);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i6) {
        this(context, attributeSet, i6, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(i3.a.c(context, attributeSet, i6, i7), attributeSet, i6);
        int h6;
        Context context2 = getContext();
        if (g(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (j(context2, theme, attributeSet, i6, i7) || (h6 = h(theme, attributeSet, i6, i7)) == -1) {
                return;
            }
            f(theme, h6);
        }
    }
}
