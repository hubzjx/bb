package n0;

import android.os.Build;
import android.view.ViewGroup;
/* loaded from: classes.dex */
abstract class x {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f12181a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static v a(ViewGroup viewGroup) {
        return new u(viewGroup);
    }

    private static void b(ViewGroup viewGroup, boolean z5) {
        if (f12181a) {
            try {
                viewGroup.suppressLayout(z5);
            } catch (NoSuchMethodError unused) {
                f12181a = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(ViewGroup viewGroup, boolean z5) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z5);
        } else {
            b(viewGroup, z5);
        }
    }
}
