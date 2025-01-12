package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
/* loaded from: classes.dex */
class i {

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f941a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f942b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f943c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f944d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f945e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f946f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(CompoundButton compoundButton) {
        this.f941a = compoundButton;
    }

    void a() {
        Drawable a6 = androidx.core.widget.d.a(this.f941a);
        if (a6 != null) {
            if (this.f944d || this.f945e) {
                Drawable mutate = x.b.r(a6).mutate();
                if (this.f944d) {
                    x.b.o(mutate, this.f942b);
                }
                if (this.f945e) {
                    x.b.p(mutate, this.f943c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f941a.getDrawableState());
                }
                this.f941a.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i6) {
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.f942b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        return this.f943c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003e A[Catch: all -> 0x0085, TRY_ENTER, TryCatch #1 {all -> 0x0085, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:17:0x0059, B:19:0x0061, B:20:0x006a, B:22:0x0072), top: B:30:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061 A[Catch: all -> 0x0085, TryCatch #1 {all -> 0x0085, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:17:0x0059, B:19:0x0061, B:20:0x006a, B:22:0x0072), top: B:30:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #1 {all -> 0x0085, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:17:0x0059, B:19:0x0061, B:20:0x006a, B:22:0x0072), top: B:30:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(AttributeSet attributeSet, int i6) {
        boolean z5;
        int i7;
        int i8;
        int n5;
        int n6;
        Context context = this.f941a.getContext();
        int[] iArr = b.j.R0;
        c2 v5 = c2.v(context, attributeSet, iArr, i6, 0);
        CompoundButton compoundButton = this.f941a;
        e0.b0.j0(compoundButton, compoundButton.getContext(), iArr, attributeSet, v5.r(), i6, 0);
        try {
            int i9 = b.j.T0;
            if (v5.s(i9) && (n6 = v5.n(i9, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.f941a;
                    compoundButton2.setButtonDrawable(e.b.d(compoundButton2.getContext(), n6));
                    z5 = true;
                } catch (Resources.NotFoundException unused) {
                }
                if (!z5) {
                    int i10 = b.j.S0;
                    if (v5.s(i10) && (n5 = v5.n(i10, 0)) != 0) {
                        CompoundButton compoundButton3 = this.f941a;
                        compoundButton3.setButtonDrawable(e.b.d(compoundButton3.getContext(), n5));
                    }
                }
                i7 = b.j.U0;
                if (v5.s(i7)) {
                    androidx.core.widget.d.c(this.f941a, v5.c(i7));
                }
                i8 = b.j.V0;
                if (v5.s(i8)) {
                    androidx.core.widget.d.d(this.f941a, f1.d(v5.k(i8, -1), null));
                }
            }
            z5 = false;
            if (!z5) {
            }
            i7 = b.j.U0;
            if (v5.s(i7)) {
            }
            i8 = b.j.V0;
            if (v5.s(i8)) {
            }
        } finally {
            v5.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.f946f) {
            this.f946f = false;
            return;
        }
        this.f946f = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ColorStateList colorStateList) {
        this.f942b = colorStateList;
        this.f944d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(PorterDuff.Mode mode) {
        this.f943c = mode;
        this.f945e = true;
        a();
    }
}
