package com.secret.prettyhezi.Upload;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.abc;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Server.d0;
import com.secret.prettyhezi.Server.e0;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.Upload.j;
import com.secret.prettyhezi.Video.MSqCZ2mQ;
import com.secret.prettyhezi.Video.NRxYacSEB;
import com.secret.prettyhezi.WOqyeiK;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import e4.c;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class XXAJdUV0R extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    int f7402r;

    /* renamed from: s  reason: collision with root package name */
    int f7403s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f7404t;

    /* renamed from: u  reason: collision with root package name */
    public LinearLayout f7405u;

    /* renamed from: v  reason: collision with root package name */
    d0 f7406v;

    /* renamed from: w  reason: collision with root package name */
    d0 f7407w;

    /* renamed from: x  reason: collision with root package name */
    LinearLayout f7408x;

    /* renamed from: y  reason: collision with root package name */
    String[] f7409y = {"左边包含广告", "右边包含广告"};

    /* renamed from: z  reason: collision with root package name */
    com.secret.prettyhezi.controls.c[] f7410z = new com.secret.prettyhezi.controls.c[2];
    String[] A = {"左边更清晰", "右边更清晰", "差不多清晰"};
    com.secret.prettyhezi.controls.c[] B = new com.secret.prettyhezi.controls.c[3];
    String[] C = {"左边更完整", "右边更完整", "差不多完整"};
    com.secret.prettyhezi.controls.c[] D = new com.secret.prettyhezi.controls.c[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            if (XXAJdUV0R.this.isDestroyed() || XXAJdUV0R.this.isFinishing()) {
                return;
            }
            k kVar = (k) com.secret.prettyhezi.f.d(str, k.class);
            if (kVar.code != 200) {
                com.secret.prettyhezi.s.d(XXAJdUV0R.this, kVar.err);
                return;
            }
            XXAJdUV0R xXAJdUV0R = XXAJdUV0R.this;
            d0[] d0VarArr = kVar.data;
            xXAJdUV0R.f7406v = d0VarArr[0];
            xXAJdUV0R.f7407w = d0VarArr[1];
            xXAJdUV0R.e1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d0 f7412d;

        b(d0 d0Var) {
            this.f7412d = d0Var;
        }

        @Override // g4.f
        protected void a(View view) {
            d0 d0Var = this.f7412d;
            String[] strArr = d0Var.ps;
            if (strArr == null || strArr.length <= 0) {
                XXAJdUV0R.this.c1(d0Var.f7110me);
            } else {
                WOqyeiK.T0(XXAJdUV0R.this, strArr, d0Var.f7110me.f7128p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                XXAJdUV0R.this.Z0(false, null);
            }
        }

        c() {
        }

        @Override // g4.f
        protected void a(View view) {
            XXAJdUV0R.this.B("确认视频内容不重复？", new a(), false);
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
                XXAJdUV0R.this.a1();
            }
        }

        d() {
        }

        @Override // g4.f
        protected void a(View view) {
            XXAJdUV0R.this.B("确认视频内容重复？", new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.c[] f7418d;

        e(com.secret.prettyhezi.controls.c[] cVarArr) {
            this.f7418d = cVarArr;
        }

        @Override // g4.f
        protected void a(View view) {
            int i6 = 0;
            while (true) {
                com.secret.prettyhezi.controls.c[] cVarArr = this.f7418d;
                if (i6 >= cVarArr.length) {
                    return;
                }
                com.secret.prettyhezi.controls.c cVar = cVarArr[i6];
                if (view != cVar) {
                    cVar.setSelected(false);
                } else {
                    cVar.setSelected(true);
                }
                i6++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {
        f() {
        }

        @Override // g4.f
        protected void a(View view) {
            XXAJdUV0R.this.b1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j.a[] f7421a;

        g(j.a[] aVarArr) {
            this.f7421a = aVarArr;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            XXAJdUV0R.this.Z0(true, this.f7421a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends s.g {
        h(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            if (XXAJdUV0R.this.isDestroyed() || XXAJdUV0R.this.isFinishing()) {
                return;
            }
            com.secret.prettyhezi.Server.z zVar = (com.secret.prettyhezi.Server.z) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.Server.z.class);
            if (zVar.code != 200) {
                d(zVar.err);
                return;
            }
            int size = ZZcINlcxH.f8162n.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Activity activity = (Activity) ZZcINlcxH.f8162n.get(size);
                if (activity instanceof KSglG) {
                    ((KSglG) activity).S0();
                    break;
                }
                size--;
            }
            XXAJdUV0R.this.finish();
        }
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        this.f7408x = linearLayout;
        linearLayout.setOrientation(1);
        this.f7405u.addView(this.f7408x, new LinearLayout.LayoutParams(-1, -2));
        U(this.f7408x, "视频内容不重复", 30, 30).setOnClickListener(new c());
        U(this.f7408x, "视频内容重复", 40, 30).setOnClickListener(new d());
    }

    void T0() {
        int r5 = g4.i.r(160.0f);
        int r6 = o().x - g4.i.r(18.0f);
        if (r6 > r5 * 3) {
            r6 /= 3;
        } else if (r6 > r5 * 2) {
            r6 /= 2;
        }
        e4.c V0 = V0();
        int i6 = 0;
        while (true) {
            com.secret.prettyhezi.controls.c[] cVarArr = this.f7410z;
            if (i6 >= cVarArr.length) {
                break;
            }
            cVarArr[i6] = new com.secret.prettyhezi.controls.c(this, this.f7409y[i6]);
            V0.addView(this.f7410z[i6], new c.a(r6, -2));
            i6++;
        }
        V(this.f7408x, Color.parseColor("#888888"), 0.5f, 0, 0);
        X0(this.B, this.A, r6);
        if (this.f7403s == 5) {
            V(this.f7408x, Color.parseColor("#888888"), 0.5f, 0, 0);
            X0(this.D, this.C, r6);
        }
    }

    void U0() {
        String str;
        LinearLayout W0 = W0(this.f7405u);
        W0.setGravity(17);
        int r5 = (o().x - g4.i.r(10.0f)) / 2;
        com.secret.prettyhezi.Server.l lVar = this.f7406v.co;
        int i6 = (lVar.f7127h * r5) / lVar.f7129w;
        com.secret.prettyhezi.Server.l lVar2 = this.f7407w.co;
        int max = Math.max(i6, (lVar2.f7127h * r5) / lVar2.f7129w);
        W0.addView(Y0(this.f7406v, r5, max), 0, new LinearLayout.LayoutParams(0, max, 1.0f));
        W0.addView(Y0(this.f7407w, r5, max), new LinearLayout.LayoutParams(0, max, 1.0f));
        int r6 = g4.i.r(6.0f);
        String str2 = this.f7406v.na;
        if ((str2 != null && str2.length() > 0) || ((str = this.f7407w.na) != null && str.length() > 0)) {
            TextView b6 = g4.d.b(this, 12.0f, -16777216, "标题：" + this.f7406v.na);
            TextView b7 = g4.d.b(this, 12.0f, -16777216, "标题：" + this.f7407w.na);
            b6.setPadding(r6, r6, r6, r6);
            b7.setPadding(r6, r6, r6, r6);
            LinearLayout W02 = W0(this.f7405u);
            W02.addView(b6, 0, new LinearLayout.LayoutParams(0, -2, 1.0f));
            W02.addView(b7, new LinearLayout.LayoutParams(0, -2, 1.0f));
        }
        int r7 = g4.i.r(26.0f);
        if (this.f7406v.sz > 0 && this.f7407w.sz > 0) {
            TextView c6 = g4.d.c(this, 12, -16777216, "大小：" + g4.i.D(this.f7406v.sz), 16);
            TextView c7 = g4.d.c(this, 12, -16777216, "大小：" + g4.i.D(this.f7407w.sz), 16);
            c6.setPadding(r6, 0, 0, 0);
            c7.setPadding(r6, 0, 0, 0);
            LinearLayout W03 = W0(this.f7405u);
            W03.addView(c6, 0, new LinearLayout.LayoutParams(0, r7, 1.0f));
            W03.addView(c7, new LinearLayout.LayoutParams(0, r7, 1.0f));
        }
        if (this.f7406v.dur <= 0 || this.f7407w.dur <= 0) {
            return;
        }
        TextView c8 = g4.d.c(this, 12, -16777216, "时长：" + g4.i.G(this.f7406v.dur), 16);
        TextView c9 = g4.d.c(this, 12, -16777216, "时长：" + g4.i.G(this.f7407w.dur), 16);
        c8.setPadding(g4.i.r(6.0f), 0, 0, 0);
        c9.setPadding(g4.i.r(6.0f), 0, 0, 0);
        LinearLayout W04 = W0(this.f7405u);
        W04.addView(c8, 0, new LinearLayout.LayoutParams(0, r7, 1.0f));
        W04.addView(c9, new LinearLayout.LayoutParams(0, r7, 1.0f));
    }

    e4.c V0() {
        e4.c cVar = new e4.c(this);
        cVar.setPadding(0, g4.i.r(20.0f), 0, g4.i.r(10.0f));
        this.f7408x.addView(cVar, new LinearLayout.LayoutParams(-1, -2));
        return cVar;
    }

    LinearLayout W0(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.setOrientation(0);
        View view = new View(this);
        view.setBackgroundColor(Color.parseColor("#888888"));
        linearLayout2.addView(view, new LinearLayout.LayoutParams(g4.i.r(1.5f), -1));
        return linearLayout2;
    }

    void X0(com.secret.prettyhezi.controls.c[] cVarArr, String[] strArr, int i6) {
        e4.c V0 = V0();
        for (int i7 = 0; i7 < cVarArr.length; i7++) {
            cVarArr[i7] = new com.secret.prettyhezi.controls.c(this, C0382R.drawable.gesture_normal_red, C0382R.drawable.gesture_pressed_red, strArr[i7]);
            c.a aVar = new c.a(i6, -2);
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = g4.i.r(6.0f);
            V0.addView(cVarArr[i7], aVar);
            cVarArr[i7].setOnClickListener(new e(cVarArr));
        }
    }

    RelativeLayout Y0(d0 d0Var, int i6, int i7) {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        com.secret.prettyhezi.controls.q qVar = new com.secret.prettyhezi.controls.q(this, d0Var.co.f7128p, i6, i7);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        relativeLayout.addView(qVar, layoutParams);
        com.secret.prettyhezi.controls.z zVar = new com.secret.prettyhezi.controls.z(this, C0382R.drawable.play_normal);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(g4.i.r(40.0f), g4.i.r(40.0f));
        layoutParams2.addRule(13, -1);
        relativeLayout.addView(zVar, layoutParams2);
        b bVar = new b(d0Var);
        zVar.setOnClickListener(bVar);
        qVar.setOnClickListener(bVar);
        return relativeLayout;
    }

    void Z0(boolean z5, j.a[] aVarArr) {
        j jVar = new j(this.f7402r, z5, this.f7403s);
        jVar.items = aVarArr;
        com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "repeatedly/audit/json", jVar, true, new h(this));
    }

    void a1() {
        this.f7408x.removeAllViews();
        this.f7408x.setPadding(g4.i.r(8.0f), g4.i.r(20.0f), g4.i.r(8.0f), g4.i.r(20.0f));
        this.f7408x.addView(g4.d.b(this, 14.0f, -65536, "请填写如下选项再次提交"), new LinearLayout.LayoutParams(-1, -2));
        T0();
        U(this.f7408x, "提交举报", 40, 30).setOnClickListener(new f());
    }

    void b1() {
        boolean isSelected = this.f7410z[0].isSelected();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (isSelected) {
            str = HttpUrl.FRAGMENT_ENCODE_SET + this.f7409y[0] + "\n";
        }
        if (this.f7410z[1].isSelected()) {
            str = str + this.f7409y[1] + "\n";
        }
        String str2 = this.f7410z[0].isSelected() ? "1" : "0";
        String str3 = this.f7410z[1].isSelected() ? "1" : "0";
        int i6 = 0;
        while (true) {
            if (i6 >= this.A.length) {
                i6 = -1;
                break;
            } else if (this.B[i6].isSelected()) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 == -1) {
            y("请判断清晰度");
            return;
        }
        String str4 = str + this.A[i6] + "\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(this.B[0].isSelected() ? "1" : "0");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str3);
        sb3.append(this.B[1].isSelected() ? "1" : "0");
        String sb4 = sb3.toString();
        if (this.f7403s == 5) {
            int i7 = 0;
            while (true) {
                if (i7 >= this.C.length) {
                    i7 = -1;
                    break;
                } else if (this.D[i7].isSelected()) {
                    break;
                } else {
                    i7++;
                }
            }
            if (i7 == -1) {
                y("请判断完整度");
                return;
            }
            str4 = str4 + this.C[i7] + "\n";
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb2);
            sb5.append(this.D[0].isSelected() ? "1" : "0");
            sb2 = sb5.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(sb4);
            sb6.append(this.D[1].isSelected() ? "1" : "0");
            sb4 = sb6.toString();
        }
        j.a aVar = new j.a();
        j.a[] aVarArr = {new j.a(), aVar};
        j.a aVar2 = aVarArr[0];
        aVar2.id = this.f7406v.id;
        aVar2.res = sb2;
        aVar.id = this.f7407w.id;
        aVar.res = sb4;
        B(str4, new g(aVarArr), false);
    }

    public void c1(e0 e0Var) {
        if (!g4.g.a().b("keyVideoAutoLandscape") || e0Var.f7129w <= e0Var.f7127h) {
            MSqCZ2mQ.T0(this, e0Var.f7128p, this.f7403s, 0, 0L);
        } else {
            NRxYacSEB.z1(this, e0Var.f7128p, this.f7403s, 0, 0L);
        }
    }

    void d1() {
        G0();
        com.secret.prettyhezi.j.m(com.secret.prettyhezi.Server.v.f7132a + "repeatedly/audit/show/json?t=" + this.f7403s + "&id=" + this.f7402r, new a(this));
    }

    void e1() {
        this.f7405u.removeAllViews();
        U0();
        S0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7402r = extras.getInt("id");
            this.f7403s = extras.getInt("type");
        }
        LinearLayout C0 = C0();
        this.f7404t = C0;
        M(C0, abc.ams("s10"));
        LinearLayout e6 = e(this.f7404t);
        this.f7405u = e6;
        e6.setGravity(1);
        this.f7405u.setPadding(0, 0, 0, g4.i.r(30.0f));
        d1();
    }
}
