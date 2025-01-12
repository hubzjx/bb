package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import e0.b0;
import f0.a0;
import f0.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements e0.s, e0.p {
    private static final a B = new a();
    private static final int[] C = {16843130};
    private b A;

    /* renamed from: b  reason: collision with root package name */
    private long f1609b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f1610c;

    /* renamed from: d  reason: collision with root package name */
    private OverScroller f1611d;

    /* renamed from: e  reason: collision with root package name */
    private EdgeEffect f1612e;

    /* renamed from: f  reason: collision with root package name */
    private EdgeEffect f1613f;

    /* renamed from: g  reason: collision with root package name */
    private int f1614g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1615h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1616i;

    /* renamed from: j  reason: collision with root package name */
    private View f1617j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1618k;

    /* renamed from: l  reason: collision with root package name */
    private VelocityTracker f1619l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1620m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1621n;

    /* renamed from: o  reason: collision with root package name */
    private int f1622o;

    /* renamed from: p  reason: collision with root package name */
    private int f1623p;

    /* renamed from: q  reason: collision with root package name */
    private int f1624q;

    /* renamed from: r  reason: collision with root package name */
    private int f1625r;

    /* renamed from: s  reason: collision with root package name */
    private final int[] f1626s;

    /* renamed from: t  reason: collision with root package name */
    private final int[] f1627t;

    /* renamed from: u  reason: collision with root package name */
    private int f1628u;

    /* renamed from: v  reason: collision with root package name */
    private int f1629v;

    /* renamed from: w  reason: collision with root package name */
    private c f1630w;

    /* renamed from: x  reason: collision with root package name */
    private final e0.t f1631x;

    /* renamed from: y  reason: collision with root package name */
    private final e0.q f1632y;

    /* renamed from: z  reason: collision with root package name */
    private float f1633z;

    /* loaded from: classes.dex */
    static class a extends e0.a {
        a() {
        }

        @Override // e0.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            a0.a(accessibilityEvent, nestedScrollView.getScrollX());
            a0.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // e0.a
        public void g(View view, y yVar) {
            int scrollRange;
            super.g(view, yVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            yVar.W(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            yVar.o0(true);
            if (nestedScrollView.getScrollY() > 0) {
                yVar.b(y.a.f9749r);
                yVar.b(y.a.C);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                yVar.b(y.a.f9748q);
                yVar.b(y.a.E);
            }
        }

        @Override // e0.a
        public boolean j(View view, int i6, Bundle bundle) {
            if (super.j(view, i6, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (nestedScrollView.isEnabled()) {
                if (i6 != 4096) {
                    if (i6 == 8192 || i6 == 16908344) {
                        int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                        if (max != nestedScrollView.getScrollY()) {
                            nestedScrollView.O(0, max, true);
                            return true;
                        }
                        return false;
                    } else if (i6 != 16908346) {
                        return false;
                    }
                }
                int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                if (min != nestedScrollView.getScrollY()) {
                    nestedScrollView.O(0, min, true);
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(NestedScrollView nestedScrollView, int i6, int i7, int i8, int i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f1634a;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public c[] newArray(int i6) {
                return new c[i6];
            }
        }

        c(Parcel parcel) {
            super(parcel);
            this.f1634a = parcel.readInt();
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f1634a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f1634a);
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    private static boolean A(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && A((View) parent, view2);
    }

    private boolean B(View view, int i6, int i7) {
        view.getDrawingRect(this.f1610c);
        offsetDescendantRectToMyCoords(view, this.f1610c);
        return this.f1610c.bottom + i6 >= getScrollY() && this.f1610c.top - i6 <= getScrollY() + i7;
    }

    private void C(int i6, int i7, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i6);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f1632y.e(0, scrollY2, 0, i6 - scrollY2, null, i7, iArr);
    }

    private void D(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1625r) {
            int i6 = actionIndex == 0 ? 1 : 0;
            this.f1614g = (int) motionEvent.getY(i6);
            this.f1625r = motionEvent.getPointerId(i6);
            VelocityTracker velocityTracker = this.f1619l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void G() {
        VelocityTracker velocityTracker = this.f1619l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1619l = null;
        }
    }

    private void H(boolean z5) {
        if (z5) {
            P(2, 1);
        } else {
            Q(1);
        }
        this.f1629v = getScrollY();
        b0.c0(this);
    }

    private boolean I(int i6, int i7, int i8) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i9 = height + scrollY;
        boolean z5 = false;
        boolean z6 = i6 == 33;
        View r5 = r(z6, i7, i8);
        if (r5 == null) {
            r5 = this;
        }
        if (i7 < scrollY || i8 > i9) {
            k(z6 ? i7 - scrollY : i8 - i9);
            z5 = true;
        }
        if (r5 != findFocus()) {
            r5.requestFocus(i6);
        }
        return z5;
    }

    private void J(View view) {
        view.getDrawingRect(this.f1610c);
        offsetDescendantRectToMyCoords(view, this.f1610c);
        int e6 = e(this.f1610c);
        if (e6 != 0) {
            scrollBy(0, e6);
        }
    }

    private boolean K(Rect rect, boolean z5) {
        int e6 = e(rect);
        boolean z6 = e6 != 0;
        if (z6) {
            if (z5) {
                scrollBy(0, e6);
            } else {
                L(0, e6);
            }
        }
        return z6;
    }

    private void M(int i6, int i7, int i8, boolean z5) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f1609b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int scrollY = getScrollY();
            OverScroller overScroller = this.f1611d;
            int scrollX = getScrollX();
            overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i7 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i8);
            H(z5);
        } else {
            if (!this.f1611d.isFinished()) {
                a();
            }
            scrollBy(i6, i7);
        }
        this.f1609b = AnimationUtils.currentAnimationTimeMillis();
    }

    private void a() {
        this.f1611d.abortAnimation();
        Q(1);
    }

    private boolean c() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
        }
        return false;
    }

    private static int d(int i6, int i7, int i8) {
        if (i7 >= i8 || i6 < 0) {
            return 0;
        }
        return i7 + i6 > i8 ? i8 - i7 : i6;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1633z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f1633z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f1633z;
    }

    private void k(int i6) {
        if (i6 != 0) {
            if (this.f1621n) {
                L(0, i6);
            } else {
                scrollBy(0, i6);
            }
        }
    }

    private void l() {
        this.f1618k = false;
        G();
        Q(0);
        EdgeEffect edgeEffect = this.f1612e;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f1613f.onRelease();
        }
    }

    private void p() {
        if (getOverScrollMode() == 2) {
            this.f1612e = null;
            this.f1613f = null;
        } else if (this.f1612e == null) {
            Context context = getContext();
            this.f1612e = new EdgeEffect(context);
            this.f1613f = new EdgeEffect(context);
        }
    }

    private View r(boolean z5, int i6, int i7) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z6 = false;
        for (int i8 = 0; i8 < size; i8++) {
            View view2 = focusables.get(i8);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i6 < bottom && top < i7) {
                boolean z7 = i6 < top && bottom < i7;
                if (view == null) {
                    view = view2;
                    z6 = z7;
                } else {
                    boolean z8 = (z5 && top < view.getTop()) || (!z5 && bottom > view.getBottom());
                    if (z6) {
                        if (z7) {
                            if (!z8) {
                            }
                            view = view2;
                        }
                    } else if (z7) {
                        view = view2;
                        z6 = true;
                    } else {
                        if (!z8) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private boolean v(int i6, int i7) {
        if (getChildCount() > 0) {
            int scrollY = getScrollY();
            View childAt = getChildAt(0);
            return i7 >= childAt.getTop() - scrollY && i7 < childAt.getBottom() - scrollY && i6 >= childAt.getLeft() && i6 < childAt.getRight();
        }
        return false;
    }

    private void w() {
        VelocityTracker velocityTracker = this.f1619l;
        if (velocityTracker == null) {
            this.f1619l = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void x() {
        this.f1611d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1622o = viewConfiguration.getScaledTouchSlop();
        this.f1623p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1624q = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void y() {
        if (this.f1619l == null) {
            this.f1619l = VelocityTracker.obtain();
        }
    }

    private boolean z(View view) {
        return !B(view, 0, getHeight());
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean E(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, boolean z5) {
        boolean z6;
        boolean z7;
        int overScrollMode = getOverScrollMode();
        boolean z8 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z9 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z10 = overScrollMode == 0 || (overScrollMode == 1 && z8);
        boolean z11 = overScrollMode == 0 || (overScrollMode == 1 && z9);
        int i14 = i8 + i6;
        int i15 = !z10 ? 0 : i12;
        int i16 = i9 + i7;
        int i17 = !z11 ? 0 : i13;
        int i18 = -i15;
        int i19 = i15 + i10;
        int i20 = -i17;
        int i21 = i17 + i11;
        if (i14 > i19) {
            i14 = i19;
        } else if (i14 >= i18) {
            z6 = false;
            if (i16 <= i21) {
                i16 = i21;
            } else if (i16 >= i20) {
                z7 = false;
                if (z7 && !u(1)) {
                    this.f1611d.springBack(i14, i16, 0, 0, 0, getScrollRange());
                }
                onOverScrolled(i14, i16, z6, z7);
                return !z6 || z7;
            } else {
                i16 = i20;
            }
            z7 = true;
            if (z7) {
                this.f1611d.springBack(i14, i16, 0, 0, 0, getScrollRange());
            }
            onOverScrolled(i14, i16, z6, z7);
            if (z6) {
            }
        } else {
            i14 = i18;
        }
        z6 = true;
        if (i16 <= i21) {
        }
        z7 = true;
        if (z7) {
        }
        onOverScrolled(i14, i16, z6, z7);
        if (z6) {
        }
    }

    public boolean F(int i6) {
        boolean z5 = i6 == 130;
        int height = getHeight();
        if (z5) {
            this.f1610c.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f1610c;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f1610c.top = getScrollY() - height;
            Rect rect2 = this.f1610c;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f1610c;
        int i7 = rect3.top;
        int i8 = height + i7;
        rect3.bottom = i8;
        return I(i6, i7, i8);
    }

    public final void L(int i6, int i7) {
        M(i6, i7, 250, false);
    }

    void N(int i6, int i7, int i8, boolean z5) {
        M(i6 - getScrollX(), i7 - getScrollY(), i8, z5);
    }

    void O(int i6, int i7, boolean z5) {
        N(i6, i7, 250, z5);
    }

    public boolean P(int i6, int i7) {
        return this.f1632y.p(i6, i7);
    }

    public void Q(int i6) {
        this.f1632y.r(i6);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public boolean b(int i6) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i6);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !B(findNextFocus, maxScrollAmount, getHeight())) {
            if (i6 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i6 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i6 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            k(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f1610c);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1610c);
            k(e(this.f1610c));
            findNextFocus.requestFocus(i6);
        }
        if (findFocus != null && findFocus.isFocused() && z(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
            return true;
        }
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        EdgeEffect edgeEffect;
        if (this.f1611d.isFinished()) {
            return;
        }
        this.f1611d.computeScrollOffset();
        int currY = this.f1611d.getCurrY();
        int i6 = currY - this.f1629v;
        this.f1629v = currY;
        int[] iArr = this.f1627t;
        boolean z5 = false;
        iArr[1] = 0;
        f(0, i6, iArr, null, 1);
        int i7 = i6 - this.f1627t[1];
        int scrollRange = getScrollRange();
        if (i7 != 0) {
            int scrollY = getScrollY();
            E(0, i7, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i8 = i7 - scrollY2;
            int[] iArr2 = this.f1627t;
            iArr2[1] = 0;
            g(0, scrollY2, 0, i8, this.f1626s, 1, iArr2);
            i7 = i8 - this.f1627t[1];
        }
        if (i7 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z5 = true;
            }
            if (z5) {
                p();
                if (i7 < 0) {
                    if (this.f1612e.isFinished()) {
                        edgeEffect = this.f1612e;
                        edgeEffect.onAbsorb((int) this.f1611d.getCurrVelocity());
                    }
                } else if (this.f1613f.isFinished()) {
                    edgeEffect = this.f1613f;
                    edgeEffect.onAbsorb((int) this.f1611d.getCurrVelocity());
                }
            }
            a();
        }
        if (this.f1611d.isFinished()) {
            Q(1);
        } else {
            b0.c0(this);
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || q(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f6, float f7, boolean z5) {
        return this.f1632y.a(f6, f7, z5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f6, float f7) {
        return this.f1632y.b(f6, f7);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i6, int i7, int[] iArr, int[] iArr2) {
        return f(i6, i7, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i6, int i7, int i8, int i9, int[] iArr) {
        return this.f1632y.f(i6, i7, i8, i9, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i6;
        super.draw(canvas);
        if (this.f1612e != null) {
            int scrollY = getScrollY();
            int i7 = 0;
            if (!this.f1612e.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i6 = getPaddingLeft() + 0;
                } else {
                    i6 = 0;
                }
                if (getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate(i6, min);
                this.f1612e.setSize(width, height);
                if (this.f1612e.draw(canvas)) {
                    b0.c0(this);
                }
                canvas.restoreToCount(save);
            }
            if (this.f1613f.isFinished()) {
                return;
            }
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i7 = 0 + getPaddingLeft();
            }
            if (getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate(i7 - width2, max);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f1613f.setSize(width2, height2);
            if (this.f1613f.draw(canvas)) {
                b0.c0(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    protected int e(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i6 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i7 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i6 - verticalFadingEdgeLength : i6;
        int i8 = rect.bottom;
        if (i8 > i7 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i7) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i6);
        } else if (rect.top >= scrollY || i8 >= i7) {
            return 0;
        } else {
            return Math.max(rect.height() > height ? 0 - (i7 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
    }

    public boolean f(int i6, int i7, int[] iArr, int[] iArr2, int i8) {
        return this.f1632y.d(i6, i7, iArr, iArr2, i8);
    }

    public void g(int i6, int i7, int i8, int i9, int[] iArr, int i10, int[] iArr2) {
        this.f1632y.e(i6, i7, i8, i9, iArr, i10, iArr2);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f1631x.a();
    }

    int getScrollRange() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        }
        return 0;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // e0.r
    public void h(View view, View view2, int i6, int i7) {
        this.f1631x.c(view, view2, i6, i7);
        P(2, i7);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return u(0);
    }

    @Override // e0.r
    public void i(View view, int i6) {
        this.f1631x.d(view, i6);
        Q(i6);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f1632y.l();
    }

    @Override // e0.r
    public void j(View view, int i6, int i7, int[] iArr, int i8) {
        f(i6, i7, iArr, null, i8);
    }

    @Override // e0.s
    public void m(View view, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
        C(i9, i10, iArr);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i6, int i7) {
        view.measure(ViewGroup.getChildMeasureSpec(i6, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i6, int i7, int i8, int i9) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i6, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i7, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // e0.r
    public void n(View view, int i6, int i7, int i8, int i9, int i10) {
        C(i9, i10, null);
    }

    @Override // e0.r
    public boolean o(View view, View view2, int i6, int i7) {
        return (i6 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1616i = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f1618k) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int verticalScrollFactorCompat = scrollY - ((int) (axisValue * getVerticalScrollFactorCompat()));
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f1618k) {
            return true;
        }
        int i6 = action & 255;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 == 2) {
                    int i7 = this.f1625r;
                    if (i7 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i7);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i7 + " in onInterceptTouchEvent");
                        } else {
                            int y5 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y5 - this.f1614g) > this.f1622o && (2 & getNestedScrollAxes()) == 0) {
                                this.f1618k = true;
                                this.f1614g = y5;
                                y();
                                this.f1619l.addMovement(motionEvent);
                                this.f1628u = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i6 != 3) {
                    if (i6 == 6) {
                        D(motionEvent);
                    }
                }
            }
            this.f1618k = false;
            this.f1625r = -1;
            G();
            if (this.f1611d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                b0.c0(this);
            }
            Q(0);
        } else {
            int y6 = (int) motionEvent.getY();
            if (v((int) motionEvent.getX(), y6)) {
                this.f1614g = y6;
                this.f1625r = motionEvent.getPointerId(0);
                w();
                this.f1619l.addMovement(motionEvent);
                this.f1611d.computeScrollOffset();
                this.f1618k = !this.f1611d.isFinished();
                P(2, 0);
            } else {
                this.f1618k = false;
                G();
            }
        }
        return this.f1618k;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        int i10 = 0;
        this.f1615h = false;
        View view = this.f1617j;
        if (view != null && A(view, this)) {
            J(this.f1617j);
        }
        this.f1617j = null;
        if (!this.f1616i) {
            if (this.f1630w != null) {
                scrollTo(getScrollX(), this.f1630w.f1634a);
                this.f1630w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i10 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i9 - i7) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int d6 = d(scrollY, paddingTop, i10);
            if (d6 != scrollY) {
                scrollTo(getScrollX(), d6);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1616i = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (this.f1620m && View.MeasureSpec.getMode(i7) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i6, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f6, float f7, boolean z5) {
        if (z5) {
            return false;
        }
        dispatchNestedFling(0.0f, f7, true);
        s((int) f7);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f6, float f7) {
        return dispatchNestedPreFling(f6, f7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i6, int i7, int[] iArr) {
        j(view, i6, i7, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i6, int i7, int i8, int i9) {
        C(i9, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i6) {
        h(view, view2, i6, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i6, int i7, boolean z5, boolean z6) {
        super.scrollTo(i6, i7);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i6, Rect rect) {
        if (i6 == 2) {
            i6 = 130;
        } else if (i6 == 1) {
            i6 = 33;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        View findNextFocus = rect == null ? focusFinder.findNextFocus(this, null, i6) : focusFinder.findNextFocusFromRect(this, rect, i6);
        if (findNextFocus == null || z(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i6, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.f1630w = cVar;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f1634a = getScrollY();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i6, int i7, int i8, int i9) {
        super.onScrollChanged(i6, i7, i8, i9);
        b bVar = this.A;
        if (bVar != null) {
            bVar.a(this, i6, i7, i8, i9);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !B(findFocus, 0, i9)) {
            return;
        }
        findFocus.getDrawingRect(this.f1610c);
        offsetDescendantRectToMyCoords(findFocus, this.f1610c);
        k(e(this.f1610c));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i6) {
        return o(view, view2, i6, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
        if (r23.f1611d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
        e0.b0.c0(r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x020e, code lost:
        if (r23.f1611d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L29;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        EdgeEffect edgeEffect;
        EdgeEffect edgeEffect2;
        y();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1628u = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.f1628u);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f1619l;
                velocityTracker.computeCurrentVelocity(1000, this.f1624q);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f1625r);
                if (Math.abs(yVelocity) >= this.f1623p) {
                    int i6 = -yVelocity;
                    float f6 = i6;
                    if (!dispatchNestedPreFling(0.0f, f6)) {
                        dispatchNestedFling(0.0f, f6, true);
                        s(i6);
                    }
                }
                this.f1625r = -1;
                l();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f1625r);
                if (findPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f1625r + " in onTouchEvent");
                } else {
                    int y5 = (int) motionEvent.getY(findPointerIndex);
                    int i7 = this.f1614g - y5;
                    if (!this.f1618k && Math.abs(i7) > this.f1622o) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1618k = true;
                        int i8 = this.f1622o;
                        i7 = i7 > 0 ? i7 - i8 : i7 + i8;
                    }
                    int i9 = i7;
                    if (this.f1618k) {
                        if (f(0, i9, this.f1627t, this.f1626s, 0)) {
                            i9 -= this.f1627t[1];
                            this.f1628u += this.f1626s[1];
                        }
                        int i10 = i9;
                        this.f1614g = y5 - this.f1626s[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z5 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (E(0, i10, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !u(0)) {
                            this.f1619l.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.f1627t;
                        iArr[1] = 0;
                        g(0, scrollY2, 0, i10 - scrollY2, this.f1626s, 0, iArr);
                        int i11 = this.f1614g;
                        int i12 = this.f1626s[1];
                        this.f1614g = i11 - i12;
                        this.f1628u += i12;
                        if (z5) {
                            int i13 = i10 - this.f1627t[1];
                            p();
                            int i14 = scrollY + i13;
                            if (i14 < 0) {
                                e.a(this.f1612e, i13 / getHeight(), motionEvent.getX(findPointerIndex) / getWidth());
                                if (!this.f1613f.isFinished()) {
                                    edgeEffect = this.f1613f;
                                    edgeEffect.onRelease();
                                }
                                edgeEffect2 = this.f1612e;
                                if (edgeEffect2 != null && (!edgeEffect2.isFinished() || !this.f1613f.isFinished())) {
                                    b0.c0(this);
                                }
                            } else {
                                if (i14 > scrollRange) {
                                    e.a(this.f1613f, i13 / getHeight(), 1.0f - (motionEvent.getX(findPointerIndex) / getWidth()));
                                    if (!this.f1612e.isFinished()) {
                                        edgeEffect = this.f1612e;
                                        edgeEffect.onRelease();
                                    }
                                }
                                edgeEffect2 = this.f1612e;
                                if (edgeEffect2 != null) {
                                    b0.c0(this);
                                }
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f1618k) {
                    if (getChildCount() > 0) {
                    }
                }
                this.f1625r = -1;
                l();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f1614g = (int) motionEvent.getY(actionIndex);
                this.f1625r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                D(motionEvent);
                this.f1614g = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f1625r));
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            boolean z6 = !this.f1611d.isFinished();
            this.f1618k = z6;
            if (z6 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f1611d.isFinished()) {
                a();
            }
            this.f1614g = (int) motionEvent.getY();
            this.f1625r = motionEvent.getPointerId(0);
            P(2, 0);
        }
        VelocityTracker velocityTracker2 = this.f1619l;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public boolean q(KeyEvent keyEvent) {
        this.f1610c.setEmpty();
        if (!c()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        } else if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                return !keyEvent.isAltPressed() ? b(33) : t(33);
            } else if (keyCode == 20) {
                return !keyEvent.isAltPressed() ? b(130) : t(130);
            } else if (keyCode != 62) {
                return false;
            } else {
                F(keyEvent.isShiftPressed() ? 33 : 130);
                return false;
            }
        } else {
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f1615h) {
            this.f1617j = view2;
        } else {
            J(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z5) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return K(rect, z5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z5) {
        if (z5) {
            G();
        }
        super.requestDisallowInterceptTouchEvent(z5);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f1615h = true;
        super.requestLayout();
    }

    public void s(int i6) {
        if (getChildCount() > 0) {
            this.f1611d.fling(getScrollX(), getScrollY(), 0, i6, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            H(true);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i6, int i7) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int d6 = d(i6, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int d7 = d(i7, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (d6 == getScrollX() && d7 == getScrollY()) {
                return;
            }
            super.scrollTo(d6, d7);
        }
    }

    public void setFillViewport(boolean z5) {
        if (z5 != this.f1620m) {
            this.f1620m = z5;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z5) {
        this.f1632y.m(z5);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.A = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z5) {
        this.f1621n = z5;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i6) {
        return P(i6, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        Q(0);
    }

    public boolean t(int i6) {
        int childCount;
        boolean z5 = i6 == 130;
        int height = getHeight();
        Rect rect = this.f1610c;
        rect.top = 0;
        rect.bottom = height;
        if (z5 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f1610c.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f1610c;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f1610c;
        return I(i6, rect3.top, rect3.bottom);
    }

    public boolean u(int i6) {
        return this.f1632y.k(i6);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i6);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1610c = new Rect();
        this.f1615h = true;
        this.f1616i = false;
        this.f1617j = null;
        this.f1618k = false;
        this.f1621n = true;
        this.f1625r = -1;
        this.f1626s = new int[2];
        this.f1627t = new int[2];
        x();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C, i6, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1631x = new e0.t(this);
        this.f1632y = new e0.q(this);
        setNestedScrollingEnabled(true);
        b0.l0(this, B);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i6, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }
}
