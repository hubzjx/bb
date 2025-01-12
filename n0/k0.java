package n0;

import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
class k0 extends i0 {

    /* renamed from: i  reason: collision with root package name */
    private static boolean f12106i = true;

    @Override // n0.m0
    public void g(View view, int i6) {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i6);
        } else if (f12106i) {
            try {
                view.setTransitionVisibility(i6);
            } catch (NoSuchMethodError unused) {
                f12106i = false;
            }
        }
    }
}
