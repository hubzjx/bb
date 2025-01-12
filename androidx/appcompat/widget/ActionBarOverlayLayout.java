package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.j;
import e0.v0;
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements d1, e0.r, e0.s {
    static final int[] G = {b.a.actionBarSize, 16842841};
    private OverScroller A;
    ViewPropertyAnimator B;
    final AnimatorListenerAdapter C;
    private final Runnable D;
    private final Runnable E;
    private final e0.t F;

    /* renamed from: b  reason: collision with root package name */
    private int f669b;

    /* renamed from: c  reason: collision with root package name */
    private int f670c;

    /* renamed from: d  reason: collision with root package name */
    private ContentFrameLayout f671d;

    /* renamed from: e  reason: collision with root package name */
    ActionBarContainer f672e;

    /* renamed from: f  reason: collision with root package name */
    private e1 f673f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f674g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f675h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f676i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f677j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f678k;

    /* renamed from: l  reason: collision with root package name */
    boolean f679l;

    /* renamed from: m  reason: collision with root package name */
    private int f680m;

    /* renamed from: n  reason: collision with root package name */
    private int f681n;

    /* renamed from: o  reason: collision with root package name */
    private final Rect f682o;

    /* renamed from: p  reason: collision with root package name */
    private final Rect f683p;

    /* renamed from: q  reason: collision with root package name */
    private final Rect f684q;

    /* renamed from: r  reason: collision with root package name */
    private final Rect f685r;

    /* renamed from: s  reason: collision with root package name */
    private final Rect f686s;

    /* renamed from: t  reason: collision with root package name */
    private final Rect f687t;

    /* renamed from: u  reason: collision with root package name */
    private final Rect f688u;

    /* renamed from: v  reason: collision with root package name */
    private e0.v0 f689v;

    /* renamed from: w  reason: collision with root package name */
    private e0.v0 f690w;

    /* renamed from: x  reason: collision with root package name */
    private e0.v0 f691x;

    /* renamed from: y  reason: collision with root package name */
    private e0.v0 f692y;

    /* renamed from: z  reason: collision with root package name */
    private d f693z;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.f679l = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.f679l = false;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f672e.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f672e.animate().translationY(-ActionBarOverlayLayout.this.f672e.getHeight()).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();

        void c(int i6);

        void d();

        void e(boolean z5);

        void f();
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {
        public e(int i6, int i7) {
            super(i6, i7);
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f670c = 0;
        this.f682o = new Rect();
        this.f683p = new Rect();
        this.f684q = new Rect();
        this.f685r = new Rect();
        this.f686s = new Rect();
        this.f687t = new Rect();
        this.f688u = new Rect();
        e0.v0 v0Var = e0.v0.f9372b;
        this.f689v = v0Var;
        this.f690w = v0Var;
        this.f691x = v0Var;
        this.f692y = v0Var;
        this.C = new a();
        this.D = new b();
        this.E = new c();
        v(context);
        this.F = new e0.t(this);
    }

    private void A() {
        u();
        this.D.run();
    }

    private boolean B(float f6) {
        this.A.fling(0, 0, 0, (int) f6, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.A.getFinalY() > this.f672e.getHeight();
    }

    private void p() {
        u();
        this.E.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean q(View view, Rect rect, boolean z5, boolean z6, boolean z7, boolean z8) {
        boolean z9;
        e eVar = (e) view.getLayoutParams();
        if (z5) {
            int i6 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
            int i7 = rect.left;
            if (i6 != i7) {
                ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i7;
                z9 = true;
                if (z6) {
                    int i8 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                    int i9 = rect.top;
                    if (i8 != i9) {
                        ((ViewGroup.MarginLayoutParams) eVar).topMargin = i9;
                        z9 = true;
                    }
                }
                if (z8) {
                    int i10 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
                    int i11 = rect.right;
                    if (i10 != i11) {
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i11;
                        z9 = true;
                    }
                }
                if (z7) {
                    int i12 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                    int i13 = rect.bottom;
                    if (i12 != i13) {
                        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i13;
                        return true;
                    }
                }
                return z9;
            }
        }
        z9 = false;
        if (z6) {
        }
        if (z8) {
        }
        if (z7) {
        }
        return z9;
    }

    private e1 t(View view) {
        if (view instanceof e1) {
            return (e1) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(G);
        this.f669b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f674g = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.f675h = context.getApplicationInfo().targetSdkVersion < 19;
        this.A = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.E, 600L);
    }

    private void y() {
        u();
        postDelayed(this.D, 600L);
    }

    @Override // androidx.appcompat.widget.d1
    public void a(Menu menu, j.a aVar) {
        z();
        this.f673f.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.d1
    public boolean b() {
        z();
        return this.f673f.b();
    }

    @Override // androidx.appcompat.widget.d1
    public void c() {
        z();
        this.f673f.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.d1
    public boolean d() {
        z();
        return this.f673f.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f674g == null || this.f675h) {
            return;
        }
        int bottom = this.f672e.getVisibility() == 0 ? (int) (this.f672e.getBottom() + this.f672e.getTranslationY() + 0.5f) : 0;
        this.f674g.setBounds(0, bottom, getWidth(), this.f674g.getIntrinsicHeight() + bottom);
        this.f674g.draw(canvas);
    }

    @Override // androidx.appcompat.widget.d1
    public boolean e() {
        z();
        return this.f673f.e();
    }

    @Override // androidx.appcompat.widget.d1
    public boolean f() {
        z();
        return this.f673f.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.d1
    public boolean g() {
        z();
        return this.f673f.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f672e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.F.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f673f.getTitle();
    }

    @Override // e0.r
    public void h(View view, View view2, int i6, int i7) {
        if (i7 == 0) {
            onNestedScrollAccepted(view, view2, i6);
        }
    }

    @Override // e0.r
    public void i(View view, int i6) {
        if (i6 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // e0.r
    public void j(View view, int i6, int i7, int[] iArr, int i8) {
        if (i8 == 0) {
            onNestedPreScroll(view, i6, i7, iArr);
        }
    }

    @Override // androidx.appcompat.widget.d1
    public void k(int i6) {
        z();
        if (i6 == 2) {
            this.f673f.s();
        } else if (i6 == 5) {
            this.f673f.t();
        } else if (i6 != 109) {
        } else {
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.d1
    public void l() {
        z();
        this.f673f.h();
    }

    @Override // e0.s
    public void m(View view, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
        n(view, i6, i7, i8, i9, i10);
    }

    @Override // e0.r
    public void n(View view, int i6, int i7, int i8, int i9, int i10) {
        if (i10 == 0) {
            onNestedScroll(view, i6, i7, i8, i9);
        }
    }

    @Override // e0.r
    public boolean o(View view, View view2, int i6, int i7) {
        return i7 == 0 && onStartNestedScroll(view, view2, i6);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        z();
        e0.v0 s5 = e0.v0.s(windowInsets);
        boolean q5 = q(this.f672e, new Rect(s5.g(), s5.i(), s5.h(), s5.f()), true, true, false, true);
        e0.b0.g(this, s5, this.f682o);
        Rect rect = this.f682o;
        e0.v0 j6 = s5.j(rect.left, rect.top, rect.right, rect.bottom);
        this.f689v = j6;
        boolean z5 = true;
        if (!this.f690w.equals(j6)) {
            this.f690w = this.f689v;
            q5 = true;
        }
        if (this.f683p.equals(this.f682o)) {
            z5 = q5;
        } else {
            this.f683p.set(this.f682o);
        }
        if (z5) {
            requestLayout();
        }
        return s5.a().c().b().r();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        e0.b0.i0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i11 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i12 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i11, i12, measuredWidth + i11, measuredHeight + i12);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int measuredHeight;
        e0.v0 a6;
        z();
        measureChildWithMargins(this.f672e, i6, 0, i7, 0);
        e eVar = (e) this.f672e.getLayoutParams();
        int max = Math.max(0, this.f672e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f672e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f672e.getMeasuredState());
        boolean z5 = (e0.b0.K(this) & 256) != 0;
        if (z5) {
            measuredHeight = this.f669b;
            if (this.f677j && this.f672e.getTabContainer() != null) {
                measuredHeight += this.f669b;
            }
        } else {
            measuredHeight = this.f672e.getVisibility() != 8 ? this.f672e.getMeasuredHeight() : 0;
        }
        this.f684q.set(this.f682o);
        e0.v0 v0Var = this.f689v;
        this.f691x = v0Var;
        if (this.f676i || z5) {
            a6 = new v0.b(this.f691x).c(w.g.b(v0Var.g(), this.f691x.i() + measuredHeight, this.f691x.h(), this.f691x.f() + 0)).a();
        } else {
            Rect rect = this.f684q;
            rect.top += measuredHeight;
            rect.bottom += 0;
            a6 = v0Var.j(0, measuredHeight, 0, 0);
        }
        this.f691x = a6;
        q(this.f671d, this.f684q, true, true, true, true);
        if (!this.f692y.equals(this.f691x)) {
            e0.v0 v0Var2 = this.f691x;
            this.f692y = v0Var2;
            e0.b0.h(this.f671d, v0Var2);
        }
        measureChildWithMargins(this.f671d, i6, 0, i7, 0);
        e eVar2 = (e) this.f671d.getLayoutParams();
        int max3 = Math.max(max, this.f671d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f671d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f671d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i6, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i7, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f6, float f7, boolean z5) {
        if (this.f678k && z5) {
            if (B(f7)) {
                p();
            } else {
                A();
            }
            this.f679l = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f6, float f7) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i6, int i7, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i6, int i7, int i8, int i9) {
        int i10 = this.f680m + i7;
        this.f680m = i10;
        setActionBarHideOffset(i10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i6) {
        this.F.b(view, view2, i6);
        this.f680m = getActionBarHideOffset();
        u();
        d dVar = this.f693z;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i6) {
        if ((i6 & 2) == 0 || this.f672e.getVisibility() != 0) {
            return false;
        }
        return this.f678k;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f678k && !this.f679l) {
            if (this.f680m <= this.f672e.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.f693z;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i6) {
        super.onWindowSystemUiVisibilityChanged(i6);
        z();
        int i7 = this.f681n ^ i6;
        this.f681n = i6;
        boolean z5 = (i6 & 4) == 0;
        boolean z6 = (i6 & 256) != 0;
        d dVar = this.f693z;
        if (dVar != null) {
            dVar.e(!z6);
            if (z5 || !z6) {
                this.f693z.a();
            } else {
                this.f693z.f();
            }
        }
        if ((i7 & 256) == 0 || this.f693z == null) {
            return;
        }
        e0.b0.i0(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        this.f670c = i6;
        d dVar = this.f693z;
        if (dVar != null) {
            dVar.c(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: r */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: s */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i6) {
        u();
        this.f672e.setTranslationY(-Math.max(0, Math.min(i6, this.f672e.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f693z = dVar;
        if (getWindowToken() != null) {
            this.f693z.c(this.f670c);
            int i6 = this.f681n;
            if (i6 != 0) {
                onWindowSystemUiVisibilityChanged(i6);
                e0.b0.i0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z5) {
        this.f677j = z5;
    }

    public void setHideOnContentScrollEnabled(boolean z5) {
        if (z5 != this.f678k) {
            this.f678k = z5;
            if (z5) {
                return;
            }
            u();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i6) {
        z();
        this.f673f.setIcon(i6);
    }

    public void setLogo(int i6) {
        z();
        this.f673f.p(i6);
    }

    public void setOverlayMode(boolean z5) {
        this.f676i = z5;
        this.f675h = z5 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z5) {
    }

    public void setUiOptions(int i6) {
    }

    @Override // androidx.appcompat.widget.d1
    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f673f.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.d1
    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f673f.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    void u() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.B;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.f676i;
    }

    void z() {
        if (this.f671d == null) {
            this.f671d = (ContentFrameLayout) findViewById(b.f.action_bar_activity_content);
            this.f672e = (ActionBarContainer) findViewById(b.f.action_bar_container);
            this.f673f = t(findViewById(b.f.action_bar));
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f673f.setIcon(drawable);
    }
}
