package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.f2;
import androidx.appcompat.widget.j1;
import androidx.core.widget.v;
import e0.b0;
import f0.y;
/* loaded from: classes.dex */
public class NavigationMenuItemView extends d implements k.a {
    private static final int[] G = {16842912};
    private FrameLayout A;
    private androidx.appcompat.view.menu.g B;
    private ColorStateList C;
    private boolean D;
    private Drawable E;
    private final e0.a F;

    /* renamed from: w  reason: collision with root package name */
    private int f5230w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f5231x;

    /* renamed from: y  reason: collision with root package name */
    boolean f5232y;

    /* renamed from: z  reason: collision with root package name */
    private final CheckedTextView f5233z;

    /* loaded from: classes.dex */
    class a extends e0.a {
        a() {
        }

        @Override // e0.a
        public void g(View view, y yVar) {
            super.g(view, yVar);
            yVar.U(NavigationMenuItemView.this.f5232y);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B() {
        j1.a aVar;
        int i6;
        if (D()) {
            this.f5233z.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout == null) {
                return;
            }
            aVar = (j1.a) frameLayout.getLayoutParams();
            i6 = -1;
        } else {
            this.f5233z.setVisibility(0);
            FrameLayout frameLayout2 = this.A;
            if (frameLayout2 == null) {
                return;
            }
            aVar = (j1.a) frameLayout2.getLayoutParams();
            i6 = -2;
        }
        ((ViewGroup.MarginLayoutParams) aVar).width = i6;
        this.A.setLayoutParams(aVar);
    }

    private StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(b.a.f2710s, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(G, new ColorDrawable(typedValue.data));
            stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }

    private boolean D() {
        return this.B.getTitle() == null && this.B.getIcon() == null && this.B.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = (FrameLayout) ((ViewStub) findViewById(u2.e.design_menu_item_action_area_stub)).inflate();
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(androidx.appcompat.view.menu.g gVar, int i6) {
        this.B = gVar;
        if (gVar.getItemId() > 0) {
            setId(gVar.getItemId());
        }
        setVisibility(gVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            b0.o0(this, C());
        }
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setTitle(gVar.getTitle());
        setIcon(gVar.getIcon());
        setActionView(gVar.getActionView());
        setContentDescription(gVar.getContentDescription());
        f2.a(this, gVar.getTooltipText());
        B();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public androidx.appcompat.view.menu.g getItemData() {
        return this.B;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i6) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i6 + 1);
        androidx.appcompat.view.menu.g gVar = this.B;
        if (gVar != null && gVar.isCheckable() && this.B.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, G);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z5) {
        refreshDrawableState();
        if (this.f5232y != z5) {
            this.f5232y = z5;
            this.F.l(this.f5233z, 2048);
        }
    }

    public void setChecked(boolean z5) {
        refreshDrawableState();
        this.f5233z.setChecked(z5);
    }

    public void setHorizontalPadding(int i6) {
        setPadding(i6, 0, i6, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = x.b.r(drawable).mutate();
                x.b.o(drawable, this.C);
            }
            int i6 = this.f5230w;
            drawable.setBounds(0, 0, i6, i6);
        } else if (this.f5231x) {
            if (this.E == null) {
                Drawable b6 = v.f.b(getResources(), u2.d.navigation_empty_icon, getContext().getTheme());
                this.E = b6;
                if (b6 != null) {
                    int i7 = this.f5230w;
                    b6.setBounds(0, 0, i7, i7);
                }
            }
            drawable = this.E;
        }
        v.i(this.f5233z, drawable, null, null, null);
    }

    public void setIconPadding(int i6) {
        this.f5233z.setCompoundDrawablePadding(i6);
    }

    public void setIconSize(int i6) {
        this.f5230w = i6;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = colorStateList != null;
        androidx.appcompat.view.menu.g gVar = this.B;
        if (gVar != null) {
            setIcon(gVar.getIcon());
        }
    }

    public void setMaxLines(int i6) {
        this.f5233z.setMaxLines(i6);
    }

    public void setNeedsEmptyIcon(boolean z5) {
        this.f5231x = z5;
    }

    public void setTextAppearance(int i6) {
        v.n(this.f5233z, i6);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f5233z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f5233z.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        a aVar = new a();
        this.F = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(u2.g.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(u2.c.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(u2.e.design_menu_item_text);
        this.f5233z = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        b0.l0(checkedTextView, aVar);
    }
}
