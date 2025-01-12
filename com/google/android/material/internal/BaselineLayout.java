package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class BaselineLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private int f5223b;

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f5223b = -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.f5223b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i8 - i6) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i11 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                int baseline = (this.f5223b == -1 || childAt.getBaseline() == -1) ? paddingTop : (this.f5223b + paddingTop) - childAt.getBaseline();
                childAt.layout(i11, baseline, measuredWidth + i11, measuredHeight + baseline);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i6, i7);
                int baseline = childAt.getBaseline();
                if (baseline != -1) {
                    i11 = Math.max(i11, baseline);
                    i12 = Math.max(i12, childAt.getMeasuredHeight() - baseline);
                }
                i9 = Math.max(i9, childAt.getMeasuredWidth());
                i8 = Math.max(i8, childAt.getMeasuredHeight());
                i10 = View.combineMeasuredStates(i10, childAt.getMeasuredState());
            }
        }
        if (i11 != -1) {
            i8 = Math.max(i8, Math.max(i12, getPaddingBottom()) + i11);
            this.f5223b = i11;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i9, getSuggestedMinimumWidth()), i6, i10), View.resolveSizeAndState(Math.max(i8, getSuggestedMinimumHeight()), i7, i10 << 16));
    }
}
