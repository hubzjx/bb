package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f1009a;

    /* renamed from: b  reason: collision with root package name */
    private a2 f1010b;

    /* renamed from: c  reason: collision with root package name */
    private a2 f1011c;

    /* renamed from: d  reason: collision with root package name */
    private a2 f1012d;

    public n(ImageView imageView) {
        this.f1009a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f1012d == null) {
            this.f1012d = new a2();
        }
        a2 a2Var = this.f1012d;
        a2Var.a();
        ColorStateList a6 = androidx.core.widget.f.a(this.f1009a);
        if (a6 != null) {
            a2Var.f830d = true;
            a2Var.f827a = a6;
        }
        PorterDuff.Mode b6 = androidx.core.widget.f.b(this.f1009a);
        if (b6 != null) {
            a2Var.f829c = true;
            a2Var.f828b = b6;
        }
        if (a2Var.f830d || a2Var.f829c) {
            j.i(drawable, a2Var, this.f1009a.getDrawableState());
            return true;
        }
        return false;
    }

    private boolean j() {
        int i6 = Build.VERSION.SDK_INT;
        return i6 > 21 ? this.f1010b != null : i6 == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.f1009a.getDrawable();
        if (drawable != null) {
            f1.b(drawable);
        }
        if (drawable != null) {
            if (j() && a(drawable)) {
                return;
            }
            a2 a2Var = this.f1011c;
            if (a2Var != null) {
                j.i(drawable, a2Var, this.f1009a.getDrawableState());
                return;
            }
            a2 a2Var2 = this.f1010b;
            if (a2Var2 != null) {
                j.i(drawable, a2Var2, this.f1009a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        a2 a2Var = this.f1011c;
        if (a2Var != null) {
            return a2Var.f827a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        a2 a2Var = this.f1011c;
        if (a2Var != null) {
            return a2Var.f828b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return !(this.f1009a.getBackground() instanceof RippleDrawable);
    }

    public void f(AttributeSet attributeSet, int i6) {
        int n5;
        Context context = this.f1009a.getContext();
        int[] iArr = b.j.R;
        c2 v5 = c2.v(context, attributeSet, iArr, i6, 0);
        ImageView imageView = this.f1009a;
        e0.b0.j0(imageView, imageView.getContext(), iArr, attributeSet, v5.r(), i6, 0);
        try {
            Drawable drawable = this.f1009a.getDrawable();
            if (drawable == null && (n5 = v5.n(b.j.S, -1)) != -1 && (drawable = e.b.d(this.f1009a.getContext(), n5)) != null) {
                this.f1009a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                f1.b(drawable);
            }
            int i7 = b.j.T;
            if (v5.s(i7)) {
                androidx.core.widget.f.c(this.f1009a, v5.c(i7));
            }
            int i8 = b.j.U;
            if (v5.s(i8)) {
                androidx.core.widget.f.d(this.f1009a, f1.d(v5.k(i8, -1), null));
            }
        } finally {
            v5.w();
        }
    }

    public void g(int i6) {
        if (i6 != 0) {
            Drawable d6 = e.b.d(this.f1009a.getContext(), i6);
            if (d6 != null) {
                f1.b(d6);
            }
            this.f1009a.setImageDrawable(d6);
        } else {
            this.f1009a.setImageDrawable(null);
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (this.f1011c == null) {
            this.f1011c = new a2();
        }
        a2 a2Var = this.f1011c;
        a2Var.f827a = colorStateList;
        a2Var.f830d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(PorterDuff.Mode mode) {
        if (this.f1011c == null) {
            this.f1011c = new a2();
        }
        a2 a2Var = this.f1011c;
        a2Var.f828b = mode;
        a2Var.f829c = true;
        b();
    }
}
