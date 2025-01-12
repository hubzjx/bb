package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    private final View f886a;

    /* renamed from: d  reason: collision with root package name */
    private a2 f889d;

    /* renamed from: e  reason: collision with root package name */
    private a2 f890e;

    /* renamed from: f  reason: collision with root package name */
    private a2 f891f;

    /* renamed from: c  reason: collision with root package name */
    private int f888c = -1;

    /* renamed from: b  reason: collision with root package name */
    private final j f887b = j.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(View view) {
        this.f886a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f891f == null) {
            this.f891f = new a2();
        }
        a2 a2Var = this.f891f;
        a2Var.a();
        ColorStateList s5 = e0.b0.s(this.f886a);
        if (s5 != null) {
            a2Var.f830d = true;
            a2Var.f827a = s5;
        }
        PorterDuff.Mode t5 = e0.b0.t(this.f886a);
        if (t5 != null) {
            a2Var.f829c = true;
            a2Var.f828b = t5;
        }
        if (a2Var.f830d || a2Var.f829c) {
            j.i(drawable, a2Var, this.f886a.getDrawableState());
            return true;
        }
        return false;
    }

    private boolean k() {
        int i6 = Build.VERSION.SDK_INT;
        return i6 > 21 ? this.f889d != null : i6 == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f886a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            a2 a2Var = this.f890e;
            if (a2Var != null) {
                j.i(background, a2Var, this.f886a.getDrawableState());
                return;
            }
            a2 a2Var2 = this.f889d;
            if (a2Var2 != null) {
                j.i(background, a2Var2, this.f886a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        a2 a2Var = this.f890e;
        if (a2Var != null) {
            return a2Var.f827a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        a2 a2Var = this.f890e;
        if (a2Var != null) {
            return a2Var.f828b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i6) {
        Context context = this.f886a.getContext();
        int[] iArr = b.j.D3;
        c2 v5 = c2.v(context, attributeSet, iArr, i6, 0);
        View view = this.f886a;
        e0.b0.j0(view, view.getContext(), iArr, attributeSet, v5.r(), i6, 0);
        try {
            int i7 = b.j.E3;
            if (v5.s(i7)) {
                this.f888c = v5.n(i7, -1);
                ColorStateList f6 = this.f887b.f(this.f886a.getContext(), this.f888c);
                if (f6 != null) {
                    h(f6);
                }
            }
            int i8 = b.j.F3;
            if (v5.s(i8)) {
                e0.b0.p0(this.f886a, v5.c(i8));
            }
            int i9 = b.j.G3;
            if (v5.s(i9)) {
                e0.b0.q0(this.f886a, f1.d(v5.k(i9, -1), null));
            }
        } finally {
            v5.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f888c = -1;
        h(null);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i6) {
        this.f888c = i6;
        j jVar = this.f887b;
        h(jVar != null ? jVar.f(this.f886a.getContext(), i6) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f889d == null) {
                this.f889d = new a2();
            }
            a2 a2Var = this.f889d;
            a2Var.f827a = colorStateList;
            a2Var.f830d = true;
        } else {
            this.f889d = null;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f890e == null) {
            this.f890e = new a2();
        }
        a2 a2Var = this.f890e;
        a2Var.f827a = colorStateList;
        a2Var.f830d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f890e == null) {
            this.f890e = new a2();
        }
        a2 a2Var = this.f890e;
        a2Var.f828b = mode;
        a2Var.f829c = true;
        b();
    }
}
