package com.google.android.material.internal;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
/* loaded from: classes.dex */
public abstract class k {
    public static TextView a(Toolbar toolbar) {
        return b(toolbar, toolbar.getSubtitle());
    }

    private static TextView b(Toolbar toolbar, CharSequence charSequence) {
        for (int i6 = 0; i6 < toolbar.getChildCount(); i6++) {
            View childAt = toolbar.getChildAt(i6);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    return textView;
                }
            }
        }
        return null;
    }

    public static TextView c(Toolbar toolbar) {
        return b(toolbar, toolbar.getTitle());
    }
}
