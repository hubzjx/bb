package com.secret.prettyhezi.Registration;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class UUS6bYTjG extends UoWMF {

    /* renamed from: w  reason: collision with root package name */
    public static long f6929w;

    /* renamed from: x  reason: collision with root package name */
    public static boolean f6930x;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6931r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6932s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f6933t;

    /* renamed from: u  reason: collision with root package name */
    long f6934u = 0;

    /* renamed from: v  reason: collision with root package name */
    com.secret.prettyhezi.Registration.a f6935v = null;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            UUS6bYTjG.this.M0(ZsblHj3O.class);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        protected void a(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - UUS6bYTjG.f6929w <= 3000) {
                UUS6bYTjG.this.z("请不要频繁刷新");
                return;
            }
            UUS6bYTjG.f6929w = currentTimeMillis;
            UUS6bYTjG.this.S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends s.g {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ com.secret.prettyhezi.Registration.a f6939a;

            a(com.secret.prettyhezi.Registration.a aVar) {
                this.f6939a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f6939a.u();
            }
        }

        c(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            com.secret.prettyhezi.ScoreExchange.c cVar = (com.secret.prettyhezi.ScoreExchange.c) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.ScoreExchange.c.class);
            if (cVar.code != 200) {
                f.a();
                d(cVar.err);
                return;
            }
            com.secret.prettyhezi.ScoreExchange.b[] bVarArr = cVar.data;
            if (bVarArr != null && bVarArr.length > 0) {
                com.secret.prettyhezi.ScoreExchange.b bVar = null;
                for (com.secret.prettyhezi.ScoreExchange.b bVar2 : bVarArr) {
                    int i6 = bVar2.status;
                    if (i6 == 1 || i6 == 2 || i6 == 4) {
                        bVar = bVar2;
                    }
                    com.secret.prettyhezi.Registration.a aVar = new com.secret.prettyhezi.Registration.a(UUS6bYTjG.this, bVar2);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, aVar.getItemHeight());
                    int r5 = g4.i.r(2.0f);
                    layoutParams.bottomMargin = r5;
                    layoutParams.topMargin = r5;
                    UUS6bYTjG.this.f6932s.addView(aVar, layoutParams);
                    if (bVar != null && bVar2 == bVar) {
                        UUS6bYTjG.this.f6935v = aVar;
                        if (!UUS6bYTjG.f6930x) {
                            UUS6bYTjG.f6930x = true;
                            aVar.postDelayed(new a(aVar), 50L);
                        }
                    }
                    com.secret.prettyhezi.i.f8489j.g(2);
                }
                if (bVar != null) {
                    return;
                }
            }
            UUS6bYTjG.this.I0();
            UUS6bYTjG.this.U0();
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
                f.a();
                d(c6.err);
                return;
            }
            com.secret.prettyhezi.Server.n[] nVarArr = c6.data.items;
            if (nVarArr == null || nVarArr.length <= 0) {
                UUS6bYTjG.this.f6932s.addView(g4.d.c(UUS6bYTjG.this, 16, -16777216, "暂时没有卖单，请稍后再试...", 17), new LinearLayout.LayoutParams(-1, g4.i.r(160.0f)));
                return;
            }
            for (com.secret.prettyhezi.Server.n nVar : nVarArr) {
                com.secret.prettyhezi.Registration.a aVar = new com.secret.prettyhezi.Registration.a(UUS6bYTjG.this, (com.secret.prettyhezi.ScoreExchange.b) nVar);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, aVar.getItemHeight());
                int r5 = g4.i.r(2.0f);
                layoutParams.bottomMargin = r5;
                layoutParams.topMargin = r5;
                UUS6bYTjG.this.f6932s.addView(aVar, layoutParams);
            }
        }
    }

    /* loaded from: classes.dex */
    class e extends ZZcINlcxH.q {
        e() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            UUS6bYTjG.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String T0() {
        return "本系统全自动运行，所有行为均为用户或者用户之间的行为。\n所以请一定严格按照规则操作，一旦违规系统的惩罚至少是封权限。\n虽然有仲裁机制，但是尽量不要走到仲裁这一步，因为我是不定期上线仲裁的。\n购买注册流程：\n1. 保存卖家收款码，或直接用另一个手机扫卖家收款码\n2. 用相应的付款软件严格按照订单金额付款\n3. 在沟通页面点击已付款\n4. 等待卖家确认后就可以注册账号了。\n5. 交易过程中卸载App会导致交易失败。";
    }

    public void S0() {
        if (System.currentTimeMillis() - this.f6934u < 1000) {
            return;
        }
        this.f6934u = System.currentTimeMillis();
        this.f6935v = null;
        this.f6932s.removeAllViews();
        I0();
        V0();
    }

    void U0() {
        I0();
        com.secret.prettyhezi.j.o(v.f7132a + "registration/json", true, new d(this));
    }

    void V0() {
        com.secret.prettyhezi.j.r(v.f7132a + "registration/buyer/json", new g("a"), true, new c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6931r = C0;
        RelativeLayout N = N(C0, "买注册码(刷新)", "帮助", new a());
        f6929w = System.currentTimeMillis();
        N.setOnClickListener(new b());
        LinearLayout e6 = e(this.f6931r);
        this.f6933t = e6;
        e6.setGravity(1);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f6932s = linearLayout;
        linearLayout.setOrientation(1);
        this.f6932s.setGravity(1);
        this.f6933t.addView(this.f6932s, new LinearLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        S0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH
    public void v0() {
        if (this.f6935v != null) {
            D("你正在购买注册码，请时时关注购买进度。", new e(), false);
        } else {
            super.v0();
        }
    }
}
