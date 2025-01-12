package com.secret.prettyhezi.Registration;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Payment.QCLQRilFO;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UFlsvW6LF;
import com.secret.prettyhezi.View.u;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.controls.y;
import com.secret.prettyhezi.controls.z;
import com.secret.prettyhezi.message.AWsQxAQ;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class a extends u {

    /* renamed from: p  reason: collision with root package name */
    static String f6951p;

    /* renamed from: q  reason: collision with root package name */
    static long f6952q;

    /* renamed from: m  reason: collision with root package name */
    private ZZcINlcxH f6953m;

    /* renamed from: n  reason: collision with root package name */
    private com.secret.prettyhezi.ScoreExchange.b f6954n;

    /* renamed from: o  reason: collision with root package name */
    private RelativeLayout f6955o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.secret.prettyhezi.Registration.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0091a implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f6956a;

        C0091a(x xVar) {
            this.f6956a = xVar;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            a.this.f6953m.j(this.f6956a);
            if (i6 == 1) {
                a.this.s();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements s.f {
        b() {
        }

        @Override // com.secret.prettyhezi.s.f
        public void a(String str) {
            a.f6951p = null;
            a.f6952q = 0L;
            com.secret.prettyhezi.i.f8489j.g(2);
            if (a.this.f6953m instanceof UUS6bYTjG) {
                ((UUS6bYTjG) a.this.f6953m).S0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends s.e {
        c(ZZcINlcxH zZcINlcxH, s.f fVar) {
            super(zZcINlcxH, fVar);
        }

        @Override // com.secret.prettyhezi.s.g
        public void f(String str) {
            a.f6951p = str;
            a.f6952q = System.currentTimeMillis();
            super.f(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {

        /* renamed from: com.secret.prettyhezi.Registration.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0092a extends ZZcINlcxH.q {
            C0092a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                a.this.f6953m.M0(ZsblHj3O.class);
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.t();
            }
        }

        d() {
        }

        @Override // g4.f
        public void a(View view) {
            if (a.f6952q > 0 && System.currentTimeMillis() - a.f6952q < 60000 && a.f6951p != null) {
                a.this.f6953m.y(com.secret.prettyhezi.c.b(a.f6951p));
            } else if (ZsblHj3O.S0()) {
                a.this.f6953m.r(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new b());
            } else {
                a.this.f6953m.D("请先阅读购买流程\n并点击下方“我已阅读”按钮", new C0092a(), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {

        /* renamed from: com.secret.prettyhezi.Registration.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0093a extends ZZcINlcxH.q {

            /* renamed from: com.secret.prettyhezi.Registration.a$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0094a implements a.f {

                /* renamed from: com.secret.prettyhezi.Registration.a$e$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class C0095a implements s.f {
                    C0095a() {
                    }

                    @Override // com.secret.prettyhezi.s.f
                    public void a(String str) {
                        if (a.this.f6953m instanceof QHHnp8H) {
                            ((QHHnp8H) a.this.f6953m).S0();
                        }
                    }
                }

                C0094a() {
                }

                @Override // com.secret.prettyhezi.Device.a.f
                public void a(String str) {
                    com.secret.prettyhezi.j.r(v.f7132a + "registration/seller/json", new n("c", a.this.f6954n.id), true, new s.e(a.this.f6953m, new C0095a()));
                }
            }

            C0093a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                com.secret.prettyhezi.Device.a.e();
                com.secret.prettyhezi.Device.a.b(a.this.f6953m, new C0094a());
            }
        }

        e() {
        }

        @Override // g4.f
        public void a(View view) {
            if ((System.currentTimeMillis() / 1000) - a.this.f6954n.create_time < 600) {
                a.this.f6953m.y("挂单10分钟后才能取消");
            } else {
                a.this.f6953m.C("取消卖单？\n\n每天最多取消3次卖单，否则会暂停交易权限", new String[]{"暂不取消", "取消卖单"}, new C0093a(), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {
        f() {
        }

        @Override // g4.f
        public void a(View view) {
            a.this.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends g4.f {
        g() {
        }

        @Override // g4.f
        public void a(View view) {
            a.this.f6953m.H("请确保收款方式有效");
            a.this.f6953m.M0(QCLQRilFO.class);
        }
    }

    public a(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        this.f6953m = zZcINlcxH;
        setBackground(null);
        setPadding(g4.i.r(2.0f), g4.i.r(2.0f), g4.i.r(2.0f), g4.i.r(2.0f));
        RelativeLayout relativeLayout = new RelativeLayout(zZcINlcxH);
        this.f6955o = relativeLayout;
        relativeLayout.setPadding(g4.i.r(12.0f), 0, g4.i.r(12.0f), 0);
        this.f6955o.setBackground(g4.i.b(-1, 5.0f));
        addView(this.f6955o, new LinearLayout.LayoutParams(-1, -1));
    }

    public static LinearLayout p(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.ScoreExchange.b bVar) {
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        new LinearLayout.LayoutParams(g4.i.r(100.0f), -2).rightMargin = g4.i.r(2.0f);
        linearLayout2.addView(g4.d.b(zZcINlcxH, 16.0f, -65536, g4.i.B(bVar.price) + "元"), new LinearLayout.LayoutParams(g4.i.r(100.0f), -2));
        String str = bVar.payment;
        if (str != null && str.length() > 0) {
            for (String str2 : bVar.payment.split(",")) {
                z zVar = new z(zZcINlcxH, com.secret.prettyhezi.Payment.d.c(Integer.parseInt(str2)));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(12.0f), g4.i.r(12.0f));
                layoutParams.rightMargin = g4.i.r(4.0f);
                linearLayout2.addView(zVar, layoutParams);
            }
        }
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout3 = new LinearLayout(zZcINlcxH);
        linearLayout3.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(100.0f), -2);
        layoutParams2.rightMargin = g4.i.r(2.0f);
        linearLayout3.addView(g4.d.b(zZcINlcxH, 10.0f, -7829368, "发布：" + g4.i.v(bVar.create_time)), layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(100.0f), -2);
        if (bVar.update_time > 0) {
            int i6 = bVar.status;
            linearLayout3.addView(g4.d.b(zZcINlcxH, 10.0f, -7829368, (i6 == 1 ? "下单" : i6 == 2 ? "付款" : i6 == 4 ? "申诉" : i6 == 3 ? "成交" : "更新") + "：" + g4.i.v(bVar.update_time)), layoutParams3);
        }
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        int r5 = g4.i.r(6.0f);
        layoutParams4.bottomMargin = r5;
        layoutParams4.topMargin = r5;
        linearLayout.addView(linearLayout3, layoutParams4);
        return linearLayout;
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        TextView r5;
        View.OnClickListener gVar;
        com.secret.prettyhezi.ScoreExchange.b bVar = (com.secret.prettyhezi.ScoreExchange.b) nVar;
        this.f6954n = bVar;
        setBackground(bVar.canTalk() ? g4.i.c(0, 6.0f, -65536, 1.0f) : null);
        this.f6955o.removeAllViews();
        this.f6955o.addView(p(this.f6953m, this.f6954n), new RelativeLayout.LayoutParams(-2, -1));
        LinearLayout linearLayout = new LinearLayout(this.f6953m);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        int r6 = g4.i.r(60.0f);
        int r7 = g4.i.r(36.0f);
        com.secret.prettyhezi.ScoreExchange.b bVar2 = this.f6954n;
        int i6 = bVar2.status;
        if (i6 == 0) {
            if (MainApplication.f6711r.r().grade == 0) {
                TextView q5 = com.secret.prettyhezi.ScoreExchange.e.q(this.f6953m, "买入");
                q5.setOnClickListener(new d());
                linearLayout.addView(q5, new LinearLayout.LayoutParams(r6, r7));
            } else {
                r5 = com.secret.prettyhezi.ScoreExchange.e.r(this.f6953m, "取消");
                linearLayout.addView(r5, new LinearLayout.LayoutParams(r6, r7));
                gVar = new e();
                r5.setOnClickListener(gVar);
            }
        } else if (i6 == 1 || i6 == 4 || i6 == 2) {
            linearLayout.setOrientation(0);
            z zVar = new z(this.f6953m, C0382R.drawable.chat_user);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r7, r7);
            layoutParams.rightMargin = g4.i.r(6.0f);
            linearLayout.addView(zVar, layoutParams);
            TextView q6 = com.secret.prettyhezi.ScoreExchange.e.q(this.f6953m, this.f6954n.Status());
            q6.setTextSize(12.0f);
            q6.setTextColor(-65536);
            linearLayout.addView(q6, new LinearLayout.LayoutParams(r6, r7));
            int e6 = com.secret.prettyhezi.i.f8489j.e(this.f6954n.chat_id);
            if (e6 > 0) {
                y yVar = new y(this.f6953m);
                yVar.b(e6);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(24.0f), g4.i.r(20.0f));
                layoutParams2.rightMargin = g4.i.r(2.0f);
                linearLayout.addView(yVar, 0, layoutParams2);
            }
            setOnClickListener(new f());
        } else {
            r5 = com.secret.prettyhezi.ScoreExchange.e.r(this.f6953m, bVar2.Status());
            r5.setTextColor(-65536);
            r5.setTextSize(14.0f);
            linearLayout.addView(r5, new LinearLayout.LayoutParams(r6, r7));
            if (this.f6954n.status == -3 && (this.f6953m instanceof QHHnp8H)) {
                gVar = new g();
                r5.setOnClickListener(gVar);
            }
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(15, -1);
        this.f6955o.addView(linearLayout, layoutParams3);
        this.f8037b = g4.i.r(linearLayout.getChildCount() > 1 ? 80.0f : 54.0f);
    }

    @Override // com.secret.prettyhezi.View.u
    public RelativeLayout getTopRelativeLayout() {
        return this.f6955o;
    }

    void s() {
        com.secret.prettyhezi.j.r(v.f7132a + "registration/buyer/json", new i("b", this.f6954n.id), true, new c(this.f6953m, new b()));
    }

    void t() {
        x xVar = new x(this.f6953m);
        LinearLayout linearLayout = new LinearLayout(this.f6953m);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        xVar.e(linearLayout);
        TextView b6 = g4.d.b(this.f6953m, 16.0f, -16777216, "交易须知");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = g4.i.r(10.0f);
        linearLayout.addView(b6, layoutParams);
        linearLayout.addView(g4.d.b(this.f6953m, 14.0f, -16777216, UUS6bYTjG.T0()), new LinearLayout.LayoutParams(-1, -2));
        xVar.d(new String[]{"暂不买入", "确认买入"}, new C0091a(xVar));
        xVar.c(1, 5);
        this.f6953m.x(xVar, null, false);
    }

    public void u() {
        ZZcINlcxH zZcINlcxH = this.f6953m;
        if (zZcINlcxH instanceof UFlsvW6LF) {
            com.secret.prettyhezi.ScoreExchange.b bVar = this.f6954n;
            AWsQxAQ.V0(zZcINlcxH, 3, bVar.chat_id, bVar);
            return;
        }
        boolean z5 = MainApplication.f6711r.r().grade == 0;
        com.secret.prettyhezi.i.f8489j.b(this.f6954n.chat_id);
        ZZcINlcxH zZcINlcxH2 = this.f6953m;
        int i6 = z5 ? 1 : 2;
        com.secret.prettyhezi.ScoreExchange.b bVar2 = this.f6954n;
        AWsQxAQ.V0(zZcINlcxH2, i6, bVar2.chat_id, bVar2);
    }

    public a(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.ScoreExchange.b bVar) {
        this(zZcINlcxH);
        a(bVar);
    }
}
