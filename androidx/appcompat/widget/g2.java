package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
/* loaded from: classes.dex */
class g2 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: k  reason: collision with root package name */
    private static g2 f919k;

    /* renamed from: l  reason: collision with root package name */
    private static g2 f920l;

    /* renamed from: b  reason: collision with root package name */
    private final View f921b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f922c;

    /* renamed from: d  reason: collision with root package name */
    private final int f923d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f924e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f925f = new b();

    /* renamed from: g  reason: collision with root package name */
    private int f926g;

    /* renamed from: h  reason: collision with root package name */
    private int f927h;

    /* renamed from: i  reason: collision with root package name */
    private h2 f928i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f929j;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g2.this.g(false);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g2.this.c();
        }
    }

    private g2(View view, CharSequence charSequence) {
        this.f921b = view;
        this.f922c = charSequence;
        this.f923d = e0.o0.c(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void a() {
        this.f921b.removeCallbacks(this.f924e);
    }

    private void b() {
        this.f926g = Integer.MAX_VALUE;
        this.f927h = Integer.MAX_VALUE;
    }

    private void d() {
        this.f921b.postDelayed(this.f924e, ViewConfiguration.getLongPressTimeout());
    }

    private static void e(g2 g2Var) {
        g2 g2Var2 = f919k;
        if (g2Var2 != null) {
            g2Var2.a();
        }
        f919k = g2Var;
        if (g2Var != null) {
            g2Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        g2 g2Var = f919k;
        if (g2Var != null && g2Var.f921b == view) {
            e(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new g2(view, charSequence);
            return;
        }
        g2 g2Var2 = f920l;
        if (g2Var2 != null && g2Var2.f921b == view) {
            g2Var2.c();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean h(MotionEvent motionEvent) {
        int x5 = (int) motionEvent.getX();
        int y5 = (int) motionEvent.getY();
        if (Math.abs(x5 - this.f926g) > this.f923d || Math.abs(y5 - this.f927h) > this.f923d) {
            this.f926g = x5;
            this.f927h = y5;
            return true;
        }
        return false;
    }

    void c() {
        if (f920l == this) {
            f920l = null;
            h2 h2Var = this.f928i;
            if (h2Var != null) {
                h2Var.c();
                this.f928i = null;
                b();
                this.f921b.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f919k == this) {
            e(null);
        }
        this.f921b.removeCallbacks(this.f925f);
    }

    void g(boolean z5) {
        long longPressTimeout;
        long j6;
        long j7;
        if (e0.b0.Q(this.f921b)) {
            e(null);
            g2 g2Var = f920l;
            if (g2Var != null) {
                g2Var.c();
            }
            f920l = this;
            this.f929j = z5;
            h2 h2Var = new h2(this.f921b.getContext());
            this.f928i = h2Var;
            h2Var.e(this.f921b, this.f926g, this.f927h, this.f929j, this.f922c);
            this.f921b.addOnAttachStateChangeListener(this);
            if (this.f929j) {
                j7 = 2500;
            } else {
                if ((e0.b0.K(this.f921b) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j6 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j6 = 15000;
                }
                j7 = j6 - longPressTimeout;
            }
            this.f921b.removeCallbacks(this.f925f);
            this.f921b.postDelayed(this.f925f, j7);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f928i == null || !this.f929j) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.f921b.getContext().getSystemService("accessibility");
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 10) {
                    b();
                    c();
                }
            } else if (this.f921b.isEnabled() && this.f928i == null && h(motionEvent)) {
                e(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f926g = view.getWidth() / 2;
        this.f927h = view.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
