package com.secret.prettyhezi.User;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.A0TdcT;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.OAnkX;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.p;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.a0;
import com.secret.prettyhezi.controls.e0;
import com.secret.prettyhezi.controls.v;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class TK1dGVzP extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7666r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f7667s;

    /* renamed from: t  reason: collision with root package name */
    private com.secret.prettyhezi.controls.d f7668t;

    /* renamed from: u  reason: collision with root package name */
    private v f7669u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f7670v;

    /* renamed from: w  reason: collision with root package name */
    TextWatcher f7671w = new h();

    /* loaded from: classes.dex */
    class a extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7672a;

        a(ZZcINlcxH zZcINlcxH) {
            this.f7672a = zZcINlcxH;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            this.f7672a.startActivity(new Intent(this.f7672a, TK1dGVzP.class));
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            TK1dGVzP.this.M0(T6FSl1UsM.class);
            TK1dGVzP.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class c extends g4.f {

        /* loaded from: classes.dex */
        class a extends a0.f {
            a() {
            }

            @Override // com.secret.prettyhezi.controls.a0.f
            public void b(String str, String str2) {
                TK1dGVzP.this.V0(str, str2);
            }
        }

        c() {
        }

        @Override // g4.f
        public void a(View view) {
            TK1dGVzP tK1dGVzP = TK1dGVzP.this;
            tK1dGVzP.q0(tK1dGVzP.f7668t.f8305c);
            TK1dGVzP tK1dGVzP2 = TK1dGVzP.this;
            tK1dGVzP2.q0(tK1dGVzP2.f7669u.f8469b);
            TK1dGVzP.this.A(new a());
        }
    }

    /* loaded from: classes.dex */
    class d extends g4.f {
        d() {
        }

        @Override // g4.f
        public void a(View view) {
            TK1dGVzP.this.M0(A0TdcT.class);
        }
    }

    /* loaded from: classes.dex */
    class e extends g4.f {
        e() {
        }

        @Override // g4.f
        public void a(View view) {
            TK1dGVzP.this.M0(SysychU.class);
            TK1dGVzP.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class f implements Runnable {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                TK1dGVzP.this.finish();
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TK1dGVzP tK1dGVzP = TK1dGVzP.this;
            tK1dGVzP.D(tK1dGVzP.s0(C0382R.string.SignInNotAllowed), new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f7680b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f7681c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(ZZcINlcxH zZcINlcxH, String str, String str2) {
            super(zZcINlcxH);
            this.f7680b = str;
            this.f7681c = str2;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            p pVar = (p) com.secret.prettyhezi.f.d(str, p.class);
            if (pVar.code != 200) {
                MainApplication.f6711r.A(null);
                f(pVar.err);
                return;
            }
            If7AjsI.U0();
            MainApplication.f6711r.A(pVar.data);
            g4.g.a().k(this.f7680b, this.f7681c, pVar.data.token);
            QlIdC.S0(null);
            com.secret.prettyhezi.Server.a0 r5 = MainApplication.f6711r.r();
            if (!r5.payment_password && r5.grade != 0) {
                OAnkX.S0(TK1dGVzP.this);
                return;
            }
            TK1dGVzP.this.M0(EjNkL.class);
            TK1dGVzP.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class h extends e0 {
        h() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TK1dGVzP.this.W0();
        }
    }

    public static void S0(String str) {
        ZZcINlcxH j6 = g4.i.j();
        if (j6 == null) {
            return;
        }
        j6.C(str, new String[]{j6.s0(C0382R.string.cancel), j6.s0(C0382R.string.sign_in)}, new a(j6), true);
    }

    void V0(String str, String str2) {
        String trim = this.f7668t.f8305c.getText().toString().trim();
        String trim2 = this.f7669u.f8469b.getText().toString().trim();
        I0();
        com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "auth/json", new com.secret.prettyhezi.Registration.p(trim, trim2, str, str2), false, new g(this, trim, trim2));
    }

    void W0() {
        String trim = this.f7669u.f8469b.getText().toString().trim();
        this.f7670v.setEnabled((this.f7668t.f8305c.getText().toString().trim().isEmpty() || trim.isEmpty()) ? false : true);
    }

    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7666r = C0;
        C0.setBackgroundColor(-1);
        N(this.f7666r, s0(C0382R.string.sign_in), s0(C0382R.string.sign_up), new b());
        LinearLayout e6 = e(this.f7666r);
        this.f7667s = e6;
        e6.setPadding(g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f));
        com.secret.prettyhezi.controls.d dVar = new com.secret.prettyhezi.controls.d(this, 0);
        this.f7668t = dVar;
        dVar.f8305c.setHint(s0(C0382R.string.Account));
        this.f7667s.addView(this.f7668t, new LinearLayout.LayoutParams(-1, g4.i.r(48.0f)));
        v vVar = new v(this, 0);
        this.f7669u = vVar;
        vVar.f8469b.setHint(s0(C0382R.string.Password));
        this.f7669u.setMaxLength(32);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(48.0f));
        layoutParams.topMargin = g4.i.r(30.0f);
        this.f7667s.addView(this.f7669u, layoutParams);
        TextView U = U(this.f7667s, s0(C0382R.string.sign_in), 30, 0);
        this.f7670v = U;
        U.setEnabled(false);
        this.f7670v.setOnClickListener(new c());
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = g4.i.r(30.0f);
        this.f7667s.addView(linearLayout, layoutParams2);
        TextView b6 = g4.d.b(this, 14.0f, Color.parseColor("#333333"), "留言反馈");
        b6.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        linearLayout.addView(b6, new LinearLayout.LayoutParams(-2, -2));
        b6.setOnClickListener(new d());
        linearLayout.addView(new View(this), new LinearLayout.LayoutParams(0, 10, 1.0f));
        if (com.secret.prettyhezi.Device.a.f() != null) {
            int parseColor = Color.parseColor("#333333");
            TextView b7 = g4.d.b(this, 14.0f, parseColor, s0(C0382R.string.ForgetPassword) + "?");
            b7.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
            linearLayout.addView(b7, new LinearLayout.LayoutParams(-2, -2));
            b7.setOnClickListener(new e());
        }
        this.f7668t.f8305c.addTextChangedListener(this.f7671w);
        this.f7669u.f8469b.addTextChangedListener(this.f7671w);
        String e7 = g4.g.a().e();
        if (e7 != null && !e7.isEmpty()) {
            this.f7668t.f8305c.setText(e7);
        }
        com.secret.prettyhezi.Device.a.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        if (MainApplication.f6711r.b()) {
            return;
        }
        this.f7666r.postDelayed(new f(), 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH
    public void v0() {
        l0();
    }
}
