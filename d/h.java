package d;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import e0.e;
import h.b;
/* loaded from: classes.dex */
public class h extends Dialog implements d.a {

    /* renamed from: b  reason: collision with root package name */
    private androidx.appcompat.app.c f9052b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a f9053c;

    /* loaded from: classes.dex */
    class a implements e.a {
        a() {
        }

        @Override // e0.e.a
        public boolean c(KeyEvent keyEvent) {
            return h.this.c(keyEvent);
        }
    }

    public h(Context context, int i6) {
        super(context, b(context, i6));
        this.f9053c = new a();
        androidx.appcompat.app.c a6 = a();
        a6.D(b(context, i6));
        a6.q(null);
    }

    private static int b(Context context, int i6) {
        if (i6 == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(b.a.dialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return i6;
    }

    public androidx.appcompat.app.c a() {
        if (this.f9052b == null) {
            this.f9052b = androidx.appcompat.app.c.h(this, this);
        }
        return this.f9052b;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().d(view, layoutParams);
    }

    boolean c(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // d.a
    public h.b d(b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a().r();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return e0.e.e(this.f9053c, getWindow().getDecorView(), this, keyEvent);
    }

    public boolean e(int i6) {
        return a().z(i6);
    }

    @Override // d.a
    public void f(h.b bVar) {
    }

    @Override // android.app.Dialog
    public View findViewById(int i6) {
        return a().i(i6);
    }

    @Override // d.a
    public void i(h.b bVar) {
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        a().n();
        super.onCreate(bundle);
        a().q(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        a().w();
    }

    @Override // android.app.Dialog
    public void setContentView(int i6) {
        a().A(i6);
    }

    @Override // android.app.Dialog
    public void setTitle(int i6) {
        super.setTitle(i6);
        a().E(getContext().getString(i6));
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().B(view);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().E(charSequence);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().C(view, layoutParams);
    }
}
