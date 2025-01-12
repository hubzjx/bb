package e0;

import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes.dex */
public final class w implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    private final View f9406b;

    /* renamed from: c  reason: collision with root package name */
    private ViewTreeObserver f9407c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f9408d;

    private w(View view, Runnable runnable) {
        this.f9406b = view;
        this.f9407c = view.getViewTreeObserver();
        this.f9408d = runnable;
    }

    public static w a(View view, Runnable runnable) {
        if (view != null) {
            if (runnable != null) {
                w wVar = new w(view, runnable);
                view.getViewTreeObserver().addOnPreDrawListener(wVar);
                view.addOnAttachStateChangeListener(wVar);
                return wVar;
            }
            throw new NullPointerException("runnable == null");
        }
        throw new NullPointerException("view == null");
    }

    public void b() {
        (this.f9407c.isAlive() ? this.f9407c : this.f9406b.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f9406b.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f9408d.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f9407c = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
