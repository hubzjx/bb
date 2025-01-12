package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.e1;
import b.j;
import e0.b0;
import e0.r0;
import e0.s0;
import e0.t0;
import e0.u0;
import h.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    private static final Interpolator D = new AccelerateInterpolator();
    private static final Interpolator E = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    Context f425a;

    /* renamed from: b  reason: collision with root package name */
    private Context f426b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f427c;

    /* renamed from: d  reason: collision with root package name */
    ActionBarOverlayLayout f428d;

    /* renamed from: e  reason: collision with root package name */
    ActionBarContainer f429e;

    /* renamed from: f  reason: collision with root package name */
    e1 f430f;

    /* renamed from: g  reason: collision with root package name */
    ActionBarContextView f431g;

    /* renamed from: h  reason: collision with root package name */
    View f432h;

    /* renamed from: k  reason: collision with root package name */
    private boolean f435k;

    /* renamed from: l  reason: collision with root package name */
    d f436l;

    /* renamed from: m  reason: collision with root package name */
    h.b f437m;

    /* renamed from: n  reason: collision with root package name */
    b.a f438n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f439o;

    /* renamed from: q  reason: collision with root package name */
    private boolean f441q;

    /* renamed from: t  reason: collision with root package name */
    boolean f444t;

    /* renamed from: u  reason: collision with root package name */
    boolean f445u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f446v;

    /* renamed from: x  reason: collision with root package name */
    h.h f448x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f449y;

    /* renamed from: z  reason: collision with root package name */
    boolean f450z;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList f433i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private int f434j = -1;

    /* renamed from: p  reason: collision with root package name */
    private ArrayList f440p = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private int f442r = 0;

    /* renamed from: s  reason: collision with root package name */
    boolean f443s = true;

    /* renamed from: w  reason: collision with root package name */
    private boolean f447w = true;
    final s0 A = new a();
    final s0 B = new b();
    final u0 C = new c();

    /* loaded from: classes.dex */
    class a extends t0 {
        a() {
        }

        @Override // e0.s0
        public void b(View view) {
            View view2;
            i iVar = i.this;
            if (iVar.f443s && (view2 = iVar.f432h) != null) {
                view2.setTranslationY(0.0f);
                i.this.f429e.setTranslationY(0.0f);
            }
            i.this.f429e.setVisibility(8);
            i.this.f429e.setTransitioning(false);
            i iVar2 = i.this;
            iVar2.f448x = null;
            iVar2.x();
            ActionBarOverlayLayout actionBarOverlayLayout = i.this.f428d;
            if (actionBarOverlayLayout != null) {
                b0.i0(actionBarOverlayLayout);
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends t0 {
        b() {
        }

        @Override // e0.s0
        public void b(View view) {
            i iVar = i.this;
            iVar.f448x = null;
            iVar.f429e.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    class c implements u0 {
        c() {
        }

        @Override // e0.u0
        public void a(View view) {
            ((View) i.this.f429e.getParent()).invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class d extends h.b implements e.a {

        /* renamed from: d  reason: collision with root package name */
        private final Context f454d;

        /* renamed from: e  reason: collision with root package name */
        private final androidx.appcompat.view.menu.e f455e;

        /* renamed from: f  reason: collision with root package name */
        private b.a f456f;

        /* renamed from: g  reason: collision with root package name */
        private WeakReference f457g;

        public d(Context context, b.a aVar) {
            this.f454d = context;
            this.f456f = aVar;
            androidx.appcompat.view.menu.e S = new androidx.appcompat.view.menu.e(context).S(1);
            this.f455e = S;
            S.R(this);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            b.a aVar = this.f456f;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (this.f456f == null) {
                return;
            }
            k();
            i.this.f431g.l();
        }

        @Override // h.b
        public void c() {
            i iVar = i.this;
            if (iVar.f436l != this) {
                return;
            }
            if (i.w(iVar.f444t, iVar.f445u, false)) {
                this.f456f.d(this);
            } else {
                i iVar2 = i.this;
                iVar2.f437m = this;
                iVar2.f438n = this.f456f;
            }
            this.f456f = null;
            i.this.v(false);
            i.this.f431g.g();
            i.this.f430f.k().sendAccessibilityEvent(32);
            i iVar3 = i.this;
            iVar3.f428d.setHideOnContentScrollEnabled(iVar3.f450z);
            i.this.f436l = null;
        }

        @Override // h.b
        public View d() {
            WeakReference weakReference = this.f457g;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // h.b
        public Menu e() {
            return this.f455e;
        }

        @Override // h.b
        public MenuInflater f() {
            return new h.g(this.f454d);
        }

        @Override // h.b
        public CharSequence g() {
            return i.this.f431g.getSubtitle();
        }

        @Override // h.b
        public CharSequence i() {
            return i.this.f431g.getTitle();
        }

        @Override // h.b
        public void k() {
            if (i.this.f436l != this) {
                return;
            }
            this.f455e.d0();
            try {
                this.f456f.c(this, this.f455e);
            } finally {
                this.f455e.c0();
            }
        }

        @Override // h.b
        public boolean l() {
            return i.this.f431g.j();
        }

        @Override // h.b
        public void m(View view) {
            i.this.f431g.setCustomView(view);
            this.f457g = new WeakReference(view);
        }

        @Override // h.b
        public void n(int i6) {
            o(i.this.f425a.getResources().getString(i6));
        }

        @Override // h.b
        public void o(CharSequence charSequence) {
            i.this.f431g.setSubtitle(charSequence);
        }

        @Override // h.b
        public void q(int i6) {
            r(i.this.f425a.getResources().getString(i6));
        }

        @Override // h.b
        public void r(CharSequence charSequence) {
            i.this.f431g.setTitle(charSequence);
        }

        @Override // h.b
        public void s(boolean z5) {
            super.s(z5);
            i.this.f431g.setTitleOptional(z5);
        }

        public boolean t() {
            this.f455e.d0();
            try {
                return this.f456f.b(this, this.f455e);
            } finally {
                this.f455e.c0();
            }
        }
    }

    public i(Activity activity, boolean z5) {
        this.f427c = activity;
        View decorView = activity.getWindow().getDecorView();
        D(decorView);
        if (z5) {
            return;
        }
        this.f432h = decorView.findViewById(16908290);
    }

    private e1 A(View view) {
        if (view instanceof e1) {
            return (e1) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void C() {
        if (this.f446v) {
            this.f446v = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f428d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            M(false);
        }
    }

    private void D(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(b.f.decor_content_parent);
        this.f428d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f430f = A(view.findViewById(b.f.action_bar));
        this.f431g = (ActionBarContextView) view.findViewById(b.f.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(b.f.action_bar_container);
        this.f429e = actionBarContainer;
        e1 e1Var = this.f430f;
        if (e1Var == null || this.f431g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f425a = e1Var.getContext();
        boolean z5 = (this.f430f.o() & 4) != 0;
        if (z5) {
            this.f435k = true;
        }
        h.a b6 = h.a.b(this.f425a);
        J(b6.a() || z5);
        H(b6.e());
        TypedArray obtainStyledAttributes = this.f425a.obtainStyledAttributes(null, j.f2712a, b.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(j.f2762k, false)) {
            I(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.f2752i, 0);
        if (dimensionPixelSize != 0) {
            G(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void H(boolean z5) {
        this.f441q = z5;
        if (z5) {
            this.f429e.setTabContainer(null);
            this.f430f.j(null);
        } else {
            this.f430f.j(null);
            this.f429e.setTabContainer(null);
        }
        boolean z6 = true;
        boolean z7 = B() == 2;
        this.f430f.u(!this.f441q && z7);
        this.f428d.setHasNonEmbeddedTabs((this.f441q || !z7) ? false : false);
    }

    private boolean K() {
        return b0.R(this.f429e);
    }

    private void L() {
        if (this.f446v) {
            return;
        }
        this.f446v = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f428d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        M(false);
    }

    private void M(boolean z5) {
        if (w(this.f444t, this.f445u, this.f446v)) {
            if (this.f447w) {
                return;
            }
            this.f447w = true;
            z(z5);
        } else if (this.f447w) {
            this.f447w = false;
            y(z5);
        }
    }

    static boolean w(boolean z5, boolean z6, boolean z7) {
        if (z7) {
            return true;
        }
        return (z5 || z6) ? false : true;
    }

    public int B() {
        return this.f430f.q();
    }

    public void E(boolean z5) {
        F(z5 ? 4 : 0, 4);
    }

    public void F(int i6, int i7) {
        int o5 = this.f430f.o();
        if ((i7 & 4) != 0) {
            this.f435k = true;
        }
        this.f430f.n((i6 & i7) | ((~i7) & o5));
    }

    public void G(float f6) {
        b0.s0(this.f429e, f6);
    }

    public void I(boolean z5) {
        if (z5 && !this.f428d.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f450z = z5;
        this.f428d.setHideOnContentScrollEnabled(z5);
    }

    public void J(boolean z5) {
        this.f430f.l(z5);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.f445u) {
            this.f445u = false;
            M(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        h.h hVar = this.f448x;
        if (hVar != null) {
            hVar.a();
            this.f448x = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(int i6) {
        this.f442r = i6;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e(boolean z5) {
        this.f443s = z5;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
        if (this.f445u) {
            return;
        }
        this.f445u = true;
        M(true);
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        e1 e1Var = this.f430f;
        if (e1Var == null || !e1Var.m()) {
            return false;
        }
        this.f430f.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z5) {
        if (z5 == this.f439o) {
            return;
        }
        this.f439o = z5;
        if (this.f440p.size() <= 0) {
            return;
        }
        android.support.v4.media.a.a(this.f440p.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f430f.o();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.f426b == null) {
            TypedValue typedValue = new TypedValue();
            this.f425a.getTheme().resolveAttribute(b.a.actionBarWidgetTheme, typedValue, true);
            int i6 = typedValue.resourceId;
            if (i6 != 0) {
                this.f426b = new ContextThemeWrapper(this.f425a, i6);
            } else {
                this.f426b = this.f425a;
            }
        }
        return this.f426b;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        H(h.a.b(this.f425a).e());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i6, KeyEvent keyEvent) {
        Menu e6;
        d dVar = this.f436l;
        if (dVar == null || (e6 = dVar.e()) == null) {
            return false;
        }
        e6.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return e6.performShortcut(i6, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z5) {
        if (this.f435k) {
            return;
        }
        E(z5);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z5) {
        h.h hVar;
        this.f449y = z5;
        if (z5 || (hVar = this.f448x) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void t(CharSequence charSequence) {
        this.f430f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public h.b u(b.a aVar) {
        d dVar = this.f436l;
        if (dVar != null) {
            dVar.c();
        }
        this.f428d.setHideOnContentScrollEnabled(false);
        this.f431g.k();
        d dVar2 = new d(this.f431g.getContext(), aVar);
        if (dVar2.t()) {
            this.f436l = dVar2;
            dVar2.k();
            this.f431g.h(dVar2);
            v(true);
            this.f431g.sendAccessibilityEvent(32);
            return dVar2;
        }
        return null;
    }

    public void v(boolean z5) {
        r0 r5;
        r0 f6;
        if (z5) {
            L();
        } else {
            C();
        }
        if (!K()) {
            if (z5) {
                this.f430f.i(4);
                this.f431g.setVisibility(0);
                return;
            }
            this.f430f.i(0);
            this.f431g.setVisibility(8);
            return;
        }
        if (z5) {
            f6 = this.f430f.r(4, 100L);
            r5 = this.f431g.f(0, 200L);
        } else {
            r5 = this.f430f.r(0, 200L);
            f6 = this.f431g.f(8, 100L);
        }
        h.h hVar = new h.h();
        hVar.d(f6, r5);
        hVar.h();
    }

    void x() {
        b.a aVar = this.f438n;
        if (aVar != null) {
            aVar.d(this.f437m);
            this.f437m = null;
            this.f438n = null;
        }
    }

    public void y(boolean z5) {
        View view;
        int[] iArr;
        h.h hVar = this.f448x;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f442r != 0 || (!this.f449y && !z5)) {
            this.A.b(null);
            return;
        }
        this.f429e.setAlpha(1.0f);
        this.f429e.setTransitioning(true);
        h.h hVar2 = new h.h();
        float f6 = -this.f429e.getHeight();
        if (z5) {
            this.f429e.getLocationInWindow(new int[]{0, 0});
            f6 -= iArr[1];
        }
        r0 k6 = b0.d(this.f429e).k(f6);
        k6.i(this.C);
        hVar2.c(k6);
        if (this.f443s && (view = this.f432h) != null) {
            hVar2.c(b0.d(view).k(f6));
        }
        hVar2.f(D);
        hVar2.e(250L);
        hVar2.g(this.A);
        this.f448x = hVar2;
        hVar2.h();
    }

    public void z(boolean z5) {
        View view;
        View view2;
        int[] iArr;
        h.h hVar = this.f448x;
        if (hVar != null) {
            hVar.a();
        }
        this.f429e.setVisibility(0);
        if (this.f442r == 0 && (this.f449y || z5)) {
            this.f429e.setTranslationY(0.0f);
            float f6 = -this.f429e.getHeight();
            if (z5) {
                this.f429e.getLocationInWindow(new int[]{0, 0});
                f6 -= iArr[1];
            }
            this.f429e.setTranslationY(f6);
            h.h hVar2 = new h.h();
            r0 k6 = b0.d(this.f429e).k(0.0f);
            k6.i(this.C);
            hVar2.c(k6);
            if (this.f443s && (view2 = this.f432h) != null) {
                view2.setTranslationY(f6);
                hVar2.c(b0.d(this.f432h).k(0.0f));
            }
            hVar2.f(E);
            hVar2.e(250L);
            hVar2.g(this.B);
            this.f448x = hVar2;
            hVar2.h();
        } else {
            this.f429e.setAlpha(1.0f);
            this.f429e.setTranslationY(0.0f);
            if (this.f443s && (view = this.f432h) != null) {
                view.setTranslationY(0.0f);
            }
            this.B.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f428d;
        if (actionBarOverlayLayout != null) {
            b0.i0(actionBarOverlayLayout);
        }
    }

    public i(Dialog dialog) {
        D(dialog.getWindow().getDecorView());
    }
}
