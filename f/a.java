package f;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.t1;
import f.c;
import f.e;
import l.h;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class a extends f.e implements x.e {

    /* renamed from: p  reason: collision with root package name */
    private c f9643p;

    /* renamed from: q  reason: collision with root package name */
    private g f9644q;

    /* renamed from: r  reason: collision with root package name */
    private int f9645r;

    /* renamed from: s  reason: collision with root package name */
    private int f9646s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f9647t;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        private final Animatable f9648a;

        b(Animatable animatable) {
            super();
            this.f9648a = animatable;
        }

        @Override // f.a.g
        public void c() {
            this.f9648a.start();
        }

        @Override // f.a.g
        public void d() {
            this.f9648a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends e.a {
        l.d K;
        h L;

        c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            h hVar;
            if (cVar != null) {
                this.K = cVar.K;
                hVar = cVar.L;
            } else {
                this.K = new l.d();
                hVar = new h();
            }
            this.L = hVar;
        }

        private static long D(int i6, int i7) {
            return i7 | (i6 << 32);
        }

        int B(int[] iArr, Drawable drawable, int i6) {
            int z5 = super.z(iArr, drawable);
            this.L.i(z5, Integer.valueOf(i6));
            return z5;
        }

        int C(int i6, int i7, Drawable drawable, boolean z5) {
            int a6 = super.a(drawable);
            long D = D(i6, i7);
            long j6 = z5 ? 8589934592L : 0L;
            long j7 = a6;
            this.K.a(D, Long.valueOf(j7 | j6));
            if (z5) {
                this.K.a(D(i7, i6), Long.valueOf(4294967296L | j7 | j6));
            }
            return a6;
        }

        int E(int i6) {
            if (i6 < 0) {
                return 0;
            }
            return ((Integer) this.L.f(i6, 0)).intValue();
        }

        int F(int[] iArr) {
            int A = super.A(iArr);
            return A >= 0 ? A : super.A(StateSet.WILD_CARD);
        }

        int G(int i6, int i7) {
            return (int) ((Long) this.K.f(D(i6, i7), -1L)).longValue();
        }

        boolean H(int i6, int i7) {
            return (((Long) this.K.f(D(i6, i7), -1L)).longValue() & 4294967296L) != 0;
        }

        boolean I(int i6, int i7) {
            return (((Long) this.K.f(D(i6, i7), -1L)).longValue() & 8589934592L) != 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // f.e.a, f.c.AbstractC0162c
        void r() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends g {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.vectordrawable.graphics.drawable.b f9649a;

        d(androidx.vectordrawable.graphics.drawable.b bVar) {
            super();
            this.f9649a = bVar;
        }

        @Override // f.a.g
        public void c() {
            this.f9649a.start();
        }

        @Override // f.a.g
        public void d() {
            this.f9649a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends g {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectAnimator f9650a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f9651b;

        e(AnimationDrawable animationDrawable, boolean z5, boolean z6) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i6 = z5 ? numberOfFrames - 1 : 0;
            int i7 = z5 ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z5);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i6, i7);
            ofInt.setAutoCancel(true);
            ofInt.setDuration(fVar.a());
            ofInt.setInterpolator(fVar);
            this.f9651b = z6;
            this.f9650a = ofInt;
        }

        @Override // f.a.g
        public boolean a() {
            return this.f9651b;
        }

        @Override // f.a.g
        public void b() {
            this.f9650a.reverse();
        }

        @Override // f.a.g
        public void c() {
            this.f9650a.start();
        }

        @Override // f.a.g
        public void d() {
            this.f9650a.cancel();
        }
    }

    /* loaded from: classes.dex */
    private static class f implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        private int[] f9652a;

        /* renamed from: b  reason: collision with root package name */
        private int f9653b;

        /* renamed from: c  reason: collision with root package name */
        private int f9654c;

        f(AnimationDrawable animationDrawable, boolean z5) {
            b(animationDrawable, z5);
        }

        int a() {
            return this.f9654c;
        }

        int b(AnimationDrawable animationDrawable, boolean z5) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f9653b = numberOfFrames;
            int[] iArr = this.f9652a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f9652a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f9652a;
            int i6 = 0;
            for (int i7 = 0; i7 < numberOfFrames; i7++) {
                int duration = animationDrawable.getDuration(z5 ? (numberOfFrames - i7) - 1 : i7);
                iArr2[i7] = duration;
                i6 += duration;
            }
            this.f9654c = i6;
            return i6;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            int i6 = (int) ((f6 * this.f9654c) + 0.5f);
            int i7 = this.f9653b;
            int[] iArr = this.f9652a;
            int i8 = 0;
            while (i8 < i7) {
                int i9 = iArr[i8];
                if (i6 < i9) {
                    break;
                }
                i6 -= i9;
                i8++;
            }
            return (i8 / i7) + (i8 < i7 ? i6 / this.f9654c : 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this(null, null);
    }

    public static a l(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.m(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    p(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    q(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void o() {
        onStateChange(getState());
    }

    private int p(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray k6 = v.h.k(resources, theme, attributeSet, g.b.f9931h);
        int resourceId = k6.getResourceId(g.b.f9932i, 0);
        int resourceId2 = k6.getResourceId(g.b.f9933j, -1);
        Drawable j6 = resourceId2 > 0 ? t1.h().j(context, resourceId2) : null;
        k6.recycle();
        int[] j7 = j(attributeSet);
        if (j6 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            j6 = xmlPullParser.getName().equals("vector") ? androidx.vectordrawable.graphics.drawable.g.c(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
        }
        if (j6 != null) {
            return this.f9643p.B(j7, j6, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray k6 = v.h.k(resources, theme, attributeSet, g.b.f9934k);
        int resourceId = k6.getResourceId(g.b.f9937n, -1);
        int resourceId2 = k6.getResourceId(g.b.f9936m, -1);
        int resourceId3 = k6.getResourceId(g.b.f9935l, -1);
        Drawable j6 = resourceId3 > 0 ? t1.h().j(context, resourceId3) : null;
        boolean z5 = k6.getBoolean(g.b.f9938o, false);
        k6.recycle();
        if (j6 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            j6 = xmlPullParser.getName().equals("animated-vector") ? androidx.vectordrawable.graphics.drawable.b.a(context, resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
        }
        if (j6 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId == -1 || resourceId2 == -1) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        } else {
            return this.f9643p.C(resourceId, resourceId2, j6, z5);
        }
    }

    private boolean r(int i6) {
        int c6;
        int G;
        g bVar;
        g gVar = this.f9644q;
        if (gVar == null) {
            c6 = c();
        } else if (i6 == this.f9645r) {
            return true;
        } else {
            if (i6 == this.f9646s && gVar.a()) {
                gVar.b();
                this.f9645r = this.f9646s;
                this.f9646s = i6;
                return true;
            }
            c6 = this.f9645r;
            gVar.d();
        }
        this.f9644q = null;
        this.f9646s = -1;
        this.f9645r = -1;
        c cVar = this.f9643p;
        int E = cVar.E(c6);
        int E2 = cVar.E(i6);
        if (E2 == 0 || E == 0 || (G = cVar.G(E, E2)) < 0) {
            return false;
        }
        boolean I = cVar.I(E, E2);
        g(G);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.H(E, E2), I);
        } else if (!(current instanceof androidx.vectordrawable.graphics.drawable.b)) {
            if (current instanceof Animatable) {
                bVar = new b((Animatable) current);
            }
            return false;
        } else {
            bVar = new d((androidx.vectordrawable.graphics.drawable.b) current);
        }
        bVar.c();
        this.f9644q = bVar;
        this.f9646s = c6;
        this.f9645r = i6;
        return true;
    }

    private void s(TypedArray typedArray) {
        c cVar = this.f9643p;
        cVar.f9672d |= typedArray.getChangingConfigurations();
        cVar.x(typedArray.getBoolean(g.b.f9927d, cVar.f9677i));
        cVar.t(typedArray.getBoolean(g.b.f9928e, cVar.f9680l));
        cVar.u(typedArray.getInt(g.b.f9929f, cVar.A));
        cVar.v(typedArray.getInt(g.b.f9930g, cVar.B));
        setDither(typedArray.getBoolean(g.b.f9925b, cVar.f9692x));
    }

    @Override // f.e, f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // f.e, f.c
    public void h(c.AbstractC0162c abstractC0162c) {
        super.h(abstractC0162c);
        if (abstractC0162c instanceof c) {
            this.f9643p = (c) abstractC0162c;
        }
    }

    @Override // f.c, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.f9644q;
        if (gVar != null) {
            gVar.d();
            this.f9644q = null;
            g(this.f9645r);
            this.f9645r = -1;
            this.f9646s = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // f.c
    /* renamed from: k */
    public c b() {
        return new c(this.f9643p, this, null);
    }

    public void m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray k6 = v.h.k(resources, theme, attributeSet, g.b.f9924a);
        setVisible(k6.getBoolean(g.b.f9926c, true), true);
        s(k6);
        i(resources);
        k6.recycle();
        n(context, resources, xmlPullParser, attributeSet, theme);
        o();
    }

    @Override // f.e, f.c, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f9647t && super.mutate() == this) {
            this.f9643p.r();
            this.f9647t = true;
        }
        return this;
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i6) {
        return super.onLayoutDirectionChanged(i6);
    }

    @Override // f.e, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int F = this.f9643p.F(iArr);
        boolean z5 = F != c() && (r(F) || g(F));
        Drawable current = getCurrent();
        return current != null ? z5 | current.setState(iArr) : z5;
    }

    @Override // f.c, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j6) {
        super.scheduleDrawable(drawable, runnable, j6);
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i6) {
        super.setAlpha(i6);
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z5) {
        super.setAutoMirrored(z5);
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z5) {
        super.setDither(z5);
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f6, float f7) {
        super.setHotspot(f6, f7);
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i6, int i7, int i8, int i9) {
        super.setHotspotBounds(i6, i7, i8, i9);
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // f.c, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        boolean visible = super.setVisible(z5, z6);
        g gVar = this.f9644q;
        if (gVar != null && (visible || z6)) {
            if (z5) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // f.c, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    a(c cVar, Resources resources) {
        super(null);
        this.f9645r = -1;
        this.f9646s = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
