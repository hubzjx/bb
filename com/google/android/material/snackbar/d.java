package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.internal.l;
import e0.b0;
import u2.j;
/* loaded from: classes.dex */
public abstract class d extends FrameLayout {

    /* renamed from: g  reason: collision with root package name */
    private static final View.OnTouchListener f5322g = new a();

    /* renamed from: b  reason: collision with root package name */
    private int f5323b;

    /* renamed from: c  reason: collision with root package name */
    private final float f5324c;

    /* renamed from: d  reason: collision with root package name */
    private final float f5325d;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f5326e;

    /* renamed from: f  reason: collision with root package name */
    private PorterDuff.Mode f5327f;

    /* loaded from: classes.dex */
    static class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, AttributeSet attributeSet) {
        super(i3.a.c(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, j.V3);
        int i6 = j.f13456c4;
        if (obtainStyledAttributes.hasValue(i6)) {
            b0.s0(this, obtainStyledAttributes.getDimensionPixelSize(i6, 0));
        }
        this.f5323b = obtainStyledAttributes.getInt(j.Y3, 0);
        this.f5324c = obtainStyledAttributes.getFloat(j.Z3, 1.0f);
        setBackgroundTintList(e3.c.a(context2, obtainStyledAttributes, j.f13442a4));
        setBackgroundTintMode(l.e(obtainStyledAttributes.getInt(j.f13449b4, -1), PorterDuff.Mode.SRC_IN));
        this.f5325d = obtainStyledAttributes.getFloat(j.X3, 1.0f);
        obtainStyledAttributes.recycle();
        setOnTouchListener(f5322g);
        setFocusable(true);
        if (getBackground() == null) {
            b0.o0(this, a());
        }
    }

    private Drawable a() {
        float dimension = getResources().getDimension(u2.c.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(y2.a.h(this, u2.a.colorSurface, u2.a.colorOnSurface, getBackgroundOverlayColorAlpha()));
        if (this.f5326e != null) {
            Drawable r5 = x.b.r(gradientDrawable);
            x.b.o(r5, this.f5326e);
            return r5;
        }
        return x.b.r(gradientDrawable);
    }

    float getActionTextColorAlpha() {
        return this.f5325d;
    }

    int getAnimationMode() {
        return this.f5323b;
    }

    float getBackgroundOverlayColorAlpha() {
        return this.f5324c;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b0.i0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
    }

    void setAnimationMode(int i6) {
        this.f5323b = i6;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.f5326e != null) {
            drawable = x.b.r(drawable.mutate());
            x.b.o(drawable, this.f5326e);
            x.b.p(drawable, this.f5327f);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f5326e = colorStateList;
        if (getBackground() != null) {
            Drawable r5 = x.b.r(getBackground().mutate());
            x.b.o(r5, colorStateList);
            x.b.p(r5, this.f5327f);
            if (r5 != getBackground()) {
                super.setBackgroundDrawable(r5);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.f5327f = mode;
        if (getBackground() != null) {
            Drawable r5 = x.b.r(getBackground().mutate());
            x.b.p(r5, mode);
            if (r5 != getBackground()) {
                super.setBackgroundDrawable(r5);
            }
        }
    }

    void setOnAttachStateChangeListener(b bVar) {
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f5322g);
        super.setOnClickListener(onClickListener);
    }

    void setOnLayoutChangeListener(c cVar) {
    }
}
