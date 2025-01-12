package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import e0.b0;
/* loaded from: classes.dex */
public abstract class c extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private int f5275b;

    /* renamed from: c  reason: collision with root package name */
    private int f5276c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5277d;

    /* renamed from: e  reason: collision with root package name */
    private int f5278e;

    public c(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f5277d = false;
        d(context, attributeSet);
    }

    private static int a(int i6, int i7, int i8) {
        return i7 != Integer.MIN_VALUE ? i7 != 1073741824 ? i8 : i6 : Math.min(i8, i6);
    }

    private void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, u2.j.f13541p1, 0, 0);
        this.f5275b = obtainStyledAttributes.getDimensionPixelSize(u2.j.f13553r1, 0);
        this.f5276c = obtainStyledAttributes.getDimensionPixelSize(u2.j.f13547q1, 0);
        obtainStyledAttributes.recycle();
    }

    public int b(View view) {
        Object tag = view.getTag(u2.e.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean c() {
        return this.f5277d;
    }

    protected int getItemSpacing() {
        return this.f5276c;
    }

    protected int getLineSpacing() {
        return this.f5275b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRowCount() {
        return this.f5278e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        if (getChildCount() == 0) {
            this.f5278e = 0;
            return;
        }
        this.f5278e = 1;
        boolean z6 = b0.B(this) == 1;
        int paddingRight = z6 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z6 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i12 = (i8 - i6) - paddingLeft;
        int i13 = paddingRight;
        int i14 = paddingTop;
        for (int i15 = 0; i15 < getChildCount(); i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(u2.e.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i11 = e0.g.b(marginLayoutParams);
                    i10 = e0.g.a(marginLayoutParams);
                } else {
                    i10 = 0;
                    i11 = 0;
                }
                int measuredWidth = i13 + i11 + childAt.getMeasuredWidth();
                if (!this.f5277d && measuredWidth > i12) {
                    i14 = this.f5275b + paddingTop;
                    this.f5278e++;
                    i13 = paddingRight;
                }
                childAt.setTag(u2.e.row_index_key, Integer.valueOf(this.f5278e - 1));
                int i16 = i13 + i11;
                int measuredWidth2 = childAt.getMeasuredWidth() + i16;
                int measuredHeight = childAt.getMeasuredHeight() + i14;
                if (z6) {
                    i16 = i12 - measuredWidth2;
                    measuredWidth2 = (i12 - i13) - i11;
                }
                childAt.layout(i16, i14, measuredWidth2, measuredHeight);
                i13 += i11 + i10 + childAt.getMeasuredWidth() + this.f5276c;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int size = View.MeasureSpec.getSize(i6);
        int mode = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i7);
        int i11 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i11 - getPaddingRight();
        int i12 = paddingTop;
        int i13 = 0;
        for (int i14 = 0; i14 < getChildCount(); i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i6, i7);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i8 = marginLayoutParams.leftMargin + 0;
                    i9 = marginLayoutParams.rightMargin + 0;
                } else {
                    i8 = 0;
                    i9 = 0;
                }
                int i15 = paddingLeft;
                if (paddingLeft + i8 + childAt.getMeasuredWidth() <= paddingRight || c()) {
                    i10 = i15;
                } else {
                    i10 = getPaddingLeft();
                    i12 = this.f5275b + paddingTop;
                }
                int measuredWidth = i10 + i8 + childAt.getMeasuredWidth();
                int measuredHeight = i12 + childAt.getMeasuredHeight();
                if (measuredWidth > i13) {
                    i13 = measuredWidth;
                }
                paddingLeft = i10 + i8 + i9 + childAt.getMeasuredWidth() + this.f5276c;
                if (i14 == getChildCount() - 1) {
                    i13 += i9;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i13 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setItemSpacing(int i6) {
        this.f5276c = i6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLineSpacing(int i6) {
        this.f5275b = i6;
    }

    public void setSingleLine(boolean z5) {
        this.f5277d = z5;
    }
}
