package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.j;
/* loaded from: classes.dex */
public class d2 implements e1 {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f864a;

    /* renamed from: b  reason: collision with root package name */
    private int f865b;

    /* renamed from: c  reason: collision with root package name */
    private View f866c;

    /* renamed from: d  reason: collision with root package name */
    private View f867d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f868e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f869f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f870g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f871h;

    /* renamed from: i  reason: collision with root package name */
    CharSequence f872i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f873j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f874k;

    /* renamed from: l  reason: collision with root package name */
    Window.Callback f875l;

    /* renamed from: m  reason: collision with root package name */
    boolean f876m;

    /* renamed from: n  reason: collision with root package name */
    private c f877n;

    /* renamed from: o  reason: collision with root package name */
    private int f878o;

    /* renamed from: p  reason: collision with root package name */
    private int f879p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f880q;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final i.a f881b;

        a() {
            this.f881b = new i.a(d2.this.f864a.getContext(), 0, 16908332, 0, 0, d2.this.f872i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d2 d2Var = d2.this;
            Window.Callback callback = d2Var.f875l;
            if (callback == null || !d2Var.f876m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f881b);
        }
    }

    /* loaded from: classes.dex */
    class b extends e0.t0 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f883a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f884b;

        b(int i6) {
            this.f884b = i6;
        }

        @Override // e0.t0, e0.s0
        public void a(View view) {
            this.f883a = true;
        }

        @Override // e0.s0
        public void b(View view) {
            if (this.f883a) {
                return;
            }
            d2.this.f864a.setVisibility(this.f884b);
        }

        @Override // e0.t0, e0.s0
        public void c(View view) {
            d2.this.f864a.setVisibility(0);
        }
    }

    public d2(Toolbar toolbar, boolean z5) {
        this(toolbar, z5, b.h.abc_action_bar_up_description, b.e.abc_ic_ab_back_material);
    }

    private void E(CharSequence charSequence) {
        this.f872i = charSequence;
        if ((this.f865b & 8) != 0) {
            this.f864a.setTitle(charSequence);
        }
    }

    private void F() {
        if ((this.f865b & 4) != 0) {
            if (TextUtils.isEmpty(this.f874k)) {
                this.f864a.setNavigationContentDescription(this.f879p);
            } else {
                this.f864a.setNavigationContentDescription(this.f874k);
            }
        }
    }

    private void G() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.f865b & 4) != 0) {
            toolbar = this.f864a;
            drawable = this.f870g;
            if (drawable == null) {
                drawable = this.f880q;
            }
        } else {
            toolbar = this.f864a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void H() {
        Drawable drawable;
        int i6 = this.f865b;
        if ((i6 & 2) == 0) {
            drawable = null;
        } else if ((i6 & 1) == 0 || (drawable = this.f869f) == null) {
            drawable = this.f868e;
        }
        this.f864a.setLogo(drawable);
    }

    private int v() {
        if (this.f864a.getNavigationIcon() != null) {
            this.f880q = this.f864a.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    public void A(CharSequence charSequence) {
        this.f874k = charSequence;
        F();
    }

    public void B(Drawable drawable) {
        this.f870g = drawable;
        G();
    }

    public void C(CharSequence charSequence) {
        this.f873j = charSequence;
        if ((this.f865b & 8) != 0) {
            this.f864a.setSubtitle(charSequence);
        }
    }

    public void D(CharSequence charSequence) {
        this.f871h = true;
        E(charSequence);
    }

    @Override // androidx.appcompat.widget.e1
    public void a(Menu menu, j.a aVar) {
        if (this.f877n == null) {
            c cVar = new c(this.f864a.getContext());
            this.f877n = cVar;
            cVar.p(b.f.action_menu_presenter);
        }
        this.f877n.k(aVar);
        this.f864a.I((androidx.appcompat.view.menu.e) menu, this.f877n);
    }

    @Override // androidx.appcompat.widget.e1
    public boolean b() {
        return this.f864a.A();
    }

    @Override // androidx.appcompat.widget.e1
    public void c() {
        this.f876m = true;
    }

    @Override // androidx.appcompat.widget.e1
    public void collapseActionView() {
        this.f864a.e();
    }

    @Override // androidx.appcompat.widget.e1
    public boolean d() {
        return this.f864a.z();
    }

    @Override // androidx.appcompat.widget.e1
    public boolean e() {
        return this.f864a.w();
    }

    @Override // androidx.appcompat.widget.e1
    public boolean f() {
        return this.f864a.N();
    }

    @Override // androidx.appcompat.widget.e1
    public boolean g() {
        return this.f864a.d();
    }

    @Override // androidx.appcompat.widget.e1
    public Context getContext() {
        return this.f864a.getContext();
    }

    @Override // androidx.appcompat.widget.e1
    public CharSequence getTitle() {
        return this.f864a.getTitle();
    }

    @Override // androidx.appcompat.widget.e1
    public void h() {
        this.f864a.f();
    }

    @Override // androidx.appcompat.widget.e1
    public void i(int i6) {
        this.f864a.setVisibility(i6);
    }

    @Override // androidx.appcompat.widget.e1
    public void j(w1 w1Var) {
        View view = this.f866c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f864a;
            if (parent == toolbar) {
                toolbar.removeView(this.f866c);
            }
        }
        this.f866c = w1Var;
    }

    @Override // androidx.appcompat.widget.e1
    public ViewGroup k() {
        return this.f864a;
    }

    @Override // androidx.appcompat.widget.e1
    public void l(boolean z5) {
    }

    @Override // androidx.appcompat.widget.e1
    public boolean m() {
        return this.f864a.v();
    }

    @Override // androidx.appcompat.widget.e1
    public void n(int i6) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i7 = this.f865b ^ i6;
        this.f865b = i6;
        if (i7 != 0) {
            if ((i7 & 4) != 0) {
                if ((i6 & 4) != 0) {
                    F();
                }
                G();
            }
            if ((i7 & 3) != 0) {
                H();
            }
            if ((i7 & 8) != 0) {
                if ((i6 & 8) != 0) {
                    this.f864a.setTitle(this.f872i);
                    toolbar = this.f864a;
                    charSequence = this.f873j;
                } else {
                    charSequence = null;
                    this.f864a.setTitle((CharSequence) null);
                    toolbar = this.f864a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i7 & 16) == 0 || (view = this.f867d) == null) {
                return;
            }
            if ((i6 & 16) != 0) {
                this.f864a.addView(view);
            } else {
                this.f864a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.e1
    public int o() {
        return this.f865b;
    }

    @Override // androidx.appcompat.widget.e1
    public void p(int i6) {
        y(i6 != 0 ? e.b.d(getContext(), i6) : null);
    }

    @Override // androidx.appcompat.widget.e1
    public int q() {
        return this.f878o;
    }

    @Override // androidx.appcompat.widget.e1
    public e0.r0 r(int i6, long j6) {
        return e0.b0.d(this.f864a).a(i6 == 0 ? 1.0f : 0.0f).d(j6).f(new b(i6));
    }

    @Override // androidx.appcompat.widget.e1
    public void s() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.e1
    public void setIcon(int i6) {
        setIcon(i6 != 0 ? e.b.d(getContext(), i6) : null);
    }

    @Override // androidx.appcompat.widget.e1
    public void setWindowCallback(Window.Callback callback) {
        this.f875l = callback;
    }

    @Override // androidx.appcompat.widget.e1
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f871h) {
            return;
        }
        E(charSequence);
    }

    @Override // androidx.appcompat.widget.e1
    public void t() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.e1
    public void u(boolean z5) {
        this.f864a.setCollapsible(z5);
    }

    public void w(View view) {
        View view2 = this.f867d;
        if (view2 != null && (this.f865b & 16) != 0) {
            this.f864a.removeView(view2);
        }
        this.f867d = view;
        if (view == null || (this.f865b & 16) == 0) {
            return;
        }
        this.f864a.addView(view);
    }

    public void x(int i6) {
        if (i6 == this.f879p) {
            return;
        }
        this.f879p = i6;
        if (TextUtils.isEmpty(this.f864a.getNavigationContentDescription())) {
            z(this.f879p);
        }
    }

    public void y(Drawable drawable) {
        this.f869f = drawable;
        H();
    }

    public void z(int i6) {
        A(i6 == 0 ? null : getContext().getString(i6));
    }

    public d2(Toolbar toolbar, boolean z5, int i6, int i7) {
        Drawable drawable;
        this.f878o = 0;
        this.f879p = 0;
        this.f864a = toolbar;
        this.f872i = toolbar.getTitle();
        this.f873j = toolbar.getSubtitle();
        this.f871h = this.f872i != null;
        this.f870g = toolbar.getNavigationIcon();
        c2 v5 = c2.v(toolbar.getContext(), null, b.j.f2712a, b.a.actionBarStyle, 0);
        this.f880q = v5.g(b.j.f2767l);
        if (z5) {
            CharSequence p5 = v5.p(b.j.f2797r);
            if (!TextUtils.isEmpty(p5)) {
                D(p5);
            }
            CharSequence p6 = v5.p(b.j.f2787p);
            if (!TextUtils.isEmpty(p6)) {
                C(p6);
            }
            Drawable g6 = v5.g(b.j.f2777n);
            if (g6 != null) {
                y(g6);
            }
            Drawable g7 = v5.g(b.j.f2772m);
            if (g7 != null) {
                setIcon(g7);
            }
            if (this.f870g == null && (drawable = this.f880q) != null) {
                B(drawable);
            }
            n(v5.k(b.j.f2747h, 0));
            int n5 = v5.n(b.j.f2742g, 0);
            if (n5 != 0) {
                w(LayoutInflater.from(this.f864a.getContext()).inflate(n5, (ViewGroup) this.f864a, false));
                n(this.f865b | 16);
            }
            int m5 = v5.m(b.j.f2757j, 0);
            if (m5 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f864a.getLayoutParams();
                layoutParams.height = m5;
                this.f864a.setLayoutParams(layoutParams);
            }
            int e6 = v5.e(b.j.f2737f, -1);
            int e7 = v5.e(b.j.f2732e, -1);
            if (e6 >= 0 || e7 >= 0) {
                this.f864a.H(Math.max(e6, 0), Math.max(e7, 0));
            }
            int n6 = v5.n(b.j.f2802s, 0);
            if (n6 != 0) {
                Toolbar toolbar2 = this.f864a;
                toolbar2.K(toolbar2.getContext(), n6);
            }
            int n7 = v5.n(b.j.f2792q, 0);
            if (n7 != 0) {
                Toolbar toolbar3 = this.f864a;
                toolbar3.J(toolbar3.getContext(), n7);
            }
            int n8 = v5.n(b.j.f2782o, 0);
            if (n8 != 0) {
                this.f864a.setPopupTheme(n8);
            }
        } else {
            this.f865b = v();
        }
        v5.w();
        x(i6);
        this.f874k = this.f864a.getNavigationContentDescription();
        this.f864a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.e1
    public void setIcon(Drawable drawable) {
        this.f868e = drawable;
        H();
    }
}
