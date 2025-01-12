package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.s1;
import e0.b0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends h implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: w  reason: collision with root package name */
    private static final int f623w = b.g.abc_popup_menu_item_layout;

    /* renamed from: c  reason: collision with root package name */
    private final Context f624c;

    /* renamed from: d  reason: collision with root package name */
    private final e f625d;

    /* renamed from: e  reason: collision with root package name */
    private final d f626e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f627f;

    /* renamed from: g  reason: collision with root package name */
    private final int f628g;

    /* renamed from: h  reason: collision with root package name */
    private final int f629h;

    /* renamed from: i  reason: collision with root package name */
    private final int f630i;

    /* renamed from: j  reason: collision with root package name */
    final s1 f631j;

    /* renamed from: m  reason: collision with root package name */
    private PopupWindow.OnDismissListener f634m;

    /* renamed from: n  reason: collision with root package name */
    private View f635n;

    /* renamed from: o  reason: collision with root package name */
    View f636o;

    /* renamed from: p  reason: collision with root package name */
    private j.a f637p;

    /* renamed from: q  reason: collision with root package name */
    ViewTreeObserver f638q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f639r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f640s;

    /* renamed from: t  reason: collision with root package name */
    private int f641t;

    /* renamed from: v  reason: collision with root package name */
    private boolean f643v;

    /* renamed from: k  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f632k = new a();

    /* renamed from: l  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f633l = new b();

    /* renamed from: u  reason: collision with root package name */
    private int f642u = 0;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!l.this.c() || l.this.f631j.B()) {
                return;
            }
            View view = l.this.f636o;
            if (view == null || !view.isShown()) {
                l.this.dismiss();
            } else {
                l.this.f631j.a();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = l.this.f638q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    l.this.f638q = view.getViewTreeObserver();
                }
                l lVar = l.this;
                lVar.f638q.removeGlobalOnLayoutListener(lVar.f632k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public l(Context context, e eVar, View view, int i6, int i7, boolean z5) {
        this.f624c = context;
        this.f625d = eVar;
        this.f627f = z5;
        this.f626e = new d(eVar, LayoutInflater.from(context), z5, f623w);
        this.f629h = i6;
        this.f630i = i7;
        Resources resources = context.getResources();
        this.f628g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(b.d.abc_config_prefDialogWidth));
        this.f635n = view;
        this.f631j = new s1(context, null, i6, i7);
        eVar.c(this, context);
    }

    private boolean z() {
        View view;
        if (c()) {
            return true;
        }
        if (this.f639r || (view = this.f635n) == null) {
            return false;
        }
        this.f636o = view;
        this.f631j.K(this);
        this.f631j.L(this);
        this.f631j.J(true);
        View view2 = this.f636o;
        boolean z5 = this.f638q == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f638q = viewTreeObserver;
        if (z5) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f632k);
        }
        view2.addOnAttachStateChangeListener(this.f633l);
        this.f631j.D(view2);
        this.f631j.G(this.f642u);
        if (!this.f640s) {
            this.f641t = h.o(this.f626e, null, this.f624c, this.f628g);
            this.f640s = true;
        }
        this.f631j.F(this.f641t);
        this.f631j.I(2);
        this.f631j.H(n());
        this.f631j.a();
        ListView g6 = this.f631j.g();
        g6.setOnKeyListener(this);
        if (this.f643v && this.f625d.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f624c).inflate(b.g.abc_popup_menu_header_item_layout, (ViewGroup) g6, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f625d.x());
            }
            frameLayout.setEnabled(false);
            g6.addHeaderView(frameLayout, null, false);
        }
        this.f631j.p(this.f626e);
        this.f631j.a();
        return true;
    }

    @Override // i.e
    public void a() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(e eVar, boolean z5) {
        if (eVar != this.f625d) {
            return;
        }
        dismiss();
        j.a aVar = this.f637p;
        if (aVar != null) {
            aVar.b(eVar, z5);
        }
    }

    @Override // i.e
    public boolean c() {
        return !this.f639r && this.f631j.c();
    }

    @Override // i.e
    public void dismiss() {
        if (c()) {
            this.f631j.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e(m mVar) {
        if (mVar.hasVisibleItems()) {
            i iVar = new i(this.f624c, mVar, this.f636o, this.f627f, this.f629h, this.f630i);
            iVar.j(this.f637p);
            iVar.g(h.x(mVar));
            iVar.i(this.f634m);
            this.f634m = null;
            this.f625d.e(false);
            int d6 = this.f631j.d();
            int n5 = this.f631j.n();
            if ((Gravity.getAbsoluteGravity(this.f642u, b0.B(this.f635n)) & 7) == 5) {
                d6 += this.f635n.getWidth();
            }
            if (iVar.n(d6, n5)) {
                j.a aVar = this.f637p;
                if (aVar != null) {
                    aVar.c(mVar);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void f(boolean z5) {
        this.f640s = false;
        d dVar = this.f626e;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    @Override // i.e
    public ListView g() {
        return this.f631j.g();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean h() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void k(j.a aVar) {
        this.f637p = aVar;
    }

    @Override // androidx.appcompat.view.menu.h
    public void l(e eVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f639r = true;
        this.f625d.close();
        ViewTreeObserver viewTreeObserver = this.f638q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f638q = this.f636o.getViewTreeObserver();
            }
            this.f638q.removeGlobalOnLayoutListener(this.f632k);
            this.f638q = null;
        }
        this.f636o.removeOnAttachStateChangeListener(this.f633l);
        PopupWindow.OnDismissListener onDismissListener = this.f634m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i6, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i6 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.h
    public void p(View view) {
        this.f635n = view;
    }

    @Override // androidx.appcompat.view.menu.h
    public void r(boolean z5) {
        this.f626e.d(z5);
    }

    @Override // androidx.appcompat.view.menu.h
    public void s(int i6) {
        this.f642u = i6;
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(int i6) {
        this.f631j.l(i6);
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f634m = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(boolean z5) {
        this.f643v = z5;
    }

    @Override // androidx.appcompat.view.menu.h
    public void w(int i6) {
        this.f631j.j(i6);
    }
}
