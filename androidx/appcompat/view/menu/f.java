package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.j;
/* loaded from: classes.dex */
class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, j.a {

    /* renamed from: b  reason: collision with root package name */
    private e f578b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.appcompat.app.b f579c;

    /* renamed from: d  reason: collision with root package name */
    c f580d;

    /* renamed from: e  reason: collision with root package name */
    private j.a f581e;

    public f(e eVar) {
        this.f578b = eVar;
    }

    public void a() {
        androidx.appcompat.app.b bVar = this.f579c;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void b(e eVar, boolean z5) {
        if (z5 || eVar == this.f578b) {
            a();
        }
        j.a aVar = this.f581e;
        if (aVar != null) {
            aVar.b(eVar, z5);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean c(e eVar) {
        j.a aVar = this.f581e;
        if (aVar != null) {
            return aVar.c(eVar);
        }
        return false;
    }

    public void d(IBinder iBinder) {
        e eVar = this.f578b;
        b.a aVar = new b.a(eVar.u());
        c cVar = new c(aVar.getContext(), b.g.abc_list_menu_item_layout);
        this.f580d = cVar;
        cVar.k(this);
        this.f578b.b(this.f580d);
        aVar.a(this.f580d.a(), this);
        View y5 = eVar.y();
        if (y5 != null) {
            aVar.b(y5);
        } else {
            aVar.c(eVar.w()).setTitle(eVar.x());
        }
        aVar.e(this);
        androidx.appcompat.app.b create = aVar.create();
        this.f579c = create;
        create.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f579c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f579c.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i6) {
        this.f578b.L((g) this.f580d.a().getItem(i6), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f580d.b(this.f578b, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i6 == 82 || i6 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f579c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f579c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f578b.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f578b.performShortcut(i6, keyEvent, 0);
    }
}
