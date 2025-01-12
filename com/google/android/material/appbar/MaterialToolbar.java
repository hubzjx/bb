package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.internal.j;
import com.google.android.material.internal.k;
import e0.b0;
import h3.g;
import h3.h;
import u2.i;
/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    private static final int S = i.Widget_MaterialComponents_Toolbar;
    private Integer P;
    private boolean Q;
    private boolean R;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, u2.a.D);
    }

    private Pair O(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i6 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i6 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i6 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void P(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            g gVar = new g();
            gVar.U(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            gVar.K(context);
            gVar.T(b0.w(this));
            b0.o0(this, gVar);
        }
    }

    private void Q(View view, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i6 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i7 = measuredWidth2 + i6;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i6, 0), Math.max(i7 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i6 += max;
            i7 -= max;
            view.measure(View.MeasureSpec.makeMeasureSpec(i7 - i6, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i6, view.getTop(), i7, view.getBottom());
    }

    private void R() {
        if (this.Q || this.R) {
            TextView c6 = k.c(this);
            TextView a6 = k.a(this);
            if (c6 == null && a6 == null) {
                return;
            }
            Pair O = O(c6, a6);
            if (this.Q && c6 != null) {
                Q(c6, O);
            }
            if (!this.R || a6 == null) {
                return;
            }
            Q(a6, O);
        }
    }

    private Drawable S(Drawable drawable) {
        if (drawable == null || this.P == null) {
            return drawable;
        }
        Drawable r5 = x.b.r(drawable);
        x.b.n(r5, this.P.intValue());
        return r5;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        R();
    }

    @Override // android.view.View
    public void setElevation(float f6) {
        super.setElevation(f6);
        h.d(this, f6);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(S(drawable));
    }

    public void setNavigationIconTint(int i6) {
        this.P = Integer.valueOf(i6);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z5) {
        if (this.R != z5) {
            this.R = z5;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z5) {
        if (this.Q != z5) {
            this.Q = z5;
            requestLayout();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i6) {
        super(i3.a.c(context, attributeSet, i6, r4), attributeSet, i6);
        int i7 = S;
        Context context2 = getContext();
        TypedArray h6 = j.h(context2, attributeSet, u2.j.f13462d3, i6, i7, new int[0]);
        int i8 = u2.j.f13469e3;
        if (h6.hasValue(i8)) {
            setNavigationIconTint(h6.getColor(i8, -1));
        }
        this.Q = h6.getBoolean(u2.j.f13483g3, false);
        this.R = h6.getBoolean(u2.j.f13476f3, false);
        h6.recycle();
        P(context2);
    }
}
