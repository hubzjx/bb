package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends BaseAdapter {

    /* renamed from: b  reason: collision with root package name */
    e f546b;

    /* renamed from: c  reason: collision with root package name */
    private int f547c = -1;

    /* renamed from: d  reason: collision with root package name */
    private boolean f548d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f549e;

    /* renamed from: f  reason: collision with root package name */
    private final LayoutInflater f550f;

    /* renamed from: g  reason: collision with root package name */
    private final int f551g;

    public d(e eVar, LayoutInflater layoutInflater, boolean z5, int i6) {
        this.f549e = z5;
        this.f550f = layoutInflater;
        this.f546b = eVar;
        this.f551g = i6;
        a();
    }

    void a() {
        g v5 = this.f546b.v();
        if (v5 != null) {
            ArrayList z5 = this.f546b.z();
            int size = z5.size();
            for (int i6 = 0; i6 < size; i6++) {
                if (((g) z5.get(i6)) == v5) {
                    this.f547c = i6;
                    return;
                }
            }
        }
        this.f547c = -1;
    }

    public e b() {
        return this.f546b;
    }

    @Override // android.widget.Adapter
    /* renamed from: c */
    public g getItem(int i6) {
        ArrayList z5 = this.f549e ? this.f546b.z() : this.f546b.E();
        int i7 = this.f547c;
        if (i7 >= 0 && i6 >= i7) {
            i6++;
        }
        return (g) z5.get(i6);
    }

    public void d(boolean z5) {
        this.f548d = z5;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList z5 = this.f549e ? this.f546b.z() : this.f546b.E();
        int i6 = this.f547c;
        int size = z5.size();
        return i6 < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i6) {
        return i6;
    }

    @Override // android.widget.Adapter
    public View getView(int i6, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f550f.inflate(this.f551g, viewGroup, false);
        }
        int groupId = getItem(i6).getGroupId();
        int i7 = i6 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f546b.F() && groupId != (i7 >= 0 ? getItem(i7).getGroupId() : groupId));
        k.a aVar = (k.a) view;
        if (this.f548d) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i6), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
