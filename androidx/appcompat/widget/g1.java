package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g1 extends ListView {

    /* renamed from: b  reason: collision with root package name */
    private final Rect f903b;

    /* renamed from: c  reason: collision with root package name */
    private int f904c;

    /* renamed from: d  reason: collision with root package name */
    private int f905d;

    /* renamed from: e  reason: collision with root package name */
    private int f906e;

    /* renamed from: f  reason: collision with root package name */
    private int f907f;

    /* renamed from: g  reason: collision with root package name */
    private int f908g;

    /* renamed from: h  reason: collision with root package name */
    private Field f909h;

    /* renamed from: i  reason: collision with root package name */
    private a f910i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f911j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f912k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f913l;

    /* renamed from: m  reason: collision with root package name */
    private e0.r0 f914m;

    /* renamed from: n  reason: collision with root package name */
    private androidx.core.widget.g f915n;

    /* renamed from: o  reason: collision with root package name */
    b f916o;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends f.d {

        /* renamed from: c  reason: collision with root package name */
        private boolean f917c;

        a(Drawable drawable) {
            super(drawable);
            this.f917c = true;
        }

        void c(boolean z5) {
            this.f917c = z5;
        }

        @Override // f.d, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f917c) {
                super.draw(canvas);
            }
        }

        @Override // f.d, android.graphics.drawable.Drawable
        public void setHotspot(float f6, float f7) {
            if (this.f917c) {
                super.setHotspot(f6, f7);
            }
        }

        @Override // f.d, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i6, int i7, int i8, int i9) {
            if (this.f917c) {
                super.setHotspotBounds(i6, i7, i8, i9);
            }
        }

        @Override // f.d, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f917c) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // f.d, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z5, boolean z6) {
            if (this.f917c) {
                return super.setVisible(z5, z6);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        public void a() {
            g1 g1Var = g1.this;
            g1Var.f916o = null;
            g1Var.removeCallbacks(this);
        }

        public void b() {
            g1.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            g1 g1Var = g1.this;
            g1Var.f916o = null;
            g1Var.drawableStateChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1(Context context, boolean z5) {
        super(context, null, b.a.dropDownListViewStyle);
        this.f903b = new Rect();
        this.f904c = 0;
        this.f905d = 0;
        this.f906e = 0;
        this.f907f = 0;
        this.f912k = z5;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f909h = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e6) {
            e6.printStackTrace();
        }
    }

    private void a() {
        this.f913l = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f908g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        e0.r0 r0Var = this.f914m;
        if (r0Var != null) {
            r0Var.b();
            this.f914m = null;
        }
    }

    private void b(View view, int i6) {
        performItemClick(view, i6, getItemIdAtPosition(i6));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.f903b.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f903b);
        selector.draw(canvas);
    }

    private void f(int i6, View view) {
        Rect rect = this.f903b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f904c;
        rect.top -= this.f905d;
        rect.right += this.f906e;
        rect.bottom += this.f907f;
        try {
            boolean z5 = this.f909h.getBoolean(this);
            if (view.isEnabled() != z5) {
                this.f909h.set(this, Boolean.valueOf(!z5));
                if (i6 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
        }
    }

    private void g(int i6, View view) {
        Drawable selector = getSelector();
        boolean z5 = (selector == null || i6 == -1) ? false : true;
        if (z5) {
            selector.setVisible(false, false);
        }
        f(i6, view);
        if (z5) {
            Rect rect = this.f903b;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            x.b.k(selector, exactCenterX, exactCenterY);
        }
    }

    private void h(int i6, View view, float f6, float f7) {
        g(i6, view);
        Drawable selector = getSelector();
        if (selector == null || i6 == -1) {
            return;
        }
        x.b.k(selector, f6, f7);
    }

    private void i(View view, int i6, float f6, float f7) {
        View childAt;
        this.f913l = true;
        drawableHotspotChanged(f6, f7);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i7 = this.f908g;
        if (i7 != -1 && (childAt = getChildAt(i7 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f908g = i6;
        view.drawableHotspotChanged(f6 - view.getLeft(), f7 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i6, view, f6, f7);
        j(false);
        refreshDrawableState();
    }

    private void j(boolean z5) {
        a aVar = this.f910i;
        if (aVar != null) {
            aVar.c(z5);
        }
    }

    private boolean k() {
        return this.f913l;
    }

    private void l() {
        Drawable selector = getSelector();
        if (selector != null && k() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public int d(int i6, int i7, int i8, int i9, int i10) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int i11 = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return i11;
        }
        dividerHeight = (dividerHeight <= 0 || divider == null) ? 0 : 0;
        int count = adapter.getCount();
        View view = null;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < count) {
            int itemViewType = adapter.getItemViewType(i12);
            if (itemViewType != i13) {
                view = null;
                i13 = itemViewType;
            }
            view = adapter.getView(i12, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i15 = layoutParams.height;
            view.measure(i6, i15 > 0 ? View.MeasureSpec.makeMeasureSpec(i15, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i12 > 0) {
                i11 += dividerHeight;
            }
            i11 += view.getMeasuredHeight();
            if (i11 >= i9) {
                return (i10 < 0 || i12 <= i10 || i14 <= 0 || i11 == i9) ? i9 : i14;
            }
            if (i10 >= 0 && i12 >= i10) {
                i14 = i11;
            }
            i12++;
        }
        return i11;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f916o != null) {
            return;
        }
        super.drawableStateChanged();
        j(true);
        l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
        if (r0 != 3) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(MotionEvent motionEvent, int i6) {
        boolean z5;
        boolean z6;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            z5 = false;
        } else if (actionMasked == 2) {
            z5 = true;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i6);
        if (findPointerIndex >= 0) {
            int x5 = (int) motionEvent.getX(findPointerIndex);
            int y5 = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x5, y5);
            if (pointToPosition != -1) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                i(childAt, pointToPosition, x5, y5);
                if (actionMasked == 1) {
                    b(childAt, pointToPosition);
                }
                z6 = false;
                z5 = true;
                if (z5) {
                }
                a();
                if (z5) {
                }
                return z5;
            }
            z6 = true;
            if (z5 || z6) {
                a();
            }
            if (z5) {
                if (this.f915n == null) {
                    this.f915n = new androidx.core.widget.g(this);
                }
                this.f915n.m(true);
                this.f915n.onTouch(this, motionEvent);
            } else {
                androidx.core.widget.g gVar = this.f915n;
                if (gVar != null) {
                    gVar.m(false);
                }
            }
            return z5;
        }
        z6 = false;
        z5 = false;
        if (z5) {
        }
        a();
        if (z5) {
        }
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f912k || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f912k || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f912k || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f912k && this.f911j) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f916o = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f916o == null) {
            b bVar = new b();
            this.f916o = bVar;
            bVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                l();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f908g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.f916o;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z5) {
        this.f911j = z5;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.f910i = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f904c = rect.left;
        this.f905d = rect.top;
        this.f906e = rect.right;
        this.f907f = rect.bottom;
    }
}
