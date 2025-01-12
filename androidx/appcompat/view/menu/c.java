package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c implements j, AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    Context f535b;

    /* renamed from: c  reason: collision with root package name */
    LayoutInflater f536c;

    /* renamed from: d  reason: collision with root package name */
    e f537d;

    /* renamed from: e  reason: collision with root package name */
    ExpandedMenuView f538e;

    /* renamed from: f  reason: collision with root package name */
    int f539f;

    /* renamed from: g  reason: collision with root package name */
    int f540g;

    /* renamed from: h  reason: collision with root package name */
    int f541h;

    /* renamed from: i  reason: collision with root package name */
    private j.a f542i;

    /* renamed from: j  reason: collision with root package name */
    a f543j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private int f544b = -1;

        public a() {
            a();
        }

        void a() {
            g v5 = c.this.f537d.v();
            if (v5 != null) {
                ArrayList z5 = c.this.f537d.z();
                int size = z5.size();
                for (int i6 = 0; i6 < size; i6++) {
                    if (((g) z5.get(i6)) == v5) {
                        this.f544b = i6;
                        return;
                    }
                }
            }
            this.f544b = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b */
        public g getItem(int i6) {
            ArrayList z5 = c.this.f537d.z();
            int i7 = i6 + c.this.f539f;
            int i8 = this.f544b;
            if (i8 >= 0 && i7 >= i8) {
                i7++;
            }
            return (g) z5.get(i7);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = c.this.f537d.z().size() - c.this.f539f;
            return this.f544b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i6) {
            return i6;
        }

        @Override // android.widget.Adapter
        public View getView(int i6, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.f536c.inflate(cVar.f541h, viewGroup, false);
            }
            ((k.a) view).e(getItem(i6), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public c(int i6, int i7) {
        this.f541h = i6;
        this.f540g = i7;
    }

    public ListAdapter a() {
        if (this.f543j == null) {
            this.f543j = new a();
        }
        return this.f543j;
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(e eVar, boolean z5) {
        j.a aVar = this.f542i;
        if (aVar != null) {
            aVar.b(eVar, z5);
        }
    }

    public k c(ViewGroup viewGroup) {
        if (this.f538e == null) {
            this.f538e = (ExpandedMenuView) this.f536c.inflate(b.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.f543j == null) {
                this.f543j = new a();
            }
            this.f538e.setAdapter((ListAdapter) this.f543j);
            this.f538e.setOnItemClickListener(this);
        }
        return this.f538e;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.view.menu.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(Context context, e eVar) {
        LayoutInflater from;
        a aVar;
        if (this.f540g == 0) {
            if (this.f535b != null) {
                this.f535b = context;
                if (this.f536c == null) {
                    from = LayoutInflater.from(context);
                }
            }
            this.f537d = eVar;
            aVar = this.f543j;
            if (aVar == null) {
                aVar.notifyDataSetChanged();
                return;
            }
            return;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f540g);
        this.f535b = contextThemeWrapper;
        from = LayoutInflater.from(contextThemeWrapper);
        this.f536c = from;
        this.f537d = eVar;
        aVar = this.f543j;
        if (aVar == null) {
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e(m mVar) {
        if (mVar.hasVisibleItems()) {
            new f(mVar).d(null);
            j.a aVar = this.f542i;
            if (aVar != null) {
                aVar.c(mVar);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void f(boolean z5) {
        a aVar = this.f543j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean h() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean i(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean j(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void k(j.a aVar) {
        this.f542i = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
        this.f537d.M(this.f543j.getItem(i6), this, 0);
    }

    public c(Context context, int i6) {
        this(i6, 0);
        this.f535b = context;
        this.f536c = LayoutInflater.from(context);
    }
}
