package com.secret.prettyhezi.Registration;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.Server.z;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.e0;
import com.secret.prettyhezi.s;
import java.io.Serializable;
/* loaded from: classes.dex */
public class PFqTwYaD extends UoWMF {
    public static g.a A;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6893r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6894s;

    /* renamed from: t  reason: collision with root package name */
    TextView f6895t;

    /* renamed from: u  reason: collision with root package name */
    TextView f6896u;

    /* renamed from: v  reason: collision with root package name */
    TextView f6897v;

    /* renamed from: w  reason: collision with root package name */
    com.secret.prettyhezi.controls.d f6898w;

    /* renamed from: x  reason: collision with root package name */
    TextView f6899x;

    /* renamed from: y  reason: collision with root package name */
    TextView f6900y;

    /* renamed from: z  reason: collision with root package name */
    TextWatcher f6901z = new c();

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            PFqTwYaD.this.T0(1);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            PFqTwYaD.this.T0(2);
        }
    }

    /* loaded from: classes.dex */
    class c extends e0 {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String trim = PFqTwYaD.this.f6898w.f8305c.getText().toString().trim();
            int parseInt = !trim.isEmpty() ? Integer.parseInt(trim) : 0;
            if (parseInt <= 0) {
                PFqTwYaD.this.f6899x.setText("积分兑换");
                PFqTwYaD.this.f6900y.setText("登录值兑换");
                PFqTwYaD.this.f6899x.setEnabled(false);
                PFqTwYaD.this.f6900y.setEnabled(false);
                return;
            }
            TextView textView = PFqTwYaD.this.f6899x;
            textView.setText((PFqTwYaD.A.score * parseInt) + "积分兑换");
            TextView textView2 = PFqTwYaD.this.f6900y;
            textView2.setText((PFqTwYaD.A.num * parseInt) + "登录值兑换");
            a0 r5 = MainApplication.f6711r.r();
            PFqTwYaD.this.f6899x.setEnabled(r5.integral.all >= ((double) (PFqTwYaD.A.score * parseInt)));
            PFqTwYaD.this.f6900y.setEnabled(r5.integral.sign_count >= PFqTwYaD.A.num * parseInt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends s.g {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                PFqTwYaD.this.finish();
            }
        }

        d(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void f(String str) {
            super.f(str);
            PFqTwYaD.this.D("请稍后再试", new a(), false);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            g gVar = (g) com.secret.prettyhezi.f.d(str, g.class);
            if (gVar.code != 200) {
                f(gVar.err);
                return;
            }
            g.a aVar = gVar.data;
            PFqTwYaD.A = aVar;
            Fxee7N.f6872y = aVar;
            QHHnp8H.A = aVar;
            PFqTwYaD.this.V0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6907a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f6908b;

        /* loaded from: classes.dex */
        class a implements a.f {

            /* renamed from: com.secret.prettyhezi.Registration.PFqTwYaD$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0089a extends s.g {

                /* renamed from: com.secret.prettyhezi.Registration.PFqTwYaD$e$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class C0090a extends ZZcINlcxH.q {
                    C0090a() {
                    }

                    @Override // com.secret.prettyhezi.ZZcINlcxH.q
                    public void b() {
                        PFqTwYaD.this.finish();
                    }
                }

                C0089a(ZZcINlcxH zZcINlcxH) {
                    super(zZcINlcxH);
                }

                @Override // com.secret.prettyhezi.s.g
                public void g(String str) {
                    z zVar = (z) com.secret.prettyhezi.f.d(str, z.class);
                    if (zVar.code != 200) {
                        f(zVar.err);
                        return;
                    }
                    a0 r5 = MainApplication.f6711r.r();
                    e eVar = e.this;
                    int i6 = eVar.f6907a;
                    a0.e eVar2 = r5.integral;
                    if (i6 == 1) {
                        eVar2.all -= eVar.f6908b * PFqTwYaD.A.score;
                    } else {
                        eVar2.sign_count -= eVar.f6908b * PFqTwYaD.A.num;
                    }
                    MainApplication.f6711r.x();
                    EjNkL.N.f6165r.j();
                    PFqTwYaD.this.D("兑换成功", new C0090a(), false);
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                e eVar = e.this;
                com.secret.prettyhezi.j.r(v.f7132a + "user/registration/code/new/json", new f(eVar.f6907a, eVar.f6908b), true, new C0089a(PFqTwYaD.this));
            }
        }

        e(int i6, int i7) {
            this.f6907a = i6;
            this.f6908b = i7;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            com.secret.prettyhezi.Device.a.b(PFqTwYaD.this, new a());
        }
    }

    /* loaded from: classes.dex */
    static class f extends v.f {
        public int num;

        /* renamed from: t  reason: collision with root package name */
        public int f6913t;

        public f(int i6, int i7) {
            this.f6913t = i6;
            this.num = i7;
        }
    }

    /* loaded from: classes.dex */
    static class g extends w {
        public a data;

        /* loaded from: classes.dex */
        public static class a implements Serializable {
            public int amount;
            public int cny;
            public int num;
            public int score;
            public int usd;
        }

        g() {
        }
    }

    TextView S0(String str) {
        TextView c6 = g4.d.c(this, 14, -1, str, 17);
        c6.setBackground(g4.i.e(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#111111"), 5.0f), g4.i.b(Color.parseColor("#888888"), 5.0f)));
        c6.setEnabled(false);
        return c6;
    }

    void T0(int i6) {
        int parseInt = Integer.parseInt(this.f6898w.f8305c.getText().toString().trim());
        StringBuilder sb = new StringBuilder();
        sb.append((i6 == 1 ? this.f6899x : this.f6900y).getText().toString());
        sb.append(parseInt);
        sb.append("个注册码？");
        B(sb.toString(), new e(i6, parseInt), true);
    }

    void U0() {
        com.secret.prettyhezi.j.o(v.f7132a + "user/registration/code/info/json", true, new d(this));
    }

    void V0() {
        this.f6895t.setText("因容量限制，注册本系统需要注册码，使用" + A.score + "积分兑换一个注册码，注册码建议公允价值" + A.cny + "元人民币/港币或" + A.usd + "美金/欧元。");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6893r = C0;
        M(C0, "兑换注册码");
        TextView a6 = g4.d.a(this, 12.0f, -1);
        this.f6895t = a6;
        a6.setBackgroundColor(-16777216);
        this.f6895t.setPadding(g4.i.r(12.0f), g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        this.f6893r.addView(this.f6895t, new LinearLayout.LayoutParams(-1, -2));
        if (A == null) {
            I0();
            U0();
        } else {
            V0();
        }
        LinearLayout e6 = e(this.f6893r);
        this.f6894s = e6;
        e6.setGravity(1);
        int r5 = (o().x - g4.i.r(300.0f)) / 2;
        if (r5 < g4.i.r(12.0f)) {
            r5 = g4.i.r(12.0f);
        }
        this.f6894s.setPadding(r5, g4.i.r(10.0f), r5, g4.i.r(20.0f));
        a0 r6 = MainApplication.f6711r.r();
        this.f6896u = g4.d.b(this, 14.0f, -16777216, "当前可用积分: " + g4.i.F(r6.integral.all));
        this.f6897v = g4.d.b(this, 14.0f, -16777216, "当前可用登录值: " + r6.integral.sign_count);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(12.0f);
        layoutParams.bottomMargin = g4.i.r(20.0f);
        this.f6894s.addView(this.f6896u, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        int r7 = g4.i.r(12.0f);
        layoutParams2.bottomMargin = r7;
        layoutParams2.topMargin = r7;
        com.secret.prettyhezi.controls.d dVar = new com.secret.prettyhezi.controls.d(this, 0);
        this.f6898w = dVar;
        dVar.f8305c.setHint("兑换数量");
        this.f6894s.addView(this.f6898w, new LinearLayout.LayoutParams(-1, g4.i.r(48.0f)));
        com.secret.prettyhezi.controls.j.a(this.f6898w.f8305c, 3, 2);
        this.f6899x = S0("积分兑换");
        this.f6900y = S0("登录值兑换");
        this.f6899x.setOnClickListener(new a());
        this.f6900y.setOnClickListener(new b());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(200.0f), g4.i.r(40.0f));
        layoutParams3.topMargin = g4.i.r(20.0f);
        this.f6894s.addView(this.f6899x, layoutParams3);
        new LinearLayout.LayoutParams(g4.i.r(200.0f), g4.i.r(40.0f)).topMargin = g4.i.r(16.0f);
        this.f6898w.f8305c.addTextChangedListener(this.f6901z);
    }
}
