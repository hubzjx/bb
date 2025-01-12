package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import c0.n;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class n0 extends TextView implements androidx.core.widget.w, androidx.core.widget.b {

    /* renamed from: b  reason: collision with root package name */
    private final e f1013b;

    /* renamed from: c  reason: collision with root package name */
    private final m0 f1014c;

    /* renamed from: d  reason: collision with root package name */
    private final e0 f1015d;

    /* renamed from: e  reason: collision with root package name */
    private Future f1016e;

    public n0(Context context) {
        this(context, null);
    }

    private void c() {
        Future future = this.f1016e;
        if (future != null) {
            try {
                this.f1016e = null;
                android.support.v4.media.a.a(future.get());
                androidx.core.widget.v.m(this, null);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1013b;
        if (eVar != null) {
            eVar.b();
        }
        m0 m0Var = this.f1014c;
        if (m0Var != null) {
            m0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.b.f1665a) {
            return super.getAutoSizeMaxTextSize();
        }
        m0 m0Var = this.f1014c;
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
        m0 m0Var = this.f1014c;
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
        m0 m0Var = this.f1014c;
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
        m0 m0Var = this.f1014c;
        return m0Var != null ? m0Var.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (androidx.core.widget.b.f1665a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        m0 m0Var = this.f1014c;
        if (m0Var != null) {
            return m0Var.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.v.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.v.c(this);
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1013b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1013b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1014c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1014c.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        c();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        e0 e0Var;
        return (Build.VERSION.SDK_INT >= 28 || (e0Var = this.f1015d) == null) ? super.getTextClassifier() : e0Var.a();
    }

    public n.a getTextMetricsParamsCompat() {
        return androidx.core.widget.v.f(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        m0 m0Var = this.f1014c;
        if (m0Var != null) {
            m0Var.o(z5, i6, i7, i8, i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i6, int i7) {
        c();
        super.onMeasure(i6, i7);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        super.onTextChanged(charSequence, i6, i7, i8);
        m0 m0Var = this.f1014c;
        if (m0Var == null || androidx.core.widget.b.f1665a || !m0Var.l()) {
            return;
        }
        this.f1014c.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i6, int i7, int i8, int i9) {
        if (androidx.core.widget.b.f1665a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i6, i7, i8, i9);
            return;
        }
        m0 m0Var = this.f1014c;
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
        m0 m0Var = this.f1014c;
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
        m0 m0Var = this.f1014c;
        if (m0Var != null) {
            m0Var.u(i6);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1013b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        e eVar = this.f1013b;
        if (eVar != null) {
            eVar.g(i6);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        m0 m0Var = this.f1014c;
        if (m0Var != null) {
            m0Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        m0 m0Var = this.f1014c;
        if (m0Var != null) {
            m0Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i6, int i7, int i8, int i9) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i6 != 0 ? e.b.d(context, i6) : null, i7 != 0 ? e.b.d(context, i7) : null, i8 != 0 ? e.b.d(context, i8) : null, i9 != 0 ? e.b.d(context, i9) : null);
        m0 m0Var = this.f1014c;
        if (m0Var != null) {
            m0Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i6, int i7, int i8, int i9) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i6 != 0 ? e.b.d(context, i6) : null, i7 != 0 ? e.b.d(context, i7) : null, i8 != 0 ? e.b.d(context, i8) : null, i9 != 0 ? e.b.d(context, i9) : null);
        m0 m0Var = this.f1014c;
        if (m0Var != null) {
            m0Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.v.p(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i6) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i6);
        } else {
            androidx.core.widget.v.j(this, i6);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i6) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i6);
        } else {
            androidx.core.widget.v.k(this, i6);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i6) {
        androidx.core.widget.v.l(this, i6);
    }

    public void setPrecomputedText(c0.n nVar) {
        androidx.core.widget.v.m(this, nVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1013b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1013b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.w
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1014c.v(colorStateList);
        this.f1014c.b();
    }

    @Override // androidx.core.widget.w
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1014c.w(mode);
        this.f1014c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i6) {
        super.setTextAppearance(context, i6);
        m0 m0Var = this.f1014c;
        if (m0Var != null) {
            m0Var.q(context, i6);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        e0 e0Var;
        if (Build.VERSION.SDK_INT >= 28 || (e0Var = this.f1015d) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            e0Var.b(textClassifier);
        }
    }

    public void setTextFuture(Future<c0.n> future) {
        this.f1016e = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(n.a aVar) {
        androidx.core.widget.v.o(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i6, float f6) {
        if (androidx.core.widget.b.f1665a) {
            super.setTextSize(i6, f6);
            return;
        }
        m0 m0Var = this.f1014c;
        if (m0Var != null) {
            m0Var.z(i6, f6);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i6) {
        Typeface a6 = (typeface == null || i6 <= 0) ? null : w.i.a(getContext(), typeface, i6);
        if (a6 != null) {
            typeface = a6;
        }
        super.setTypeface(typeface, i6);
    }

    public n0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        m0 m0Var = this.f1014c;
        if (m0Var != null) {
            m0Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        m0 m0Var = this.f1014c;
        if (m0Var != null) {
            m0Var.p();
        }
    }

    public n0(Context context, AttributeSet attributeSet, int i6) {
        super(z1.b(context), attributeSet, i6);
        y1.a(this, getContext());
        e eVar = new e(this);
        this.f1013b = eVar;
        eVar.e(attributeSet, i6);
        m0 m0Var = new m0(this);
        this.f1014c = m0Var;
        m0Var.m(attributeSet, i6);
        m0Var.b();
        this.f1015d = new e0(this);
    }
}
