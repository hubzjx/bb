package n0;

import android.graphics.Matrix;
import android.view.View;
/* loaded from: classes.dex */
class l0 extends k0 {
    @Override // n0.d0, n0.m0
    public float c(View view) {
        float transitionAlpha;
        transitionAlpha = view.getTransitionAlpha();
        return transitionAlpha;
    }

    @Override // n0.i0, n0.m0
    public void e(View view, int i6, int i7, int i8, int i9) {
        view.setLeftTopRightBottom(i6, i7, i8, i9);
    }

    @Override // n0.d0, n0.m0
    public void f(View view, float f6) {
        view.setTransitionAlpha(f6);
    }

    @Override // n0.k0, n0.m0
    public void g(View view, int i6) {
        view.setTransitionVisibility(i6);
    }

    @Override // n0.g0, n0.m0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // n0.g0, n0.m0
    public void i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
