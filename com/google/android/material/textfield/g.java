package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.n1;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class g extends androidx.appcompat.widget.d {

    /* renamed from: e  reason: collision with root package name */
    private final n1 f5471e;

    /* renamed from: f  reason: collision with root package name */
    private final AccessibilityManager f5472f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f5473g;

    /* loaded from: classes.dex */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
            g gVar = g.this;
            g.this.e(i6 < 0 ? gVar.f5471e.v() : gVar.getAdapter().getItem(i6));
            AdapterView.OnItemClickListener onItemClickListener = g.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i6 < 0) {
                    view = g.this.f5471e.y();
                    i6 = g.this.f5471e.x();
                    j6 = g.this.f5471e.w();
                }
                onItemClickListener.onItemClick(g.this.f5471e.g(), view, i6, j6);
            }
            g.this.f5471e.dismiss();
        }
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, u2.a.f13431a);
    }

    private TextInputLayout c() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private int d() {
        ListAdapter adapter = getAdapter();
        TextInputLayout c6 = c();
        int i6 = 0;
        if (adapter == null || c6 == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.f5471e.x()) + 15);
        View view = null;
        int i7 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i6) {
                view = null;
                i6 = itemViewType;
            }
            view = adapter.getView(max, view, c6);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i7 = Math.max(i7, view.getMeasuredWidth());
        }
        Drawable f6 = this.f5471e.f();
        if (f6 != null) {
            f6.getPadding(this.f5473g);
            Rect rect = this.f5473g;
            i7 += rect.left + rect.right;
        }
        return i7 + c6.getEndIconView().getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout c6 = c();
        return (c6 == null || !c6.O()) ? super.getHint() : c6.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout c6 = c();
        if (c6 != null && c6.O() && super.getHint() == null && com.google.android.material.internal.e.a()) {
            setHint(HttpUrl.FRAGMENT_ENCODE_SET);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (View.MeasureSpec.getMode(i6) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), d()), View.MeasureSpec.getSize(i6)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t5) {
        super.setAdapter(t5);
        this.f5471e.p(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f5472f;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f5471e.a();
        }
    }

    public g(Context context, AttributeSet attributeSet, int i6) {
        super(i3.a.c(context, attributeSet, i6, 0), attributeSet, i6);
        this.f5473g = new Rect();
        Context context2 = getContext();
        TypedArray h6 = com.google.android.material.internal.j.h(context2, attributeSet, u2.j.O1, i6, u2.i.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int i7 = u2.j.P1;
        if (h6.hasValue(i7) && h6.getInt(i7, 0) == 0) {
            setKeyListener(null);
        }
        this.f5472f = (AccessibilityManager) context2.getSystemService("accessibility");
        n1 n1Var = new n1(context2);
        this.f5471e = n1Var;
        n1Var.J(true);
        n1Var.D(this);
        n1Var.I(2);
        n1Var.p(getAdapter());
        n1Var.L(new a());
        h6.recycle();
    }
}
