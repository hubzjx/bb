package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.internal.l;
import e0.b0;
import e3.c;
import h3.g;
import h3.k;
import h3.n;
import u2.j;
import x.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {

    /* renamed from: t  reason: collision with root package name */
    private static final boolean f5027t = true;

    /* renamed from: a  reason: collision with root package name */
    private final MaterialButton f5028a;

    /* renamed from: b  reason: collision with root package name */
    private k f5029b;

    /* renamed from: c  reason: collision with root package name */
    private int f5030c;

    /* renamed from: d  reason: collision with root package name */
    private int f5031d;

    /* renamed from: e  reason: collision with root package name */
    private int f5032e;

    /* renamed from: f  reason: collision with root package name */
    private int f5033f;

    /* renamed from: g  reason: collision with root package name */
    private int f5034g;

    /* renamed from: h  reason: collision with root package name */
    private int f5035h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuff.Mode f5036i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f5037j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f5038k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f5039l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f5040m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f5041n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f5042o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f5043p = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f5044q;

    /* renamed from: r  reason: collision with root package name */
    private LayerDrawable f5045r;

    /* renamed from: s  reason: collision with root package name */
    private int f5046s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MaterialButton materialButton, k kVar) {
        this.f5028a = materialButton;
        this.f5029b = kVar;
    }

    private void E(int i6, int i7) {
        int G = b0.G(this.f5028a);
        int paddingTop = this.f5028a.getPaddingTop();
        int F = b0.F(this.f5028a);
        int paddingBottom = this.f5028a.getPaddingBottom();
        int i8 = this.f5032e;
        int i9 = this.f5033f;
        this.f5033f = i7;
        this.f5032e = i6;
        if (!this.f5042o) {
            F();
        }
        b0.x0(this.f5028a, G, (paddingTop + i6) - i8, F, (paddingBottom + i7) - i9);
    }

    private void F() {
        this.f5028a.setInternalBackground(a());
        g f6 = f();
        if (f6 != null) {
            f6.T(this.f5046s);
        }
    }

    private void G(k kVar) {
        if (f() != null) {
            f().setShapeAppearanceModel(kVar);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(kVar);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(kVar);
        }
    }

    private void I() {
        g f6 = f();
        g n5 = n();
        if (f6 != null) {
            f6.Z(this.f5035h, this.f5038k);
            if (n5 != null) {
                n5.Y(this.f5035h, this.f5041n ? y2.a.c(this.f5028a, u2.a.colorSurface) : 0);
            }
        }
    }

    private InsetDrawable J(Drawable drawable) {
        return new InsetDrawable(drawable, this.f5030c, this.f5032e, this.f5031d, this.f5033f);
    }

    private Drawable a() {
        g gVar = new g(this.f5029b);
        gVar.K(this.f5028a.getContext());
        b.o(gVar, this.f5037j);
        PorterDuff.Mode mode = this.f5036i;
        if (mode != null) {
            b.p(gVar, mode);
        }
        gVar.Z(this.f5035h, this.f5038k);
        g gVar2 = new g(this.f5029b);
        gVar2.setTint(0);
        gVar2.Y(this.f5035h, this.f5041n ? y2.a.c(this.f5028a, u2.a.colorSurface) : 0);
        if (f5027t) {
            g gVar3 = new g(this.f5029b);
            this.f5040m = gVar3;
            b.n(gVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(f3.b.a(this.f5039l), J(new LayerDrawable(new Drawable[]{gVar2, gVar})), this.f5040m);
            this.f5045r = rippleDrawable;
            return rippleDrawable;
        }
        f3.a aVar = new f3.a(this.f5029b);
        this.f5040m = aVar;
        b.o(aVar, f3.b.a(this.f5039l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.f5040m});
        this.f5045r = layerDrawable;
        return J(layerDrawable);
    }

    private g g(boolean z5) {
        LayerDrawable layerDrawable = this.f5045r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (g) (f5027t ? (LayerDrawable) ((InsetDrawable) this.f5045r.getDrawable(0)).getDrawable() : this.f5045r).getDrawable(!z5 ? 1 : 0);
    }

    private g n() {
        return g(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(ColorStateList colorStateList) {
        if (this.f5038k != colorStateList) {
            this.f5038k = colorStateList;
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i6) {
        if (this.f5035h != i6) {
            this.f5035h = i6;
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(ColorStateList colorStateList) {
        if (this.f5037j != colorStateList) {
            this.f5037j = colorStateList;
            if (f() != null) {
                b.o(f(), this.f5037j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(PorterDuff.Mode mode) {
        if (this.f5036i != mode) {
            this.f5036i = mode;
            if (f() == null || this.f5036i == null) {
                return;
            }
            b.p(f(), this.f5036i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(int i6, int i7) {
        Drawable drawable = this.f5040m;
        if (drawable != null) {
            drawable.setBounds(this.f5030c, this.f5032e, i7 - this.f5031d, i6 - this.f5033f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f5034g;
    }

    public int c() {
        return this.f5033f;
    }

    public int d() {
        return this.f5032e;
    }

    public n e() {
        LayerDrawable layerDrawable = this.f5045r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (n) (this.f5045r.getNumberOfLayers() > 2 ? this.f5045r.getDrawable(2) : this.f5045r.getDrawable(1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g f() {
        return g(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.f5039l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k i() {
        return this.f5029b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        return this.f5038k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f5035h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f5037j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode m() {
        return this.f5036i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.f5042o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f5044q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(TypedArray typedArray) {
        this.f5030c = typedArray.getDimensionPixelOffset(j.S1, 0);
        this.f5031d = typedArray.getDimensionPixelOffset(j.T1, 0);
        this.f5032e = typedArray.getDimensionPixelOffset(j.U1, 0);
        this.f5033f = typedArray.getDimensionPixelOffset(j.V1, 0);
        int i6 = j.Z1;
        if (typedArray.hasValue(i6)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i6, -1);
            this.f5034g = dimensionPixelSize;
            y(this.f5029b.w(dimensionPixelSize));
            this.f5043p = true;
        }
        this.f5035h = typedArray.getDimensionPixelSize(j.f13503j2, 0);
        this.f5036i = l.e(typedArray.getInt(j.Y1, -1), PorterDuff.Mode.SRC_IN);
        this.f5037j = c.a(this.f5028a.getContext(), typedArray, j.X1);
        this.f5038k = c.a(this.f5028a.getContext(), typedArray, j.f13496i2);
        this.f5039l = c.a(this.f5028a.getContext(), typedArray, j.f13489h2);
        this.f5044q = typedArray.getBoolean(j.W1, false);
        this.f5046s = typedArray.getDimensionPixelSize(j.f13440a2, 0);
        int G = b0.G(this.f5028a);
        int paddingTop = this.f5028a.getPaddingTop();
        int F = b0.F(this.f5028a);
        int paddingBottom = this.f5028a.getPaddingBottom();
        if (typedArray.hasValue(j.R1)) {
            s();
        } else {
            F();
        }
        b0.x0(this.f5028a, G + this.f5030c, paddingTop + this.f5032e, F + this.f5031d, paddingBottom + this.f5033f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i6) {
        if (f() != null) {
            f().setTint(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.f5042o = true;
        this.f5028a.setSupportBackgroundTintList(this.f5037j);
        this.f5028a.setSupportBackgroundTintMode(this.f5036i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(boolean z5) {
        this.f5044q = z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i6) {
        if (this.f5043p && this.f5034g == i6) {
            return;
        }
        this.f5034g = i6;
        this.f5043p = true;
        y(this.f5029b.w(i6));
    }

    public void v(int i6) {
        E(this.f5032e, i6);
    }

    public void w(int i6) {
        E(i6, this.f5033f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(ColorStateList colorStateList) {
        if (this.f5039l != colorStateList) {
            this.f5039l = colorStateList;
            boolean z5 = f5027t;
            if (z5 && (this.f5028a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f5028a.getBackground()).setColor(f3.b.a(colorStateList));
            } else if (z5 || !(this.f5028a.getBackground() instanceof f3.a)) {
            } else {
                ((f3.a) this.f5028a.getBackground()).setTintList(f3.b.a(colorStateList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(k kVar) {
        this.f5029b = kVar;
        G(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(boolean z5) {
        this.f5041n = z5;
        I();
    }
}
