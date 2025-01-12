package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import c0.p;
import com.google.android.material.internal.g;
import e0.b0;
import e3.a;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: j0  reason: collision with root package name */
    private static final boolean f5235j0 = false;

    /* renamed from: k0  reason: collision with root package name */
    private static final Paint f5236k0 = null;
    private e3.a A;
    private CharSequence B;
    private CharSequence C;
    private boolean D;
    private boolean F;
    private Bitmap G;
    private Paint H;
    private float I;
    private float J;
    private int[] K;
    private boolean L;
    private final TextPaint M;
    private final TextPaint N;
    private TimeInterpolator O;
    private TimeInterpolator P;
    private float Q;
    private float R;
    private float S;
    private ColorStateList T;
    private float U;
    private float V;
    private float W;
    private ColorStateList X;
    private float Y;
    private float Z;

    /* renamed from: a  reason: collision with root package name */
    private final View f5237a;

    /* renamed from: a0  reason: collision with root package name */
    private StaticLayout f5238a0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5239b;

    /* renamed from: b0  reason: collision with root package name */
    private float f5240b0;

    /* renamed from: c  reason: collision with root package name */
    private float f5241c;

    /* renamed from: c0  reason: collision with root package name */
    private float f5242c0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5243d;

    /* renamed from: d0  reason: collision with root package name */
    private float f5244d0;

    /* renamed from: e  reason: collision with root package name */
    private float f5245e;

    /* renamed from: e0  reason: collision with root package name */
    private CharSequence f5246e0;

    /* renamed from: f  reason: collision with root package name */
    private float f5247f;

    /* renamed from: g  reason: collision with root package name */
    private int f5249g;

    /* renamed from: h  reason: collision with root package name */
    private final Rect f5251h;

    /* renamed from: i  reason: collision with root package name */
    private final Rect f5253i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f5255j;

    /* renamed from: o  reason: collision with root package name */
    private ColorStateList f5260o;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f5261p;

    /* renamed from: q  reason: collision with root package name */
    private float f5262q;

    /* renamed from: r  reason: collision with root package name */
    private float f5263r;

    /* renamed from: s  reason: collision with root package name */
    private float f5264s;

    /* renamed from: t  reason: collision with root package name */
    private float f5265t;

    /* renamed from: u  reason: collision with root package name */
    private float f5266u;

    /* renamed from: v  reason: collision with root package name */
    private float f5267v;

    /* renamed from: w  reason: collision with root package name */
    private Typeface f5268w;

    /* renamed from: x  reason: collision with root package name */
    private Typeface f5269x;

    /* renamed from: y  reason: collision with root package name */
    private Typeface f5270y;

    /* renamed from: z  reason: collision with root package name */
    private e3.a f5271z;

    /* renamed from: k  reason: collision with root package name */
    private int f5256k = 16;

    /* renamed from: l  reason: collision with root package name */
    private int f5257l = 16;

    /* renamed from: m  reason: collision with root package name */
    private float f5258m = 15.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f5259n = 15.0f;
    private boolean E = true;

    /* renamed from: f0  reason: collision with root package name */
    private int f5248f0 = 1;

    /* renamed from: g0  reason: collision with root package name */
    private float f5250g0 = 0.0f;

    /* renamed from: h0  reason: collision with root package name */
    private float f5252h0 = 1.0f;

    /* renamed from: i0  reason: collision with root package name */
    private int f5254i0 = g.f5285n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.internal.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0048a implements a.InterfaceC0160a {
        C0048a() {
        }

        @Override // e3.a.InterfaceC0160a
        public void a(Typeface typeface) {
            a.this.R(typeface);
        }
    }

    public a(View view) {
        this.f5237a = view;
        TextPaint textPaint = new TextPaint(129);
        this.M = textPaint;
        this.N = new TextPaint(textPaint);
        this.f5253i = new Rect();
        this.f5251h = new Rect();
        this.f5255j = new RectF();
        this.f5247f = f();
    }

    private void A(TextPaint textPaint) {
        textPaint.setTextSize(this.f5258m);
        textPaint.setTypeface(this.f5269x);
        textPaint.setLetterSpacing(this.Z);
    }

    private void B(float f6) {
        if (this.f5243d) {
            this.f5255j.set(f6 < this.f5247f ? this.f5251h : this.f5253i);
            return;
        }
        this.f5255j.left = G(this.f5251h.left, this.f5253i.left, f6, this.O);
        this.f5255j.top = G(this.f5262q, this.f5263r, f6, this.O);
        this.f5255j.right = G(this.f5251h.right, this.f5253i.right, f6, this.O);
        this.f5255j.bottom = G(this.f5251h.bottom, this.f5253i.bottom, f6, this.O);
    }

    private static boolean C(float f6, float f7) {
        return Math.abs(f6 - f7) < 0.001f;
    }

    private boolean D() {
        return b0.B(this.f5237a) == 1;
    }

    private boolean F(CharSequence charSequence, boolean z5) {
        return (z5 ? p.f3123d : p.f3122c).a(charSequence, 0, charSequence.length());
    }

    private static float G(float f6, float f7, float f8, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f8 = timeInterpolator.getInterpolation(f8);
        }
        return v2.a.a(f6, f7, f8);
    }

    private static boolean K(Rect rect, int i6, int i7, int i8, int i9) {
        return rect.left == i6 && rect.top == i7 && rect.right == i8 && rect.bottom == i9;
    }

    private void O(float f6) {
        this.f5240b0 = f6;
        b0.c0(this.f5237a);
    }

    private boolean S(Typeface typeface) {
        e3.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f5268w != typeface) {
            this.f5268w = typeface;
            return true;
        }
        return false;
    }

    private void V(float f6) {
        this.f5242c0 = f6;
        b0.c0(this.f5237a);
    }

    private boolean Z(Typeface typeface) {
        e3.a aVar = this.f5271z;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f5269x != typeface) {
            this.f5269x = typeface;
            return true;
        }
        return false;
    }

    private static int a(int i6, int i7, float f6) {
        float f7 = 1.0f - f6;
        return Color.argb((int) ((Color.alpha(i6) * f7) + (Color.alpha(i7) * f6)), (int) ((Color.red(i6) * f7) + (Color.red(i7) * f6)), (int) ((Color.green(i6) * f7) + (Color.green(i7) * f6)), (int) ((Color.blue(i6) * f7) + (Color.blue(i7) * f6)));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(boolean z5) {
        float f6;
        int i6;
        float centerX;
        StaticLayout staticLayout;
        float measureText;
        StaticLayout staticLayout2;
        int i7;
        int i8;
        float centerX2;
        float f7;
        StaticLayout staticLayout3;
        float f8 = this.J;
        j(this.f5259n, z5);
        CharSequence charSequence = this.C;
        if (charSequence != null && (staticLayout3 = this.f5238a0) != null) {
            this.f5246e0 = TextUtils.ellipsize(charSequence, this.M, staticLayout3.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.f5246e0;
        float measureText2 = charSequence2 != null ? this.M.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int b6 = e0.d.b(this.f5257l, this.D ? 1 : 0);
        int i9 = b6 & 112;
        if (i9 == 48) {
            f6 = this.f5253i.top;
        } else if (i9 != 80) {
            this.f5263r = this.f5253i.centerY() - ((this.M.descent() - this.M.ascent()) / 2.0f);
            i6 = b6 & 8388615;
            if (i6 != 1) {
                centerX = this.f5253i.centerX();
                measureText2 /= 2.0f;
            } else if (i6 != 5) {
                this.f5265t = this.f5253i.left;
                j(this.f5258m, z5);
                float height = this.f5238a0 != null ? staticLayout.getHeight() : 0.0f;
                CharSequence charSequence3 = this.C;
                measureText = charSequence3 != null ? this.M.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
                staticLayout2 = this.f5238a0;
                if (staticLayout2 != null && this.f5248f0 > 1) {
                    measureText = staticLayout2.getWidth();
                }
                StaticLayout staticLayout4 = this.f5238a0;
                this.f5244d0 = staticLayout4 != null ? this.f5248f0 > 1 ? staticLayout4.getLineStart(0) : staticLayout4.getLineLeft(0) : 0.0f;
                int b7 = e0.d.b(this.f5256k, this.D ? 1 : 0);
                i7 = b7 & 112;
                if (i7 != 48) {
                    this.f5262q = i7 != 80 ? this.f5251h.centerY() - (height / 2.0f) : (this.f5251h.bottom - height) + this.M.descent();
                } else {
                    this.f5262q = this.f5251h.top;
                }
                i8 = b7 & 8388615;
                if (i8 == 1) {
                    centerX2 = this.f5251h.centerX();
                    measureText /= 2.0f;
                } else if (i8 != 5) {
                    f7 = this.f5251h.left;
                    this.f5264s = f7;
                    k();
                    b0(f8);
                } else {
                    centerX2 = this.f5251h.right;
                }
                f7 = centerX2 - measureText;
                this.f5264s = f7;
                k();
                b0(f8);
            } else {
                centerX = this.f5253i.right;
            }
            this.f5265t = centerX - measureText2;
            j(this.f5258m, z5);
            if (this.f5238a0 != null) {
            }
            CharSequence charSequence32 = this.C;
            if (charSequence32 != null) {
            }
            staticLayout2 = this.f5238a0;
            if (staticLayout2 != null) {
                measureText = staticLayout2.getWidth();
            }
            StaticLayout staticLayout42 = this.f5238a0;
            this.f5244d0 = staticLayout42 != null ? this.f5248f0 > 1 ? staticLayout42.getLineStart(0) : staticLayout42.getLineLeft(0) : 0.0f;
            int b72 = e0.d.b(this.f5256k, this.D ? 1 : 0);
            i7 = b72 & 112;
            if (i7 != 48) {
            }
            i8 = b72 & 8388615;
            if (i8 == 1) {
            }
            f7 = centerX2 - measureText;
            this.f5264s = f7;
            k();
            b0(f8);
        } else {
            f6 = this.f5253i.bottom + this.M.ascent();
        }
        this.f5263r = f6;
        i6 = b6 & 8388615;
        if (i6 != 1) {
        }
        this.f5265t = centerX - measureText2;
        j(this.f5258m, z5);
        if (this.f5238a0 != null) {
        }
        CharSequence charSequence322 = this.C;
        if (charSequence322 != null) {
        }
        staticLayout2 = this.f5238a0;
        if (staticLayout2 != null) {
        }
        StaticLayout staticLayout422 = this.f5238a0;
        this.f5244d0 = staticLayout422 != null ? this.f5248f0 > 1 ? staticLayout422.getLineStart(0) : staticLayout422.getLineLeft(0) : 0.0f;
        int b722 = e0.d.b(this.f5256k, this.D ? 1 : 0);
        i7 = b722 & 112;
        if (i7 != 48) {
        }
        i8 = b722 & 8388615;
        if (i8 == 1) {
        }
        f7 = centerX2 - measureText;
        this.f5264s = f7;
        k();
        b0(f8);
    }

    private void b0(float f6) {
        i(f6);
        boolean z5 = f5235j0 && this.I != 1.0f;
        this.F = z5;
        if (z5) {
            o();
        }
        b0.c0(this.f5237a);
    }

    private void d() {
        h(this.f5241c);
    }

    private float e(float f6) {
        float f7 = this.f5247f;
        return f6 <= f7 ? v2.a.b(1.0f, 0.0f, this.f5245e, f7, f6) : v2.a.b(0.0f, 1.0f, f7, 1.0f, f6);
    }

    private float f() {
        float f6 = this.f5245e;
        return f6 + ((1.0f - f6) * 0.5f);
    }

    private boolean g(CharSequence charSequence) {
        boolean D = D();
        return this.E ? F(charSequence, D) : D;
    }

    private void h(float f6) {
        float f7;
        B(f6);
        if (!this.f5243d) {
            this.f5266u = G(this.f5264s, this.f5265t, f6, this.O);
            this.f5267v = G(this.f5262q, this.f5263r, f6, this.O);
            b0(G(this.f5258m, this.f5259n, f6, this.P));
            f7 = f6;
        } else if (f6 < this.f5247f) {
            this.f5266u = this.f5264s;
            this.f5267v = this.f5262q;
            b0(this.f5258m);
            f7 = 0.0f;
        } else {
            this.f5266u = this.f5265t;
            this.f5267v = this.f5263r - Math.max(0, this.f5249g);
            b0(this.f5259n);
            f7 = 1.0f;
        }
        TimeInterpolator timeInterpolator = v2.a.f13674b;
        O(1.0f - G(0.0f, 1.0f, 1.0f - f6, timeInterpolator));
        V(G(1.0f, 0.0f, f6, timeInterpolator));
        if (this.f5261p != this.f5260o) {
            this.M.setColor(a(w(), u(), f7));
        } else {
            this.M.setColor(u());
        }
        float f8 = this.Y;
        float f9 = this.Z;
        if (f8 != f9) {
            this.M.setLetterSpacing(G(f9, f8, f6, timeInterpolator));
        } else {
            this.M.setLetterSpacing(f8);
        }
        this.M.setShadowLayer(G(this.U, this.Q, f6, null), G(this.V, this.R, f6, null), G(this.W, this.S, f6, null), a(v(this.X), v(this.T), f6));
        if (this.f5243d) {
            this.M.setAlpha((int) (e(f6) * 255.0f));
        }
        b0.c0(this.f5237a);
    }

    private boolean h0() {
        return this.f5248f0 > 1 && (!this.D || this.f5243d) && !this.F;
    }

    private void i(float f6) {
        j(f6, false);
    }

    private void j(float f6, boolean z5) {
        boolean z6;
        float f7;
        boolean z7;
        if (this.B == null) {
            return;
        }
        float width = this.f5253i.width();
        float width2 = this.f5251h.width();
        if (C(f6, this.f5259n)) {
            f7 = this.f5259n;
            this.I = 1.0f;
            Typeface typeface = this.f5270y;
            Typeface typeface2 = this.f5268w;
            if (typeface != typeface2) {
                this.f5270y = typeface2;
                z7 = true;
            } else {
                z7 = false;
            }
        } else {
            float f8 = this.f5258m;
            Typeface typeface3 = this.f5270y;
            Typeface typeface4 = this.f5269x;
            if (typeface3 != typeface4) {
                this.f5270y = typeface4;
                z6 = true;
            } else {
                z6 = false;
            }
            if (C(f6, f8)) {
                this.I = 1.0f;
            } else {
                this.I = f6 / this.f5258m;
            }
            float f9 = this.f5259n / this.f5258m;
            width = (!z5 && width2 * f9 > width) ? Math.min(width / f9, width2) : width2;
            f7 = f8;
            z7 = z6;
        }
        if (width > 0.0f) {
            z7 = this.J != f7 || this.L || z7;
            this.J = f7;
            this.L = false;
        }
        if (this.C == null || z7) {
            this.M.setTextSize(this.J);
            this.M.setTypeface(this.f5270y);
            this.M.setLinearText(this.I != 1.0f);
            this.D = g(this.B);
            StaticLayout l6 = l(h0() ? this.f5248f0 : 1, width, this.D);
            this.f5238a0 = l6;
            this.C = l6.getText();
        }
    }

    private void k() {
        Bitmap bitmap = this.G;
        if (bitmap != null) {
            bitmap.recycle();
            this.G = null;
        }
    }

    private StaticLayout l(int i6, float f6, boolean z5) {
        StaticLayout staticLayout;
        try {
            staticLayout = g.c(this.B, this.M, (int) f6).e(TextUtils.TruncateAt.END).h(z5).d(Layout.Alignment.ALIGN_NORMAL).g(false).j(i6).i(this.f5250g0, this.f5252h0).f(this.f5254i0).a();
        } catch (g.a e6) {
            Log.e("CollapsingTextHelper", e6.getCause().getMessage(), e6);
            staticLayout = null;
        }
        return (StaticLayout) d0.i.c(staticLayout);
    }

    private void n(Canvas canvas, float f6, float f7) {
        int alpha = this.M.getAlpha();
        canvas.translate(f6, f7);
        float f8 = alpha;
        this.M.setAlpha((int) (this.f5242c0 * f8));
        this.f5238a0.draw(canvas);
        this.M.setAlpha((int) (this.f5240b0 * f8));
        int lineBaseline = this.f5238a0.getLineBaseline(0);
        CharSequence charSequence = this.f5246e0;
        float f9 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f9, this.M);
        if (this.f5243d) {
            return;
        }
        String trim = this.f5246e0.toString().trim();
        if (trim.endsWith("…")) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.M.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f5238a0.getLineEnd(0), str.length()), 0.0f, f9, (Paint) this.M);
    }

    private void o() {
        if (this.G != null || this.f5251h.isEmpty() || TextUtils.isEmpty(this.C)) {
            return;
        }
        h(0.0f);
        int width = this.f5238a0.getWidth();
        int height = this.f5238a0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.G = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f5238a0.draw(new Canvas(this.G));
        if (this.H == null) {
            this.H = new Paint(3);
        }
    }

    private float s(int i6, int i7) {
        return (i7 == 17 || (i7 & 7) == 1) ? (i6 / 2.0f) - (c() / 2.0f) : ((i7 & 8388613) == 8388613 || (i7 & 5) == 5) ? this.D ? this.f5253i.left : this.f5253i.right - c() : this.D ? this.f5253i.right - c() : this.f5253i.left;
    }

    private float t(RectF rectF, int i6, int i7) {
        return (i7 == 17 || (i7 & 7) == 1) ? (i6 / 2.0f) + (c() / 2.0f) : ((i7 & 8388613) == 8388613 || (i7 & 5) == 5) ? this.D ? rectF.left + c() : this.f5253i.right : this.D ? this.f5253i.right : rectF.left + c();
    }

    private int v(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.K;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private int w() {
        return v(this.f5260o);
    }

    private void z(TextPaint textPaint) {
        textPaint.setTextSize(this.f5259n);
        textPaint.setTypeface(this.f5268w);
        textPaint.setLetterSpacing(this.Y);
    }

    public final boolean E() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f5261p;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f5260o) != null && colorStateList.isStateful());
    }

    void H() {
        this.f5239b = this.f5253i.width() > 0 && this.f5253i.height() > 0 && this.f5251h.width() > 0 && this.f5251h.height() > 0;
    }

    public void I() {
        J(false);
    }

    public void J(boolean z5) {
        if ((this.f5237a.getHeight() <= 0 || this.f5237a.getWidth() <= 0) && !z5) {
            return;
        }
        b(z5);
        d();
    }

    public void L(int i6, int i7, int i8, int i9) {
        if (K(this.f5253i, i6, i7, i8, i9)) {
            return;
        }
        this.f5253i.set(i6, i7, i8, i9);
        this.L = true;
        H();
    }

    public void M(Rect rect) {
        L(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void N(int i6) {
        e3.d dVar = new e3.d(this.f5237a.getContext(), i6);
        ColorStateList colorStateList = dVar.f9488a;
        if (colorStateList != null) {
            this.f5261p = colorStateList;
        }
        float f6 = dVar.f9501n;
        if (f6 != 0.0f) {
            this.f5259n = f6;
        }
        ColorStateList colorStateList2 = dVar.f9491d;
        if (colorStateList2 != null) {
            this.T = colorStateList2;
        }
        this.R = dVar.f9496i;
        this.S = dVar.f9497j;
        this.Q = dVar.f9498k;
        this.Y = dVar.f9500m;
        e3.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
        this.A = new e3.a(new C0048a(), dVar.e());
        dVar.h(this.f5237a.getContext(), this.A);
        I();
    }

    public void P(ColorStateList colorStateList) {
        if (this.f5261p != colorStateList) {
            this.f5261p = colorStateList;
            I();
        }
    }

    public void Q(int i6) {
        if (this.f5257l != i6) {
            this.f5257l = i6;
            I();
        }
    }

    public void R(Typeface typeface) {
        if (S(typeface)) {
            I();
        }
    }

    public void T(int i6, int i7, int i8, int i9) {
        if (K(this.f5251h, i6, i7, i8, i9)) {
            return;
        }
        this.f5251h.set(i6, i7, i8, i9);
        this.L = true;
        H();
    }

    public void U(Rect rect) {
        T(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void W(ColorStateList colorStateList) {
        if (this.f5260o != colorStateList) {
            this.f5260o = colorStateList;
            I();
        }
    }

    public void X(int i6) {
        if (this.f5256k != i6) {
            this.f5256k = i6;
            I();
        }
    }

    public void Y(float f6) {
        if (this.f5258m != f6) {
            this.f5258m = f6;
            I();
        }
    }

    public void a0(float f6) {
        float a6 = z.a.a(f6, 0.0f, 1.0f);
        if (a6 != this.f5241c) {
            this.f5241c = a6;
            d();
        }
    }

    public float c() {
        if (this.B == null) {
            return 0.0f;
        }
        z(this.N);
        TextPaint textPaint = this.N;
        CharSequence charSequence = this.B;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void c0(TimeInterpolator timeInterpolator) {
        this.O = timeInterpolator;
        I();
    }

    public final boolean d0(int[] iArr) {
        this.K = iArr;
        if (E()) {
            I();
            return true;
        }
        return false;
    }

    public void e0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.B, charSequence)) {
            this.B = charSequence;
            this.C = null;
            k();
            I();
        }
    }

    public void f0(TimeInterpolator timeInterpolator) {
        this.P = timeInterpolator;
        I();
    }

    public void g0(Typeface typeface) {
        boolean S = S(typeface);
        boolean Z = Z(typeface);
        if (S || Z) {
            I();
        }
    }

    public void m(Canvas canvas) {
        int save = canvas.save();
        if (this.C == null || !this.f5239b) {
            return;
        }
        boolean z5 = true;
        float lineStart = (this.f5266u + (this.f5248f0 > 1 ? this.f5238a0.getLineStart(0) : this.f5238a0.getLineLeft(0))) - (this.f5244d0 * 2.0f);
        this.M.setTextSize(this.J);
        float f6 = this.f5266u;
        float f7 = this.f5267v;
        z5 = (!this.F || this.G == null) ? false : false;
        float f8 = this.I;
        if (f8 != 1.0f && !this.f5243d) {
            canvas.scale(f8, f8, f6, f7);
        }
        if (z5) {
            canvas.drawBitmap(this.G, f6, f7, this.H);
            canvas.restoreToCount(save);
            return;
        }
        if (!h0() || (this.f5243d && this.f5241c <= this.f5247f)) {
            canvas.translate(f6, f7);
            this.f5238a0.draw(canvas);
        } else {
            n(canvas, lineStart, f7);
        }
        canvas.restoreToCount(save);
    }

    public void p(RectF rectF, int i6, int i7) {
        this.D = g(this.B);
        rectF.left = s(i6, i7);
        rectF.top = this.f5253i.top;
        rectF.right = t(rectF, i6, i7);
        rectF.bottom = this.f5253i.top + r();
    }

    public ColorStateList q() {
        return this.f5261p;
    }

    public float r() {
        z(this.N);
        return -this.N.ascent();
    }

    public int u() {
        return v(this.f5261p);
    }

    public float x() {
        A(this.N);
        return -this.N.ascent();
    }

    public float y() {
        return this.f5241c;
    }
}
