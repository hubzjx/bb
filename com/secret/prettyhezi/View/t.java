package com.secret.prettyhezi.View;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.o;
import com.secret.prettyhezi.View.s;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class t extends FrameLayout {
    public String A;
    Class B;
    int C;
    int D;
    public boolean E;
    public String F;
    private ArrayList G;
    private ArrayList H;
    protected boolean I;
    long J;
    long K;
    protected boolean L;
    protected boolean M;
    int N;
    String O;
    View P;

    /* renamed from: b  reason: collision with root package name */
    protected ZZcINlcxH f8008b;

    /* renamed from: c  reason: collision with root package name */
    public int f8009c;

    /* renamed from: d  reason: collision with root package name */
    protected int f8010d;

    /* renamed from: e  reason: collision with root package name */
    public long f8011e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList f8012f;

    /* renamed from: g  reason: collision with root package name */
    protected int f8013g;

    /* renamed from: h  reason: collision with root package name */
    protected int f8014h;

    /* renamed from: i  reason: collision with root package name */
    protected int f8015i;

    /* renamed from: j  reason: collision with root package name */
    protected int[] f8016j;

    /* renamed from: k  reason: collision with root package name */
    private long f8017k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8018l;

    /* renamed from: m  reason: collision with root package name */
    protected String f8019m;

    /* renamed from: n  reason: collision with root package name */
    protected int f8020n;

    /* renamed from: o  reason: collision with root package name */
    String f8021o;

    /* renamed from: p  reason: collision with root package name */
    private s.c f8022p;

    /* renamed from: q  reason: collision with root package name */
    int f8023q;

    /* renamed from: r  reason: collision with root package name */
    int f8024r;

    /* renamed from: s  reason: collision with root package name */
    int f8025s;

    /* renamed from: t  reason: collision with root package name */
    TextView f8026t;

    /* renamed from: u  reason: collision with root package name */
    q f8027u;

    /* renamed from: v  reason: collision with root package name */
    int f8028v;

    /* renamed from: w  reason: collision with root package name */
    protected boolean f8029w;

    /* renamed from: x  reason: collision with root package name */
    public int f8030x;

    /* renamed from: y  reason: collision with root package name */
    public int f8031y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f8032z;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t.this.f8009c >= 0) {
                s m5 = MainApplication.f6711r.m();
                t tVar = t.this;
                tVar.f8022p = m5.b(tVar.F);
                if (t.this.f8022p != null) {
                    t tVar2 = t.this;
                    if (m5.k(tVar2.F, tVar2)) {
                        return;
                    }
                }
                t.this.H();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends s.d {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8034c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ZZcINlcxH zZcINlcxH, t tVar, int i6) {
            super(zZcINlcxH, tVar);
            this.f8034c = i6;
        }

        @Override // com.secret.prettyhezi.s.d, com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
            super.a(iOException);
            t.this.I = false;
        }

        @Override // com.secret.prettyhezi.s.d, com.secret.prettyhezi.j.e
        public void b(int i6) {
            super.b(i6);
            t.this.I = false;
        }

        @Override // com.secret.prettyhezi.s.d
        public void f(String str) {
            com.secret.prettyhezi.Server.o c6 = com.secret.prettyhezi.f.c(str, t.this.B);
            if (c6.code != 200) {
                e(c6.err);
                return;
            }
            int i6 = c6.data.total;
            if (i6 > 0 && this.f8034c == 1) {
                t.this.E(i6);
            }
            t tVar = t.this;
            o.a aVar = c6.data;
            tVar.f8009c = aVar.pages;
            tVar.k(aVar.items);
        }
    }

    public t(ZZcINlcxH zZcINlcxH, Class cls) {
        super(zZcINlcxH);
        this.f8009c = 0;
        this.f8010d = 1;
        this.f8012f = new ArrayList();
        this.f8013g = g4.i.r(10.0f);
        this.f8017k = 0L;
        this.f8018l = false;
        this.f8019m = com.secret.prettyhezi.Server.v.f7132a;
        this.f8020n = 1;
        this.f8021o = MainApplication.e();
        this.f8022p = null;
        this.f8023q = 0;
        this.f8025s = 0;
        this.f8026t = null;
        this.f8027u = null;
        this.f8028v = -1;
        this.f8029w = false;
        this.f8032z = false;
        this.C = 0;
        this.D = 0;
        this.E = true;
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.I = false;
        this.J = 0L;
        this.K = 0L;
        this.L = false;
        this.M = false;
        this.N = -1;
        this.O = null;
        this.P = null;
        this.f8008b = zZcINlcxH;
        this.B = cls;
        setPadding(0, 0, 0, this.f8013g);
        this.f8029w = com.secret.AD.c.b(2);
        Point o5 = this.f8008b.o();
        this.f8024r = o5.y;
        int a6 = a();
        this.f8014h = a6;
        this.f8015i = a6 == 1 ? o5.x : (o5.x - ((a6 + 1) * this.f8013g)) / a6;
        this.f8016j = new int[a6];
        this.f8030x = a6;
        int i6 = ((int) (((((a6 / 2.6d) * o5.y) / o5.x) * 2.0d) + 0.2d)) * 2;
        this.f8031y = i6;
        if (i6 < 5) {
            this.f8031y = 5;
        }
        post(new a());
    }

    public void A() {
        this.I = false;
    }

    public void B() {
        this.H.clear();
        this.G.clear();
    }

    public void C() {
        int i6 = this.f8009c;
        if (i6 <= 5) {
            this.f8008b.H("Not supported");
            return;
        }
        int i7 = this.f8010d;
        if (i6 - i7 < 2) {
            i7 = 0;
        }
        int i8 = i6 - i7;
        o(i7 + (i8 / 10) + ((int) (Math.random() * (i8 / 3))));
    }

    public void D(int i6) {
        M(i6, this.f8024r + i6);
        this.f8025s = i6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(long j6) {
        this.f8011e = j6;
        ZZcINlcxH zZcINlcxH = this.f8008b;
        if (zZcINlcxH instanceof EjNkL) {
            ((EjNkL) zZcINlcxH).k1(j6);
        }
    }

    protected final void F(u uVar, com.secret.prettyhezi.Server.n nVar) {
        if (nVar instanceof com.secret.prettyhezi.Server.a) {
            this.H.add(uVar);
        } else {
            G(uVar, nVar);
        }
    }

    protected void G(u uVar, com.secret.prettyhezi.Server.n nVar) {
        this.G.add(uVar);
    }

    protected void H() {
        if (this.I) {
            return;
        }
        if (this.f8012f.size() > 10 && this.f8010d >= 3 && System.currentTimeMillis() - this.J < 4000) {
            if (System.currentTimeMillis() - this.K > 1500) {
                this.K = System.currentTimeMillis();
                g4.i.j().H("请不要刷的太快");
                return;
            }
            return;
        }
        this.I = true;
        q();
        this.J = System.currentTimeMillis();
        if (this.f8022p != null) {
            this.f8018l = true;
        }
    }

    public void I() {
        if (this.f8018l) {
            if (this.f8012f.size() == 0 || (this.f8012f.size() > 0 && ((com.secret.prettyhezi.Server.n) this.f8012f.get(0)).pageIndex == 1)) {
                this.f8018l = false;
                s m5 = MainApplication.f6711r.m();
                String str = this.F;
                int i6 = this.f8009c;
                int i7 = this.f8010d;
                long j6 = this.f8017k;
                if (j6 <= 0) {
                    j6 = this.f8022p.a();
                }
                m5.n(str, i6, i7, j6, this.f8011e, this.f8012f);
            }
        }
    }

    public void J(boolean z5) {
        this.L = z5;
        if (this.f8012f.size() == 0) {
            return;
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            ((u) getChildAt(i6)).n(z5);
        }
    }

    public void K(boolean z5) {
        this.M = z5;
        if (this.f8012f.size() == 0) {
            return;
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            ((u) getChildAt(i6)).o(z5);
        }
    }

    public void L() {
        int i6;
        for (int i7 = 0; i7 < this.f8014h; i7++) {
            this.f8016j[i7] = 0;
        }
        int size = this.f8012f.size();
        for (int i8 = 0; i8 < size; i8++) {
            com.secret.prettyhezi.Server.n nVar = (com.secret.prettyhezi.Server.n) this.f8012f.get(i8);
            FrameLayout.LayoutParams layoutParams = nVar.pa;
            if (layoutParams == null) {
                break;
            }
            int i9 = 1;
            int i10 = 0;
            while (true) {
                i6 = this.f8014h;
                if (i9 >= i6) {
                    break;
                }
                int[] iArr = this.f8016j;
                if (iArr[i9] < iArr[i10]) {
                    i10 = i9;
                }
                i9++;
            }
            if (i6 > 1) {
                layoutParams.leftMargin = ((i10 + 1) * this.f8013g) + (this.f8015i * i10);
            }
            layoutParams.topMargin = this.f8016j[i10] + this.f8013g;
            u uVar = nVar.view;
            if (uVar != null) {
                uVar.setLayoutParams(layoutParams);
            }
            this.f8016j[i10] = layoutParams.topMargin + layoutParams.height;
        }
        this.C = 0;
        int i11 = this.f8023q;
        M(i11, this.f8024r + i11);
    }

    public void M(int i6, int i7) {
        boolean z5 = i6 >= this.f8023q || this.C == 0;
        this.f8023q = i6;
        int size = this.f8012f.size();
        if (!z5) {
            this.C = 0;
            int i8 = i7 + 10000;
            boolean z6 = true;
            for (int i9 = this.D; i9 >= 0; i9--) {
                com.secret.prettyhezi.Server.n nVar = (com.secret.prettyhezi.Server.n) this.f8012f.get(i9);
                FrameLayout.LayoutParams layoutParams = nVar.pa;
                int i10 = layoutParams.topMargin;
                if ((i6 <= layoutParams.height + i10 && i7 >= i10) || i8 < i10) {
                    if (z6) {
                        this.D = i9;
                        z6 = false;
                    }
                    if (nVar.view == null) {
                        addView(u(this.f8008b, nVar, this.f8015i), layoutParams);
                    }
                    i8 = Math.min(i8, layoutParams.topMargin);
                } else {
                    int w5 = w(layoutParams);
                    if (!z6 && this.C == 0 && w5 % this.f8014h == 0) {
                        this.C = i9 + 1;
                    }
                    View view = nVar.view;
                    if (view != null) {
                        removeView(view);
                        F(nVar.view, nVar);
                        nVar.view = null;
                    } else if (!z6 && w5 % this.f8014h == 0) {
                        return;
                    }
                }
            }
            return;
        }
        this.D = size - 1;
        boolean z7 = true;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = this.C; i13 < size; i13++) {
            com.secret.prettyhezi.Server.n nVar2 = (com.secret.prettyhezi.Server.n) this.f8012f.get(i13);
            FrameLayout.LayoutParams layoutParams2 = nVar2.pa;
            if (layoutParams2 == null) {
                if (!z7 && i11 >= 0) {
                    break;
                }
                u u5 = u(this.f8008b, nVar2, this.f8015i);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.f8015i, u5.getItemHeight());
                setupLayoutParameterForNewItem(layoutParams3);
                addView(u5, layoutParams3);
                nVar2.pa = layoutParams3;
                layoutParams2 = layoutParams3;
            }
            int i14 = layoutParams2.topMargin;
            int i15 = layoutParams2.height;
            if (!((i6 <= i14 + i15 && i7 >= i14) || i14 + i15 < i12)) {
                int w6 = w(layoutParams2);
                if (!z7 && i11 == -1 && w6 % this.f8014h == 0) {
                    i11 = size - i13;
                    this.D = i13 - 1;
                }
                View view2 = nVar2.view;
                if (view2 != null) {
                    removeView(view2);
                    F(nVar2.view, nVar2);
                    nVar2.view = null;
                } else if (!z7 && w6 % this.f8014h == 0) {
                    break;
                }
            } else {
                if (nVar2.view == null) {
                    addView(u(this.f8008b, nVar2, this.f8015i), layoutParams2);
                }
                if (z7) {
                    q qVar = this.f8027u;
                    if (qVar != null) {
                        qVar.a(nVar2.pageIndex);
                    }
                    this.f8028v = nVar2.pageIndex;
                    this.C = i13;
                    z7 = false;
                }
                i12 = Math.max(i12, layoutParams2.topMargin + layoutParams2.height);
            }
        }
        ViewGroup.LayoutParams layoutParams4 = getLayoutParams();
        int newHeight = getNewHeight();
        if (layoutParams4 == null) {
            setMinimumHeight(newHeight);
        } else if (newHeight != layoutParams4.height) {
            layoutParams4.height = newHeight;
            setMinimumHeight(newHeight);
            setLayoutParams(layoutParams4);
        }
        if (this.I || this.f8009c < this.f8010d || this.N >= 0 || i11 / 2 > getChildCount() || i11 >= 20) {
            return;
        }
        H();
    }

    protected int a() {
        return ((float) this.f8008b.o().x) / this.f8008b.getResources().getDisplayMetrics().density > 600.0f ? 3 : 2;
    }

    public void b() {
        B();
        Iterator it = this.f8012f.iterator();
        while (it.hasNext()) {
            ((com.secret.prettyhezi.Server.n) it.next()).Clear();
        }
    }

    public void c() {
        this.F += "&desc=1";
    }

    public void d() {
        this.f8020n = 3;
        this.f8019m = com.secret.prettyhezi.Game.i.a();
        this.f8021o = com.secret.prettyhezi.Game.i.f6608a.token.token;
    }

    public void e(q qVar, TextView textView) {
        this.f8027u = qVar;
        this.f8026t = textView;
        qVar.b(this);
        int i6 = this.f8009c;
        if (i6 > 0) {
            qVar.c(i6);
        }
        int i7 = this.f8028v;
        if (i7 > 0) {
            qVar.a(i7);
        }
    }

    public void f(String str) {
        this.O = str;
    }

    public void g(String str) {
        this.F = str;
    }

    public com.secret.prettyhezi.Server.n getFirstSelectedItem() {
        Iterator it = this.f8012f.iterator();
        while (it.hasNext()) {
            com.secret.prettyhezi.Server.n nVar = (com.secret.prettyhezi.Server.n) it.next();
            if (nVar.selected) {
                return nVar;
            }
        }
        return null;
    }

    protected int getNewHeight() {
        int i6 = 0;
        for (int i7 = 1; i7 < this.f8014h; i7++) {
            int[] iArr = this.f8016j;
            if (iArr[i7] > iArr[i6]) {
                i6 = i7;
            }
        }
        return this.f8016j[i6] + this.f8013g;
    }

    String getNoDataHint() {
        String str = this.O;
        return str == null ? this.f8008b.s0(C0382R.string.no_data) : str;
    }

    public int getOldScrollY() {
        return this.f8025s;
    }

    public ArrayList<com.secret.prettyhezi.Server.n> getSelectedItems() {
        ArrayList<com.secret.prettyhezi.Server.n> arrayList = new ArrayList<>();
        Iterator it = this.f8012f.iterator();
        while (it.hasNext()) {
            com.secret.prettyhezi.Server.n nVar = (com.secret.prettyhezi.Server.n) it.next();
            if (nVar.selected) {
                arrayList.add(nVar);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public void h() {
        View view = this.P;
        if (view != null) {
            addView(view, new FrameLayout.LayoutParams(-1, -2));
            return;
        }
        String noDataHint = getNoDataHint();
        TextView c6 = g4.d.c(this.f8008b, 18, -16777216, getNoDataHint(), 17);
        if (noDataHint.length() > 50) {
            c6.setPadding(g4.i.r(20.0f), g4.i.r(20.0f), g4.i.r(20.0f), g4.i.r(20.0f));
            c6.setGravity(16);
        }
        addView(c6, new FrameLayout.LayoutParams(-1, g4.i.r(120.0f)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(com.secret.prettyhezi.Server.n[] nVarArr) {
        if (nVarArr != null && nVarArr.length > 0) {
            com.secret.AD.b.q();
            for (com.secret.prettyhezi.Server.n nVar : nVarArr) {
                nVar.pageIndex = this.f8010d;
                setupItem(nVar);
                this.f8012f.add(nVar);
                if (this.f8029w && this.f8012f.size() % this.f8031y == this.f8030x) {
                    this.f8012f.add(new com.secret.prettyhezi.Server.a());
                }
            }
        }
        r();
    }

    protected abstract u l(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.Server.n nVar, int i6);

    public void m() {
        Iterator it = this.f8012f.iterator();
        while (it.hasNext()) {
            ((com.secret.prettyhezi.Server.n) it.next()).selected = false;
        }
    }

    void n() {
        int i6 = this.N;
        if (i6 >= 0 && i6 <= this.f8009c) {
            this.f8010d = Math.max(1, i6);
            this.f8012f.clear();
            removeAllViews();
            L();
            H();
        }
        this.N = -1;
    }

    public void o(int i6) {
        if (i6 > 1) {
            int i7 = this.f8009c;
            if (i6 >= i7 - 2) {
                i6 = i7 - 2;
            }
        }
        this.N = i6;
        if (this.I) {
            return;
        }
        n();
    }

    protected u p(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.Server.n nVar, int i6) {
        u s5 = s(nVar);
        return s5 == null ? l(zZcINlcxH, nVar, i6) : s5;
    }

    protected void q() {
        int i6 = this.f8010d;
        com.secret.prettyhezi.j.q(this.f8019m + v(this.f8010d), this.f8021o, this.f8020n, new b(this.f8008b, this, i6));
    }

    protected void r() {
        this.I = false;
        if (this.f8010d == 1 && this.f8009c <= 0 && this.f8012f.size() == 0 && this.N < 0) {
            h();
            I();
            return;
        }
        if (this.f8010d == 1) {
            q qVar = this.f8027u;
            if (qVar != null) {
                qVar.c(this.f8009c);
            }
            TextView textView = this.f8026t;
            if (textView != null && this.f8009c < 5) {
                textView.setVisibility(8);
            }
        }
        this.f8010d++;
        int i6 = this.f8023q;
        M(i6, this.f8024r + i6);
        if (this.N >= 0) {
            n();
        }
        I();
    }

    protected u s(com.secret.prettyhezi.Server.n nVar) {
        if (this.G.isEmpty()) {
            return null;
        }
        u uVar = (u) this.G.get(0);
        this.G.remove(0);
        return uVar;
    }

    public void setItems(com.secret.prettyhezi.Server.n[] nVarArr) {
        this.f8009c = -1;
        k(nVarArr);
    }

    protected void setupItem(com.secret.prettyhezi.Server.n nVar) {
    }

    protected void setupLayoutParameterForNewItem(FrameLayout.LayoutParams layoutParams) {
        int i6;
        int i7 = 0;
        int i8 = 1;
        while (true) {
            i6 = this.f8014h;
            if (i8 >= i6) {
                break;
            }
            int[] iArr = this.f8016j;
            if (iArr[i8] < iArr[i7]) {
                i7 = i8;
            }
            i8++;
        }
        if (i6 > 1) {
            layoutParams.leftMargin = ((i7 + 1) * this.f8013g) + (this.f8015i * i7);
        }
        int[] iArr2 = this.f8016j;
        int i9 = iArr2[i7] + this.f8013g;
        layoutParams.topMargin = i9;
        iArr2[i7] = i9 + layoutParams.height;
    }

    public u t(com.secret.prettyhezi.Server.n nVar) {
        u uVar = nVar.view;
        if (uVar == null || uVar.f8044i != nVar || indexOfChild(uVar) < 0) {
            return null;
        }
        return uVar;
    }

    protected final u u(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.Server.n nVar, int i6) {
        u p5;
        if (!(nVar instanceof com.secret.prettyhezi.Server.a)) {
            p5 = p(zZcINlcxH, nVar, i6);
        } else if (this.H.isEmpty()) {
            p5 = new com.secret.AD.b(this.f8008b, this.f8015i);
        } else {
            p5 = (u) this.H.get(0);
            this.H.remove(0);
        }
        p5.f8038c = this.f8032z;
        p5.b(nVar);
        String str = this.A;
        if (str != null) {
            p5.f8042g = str;
        }
        p5.n(this.L);
        nVar.view = p5;
        if (this.M) {
            p5.o(true);
        }
        return p5;
    }

    protected String v(int i6) {
        String str = this.F;
        if (str != null) {
            return str.replace("page=999", "page=" + i6);
        }
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    protected int w(FrameLayout.LayoutParams layoutParams) {
        int i6;
        int i7;
        if (this.f8014h <= 1 || (i6 = layoutParams.leftMargin) < (i7 = this.f8015i)) {
            return 0;
        }
        int i8 = this.f8013g;
        if (i6 < (i7 * 2) + i8) {
            return 1;
        }
        if (i6 < (i8 * 2) + (i7 * 3)) {
            return 2;
        }
        return i6 < (i8 * 3) + (i7 * 4) ? 3 : 0;
    }

    public void x(int i6, int i7, long j6, long j7, ArrayList arrayList) {
        this.f8009c = i6;
        int i8 = 1;
        if (i6 > 0) {
            this.f8010d = i7 - 1;
            E(j7);
            if (this.f8010d != 1) {
                q qVar = this.f8027u;
                if (qVar != null) {
                    qVar.c(this.f8009c);
                }
                TextView textView = this.f8026t;
                if (textView != null && this.f8009c < 5) {
                    textView.setVisibility(8);
                }
            }
        }
        this.f8017k = j6;
        this.f8012f = arrayList;
        com.secret.AD.b.q();
        int size = arrayList.size();
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            com.secret.prettyhezi.Server.n nVar = (com.secret.prettyhezi.Server.n) arrayList.get(i10);
            if (nVar instanceof com.secret.prettyhezi.Server.a) {
                ((com.secret.prettyhezi.Server.a) nVar).ResetAD();
            } else {
                i9++;
                nVar.pageIndex = i8;
                if (i9 == 60) {
                    i8++;
                    i9 = 0;
                }
            }
        }
        r();
    }

    public void y(com.secret.prettyhezi.Server.n nVar) {
        if (this.f8012f.size() == 0 && getChildCount() > 0) {
            removeViewAt(0);
        }
        this.f8012f.add(0, nVar);
        u u5 = u(this.f8008b, nVar, this.f8015i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f8015i, u5.getItemHeight());
        setupLayoutParameterForNewItem(layoutParams);
        addView(u5, layoutParams);
        nVar.pa = layoutParams;
        L();
    }

    public void z(com.secret.prettyhezi.Server.n nVar, u uVar) {
        nVar.view = null;
        nVar.pa = null;
        this.f8012f.remove(nVar);
        if (uVar != null) {
            removeView(uVar);
        }
        L();
    }
}
