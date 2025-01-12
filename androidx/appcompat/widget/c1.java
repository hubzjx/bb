package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;
/* loaded from: classes.dex */
public class c1 extends ToggleButton {

    /* renamed from: b  reason: collision with root package name */
    private final m0 f857b;

    public c1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public c1(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        y1.a(this, getContext());
        m0 m0Var = new m0(this);
        this.f857b = m0Var;
        m0Var.m(attributeSet, i6);
    }
}
