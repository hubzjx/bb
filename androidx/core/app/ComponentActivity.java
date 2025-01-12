package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.c;
import androidx.lifecycle.f;
import e0.e;
import l.g;
/* loaded from: classes.dex */
public class ComponentActivity extends Activity implements f, e.a {

    /* renamed from: b  reason: collision with root package name */
    private g f1556b = new g();

    /* renamed from: c  reason: collision with root package name */
    private androidx.lifecycle.g f1557c = new androidx.lifecycle.g(this);

    @Override // e0.e.a
    public boolean c(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !e.d(decorView, keyEvent)) {
            return e.e(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !e.d(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    public c h() {
        return this.f1557c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f1557c.k(c.b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
