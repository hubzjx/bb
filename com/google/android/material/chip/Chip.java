package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.g;
import com.google.android.material.chip.b;
import com.google.android.material.internal.j;
import com.google.android.material.internal.l;
import e0.b0;
import e3.d;
import e3.f;
import f0.y;
import h3.k;
import h3.n;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import okhttp3.HttpUrl;
import u2.h;
import u2.i;
/* loaded from: classes.dex */
public class Chip extends g implements b.a, n {

    /* renamed from: u  reason: collision with root package name */
    private static final int f5047u = i.Widget_MaterialComponents_Chip_Action;

    /* renamed from: v  reason: collision with root package name */
    private static final Rect f5048v = new Rect();

    /* renamed from: w  reason: collision with root package name */
    private static final int[] f5049w = {16842913};

    /* renamed from: x  reason: collision with root package name */
    private static final int[] f5050x = {16842911};

    /* renamed from: e  reason: collision with root package name */
    private com.google.android.material.chip.b f5051e;

    /* renamed from: f  reason: collision with root package name */
    private InsetDrawable f5052f;

    /* renamed from: g  reason: collision with root package name */
    private RippleDrawable f5053g;

    /* renamed from: h  reason: collision with root package name */
    private View.OnClickListener f5054h;

    /* renamed from: i  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f5055i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5056j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5057k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5058l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5059m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f5060n;

    /* renamed from: o  reason: collision with root package name */
    private int f5061o;

    /* renamed from: p  reason: collision with root package name */
    private int f5062p;

    /* renamed from: q  reason: collision with root package name */
    private final c f5063q;

    /* renamed from: r  reason: collision with root package name */
    private final Rect f5064r;

    /* renamed from: s  reason: collision with root package name */
    private final RectF f5065s;

    /* renamed from: t  reason: collision with root package name */
    private final f f5066t;

    /* loaded from: classes.dex */
    class a extends f {
        a() {
        }

        @Override // e3.f
        public void a(int i6) {
        }

        @Override // e3.f
        public void b(Typeface typeface, boolean z5) {
            Chip chip = Chip.this;
            chip.setText(chip.f5051e.G2() ? Chip.this.f5051e.c1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (Chip.this.f5051e != null) {
                Chip.this.f5051e.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends i0.a {
        c(Chip chip) {
            super(chip);
        }

        @Override // i0.a
        protected int B(float f6, float f7) {
            return (Chip.this.n() && Chip.this.getCloseIconTouchBounds().contains(f6, f7)) ? 1 : 0;
        }

        @Override // i0.a
        protected void C(List list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.f5054h != null) {
                list.add(1);
            }
        }

        @Override // i0.a
        protected boolean J(int i6, int i7, Bundle bundle) {
            if (i7 == 16) {
                if (i6 == 0) {
                    return Chip.this.performClick();
                }
                if (i6 == 1) {
                    return Chip.this.t();
                }
                return false;
            }
            return false;
        }

        @Override // i0.a
        protected void M(y yVar) {
            yVar.U(Chip.this.r());
            yVar.X(Chip.this.isClickable());
            yVar.W((Chip.this.r() || Chip.this.isClickable()) ? Chip.this.r() ? "android.widget.CompoundButton" : "android.widget.Button" : "android.view.View");
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                yVar.s0(text);
            } else {
                yVar.a0(text);
            }
        }

        @Override // i0.a
        protected void N(int i6, y yVar) {
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (i6 != 1) {
                yVar.a0(HttpUrl.FRAGMENT_ENCODE_SET);
                yVar.S(Chip.f5048v);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription == null) {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i7 = h.mtrl_chip_close_icon_content_description;
                Object[] objArr = new Object[1];
                if (!TextUtils.isEmpty(text)) {
                    str = text;
                }
                objArr[0] = str;
                closeIconContentDescription = context.getString(i7, objArr).trim();
            }
            yVar.a0(closeIconContentDescription);
            yVar.S(Chip.this.getCloseIconTouchBoundsInt());
            yVar.b(y.a.f9740i);
            yVar.c0(Chip.this.isEnabled());
        }

        @Override // i0.a
        protected void O(int i6, boolean z5) {
            if (i6 == 1) {
                Chip.this.f5059m = z5;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, u2.a.chipStyle);
    }

    private void A() {
        com.google.android.material.chip.b bVar;
        if (TextUtils.isEmpty(getText()) || (bVar = this.f5051e) == null) {
            return;
        }
        int E0 = (int) (bVar.E0() + this.f5051e.e1() + this.f5051e.l0());
        int J0 = (int) (this.f5051e.J0() + this.f5051e.f1() + this.f5051e.h0());
        if (this.f5052f != null) {
            Rect rect = new Rect();
            this.f5052f.getPadding(rect);
            J0 += rect.left;
            E0 += rect.right;
        }
        b0.x0(this, J0, getPaddingTop(), E0, getPaddingBottom());
    }

    private void B() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            paint.drawableState = bVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.j(getContext(), paint, this.f5066t);
        }
    }

    private void C(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f5065s.setEmpty();
        if (n() && this.f5054h != null) {
            this.f5051e.T0(this.f5065s);
        }
        return this.f5065s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f5064r.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f5064r;
    }

    private d getTextAppearance() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.d1();
        }
        return null;
    }

    private void i(com.google.android.material.chip.b bVar) {
        bVar.k2(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    private int[] j() {
        ?? isEnabled = isEnabled();
        int i6 = isEnabled;
        if (this.f5059m) {
            i6 = isEnabled + 1;
        }
        int i7 = i6;
        if (this.f5058l) {
            i7 = i6 + 1;
        }
        int i8 = i7;
        if (this.f5057k) {
            i8 = i7 + 1;
        }
        int i9 = i8;
        if (isChecked()) {
            i9 = i8 + 1;
        }
        int[] iArr = new int[i9];
        int i10 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i10 = 1;
        }
        if (this.f5059m) {
            iArr[i10] = 16842908;
            i10++;
        }
        if (this.f5058l) {
            iArr[i10] = 16843623;
            i10++;
        }
        if (this.f5057k) {
            iArr[i10] = 16842919;
            i10++;
        }
        if (isChecked()) {
            iArr[i10] = 16842913;
        }
        return iArr;
    }

    private void l() {
        if (getBackgroundDrawable() == this.f5052f && this.f5051e.getCallback() == null) {
            this.f5051e.setCallback(this.f5052f);
        }
    }

    private boolean m(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = i0.a.class.getDeclaredField("m");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.f5063q)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = i0.a.class.getDeclaredMethod("V", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.f5063q, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e6) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e6);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        com.google.android.material.chip.b bVar = this.f5051e;
        return (bVar == null || bVar.M0() == null) ? false : true;
    }

    private void o(Context context, AttributeSet attributeSet, int i6) {
        TypedArray h6 = j.h(context, attributeSet, u2.j.Q, i6, f5047u, new int[0]);
        this.f5060n = h6.getBoolean(u2.j.f13588x0, false);
        this.f5062p = (int) Math.ceil(h6.getDimension(u2.j.f13515l0, (float) Math.ceil(l.b(getContext(), 48))));
        h6.recycle();
    }

    private void p() {
        setOutlineProvider(new b());
    }

    private void q(int i6, int i7, int i8, int i9) {
        this.f5052f = new InsetDrawable((Drawable) this.f5051e, i6, i7, i8, i9);
    }

    private void setCloseIconHovered(boolean z5) {
        if (this.f5058l != z5) {
            this.f5058l = z5;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z5) {
        if (this.f5057k != z5) {
            this.f5057k = z5;
            refreshDrawableState();
        }
    }

    private void u() {
        if (this.f5052f != null) {
            this.f5052f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            y();
        }
    }

    private void w(com.google.android.material.chip.b bVar) {
        if (bVar != null) {
            bVar.k2(null);
        }
    }

    private void x() {
        b0.l0(this, (n() && s() && this.f5054h != null) ? this.f5063q : null);
    }

    private void y() {
        if (f3.b.f9883a) {
            z();
            return;
        }
        this.f5051e.F2(true);
        b0.o0(this, getBackgroundDrawable());
        A();
        l();
    }

    private void z() {
        this.f5053g = new RippleDrawable(f3.b.a(this.f5051e.a1()), getBackgroundDrawable(), null);
        this.f5051e.F2(false);
        b0.o0(this, this.f5053g);
        A();
    }

    @Override // com.google.android.material.chip.b.a
    public void a() {
        k(this.f5062p);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return m(motionEvent) || this.f5063q.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f5063q.w(keyEvent) || this.f5063q.A() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.g, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.b bVar = this.f5051e;
        if ((bVar == null || !bVar.k1()) ? false : this.f5051e.g2(j())) {
            invalidate();
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f5052f;
        return insetDrawable == null ? this.f5051e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.A0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.B0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.C0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return Math.max(0.0f, bVar.D0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f5051e;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.E0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.F0();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.G0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.H0();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.I0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.J0();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.K0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.L0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.M0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.N0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.O0();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.P0();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.Q0();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.S0();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.W0();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.f5063q.A() == 1 || this.f5063q.x() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public v2.c getHideMotionSpec() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.X0();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.Y0();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.Z0();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.a1();
        }
        return null;
    }

    public k getShapeAppearanceModel() {
        return this.f5051e.B();
    }

    public v2.c getShowMotionSpec() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.b1();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.e1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            return bVar.f1();
        }
        return 0.0f;
    }

    public boolean k(int i6) {
        this.f5062p = i6;
        if (!v()) {
            if (this.f5052f != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int max = Math.max(0, i6 - this.f5051e.getIntrinsicHeight());
        int max2 = Math.max(0, i6 - this.f5051e.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.f5052f != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int i7 = max2 > 0 ? max2 / 2 : 0;
        int i8 = max > 0 ? max / 2 : 0;
        if (this.f5052f != null) {
            Rect rect = new Rect();
            this.f5052f.getPadding(rect);
            if (rect.top == i8 && rect.bottom == i8 && rect.left == i7 && rect.right == i7) {
                y();
                return true;
            }
        }
        if (getMinHeight() != i6) {
            setMinHeight(i6);
        }
        if (getMinWidth() != i6) {
            setMinWidth(i6);
        }
        q(i7, i8, i7, i8);
        y();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h3.h.f(this, this.f5051e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i6) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i6 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f5049w);
        }
        if (r()) {
            View.mergeDrawableStates(onCreateDrawableState, f5050x);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z5, int i6, Rect rect) {
        super.onFocusChanged(z5, i6, rect);
        this.f5063q.I(z5, i6, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        boolean contains;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                contains = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(contains);
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((r() || isClickable()) ? r() ? "android.widget.CompoundButton" : "android.widget.Button" : "android.view.View");
        accessibilityNodeInfo.setCheckable(r());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            y.w0(accessibilityNodeInfo).Z(y.c.a(chipGroup.b(this), 1, chipGroup.c() ? chipGroup.o(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i6) {
        PointerIcon systemIcon;
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            systemIcon = PointerIcon.getSystemIcon(getContext(), 1002);
            return systemIcon;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int i6) {
        super.onRtlPropertiesChanged(i6);
        if (this.f5061o != i6) {
            this.f5061o = i6;
            A();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0 != 3) goto L17;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        int actionMasked = motionEvent.getActionMasked();
        boolean contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f5057k) {
                        if (!contains) {
                            setCloseIconPressed(false);
                        }
                        z5 = true;
                    }
                }
                z5 = false;
            } else if (this.f5057k) {
                t();
                z5 = true;
                setCloseIconPressed(false);
            }
            z5 = false;
            setCloseIconPressed(false);
        } else {
            if (contains) {
                setCloseIconPressed(true);
                z5 = true;
            }
            z5 = false;
        }
        return z5 || super.onTouchEvent(motionEvent);
    }

    public boolean r() {
        com.google.android.material.chip.b bVar = this.f5051e;
        return bVar != null && bVar.j1();
    }

    public boolean s() {
        com.google.android.material.chip.b bVar = this.f5051e;
        return bVar != null && bVar.l1();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f5053g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i6) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.g, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f5053g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.g, android.view.View
    public void setBackgroundResource(int i6) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z5) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.s1(z5);
        }
    }

    public void setCheckableResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.t1(i6);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z5) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar == null) {
            this.f5056j = z5;
        } else if (bVar.j1()) {
            boolean isChecked = isChecked();
            super.setChecked(z5);
            if (isChecked == z5 || (onCheckedChangeListener = this.f5055i) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z5);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.u1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z5) {
        setCheckedIconVisible(z5);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i6) {
        setCheckedIconVisible(i6);
    }

    public void setCheckedIconResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.v1(i6);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.w1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.x1(i6);
        }
    }

    public void setCheckedIconVisible(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.y1(i6);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.A1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.B1(i6);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.C1(f6);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.D1(i6);
        }
    }

    public void setChipDrawable(com.google.android.material.chip.b bVar) {
        com.google.android.material.chip.b bVar2 = this.f5051e;
        if (bVar2 != bVar) {
            w(bVar2);
            this.f5051e = bVar;
            bVar.v2(false);
            i(this.f5051e);
            k(this.f5062p);
        }
    }

    public void setChipEndPadding(float f6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.E1(f6);
        }
    }

    public void setChipEndPaddingResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.F1(i6);
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.G1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z5) {
        setChipIconVisible(z5);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i6) {
        setChipIconVisible(i6);
    }

    public void setChipIconResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.H1(i6);
        }
    }

    public void setChipIconSize(float f6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.I1(f6);
        }
    }

    public void setChipIconSizeResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.J1(i6);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.K1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.L1(i6);
        }
    }

    public void setChipIconVisible(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.M1(i6);
        }
    }

    public void setChipMinHeight(float f6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.O1(f6);
        }
    }

    public void setChipMinHeightResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.P1(i6);
        }
    }

    public void setChipStartPadding(float f6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.Q1(f6);
        }
    }

    public void setChipStartPaddingResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.R1(i6);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.S1(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.T1(i6);
        }
    }

    public void setChipStrokeWidth(float f6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.U1(f6);
        }
    }

    public void setChipStrokeWidthResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.V1(i6);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i6) {
        setText(getResources().getString(i6));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.X1(drawable);
        }
        x();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.Y1(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z5) {
        setCloseIconVisible(z5);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i6) {
        setCloseIconVisible(i6);
    }

    public void setCloseIconEndPadding(float f6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.Z1(f6);
        }
    }

    public void setCloseIconEndPaddingResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.a2(i6);
        }
    }

    public void setCloseIconResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.b2(i6);
        }
        x();
    }

    public void setCloseIconSize(float f6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.c2(f6);
        }
    }

    public void setCloseIconSizeResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.d2(i6);
        }
    }

    public void setCloseIconStartPadding(float f6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.e2(f6);
        }
    }

    public void setCloseIconStartPaddingResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.f2(i6);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.h2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.i2(i6);
        }
    }

    public void setCloseIconVisible(int i6) {
        setCloseIconVisible(getResources().getBoolean(i6));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i6, int i7, int i8, int i9) {
        if (i6 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i8 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i6, i7, i8, i9);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i6, int i7, int i8, int i9) {
        if (i6 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i8 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i6, i7, i8, i9);
    }

    @Override // android.view.View
    public void setElevation(float f6) {
        super.setElevation(f6);
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.T(f6);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f5051e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.l2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z5) {
        this.f5060n = z5;
        k(this.f5062p);
    }

    @Override // android.widget.TextView
    public void setGravity(int i6) {
        if (i6 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i6);
        }
    }

    public void setHideMotionSpec(v2.c cVar) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.m2(cVar);
        }
    }

    public void setHideMotionSpecResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.n2(i6);
        }
    }

    public void setIconEndPadding(float f6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.o2(f6);
        }
    }

    public void setIconEndPaddingResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.p2(i6);
        }
    }

    public void setIconStartPadding(float f6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.q2(f6);
        }
    }

    public void setIconStartPaddingResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.r2(i6);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i6) {
        if (this.f5051e == null) {
            return;
        }
        super.setLayoutDirection(i6);
    }

    @Override // android.widget.TextView
    public void setLines(int i6) {
        if (i6 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i6);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i6) {
        if (i6 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i6);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i6) {
        super.setMaxWidth(i6);
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.s2(i6);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i6) {
        if (i6 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f5055i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f5054h = onClickListener;
        x();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.t2(colorStateList);
        }
        if (this.f5051e.h1()) {
            return;
        }
        z();
    }

    public void setRippleColorResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.u2(i6);
            if (this.f5051e.h1()) {
                return;
            }
            z();
        }
    }

    @Override // h3.n
    public void setShapeAppearanceModel(k kVar) {
        this.f5051e.setShapeAppearanceModel(kVar);
    }

    public void setShowMotionSpec(v2.c cVar) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.w2(cVar);
        }
    }

    public void setShowMotionSpecResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.x2(i6);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z5) {
        if (!z5) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z5);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        super.setText(bVar.G2() ? null : charSequence, bufferType);
        com.google.android.material.chip.b bVar2 = this.f5051e;
        if (bVar2 != null) {
            bVar2.y2(charSequence);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i6) {
        super.setTextAppearance(i6);
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.A2(i6);
        }
        B();
    }

    public void setTextAppearanceResource(int i6) {
        setTextAppearance(getContext(), i6);
    }

    public void setTextEndPadding(float f6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.B2(f6);
        }
    }

    public void setTextEndPaddingResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.C2(i6);
        }
    }

    public void setTextStartPadding(float f6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.D2(f6);
        }
    }

    public void setTextStartPaddingResource(int i6) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.E2(i6);
        }
    }

    public boolean t() {
        boolean z5 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f5054h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z5 = true;
        }
        this.f5063q.U(1, 1);
        return z5;
    }

    public boolean v() {
        return this.f5060n;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Chip(Context context, AttributeSet attributeSet, int i6) {
        super(i3.a.c(context, attributeSet, i6, r4), attributeSet, i6);
        int i7 = f5047u;
        this.f5064r = new Rect();
        this.f5065s = new RectF();
        this.f5066t = new a();
        Context context2 = getContext();
        C(attributeSet);
        com.google.android.material.chip.b q02 = com.google.android.material.chip.b.q0(context2, attributeSet, i6, i7);
        o(context2, attributeSet, i6);
        setChipDrawable(q02);
        q02.T(b0.w(this));
        TypedArray h6 = j.h(context2, attributeSet, u2.j.Q, i6, i7, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(e3.c.a(context2, h6, u2.j.T));
        }
        boolean hasValue = h6.hasValue(u2.j.C0);
        h6.recycle();
        this.f5063q = new c(this);
        x();
        if (!hasValue) {
            p();
        }
        setChecked(this.f5056j);
        setText(q02.c1());
        setEllipsize(q02.W0());
        B();
        if (!this.f5051e.G2()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        A();
        if (v()) {
            setMinHeight(this.f5062p);
        }
        this.f5061o = b0.B(this);
    }

    public void setCheckedIconVisible(boolean z5) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.z1(z5);
        }
    }

    public void setChipIconVisible(boolean z5) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.N1(z5);
        }
    }

    public void setCloseIconVisible(boolean z5) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.j2(z5);
        }
        x();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i6) {
        super.setTextAppearance(context, i6);
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.A2(i6);
        }
        B();
    }

    public void setTextAppearance(d dVar) {
        com.google.android.material.chip.b bVar = this.f5051e;
        if (bVar != null) {
            bVar.z2(dVar);
        }
        B();
    }
}
