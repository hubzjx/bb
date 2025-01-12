package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c3.a;
import e0.b0;
import java.util.List;
@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.b {

    /* renamed from: a  reason: collision with root package name */
    private int f5576a;

    public ExpandableBehavior() {
        this.f5576a = 0;
    }

    protected a E(CoordinatorLayout coordinatorLayout, View view) {
        List q5 = coordinatorLayout.q(view);
        int size = q5.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = (View) q5.get(i6);
            if (e(coordinatorLayout, view, view2)) {
                android.support.v4.media.a.a(view2);
                return null;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public abstract boolean e(CoordinatorLayout coordinatorLayout, View view, View view2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        android.support.v4.media.a.a(view2);
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i6) {
        if (b0.R(view)) {
            return false;
        }
        E(coordinatorLayout, view);
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5576a = 0;
    }
}
