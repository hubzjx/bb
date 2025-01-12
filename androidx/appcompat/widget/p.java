package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
/* loaded from: classes.dex */
public class p extends MultiAutoCompleteTextView {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f1051d = {16843126};

    /* renamed from: b  reason: collision with root package name */
    private final e f1052b;

    /* renamed from: c  reason: collision with root package name */
    private final m0 f1053c;

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.f2707m);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1052b;
        if (eVar != null) {
            eVar.b();
        }
        m0 m0Var = this.f1053c;
        if (m0Var != null) {
            m0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1052b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1052b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1052b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        e eVar = this.f1052b;
        if (eVar != null) {
            eVar.g(i6);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i6) {
        setDropDownBackgroundDrawable(e.b.d(getContext(), i6));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1052b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1052b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i6) {
        super.setTextAppearance(context, i6);
        m0 m0Var = this.f1053c;
        if (m0Var != null) {
            m0Var.q(context, i6);
        }
    }

    public p(Context context, AttributeSet attributeSet, int i6) {
        super(z1.b(context), attributeSet, i6);
        y1.a(this, getContext());
        c2 v5 = c2.v(getContext(), attributeSet, f1051d, i6, 0);
        if (v5.s(0)) {
            setDropDownBackgroundDrawable(v5.g(0));
        }
        v5.w();
        e eVar = new e(this);
        this.f1052b = eVar;
        eVar.e(attributeSet, i6);
        m0 m0Var = new m0(this);
        this.f1053c = m0Var;
        m0Var.m(attributeSet, i6);
        m0Var.b();
    }
}
