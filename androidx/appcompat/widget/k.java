package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
/* loaded from: classes.dex */
public class k extends EditText {

    /* renamed from: b  reason: collision with root package name */
    private final e f987b;

    /* renamed from: c  reason: collision with root package name */
    private final m0 f988c;

    /* renamed from: d  reason: collision with root package name */
    private final e0 f989d;

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.f2711x);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f987b;
        if (eVar != null) {
            eVar.b();
        }
        m0 m0Var = this.f988c;
        if (m0Var != null) {
            m0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f987b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f987b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        e0 e0Var;
        return (Build.VERSION.SDK_INT >= 28 || (e0Var = this.f989d) == null) ? super.getTextClassifier() : e0Var.a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f987b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        e eVar = this.f987b;
        if (eVar != null) {
            eVar.g(i6);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.v.p(this, callback));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f987b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f987b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i6) {
        super.setTextAppearance(context, i6);
        m0 m0Var = this.f988c;
        if (m0Var != null) {
            m0Var.q(context, i6);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        e0 e0Var;
        if (Build.VERSION.SDK_INT >= 28 || (e0Var = this.f989d) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            e0Var.b(textClassifier);
        }
    }

    public k(Context context, AttributeSet attributeSet, int i6) {
        super(z1.b(context), attributeSet, i6);
        y1.a(this, getContext());
        e eVar = new e(this);
        this.f987b = eVar;
        eVar.e(attributeSet, i6);
        m0 m0Var = new m0(this);
        this.f988c = m0Var;
        m0Var.m(attributeSet, i6);
        m0Var.b();
        this.f989d = new e0(this);
    }
}
