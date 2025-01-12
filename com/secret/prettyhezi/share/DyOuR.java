package com.secret.prettyhezi.share;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Registration.QHHnp8H;
import com.secret.prettyhezi.Registration.Xh1XG;
import com.secret.prettyhezi.ScoreExchange.ESXWxWYN;
import com.secret.prettyhezi.ScoreExchange.JrBjWAK;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.User.QlIdC;
import com.secret.prettyhezi.User.Ticket.Alv5GBDA;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.s;
import com.secret.prettyhezi.share.c;
import com.secret.prettyhezi.share.digital.NAfCh37OB;
import com.secret.prettyhezi.share.digital.RZS12WA;
import com.secret.prettyhezi.share.digital.WuXLOHsS;
/* loaded from: classes.dex */
public class DyOuR extends UoWMF {
    TextView G;
    TextView H;
    TextView I;
    TextView K;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f8830r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f8831s;

    /* renamed from: u  reason: collision with root package name */
    LinearLayout f8833u;

    /* renamed from: v  reason: collision with root package name */
    TextView f8834v;

    /* renamed from: w  reason: collision with root package name */
    TextView f8835w;

    /* renamed from: x  reason: collision with root package name */
    TextView f8836x;

    /* renamed from: y  reason: collision with root package name */
    TextView f8837y;

    /* renamed from: z  reason: collision with root package name */
    TextView f8838z;

    /* renamed from: t  reason: collision with root package name */
    int f8832t = Color.parseColor("#333333");
    TextView A = null;
    int B = 0;
    LinearLayout C = null;
    TextView D = null;
    TextView E = null;
    TextView F = null;
    TextView J = null;
    LinearLayout L = null;

    /* loaded from: classes.dex */
    class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            com.secret.prettyhezi.share.c cVar = (com.secret.prettyhezi.share.c) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.share.c.class);
            if (cVar.code == 200) {
                DyOuR.this.d1(cVar.data);
            } else {
                f(cVar.err);
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
            DyOuR.this.N0(YadO5U.class, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            DyOuR.this.N0(YadO5U.class, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {
        d() {
        }

        @Override // g4.f
        public void a(View view) {
            DyOuR.this.M0(Alv5GBDA.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {
        e() {
        }

        @Override // g4.f
        public void a(View view) {
            DyOuR.this.M0(QlIdC.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {
        f() {
        }

        @Override // g4.f
        public void a(View view) {
            DyOuR.this.M0(JrBjWAK.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ double f8845d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f8846e;

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }
        }

        g(double d6, int i6) {
            this.f8845d = d6;
            this.f8846e = i6;
        }

        @Override // g4.f
        public void a(View view) {
            if (this.f8845d >= this.f8846e || MainApplication.f6711r.r().integral.freeze != 0.0d) {
                DyOuR.this.M0(ESXWxWYN.class);
                return;
            }
            String str = "积分低于" + this.f8846e + "不能出售积分";
            if (MainApplication.f6711r.r().upload) {
                str = "上传者" + str;
            }
            DyOuR.this.D(str, new a(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends g4.f {
        h() {
        }

        @Override // g4.f
        public void a(View view) {
            DyOuR.this.M0(NbDOwgfTQ.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f8850a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f8851b;

        i(ZZcINlcxH zZcINlcxH, x xVar) {
            this.f8850a = zZcINlcxH;
            this.f8851b = xVar;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            if (this.f8850a.j(this.f8851b) && i6 == 1) {
                this.f8850a.startActivity(new Intent(this.f8850a, DyOuR.class));
            }
        }
    }

    /* loaded from: classes.dex */
    class j extends g4.f {
        j() {
        }

        @Override // g4.f
        public void a(View view) {
            DyOuR dyOuR = DyOuR.this;
            dyOuR.F("获得积分分成同时获得等量推广贡献值", null, dyOuR.s0(C0382R.string.IKnow), null, true);
        }
    }

    /* loaded from: classes.dex */
    class k extends g4.f {
        k() {
        }

        @Override // g4.f
        public void a(View view) {
            DyOuR dyOuR = DyOuR.this;
            dyOuR.F("邀请一个新用户获得一个分享值", null, dyOuR.s0(C0382R.string.IKnow), null, true);
        }
    }

    /* loaded from: classes.dex */
    class l extends g4.f {
        l() {
        }

        @Override // g4.f
        public void a(View view) {
            DyOuR.this.M0(UTsTXJH.class);
        }
    }

    /* loaded from: classes.dex */
    class m extends g4.f {
        m() {
        }

        @Override // g4.f
        public void a(View view) {
            DyOuR.this.M0(Xh1XG.class);
        }
    }

    /* loaded from: classes.dex */
    class n extends g4.f {
        n() {
        }

        @Override // g4.f
        public void a(View view) {
            DyOuR.this.M0(QHHnp8H.class);
        }
    }

    /* loaded from: classes.dex */
    class o extends g4.f {
        o() {
        }

        @Override // g4.f
        public void a(View view) {
            DyOuR.this.M0(Alv5GBDA.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a0 f8858d;

        p(a0 a0Var) {
            this.f8858d = a0Var;
        }

        @Override // g4.f
        public void a(View view) {
            DyOuR.this.M0(this.f8858d.digital ? WuXLOHsS.class : NAfCh37OB.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a0 f8860d;

        q(a0 a0Var) {
            this.f8860d = a0Var;
        }

        @Override // g4.f
        public void a(View view) {
            DyOuR.this.M0(this.f8860d.digital ? RZS12WA.class : NAfCh37OB.class);
        }
    }

    public static void S0(int i6) {
        ZZcINlcxH j6 = g4.i.j();
        if (j6 == null) {
            return;
        }
        T0(j6.s0(i6));
    }

    public static void T0(String str) {
        ZZcINlcxH j6 = g4.i.j();
        if (j6 == null) {
            return;
        }
        x xVar = new x(j6);
        xVar.f(str);
        xVar.d(new String[]{j6.s0(C0382R.string.cancel), j6.s0(C0382R.string.RedeemNow)}, new i(j6, xVar));
        j6.x(xVar, null, true);
    }

    public void U0() {
        TextView textView;
        String str;
        if (MainApplication.f6711r.k().sys.proxy) {
            com.secret.prettyhezi.User.a aVar = MainApplication.f6711r.f6728n;
            if (aVar == null) {
                this.J.setText("资源加速权限(视频&图片)：无");
                textView = this.K;
                str = "兑换";
            } else {
                TextView textView2 = this.J;
                textView2.setText("资源加速权限(视频&图片)：" + aVar.GetExpire());
                if (MainApplication.f6711r.B()) {
                    textView = this.K;
                    str = "开启";
                } else {
                    textView = this.K;
                    str = "切换";
                }
            }
            textView.setText(str);
        }
    }

    TextView V0(LinearLayout linearLayout, String str, boolean z5) {
        TextView c6 = g4.d.c(this, 16, -1, str, 17);
        c6.setBackground(g4.i.d(g4.i.b(Color.parseColor(z5 ? "#333333" : "#888888"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(38.0f));
        int r5 = g4.i.r(15.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        linearLayout.addView(c6, layoutParams);
        return c6;
    }

    void W0() {
        this.L.removeAllViews();
        if (MainApplication.f6711r.d()) {
            a0 r5 = MainApplication.f6711r.r();
            a0.e eVar = r5.integral;
            com.secret.prettyhezi.Server.g k6 = MainApplication.f6711r.k();
            double d6 = eVar.all;
            int i6 = r5.upload ? k6.sys.upload_min_score : k6.sys.min_score;
            TextView V0 = V0(this.L, "购买", true);
            TextView V02 = V0(this.L, "出售", d6 >= ((double) i6) || eVar.freeze > 0.0d);
            V0.setOnClickListener(new f());
            V02.setOnClickListener(new g(d6, i6));
        }
        V0(this.L, "详情", true).setOnClickListener(new h());
    }

    LinearLayout X0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int r5 = g4.i.r(6.0f);
        layoutParams.bottomMargin = r5;
        layoutParams.topMargin = r5;
        this.f8831s.addView(linearLayout, layoutParams);
        linearLayout.setBackground(g4.i.c(-1, 5.0f, -16777216, 1.0f));
        linearLayout.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        return linearLayout;
    }

    void Y0() {
        TextView b6 = g4.d.b(this, 16.0f, this.f8832t, "我的权限：");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = g4.i.r(12.0f);
        layoutParams.bottomMargin = g4.i.r(2.0f);
        this.f8831s.addView(b6, layoutParams);
        LinearLayout a12 = a1("兑换");
        this.D = (TextView) a12.getChildAt(0);
        TextView textView = (TextView) a12.getChildAt(1);
        this.G = textView;
        textView.setOnClickListener(new b());
        this.G.setVisibility(8);
        LinearLayout a13 = a1("兑换");
        this.E = (TextView) a13.getChildAt(0);
        TextView textView2 = (TextView) a13.getChildAt(1);
        this.H = textView2;
        textView2.setOnClickListener(new c());
        this.H.setVisibility(8);
        LinearLayout a14 = a1("兑换");
        this.F = (TextView) a14.getChildAt(0);
        TextView textView3 = (TextView) a14.getChildAt(1);
        this.I = textView3;
        textView3.setOnClickListener(new d());
        if (MainApplication.f6711r.k().sys.proxy) {
            LinearLayout a15 = a1("兑换");
            this.J = (TextView) a15.getChildAt(0);
            TextView textView4 = (TextView) a15.getChildAt(1);
            this.K = textView4;
            textView4.setOnClickListener(new e());
            QlIdC.S0(this);
        }
    }

    void Z0() {
        this.C.removeAllViews();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        this.C.addView(linearLayout, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        this.C.addView(linearLayout2, new LinearLayout.LayoutParams(-2, -2));
        a0.e eVar = MainApplication.f6711r.r().integral;
        int i6 = this.f8832t;
        linearLayout.addView(g4.d.b(this, 16.0f, i6, "账户积分：" + g4.i.F(eVar.all + eVar.freeze)), new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.addView(g4.d.b(this, 16.0f, 0, g4.i.F(eVar.all)), new LinearLayout.LayoutParams(-2, -2, -2.0f));
        if (eVar.freeze > 0.0d) {
            int i7 = this.f8832t;
            linearLayout.addView(g4.d.b(this, 16.0f, i7, "可用积分：" + g4.i.F(eVar.all)), new LinearLayout.LayoutParams(-2, -2));
            int i8 = this.f8832t;
            TextView b6 = g4.d.b(this, 16.0f, i8, "冻结积分：" + g4.i.F(eVar.freeze));
            b6.setSingleLine();
            linearLayout2.addView(b6, new LinearLayout.LayoutParams(-2, -2));
        }
        linearLayout.addView(g4.d.b(this, 16.0f, this.f8832t, "自上次登录以来增加的积分："), new LinearLayout.LayoutParams(-2, -2));
        double d6 = eVar.last;
        StringBuilder sb = new StringBuilder();
        sb.append(d6 < 0.0d ? "-" : k5.d.ANY_NON_NULL_MARKER);
        sb.append(g4.i.F(Math.abs(d6)));
        linearLayout2.addView(g4.d.b(this, 16.0f, this.f8832t, sb.toString()), new LinearLayout.LayoutParams(-2, -2, -2.0f));
    }

    LinearLayout a1(String str) {
        LinearLayout X0 = X0();
        X0.setOrientation(0);
        X0.addView(g4.d.b(this, 15.0f, -16777216, "一日全站超级浏览权限卡："), new LinearLayout.LayoutParams(0, -2, 1.0f));
        X0.addView(b1(str), new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(38.0f)));
        return X0;
    }

    TextView b1(String str) {
        TextView c6 = g4.d.c(this, 15, -1, str, 17);
        c6.setBackground(g4.i.e(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        return c6;
    }

    String c1(long j6) {
        if (j6 == 0) {
            return "无";
        }
        String u5 = g4.i.u(j6);
        return u5.compareTo("2030") > 0 ? "永久" : u5;
    }

    void d1(c.a aVar) {
        a0 r5 = MainApplication.f6711r.r();
        r5.integral = aVar.integral;
        r5.expire = aVar.expire;
        MainApplication.f6711r.x();
        Z0();
        TextView textView = this.f8834v;
        textView.setText("推广贡献值：" + g4.i.F(r5.integral.contribution));
        TextView textView2 = this.f8835w;
        textView2.setText("分享值：" + g4.i.F(r5.integral.invite));
        EjNkL.N.f6165r.j();
        W0();
        this.B = aVar.cards;
        TextView textView3 = this.f8836x;
        textView3.setText("一日全站超级浏览权限卡：" + aVar.cards);
        this.f8837y.setEnabled(aVar.cards > 0);
        TextView textView4 = this.D;
        textView4.setText("热门内容权限：" + c1(r5.expire.f7104p1));
        TextView textView5 = this.E;
        textView5.setText("精华上传内容权限：" + c1(r5.expire.f7105p2));
        TextView textView6 = this.F;
        textView6.setText("全站超级浏览权限：" + c1(r5.expire.f7106p3));
        this.G.setVisibility(c1(r5.expire.f7104p1).equals("永久") ? 8 : 0);
        this.H.setVisibility(c1(r5.expire.f7105p2).equals("永久") ? 8 : 0);
        if (MainApplication.f6711r.k().sys.proxy) {
            U0();
        }
    }

    void e1() {
        a0 r5 = MainApplication.f6711r.r();
        if (!MainApplication.f6711r.d() || (!r5.digital && !r5.is_digital)) {
            TextView textView = this.f8838z;
            if (textView != null) {
                ((ViewGroup) textView.getParent()).removeView(this.f8838z);
                ((ViewGroup) this.A.getParent()).removeView(this.A);
                this.f8838z = null;
                this.A = null;
            }
        } else if (this.f8838z == null) {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setGravity(1);
            TextView c6 = g4.d.c(this, 15, -1, "USDT兑换积分", 17);
            this.f8838z = c6;
            c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = g4.i.r(6.0f);
            this.f8833u.addView(linearLayout, layoutParams);
            linearLayout.addView(this.f8838z, new LinearLayout.LayoutParams(g4.i.r(140.0f), g4.i.r(38.0f)));
            this.f8838z.setOnClickListener(new p(r5));
            TextView c7 = g4.d.c(this, 15, -1, "积分兑换USDT", 17);
            this.A = c7;
            c7.setBackground(g4.i.d(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(140.0f), g4.i.r(38.0f));
            layoutParams2.leftMargin = g4.i.r(12.0f);
            linearLayout.addView(this.A, layoutParams2);
            this.A.setOnClickListener(new q(r5));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout B0 = B0(3, 4);
        this.f8830r = B0;
        B0.setGravity(1);
        M(this.f8830r, s0(C0382R.string.ScoreAndAccess));
        LinearLayout e6 = e(this.f8830r);
        this.f8831s = e6;
        e6.setGravity(3);
        this.f8831s.setPadding(g4.i.r(10.0f), g4.i.r(6.0f), g4.i.r(10.0f), g4.i.r(12.0f));
        this.f8833u = X0();
        LinearLayout linearLayout = new LinearLayout(this);
        this.C = linearLayout;
        linearLayout.setOrientation(0);
        this.f8833u.addView(this.C, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(this);
        this.L = linearLayout2;
        linearLayout2.setOrientation(0);
        this.L.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(6.0f);
        layoutParams.bottomMargin = g4.i.r(6.0f);
        this.f8833u.addView(this.L, layoutParams);
        Z0();
        W0();
        this.f8838z = null;
        e1();
        LinearLayout X0 = X0();
        X0.setOrientation(0);
        TextView c6 = g4.d.c(this, 16, -16777216, "推广贡献值：0", 16);
        this.f8834v = c6;
        c6.setPadding(g4.i.r(6.0f), 0, 0, 0);
        X0.addView(this.f8834v, new LinearLayout.LayoutParams(0, g4.i.r(36.0f), 1.0f));
        X0.addView(g4.d.b(this, 14.0f, Color.parseColor("#333333"), "如何获取推广贡献值？"), new LinearLayout.LayoutParams(-2, -2));
        X0.setOnClickListener(new j());
        LinearLayout X02 = X0();
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        TextView c7 = g4.d.c(this, 16, -65536, "分享值：0", 16);
        this.f8835w = c7;
        c7.setPadding(g4.i.r(6.0f), 0, 0, 0);
        linearLayout3.addView(this.f8835w, new LinearLayout.LayoutParams(0, g4.i.r(36.0f), 1.0f));
        linearLayout3.addView(g4.d.b(this, 14.0f, Color.parseColor("#333333"), "如何获取分享值？"), new LinearLayout.LayoutParams(-2, -2));
        linearLayout3.setOnClickListener(new k());
        X02.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
        View view = new View(this);
        view.setBackgroundColor(Color.parseColor("#333333"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, g4.i.r(0.5f));
        int r5 = g4.i.r(6.0f);
        layoutParams2.rightMargin = r5;
        layoutParams2.leftMargin = r5;
        X02.addView(view, layoutParams2);
        LinearLayout linearLayout4 = new LinearLayout(this);
        linearLayout4.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), 0, 0);
        linearLayout4.setGravity(16);
        linearLayout4.addView(g4.d.b(this, 16.0f, -65536, "推广赚钱："), new LinearLayout.LayoutParams(-2, -2));
        linearLayout4.addView(g4.d.b(this, 14.0f, -16777216, "分享值+贡献值兑换积分卖钱"), new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView c8 = g4.d.c(this, 16, -1, "兑换", 17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(38.0f));
        c8.setBackground(g4.i.e(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        linearLayout4.addView(c8, layoutParams3);
        linearLayout4.setOnClickListener(new l());
        X02.addView(linearLayout4, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout a12 = a1("兑换");
        ((TextView) a12.getChildAt(0)).setText("注册码");
        ((TextView) a12.getChildAt(1)).setOnClickListener(new m());
        TextView b12 = b1("出售");
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(38.0f));
        layoutParams4.rightMargin = g4.i.r(12.0f);
        a12.addView(b12, 1, layoutParams4);
        b12.setOnClickListener(new n());
        LinearLayout a13 = a1("使用");
        this.f8836x = (TextView) a13.getChildAt(0);
        TextView textView = (TextView) a13.getChildAt(1);
        this.f8837y = textView;
        textView.setOnClickListener(new o());
        Y0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        I0();
        com.secret.prettyhezi.j.o(v.f7132a + "user/expire/info/json", true, new a(this));
    }
}
