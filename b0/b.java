package b0;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
abstract class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Handler a() {
        return Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
    }
}
