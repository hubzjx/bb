package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
/* loaded from: classes.dex */
public class f extends Button implements androidx.core.widget.b, androidx.core.widget.w {

    /* renamed from: b  reason: collision with root package name */
    private final e f894b;

    /* renamed from: c  reason: collision with root package name */
    private final m0 f895c;

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.buttonStyle);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f894b;
        if (eVar != null) {
            eVar.b();
        }
        m0 m0Var = this.f895c;
        if (m0Var != null) {
            m0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.b.f1665a) {
            return super.getAutoSizeMaxTextSize();
        }
        m0 m0Var = this.f895c;
        if (m0Var != null) {
            return m0Var.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (androidx.core.widget.b.f1665a) {
            return super.getAutoSizeMinTextSize();
        }
        m0 m0Var = this.f895c;
        if (m0Var != null) {
            return m0Var.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (androidx.core.widget.b.f1665a) {
            return super.getAutoSizeStepGranularity();
        }
        m0 m0Var = this.f895c;
        if (m0Var != null) {
            return m0Var.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (androidx.core.widget.b.f1665a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        m0 m0Var = this.f895c;
        return m0Var != null ? m0Var.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (androidx.core.widget.b.f1665a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        m0 m0Var = this.f895c;
        if (m0Var != null) {
            return m0Var.i();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f894b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f894b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f895c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f895c.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        m0 m0Var = this.f895c;
        if (m0Var != null) {
            m0Var.o(z5, i6, i7, i8, i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        super.onTextChanged(charSequence, i6, i7, i8);
        m0 m0Var = this.f895c;
        if (m0Var == null || androidx.core.widget.b.f1665a || !m0Var.l()) {
            return;
        }
        this.f895c.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i6, int i7, int i8, int i9) {
        if (androidx.core.widget.b.f1665a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i6, i7, i8, i9);
            return;
        }
        m0 m0Var = this.f895c;
        if (m0Var != null) {
            m0Var.s(i6, i7, i8, i9);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i6) {
        if (androidx.core.widget.b.f1665a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i6);
            return;
        }
        m0 m0Var = this.f895c;
        if (m0Var != null) {
            m0Var.t(iArr, i6);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i6) {
        if (androidx.core.widget.b.f1665a) {
            super.setAutoSizeTextTypeWithDefaults(i6);
            return;
        }
        m0 m0Var = this.f895c;
        if (m0Var != null) {
            m0Var.u(i6);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f894b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        e eVar = this.f894b;
        if (eVar != null) {
            eVar.g(i6);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.v.p(this, callback));
    }

    public void setSupportAllCaps(boolean z5) {
        m0 m0Var = this.f895c;
        if (m0Var != null) {
            m0Var.r(z5);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f894b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f894b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.w
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f895c.v(colorStateList);
        this.f895c.b();
    }

    @Override // androidx.core.widget.w
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f895c.w(mode);
        this.f895c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i6) {
        super.setTextAppearance(context, i6);
        m0 m0Var = this.f895c;
        if (m0Var != null) {
            m0Var.q(context, i6);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i6, float f6) {
        if (androidx.core.widget.b.f1665a) {
            super.setTextSize(i6, f6);
            return;
        }
        m0 m0Var = this.f895c;
        if (m0Var != null) {
            m0Var.z(i6, f6);
        }
    }

    public f(Context context, AttributeSet attributeSet, int i6) {
        super(z1.b(context), attributeSet, i6);
        y1.a(this, getContext());
        e eVar = new e(this);
        this.f894b = eVar;
        eVar.e(attributeSet, i6);
        m0 m0Var = new m0(this);
        this.f895c = m0Var;
        m0Var.m(attributeSet, i6);
        m0Var.b();
    }
}
