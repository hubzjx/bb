package e0;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f9326a;

    /* renamed from: b  reason: collision with root package name */
    private a f9327b;

    /* renamed from: c  reason: collision with root package name */
    private InterfaceC0157b f9328c;

    /* loaded from: classes.dex */
    public interface a {
    }

    /* renamed from: e0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0157b {
        void onActionProviderVisibilityChanged(boolean z5);
    }

    public b(Context context) {
        this.f9326a = context;
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract View c(MenuItem menuItem);

    public abstract boolean d();

    public abstract void e(SubMenu subMenu);

    public abstract boolean f();

    public void g() {
        this.f9328c = null;
        this.f9327b = null;
    }

    public void h(a aVar) {
        this.f9327b = aVar;
    }

    public abstract void i(InterfaceC0157b interfaceC0157b);
}
