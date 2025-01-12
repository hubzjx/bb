package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.b {

    /* renamed from: a  reason: collision with root package name */
    private int f4897a;

    /* renamed from: b  reason: collision with root package name */
    private int f4898b;

    /* renamed from: c  reason: collision with root package name */
    private int f4899c;

    /* renamed from: d  reason: collision with root package name */
    private ViewPropertyAnimator f4900d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f4900d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f4897a = 0;
        this.f4898b = 2;
        this.f4899c = 0;
    }

    private void F(View view, int i6, long j6, TimeInterpolator timeInterpolator) {
        this.f4900d = view.animate().translationY(i6).setInterpolator(timeInterpolator).setDuration(j6).setListener(new a());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i6, int i7) {
        return i6 == 2;
    }

    public void G(View view) {
        if (this.f4898b == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f4900d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f4898b = 1;
        F(view, this.f4897a + this.f4899c, 175L, v2.a.f13675c);
    }

    public void H(View view) {
        if (this.f4898b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f4900d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f4898b = 2;
        F(view, 0, 225L, v2.a.f13676d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i6) {
        this.f4897a = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        return super.l(coordinatorLayout, view, i6);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
        if (i7 > 0) {
            G(view);
        } else if (i7 < 0) {
            H(view);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4897a = 0;
        this.f4898b = 2;
        this.f4899c = 0;
    }
}
