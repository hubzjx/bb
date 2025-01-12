package i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
/* loaded from: classes.dex */
public class d extends b implements Menu {

    /* renamed from: d  reason: collision with root package name */
    private final y.a f10827d;

    public d(Context context, y.a aVar) {
        super(context);
        if (aVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f10827d = aVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i6) {
        return c(this.f10827d.add(i6));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i6, int i7, int i8, ComponentName componentName, Intent[] intentArr, Intent intent, int i9, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = this.f10827d.addIntentOptions(i6, i7, i8, componentName, intentArr, intent, i9, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i10 = 0; i10 < length; i10++) {
                menuItemArr[i10] = c(menuItemArr2[i10]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i6) {
        return d(this.f10827d.addSubMenu(i6));
    }

    @Override // android.view.Menu
    public void clear() {
        e();
        this.f10827d.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f10827d.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i6) {
        return c(this.f10827d.findItem(i6));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i6) {
        return c(this.f10827d.getItem(i6));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f10827d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i6, KeyEvent keyEvent) {
        return this.f10827d.isShortcutKey(i6, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i6, int i7) {
        return this.f10827d.performIdentifierAction(i6, i7);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i6, KeyEvent keyEvent, int i7) {
        return this.f10827d.performShortcut(i6, keyEvent, i7);
    }

    @Override // android.view.Menu
    public void removeGroup(int i6) {
        f(i6);
        this.f10827d.removeGroup(i6);
    }

    @Override // android.view.Menu
    public void removeItem(int i6) {
        g(i6);
        this.f10827d.removeItem(i6);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i6, boolean z5, boolean z6) {
        this.f10827d.setGroupCheckable(i6, z5, z6);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i6, boolean z5) {
        this.f10827d.setGroupEnabled(i6, z5);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i6, boolean z5) {
        this.f10827d.setGroupVisible(i6, z5);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z5) {
        this.f10827d.setQwertyMode(z5);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f10827d.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i6, int i7, int i8, int i9) {
        return c(this.f10827d.add(i6, i7, i8, i9));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i6, int i7, int i8, int i9) {
        return d(this.f10827d.addSubMenu(i6, i7, i8, i9));
    }

    @Override // android.view.Menu
    public MenuItem add(int i6, int i7, int i8, CharSequence charSequence) {
        return c(this.f10827d.add(i6, i7, i8, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i6, int i7, int i8, CharSequence charSequence) {
        return d(this.f10827d.addSubMenu(i6, i7, i8, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return c(this.f10827d.add(charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return d(this.f10827d.addSubMenu(charSequence));
    }
}
