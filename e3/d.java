package e3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import u2.j;
import v.f;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f9488a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f9489b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f9490c;

    /* renamed from: d  reason: collision with root package name */
    public final ColorStateList f9491d;

    /* renamed from: e  reason: collision with root package name */
    public final String f9492e;

    /* renamed from: f  reason: collision with root package name */
    public final int f9493f;

    /* renamed from: g  reason: collision with root package name */
    public final int f9494g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f9495h;

    /* renamed from: i  reason: collision with root package name */
    public final float f9496i;

    /* renamed from: j  reason: collision with root package name */
    public final float f9497j;

    /* renamed from: k  reason: collision with root package name */
    public final float f9498k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f9499l;

    /* renamed from: m  reason: collision with root package name */
    public final float f9500m;

    /* renamed from: n  reason: collision with root package name */
    public float f9501n;

    /* renamed from: o  reason: collision with root package name */
    private final int f9502o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f9503p = false;

    /* renamed from: q  reason: collision with root package name */
    private Typeface f9504q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends f.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f9505a;

        a(f fVar) {
            this.f9505a = fVar;
        }

        @Override // v.f.a
        public void d(int i6) {
            d.this.f9503p = true;
            this.f9505a.a(i6);
        }

        @Override // v.f.a
        public void e(Typeface typeface) {
            d dVar = d.this;
            dVar.f9504q = Typeface.create(typeface, dVar.f9493f);
            d.this.f9503p = true;
            this.f9505a.b(d.this.f9504q, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextPaint f9507a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f9508b;

        b(TextPaint textPaint, f fVar) {
            this.f9507a = textPaint;
            this.f9508b = fVar;
        }

        @Override // e3.f
        public void a(int i6) {
            this.f9508b.a(i6);
        }

        @Override // e3.f
        public void b(Typeface typeface, boolean z5) {
            d.this.l(this.f9507a, typeface);
            this.f9508b.b(typeface, z5);
        }
    }

    public d(Context context, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i6, j.f13532n4);
        this.f9501n = obtainStyledAttributes.getDimension(j.f13538o4, 0.0f);
        this.f9488a = c.a(context, obtainStyledAttributes, j.f13556r4);
        this.f9489b = c.a(context, obtainStyledAttributes, j.f13562s4);
        this.f9490c = c.a(context, obtainStyledAttributes, j.f13568t4);
        this.f9493f = obtainStyledAttributes.getInt(j.f13550q4, 0);
        this.f9494g = obtainStyledAttributes.getInt(j.f13544p4, 1);
        int e6 = c.e(obtainStyledAttributes, j.f13604z4, j.f13598y4);
        this.f9502o = obtainStyledAttributes.getResourceId(e6, 0);
        this.f9492e = obtainStyledAttributes.getString(e6);
        this.f9495h = obtainStyledAttributes.getBoolean(j.A4, false);
        this.f9491d = c.a(context, obtainStyledAttributes, j.f13574u4);
        this.f9496i = obtainStyledAttributes.getFloat(j.f13580v4, 0.0f);
        this.f9497j = obtainStyledAttributes.getFloat(j.f13586w4, 0.0f);
        this.f9498k = obtainStyledAttributes.getFloat(j.f13592x4, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i6, j.S2);
        int i7 = j.T2;
        this.f9499l = obtainStyledAttributes2.hasValue(i7);
        this.f9500m = obtainStyledAttributes2.getFloat(i7, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f9504q == null && (str = this.f9492e) != null) {
            this.f9504q = Typeface.create(str, this.f9493f);
        }
        if (this.f9504q == null) {
            int i6 = this.f9494g;
            this.f9504q = i6 != 1 ? i6 != 2 ? i6 != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.f9504q = Typeface.create(this.f9504q, this.f9493f);
        }
    }

    private boolean i(Context context) {
        if (e.a()) {
            return true;
        }
        int i6 = this.f9502o;
        return (i6 != 0 ? v.f.a(context, i6) : null) != null;
    }

    public Typeface e() {
        d();
        return this.f9504q;
    }

    public Typeface f(Context context) {
        if (this.f9503p) {
            return this.f9504q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface c6 = v.f.c(context, this.f9502o);
                this.f9504q = c6;
                if (c6 != null) {
                    this.f9504q = Typeface.create(c6, this.f9493f);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e6) {
                Log.d("TextAppearance", "Error loading font " + this.f9492e, e6);
            }
        }
        d();
        this.f9503p = true;
        return this.f9504q;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        l(textPaint, e());
        h(context, new b(textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (i(context)) {
            f(context);
        } else {
            d();
        }
        int i6 = this.f9502o;
        if (i6 == 0) {
            this.f9503p = true;
        }
        if (this.f9503p) {
            fVar.b(this.f9504q, true);
            return;
        }
        try {
            v.f.e(context, i6, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f9503p = true;
            fVar.a(1);
        } catch (Exception e6) {
            Log.d("TextAppearance", "Error loading font " + this.f9492e, e6);
            this.f9503p = true;
            fVar.a(-3);
        }
    }

    public void j(Context context, TextPaint textPaint, f fVar) {
        k(context, textPaint, fVar);
        ColorStateList colorStateList = this.f9488a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f6 = this.f9498k;
        float f7 = this.f9496i;
        float f8 = this.f9497j;
        ColorStateList colorStateList2 = this.f9491d;
        textPaint.setShadowLayer(f6, f7, f8, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void k(Context context, TextPaint textPaint, f fVar) {
        if (i(context)) {
            l(textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void l(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i6 = (~typeface.getStyle()) & this.f9493f;
        textPaint.setFakeBoldText((i6 & 1) != 0);
        textPaint.setTextSkewX((i6 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f9501n);
        if (this.f9499l) {
            textPaint.setLetterSpacing(this.f9500m);
        }
    }
}
