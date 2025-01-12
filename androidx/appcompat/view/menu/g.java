package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.k;
import e0.b;
import okhttp3.HttpUrl;
import okhttp3.dnsoverhttps.DnsOverHttps;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public final class g implements y.b {
    private View A;
    private e0.b B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    private final int f582a;

    /* renamed from: b  reason: collision with root package name */
    private final int f583b;

    /* renamed from: c  reason: collision with root package name */
    private final int f584c;

    /* renamed from: d  reason: collision with root package name */
    private final int f585d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f586e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f587f;

    /* renamed from: g  reason: collision with root package name */
    private Intent f588g;

    /* renamed from: h  reason: collision with root package name */
    private char f589h;

    /* renamed from: j  reason: collision with root package name */
    private char f591j;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f593l;

    /* renamed from: n  reason: collision with root package name */
    e f595n;

    /* renamed from: o  reason: collision with root package name */
    private m f596o;

    /* renamed from: p  reason: collision with root package name */
    private Runnable f597p;

    /* renamed from: q  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f598q;

    /* renamed from: r  reason: collision with root package name */
    private CharSequence f599r;

    /* renamed from: s  reason: collision with root package name */
    private CharSequence f600s;

    /* renamed from: z  reason: collision with root package name */
    private int f607z;

    /* renamed from: i  reason: collision with root package name */
    private int f590i = _BufferKt.SEGMENTING_THRESHOLD;

    /* renamed from: k  reason: collision with root package name */
    private int f592k = _BufferKt.SEGMENTING_THRESHOLD;

    /* renamed from: m  reason: collision with root package name */
    private int f594m = 0;

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f601t = null;

    /* renamed from: u  reason: collision with root package name */
    private PorterDuff.Mode f602u = null;

    /* renamed from: v  reason: collision with root package name */
    private boolean f603v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f604w = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f605x = false;

    /* renamed from: y  reason: collision with root package name */
    private int f606y = 16;
    private boolean D = false;

    /* loaded from: classes.dex */
    class a implements b.InterfaceC0157b {
        a() {
        }

        @Override // e0.b.InterfaceC0157b
        public void onActionProviderVisibilityChanged(boolean z5) {
            g gVar = g.this;
            gVar.f595n.J(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i6, int i7, int i8, int i9, CharSequence charSequence, int i10) {
        this.f595n = eVar;
        this.f582a = i7;
        this.f583b = i6;
        this.f584c = i8;
        this.f585d = i9;
        this.f586e = charSequence;
        this.f607z = i10;
    }

    private static void d(StringBuilder sb, int i6, int i7, String str) {
        if ((i6 & i7) == i7) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f605x && (this.f603v || this.f604w)) {
            drawable = x.b.r(drawable).mutate();
            if (this.f603v) {
                x.b.o(drawable, this.f601t);
            }
            if (this.f604w) {
                x.b.p(drawable, this.f602u);
            }
            this.f605x = false;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.f595n.H() && g() != 0;
    }

    public boolean B() {
        return (this.f607z & 4) == 4;
    }

    @Override // y.b
    public y.b a(e0.b bVar) {
        e0.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.g();
        }
        this.A = null;
        this.B = bVar;
        this.f595n.K(true);
        e0.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.i(new a());
        }
        return this;
    }

    @Override // y.b
    public e0.b b() {
        return this.B;
    }

    public void c() {
        this.f595n.I(this);
    }

    @Override // y.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f607z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f595n.f(this);
        }
        return false;
    }

    @Override // y.b, android.view.MenuItem
    public boolean expandActionView() {
        if (j()) {
            MenuItem.OnActionExpandListener onActionExpandListener = this.C;
            if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
                return this.f595n.k(this);
            }
            return false;
        }
        return false;
    }

    public int f() {
        return this.f585d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char g() {
        return this.f595n.G() ? this.f591j : this.f589h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // y.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        e0.b bVar = this.B;
        if (bVar != null) {
            View c6 = bVar.c(this);
            this.A = c6;
            return c6;
        }
        return null;
    }

    @Override // y.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f592k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f591j;
    }

    @Override // y.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f599r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f583b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f593l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f594m != 0) {
            Drawable d6 = e.b.d(this.f595n.u(), this.f594m);
            this.f594m = 0;
            this.f593l = d6;
            return e(d6);
        }
        return null;
    }

    @Override // y.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f601t;
    }

    @Override // y.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f602u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f588g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f582a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // y.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f590i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f589h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f584c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f596o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f586e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f587f;
        return charSequence != null ? charSequence : this.f586e;
    }

    @Override // y.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f600s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        int i6;
        char g6 = g();
        if (g6 == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        Resources resources = this.f595n.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f595n.u()).hasPermanentMenuKey()) {
            sb.append(resources.getString(b.h.abc_prepend_shortcut_label));
        }
        int i7 = this.f595n.G() ? this.f592k : this.f590i;
        d(sb, i7, DnsOverHttps.MAX_RESPONSE_SIZE, resources.getString(b.h.abc_menu_meta_shortcut_label));
        d(sb, i7, _BufferKt.SEGMENTING_THRESHOLD, resources.getString(b.h.abc_menu_ctrl_shortcut_label));
        d(sb, i7, 2, resources.getString(b.h.abc_menu_alt_shortcut_label));
        d(sb, i7, 1, resources.getString(b.h.abc_menu_shift_shortcut_label));
        d(sb, i7, 4, resources.getString(b.h.abc_menu_sym_shortcut_label));
        d(sb, i7, 8, resources.getString(b.h.abc_menu_function_shortcut_label));
        if (g6 == '\b') {
            i6 = b.h.abc_menu_delete_shortcut_label;
        } else if (g6 == '\n') {
            i6 = b.h.abc_menu_enter_shortcut_label;
        } else if (g6 != ' ') {
            sb.append(g6);
            return sb.toString();
        } else {
            i6 = b.h.abc_menu_space_shortcut_label;
        }
        sb.append(resources.getString(i6));
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f596o != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence i(k.a aVar) {
        return (aVar == null || !aVar.d()) ? getTitle() : getTitleCondensed();
    }

    @Override // y.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f606y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f606y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f606y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        e0.b bVar = this.B;
        return (bVar == null || !bVar.f()) ? (this.f606y & 8) == 0 : (this.f606y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        e0.b bVar;
        if ((this.f607z & 8) != 0) {
            if (this.A == null && (bVar = this.B) != null) {
                this.A = bVar.c(this);
            }
            return this.A != null;
        }
        return false;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f598q;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(this)) {
            e eVar = this.f595n;
            if (eVar.h(eVar, this)) {
                return true;
            }
            Runnable runnable = this.f597p;
            if (runnable != null) {
                runnable.run();
                return true;
            }
            if (this.f588g != null) {
                try {
                    this.f595n.u().startActivity(this.f588g);
                    return true;
                } catch (ActivityNotFoundException e6) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e6);
                }
            }
            e0.b bVar = this.B;
            return bVar != null && bVar.d();
        }
        return true;
    }

    public boolean l() {
        return (this.f606y & 32) == 32;
    }

    public boolean m() {
        return (this.f606y & 4) != 0;
    }

    public boolean n() {
        return (this.f607z & 1) == 1;
    }

    public boolean o() {
        return (this.f607z & 2) == 2;
    }

    @Override // y.b, android.view.MenuItem
    /* renamed from: p */
    public y.b setActionView(int i6) {
        Context u5 = this.f595n.u();
        setActionView(LayoutInflater.from(u5).inflate(i6, (ViewGroup) new LinearLayout(u5), false));
        return this;
    }

    @Override // y.b, android.view.MenuItem
    /* renamed from: q */
    public y.b setActionView(View view) {
        int i6;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i6 = this.f582a) > 0) {
            view.setId(i6);
        }
        this.f595n.I(this);
        return this;
    }

    public void r(boolean z5) {
        this.D = z5;
        this.f595n.K(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z5) {
        int i6 = this.f606y;
        int i7 = (z5 ? 2 : 0) | (i6 & (-3));
        this.f606y = i7;
        if (i6 != i7) {
            this.f595n.K(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6) {
        if (this.f591j == c6) {
            return this;
        }
        this.f591j = Character.toLowerCase(c6);
        this.f595n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z5) {
        int i6 = this.f606y;
        int i7 = (z5 ? 1 : 0) | (i6 & (-2));
        this.f606y = i7;
        if (i6 != i7) {
            this.f595n.K(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z5) {
        if ((this.f606y & 4) != 0) {
            this.f595n.T(this);
        } else {
            s(z5);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z5) {
        this.f606y = z5 ? this.f606y | 16 : this.f606y & (-17);
        this.f595n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i6) {
        this.f593l = null;
        this.f594m = i6;
        this.f605x = true;
        this.f595n.K(false);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f601t = colorStateList;
        this.f603v = true;
        this.f605x = true;
        this.f595n.K(false);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f602u = mode;
        this.f604w = true;
        this.f605x = true;
        this.f595n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f588g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c6) {
        if (this.f589h == c6) {
            return this;
        }
        this.f589h = c6;
        this.f595n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f598q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7) {
        this.f589h = c6;
        this.f591j = Character.toLowerCase(c7);
        this.f595n.K(false);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public void setShowAsAction(int i6) {
        int i7 = i6 & 3;
        if (i7 != 0 && i7 != 1 && i7 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f607z = i6;
        this.f595n.I(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i6) {
        return setTitle(this.f595n.u().getString(i6));
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f587f = charSequence;
        this.f595n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z5) {
        if (y(z5)) {
            this.f595n.J(this);
        }
        return this;
    }

    public void t(boolean z5) {
        this.f606y = (z5 ? 4 : 0) | (this.f606y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f586e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z5) {
        this.f606y = z5 ? this.f606y | 32 : this.f606y & (-33);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // y.b, android.view.MenuItem
    /* renamed from: w */
    public y.b setShowAsActionFlags(int i6) {
        setShowAsAction(i6);
        return this;
    }

    public void x(m mVar) {
        this.f596o = mVar;
        mVar.setHeaderTitle(getTitle());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y(boolean z5) {
        int i6 = this.f606y;
        int i7 = (z5 ? 0 : 8) | (i6 & (-9));
        this.f606y = i7;
        return i6 != i7;
    }

    public boolean z() {
        return this.f595n.A();
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6, int i6) {
        if (this.f591j == c6 && this.f592k == i6) {
            return this;
        }
        this.f591j = Character.toLowerCase(c6);
        this.f592k = KeyEvent.normalizeMetaState(i6);
        this.f595n.K(false);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public y.b setContentDescription(CharSequence charSequence) {
        this.f599r = charSequence;
        this.f595n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f594m = 0;
        this.f593l = drawable;
        this.f605x = true;
        this.f595n.K(false);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c6, int i6) {
        if (this.f589h == c6 && this.f590i == i6) {
            return this;
        }
        this.f589h = c6;
        this.f590i = KeyEvent.normalizeMetaState(i6);
        this.f595n.K(false);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7, int i6, int i7) {
        this.f589h = c6;
        this.f590i = KeyEvent.normalizeMetaState(i6);
        this.f591j = Character.toLowerCase(c7);
        this.f592k = KeyEvent.normalizeMetaState(i7);
        this.f595n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f586e = charSequence;
        this.f595n.K(false);
        m mVar = this.f596o;
        if (mVar != null) {
            mVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public y.b setTooltipText(CharSequence charSequence) {
        this.f600s = charSequence;
        this.f595n.K(false);
        return this;
    }
}
