package com.secret.prettyhezi.Registration;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Payment.QCLQRilFO;
import com.secret.prettyhezi.Registration.PFqTwYaD;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.z;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class Fxee7N extends UoWMF {

    /* renamed from: y  reason: collision with root package name */
    public static PFqTwYaD.g.a f6872y;

    /* renamed from: z  reason: collision with root package name */
    static long f6873z;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6874r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6875s;

    /* renamed from: t  reason: collision with root package name */
    TextView f6876t;

    /* renamed from: u  reason: collision with root package name */
    TextView f6877u;

    /* renamed from: v  reason: collision with root package name */
    TextView f6878v;

    /* renamed from: w  reason: collision with root package name */
    TextView f6879w;

    /* renamed from: x  reason: collision with root package name */
    TextView f6880x;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            Fxee7N.this.U0(0);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            Fxee7N.this.U0(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends s.g {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                Fxee7N.this.finish();
            }
        }

        c(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void f(String str) {
            super.f(str);
            Fxee7N.this.D("请稍后再试", new a(), false);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            PFqTwYaD.g gVar = (PFqTwYaD.g) com.secret.prettyhezi.f.d(str, PFqTwYaD.g.class);
            if (gVar.code != 200) {
                f(gVar.err);
                return;
            }
            PFqTwYaD.g.a aVar = gVar.data;
            Fxee7N.f6872y = aVar;
            PFqTwYaD.A = aVar;
            QHHnp8H.A = aVar;
            Fxee7N.this.W0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f6885b;

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                Fxee7N.this.finish();
            }
        }

        /* loaded from: classes.dex */
        class b extends ZZcINlcxH.q {
            b() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                Fxee7N.this.M0(QCLQRilFO.class);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            this.f6885b = i6;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            z zVar = (z) com.secret.prettyhezi.f.d(str, z.class);
            if (zVar.code != 200) {
                String str2 = zVar.err;
                if (str2 == null || !str2.equals("EmptyPayCode")) {
                    f(zVar.err);
                    return;
                }
                Fxee7N fxee7N = Fxee7N.this;
                fxee7N.C("请先设置收款方式", new String[]{fxee7N.s0(C0382R.string.cancel), Fxee7N.this.s0(C0382R.string.ok)}, new b(), false);
                return;
            }
            a0 r5 = MainApplication.f6711r.r();
            int i6 = this.f6885b;
            a0.e eVar = r5.integral;
            if (i6 == 1) {
                eVar.all -= Fxee7N.f6872y.amount;
            } else {
                eVar.sign_count -= Fxee7N.f6872y.num;
            }
            MainApplication.f6711r.x();
            EjNkL.N.f6165r.j();
            com.secret.prettyhezi.i.f8489j.g(3);
            Fxee7N.this.D("出售成功", new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f6889a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f6890b;

        /* loaded from: classes.dex */
        class a implements a.f {
            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                e eVar = e.this;
                Fxee7N.this.T0(eVar.f6890b);
            }
        }

        e(x xVar, int i6) {
            this.f6889a = xVar;
            this.f6890b = i6;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            Fxee7N.this.j(this.f6889a);
            if (i6 == 1) {
                com.secret.prettyhezi.Device.a.e();
                com.secret.prettyhezi.Device.a.b(Fxee7N.this, new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f extends m {
        public int xa;

        public f(int i6) {
            super("b");
            this.xa = i6;
        }
    }

    TextView S0(String str) {
        TextView c6 = g4.d.c(this, 14, -1, str, 17);
        c6.setBackground(g4.i.e(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#111111"), 5.0f), g4.i.b(Color.parseColor("#888888"), 5.0f)));
        return c6;
    }

    void T0(int i6) {
        f6873z = System.currentTimeMillis();
        com.secret.prettyhezi.j.r(v.f7132a + "registration/seller/json", new f(i6), true, new d(this, i6));
    }

    void U0(int i6) {
        if (System.currentTimeMillis() - f6873z < 60000) {
            y("请一分钟后再试");
            return;
        }
        x xVar = new x(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        xVar.e(linearLayout);
        StringBuilder sb = new StringBuilder();
        sb.append((i6 == 0 ? this.f6879w : this.f6880x).getText().toString());
        sb.append("？");
        TextView b6 = g4.d.b(this, 16.0f, -16777216, sb.toString());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = g4.i.r(10.0f);
        linearLayout.addView(b6, layoutParams);
        linearLayout.addView(g4.d.b(this, 14.0f, -65536, "买家支付后，卖家须在60分钟内确认，超时注册码自动给对方。 超时，不诚信等行为会有惩罚措施，永久封禁交易权限"), new LinearLayout.LayoutParams(-1, -2));
        xVar.d(new String[]{"暂不挂单", "确认挂单"}, new e(xVar, i6));
        xVar.c(1, 1);
        x(xVar, null, true);
    }

    void V0() {
        com.secret.prettyhezi.j.o(v.f7132a + "user/registration/code/info/json", true, new c(this));
    }

    void W0() {
        this.f6876t.setText(f6872y.amount + "积分兑换一个注册码，系统会根据当前买卖方情况智能计算出合适价格挂单。");
        TextView textView = this.f6879w;
        textView.setText(f6872y.amount + "积分兑换注册码出售");
        TextView textView2 = this.f6880x;
        textView2.setText(f6872y.num + "登录值兑换注册码出售");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6874r = C0;
        M(C0, "出售注册码");
        TextView a6 = g4.d.a(this, 12.0f, -1);
        this.f6876t = a6;
        a6.setBackgroundColor(-16777216);
        this.f6876t.setPadding(g4.i.r(12.0f), g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        this.f6874r.addView(this.f6876t, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout e6 = e(this.f6874r);
        this.f6875s = e6;
        e6.setGravity(1);
        int r5 = (o().x - g4.i.r(300.0f)) / 2;
        if (r5 < g4.i.r(12.0f)) {
            r5 = g4.i.r(12.0f);
        }
        this.f6875s.setPadding(r5, g4.i.r(10.0f), r5, g4.i.r(20.0f));
        a0 r6 = MainApplication.f6711r.r();
        this.f6877u = g4.d.c(this, 14, -16777216, "当前可用积分: " + g4.i.F(r6.integral.all), 17);
        this.f6878v = g4.d.b(this, 14.0f, -16777216, "当前可用登录值: " + r6.integral.sign_count);
        this.f6875s.addView(this.f6877u, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int r7 = g4.i.r(12.0f);
        layoutParams.bottomMargin = r7;
        layoutParams.topMargin = r7;
        this.f6879w = S0("积分兑换注册码出售");
        this.f6880x = S0("登录值兑换注册码出售");
        this.f6879w.setOnClickListener(new a());
        this.f6880x.setOnClickListener(new b());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(200.0f), g4.i.r(40.0f));
        layoutParams2.topMargin = g4.i.r(20.0f);
        this.f6875s.addView(this.f6879w, layoutParams2);
        new LinearLayout.LayoutParams(g4.i.r(200.0f), g4.i.r(40.0f)).topMargin = g4.i.r(16.0f);
        if (f6872y != null) {
            W0();
            return;
        }
        I0();
        V0();
    }
}
