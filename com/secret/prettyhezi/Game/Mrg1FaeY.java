package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import com.secret.prettyhezi.share.DyOuR;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class Mrg1FaeY extends UoWMF {

    /* renamed from: s  reason: collision with root package name */
    com.secret.prettyhezi.controls.d f6276s;

    /* renamed from: t  reason: collision with root package name */
    TextView f6277t;

    /* renamed from: r  reason: collision with root package name */
    boolean f6275r = false;

    /* renamed from: u  reason: collision with root package name */
    long f6278u = 0;

    /* renamed from: v  reason: collision with root package name */
    int f6279v = 0;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        protected void a(View view) {
            String trim = Mrg1FaeY.this.f6276s.f8305c.getText().toString().trim();
            if (trim.length() == 0) {
                return;
            }
            int parseInt = Integer.parseInt(trim);
            if (parseInt <= 0) {
                Mrg1FaeY.this.y("请填写正确的金币数量");
            } else {
                Mrg1FaeY.this.T0(parseInt);
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        protected void a(View view) {
            Mrg1FaeY.this.M0(DyOuR.class);
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Mrg1FaeY.this.U0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6283a;

        /* loaded from: classes.dex */
        class a implements a.f {
            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                d dVar = d.this;
                Mrg1FaeY.this.S0(dVar.f6283a);
            }
        }

        d(int i6) {
            this.f6283a = i6;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            com.secret.prettyhezi.Device.a.e();
            com.secret.prettyhezi.Device.a.b(Mrg1FaeY.this, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f6286b;

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            this.f6286b = i6;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            a0.e eVar;
            double d6;
            com.secret.prettyhezi.Server.z zVar = (com.secret.prettyhezi.Server.z) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.Server.z.class);
            if (zVar.code != 200) {
                f(zVar.err);
                return;
            }
            if (Mrg1FaeY.this.f6275r) {
                i.f6608a.integral += this.f6286b;
                eVar = MainApplication.f6711r.r().integral;
                d6 = eVar.all - this.f6286b;
            } else {
                i.f6608a.integral -= this.f6286b;
                eVar = MainApplication.f6711r.r().integral;
                d6 = eVar.all + this.f6286b;
            }
            eVar.all = d6;
            MainApplication.f6711r.x();
            EjNkL.N.f6165r.j();
            Mrg1FaeY.this.V0();
            Mrg1FaeY.this.D("操作成功", new a(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f implements Serializable {
        int integral;
        String passwd = com.secret.prettyhezi.Device.a.a();

        f(int i6) {
            this.integral = i6;
        }
    }

    void S0(int i6) {
        I0();
        StringBuilder sb = new StringBuilder();
        sb.append(i.a());
        sb.append(this.f6275r ? "auth/payenter/json" : "auth/payout/json");
        com.secret.prettyhezi.j.t(sb.toString(), com.secret.prettyhezi.f.e(new f(i6)), i.f6608a.token.token, 3, new e(this, i6));
    }

    void T0(int i6) {
        StringBuilder sb = new StringBuilder();
        sb.append("确定");
        sb.append(i6);
        sb.append(this.f6275r ? "积分" : "金币");
        sb.append("兑换");
        sb.append(i6);
        sb.append(this.f6275r ? "金币" : "积分");
        sb.append("?");
        C(sb.toString(), new String[]{s0(C0382R.string.cancel), "兑换"}, new d(i6), true);
    }

    void U0() {
        long currentTimeMillis = System.currentTimeMillis();
        int i6 = this.f6279v;
        if (i6 <= 0 || currentTimeMillis - this.f6278u >= 500) {
            this.f6279v = 1;
            this.f6278u = currentTimeMillis;
            return;
        }
        int i7 = i6 + 1;
        this.f6279v = i7;
        this.f6278u = currentTimeMillis;
        if (i7 >= 3) {
            M0(TXkNPZRG.class);
        }
    }

    void V0() {
        this.f6277t.setText(String.format("当前金币: %d, 当前积分: ", Integer.valueOf(i.f6608a.integral)) + g4.i.F(MainApplication.f6711r.r().integral.all));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        TextView c6;
        View.OnClickListener cVar;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6275r = extras.getInt("id") == 0;
        }
        LinearLayout C0 = C0();
        String str = this.f6275r ? "充值金币" : "提现金币";
        M(C0, str);
        C0.setBackgroundColor(-1);
        V(C0, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        LinearLayout e6 = e(C0);
        e6.setGravity(1);
        e6.setPadding(0, g4.i.r(20.0f), 0, g4.i.r(20.0f));
        TextView c7 = g4.d.c(this, 14, Color.parseColor("#333333"), HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f6277t = c7;
        e6.addView(c7, new LinearLayout.LayoutParams(-1, -2));
        V0();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = g4.i.r(20.0f);
        layoutParams.topMargin = g4.i.r(20.0f);
        e6.addView(linearLayout, layoutParams);
        com.secret.prettyhezi.controls.d dVar = new com.secret.prettyhezi.controls.d(this);
        this.f6276s = dVar;
        EditText editText = dVar.f8305c;
        editText.setHint(str + "数额");
        this.f6276s.f8305c.setInputType(2);
        this.f6276s.setBackground(g4.i.c(-1, 5.0f, -16777216, 1.0f));
        com.secret.prettyhezi.controls.j.a(this.f6276s.f8305c, 8, 2);
        linearLayout.addView(this.f6276s, new LinearLayout.LayoutParams(g4.i.r(200.0f), g4.i.r(48.0f)));
        e6.addView(g4.d.b(this, 14.0f, -65536, "*积分与金币1:1兑换*"), new LinearLayout.LayoutParams(-2, -2));
        TextView c8 = g4.d.c(this, 16, -1, str, 17);
        c8.setBackground(g4.i.e(g4.i.b(-16777216, 5.0f), g4.i.b(Color.parseColor("#666666"), 5.0f), g4.i.b(Color.parseColor("#666666"), 5.0f)));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(160.0f), g4.i.r(38.0f));
        layoutParams2.topMargin = g4.i.r(20.0f);
        e6.addView(c8, layoutParams2);
        c8.setOnClickListener(new a());
        if (this.f6275r) {
            c6 = g4.d.c(this, 12, Color.parseColor("#666666"), "积分不够用？ 去看看积分市场", 17);
            c6.setBackground(g4.i.d(g4.i.c(0, 5.0f, Color.parseColor("#cccccc"), 1.0f), g4.i.c(Color.parseColor("#f0f0f0"), 5.0f, Color.parseColor("#cccccc"), 1.0f)));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(200.0f), g4.i.r(40.0f));
            layoutParams3.topMargin = g4.i.r(40.0f);
            e6.addView(c6, layoutParams3);
            cVar = new b();
        } else if (i.f6608a.f6629m != 1) {
            return;
        } else {
            c6 = g4.d.c(this, 18, Color.parseColor("#cccccc"), ".", 17);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(g4.i.r(50.0f), g4.i.r(40.0f));
            layoutParams4.topMargin = g4.i.r(120.0f);
            e6.addView(c6, layoutParams4);
            cVar = new c();
        }
        c6.setOnClickListener(cVar);
    }
}
