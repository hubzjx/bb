package com.secret.prettyhezi.Registration;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Registration.PFqTwYaD;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class QHHnp8H extends UoWMF {
    public static PFqTwYaD.g.a A;

    /* renamed from: z  reason: collision with root package name */
    public static boolean f6914z;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6915r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6916s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f6917t;

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f6920w;

    /* renamed from: x  reason: collision with root package name */
    TextView f6921x;

    /* renamed from: u  reason: collision with root package name */
    LinearLayout f6918u = null;

    /* renamed from: v  reason: collision with root package name */
    long f6919v = 0;

    /* renamed from: y  reason: collision with root package name */
    int f6922y = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            int i6;
            int i7;
            com.secret.prettyhezi.ScoreExchange.b[] bVarArr;
            com.secret.prettyhezi.ScoreExchange.c cVar = (com.secret.prettyhezi.ScoreExchange.c) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.ScoreExchange.c.class);
            if (cVar.code != 200) {
                d(cVar.err);
                return;
            }
            com.secret.prettyhezi.ScoreExchange.b[] bVarArr2 = cVar.data;
            if (bVarArr2 == null || bVarArr2.length <= 0) {
                i6 = 0;
                i7 = 0;
            } else {
                QHHnp8H.this.f6920w = new LinearLayout(QHHnp8H.this);
                QHHnp8H.this.f6920w.setOrientation(1);
                QHHnp8H qHHnp8H = QHHnp8H.this;
                qHHnp8H.f6916s.addView(qHHnp8H.f6920w, new LinearLayout.LayoutParams(-1, -2));
                i6 = 0;
                i7 = 0;
                int i8 = 0;
                for (com.secret.prettyhezi.ScoreExchange.b bVar : cVar.data) {
                    int i9 = bVar.status;
                    if (i9 == 0) {
                        i6++;
                    } else if (i9 == 1 || i9 == 2) {
                        i7++;
                    } else if (i9 == 4) {
                        i8++;
                    }
                    com.secret.prettyhezi.Registration.a aVar = new com.secret.prettyhezi.Registration.a(QHHnp8H.this, bVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, aVar.getItemHeight());
                    int r5 = g4.i.r(2.0f);
                    layoutParams.bottomMargin = r5;
                    layoutParams.topMargin = r5;
                    QHHnp8H.this.f6920w.addView(aVar, layoutParams);
                }
                if (i6 + i7 + i8 > 0) {
                    com.secret.prettyhezi.i.f8489j.g(3);
                }
            }
            int i10 = i6 + i7;
            if (i10 < MainApplication.f6711r.k().sys.msorct) {
                QHHnp8H.this.U0();
                return;
            }
            QHHnp8H.this.f6916s.addView(g4.d.c(QHHnp8H.this, 16, -65536, "您有" + i10 + "个订单进行中，请先等待它们成交或取消订单", 17), 0, new LinearLayout.LayoutParams(-1, g4.i.r(80.0f)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            int i6 = MainApplication.f6711r.k().sys.msoarct;
            QHHnp8H qHHnp8H = QHHnp8H.this;
            if (qHHnp8H.f6922y < i6) {
                qHHnp8H.W0();
            } else {
                qHHnp8H.D("当前挂单量已达最大值，请稍后再试", null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends ZZcINlcxH.q {
        c() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            QHHnp8H.this.M0(Fxee7N.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends s.g {
        d(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            com.secret.prettyhezi.Server.o c6 = com.secret.prettyhezi.f.c(str, com.secret.prettyhezi.ScoreExchange.b.class);
            if (c6.code != 200) {
                d(c6.err);
                return;
            }
            com.secret.prettyhezi.Server.n[] nVarArr = c6.data.items;
            if (nVarArr == null || nVarArr.length <= 0) {
                QHHnp8H qHHnp8H = QHHnp8H.this;
                qHHnp8H.f6922y = 0;
                TextView c7 = g4.d.c(qHHnp8H, 16, -16777216, "当前无卖单", 1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = g4.i.r(20.0f);
                layoutParams.bottomMargin = g4.i.r(20.0f);
                QHHnp8H.this.f6917t.addView(c7, layoutParams);
                return;
            }
            int i6 = MainApplication.f6711r.k().sys.msoarct;
            QHHnp8H.this.f6922y = c6.data.total;
            TextView c8 = g4.d.c(QHHnp8H.this, 14, -65536, "*当总挂单量少于" + i6 + "个才能挂单成功*", 1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = g4.i.r(10.0f);
            layoutParams2.bottomMargin = g4.i.r(20.0f);
            layoutParams2.leftMargin = g4.i.r(12.0f);
            QHHnp8H.this.f6917t.addView(c8, layoutParams2);
            for (com.secret.prettyhezi.Server.n nVar : c6.data.items) {
                LinearLayout p5 = com.secret.prettyhezi.Registration.a.p(QHHnp8H.this, (com.secret.prettyhezi.ScoreExchange.b) nVar);
                p5.setPadding(g4.i.r(6.0f), g4.i.r(2.0f), g4.i.r(6.0f), g4.i.r(2.0f));
                p5.setBackground(g4.i.b(-1, 5.0f));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                int r5 = g4.i.r(2.0f);
                layoutParams3.bottomMargin = r5;
                layoutParams3.topMargin = r5;
                int r6 = g4.i.r(12.0f);
                layoutParams3.rightMargin = r6;
                layoutParams3.leftMargin = r6;
                QHHnp8H.this.f6917t.addView(p5, layoutParams3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends s.g {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                QHHnp8H.this.finish();
            }
        }

        e(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void f(String str) {
            super.f(str);
            QHHnp8H.this.D("请稍后再试", new a(), false);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            PFqTwYaD.g gVar = (PFqTwYaD.g) com.secret.prettyhezi.f.d(str, PFqTwYaD.g.class);
            if (gVar.code != 200) {
                f(gVar.err);
                return;
            }
            PFqTwYaD.g.a aVar = gVar.data;
            QHHnp8H.A = aVar;
            PFqTwYaD.A = aVar;
            Fxee7N.f6872y = aVar;
        }
    }

    public void S0() {
        if (!L0() && System.currentTimeMillis() - this.f6919v >= 1000) {
            this.f6919v = System.currentTimeMillis();
            T0();
            this.f6916s.removeAllViews();
            this.f6918u = null;
            I0();
            com.secret.prettyhezi.j.r(v.f7132a + "registration/seller/json", new g("a"), true, new a(this));
        }
    }

    void T0() {
        this.f6917t.removeAllViews();
        I0();
        com.secret.prettyhezi.j.o(v.f7132a + "registration/json", true, new d(this));
    }

    void U0() {
        LinearLayout linearLayout = this.f6918u;
        if (linearLayout != null && linearLayout.getParent() != null) {
            this.f6916s.removeView(this.f6918u);
            this.f6918u = null;
        }
        LinearLayout linearLayout2 = new LinearLayout(this);
        this.f6918u = linearLayout2;
        linearLayout2.setOrientation(1);
        this.f6918u.setGravity(1);
        this.f6918u.setPadding(0, g4.i.r(20.0f), 0, g4.i.r(30.0f));
        this.f6916s.addView(this.f6918u, 0, new LinearLayout.LayoutParams(-1, -2));
        TextView c6 = g4.d.c(this, 18, -1, "新建卖单", 17);
        this.f6921x = c6;
        c6.setOnClickListener(new b());
        this.f6921x.setBackground(g4.i.d(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        this.f6918u.addView(this.f6921x, new LinearLayout.LayoutParams(g4.i.r(100.0f), g4.i.r(40.0f)));
    }

    void V0() {
        if (A != null) {
            return;
        }
        com.secret.prettyhezi.j.o(v.f7132a + "user/registration/code/info/json", true, new e(this));
    }

    void W0() {
        int i6;
        PFqTwYaD.g.a aVar = A;
        if (aVar != null) {
            i6 = aVar.amount;
            int i7 = aVar.num;
        } else {
            i6 = 1500;
        }
        x G = G("出售注册码须知", "1. 本系统全自动运行，所有行为均为用户或者用户之间的行为。\n2. 所以请一定严格按照规则操作，一旦违规系统的惩罚至少是封权限。\n3. 虽然有仲裁机制，但是尽量不要走到仲裁这一步，因为我是不定期上线仲裁的。\n4. 确保账户有足够的积分(" + i6 + "积分)。\n5. 确保设置正确的收款方式。\n6. 为保证能够及时处理卖单，出售队列有长度限制，请多刷新创建卖单。\n7. 买家付款后，卖家须及时确认，超时不确认直接判定卖家违规，封禁卖家权限并不退回积分等。\n8. 为账户安全，账户只能在已绑定的设备上出售注册码。\n9. 通过本渠道出售的注册码，卖家和买家之间不建立邀请关系。", s0(C0382R.string.IKnow), new c(), true, 3);
        G.f8479f.setTextSize(13.0f);
        G.f8479f.setGravity(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6915r = C0;
        M(C0, "卖注册码");
        LinearLayout e6 = e(this.f6915r);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f6916s = linearLayout;
        linearLayout.setOrientation(1);
        e6.addView(this.f6916s, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(this);
        this.f6917t = linearLayout2;
        linearLayout2.setOrientation(1);
        e6.addView(this.f6917t, new LinearLayout.LayoutParams(-1, -2));
        V0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        S0();
    }
}
