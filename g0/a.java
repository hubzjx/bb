package g0;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import g0.b;
/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: b  reason: collision with root package name */
    protected boolean f10316b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f10317c;

    /* renamed from: d  reason: collision with root package name */
    protected Cursor f10318d;

    /* renamed from: e  reason: collision with root package name */
    protected Context f10319e;

    /* renamed from: f  reason: collision with root package name */
    protected int f10320f;

    /* renamed from: g  reason: collision with root package name */
    protected C0167a f10321g;

    /* renamed from: h  reason: collision with root package name */
    protected DataSetObserver f10322h;

    /* renamed from: i  reason: collision with root package name */
    protected g0.b f10323i;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0167a extends ContentObserver {
        C0167a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            a.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f10316b = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f10316b = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z5) {
        f(context, cursor, z5 ? 1 : 2);
    }

    public void a(Cursor cursor) {
        Cursor j6 = j(cursor);
        if (j6 != null) {
            j6.close();
        }
    }

    @Override // g0.b.a
    public Cursor b() {
        return this.f10318d;
    }

    public abstract CharSequence c(Cursor cursor);

    public abstract void e(View view, Context context, Cursor cursor);

    void f(Context context, Cursor cursor, int i6) {
        b bVar;
        if ((i6 & 1) == 1) {
            i6 |= 2;
            this.f10317c = true;
        } else {
            this.f10317c = false;
        }
        boolean z5 = cursor != null;
        this.f10318d = cursor;
        this.f10316b = z5;
        this.f10319e = context;
        this.f10320f = z5 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i6 & 2) == 2) {
            this.f10321g = new C0167a();
            bVar = new b();
        } else {
            bVar = null;
            this.f10321g = null;
        }
        this.f10322h = bVar;
        if (z5) {
            C0167a c0167a = this.f10321g;
            if (c0167a != null) {
                cursor.registerContentObserver(c0167a);
            }
            DataSetObserver dataSetObserver = this.f10322h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f10316b || (cursor = this.f10318d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i6, View view, ViewGroup viewGroup) {
        if (this.f10316b) {
            this.f10318d.moveToPosition(i6);
            if (view == null) {
                view = g(this.f10319e, this.f10318d, viewGroup);
            }
            e(view, this.f10319e, this.f10318d);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f10323i == null) {
            this.f10323i = new g0.b(this);
        }
        return this.f10323i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i6) {
        Cursor cursor;
        if (!this.f10316b || (cursor = this.f10318d) == null) {
            return null;
        }
        cursor.moveToPosition(i6);
        return this.f10318d;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i6) {
        Cursor cursor;
        if (this.f10316b && (cursor = this.f10318d) != null && cursor.moveToPosition(i6)) {
            return this.f10318d.getLong(this.f10320f);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i6, View view, ViewGroup viewGroup) {
        if (this.f10316b) {
            if (this.f10318d.moveToPosition(i6)) {
                if (view == null) {
                    view = h(this.f10319e, this.f10318d, viewGroup);
                }
                e(view, this.f10319e, this.f10318d);
                return view;
            }
            throw new IllegalStateException("couldn't move cursor to position " + i6);
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void i() {
        Cursor cursor;
        if (!this.f10317c || (cursor = this.f10318d) == null || cursor.isClosed()) {
            return;
        }
        this.f10316b = this.f10318d.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f10318d;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0167a c0167a = this.f10321g;
            if (c0167a != null) {
                cursor2.unregisterContentObserver(c0167a);
            }
            DataSetObserver dataSetObserver = this.f10322h;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f10318d = cursor;
        if (cursor != null) {
            C0167a c0167a2 = this.f10321g;
            if (c0167a2 != null) {
                cursor.registerContentObserver(c0167a2);
            }
            DataSetObserver dataSetObserver2 = this.f10322h;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f10320f = cursor.getColumnIndexOrThrow("_id");
            this.f10316b = true;
            notifyDataSetChanged();
        } else {
            this.f10320f = -1;
            this.f10316b = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
