package i0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import e0.b0;
import java.util.Arrays;
/* loaded from: classes.dex */
public class c {

    /* renamed from: w  reason: collision with root package name */
    private static final Interpolator f10846w = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f10847a;

    /* renamed from: b  reason: collision with root package name */
    private int f10848b;

    /* renamed from: d  reason: collision with root package name */
    private float[] f10850d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f10851e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f10852f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f10853g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f10854h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f10855i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f10856j;

    /* renamed from: k  reason: collision with root package name */
    private int f10857k;

    /* renamed from: l  reason: collision with root package name */
    private VelocityTracker f10858l;

    /* renamed from: m  reason: collision with root package name */
    private float f10859m;

    /* renamed from: n  reason: collision with root package name */
    private float f10860n;

    /* renamed from: o  reason: collision with root package name */
    private int f10861o;

    /* renamed from: p  reason: collision with root package name */
    private int f10862p;

    /* renamed from: q  reason: collision with root package name */
    private OverScroller f10863q;

    /* renamed from: r  reason: collision with root package name */
    private final AbstractC0177c f10864r;

    /* renamed from: s  reason: collision with root package name */
    private View f10865s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f10866t;

    /* renamed from: u  reason: collision with root package name */
    private final ViewGroup f10867u;

    /* renamed from: c  reason: collision with root package name */
    private int f10849c = -1;

    /* renamed from: v  reason: collision with root package name */
    private final Runnable f10868v = new b();

    /* loaded from: classes.dex */
    static class a implements Interpolator {
        a() {
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
            c.this.E(0);
        }
    }

    /* renamed from: i0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0177c {
        public abstract int a(View view, int i6, int i7);

        public abstract int b(View view, int i6, int i7);

        public int c(int i6) {
            return i6;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i6, int i7) {
        }

        public boolean g(int i6) {
            return false;
        }

        public void h(int i6, int i7) {
        }

        public void i(View view, int i6) {
        }

        public abstract void j(int i6);

        public abstract void k(View view, int i6, int i7, int i8, int i9);

        public abstract void l(View view, float f6, float f7);

        public abstract boolean m(View view, int i6);
    }

    private c(Context context, ViewGroup viewGroup, AbstractC0177c abstractC0177c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0177c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f10867u = viewGroup;
        this.f10864r = abstractC0177c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f10861o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f10848b = viewConfiguration.getScaledTouchSlop();
        this.f10859m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f10860n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f10863q = new OverScroller(context, f10846w);
    }

    private void A() {
        this.f10858l.computeCurrentVelocity(1000, this.f10859m);
        n(e(this.f10858l.getXVelocity(this.f10849c), this.f10860n, this.f10859m), e(this.f10858l.getYVelocity(this.f10849c), this.f10860n, this.f10859m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [i0.c$c] */
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
            int[] iArr = this.f10855i;
            iArr[i6] = iArr[i6] | r02;
            this.f10864r.f(r02, i6);
        }
    }

    private void C(float f6, float f7, int i6) {
        q(i6);
        float[] fArr = this.f10850d;
        this.f10852f[i6] = f6;
        fArr[i6] = f6;
        float[] fArr2 = this.f10851e;
        this.f10853g[i6] = f7;
        fArr2[i6] = f7;
        this.f10854h[i6] = t((int) f6, (int) f7);
        this.f10857k |= 1 << i6;
    }

    private void D(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i6 = 0; i6 < pointerCount; i6++) {
            int pointerId = motionEvent.getPointerId(i6);
            if (x(pointerId)) {
                float x5 = motionEvent.getX(i6);
                float y5 = motionEvent.getY(i6);
                this.f10852f[pointerId] = x5;
                this.f10853g[pointerId] = y5;
            }
        }
    }

    private boolean c(float f6, float f7, int i6, int i7) {
        float abs = Math.abs(f6);
        float abs2 = Math.abs(f7);
        if ((this.f10854h[i6] & i7) != i7 || (this.f10862p & i7) == 0 || (this.f10856j[i6] & i7) == i7 || (this.f10855i[i6] & i7) == i7) {
            return false;
        }
        int i8 = this.f10848b;
        if (abs > i8 || abs2 > i8) {
            if (abs >= abs2 * 0.5f || !this.f10864r.g(i7)) {
                return (this.f10855i[i6] & i7) == 0 && abs > ((float) this.f10848b);
            }
            int[] iArr = this.f10856j;
            iArr[i6] = iArr[i6] | i7;
            return false;
        }
        return false;
    }

    private boolean d(View view, float f6, float f7) {
        if (view == null) {
            return false;
        }
        boolean z5 = this.f10864r.d(view) > 0;
        boolean z6 = this.f10864r.e(view) > 0;
        if (!z5 || !z6) {
            return z5 ? Math.abs(f6) > ((float) this.f10848b) : z6 && Math.abs(f7) > ((float) this.f10848b);
        }
        int i6 = this.f10848b;
        return (f6 * f6) + (f7 * f7) > ((float) (i6 * i6));
    }

    private float e(float f6, float f7, float f8) {
        float abs = Math.abs(f6);
        if (abs < f7) {
            return 0.0f;
        }
        return abs > f8 ? f6 > 0.0f ? f8 : -f8 : f6;
    }

    private int f(int i6, int i7, int i8) {
        int abs = Math.abs(i6);
        if (abs < i7) {
            return 0;
        }
        return abs > i8 ? i6 > 0 ? i8 : -i8 : i6;
    }

    private void g() {
        float[] fArr = this.f10850d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f10851e, 0.0f);
        Arrays.fill(this.f10852f, 0.0f);
        Arrays.fill(this.f10853g, 0.0f);
        Arrays.fill(this.f10854h, 0);
        Arrays.fill(this.f10855i, 0);
        Arrays.fill(this.f10856j, 0);
        this.f10857k = 0;
    }

    private void h(int i6) {
        if (this.f10850d == null || !w(i6)) {
            return;
        }
        this.f10850d[i6] = 0.0f;
        this.f10851e[i6] = 0.0f;
        this.f10852f[i6] = 0.0f;
        this.f10853g[i6] = 0.0f;
        this.f10854h[i6] = 0;
        this.f10855i[i6] = 0;
        this.f10856j[i6] = 0;
        this.f10857k = (~(1 << i6)) & this.f10857k;
    }

    private int i(int i6, int i7, int i8) {
        if (i6 == 0) {
            return 0;
        }
        int width = this.f10867u.getWidth();
        float f6 = width / 2;
        float o5 = f6 + (o(Math.min(1.0f, Math.abs(i6) / width)) * f6);
        int abs = Math.abs(i7);
        return Math.min(abs > 0 ? Math.round(Math.abs(o5 / abs) * 1000.0f) * 4 : (int) (((Math.abs(i6) / i8) + 1.0f) * 256.0f), 600);
    }

    private int j(View view, int i6, int i7, int i8, int i9) {
        float f6;
        float f7;
        float f8;
        float f9;
        int f10 = f(i8, (int) this.f10860n, (int) this.f10859m);
        int f11 = f(i9, (int) this.f10860n, (int) this.f10859m);
        int abs = Math.abs(i6);
        int abs2 = Math.abs(i7);
        int abs3 = Math.abs(f10);
        int abs4 = Math.abs(f11);
        int i10 = abs3 + abs4;
        int i11 = abs + abs2;
        if (f10 != 0) {
            f6 = abs3;
            f7 = i10;
        } else {
            f6 = abs;
            f7 = i11;
        }
        float f12 = f6 / f7;
        if (f11 != 0) {
            f8 = abs4;
            f9 = i10;
        } else {
            f8 = abs2;
            f9 = i11;
        }
        return (int) ((i(i6, f10, this.f10864r.d(view)) * f12) + (i(i7, f11, this.f10864r.e(view)) * (f8 / f9)));
    }

    public static c l(ViewGroup viewGroup, float f6, AbstractC0177c abstractC0177c) {
        c m5 = m(viewGroup, abstractC0177c);
        m5.f10848b = (int) (m5.f10848b * (1.0f / f6));
        return m5;
    }

    public static c m(ViewGroup viewGroup, AbstractC0177c abstractC0177c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0177c);
    }

    private void n(float f6, float f7) {
        this.f10866t = true;
        this.f10864r.l(this.f10865s, f6, f7);
        this.f10866t = false;
        if (this.f10847a == 1) {
            E(0);
        }
    }

    private float o(float f6) {
        return (float) Math.sin((f6 - 0.5f) * 0.47123894f);
    }

    private void p(int i6, int i7, int i8, int i9) {
        int left = this.f10865s.getLeft();
        int top = this.f10865s.getTop();
        if (i8 != 0) {
            i6 = this.f10864r.a(this.f10865s, i6, i8);
            b0.W(this.f10865s, i6 - left);
        }
        int i10 = i6;
        if (i9 != 0) {
            i7 = this.f10864r.b(this.f10865s, i7, i9);
            b0.X(this.f10865s, i7 - top);
        }
        int i11 = i7;
        if (i8 == 0 && i9 == 0) {
            return;
        }
        this.f10864r.k(this.f10865s, i10, i11, i10 - left, i11 - top);
    }

    private void q(int i6) {
        float[] fArr = this.f10850d;
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
                float[] fArr6 = this.f10851e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f10852f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f10853g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f10854h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f10855i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f10856j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f10850d = fArr2;
            this.f10851e = fArr3;
            this.f10852f = fArr4;
            this.f10853g = fArr5;
            this.f10854h = iArr;
            this.f10855i = iArr2;
            this.f10856j = iArr3;
        }
    }

    private boolean s(int i6, int i7, int i8, int i9) {
        int left = this.f10865s.getLeft();
        int top = this.f10865s.getTop();
        int i10 = i6 - left;
        int i11 = i7 - top;
        if (i10 == 0 && i11 == 0) {
            this.f10863q.abortAnimation();
            E(0);
            return false;
        }
        this.f10863q.startScroll(left, top, i10, i11, j(this.f10865s, i10, i11, i8, i9));
        E(2);
        return true;
    }

    private int t(int i6, int i7) {
        int i8 = i6 < this.f10867u.getLeft() + this.f10861o ? 1 : 0;
        if (i7 < this.f10867u.getTop() + this.f10861o) {
            i8 |= 4;
        }
        if (i6 > this.f10867u.getRight() - this.f10861o) {
            i8 |= 2;
        }
        return i7 > this.f10867u.getBottom() - this.f10861o ? i8 | 8 : i8;
    }

    private boolean x(int i6) {
        if (w(i6)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i6 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    void E(int i6) {
        this.f10867u.removeCallbacks(this.f10868v);
        if (this.f10847a != i6) {
            this.f10847a = i6;
            this.f10864r.j(i6);
            if (this.f10847a == 0) {
                this.f10865s = null;
            }
        }
    }

    public boolean F(int i6, int i7) {
        if (this.f10866t) {
            return s(i6, i7, (int) this.f10858l.getXVelocity(this.f10849c), (int) this.f10858l.getYVelocity(this.f10849c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00dd, code lost:
        if (r12 != r11) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean G(MotionEvent motionEvent) {
        boolean z5;
        View r5;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f10858l == null) {
            this.f10858l = VelocityTracker.obtain();
        }
        this.f10858l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            float x5 = motionEvent.getX(actionIndex);
                            float y5 = motionEvent.getY(actionIndex);
                            C(x5, y5, pointerId);
                            int i6 = this.f10847a;
                            if (i6 == 0) {
                                int i7 = this.f10854h[pointerId];
                                int i8 = this.f10862p;
                                if ((i7 & i8) != 0) {
                                    this.f10864r.h(i7 & i8, pointerId);
                                }
                            } else if (i6 == 2 && (r5 = r((int) x5, (int) y5)) == this.f10865s) {
                                I(r5, pointerId);
                            }
                        } else if (actionMasked == 6) {
                            h(motionEvent.getPointerId(actionIndex));
                        }
                    }
                } else if (this.f10850d != null && this.f10851e != null) {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i9 = 0; i9 < pointerCount; i9++) {
                        int pointerId2 = motionEvent.getPointerId(i9);
                        if (x(pointerId2)) {
                            float x6 = motionEvent.getX(i9);
                            float y6 = motionEvent.getY(i9);
                            float f6 = x6 - this.f10850d[pointerId2];
                            float f7 = y6 - this.f10851e[pointerId2];
                            View r6 = r((int) x6, (int) y6);
                            boolean z6 = r6 != null && d(r6, f6, f7);
                            if (z6) {
                                int left = r6.getLeft();
                                int i10 = (int) f6;
                                int a6 = this.f10864r.a(r6, left + i10, i10);
                                int top = r6.getTop();
                                int i11 = (int) f7;
                                int b6 = this.f10864r.b(r6, top + i11, i11);
                                int d6 = this.f10864r.d(r6);
                                int e6 = this.f10864r.e(r6);
                                if (d6 != 0) {
                                    if (d6 > 0) {
                                    }
                                }
                                if (e6 == 0) {
                                    break;
                                } else if (e6 > 0 && b6 == top) {
                                    break;
                                }
                            }
                            B(f6, f7, pointerId2);
                            if (this.f10847a != 1) {
                                if (z6 && I(r6, pointerId2)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    D(motionEvent);
                }
                z5 = false;
            }
            a();
            z5 = false;
        } else {
            float x7 = motionEvent.getX();
            float y7 = motionEvent.getY();
            z5 = false;
            int pointerId3 = motionEvent.getPointerId(0);
            C(x7, y7, pointerId3);
            View r7 = r((int) x7, (int) y7);
            if (r7 == this.f10865s && this.f10847a == 2) {
                I(r7, pointerId3);
            }
            int i12 = this.f10854h[pointerId3];
            int i13 = this.f10862p;
            if ((i12 & i13) != 0) {
                this.f10864r.h(i12 & i13, pointerId3);
            }
        }
        if (this.f10847a == 1) {
            return true;
        }
        return z5;
    }

    public boolean H(View view, int i6, int i7) {
        this.f10865s = view;
        this.f10849c = -1;
        boolean s5 = s(i6, i7, 0, 0);
        if (!s5 && this.f10847a == 0 && this.f10865s != null) {
            this.f10865s = null;
        }
        return s5;
    }

    boolean I(View view, int i6) {
        if (view == this.f10865s && this.f10849c == i6) {
            return true;
        }
        if (view == null || !this.f10864r.m(view, i6)) {
            return false;
        }
        this.f10849c = i6;
        b(view, i6);
        return true;
    }

    public void a() {
        this.f10849c = -1;
        g();
        VelocityTracker velocityTracker = this.f10858l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f10858l = null;
        }
    }

    public void b(View view, int i6) {
        if (view.getParent() == this.f10867u) {
            this.f10865s = view;
            this.f10849c = i6;
            this.f10864r.i(view, i6);
            E(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f10867u + ")");
    }

    public boolean k(boolean z5) {
        if (this.f10847a == 2) {
            boolean computeScrollOffset = this.f10863q.computeScrollOffset();
            int currX = this.f10863q.getCurrX();
            int currY = this.f10863q.getCurrY();
            int left = currX - this.f10865s.getLeft();
            int top = currY - this.f10865s.getTop();
            if (left != 0) {
                b0.W(this.f10865s, left);
            }
            if (top != 0) {
                b0.X(this.f10865s, top);
            }
            if (left != 0 || top != 0) {
                this.f10864r.k(this.f10865s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f10863q.getFinalX() && currY == this.f10863q.getFinalY()) {
                this.f10863q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z5) {
                    this.f10867u.post(this.f10868v);
                } else {
                    E(0);
                }
            }
        }
        return this.f10847a == 2;
    }

    public View r(int i6, int i7) {
        for (int childCount = this.f10867u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f10867u.getChildAt(this.f10864r.c(childCount));
            if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && i7 >= childAt.getTop() && i7 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public int u() {
        return this.f10848b;
    }

    public boolean v(int i6, int i7) {
        return y(this.f10865s, i6, i7);
    }

    public boolean w(int i6) {
        return ((1 << i6) & this.f10857k) != 0;
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
        if (this.f10858l == null) {
            this.f10858l = VelocityTracker.obtain();
        }
        this.f10858l.addMovement(motionEvent);
        int i7 = 0;
        if (actionMasked == 0) {
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View r5 = r((int) x5, (int) y5);
            C(x5, y5, pointerId);
            I(r5, pointerId);
            int i8 = this.f10854h[pointerId];
            int i9 = this.f10862p;
            if ((i8 & i9) != 0) {
                this.f10864r.h(i8 & i9, pointerId);
                return;
            }
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.f10847a != 1) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i7 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i7);
                        if (x(pointerId2)) {
                            float x6 = motionEvent.getX(i7);
                            float y6 = motionEvent.getY(i7);
                            float f6 = x6 - this.f10850d[pointerId2];
                            float f7 = y6 - this.f10851e[pointerId2];
                            B(f6, f7, pointerId2);
                            if (this.f10847a != 1) {
                                View r6 = r((int) x6, (int) y6);
                                if (d(r6, f6, f7) && I(r6, pointerId2)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        i7++;
                    }
                } else if (!x(this.f10849c)) {
                    return;
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f10849c);
                    float x7 = motionEvent.getX(findPointerIndex);
                    float y7 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f10852f;
                    int i10 = this.f10849c;
                    int i11 = (int) (x7 - fArr[i10]);
                    int i12 = (int) (y7 - this.f10853g[i10]);
                    p(this.f10865s.getLeft() + i11, this.f10865s.getTop() + i12, i11, i12);
                }
                D(motionEvent);
                return;
            } else if (actionMasked != 3) {
                if (actionMasked == 5) {
                    int pointerId3 = motionEvent.getPointerId(actionIndex);
                    float x8 = motionEvent.getX(actionIndex);
                    float y8 = motionEvent.getY(actionIndex);
                    C(x8, y8, pointerId3);
                    if (this.f10847a != 0) {
                        if (v((int) x8, (int) y8)) {
                            I(this.f10865s, pointerId3);
                            return;
                        }
                        return;
                    }
                    I(r((int) x8, (int) y8), pointerId3);
                    int i13 = this.f10854h[pointerId3];
                    int i14 = this.f10862p;
                    if ((i13 & i14) != 0) {
                        this.f10864r.h(i13 & i14, pointerId3);
                        return;
                    }
                    return;
                } else if (actionMasked != 6) {
                    return;
                } else {
                    int pointerId4 = motionEvent.getPointerId(actionIndex);
                    if (this.f10847a == 1 && pointerId4 == this.f10849c) {
                        int pointerCount2 = motionEvent.getPointerCount();
                        while (true) {
                            if (i7 >= pointerCount2) {
                                i6 = -1;
                                break;
                            }
                            int pointerId5 = motionEvent.getPointerId(i7);
                            if (pointerId5 != this.f10849c) {
                                View r7 = r((int) motionEvent.getX(i7), (int) motionEvent.getY(i7));
                                View view = this.f10865s;
                                if (r7 == view && I(view, pointerId5)) {
                                    i6 = this.f10849c;
                                    break;
                                }
                            }
                            i7++;
                        }
                        if (i6 == -1) {
                            A();
                        }
                    }
                    h(pointerId4);
                    return;
                }
            } else if (this.f10847a == 1) {
                n(0.0f, 0.0f);
            }
        } else if (this.f10847a == 1) {
            A();
        }
        a();
    }
}
