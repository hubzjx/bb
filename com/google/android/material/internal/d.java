package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.j1;
/* loaded from: classes.dex */
public abstract class d extends j1 {

    /* renamed from: q  reason: collision with root package name */
    private Drawable f5279q;

    /* renamed from: r  reason: collision with root package name */
    private final Rect f5280r;

    /* renamed from: s  reason: collision with root package name */
    private final Rect f5281s;

    /* renamed from: t  reason: collision with root package name */
    private int f5282t;

    /* renamed from: u  reason: collision with root package name */
    protected boolean f5283u;

    /* renamed from: v  reason: collision with root package name */
    boolean f5284v;

    public d(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f5280r = new Rect();
        this.f5281s = new Rect();
        this.f5282t = b.j.I0;
        this.f5283u = true;
        this.f5284v = false;
        TypedArray h6 = j.h(context, attributeSet, u2.j.f13571u1, i6, 0, new int[0]);
        this.f5282t = h6.getInt(u2.j.f13583w1, this.f5282t);
        Drawable drawable = h6.getDrawable(u2.j.f13577v1);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f5283u = h6.getBoolean(u2.j.f13589x1, true);
        h6.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f5279q;
        if (drawable != null) {
            if (this.f5284v) {
                this.f5284v = false;
                Rect rect = this.f5280r;
                Rect rect2 = this.f5281s;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f5283u) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f5282t, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f6, float f7) {
        super.drawableHotspotChanged(f6, f7);
        Drawable drawable = this.f5279q;
        if (drawable != null) {
            drawable.setHotspot(f6, f7);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f5279q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f5279q.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f5279q;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f5282t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f5279q;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.j1, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        this.f5284v = z5 | this.f5284v;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.f5284v = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f5279q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f5279q);
            }
            this.f5279q = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f5282t == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i6) {
        if (this.f5282t != i6) {
            if ((8388615 & i6) == 0) {
                i6 |= 8388611;
            }
            if ((i6 & 112) == 0) {
                i6 |= 48;
            }
            this.f5282t = i6;
            if (i6 == 119 && this.f5279q != null) {
                this.f5279q.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5279q;
    }
}
