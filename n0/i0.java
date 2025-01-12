package n0;

import android.view.View;
/* loaded from: classes.dex */
class i0 extends g0 {

    /* renamed from: h  reason: collision with root package name */
    private static boolean f12104h = true;

    @Override // n0.m0
    public void e(View view, int i6, int i7, int i8, int i9) {
        if (f12104h) {
            try {
                view.setLeftTopRightBottom(i6, i7, i8, i9);
            } catch (NoSuchMethodError unused) {
                f12104h = false;
            }
        }
    }
}
