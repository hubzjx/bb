package com.secret.prettyhezi.message;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.A0TdcT;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.n;
import com.secret.prettyhezi.Server.q;
import com.secret.prettyhezi.Server.r;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.View.a0;
import com.secret.prettyhezi.View.t;
import com.secret.prettyhezi.VpEEnM;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.u;
import com.secret.prettyhezi.controls.z;
import com.secret.prettyhezi.message.d;
import com.secret.prettyhezi.s;
import e4.c;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class HYYYBI extends UoWMF implements x0.b {
    static final String[] B = {"公告", "会话", "通知", "系统", "群聊"};
    static f[] C = null;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f8672r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f8673s;

    /* renamed from: t  reason: collision with root package name */
    x0.a f8674t;

    /* renamed from: u  reason: collision with root package name */
    TextView f8675u;

    /* renamed from: v  reason: collision with root package name */
    a0[] f8676v = new a0[5];

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f8677w = null;

    /* renamed from: x  reason: collision with root package name */
    int f8678x = 0;

    /* renamed from: y  reason: collision with root package name */
    h f8679y = null;

    /* renamed from: z  reason: collision with root package name */
    e4.c f8680z = null;
    int A = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8681d;

        a(int i6) {
            this.f8681d = i6;
        }

        @Override // g4.f
        public void a(View view) {
            HYYYBI hyyybi = HYYYBI.this;
            a0[] a0VarArr = hyyybi.f8676v;
            int i6 = this.f8681d;
            if (a0VarArr[i6].f7848f) {
                hyyybi.f8674t.scrollTo(0, 0);
            } else {
                hyyybi.a1(i6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            HYYYBI.this.v0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ q f8684d;

        c(q qVar) {
            this.f8684d = qVar;
        }

        @Override // g4.f
        public void a(View view) {
            HYYYBI.this.N0(VpEEnM.class, this.f8684d.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8686d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f8687e;

        d(int i6, String str) {
            this.f8686d = i6;
            this.f8687e = str;
        }

        @Override // g4.f
        public void a(View view) {
            int i6;
            ArrayList arrayList = HYYYBI.this.f8679y.f8012f;
            if (arrayList != null) {
                int f6 = MainApplication.f();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.secret.prettyhezi.message.e eVar = (com.secret.prettyhezi.message.e) ((n) it.next());
                    com.secret.prettyhezi.message.e eVar2 = eVar.notify;
                    int i7 = eVar2.target;
                    int i8 = this.f8686d;
                    if ((i7 == i8 && f6 == eVar2.sender) || (eVar2.sender == i8 && f6 == i7)) {
                        i6 = eVar.id;
                        break;
                    }
                }
            }
            i6 = 0;
            AWsQxAQ.U0(HYYYBI.this, i6, this.f8686d, this.f8687e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends s.g {
        e(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            g gVar = (g) com.secret.prettyhezi.f.d(str, g.class);
            if (gVar.code != 200) {
                f(gVar.err);
                return;
            }
            HYYYBI.C = gVar.data;
            HYYYBI.this.X0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f implements Serializable {
        public String name;
        public int target;

        f() {
        }
    }

    /* loaded from: classes.dex */
    static class g extends w {
        public f[] data;

        g() {
        }
    }

    void T0() {
        u a6 = u.a(new z(this, C0382R.drawable.ic_back), 32, 32);
        a6.setBackground(g4.i.d(new ColorDrawable(-1), g4.i.b(Color.parseColor("#cccccc"), 20.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(42.0f), g4.i.r(42.0f));
        layoutParams.leftMargin = g4.i.r(6.0f);
        this.f8673s.addView(a6, layoutParams);
        a6.setId(11);
        a6.setOnClickListener(new b());
    }

    void U0(int i6, String str) {
        this.f8676v[i6] = new a0(this, str);
        this.f8673s.addView(this.f8676v[i6], new LinearLayout.LayoutParams(0, -1, 1.0f));
        this.f8676v[i6].setOnClickListener(new a(i6));
    }

    void V0() {
        if (this.f8677w == null) {
            LinearLayout linearLayout = new LinearLayout(this);
            this.f8677w = linearLayout;
            linearLayout.setOrientation(1);
            this.f8677w.setPadding(0, 0, 0, g4.i.r(10.0f));
            this.f8677w.setBackgroundColor(Color.parseColor("#f0f0f0"));
            r rVar = r.notices;
            if (rVar != null) {
                q[] qVarArr = rVar.data.items;
                if (qVarArr.length == 0) {
                    return;
                }
                for (q qVar : qVarArr) {
                    k kVar = new k(this, qVar.name);
                    this.f8677w.addView(kVar, new LinearLayout.LayoutParams(-1, -2));
                    W(this.f8677w, Color.parseColor("#cccccc"), 0.5f, 12, 0, 12);
                    kVar.setOnClickListener(new c(qVar));
                }
            }
        }
    }

    void W0() {
        this.f8680z = new e4.c(this);
        X0();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(8.0f);
        layoutParams.bottomMargin = g4.i.r(6.0f);
        this.f8672r.addView(this.f8680z, 2, layoutParams);
    }

    void X0() {
        int i6;
        if (C == null) {
            Z0();
        } else if (this.f8680z.getChildCount() != 0) {
        } else {
            int i7 = o().x;
            int r5 = g4.i.r(12.0f);
            int r6 = g4.i.r(110.0f);
            int i8 = r5 * 3;
            if (i7 < (r6 * 2) + i8) {
                i6 = 1;
            } else {
                int i9 = r5 * 4;
                if (i7 < (r6 * 3) + i9) {
                    int i10 = (i7 - i8) / 2;
                    i6 = 2;
                } else {
                    int i11 = (i7 - i9) / 3;
                    i6 = 3;
                }
            }
            int i12 = i6 + 1;
            int i13 = (i7 - (r5 * i12)) / i6;
            int r7 = g4.i.r(180.0f);
            if (i13 > r7) {
                i13 = r7;
            }
            int i14 = (i7 - (i6 * i13)) / i12;
            int i15 = 0;
            while (true) {
                f[] fVarArr = C;
                if (i15 >= fVarArr.length) {
                    return;
                }
                f fVar = fVarArr[i15];
                String str = fVar.name;
                int i16 = fVar.target;
                TextView c6 = g4.d.c(this, 14, -1, str, 17);
                c6.setBackground(g4.i.d(g4.i.b(-16777216, 6.0f), g4.i.b(Color.parseColor("#666666"), 6.0f)));
                c6.setOnClickListener(new d(i16, str));
                c.a aVar = new c.a(i13, g4.i.r(36.0f));
                ((ViewGroup.MarginLayoutParams) aVar).topMargin = g4.i.r(6.0f);
                ((ViewGroup.MarginLayoutParams) aVar).leftMargin = i14;
                this.f8680z.addView(c6, aVar);
                i15++;
            }
        }
    }

    public void Y0() {
        boolean f6 = com.secret.prettyhezi.message.c.f();
        this.f8676v[4].setVisibility(f6 ? 0 : 8);
        if (this.f8678x == 4 && !f6) {
            a1(0);
        }
        if (f6) {
            this.f8676v[4].d(com.secret.prettyhezi.message.c.e());
            if (this.f8678x == 4) {
                a1(4);
            }
        }
    }

    void Z0() {
        com.secret.prettyhezi.j.m(v.f7132a + "/notify/message/list/json", new e(this));
    }

    @Override // x0.b
    public void a(x0.c cVar) {
    }

    void a1(int i6) {
        com.secret.prettyhezi.message.a[] aVarArr;
        this.f8678x = i6;
        this.f8675u.setVisibility(i6 == 1 ? 0 : 8);
        int i7 = 0;
        while (true) {
            a0[] a0VarArr = this.f8676v;
            if (i7 >= a0VarArr.length) {
                break;
            }
            a0VarArr[i7].b(i6 == i7);
            i7++;
        }
        this.f8674t.removeAllViews();
        if (i6 == 0) {
            V0();
            this.f8674t.addView(this.f8677w, new FrameLayout.LayoutParams(-1, -2));
        } else if (i6 == 4) {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(g4.i.r(10.0f), g4.i.r(6.0f), g4.i.r(10.0f), g4.i.r(2.0f));
            this.f8674t.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
            for (com.secret.prettyhezi.message.a aVar : com.secret.prettyhezi.message.c.f8698a) {
                com.secret.prettyhezi.message.b bVar = new com.secret.prettyhezi.message.b(this);
                bVar.a(aVar);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = g4.i.r(4.0f);
                linearLayout.addView(bVar, layoutParams);
            }
        } else {
            h hVar = new h(this, i6);
            this.f8679y = hVar;
            this.f8674t.addView(hVar, new FrameLayout.LayoutParams(-1, -2));
            if (i6 == 3 || i6 == 2) {
                this.f8676v[i6].d(0);
                d.a aVar2 = MainApplication.f6715v;
                if (aVar2 != null) {
                    if (i6 == 3) {
                        aVar2.announce = 0;
                    } else if (i6 == 2) {
                        aVar2.remind = 0;
                    }
                }
            } else {
                this.f8679y.f("  ");
            }
        }
        b1(i6 == 1);
    }

    @Override // x0.b
    public void b() {
    }

    void b1(boolean z5) {
        e4.c cVar;
        int i6;
        if (z5) {
            if (this.f8680z == null) {
                W0();
            }
            cVar = this.f8680z;
            i6 = 0;
        } else {
            cVar = this.f8680z;
            if (cVar == null) {
                return;
            }
            i6 = 8;
        }
        cVar.setVisibility(i6);
    }

    @Override // x0.b
    public void c(int i6, boolean z5, boolean z6) {
        if (this.A == i6) {
            return;
        }
        this.A = i6;
        if (this.f8674t.getChildCount() > 0) {
            View childAt = this.f8674t.getChildAt(0);
            if (childAt instanceof t) {
                ((t) childAt).D(i6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8672r = B0(3, 4);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f8673s = linearLayout;
        int i6 = 0;
        linearLayout.setOrientation(0);
        this.f8673s.setBackgroundColor(-1);
        this.f8673s.setGravity(16);
        this.f8672r.addView(this.f8673s, new LinearLayout.LayoutParams(-1, g4.i.r(52.0f)));
        this.f8675u = A0TdcT.S0(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(8.0f);
        int r5 = g4.i.r(12.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        this.f8672r.addView(this.f8675u, layoutParams);
        x0.a aVar = new x0.a(this);
        this.f8674t = aVar;
        aVar.setScrollViewCallbacks(this);
        this.f8672r.addView(this.f8674t, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        T0();
        for (int i7 = 0; i7 < this.f8676v.length; i7++) {
            U0(i7, B[i7]);
        }
        boolean f6 = com.secret.prettyhezi.message.c.f();
        this.f8676v[4].setVisibility(f6 ? 0 : 8);
        if (f6) {
            this.f8676v[4].d(com.secret.prettyhezi.message.c.e());
        }
        d.a aVar2 = MainApplication.f6715v;
        int i8 = 1;
        if (aVar2 != null) {
            this.f8676v[3].d(aVar2.announce);
            this.f8676v[2].d(aVar2.remind);
            this.f8676v[1].d(aVar2.message);
        }
        if (r.GetNoticeVersion() > g4.g.a().d(r.keyCheckedNoticeVersion, 0)) {
            this.f8676v[0].d(1);
            g4.g.a().n(r.keyCheckedNoticeVersion, r.GetNoticeVersion());
        }
        while (true) {
            a0[] a0VarArr = this.f8676v;
            if (i8 >= a0VarArr.length) {
                break;
            } else if (a0VarArr[i8].a() > 0) {
                i6 = i8;
                break;
            } else {
                i8++;
            }
        }
        a1(i6);
        g4.g.a().o("keyLastPopupNoticeDateALL", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        int i6 = this.f8678x;
        if (i6 == 1) {
            a1(i6);
        }
        Y0();
    }
}
