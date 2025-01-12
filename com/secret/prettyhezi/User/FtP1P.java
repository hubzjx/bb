package com.secret.prettyhezi.User;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.OAnkX;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Payment.QCLQRilFO;
import com.secret.prettyhezi.Server.p;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.User.Ticket.Alv5GBDA;
import com.secret.prettyhezi.Yzg4R57AT;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.e0;
import com.secret.prettyhezi.s;
import java.io.IOException;
/* loaded from: classes.dex */
public class FtP1P extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7537r;

    /* renamed from: s  reason: collision with root package name */
    RelativeLayout f7538s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f7539t;

    /* renamed from: u  reason: collision with root package name */
    EditText f7540u;

    /* renamed from: v  reason: collision with root package name */
    TextView f7541v;

    /* renamed from: w  reason: collision with root package name */
    int f7542w = g4.i.r(12.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends e0 {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String trim = FtP1P.this.f7540u.getText().toString().trim();
            FtP1P.this.f7541v.setVisibility((trim.length() <= 0 || trim.equals(MainApplication.f6711r.r().nickname)) ? 4 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* loaded from: classes.dex */
        class a extends s.g {
            a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g, com.secret.prettyhezi.j.e
            public void a(IOException iOException) {
                super.a(iOException);
                FtP1P.this.k0();
            }

            @Override // com.secret.prettyhezi.s.g, com.secret.prettyhezi.j.e
            public void b(int i6) {
                super.b(i6);
                FtP1P.this.k0();
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                p pVar = (p) com.secret.prettyhezi.f.d(str, p.class);
                if (pVar.code != 200) {
                    f(pVar.err);
                    return;
                }
                MainApplication.f6711r.A(pVar.data);
                EjNkL.N.f6165r.j();
                FtP1P ftP1P = FtP1P.this;
                ftP1P.H(ftP1P.s0(C0382R.string.SaveSuccessfully));
                FtP1P.this.f7541v.setVisibility(4);
            }
        }

        b() {
        }

        @Override // g4.f
        public void a(View view) {
            String trim = FtP1P.this.f7540u.getText().toString().trim();
            FtP1P.this.I0();
            v.A(trim, new a(FtP1P.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            FtP1P.this.N0(Yzg4R57AT.class, MainApplication.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {

        /* loaded from: classes.dex */
        class a implements a.f {
            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                FtP1P.this.M0(KUDZxA.class);
            }
        }

        d() {
        }

        @Override // g4.f
        public void a(View view) {
            com.secret.prettyhezi.Device.a.b(FtP1P.this, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {

        /* loaded from: classes.dex */
        class a implements a.f {
            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                FtP1P.this.M0(OAnkX.class);
            }
        }

        e() {
        }

        @Override // g4.f
        public void a(View view) {
            com.secret.prettyhezi.Device.a.e();
            com.secret.prettyhezi.Device.a.c(FtP1P.this, "请输入旧支付密码", new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Class f7551d;

        f(Class cls) {
            this.f7551d = cls;
        }

        @Override // g4.f
        public void a(View view) {
            Class cls = this.f7551d;
            if ((cls == QCLQRilFO.class || cls == Alv5GBDA.class) && FtP1P.this.X()) {
                return;
            }
            FtP1P.this.M0(this.f7551d);
        }
    }

    LinearLayout S0(String str) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        TextView b6 = g4.d.b(this, 14.0f, -16777216, str);
        b6.setPadding(this.f7542w, 0, 0, 0);
        linearLayout.addView(b6, new LinearLayout.LayoutParams(g4.i.r(100.0f), -2));
        return linearLayout;
    }

    TextView T0(String str, Class cls) {
        TextView b6 = g4.d.b(this, 16.0f, -16777216, str);
        b6.setPadding(this.f7542w, 0, 0, 0);
        b6.setGravity(19);
        b6.setBackgroundColor(Color.parseColor("#f0f0f0"));
        if (cls != null) {
            b6.setOnClickListener(new f(cls));
        }
        return b6;
    }

    void U0() {
        this.f7539t.removeAllViews();
        LinearLayout S0 = S0(s0(C0382R.string.Account) + ":");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(10.0f);
        layoutParams.bottomMargin = g4.i.r(20.0f);
        this.f7539t.addView(S0, layoutParams);
        S0.addView(g4.d.b(this, 14.0f, -16777216, MainApplication.f6711r.r().username), new LinearLayout.LayoutParams(-2, -2));
        LinearLayout S02 = S0(s0(C0382R.string.NickName) + "：");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.bottomMargin = g4.i.r(10.0f);
        this.f7539t.addView(S02, layoutParams2);
        EditText editText = new EditText(this);
        this.f7540u = editText;
        editText.setBackground(ZZcINlcxH.g0(-1, 2.0f, -7829368, 0.5f));
        this.f7540u.setText(MainApplication.f6711r.r().nickname);
        this.f7540u.setGravity(16);
        this.f7540u.setTextSize(14.0f);
        this.f7540u.addTextChangedListener(new a());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(100.0f), g4.i.r(30.0f));
        this.f7540u.setPadding(g4.i.r(2.0f), 0, g4.i.r(2.0f), 0);
        S02.addView(this.f7540u, layoutParams3);
        TextView b6 = g4.d.b(this, 16.0f, -1, s0(C0382R.string.Save));
        this.f7541v = b6;
        b6.setGravity(17);
        this.f7541v.setBackground(g4.i.d(g4.i.b(-65536, 2.0f), g4.i.c(Color.parseColor("#aa000000"), 2.0f, -65536, 1.0f)));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(30.0f));
        layoutParams4.rightMargin = this.f7542w;
        S02.addView(new View(this), new LinearLayout.LayoutParams(0, g4.i.r(2.0f), 1.0f));
        S02.addView(this.f7541v, layoutParams4);
        this.f7541v.setVisibility(4);
        this.f7541v.setOnClickListener(new b());
        int r5 = g4.i.r(10.0f);
        TextView T0 = T0("我的主页", null);
        this.f7539t.addView(T0, new LinearLayout.LayoutParams(-1, g4.i.r(36.0f)));
        T0.setOnClickListener(new c());
        TextView T02 = T0(s0(C0382R.string.ChangePassword), null);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, g4.i.r(36.0f));
        layoutParams5.topMargin = r5;
        this.f7539t.addView(T02, layoutParams5);
        T02.setOnClickListener(new d());
        TextView T03 = T0("修改支付密码", null);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, g4.i.r(36.0f));
        layoutParams6.topMargin = r5;
        this.f7539t.addView(T03, layoutParams6);
        T03.setOnClickListener(new e());
        TextView T04 = T0("收款方式", QCLQRilFO.class);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, g4.i.r(36.0f));
        layoutParams7.topMargin = r5;
        this.f7539t.addView(T04, layoutParams7);
        TextView T05 = T0(s0(C0382R.string.MyTickets), Alv5GBDA.class);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, g4.i.r(36.0f));
        layoutParams8.topMargin = r5;
        this.f7539t.addView(T05, layoutParams8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7537r = C0;
        C0.setBackgroundColor(-1);
        this.f7538s = M(this.f7537r, s0(C0382R.string.MyProfile));
        ScrollView scrollView = new ScrollView(this);
        this.f7537r.addView(scrollView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout linearLayout = new LinearLayout(this);
        this.f7539t = linearLayout;
        linearLayout.setOrientation(1);
        this.f7539t.setGravity(1);
        this.f7539t.setPadding(0, 0, 0, g4.i.r(12.0f));
        scrollView.addView(this.f7539t, new ViewGroup.LayoutParams(-1, -2));
        U0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        U0();
    }
}
