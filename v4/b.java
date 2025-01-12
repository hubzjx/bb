package v4;

import android.app.Activity;
import java.lang.ref.WeakReference;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
/* loaded from: classes.dex */
public class b implements SwipeBackLayout.c {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f13687a;

    public b(Activity activity) {
        this.f13687a = new WeakReference(activity);
    }

    @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.c
    public void a() {
        Activity activity = (Activity) this.f13687a.get();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
        activity.overridePendingTransition(0, 0);
    }

    @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.b
    public void b() {
    }

    @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.b
    public void c(int i6) {
        Activity activity = (Activity) this.f13687a.get();
        if (activity != null) {
            u4.a.a(activity);
        }
    }

    @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.b
    public void d(int i6, float f6) {
    }
}
