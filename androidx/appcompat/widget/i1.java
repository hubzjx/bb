package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
/* loaded from: classes.dex */
public abstract class i1 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    private final float f947b;

    /* renamed from: c  reason: collision with root package name */
    private final int f948c;

    /* renamed from: d  reason: collision with root package name */
    private final int f949d;

    /* renamed from: e  reason: collision with root package name */
    final View f950e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f951f;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f952g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f953h;

    /* renamed from: i  reason: collision with root package name */
    private int f954i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f955j = new int[2];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = i1.this.f950e.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i1.this.e();
        }
    }

    public i1(View view) {
        this.f950e = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f947b = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f948c = tapTimeout;
        this.f949d = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f952g;
        if (runnable != null) {
            this.f950e.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f951f;
        if (runnable2 != null) {
            this.f950e.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        g1 g1Var;
        View view = this.f950e;
        i.e b6 = b();
        if (b6 == null || !b6.c() || (g1Var = (g1) b6.g()) == null || !g1Var.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(g1Var, obtainNoHistory);
        boolean e6 = g1Var.e(obtainNoHistory, this.f954i);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return e6 && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r1 != 3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean g(MotionEvent motionEvent) {
        View view = this.f950e;
        if (view.isEnabled()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f954i);
                        if (findPointerIndex >= 0 && !h(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f947b)) {
                            a();
                            view.getParent().requestDisallowInterceptTouchEvent(true);
                            return true;
                        }
                    }
                }
                a();
            } else {
                this.f954i = motionEvent.getPointerId(0);
                if (this.f951f == null) {
                    this.f951f = new a();
                }
                view.postDelayed(this.f951f, this.f948c);
                if (this.f952g == null) {
                    this.f952g = new b();
                }
                view.postDelayed(this.f952g, this.f949d);
            }
            return false;
        }
        return false;
    }

    private static boolean h(View view, float f6, float f7, float f8) {
        float f9 = -f8;
        return f6 >= f9 && f7 >= f9 && f6 < ((float) (view.getRight() - view.getLeft())) + f8 && f7 < ((float) (view.getBottom() - view.getTop())) + f8;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f955j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f955j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }

    public abstract i.e b();

    protected abstract boolean c();

    protected boolean d() {
        i.e b6 = b();
        if (b6 == null || !b6.c()) {
            return true;
        }
        b6.dismiss();
        return true;
    }

    void e() {
        a();
        View view = this.f950e;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f953h = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z5;
        boolean z6 = this.f953h;
        if (z6) {
            z5 = f(motionEvent) || !d();
        } else {
            z5 = g(motionEvent) && c();
            if (z5) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f950e.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f953h = z5;
        return z5 || z6;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f953h = false;
        this.f954i = -1;
        Runnable runnable = this.f951f;
        if (runnable != null) {
            this.f950e.removeCallbacks(runnable);
        }
    }
}
