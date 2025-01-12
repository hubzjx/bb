package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class h implements i.e, j, AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    private Rect f609b;

    /* JADX INFO: Access modifiers changed from: protected */
    public static int o(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i6) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        View view = null;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < count; i9++) {
            int itemViewType = listAdapter.getItemViewType(i9);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i9, view, viewGroup);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i6) {
                return i6;
            }
            if (measuredWidth > i7) {
                i7 = measuredWidth;
            }
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean x(e eVar) {
        int size = eVar.size();
        for (int i6 = 0; i6 < size; i6++) {
            MenuItem item = eVar.getItem(i6);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static d y(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (d) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (d) listAdapter;
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(Context context, e eVar) {
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean i(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean j(e eVar, g gVar) {
        return false;
    }

    public abstract void l(e eVar);

    protected boolean m() {
        return true;
    }

    public Rect n() {
        return this.f609b;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        y(listAdapter).f546b.M((MenuItem) listAdapter.getItem(i6), this, m() ? 0 : 4);
    }

    public abstract void p(View view);

    public void q(Rect rect) {
        this.f609b = rect;
    }

    public abstract void r(boolean z5);

    public abstract void s(int i6);

    public abstract void t(int i6);

    public abstract void u(PopupWindow.OnDismissListener onDismissListener);

    public abstract void v(boolean z5);

    public abstract void w(int i6);
}
