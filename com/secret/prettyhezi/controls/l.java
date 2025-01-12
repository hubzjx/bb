package com.secret.prettyhezi.controls;

import android.graphics.Color;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.ZZcINlcxH;
import x0.d;
/* loaded from: classes.dex */
public class l extends FrameLayout implements x0.b {
    public long A;
    float B;

    /* renamed from: b  reason: collision with root package name */
    ZZcINlcxH f8368b;

    /* renamed from: c  reason: collision with root package name */
    x0.d f8369c;

    /* renamed from: d  reason: collision with root package name */
    x0.a f8370d;

    /* renamed from: e  reason: collision with root package name */
    View f8371e;

    /* renamed from: f  reason: collision with root package name */
    g[] f8372f;

    /* renamed from: g  reason: collision with root package name */
    int f8373g;

    /* renamed from: h  reason: collision with root package name */
    int f8374h;

    /* renamed from: i  reason: collision with root package name */
    LinearLayout f8375i;

    /* renamed from: j  reason: collision with root package name */
    f f8376j;

    /* renamed from: k  reason: collision with root package name */
    TextView f8377k;

    /* renamed from: l  reason: collision with root package name */
    com.secret.prettyhezi.View.q f8378l;

    /* renamed from: m  reason: collision with root package name */
    private VelocityTracker f8379m;

    /* renamed from: n  reason: collision with root package name */
    private OverScroller f8380n;

    /* renamed from: o  reason: collision with root package name */
    private float f8381o;

    /* renamed from: p  reason: collision with root package name */
    private int f8382p;

    /* renamed from: q  reason: collision with root package name */
    private int f8383q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f8384r;

    /* renamed from: s  reason: collision with root package name */
    long f8385s;

    /* renamed from: t  reason: collision with root package name */
    boolean f8386t;

    /* renamed from: u  reason: collision with root package name */
    int f8387u;

    /* renamed from: v  reason: collision with root package name */
    d.a f8388v;

    /* renamed from: w  reason: collision with root package name */
    int f8389w;

    /* renamed from: x  reason: collision with root package name */
    int f8390x;

    /* renamed from: y  reason: collision with root package name */
    boolean f8391y;

    /* renamed from: z  reason: collision with root package name */
    boolean f8392z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            l.this.f8370d.scrollTo(0, 0);
            View d6 = l.this.d();
            if (d6 instanceof com.secret.prettyhezi.View.t) {
                ((com.secret.prettyhezi.View.t) d6).C();
                l.this.f8377k.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.s();
        }
    }

    /* loaded from: classes.dex */
    class c implements d.a {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.w();
            }
        }

        c() {
        }

        @Override // x0.d.a
        public void a(MotionEvent motionEvent) {
            l lVar = l.this;
            float f6 = lVar.B;
            if (f6 == 0.0f || f6 == lVar.f8373g) {
                return;
            }
            lVar.f8379m.computeCurrentVelocity(1000, l.this.f8382p);
            int yVelocity = (int) l.this.f8379m.getYVelocity(l.this.f8383q);
            l.this.f8383q = -1;
            l.this.f8380n.forceFinished(true);
            l lVar2 = l.this;
            lVar2.f8380n.fling(0, (int) lVar2.B, 0, yVelocity, 0, 0, 0, lVar2.f8373g);
            new Handler().post(new a());
        }

        @Override // x0.d.a
        public void b(MotionEvent motionEvent) {
            l lVar = l.this;
            lVar.f8387u = lVar.f8370d.getCurrentScrollY();
            l.this.f8383q = motionEvent.getPointerId(0);
            l.this.f8380n.forceFinished(true);
            if (l.this.f8379m == null) {
                l.this.f8379m = VelocityTracker.obtain();
            } else {
                l.this.f8379m.clear();
            }
            l lVar2 = l.this;
            lVar2.f8381o = lVar2.B;
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            obtainNoHistory.setLocation(0.0f, l.this.f8381o);
            l.this.f8379m.addMovement(obtainNoHistory);
        }

        @Override // x0.d.a
        public boolean c(MotionEvent motionEvent, boolean z5, float f6, float f7) {
            if (Math.abs(f7) < 4.0f) {
                return false;
            }
            return 0.0f < l.this.f8369c.getY() || (z5 && ((float) l.this.f8370d.getCurrentScrollY()) - f7 < 0.0f);
        }

        @Override // x0.d.a
        public void d(MotionEvent motionEvent, float f6, float f7) {
            float translationY = l.this.f8369c.getTranslationY();
            l lVar = l.this;
            float f8 = (translationY - lVar.f8387u) + f7;
            if (f8 < 0.0f) {
                f8 = 0.0f;
            } else {
                int i6 = lVar.f8373g;
                if (i6 < f8) {
                    f8 = i6;
                }
            }
            lVar.x(f8);
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            obtainNoHistory.setLocation(0.0f, f8);
            l.this.f8379m.addMovement(obtainNoHistory);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.View.t f8398a;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        e(com.secret.prettyhezi.View.t tVar) {
            this.f8398a = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.f8370d.scrollTo(0, this.f8398a.getOldScrollY());
            l.this.f8370d.postDelayed(new a(), 50L);
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        int a();

        String b(int i6);

        String c(int i6);

        View d(int i6);

        View e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        public TextView f8401b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f8402c;

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ l f8404d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f8405e;

            a(l lVar, int i6) {
                this.f8404d = lVar;
                this.f8405e = i6;
            }

            @Override // g4.f
            public void a(View view) {
                l.this.f(this.f8405e);
            }
        }

        public g(ZZcINlcxH zZcINlcxH, String str, String str2, int i6) {
            super(zZcINlcxH);
            setOrientation(1);
            setGravity(17);
            this.f8401b = g4.d.b(zZcINlcxH, 14.0f, -16777216, str);
            TextView b6 = g4.d.b(zZcINlcxH, 12.0f, Color.parseColor("#333333"), str2);
            this.f8402c = b6;
            b6.setSingleLine(true);
            addView(this.f8401b, new LinearLayout.LayoutParams(-2, -2));
            addView(this.f8402c, new LinearLayout.LayoutParams(-2, -2));
            int parseColor = Color.parseColor("#e0e0e0");
            setBackground(g4.i.i(0, parseColor, parseColor));
            setOnClickListener(new a(l.this, i6));
        }
    }

    public l(ZZcINlcxH zZcINlcxH, int i6, f fVar) {
        super(zZcINlcxH);
        this.f8374h = g4.i.r(56.0f);
        this.f8377k = null;
        this.f8378l = null;
        this.f8383q = -1;
        this.f8384r = false;
        this.f8385s = 0L;
        this.f8386t = false;
        this.f8388v = new c();
        this.f8389w = 0;
        this.f8390x = -1;
        this.f8391y = false;
        this.f8392z = false;
        this.A = 0L;
        this.B = 0.0f;
        this.f8368b = zZcINlcxH;
        this.f8376j = fVar;
        this.f8373g = fVar.a();
        View e6 = fVar.e();
        this.f8371e = e6;
        addView(e6, new FrameLayout.LayoutParams(-1, this.f8373g));
        x0.d dVar = new x0.d(zZcINlcxH);
        this.f8369c = dVar;
        dVar.setScrollInterceptionListener(this.f8388v);
        addView(this.f8369c, new FrameLayout.LayoutParams(-1, -1));
        x0.a aVar = new x0.a(zZcINlcxH);
        this.f8370d = aVar;
        aVar.setScrollViewCallbacks(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = this.f8374h;
        this.f8369c.addView(this.f8370d, layoutParams);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        this.f8375i = linearLayout;
        linearLayout.setBackgroundColor(-1);
        this.f8375i.setPadding(g4.i.r(2.0f), g4.i.r(4.0f), g4.i.r(2.0f), g4.i.r(4.0f));
        addView(this.f8375i, new LinearLayout.LayoutParams(-1, -2));
        this.f8372f = new g[i6];
        int i7 = 0;
        while (true) {
            g[] gVarArr = this.f8372f;
            if (i7 >= gVarArr.length) {
                x(this.f8373g);
                this.f8380n = new OverScroller(zZcINlcxH);
                this.f8382p = ViewConfiguration.get(zZcINlcxH).getScaledMaximumFlingVelocity();
                return;
            }
            gVarArr[i7] = new g(zZcINlcxH, fVar.c(i7), fVar.b(i7), i7);
            this.f8375i.addView(this.f8372f[i7], new LinearLayout.LayoutParams(0, g4.i.r(48.0f), 1.0f));
            i7++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        boolean z5 = false;
        float f6 = 0.0f;
        if (this.f8380n.computeScrollOffset()) {
            float currY = this.f8380n.getCurrY();
            int i6 = this.f8373g;
            if (i6 >= currY && currY >= 0.0f) {
                f6 = currY;
            } else if (currY > i6) {
                f6 = i6;
            } else if (0.0f <= currY) {
                f6 = currY;
            }
            z5 = true;
        }
        if (z5) {
            x((int) f6);
            new Handler().post(new d());
        }
    }

    @Override // x0.b
    public void a(x0.c cVar) {
        if (cVar == null || !this.f8384r) {
            return;
        }
        if (this.f8370d.getScrollY() == 0) {
            cVar = x0.c.DOWN;
        }
        boolean z5 = false;
        if (cVar == x0.c.DOWN) {
            View d6 = d();
            if ((d6 instanceof com.secret.prettyhezi.View.t) && ((com.secret.prettyhezi.View.t) d6).f8009c > 5) {
                z5 = true;
            }
        }
        v(z5);
    }

    @Override // x0.b
    public void b() {
    }

    @Override // x0.b
    public void c(int i6, boolean z5, boolean z6) {
        if (this.f8389w == i6) {
            return;
        }
        this.f8389w = i6;
        if (this.f8370d.getChildCount() > 0) {
            View childAt = this.f8370d.getChildAt(0);
            if (childAt instanceof com.secret.prettyhezi.View.t) {
                ((com.secret.prettyhezi.View.t) childAt).D(i6);
            }
        }
    }

    public View d() {
        return this.f8370d.getChildAt(0);
    }

    public int e() {
        return this.f8390x;
    }

    public void f(int i6) {
        if (this.f8390x == i6) {
            this.f8370d.scrollTo(0, 0);
            return;
        }
        this.f8390x = i6;
        int i7 = 0;
        while (true) {
            g[] gVarArr = this.f8372f;
            if (i7 >= gVarArr.length) {
                break;
            }
            gVarArr[i7].setSelected(i7 == this.f8390x);
            i7++;
        }
        if (this.f8370d.getChildCount() > 0) {
            View childAt = this.f8370d.getChildAt(0);
            if (childAt instanceof com.secret.prettyhezi.View.t) {
                ((com.secret.prettyhezi.View.t) childAt).B();
            }
        }
        this.f8370d.removeAllViews();
        View d6 = this.f8376j.d(i6);
        if (d6.getParent() != null) {
            ((ViewGroup) d6.getParent()).removeView(d6);
        }
        this.f8370d.addView(d6, new FrameLayout.LayoutParams(-1, -2));
        boolean z5 = d6 instanceof com.secret.prettyhezi.View.t;
        if (z5) {
            this.f8370d.postDelayed(new e((com.secret.prettyhezi.View.t) d6), 50L);
        }
        v(false);
        if (z5) {
            com.secret.prettyhezi.View.t tVar = (com.secret.prettyhezi.View.t) d6;
            tVar.J(this.f8391y);
            tVar.K(this.f8392z);
            com.secret.prettyhezi.View.q qVar = this.f8378l;
            if (qVar != null) {
                tVar.e(qVar, this.f8377k);
            }
        }
    }

    public void g(boolean z5) {
        this.f8391y = z5;
        View d6 = d();
        if (d6 instanceof com.secret.prettyhezi.View.t) {
            ((com.secret.prettyhezi.View.t) d6).J(this.f8391y);
        }
    }

    public void h(boolean z5) {
        this.f8392z = z5;
        View d6 = d();
        if (d6 instanceof com.secret.prettyhezi.View.t) {
            ((com.secret.prettyhezi.View.t) d6).K(this.f8392z);
        }
    }

    public View r() {
        ZZcINlcxH zZcINlcxH = this.f8368b;
        TextView b6 = g4.d.b(zZcINlcxH, 18.0f, -16777216, zZcINlcxH.s0(C0382R.string.no_data));
        b6.setGravity(17);
        b6.setBackgroundColor(-1);
        b6.setMinHeight((this.f8368b.o().y - this.f8374h) - g4.i.r(20.0f));
        return b6;
    }

    void s() {
        if (System.currentTimeMillis() - this.f8385s > 2900) {
            this.f8377k.setVisibility(8);
            this.f8378l.setVisibility(4);
        }
    }

    public void t() {
        if (this.f8370d.getChildCount() > 0) {
            View childAt = this.f8370d.getChildAt(0);
            if (childAt instanceof com.secret.prettyhezi.View.t) {
                ((com.secret.prettyhezi.View.t) childAt).B();
            }
        }
    }

    public void u() {
        if (this.f8370d.getChildCount() > 0) {
            boolean z5 = this.f8370d.getChildAt(0) instanceof com.secret.prettyhezi.View.t;
        }
    }

    void v(boolean z5) {
        if (this.f8386t == z5) {
            return;
        }
        this.f8386t = z5;
        if (!z5) {
            TextView textView = this.f8377k;
            if (textView != null) {
                textView.setVisibility(8);
                this.f8378l.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f8377k == null) {
            this.f8377k = com.secret.prettyhezi.View.q.e(this.f8368b);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, g4.i.r(42.0f));
            layoutParams.topMargin = getHeight() - layoutParams.height;
            layoutParams.rightMargin = g4.i.r(60.0f);
            addView(this.f8377k, layoutParams);
            this.f8377k.setOnClickListener(new a());
            this.f8378l = new com.secret.prettyhezi.View.q(this.f8368b);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(g4.i.r(60.0f), -1);
            layoutParams2.leftMargin = getWidth() - layoutParams2.width;
            layoutParams2.topMargin = this.f8374h;
            addView(this.f8378l, layoutParams2);
            View childAt = this.f8370d.getChildAt(0);
            if (childAt instanceof com.secret.prettyhezi.View.t) {
                ((com.secret.prettyhezi.View.t) childAt).e(this.f8378l, this.f8377k);
            }
        }
        this.f8377k.setVisibility(0);
        this.f8378l.setVisibility(0);
        this.f8385s = System.currentTimeMillis();
        postDelayed(new b(), 3000L);
    }

    protected void x(float f6) {
        if (this.B == f6) {
            return;
        }
        this.B = f6;
        this.A = System.currentTimeMillis();
        this.f8369c.setTranslationY(f6);
        this.f8371e.setTranslationY(f6 - this.f8373g);
        this.f8375i.setTranslationY(Math.max(0.0f, f6));
        com.secret.prettyhezi.View.q qVar = this.f8378l;
        if (qVar != null) {
            ((FrameLayout.LayoutParams) qVar.getLayoutParams()).topMargin = this.f8374h + ((int) Math.max(0.0f, f6));
            this.f8378l.requestLayout();
        }
    }
}
