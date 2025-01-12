package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.google.android.material.internal.j;
import e0.b0;
import f0.y;
import java.util.ArrayList;
import java.util.List;
import u2.i;
/* loaded from: classes.dex */
public class ChipGroup extends com.google.android.material.internal.c {

    /* renamed from: n  reason: collision with root package name */
    private static final int f5070n = i.Widget_MaterialComponents_ChipGroup;

    /* renamed from: f  reason: collision with root package name */
    private int f5071f;

    /* renamed from: g  reason: collision with root package name */
    private int f5072g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5073h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5074i;

    /* renamed from: j  reason: collision with root package name */
    private final b f5075j;

    /* renamed from: k  reason: collision with root package name */
    private e f5076k;

    /* renamed from: l  reason: collision with root package name */
    private int f5077l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5078m;

    /* loaded from: classes.dex */
    private class b implements CompoundButton.OnCheckedChangeListener {
        private b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
            if (ChipGroup.this.f5078m) {
                return;
            }
            if (ChipGroup.this.getCheckedChipIds().isEmpty() && ChipGroup.this.f5074i) {
                ChipGroup.this.r(compoundButton.getId(), true);
                ChipGroup.this.q(compoundButton.getId(), false);
                return;
            }
            int id = compoundButton.getId();
            if (!z5) {
                if (ChipGroup.this.f5077l == id) {
                    ChipGroup.this.setCheckedId(-1);
                    return;
                }
                return;
            }
            if (ChipGroup.this.f5077l != -1 && ChipGroup.this.f5077l != id && ChipGroup.this.f5073h) {
                ChipGroup chipGroup = ChipGroup.this;
                chipGroup.r(chipGroup.f5077l, false);
            }
            ChipGroup.this.setCheckedId(id);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ViewGroup.MarginLayoutParams {
        public c(int i6, int i7) {
            super(i6, i7);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    /* loaded from: classes.dex */
    private class e implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private ViewGroup.OnHierarchyChangeListener f5080b;

        private e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(b0.k());
                }
                Chip chip = (Chip) view2;
                if (chip.isChecked()) {
                    ((ChipGroup) view).m(chip.getId());
                }
                chip.setOnCheckedChangeListenerInternal(ChipGroup.this.f5075j);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f5080b;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f5080b;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, u2.a.chipGroupStyle);
    }

    private int getChipCount() {
        int i6 = 0;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            if (getChildAt(i7) instanceof Chip) {
                i6++;
            }
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i6, boolean z5) {
        this.f5077l = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i6, boolean z5) {
        View findViewById = findViewById(i6);
        if (findViewById instanceof Chip) {
            this.f5078m = true;
            ((Chip) findViewById).setChecked(z5);
            this.f5078m = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i6) {
        q(i6, true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i7 = this.f5077l;
                if (i7 != -1 && this.f5073h) {
                    r(i7, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i6, layoutParams);
    }

    @Override // com.google.android.material.internal.c
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof c);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        if (this.f5073h) {
            return this.f5077l;
        }
        return -1;
    }

    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.f5073h) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public int getChipSpacingHorizontal() {
        return this.f5071f;
    }

    public int getChipSpacingVertical() {
        return this.f5072g;
    }

    public void m(int i6) {
        int i7 = this.f5077l;
        if (i6 == i7) {
            return;
        }
        if (i7 != -1 && this.f5073h) {
            r(i7, false);
        }
        if (i6 != -1) {
            r(i6, true);
        }
        setCheckedId(i6);
    }

    public void n() {
        this.f5078m = true;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.f5078m = false;
        setCheckedId(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o(View view) {
        if (view instanceof Chip) {
            int i6 = 0;
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                if (getChildAt(i7) instanceof Chip) {
                    if (((Chip) getChildAt(i7)) == view) {
                        return i6;
                    }
                    i6++;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i6 = this.f5077l;
        if (i6 != -1) {
            r(i6, true);
            setCheckedId(this.f5077l);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        y.w0(accessibilityNodeInfo).Y(y.b.a(getRowCount(), c() ? getChipCount() : -1, false, p() ? 1 : 2));
    }

    public boolean p() {
        return this.f5073h;
    }

    public void setChipSpacing(int i6) {
        setChipSpacingHorizontal(i6);
        setChipSpacingVertical(i6);
    }

    public void setChipSpacingHorizontal(int i6) {
        if (this.f5071f != i6) {
            this.f5071f = i6;
            setItemSpacing(i6);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i6) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i6));
    }

    public void setChipSpacingResource(int i6) {
        setChipSpacing(getResources().getDimensionPixelOffset(i6));
    }

    public void setChipSpacingVertical(int i6) {
        if (this.f5072g != i6) {
            this.f5072g = i6;
            setLineSpacing(i6);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i6) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i6));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i6) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(d dVar) {
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f5076k.f5080b = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z5) {
        this.f5074i = z5;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i6) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i6) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int i6) {
        setSingleLine(getResources().getBoolean(i6));
    }

    public void setSingleSelection(int i6) {
        setSingleSelection(getResources().getBoolean(i6));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChipGroup(Context context, AttributeSet attributeSet, int i6) {
        super(i3.a.c(context, attributeSet, i6, r4), attributeSet, i6);
        int i7 = f5070n;
        this.f5075j = new b();
        this.f5076k = new e();
        this.f5077l = -1;
        this.f5078m = false;
        TypedArray h6 = j.h(getContext(), attributeSet, u2.j.G0, i6, i7, new int[0]);
        int dimensionPixelOffset = h6.getDimensionPixelOffset(u2.j.I0, 0);
        setChipSpacingHorizontal(h6.getDimensionPixelOffset(u2.j.J0, dimensionPixelOffset));
        setChipSpacingVertical(h6.getDimensionPixelOffset(u2.j.K0, dimensionPixelOffset));
        setSingleLine(h6.getBoolean(u2.j.M0, false));
        setSingleSelection(h6.getBoolean(u2.j.N0, false));
        setSelectionRequired(h6.getBoolean(u2.j.L0, false));
        int resourceId = h6.getResourceId(u2.j.H0, -1);
        if (resourceId != -1) {
            this.f5077l = resourceId;
        }
        h6.recycle();
        super.setOnHierarchyChangeListener(this.f5076k);
        b0.u0(this, 1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    @Override // com.google.android.material.internal.c
    public void setSingleLine(boolean z5) {
        super.setSingleLine(z5);
    }

    public void setSingleSelection(boolean z5) {
        if (this.f5073h != z5) {
            this.f5073h = z5;
            n();
        }
    }
}
