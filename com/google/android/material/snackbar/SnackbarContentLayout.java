package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import e0.b0;
import u2.j;
/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private TextView f5318b;

    /* renamed from: c  reason: collision with root package name */
    private Button f5319c;

    /* renamed from: d  reason: collision with root package name */
    private int f5320d;

    /* renamed from: e  reason: collision with root package name */
    private int f5321e;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.V3);
        this.f5320d = obtainStyledAttributes.getDimensionPixelSize(j.W3, -1);
        this.f5321e = obtainStyledAttributes.getDimensionPixelSize(j.f13463d4, -1);
        obtainStyledAttributes.recycle();
    }

    private static void a(View view, int i6, int i7) {
        if (b0.T(view)) {
            b0.x0(view, b0.G(view), i6, b0.F(view), i7);
        } else {
            view.setPadding(view.getPaddingLeft(), i6, view.getPaddingRight(), i7);
        }
    }

    private boolean b(int i6, int i7, int i8) {
        boolean z5;
        if (i6 != getOrientation()) {
            setOrientation(i6);
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.f5318b.getPaddingTop() == i7 && this.f5318b.getPaddingBottom() == i8) {
            return z5;
        }
        a(this.f5318b, i7, i8);
        return true;
    }

    public Button getActionView() {
        return this.f5319c;
    }

    public TextView getMessageView() {
        return this.f5318b;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f5318b = (TextView) findViewById(u2.e.snackbar_text);
        this.f5319c = (Button) findViewById(u2.e.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (b(1, r0, r0 - r1) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
        if (b(0, r0, r0) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        r3 = true;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (this.f5320d > 0) {
            int measuredWidth = getMeasuredWidth();
            int i8 = this.f5320d;
            if (measuredWidth > i8) {
                i6 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
                super.onMeasure(i6, i7);
            }
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(u2.c.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(u2.c.design_snackbar_padding_vertical);
        boolean z5 = false;
        boolean z6 = this.f5318b.getLayout().getLineCount() > 1;
        if (!z6 || this.f5321e <= 0 || this.f5319c.getMeasuredWidth() <= this.f5321e) {
            if (!z6) {
                dimensionPixelSize = dimensionPixelSize2;
            }
        }
        if (z5) {
            super.onMeasure(i6, i7);
        }
    }

    public void setMaxInlineActionWidth(int i6) {
        this.f5321e = i6;
    }
}
