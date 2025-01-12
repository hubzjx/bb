package f;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c extends Drawable implements Drawable.Callback {

    /* renamed from: b  reason: collision with root package name */
    private AbstractC0162c f9655b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f9656c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f9657d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f9658e;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9660g;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9662i;

    /* renamed from: j  reason: collision with root package name */
    private Runnable f9663j;

    /* renamed from: k  reason: collision with root package name */
    private long f9664k;

    /* renamed from: l  reason: collision with root package name */
    private long f9665l;

    /* renamed from: m  reason: collision with root package name */
    private b f9666m;

    /* renamed from: f  reason: collision with root package name */
    private int f9659f = 255;

    /* renamed from: h  reason: collision with root package name */
    private int f9661h = -1;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(true);
            c.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements Drawable.Callback {

        /* renamed from: b  reason: collision with root package name */
        private Drawable.Callback f9668b;

        b() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f9668b;
            this.f9668b = null;
            return callback;
        }

        public b b(Drawable.Callback callback) {
            this.f9668b = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j6) {
            Drawable.Callback callback = this.f9668b;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j6);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f9668b;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0162c extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a  reason: collision with root package name */
        final c f9669a;

        /* renamed from: b  reason: collision with root package name */
        Resources f9670b;

        /* renamed from: c  reason: collision with root package name */
        int f9671c;

        /* renamed from: d  reason: collision with root package name */
        int f9672d;

        /* renamed from: e  reason: collision with root package name */
        int f9673e;

        /* renamed from: f  reason: collision with root package name */
        SparseArray f9674f;

        /* renamed from: g  reason: collision with root package name */
        Drawable[] f9675g;

        /* renamed from: h  reason: collision with root package name */
        int f9676h;

        /* renamed from: i  reason: collision with root package name */
        boolean f9677i;

        /* renamed from: j  reason: collision with root package name */
        boolean f9678j;

        /* renamed from: k  reason: collision with root package name */
        Rect f9679k;

        /* renamed from: l  reason: collision with root package name */
        boolean f9680l;

        /* renamed from: m  reason: collision with root package name */
        boolean f9681m;

        /* renamed from: n  reason: collision with root package name */
        int f9682n;

        /* renamed from: o  reason: collision with root package name */
        int f9683o;

        /* renamed from: p  reason: collision with root package name */
        int f9684p;

        /* renamed from: q  reason: collision with root package name */
        int f9685q;

        /* renamed from: r  reason: collision with root package name */
        boolean f9686r;

        /* renamed from: s  reason: collision with root package name */
        int f9687s;

        /* renamed from: t  reason: collision with root package name */
        boolean f9688t;

        /* renamed from: u  reason: collision with root package name */
        boolean f9689u;

        /* renamed from: v  reason: collision with root package name */
        boolean f9690v;

        /* renamed from: w  reason: collision with root package name */
        boolean f9691w;

        /* renamed from: x  reason: collision with root package name */
        boolean f9692x;

        /* renamed from: y  reason: collision with root package name */
        boolean f9693y;

        /* renamed from: z  reason: collision with root package name */
        int f9694z;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AbstractC0162c(AbstractC0162c abstractC0162c, c cVar, Resources resources) {
            this.f9671c = 160;
            this.f9677i = false;
            this.f9680l = false;
            this.f9692x = true;
            this.A = 0;
            this.B = 0;
            this.f9669a = cVar;
            this.f9670b = resources != null ? resources : abstractC0162c != null ? abstractC0162c.f9670b : null;
            int f6 = c.f(resources, abstractC0162c != null ? abstractC0162c.f9671c : 0);
            this.f9671c = f6;
            if (abstractC0162c == null) {
                this.f9675g = new Drawable[10];
                this.f9676h = 0;
                return;
            }
            this.f9672d = abstractC0162c.f9672d;
            this.f9673e = abstractC0162c.f9673e;
            this.f9690v = true;
            this.f9691w = true;
            this.f9677i = abstractC0162c.f9677i;
            this.f9680l = abstractC0162c.f9680l;
            this.f9692x = abstractC0162c.f9692x;
            this.f9693y = abstractC0162c.f9693y;
            this.f9694z = abstractC0162c.f9694z;
            this.A = abstractC0162c.A;
            this.B = abstractC0162c.B;
            this.C = abstractC0162c.C;
            this.D = abstractC0162c.D;
            this.E = abstractC0162c.E;
            this.F = abstractC0162c.F;
            this.G = abstractC0162c.G;
            this.H = abstractC0162c.H;
            this.I = abstractC0162c.I;
            if (abstractC0162c.f9671c == f6) {
                if (abstractC0162c.f9678j) {
                    this.f9679k = new Rect(abstractC0162c.f9679k);
                    this.f9678j = true;
                }
                if (abstractC0162c.f9681m) {
                    this.f9682n = abstractC0162c.f9682n;
                    this.f9683o = abstractC0162c.f9683o;
                    this.f9684p = abstractC0162c.f9684p;
                    this.f9685q = abstractC0162c.f9685q;
                    this.f9681m = true;
                }
            }
            if (abstractC0162c.f9686r) {
                this.f9687s = abstractC0162c.f9687s;
                this.f9686r = true;
            }
            if (abstractC0162c.f9688t) {
                this.f9689u = abstractC0162c.f9689u;
                this.f9688t = true;
            }
            Drawable[] drawableArr = abstractC0162c.f9675g;
            this.f9675g = new Drawable[drawableArr.length];
            this.f9676h = abstractC0162c.f9676h;
            SparseArray sparseArray = abstractC0162c.f9674f;
            this.f9674f = sparseArray != null ? sparseArray.clone() : new SparseArray(this.f9676h);
            int i6 = this.f9676h;
            for (int i7 = 0; i7 < i6; i7++) {
                Drawable drawable = drawableArr[i7];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f9674f.put(i7, constantState);
                    } else {
                        this.f9675g[i7] = drawableArr[i7];
                    }
                }
            }
        }

        private void e() {
            SparseArray sparseArray = this.f9674f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i6 = 0; i6 < size; i6++) {
                    this.f9675g[this.f9674f.keyAt(i6)] = s(((Drawable.ConstantState) this.f9674f.valueAt(i6)).newDrawable(this.f9670b));
                }
                this.f9674f = null;
            }
        }

        private Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.f9694z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f9669a);
            return mutate;
        }

        public final int a(Drawable drawable) {
            int i6 = this.f9676h;
            if (i6 >= this.f9675g.length) {
                o(i6, i6 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f9669a);
            this.f9675g[i6] = drawable;
            this.f9676h++;
            this.f9673e = drawable.getChangingConfigurations() | this.f9673e;
            p();
            this.f9679k = null;
            this.f9678j = false;
            this.f9681m = false;
            this.f9690v = false;
            return i6;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i6 = this.f9676h;
                Drawable[] drawableArr = this.f9675g;
                for (int i7 = 0; i7 < i6; i7++) {
                    Drawable drawable = drawableArr[i7];
                    if (drawable != null && drawable.canApplyTheme()) {
                        drawableArr[i7].applyTheme(theme);
                        this.f9673e |= drawableArr[i7].getChangingConfigurations();
                    }
                }
                y(theme.getResources());
            }
        }

        public synchronized boolean c() {
            if (this.f9690v) {
                return this.f9691w;
            }
            e();
            this.f9690v = true;
            int i6 = this.f9676h;
            Drawable[] drawableArr = this.f9675g;
            for (int i7 = 0; i7 < i6; i7++) {
                if (drawableArr[i7].getConstantState() == null) {
                    this.f9691w = false;
                    return false;
                }
            }
            this.f9691w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i6 = this.f9676h;
            Drawable[] drawableArr = this.f9675g;
            for (int i7 = 0; i7 < i6; i7++) {
                Drawable drawable = drawableArr[i7];
                if (drawable == null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f9674f.get(i7);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        protected void d() {
            this.f9681m = true;
            e();
            int i6 = this.f9676h;
            Drawable[] drawableArr = this.f9675g;
            this.f9683o = -1;
            this.f9682n = -1;
            this.f9685q = 0;
            this.f9684p = 0;
            for (int i7 = 0; i7 < i6; i7++) {
                Drawable drawable = drawableArr[i7];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f9682n) {
                    this.f9682n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f9683o) {
                    this.f9683o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f9684p) {
                    this.f9684p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f9685q) {
                    this.f9685q = minimumHeight;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int f() {
            return this.f9675g.length;
        }

        public final Drawable g(int i6) {
            int indexOfKey;
            Drawable drawable = this.f9675g[i6];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.f9674f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i6)) < 0) {
                return null;
            }
            Drawable s5 = s(((Drawable.ConstantState) this.f9674f.valueAt(indexOfKey)).newDrawable(this.f9670b));
            this.f9675g[i6] = s5;
            this.f9674f.removeAt(indexOfKey);
            if (this.f9674f.size() == 0) {
                this.f9674f = null;
            }
            return s5;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f9672d | this.f9673e;
        }

        public final int h() {
            return this.f9676h;
        }

        public final int i() {
            if (!this.f9681m) {
                d();
            }
            return this.f9683o;
        }

        public final int j() {
            if (!this.f9681m) {
                d();
            }
            return this.f9685q;
        }

        public final int k() {
            if (!this.f9681m) {
                d();
            }
            return this.f9684p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f9677i) {
                return null;
            }
            Rect rect2 = this.f9679k;
            if (rect2 != null || this.f9678j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i6 = this.f9676h;
            Drawable[] drawableArr = this.f9675g;
            for (int i7 = 0; i7 < i6; i7++) {
                if (drawableArr[i7].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i8 = rect3.left;
                    if (i8 > rect.left) {
                        rect.left = i8;
                    }
                    int i9 = rect3.top;
                    if (i9 > rect.top) {
                        rect.top = i9;
                    }
                    int i10 = rect3.right;
                    if (i10 > rect.right) {
                        rect.right = i10;
                    }
                    int i11 = rect3.bottom;
                    if (i11 > rect.bottom) {
                        rect.bottom = i11;
                    }
                }
            }
            this.f9678j = true;
            this.f9679k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f9681m) {
                d();
            }
            return this.f9682n;
        }

        public final int n() {
            if (this.f9686r) {
                return this.f9687s;
            }
            e();
            int i6 = this.f9676h;
            Drawable[] drawableArr = this.f9675g;
            int opacity = i6 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i7 = 1; i7 < i6; i7++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i7].getOpacity());
            }
            this.f9687s = opacity;
            this.f9686r = true;
            return opacity;
        }

        public void o(int i6, int i7) {
            Drawable[] drawableArr = new Drawable[i7];
            System.arraycopy(this.f9675g, 0, drawableArr, 0, i6);
            this.f9675g = drawableArr;
        }

        void p() {
            this.f9686r = false;
            this.f9688t = false;
        }

        public final boolean q() {
            return this.f9680l;
        }

        abstract void r();

        public final void t(boolean z5) {
            this.f9680l = z5;
        }

        public final void u(int i6) {
            this.A = i6;
        }

        public final void v(int i6) {
            this.B = i6;
        }

        final boolean w(int i6, int i7) {
            int i8 = this.f9676h;
            Drawable[] drawableArr = this.f9675g;
            boolean z5 = false;
            for (int i9 = 0; i9 < i8; i9++) {
                Drawable drawable = drawableArr[i9];
                if (drawable != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawable.setLayoutDirection(i6) : false;
                    if (i9 == i7) {
                        z5 = layoutDirection;
                    }
                }
            }
            this.f9694z = i6;
            return z5;
        }

        public final void x(boolean z5) {
            this.f9677i = z5;
        }

        final void y(Resources resources) {
            if (resources != null) {
                this.f9670b = resources;
                int f6 = c.f(resources, this.f9671c);
                int i6 = this.f9671c;
                this.f9671c = f6;
                if (i6 != f6) {
                    this.f9681m = false;
                    this.f9678j = false;
                }
            }
        }
    }

    private void d(Drawable drawable) {
        if (this.f9666m == null) {
            this.f9666m = new b();
        }
        drawable.setCallback(this.f9666m.b(drawable.getCallback()));
        try {
            if (this.f9655b.A <= 0 && this.f9660g) {
                drawable.setAlpha(this.f9659f);
            }
            AbstractC0162c abstractC0162c = this.f9655b;
            if (abstractC0162c.E) {
                drawable.setColorFilter(abstractC0162c.D);
            } else {
                if (abstractC0162c.H) {
                    x.b.o(drawable, abstractC0162c.F);
                }
                AbstractC0162c abstractC0162c2 = this.f9655b;
                if (abstractC0162c2.I) {
                    x.b.p(drawable, abstractC0162c2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f9655b.f9692x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            drawable.setAutoMirrored(this.f9655b.C);
            Rect rect = this.f9656c;
            if (rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f9666m.a());
        }
    }

    private boolean e() {
        return isAutoMirrored() && x.b.f(this) == 1;
    }

    static int f(Resources resources, int i6) {
        if (resources != null) {
            i6 = resources.getDisplayMetrics().densityDpi;
        }
        if (i6 == 0) {
            return 160;
        }
        return i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(boolean z5) {
        boolean z6;
        Drawable drawable;
        boolean z7 = true;
        this.f9660g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f9657d;
        if (drawable2 != null) {
            long j6 = this.f9664k;
            if (j6 != 0) {
                if (j6 <= uptimeMillis) {
                    drawable2.setAlpha(this.f9659f);
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j6 - uptimeMillis) * 255)) / this.f9655b.A)) * this.f9659f) / 255);
                    z6 = true;
                    drawable = this.f9658e;
                    if (drawable != null) {
                        long j7 = this.f9665l;
                        if (j7 != 0) {
                            if (j7 > uptimeMillis) {
                                drawable.setAlpha(((((int) ((j7 - uptimeMillis) * 255)) / this.f9655b.B) * this.f9659f) / 255);
                                if (z5 && z7) {
                                    scheduleSelf(this.f9663j, uptimeMillis + 16);
                                    return;
                                }
                                return;
                            }
                            drawable.setVisible(false, false);
                            this.f9658e = null;
                        }
                        z7 = z6;
                        if (z5) {
                            return;
                        }
                        return;
                    }
                    this.f9665l = 0L;
                    z7 = z6;
                    if (z5) {
                    }
                }
            }
            z6 = false;
            drawable = this.f9658e;
            if (drawable != null) {
            }
            this.f9665l = 0L;
            z7 = z6;
            if (z5) {
            }
        }
        this.f9664k = 0L;
        z6 = false;
        drawable = this.f9658e;
        if (drawable != null) {
        }
        this.f9665l = 0L;
        z7 = z6;
        if (z5) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f9655b.b(theme);
    }

    abstract AbstractC0162c b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f9661h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f9655b.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f9657d;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f9658e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(int i6) {
        Runnable runnable;
        if (i6 == this.f9661h) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f9655b.B > 0) {
            Drawable drawable = this.f9658e;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f9657d;
            if (drawable2 != null) {
                this.f9658e = drawable2;
                this.f9665l = this.f9655b.B + uptimeMillis;
            } else {
                this.f9658e = null;
                this.f9665l = 0L;
            }
        } else {
            Drawable drawable3 = this.f9657d;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i6 >= 0) {
            AbstractC0162c abstractC0162c = this.f9655b;
            if (i6 < abstractC0162c.f9676h) {
                Drawable g6 = abstractC0162c.g(i6);
                this.f9657d = g6;
                this.f9661h = i6;
                if (g6 != null) {
                    int i7 = this.f9655b.A;
                    if (i7 > 0) {
                        this.f9664k = uptimeMillis + i7;
                    }
                    d(g6);
                }
                if (this.f9664k == 0 || this.f9665l != 0) {
                    runnable = this.f9663j;
                    if (runnable != null) {
                        this.f9663j = new a();
                    } else {
                        unscheduleSelf(runnable);
                    }
                    a(true);
                }
                invalidateSelf();
                return true;
            }
        }
        this.f9657d = null;
        this.f9661h = -1;
        if (this.f9664k == 0) {
        }
        runnable = this.f9663j;
        if (runnable != null) {
        }
        a(true);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f9659f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f9655b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f9655b.c()) {
            this.f9655b.f9672d = getChangingConfigurations();
            return this.f9655b;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f9657d;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f9656c;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f9655b.q()) {
            return this.f9655b.i();
        }
        Drawable drawable = this.f9657d;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f9655b.q()) {
            return this.f9655b.m();
        }
        Drawable drawable = this.f9657d;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f9655b.q()) {
            return this.f9655b.j();
        }
        Drawable drawable = this.f9657d;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f9655b.q()) {
            return this.f9655b.k();
        }
        Drawable drawable = this.f9657d;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f9657d;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f9655b.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f9657d;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect l6 = this.f9655b.l();
        if (l6 != null) {
            rect.set(l6);
            padding = (l6.right | ((l6.left | l6.top) | l6.bottom)) != 0;
        } else {
            Drawable drawable = this.f9657d;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i6 = rect.left;
            rect.left = rect.right;
            rect.right = i6;
        }
        return padding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(AbstractC0162c abstractC0162c) {
        this.f9655b = abstractC0162c;
        int i6 = this.f9661h;
        if (i6 >= 0) {
            Drawable g6 = abstractC0162c.g(i6);
            this.f9657d = g6;
            if (g6 != null) {
                d(g6);
            }
        }
        this.f9658e = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(Resources resources) {
        this.f9655b.y(resources);
    }

    public void invalidateDrawable(Drawable drawable) {
        AbstractC0162c abstractC0162c = this.f9655b;
        if (abstractC0162c != null) {
            abstractC0162c.p();
        }
        if (drawable != this.f9657d || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f9655b.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z5;
        Drawable drawable = this.f9658e;
        boolean z6 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f9658e = null;
            z5 = true;
        } else {
            z5 = false;
        }
        Drawable drawable2 = this.f9657d;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f9660g) {
                this.f9657d.setAlpha(this.f9659f);
            }
        }
        if (this.f9665l != 0) {
            this.f9665l = 0L;
            z5 = true;
        }
        if (this.f9664k != 0) {
            this.f9664k = 0L;
        } else {
            z6 = z5;
        }
        if (z6) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f9662i && super.mutate() == this) {
            AbstractC0162c b6 = b();
            b6.r();
            h(b6);
            this.f9662i = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f9658e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f9657d;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i6) {
        return this.f9655b.w(i6, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i6) {
        Drawable drawable = this.f9658e;
        if (drawable != null) {
            return drawable.setLevel(i6);
        }
        Drawable drawable2 = this.f9657d;
        if (drawable2 != null) {
            return drawable2.setLevel(i6);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j6) {
        if (drawable != this.f9657d || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        if (this.f9660g && this.f9659f == i6) {
            return;
        }
        this.f9660g = true;
        this.f9659f = i6;
        Drawable drawable = this.f9657d;
        if (drawable != null) {
            if (this.f9664k == 0) {
                drawable.setAlpha(i6);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z5) {
        AbstractC0162c abstractC0162c = this.f9655b;
        if (abstractC0162c.C != z5) {
            abstractC0162c.C = z5;
            Drawable drawable = this.f9657d;
            if (drawable != null) {
                x.b.j(drawable, z5);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        AbstractC0162c abstractC0162c = this.f9655b;
        abstractC0162c.E = true;
        if (abstractC0162c.D != colorFilter) {
            abstractC0162c.D = colorFilter;
            Drawable drawable = this.f9657d;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z5) {
        AbstractC0162c abstractC0162c = this.f9655b;
        if (abstractC0162c.f9692x != z5) {
            abstractC0162c.f9692x = z5;
            Drawable drawable = this.f9657d;
            if (drawable != null) {
                drawable.setDither(z5);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f6, float f7) {
        Drawable drawable = this.f9657d;
        if (drawable != null) {
            x.b.k(drawable, f6, f7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i6, int i7, int i8, int i9) {
        Rect rect = this.f9656c;
        if (rect == null) {
            this.f9656c = new Rect(i6, i7, i8, i9);
        } else {
            rect.set(i6, i7, i8, i9);
        }
        Drawable drawable = this.f9657d;
        if (drawable != null) {
            x.b.l(drawable, i6, i7, i8, i9);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        AbstractC0162c abstractC0162c = this.f9655b;
        abstractC0162c.H = true;
        if (abstractC0162c.F != colorStateList) {
            abstractC0162c.F = colorStateList;
            x.b.o(this.f9657d, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        AbstractC0162c abstractC0162c = this.f9655b;
        abstractC0162c.I = true;
        if (abstractC0162c.G != mode) {
            abstractC0162c.G = mode;
            x.b.p(this.f9657d, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        boolean visible = super.setVisible(z5, z6);
        Drawable drawable = this.f9658e;
        if (drawable != null) {
            drawable.setVisible(z5, z6);
        }
        Drawable drawable2 = this.f9657d;
        if (drawable2 != null) {
            drawable2.setVisible(z5, z6);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f9657d || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
