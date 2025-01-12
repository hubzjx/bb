package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import e0.b0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends RecyclerView.n implements RecyclerView.r {
    private static final int[] D = {16842919};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.s C;

    /* renamed from: a  reason: collision with root package name */
    private final int f2439a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2440b;

    /* renamed from: c  reason: collision with root package name */
    final StateListDrawable f2441c;

    /* renamed from: d  reason: collision with root package name */
    final Drawable f2442d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2443e;

    /* renamed from: f  reason: collision with root package name */
    private final int f2444f;

    /* renamed from: g  reason: collision with root package name */
    private final StateListDrawable f2445g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f2446h;

    /* renamed from: i  reason: collision with root package name */
    private final int f2447i;

    /* renamed from: j  reason: collision with root package name */
    private final int f2448j;

    /* renamed from: k  reason: collision with root package name */
    int f2449k;

    /* renamed from: l  reason: collision with root package name */
    int f2450l;

    /* renamed from: m  reason: collision with root package name */
    float f2451m;

    /* renamed from: n  reason: collision with root package name */
    int f2452n;

    /* renamed from: o  reason: collision with root package name */
    int f2453o;

    /* renamed from: p  reason: collision with root package name */
    float f2454p;

    /* renamed from: s  reason: collision with root package name */
    private RecyclerView f2457s;

    /* renamed from: z  reason: collision with root package name */
    final ValueAnimator f2464z;

    /* renamed from: q  reason: collision with root package name */
    private int f2455q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f2456r = 0;

    /* renamed from: t  reason: collision with root package name */
    private boolean f2458t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f2459u = false;

    /* renamed from: v  reason: collision with root package name */
    private int f2460v = 0;

    /* renamed from: w  reason: collision with root package name */
    private int f2461w = 0;

    /* renamed from: x  reason: collision with root package name */
    private final int[] f2462x = new int[2];

    /* renamed from: y  reason: collision with root package name */
    private final int[] f2463y = new int[2];

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(500);
        }
    }

    /* loaded from: classes.dex */
    class b extends RecyclerView.s {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int i6, int i7) {
            d.this.B(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* loaded from: classes.dex */
    private class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2467a = false;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2467a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2467a) {
                this.f2467a = false;
            } else if (((Float) d.this.f2464z.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.A = 0;
                dVar.y(0);
            } else {
                d dVar2 = d.this;
                dVar2.A = 2;
                dVar2.v();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0024d implements ValueAnimator.AnimatorUpdateListener {
        C0024d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.f2441c.setAlpha(floatValue);
            d.this.f2442d.setAlpha(floatValue);
            d.this.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i6, int i7, int i8) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2464z = ofFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f2441c = stateListDrawable;
        this.f2442d = drawable;
        this.f2445g = stateListDrawable2;
        this.f2446h = drawable2;
        this.f2443e = Math.max(i6, stateListDrawable.getIntrinsicWidth());
        this.f2444f = Math.max(i6, drawable.getIntrinsicWidth());
        this.f2447i = Math.max(i6, stateListDrawable2.getIntrinsicWidth());
        this.f2448j = Math.max(i6, drawable2.getIntrinsicWidth());
        this.f2439a = i7;
        this.f2440b = i8;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new C0024d());
        j(recyclerView);
    }

    private void C(float f6) {
        int[] p5 = p();
        float max = Math.max(p5[0], Math.min(p5[1], f6));
        if (Math.abs(this.f2450l - max) < 2.0f) {
            return;
        }
        int x5 = x(this.f2451m, max, p5, this.f2457s.computeVerticalScrollRange(), this.f2457s.computeVerticalScrollOffset(), this.f2456r);
        if (x5 != 0) {
            this.f2457s.scrollBy(0, x5);
        }
        this.f2451m = max;
    }

    private void k() {
        this.f2457s.removeCallbacks(this.B);
    }

    private void l() {
        this.f2457s.V0(this);
        this.f2457s.W0(this);
        this.f2457s.X0(this.C);
        k();
    }

    private void m(Canvas canvas) {
        int i6 = this.f2456r;
        int i7 = this.f2447i;
        int i8 = i6 - i7;
        int i9 = this.f2453o;
        int i10 = this.f2452n;
        int i11 = i9 - (i10 / 2);
        this.f2445g.setBounds(0, 0, i10, i7);
        this.f2446h.setBounds(0, 0, this.f2455q, this.f2448j);
        canvas.translate(0.0f, i8);
        this.f2446h.draw(canvas);
        canvas.translate(i11, 0.0f);
        this.f2445g.draw(canvas);
        canvas.translate(-i11, -i8);
    }

    private void n(Canvas canvas) {
        int i6 = this.f2455q;
        int i7 = this.f2443e;
        int i8 = i6 - i7;
        int i9 = this.f2450l;
        int i10 = this.f2449k;
        int i11 = i9 - (i10 / 2);
        this.f2441c.setBounds(0, 0, i7, i10);
        this.f2442d.setBounds(0, 0, this.f2444f, this.f2456r);
        if (s()) {
            this.f2442d.draw(canvas);
            canvas.translate(this.f2443e, i11);
            canvas.scale(-1.0f, 1.0f);
            this.f2441c.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            i8 = this.f2443e;
        } else {
            canvas.translate(i8, 0.0f);
            this.f2442d.draw(canvas);
            canvas.translate(0.0f, i11);
            this.f2441c.draw(canvas);
        }
        canvas.translate(-i8, -i11);
    }

    private int[] o() {
        int[] iArr = this.f2463y;
        int i6 = this.f2440b;
        iArr[0] = i6;
        iArr[1] = this.f2455q - i6;
        return iArr;
    }

    private int[] p() {
        int[] iArr = this.f2462x;
        int i6 = this.f2440b;
        iArr[0] = i6;
        iArr[1] = this.f2456r - i6;
        return iArr;
    }

    private void r(float f6) {
        int[] o5 = o();
        float max = Math.max(o5[0], Math.min(o5[1], f6));
        if (Math.abs(this.f2453o - max) < 2.0f) {
            return;
        }
        int x5 = x(this.f2454p, max, o5, this.f2457s.computeHorizontalScrollRange(), this.f2457s.computeHorizontalScrollOffset(), this.f2455q);
        if (x5 != 0) {
            this.f2457s.scrollBy(x5, 0);
        }
        this.f2454p = max;
    }

    private boolean s() {
        return b0.B(this.f2457s) == 1;
    }

    private void w(int i6) {
        k();
        this.f2457s.postDelayed(this.B, i6);
    }

    private int x(float f6, float f7, int[] iArr, int i6, int i7, int i8) {
        int i9 = iArr[1] - iArr[0];
        if (i9 == 0) {
            return 0;
        }
        int i10 = i6 - i8;
        int i11 = (int) (((f7 - f6) / i9) * i10);
        int i12 = i7 + i11;
        if (i12 >= i10 || i12 < 0) {
            return 0;
        }
        return i11;
    }

    private void z() {
        this.f2457s.h(this);
        this.f2457s.j(this);
        this.f2457s.k(this.C);
    }

    public void A() {
        int i6 = this.A;
        if (i6 != 0) {
            if (i6 != 3) {
                return;
            }
            this.f2464z.cancel();
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f2464z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f2464z.setDuration(500L);
        this.f2464z.setStartDelay(0L);
        this.f2464z.start();
    }

    void B(int i6, int i7) {
        int computeVerticalScrollRange = this.f2457s.computeVerticalScrollRange();
        int i8 = this.f2456r;
        this.f2458t = computeVerticalScrollRange - i8 > 0 && i8 >= this.f2439a;
        int computeHorizontalScrollRange = this.f2457s.computeHorizontalScrollRange();
        int i9 = this.f2455q;
        boolean z5 = computeHorizontalScrollRange - i9 > 0 && i9 >= this.f2439a;
        this.f2459u = z5;
        boolean z6 = this.f2458t;
        if (!z6 && !z5) {
            if (this.f2460v != 0) {
                y(0);
                return;
            }
            return;
        }
        if (z6) {
            float f6 = i8;
            this.f2450l = (int) ((f6 * (i7 + (f6 / 2.0f))) / computeVerticalScrollRange);
            this.f2449k = Math.min(i8, (i8 * i8) / computeVerticalScrollRange);
        }
        if (this.f2459u) {
            float f7 = i9;
            this.f2453o = (int) ((f7 * (i6 + (f7 / 2.0f))) / computeHorizontalScrollRange);
            this.f2452n = Math.min(i9, (i9 * i9) / computeHorizontalScrollRange);
        }
        int i10 = this.f2460v;
        if (i10 == 0 || i10 == 1) {
            y(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i6 = this.f2460v;
        if (i6 == 1) {
            boolean u5 = u(motionEvent.getX(), motionEvent.getY());
            boolean t5 = t(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!u5 && !t5) {
                return false;
            }
            if (t5) {
                this.f2461w = 1;
                this.f2454p = (int) motionEvent.getX();
            } else if (u5) {
                this.f2461w = 2;
                this.f2451m = (int) motionEvent.getY();
            }
            y(2);
        } else if (i6 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f2460v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean u5 = u(motionEvent.getX(), motionEvent.getY());
            boolean t5 = t(motionEvent.getX(), motionEvent.getY());
            if (u5 || t5) {
                if (t5) {
                    this.f2461w = 1;
                    this.f2454p = (int) motionEvent.getX();
                } else if (u5) {
                    this.f2461w = 2;
                    this.f2451m = (int) motionEvent.getY();
                }
                y(2);
            }
        } else if (motionEvent.getAction() == 1 && this.f2460v == 2) {
            this.f2451m = 0.0f;
            this.f2454p = 0.0f;
            y(1);
            this.f2461w = 0;
        } else if (motionEvent.getAction() == 2 && this.f2460v == 2) {
            A();
            if (this.f2461w == 1) {
                r(motionEvent.getX());
            }
            if (this.f2461w == 2) {
                C(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void c(boolean z5) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        if (this.f2455q != this.f2457s.getWidth() || this.f2456r != this.f2457s.getHeight()) {
            this.f2455q = this.f2457s.getWidth();
            this.f2456r = this.f2457s.getHeight();
            y(0);
        } else if (this.A != 0) {
            if (this.f2458t) {
                n(canvas);
            }
            if (this.f2459u) {
                m(canvas);
            }
        }
    }

    public void j(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2457s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            l();
        }
        this.f2457s = recyclerView;
        if (recyclerView != null) {
            z();
        }
    }

    void q(int i6) {
        int i7 = this.A;
        if (i7 == 1) {
            this.f2464z.cancel();
        } else if (i7 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f2464z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f2464z.setDuration(i6);
        this.f2464z.start();
    }

    boolean t(float f6, float f7) {
        if (f7 >= this.f2456r - this.f2447i) {
            int i6 = this.f2453o;
            int i7 = this.f2452n;
            if (f6 >= i6 - (i7 / 2) && f6 <= i6 + (i7 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean u(float f6, float f7) {
        if (!s() ? f6 >= this.f2455q - this.f2443e : f6 <= this.f2443e / 2) {
            int i6 = this.f2450l;
            int i7 = this.f2449k;
            if (f7 >= i6 - (i7 / 2) && f7 <= i6 + (i7 / 2)) {
                return true;
            }
        }
        return false;
    }

    void v() {
        this.f2457s.invalidate();
    }

    void y(int i6) {
        int i7;
        if (i6 == 2 && this.f2460v != 2) {
            this.f2441c.setState(D);
            k();
        }
        if (i6 == 0) {
            v();
        } else {
            A();
        }
        if (this.f2460v != 2 || i6 == 2) {
            i7 = i6 == 1 ? 1500 : 1500;
            this.f2460v = i6;
        }
        this.f2441c.setState(E);
        i7 = 1200;
        w(i7);
        this.f2460v = i6;
    }
}
