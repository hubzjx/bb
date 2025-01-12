package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private boolean f715b;

    /* renamed from: c  reason: collision with root package name */
    private int f716c;

    /* renamed from: d  reason: collision with root package name */
    private int f717d;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f716c = -1;
        this.f717d = 0;
        int[] iArr = b.j.O0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        e0.b0.j0(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.f715b = obtainStyledAttributes.getBoolean(b.j.P0, true);
        obtainStyledAttributes.recycle();
    }

    private int a(int i6) {
        int childCount = getChildCount();
        while (i6 < childCount) {
            if (getChildAt(i6).getVisibility() == 0) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    private boolean b() {
        return getOrientation() == 1;
    }

    private void setStacked(boolean z5) {
        setOrientation(z5 ? 1 : 0);
        setGravity(z5 ? 5 : 80);
        View findViewById = findViewById(b.f.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z5 ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(this.f717d, super.getMinimumHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        int i8;
        boolean z5;
        int size = View.MeasureSpec.getSize(i6);
        int i9 = 0;
        if (this.f715b) {
            if (size > this.f716c && b()) {
                setStacked(false);
            }
            this.f716c = size;
        }
        if (b() || View.MeasureSpec.getMode(i6) != 1073741824) {
            i8 = i6;
            z5 = false;
        } else {
            i8 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z5 = true;
        }
        super.onMeasure(i8, i7);
        if (this.f715b && !b()) {
            if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                setStacked(true);
                z5 = true;
            }
        }
        if (z5) {
            super.onMeasure(i6, i7);
        }
        int a6 = a(0);
        if (a6 >= 0) {
            View childAt = getChildAt(a6);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (b()) {
                int a7 = a(a6 + 1);
                if (a7 >= 0) {
                    paddingTop += getChildAt(a7).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i9 = paddingTop;
            } else {
                i9 = paddingTop + getPaddingBottom();
            }
        }
        if (e0.b0.C(this) != i9) {
            setMinimumHeight(i9);
        }
    }

    public void setAllowStacking(boolean z5) {
        if (this.f715b != z5) {
            this.f715b = z5;
            if (!z5 && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
