package t;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
/* loaded from: classes.dex */
public abstract class a extends u.c {

    /* renamed from: t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0215a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f13300a;

        RunnableC0215a(Activity activity) {
            this.f13300a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13300a.isFinishing() || t.b.i(this.f13300a)) {
                return;
            }
            this.f13300a.recreate();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public static void i(Activity activity) {
        activity.finishAffinity();
    }

    public static b j() {
        return null;
    }

    public static void k(Activity activity) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 28) {
            if (i6 <= 23) {
                new Handler(activity.getMainLooper()).post(new RunnableC0215a(activity));
                return;
            } else if (t.b.i(activity)) {
                return;
            }
        }
        activity.recreate();
    }
}
