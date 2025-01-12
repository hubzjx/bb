package g0;

import android.database.Cursor;
import android.widget.Filter;
/* loaded from: classes.dex */
class b extends Filter {

    /* renamed from: a  reason: collision with root package name */
    a f10326a;

    /* loaded from: classes.dex */
    interface a {
        void a(Cursor cursor);

        Cursor b();

        CharSequence c(Cursor cursor);

        Cursor d(CharSequence charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f10326a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f10326a.c((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor d6 = this.f10326a.d(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (d6 != null) {
            filterResults.count = d6.getCount();
        } else {
            filterResults.count = 0;
            d6 = null;
        }
        filterResults.values = d6;
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor b6 = this.f10326a.b();
        Object obj = filterResults.values;
        if (obj == null || obj == b6) {
            return;
        }
        this.f10326a.a((Cursor) obj);
    }
}
