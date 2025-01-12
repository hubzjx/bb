package i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import e0.b;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class c extends i.b implements MenuItem {

    /* renamed from: d  reason: collision with root package name */
    private final y.b f10816d;

    /* renamed from: e  reason: collision with root package name */
    private Method f10817e;

    /* loaded from: classes.dex */
    private class a extends e0.b {

        /* renamed from: d  reason: collision with root package name */
        final ActionProvider f10818d;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f10818d = actionProvider;
        }

        @Override // e0.b
        public boolean a() {
            return this.f10818d.hasSubMenu();
        }

        @Override // e0.b
        public boolean d() {
            return this.f10818d.onPerformDefaultAction();
        }

        @Override // e0.b
        public void e(SubMenu subMenu) {
            this.f10818d.onPrepareSubMenu(c.this.d(subMenu));
        }
    }

    /* loaded from: classes.dex */
    private class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: f  reason: collision with root package name */
        private b.InterfaceC0157b f10820f;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // e0.b
        public boolean b() {
            return this.f10818d.isVisible();
        }

        @Override // e0.b
        public View c(MenuItem menuItem) {
            return this.f10818d.onCreateActionView(menuItem);
        }

        @Override // e0.b
        public boolean f() {
            return this.f10818d.overridesItemVisibility();
        }

        @Override // e0.b
        public void i(b.InterfaceC0157b interfaceC0157b) {
            this.f10820f = interfaceC0157b;
            this.f10818d.setVisibilityListener(interfaceC0157b != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z5) {
            b.InterfaceC0157b interfaceC0157b = this.f10820f;
            if (interfaceC0157b != null) {
                interfaceC0157b.onActionProviderVisibilityChanged(z5);
            }
        }
    }

    /* renamed from: i.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0174c extends FrameLayout implements h.c {

        /* renamed from: b  reason: collision with root package name */
        final CollapsibleActionView f10822b;

        C0174c(View view) {
            super(view.getContext());
            this.f10822b = (CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f10822b;
        }

        @Override // h.c
        public void c() {
            this.f10822b.onActionViewExpanded();
        }

        @Override // h.c
        public void f() {
            this.f10822b.onActionViewCollapsed();
        }
    }

    /* loaded from: classes.dex */
    private class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f10823a;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f10823a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f10823a.onMenuItemActionCollapse(c.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f10823a.onMenuItemActionExpand(c.this.c(menuItem));
        }
    }

    /* loaded from: classes.dex */
    private class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f10825a;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f10825a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f10825a.onMenuItemClick(c.this.c(menuItem));
        }
    }

    public c(Context context, y.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f10816d = bVar;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f10816d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f10816d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        e0.b b6 = this.f10816d.b();
        if (b6 instanceof a) {
            return ((a) b6).f10818d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f10816d.getActionView();
        return actionView instanceof C0174c ? ((C0174c) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f10816d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f10816d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f10816d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f10816d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f10816d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f10816d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f10816d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f10816d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f10816d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f10816d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f10816d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f10816d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f10816d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.f10816d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f10816d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f10816d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f10816d.getTooltipText();
    }

    public void h(boolean z5) {
        try {
            if (this.f10817e == null) {
                this.f10817e = this.f10816d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f10817e.invoke(this.f10816d, Boolean.valueOf(z5));
        } catch (Exception e6) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e6);
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f10816d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f10816d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f10816d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f10816d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f10816d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f10816d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this.f10813a, actionProvider);
        y.b bVar2 = this.f10816d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i6) {
        this.f10816d.setActionView(i6);
        View actionView = this.f10816d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f10816d.setActionView(new C0174c(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6) {
        this.f10816d.setAlphabeticShortcut(c6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z5) {
        this.f10816d.setCheckable(z5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z5) {
        this.f10816d.setChecked(z5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f10816d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z5) {
        this.f10816d.setEnabled(z5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i6) {
        this.f10816d.setIcon(i6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f10816d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f10816d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f10816d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c6) {
        this.f10816d.setNumericShortcut(c6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f10816d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f10816d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7) {
        this.f10816d.setShortcut(c6, c7);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i6) {
        this.f10816d.setShowAsAction(i6);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i6) {
        this.f10816d.setShowAsActionFlags(i6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i6) {
        this.f10816d.setTitle(i6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f10816d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f10816d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z5) {
        return this.f10816d.setVisible(z5);
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0174c(view);
        }
        this.f10816d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6, int i6) {
        this.f10816d.setAlphabeticShortcut(c6, i6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f10816d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c6, int i6) {
        this.f10816d.setNumericShortcut(c6, i6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7, int i6, int i7) {
        this.f10816d.setShortcut(c6, c7, i6, i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f10816d.setTitle(charSequence);
        return this;
    }
}
