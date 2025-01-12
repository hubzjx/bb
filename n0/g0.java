package n0;

import android.graphics.Matrix;
import android.view.View;
/* loaded from: classes.dex */
class g0 extends d0 {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f12102f = true;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f12103g = true;

    @Override // n0.m0
    public void h(View view, Matrix matrix) {
        if (f12102f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f12102f = false;
            }
        }
    }

    @Override // n0.m0
    public void i(View view, Matrix matrix) {
        if (f12103g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f12103g = false;
            }
        }
    }
}
