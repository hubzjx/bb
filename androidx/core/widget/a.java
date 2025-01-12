package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import e0.b0;
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: s  reason: collision with root package name */
    private static final int f1635s = ViewConfiguration.getTapTimeout();

    /* renamed from: d  reason: collision with root package name */
    final View f1638d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f1639e;

    /* renamed from: h  reason: collision with root package name */
    private int f1642h;

    /* renamed from: i  reason: collision with root package name */
    private int f1643i;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1647m;

    /* renamed from: n  reason: collision with root package name */
    boolean f1648n;

    /* renamed from: o  reason: collision with root package name */
    boolean f1649o;

    /* renamed from: p  reason: collision with root package name */
    boolean f1650p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1651q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1652r;

    /* renamed from: b  reason: collision with root package name */
    final C0015a f1636b = new C0015a();

    /* renamed from: c  reason: collision with root package name */
    private final Interpolator f1637c = new AccelerateInterpolator();

    /* renamed from: f  reason: collision with root package name */
    private float[] f1640f = {0.0f, 0.0f};

    /* renamed from: g  reason: collision with root package name */
    private float[] f1641g = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: j  reason: collision with root package name */
    private float[] f1644j = {0.0f, 0.0f};

    /* renamed from: k  reason: collision with root package name */
    private float[] f1645k = {0.0f, 0.0f};

    /* renamed from: l  reason: collision with root package name */
    private float[] f1646l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a {

        /* renamed from: a  reason: collision with root package name */
        private int f1653a;

        /* renamed from: b  reason: collision with root package name */
        private int f1654b;

        /* renamed from: c  reason: collision with root package name */
        private float f1655c;

        /* renamed from: d  reason: collision with root package name */
        private float f1656d;

        /* renamed from: j  reason: collision with root package name */
        private float f1662j;

        /* renamed from: k  reason: collision with root package name */
        private int f1663k;

        /* renamed from: e  reason: collision with root package name */
        private long f1657e = Long.MIN_VALUE;

        /* renamed from: i  reason: collision with root package name */
        private long f1661i = -1;

        /* renamed from: f  reason: collision with root package name */
        private long f1658f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f1659g = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f1660h = 0;

        C0015a() {
        }

        private float e(long j6) {
            long j7 = this.f1657e;
            if (j6 < j7) {
                return 0.0f;
            }
            long j8 = this.f1661i;
            if (j8 < 0 || j6 < j8) {
                return a.e(((float) (j6 - j7)) / this.f1653a, 0.0f, 1.0f) * 0.5f;
            }
            float f6 = this.f1662j;
            return (1.0f - f6) + (f6 * a.e(((float) (j6 - j8)) / this.f1663k, 0.0f, 1.0f));
        }

        private float g(float f6) {
            return ((-4.0f) * f6 * f6) + (f6 * 4.0f);
        }

        public void a() {
            if (this.f1658f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float g6 = g(e(currentAnimationTimeMillis));
            this.f1658f = currentAnimationTimeMillis;
            float f6 = ((float) (currentAnimationTimeMillis - this.f1658f)) * g6;
            this.f1659g = (int) (this.f1655c * f6);
            this.f1660h = (int) (f6 * this.f1656d);
        }

        public int b() {
            return this.f1659g;
        }

        public int c() {
            return this.f1660h;
        }

        public int d() {
            float f6 = this.f1655c;
            return (int) (f6 / Math.abs(f6));
        }

        public int f() {
            float f6 = this.f1656d;
            return (int) (f6 / Math.abs(f6));
        }

        public boolean h() {
            return this.f1661i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1661i + ((long) this.f1663k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1663k = a.f((int) (currentAnimationTimeMillis - this.f1657e), 0, this.f1654b);
            this.f1662j = e(currentAnimationTimeMillis);
            this.f1661i = currentAnimationTimeMillis;
        }

        public void j(int i6) {
            this.f1654b = i6;
        }

        public void k(int i6) {
            this.f1653a = i6;
        }

        public void l(float f6, float f7) {
            this.f1655c = f6;
            this.f1656d = f7;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1657e = currentAnimationTimeMillis;
            this.f1661i = -1L;
            this.f1658f = currentAnimationTimeMillis;
            this.f1662j = 0.5f;
            this.f1659g = 0;
            this.f1660h = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f1650p) {
                if (aVar.f1648n) {
                    aVar.f1648n = false;
                    aVar.f1636b.m();
                }
                C0015a c0015a = a.this.f1636b;
                if (c0015a.h() || !a.this.u()) {
                    a.this.f1650p = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f1649o) {
                    aVar2.f1649o = false;
                    aVar2.c();
                }
                c0015a.a();
                a.this.j(c0015a.b(), c0015a.c());
                b0.d0(a.this.f1638d, this);
            }
        }
    }

    public a(View view) {
        this.f1638d = view;
        float f6 = Resources.getSystem().getDisplayMetrics().density;
        float f7 = (int) ((1575.0f * f6) + 0.5f);
        o(f7, f7);
        float f8 = (int) ((f6 * 315.0f) + 0.5f);
        p(f8, f8);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f1635s);
        r(500);
        q(500);
    }

    private float d(int i6, float f6, float f7, float f8) {
        float h6 = h(this.f1640f[i6], f7, this.f1641g[i6], f6);
        int i7 = (h6 > 0.0f ? 1 : (h6 == 0.0f ? 0 : -1));
        if (i7 == 0) {
            return 0.0f;
        }
        float f9 = this.f1644j[i6];
        float f10 = this.f1645k[i6];
        float f11 = this.f1646l[i6];
        float f12 = f9 * f8;
        return i7 > 0 ? e(h6 * f12, f10, f11) : -e((-h6) * f12, f10, f11);
    }

    static float e(float f6, float f7, float f8) {
        return f6 > f8 ? f8 : f6 < f7 ? f7 : f6;
    }

    static int f(int i6, int i7, int i8) {
        return i6 > i8 ? i8 : i6 < i7 ? i7 : i6;
    }

    private float g(float f6, float f7) {
        if (f7 == 0.0f) {
            return 0.0f;
        }
        int i6 = this.f1642h;
        if (i6 == 0 || i6 == 1) {
            if (f6 < f7) {
                if (f6 >= 0.0f) {
                    return 1.0f - (f6 / f7);
                }
                if (this.f1650p && i6 == 1) {
                    return 1.0f;
                }
            }
        } else if (i6 == 2 && f6 < 0.0f) {
            return f6 / (-f7);
        }
        return 0.0f;
    }

    private float h(float f6, float f7, float f8, float f9) {
        float interpolation;
        float e6 = e(f6 * f7, 0.0f, f8);
        float g6 = g(f7 - f9, e6) - g(f9, e6);
        if (g6 < 0.0f) {
            interpolation = -this.f1637c.getInterpolation(-g6);
        } else if (g6 <= 0.0f) {
            return 0.0f;
        } else {
            interpolation = this.f1637c.getInterpolation(g6);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f1648n) {
            this.f1650p = false;
        } else {
            this.f1636b.i();
        }
    }

    private void v() {
        int i6;
        if (this.f1639e == null) {
            this.f1639e = new b();
        }
        this.f1650p = true;
        this.f1648n = true;
        if (this.f1647m || (i6 = this.f1643i) <= 0) {
            this.f1639e.run();
        } else {
            b0.e0(this.f1638d, this.f1639e, i6);
        }
        this.f1647m = true;
    }

    public abstract boolean a(int i6);

    public abstract boolean b(int i6);

    void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1638d.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i6, int i7);

    public a k(int i6) {
        this.f1643i = i6;
        return this;
    }

    public a l(int i6) {
        this.f1642h = i6;
        return this;
    }

    public a m(boolean z5) {
        if (this.f1651q && !z5) {
            i();
        }
        this.f1651q = z5;
        return this;
    }

    public a n(float f6, float f7) {
        float[] fArr = this.f1641g;
        fArr[0] = f6;
        fArr[1] = f7;
        return this;
    }

    public a o(float f6, float f7) {
        float[] fArr = this.f1646l;
        fArr[0] = f6 / 1000.0f;
        fArr[1] = f7 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f1651q) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                }
            }
            i();
            return this.f1652r && this.f1650p;
        }
        this.f1649o = true;
        this.f1647m = false;
        this.f1636b.l(d(0, motionEvent.getX(), view.getWidth(), this.f1638d.getWidth()), d(1, motionEvent.getY(), view.getHeight(), this.f1638d.getHeight()));
        if (!this.f1650p && u()) {
            v();
        }
        if (this.f1652r) {
            return false;
        }
    }

    public a p(float f6, float f7) {
        float[] fArr = this.f1645k;
        fArr[0] = f6 / 1000.0f;
        fArr[1] = f7 / 1000.0f;
        return this;
    }

    public a q(int i6) {
        this.f1636b.j(i6);
        return this;
    }

    public a r(int i6) {
        this.f1636b.k(i6);
        return this;
    }

    public a s(float f6, float f7) {
        float[] fArr = this.f1640f;
        fArr[0] = f6;
        fArr[1] = f7;
        return this;
    }

    public a t(float f6, float f7) {
        float[] fArr = this.f1644j;
        fArr[0] = f6 / 1000.0f;
        fArr[1] = f7 / 1000.0f;
        return this;
    }

    boolean u() {
        C0015a c0015a = this.f1636b;
        int f6 = c0015a.f();
        int d6 = c0015a.d();
        return (f6 != 0 && b(f6)) || (d6 != 0 && a(d6));
    }
}
