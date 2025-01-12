package i;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import l.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    final Context f10813a;

    /* renamed from: b  reason: collision with root package name */
    private g f10814b;

    /* renamed from: c  reason: collision with root package name */
    private g f10815c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f10813a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (menuItem instanceof y.b) {
            y.b bVar = (y.b) menuItem;
            if (this.f10814b == null) {
                this.f10814b = new g();
            }
            MenuItem menuItem2 = (MenuItem) this.f10814b.get(menuItem);
            if (menuItem2 == null) {
                c cVar = new c(this.f10813a, bVar);
                this.f10814b.put(bVar, cVar);
                return cVar;
            }
            return menuItem2;
        }
        return menuItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        g gVar = this.f10814b;
        if (gVar != null) {
            gVar.clear();
        }
        g gVar2 = this.f10815c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i6) {
        if (this.f10814b == null) {
            return;
        }
        int i7 = 0;
        while (i7 < this.f10814b.size()) {
            if (((y.b) this.f10814b.i(i7)).getGroupId() == i6) {
                this.f10814b.k(i7);
                i7--;
            }
            i7++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(int i6) {
        if (this.f10814b == null) {
            return;
        }
        for (int i7 = 0; i7 < this.f10814b.size(); i7++) {
            if (((y.b) this.f10814b.i(i7)).getItemId() == i6) {
                this.f10814b.k(i7);
                return;
            }
        }
    }
}
