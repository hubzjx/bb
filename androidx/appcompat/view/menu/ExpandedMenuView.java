package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.c2;
/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements e.b, k, AdapterView.OnItemClickListener {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f471d = {16842964, 16843049};

    /* renamed from: b  reason: collision with root package name */
    private e f472b;

    /* renamed from: c  reason: collision with root package name */
    private int f473c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean a(g gVar) {
        return this.f472b.L(gVar, 0);
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(e eVar) {
        this.f472b = eVar;
    }

    public int getWindowAnimations() {
        return this.f473c;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
        a((g) getAdapter().getItem(i6));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        c2 v5 = c2.v(context, attributeSet, f471d, i6, 0);
        if (v5.s(0)) {
            setBackgroundDrawable(v5.g(0));
        }
        if (v5.s(1)) {
            setDivider(v5.g(1));
        }
        v5.w();
    }
}
