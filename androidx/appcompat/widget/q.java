package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
class q extends PopupWindow {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f1054b = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1055a;

    public q(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        a(context, attributeSet, i6, i7);
    }

    private void a(Context context, AttributeSet attributeSet, int i6, int i7) {
        c2 v5 = c2.v(context, attributeSet, b.j.f2720b2, i6, i7);
        int i8 = b.j.f2730d2;
        if (v5.s(i8)) {
            b(v5.a(i8, false));
        }
        setBackgroundDrawable(v5.g(b.j.f2725c2));
        v5.w();
    }

    private void b(boolean z5) {
        if (f1054b) {
            this.f1055a = z5;
        } else {
            androidx.core.widget.k.a(this, z5);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i6, int i7) {
        if (f1054b && this.f1055a) {
            i7 -= view.getHeight();
        }
        super.showAsDropDown(view, i6, i7);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i6, int i7, int i8, int i9) {
        if (f1054b && this.f1055a) {
            i7 -= view.getHeight();
        }
        super.update(view, i6, i7, i8, i9);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i6, int i7, int i8) {
        if (f1054b && this.f1055a) {
            i7 -= view.getHeight();
        }
        super.showAsDropDown(view, i6, i7, i8);
    }
}
