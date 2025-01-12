package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    protected final C0011a f816b;

    /* renamed from: c  reason: collision with root package name */
    protected final Context f817c;

    /* renamed from: d  reason: collision with root package name */
    protected ActionMenuView f818d;

    /* renamed from: e  reason: collision with root package name */
    protected c f819e;

    /* renamed from: f  reason: collision with root package name */
    protected int f820f;

    /* renamed from: g  reason: collision with root package name */
    protected e0.r0 f821g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f822h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f823i;

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class C0011a implements e0.s0 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f824a = false;

        /* renamed from: b  reason: collision with root package name */
        int f825b;

        protected C0011a() {
        }

        @Override // e0.s0
        public void a(View view) {
            this.f824a = true;
        }

        @Override // e0.s0
        public void b(View view) {
            if (this.f824a) {
                return;
            }
            a aVar = a.this;
            aVar.f821g = null;
            a.super.setVisibility(this.f825b);
        }

        @Override // e0.s0
        public void c(View view) {
            a.super.setVisibility(0);
            this.f824a = false;
        }

        public C0011a d(e0.r0 r0Var, int i6) {
            a.this.f821g = r0Var;
            this.f825b = i6;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f816b = new C0011a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(b.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f817c = context;
        } else {
            this.f817c = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int d(int i6, int i7, boolean z5) {
        return z5 ? i6 - i7 : i6 + i7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(View view, int i6, int i7, int i8) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE), i7);
        return Math.max(0, (i6 - view.getMeasuredWidth()) - i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(View view, int i6, int i7, int i8, boolean z5) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i9 = i7 + ((i8 - measuredHeight) / 2);
        if (z5) {
            view.layout(i6 - measuredWidth, i9, i6, measuredHeight + i9);
        } else {
            view.layout(i6, i9, i6 + measuredWidth, measuredHeight + i9);
        }
        return z5 ? -measuredWidth : measuredWidth;
    }

    public e0.r0 f(int i6, long j6) {
        e0.r0 a6;
        e0.r0 r0Var = this.f821g;
        if (r0Var != null) {
            r0Var.b();
        }
        if (i6 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            a6 = e0.b0.d(this).a(1.0f);
        } else {
            a6 = e0.b0.d(this).a(0.0f);
        }
        a6.d(j6);
        a6.f(this.f816b.d(a6, i6));
        return a6;
    }

    public int getAnimatedVisibility() {
        return this.f821g != null ? this.f816b.f825b : getVisibility();
    }

    public int getContentHeight() {
        return this.f820f;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, b.j.f2712a, b.a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(b.j.f2757j, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.f819e;
        if (cVar != null) {
            cVar.F(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f823i = false;
        }
        if (!this.f823i) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f823i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f823i = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f822h = false;
        }
        if (!this.f822h) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f822h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f822h = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i6);

    @Override // android.view.View
    public void setVisibility(int i6) {
        if (i6 != getVisibility()) {
            e0.r0 r0Var = this.f821g;
            if (r0Var != null) {
                r0Var.b();
            }
            super.setVisibility(i6);
        }
    }
}
