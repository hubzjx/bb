package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private boolean f646b;

    /* renamed from: c  reason: collision with root package name */
    private View f647c;

    /* renamed from: d  reason: collision with root package name */
    private View f648d;

    /* renamed from: e  reason: collision with root package name */
    private View f649e;

    /* renamed from: f  reason: collision with root package name */
    Drawable f650f;

    /* renamed from: g  reason: collision with root package name */
    Drawable f651g;

    /* renamed from: h  reason: collision with root package name */
    Drawable f652h;

    /* renamed from: i  reason: collision with root package name */
    boolean f653i;

    /* renamed from: j  reason: collision with root package name */
    boolean f654j;

    /* renamed from: k  reason: collision with root package name */
    private int f655k;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e0.b0.o0(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.j.f2712a);
        this.f650f = obtainStyledAttributes.getDrawable(b.j.f2717b);
        this.f651g = obtainStyledAttributes.getDrawable(b.j.f2727d);
        this.f655k = obtainStyledAttributes.getDimensionPixelSize(b.j.f2757j, -1);
        boolean z5 = true;
        if (getId() == b.f.split_action_bar) {
            this.f653i = true;
            this.f652h = obtainStyledAttributes.getDrawable(b.j.f2722c);
        }
        obtainStyledAttributes.recycle();
        if (!this.f653i ? this.f650f != null || this.f651g != null : this.f652h != null) {
            z5 = false;
        }
        setWillNotDraw(z5);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f650f;
        if (drawable != null && drawable.isStateful()) {
            this.f650f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f651g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f651g.setState(getDrawableState());
        }
        Drawable drawable3 = this.f652h;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f652h.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f647c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f650f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f651g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f652h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f648d = findViewById(b.f.action_bar);
        this.f649e = findViewById(b.f.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f646b || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        Drawable drawable;
        Drawable drawable2;
        int left;
        int top;
        int right;
        View view;
        super.onLayout(z5, i6, i7, i8, i9);
        View view2 = this.f647c;
        boolean z6 = true;
        boolean z7 = false;
        boolean z8 = (view2 == null || view2.getVisibility() == 8) ? false : true;
        if (view2 != null && view2.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            int i10 = ((FrameLayout.LayoutParams) view2.getLayoutParams()).bottomMargin;
            view2.layout(i6, (measuredHeight - view2.getMeasuredHeight()) - i10, i8, measuredHeight - i10);
        }
        if (this.f653i) {
            Drawable drawable3 = this.f652h;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z6 = false;
            }
        } else {
            if (this.f650f != null) {
                if (this.f648d.getVisibility() == 0) {
                    drawable2 = this.f650f;
                    left = this.f648d.getLeft();
                    top = this.f648d.getTop();
                    right = this.f648d.getRight();
                    view = this.f648d;
                } else {
                    View view3 = this.f649e;
                    if (view3 == null || view3.getVisibility() != 0) {
                        this.f650f.setBounds(0, 0, 0, 0);
                        z7 = true;
                    } else {
                        drawable2 = this.f650f;
                        left = this.f649e.getLeft();
                        top = this.f649e.getTop();
                        right = this.f649e.getRight();
                        view = this.f649e;
                    }
                }
                drawable2.setBounds(left, top, right, view.getBottom());
                z7 = true;
            }
            this.f654j = z8;
            if (!z8 || (drawable = this.f651g) == null) {
                z6 = z7;
            } else {
                drawable.setBounds(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            }
        }
        if (z6) {
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i6, int i7) {
        int i8;
        View view;
        int i9;
        if (this.f648d == null && View.MeasureSpec.getMode(i7) == Integer.MIN_VALUE && (i9 = this.f655k) >= 0) {
            i7 = View.MeasureSpec.makeMeasureSpec(Math.min(i9, View.MeasureSpec.getSize(i7)), Integer.MIN_VALUE);
        }
        super.onMeasure(i6, i7);
        if (this.f648d == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i7);
        View view2 = this.f647c;
        if (view2 == null || view2.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!b(this.f648d)) {
            view = this.f648d;
        } else if (b(this.f649e)) {
            i8 = 0;
            setMeasuredDimension(getMeasuredWidth(), Math.min(i8 + a(this.f647c), mode != Integer.MIN_VALUE ? View.MeasureSpec.getSize(i7) : Integer.MAX_VALUE));
        } else {
            view = this.f649e;
        }
        i8 = a(view);
        setMeasuredDimension(getMeasuredWidth(), Math.min(i8 + a(this.f647c), mode != Integer.MIN_VALUE ? View.MeasureSpec.getSize(i7) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f650f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f650f);
        }
        this.f650f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f648d;
            if (view != null) {
                this.f650f.setBounds(view.getLeft(), this.f648d.getTop(), this.f648d.getRight(), this.f648d.getBottom());
            }
        }
        boolean z5 = true;
        if (!this.f653i ? this.f650f != null || this.f651g != null : this.f652h != null) {
            z5 = false;
        }
        setWillNotDraw(z5);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f652h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f652h);
        }
        this.f652h = drawable;
        boolean z5 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f653i && (drawable2 = this.f652h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f653i ? !(this.f650f != null || this.f651g != null) : this.f652h == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f651g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f651g);
        }
        this.f651g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f654j && (drawable2 = this.f651g) != null) {
                drawable2.setBounds(this.f647c.getLeft(), this.f647c.getTop(), this.f647c.getRight(), this.f647c.getBottom());
            }
        }
        boolean z5 = true;
        if (!this.f653i ? this.f650f != null || this.f651g != null : this.f652h != null) {
            z5 = false;
        }
        setWillNotDraw(z5);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(w1 w1Var) {
        View view = this.f647c;
        if (view != null) {
            removeView(view);
        }
        this.f647c = w1Var;
    }

    public void setTransitioning(boolean z5) {
        this.f646b = z5;
        setDescendantFocusability(z5 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        boolean z5 = i6 == 0;
        Drawable drawable = this.f650f;
        if (drawable != null) {
            drawable.setVisible(z5, false);
        }
        Drawable drawable2 = this.f651g;
        if (drawable2 != null) {
            drawable2.setVisible(z5, false);
        }
        Drawable drawable3 = this.f652h;
        if (drawable3 != null) {
            drawable3.setVisible(z5, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f650f && !this.f653i) || (drawable == this.f651g && this.f654j) || ((drawable == this.f652h && this.f653i) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i6) {
        if (i6 != 0) {
            return super.startActionModeForChild(view, callback, i6);
        }
        return null;
    }
}
