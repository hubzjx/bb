package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.j;
import com.google.android.material.internal.l;
import e0.b0;
import e0.g;
import f0.y;
import h3.k;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
import u2.i;
/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: l  reason: collision with root package name */
    private static final String f5006l = "MaterialButtonToggleGroup";

    /* renamed from: m  reason: collision with root package name */
    private static final int f5007m = i.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: b  reason: collision with root package name */
    private final List f5008b;

    /* renamed from: c  reason: collision with root package name */
    private final c f5009c;

    /* renamed from: d  reason: collision with root package name */
    private final f f5010d;

    /* renamed from: e  reason: collision with root package name */
    private final LinkedHashSet f5011e;

    /* renamed from: f  reason: collision with root package name */
    private final Comparator f5012f;

    /* renamed from: g  reason: collision with root package name */
    private Integer[] f5013g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5014h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5015i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5016j;

    /* renamed from: k  reason: collision with root package name */
    private int f5017k;

    /* loaded from: classes.dex */
    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    /* loaded from: classes.dex */
    class b extends e0.a {
        b() {
        }

        @Override // e0.a
        public void g(View view, y yVar) {
            super.g(view, yVar);
            yVar.Z(y.c.a(0, 1, MaterialButtonToggleGroup.this.o(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements MaterialButton.a {
        private c() {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(MaterialButton materialButton, boolean z5) {
            if (MaterialButtonToggleGroup.this.f5014h) {
                return;
            }
            if (MaterialButtonToggleGroup.this.f5015i) {
                MaterialButtonToggleGroup.this.f5017k = z5 ? materialButton.getId() : -1;
            }
            if (MaterialButtonToggleGroup.this.v(materialButton.getId(), z5)) {
                MaterialButtonToggleGroup.this.m(materialButton.getId(), materialButton.isChecked());
            }
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ c(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: e  reason: collision with root package name */
        private static final h3.c f5021e = new h3.a(0.0f);

        /* renamed from: a  reason: collision with root package name */
        h3.c f5022a;

        /* renamed from: b  reason: collision with root package name */
        h3.c f5023b;

        /* renamed from: c  reason: collision with root package name */
        h3.c f5024c;

        /* renamed from: d  reason: collision with root package name */
        h3.c f5025d;

        d(h3.c cVar, h3.c cVar2, h3.c cVar3, h3.c cVar4) {
            this.f5022a = cVar;
            this.f5023b = cVar3;
            this.f5024c = cVar4;
            this.f5025d = cVar2;
        }

        public static d a(d dVar) {
            h3.c cVar = f5021e;
            return new d(cVar, dVar.f5025d, cVar, dVar.f5024c);
        }

        public static d b(d dVar, View view) {
            return l.d(view) ? c(dVar) : d(dVar);
        }

        public static d c(d dVar) {
            h3.c cVar = dVar.f5022a;
            h3.c cVar2 = dVar.f5025d;
            h3.c cVar3 = f5021e;
            return new d(cVar, cVar2, cVar3, cVar3);
        }

        public static d d(d dVar) {
            h3.c cVar = f5021e;
            return new d(cVar, cVar, dVar.f5023b, dVar.f5024c);
        }

        public static d e(d dVar, View view) {
            return l.d(view) ? d(dVar) : c(dVar);
        }

        public static d f(d dVar) {
            h3.c cVar = dVar.f5022a;
            h3.c cVar2 = f5021e;
            return new d(cVar, cVar2, dVar.f5023b, cVar2);
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i6, boolean z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements MaterialButton.b {
        private f() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(MaterialButton materialButton, boolean z5) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ f(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, u2.a.materialButtonToggleGroupStyle);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            if (q(i6)) {
                return i6;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (q(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i6 = 0;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            if ((getChildAt(i7) instanceof MaterialButton) && q(i7)) {
                i6++;
            }
        }
        return i6;
    }

    private void h() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i6 = firstVisibleChildIndex + 1; i6 < getChildCount(); i6++) {
            MaterialButton n5 = n(i6);
            int min = Math.min(n5.getStrokeWidth(), n(i6 - 1).getStrokeWidth());
            LinearLayout.LayoutParams i7 = i(n5);
            if (getOrientation() == 0) {
                g.c(i7, 0);
                g.d(i7, -min);
                i7.topMargin = 0;
            } else {
                i7.bottomMargin = 0;
                i7.topMargin = -min;
                g.d(i7, 0);
            }
            n5.setLayoutParams(i7);
        }
        s(firstVisibleChildIndex);
    }

    private LinearLayout.LayoutParams i(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void k(int i6, boolean z5) {
        MaterialButton materialButton = (MaterialButton) findViewById(i6);
        if (materialButton != null) {
            materialButton.setChecked(z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i6, boolean z5) {
        Iterator it = this.f5011e.iterator();
        while (it.hasNext()) {
            ((e) it.next()).a(this, i6, z5);
        }
    }

    private MaterialButton n(int i6) {
        return (MaterialButton) getChildAt(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o(View view) {
        if (view instanceof MaterialButton) {
            int i6 = 0;
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                if (getChildAt(i7) == view) {
                    return i6;
                }
                if ((getChildAt(i7) instanceof MaterialButton) && q(i7)) {
                    i6++;
                }
            }
            return -1;
        }
        return -1;
    }

    private d p(int i6, int i7, int i8) {
        d dVar = (d) this.f5008b.get(i6);
        if (i7 == i8) {
            return dVar;
        }
        boolean z5 = getOrientation() == 0;
        if (i6 == i7) {
            return z5 ? d.e(dVar, this) : d.f(dVar);
        } else if (i6 == i8) {
            return z5 ? d.b(dVar, this) : d.a(dVar);
        } else {
            return null;
        }
    }

    private boolean q(int i6) {
        return getChildAt(i6).getVisibility() != 8;
    }

    private void s(int i6) {
        if (getChildCount() == 0 || i6 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) n(i6).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            return;
        }
        g.c(layoutParams, 0);
        g.d(layoutParams, 0);
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
    }

    private void setCheckedId(int i6) {
        this.f5017k = i6;
        m(i6, true);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(b0.k());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.a(this.f5009c);
        materialButton.setOnPressedChangeListenerInternal(this.f5010d);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private void t(int i6, boolean z5) {
        View findViewById = findViewById(i6);
        if (findViewById instanceof MaterialButton) {
            this.f5014h = true;
            ((MaterialButton) findViewById).setChecked(z5);
            this.f5014h = false;
        }
    }

    private static void u(k.b bVar, d dVar) {
        if (dVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.B(dVar.f5022a).t(dVar.f5025d).F(dVar.f5023b).x(dVar.f5024c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(int i6, boolean z5) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.f5016j && checkedButtonIds.isEmpty()) {
            t(i6, true);
            this.f5017k = i6;
            return false;
        }
        if (z5 && this.f5015i) {
            checkedButtonIds.remove(Integer.valueOf(i6));
            for (Integer num : checkedButtonIds) {
                int intValue = num.intValue();
                t(intValue, false);
                m(intValue, false);
            }
        }
        return true;
    }

    private void w() {
        TreeMap treeMap = new TreeMap(this.f5012f);
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            treeMap.put(n(i6), Integer.valueOf(i6));
        }
        this.f5013g = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(f5006l, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i6, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            v(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        k shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f5008b.add(new d(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        b0.l0(materialButton, new b());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        w();
        super.dispatchDraw(canvas);
    }

    public void g(e eVar) {
        this.f5011e.add(eVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    public int getCheckedButtonId() {
        if (this.f5015i) {
            return this.f5017k;
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            MaterialButton n5 = n(i6);
            if (n5.isChecked()) {
                arrayList.add(Integer.valueOf(n5.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i6, int i7) {
        Integer[] numArr = this.f5013g;
        if (numArr == null || i7 >= numArr.length) {
            Log.w(f5006l, "Child order wasn't updated");
            return i7;
        }
        return numArr[i7].intValue();
    }

    public void j(int i6) {
        if (i6 == this.f5017k) {
            return;
        }
        k(i6, true);
    }

    public void l() {
        this.f5014h = true;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            MaterialButton n5 = n(i6);
            n5.setChecked(false);
            m(n5.getId(), false);
        }
        this.f5014h = false;
        setCheckedId(-1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i6 = this.f5017k;
        if (i6 != -1) {
            k(i6, true);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        y.w0(accessibilityNodeInfo).Y(y.b.a(1, getVisibleButtonCount(), false, r() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        x();
        h();
        super.onMeasure(i6, i7);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.h(this.f5009c);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f5008b.remove(indexOfChild);
        }
        x();
        h();
    }

    public boolean r() {
        return this.f5015i;
    }

    public void setSelectionRequired(boolean z5) {
        this.f5016j = z5;
    }

    public void setSingleSelection(int i6) {
        setSingleSelection(getResources().getBoolean(i6));
    }

    void x() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i6 = 0; i6 < childCount; i6++) {
            MaterialButton n5 = n(i6);
            if (n5.getVisibility() != 8) {
                k.b v5 = n5.getShapeAppearanceModel().v();
                u(v5, p(i6, firstVisibleChildIndex, lastVisibleChildIndex));
                n5.setShapeAppearanceModel(v5.m());
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i6) {
        super(i3.a.c(context, attributeSet, i6, r4), attributeSet, i6);
        int i7 = f5007m;
        this.f5008b = new ArrayList();
        this.f5009c = new c(this, null);
        this.f5010d = new f(this, null);
        this.f5011e = new LinkedHashSet();
        this.f5012f = new a();
        this.f5014h = false;
        TypedArray h6 = j.h(getContext(), attributeSet, u2.j.f13510k2, i6, i7, new int[0]);
        setSingleSelection(h6.getBoolean(u2.j.f13530n2, false));
        this.f5017k = h6.getResourceId(u2.j.f13517l2, -1);
        this.f5016j = h6.getBoolean(u2.j.f13524m2, false);
        setChildrenDrawingOrderEnabled(true);
        h6.recycle();
        b0.u0(this, 1);
    }

    public void setSingleSelection(boolean z5) {
        if (this.f5015i != z5) {
            this.f5015i = z5;
            l();
        }
    }
}
