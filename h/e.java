package h;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import h.b;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e extends b implements e.a {

    /* renamed from: d  reason: collision with root package name */
    private Context f10535d;

    /* renamed from: e  reason: collision with root package name */
    private ActionBarContextView f10536e;

    /* renamed from: f  reason: collision with root package name */
    private b.a f10537f;

    /* renamed from: g  reason: collision with root package name */
    private WeakReference f10538g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10539h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10540i;

    /* renamed from: j  reason: collision with root package name */
    private androidx.appcompat.view.menu.e f10541j;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z5) {
        this.f10535d = context;
        this.f10536e = actionBarContextView;
        this.f10537f = aVar;
        androidx.appcompat.view.menu.e S = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).S(1);
        this.f10541j = S;
        S.R(this);
        this.f10540i = z5;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        return this.f10537f.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        k();
        this.f10536e.l();
    }

    @Override // h.b
    public void c() {
        if (this.f10539h) {
            return;
        }
        this.f10539h = true;
        this.f10536e.sendAccessibilityEvent(32);
        this.f10537f.d(this);
    }

    @Override // h.b
    public View d() {
        WeakReference weakReference = this.f10538g;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // h.b
    public Menu e() {
        return this.f10541j;
    }

    @Override // h.b
    public MenuInflater f() {
        return new g(this.f10536e.getContext());
    }

    @Override // h.b
    public CharSequence g() {
        return this.f10536e.getSubtitle();
    }

    @Override // h.b
    public CharSequence i() {
        return this.f10536e.getTitle();
    }

    @Override // h.b
    public void k() {
        this.f10537f.c(this, this.f10541j);
    }

    @Override // h.b
    public boolean l() {
        return this.f10536e.j();
    }

    @Override // h.b
    public void m(View view) {
        this.f10536e.setCustomView(view);
        this.f10538g = view != null ? new WeakReference(view) : null;
    }

    @Override // h.b
    public void n(int i6) {
        o(this.f10535d.getString(i6));
    }

    @Override // h.b
    public void o(CharSequence charSequence) {
        this.f10536e.setSubtitle(charSequence);
    }

    @Override // h.b
    public void q(int i6) {
        r(this.f10535d.getString(i6));
    }

    @Override // h.b
    public void r(CharSequence charSequence) {
        this.f10536e.setTitle(charSequence);
    }

    @Override // h.b
    public void s(boolean z5) {
        super.s(z5);
        this.f10536e.setTitleOptional(z5);
    }
}
