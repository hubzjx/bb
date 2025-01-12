package com.secret.prettyhezi.controls.PullToRefresh;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public abstract class f extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private float f8223b;

    /* renamed from: c  reason: collision with root package name */
    private h f8224c;

    /* renamed from: d  reason: collision with root package name */
    private com.secret.prettyhezi.controls.PullToRefresh.e f8225d;

    /* renamed from: e  reason: collision with root package name */
    private com.secret.prettyhezi.controls.PullToRefresh.e f8226e;

    /* renamed from: f  reason: collision with root package name */
    private int f8227f;

    /* renamed from: g  reason: collision with root package name */
    private int f8228g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8229h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8230i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8231j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8232k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8233l;

    /* renamed from: m  reason: collision with root package name */
    private int f8234m;

    /* renamed from: n  reason: collision with root package name */
    private com.secret.prettyhezi.controls.PullToRefresh.d f8235n;

    /* renamed from: o  reason: collision with root package name */
    private com.secret.prettyhezi.controls.PullToRefresh.d f8236o;

    /* renamed from: p  reason: collision with root package name */
    View f8237p;

    /* renamed from: q  reason: collision with root package name */
    private i f8238q;

    /* renamed from: r  reason: collision with root package name */
    private FrameLayout f8239r;

    /* renamed from: s  reason: collision with root package name */
    protected boolean f8240s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            f.this.E();
            f.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.setInterceptTouchEventEnabled(true);
            f.this.f8225d.setState(com.secret.prettyhezi.controls.PullToRefresh.d.RESET);
        }
    }

    /* loaded from: classes.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.setInterceptTouchEventEnabled(true);
            f.this.f8226e.setState(com.secret.prettyhezi.controls.PullToRefresh.d.RESET);
        }
    }

    /* loaded from: classes.dex */
    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8245a;

        e(boolean z5) {
            this.f8245a = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i6 = -f.this.f8227f;
            int i7 = this.f8245a ? 150 : 0;
            f.this.N();
            f.this.L(i6, i7, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.secret.prettyhezi.controls.PullToRefresh.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0131f implements Runnable {
        RunnableC0131f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f8224c.a(f.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f8224c.b(f.this);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class h {
        public void a(f fVar) {
        }

        public void b(f fVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class i implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final int f8250b;

        /* renamed from: c  reason: collision with root package name */
        private final int f8251c;

        /* renamed from: d  reason: collision with root package name */
        private final long f8252d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8253e = true;

        /* renamed from: f  reason: collision with root package name */
        private long f8254f = -1;

        /* renamed from: g  reason: collision with root package name */
        private int f8255g = -1;

        /* renamed from: a  reason: collision with root package name */
        private final Interpolator f8249a = new DecelerateInterpolator();

        public i(int i6, int i7, long j6) {
            this.f8251c = i6;
            this.f8250b = i7;
            this.f8252d = j6;
        }

        public void a() {
            this.f8253e = false;
            f.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f8252d <= 0) {
                f.this.J(0, this.f8250b);
                return;
            }
            int i6 = (this.f8254f > (-1L) ? 1 : (this.f8254f == (-1L) ? 0 : -1));
            long currentTimeMillis = System.currentTimeMillis();
            if (i6 == 0) {
                this.f8254f = currentTimeMillis;
            } else {
                int round = this.f8251c - Math.round((this.f8251c - this.f8250b) * this.f8249a.getInterpolation(((float) Math.max(Math.min(((currentTimeMillis - this.f8254f) * 1000) / this.f8252d, 1000L), 0L)) / 1000.0f));
                this.f8255g = round;
                f.this.J(0, round);
            }
            if (!this.f8253e || this.f8250b == this.f8255g) {
                return;
            }
            f.this.postDelayed(this, 16L);
        }
    }

    public f(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f8223b = -1.0f;
        this.f8229h = true;
        this.f8230i = false;
        this.f8231j = false;
        this.f8232k = true;
        this.f8233l = false;
        com.secret.prettyhezi.controls.PullToRefresh.d dVar = com.secret.prettyhezi.controls.PullToRefresh.d.NONE;
        this.f8235n = dVar;
        this.f8236o = dVar;
        this.f8240s = false;
        q(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        com.secret.prettyhezi.controls.PullToRefresh.e eVar = this.f8225d;
        int contentSize = eVar != null ? eVar.getContentSize() : 0;
        com.secret.prettyhezi.controls.PullToRefresh.e eVar2 = this.f8226e;
        int contentSize2 = eVar2 != null ? eVar2.getContentSize() : 0;
        if (contentSize < 0) {
            contentSize = 0;
        }
        if (contentSize2 < 0) {
            contentSize2 = 0;
        }
        this.f8227f = contentSize;
        this.f8228g = contentSize2;
        com.secret.prettyhezi.controls.PullToRefresh.e eVar3 = this.f8225d;
        int measuredHeight = eVar3 != null ? eVar3.getMeasuredHeight() : 0;
        com.secret.prettyhezi.controls.PullToRefresh.e eVar4 = this.f8226e;
        int measuredHeight2 = eVar4 != null ? eVar4.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.f8228g;
        }
        int paddingLeft = getPaddingLeft();
        getPaddingTop();
        int paddingRight = getPaddingRight();
        getPaddingBottom();
        setPadding(paddingLeft, -measuredHeight, paddingRight, -measuredHeight2);
    }

    private void I(int i6, int i7) {
        scrollBy(i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i6, int i7) {
        scrollTo(i6, i7);
    }

    private void K(int i6) {
        L(i6, getSmoothScrollDuration(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i6, long j6, long j7) {
        i iVar = this.f8238q;
        if (iVar != null) {
            iVar.a();
        }
        int scrollYValue = getScrollYValue();
        boolean z5 = scrollYValue != i6;
        if (z5) {
            this.f8238q = new i(scrollYValue, i6, j6);
        }
        if (z5) {
            int i7 = (j7 > 0L ? 1 : (j7 == 0L ? 0 : -1));
            i iVar2 = this.f8238q;
            if (i7 > 0) {
                postDelayed(iVar2, j7);
            } else {
                post(iVar2);
            }
        }
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void q(Context context, AttributeSet attributeSet) {
        setOrientation(1);
        this.f8234m = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f8225d = n(context, attributeSet);
        this.f8226e = m(context, attributeSet);
        View o5 = o(context, attributeSet);
        this.f8237p = o5;
        if (o5 == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        k(context, o5);
        j(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private boolean r() {
        return this.f8232k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z5) {
        this.f8232k = z5;
    }

    public void A() {
        if (t()) {
            com.secret.prettyhezi.controls.PullToRefresh.d dVar = com.secret.prettyhezi.controls.PullToRefresh.d.RESET;
            this.f8236o = dVar;
            B(dVar, false);
            postDelayed(new d(), getSmoothScrollDuration());
            G();
            setInterceptTouchEventEnabled(false);
        }
    }

    protected void B(com.secret.prettyhezi.controls.PullToRefresh.d dVar, boolean z5) {
    }

    protected void C(float f6) {
        int scrollYValue = getScrollYValue();
        if (f6 > 0.0f && scrollYValue - f6 <= 0.0f) {
            J(0, 0);
            return;
        }
        I(0, -((int) f6));
        if (this.f8226e != null && this.f8228g != 0) {
            this.f8226e.d(Math.abs(getScrollYValue()) / this.f8228g);
        }
        int abs = Math.abs(getScrollYValue());
        if (!s() || t()) {
            return;
        }
        this.f8236o = abs > this.f8228g ? com.secret.prettyhezi.controls.PullToRefresh.d.RELEASE_TO_REFRESH : com.secret.prettyhezi.controls.PullToRefresh.d.PULL_TO_REFRESH;
        this.f8226e.setState(this.f8236o);
        B(this.f8236o, false);
    }

    protected void D(float f6) {
        int scrollYValue = getScrollYValue();
        if (f6 < 0.0f && scrollYValue - f6 >= 0.0f) {
            J(0, 0);
            return;
        }
        I(0, -((int) f6));
        if (this.f8225d != null && this.f8227f != 0) {
            this.f8225d.d(Math.abs(getScrollYValue()) / this.f8227f);
        }
        int abs = Math.abs(getScrollYValue());
        if (!u() || v()) {
            return;
        }
        this.f8235n = abs > this.f8227f ? com.secret.prettyhezi.controls.PullToRefresh.d.RELEASE_TO_REFRESH : com.secret.prettyhezi.controls.PullToRefresh.d.PULL_TO_REFRESH;
        this.f8225d.setState(this.f8235n);
        B(this.f8235n, true);
    }

    protected void F(int i6, int i7) {
        FrameLayout frameLayout = this.f8239r;
        if (frameLayout != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams.height != i7) {
                layoutParams.height = i7;
                this.f8239r.requestLayout();
            }
        }
    }

    protected void G() {
        int abs = Math.abs(getScrollYValue());
        boolean t5 = t();
        if (t5 && abs <= this.f8228g) {
            K(0);
        } else if (t5) {
            K(this.f8228g);
        } else {
            K(0);
        }
    }

    protected void H() {
        int abs = Math.abs(getScrollYValue());
        boolean v5 = v();
        if (v5 && abs <= this.f8227f) {
            K(0);
        } else if (v5) {
            K(-this.f8227f);
        } else {
            K(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M() {
        if (t()) {
            return;
        }
        com.secret.prettyhezi.controls.PullToRefresh.d dVar = com.secret.prettyhezi.controls.PullToRefresh.d.REFRESHING;
        this.f8236o = dVar;
        B(dVar, false);
        com.secret.prettyhezi.controls.PullToRefresh.e eVar = this.f8226e;
        if (eVar != null) {
            eVar.setState(dVar);
        }
        if (this.f8224c != null) {
            postDelayed(new g(), getSmoothScrollDuration());
        }
    }

    protected void N() {
        if (v()) {
            return;
        }
        com.secret.prettyhezi.controls.PullToRefresh.d dVar = com.secret.prettyhezi.controls.PullToRefresh.d.REFRESHING;
        this.f8235n = dVar;
        B(dVar, true);
        com.secret.prettyhezi.controls.PullToRefresh.e eVar = this.f8225d;
        if (eVar != null) {
            eVar.setState(dVar);
        }
        if (this.f8224c != null) {
            postDelayed(new RunnableC0131f(), getSmoothScrollDuration());
        }
    }

    public com.secret.prettyhezi.controls.PullToRefresh.e getFooterLoadingLayout() {
        return this.f8226e;
    }

    public com.secret.prettyhezi.controls.PullToRefresh.e getHeaderLoadingLayout() {
        return this.f8225d;
    }

    protected int getMarginOfCoverView() {
        return 0;
    }

    public View getRefreshableView() {
        return this.f8237p;
    }

    protected long getSmoothScrollDuration() {
        return 150L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(View view) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(Color.parseColor("#f0f0f0"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = getMarginOfCoverView();
        this.f8239r.addView(linearLayout, layoutParams);
        linearLayout.setGravity(1);
        linearLayout.addView(view, new FrameLayout.LayoutParams(-2, -2));
        this.f8240s = true;
    }

    protected void j(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        com.secret.prettyhezi.controls.PullToRefresh.e eVar = this.f8225d;
        com.secret.prettyhezi.controls.PullToRefresh.e eVar2 = this.f8226e;
        if (eVar != null) {
            if (this == eVar.getParent()) {
                removeView(eVar);
            }
            addView(eVar, 0, layoutParams);
        }
        if (eVar2 != null) {
            if (this == eVar2.getParent()) {
                removeView(eVar2);
            }
            addView(eVar2, -1, layoutParams);
        }
    }

    protected void k(Context context, View view) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.f8239r = frameLayout;
        frameLayout.addView(view, -1, -1);
        addView(this.f8239r, new LinearLayout.LayoutParams(-1, 10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        if (this.f8239r.getChildCount() == 2) {
            FrameLayout frameLayout = this.f8239r;
            frameLayout.removeView(frameLayout.getChildAt(1));
            this.f8240s = false;
        }
    }

    protected com.secret.prettyhezi.controls.PullToRefresh.e m(Context context, AttributeSet attributeSet) {
        return new com.secret.prettyhezi.controls.PullToRefresh.a(context);
    }

    protected com.secret.prettyhezi.controls.PullToRefresh.e n(Context context, AttributeSet attributeSet) {
        return new com.secret.prettyhezi.controls.PullToRefresh.c(context);
    }

    protected abstract View o(Context context, AttributeSet attributeSet);

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z5 = false;
        if (r()) {
            if (s() || u()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.f8233l = false;
                    return false;
                } else if (action == 0 || !this.f8233l) {
                    if (action != 0) {
                        if (action == 2) {
                            float y5 = motionEvent.getY() - this.f8223b;
                            if (Math.abs(y5) > this.f8234m || v() || t()) {
                                this.f8223b = motionEvent.getY();
                                if (u() && w()) {
                                    z5 = (Math.abs(getScrollYValue()) > 0 || y5 > 0.5f) ? true : true;
                                    this.f8233l = z5;
                                    if (z5) {
                                        this.f8237p.onTouchEvent(motionEvent);
                                    }
                                } else if (s() && x()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y5 < -0.5f) {
                                        z5 = true;
                                    }
                                }
                            }
                        }
                        return this.f8233l;
                    }
                    this.f8223b = motionEvent.getY();
                    this.f8233l = z5;
                    return this.f8233l;
                } else {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        E();
        F(i6, i7);
        post(new b());
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z5 = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y5 = motionEvent.getY() - this.f8223b;
                    this.f8223b = motionEvent.getY();
                    if (u() && w()) {
                        D(y5 / 2.5f);
                    } else if (s() && x()) {
                        C(y5 / 2.5f);
                    }
                    return true;
                } else if (action != 3) {
                    return false;
                }
            }
            if (this.f8233l) {
                this.f8233l = false;
                if (w()) {
                    if (this.f8229h && this.f8235n == com.secret.prettyhezi.controls.PullToRefresh.d.RELEASE_TO_REFRESH) {
                        N();
                        z5 = true;
                    }
                    H();
                    return z5;
                } else if (x()) {
                    if (s() && this.f8236o == com.secret.prettyhezi.controls.PullToRefresh.d.RELEASE_TO_REFRESH) {
                        M();
                        z5 = true;
                    }
                    G();
                    return z5;
                } else {
                    return false;
                }
            }
            return false;
        }
        this.f8223b = motionEvent.getY();
        this.f8233l = false;
        return false;
    }

    public void p(boolean z5, long j6) {
        postDelayed(new e(z5), j6);
    }

    public boolean s() {
        return this.f8230i && this.f8226e != null;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        com.secret.prettyhezi.controls.PullToRefresh.e eVar = this.f8225d;
        if (eVar != null) {
            eVar.setLastUpdatedLabel(charSequence);
        }
        com.secret.prettyhezi.controls.PullToRefresh.e eVar2 = this.f8226e;
        if (eVar2 != null) {
            eVar2.setLastUpdatedLabel(charSequence);
        }
    }

    public void setOnRefreshListener(h hVar) {
        this.f8224c = hVar;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i6) {
        if (1 != i6) {
            throw new IllegalArgumentException("This class only supports VERTICAL orientation.");
        }
        super.setOrientation(i6);
    }

    public void setPullLoadEnabled(boolean z5) {
        this.f8230i = z5;
    }

    public void setPullRefreshEnabled(boolean z5) {
        this.f8229h = z5;
    }

    public void setScrollLoadEnabled(boolean z5) {
        this.f8231j = z5;
    }

    protected boolean t() {
        return this.f8236o == com.secret.prettyhezi.controls.PullToRefresh.d.REFRESHING;
    }

    public boolean u() {
        return this.f8229h && this.f8225d != null;
    }

    protected boolean v() {
        return this.f8235n == com.secret.prettyhezi.controls.PullToRefresh.d.REFRESHING;
    }

    protected abstract boolean w();

    protected abstract boolean x();

    public boolean y() {
        return this.f8231j;
    }

    public void z() {
        if (v()) {
            com.secret.prettyhezi.controls.PullToRefresh.d dVar = com.secret.prettyhezi.controls.PullToRefresh.d.RESET;
            this.f8235n = dVar;
            B(dVar, true);
            postDelayed(new c(), getSmoothScrollDuration());
            H();
            setInterceptTouchEventEnabled(false);
        }
    }
}
