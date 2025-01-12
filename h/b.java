package h;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: b  reason: collision with root package name */
    private Object f10528b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10529c;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(b bVar, MenuItem menuItem);

        boolean b(b bVar, Menu menu);

        boolean c(b bVar, Menu menu);

        void d(b bVar);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f10528b;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f10529c;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i6);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f10528b = obj;
    }

    public abstract void q(int i6);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z5) {
        this.f10529c = z5;
    }
}
