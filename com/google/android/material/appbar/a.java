package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e0.b0;
/* loaded from: classes.dex */
abstract class a extends c {

    /* renamed from: d  reason: collision with root package name */
    private Runnable f4873d;

    /* renamed from: e  reason: collision with root package name */
    OverScroller f4874e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4875f;

    /* renamed from: g  reason: collision with root package name */
    private int f4876g;

    /* renamed from: h  reason: collision with root package name */
    private int f4877h;

    /* renamed from: i  reason: collision with root package name */
    private int f4878i;

    /* renamed from: j  reason: collision with root package name */
    private VelocityTracker f4879j;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.material.appbar.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0045a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final CoordinatorLayout f4880a;

        /* renamed from: b  reason: collision with root package name */
        private final View f4881b;

        RunnableC0045a(CoordinatorLayout coordinatorLayout, View view) {
            this.f4880a = coordinatorLayout;
            this.f4881b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f4881b == null || (overScroller = a.this.f4874e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                a.this.M(this.f4880a, this.f4881b);
                return;
            }
            a aVar = a.this;
            aVar.O(this.f4880a, this.f4881b, aVar.f4874e.getCurrY());
            b0.d0(this.f4881b, this);
        }
    }

    public a() {
        this.f4876g = -1;
        this.f4878i = -1;
    }

    private void H() {
        if (this.f4879j == null) {
            this.f4879j = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z5;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f4876g);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y5 = (int) motionEvent.getY(findPointerIndex);
                this.f4877h = y5;
                N(coordinatorLayout, view, this.f4877h - y5, J(view), 0);
            } else if (actionMasked != 3) {
                if (actionMasked == 6) {
                    int i6 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                    this.f4876g = motionEvent.getPointerId(i6);
                    this.f4877h = (int) (motionEvent.getY(i6) + 0.5f);
                }
            }
            z5 = false;
            velocityTracker2 = this.f4879j;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            return !this.f4875f || z5;
        }
        VelocityTracker velocityTracker3 = this.f4879j;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.f4879j.computeCurrentVelocity(1000);
            I(coordinatorLayout, view, -K(view), 0, this.f4879j.getYVelocity(this.f4876g));
            z5 = true;
            this.f4875f = false;
            this.f4876g = -1;
            velocityTracker = this.f4879j;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f4879j = null;
            }
            velocityTracker2 = this.f4879j;
            if (velocityTracker2 != null) {
            }
            if (this.f4875f) {
                return true;
            }
        }
        z5 = false;
        this.f4875f = false;
        this.f4876g = -1;
        velocityTracker = this.f4879j;
        if (velocityTracker != null) {
        }
        velocityTracker2 = this.f4879j;
        if (velocityTracker2 != null) {
        }
        if (this.f4875f) {
        }
    }

    abstract boolean G(View view);

    final boolean I(CoordinatorLayout coordinatorLayout, View view, int i6, int i7, float f6) {
        Runnable runnable = this.f4873d;
        if (runnable != null) {
            view.removeCallbacks(runnable);
            this.f4873d = null;
        }
        if (this.f4874e == null) {
            this.f4874e = new OverScroller(view.getContext());
        }
        this.f4874e.fling(0, E(), 0, Math.round(f6), 0, 0, i6, i7);
        if (!this.f4874e.computeScrollOffset()) {
            M(coordinatorLayout, view);
            return false;
        }
        RunnableC0045a runnableC0045a = new RunnableC0045a(coordinatorLayout, view);
        this.f4873d = runnableC0045a;
        b0.d0(view, runnableC0045a);
        return true;
    }

    abstract int J(View view);

    abstract int K(View view);

    abstract int L();

    abstract void M(CoordinatorLayout coordinatorLayout, View view);

    final int N(CoordinatorLayout coordinatorLayout, View view, int i6, int i7, int i8) {
        return P(coordinatorLayout, view, L() - i6, i7, i8);
    }

    int O(CoordinatorLayout coordinatorLayout, View view, int i6) {
        return P(coordinatorLayout, view, i6, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    abstract int P(CoordinatorLayout coordinatorLayout, View view, int i6, int i7, int i8);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f4878i < 0) {
            this.f4878i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f4875f) {
            int i6 = this.f4876g;
            if (i6 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i6)) == -1) {
                return false;
            }
            int y5 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y5 - this.f4877h) > this.f4878i) {
                this.f4877h = y5;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f4876g = -1;
            int x5 = (int) motionEvent.getX();
            int y6 = (int) motionEvent.getY();
            boolean z5 = G(view) && coordinatorLayout.z(view, x5, y6);
            this.f4875f = z5;
            if (z5) {
                this.f4877h = y6;
                this.f4876g = motionEvent.getPointerId(0);
                H();
                OverScroller overScroller = this.f4874e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f4874e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f4879j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4876g = -1;
        this.f4878i = -1;
    }
}
