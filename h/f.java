package h;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import h.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f10542a;

    /* renamed from: b  reason: collision with root package name */
    final b f10543b;

    /* loaded from: classes.dex */
    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f10544a;

        /* renamed from: b  reason: collision with root package name */
        final Context f10545b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList f10546c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        final l.g f10547d = new l.g();

        public a(Context context, ActionMode.Callback callback) {
            this.f10545b = context;
            this.f10544a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = (Menu) this.f10547d.get(menu);
            if (menu2 == null) {
                i.d dVar = new i.d(this.f10545b, (y.a) menu);
                this.f10547d.put(menu, dVar);
                return dVar;
            }
            return menu2;
        }

        @Override // h.b.a
        public boolean a(b bVar, MenuItem menuItem) {
            return this.f10544a.onActionItemClicked(e(bVar), new i.c(this.f10545b, (y.b) menuItem));
        }

        @Override // h.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f10544a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // h.b.a
        public boolean c(b bVar, Menu menu) {
            return this.f10544a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // h.b.a
        public void d(b bVar) {
            this.f10544a.onDestroyActionMode(e(bVar));
        }

        public ActionMode e(b bVar) {
            int size = this.f10546c.size();
            for (int i6 = 0; i6 < size; i6++) {
                f fVar = (f) this.f10546c.get(i6);
                if (fVar != null && fVar.f10543b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f10545b, bVar);
            this.f10546c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f10542a = context;
        this.f10543b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f10543b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f10543b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new i.d(this.f10542a, (y.a) this.f10543b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f10543b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f10543b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f10543b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f10543b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f10543b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f10543b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f10543b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f10543b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i6) {
        this.f10543b.n(i6);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f10543b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i6) {
        this.f10543b.q(i6);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z5) {
        this.f10543b.s(z5);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f10543b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f10543b.r(charSequence);
    }
}
