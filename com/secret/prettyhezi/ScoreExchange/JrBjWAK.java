package com.secret.prettyhezi.ScoreExchange;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.ScoreExchange.f;
import com.secret.prettyhezi.Server.g;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.View.n;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.message.AWsQxAQ;
import com.secret.prettyhezi.s;
import g4.i;
/* loaded from: classes.dex */
public class JrBjWAK extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7048r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f7049s;

    /* renamed from: t  reason: collision with root package name */
    boolean f7050t;

    /* renamed from: u  reason: collision with root package name */
    String[] f7051u;

    /* renamed from: v  reason: collision with root package name */
    String[] f7052v;

    /* renamed from: w  reason: collision with root package name */
    n f7053w = null;

    /* renamed from: x  reason: collision with root package name */
    int f7054x = 0;

    /* renamed from: y  reason: collision with root package name */
    long f7055y = 0;

    /* renamed from: z  reason: collision with root package name */
    com.secret.prettyhezi.ScoreExchange.b f7056z = null;
    int A = 0;
    public int B = -1;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            JrBjWAK.this.M0(Q1Y0tWRI.class);
        }
    }

    /* loaded from: classes.dex */
    class b implements com.secret.prettyhezi.e {
        b() {
        }

        @Override // com.secret.prettyhezi.e
        public void a(int i6) {
            JrBjWAK.this.T0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements n.b {
        c() {
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void a(int i6) {
            String str;
            g.d dVar = MainApplication.f6711r.k().sys;
            if (i6 != 0) {
                JrBjWAK jrBjWAK = JrBjWAK.this;
                if (jrBjWAK.f7056z != null || jrBjWAK.A >= dVar.mboptb) {
                    jrBjWAK.f7053w.setCurrentTab(0);
                    JrBjWAK jrBjWAK2 = JrBjWAK.this;
                    if (jrBjWAK2.f7056z != null) {
                        str = "你有未支付的单，请与卖家及时沟通";
                    } else {
                        str = "你有" + JrBjWAK.this.A + "个未完成的订单，请与卖家及时沟通";
                    }
                    jrBjWAK2.q(str);
                    return;
                }
            }
            JrBjWAK jrBjWAK3 = JrBjWAK.this;
            if (jrBjWAK3.f7054x != i6) {
                jrBjWAK3.V0(i6);
                JrBjWAK.this.f7054x = i6;
            }
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void b(int i6) {
            ((ScrollView) JrBjWAK.this.f7049s.getParent()).scrollTo(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7060b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            this.f7060b = i6;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            com.secret.prettyhezi.ScoreExchange.b[] bVarArr;
            com.secret.prettyhezi.ScoreExchange.c cVar = (com.secret.prettyhezi.ScoreExchange.c) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.ScoreExchange.c.class);
            if (cVar.code != 200) {
                d(cVar.err);
                return;
            }
            com.secret.prettyhezi.ScoreExchange.b[] bVarArr2 = cVar.data;
            if (bVarArr2 == null || bVarArr2.length <= 0) {
                JrBjWAK.this.f7049s.addView(g4.d.c(JrBjWAK.this, 16, -16777216, this.f7060b == 0 ? "您没有任何订单" : "暂时没有卖单，请稍候...", 17), new LinearLayout.LayoutParams(-1, i.r(100.0f)));
            } else {
                int i6 = 0;
                while (true) {
                    bVarArr = cVar.data;
                    if (i6 >= bVarArr.length) {
                        break;
                    }
                    if (i6 != 0) {
                        JrBjWAK jrBjWAK = JrBjWAK.this;
                        jrBjWAK.W(jrBjWAK.f7049s, Color.parseColor("#cccccc"), 0.5f, 12, 0, 12);
                    }
                    e eVar = new e(JrBjWAK.this, cVar.data[i6]);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, eVar.getItemHeight());
                    layoutParams.topMargin = i.r(4.0f);
                    JrBjWAK.this.f7049s.addView(eVar, layoutParams);
                    i6++;
                }
                if (this.f7060b == 0) {
                    JrBjWAK jrBjWAK2 = JrBjWAK.this;
                    jrBjWAK2.A = 0;
                    jrBjWAK2.f7056z = null;
                    for (com.secret.prettyhezi.ScoreExchange.b bVar : bVarArr) {
                        int i7 = bVar.status;
                        if (i7 == 1) {
                            JrBjWAK jrBjWAK3 = JrBjWAK.this;
                            jrBjWAK3.f7056z = bVar;
                            int i8 = jrBjWAK3.B;
                            if (i8 >= 0 && bVar.id == i8) {
                                jrBjWAK3.B = -1;
                                AWsQxAQ.T0(jrBjWAK3, 1, bVar.chat_id, bVar);
                            }
                        } else if (i7 == 2 || i7 == 4) {
                            JrBjWAK.this.A++;
                        }
                    }
                }
            }
            JrBjWAK jrBjWAK4 = JrBjWAK.this;
            if (jrBjWAK4.f7050t) {
                jrBjWAK4.f7050t = false;
                if (jrBjWAK4.A == 0 && jrBjWAK4.f7056z == null) {
                    jrBjWAK4.f7053w.setCurrentTab(1);
                } else {
                    com.secret.prettyhezi.i.f8489j.g(0);
                }
            }
            if (this.f7060b == 0) {
                JrBjWAK jrBjWAK5 = JrBjWAK.this;
                if (jrBjWAK5.f7056z != null || jrBjWAK5.A > 0) {
                    TextView c6 = g4.d.c(jrBjWAK5, 16, -65536, "您有未完成的买单，请与卖家及时沟通", 17);
                    c6.setBackgroundColor(Color.parseColor("#f0f0f0"));
                    JrBjWAK.this.f7049s.addView(c6, 0, new LinearLayout.LayoutParams(-1, i.r(60.0f)));
                }
            }
        }
    }

    public void S0() {
        if (L0() || this.f7049s == null || System.currentTimeMillis() - this.f7055y < 1000) {
            return;
        }
        this.f7055y = System.currentTimeMillis();
        this.f7049s.removeAllViews();
        this.f7056z = null;
        this.A = 0;
        if (this.f7054x == 0) {
            V0(0);
        } else {
            this.f7053w.setCurrentTab(0);
        }
    }

    void T0() {
        U0();
        LinearLayout e6 = e(this.f7048r);
        this.f7049s = e6;
        e6.setGravity(1);
        this.f7049s.setBackgroundColor(-1);
        V0(this.f7054x);
    }

    void U0() {
        f.d[] dVarArr = f.f7098a.types;
        String[] strArr = new String[dVarArr.length + 1];
        this.f7051u = strArr;
        String[] strArr2 = new String[strArr.length];
        this.f7052v = strArr2;
        strArr[0] = "我的";
        strArr2[0] = "transaction/buyer/json";
        int i6 = 0;
        while (i6 < dVarArr.length) {
            String[] strArr3 = this.f7051u;
            int i7 = i6 + 1;
            strArr3[i7] = dVarArr[i6].amount + "区";
            String[] strArr4 = this.f7052v;
            strArr4[i7] = "transaction/json?t=" + dVarArr[i6].id;
            i6 = i7;
        }
        this.f7053w = new n(this, this.f7051u, new c());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i.r(42.0f));
        layoutParams.topMargin = i.r(1.0f);
        this.f7048r.addView(this.f7053w, layoutParams);
        this.f7053w.setCurrentTab(0);
    }

    void V0(int i6) {
        this.f7049s.removeAllViews();
        I0();
        j.o(v.f7132a + this.f7052v[i6], true, new d(this, i6));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7048r = C0;
        this.f7050t = true;
        N(C0, "买积分", "帮助", new a());
        f.a(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f7053w == null) {
            return;
        }
        this.f7055y = System.currentTimeMillis();
        if (L0()) {
            return;
        }
        V0(this.f7054x);
    }
}
