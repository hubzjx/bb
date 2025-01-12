package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
/* loaded from: classes.dex */
class v extends r {

    /* renamed from: d  reason: collision with root package name */
    private final SeekBar f1079d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1080e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f1081f;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f1082g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1083h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1084i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SeekBar seekBar) {
        super(seekBar);
        this.f1081f = null;
        this.f1082g = null;
        this.f1083h = false;
        this.f1084i = false;
        this.f1079d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f1080e;
        if (drawable != null) {
            if (this.f1083h || this.f1084i) {
                Drawable r5 = x.b.r(drawable.mutate());
                this.f1080e = r5;
                if (this.f1083h) {
                    x.b.o(r5, this.f1081f);
                }
                if (this.f1084i) {
                    x.b.p(this.f1080e, this.f1082g);
                }
                if (this.f1080e.isStateful()) {
                    this.f1080e.setState(this.f1079d.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.r
    public void c(AttributeSet attributeSet, int i6) {
        super.c(attributeSet, i6);
        Context context = this.f1079d.getContext();
        int[] iArr = b.j.V;
        c2 v5 = c2.v(context, attributeSet, iArr, i6, 0);
        SeekBar seekBar = this.f1079d;
        e0.b0.j0(seekBar, seekBar.getContext(), iArr, attributeSet, v5.r(), i6, 0);
        Drawable h6 = v5.h(b.j.W);
        if (h6 != null) {
            this.f1079d.setThumb(h6);
        }
        j(v5.g(b.j.X));
        int i7 = b.j.Z;
        if (v5.s(i7)) {
            this.f1082g = f1.d(v5.k(i7, -1), this.f1082g);
            this.f1084i = true;
        }
        int i8 = b.j.Y;
        if (v5.s(i8)) {
            this.f1081f = v5.c(i8);
            this.f1083h = true;
        }
        v5.w();
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        if (this.f1080e != null) {
            int max = this.f1079d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f1080e.getIntrinsicWidth();
                int intrinsicHeight = this.f1080e.getIntrinsicHeight();
                int i6 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i7 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f1080e.setBounds(-i6, -i7, i6, i7);
                float width = ((this.f1079d.getWidth() - this.f1079d.getPaddingLeft()) - this.f1079d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f1079d.getPaddingLeft(), this.f1079d.getHeight() / 2);
                for (int i8 = 0; i8 <= max; i8++) {
                    this.f1080e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f1080e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1079d.getDrawableState())) {
            this.f1079d.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f1080e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f1080e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1080e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1079d);
            x.b.m(drawable, e0.b0.B(this.f1079d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1079d.getDrawableState());
            }
            f();
        }
        this.f1079d.invalidate();
    }
}
