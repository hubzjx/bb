package com.secret.prettyhezi.User;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Registration.o;
import com.secret.prettyhezi.Server.k;
import com.secret.prettyhezi.Server.p;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.a0;
import com.secret.prettyhezi.controls.e0;
import com.secret.prettyhezi.controls.v;
import com.secret.prettyhezi.s;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class SysychU extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7614r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f7615s;

    /* renamed from: t  reason: collision with root package name */
    private com.secret.prettyhezi.controls.d f7616t;

    /* renamed from: u  reason: collision with root package name */
    private v f7617u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f7618v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f7619w;

    /* renamed from: x  reason: collision with root package name */
    String[] f7620x = null;

    /* renamed from: y  reason: collision with root package name */
    TextWatcher f7621y = new d();

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: com.secret.prettyhezi.User.SysychU$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0117a extends a0.f {

            /* renamed from: com.secret.prettyhezi.User.SysychU$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0118a extends ZZcINlcxH.q {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ String f7624a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ String f7625b;

                /* renamed from: com.secret.prettyhezi.User.SysychU$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class C0119a implements a.f {
                    C0119a() {
                    }

                    @Override // com.secret.prettyhezi.Device.a.f
                    public void a(String str) {
                        C0118a c0118a = C0118a.this;
                        SysychU.this.W0(c0118a.f7624a, c0118a.f7625b);
                    }
                }

                C0118a(String str, String str2) {
                    this.f7624a = str;
                    this.f7625b = str2;
                }

                @Override // com.secret.prettyhezi.ZZcINlcxH.q
                public void b() {
                    com.secret.prettyhezi.Device.a.e();
                    com.secret.prettyhezi.Device.a.b(SysychU.this, new C0119a());
                }
            }

            C0117a() {
            }

            @Override // com.secret.prettyhezi.controls.a0.f
            public void b(String str, String str2) {
                SysychU sysychU = SysychU.this;
                sysychU.B(sysychU.s0(C0382R.string.sign_up_hint), new C0118a(str, str2), true);
            }
        }

        a() {
        }

        @Override // g4.f
        public void a(View view) {
            String trim = SysychU.this.f7616t.f8305c.getText().toString().trim();
            boolean z5 = false;
            int i6 = 0;
            while (true) {
                String[] strArr = SysychU.this.f7620x;
                if (i6 >= strArr.length) {
                    break;
                } else if (trim.contains(strArr[i6].replace(k5.d.ANY_MARKER, HttpUrl.FRAGMENT_ENCODE_SET))) {
                    z5 = true;
                    break;
                } else {
                    i6++;
                }
            }
            SysychU sysychU = SysychU.this;
            if (z5) {
                sysychU.A(new C0117a());
            } else {
                sysychU.y("不能在此设备修改所填账号密码");
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends s.g {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                SysychU.this.v0();
            }
        }

        b(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            k kVar = (k) com.secret.prettyhezi.f.d(str, k.class);
            if (kVar.code != 200) {
                f(kVar.err);
                return;
            }
            String[] strArr = kVar.data;
            if (strArr == null || strArr.length == 0) {
                SysychU.this.D("此设备没有绑定的账户", new a(), false);
                return;
            }
            SysychU.this.f7620x = strArr;
            String str2 = "请尝试设置这些账号的密码：" + kVar.data[0];
            for (int i6 = 1; i6 < kVar.data.length; i6++) {
                str2 = str2 + "," + kVar.data[i6];
            }
            SysychU.this.f7619w.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f7630b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f7631c;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SysychU.this.isDestroyed()) {
                    return;
                }
                SysychU.this.M0(EjNkL.class);
                SysychU.this.finish();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ZZcINlcxH zZcINlcxH, String str, String str2) {
            super(zZcINlcxH);
            this.f7630b = str;
            this.f7631c = str2;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            SysychU sysychU;
            EditText editText;
            p pVar = (p) com.secret.prettyhezi.f.d(str, p.class);
            if (pVar.code == 200) {
                MainApplication.f6711r.A(pVar.data);
                g4.g.a().k(this.f7630b, this.f7631c, pVar.data.token);
                SysychU sysychU2 = SysychU.this;
                sysychU2.H(sysychU2.s0(C0382R.string.SetupSuccess));
                SysychU.this.f7614r.postDelayed(new a(), 200L);
                return;
            }
            MainApplication.f6711r.A(null);
            String str2 = pVar.err;
            if (str2 != null) {
                if (str2.equals("NotFound")) {
                    SysychU sysychU3 = SysychU.this;
                    sysychU3.V0(sysychU3.f7616t.f8305c);
                    str2 = "账号不存在";
                } else {
                    if (str2.equals("InvalidAccount.Format")) {
                        sysychU = SysychU.this;
                        editText = sysychU.f7616t.f8305c;
                    } else if (str2.equals("InvalidPassword.Format")) {
                        sysychU = SysychU.this;
                        editText = sysychU.f7617u.f8469b;
                    }
                    sysychU.V0(editText);
                }
            }
            f(str2);
        }
    }

    /* loaded from: classes.dex */
    class d extends e0 {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SysychU.this.X0();
        }
    }

    void V0(EditText editText) {
        editText.setText(HttpUrl.FRAGMENT_ENCODE_SET);
        editText.requestFocus();
    }

    void W0(String str, String str2) {
        String trim = this.f7616t.f8305c.getText().toString().trim();
        String trim2 = this.f7617u.f8469b.getText().toString().trim();
        I0();
        com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "auth/json", new o(trim, trim2, str, str2), false, new c(this, trim, trim2));
    }

    void X0() {
        this.f7618v.setEnabled((this.f7616t.f8305c.getText().toString().trim().isEmpty() || this.f7617u.f8469b.getText().toString().trim().isEmpty()) ? false : true);
    }

    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7614r = C0;
        C0.setBackgroundColor(-1);
        M(this.f7614r, s0(C0382R.string.ChangePassword));
        LinearLayout e6 = e(this.f7614r);
        this.f7615s = e6;
        e6.setPadding(g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f));
        this.f7615s.setBackgroundColor(-1);
        this.f7619w = g4.d.a(this, 14.0f, -16777216);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = g4.i.r(12.0f);
        this.f7615s.addView(this.f7619w, layoutParams);
        com.secret.prettyhezi.controls.d dVar = new com.secret.prettyhezi.controls.d(this, 0);
        this.f7616t = dVar;
        dVar.f8305c.setHint(s0(C0382R.string.Account));
        com.secret.prettyhezi.controls.j.a(this.f7616t.f8305c, 32, 6);
        this.f7615s.addView(this.f7616t, new LinearLayout.LayoutParams(-1, g4.i.r(48.0f)));
        v vVar = new v(this, 0);
        this.f7617u = vVar;
        vVar.f8469b.setHint(s0(C0382R.string.NewPassword));
        this.f7617u.setMaxLength(32);
        this.f7617u.setHidden(false);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, g4.i.r(48.0f));
        layoutParams2.topMargin = g4.i.r(10.0f);
        this.f7615s.addView(this.f7617u, layoutParams2);
        TextView U = U(this.f7615s, s0(C0382R.string.ChangePassword), 10, 0);
        this.f7618v = U;
        U.setEnabled(false);
        this.f7618v.setOnClickListener(new a());
        this.f7616t.f8305c.addTextChangedListener(this.f7621y);
        this.f7617u.f8469b.addTextChangedListener(this.f7621y);
        I0();
        com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "auth/json", new com.secret.prettyhezi.Registration.k("d"), false, new b(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onStop() {
        super.onStop();
        com.secret.prettyhezi.Device.a.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH
    public void v0() {
        if (ZZcINlcxH.f8162n.size() == 1) {
            M0(TK1dGVzP.class);
            finish();
            return;
        }
        Z();
        M0(TK1dGVzP.class);
    }
}
