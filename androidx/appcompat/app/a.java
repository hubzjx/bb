package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import b.j;
import h.b;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: androidx.appcompat.app.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0008a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f320a;

        public C0008a(int i6, int i7) {
            super(i6, i7);
            this.f320a = 8388627;
        }

        public C0008a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f320a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f2807t);
            this.f320a = obtainStyledAttributes.getInt(j.f2812u, 0);
            obtainStyledAttributes.recycle();
        }

        public C0008a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f320a = 0;
        }

        public C0008a(C0008a c0008a) {
            super((ViewGroup.MarginLayoutParams) c0008a);
            this.f320a = 0;
            this.f320a = c0008a.f320a;
        }
    }

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z5);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return false;
    }

    public abstract void m(Configuration configuration);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
    }

    public abstract boolean o(int i6, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(boolean z5);

    public abstract void s(boolean z5);

    public abstract void t(CharSequence charSequence);

    public abstract h.b u(b.a aVar);
}
