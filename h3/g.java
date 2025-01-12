package h3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import h3.k;
import h3.l;
import h3.m;
import java.util.BitSet;
/* loaded from: classes.dex */
public class g extends Drawable implements x.e, n {

    /* renamed from: x  reason: collision with root package name */
    private static final String f10652x = "g";

    /* renamed from: y  reason: collision with root package name */
    private static final Paint f10653y = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private c f10654b;

    /* renamed from: c  reason: collision with root package name */
    private final m.g[] f10655c;

    /* renamed from: d  reason: collision with root package name */
    private final m.g[] f10656d;

    /* renamed from: e  reason: collision with root package name */
    private final BitSet f10657e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10658f;

    /* renamed from: g  reason: collision with root package name */
    private final Matrix f10659g;

    /* renamed from: h  reason: collision with root package name */
    private final Path f10660h;

    /* renamed from: i  reason: collision with root package name */
    private final Path f10661i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f10662j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f10663k;

    /* renamed from: l  reason: collision with root package name */
    private final Region f10664l;

    /* renamed from: m  reason: collision with root package name */
    private final Region f10665m;

    /* renamed from: n  reason: collision with root package name */
    private k f10666n;

    /* renamed from: o  reason: collision with root package name */
    private final Paint f10667o;

    /* renamed from: p  reason: collision with root package name */
    private final Paint f10668p;

    /* renamed from: q  reason: collision with root package name */
    private final g3.a f10669q;

    /* renamed from: r  reason: collision with root package name */
    private final l.b f10670r;

    /* renamed from: s  reason: collision with root package name */
    private final l f10671s;

    /* renamed from: t  reason: collision with root package name */
    private PorterDuffColorFilter f10672t;

    /* renamed from: u  reason: collision with root package name */
    private PorterDuffColorFilter f10673u;

    /* renamed from: v  reason: collision with root package name */
    private final RectF f10674v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f10675w;

    /* loaded from: classes.dex */
    class a implements l.b {
        a() {
        }

        @Override // h3.l.b
        public void a(m mVar, Matrix matrix, int i6) {
            g.this.f10657e.set(i6 + 4, mVar.e());
            g.this.f10656d[i6] = mVar.f(matrix);
        }

        @Override // h3.l.b
        public void b(m mVar, Matrix matrix, int i6) {
            g.this.f10657e.set(i6, mVar.e());
            g.this.f10655c[i6] = mVar.f(matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements k.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f10677a;

        b(float f6) {
            this.f10677a = f6;
        }

        @Override // h3.k.c
        public h3.c a(h3.c cVar) {
            return cVar instanceof i ? cVar : new h3.b(this.f10677a, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public k f10679a;

        /* renamed from: b  reason: collision with root package name */
        public b3.a f10680b;

        /* renamed from: c  reason: collision with root package name */
        public ColorFilter f10681c;

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f10682d;

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f10683e;

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f10684f;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f10685g;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f10686h;

        /* renamed from: i  reason: collision with root package name */
        public Rect f10687i;

        /* renamed from: j  reason: collision with root package name */
        public float f10688j;

        /* renamed from: k  reason: collision with root package name */
        public float f10689k;

        /* renamed from: l  reason: collision with root package name */
        public float f10690l;

        /* renamed from: m  reason: collision with root package name */
        public int f10691m;

        /* renamed from: n  reason: collision with root package name */
        public float f10692n;

        /* renamed from: o  reason: collision with root package name */
        public float f10693o;

        /* renamed from: p  reason: collision with root package name */
        public float f10694p;

        /* renamed from: q  reason: collision with root package name */
        public int f10695q;

        /* renamed from: r  reason: collision with root package name */
        public int f10696r;

        /* renamed from: s  reason: collision with root package name */
        public int f10697s;

        /* renamed from: t  reason: collision with root package name */
        public int f10698t;

        /* renamed from: u  reason: collision with root package name */
        public boolean f10699u;

        /* renamed from: v  reason: collision with root package name */
        public Paint.Style f10700v;

        public c(c cVar) {
            this.f10682d = null;
            this.f10683e = null;
            this.f10684f = null;
            this.f10685g = null;
            this.f10686h = PorterDuff.Mode.SRC_IN;
            this.f10687i = null;
            this.f10688j = 1.0f;
            this.f10689k = 1.0f;
            this.f10691m = 255;
            this.f10692n = 0.0f;
            this.f10693o = 0.0f;
            this.f10694p = 0.0f;
            this.f10695q = 0;
            this.f10696r = 0;
            this.f10697s = 0;
            this.f10698t = 0;
            this.f10699u = false;
            this.f10700v = Paint.Style.FILL_AND_STROKE;
            this.f10679a = cVar.f10679a;
            this.f10680b = cVar.f10680b;
            this.f10690l = cVar.f10690l;
            this.f10681c = cVar.f10681c;
            this.f10682d = cVar.f10682d;
            this.f10683e = cVar.f10683e;
            this.f10686h = cVar.f10686h;
            this.f10685g = cVar.f10685g;
            this.f10691m = cVar.f10691m;
            this.f10688j = cVar.f10688j;
            this.f10697s = cVar.f10697s;
            this.f10695q = cVar.f10695q;
            this.f10699u = cVar.f10699u;
            this.f10689k = cVar.f10689k;
            this.f10692n = cVar.f10692n;
            this.f10693o = cVar.f10693o;
            this.f10694p = cVar.f10694p;
            this.f10696r = cVar.f10696r;
            this.f10698t = cVar.f10698t;
            this.f10684f = cVar.f10684f;
            this.f10700v = cVar.f10700v;
            if (cVar.f10687i != null) {
                this.f10687i = new Rect(cVar.f10687i);
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this, null);
            gVar.f10658f = true;
            return gVar;
        }

        public c(k kVar, b3.a aVar) {
            this.f10682d = null;
            this.f10683e = null;
            this.f10684f = null;
            this.f10685g = null;
            this.f10686h = PorterDuff.Mode.SRC_IN;
            this.f10687i = null;
            this.f10688j = 1.0f;
            this.f10689k = 1.0f;
            this.f10691m = 255;
            this.f10692n = 0.0f;
            this.f10693o = 0.0f;
            this.f10694p = 0.0f;
            this.f10695q = 0;
            this.f10696r = 0;
            this.f10697s = 0;
            this.f10698t = 0;
            this.f10699u = false;
            this.f10700v = Paint.Style.FILL_AND_STROKE;
            this.f10679a = kVar;
            this.f10680b = aVar;
        }
    }

    public g() {
        this(new k());
    }

    private float C() {
        if (J()) {
            return this.f10668p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean H() {
        c cVar = this.f10654b;
        int i6 = cVar.f10695q;
        return i6 != 1 && cVar.f10696r > 0 && (i6 == 2 || R());
    }

    private boolean I() {
        Paint.Style style = this.f10654b.f10700v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean J() {
        Paint.Style style = this.f10654b.f10700v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f10668p.getStrokeWidth() > 0.0f;
    }

    private void L() {
        super.invalidateSelf();
    }

    private void O(Canvas canvas) {
        if (H()) {
            canvas.save();
            Q(canvas);
            if (this.f10675w) {
                int width = (int) (this.f10674v.width() - getBounds().width());
                int height = (int) (this.f10674v.height() - getBounds().height());
                if (width < 0 || height < 0) {
                    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                }
                Bitmap createBitmap = Bitmap.createBitmap(((int) this.f10674v.width()) + (this.f10654b.f10696r * 2) + width, ((int) this.f10674v.height()) + (this.f10654b.f10696r * 2) + height, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f6 = (getBounds().left - this.f10654b.f10696r) - width;
                float f7 = (getBounds().top - this.f10654b.f10696r) - height;
                canvas2.translate(-f6, -f7);
                n(canvas2);
                canvas.drawBitmap(createBitmap, f6, f7, (Paint) null);
                createBitmap.recycle();
            } else {
                n(canvas);
            }
            canvas.restore();
        }
    }

    private static int P(int i6, int i7) {
        return (i6 * (i7 + (i7 >>> 7))) >>> 8;
    }

    private void Q(Canvas canvas) {
        canvas.translate(z(), A());
    }

    private boolean c0(int[] iArr) {
        boolean z5;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f10654b.f10682d == null || color2 == (colorForState2 = this.f10654b.f10682d.getColorForState(iArr, (color2 = this.f10667o.getColor())))) {
            z5 = false;
        } else {
            this.f10667o.setColor(colorForState2);
            z5 = true;
        }
        if (this.f10654b.f10683e == null || color == (colorForState = this.f10654b.f10683e.getColorForState(iArr, (color = this.f10668p.getColor())))) {
            return z5;
        }
        this.f10668p.setColor(colorForState);
        return true;
    }

    private boolean d0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f10672t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f10673u;
        c cVar = this.f10654b;
        this.f10672t = k(cVar.f10685g, cVar.f10686h, this.f10667o, true);
        c cVar2 = this.f10654b;
        this.f10673u = k(cVar2.f10684f, cVar2.f10686h, this.f10668p, false);
        c cVar3 = this.f10654b;
        if (cVar3.f10699u) {
            this.f10669q.d(cVar3.f10685g.getColorForState(getState(), 0));
        }
        return (d0.d.a(porterDuffColorFilter, this.f10672t) && d0.d.a(porterDuffColorFilter2, this.f10673u)) ? false : true;
    }

    private void e0() {
        float G = G();
        this.f10654b.f10696r = (int) Math.ceil(0.75f * G);
        this.f10654b.f10697s = (int) Math.ceil(G * 0.25f);
        d0();
        L();
    }

    private PorterDuffColorFilter f(Paint paint, boolean z5) {
        int color;
        int l6;
        if (!z5 || (l6 = l((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(l6, PorterDuff.Mode.SRC_IN);
    }

    private void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.f10654b.f10688j != 1.0f) {
            this.f10659g.reset();
            Matrix matrix = this.f10659g;
            float f6 = this.f10654b.f10688j;
            matrix.setScale(f6, f6, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f10659g);
        }
        path.computeBounds(this.f10674v, true);
    }

    private void i() {
        k y5 = B().y(new b(-C()));
        this.f10666n = y5;
        this.f10671s.d(y5, this.f10654b.f10689k, v(), this.f10661i);
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z5) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z5) {
            colorForState = l(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z5) {
        return (colorStateList == null || mode == null) ? f(paint, z5) : j(colorStateList, mode, z5);
    }

    public static g m(Context context, float f6) {
        int b6 = y2.a.b(context, u2.a.colorSurface, g.class.getSimpleName());
        g gVar = new g();
        gVar.K(context);
        gVar.U(ColorStateList.valueOf(b6));
        gVar.T(f6);
        return gVar;
    }

    private void n(Canvas canvas) {
        if (this.f10657e.cardinality() > 0) {
            Log.w(f10652x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f10654b.f10697s != 0) {
            canvas.drawPath(this.f10660h, this.f10669q.c());
        }
        for (int i6 = 0; i6 < 4; i6++) {
            this.f10655c[i6].b(this.f10669q, this.f10654b.f10696r, canvas);
            this.f10656d[i6].b(this.f10669q, this.f10654b.f10696r, canvas);
        }
        if (this.f10675w) {
            int z5 = z();
            int A = A();
            canvas.translate(-z5, -A);
            canvas.drawPath(this.f10660h, f10653y);
            canvas.translate(z5, A);
        }
    }

    private void o(Canvas canvas) {
        q(canvas, this.f10667o, this.f10660h, this.f10654b.f10679a, u());
    }

    private void q(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (!kVar.u(rectF)) {
            canvas.drawPath(path, paint);
            return;
        }
        float a6 = kVar.t().a(rectF) * this.f10654b.f10689k;
        canvas.drawRoundRect(rectF, a6, a6, paint);
    }

    private void r(Canvas canvas) {
        q(canvas, this.f10668p, this.f10661i, this.f10666n, v());
    }

    private RectF v() {
        this.f10663k.set(u());
        float C = C();
        this.f10663k.inset(C, C);
        return this.f10663k;
    }

    public int A() {
        c cVar = this.f10654b;
        return (int) (cVar.f10697s * Math.cos(Math.toRadians(cVar.f10698t)));
    }

    public k B() {
        return this.f10654b.f10679a;
    }

    public float D() {
        return this.f10654b.f10679a.r().a(u());
    }

    public float E() {
        return this.f10654b.f10679a.t().a(u());
    }

    public float F() {
        return this.f10654b.f10694p;
    }

    public float G() {
        return w() + F();
    }

    public void K(Context context) {
        this.f10654b.f10680b = new b3.a(context);
        e0();
    }

    public boolean M() {
        b3.a aVar = this.f10654b.f10680b;
        return aVar != null && aVar.d();
    }

    public boolean N() {
        return this.f10654b.f10679a.u(u());
    }

    public boolean R() {
        return (N() || this.f10660h.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    public void S(h3.c cVar) {
        setShapeAppearanceModel(this.f10654b.f10679a.x(cVar));
    }

    public void T(float f6) {
        c cVar = this.f10654b;
        if (cVar.f10693o != f6) {
            cVar.f10693o = f6;
            e0();
        }
    }

    public void U(ColorStateList colorStateList) {
        c cVar = this.f10654b;
        if (cVar.f10682d != colorStateList) {
            cVar.f10682d = colorStateList;
            onStateChange(getState());
        }
    }

    public void V(float f6) {
        c cVar = this.f10654b;
        if (cVar.f10689k != f6) {
            cVar.f10689k = f6;
            this.f10658f = true;
            invalidateSelf();
        }
    }

    public void W(int i6, int i7, int i8, int i9) {
        c cVar = this.f10654b;
        if (cVar.f10687i == null) {
            cVar.f10687i = new Rect();
        }
        this.f10654b.f10687i.set(i6, i7, i8, i9);
        invalidateSelf();
    }

    public void X(float f6) {
        c cVar = this.f10654b;
        if (cVar.f10692n != f6) {
            cVar.f10692n = f6;
            e0();
        }
    }

    public void Y(float f6, int i6) {
        b0(f6);
        a0(ColorStateList.valueOf(i6));
    }

    public void Z(float f6, ColorStateList colorStateList) {
        b0(f6);
        a0(colorStateList);
    }

    public void a0(ColorStateList colorStateList) {
        c cVar = this.f10654b;
        if (cVar.f10683e != colorStateList) {
            cVar.f10683e = colorStateList;
            onStateChange(getState());
        }
    }

    public void b0(float f6) {
        this.f10654b.f10690l = f6;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f10667o.setColorFilter(this.f10672t);
        int alpha = this.f10667o.getAlpha();
        this.f10667o.setAlpha(P(alpha, this.f10654b.f10691m));
        this.f10668p.setColorFilter(this.f10673u);
        this.f10668p.setStrokeWidth(this.f10654b.f10690l);
        int alpha2 = this.f10668p.getAlpha();
        this.f10668p.setAlpha(P(alpha2, this.f10654b.f10691m));
        if (this.f10658f) {
            i();
            g(u(), this.f10660h);
            this.f10658f = false;
        }
        O(canvas);
        if (I()) {
            o(canvas);
        }
        if (J()) {
            r(canvas);
        }
        this.f10667o.setAlpha(alpha);
        this.f10668p.setAlpha(alpha2);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f10654b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f10654b.f10695q == 2) {
            return;
        }
        if (N()) {
            outline.setRoundRect(getBounds(), D() * this.f10654b.f10689k);
            return;
        }
        g(u(), this.f10660h);
        if (this.f10660h.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f10660h);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f10654b.f10687i;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f10664l.set(getBounds());
        g(u(), this.f10660h);
        this.f10665m.setPath(this.f10660h, this.f10664l);
        this.f10664l.op(this.f10665m, Region.Op.DIFFERENCE);
        return this.f10664l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(RectF rectF, Path path) {
        l lVar = this.f10671s;
        c cVar = this.f10654b;
        lVar.e(cVar.f10679a, cVar.f10689k, rectF, this.f10670r, path);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f10658f = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f10654b.f10685g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f10654b.f10684f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f10654b.f10683e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f10654b.f10682d) != null && colorStateList4.isStateful())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int l(int i6) {
        float G = G() + y();
        b3.a aVar = this.f10654b.f10680b;
        return aVar != null ? aVar.c(i6, G) : i6;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f10654b = new c(this.f10654b);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f10658f = true;
        super.onBoundsChange(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.h.b
    public boolean onStateChange(int[] iArr) {
        boolean z5 = c0(iArr) || d0();
        if (z5) {
            invalidateSelf();
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        q(canvas, paint, path, this.f10654b.f10679a, rectF);
    }

    public float s() {
        return this.f10654b.f10679a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        c cVar = this.f10654b;
        if (cVar.f10691m != i6) {
            cVar.f10691m = i6;
            L();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f10654b.f10681c = colorFilter;
        L();
    }

    @Override // h3.n
    public void setShapeAppearanceModel(k kVar) {
        this.f10654b.f10679a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i6) {
        setTintList(ColorStateList.valueOf(i6));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f10654b.f10685g = colorStateList;
        d0();
        L();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f10654b;
        if (cVar.f10686h != mode) {
            cVar.f10686h = mode;
            d0();
            L();
        }
    }

    public float t() {
        return this.f10654b.f10679a.l().a(u());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RectF u() {
        this.f10662j.set(getBounds());
        return this.f10662j;
    }

    public float w() {
        return this.f10654b.f10693o;
    }

    public ColorStateList x() {
        return this.f10654b.f10682d;
    }

    public float y() {
        return this.f10654b.f10692n;
    }

    public int z() {
        c cVar = this.f10654b;
        return (int) (cVar.f10697s * Math.sin(Math.toRadians(cVar.f10698t)));
    }

    public g(Context context, AttributeSet attributeSet, int i6, int i7) {
        this(k.e(context, attributeSet, i6, i7).m());
    }

    private g(c cVar) {
        this.f10655c = new m.g[4];
        this.f10656d = new m.g[4];
        this.f10657e = new BitSet(8);
        this.f10659g = new Matrix();
        this.f10660h = new Path();
        this.f10661i = new Path();
        this.f10662j = new RectF();
        this.f10663k = new RectF();
        this.f10664l = new Region();
        this.f10665m = new Region();
        Paint paint = new Paint(1);
        this.f10667o = paint;
        Paint paint2 = new Paint(1);
        this.f10668p = paint2;
        this.f10669q = new g3.a();
        this.f10671s = Looper.getMainLooper().getThread() == Thread.currentThread() ? l.k() : new l();
        this.f10674v = new RectF();
        this.f10675w = true;
        this.f10654b = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = f10653y;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        d0();
        c0(getState());
        this.f10670r = new a();
    }

    /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }
}
