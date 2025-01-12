package me.imid.swipebacklayout.lib;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.util.Arrays;
/* loaded from: classes.dex */
public class a {

    /* renamed from: w  reason: collision with root package name */
    private static final Interpolator f12030w = new animation.InterpolatorC0196a();

    /* renamed from: a  reason: collision with root package name */
    private int f12031a;

    /* renamed from: b  reason: collision with root package name */
    private int f12032b;

    /* renamed from: d  reason: collision with root package name */
    private float[] f12034d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f12035e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f12036f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f12037g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f12038h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f12039i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f12040j;

    /* renamed from: k  reason: collision with root package name */
    private int f12041k;

    /* renamed from: l  reason: collision with root package name */
    private VelocityTracker f12042l;

    /* renamed from: m  reason: collision with root package name */
    private float f12043m;

    /* renamed from: n  reason: collision with root package name */
    private float f12044n;

    /* renamed from: o  reason: collision with root package name */
    private int f12045o;

    /* renamed from: p  reason: collision with root package name */
    private int f12046p;

    /* renamed from: q  reason: collision with root package name */
    private Scroller f12047q;

    /* renamed from: r  reason: collision with root package name */
    private final c f12048r;

    /* renamed from: s  reason: collision with root package name */
    private View f12049s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f12050t;

    /* renamed from: u  reason: collision with root package name */
    private final ViewGroup f12051u;

    /* renamed from: c  reason: collision with root package name */
    private int f12033c = -1;

    /* renamed from: v  reason: collision with root package name */
    private final Runnable f12052v = new b();

    /* renamed from: me.imid.swipebacklayout.lib.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class animation.InterpolatorC0196a implements Interpolator {
        animation.InterpolatorC0196a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7 = f6 - 1.0f;
            return (f7 * f7 * f7 * f7 * f7) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.E(0);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract int a(View view, int i6, int i7);

        public abstract int b(View view, int i6, int i7);

        public int c(int i6) {
            return i6;
        }

        public abstract int d(View view);

        public abstract int e(View view);

        public void f(int i6, int i7) {
        }

        public boolean g(int i6) {
            return false;
        }

        public void h(int i6, int i7) {
        }

        public void i(View view, int i6) {
        }

        public void j(int i6) {
        }

        public void k(View view, int i6, int i7, int i8, int i9) {
        }

        public abstract void l(View view, float f6, float f7);

        public abstract boolean m(View view, int i6);
    }

    private a(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f12051u = viewGroup;
        this.f12048r = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f12045o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f12032b = viewConfiguration.getScaledTouchSlop();
        this.f12043m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f12044n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f12047q = new Scroller(context, f12030w);
    }

    private void A() {
        this.f12042l.computeCurrentVelocity(1000, this.f12043m);
        n(f(this.f12042l.getXVelocity(this.f12033c), this.f12044n, this.f12043m), f(this.f12042l.getYVelocity(this.f12033c), this.f12044n, this.f12043m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [me.imid.swipebacklayout.lib.a$c] */
    private void B(float f6, float f7, int i6) {
        boolean c6 = c(f6, f7, i6, 1);
        boolean z5 = c6;
        if (c(f7, f6, i6, 4)) {
            z5 = c6 | true;
        }
        boolean z6 = z5;
        if (c(f6, f7, i6, 2)) {
            z6 = (z5 ? 1 : 0) | true;
        }
        ?? r02 = z6;
        if (c(f7, f6, i6, 8)) {
            r02 = (z6 ? 1 : 0) | true;
        }
        if (r02 != 0) {
            int[] iArr = this.f12039i;
            iArr[i6] = iArr[i6] | r02;
            this.f12048r.f(r02, i6);
        }
    }

    private void C(float f6, float f7, int i6) {
        q(i6);
        float[] fArr = this.f12034d;
        this.f12036f[i6] = f6;
        fArr[i6] = f6;
        float[] fArr2 = this.f12035e;
        this.f12037g[i6] = f7;
        fArr2[i6] = f7;
        this.f12038h[i6] = t((int) f6, (int) f7);
        this.f12041k |= 1 << i6;
    }

    private void D(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i6 = 0; i6 < pointerCount; i6++) {
            int pointerId = motionEvent.getPointerId(i6);
            float x5 = motionEvent.getX(i6);
            float y5 = motionEvent.getY(i6);
            this.f12036f[pointerId] = x5;
            this.f12037g[pointerId] = y5;
        }
    }

    private boolean c(float f6, float f7, int i6, int i7) {
        float abs = Math.abs(f6);
        float abs2 = Math.abs(f7);
        if ((this.f12038h[i6] & i7) != i7 || (this.f12046p & i7) == 0 || (this.f12040j[i6] & i7) == i7 || (this.f12039i[i6] & i7) == i7) {
            return false;
        }
        int i8 = this.f12032b;
        if (abs > i8 || abs2 > i8) {
            if (abs >= abs2 * 0.5f || !this.f12048r.g(i7)) {
                return (this.f12039i[i6] & i7) == 0 && abs > ((float) this.f12032b);
            }
            int[] iArr = this.f12040j;
            iArr[i6] = iArr[i6] | i7;
            return false;
        }
        return false;
    }

    private boolean e(View view, float f6, float f7) {
        if (view == null) {
            return false;
        }
        boolean z5 = this.f12048r.d(view) > 0;
        boolean z6 = this.f12048r.e(view) > 0;
        if (!z5 || !z6) {
            return z5 ? Math.abs(f6) > ((float) this.f12032b) : z6 && Math.abs(f7) > ((float) this.f12032b);
        }
        int i6 = this.f12032b;
        return (f6 * f6) + (f7 * f7) > ((float) (i6 * i6));
    }

    private float f(float f6, float f7, float f8) {
        float abs = Math.abs(f6);
        if (abs < f7) {
            return 0.0f;
        }
        return abs > f8 ? f6 > 0.0f ? f8 : -f8 : f6;
    }

    private int g(int i6, int i7, int i8) {
        int abs = Math.abs(i6);
        if (abs < i7) {
            return 0;
        }
        return abs > i8 ? i6 > 0 ? i8 : -i8 : i6;
    }

    private void h() {
        float[] fArr = this.f12034d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f12035e, 0.0f);
        Arrays.fill(this.f12036f, 0.0f);
        Arrays.fill(this.f12037g, 0.0f);
        Arrays.fill(this.f12038h, 0);
        Arrays.fill(this.f12039i, 0);
        Arrays.fill(this.f12040j, 0);
        this.f12041k = 0;
    }

    private void i(int i6) {
        float[] fArr = this.f12034d;
        if (fArr == null) {
            return;
        }
        fArr[i6] = 0.0f;
        this.f12035e[i6] = 0.0f;
        this.f12036f[i6] = 0.0f;
        this.f12037g[i6] = 0.0f;
        this.f12038h[i6] = 0;
        this.f12039i[i6] = 0;
        this.f12040j[i6] = 0;
        this.f12041k = (~(1 << i6)) & this.f12041k;
    }

    private int j(int i6, int i7, int i8) {
        if (i6 == 0) {
            return 0;
        }
        int width = this.f12051u.getWidth();
        float f6 = width / 2;
        float o5 = f6 + (o(Math.min(1.0f, Math.abs(i6) / width)) * f6);
        int abs = Math.abs(i7);
        return Math.min(abs > 0 ? Math.round(Math.abs(o5 / abs) * 1000.0f) * 4 : (int) (((Math.abs(i6) / i8) + 1.0f) * 256.0f), 600);
    }

    private int k(View view, int i6, int i7, int i8, int i9) {
        float f6;
        float f7;
        float f8;
        float f9;
        int g6 = g(i8, (int) this.f12044n, (int) this.f12043m);
        int g7 = g(i9, (int) this.f12044n, (int) this.f12043m);
        int abs = Math.abs(i6);
        int abs2 = Math.abs(i7);
        int abs3 = Math.abs(g6);
        int abs4 = Math.abs(g7);
        int i10 = abs3 + abs4;
        int i11 = abs + abs2;
        if (g6 != 0) {
            f6 = abs3;
            f7 = i10;
        } else {
            f6 = abs;
            f7 = i11;
        }
        float f10 = f6 / f7;
        if (g7 != 0) {
            f8 = abs4;
            f9 = i10;
        } else {
            f8 = abs2;
            f9 = i11;
        }
        return (int) ((j(i6, g6, this.f12048r.d(view)) * f10) + (j(i7, g7, this.f12048r.e(view)) * (f8 / f9)));
    }

    public static a m(ViewGroup viewGroup, c cVar) {
        return new a(viewGroup.getContext(), viewGroup, cVar);
    }

    private void n(float f6, float f7) {
        this.f12050t = true;
        this.f12048r.l(this.f12049s, f6, f7);
        this.f12050t = false;
        if (this.f12031a == 1) {
            E(0);
        }
    }

    private float o(float f6) {
        return (float) Math.sin((float) ((f6 - 0.5f) * 0.4712389167638204d));
    }

    private void p(int i6, int i7, int i8, int i9) {
        int left = this.f12049s.getLeft();
        int top = this.f12049s.getTop();
        if (i8 != 0) {
            i6 = this.f12048r.a(this.f12049s, i6, i8);
            this.f12049s.offsetLeftAndRight(i6 - left);
        }
        int i10 = i6;
        if (i9 != 0) {
            i7 = this.f12048r.b(this.f12049s, i7, i9);
            this.f12049s.offsetTopAndBottom(i7 - top);
        }
        int i11 = i7;
        if (i8 == 0 && i9 == 0) {
            return;
        }
        this.f12048r.k(this.f12049s, i10, i11, i10 - left, i11 - top);
    }

    private void q(int i6) {
        float[] fArr = this.f12034d;
        if (fArr == null || fArr.length <= i6) {
            int i7 = i6 + 1;
            float[] fArr2 = new float[i7];
            float[] fArr3 = new float[i7];
            float[] fArr4 = new float[i7];
            float[] fArr5 = new float[i7];
            int[] iArr = new int[i7];
            int[] iArr2 = new int[i7];
            int[] iArr3 = new int[i7];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f12035e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f12036f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f12037g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f12038h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f12039i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f12040j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f12034d = fArr2;
            this.f12035e = fArr3;
            this.f12036f = fArr4;
            this.f12037g = fArr5;
            this.f12038h = iArr;
            this.f12039i = iArr2;
            this.f12040j = iArr3;
        }
    }

    private boolean s(int i6, int i7, int i8, int i9) {
        int left = this.f12049s.getLeft();
        int top = this.f12049s.getTop();
        int i10 = i6 - left;
        int i11 = i7 - top;
        if (i10 == 0 && i11 == 0) {
            this.f12047q.abortAnimation();
            E(0);
            return false;
        }
        this.f12047q.startScroll(left, top, i10, i11, k(this.f12049s, i10, i11, i8, i9));
        E(2);
        return true;
    }

    private int t(int i6, int i7) {
        int i8 = i6 < this.f12051u.getLeft() + this.f12045o ? 1 : 0;
        if (i7 < this.f12051u.getTop() + this.f12045o) {
            i8 = 4;
        }
        if (i6 > this.f12051u.getRight() - this.f12045o) {
            i8 = 2;
        }
        if (i7 > this.f12051u.getBottom() - this.f12045o) {
            return 8;
        }
        return i8;
    }

    void E(int i6) {
        if (this.f12031a != i6) {
            this.f12031a = i6;
            this.f12048r.j(i6);
            if (i6 == 0) {
                this.f12049s = null;
            }
        }
    }

    public void F(int i6) {
        this.f12045o = i6;
    }

    public void G(int i6) {
        this.f12046p = i6;
    }

    public void H(float f6) {
        this.f12043m = f6;
    }

    public void I(float f6) {
        this.f12044n = f6;
    }

    public boolean J(int i6, int i7) {
        if (this.f12050t) {
            return s(i6, i7, (int) this.f12042l.getXVelocity(this.f12033c), (int) this.f12042l.getYVelocity(this.f12033c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean K(MotionEvent motionEvent) {
        View r5;
        View r6;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f12042l == null) {
            this.f12042l = VelocityTracker.obtain();
        }
        this.f12042l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i6 = 0; i6 < pointerCount; i6++) {
                        int pointerId = motionEvent.getPointerId(i6);
                        float x5 = motionEvent.getX(i6);
                        float y5 = motionEvent.getY(i6);
                        float f6 = x5 - this.f12034d[pointerId];
                        float f7 = y5 - this.f12035e[pointerId];
                        B(f6, f7, pointerId);
                        if (this.f12031a == 1 || ((r5 = r((int) x5, (int) y5)) != null && e(r5, f6, f7) && L(r5, pointerId))) {
                            break;
                        }
                    }
                    D(motionEvent);
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = motionEvent.getPointerId(actionIndex);
                        float x6 = motionEvent.getX(actionIndex);
                        float y6 = motionEvent.getY(actionIndex);
                        C(x6, y6, pointerId2);
                        int i7 = this.f12031a;
                        if (i7 == 0) {
                            int i8 = this.f12038h[pointerId2];
                            int i9 = this.f12046p;
                            if ((i8 & i9) != 0) {
                                this.f12048r.h(i8 & i9, pointerId2);
                            }
                        } else if (i7 == 2 && (r6 = r((int) x6, (int) y6)) == this.f12049s) {
                            L(r6, pointerId2);
                        }
                    } else if (actionMasked == 6) {
                        i(motionEvent.getPointerId(actionIndex));
                    }
                }
            }
            a();
        } else {
            float x7 = motionEvent.getX();
            float y7 = motionEvent.getY();
            int pointerId3 = motionEvent.getPointerId(0);
            C(x7, y7, pointerId3);
            View r7 = r((int) x7, (int) y7);
            if (r7 == this.f12049s && this.f12031a == 2) {
                L(r7, pointerId3);
            }
            int i10 = this.f12038h[pointerId3];
            int i11 = this.f12046p;
            if ((i10 & i11) != 0) {
                this.f12048r.h(i10 & i11, pointerId3);
            }
        }
        return this.f12031a == 1;
    }

    boolean L(View view, int i6) {
        if (view == this.f12049s && this.f12033c == i6) {
            return true;
        }
        if (view == null || !this.f12048r.m(view, i6)) {
            return false;
        }
        this.f12033c = i6;
        b(view, i6);
        return true;
    }

    public void a() {
        this.f12033c = -1;
        h();
        VelocityTracker velocityTracker = this.f12042l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f12042l = null;
        }
    }

    public void b(View view, int i6) {
        if (view.getParent() == this.f12051u) {
            this.f12049s = view;
            this.f12033c = i6;
            this.f12048r.i(view, i6);
            E(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f12051u + ")");
    }

    public boolean d(int i6, int i7) {
        if (x(i7)) {
            boolean z5 = (i6 & 1) == 1;
            boolean z6 = (i6 & 2) == 2;
            float f6 = this.f12036f[i7] - this.f12034d[i7];
            float f7 = this.f12037g[i7] - this.f12035e[i7];
            if (!z5 || !z6) {
                return z5 ? Math.abs(f6) > ((float) this.f12032b) : z6 && Math.abs(f7) > ((float) this.f12032b);
            }
            int i8 = this.f12032b;
            return (f6 * f6) + (f7 * f7) > ((float) (i8 * i8));
        }
        return false;
    }

    public boolean l(boolean z5) {
        if (this.f12031a == 2) {
            boolean computeScrollOffset = this.f12047q.computeScrollOffset();
            int currX = this.f12047q.getCurrX();
            int currY = this.f12047q.getCurrY();
            int left = currX - this.f12049s.getLeft();
            int top = currY - this.f12049s.getTop();
            if (left != 0) {
                this.f12049s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f12049s.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f12048r.k(this.f12049s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f12047q.getFinalX() && currY == this.f12047q.getFinalY()) {
                this.f12047q.abortAnimation();
                computeScrollOffset = this.f12047q.isFinished();
            }
            if (!computeScrollOffset) {
                if (z5) {
                    this.f12051u.post(this.f12052v);
                } else {
                    E(0);
                }
            }
        }
        return this.f12031a == 2;
    }

    public View r(int i6, int i7) {
        for (int childCount = this.f12051u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f12051u.getChildAt(this.f12048r.c(childCount));
            if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && i7 >= childAt.getTop() && i7 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public int u() {
        return this.f12031a;
    }

    public boolean v(int i6, int i7) {
        return y(this.f12049s, i6, i7);
    }

    public boolean w(int i6, int i7) {
        return x(i7) && (i6 & this.f12038h[i7]) != 0;
    }

    public boolean x(int i6) {
        return ((1 << i6) & this.f12041k) != 0;
    }

    public boolean y(View view, int i6, int i7) {
        return view != null && i6 >= view.getLeft() && i6 < view.getRight() && i7 >= view.getTop() && i7 < view.getBottom();
    }

    public void z(MotionEvent motionEvent) {
        int i6;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f12042l == null) {
            this.f12042l = VelocityTracker.obtain();
        }
        this.f12042l.addMovement(motionEvent);
        int i7 = 0;
        if (actionMasked == 0) {
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View r5 = r((int) x5, (int) y5);
            C(x5, y5, pointerId);
            L(r5, pointerId);
            int i8 = this.f12038h[pointerId];
            int i9 = this.f12046p;
            if ((i8 & i9) != 0) {
                this.f12048r.h(i8 & i9, pointerId);
                return;
            }
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.f12031a != 1) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i7 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i7);
                        float x6 = motionEvent.getX(i7);
                        float y6 = motionEvent.getY(i7);
                        float f6 = x6 - this.f12034d[pointerId2];
                        float f7 = y6 - this.f12035e[pointerId2];
                        B(f6, f7, pointerId2);
                        if (this.f12031a != 1) {
                            View r6 = r((int) x6, (int) y6);
                            if (e(r6, f6, f7) && L(r6, pointerId2)) {
                                break;
                            }
                            i7++;
                        } else {
                            break;
                        }
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f12033c);
                    float x7 = motionEvent.getX(findPointerIndex);
                    float y7 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f12036f;
                    int i10 = this.f12033c;
                    int i11 = (int) (x7 - fArr[i10]);
                    int i12 = (int) (y7 - this.f12037g[i10]);
                    p(this.f12049s.getLeft() + i11, this.f12049s.getTop() + i12, i11, i12);
                }
                D(motionEvent);
                return;
            } else if (actionMasked != 3) {
                if (actionMasked == 5) {
                    int pointerId3 = motionEvent.getPointerId(actionIndex);
                    float x8 = motionEvent.getX(actionIndex);
                    float y8 = motionEvent.getY(actionIndex);
                    C(x8, y8, pointerId3);
                    if (this.f12031a != 0) {
                        if (v((int) x8, (int) y8)) {
                            L(this.f12049s, pointerId3);
                            return;
                        }
                        return;
                    }
                    L(r((int) x8, (int) y8), pointerId3);
                    int i13 = this.f12038h[pointerId3];
                    int i14 = this.f12046p;
                    if ((i13 & i14) != 0) {
                        this.f12048r.h(i13 & i14, pointerId3);
                        return;
                    }
                    return;
                } else if (actionMasked != 6) {
                    return;
                } else {
                    int pointerId4 = motionEvent.getPointerId(actionIndex);
                    if (this.f12031a == 1 && pointerId4 == this.f12033c) {
                        int pointerCount2 = motionEvent.getPointerCount();
                        while (true) {
                            if (i7 >= pointerCount2) {
                                i6 = -1;
                                break;
                            }
                            int pointerId5 = motionEvent.getPointerId(i7);
                            if (pointerId5 != this.f12033c) {
                                View r7 = r((int) motionEvent.getX(i7), (int) motionEvent.getY(i7));
                                View view = this.f12049s;
                                if (r7 == view && L(view, pointerId5)) {
                                    i6 = this.f12033c;
                                    break;
                                }
                            }
                            i7++;
                        }
                        if (i6 == -1) {
                            A();
                        }
                    }
                    i(pointerId4);
                    return;
                }
            } else if (this.f12031a == 1) {
                n(0.0f, 0.0f);
            }
        } else if (this.f12031a == 1) {
            A();
        }
        a();
    }
}
