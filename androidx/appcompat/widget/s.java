package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
/* loaded from: classes.dex */
public class s extends RadioButton {

    /* renamed from: b  reason: collision with root package name */
    private final i f1059b;

    /* renamed from: c  reason: collision with root package name */
    private final e f1060c;

    /* renamed from: d  reason: collision with root package name */
    private final m0 f1061d;

    public s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.C);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1060c;
        if (eVar != null) {
            eVar.b();
        }
        m0 m0Var = this.f1061d;
        if (m0Var != null) {
            m0Var.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        i iVar = this.f1059b;
        return iVar != null ? iVar.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1060c;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1060c;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        i iVar = this.f1059b;
        if (iVar != null) {
            return iVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        i iVar = this.f1059b;
        if (iVar != null) {
            return iVar.d();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1060c;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        e eVar = this.f1060c;
        if (eVar != null) {
            eVar.g(i6);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i6) {
        setButtonDrawable(e.b.d(getContext(), i6));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1060c;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1060c;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        i iVar = this.f1059b;
        if (iVar != null) {
            iVar.g(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        i iVar = this.f1059b;
        if (iVar != null) {
            iVar.h(mode);
        }
    }

    public s(Context context, AttributeSet attributeSet, int i6) {
        super(z1.b(context), attributeSet, i6);
        y1.a(this, getContext());
        i iVar = new i(this);
        this.f1059b = iVar;
        iVar.e(attributeSet, i6);
        e eVar = new e(this);
        this.f1060c = eVar;
        eVar.e(attributeSet, i6);
        m0 m0Var = new m0(this);
        this.f1061d = m0Var;
        m0Var.m(attributeSet, i6);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        i iVar = this.f1059b;
        if (iVar != null) {
            iVar.f();
        }
    }
}
