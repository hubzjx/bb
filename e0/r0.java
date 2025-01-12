package e0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference f9360a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f9361b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f9362c = null;

    /* renamed from: d  reason: collision with root package name */
    int f9363d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s0 f9364a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f9365b;

        a(s0 s0Var, View view) {
            this.f9364a = s0Var;
            this.f9365b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f9364a.a(this.f9365b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9364a.b(this.f9365b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f9364a.c(this.f9365b);
        }
    }

    /* loaded from: classes.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u0 f9367a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f9368b;

        b(u0 u0Var, View view) {
            this.f9367a = u0Var;
            this.f9368b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f9367a.a(this.f9368b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0(View view) {
        this.f9360a = new WeakReference(view);
    }

    private void g(View view, s0 s0Var) {
        if (s0Var != null) {
            view.animate().setListener(new a(s0Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public r0 a(float f6) {
        View view = (View) this.f9360a.get();
        if (view != null) {
            view.animate().alpha(f6);
        }
        return this;
    }

    public void b() {
        View view = (View) this.f9360a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = (View) this.f9360a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public r0 d(long j6) {
        View view = (View) this.f9360a.get();
        if (view != null) {
            view.animate().setDuration(j6);
        }
        return this;
    }

    public r0 e(Interpolator interpolator) {
        View view = (View) this.f9360a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public r0 f(s0 s0Var) {
        View view = (View) this.f9360a.get();
        if (view != null) {
            g(view, s0Var);
        }
        return this;
    }

    public r0 h(long j6) {
        View view = (View) this.f9360a.get();
        if (view != null) {
            view.animate().setStartDelay(j6);
        }
        return this;
    }

    public r0 i(u0 u0Var) {
        View view = (View) this.f9360a.get();
        if (view != null) {
            view.animate().setUpdateListener(u0Var != null ? new b(u0Var, view) : null);
        }
        return this;
    }

    public void j() {
        View view = (View) this.f9360a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public r0 k(float f6) {
        View view = (View) this.f9360a.get();
        if (view != null) {
            view.animate().translationY(f6);
        }
        return this;
    }
}
