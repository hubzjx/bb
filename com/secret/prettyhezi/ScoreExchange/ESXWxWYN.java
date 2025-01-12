package com.secret.prettyhezi.ScoreExchange;

import android.graphics.Color;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Payment.QCLQRilFO;
import com.secret.prettyhezi.ScoreExchange.f;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.g;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.i;
/* loaded from: classes.dex */
public class ESXWxWYN extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7030r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f7031s;

    /* renamed from: v  reason: collision with root package name */
    LinearLayout f7034v;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f7032t = null;

    /* renamed from: u  reason: collision with root package name */
    long f7033u = 0;

    /* renamed from: w  reason: collision with root package name */
    ArrayMap f7035w = new ArrayMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {

        /* renamed from: com.secret.prettyhezi.ScoreExchange.ESXWxWYN$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0100a implements com.secret.prettyhezi.e {
            C0100a() {
            }

            @Override // com.secret.prettyhezi.e
            public void a(int i6) {
                ESXWxWYN.this.T0();
            }
        }

        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            com.secret.prettyhezi.ScoreExchange.b[] bVarArr;
            ESXWxWYN.this.f7035w.clear();
            com.secret.prettyhezi.ScoreExchange.c cVar = (com.secret.prettyhezi.ScoreExchange.c) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.ScoreExchange.c.class);
            if (cVar.code != 200) {
                d(cVar.err);
                return;
            }
            com.secret.prettyhezi.ScoreExchange.b[] bVarArr2 = cVar.data;
            if (bVarArr2 != null && bVarArr2.length > 0) {
                ESXWxWYN.this.f7034v = new LinearLayout(ESXWxWYN.this);
                ESXWxWYN.this.f7034v.setOrientation(1);
                ESXWxWYN eSXWxWYN = ESXWxWYN.this;
                eSXWxWYN.f7031s.addView(eSXWxWYN.f7034v, new LinearLayout.LayoutParams(-1, -2));
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                for (com.secret.prettyhezi.ScoreExchange.b bVar : cVar.data) {
                    if (ESXWxWYN.this.f7035w.get(Integer.valueOf(bVar.amount)) == null) {
                        ESXWxWYN.this.f7035w.put(Integer.valueOf(bVar.amount), 0);
                    }
                    int i9 = bVar.status;
                    if (i9 == 0) {
                        i6++;
                    } else if (i9 == 1 || i9 == 2) {
                        i7++;
                    } else {
                        if (i9 == 4) {
                            i8++;
                        }
                        ESXWxWYN eSXWxWYN2 = ESXWxWYN.this;
                        eSXWxWYN2.W(eSXWxWYN2.f7034v, Color.parseColor("#cccccc"), 0.5f, 12, 0, 12);
                        e eVar = new e(ESXWxWYN.this, bVar);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, eVar.getItemHeight());
                        int r5 = i.r(2.0f);
                        layoutParams.bottomMargin = r5;
                        layoutParams.topMargin = r5;
                        ESXWxWYN.this.f7034v.addView(eVar, layoutParams);
                    }
                    ESXWxWYN.this.f7035w.put(Integer.valueOf(bVar.amount), Integer.valueOf(((Integer) ESXWxWYN.this.f7035w.get(Integer.valueOf(bVar.amount))).intValue() + 1));
                    ESXWxWYN eSXWxWYN22 = ESXWxWYN.this;
                    eSXWxWYN22.W(eSXWxWYN22.f7034v, Color.parseColor("#cccccc"), 0.5f, 12, 0, 12);
                    e eVar2 = new e(ESXWxWYN.this, bVar);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, eVar2.getItemHeight());
                    int r52 = i.r(2.0f);
                    layoutParams2.bottomMargin = r52;
                    layoutParams2.topMargin = r52;
                    ESXWxWYN.this.f7034v.addView(eVar2, layoutParams2);
                }
                if (i6 + i7 + i8 > 0) {
                    com.secret.prettyhezi.i.f8489j.g(1);
                }
            }
            f.a(ESXWxWYN.this, new C0100a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ f.c f7038d;

        b(f.c cVar) {
            this.f7038d = cVar;
        }

        @Override // g4.f
        public void a(View view) {
            ESXWxWYN.this.U0(this.f7038d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f7040a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f.c f7041b;

        /* loaded from: classes.dex */
        class a implements a.f {

            /* renamed from: com.secret.prettyhezi.ScoreExchange.ESXWxWYN$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0101a implements s.f {
                C0101a() {
                }

                @Override // com.secret.prettyhezi.s.f
                public void a(String str) {
                    MainApplication.f6711r.r().integral.all -= c.this.f7041b.amount;
                    MainApplication.f6711r.x();
                    ESXWxWYN.this.H("挂单成功");
                    com.secret.prettyhezi.i.f8489j.g(1);
                    ESXWxWYN.this.S0();
                }
            }

            /* loaded from: classes.dex */
            class b extends s.e {

                /* renamed from: com.secret.prettyhezi.ScoreExchange.ESXWxWYN$c$a$b$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class RunnableC0102a implements Runnable {

                    /* renamed from: com.secret.prettyhezi.ScoreExchange.ESXWxWYN$c$a$b$a$a  reason: collision with other inner class name */
                    /* loaded from: classes.dex */
                    class C0103a extends ZZcINlcxH.q {
                        C0103a() {
                        }

                        @Override // com.secret.prettyhezi.ZZcINlcxH.q
                        public void b() {
                            ESXWxWYN.this.M0(QCLQRilFO.class);
                        }
                    }

                    RunnableC0102a() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ESXWxWYN eSXWxWYN = ESXWxWYN.this;
                        eSXWxWYN.C("请先设置收款方式", new String[]{eSXWxWYN.s0(C0382R.string.cancel), ESXWxWYN.this.s0(C0382R.string.ok)}, new C0103a(), false);
                    }
                }

                b(ZZcINlcxH zZcINlcxH, s.f fVar) {
                    super(zZcINlcxH, fVar);
                }

                @Override // com.secret.prettyhezi.s.g
                public void d(String str) {
                    if (str == null || !str.equals("EmptyPayCode")) {
                        super.d(str);
                    } else {
                        ESXWxWYN.this.runOnUiThread(new RunnableC0102a());
                    }
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                ESXWxWYN.this.I0();
                j.r(v.f7132a + "transaction/seller/new/json", new com.secret.prettyhezi.ScoreExchange.a(c.this.f7041b.id), true, new b(ESXWxWYN.this, new C0101a()));
            }
        }

        c(x xVar, f.c cVar) {
            this.f7040a = xVar;
            this.f7041b = cVar;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            ESXWxWYN.this.j(this.f7040a);
            if (i6 == 1) {
                com.secret.prettyhezi.Device.a.e();
                com.secret.prettyhezi.Device.a.b(ESXWxWYN.this, new a());
            }
        }
    }

    public void S0() {
        if (!L0() && System.currentTimeMillis() - this.f7033u >= 1000) {
            this.f7033u = System.currentTimeMillis();
            this.f7035w.clear();
            this.f7031s.removeAllViews();
            this.f7032t = null;
            I0();
            j.o(v.f7132a + "transaction/seller/json", true, new a(this));
        }
    }

    void T0() {
        f.c[] cVarArr = f.f7098a.news;
        g.d dVar = MainApplication.f6711r.k().sys;
        a0 r5 = MainApplication.f6711r.r();
        boolean z5 = false;
        for (f.c cVar : cVarArr) {
            if (this.f7035w.get(Integer.valueOf(cVar.amount)) == null) {
                this.f7035w.put(Integer.valueOf(cVar.amount), 0);
            }
            double d6 = r5.integral.all;
            int i6 = cVar.amount;
            if (d6 >= i6 && ((Integer) this.f7035w.get(Integer.valueOf(i6))).intValue() < dVar.msopt) {
                z5 = true;
            }
        }
        if (!z5) {
            this.f7031s.addView(g4.d.c(this, 16, -65536, "您的订单额度已用完，请等待现有订单成交或取消订单", 17), 0, new LinearLayout.LayoutParams(-1, i.r(80.0f)));
            return;
        }
        LinearLayout linearLayout = this.f7032t;
        if (linearLayout != null && linearLayout.getParent() != null) {
            this.f7031s.removeView(this.f7032t);
            this.f7032t = null;
        }
        LinearLayout linearLayout2 = new LinearLayout(this);
        this.f7032t = linearLayout2;
        linearLayout2.setOrientation(1);
        this.f7032t.setGravity(1);
        this.f7032t.setPadding(0, i.r(20.0f), 0, i.r(30.0f));
        this.f7031s.addView(this.f7032t, 0, new LinearLayout.LayoutParams(-1, -2));
        int i7 = r5.upload ? dVar.upload_min_score : dVar.min_score;
        TextView c6 = g4.d.c(this, 16, -16777216, "当前积分：" + i.F(r5.integral.all), 17);
        c6.setPadding(0, i.r(10.0f), 0, 0);
        this.f7032t.addView(c6, new LinearLayout.LayoutParams(-2, -2));
        if (r5.integral.all < i7) {
            TextView c7 = g4.d.c(this, 16, -65536, "积分超过" + i7 + "才可出售", 17);
            c7.setPadding(0, i.r(10.0f), 0, 0);
            this.f7032t.addView(c7, new LinearLayout.LayoutParams(-2, -2));
            return;
        }
        for (f.c cVar2 : cVarArr) {
            double d7 = r5.integral.all;
            int i8 = cVar2.amount;
            if (d7 >= i8 && ((Integer) this.f7035w.get(Integer.valueOf(i8))).intValue() < dVar.msopt) {
                boolean z6 = ((double) Math.abs(((float) (cVar2.amount / 100)) - cVar2.cny)) < 0.01d;
                String str = "以" + i.B(cVar2.cny) + "元出售" + cVar2.amount + "积分";
                if (z6) {
                    str = str + "\n(平价更快成交)";
                }
                TextView c8 = g4.d.c(this, 18, -1, str, 17);
                c8.setOnClickListener(new b(cVar2));
                c8.setBackground(i.d(i.b(Color.parseColor("#333333"), 5.0f), i.b(Color.parseColor("#aaaaaa"), 5.0f)));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(220.0f), i.r(z6 ? 66.0f : 46.0f));
                layoutParams.topMargin = i.r(20.0f);
                this.f7032t.addView(c8, layoutParams);
            }
        }
        TextView b6 = g4.d.b(this, 14.0f, Color.parseColor("#333333"), "系统会根据当前买卖方情况智能计算出合适价格挂单");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        int r6 = i.r(20.0f);
        layoutParams2.bottomMargin = r6;
        layoutParams2.topMargin = r6;
        this.f7032t.addView(b6, layoutParams2);
        TextView c9 = g4.d.c(this, 14, -65536, "*当区域积分市场挂单量少于" + dVar.msoapt + "个时才能挂单成功*", 17);
        c9.setPadding(0, i.r(20.0f), 0, i.r(20.0f));
        this.f7032t.addView(c9, new LinearLayout.LayoutParams(-2, -2));
    }

    void U0(f.c cVar) {
        x xVar = new x(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        xVar.e(linearLayout);
        TextView b6 = g4.d.b(this, 16.0f, -16777216, "交易须知");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = i.r(10.0f);
        linearLayout.addView(b6, layoutParams);
        linearLayout.addView(g4.d.b(this, 14.0f, -16777216, "1. 卖家须抱着诚信为本的原则交易。\n2. 买家支付后，卖家须在60分钟内确认，超时积分自动给对方。\n3. 交易中间有任何问题，请使用仲裁系统，包括并不限于未收到款，未收到全款，收款金额大于订单金额等。\n4. 超时，不诚信等行为会有惩罚措施，封禁交易权限1天 - 永久。"), new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(g4.d.c(this, 16, -65536, "以" + i.B(cVar.cny) + "元出售" + cVar.amount + "积分", 17), new LinearLayout.LayoutParams(-1, i.r(40.0f)));
        StringBuilder sb = new StringBuilder();
        sb.append("确认挂单");
        sb.append(cVar.amount);
        sb.append("积分");
        xVar.d(new String[]{"暂不挂单", sb.toString()}, new c(xVar, cVar));
        x(xVar, null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7030r = C0;
        M(C0, "卖积分");
        V(this.f7030r, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        LinearLayout e6 = e(this.f7030r);
        this.f7031s = e6;
        e6.setGravity(1);
        this.f7031s.setBackgroundColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        S0();
    }
}
