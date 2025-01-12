package com.secret.prettyhezi.controls.PullToRefresh;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.PullToRefresh.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class h extends g {
    public c A;
    public boolean B;
    private String C;
    View D;

    /* renamed from: x  reason: collision with root package name */
    public int f8261x;

    /* renamed from: y  reason: collision with root package name */
    public ListView f8262y;

    /* renamed from: z  reason: collision with root package name */
    public ArrayList f8263z;

    /* loaded from: classes.dex */
    class a extends f.h {
        a() {
        }

        @Override // com.secret.prettyhezi.controls.PullToRefresh.f.h
        public void a(f fVar) {
            h.this.c0(1);
        }

        @Override // com.secret.prettyhezi.controls.PullToRefresh.f.h
        public void b(f fVar) {
            h hVar = h.this;
            hVar.c0(hVar.f8261x + 1);
        }
    }

    /* loaded from: classes.dex */
    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
            Object item = adapterView.getAdapter().getItem(i6);
            if (item != null) {
                h.this.g0(item);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c4.a {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.S() || !h.this.y()) {
                    h.this.B = true;
                    return;
                }
                h hVar = h.this;
                hVar.c0(hVar.f8261x + 1);
            }
        }

        public c(Context context) {
            super(context);
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return h.this.f8263z.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public Object getItem(int i6) {
            return h.this.f8263z.get(i6);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i6) {
            return i6;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i6, View view, ViewGroup viewGroup) {
            Object obj = h.this.f8263z.get(i6);
            h hVar = h.this;
            if (!hVar.B && i6 == hVar.f8263z.size() - 1) {
                h.this.postDelayed(new a(), 200L);
            }
            return !h.this.d0() ? h.this.a0(obj) : h.this.Z(view, obj, i6);
        }
    }

    public h(ZZcINlcxH zZcINlcxH) {
        this(zZcINlcxH, true);
    }

    public View T() {
        String str = this.C;
        if (str == null || str.length() == 0) {
            this.C = ((ZZcINlcxH) getContext()).s0(C0382R.string.no_data);
        }
        TextView c6 = g4.d.c(getContext(), 16, -16777216, this.C, 17);
        c6.setPadding(g4.i.r(12.0f), g4.i.r(20.0f), g4.i.r(12.0f), g4.i.r(20.0f));
        return c6;
    }

    public void U(View view) {
        this.f8262y.addHeaderView(view, null, false);
        this.f8262y.setHeaderDividersEnabled(false);
    }

    public void V(String str) {
        this.C = str;
    }

    public void W() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(Color.parseColor("#f0f0f0"));
        View view = new View(getContext());
        view.setBackgroundColor(Color.parseColor("#cccccc"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(0.5f));
        layoutParams.topMargin = g4.i.r(12.0f);
        linearLayout.addView(view, layoutParams);
        this.f8262y.addHeaderView(linearLayout, null, false);
        this.f8262y.setHeaderDividersEnabled(false);
    }

    public void X() {
        if (this.f8261x == 1) {
            z();
        } else {
            A();
        }
    }

    public abstract View Y(View view, Object obj);

    public View Z(View view, Object obj, int i6) {
        return Y(view, obj);
    }

    public View a0(Object obj) {
        return null;
    }

    public abstract void b0(int i6);

    public void c0(int i6) {
        if (i6 == 1) {
            this.B = false;
        }
        this.f8261x = i6;
        b0(i6);
    }

    public abstract boolean d0();

    public boolean e0() {
        return true;
    }

    public void f0() {
    }

    public void g0(Object obj) {
    }

    public void h0(Object[] objArr, boolean z5) {
        if (this.f8261x == 1) {
            this.f8263z.clear();
        }
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                this.f8263z.add(obj);
            }
            f0();
            this.A.notifyDataSetChanged();
        }
        setHasMoreData(z5);
        if (!z5) {
            this.B = true;
        }
        if (this.f8261x == 1) {
            z();
        } else if (this.B) {
            A();
        }
        if (this.f8263z.size() == 0 && !this.f8240s) {
            i(T());
        }
        if (this.f8263z.size() <= 0 || !this.f8240s) {
            return;
        }
        l();
    }

    public h(ZZcINlcxH zZcINlcxH, boolean z5) {
        super(zZcINlcxH);
        this.f8261x = 1;
        this.f8263z = new ArrayList();
        this.B = false;
        this.C = null;
        this.D = null;
        setPullRefreshEnabled(true);
        setPullLoadEnabled(false);
        setScrollLoadEnabled(true);
        if (z5) {
            p(true, 0L);
        }
        setOnRefreshListener(new a());
        this.A = new c(getContext());
        ListView listView = (ListView) getRefreshableView();
        this.f8262y = listView;
        listView.setFooterDividersEnabled(false);
        this.f8262y.setAdapter((ListAdapter) this.A);
        this.f8262y.setBackgroundColor(Color.parseColor("#f0f0f0"));
        if (e0()) {
            this.f8262y.setOnItemClickListener(new b());
        }
    }
}
