package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private ColorStateList A;
    private ColorStateList B;
    private boolean C;
    private boolean D;
    private final ArrayList E;
    private final ArrayList F;
    private final int[] G;
    private final ActionMenuView.e H;
    private d2 I;
    private androidx.appcompat.widget.c J;
    private d K;
    private j.a L;
    private e.a M;
    private boolean N;
    private final Runnable O;

    /* renamed from: b  reason: collision with root package name */
    private ActionMenuView f778b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f779c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f780d;

    /* renamed from: e  reason: collision with root package name */
    private ImageButton f781e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f782f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f783g;

    /* renamed from: h  reason: collision with root package name */
    private CharSequence f784h;

    /* renamed from: i  reason: collision with root package name */
    ImageButton f785i;

    /* renamed from: j  reason: collision with root package name */
    View f786j;

    /* renamed from: k  reason: collision with root package name */
    private Context f787k;

    /* renamed from: l  reason: collision with root package name */
    private int f788l;

    /* renamed from: m  reason: collision with root package name */
    private int f789m;

    /* renamed from: n  reason: collision with root package name */
    private int f790n;

    /* renamed from: o  reason: collision with root package name */
    int f791o;

    /* renamed from: p  reason: collision with root package name */
    private int f792p;

    /* renamed from: q  reason: collision with root package name */
    private int f793q;

    /* renamed from: r  reason: collision with root package name */
    private int f794r;

    /* renamed from: s  reason: collision with root package name */
    private int f795s;

    /* renamed from: t  reason: collision with root package name */
    private int f796t;

    /* renamed from: u  reason: collision with root package name */
    private v1 f797u;

    /* renamed from: v  reason: collision with root package name */
    private int f798v;

    /* renamed from: w  reason: collision with root package name */
    private int f799w;

    /* renamed from: x  reason: collision with root package name */
    private int f800x;

    /* renamed from: y  reason: collision with root package name */
    private CharSequence f801y;

    /* renamed from: z  reason: collision with root package name */
    private CharSequence f802z;

    /* loaded from: classes.dex */
    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            Toolbar.this.getClass();
            return false;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements androidx.appcompat.view.menu.j {

        /* renamed from: b  reason: collision with root package name */
        androidx.appcompat.view.menu.e f806b;

        /* renamed from: c  reason: collision with root package name */
        androidx.appcompat.view.menu.g f807c;

        d() {
        }

        @Override // androidx.appcompat.view.menu.j
        public void b(androidx.appcompat.view.menu.e eVar, boolean z5) {
        }

        @Override // androidx.appcompat.view.menu.j
        public void d(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.f806b;
            if (eVar2 != null && (gVar = this.f807c) != null) {
                eVar2.f(gVar);
            }
            this.f806b = eVar;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean e(androidx.appcompat.view.menu.m mVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public void f(boolean z5) {
            if (this.f807c != null) {
                androidx.appcompat.view.menu.e eVar = this.f806b;
                boolean z6 = false;
                if (eVar != null) {
                    int size = eVar.size();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= size) {
                            break;
                        } else if (this.f806b.getItem(i6) == this.f807c) {
                            z6 = true;
                            break;
                        } else {
                            i6++;
                        }
                    }
                }
                if (z6) {
                    return;
                }
                i(this.f806b, this.f807c);
            }
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean h() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean i(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            View view = Toolbar.this.f786j;
            if (view instanceof h.c) {
                ((h.c) view).f();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f786j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f785i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f786j = null;
            toolbar3.a();
            this.f807c = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean j(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f785i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f785i);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f785i);
            }
            Toolbar.this.f786j = gVar.getActionView();
            this.f807c = gVar;
            ViewParent parent2 = Toolbar.this.f786j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f786j);
                }
                e generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.f320a = (toolbar4.f791o & 112) | 8388611;
                generateDefaultLayoutParams.f809b = 2;
                toolbar4.f786j.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f786j);
            }
            Toolbar.this.G();
            Toolbar.this.requestLayout();
            gVar.r(true);
            View view = Toolbar.this.f786j;
            if (view instanceof h.c) {
                ((h.c) view).c();
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends a.C0008a {

        /* renamed from: b  reason: collision with root package name */
        int f809b;

        public e(int i6, int i7) {
            super(i6, i7);
            this.f809b = 0;
            this.f320a = 8388627;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f809b = 0;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f809b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f809b = 0;
            a(marginLayoutParams);
        }

        public e(a.C0008a c0008a) {
            super(c0008a);
            this.f809b = 0;
        }

        public e(e eVar) {
            super((a.C0008a) eVar);
            this.f809b = 0;
            this.f809b = eVar.f809b;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    /* loaded from: classes.dex */
    public static class g extends h0.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f810c;

        /* renamed from: d  reason: collision with root package name */
        boolean f811d;

        /* loaded from: classes.dex */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public g[] newArray(int i6) {
                return new g[i6];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f810c = parcel.readInt();
            this.f811d = parcel.readInt() != 0;
        }

        @Override // h0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f810c);
            parcel.writeInt(this.f811d ? 1 : 0);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.J);
    }

    private int B(View view, int i6, int[] iArr, int i7) {
        e eVar = (e) view.getLayoutParams();
        int i8 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int max = i6 + Math.max(0, i8);
        iArr[0] = Math.max(0, -i8);
        int q5 = q(view, i7);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, q5, max + measuredWidth, view.getMeasuredHeight() + q5);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
    }

    private int C(View view, int i6, int[] iArr, int i7) {
        e eVar = (e) view.getLayoutParams();
        int i8 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int max = i6 - Math.max(0, i8);
        iArr[1] = Math.max(0, -i8);
        int q5 = q(view, i7);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, q5, max, view.getMeasuredHeight() + q5);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    private int D(View view, int i6, int i7, int i8, int i9, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i10 = marginLayoutParams.leftMargin - iArr[0];
        int i11 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i10) + Math.max(0, i11);
        iArr[0] = Math.max(0, -i10);
        iArr[1] = Math.max(0, -i11);
        view.measure(ViewGroup.getChildMeasureSpec(i6, getPaddingLeft() + getPaddingRight() + max + i7, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i8, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i9, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void E(View view, int i6, int i7, int i8, int i9, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i7, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i8, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i9, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i10 >= 0) {
            if (mode != 0) {
                i10 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i10);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void F() {
        removeCallbacks(this.O);
        post(this.O);
    }

    private boolean L() {
        if (this.N) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (M(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean M(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List list, int i6) {
        boolean z5 = e0.b0.B(this) == 1;
        int childCount = getChildCount();
        int b6 = e0.d.b(i6, e0.b0.B(this));
        list.clear();
        if (!z5) {
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f809b == 0 && M(childAt) && p(eVar.f320a) == b6) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i8 = childCount - 1; i8 >= 0; i8--) {
            View childAt2 = getChildAt(i8);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f809b == 0 && M(childAt2) && p(eVar2.f320a) == b6) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z5) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        e generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        generateDefaultLayoutParams.f809b = 1;
        if (!z5 || this.f786j == null) {
            addView(view, generateDefaultLayoutParams);
            return;
        }
        view.setLayoutParams(generateDefaultLayoutParams);
        this.F.add(view);
    }

    private MenuInflater getMenuInflater() {
        return new h.g(getContext());
    }

    private void h() {
        if (this.f797u == null) {
            this.f797u = new v1();
        }
    }

    private void i() {
        if (this.f782f == null) {
            this.f782f = new o(getContext());
        }
    }

    private void j() {
        k();
        if (this.f778b.N() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.f778b.getMenu();
            if (this.K == null) {
                this.K = new d();
            }
            this.f778b.setExpandedActionViewsExclusive(true);
            eVar.c(this.K, this.f787k);
        }
    }

    private void k() {
        if (this.f778b == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f778b = actionMenuView;
            actionMenuView.setPopupTheme(this.f788l);
            this.f778b.setOnMenuItemClickListener(this.H);
            this.f778b.O(this.L, this.M);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f320a = (this.f791o & 112) | 8388613;
            this.f778b.setLayoutParams(generateDefaultLayoutParams);
            c(this.f778b, false);
        }
    }

    private void l() {
        if (this.f781e == null) {
            this.f781e = new m(getContext(), null, b.a.toolbarNavigationButtonStyle);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f320a = (this.f791o & 112) | 8388611;
            this.f781e.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private int p(int i6) {
        int B = e0.b0.B(this);
        int b6 = e0.d.b(i6, B) & 7;
        return (b6 == 1 || b6 == 3 || b6 == 5) ? b6 : B == 1 ? 5 : 3;
    }

    private int q(View view, int i6) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i7 = i6 > 0 ? (measuredHeight - i6) / 2 : 0;
        int r5 = r(eVar.f320a);
        if (r5 != 48) {
            if (r5 != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i8 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i9 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                if (i8 < i9) {
                    i8 = i9;
                } else {
                    int i10 = (((height - paddingBottom) - measuredHeight) - i8) - paddingTop;
                    int i11 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                    if (i10 < i11) {
                        i8 = Math.max(0, i8 - (i11 - i10));
                    }
                }
                return paddingTop + i8;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i7;
        }
        return getPaddingTop() - i7;
    }

    private int r(int i6) {
        int i7 = i6 & 112;
        return (i7 == 16 || i7 == 48 || i7 == 80) ? i7 : this.f800x & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return e0.g.b(marginLayoutParams) + e0.g.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List list, int[] iArr) {
        int i6 = iArr[0];
        int i7 = iArr[1];
        int size = list.size();
        int i8 = 0;
        int i9 = 0;
        while (i8 < size) {
            View view = (View) list.get(i8);
            e eVar = (e) view.getLayoutParams();
            int i10 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - i6;
            int i11 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - i7;
            int max = Math.max(0, i10);
            int max2 = Math.max(0, i11);
            int max3 = Math.max(0, -i10);
            int max4 = Math.max(0, -i11);
            i9 += max + view.getMeasuredWidth() + max2;
            i8++;
            i7 = max4;
            i6 = max3;
        }
        return i9;
    }

    private boolean y(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f778b;
        return actionMenuView != null && actionMenuView.J();
    }

    void G() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((e) childAt.getLayoutParams()).f809b != 2 && childAt != this.f778b) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    public void H(int i6, int i7) {
        h();
        this.f797u.g(i6, i7);
    }

    public void I(androidx.appcompat.view.menu.e eVar, androidx.appcompat.widget.c cVar) {
        if (eVar == null && this.f778b == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.e N = this.f778b.N();
        if (N == eVar) {
            return;
        }
        if (N != null) {
            N.O(this.J);
            N.O(this.K);
        }
        if (this.K == null) {
            this.K = new d();
        }
        cVar.G(true);
        if (eVar != null) {
            eVar.c(cVar, this.f787k);
            eVar.c(this.K, this.f787k);
        } else {
            cVar.d(this.f787k, null);
            this.K.d(this.f787k, null);
            cVar.f(true);
            this.K.f(true);
        }
        this.f778b.setPopupTheme(this.f788l);
        this.f778b.setPresenter(cVar);
        this.J = cVar;
    }

    public void J(Context context, int i6) {
        this.f790n = i6;
        TextView textView = this.f780d;
        if (textView != null) {
            textView.setTextAppearance(context, i6);
        }
    }

    public void K(Context context, int i6) {
        this.f789m = i6;
        TextView textView = this.f779c;
        if (textView != null) {
            textView.setTextAppearance(context, i6);
        }
    }

    public boolean N() {
        ActionMenuView actionMenuView = this.f778b;
        return actionMenuView != null && actionMenuView.P();
    }

    void a() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView((View) this.F.get(size));
        }
        this.F.clear();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f778b) != null && actionMenuView.K();
    }

    public void e() {
        d dVar = this.K;
        androidx.appcompat.view.menu.g gVar = dVar == null ? null : dVar.f807c;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f778b;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    void g() {
        if (this.f785i == null) {
            m mVar = new m(getContext(), null, b.a.toolbarNavigationButtonStyle);
            this.f785i = mVar;
            mVar.setImageDrawable(this.f783g);
            this.f785i.setContentDescription(this.f784h);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f320a = (this.f791o & 112) | 8388611;
            generateDefaultLayoutParams.f809b = 2;
            this.f785i.setLayoutParams(generateDefaultLayoutParams);
            this.f785i.setOnClickListener(new c());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f785i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f785i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        v1 v1Var = this.f797u;
        if (v1Var != null) {
            return v1Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i6 = this.f799w;
        return i6 != Integer.MIN_VALUE ? i6 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        v1 v1Var = this.f797u;
        if (v1Var != null) {
            return v1Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        v1 v1Var = this.f797u;
        if (v1Var != null) {
            return v1Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        v1 v1Var = this.f797u;
        if (v1Var != null) {
            return v1Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i6 = this.f798v;
        return i6 != Integer.MIN_VALUE ? i6 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e N;
        ActionMenuView actionMenuView = this.f778b;
        return actionMenuView != null && (N = actionMenuView.N()) != null && N.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.f799w, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return e0.b0.B(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return e0.b0.B(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f798v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f782f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f782f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f778b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f781e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f781e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    androidx.appcompat.widget.c getOuterActionMenuPresenter() {
        return this.J;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f778b.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f787k;
    }

    public int getPopupTheme() {
        return this.f788l;
    }

    public CharSequence getSubtitle() {
        return this.f802z;
    }

    final TextView getSubtitleTextView() {
        return this.f780d;
    }

    public CharSequence getTitle() {
        return this.f801y;
    }

    public int getTitleMarginBottom() {
        return this.f796t;
    }

    public int getTitleMarginEnd() {
        return this.f794r;
    }

    public int getTitleMarginStart() {
        return this.f793q;
    }

    public int getTitleMarginTop() {
        return this.f795s;
    }

    final TextView getTitleTextView() {
        return this.f779c;
    }

    public e1 getWrapper() {
        if (this.I == null) {
            this.I = new d2(this, true);
        }
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: n */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: o */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof a.C0008a ? new e((a.C0008a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.O);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0295 A[LOOP:0: B:109:0x0293->B:110:0x0295, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02b7 A[LOOP:1: B:112:0x02b5->B:113:0x02b7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02f0 A[LOOP:2: B:121:0x02ee->B:122:0x02f0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x021d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        boolean M;
        boolean M2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int paddingTop;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int size;
        int i25;
        int size2;
        int i26;
        int i27;
        int size3;
        boolean z6 = e0.b0.B(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i28 = width - paddingRight;
        int[] iArr = this.G;
        iArr[1] = 0;
        iArr[0] = 0;
        int C = e0.b0.C(this);
        int min = C >= 0 ? Math.min(C, i9 - i7) : 0;
        if (M(this.f781e)) {
            ImageButton imageButton = this.f781e;
            if (z6) {
                i11 = C(imageButton, i28, iArr, min);
                i10 = paddingLeft;
                if (M(this.f785i)) {
                    ImageButton imageButton2 = this.f785i;
                    if (z6) {
                        i11 = C(imageButton2, i11, iArr, min);
                    } else {
                        i10 = B(imageButton2, i10, iArr, min);
                    }
                }
                if (M(this.f778b)) {
                    ActionMenuView actionMenuView = this.f778b;
                    if (z6) {
                        i10 = B(actionMenuView, i10, iArr, min);
                    } else {
                        i11 = C(actionMenuView, i11, iArr, min);
                    }
                }
                int currentContentInsetLeft = getCurrentContentInsetLeft();
                int currentContentInsetRight = getCurrentContentInsetRight();
                iArr[0] = Math.max(0, currentContentInsetLeft - i10);
                iArr[1] = Math.max(0, currentContentInsetRight - (i28 - i11));
                int max = Math.max(i10, currentContentInsetLeft);
                int min2 = Math.min(i11, i28 - currentContentInsetRight);
                if (M(this.f786j)) {
                    View view = this.f786j;
                    if (z6) {
                        min2 = C(view, min2, iArr, min);
                    } else {
                        max = B(view, max, iArr, min);
                    }
                }
                if (M(this.f782f)) {
                    ImageView imageView = this.f782f;
                    if (z6) {
                        min2 = C(imageView, min2, iArr, min);
                    } else {
                        max = B(imageView, max, iArr, min);
                    }
                }
                M = M(this.f779c);
                M2 = M(this.f780d);
                if (M) {
                    i12 = paddingRight;
                    i13 = 0;
                } else {
                    e eVar = (e) this.f779c.getLayoutParams();
                    i12 = paddingRight;
                    i13 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + this.f779c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin + 0;
                }
                if (M2) {
                    i14 = width;
                } else {
                    e eVar2 = (e) this.f780d.getLayoutParams();
                    i14 = width;
                    i13 += ((ViewGroup.MarginLayoutParams) eVar2).topMargin + this.f780d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin;
                }
                if (!M || M2) {
                    TextView textView = !M ? this.f779c : this.f780d;
                    TextView textView2 = !M2 ? this.f780d : this.f779c;
                    e eVar3 = (e) textView.getLayoutParams();
                    e eVar4 = (e) textView2.getLayoutParams();
                    boolean z7 = (!M && this.f779c.getMeasuredWidth() > 0) || (M2 && this.f780d.getMeasuredWidth() > 0);
                    i15 = this.f800x & 112;
                    i16 = paddingLeft;
                    if (i15 != 48) {
                        i17 = max;
                        i18 = min;
                        paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar3).topMargin + this.f795s;
                    } else if (i15 != 80) {
                        int i29 = (((height - paddingTop2) - paddingBottom) - i13) / 2;
                        int i30 = ((ViewGroup.MarginLayoutParams) eVar3).topMargin;
                        i18 = min;
                        int i31 = this.f795s;
                        i17 = max;
                        if (i29 < i30 + i31) {
                            i29 = i30 + i31;
                        } else {
                            int i32 = (((height - paddingBottom) - i13) - i29) - paddingTop2;
                            int i33 = ((ViewGroup.MarginLayoutParams) eVar3).bottomMargin;
                            int i34 = this.f796t;
                            if (i32 < i33 + i34) {
                                i29 = Math.max(0, i29 - ((((ViewGroup.MarginLayoutParams) eVar4).bottomMargin + i34) - i32));
                            }
                        }
                        paddingTop = paddingTop2 + i29;
                    } else {
                        i17 = max;
                        i18 = min;
                        paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) eVar4).bottomMargin) - this.f796t) - i13;
                    }
                    if (z6) {
                        if (z7) {
                            i20 = this.f793q;
                            i19 = 0;
                        } else {
                            i19 = 0;
                            i20 = 0;
                        }
                        int i35 = i20 - iArr[i19];
                        max = i17 + Math.max(i19, i35);
                        iArr[i19] = Math.max(i19, -i35);
                        if (M) {
                            int measuredWidth = this.f779c.getMeasuredWidth() + max;
                            int measuredHeight = this.f779c.getMeasuredHeight() + paddingTop;
                            this.f779c.layout(max, paddingTop, measuredWidth, measuredHeight);
                            i21 = measuredWidth + this.f794r;
                            paddingTop = measuredHeight + ((ViewGroup.MarginLayoutParams) ((e) this.f779c.getLayoutParams())).bottomMargin;
                        } else {
                            i21 = max;
                        }
                        if (M2) {
                            int i36 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f780d.getLayoutParams())).topMargin;
                            int measuredWidth2 = this.f780d.getMeasuredWidth() + max;
                            this.f780d.layout(max, i36, measuredWidth2, this.f780d.getMeasuredHeight() + i36);
                            i22 = measuredWidth2 + this.f794r;
                        } else {
                            i22 = max;
                        }
                        if (z7) {
                            max = Math.max(i21, i22);
                        }
                        b(this.E, 3);
                        size = this.E.size();
                        for (i25 = 0; i25 < size; i25++) {
                            max = B((View) this.E.get(i25), max, iArr, i18);
                        }
                        int i37 = i18;
                        b(this.E, 5);
                        size2 = this.E.size();
                        for (i26 = 0; i26 < size2; i26++) {
                            min2 = C((View) this.E.get(i26), min2, iArr, i37);
                        }
                        b(this.E, 1);
                        int u5 = u(this.E, iArr);
                        i27 = (i16 + (((i14 - i16) - i12) / 2)) - (u5 / 2);
                        int i38 = u5 + i27;
                        if (i27 >= max) {
                            max = i38 > min2 ? i27 - (i38 - min2) : i27;
                        }
                        size3 = this.E.size();
                        while (i19 < size3) {
                            max = B((View) this.E.get(i19), max, iArr, i37);
                            i19++;
                        }
                        this.E.clear();
                        return;
                    }
                    int i39 = (z7 ? this.f793q : 0) - iArr[1];
                    min2 -= Math.max(0, i39);
                    iArr[1] = Math.max(0, -i39);
                    if (M) {
                        int measuredWidth3 = min2 - this.f779c.getMeasuredWidth();
                        int measuredHeight2 = this.f779c.getMeasuredHeight() + paddingTop;
                        this.f779c.layout(measuredWidth3, paddingTop, min2, measuredHeight2);
                        i23 = measuredWidth3 - this.f794r;
                        paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) ((e) this.f779c.getLayoutParams())).bottomMargin;
                    } else {
                        i23 = min2;
                    }
                    if (M2) {
                        int i40 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f780d.getLayoutParams())).topMargin;
                        this.f780d.layout(min2 - this.f780d.getMeasuredWidth(), i40, min2, this.f780d.getMeasuredHeight() + i40);
                        i24 = min2 - this.f794r;
                    } else {
                        i24 = min2;
                    }
                    if (z7) {
                        min2 = Math.min(i23, i24);
                    }
                    max = i17;
                } else {
                    i16 = paddingLeft;
                    i18 = min;
                }
                i19 = 0;
                b(this.E, 3);
                size = this.E.size();
                while (i25 < size) {
                }
                int i372 = i18;
                b(this.E, 5);
                size2 = this.E.size();
                while (i26 < size2) {
                }
                b(this.E, 1);
                int u52 = u(this.E, iArr);
                i27 = (i16 + (((i14 - i16) - i12) / 2)) - (u52 / 2);
                int i382 = u52 + i27;
                if (i27 >= max) {
                }
                size3 = this.E.size();
                while (i19 < size3) {
                }
                this.E.clear();
                return;
            }
            i10 = B(imageButton, paddingLeft, iArr, min);
        } else {
            i10 = paddingLeft;
        }
        i11 = i28;
        if (M(this.f785i)) {
        }
        if (M(this.f778b)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - i10);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i28 - i11));
        int max2 = Math.max(i10, currentContentInsetLeft2);
        int min22 = Math.min(i11, i28 - currentContentInsetRight2);
        if (M(this.f786j)) {
        }
        if (M(this.f782f)) {
        }
        M = M(this.f779c);
        M2 = M(this.f780d);
        if (M) {
        }
        if (M2) {
        }
        if (M) {
        }
        if (!M) {
        }
        if (!M2) {
        }
        e eVar32 = (e) textView.getLayoutParams();
        e eVar42 = (e) textView2.getLayoutParams();
        if (M) {
        }
        i15 = this.f800x & 112;
        i16 = paddingLeft;
        if (i15 != 48) {
        }
        if (z6) {
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int[] iArr = this.G;
        boolean b6 = j2.b(this);
        int i15 = !b6 ? 1 : 0;
        if (M(this.f781e)) {
            E(this.f781e, i6, 0, i7, 0, this.f792p);
            i8 = this.f781e.getMeasuredWidth() + s(this.f781e);
            i9 = Math.max(0, this.f781e.getMeasuredHeight() + t(this.f781e));
            i10 = View.combineMeasuredStates(0, this.f781e.getMeasuredState());
        } else {
            i8 = 0;
            i9 = 0;
            i10 = 0;
        }
        if (M(this.f785i)) {
            E(this.f785i, i6, 0, i7, 0, this.f792p);
            i8 = this.f785i.getMeasuredWidth() + s(this.f785i);
            i9 = Math.max(i9, this.f785i.getMeasuredHeight() + t(this.f785i));
            i10 = View.combineMeasuredStates(i10, this.f785i.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i8);
        iArr[b6 ? 1 : 0] = Math.max(0, currentContentInsetStart - i8);
        if (M(this.f778b)) {
            E(this.f778b, i6, max, i7, 0, this.f792p);
            i11 = this.f778b.getMeasuredWidth() + s(this.f778b);
            i9 = Math.max(i9, this.f778b.getMeasuredHeight() + t(this.f778b));
            i10 = View.combineMeasuredStates(i10, this.f778b.getMeasuredState());
        } else {
            i11 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i11);
        iArr[i15] = Math.max(0, currentContentInsetEnd - i11);
        if (M(this.f786j)) {
            max2 += D(this.f786j, i6, max2, i7, 0, iArr);
            i9 = Math.max(i9, this.f786j.getMeasuredHeight() + t(this.f786j));
            i10 = View.combineMeasuredStates(i10, this.f786j.getMeasuredState());
        }
        if (M(this.f782f)) {
            max2 += D(this.f782f, i6, max2, i7, 0, iArr);
            i9 = Math.max(i9, this.f782f.getMeasuredHeight() + t(this.f782f));
            i10 = View.combineMeasuredStates(i10, this.f782f.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (((e) childAt.getLayoutParams()).f809b == 0 && M(childAt)) {
                max2 += D(childAt, i6, max2, i7, 0, iArr);
                i9 = Math.max(i9, childAt.getMeasuredHeight() + t(childAt));
                i10 = View.combineMeasuredStates(i10, childAt.getMeasuredState());
            }
        }
        int i17 = this.f795s + this.f796t;
        int i18 = this.f793q + this.f794r;
        if (M(this.f779c)) {
            D(this.f779c, i6, max2 + i18, i7, i17, iArr);
            int measuredWidth = this.f779c.getMeasuredWidth() + s(this.f779c);
            i14 = this.f779c.getMeasuredHeight() + t(this.f779c);
            i12 = View.combineMeasuredStates(i10, this.f779c.getMeasuredState());
            i13 = measuredWidth;
        } else {
            i12 = i10;
            i13 = 0;
            i14 = 0;
        }
        if (M(this.f780d)) {
            i13 = Math.max(i13, D(this.f780d, i6, max2 + i18, i7, i14 + i17, iArr));
            i14 += this.f780d.getMeasuredHeight() + t(this.f780d);
            i12 = View.combineMeasuredStates(i12, this.f780d.getMeasuredState());
        }
        int max3 = Math.max(i9, i14);
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max2 + i13 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i6, (-16777216) & i12), L() ? 0 : View.resolveSizeAndState(Math.max(max3 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i7, i12 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.e());
        ActionMenuView actionMenuView = this.f778b;
        androidx.appcompat.view.menu.e N = actionMenuView != null ? actionMenuView.N() : null;
        int i6 = gVar.f810c;
        if (i6 != 0 && this.K != null && N != null && (findItem = N.findItem(i6)) != null) {
            findItem.expandActionView();
        }
        if (gVar.f811d) {
            F();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i6) {
        super.onRtlPropertiesChanged(i6);
        h();
        this.f797u.f(i6 == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        g gVar2 = new g(super.onSaveInstanceState());
        d dVar = this.K;
        if (dVar != null && (gVar = dVar.f807c) != null) {
            gVar2.f810c = gVar.getItemId();
        }
        gVar2.f811d = A();
        return gVar2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public void setCollapseContentDescription(int i6) {
        setCollapseContentDescription(i6 != 0 ? getContext().getText(i6) : null);
    }

    public void setCollapseIcon(int i6) {
        setCollapseIcon(e.b.d(getContext(), i6));
    }

    public void setCollapsible(boolean z5) {
        this.N = z5;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i6) {
        if (i6 < 0) {
            i6 = Integer.MIN_VALUE;
        }
        if (i6 != this.f799w) {
            this.f799w = i6;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i6) {
        if (i6 < 0) {
            i6 = Integer.MIN_VALUE;
        }
        if (i6 != this.f798v) {
            this.f798v = i6;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i6) {
        setLogo(e.b.d(getContext(), i6));
    }

    public void setLogoDescription(int i6) {
        setLogoDescription(getContext().getText(i6));
    }

    public void setNavigationContentDescription(int i6) {
        setNavigationContentDescription(i6 != 0 ? getContext().getText(i6) : null);
    }

    public void setNavigationIcon(int i6) {
        setNavigationIcon(e.b.d(getContext(), i6));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f781e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f778b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i6) {
        if (this.f788l != i6) {
            this.f788l = i6;
            if (i6 == 0) {
                this.f787k = getContext();
            } else {
                this.f787k = new ContextThemeWrapper(getContext(), i6);
            }
        }
    }

    public void setSubtitle(int i6) {
        setSubtitle(getContext().getText(i6));
    }

    public void setSubtitleTextColor(int i6) {
        setSubtitleTextColor(ColorStateList.valueOf(i6));
    }

    public void setTitle(int i6) {
        setTitle(getContext().getText(i6));
    }

    public void setTitleMarginBottom(int i6) {
        this.f796t = i6;
        requestLayout();
    }

    public void setTitleMarginEnd(int i6) {
        this.f794r = i6;
        requestLayout();
    }

    public void setTitleMarginStart(int i6) {
        this.f793q = i6;
        requestLayout();
    }

    public void setTitleMarginTop(int i6) {
        this.f795s = i6;
        requestLayout();
    }

    public void setTitleTextColor(int i6) {
        setTitleTextColor(ColorStateList.valueOf(i6));
    }

    public boolean v() {
        d dVar = this.K;
        return (dVar == null || dVar.f807c == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f778b;
        return actionMenuView != null && actionMenuView.H();
    }

    public void x(int i6) {
        getMenuInflater().inflate(i6, getMenu());
    }

    public boolean z() {
        ActionMenuView actionMenuView = this.f778b;
        return actionMenuView != null && actionMenuView.I();
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f800x = 8388627;
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new int[2];
        this.H = new a();
        this.O = new b();
        Context context2 = getContext();
        int[] iArr = b.j.W2;
        c2 v5 = c2.v(context2, attributeSet, iArr, i6, 0);
        e0.b0.j0(this, context, iArr, attributeSet, v5.r(), i6, 0);
        this.f789m = v5.n(b.j.f2836y3, 0);
        this.f790n = v5.n(b.j.f2791p3, 0);
        this.f800x = v5.l(b.j.X2, this.f800x);
        this.f791o = v5.l(b.j.Y2, 48);
        int e6 = v5.e(b.j.f2806s3, 0);
        int i7 = b.j.f2831x3;
        e6 = v5.s(i7) ? v5.e(i7, e6) : e6;
        this.f796t = e6;
        this.f795s = e6;
        this.f794r = e6;
        this.f793q = e6;
        int e7 = v5.e(b.j.f2821v3, -1);
        if (e7 >= 0) {
            this.f793q = e7;
        }
        int e8 = v5.e(b.j.f2816u3, -1);
        if (e8 >= 0) {
            this.f794r = e8;
        }
        int e9 = v5.e(b.j.f2826w3, -1);
        if (e9 >= 0) {
            this.f795s = e9;
        }
        int e10 = v5.e(b.j.f2811t3, -1);
        if (e10 >= 0) {
            this.f796t = e10;
        }
        this.f792p = v5.f(b.j.f2761j3, -1);
        int e11 = v5.e(b.j.f2741f3, Integer.MIN_VALUE);
        int e12 = v5.e(b.j.f2721b3, Integer.MIN_VALUE);
        int f6 = v5.f(b.j.f2731d3, 0);
        int f7 = v5.f(b.j.f2736e3, 0);
        h();
        this.f797u.e(f6, f7);
        if (e11 != Integer.MIN_VALUE || e12 != Integer.MIN_VALUE) {
            this.f797u.g(e11, e12);
        }
        this.f798v = v5.e(b.j.f2746g3, Integer.MIN_VALUE);
        this.f799w = v5.e(b.j.f2726c3, Integer.MIN_VALUE);
        this.f783g = v5.g(b.j.f2716a3);
        this.f784h = v5.p(b.j.Z2);
        CharSequence p5 = v5.p(b.j.f2801r3);
        if (!TextUtils.isEmpty(p5)) {
            setTitle(p5);
        }
        CharSequence p6 = v5.p(b.j.f2786o3);
        if (!TextUtils.isEmpty(p6)) {
            setSubtitle(p6);
        }
        this.f787k = getContext();
        setPopupTheme(v5.n(b.j.f2781n3, 0));
        Drawable g6 = v5.g(b.j.f2776m3);
        if (g6 != null) {
            setNavigationIcon(g6);
        }
        CharSequence p7 = v5.p(b.j.f2771l3);
        if (!TextUtils.isEmpty(p7)) {
            setNavigationContentDescription(p7);
        }
        Drawable g7 = v5.g(b.j.f2751h3);
        if (g7 != null) {
            setLogo(g7);
        }
        CharSequence p8 = v5.p(b.j.f2756i3);
        if (!TextUtils.isEmpty(p8)) {
            setLogoDescription(p8);
        }
        int i8 = b.j.f2841z3;
        if (v5.s(i8)) {
            setTitleTextColor(v5.c(i8));
        }
        int i9 = b.j.f2796q3;
        if (v5.s(i9)) {
            setSubtitleTextColor(v5.c(i9));
        }
        int i10 = b.j.f2766k3;
        if (v5.s(i10)) {
            x(v5.n(i10, 0));
        }
        v5.w();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f785i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f785i.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.f785i;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.f783g);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!y(this.f782f)) {
                c(this.f782f, true);
            }
        } else {
            ImageView imageView = this.f782f;
            if (imageView != null && y(imageView)) {
                removeView(this.f782f);
                this.F.remove(this.f782f);
            }
        }
        ImageView imageView2 = this.f782f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f782f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f781e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!y(this.f781e)) {
                c(this.f781e, true);
            }
        } else {
            ImageButton imageButton = this.f781e;
            if (imageButton != null && y(imageButton)) {
                removeView(this.f781e);
                this.F.remove(this.f781e);
            }
        }
        ImageButton imageButton2 = this.f781e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f780d;
            if (textView != null && y(textView)) {
                removeView(this.f780d);
                this.F.remove(this.f780d);
            }
        } else {
            if (this.f780d == null) {
                Context context = getContext();
                n0 n0Var = new n0(context);
                this.f780d = n0Var;
                n0Var.setSingleLine();
                this.f780d.setEllipsize(TextUtils.TruncateAt.END);
                int i6 = this.f790n;
                if (i6 != 0) {
                    this.f780d.setTextAppearance(context, i6);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.f780d.setTextColor(colorStateList);
                }
            }
            if (!y(this.f780d)) {
                c(this.f780d, true);
            }
        }
        TextView textView2 = this.f780d;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f802z = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.B = colorStateList;
        TextView textView = this.f780d;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f779c;
            if (textView != null && y(textView)) {
                removeView(this.f779c);
                this.F.remove(this.f779c);
            }
        } else {
            if (this.f779c == null) {
                Context context = getContext();
                n0 n0Var = new n0(context);
                this.f779c = n0Var;
                n0Var.setSingleLine();
                this.f779c.setEllipsize(TextUtils.TruncateAt.END);
                int i6 = this.f789m;
                if (i6 != 0) {
                    this.f779c.setTextAppearance(context, i6);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f779c.setTextColor(colorStateList);
                }
            }
            if (!y(this.f779c)) {
                c(this.f779c, true);
            }
        }
        TextView textView2 = this.f779c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f801y = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f779c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
