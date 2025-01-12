package com.secret.prettyhezi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.View.n;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.z;
import com.secret.prettyhezi.s;
import e4.c;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class BCIpAmH extends UoWMF {
    static long E;
    LinearLayout A;
    LinearLayout B;
    e4.c C;
    e4.c D;

    /* renamed from: r  reason: collision with root package name */
    public int[] f5991r = {100, 5, 2, 4, 1, 6, 3, 7};

    /* renamed from: s  reason: collision with root package name */
    boolean f5992s;

    /* renamed from: t  reason: collision with root package name */
    int f5993t;

    /* renamed from: u  reason: collision with root package name */
    LinearLayout f5994u;

    /* renamed from: v  reason: collision with root package name */
    RelativeLayout f5995v;

    /* renamed from: w  reason: collision with root package name */
    com.secret.prettyhezi.View.n f5996w;

    /* renamed from: x  reason: collision with root package name */
    LinearLayout f5997x;

    /* renamed from: y  reason: collision with root package name */
    com.secret.prettyhezi.controls.d f5998y;

    /* renamed from: z  reason: collision with root package name */
    ArrayList f5999z;

    /* loaded from: classes.dex */
    class a implements n.b {
        a() {
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void a(int i6) {
            BCIpAmH bCIpAmH = BCIpAmH.this;
            bCIpAmH.f5993t = bCIpAmH.f5991r[i6];
            bCIpAmH.U0();
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void b(int i6) {
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            String trim = BCIpAmH.this.f5998y.f8305c.getText().toString().trim();
            if (trim.length() == 0) {
                BCIpAmH.this.y("Please input search text");
            } else {
                BCIpAmH.this.S0(trim, true);
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            String trim = BCIpAmH.this.f5998y.f8305c.getText().toString().trim();
            if (trim.length() == 0) {
                BCIpAmH.this.y("Please input search text");
            } else {
                BCIpAmH.this.S0(trim, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                BCIpAmH.this.f5999z.clear();
                BCIpAmH.this.c1();
                BCIpAmH.this.b1();
            }
        }

        d() {
        }

        @Override // g4.f
        public void a(View view) {
            BCIpAmH.this.B("清空搜索记录？", new a(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6005d;

        e(String str) {
            this.f6005d = str;
        }

        @Override // g4.f
        public void a(View view) {
            BCIpAmH.this.S0(this.f6005d, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {
        f() {
        }

        @Override // g4.f
        public void a(View view) {
            BCIpAmH.this.a1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends s.g {
        g(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            o oVar = (o) com.secret.prettyhezi.f.d(str, o.class);
            if (oVar.code == 200) {
                BCIpAmH.this.X0(str);
            } else {
                f(oVar.err);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6009d;

        h(String str) {
            this.f6009d = str;
        }

        @Override // g4.f
        public void a(View view) {
            BCIpAmH.this.S0(this.f6009d, false);
        }
    }

    void S0(String str, boolean z5) {
        if (System.currentTimeMillis() - E < 5000) {
            y("请不要频繁搜索");
            return;
        }
        E = System.currentTimeMillis();
        int Z0 = Z0();
        McNiD.S0(this, str, "api/search/json?name=" + str + "&t=" + Z0 + "&page=999", this.f5993t);
        if (z5) {
            this.f5999z.remove(str);
            if (this.f5999z.size() >= 10) {
                ArrayList arrayList = this.f5999z;
                arrayList.remove(arrayList.size() - 1);
            }
            this.f5999z.add(0, str);
            c1();
            b1();
        }
    }

    int T0(int i6) {
        int i7 = 0;
        while (true) {
            int[] iArr = this.f5991r;
            if (i7 >= iArr.length) {
                return 0;
            }
            if (iArr[i7] == i6) {
                return i7;
            }
            i7++;
        }
    }

    void U0() {
        String[] strArr;
        this.f5999z = new ArrayList();
        String h6 = g4.g.a().h("searchHistory" + this.f5993t, HttpUrl.FRAGMENT_ENCODE_SET);
        if (h6.length() > 1 && (strArr = ((n) com.secret.prettyhezi.f.d(h6, n.class)).items) != null && strArr.length > 0) {
            for (String str : strArr) {
                this.f5999z.add(str);
            }
        }
        c1();
        this.C.removeAllViews();
        a1();
    }

    void V0() {
        LinearLayout linearLayout = new LinearLayout(this);
        this.A = linearLayout;
        linearLayout.setBackgroundColor(-1);
        this.A.setOrientation(1);
        this.A.setPadding(0, 0, 0, g4.i.r(8.0f));
        this.f5997x.addView(this.A, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setGravity(16);
        this.A.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        TextView b6 = g4.d.b(this, 14.0f, -7829368, "最近搜索");
        b6.setPadding(g4.i.r(12.0f), g4.i.r(12.0f), 0, g4.i.r(12.0f));
        linearLayout2.addView(b6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView c6 = g4.d.c(this, 14, -16777216, "清空", 17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(80.0f), g4.i.r(32.0f));
        layoutParams.rightMargin = g4.i.r(12.0f);
        int r5 = g4.i.r(12.0f);
        layoutParams.bottomMargin = r5;
        layoutParams.topMargin = r5;
        c6.setBackground(g4.i.b(Color.parseColor("#f0f0f0"), 8.0f));
        linearLayout2.addView(c6, layoutParams);
        c6.setOnClickListener(new d());
        e4.c cVar = new e4.c(this);
        this.D = cVar;
        cVar.setPadding(g4.i.r(12.0f), 0, 0, 0);
        this.A.addView(this.D, new LinearLayout.LayoutParams(-1, -2));
        W(this.A, Color.parseColor("#cccccc"), 0.5f, 12, 0, 12);
    }

    void W0() {
        LinearLayout linearLayout = new LinearLayout(this);
        this.B = linearLayout;
        linearLayout.setBackgroundColor(-1);
        this.B.setOrientation(1);
        this.B.setPadding(g4.i.r(12.0f), 0, 0, g4.i.r(8.0f));
        this.f5997x.addView(this.B, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setGravity(16);
        this.B.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        TextView b6 = g4.d.b(this, 14.0f, -7829368, "热门搜索");
        b6.setPadding(0, g4.i.r(12.0f), 0, g4.i.r(12.0f));
        linearLayout2.addView(b6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView c6 = g4.d.c(this, 14, -65536, s0(C0382R.string.Switch), 17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(80.0f), g4.i.r(32.0f));
        layoutParams.rightMargin = g4.i.r(12.0f);
        int r5 = g4.i.r(12.0f);
        layoutParams.bottomMargin = r5;
        layoutParams.topMargin = r5;
        c6.setBackground(g4.i.b(Color.parseColor("#f0f0f0"), 8.0f));
        linearLayout2.addView(c6, layoutParams);
        c6.setOnClickListener(new f());
        e4.c cVar = new e4.c(this);
        this.C = cVar;
        this.B.addView(cVar, new LinearLayout.LayoutParams(-1, -2));
    }

    void X0(String str) {
        this.C.removeAllViews();
        String[] strArr = ((o) com.secret.prettyhezi.f.d(str, o.class)).data;
        if (strArr == null) {
            return;
        }
        for (String str2 : strArr) {
            TextView c6 = g4.d.c(this, 14, Color.parseColor("#333333"), str2, 17);
            c6.setSingleLine();
            c6.setPadding(g4.i.r(8.0f), 0, g4.i.r(8.0f), 0);
            c.a aVar = new c.a(-2, g4.i.r(32.0f));
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = g4.i.r(6.0f);
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = g4.i.r(10.0f);
            c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#f0f0f0"), 8.0f), g4.i.b(Color.parseColor("#aaaaaa"), 8.0f)));
            this.C.addView(c6, aVar);
            c6.setOnClickListener(new h(str2));
        }
    }

    public String Y0(int i6) {
        int i7;
        if (i6 != 100) {
            switch (i6) {
                case 1:
                    i7 = C0382R.string.Image;
                    break;
                case 2:
                    i7 = C0382R.string.ShortVideo;
                    break;
                case 3:
                    i7 = C0382R.string.Novel;
                    break;
                case 4:
                    i7 = C0382R.string.Film;
                    break;
                case 5:
                    i7 = C0382R.string.LongVideo;
                    break;
                case 6:
                    i7 = C0382R.string.Gallery;
                    break;
                case 7:
                    i7 = C0382R.string.Audios;
                    break;
                default:
                    return HttpUrl.FRAGMENT_ENCODE_SET;
            }
        } else {
            i7 = C0382R.string.Box;
        }
        return s0(i7);
    }

    int Z0() {
        int i6 = this.f5993t;
        if (i6 == 100) {
            return 8;
        }
        return i6;
    }

    void a1() {
        j.m(com.secret.prettyhezi.Server.v.f7132a + "api/search/tags/rand/json?t=" + Z0(), new g(this));
    }

    void b1() {
        n nVar = new n();
        String[] strArr = new String[this.f5999z.size()];
        nVar.items = strArr;
        nVar.items = (String[]) this.f5999z.toArray(strArr);
        g4.g a6 = g4.g.a();
        a6.o("searchHistory" + this.f5993t, com.secret.prettyhezi.f.e(nVar));
    }

    void c1() {
        if (this.f5999z.size() == 0) {
            this.A.setVisibility(8);
            return;
        }
        this.A.setVisibility(0);
        this.D.removeAllViews();
        Iterator it = this.f5999z.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            TextView c6 = g4.d.c(this, 14, Color.parseColor("#333333"), str, 17);
            c6.setSingleLine();
            c6.setPadding(g4.i.r(8.0f), 0, g4.i.r(8.0f), 0);
            c.a aVar = new c.a(-2, g4.i.r(32.0f));
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = g4.i.r(6.0f);
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = g4.i.r(10.0f);
            c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#f0f0f0"), 8.0f), g4.i.b(Color.parseColor("#aaaaaa"), 8.0f)));
            this.D.addView(c6, aVar);
            c6.setOnClickListener(new e(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.secret.prettyhezi.controls.u a6;
        View.OnClickListener cVar;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        this.f5992s = true;
        if (extras != null) {
            this.f5993t = extras.getInt("type");
        }
        LinearLayout C0 = C0();
        this.f5994u = C0;
        if (this.f5992s) {
            this.f5995v = M(C0, HttpUrl.FRAGMENT_ENCODE_SET);
            String[] strArr = new String[this.f5991r.length];
            int i6 = 0;
            while (true) {
                int[] iArr = this.f5991r;
                if (i6 >= iArr.length) {
                    break;
                }
                strArr[i6] = Y0(iArr[i6]);
                i6++;
            }
            this.f5996w = new com.secret.prettyhezi.View.n(this, strArr, 14, new a());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(42.0f));
            layoutParams.topMargin = g4.i.r(1.0f);
            this.f5994u.addView(this.f5996w, layoutParams);
            V(this.f5994u, Color.parseColor("#cccc00"), 2.0f, 0, 1);
            this.f5997x = e(this.f5994u);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setPadding(g4.i.r(50.0f), 0, 0, 0);
            linearLayout.setBackgroundColor(-1);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(0);
            this.f5995v.addView(linearLayout, 0, new RelativeLayout.LayoutParams(-1, -1));
            com.secret.prettyhezi.controls.d dVar = new com.secret.prettyhezi.controls.d(this);
            this.f5998y = dVar;
            dVar.setBackground(ZZcINlcxH.f0(Color.parseColor("#f2f2f2"), 19.0f));
            this.f5998y.f8305c.setTextSize(14.0f);
            linearLayout.addView(this.f5998y, new LinearLayout.LayoutParams(0, g4.i.r(40.0f), 1.0f));
            com.secret.prettyhezi.controls.j.a(this.f5998y.f8305c, 16, 23);
            a6 = com.secret.prettyhezi.controls.u.a(new z(this, C0382R.drawable.ic_search), 26, 26);
            linearLayout.addView(a6, new LinearLayout.LayoutParams(g4.i.r(48.0f), g4.i.r(48.0f)));
            cVar = new b();
        } else {
            this.f5995v = M(C0, s0(C0382R.string.Search) + " " + Y0(this.f5993t));
            V(this.f5994u, Color.parseColor("#cccccc"), 0.5f, 0, 0);
            this.f5997x = e(this.f5994u);
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setBackgroundColor(-1);
            linearLayout2.setGravity(17);
            linearLayout2.setOrientation(0);
            this.f5997x.addView(linearLayout2, new LinearLayout.LayoutParams(-1, g4.i.r(70.0f)));
            com.secret.prettyhezi.controls.d dVar2 = new com.secret.prettyhezi.controls.d(this);
            this.f5998y = dVar2;
            dVar2.setBackground(ZZcINlcxH.f0(Color.parseColor("#f2f2f2"), 19.0f));
            this.f5998y.f8305c.setTextSize(14.0f);
            int r5 = g4.i.r(260.0f);
            int r6 = o().x - g4.i.r(160.0f);
            if (r6 < r5) {
                r5 = r6;
            }
            linearLayout2.addView(this.f5998y, new LinearLayout.LayoutParams(r5, g4.i.r(40.0f)));
            com.secret.prettyhezi.controls.j.a(this.f5998y.f8305c, 16, 23);
            a6 = com.secret.prettyhezi.controls.u.a(new z(this, C0382R.drawable.ic_search), 26, 26);
            linearLayout2.addView(a6, new LinearLayout.LayoutParams(g4.i.r(48.0f), g4.i.r(48.0f)));
            cVar = new c();
        }
        a6.setOnClickListener(cVar);
        V0();
        W0();
        if (this.f5992s) {
            this.f5996w.setCurrentTab(T0(this.f5993t));
        } else {
            U0();
        }
    }
}
