package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.i2;
import androidx.fragment.app.FragmentActivity;
import h.b;
import t.j;
import t.l;
/* loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements d.a, l.a {

    /* renamed from: r  reason: collision with root package name */
    private c f318r;

    /* renamed from: s  reason: collision with root package name */
    private Resources f319s;

    private boolean B(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    public boolean A() {
        Intent e6 = e();
        if (e6 != null) {
            if (!D(e6)) {
                C(e6);
                return true;
            }
            l d6 = l.d(this);
            w(d6);
            y(d6);
            d6.e();
            try {
                t.a.i(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        }
        return false;
    }

    public void C(Intent intent) {
        j.e(this, intent);
    }

    public boolean D(Intent intent) {
        return j.f(this, intent);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        u().d(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(u().f(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a v5 = v();
        if (getWindow().hasFeature(0)) {
            if (v5 == null || !v5.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // d.a
    public h.b d(b.a aVar) {
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a v5 = v();
        if (keyCode == 82 && v5 != null && v5.p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // t.l.a
    public Intent e() {
        return j.a(this);
    }

    @Override // d.a
    public void f(h.b bVar) {
    }

    @Override // android.app.Activity
    public View findViewById(int i6) {
        return u().i(i6);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return u().l();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f319s == null && i2.b()) {
            this.f319s = new i2(this, super.getResources());
        }
        Resources resources = this.f319s;
        return resources == null ? super.getResources() : resources;
    }

    @Override // d.a
    public void i(h.b bVar) {
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        u().o();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f319s != null) {
            this.f319s.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        u().p(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        c u5 = u();
        u5.n();
        u5.q(bundle);
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        u().r();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (B(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i6, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i6, MenuItem menuItem) {
        if (super.onMenuItemSelected(i6, menuItem)) {
            return true;
        }
        a v5 = v();
        if (menuItem.getItemId() != 16908332 || v5 == null || (v5.j() & 4) == 0) {
            return false;
        }
        return A();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i6, Menu menu) {
        return super.onMenuOpened(i6, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i6, Menu menu) {
        super.onPanelClosed(i6, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        u().s(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        u().t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        u().u(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        u().v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        u().w();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i6) {
        super.onTitleChanged(charSequence, i6);
        u().E(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a v5 = v();
        if (getWindow().hasFeature(0)) {
            if (v5 == null || !v5.q()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i6) {
        u().A(i6);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i6) {
        super.setTheme(i6);
        u().D(i6);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void t() {
        u().o();
    }

    public c u() {
        if (this.f318r == null) {
            this.f318r = c.g(this, this);
        }
        return this.f318r;
    }

    public a v() {
        return u().m();
    }

    public void w(l lVar) {
        lVar.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(int i6) {
    }

    public void y(l lVar) {
    }

    public void z() {
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        u().B(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        u().C(view, layoutParams);
    }
}
