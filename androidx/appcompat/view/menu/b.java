package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.o1;
import androidx.appcompat.widget.s1;
import e0.b0;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends h implements View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int C = b.g.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;
    boolean B;

    /* renamed from: c  reason: collision with root package name */
    private final Context f501c;

    /* renamed from: d  reason: collision with root package name */
    private final int f502d;

    /* renamed from: e  reason: collision with root package name */
    private final int f503e;

    /* renamed from: f  reason: collision with root package name */
    private final int f504f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f505g;

    /* renamed from: h  reason: collision with root package name */
    final Handler f506h;

    /* renamed from: p  reason: collision with root package name */
    private View f514p;

    /* renamed from: q  reason: collision with root package name */
    View f515q;

    /* renamed from: s  reason: collision with root package name */
    private boolean f517s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f518t;

    /* renamed from: u  reason: collision with root package name */
    private int f519u;

    /* renamed from: v  reason: collision with root package name */
    private int f520v;

    /* renamed from: x  reason: collision with root package name */
    private boolean f522x;

    /* renamed from: y  reason: collision with root package name */
    private j.a f523y;

    /* renamed from: z  reason: collision with root package name */
    ViewTreeObserver f524z;

    /* renamed from: i  reason: collision with root package name */
    private final List f507i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    final List f508j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f509k = new a();

    /* renamed from: l  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f510l = new View$OnAttachStateChangeListenerC0010b();

    /* renamed from: m  reason: collision with root package name */
    private final o1 f511m = new c();

    /* renamed from: n  reason: collision with root package name */
    private int f512n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f513o = 0;

    /* renamed from: w  reason: collision with root package name */
    private boolean f521w = false;

    /* renamed from: r  reason: collision with root package name */
    private int f516r = D();

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!b.this.c() || b.this.f508j.size() <= 0 || ((d) b.this.f508j.get(0)).f532a.B()) {
                return;
            }
            View view = b.this.f515q;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            for (d dVar : b.this.f508j) {
                dVar.f532a.a();
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnAttachStateChangeListenerC0010b implements View.OnAttachStateChangeListener {
        View$OnAttachStateChangeListenerC0010b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f524z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f524z = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f524z.removeGlobalOnLayoutListener(bVar.f509k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* loaded from: classes.dex */
    class c implements o1 {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f528a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MenuItem f529b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ e f530c;

            a(d dVar, MenuItem menuItem, e eVar) {
                this.f528a = dVar;
                this.f529b = menuItem;
                this.f530c = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f528a;
                if (dVar != null) {
                    b.this.B = true;
                    dVar.f533b.e(false);
                    b.this.B = false;
                }
                if (this.f529b.isEnabled() && this.f529b.hasSubMenu()) {
                    this.f530c.L(this.f529b, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.o1
        public void b(e eVar, MenuItem menuItem) {
            b.this.f506h.removeCallbacksAndMessages(null);
            int size = b.this.f508j.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    i6 = -1;
                    break;
                } else if (eVar == ((d) b.this.f508j.get(i6)).f533b) {
                    break;
                } else {
                    i6++;
                }
            }
            if (i6 == -1) {
                return;
            }
            int i7 = i6 + 1;
            b.this.f506h.postAtTime(new a(i7 < b.this.f508j.size() ? (d) b.this.f508j.get(i7) : null, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.o1
        public void e(e eVar, MenuItem menuItem) {
            b.this.f506h.removeCallbacksAndMessages(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final s1 f532a;

        /* renamed from: b  reason: collision with root package name */
        public final e f533b;

        /* renamed from: c  reason: collision with root package name */
        public final int f534c;

        public d(s1 s1Var, e eVar, int i6) {
            this.f532a = s1Var;
            this.f533b = eVar;
            this.f534c = i6;
        }

        public ListView a() {
            return this.f532a.g();
        }
    }

    public b(Context context, View view, int i6, int i7, boolean z5) {
        this.f501c = context;
        this.f514p = view;
        this.f503e = i6;
        this.f504f = i7;
        this.f505g = z5;
        Resources resources = context.getResources();
        this.f502d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(b.d.abc_config_prefDialogWidth));
        this.f506h = new Handler();
    }

    private int A(e eVar) {
        int size = this.f508j.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (eVar == ((d) this.f508j.get(i6)).f533b) {
                return i6;
            }
        }
        return -1;
    }

    private MenuItem B(e eVar, e eVar2) {
        int size = eVar.size();
        for (int i6 = 0; i6 < size; i6++) {
            MenuItem item = eVar.getItem(i6);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(d dVar, e eVar) {
        androidx.appcompat.view.menu.d dVar2;
        int i6;
        int firstVisiblePosition;
        MenuItem B = B(dVar.f533b, eVar);
        if (B == null) {
            return null;
        }
        ListView a6 = dVar.a();
        ListAdapter adapter = a6.getAdapter();
        int i7 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i6 = headerViewListAdapter.getHeadersCount();
            dVar2 = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
        } else {
            dVar2 = (androidx.appcompat.view.menu.d) adapter;
            i6 = 0;
        }
        int count = dVar2.getCount();
        while (true) {
            if (i7 >= count) {
                i7 = -1;
                break;
            } else if (B == dVar2.getItem(i7)) {
                break;
            } else {
                i7++;
            }
        }
        if (i7 != -1 && (firstVisiblePosition = (i7 + i6) - a6.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a6.getChildCount()) {
            return a6.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return b0.B(this.f514p) == 1 ? 0 : 1;
    }

    private int E(int i6) {
        List list = this.f508j;
        ListView a6 = ((d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        a6.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f515q.getWindowVisibleDisplayFrame(rect);
        return this.f516r == 1 ? (iArr[0] + a6.getWidth()) + i6 > rect.right ? 0 : 1 : iArr[0] - i6 < 0 ? 1 : 0;
    }

    private void F(e eVar) {
        d dVar;
        View view;
        int i6;
        int i7;
        int i8;
        LayoutInflater from = LayoutInflater.from(this.f501c);
        androidx.appcompat.view.menu.d dVar2 = new androidx.appcompat.view.menu.d(eVar, from, this.f505g, C);
        if (!c() && this.f521w) {
            dVar2.d(true);
        } else if (c()) {
            dVar2.d(h.x(eVar));
        }
        int o5 = h.o(dVar2, null, this.f501c, this.f502d);
        s1 z5 = z();
        z5.p(dVar2);
        z5.F(o5);
        z5.G(this.f513o);
        if (this.f508j.size() > 0) {
            List list = this.f508j;
            dVar = (d) list.get(list.size() - 1);
            view = C(dVar, eVar);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            z5.U(false);
            z5.R(null);
            int E = E(o5);
            boolean z6 = E == 1;
            this.f516r = E;
            if (Build.VERSION.SDK_INT >= 26) {
                z5.D(view);
                i7 = 0;
                i6 = 0;
            } else {
                int[] iArr = new int[2];
                this.f514p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f513o & 7) == 5) {
                    iArr[0] = iArr[0] + this.f514p.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i6 = iArr2[0] - iArr[0];
                i7 = iArr2[1] - iArr[1];
            }
            if ((this.f513o & 5) == 5) {
                if (!z6) {
                    o5 = view.getWidth();
                    i8 = i6 - o5;
                }
                i8 = i6 + o5;
            } else {
                if (z6) {
                    o5 = view.getWidth();
                    i8 = i6 + o5;
                }
                i8 = i6 - o5;
            }
            z5.l(i8);
            z5.M(true);
            z5.j(i7);
        } else {
            if (this.f517s) {
                z5.l(this.f519u);
            }
            if (this.f518t) {
                z5.j(this.f520v);
            }
            z5.H(n());
        }
        this.f508j.add(new d(z5, eVar, this.f516r));
        z5.a();
        ListView g6 = z5.g();
        g6.setOnKeyListener(this);
        if (dVar == null && this.f522x && eVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(b.g.abc_popup_menu_header_item_layout, (ViewGroup) g6, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(eVar.x());
            g6.addHeaderView(frameLayout, null, false);
            z5.a();
        }
    }

    private s1 z() {
        s1 s1Var = new s1(this.f501c, null, this.f503e, this.f504f);
        s1Var.T(this.f511m);
        s1Var.L(this);
        s1Var.K(this);
        s1Var.D(this.f514p);
        s1Var.G(this.f513o);
        s1Var.J(true);
        s1Var.I(2);
        return s1Var;
    }

    @Override // i.e
    public void a() {
        if (c()) {
            return;
        }
        for (e eVar : this.f507i) {
            F(eVar);
        }
        this.f507i.clear();
        View view = this.f514p;
        this.f515q = view;
        if (view != null) {
            boolean z5 = this.f524z == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f524z = viewTreeObserver;
            if (z5) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f509k);
            }
            this.f515q.addOnAttachStateChangeListener(this.f510l);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(e eVar, boolean z5) {
        int A = A(eVar);
        if (A < 0) {
            return;
        }
        int i6 = A + 1;
        if (i6 < this.f508j.size()) {
            ((d) this.f508j.get(i6)).f533b.e(false);
        }
        d dVar = (d) this.f508j.remove(A);
        dVar.f533b.O(this);
        if (this.B) {
            dVar.f532a.S(null);
            dVar.f532a.E(0);
        }
        dVar.f532a.dismiss();
        int size = this.f508j.size();
        this.f516r = size > 0 ? ((d) this.f508j.get(size - 1)).f534c : D();
        if (size != 0) {
            if (z5) {
                ((d) this.f508j.get(0)).f533b.e(false);
                return;
            }
            return;
        }
        dismiss();
        j.a aVar = this.f523y;
        if (aVar != null) {
            aVar.b(eVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f524z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f524z.removeGlobalOnLayoutListener(this.f509k);
            }
            this.f524z = null;
        }
        this.f515q.removeOnAttachStateChangeListener(this.f510l);
        this.A.onDismiss();
    }

    @Override // i.e
    public boolean c() {
        return this.f508j.size() > 0 && ((d) this.f508j.get(0)).f532a.c();
    }

    @Override // i.e
    public void dismiss() {
        int size = this.f508j.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f508j.toArray(new d[size]);
            for (int i6 = size - 1; i6 >= 0; i6--) {
                d dVar = dVarArr[i6];
                if (dVar.f532a.c()) {
                    dVar.f532a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e(m mVar) {
        for (d dVar : this.f508j) {
            if (mVar == dVar.f533b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (mVar.hasVisibleItems()) {
            l(mVar);
            j.a aVar = this.f523y;
            if (aVar != null) {
                aVar.c(mVar);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void f(boolean z5) {
        for (d dVar : this.f508j) {
            h.y(dVar.a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // i.e
    public ListView g() {
        if (this.f508j.isEmpty()) {
            return null;
        }
        List list = this.f508j;
        return ((d) list.get(list.size() - 1)).a();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean h() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void k(j.a aVar) {
        this.f523y = aVar;
    }

    @Override // androidx.appcompat.view.menu.h
    public void l(e eVar) {
        eVar.c(this, this.f501c);
        if (c()) {
            F(eVar);
        } else {
            this.f507i.add(eVar);
        }
    }

    @Override // androidx.appcompat.view.menu.h
    protected boolean m() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f508j.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) this.f508j.get(i6);
            if (!dVar.f532a.c()) {
                break;
            }
            i6++;
        }
        if (dVar != null) {
            dVar.f533b.e(false);
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
        if (this.f514p != view) {
            this.f514p = view;
            this.f513o = e0.d.b(this.f512n, b0.B(view));
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void r(boolean z5) {
        this.f521w = z5;
    }

    @Override // androidx.appcompat.view.menu.h
    public void s(int i6) {
        if (this.f512n != i6) {
            this.f512n = i6;
            this.f513o = e0.d.b(i6, b0.B(this.f514p));
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(int i6) {
        this.f517s = true;
        this.f519u = i6;
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(boolean z5) {
        this.f522x = z5;
    }

    @Override // androidx.appcompat.view.menu.h
    public void w(int i6) {
        this.f518t = true;
        this.f520v = i6;
    }
}
