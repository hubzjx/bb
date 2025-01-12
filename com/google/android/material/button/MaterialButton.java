package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.f;
import androidx.core.widget.v;
import com.google.android.material.internal.j;
import com.google.android.material.internal.l;
import e0.b0;
import h3.h;
import h3.k;
import h3.n;
import java.util.Iterator;
import java.util.LinkedHashSet;
import u2.i;
/* loaded from: classes.dex */
public class MaterialButton extends f implements Checkable, n {

    /* renamed from: q  reason: collision with root package name */
    private static final int[] f4989q = {16842911};

    /* renamed from: r  reason: collision with root package name */
    private static final int[] f4990r = {16842912};

    /* renamed from: s  reason: collision with root package name */
    private static final int f4991s = i.Widget_MaterialComponents_Button;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.material.button.a f4992d;

    /* renamed from: e  reason: collision with root package name */
    private final LinkedHashSet f4993e;

    /* renamed from: f  reason: collision with root package name */
    private b f4994f;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f4995g;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f4996h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f4997i;

    /* renamed from: j  reason: collision with root package name */
    private int f4998j;

    /* renamed from: k  reason: collision with root package name */
    private int f4999k;

    /* renamed from: l  reason: collision with root package name */
    private int f5000l;

    /* renamed from: m  reason: collision with root package name */
    private int f5001m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f5002n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f5003o;

    /* renamed from: p  reason: collision with root package name */
    private int f5004p;

    /* loaded from: classes.dex */
    public interface a {
        void a(MaterialButton materialButton, boolean z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(MaterialButton materialButton, boolean z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends h0.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        boolean f5005c;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public c[] newArray(int i6) {
                return new c[i6];
            }
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            f(parcel);
        }

        private void f(Parcel parcel) {
            this.f5005c = parcel.readInt() == 1;
        }

        @Override // h0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f5005c ? 1 : 0);
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, u2.a.materialButtonStyle);
    }

    private boolean c() {
        int i6 = this.f5004p;
        return i6 == 3 || i6 == 4;
    }

    private boolean d() {
        int i6 = this.f5004p;
        return i6 == 1 || i6 == 2;
    }

    private boolean e() {
        int i6 = this.f5004p;
        return i6 == 16 || i6 == 32;
    }

    private boolean f() {
        return b0.B(this) == 1;
    }

    private boolean g() {
        com.google.android.material.button.a aVar = this.f4992d;
        return (aVar == null || aVar.o()) ? false : true;
    }

    private String getA11yClassName() {
        return (b() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    private void i() {
        if (d()) {
            v.i(this, this.f4997i, null, null, null);
        } else if (c()) {
            v.i(this, null, null, this.f4997i, null);
        } else if (e()) {
            v.i(this, null, this.f4997i, null, null);
        }
    }

    private void j(boolean z5) {
        Drawable drawable = this.f4997i;
        if (drawable != null) {
            Drawable mutate = x.b.r(drawable).mutate();
            this.f4997i = mutate;
            x.b.o(mutate, this.f4996h);
            PorterDuff.Mode mode = this.f4995g;
            if (mode != null) {
                x.b.p(this.f4997i, mode);
            }
            int i6 = this.f4998j;
            if (i6 == 0) {
                i6 = this.f4997i.getIntrinsicWidth();
            }
            int i7 = this.f4998j;
            if (i7 == 0) {
                i7 = this.f4997i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f4997i;
            int i8 = this.f4999k;
            int i9 = this.f5000l;
            drawable2.setBounds(i8, i9, i6 + i8, i7 + i9);
        }
        if (z5) {
            i();
            return;
        }
        Drawable[] a6 = v.a(this);
        boolean z6 = false;
        Drawable drawable3 = a6[0];
        Drawable drawable4 = a6[1];
        Drawable drawable5 = a6[2];
        if ((d() && drawable3 != this.f4997i) || ((c() && drawable5 != this.f4997i) || (e() && drawable4 != this.f4997i))) {
            z6 = true;
        }
        if (z6) {
            i();
        }
    }

    private void k(int i6, int i7) {
        if (this.f4997i == null || getLayout() == null) {
            return;
        }
        if (!d() && !c()) {
            if (e()) {
                this.f4999k = 0;
                if (this.f5004p == 16) {
                    this.f5000l = 0;
                    j(false);
                    return;
                }
                int i8 = this.f4998j;
                if (i8 == 0) {
                    i8 = this.f4997i.getIntrinsicHeight();
                }
                int textHeight = (((((i7 - getTextHeight()) - getPaddingTop()) - i8) - this.f5001m) - getPaddingBottom()) / 2;
                if (this.f5000l != textHeight) {
                    this.f5000l = textHeight;
                    j(false);
                }
                return;
            }
            return;
        }
        this.f5000l = 0;
        int i9 = this.f5004p;
        if (i9 == 1 || i9 == 3) {
            this.f4999k = 0;
            j(false);
            return;
        }
        int i10 = this.f4998j;
        if (i10 == 0) {
            i10 = this.f4997i.getIntrinsicWidth();
        }
        int textWidth = (((((i6 - getTextWidth()) - b0.F(this)) - i10) - this.f5001m) - b0.G(this)) / 2;
        if (f() != (this.f5004p == 4)) {
            textWidth = -textWidth;
        }
        if (this.f4999k != textWidth) {
            this.f4999k = textWidth;
            j(false);
        }
    }

    public void a(a aVar) {
        this.f4993e.add(aVar);
    }

    public boolean b() {
        com.google.android.material.button.a aVar = this.f4992d;
        return aVar != null && aVar.p();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (g()) {
            return this.f4992d.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f4997i;
    }

    public int getIconGravity() {
        return this.f5004p;
    }

    public int getIconPadding() {
        return this.f5001m;
    }

    public int getIconSize() {
        return this.f4998j;
    }

    public ColorStateList getIconTint() {
        return this.f4996h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f4995g;
    }

    public int getInsetBottom() {
        return this.f4992d.c();
    }

    public int getInsetTop() {
        return this.f4992d.d();
    }

    public ColorStateList getRippleColor() {
        if (g()) {
            return this.f4992d.h();
        }
        return null;
    }

    public k getShapeAppearanceModel() {
        if (g()) {
            return this.f4992d.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (g()) {
            return this.f4992d.j();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (g()) {
            return this.f4992d.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.f
    public ColorStateList getSupportBackgroundTintList() {
        return g() ? this.f4992d.l() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.f
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return g() ? this.f4992d.m() : super.getSupportBackgroundTintMode();
    }

    public void h(a aVar) {
        this.f4993e.remove(aVar);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f5002n;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (g()) {
            h.f(this, this.f4992d.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i6) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i6 + 2);
        if (b()) {
            View.mergeDrawableStates(onCreateDrawableState, f4989q);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f4990r);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(b());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        com.google.android.material.button.a aVar;
        super.onLayout(z5, i6, i7, i8, i9);
        if (Build.VERSION.SDK_INT != 21 || (aVar = this.f4992d) == null) {
            return;
        }
        aVar.H(i9 - i7, i8 - i6);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.e());
        setChecked(cVar.f5005c);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f5005c = this.f5002n;
        return cVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        k(i6, i7);
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        super.onTextChanged(charSequence, i6, i7, i8);
        k(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i6) {
        if (g()) {
            this.f4992d.r(i6);
        } else {
            super.setBackgroundColor(i6);
        }
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (g()) {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            } else {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.f4992d.s();
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundResource(int i6) {
        setBackgroundDrawable(i6 != 0 ? e.b.d(getContext(), i6) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z5) {
        if (g()) {
            this.f4992d.t(z5);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z5) {
        if (b() && isEnabled() && this.f5002n != z5) {
            this.f5002n = z5;
            refreshDrawableState();
            if (this.f5003o) {
                return;
            }
            this.f5003o = true;
            Iterator it = this.f4993e.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(this, this.f5002n);
            }
            this.f5003o = false;
        }
    }

    public void setCornerRadius(int i6) {
        if (g()) {
            this.f4992d.u(i6);
        }
    }

    public void setCornerRadiusResource(int i6) {
        if (g()) {
            setCornerRadius(getResources().getDimensionPixelSize(i6));
        }
    }

    @Override // android.view.View
    public void setElevation(float f6) {
        super.setElevation(f6);
        if (g()) {
            this.f4992d.f().T(f6);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f4997i != drawable) {
            this.f4997i = drawable;
            j(true);
            k(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i6) {
        if (this.f5004p != i6) {
            this.f5004p = i6;
            k(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i6) {
        if (this.f5001m != i6) {
            this.f5001m = i6;
            setCompoundDrawablePadding(i6);
        }
    }

    public void setIconResource(int i6) {
        setIcon(i6 != 0 ? e.b.d(getContext(), i6) : null);
    }

    public void setIconSize(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f4998j != i6) {
            this.f4998j = i6;
            j(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f4996h != colorStateList) {
            this.f4996h = colorStateList;
            j(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f4995g != mode) {
            this.f4995g = mode;
            j(false);
        }
    }

    public void setIconTintResource(int i6) {
        setIconTint(e.b.c(getContext(), i6));
    }

    public void setInsetBottom(int i6) {
        this.f4992d.v(i6);
    }

    public void setInsetTop(int i6) {
        this.f4992d.w(i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f4994f = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z5) {
        b bVar = this.f4994f;
        if (bVar != null) {
            bVar.a(this, z5);
        }
        super.setPressed(z5);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (g()) {
            this.f4992d.x(colorStateList);
        }
    }

    public void setRippleColorResource(int i6) {
        if (g()) {
            setRippleColor(e.b.c(getContext(), i6));
        }
    }

    @Override // h3.n
    public void setShapeAppearanceModel(k kVar) {
        if (!g()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f4992d.y(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z5) {
        if (g()) {
            this.f4992d.z(z5);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (g()) {
            this.f4992d.A(colorStateList);
        }
    }

    public void setStrokeColorResource(int i6) {
        if (g()) {
            setStrokeColor(e.b.c(getContext(), i6));
        }
    }

    public void setStrokeWidth(int i6) {
        if (g()) {
            this.f4992d.B(i6);
        }
    }

    public void setStrokeWidthResource(int i6) {
        if (g()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i6));
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (g()) {
            this.f4992d.C(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (g()) {
            this.f4992d.D(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f5002n);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialButton(Context context, AttributeSet attributeSet, int i6) {
        super(i3.a.c(context, attributeSet, i6, r6), attributeSet, i6);
        int i7 = f4991s;
        this.f4993e = new LinkedHashSet();
        this.f5002n = false;
        this.f5003o = false;
        Context context2 = getContext();
        TypedArray h6 = j.h(context2, attributeSet, u2.j.Q1, i6, i7, new int[0]);
        this.f5001m = h6.getDimensionPixelSize(u2.j.f13461d2, 0);
        this.f4995g = l.e(h6.getInt(u2.j.f13482g2, -1), PorterDuff.Mode.SRC_IN);
        this.f4996h = e3.c.a(getContext(), h6, u2.j.f13475f2);
        this.f4997i = e3.c.d(getContext(), h6, u2.j.f13447b2);
        this.f5004p = h6.getInteger(u2.j.f13454c2, 1);
        this.f4998j = h6.getDimensionPixelSize(u2.j.f13468e2, 0);
        com.google.android.material.button.a aVar = new com.google.android.material.button.a(this, k.e(context2, attributeSet, i6, i7).m());
        this.f4992d = aVar;
        aVar.q(h6);
        h6.recycle();
        setCompoundDrawablePadding(this.f5001m);
        j(this.f4997i != null);
    }
}
