package v4;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.secret.prettyhezi.C0382R;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Activity f13685a;

    /* renamed from: b  reason: collision with root package name */
    private SwipeBackLayout f13686b;

    public a(Activity activity) {
        this.f13685a = activity;
    }

    public View a(int i6) {
        SwipeBackLayout swipeBackLayout = this.f13686b;
        if (swipeBackLayout != null) {
            return swipeBackLayout.findViewById(i6);
        }
        return null;
    }

    public SwipeBackLayout b() {
        return this.f13686b;
    }

    public void c() {
        this.f13685a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f13685a.getWindow().getDecorView().setBackgroundDrawable(null);
        this.f13686b = (SwipeBackLayout) LayoutInflater.from(this.f13685a).inflate(C0382R.layout.swipeback_layout, (ViewGroup) null);
    }

    public void d() {
        this.f13686b.p(this.f13685a);
    }
}
