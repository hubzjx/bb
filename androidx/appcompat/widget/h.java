package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
/* loaded from: classes.dex */
public class h extends CheckedTextView {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f932c = {16843016};

    /* renamed from: b  reason: collision with root package name */
    private final m0 f933b;

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m0 m0Var = this.f933b;
        if (m0Var != null) {
            m0Var.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i6) {
        setCheckMarkDrawable(e.b.d(getContext(), i6));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.v.p(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i6) {
        super.setTextAppearance(context, i6);
        m0 m0Var = this.f933b;
        if (m0Var != null) {
            m0Var.q(context, i6);
        }
    }

    public h(Context context, AttributeSet attributeSet, int i6) {
        super(z1.b(context), attributeSet, i6);
        y1.a(this, getContext());
        m0 m0Var = new m0(this);
        this.f933b = m0Var;
        m0Var.m(attributeSet, i6);
        m0Var.b();
        c2 v5 = c2.v(getContext(), attributeSet, f932c, i6, 0);
        setCheckMarkDrawable(v5.g(0));
        v5.w();
    }
}
