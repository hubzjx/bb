package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.internal.h;
import com.google.android.material.internal.j;
import com.google.android.material.internal.l;
import e3.d;
import h3.g;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import okhttp3.HttpUrl;
import v2.c;
/* loaded from: classes.dex */
public class b extends g implements Drawable.Callback, h.b {
    private static final int[] J0 = {16842910};
    private static final ShapeDrawable K0 = new ShapeDrawable(new OvalShape());
    private ColorStateList A;
    private PorterDuff.Mode A0;
    private float B;
    private int[] B0;
    private float C;
    private boolean C0;
    private ColorStateList D;
    private ColorStateList D0;
    private float E;
    private WeakReference E0;
    private ColorStateList F;
    private TextUtils.TruncateAt F0;
    private CharSequence G;
    private boolean G0;
    private boolean H;
    private int H0;
    private Drawable I;
    private boolean I0;
    private ColorStateList J;
    private float K;
    private boolean L;
    private boolean M;
    private Drawable N;
    private Drawable O;
    private ColorStateList P;
    private float Q;
    private CharSequence R;
    private boolean S;
    private boolean T;
    private Drawable U;
    private ColorStateList V;
    private c W;
    private c X;
    private float Y;
    private float Z;

    /* renamed from: a0  reason: collision with root package name */
    private float f5082a0;

    /* renamed from: b0  reason: collision with root package name */
    private float f5083b0;

    /* renamed from: c0  reason: collision with root package name */
    private float f5084c0;

    /* renamed from: d0  reason: collision with root package name */
    private float f5085d0;

    /* renamed from: e0  reason: collision with root package name */
    private float f5086e0;

    /* renamed from: f0  reason: collision with root package name */
    private float f5087f0;

    /* renamed from: g0  reason: collision with root package name */
    private final Context f5088g0;

    /* renamed from: h0  reason: collision with root package name */
    private final Paint f5089h0;

    /* renamed from: i0  reason: collision with root package name */
    private final Paint f5090i0;

    /* renamed from: j0  reason: collision with root package name */
    private final Paint.FontMetrics f5091j0;

    /* renamed from: k0  reason: collision with root package name */
    private final RectF f5092k0;

    /* renamed from: l0  reason: collision with root package name */
    private final PointF f5093l0;

    /* renamed from: m0  reason: collision with root package name */
    private final Path f5094m0;

    /* renamed from: n0  reason: collision with root package name */
    private final h f5095n0;

    /* renamed from: o0  reason: collision with root package name */
    private int f5096o0;

    /* renamed from: p0  reason: collision with root package name */
    private int f5097p0;

    /* renamed from: q0  reason: collision with root package name */
    private int f5098q0;

    /* renamed from: r0  reason: collision with root package name */
    private int f5099r0;

    /* renamed from: s0  reason: collision with root package name */
    private int f5100s0;

    /* renamed from: t0  reason: collision with root package name */
    private int f5101t0;

    /* renamed from: u0  reason: collision with root package name */
    private boolean f5102u0;

    /* renamed from: v0  reason: collision with root package name */
    private int f5103v0;

    /* renamed from: w0  reason: collision with root package name */
    private int f5104w0;

    /* renamed from: x0  reason: collision with root package name */
    private ColorFilter f5105x0;

    /* renamed from: y0  reason: collision with root package name */
    private PorterDuffColorFilter f5106y0;

    /* renamed from: z  reason: collision with root package name */
    private ColorStateList f5107z;

    /* renamed from: z0  reason: collision with root package name */
    private ColorStateList f5108z0;

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    private b(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.C = -1.0f;
        this.f5089h0 = new Paint(1);
        this.f5091j0 = new Paint.FontMetrics();
        this.f5092k0 = new RectF();
        this.f5093l0 = new PointF();
        this.f5094m0 = new Path();
        this.f5104w0 = 255;
        this.A0 = PorterDuff.Mode.SRC_IN;
        this.E0 = new WeakReference(null);
        K(context);
        this.f5088g0 = context;
        h hVar = new h(this);
        this.f5095n0 = hVar;
        this.G = HttpUrl.FRAGMENT_ENCODE_SET;
        hVar.e().density = context.getResources().getDisplayMetrics().density;
        this.f5090i0 = null;
        int[] iArr = J0;
        setState(iArr);
        g2(iArr);
        this.G0 = true;
        if (f3.b.f9883a) {
            K0.setTint(-1);
        }
    }

    private boolean H2() {
        return this.T && this.U != null && this.f5102u0;
    }

    private boolean I2() {
        return this.H && this.I != null;
    }

    private boolean J2() {
        return this.M && this.N != null;
    }

    private void K2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void L2() {
        this.D0 = this.C0 ? f3.b.a(this.F) : null;
    }

    private void M2() {
        this.O = new RippleDrawable(f3.b.a(a1()), this.N, K0);
    }

    private float U0() {
        Drawable drawable = this.f5102u0 ? this.U : this.I;
        float f6 = this.K;
        if (f6 <= 0.0f && drawable != null) {
            f6 = (float) Math.ceil(l.b(this.f5088g0, 24));
            if (drawable.getIntrinsicHeight() <= f6) {
                return drawable.getIntrinsicHeight();
            }
        }
        return f6;
    }

    private float V0() {
        Drawable drawable = this.f5102u0 ? this.U : this.I;
        float f6 = this.K;
        return (f6 > 0.0f || drawable == null) ? f6 : drawable.getIntrinsicWidth();
    }

    private void W1(ColorStateList colorStateList) {
        if (this.f5107z != colorStateList) {
            this.f5107z = colorStateList;
            onStateChange(getState());
        }
    }

    private void f0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        x.b.m(drawable, x.b.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.N) {
            if (drawable.isStateful()) {
                drawable.setState(R0());
            }
            x.b.o(drawable, this.P);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.I;
        if (drawable == drawable2 && this.L) {
            x.b.o(drawable2, this.J);
        }
    }

    private void g0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (I2() || H2()) {
            float f6 = this.Y + this.Z;
            float V0 = V0();
            if (x.b.f(this) == 0) {
                float f7 = rect.left + f6;
                rectF.left = f7;
                rectF.right = f7 + V0;
            } else {
                float f8 = rect.right - f6;
                rectF.right = f8;
                rectF.left = f8 - V0;
            }
            float U0 = U0();
            float exactCenterY = rect.exactCenterY() - (U0 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + U0;
        }
    }

    private ColorFilter g1() {
        ColorFilter colorFilter = this.f5105x0;
        return colorFilter != null ? colorFilter : this.f5106y0;
    }

    private void i0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (J2()) {
            float f6 = this.f5087f0 + this.f5086e0 + this.Q + this.f5085d0 + this.f5084c0;
            if (x.b.f(this) == 0) {
                rectF.right = rect.right - f6;
            } else {
                rectF.left = rect.left + f6;
            }
        }
    }

    private static boolean i1(int[] iArr, int i6) {
        if (iArr == null) {
            return false;
        }
        for (int i7 : iArr) {
            if (i7 == i6) {
                return true;
            }
        }
        return false;
    }

    private void j0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (J2()) {
            float f6 = this.f5087f0 + this.f5086e0;
            if (x.b.f(this) == 0) {
                float f7 = rect.right - f6;
                rectF.right = f7;
                rectF.left = f7 - this.Q;
            } else {
                float f8 = rect.left + f6;
                rectF.left = f8;
                rectF.right = f8 + this.Q;
            }
            float exactCenterY = rect.exactCenterY();
            float f9 = this.Q;
            float f10 = exactCenterY - (f9 / 2.0f);
            rectF.top = f10;
            rectF.bottom = f10 + f9;
        }
    }

    private void k0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (J2()) {
            float f6 = this.f5087f0 + this.f5086e0 + this.Q + this.f5085d0 + this.f5084c0;
            if (x.b.f(this) == 0) {
                float f7 = rect.right;
                rectF.right = f7;
                rectF.left = f7 - f6;
            } else {
                int i6 = rect.left;
                rectF.left = i6;
                rectF.right = i6 + f6;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void m0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.G != null) {
            float h02 = this.Y + h0() + this.f5083b0;
            float l02 = this.f5087f0 + l0() + this.f5084c0;
            if (x.b.f(this) == 0) {
                rectF.left = rect.left + h02;
                rectF.right = rect.right - l02;
            } else {
                rectF.left = rect.left + l02;
                rectF.right = rect.right - h02;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean m1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private float n0() {
        this.f5095n0.e().getFontMetrics(this.f5091j0);
        Paint.FontMetrics fontMetrics = this.f5091j0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean n1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean o1(d dVar) {
        ColorStateList colorStateList;
        return (dVar == null || (colorStateList = dVar.f9488a) == null || !colorStateList.isStateful()) ? false : true;
    }

    private boolean p0() {
        return this.T && this.U != null && this.S;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p1(AttributeSet attributeSet, int i6, int i7) {
        TextUtils.TruncateAt truncateAt;
        int i8;
        int i9;
        TypedArray h6 = j.h(this.f5088g0, attributeSet, u2.j.Q, i6, i7, new int[0]);
        this.I0 = h6.hasValue(u2.j.C0);
        W1(e3.c.a(this.f5088g0, h6, u2.j.f13540p0));
        A1(e3.c.a(this.f5088g0, h6, u2.j.f13452c0));
        O1(h6.getDimension(u2.j.f13508k0, 0.0f));
        int i10 = u2.j.f13459d0;
        if (h6.hasValue(i10)) {
            C1(h6.getDimension(i10, 0.0f));
        }
        S1(e3.c.a(this.f5088g0, h6, u2.j.f13528n0));
        U1(h6.getDimension(u2.j.f13534o0, 0.0f));
        t2(e3.c.a(this.f5088g0, h6, u2.j.B0));
        y2(h6.getText(u2.j.W));
        d f6 = e3.c.f(this.f5088g0, h6, u2.j.R);
        f6.f9501n = h6.getDimension(u2.j.S, f6.f9501n);
        z2(f6);
        int i11 = h6.getInt(u2.j.U, 0);
        if (i11 == 1) {
            truncateAt = TextUtils.TruncateAt.START;
        } else if (i11 != 2) {
            if (i11 == 3) {
                truncateAt = TextUtils.TruncateAt.END;
            }
            N1(h6.getBoolean(u2.j.f13501j0, false));
            if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
                N1(h6.getBoolean(u2.j.f13480g0, false));
            }
            G1(e3.c.d(this.f5088g0, h6, u2.j.f13473f0));
            i8 = u2.j.f13494i0;
            if (h6.hasValue(i8)) {
                K1(e3.c.a(this.f5088g0, h6, i8));
            }
            I1(h6.getDimension(u2.j.f13487h0, -1.0f));
            j2(h6.getBoolean(u2.j.f13582w0, false));
            if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
                j2(h6.getBoolean(u2.j.f13552r0, false));
            }
            X1(e3.c.d(this.f5088g0, h6, u2.j.f13546q0));
            h2(e3.c.a(this.f5088g0, h6, u2.j.f13576v0));
            c2(h6.getDimension(u2.j.f13564t0, 0.0f));
            s1(h6.getBoolean(u2.j.X, false));
            z1(h6.getBoolean(u2.j.f13445b0, false));
            if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
                z1(h6.getBoolean(u2.j.Z, false));
            }
            u1(e3.c.d(this.f5088g0, h6, u2.j.Y));
            i9 = u2.j.f13438a0;
            if (h6.hasValue(i9)) {
                w1(e3.c.a(this.f5088g0, h6, i9));
            }
            w2(c.b(this.f5088g0, h6, u2.j.D0));
            m2(c.b(this.f5088g0, h6, u2.j.f13594y0));
            Q1(h6.getDimension(u2.j.f13522m0, 0.0f));
            q2(h6.getDimension(u2.j.A0, 0.0f));
            o2(h6.getDimension(u2.j.f13600z0, 0.0f));
            D2(h6.getDimension(u2.j.F0, 0.0f));
            B2(h6.getDimension(u2.j.E0, 0.0f));
            e2(h6.getDimension(u2.j.f13570u0, 0.0f));
            Z1(h6.getDimension(u2.j.f13558s0, 0.0f));
            E1(h6.getDimension(u2.j.f13466e0, 0.0f));
            s2(h6.getDimensionPixelSize(u2.j.V, Integer.MAX_VALUE));
            h6.recycle();
        } else {
            truncateAt = TextUtils.TruncateAt.MIDDLE;
        }
        l2(truncateAt);
        N1(h6.getBoolean(u2.j.f13501j0, false));
        if (attributeSet != null) {
            N1(h6.getBoolean(u2.j.f13480g0, false));
        }
        G1(e3.c.d(this.f5088g0, h6, u2.j.f13473f0));
        i8 = u2.j.f13494i0;
        if (h6.hasValue(i8)) {
        }
        I1(h6.getDimension(u2.j.f13487h0, -1.0f));
        j2(h6.getBoolean(u2.j.f13582w0, false));
        if (attributeSet != null) {
            j2(h6.getBoolean(u2.j.f13552r0, false));
        }
        X1(e3.c.d(this.f5088g0, h6, u2.j.f13546q0));
        h2(e3.c.a(this.f5088g0, h6, u2.j.f13576v0));
        c2(h6.getDimension(u2.j.f13564t0, 0.0f));
        s1(h6.getBoolean(u2.j.X, false));
        z1(h6.getBoolean(u2.j.f13445b0, false));
        if (attributeSet != null) {
            z1(h6.getBoolean(u2.j.Z, false));
        }
        u1(e3.c.d(this.f5088g0, h6, u2.j.Y));
        i9 = u2.j.f13438a0;
        if (h6.hasValue(i9)) {
        }
        w2(c.b(this.f5088g0, h6, u2.j.D0));
        m2(c.b(this.f5088g0, h6, u2.j.f13594y0));
        Q1(h6.getDimension(u2.j.f13522m0, 0.0f));
        q2(h6.getDimension(u2.j.A0, 0.0f));
        o2(h6.getDimension(u2.j.f13600z0, 0.0f));
        D2(h6.getDimension(u2.j.F0, 0.0f));
        B2(h6.getDimension(u2.j.E0, 0.0f));
        e2(h6.getDimension(u2.j.f13570u0, 0.0f));
        Z1(h6.getDimension(u2.j.f13558s0, 0.0f));
        E1(h6.getDimension(u2.j.f13466e0, 0.0f));
        s2(h6.getDimensionPixelSize(u2.j.V, Integer.MAX_VALUE));
        h6.recycle();
    }

    public static b q0(Context context, AttributeSet attributeSet, int i6, int i7) {
        b bVar = new b(context, attributeSet, i6, i7);
        bVar.p1(attributeSet, i6, i7);
        return bVar;
    }

    private void r0(Canvas canvas, Rect rect) {
        if (H2()) {
            g0(rect, this.f5092k0);
            RectF rectF = this.f5092k0;
            float f6 = rectF.left;
            float f7 = rectF.top;
            canvas.translate(f6, f7);
            this.U.setBounds(0, 0, (int) this.f5092k0.width(), (int) this.f5092k0.height());
            this.U.draw(canvas);
            canvas.translate(-f6, -f7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r1(int[] iArr, int[] iArr2) {
        boolean z5;
        int colorForState;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f5107z;
        int l6 = l(colorStateList != null ? colorStateList.getColorForState(iArr, this.f5096o0) : 0);
        boolean z6 = true;
        if (this.f5096o0 != l6) {
            this.f5096o0 = l6;
            onStateChange = true;
        }
        ColorStateList colorStateList2 = this.A;
        int l7 = l(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f5097p0) : 0);
        if (this.f5097p0 != l7) {
            this.f5097p0 = l7;
            onStateChange = true;
        }
        int f6 = y2.a.f(l6, l7);
        if ((this.f5098q0 != f6) | (x() == null)) {
            this.f5098q0 = f6;
            U(ColorStateList.valueOf(f6));
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.D;
        int colorForState2 = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f5099r0) : 0;
        if (this.f5099r0 != colorForState2) {
            this.f5099r0 = colorForState2;
            onStateChange = true;
        }
        int colorForState3 = (this.D0 == null || !f3.b.b(iArr)) ? 0 : this.D0.getColorForState(iArr, this.f5100s0);
        if (this.f5100s0 != colorForState3) {
            this.f5100s0 = colorForState3;
            if (this.C0) {
                onStateChange = true;
            }
        }
        int colorForState4 = (this.f5095n0.d() == null || this.f5095n0.d().f9488a == null) ? 0 : this.f5095n0.d().f9488a.getColorForState(iArr, this.f5101t0);
        if (this.f5101t0 != colorForState4) {
            this.f5101t0 = colorForState4;
            onStateChange = true;
        }
        boolean z7 = i1(getState(), 16842912) && this.S;
        if (this.f5102u0 != z7 && this.U != null) {
            float h02 = h0();
            this.f5102u0 = z7;
            if (h02 != h0()) {
                onStateChange = true;
                z5 = true;
                ColorStateList colorStateList4 = this.f5108z0;
                colorForState = colorStateList4 == null ? colorStateList4.getColorForState(iArr, this.f5103v0) : 0;
                if (this.f5103v0 == colorForState) {
                    this.f5103v0 = colorForState;
                    this.f5106y0 = a3.a.a(this, this.f5108z0, this.A0);
                } else {
                    z6 = onStateChange;
                }
                if (n1(this.I)) {
                    z6 |= this.I.setState(iArr);
                }
                if (n1(this.U)) {
                    z6 |= this.U.setState(iArr);
                }
                if (n1(this.N)) {
                    int[] iArr3 = new int[iArr.length + iArr2.length];
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
                    z6 |= this.N.setState(iArr3);
                }
                if (f3.b.f9883a && n1(this.O)) {
                    z6 |= this.O.setState(iArr2);
                }
                if (z6) {
                    invalidateSelf();
                }
                if (z5) {
                    q1();
                }
                return z6;
            }
            onStateChange = true;
        }
        z5 = false;
        ColorStateList colorStateList42 = this.f5108z0;
        if (colorStateList42 == null) {
        }
        if (this.f5103v0 == colorForState) {
        }
        if (n1(this.I)) {
        }
        if (n1(this.U)) {
        }
        if (n1(this.N)) {
        }
        if (f3.b.f9883a) {
            z6 |= this.O.setState(iArr2);
        }
        if (z6) {
        }
        if (z5) {
        }
        return z6;
    }

    private void s0(Canvas canvas, Rect rect) {
        if (this.I0) {
            return;
        }
        this.f5089h0.setColor(this.f5097p0);
        this.f5089h0.setStyle(Paint.Style.FILL);
        this.f5089h0.setColorFilter(g1());
        this.f5092k0.set(rect);
        canvas.drawRoundRect(this.f5092k0, D0(), D0(), this.f5089h0);
    }

    private void t0(Canvas canvas, Rect rect) {
        if (I2()) {
            g0(rect, this.f5092k0);
            RectF rectF = this.f5092k0;
            float f6 = rectF.left;
            float f7 = rectF.top;
            canvas.translate(f6, f7);
            this.I.setBounds(0, 0, (int) this.f5092k0.width(), (int) this.f5092k0.height());
            this.I.draw(canvas);
            canvas.translate(-f6, -f7);
        }
    }

    private void u0(Canvas canvas, Rect rect) {
        if (this.E <= 0.0f || this.I0) {
            return;
        }
        this.f5089h0.setColor(this.f5099r0);
        this.f5089h0.setStyle(Paint.Style.STROKE);
        if (!this.I0) {
            this.f5089h0.setColorFilter(g1());
        }
        RectF rectF = this.f5092k0;
        float f6 = this.E;
        rectF.set(rect.left + (f6 / 2.0f), rect.top + (f6 / 2.0f), rect.right - (f6 / 2.0f), rect.bottom - (f6 / 2.0f));
        float f7 = this.C - (this.E / 2.0f);
        canvas.drawRoundRect(this.f5092k0, f7, f7, this.f5089h0);
    }

    private void v0(Canvas canvas, Rect rect) {
        if (this.I0) {
            return;
        }
        this.f5089h0.setColor(this.f5096o0);
        this.f5089h0.setStyle(Paint.Style.FILL);
        this.f5092k0.set(rect);
        canvas.drawRoundRect(this.f5092k0, D0(), D0(), this.f5089h0);
    }

    private void w0(Canvas canvas, Rect rect) {
        Drawable drawable;
        if (J2()) {
            j0(rect, this.f5092k0);
            RectF rectF = this.f5092k0;
            float f6 = rectF.left;
            float f7 = rectF.top;
            canvas.translate(f6, f7);
            this.N.setBounds(0, 0, (int) this.f5092k0.width(), (int) this.f5092k0.height());
            if (f3.b.f9883a) {
                this.O.setBounds(this.N.getBounds());
                this.O.jumpToCurrentState();
                drawable = this.O;
            } else {
                drawable = this.N;
            }
            drawable.draw(canvas);
            canvas.translate(-f6, -f7);
        }
    }

    private void x0(Canvas canvas, Rect rect) {
        this.f5089h0.setColor(this.f5100s0);
        this.f5089h0.setStyle(Paint.Style.FILL);
        this.f5092k0.set(rect);
        if (!this.I0) {
            canvas.drawRoundRect(this.f5092k0, D0(), D0(), this.f5089h0);
            return;
        }
        h(new RectF(rect), this.f5094m0);
        super.p(canvas, this.f5089h0, this.f5094m0, u());
    }

    private void y0(Canvas canvas, Rect rect) {
        Paint paint = this.f5090i0;
        if (paint != null) {
            paint.setColor(w.a.h(-16777216, 127));
            canvas.drawRect(rect, this.f5090i0);
            if (I2() || H2()) {
                g0(rect, this.f5092k0);
                canvas.drawRect(this.f5092k0, this.f5090i0);
            }
            if (this.G != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f5090i0);
            }
            if (J2()) {
                j0(rect, this.f5092k0);
                canvas.drawRect(this.f5092k0, this.f5090i0);
            }
            this.f5090i0.setColor(w.a.h(-65536, 127));
            i0(rect, this.f5092k0);
            canvas.drawRect(this.f5092k0, this.f5090i0);
            this.f5090i0.setColor(w.a.h(-16711936, 127));
            k0(rect, this.f5092k0);
            canvas.drawRect(this.f5092k0, this.f5090i0);
        }
    }

    private void z0(Canvas canvas, Rect rect) {
        if (this.G != null) {
            Paint.Align o02 = o0(rect, this.f5093l0);
            m0(rect, this.f5092k0);
            if (this.f5095n0.d() != null) {
                this.f5095n0.e().drawableState = getState();
                this.f5095n0.j(this.f5088g0);
            }
            this.f5095n0.e().setTextAlign(o02);
            int i6 = 0;
            boolean z5 = Math.round(this.f5095n0.f(c1().toString())) > Math.round(this.f5092k0.width());
            if (z5) {
                i6 = canvas.save();
                canvas.clipRect(this.f5092k0);
            }
            CharSequence charSequence = this.G;
            if (z5 && this.F0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.f5095n0.e(), this.f5092k0.width(), this.F0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.f5093l0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.f5095n0.e());
            if (z5) {
                canvas.restoreToCount(i6);
            }
        }
    }

    public Drawable A0() {
        return this.U;
    }

    public void A1(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    public void A2(int i6) {
        z2(new d(this.f5088g0, i6));
    }

    public ColorStateList B0() {
        return this.V;
    }

    public void B1(int i6) {
        A1(e.b.c(this.f5088g0, i6));
    }

    public void B2(float f6) {
        if (this.f5084c0 != f6) {
            this.f5084c0 = f6;
            invalidateSelf();
            q1();
        }
    }

    public ColorStateList C0() {
        return this.A;
    }

    public void C1(float f6) {
        if (this.C != f6) {
            this.C = f6;
            setShapeAppearanceModel(B().w(f6));
        }
    }

    public void C2(int i6) {
        B2(this.f5088g0.getResources().getDimension(i6));
    }

    public float D0() {
        return this.I0 ? D() : this.C;
    }

    public void D1(int i6) {
        C1(this.f5088g0.getResources().getDimension(i6));
    }

    public void D2(float f6) {
        if (this.f5083b0 != f6) {
            this.f5083b0 = f6;
            invalidateSelf();
            q1();
        }
    }

    public float E0() {
        return this.f5087f0;
    }

    public void E1(float f6) {
        if (this.f5087f0 != f6) {
            this.f5087f0 = f6;
            invalidateSelf();
            q1();
        }
    }

    public void E2(int i6) {
        D2(this.f5088g0.getResources().getDimension(i6));
    }

    public Drawable F0() {
        Drawable drawable = this.I;
        if (drawable != null) {
            return x.b.q(drawable);
        }
        return null;
    }

    public void F1(int i6) {
        E1(this.f5088g0.getResources().getDimension(i6));
    }

    public void F2(boolean z5) {
        if (this.C0 != z5) {
            this.C0 = z5;
            L2();
            onStateChange(getState());
        }
    }

    public float G0() {
        return this.K;
    }

    public void G1(Drawable drawable) {
        Drawable F0 = F0();
        if (F0 != drawable) {
            float h02 = h0();
            this.I = drawable != null ? x.b.r(drawable).mutate() : null;
            float h03 = h0();
            K2(F0);
            if (I2()) {
                f0(this.I);
            }
            invalidateSelf();
            if (h02 != h03) {
                q1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G2() {
        return this.G0;
    }

    public ColorStateList H0() {
        return this.J;
    }

    public void H1(int i6) {
        G1(e.b.d(this.f5088g0, i6));
    }

    public float I0() {
        return this.B;
    }

    public void I1(float f6) {
        if (this.K != f6) {
            float h02 = h0();
            this.K = f6;
            float h03 = h0();
            invalidateSelf();
            if (h02 != h03) {
                q1();
            }
        }
    }

    public float J0() {
        return this.Y;
    }

    public void J1(int i6) {
        I1(this.f5088g0.getResources().getDimension(i6));
    }

    public ColorStateList K0() {
        return this.D;
    }

    public void K1(ColorStateList colorStateList) {
        this.L = true;
        if (this.J != colorStateList) {
            this.J = colorStateList;
            if (I2()) {
                x.b.o(this.I, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float L0() {
        return this.E;
    }

    public void L1(int i6) {
        K1(e.b.c(this.f5088g0, i6));
    }

    public Drawable M0() {
        Drawable drawable = this.N;
        if (drawable != null) {
            return x.b.q(drawable);
        }
        return null;
    }

    public void M1(int i6) {
        N1(this.f5088g0.getResources().getBoolean(i6));
    }

    public CharSequence N0() {
        return this.R;
    }

    public void N1(boolean z5) {
        if (this.H != z5) {
            boolean I2 = I2();
            this.H = z5;
            boolean I22 = I2();
            if (I2 != I22) {
                if (I22) {
                    f0(this.I);
                } else {
                    K2(this.I);
                }
                invalidateSelf();
                q1();
            }
        }
    }

    public float O0() {
        return this.f5086e0;
    }

    public void O1(float f6) {
        if (this.B != f6) {
            this.B = f6;
            invalidateSelf();
            q1();
        }
    }

    public float P0() {
        return this.Q;
    }

    public void P1(int i6) {
        O1(this.f5088g0.getResources().getDimension(i6));
    }

    public float Q0() {
        return this.f5085d0;
    }

    public void Q1(float f6) {
        if (this.Y != f6) {
            this.Y = f6;
            invalidateSelf();
            q1();
        }
    }

    public int[] R0() {
        return this.B0;
    }

    public void R1(int i6) {
        Q1(this.f5088g0.getResources().getDimension(i6));
    }

    public ColorStateList S0() {
        return this.P;
    }

    public void S1(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            if (this.I0) {
                a0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void T0(RectF rectF) {
        k0(getBounds(), rectF);
    }

    public void T1(int i6) {
        S1(e.b.c(this.f5088g0, i6));
    }

    public void U1(float f6) {
        if (this.E != f6) {
            this.E = f6;
            this.f5089h0.setStrokeWidth(f6);
            if (this.I0) {
                super.b0(f6);
            }
            invalidateSelf();
        }
    }

    public void V1(int i6) {
        U1(this.f5088g0.getResources().getDimension(i6));
    }

    public TextUtils.TruncateAt W0() {
        return this.F0;
    }

    public c X0() {
        return this.X;
    }

    public void X1(Drawable drawable) {
        Drawable M0 = M0();
        if (M0 != drawable) {
            float l02 = l0();
            this.N = drawable != null ? x.b.r(drawable).mutate() : null;
            if (f3.b.f9883a) {
                M2();
            }
            float l03 = l0();
            K2(M0);
            if (J2()) {
                f0(this.N);
            }
            invalidateSelf();
            if (l02 != l03) {
                q1();
            }
        }
    }

    public float Y0() {
        return this.f5082a0;
    }

    public void Y1(CharSequence charSequence) {
        if (this.R != charSequence) {
            this.R = c0.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    public float Z0() {
        return this.Z;
    }

    public void Z1(float f6) {
        if (this.f5086e0 != f6) {
            this.f5086e0 = f6;
            invalidateSelf();
            if (J2()) {
                q1();
            }
        }
    }

    @Override // com.google.android.material.internal.h.b
    public void a() {
        q1();
        invalidateSelf();
    }

    public ColorStateList a1() {
        return this.F;
    }

    public void a2(int i6) {
        Z1(this.f5088g0.getResources().getDimension(i6));
    }

    public c b1() {
        return this.W;
    }

    public void b2(int i6) {
        X1(e.b.d(this.f5088g0, i6));
    }

    public CharSequence c1() {
        return this.G;
    }

    public void c2(float f6) {
        if (this.Q != f6) {
            this.Q = f6;
            invalidateSelf();
            if (J2()) {
                q1();
            }
        }
    }

    public d d1() {
        return this.f5095n0.d();
    }

    public void d2(int i6) {
        c2(this.f5088g0.getResources().getDimension(i6));
    }

    @Override // h3.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i6 = this.f5104w0;
        int a6 = i6 < 255 ? w2.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i6) : 0;
        v0(canvas, bounds);
        s0(canvas, bounds);
        if (this.I0) {
            super.draw(canvas);
        }
        u0(canvas, bounds);
        x0(canvas, bounds);
        t0(canvas, bounds);
        r0(canvas, bounds);
        if (this.G0) {
            z0(canvas, bounds);
        }
        w0(canvas, bounds);
        y0(canvas, bounds);
        if (this.f5104w0 < 255) {
            canvas.restoreToCount(a6);
        }
    }

    public float e1() {
        return this.f5084c0;
    }

    public void e2(float f6) {
        if (this.f5085d0 != f6) {
            this.f5085d0 = f6;
            invalidateSelf();
            if (J2()) {
                q1();
            }
        }
    }

    public float f1() {
        return this.f5083b0;
    }

    public void f2(int i6) {
        e2(this.f5088g0.getResources().getDimension(i6));
    }

    public boolean g2(int[] iArr) {
        if (Arrays.equals(this.B0, iArr)) {
            return false;
        }
        this.B0 = iArr;
        if (J2()) {
            return r1(getState(), iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5104w0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f5105x0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.B;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.Y + h0() + this.f5083b0 + this.f5095n0.f(c1().toString()) + this.f5084c0 + l0() + this.f5087f0), this.H0);
    }

    @Override // h3.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // h3.g, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.I0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.C);
        } else {
            outline.setRoundRect(bounds, this.C);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h0() {
        if (I2() || H2()) {
            return this.Z + V0() + this.f5082a0;
        }
        return 0.0f;
    }

    public boolean h1() {
        return this.C0;
    }

    public void h2(ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            if (J2()) {
                x.b.o(this.N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void i2(int i6) {
        h2(e.b.c(this.f5088g0, i6));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // h3.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return m1(this.f5107z) || m1(this.A) || m1(this.D) || (this.C0 && m1(this.D0)) || o1(this.f5095n0.d()) || p0() || n1(this.I) || n1(this.U) || m1(this.f5108z0);
    }

    public boolean j1() {
        return this.S;
    }

    public void j2(boolean z5) {
        if (this.M != z5) {
            boolean J2 = J2();
            this.M = z5;
            boolean J22 = J2();
            if (J2 != J22) {
                if (J22) {
                    f0(this.N);
                } else {
                    K2(this.N);
                }
                invalidateSelf();
                q1();
            }
        }
    }

    public boolean k1() {
        return n1(this.N);
    }

    public void k2(a aVar) {
        this.E0 = new WeakReference(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l0() {
        if (J2()) {
            return this.f5085d0 + this.Q + this.f5086e0;
        }
        return 0.0f;
    }

    public boolean l1() {
        return this.M;
    }

    public void l2(TextUtils.TruncateAt truncateAt) {
        this.F0 = truncateAt;
    }

    public void m2(c cVar) {
        this.X = cVar;
    }

    public void n2(int i6) {
        m2(c.c(this.f5088g0, i6));
    }

    Paint.Align o0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.G != null) {
            float h02 = this.Y + h0() + this.f5083b0;
            if (x.b.f(this) == 0) {
                pointF.x = rect.left + h02;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - h02;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - n0();
        }
        return align;
    }

    public void o2(float f6) {
        if (this.f5082a0 != f6) {
            float h02 = h0();
            this.f5082a0 = f6;
            float h03 = h0();
            invalidateSelf();
            if (h02 != h03) {
                q1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i6) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i6);
        if (I2()) {
            onLayoutDirectionChanged |= x.b.m(this.I, i6);
        }
        if (H2()) {
            onLayoutDirectionChanged |= x.b.m(this.U, i6);
        }
        if (J2()) {
            onLayoutDirectionChanged |= x.b.m(this.N, i6);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i6) {
        boolean onLevelChange = super.onLevelChange(i6);
        if (I2()) {
            onLevelChange |= this.I.setLevel(i6);
        }
        if (H2()) {
            onLevelChange |= this.U.setLevel(i6);
        }
        if (J2()) {
            onLevelChange |= this.N.setLevel(i6);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // h3.g, android.graphics.drawable.Drawable, com.google.android.material.internal.h.b
    public boolean onStateChange(int[] iArr) {
        if (this.I0) {
            super.onStateChange(iArr);
        }
        return r1(iArr, R0());
    }

    public void p2(int i6) {
        o2(this.f5088g0.getResources().getDimension(i6));
    }

    protected void q1() {
        a aVar = (a) this.E0.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    public void q2(float f6) {
        if (this.Z != f6) {
            float h02 = h0();
            this.Z = f6;
            float h03 = h0();
            invalidateSelf();
            if (h02 != h03) {
                q1();
            }
        }
    }

    public void r2(int i6) {
        q2(this.f5088g0.getResources().getDimension(i6));
    }

    public void s1(boolean z5) {
        if (this.S != z5) {
            this.S = z5;
            float h02 = h0();
            if (!z5 && this.f5102u0) {
                this.f5102u0 = false;
            }
            float h03 = h0();
            invalidateSelf();
            if (h02 != h03) {
                q1();
            }
        }
    }

    public void s2(int i6) {
        this.H0 = i6;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j6) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j6);
        }
    }

    @Override // h3.g, android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        if (this.f5104w0 != i6) {
            this.f5104w0 = i6;
            invalidateSelf();
        }
    }

    @Override // h3.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f5105x0 != colorFilter) {
            this.f5105x0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // h3.g, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f5108z0 != colorStateList) {
            this.f5108z0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // h3.g, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.A0 != mode) {
            this.A0 = mode;
            this.f5106y0 = a3.a.a(this, this.f5108z0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        boolean visible = super.setVisible(z5, z6);
        if (I2()) {
            visible |= this.I.setVisible(z5, z6);
        }
        if (H2()) {
            visible |= this.U.setVisible(z5, z6);
        }
        if (J2()) {
            visible |= this.N.setVisible(z5, z6);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t1(int i6) {
        s1(this.f5088g0.getResources().getBoolean(i6));
    }

    public void t2(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            L2();
            onStateChange(getState());
        }
    }

    public void u1(Drawable drawable) {
        if (this.U != drawable) {
            float h02 = h0();
            this.U = drawable;
            float h03 = h0();
            K2(this.U);
            f0(this.U);
            invalidateSelf();
            if (h02 != h03) {
                q1();
            }
        }
    }

    public void u2(int i6) {
        t2(e.b.c(this.f5088g0, i6));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v1(int i6) {
        u1(e.b.d(this.f5088g0, i6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v2(boolean z5) {
        this.G0 = z5;
    }

    public void w1(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            if (p0()) {
                x.b.o(this.U, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void w2(c cVar) {
        this.W = cVar;
    }

    public void x1(int i6) {
        w1(e.b.c(this.f5088g0, i6));
    }

    public void x2(int i6) {
        w2(c.c(this.f5088g0, i6));
    }

    public void y1(int i6) {
        z1(this.f5088g0.getResources().getBoolean(i6));
    }

    public void y2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (TextUtils.equals(this.G, charSequence)) {
            return;
        }
        this.G = charSequence;
        this.f5095n0.i(true);
        invalidateSelf();
        q1();
    }

    public void z1(boolean z5) {
        if (this.T != z5) {
            boolean H2 = H2();
            this.T = z5;
            boolean H22 = H2();
            if (H2 != H22) {
                if (H22) {
                    f0(this.U);
                } else {
                    K2(this.U);
                }
                invalidateSelf();
                q1();
            }
        }
    }

    public void z2(d dVar) {
        this.f5095n0.h(dVar, this.f5088g0);
    }
}
