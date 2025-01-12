package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import e0.b;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends androidx.appcompat.view.menu.a implements b.a {
    a A;
    RunnableC0012c B;
    private b C;
    final f D;
    int E;

    /* renamed from: l  reason: collision with root package name */
    d f833l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f834m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f835n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f836o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f837p;

    /* renamed from: q  reason: collision with root package name */
    private int f838q;

    /* renamed from: r  reason: collision with root package name */
    private int f839r;

    /* renamed from: s  reason: collision with root package name */
    private int f840s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f841t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f842u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f843v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f844w;

    /* renamed from: x  reason: collision with root package name */
    private int f845x;

    /* renamed from: y  reason: collision with root package name */
    private final SparseBooleanArray f846y;

    /* renamed from: z  reason: collision with root package name */
    e f847z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.menu.i {
        public a(Context context, androidx.appcompat.view.menu.m mVar, View view) {
            super(context, mVar, view, false, b.a.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.g) mVar.getItem()).l()) {
                View view2 = c.this.f833l;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.a) c.this).f499j : view2);
            }
            j(c.this.D);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            c cVar = c.this;
            cVar.A = null;
            cVar.E = 0;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public i.e a() {
            a aVar = c.this.A;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0012c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private e f850a;

        public RunnableC0012c(e eVar) {
            this.f850a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.a) c.this).f493d != null) {
                ((androidx.appcompat.view.menu.a) c.this).f493d.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.a) c.this).f499j;
            if (view != null && view.getWindowToken() != null && this.f850a.m()) {
                c.this.f847z = this.f850a;
            }
            c.this.B = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends o implements ActionMenuView.a {

        /* loaded from: classes.dex */
        class a extends i1 {

            /* renamed from: k  reason: collision with root package name */
            final /* synthetic */ c f853k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, c cVar) {
                super(view);
                this.f853k = cVar;
            }

            @Override // androidx.appcompat.widget.i1
            public i.e b() {
                e eVar = c.this.f847z;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.i1
            public boolean c() {
                c.this.K();
                return true;
            }

            @Override // androidx.appcompat.widget.i1
            public boolean d() {
                c cVar = c.this;
                if (cVar.B != null) {
                    return false;
                }
                cVar.B();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, b.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            f2.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.K();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i6, int i7, int i8, int i9) {
            boolean frame = super.setFrame(i6, i7, i8, i9);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                x.b.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends androidx.appcompat.view.menu.i {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z5) {
            super(context, eVar, view, z5, b.a.actionOverflowMenuStyle);
            h(8388613);
            j(c.this.D);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            if (((androidx.appcompat.view.menu.a) c.this).f493d != null) {
                ((androidx.appcompat.view.menu.a) c.this).f493d.close();
            }
            c.this.f847z = null;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class f implements j.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void b(androidx.appcompat.view.menu.e eVar, boolean z5) {
            if (eVar instanceof androidx.appcompat.view.menu.m) {
                eVar.D().e(false);
            }
            j.a m5 = c.this.m();
            if (m5 != null) {
                m5.b(eVar, z5);
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean c(androidx.appcompat.view.menu.e eVar) {
            if (eVar == ((androidx.appcompat.view.menu.a) c.this).f493d) {
                return false;
            }
            c.this.E = ((androidx.appcompat.view.menu.m) eVar).getItem().getItemId();
            j.a m5 = c.this.m();
            if (m5 != null) {
                return m5.c(eVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, b.g.abc_action_menu_layout, b.g.abc_action_menu_item_layout);
        this.f846y = new SparseBooleanArray();
        this.D = new f();
    }

    private View z(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f499j;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if ((childAt instanceof k.a) && ((k.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable A() {
        d dVar = this.f833l;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f835n) {
            return this.f834m;
        }
        return null;
    }

    public boolean B() {
        androidx.appcompat.view.menu.k kVar;
        RunnableC0012c runnableC0012c = this.B;
        if (runnableC0012c != null && (kVar = this.f499j) != null) {
            ((View) kVar).removeCallbacks(runnableC0012c);
            this.B = null;
            return true;
        }
        e eVar = this.f847z;
        if (eVar != null) {
            eVar.b();
            return true;
        }
        return false;
    }

    public boolean C() {
        a aVar = this.A;
        if (aVar != null) {
            aVar.b();
            return true;
        }
        return false;
    }

    public boolean D() {
        return this.B != null || E();
    }

    public boolean E() {
        e eVar = this.f847z;
        return eVar != null && eVar.d();
    }

    public void F(Configuration configuration) {
        if (!this.f841t) {
            this.f840s = h.a.b(this.f492c).d();
        }
        androidx.appcompat.view.menu.e eVar = this.f493d;
        if (eVar != null) {
            eVar.K(true);
        }
    }

    public void G(boolean z5) {
        this.f844w = z5;
    }

    public void H(ActionMenuView actionMenuView) {
        this.f499j = actionMenuView;
        actionMenuView.b(this.f493d);
    }

    public void I(Drawable drawable) {
        d dVar = this.f833l;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.f835n = true;
        this.f834m = drawable;
    }

    public void J(boolean z5) {
        this.f836o = z5;
        this.f837p = true;
    }

    public boolean K() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.f836o || E() || (eVar = this.f493d) == null || this.f499j == null || this.B != null || eVar.z().isEmpty()) {
            return false;
        }
        RunnableC0012c runnableC0012c = new RunnableC0012c(new e(this.f492c, this.f493d, this.f833l, true));
        this.B = runnableC0012c;
        ((View) this.f499j).post(runnableC0012c);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void b(androidx.appcompat.view.menu.e eVar, boolean z5) {
        y();
        super.b(eVar, z5);
    }

    @Override // androidx.appcompat.view.menu.a
    public void c(androidx.appcompat.view.menu.g gVar, k.a aVar) {
        aVar.e(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f499j);
        if (this.C == null) {
            this.C = new b();
        }
        actionMenuItemView.setPopupCallback(this.C);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void d(Context context, androidx.appcompat.view.menu.e eVar) {
        super.d(context, eVar);
        Resources resources = context.getResources();
        h.a b6 = h.a.b(context);
        if (!this.f837p) {
            this.f836o = b6.f();
        }
        if (!this.f843v) {
            this.f838q = b6.c();
        }
        if (!this.f841t) {
            this.f840s = b6.d();
        }
        int i6 = this.f838q;
        if (this.f836o) {
            if (this.f833l == null) {
                d dVar = new d(this.f491b);
                this.f833l = dVar;
                if (this.f835n) {
                    dVar.setImageDrawable(this.f834m);
                    this.f834m = null;
                    this.f835n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f833l.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i6 -= this.f833l.getMeasuredWidth();
        } else {
            this.f833l = null;
        }
        this.f839r = i6;
        this.f845x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public boolean e(androidx.appcompat.view.menu.m mVar) {
        boolean z5 = false;
        if (mVar.hasVisibleItems()) {
            androidx.appcompat.view.menu.m mVar2 = mVar;
            while (mVar2.e0() != this.f493d) {
                mVar2 = (androidx.appcompat.view.menu.m) mVar2.e0();
            }
            View z6 = z(mVar2.getItem());
            if (z6 == null) {
                return false;
            }
            this.E = mVar.getItem().getItemId();
            int size = mVar.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    break;
                }
                MenuItem item = mVar.getItem(i6);
                if (item.isVisible() && item.getIcon() != null) {
                    z5 = true;
                    break;
                }
                i6++;
            }
            a aVar = new a(this.f492c, mVar, z6);
            this.A = aVar;
            aVar.g(z5);
            this.A.k();
            super.e(mVar);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void f(boolean z5) {
        super.f(z5);
        ((View) this.f499j).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.f493d;
        boolean z6 = false;
        if (eVar != null) {
            ArrayList s5 = eVar.s();
            int size = s5.size();
            for (int i6 = 0; i6 < size; i6++) {
                e0.b b6 = ((androidx.appcompat.view.menu.g) s5.get(i6)).b();
                if (b6 != null) {
                    b6.h(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.f493d;
        ArrayList z7 = eVar2 != null ? eVar2.z() : null;
        if (this.f836o && z7 != null) {
            int size2 = z7.size();
            if (size2 == 1) {
                z6 = !((androidx.appcompat.view.menu.g) z7.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z6 = true;
            }
        }
        d dVar = this.f833l;
        if (z6) {
            if (dVar == null) {
                this.f833l = new d(this.f491b);
            }
            ViewGroup viewGroup = (ViewGroup) this.f833l.getParent();
            if (viewGroup != this.f499j) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f833l);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f499j;
                actionMenuView.addView(this.f833l, actionMenuView.F());
            }
        } else if (dVar != null) {
            ViewParent parent = dVar.getParent();
            androidx.appcompat.view.menu.k kVar = this.f499j;
            if (parent == kVar) {
                ((ViewGroup) kVar).removeView(this.f833l);
            }
        }
        ((ActionMenuView) this.f499j).setOverflowReserved(this.f836o);
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean h() {
        ArrayList arrayList;
        int i6;
        int i7;
        int i8;
        int i9;
        c cVar = this;
        androidx.appcompat.view.menu.e eVar = cVar.f493d;
        View view = null;
        int i10 = 0;
        if (eVar != null) {
            arrayList = eVar.E();
            i6 = arrayList.size();
        } else {
            arrayList = null;
            i6 = 0;
        }
        int i11 = cVar.f840s;
        int i12 = cVar.f839r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f499j;
        boolean z5 = false;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < i6; i15++) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) arrayList.get(i15);
            if (gVar.o()) {
                i13++;
            } else if (gVar.n()) {
                i14++;
            } else {
                z5 = true;
            }
            if (cVar.f844w && gVar.isActionViewExpanded()) {
                i11 = 0;
            }
        }
        if (cVar.f836o && (z5 || i14 + i13 > i11)) {
            i11--;
        }
        int i16 = i11 - i13;
        SparseBooleanArray sparseBooleanArray = cVar.f846y;
        sparseBooleanArray.clear();
        if (cVar.f842u) {
            int i17 = cVar.f845x;
            i8 = i12 / i17;
            i7 = i17 + ((i12 % i17) / i8);
        } else {
            i7 = 0;
            i8 = 0;
        }
        int i18 = 0;
        int i19 = 0;
        while (i18 < i6) {
            androidx.appcompat.view.menu.g gVar2 = (androidx.appcompat.view.menu.g) arrayList.get(i18);
            if (gVar2.o()) {
                View n5 = cVar.n(gVar2, view, viewGroup);
                if (cVar.f842u) {
                    i8 -= ActionMenuView.L(n5, i7, i8, makeMeasureSpec, i10);
                } else {
                    n5.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = n5.getMeasuredWidth();
                i12 -= measuredWidth;
                if (i19 == 0) {
                    i19 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                gVar2.u(true);
                i9 = i6;
            } else if (gVar2.n()) {
                int groupId2 = gVar2.getGroupId();
                boolean z6 = sparseBooleanArray.get(groupId2);
                boolean z7 = (i16 > 0 || z6) && i12 > 0 && (!cVar.f842u || i8 > 0);
                boolean z8 = z7;
                i9 = i6;
                if (z7) {
                    View n6 = cVar.n(gVar2, null, viewGroup);
                    if (cVar.f842u) {
                        int L = ActionMenuView.L(n6, i7, i8, makeMeasureSpec, 0);
                        i8 -= L;
                        if (L == 0) {
                            z8 = false;
                        }
                    } else {
                        n6.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z9 = z8;
                    int measuredWidth2 = n6.getMeasuredWidth();
                    i12 -= measuredWidth2;
                    if (i19 == 0) {
                        i19 = measuredWidth2;
                    }
                    z7 = z9 & (!cVar.f842u ? i12 + i19 <= 0 : i12 < 0);
                }
                if (z7 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z6) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i20 = 0; i20 < i18; i20++) {
                        androidx.appcompat.view.menu.g gVar3 = (androidx.appcompat.view.menu.g) arrayList.get(i20);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.l()) {
                                i16++;
                            }
                            gVar3.u(false);
                        }
                    }
                }
                if (z7) {
                    i16--;
                }
                gVar2.u(z7);
            } else {
                i9 = i6;
                gVar2.u(false);
                i18++;
                view = null;
                cVar = this;
                i6 = i9;
                i10 = 0;
            }
            i18++;
            view = null;
            cVar = this;
            i6 = i9;
            i10 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean l(ViewGroup viewGroup, int i6) {
        if (viewGroup.getChildAt(i6) == this.f833l) {
            return false;
        }
        return super.l(viewGroup, i6);
    }

    @Override // androidx.appcompat.view.menu.a
    public View n(androidx.appcompat.view.menu.g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.n(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.o(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.a
    public androidx.appcompat.view.menu.k o(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.k kVar = this.f499j;
        androidx.appcompat.view.menu.k o5 = super.o(viewGroup);
        if (kVar != o5) {
            ((ActionMenuView) o5).setPresenter(this);
        }
        return o5;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean q(int i6, androidx.appcompat.view.menu.g gVar) {
        return gVar.l();
    }

    public boolean y() {
        return B() | C();
    }
}
