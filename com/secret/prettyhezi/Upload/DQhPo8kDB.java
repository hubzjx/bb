package com.secret.prettyhezi.Upload;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import c.abc;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.SLUjG;
import com.secret.prettyhezi.Server.d0;
import com.secret.prettyhezi.Server.e0;
import com.secret.prettyhezi.Server.j;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.Upload.j;
import com.secret.prettyhezi.Video.MSqCZ2mQ;
import com.secret.prettyhezi.Video.NRxYacSEB;
import com.secret.prettyhezi.View.n;
import com.secret.prettyhezi.WOqyeiK;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.PullToRefresh.f;
import com.secret.prettyhezi.s;
import e4.c;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class DQhPo8kDB extends UoWMF {
    d0 A;
    LinearLayout B;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7269r;

    /* renamed from: v  reason: collision with root package name */
    int f7273v;

    /* renamed from: w  reason: collision with root package name */
    int f7274w;

    /* renamed from: x  reason: collision with root package name */
    com.secret.prettyhezi.controls.PullToRefresh.i f7275x;

    /* renamed from: y  reason: collision with root package name */
    LinearLayout f7276y;

    /* renamed from: z  reason: collision with root package name */
    d0 f7277z;

    /* renamed from: s  reason: collision with root package name */
    int[] f7270s = {2, 5};

    /* renamed from: t  reason: collision with root package name */
    int[] f7271t = {C0382R.string.ShortVideo, C0382R.string.LongVideo};

    /* renamed from: u  reason: collision with root package name */
    int f7272u = -1;
    String[] C = {"左边包含广告", "右边包含广告"};
    com.secret.prettyhezi.controls.c[] D = new com.secret.prettyhezi.controls.c[2];
    String[] E = {"左边更清晰", "右边更清晰", "差不多清晰"};
    com.secret.prettyhezi.controls.c[] F = new com.secret.prettyhezi.controls.c[3];
    String[] G = {"左边更完整", "右边更完整", "差不多完整"};
    com.secret.prettyhezi.controls.c[] H = new com.secret.prettyhezi.controls.c[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {
        a() {
        }

        @Override // g4.f
        protected void a(View view) {
            DQhPo8kDB.this.b1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j.a[] f7279a;

        b(j.a[] aVarArr) {
            this.f7279a = aVarArr;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            DQhPo8kDB.this.Z0(true, this.f7279a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends s.g {
        c(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            if (DQhPo8kDB.this.isDestroyed() || DQhPo8kDB.this.isFinishing()) {
                return;
            }
            com.secret.prettyhezi.Server.z zVar = (com.secret.prettyhezi.Server.z) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.Server.z.class);
            if (zVar.code != 200) {
                d(zVar.err);
                return;
            }
            DQhPo8kDB.this.H("操作成功!");
            DQhPo8kDB.this.d1();
        }
    }

    /* loaded from: classes.dex */
    class d implements n.b {
        d() {
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void a(int i6) {
            DQhPo8kDB dQhPo8kDB = DQhPo8kDB.this;
            dQhPo8kDB.f7272u = i6;
            dQhPo8kDB.f7273v = dQhPo8kDB.f7270s[i6];
            dQhPo8kDB.f7275x.p(true, 0L);
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void b(int i6) {
            DQhPo8kDB.this.f7275x.p(true, 0L);
        }
    }

    /* loaded from: classes.dex */
    class e extends f.h {
        e() {
        }

        @Override // com.secret.prettyhezi.controls.PullToRefresh.f.h
        public void a(com.secret.prettyhezi.controls.PullToRefresh.f fVar) {
            super.a(fVar);
            DQhPo8kDB.this.d1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends s.g {
        f(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            if (DQhPo8kDB.this.isDestroyed() || DQhPo8kDB.this.isFinishing()) {
                return;
            }
            DQhPo8kDB.this.f7275x.z();
            m mVar = (m) com.secret.prettyhezi.f.d(str, m.class);
            if (mVar.code != 200) {
                if (!mVar.err.equals("Empty")) {
                    com.secret.prettyhezi.s.d(DQhPo8kDB.this, mVar.err);
                    return;
                }
                DQhPo8kDB.this.f7276y.addView(g4.d.c(DQhPo8kDB.this, 18, -16777216, "该类型没有内容需要审核", 17), new LinearLayout.LayoutParams(-1, g4.i.r(120.0f)));
                return;
            }
            DQhPo8kDB dQhPo8kDB = DQhPo8kDB.this;
            m.a aVar = mVar.data;
            dQhPo8kDB.f7274w = aVar.id;
            d0[] d0VarArr = aVar.items;
            dQhPo8kDB.f7277z = d0VarArr[0];
            dQhPo8kDB.A = d0VarArr[1];
            dQhPo8kDB.f1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d0 f7285d;

        g(d0 d0Var) {
            this.f7285d = d0Var;
        }

        @Override // g4.f
        protected void a(View view) {
            d0 d0Var = this.f7285d;
            String[] strArr = d0Var.ps;
            if (strArr == null || strArr.length <= 0) {
                DQhPo8kDB.this.c1(d0Var.f7110me);
            } else {
                WOqyeiK.T0(DQhPo8kDB.this, strArr, d0Var.f7110me.f7128p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends g4.f {
        h() {
        }

        @Override // g4.f
        protected void a(View view) {
            DQhPo8kDB dQhPo8kDB = DQhPo8kDB.this;
            dQhPo8kDB.N0(SLUjG.class, dQhPo8kDB.f7277z.cl.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends g4.f {
        i() {
        }

        @Override // g4.f
        protected void a(View view) {
            DQhPo8kDB dQhPo8kDB = DQhPo8kDB.this;
            dQhPo8kDB.N0(SLUjG.class, dQhPo8kDB.A.cl.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                DQhPo8kDB.this.Z0(false, null);
            }
        }

        j() {
        }

        @Override // g4.f
        protected void a(View view) {
            DQhPo8kDB.this.B("确认视频内容不重复？", new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                DQhPo8kDB.this.a1();
            }
        }

        k() {
        }

        @Override // g4.f
        protected void a(View view) {
            DQhPo8kDB.this.B("确认视频内容重复？", new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.c[] f7293d;

        l(com.secret.prettyhezi.controls.c[] cVarArr) {
            this.f7293d = cVarArr;
        }

        @Override // g4.f
        protected void a(View view) {
            int i6 = 0;
            while (true) {
                com.secret.prettyhezi.controls.c[] cVarArr = this.f7293d;
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

    /* loaded from: classes.dex */
    static class m extends com.secret.prettyhezi.Server.w {
        a data;

        /* loaded from: classes.dex */
        static class a implements Serializable {
            int id;
            d0[] items;

            a() {
            }
        }

        m() {
        }
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        this.B = linearLayout;
        linearLayout.setOrientation(1);
        this.f7276y.addView(this.B, new LinearLayout.LayoutParams(-1, -2));
        U(this.B, "视频内容不重复", 30, 30).setOnClickListener(new j());
        U(this.B, "视频内容重复", 40, 30).setOnClickListener(new k());
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
            com.secret.prettyhezi.controls.c[] cVarArr = this.D;
            if (i6 >= cVarArr.length) {
                break;
            }
            cVarArr[i6] = new com.secret.prettyhezi.controls.c(this, this.C[i6]);
            V0.addView(this.D[i6], new c.a(r6, -2));
            i6++;
        }
        V(this.B, Color.parseColor("#888888"), 0.5f, 0, 0);
        X0(this.F, this.E, r6);
        if (this.f7273v == 5) {
            V(this.B, Color.parseColor("#888888"), 0.5f, 0, 0);
            X0(this.H, this.G, r6);
        }
    }

    void U0() {
        LinearLayout W0 = W0(this.f7276y);
        W0.setGravity(17);
        int r5 = (o().x - g4.i.r(10.0f)) / 2;
        com.secret.prettyhezi.Server.l lVar = this.f7277z.co;
        int i6 = (lVar.f7127h * r5) / lVar.f7129w;
        com.secret.prettyhezi.Server.l lVar2 = this.A.co;
        int max = Math.max(i6, (lVar2.f7127h * r5) / lVar2.f7129w);
        W0.addView(Y0(this.f7277z, r5, max), 0, new LinearLayout.LayoutParams(0, max, 1.0f));
        W0.addView(Y0(this.A, r5, max), new LinearLayout.LayoutParams(0, max, 1.0f));
        int r6 = g4.i.r(6.0f);
        TextView b6 = g4.d.b(this, 12.0f, Color.parseColor("#333333"), g4.i.w(this.f7277z.ct));
        TextView b7 = g4.d.b(this, 12.0f, Color.parseColor("#333333"), g4.i.w(this.A.ct));
        b6.setPadding(r6, r6, r6, r6);
        b7.setPadding(r6, r6, r6, r6);
        LinearLayout W02 = W0(this.f7276y);
        W02.addView(b6, 0, new LinearLayout.LayoutParams(0, -2, 1.0f));
        W02.addView(b7, new LinearLayout.LayoutParams(0, -2, 1.0f));
        StringBuilder sb = new StringBuilder();
        sb.append("标题：");
        String str = this.f7277z.na;
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str);
        TextView b8 = g4.d.b(this, 12.0f, -16777216, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("标题：");
        String str2 = this.A.na;
        if (str2 == null) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb2.append(str2);
        TextView b9 = g4.d.b(this, 12.0f, -16777216, sb2.toString());
        b8.setPadding(r6, r6, r6, r6);
        b9.setPadding(r6, r6, r6, r6);
        LinearLayout W03 = W0(this.f7276y);
        W03.addView(b8, 0, new LinearLayout.LayoutParams(0, -2, 1.0f));
        W03.addView(b9, new LinearLayout.LayoutParams(0, -2, 1.0f));
        int r7 = g4.i.r(26.0f);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("大小：");
        long j6 = this.f7277z.sz;
        sb3.append(j6 > 0 ? g4.i.D(j6) : "未知");
        TextView c6 = g4.d.c(this, 12, -16777216, sb3.toString(), 16);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("大小：");
        long j7 = this.A.sz;
        sb4.append(j7 > 0 ? g4.i.D(j7) : "未知");
        TextView c7 = g4.d.c(this, 12, -16777216, sb4.toString(), 16);
        c6.setPadding(r6, 0, 0, 0);
        c7.setPadding(r6, 0, 0, 0);
        LinearLayout W04 = W0(this.f7276y);
        W04.addView(c6, 0, new LinearLayout.LayoutParams(0, r7, 1.0f));
        W04.addView(c7, new LinearLayout.LayoutParams(0, r7, 1.0f));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("时长：");
        int i7 = this.f7277z.dur;
        sb5.append(i7 > 0 ? g4.i.G(i7) : "未知");
        TextView c8 = g4.d.c(this, 12, -16777216, sb5.toString(), 16);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("时长：");
        int i8 = this.A.dur;
        sb6.append(i8 > 0 ? g4.i.G(i8) : "未知");
        TextView c9 = g4.d.c(this, 12, -16777216, sb6.toString(), 16);
        c8.setPadding(g4.i.r(6.0f), 0, 0, 0);
        c9.setPadding(g4.i.r(6.0f), 0, 0, 0);
        LinearLayout W05 = W0(this.f7276y);
        W05.addView(c8, 0, new LinearLayout.LayoutParams(0, r7, 1.0f));
        W05.addView(c9, new LinearLayout.LayoutParams(0, r7, 1.0f));
        TextView c10 = g4.d.c(this, 12, -65536, "盒子：无", 16);
        TextView c11 = g4.d.c(this, 12, -65536, "盒子：无", 16);
        j.a aVar = this.f7277z.cl;
        if (aVar != null) {
            String str3 = aVar.na;
            if (str3 == null || str3.isEmpty()) {
                str3 = HttpUrl.FRAGMENT_ENCODE_SET + this.f7277z.cl.id;
            }
            c10.setText("盒子：" + str3);
            if (this.f7277z.cl.id > 0) {
                c10.setOnClickListener(new h());
            }
        }
        j.a aVar2 = this.A.cl;
        if (aVar2 != null) {
            String str4 = aVar2.na;
            if (str4 == null || str4.isEmpty()) {
                str4 = HttpUrl.FRAGMENT_ENCODE_SET + this.A.cl.id;
            }
            c10.setText("盒子：" + str4);
            if (this.A.cl.id > 0) {
                c10.setOnClickListener(new i());
            }
        }
        c10.setPadding(g4.i.r(6.0f), 0, 0, 0);
        c11.setPadding(g4.i.r(6.0f), 0, 0, 0);
        LinearLayout W06 = W0(this.f7276y);
        W06.addView(c10, 0, new LinearLayout.LayoutParams(0, r7, 1.0f));
        W06.addView(c11, new LinearLayout.LayoutParams(0, r7, 1.0f));
    }

    e4.c V0() {
        e4.c cVar = new e4.c(this);
        cVar.setPadding(0, g4.i.r(20.0f), 0, g4.i.r(10.0f));
        this.B.addView(cVar, new LinearLayout.LayoutParams(-1, -2));
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
            cVarArr[i7].setOnClickListener(new l(cVarArr));
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
        g gVar = new g(d0Var);
        zVar.setOnClickListener(gVar);
        qVar.setOnClickListener(gVar);
        return relativeLayout;
    }

    void Z0(boolean z5, j.a[] aVarArr) {
        com.secret.prettyhezi.Upload.j jVar = new com.secret.prettyhezi.Upload.j(this.f7274w, z5, this.f7273v);
        jVar.items = aVarArr;
        com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "repeatedly/audit/json", jVar, true, new c(this));
    }

    void a1() {
        this.B.removeAllViews();
        this.B.setPadding(g4.i.r(8.0f), g4.i.r(20.0f), g4.i.r(8.0f), g4.i.r(20.0f));
        this.B.addView(g4.d.b(this, 14.0f, -65536, "请填写如下选项再次提交"), new LinearLayout.LayoutParams(-1, -2));
        T0();
        U(this.B, "提交举报", 40, 30).setOnClickListener(new a());
    }

    void b1() {
        boolean isSelected = this.D[0].isSelected();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (isSelected) {
            str = HttpUrl.FRAGMENT_ENCODE_SET + this.C[0] + "\n";
        }
        if (this.D[1].isSelected()) {
            str = str + this.C[1] + "\n";
        }
        String str2 = this.D[0].isSelected() ? "1" : "0";
        String str3 = this.D[1].isSelected() ? "1" : "0";
        int i6 = 0;
        while (true) {
            if (i6 >= this.E.length) {
                i6 = -1;
                break;
            } else if (this.F[i6].isSelected()) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 == -1) {
            y("请判断清晰度");
            return;
        }
        String str4 = str + this.E[i6] + "\n";
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(this.F[0].isSelected() ? "1" : "0");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str3);
        sb3.append(this.F[1].isSelected() ? "1" : "0");
        String sb4 = sb3.toString();
        if (this.f7273v == 5) {
            int i7 = 0;
            while (true) {
                if (i7 >= this.G.length) {
                    i7 = -1;
                    break;
                } else if (this.H[i7].isSelected()) {
                    break;
                } else {
                    i7++;
                }
            }
            if (i7 == -1) {
                y("请判断完整度");
                return;
            }
            str4 = str4 + this.G[i7] + "\n";
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb2);
            sb5.append(this.H[0].isSelected() ? "1" : "0");
            sb2 = sb5.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(sb4);
            sb6.append(this.H[1].isSelected() ? "1" : "0");
            sb4 = sb6.toString();
        }
        j.a aVar = new j.a();
        j.a[] aVarArr = {new j.a(), aVar};
        j.a aVar2 = aVarArr[0];
        aVar2.id = this.f7277z.id;
        aVar2.res = sb2;
        aVar.id = this.A.id;
        aVar.res = sb4;
        B(str4, new b(aVarArr), false);
    }

    public void c1(e0 e0Var) {
        if (!g4.g.a().b("keyVideoAutoLandscape") || e0Var.f7129w <= e0Var.f7127h) {
            MSqCZ2mQ.T0(this, e0Var.f7128p, this.f7273v, 0, 0L);
        } else {
            NRxYacSEB.z1(this, e0Var.f7128p, this.f7273v, 0, 0L);
        }
    }

    void d1() {
        this.f7276y.removeAllViews();
        e1();
    }

    void e1() {
        com.secret.prettyhezi.j.m(com.secret.prettyhezi.Server.v.f7132a + "repeatedly/audit/show/json?t=" + this.f7273v, new f(this));
    }

    void f1() {
        U0();
        S0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7269r = C0;
        M(C0, abc.ams("s2"));
        com.secret.prettyhezi.View.n nVar = new com.secret.prettyhezi.View.n(this, this.f7271t, new d());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(42.0f));
        layoutParams.topMargin = g4.i.r(1.0f);
        this.f7269r.addView(nVar, layoutParams);
        com.secret.prettyhezi.controls.PullToRefresh.i iVar = new com.secret.prettyhezi.controls.PullToRefresh.i(this);
        this.f7275x = iVar;
        iVar.setScrollBarSize(0);
        this.f7269r.addView(this.f7275x, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f7275x.setOnRefreshListener(new e());
        LinearLayout linearLayout = new LinearLayout(this);
        this.f7276y = linearLayout;
        linearLayout.setOrientation(1);
        this.f7276y.setGravity(1);
        this.f7276y.setPadding(0, 0, 0, g4.i.r(30.0f));
        ((ScrollView) this.f7275x.getRefreshableView()).addView(this.f7276y, new ViewGroup.LayoutParams(-1, -2));
        nVar.setCurrentTab(0);
    }
}
