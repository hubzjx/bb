package com.secret.prettyhezi;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.abc;
import com.secret.prettyhezi.Device.OAnkX;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.Payment.QCLQRilFO;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.User.If7AjsI;
import com.secret.prettyhezi.User.KUDZxA;
import com.secret.prettyhezi.User.R8yk5xS;
import com.secret.prettyhezi.User.TK1dGVzP;
import com.secret.prettyhezi.controls.z;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class Fc3zRvpgB extends UoWMF {

    /* renamed from: z  reason: collision with root package name */
    public static boolean f6210z;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6211r;

    /* renamed from: s  reason: collision with root package name */
    RelativeLayout f6212s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f6213t;

    /* renamed from: u  reason: collision with root package name */
    LinearLayout f6214u;

    /* renamed from: v  reason: collision with root package name */
    com.secret.prettyhezi.controls.m f6215v;

    /* renamed from: w  reason: collision with root package name */
    long f6216w = 0;

    /* renamed from: x  reason: collision with root package name */
    int f6217x = 0;

    /* renamed from: y  reason: collision with root package name */
    EditText f6218y;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            Fc3zRvpgB.this.X0();
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Fc3zRvpgB.this.W0();
        }
    }

    /* loaded from: classes.dex */
    class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            Fc3zRvpgB.this.M0(MKY2nH.class);
        }
    }

    /* loaded from: classes.dex */
    class d extends g4.f {
        d() {
        }

        @Override // g4.f
        public void a(View view) {
            if (com.secret.prettyhezi.Upload.y.e()) {
                Fc3zRvpgB fc3zRvpgB = Fc3zRvpgB.this;
                fc3zRvpgB.F("还有上传的视频没有结束，请等待上传结束或者取消上传", null, fc3zRvpgB.s0(C0382R.string.IKnow), null, true);
                return;
            }
            MainApplication.f6711r.A(null);
            EjNkL.N.f6165r.j();
            EjNkL.N.f1(100, 0, false);
            g4.g.a().k(HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, null);
            com.secret.prettyhezi.Upload.y.t();
            MainApplication.f6711r.m().l();
            com.secret.prettyhezi.Game.i.f6608a = null;
            Fc3zRvpgB.this.Z();
            Fc3zRvpgB.this.M0(TK1dGVzP.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TextView f6223d;

        e(TextView textView) {
            this.f6223d = textView;
        }

        @Override // g4.f
        public void a(View view) {
            EditText editText;
            StringBuilder sb;
            if (!Fc3zRvpgB.this.f6218y.isEnabled()) {
                Fc3zRvpgB.this.f6218y.setEnabled(true);
                Fc3zRvpgB.this.f6218y.setText("G");
                Fc3zRvpgB.this.f6218y.requestFocus();
                this.f6223d.setText(Fc3zRvpgB.this.s0(C0382R.string.Save));
                ((InputMethodManager) Fc3zRvpgB.this.getSystemService("input_method")).showSoftInput(Fc3zRvpgB.this.f6218y, 2);
                return;
            }
            String trim = Fc3zRvpgB.this.f6218y.getText().toString().trim();
            if (trim.length() < 2) {
                editText = Fc3zRvpgB.this.f6218y;
                sb = new StringBuilder();
            } else {
                if (trim.endsWith("G")) {
                    trim = trim.substring(0, trim.length() - 1);
                }
                int parseInt = Integer.parseInt(trim);
                if (parseInt > 0 && parseInt <= 20) {
                    EditText editText2 = Fc3zRvpgB.this.f6218y;
                    editText2.setText(parseInt + "G");
                    Fc3zRvpgB.this.z("修改成功，下次启动后生效");
                    g4.g.a().n("keyCurrentVideoCache", parseInt);
                    Fc3zRvpgB.this.f6218y.setEnabled(false);
                    this.f6223d.setText(Fc3zRvpgB.this.s0(C0382R.string.edit));
                    ((InputMethodManager) Fc3zRvpgB.this.getSystemService("input_method")).hideSoftInputFromWindow(Fc3zRvpgB.this.f6218y.getWindowToken(), 0);
                }
                Fc3zRvpgB.this.y("请输入1到20的整数");
                editText = Fc3zRvpgB.this.f6218y;
                sb = new StringBuilder();
            }
            sb.append(Fc3zRvpgB.S0());
            sb.append("G");
            editText.setText(sb.toString());
            Fc3zRvpgB.this.f6218y.setEnabled(false);
            this.f6223d.setText(Fc3zRvpgB.this.s0(C0382R.string.edit));
            ((InputMethodManager) Fc3zRvpgB.this.getSystemService("input_method")).hideSoftInputFromWindow(Fc3zRvpgB.this.f6218y.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LinearLayout f6225d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String[] f6226e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f6227f;

        f(LinearLayout linearLayout, String[] strArr, int i6) {
            this.f6225d = linearLayout;
            this.f6226e = strArr;
            this.f6227f = i6;
        }

        @Override // g4.f
        public void a(View view) {
            Fc3zRvpgB.this.j(this.f6225d);
            Fc3zRvpgB.this.u(this.f6226e[this.f6227f]);
            Intent intent = new Intent(Fc3zRvpgB.this, EjNkL.class);
            intent.setFlags(268468224);
            Fc3zRvpgB.this.startActivity(intent);
        }
    }

    /* loaded from: classes.dex */
    class g extends g4.f {
        g() {
        }

        @Override // g4.f
        public void a(View view) {
            Fc3zRvpgB.this.M0(If7AjsI.class);
        }
    }

    /* loaded from: classes.dex */
    class h extends g4.f {

        /* loaded from: classes.dex */
        class a implements a.f {
            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                Fc3zRvpgB.this.M0(KUDZxA.class);
            }
        }

        h() {
        }

        @Override // g4.f
        public void a(View view) {
            com.secret.prettyhezi.Device.a.b(Fc3zRvpgB.this, new a());
        }
    }

    /* loaded from: classes.dex */
    class i extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a0 f6232d;

        /* loaded from: classes.dex */
        class a implements a.f {
            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                Fc3zRvpgB.this.M0(OAnkX.class);
            }
        }

        i(a0 a0Var) {
            this.f6232d = a0Var;
        }

        @Override // g4.f
        public void a(View view) {
            if (!this.f6232d.payment_password) {
                OAnkX.S0(Fc3zRvpgB.this);
                return;
            }
            com.secret.prettyhezi.Device.a.e();
            com.secret.prettyhezi.Device.a.c(Fc3zRvpgB.this, "请输入旧支付密码", new a(), false);
        }
    }

    /* loaded from: classes.dex */
    class j extends g4.f {
        j() {
        }

        @Override // g4.f
        public void a(View view) {
            if (Fc3zRvpgB.this.X()) {
                return;
            }
            Fc3zRvpgB.this.M0(R8yk5xS.class);
        }
    }

    /* loaded from: classes.dex */
    class k extends g4.f {
        k() {
        }

        @Override // g4.f
        public void a(View view) {
            if (Fc3zRvpgB.this.X()) {
                return;
            }
            Fc3zRvpgB.this.M0(QCLQRilFO.class);
        }
    }

    /* loaded from: classes.dex */
    class l implements CompoundButton.OnCheckedChangeListener {
        l() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
            g4.g.a().l("keyVideoAutoLandscape", z5);
        }
    }

    /* loaded from: classes.dex */
    class m extends g4.f {
        m() {
        }

        @Override // g4.f
        public void a(View view) {
            NbWDzx1XT.R0(Fc3zRvpgB.this, true);
        }
    }

    /* loaded from: classes.dex */
    class n extends g4.f {
        n() {
        }

        @Override // g4.f
        public void a(View view) {
            Fc3zRvpgB.this.I0();
            new p(Fc3zRvpgB.this, null).execute(new Void[0]);
        }
    }

    /* loaded from: classes.dex */
    class o extends g4.f {
        o() {
        }

        @Override // g4.f
        public void a(View view) {
            com.secret.prettyhezi.d.clearAll();
            Fc3zRvpgB.this.H("Done");
        }
    }

    /* loaded from: classes.dex */
    private class p extends AsyncTask {
        private p() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            g4.c.a(g4.b.g().h(), false);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r12) {
            Fc3zRvpgB.this.j0();
        }

        /* synthetic */ p(Fc3zRvpgB fc3zRvpgB, g gVar) {
            this();
        }
    }

    public static int S0() {
        return g4.g.a().d("keyCurrentVideoCache", 5);
    }

    View T0(LinearLayout linearLayout, String str) {
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setGravity(16);
        linearLayout2.setBackground(g4.i.f(-1, Color.parseColor("#f0f0f0")));
        linearLayout2.setPadding(g4.i.r(16.0f), 0, g4.i.r(8.0f), 0);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        TextView b6 = g4.d.b(this, 16.0f, -16777216, str);
        b6.setGravity(16);
        linearLayout2.addView(b6, new LinearLayout.LayoutParams(0, g4.i.r(48.0f), 1.0f));
        linearLayout2.addView(new z(this, C0382R.drawable.icn_right), new LinearLayout.LayoutParams(g4.i.r(20.0f), g4.i.r(18.0f)));
        return linearLayout2;
    }

    LinearLayout U0(LinearLayout linearLayout, String str, String str2) {
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(g4.i.r(16.0f), 0, g4.i.r(12.0f), 0);
        linearLayout2.addView(g4.d.b(this, 16.0f, -16777216, str), new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout2.addView(g4.d.b(this, 16.0f, -16777216, str2), new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, g4.i.r(48.0f)));
        return linearLayout2;
    }

    void V0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setPadding(g4.i.r(16.0f), 0, g4.i.r(12.0f), 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.addView(g4.d.b(this, 16.0f, -16777216, "视频缓存大小:"), new LinearLayout.LayoutParams(-2, -2));
        EditText editText = new EditText(this);
        this.f6218y = editText;
        com.secret.prettyhezi.controls.j.b(editText, 3);
        this.f6218y.setTextColor(-16777216);
        this.f6218y.setTextSize(16.0f);
        EditText editText2 = this.f6218y;
        editText2.setText(S0() + "G");
        this.f6218y.setGravity(17);
        this.f6218y.setBackground(g4.i.c(0, 2.0f, Color.parseColor("#f0f0f0"), 1.0f));
        this.f6218y.setEnabled(false);
        this.f6218y.setPadding(0, 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(52.0f), g4.i.r(32.0f));
        layoutParams.leftMargin = g4.i.r(6.0f);
        layoutParams.rightMargin = g4.i.r(10.0f);
        linearLayout.addView(this.f6218y, layoutParams);
        TextView c6 = g4.d.c(this, 16, -16777216, s0(C0382R.string.edit), 17);
        c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#cccccc"), 5.0f), g4.i.b(Color.parseColor("#888888"), 5.0f)));
        c6.setOnClickListener(new e(c6));
        linearLayout.addView(c6, new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(32.0f)));
        this.f6213t.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(48.0f)));
        V(this.f6213t, Color.parseColor("#cccccc"), 0.5f, 12, 0);
    }

    void W0() {
        long currentTimeMillis = System.currentTimeMillis();
        int i6 = this.f6217x;
        if (i6 <= 0 || currentTimeMillis - this.f6216w >= 500) {
            this.f6217x = 1;
            this.f6216w = currentTimeMillis;
            return;
        }
        int i7 = i6 + 1;
        this.f6217x = i7;
        this.f6216w = currentTimeMillis;
        if (i7 >= 3) {
            f6210z = true;
            EjNkL.N.f6165r.j();
            H(abc.ams("s4"));
        }
    }

    void X0() {
        TextView textView;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackground(ZZcINlcxH.f0(Color.parseColor("#cc000000"), 5.0f));
        linearLayout.setGravity(16);
        String i6 = i();
        int[] iArr = {C0382R.string.English, C0382R.string.traditional_chinese, C0382R.string.simplified_chinese};
        String[] strArr = {"en", "zh-rTW", "zh"};
        int i7 = 0;
        for (int i8 = 3; i7 < i8; i8 = 3) {
            TextView b6 = g4.d.b(this, 16.0f, -16777216, s0(iArr[i7]));
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(48.0f));
            b6.setGravity(17);
            linearLayout.addView(b6, layoutParams);
            linearLayout.setBackgroundColor(-1);
            if (i7 != 2) {
                textView = b6;
                W(linearLayout, Color.parseColor("#cccccc"), 0.5f, 12, 0, 12);
            } else {
                textView = b6;
            }
            textView.setBackground(g4.i.i(0, Color.parseColor("#999999"), Color.parseColor("#aaaaaa")));
            textView.setSelected(strArr[i7].equals(i6));
            textView.setOnClickListener(new f(linearLayout, strArr, i7));
            i7++;
        }
        x(linearLayout, null, true);
    }

    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6211r = C0;
        this.f6212s = M(C0, s0(C0382R.string.Settings));
        LinearLayout e6 = e(this.f6211r);
        this.f6214u = e6;
        e6.setPadding(0, 0, 0, g4.i.r(40.0f));
        if (MainApplication.f6711r.r() != null) {
            S(this.f6214u, s0(C0382R.string.UserSettings));
            T0(this.f6214u, s0(C0382R.string.AccountAndPassword)).setOnClickListener(new g());
            V(this.f6214u, Color.parseColor("#cccccc"), 0.5f, 12, 0);
            T0(this.f6214u, s0(C0382R.string.ChangePassword)).setOnClickListener(new h());
            V(this.f6214u, Color.parseColor("#cccccc"), 0.5f, 12, 0);
            a0 r5 = MainApplication.f6711r.r();
            T0(this.f6214u, r5.payment_password ? "修改支付密码" : "设置支付密码").setOnClickListener(new i(r5));
            V(this.f6214u, Color.parseColor("#cccccc"), 0.5f, 12, 0);
            T0(this.f6214u, "设备管理").setOnClickListener(new j());
            V(this.f6214u, Color.parseColor("#cccccc"), 0.5f, 12, 0);
            T0(this.f6214u, "收款方式").setOnClickListener(new k());
        }
        S(this.f6214u, s0(C0382R.string.VideoFilmPlay));
        com.secret.prettyhezi.controls.m mVar = new com.secret.prettyhezi.controls.m(this, s0(C0382R.string.AutoLandscape), 16, 12);
        this.f6215v = mVar;
        mVar.setBackgroundColor(-1);
        this.f6215v.f8407b.setChecked(g4.g.a().b("keyVideoAutoLandscape"));
        this.f6214u.addView(this.f6215v, new RelativeLayout.LayoutParams(-1, g4.i.r(48.0f)));
        this.f6215v.f8407b.setOnCheckedChangeListener(new l());
        LinearLayout T = T(this.f6214u, s0(C0382R.string.SystemSettings));
        this.f6213t = T;
        T0(T, s0(C0382R.string.ScreenLockSetup)).setOnClickListener(new m());
        V(this.f6213t, Color.parseColor("#cccccc"), 0.5f, 12, 0);
        V0();
        View T0 = T0(this.f6213t, s0(C0382R.string.ClearCache));
        V(this.f6213t, Color.parseColor("#cccccc"), 0.5f, 12, 0);
        View T02 = T0(this.f6213t, s0(C0382R.string.ClearHistory));
        T0.setOnClickListener(new n());
        T02.setOnClickListener(new o());
        V(this.f6213t, Color.parseColor("#cccccc"), 0.5f, 12, 0);
        T0(this.f6213t, s0(C0382R.string.Language)).setOnClickListener(new a());
        LinearLayout T2 = T(this.f6214u, s0(C0382R.string.SystemInfo));
        LinearLayout U0 = U0(T2, s0(C0382R.string.Version), g4.a.c());
        if (!f6210z && MainApplication.f6711r.r() != null) {
            a0 r6 = MainApplication.f6711r.r();
            if (r6.auditor || r6.mas || r6.rer || r6.isb) {
                U0.setOnClickListener(new b());
            }
        }
        V(T2, Color.parseColor("#cccccc"), 0.5f, 12, 0);
        T0(T2, s0(C0382R.string.About)).setOnClickListener(new c());
        V(this.f6214u, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        if (MainApplication.f6711r.r() != null) {
            U(this.f6214u, s0(C0382R.string.SignOut), 20, 12).setOnClickListener(new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f6218y.isEnabled()) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f6218y.getWindowToken(), 0);
        }
    }
}
