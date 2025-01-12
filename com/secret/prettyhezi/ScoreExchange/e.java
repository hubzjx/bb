package com.secret.prettyhezi.ScoreExchange;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Payment.QCLQRilFO;
import com.secret.prettyhezi.Server.n;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UFlsvW6LF;
import com.secret.prettyhezi.View.u;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.controls.y;
import com.secret.prettyhezi.controls.z;
import com.secret.prettyhezi.i;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.message.AWsQxAQ;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class e extends u {

    /* renamed from: p  reason: collision with root package name */
    static String f7078p;

    /* renamed from: q  reason: collision with root package name */
    static long f7079q;

    /* renamed from: m  reason: collision with root package name */
    private ZZcINlcxH f7080m;

    /* renamed from: n  reason: collision with root package name */
    private com.secret.prettyhezi.ScoreExchange.b f7081n;

    /* renamed from: o  reason: collision with root package name */
    private RelativeLayout f7082o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f7083a;

        /* renamed from: com.secret.prettyhezi.ScoreExchange.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0104a implements s.f {
            C0104a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                e.f7078p = null;
                e.f7079q = 0L;
                int parseInt = Integer.parseInt(str);
                e.this.f7081n.status = 1;
                e.this.f7081n.chat_id = parseInt;
                e.this.f7081n.update_time = System.currentTimeMillis() / 1000;
                i.f8489j.g(0);
                if (e.this.f7080m instanceof JrBjWAK) {
                    ((JrBjWAK) e.this.f7080m).B = e.this.f7081n.id;
                    ((JrBjWAK) e.this.f7080m).S0();
                }
            }
        }

        /* loaded from: classes.dex */
        class b extends s.e {
            b(ZZcINlcxH zZcINlcxH, s.f fVar) {
                super(zZcINlcxH, fVar);
            }

            @Override // com.secret.prettyhezi.s.g
            public void f(String str) {
                e.f7078p = str;
                e.f7079q = System.currentTimeMillis();
                super.f(str);
            }
        }

        a(x xVar) {
            this.f7083a = xVar;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            e.this.f7080m.j(this.f7083a);
            if (i6 == 1) {
                j.o(v.f7132a + "transaction/buyer/place/json?id=" + e.this.f7081n.id, true, new b(e.this.f7080m, new C0104a()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }
        }

        /* renamed from: com.secret.prettyhezi.ScoreExchange.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0105b extends ZZcINlcxH.q {
            C0105b() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                e.this.f7080m.M0(Q1Y0tWRI.class);
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.u();
            }
        }

        b() {
        }

        @Override // g4.f
        public void a(View view) {
            double d6 = MainApplication.f6711r.r().integral.all;
            int i6 = MainApplication.f6711r.k().sys.max_score;
            if (e.f7079q > 0 && System.currentTimeMillis() - e.f7079q < 60000 && e.f7078p != null) {
                e.this.f7080m.y(com.secret.prettyhezi.c.b(e.f7078p));
            } else if (d6 < i6) {
                if (Q1Y0tWRI.S0()) {
                    e.this.f7080m.r(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new c());
                } else {
                    e.this.f7080m.D("请先阅读购买流程\n并点击下方“我已阅读”按钮", new C0105b(), true);
                }
            } else {
                ZZcINlcxH zZcINlcxH = e.this.f7080m;
                zZcINlcxH.D("您已有" + g4.i.F(d6) + "积分，不需要购买，请先消费掉部分积分", new a(), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {

            /* renamed from: com.secret.prettyhezi.ScoreExchange.e$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0106a implements a.f {

                /* renamed from: com.secret.prettyhezi.ScoreExchange.e$c$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class C0107a implements s.f {
                    C0107a() {
                    }

                    @Override // com.secret.prettyhezi.s.f
                    public void a(String str) {
                        if (e.this.f7080m instanceof ESXWxWYN) {
                            ((ESXWxWYN) e.this.f7080m).S0();
                        }
                    }
                }

                C0106a() {
                }

                @Override // com.secret.prettyhezi.Device.a.f
                public void a(String str) {
                    j.r(v.f7132a + "transaction/seller/cancel/json?id=" + e.this.f7081n.id, new v.f(), true, new s.e(e.this.f7080m, new C0107a()));
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                com.secret.prettyhezi.Device.a.e();
                com.secret.prettyhezi.Device.a.b(e.this.f7080m, new C0106a());
            }
        }

        c() {
        }

        @Override // g4.f
        public void a(View view) {
            if ((System.currentTimeMillis() / 1000) - e.this.f7081n.create_time < 600) {
                e.this.f7080m.y("挂单10分钟后才能取消");
            } else {
                e.this.f7080m.C("取消卖单？\n\n每天最多取消3次卖单，否则会暂停交易权限", new String[]{"暂不取消", "取消卖单"}, new a(), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f7095d;

        d(boolean z5) {
            this.f7095d = z5;
        }

        @Override // g4.f
        public void a(View view) {
            i.f8489j.b(e.this.f7081n.chat_id);
            AWsQxAQ.T0(e.this.f7080m, e.this.f7080m instanceof UFlsvW6LF ? 3 : this.f7095d ? 1 : 2, e.this.f7081n.chat_id, e.this.f7081n);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.secret.prettyhezi.ScoreExchange.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0108e extends g4.f {
        C0108e() {
        }

        @Override // g4.f
        public void a(View view) {
            e.this.f7080m.H("请确保收款方式有效");
            e.this.f7080m.M0(QCLQRilFO.class);
        }
    }

    public e(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        this.f7080m = zZcINlcxH;
        setBackground(null);
        setPadding(g4.i.r(2.0f), g4.i.r(2.0f), g4.i.r(2.0f), g4.i.r(2.0f));
        RelativeLayout relativeLayout = new RelativeLayout(zZcINlcxH);
        this.f7082o = relativeLayout;
        relativeLayout.setPadding(g4.i.r(12.0f), 0, g4.i.r(12.0f), 0);
        this.f7082o.setBackground(g4.i.b(-1, 5.0f));
        addView(this.f7082o, new LinearLayout.LayoutParams(-1, -1));
    }

    public static LinearLayout p(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.ScoreExchange.b bVar) {
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(100.0f), -2);
        layoutParams.rightMargin = g4.i.r(2.0f);
        linearLayout2.addView(g4.d.b(zZcINlcxH, 16.0f, -16777216, bVar.amount + "积分"), layoutParams);
        linearLayout2.addView(g4.d.b(zZcINlcxH, 16.0f, -65536, g4.i.B(bVar.price) + "元"), new LinearLayout.LayoutParams(g4.i.r(80.0f), -2));
        String str = bVar.payment;
        if (str != null && str.length() > 0) {
            for (String str2 : bVar.payment.split(",")) {
                z zVar = new z(zZcINlcxH, com.secret.prettyhezi.Payment.d.c(Integer.parseInt(str2)));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(12.0f), g4.i.r(12.0f));
                layoutParams2.rightMargin = g4.i.r(4.0f);
                linearLayout2.addView(zVar, layoutParams2);
            }
        }
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout3 = new LinearLayout(zZcINlcxH);
        linearLayout3.setOrientation(0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(100.0f), -2);
        layoutParams3.rightMargin = g4.i.r(2.0f);
        linearLayout3.addView(g4.d.b(zZcINlcxH, 10.0f, -7829368, "发布：" + g4.i.v(bVar.create_time)), layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(g4.i.r(100.0f), -2);
        if (bVar.update_time > 0) {
            int i6 = bVar.status;
            linearLayout3.addView(g4.d.b(zZcINlcxH, 10.0f, -7829368, (i6 == 1 ? "下单" : i6 == 2 ? "支付" : i6 == 4 ? "申诉" : i6 == 3 ? "成交" : "更新") + ": " + g4.i.v(bVar.update_time)), layoutParams4);
        }
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        int r5 = g4.i.r(6.0f);
        layoutParams5.bottomMargin = r5;
        layoutParams5.topMargin = r5;
        linearLayout.addView(linearLayout3, layoutParams5);
        return linearLayout;
    }

    public static TextView q(ZZcINlcxH zZcINlcxH, String str) {
        TextView c6 = g4.d.c(zZcINlcxH, 16, -1, str, 17);
        c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        return c6;
    }

    public static TextView r(ZZcINlcxH zZcINlcxH, String str) {
        TextView c6 = g4.d.c(zZcINlcxH, 16, -1, str, 17);
        c6.setBackground(g4.i.b(Color.parseColor("#666666"), 5.0f));
        return c6;
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(n nVar) {
        TextView r5;
        View.OnClickListener c0108e;
        com.secret.prettyhezi.ScoreExchange.b bVar = (com.secret.prettyhezi.ScoreExchange.b) nVar;
        this.f7081n = bVar;
        setBackground(bVar.canTalk() ? g4.i.c(0, 6.0f, -65536, 1.0f) : null);
        this.f7082o.removeAllViews();
        this.f7082o.addView(p(this.f7080m, this.f7081n), new RelativeLayout.LayoutParams(-2, -1));
        LinearLayout linearLayout = new LinearLayout(this.f7080m);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        int r6 = g4.i.r(60.0f);
        int r7 = g4.i.r(36.0f);
        ZZcINlcxH zZcINlcxH = this.f7080m;
        boolean z5 = zZcINlcxH instanceof JrBjWAK;
        com.secret.prettyhezi.ScoreExchange.b bVar2 = this.f7081n;
        int i6 = bVar2.status;
        if (i6 == 0) {
            if (z5) {
                TextView q5 = q(zZcINlcxH, "买入");
                q5.setOnClickListener(new b());
                linearLayout.addView(q5, new LinearLayout.LayoutParams(r6, r7));
            } else {
                r5 = r(zZcINlcxH, "取消");
                linearLayout.addView(r5, new LinearLayout.LayoutParams(r6, r7));
                c0108e = new c();
                r5.setOnClickListener(c0108e);
            }
        } else if (i6 == 1 || i6 == 4 || i6 == 2) {
            linearLayout.setOrientation(0);
            z zVar = new z(this.f7080m, C0382R.drawable.chat_user);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r7, r7);
            layoutParams.rightMargin = g4.i.r(6.0f);
            linearLayout.addView(zVar, layoutParams);
            TextView q6 = q(this.f7080m, this.f7081n.Status());
            q6.setTextSize(12.0f);
            q6.setTextColor(-65536);
            linearLayout.addView(q6, new LinearLayout.LayoutParams(r6, r7));
            int e6 = i.f8489j.e(this.f7081n.chat_id);
            if (e6 > 0) {
                y yVar = new y(this.f7080m);
                yVar.b(e6);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(24.0f), g4.i.r(20.0f));
                layoutParams2.rightMargin = g4.i.r(2.0f);
                linearLayout.addView(yVar, 0, layoutParams2);
            }
            setOnClickListener(new d(z5));
        } else {
            r5 = r(zZcINlcxH, bVar2.Status());
            r5.setTextColor(-65536);
            r5.setTextSize(14.0f);
            linearLayout.addView(r5, new LinearLayout.LayoutParams(r6, r7));
            if (this.f7081n.status == -3 && (this.f7080m instanceof ESXWxWYN)) {
                c0108e = new C0108e();
                r5.setOnClickListener(c0108e);
            }
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(15, -1);
        this.f7082o.addView(linearLayout, layoutParams3);
        this.f8037b = g4.i.r(linearLayout.getChildCount() > 1 ? 70.0f : 54.0f);
    }

    @Override // com.secret.prettyhezi.View.u
    public RelativeLayout getTopRelativeLayout() {
        return this.f7082o;
    }

    void u() {
        x xVar = new x(this.f7080m);
        LinearLayout linearLayout = new LinearLayout(this.f7080m);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        xVar.e(linearLayout);
        TextView b6 = g4.d.b(this.f7080m, 16.0f, -16777216, "交易须知");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = g4.i.r(10.0f);
        linearLayout.addView(b6, layoutParams);
        linearLayout.addView(g4.d.b(this.f7080m, 14.0f, -16777216, "1. 买家须抱着诚信为本的原则交易。\n2. 买家下单后请及时支付款项并点击已付款。\n3. 支付有问题，及时取消交易，重新下单，不要超时。\n4. 不要有任何作弊行为，本系统经过长期实践完善，各种作弊方式都经历过。\n4. 超时未付款，作弊等行为会有惩罚措施，封禁交易权限1天 - 永久。"), new LinearLayout.LayoutParams(-1, -2));
        xVar.d(new String[]{"暂不买入", "确认买入"}, new a(xVar));
        this.f7080m.x(xVar, null, true);
    }

    public e(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.ScoreExchange.b bVar) {
        this(zZcINlcxH);
        a(bVar);
    }
}
