package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import e0.b0;
import u2.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class d extends ConstraintLayout {
    private h3.g A;

    /* renamed from: y  reason: collision with root package name */
    private final Runnable f5540y;

    /* renamed from: z  reason: collision with root package name */
    private int f5541z;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.x();
        }
    }

    public d(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        LayoutInflater.from(context).inflate(u2.g.material_radial_view_group, this);
        b0.o0(this, t());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f13597y3, i6, 0);
        this.f5541z = obtainStyledAttributes.getDimensionPixelSize(j.f13603z3, 0);
        this.f5540y = new a();
        obtainStyledAttributes.recycle();
    }

    private Drawable t() {
        h3.g gVar = new h3.g();
        this.A = gVar;
        gVar.S(new h3.i(0.5f));
        this.A.U(ColorStateList.valueOf(-1));
        return this.A;
    }

    private static boolean w(View view) {
        return "skip".equals(view.getTag());
    }

    private void y() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f5540y);
            handler.post(this.f5540y);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i6, layoutParams);
        if (view.getId() == -1) {
            view.setId(b0.k());
        }
        y();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        x();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        y();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i6) {
        this.A.U(ColorStateList.valueOf(i6));
    }

    public int u() {
        return this.f5541z;
    }

    public void v(int i6) {
        this.f5541z = i6;
        x();
    }

    protected void x() {
        int childCount = getChildCount();
        int i6 = 1;
        for (int i7 = 0; i7 < childCount; i7++) {
            if (w(getChildAt(i7))) {
                i6++;
            }
        }
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.g(this);
        float f6 = 0.0f;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            int id = childAt.getId();
            int i9 = u2.e.circle_center;
            if (id != i9 && !w(childAt)) {
                dVar.h(childAt.getId(), i9, this.f5541z, f6);
                f6 += 360.0f / (childCount - i6);
            }
        }
        dVar.c(this);
    }
}
