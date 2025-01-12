package androidx.core.widget;

import android.widget.ListView;
/* loaded from: classes.dex */
public class g extends a {

    /* renamed from: t  reason: collision with root package name */
    private final ListView f1668t;

    public g(ListView listView) {
        super(listView);
        this.f1668t = listView;
    }

    @Override // androidx.core.widget.a
    public boolean a(int i6) {
        return false;
    }

    @Override // androidx.core.widget.a
    public boolean b(int i6) {
        ListView listView = this.f1668t;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i7 = firstVisiblePosition + childCount;
        if (i6 > 0) {
            if (i7 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i6 >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.widget.a
    public void j(int i6, int i7) {
        h.a(this.f1668t, i7);
    }
}
