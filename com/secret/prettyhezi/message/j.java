package com.secret.prettyhezi.message;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.PullToRefresh.f;
import com.secret.prettyhezi.message.g;
import com.secret.prettyhezi.s;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends com.secret.prettyhezi.controls.PullToRefresh.g {
    ListView A;
    int B;
    int C;
    int D;
    boolean E;
    public ArrayList F;
    com.secret.prettyhezi.controls.PullToRefresh.b G;

    /* renamed from: x  reason: collision with root package name */
    AWsQxAQ f8735x;

    /* renamed from: y  reason: collision with root package name */
    int f8736y;

    /* renamed from: z  reason: collision with root package name */
    e f8737z;

    /* loaded from: classes.dex */
    class a extends f.h {
        a() {
        }

        @Override // com.secret.prettyhezi.controls.PullToRefresh.f.h
        public void a(com.secret.prettyhezi.controls.PullToRefresh.f fVar) {
            j.this.getNextPage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends s.g {
        b(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void f(String str) {
            super.f(str);
            j.this.E = false;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            g gVar = (g) com.secret.prettyhezi.f.d(str, g.class);
            if (gVar.code == 200) {
                g.a aVar = gVar.data;
                j jVar = j.this;
                int i6 = aVar.pages;
                jVar.C = i6;
                if (jVar.D == i6) {
                    jVar.setPullRefreshEnabled(false);
                }
                j jVar2 = j.this;
                if (jVar2.D == 1 && jVar2.B == 5) {
                    com.secret.prettyhezi.message.c.b();
                }
                j jVar3 = j.this;
                int i7 = jVar3.D + 1;
                jVar3.D = i7;
                jVar3.U(aVar.items, i7 == 2);
            } else {
                f(gVar.err);
            }
            j.this.E = false;
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            jVar.A.setSelection(jVar.F.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8741a;

        d(int i6) {
            this.f8741a = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.A.setSelection(this.f8741a);
        }
    }

    /* loaded from: classes.dex */
    public class e extends c4.a {
        public e(Context context) {
            super(context);
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return j.this.F.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public Object getItem(int i6) {
            return j.this.F.get(i6);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i6) {
            return i6;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i6, View view, ViewGroup viewGroup) {
            com.secret.prettyhezi.message.e eVar = (com.secret.prettyhezi.message.e) j.this.F.get(i6);
            j jVar = j.this;
            int f12 = jVar.B == 3 ? jVar.f8735x.f1() : MainApplication.f() > 0 ? MainApplication.f() : 0;
            int i7 = eVar.sender;
            boolean z5 = i7 == f12;
            boolean z6 = (j.this.B == 0 || i7 != 2 || eVar.IsImage()) ? false : true;
            if (view != null && (view instanceof i)) {
                i iVar = (i) view;
                if (iVar.f8727k != eVar) {
                    iVar.b(eVar, z5, false);
                    if (z6) {
                        iVar.a();
                    }
                }
                return view;
            }
            i iVar2 = new i(j.this.f8735x);
            if (j.this.B == 5) {
                iVar2.f8726j = true;
            }
            iVar2.b(eVar, z5, true);
            if (z6) {
                iVar2.a();
            }
            return iVar2;
        }
    }

    public j(AWsQxAQ aWsQxAQ, int i6, int i7) {
        super(aWsQxAQ);
        this.C = 1;
        this.D = 1;
        this.E = false;
        this.F = new ArrayList();
        this.f8735x = aWsQxAQ;
        this.B = i7;
        this.f8736y = i6;
        setPullRefreshEnabled(i6 > 0);
        setPullLoadEnabled(false);
        setScrollLoadEnabled(false);
        setOnRefreshListener(new a());
        this.f8737z = new e(getContext());
        ListView listView = (ListView) getRefreshableView();
        this.A = listView;
        listView.setAdapter((ListAdapter) this.f8737z);
        this.A.setDividerHeight(0);
        this.A.setVerticalScrollBarEnabled(true);
        this.A.setScrollBarSize(1);
        this.A.setBackgroundColor(Color.parseColor("#f0f0f0"));
        this.A.setTranscriptMode(2);
        if (i6 > 0) {
            getNextPage();
        }
    }

    public void T(com.secret.prettyhezi.message.e eVar) {
        this.F.add(eVar);
        this.f8737z.notifyDataSetChanged();
        postDelayed(new c(), 50L);
    }

    public void U(com.secret.prettyhezi.message.e[] eVarArr, boolean z5) {
        int size = this.F.size();
        if (this.F.isEmpty()) {
            for (com.secret.prettyhezi.message.e eVar : eVarArr) {
                this.F.add(0, eVar);
            }
        } else {
            int i6 = ((com.secret.prettyhezi.message.e) this.F.get(0)).id;
            int i7 = 0;
            while (i7 < eVarArr.length && eVarArr[i7].id >= i6) {
                i7++;
            }
            while (i7 < eVarArr.length) {
                this.F.add(0, eVarArr[i7]);
                i7++;
            }
        }
        this.f8737z.notifyDataSetChanged();
        int size2 = this.F.size();
        if (!z5) {
            size2 -= size;
        }
        int i8 = size2 - 1;
        int i9 = i8 >= 0 ? i8 : 0;
        this.A.setSelection(i9);
        postDelayed(new d(i9), 1L);
        z();
    }

    public void V() {
        this.D = 1;
        this.F.clear();
        this.f8737z.notifyDataSetChanged();
        getNextPage();
    }

    public void getNextPage() {
        if (this.E || this.D > this.C || this.f8736y <= 0) {
            return;
        }
        this.E = true;
        String str = this.B == 0 ? "notify/message/subscription/json?id=" : "chat/show/json?id=";
        com.secret.prettyhezi.j.o(v.f7132a + str + this.f8736y + "&page=" + this.D, true, new b(this.f8735x));
    }

    @Override // com.secret.prettyhezi.controls.PullToRefresh.f
    protected com.secret.prettyhezi.controls.PullToRefresh.e n(Context context, AttributeSet attributeSet) {
        com.secret.prettyhezi.controls.PullToRefresh.b bVar = new com.secret.prettyhezi.controls.PullToRefresh.b(context);
        this.G = bVar;
        return bVar;
    }
}
