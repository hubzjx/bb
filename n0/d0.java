package n0;

import android.view.View;
/* loaded from: classes.dex */
abstract class d0 extends m0 {

    /* renamed from: e  reason: collision with root package name */
    private static boolean f12087e = true;

    @Override // n0.m0
    public void a(View view) {
    }

    @Override // n0.m0
    public float c(View view) {
        float transitionAlpha;
        if (f12087e) {
            try {
                transitionAlpha = view.getTransitionAlpha();
                return transitionAlpha;
            } catch (NoSuchMethodError unused) {
                f12087e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // n0.m0
    public void d(View view) {
    }

    @Override // n0.m0
    public void f(View view, float f6) {
        if (f12087e) {
            try {
                view.setTransitionAlpha(f6);
                return;
            } catch (NoSuchMethodError unused) {
                f12087e = false;
            }
        }
        view.setAlpha(f6);
    }
}
