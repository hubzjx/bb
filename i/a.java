package i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public class a implements y.b {

    /* renamed from: a  reason: collision with root package name */
    private final int f10793a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10794b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10795c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f10796d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f10797e;

    /* renamed from: f  reason: collision with root package name */
    private Intent f10798f;

    /* renamed from: g  reason: collision with root package name */
    private char f10799g;

    /* renamed from: i  reason: collision with root package name */
    private char f10801i;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f10803k;

    /* renamed from: l  reason: collision with root package name */
    private Context f10804l;

    /* renamed from: m  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f10805m;

    /* renamed from: n  reason: collision with root package name */
    private CharSequence f10806n;

    /* renamed from: o  reason: collision with root package name */
    private CharSequence f10807o;

    /* renamed from: h  reason: collision with root package name */
    private int f10800h = _BufferKt.SEGMENTING_THRESHOLD;

    /* renamed from: j  reason: collision with root package name */
    private int f10802j = _BufferKt.SEGMENTING_THRESHOLD;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f10808p = null;

    /* renamed from: q  reason: collision with root package name */
    private PorterDuff.Mode f10809q = null;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10810r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f10811s = false;

    /* renamed from: t  reason: collision with root package name */
    private int f10812t = 16;

    public a(Context context, int i6, int i7, int i8, int i9, CharSequence charSequence) {
        this.f10804l = context;
        this.f10793a = i7;
        this.f10794b = i6;
        this.f10795c = i9;
        this.f10796d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f10803k;
        if (drawable != null) {
            if (this.f10810r || this.f10811s) {
                Drawable r5 = x.b.r(drawable);
                this.f10803k = r5;
                Drawable mutate = r5.mutate();
                this.f10803k = mutate;
                if (this.f10810r) {
                    x.b.o(mutate, this.f10808p);
                }
                if (this.f10811s) {
                    x.b.p(this.f10803k, this.f10809q);
                }
            }
        }
    }

    @Override // y.b
    public y.b a(e0.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // y.b
    public e0.b b() {
        return null;
    }

    @Override // y.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // y.b, android.view.MenuItem
    /* renamed from: d */
    public y.b setActionView(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // y.b, android.view.MenuItem
    /* renamed from: e */
    public y.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // y.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // y.b, android.view.MenuItem
    /* renamed from: f */
    public y.b setShowAsActionFlags(int i6) {
        setShowAsAction(i6);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // y.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // y.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f10802j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f10801i;
    }

    @Override // y.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f10806n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f10794b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f10803k;
    }

    @Override // y.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f10808p;
    }

    @Override // y.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f10809q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f10798f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f10793a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // y.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f10800h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f10799g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f10795c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f10796d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f10797e;
        return charSequence != null ? charSequence : this.f10796d;
    }

    @Override // y.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f10807o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // y.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f10812t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f10812t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f10812t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f10812t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6) {
        this.f10801i = Character.toLowerCase(c6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z5) {
        this.f10812t = (z5 ? 1 : 0) | (this.f10812t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z5) {
        this.f10812t = (z5 ? 2 : 0) | (this.f10812t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z5) {
        this.f10812t = (z5 ? 16 : 0) | (this.f10812t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i6) {
        this.f10803k = u.c.c(this.f10804l, i6);
        c();
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f10808p = colorStateList;
        this.f10810r = true;
        c();
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f10809q = mode;
        this.f10811s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f10798f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c6) {
        this.f10799g = c6;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f10805m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7) {
        this.f10799g = c6;
        this.f10801i = Character.toLowerCase(c7);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public void setShowAsAction(int i6) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i6) {
        this.f10796d = this.f10804l.getResources().getString(i6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f10797e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z5) {
        this.f10812t = (this.f10812t & 8) | (z5 ? 0 : 8);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6, int i6) {
        this.f10801i = Character.toLowerCase(c6);
        this.f10802j = KeyEvent.normalizeMetaState(i6);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public y.b setContentDescription(CharSequence charSequence) {
        this.f10806n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f10803k = drawable;
        c();
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c6, int i6) {
        this.f10799g = c6;
        this.f10800h = KeyEvent.normalizeMetaState(i6);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7, int i6, int i7) {
        this.f10799g = c6;
        this.f10800h = KeyEvent.normalizeMetaState(i6);
        this.f10801i = Character.toLowerCase(c7);
        this.f10802j = KeyEvent.normalizeMetaState(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f10796d = charSequence;
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public y.b setTooltipText(CharSequence charSequence) {
        this.f10807o = charSequence;
        return this;
    }
}
