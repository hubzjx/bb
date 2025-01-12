package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
final class f {
    private int A;
    private int B;
    private int C;
    private int D;
    private StaticLayout E;
    private StaticLayout F;
    private int G;
    private int H;
    private int I;
    private Rect J;

    /* renamed from: a  reason: collision with root package name */
    private final float f4543a;

    /* renamed from: b  reason: collision with root package name */
    private final float f4544b;

    /* renamed from: c  reason: collision with root package name */
    private final float f4545c;

    /* renamed from: d  reason: collision with root package name */
    private final float f4546d;

    /* renamed from: e  reason: collision with root package name */
    private final float f4547e;

    /* renamed from: f  reason: collision with root package name */
    private final TextPaint f4548f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f4549g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f4550h;

    /* renamed from: i  reason: collision with root package name */
    private CharSequence f4551i;

    /* renamed from: j  reason: collision with root package name */
    private Layout.Alignment f4552j;

    /* renamed from: k  reason: collision with root package name */
    private Bitmap f4553k;

    /* renamed from: l  reason: collision with root package name */
    private float f4554l;

    /* renamed from: m  reason: collision with root package name */
    private int f4555m;

    /* renamed from: n  reason: collision with root package name */
    private int f4556n;

    /* renamed from: o  reason: collision with root package name */
    private float f4557o;

    /* renamed from: p  reason: collision with root package name */
    private int f4558p;

    /* renamed from: q  reason: collision with root package name */
    private float f4559q;

    /* renamed from: r  reason: collision with root package name */
    private float f4560r;

    /* renamed from: s  reason: collision with root package name */
    private int f4561s;

    /* renamed from: t  reason: collision with root package name */
    private int f4562t;

    /* renamed from: u  reason: collision with root package name */
    private int f4563u;

    /* renamed from: v  reason: collision with root package name */
    private int f4564v;

    /* renamed from: w  reason: collision with root package name */
    private int f4565w;

    /* renamed from: x  reason: collision with root package name */
    private float f4566x;

    /* renamed from: y  reason: collision with root package name */
    private float f4567y;

    /* renamed from: z  reason: collision with root package name */
    private float f4568z;

    public f(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.f4547e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f4546d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f4543a = round;
        this.f4544b = round;
        this.f4545c = round;
        TextPaint textPaint = new TextPaint();
        this.f4548f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f4549g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f4550h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    private void c(Canvas canvas) {
        canvas.drawBitmap(this.f4553k, (Rect) null, this.J, this.f4550h);
    }

    private void d(Canvas canvas, boolean z5) {
        if (z5) {
            e(canvas);
            return;
        }
        com.google.android.exoplayer2.util.a.e(this.J);
        com.google.android.exoplayer2.util.a.e(this.f4553k);
        c(canvas);
    }

    private void e(Canvas canvas) {
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f4563u) > 0) {
            this.f4549g.setColor(this.f4563u);
            canvas.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.f4549g);
        }
        int i6 = this.f4565w;
        if (i6 == 1) {
            this.f4548f.setStrokeJoin(Paint.Join.ROUND);
            this.f4548f.setStrokeWidth(this.f4543a);
            this.f4548f.setColor(this.f4564v);
            this.f4548f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i6 == 2) {
            TextPaint textPaint = this.f4548f;
            float f6 = this.f4544b;
            float f7 = this.f4545c;
            textPaint.setShadowLayer(f6, f7, f7, this.f4564v);
        } else if (i6 == 3 || i6 == 4) {
            boolean z5 = i6 == 3;
            int i7 = z5 ? -1 : this.f4564v;
            int i8 = z5 ? this.f4564v : -1;
            float f8 = this.f4544b / 2.0f;
            this.f4548f.setColor(this.f4561s);
            this.f4548f.setStyle(Paint.Style.FILL);
            float f9 = -f8;
            this.f4548f.setShadowLayer(this.f4544b, f9, f9, i7);
            staticLayout2.draw(canvas);
            this.f4548f.setShadowLayer(this.f4544b, f8, f8, i8);
        }
        this.f4548f.setColor(this.f4561s);
        this.f4548f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f4548f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(save);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f() {
        float f6;
        int i6;
        float f7;
        Bitmap bitmap = this.f4553k;
        int i7 = this.C;
        int i8 = this.A;
        int i9 = this.D;
        int i10 = this.B;
        float f8 = i7 - i8;
        float f9 = i8 + (this.f4557o * f8);
        float f10 = i9 - i10;
        float f11 = i10 + (this.f4554l * f10);
        int round = Math.round(f8 * this.f4559q);
        float f12 = this.f4560r;
        if (f12 == -3.4028235E38f) {
            f10 = round;
            f12 = bitmap.getHeight() / bitmap.getWidth();
        }
        int round2 = Math.round(f10 * f12);
        int i11 = this.f4558p;
        if (i11 != 2) {
            if (i11 == 1) {
                f6 = round / 2;
            }
            int round3 = Math.round(f9);
            i6 = this.f4556n;
            if (i6 == 2) {
                if (i6 == 1) {
                    f7 = round2 / 2;
                }
                int round4 = Math.round(f11);
                this.J = new Rect(round3, round4, round + round3, round2 + round4);
            }
            f7 = round2;
            f11 -= f7;
            int round42 = Math.round(f11);
            this.J = new Rect(round3, round42, round + round3, round2 + round42);
        }
        f6 = round;
        f9 -= f6;
        int round32 = Math.round(f9);
        i6 = this.f4556n;
        if (i6 == 2) {
        }
        f11 -= f7;
        int round422 = Math.round(f11);
        this.J = new Rect(round32, round422, round + round32, round2 + round422);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g() {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        CharSequence charSequence = this.f4551i;
        SpannableStringBuilder spannableStringBuilder = charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : new SpannableStringBuilder(this.f4551i);
        int i14 = this.C - this.A;
        int i15 = this.D - this.B;
        this.f4548f.setTextSize(this.f4566x);
        int i16 = (int) ((this.f4566x * 0.125f) + 0.5f);
        int i17 = i16 * 2;
        int i18 = i14 - i17;
        float f6 = this.f4559q;
        if (f6 != -3.4028235E38f) {
            i18 = (int) (i18 * f6);
        }
        int i19 = i18;
        if (i19 <= 0) {
            n.h("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.f4567y > 0.0f) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) this.f4567y), 0, spannableStringBuilder.length(), 16711680);
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        if (this.f4565w == 1) {
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), ForegroundColorSpan.class)) {
                spannableStringBuilder2.removeSpan(foregroundColorSpan);
            }
        }
        if (Color.alpha(this.f4562t) > 0) {
            int i20 = this.f4565w;
            if (i20 == 0 || i20 == 2) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f4562t), 0, spannableStringBuilder.length(), 16711680);
            } else {
                spannableStringBuilder2.setSpan(new BackgroundColorSpan(this.f4562t), 0, spannableStringBuilder2.length(), 16711680);
            }
        }
        Layout.Alignment alignment = this.f4552j;
        if (alignment == null) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, this.f4548f, i19, alignment2, this.f4546d, this.f4547e, true);
        this.E = staticLayout;
        int height = staticLayout.getHeight();
        int lineCount = this.E.getLineCount();
        int i21 = 0;
        for (int i22 = 0; i22 < lineCount; i22++) {
            i21 = Math.max((int) Math.ceil(this.E.getLineWidth(i22)), i21);
        }
        if (this.f4559q == -3.4028235E38f || i21 >= i19) {
            i19 = i21;
        }
        int i23 = i19 + i17;
        float f7 = this.f4557o;
        if (f7 != -3.4028235E38f) {
            int round = Math.round(i14 * f7);
            int i24 = this.A;
            int i25 = round + i24;
            int i26 = this.f4558p;
            i6 = 1;
            i7 = 2;
            if (i26 == 1) {
                i25 = ((i25 * 2) - i23) / 2;
            } else if (i26 == 2) {
                i25 -= i23;
            }
            i8 = Math.max(i25, i24);
            i9 = Math.min(i23 + i8, this.C);
        } else {
            i6 = 1;
            i7 = 2;
            i8 = ((i14 - i23) / 2) + this.A;
            i9 = i8 + i23;
        }
        int i27 = i9 - i8;
        if (i27 <= 0) {
            n.h("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f8 = this.f4554l;
        if (f8 == -3.4028235E38f) {
            i10 = (this.D - height) - ((int) (i15 * this.f4568z));
        } else if (this.f4555m == 0) {
            i10 = Math.round(i15 * f8) + this.B;
            int i28 = this.f4556n;
            if (i28 != i7) {
                if (i28 == i6) {
                    i10 = ((i10 * 2) - height) / i7;
                }
                i12 = i10 + height;
                i13 = this.D;
                if (i12 <= i13) {
                    i10 = i13 - height;
                } else {
                    int i29 = this.B;
                    if (i10 < i29) {
                        i11 = i29;
                        this.E = new StaticLayout(spannableStringBuilder, this.f4548f, i27, alignment2, this.f4546d, this.f4547e, true);
                        this.F = new StaticLayout(spannableStringBuilder2, this.f4548f, i27, alignment2, this.f4546d, this.f4547e, true);
                        this.G = i8;
                        this.H = i11;
                        this.I = i16;
                    }
                }
            }
            i10 -= height;
            i12 = i10 + height;
            i13 = this.D;
            if (i12 <= i13) {
            }
        } else {
            int lineBottom = this.E.getLineBottom(0) - this.E.getLineTop(0);
            float f9 = this.f4554l;
            if (f9 >= 0.0f) {
                i10 = Math.round(f9 * lineBottom) + this.B;
                i12 = i10 + height;
                i13 = this.D;
                if (i12 <= i13) {
                }
            } else {
                i10 = Math.round((f9 + 1.0f) * lineBottom) + this.D;
                i10 -= height;
                i12 = i10 + height;
                i13 = this.D;
                if (i12 <= i13) {
                }
            }
        }
        i11 = i10;
        this.E = new StaticLayout(spannableStringBuilder, this.f4548f, i27, alignment2, this.f4546d, this.f4547e, true);
        this.F = new StaticLayout(spannableStringBuilder2, this.f4548f, i27, alignment2, this.f4546d, this.f4547e, true);
        this.G = i8;
        this.H = i11;
        this.I = i16;
    }

    public void b(e2.b bVar, e2.a aVar, float f6, float f7, float f8, Canvas canvas, int i6, int i7, int i8, int i9) {
        int i10;
        boolean z5 = bVar.f9438c == null;
        if (!z5) {
            i10 = -16777216;
        } else if (TextUtils.isEmpty(bVar.f9436a)) {
            return;
        } else {
            i10 = bVar.f9446k ? bVar.f9447l : aVar.f9431c;
        }
        if (a(this.f4551i, bVar.f9436a) && s0.c(this.f4552j, bVar.f9437b) && this.f4553k == bVar.f9438c && this.f4554l == bVar.f9439d && this.f4555m == bVar.f9440e && s0.c(Integer.valueOf(this.f4556n), Integer.valueOf(bVar.f9441f)) && this.f4557o == bVar.f9442g && s0.c(Integer.valueOf(this.f4558p), Integer.valueOf(bVar.f9443h)) && this.f4559q == bVar.f9444i && this.f4560r == bVar.f9445j && this.f4561s == aVar.f9429a && this.f4562t == aVar.f9430b && this.f4563u == i10 && this.f4565w == aVar.f9432d && this.f4564v == aVar.f9433e && s0.c(this.f4548f.getTypeface(), aVar.f9434f) && this.f4566x == f6 && this.f4567y == f7 && this.f4568z == f8 && this.A == i6 && this.B == i7 && this.C == i8 && this.D == i9) {
            d(canvas, z5);
            return;
        }
        this.f4551i = bVar.f9436a;
        this.f4552j = bVar.f9437b;
        this.f4553k = bVar.f9438c;
        this.f4554l = bVar.f9439d;
        this.f4555m = bVar.f9440e;
        this.f4556n = bVar.f9441f;
        this.f4557o = bVar.f9442g;
        this.f4558p = bVar.f9443h;
        this.f4559q = bVar.f9444i;
        this.f4560r = bVar.f9445j;
        this.f4561s = aVar.f9429a;
        this.f4562t = aVar.f9430b;
        this.f4563u = i10;
        this.f4565w = aVar.f9432d;
        this.f4564v = aVar.f9433e;
        this.f4548f.setTypeface(aVar.f9434f);
        this.f4566x = f6;
        this.f4567y = f7;
        this.f4568z = f8;
        this.A = i6;
        this.B = i7;
        this.C = i8;
        this.D = i9;
        if (z5) {
            com.google.android.exoplayer2.util.a.e(this.f4551i);
            g();
        } else {
            com.google.android.exoplayer2.util.a.e(this.f4553k);
            f();
        }
        d(canvas, z5);
    }
}
