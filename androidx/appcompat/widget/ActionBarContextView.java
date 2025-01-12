package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ActionBarContextView extends androidx.appcompat.widget.a {

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f656j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f657k;

    /* renamed from: l  reason: collision with root package name */
    private View f658l;

    /* renamed from: m  reason: collision with root package name */
    private View f659m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f660n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f661o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f662p;

    /* renamed from: q  reason: collision with root package name */
    private int f663q;

    /* renamed from: r  reason: collision with root package name */
    private int f664r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f665s;

    /* renamed from: t  reason: collision with root package name */
    private int f666t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h.b f667b;

        a(h.b bVar) {
            this.f667b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f667b.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void i() {
        if (this.f660n == null) {
            LayoutInflater.from(getContext()).inflate(b.g.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f660n = linearLayout;
            this.f661o = (TextView) linearLayout.findViewById(b.f.action_bar_title);
            this.f662p = (TextView) this.f660n.findViewById(b.f.action_bar_subtitle);
            if (this.f663q != 0) {
                this.f661o.setTextAppearance(getContext(), this.f663q);
            }
            if (this.f664r != 0) {
                this.f662p.setTextAppearance(getContext(), this.f664r);
            }
        }
        this.f661o.setText(this.f656j);
        this.f662p.setText(this.f657k);
        boolean z5 = !TextUtils.isEmpty(this.f656j);
        boolean z6 = !TextUtils.isEmpty(this.f657k);
        int i6 = 0;
        this.f662p.setVisibility(z6 ? 0 : 8);
        LinearLayout linearLayout2 = this.f660n;
        if (!z5 && !z6) {
            i6 = 8;
        }
        linearLayout2.setVisibility(i6);
        if (this.f660n.getParent() == null) {
            addView(this.f660n);
        }
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ e0.r0 f(int i6, long j6) {
        return super.f(i6, j6);
    }

    public void g() {
        if (this.f658l == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f657k;
    }

    public CharSequence getTitle() {
        return this.f656j;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(h.b bVar) {
        View view;
        c cVar;
        View view2 = this.f658l;
        if (view2 != null) {
            if (view2.getParent() == null) {
                view = this.f658l;
            }
            this.f658l.findViewById(b.f.action_mode_close_button).setOnClickListener(new a(bVar));
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) bVar.e();
            cVar = this.f819e;
            if (cVar != null) {
                cVar.y();
            }
            c cVar2 = new c(getContext());
            this.f819e = cVar2;
            cVar2.J(true);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
            eVar.c(this.f819e, this.f817c);
            ActionMenuView actionMenuView = (ActionMenuView) this.f819e.o(this);
            this.f818d = actionMenuView;
            e0.b0.o0(actionMenuView, null);
            addView(this.f818d, layoutParams);
        }
        view = LayoutInflater.from(getContext()).inflate(this.f666t, (ViewGroup) this, false);
        this.f658l = view;
        addView(view);
        this.f658l.findViewById(b.f.action_mode_close_button).setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.e eVar2 = (androidx.appcompat.view.menu.e) bVar.e();
        cVar = this.f819e;
        if (cVar != null) {
        }
        c cVar22 = new c(getContext());
        this.f819e = cVar22;
        cVar22.J(true);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-2, -1);
        eVar2.c(this.f819e, this.f817c);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.f819e.o(this);
        this.f818d = actionMenuView2;
        e0.b0.o0(actionMenuView2, null);
        addView(this.f818d, layoutParams2);
    }

    public boolean j() {
        return this.f665s;
    }

    public void k() {
        removeAllViews();
        this.f659m = null;
        this.f818d = null;
    }

    public boolean l() {
        c cVar = this.f819e;
        if (cVar != null) {
            return cVar.K();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f819e;
        if (cVar != null) {
            cVar.B();
            this.f819e.C();
        }
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.f656j);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        boolean b6 = j2.b(this);
        int paddingRight = b6 ? (i8 - i6) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i9 - i7) - getPaddingTop()) - getPaddingBottom();
        View view = this.f658l;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f658l.getLayoutParams();
            int i10 = b6 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i11 = b6 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int d6 = androidx.appcompat.widget.a.d(paddingRight, i10, b6);
            paddingRight = androidx.appcompat.widget.a.d(d6 + e(this.f658l, d6, paddingTop, paddingTop2, b6), i11, b6);
        }
        int i12 = paddingRight;
        LinearLayout linearLayout = this.f660n;
        if (linearLayout != null && this.f659m == null && linearLayout.getVisibility() != 8) {
            i12 += e(this.f660n, i12, paddingTop, paddingTop2, b6);
        }
        int i13 = i12;
        View view2 = this.f659m;
        if (view2 != null) {
            e(view2, i13, paddingTop, paddingTop2, b6);
        }
        int paddingLeft = b6 ? getPaddingLeft() : (i8 - i6) - getPaddingRight();
        ActionMenuView actionMenuView = this.f818d;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !b6);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        if (View.MeasureSpec.getMode(i6) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i7) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        } else {
            int size = View.MeasureSpec.getSize(i6);
            int i8 = this.f820f;
            if (i8 <= 0) {
                i8 = View.MeasureSpec.getSize(i7);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i9 = i8 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE);
            View view = this.f658l;
            if (view != null) {
                int c6 = c(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f658l.getLayoutParams();
                paddingLeft = c6 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f818d;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = c(this.f818d, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.f660n;
            if (linearLayout != null && this.f659m == null) {
                if (this.f665s) {
                    this.f660n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f660n.getMeasuredWidth();
                    boolean z5 = measuredWidth <= paddingLeft;
                    if (z5) {
                        paddingLeft -= measuredWidth;
                    }
                    this.f660n.setVisibility(z5 ? 0 : 8);
                } else {
                    paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.f659m;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i10 = layoutParams.width;
                int i11 = i10 != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (i10 >= 0) {
                    paddingLeft = Math.min(i10, paddingLeft);
                }
                int i12 = layoutParams.height;
                int i13 = i12 == -2 ? Integer.MIN_VALUE : 1073741824;
                if (i12 >= 0) {
                    i9 = Math.min(i12, i9);
                }
                this.f659m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i11), View.MeasureSpec.makeMeasureSpec(i9, i13));
            }
            if (this.f820f > 0) {
                setMeasuredDimension(size, i8);
                return;
            }
            int childCount = getChildCount();
            int i14 = 0;
            for (int i15 = 0; i15 < childCount; i15++) {
                int measuredHeight = getChildAt(i15).getMeasuredHeight() + paddingTop;
                if (measuredHeight > i14) {
                    i14 = measuredHeight;
                }
            }
            setMeasuredDimension(size, i14);
        }
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i6) {
        this.f820f = i6;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f659m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f659m = view;
        if (view != null && (linearLayout = this.f660n) != null) {
            removeView(linearLayout);
            this.f660n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f657k = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f656j = charSequence;
        i();
    }

    public void setTitleOptional(boolean z5) {
        if (z5 != this.f665s) {
            requestLayout();
        }
        this.f665s = z5;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i6) {
        super.setVisibility(i6);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        c2 v5 = c2.v(context, attributeSet, b.j.f2832y, i6, 0);
        e0.b0.o0(this, v5.g(b.j.f2837z));
        this.f663q = v5.n(b.j.D, 0);
        this.f664r = v5.n(b.j.C, 0);
        this.f820f = v5.m(b.j.B, 0);
        this.f666t = v5.n(b.j.A, b.g.abc_action_mode_close_item_material);
        v5.w();
    }
}
