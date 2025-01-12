package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.e;
/* loaded from: classes.dex */
public class m extends e implements SubMenu {
    private e B;
    private g C;

    public m(Context context, e eVar, g gVar) {
        super(context);
        this.B = eVar;
        this.C = gVar;
    }

    @Override // androidx.appcompat.view.menu.e
    public e D() {
        return this.B.D();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean F() {
        return this.B.F();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean G() {
        return this.B.G();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean H() {
        return this.B.H();
    }

    @Override // androidx.appcompat.view.menu.e
    public void R(e.a aVar) {
        this.B.R(aVar);
    }

    public Menu e0() {
        return this.B;
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean f(g gVar) {
        return this.B.f(gVar);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.view.menu.e
    public boolean h(e eVar, MenuItem menuItem) {
        return super.h(eVar, menuItem) || this.B.h(eVar, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean k(g gVar) {
        return this.B.k(gVar);
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public void setGroupDividerEnabled(boolean z5) {
        this.B.setGroupDividerEnabled(z5);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i6) {
        return (SubMenu) super.U(i6);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i6) {
        return (SubMenu) super.X(i6);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.Z(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i6) {
        this.C.setIcon(i6);
        return this;
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public void setQwertyMode(boolean z5) {
        this.B.setQwertyMode(z5);
    }

    @Override // androidx.appcompat.view.menu.e
    public String t() {
        g gVar = this.C;
        int itemId = gVar != null ? gVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.t() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.V(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.Y(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }
}
