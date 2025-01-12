package com.secret.prettyhezi.User;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.OAnkX;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Registration.r;
import com.secret.prettyhezi.Server.p;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.a0;
import com.secret.prettyhezi.controls.e0;
import com.secret.prettyhezi.controls.v;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.s;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class T6FSl1UsM extends UoWMF {
    private TextView A;
    private TextView B;
    TextView D;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7635r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f7636s;

    /* renamed from: u  reason: collision with root package name */
    private com.secret.prettyhezi.controls.d f7638u;

    /* renamed from: v  reason: collision with root package name */
    private com.secret.prettyhezi.controls.d f7639v;

    /* renamed from: w  reason: collision with root package name */
    private v f7640w;

    /* renamed from: x  reason: collision with root package name */
    LinearLayout f7641x;

    /* renamed from: y  reason: collision with root package name */
    private com.secret.prettyhezi.controls.d f7642y;

    /* renamed from: z  reason: collision with root package name */
    private com.secret.prettyhezi.controls.d f7643z;

    /* renamed from: t  reason: collision with root package name */
    private TextView f7637t = null;
    String C = null;
    TextWatcher E = new i();

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            T6FSl1UsM.this.M0(TK1dGVzP.class);
            T6FSl1UsM.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {

        /* loaded from: classes.dex */
        class a extends a0.f {

            /* renamed from: com.secret.prettyhezi.User.T6FSl1UsM$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0120a extends ZZcINlcxH.q {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ String f7647a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ String f7648b;

                C0120a(String str, String str2) {
                    this.f7647a = str;
                    this.f7648b = str2;
                }

                @Override // com.secret.prettyhezi.ZZcINlcxH.q
                public void b() {
                    T6FSl1UsM.this.e1(this.f7647a, this.f7648b);
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.controls.a0.f
            public void b(String str, String str2) {
                T6FSl1UsM t6FSl1UsM = T6FSl1UsM.this;
                t6FSl1UsM.B(t6FSl1UsM.s0(C0382R.string.sign_up_hint), new C0120a(str, str2), true);
            }
        }

        b() {
        }

        @Override // g4.f
        public void a(View view) {
            String trim = T6FSl1UsM.this.f7640w.f8469b.getText().toString().trim();
            if (trim.length() < 6 || trim.length() > 16) {
                T6FSl1UsM t6FSl1UsM = T6FSl1UsM.this;
                t6FSl1UsM.y(t6FSl1UsM.s0(C0382R.string.PasswordHint));
                T6FSl1UsM.this.f7640w.f8469b.requestFocus();
                return;
            }
            String trim2 = T6FSl1UsM.this.f7642y.f8305c.getText().toString().trim();
            if (trim2.length() > 0 && trim2.length() < 6) {
                T6FSl1UsM.this.y(com.secret.prettyhezi.c.b("RegistrationCode.Format"));
                T6FSl1UsM.this.f7642y.f8305c.requestFocus();
                return;
            }
            String trim3 = T6FSl1UsM.this.f7643z.f8305c.getText().toString().trim();
            if (trim3.length() <= 0 || trim3.length() >= 5) {
                T6FSl1UsM.this.A(new a());
                return;
            }
            T6FSl1UsM.this.y("邀请码不存在");
            T6FSl1UsM.this.f7643z.f8305c.requestFocus();
        }
    }

    /* loaded from: classes.dex */
    class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            T6FSl1UsM t6FSl1UsM = T6FSl1UsM.this;
            t6FSl1UsM.d1(t6FSl1UsM.f7636s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            T6FSl1UsM.this.Z0();
        }
    }

    /* loaded from: classes.dex */
    class e implements Runnable {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                T6FSl1UsM.this.finish();
            }
        }

        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            T6FSl1UsM t6FSl1UsM = T6FSl1UsM.this;
            t6FSl1UsM.D(t6FSl1UsM.s0(C0382R.string.SignUpNotAllowed), new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f7654a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f7655b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f7656c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String[] f7657d;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (MainApplication.f6711r.r().grade > 0) {
                    OAnkX.S0(T6FSl1UsM.this);
                    return;
                }
                T6FSl1UsM.this.M0(EjNkL.class);
                T6FSl1UsM.this.finish();
            }
        }

        f(x xVar, String str, String str2, String[] strArr) {
            this.f7654a = xVar;
            this.f7655b = str;
            this.f7656c = str2;
            this.f7657d = strArr;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            if (T6FSl1UsM.this.j(this.f7654a)) {
                Paint paint = new Paint();
                paint.setColor(Color.parseColor("#000000"));
                paint.setTextSize(48.0f);
                paint.setAntiAlias(true);
                Bitmap createBitmap = Bitmap.createBitmap(480, 400, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(-1);
                canvas.drawText(this.f7655b, 100.0f, 80.0f, paint);
                canvas.drawText(this.f7656c, 100.0f, 160.0f, paint);
                paint.setColor(Color.parseColor("#0000ff"));
                paint.setTextSize(60.0f);
                canvas.drawText("BeautyBox", 100.0f, 330.0f, paint);
                T6FSl1UsM.this.l(createBitmap, "你的照片已保存");
                T6FSl1UsM.this.B.setEnabled(false);
                T6FSl1UsM.this.f7635r.postDelayed(new a(), T6FSl1UsM.this.p0(this.f7657d) ? 1000L : 5000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f7660b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f7661c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(ZZcINlcxH zZcINlcxH, String str, String str2) {
            super(zZcINlcxH);
            this.f7660b = str;
            this.f7661c = str2;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            T6FSl1UsM t6FSl1UsM;
            com.secret.prettyhezi.controls.d dVar;
            EditText editText;
            p pVar = (p) com.secret.prettyhezi.f.d(str, p.class);
            if (pVar.code == 200) {
                If7AjsI.U0();
                MainApplication.f6711r.A(pVar.data);
                g4.g.a().k(this.f7660b, this.f7661c, pVar.data.token);
                T6FSl1UsM.this.h1(this.f7660b, this.f7661c);
                return;
            }
            MainApplication.f6711r.A(null);
            String str2 = pVar.err;
            if (str2 != null) {
                if (str2.equals("InvalidAccount.Format") || str2.equals("InvalidAccount.Used")) {
                    t6FSl1UsM = T6FSl1UsM.this;
                    dVar = t6FSl1UsM.f7638u;
                } else if (str2.equals("InvalidNickname.Format")) {
                    t6FSl1UsM = T6FSl1UsM.this;
                    dVar = t6FSl1UsM.f7639v;
                } else if (str2.equals("InvalidPassword.Format")) {
                    t6FSl1UsM = T6FSl1UsM.this;
                    editText = t6FSl1UsM.f7640w.f8469b;
                    t6FSl1UsM.Y0(editText);
                } else if (str2.equals("RegistrationCode.Format")) {
                    T6FSl1UsM t6FSl1UsM2 = T6FSl1UsM.this;
                    t6FSl1UsM2.Y0(t6FSl1UsM2.f7642y.f8305c);
                    T6FSl1UsM.this.f7642y.f8305c.setEnabled(true);
                }
                editText = dVar.f8305c;
                t6FSl1UsM.Y0(editText);
            }
            f(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f7663b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(ZZcINlcxH zZcINlcxH, String str) {
            super(zZcINlcxH);
            this.f7663b = str;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            k kVar = (k) com.secret.prettyhezi.f.d(str, k.class);
            if (kVar.code == 200 && kVar.data) {
                T6FSl1UsM.this.g1(this.f7663b);
            }
        }
    }

    /* loaded from: classes.dex */
    class i extends e0 {
        i() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            T6FSl1UsM.this.f1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class j extends com.secret.prettyhezi.Registration.k {
        public String xk;

        public j(String str) {
            super("f");
            this.xk = str;
        }
    }

    /* loaded from: classes.dex */
    static class k extends w {
        public boolean data;

        k() {
        }
    }

    public static boolean c1(String str) {
        return str != null && str.length() >= 5 && str.length() <= 7;
    }

    void Y0(EditText editText) {
        editText.setText(HttpUrl.FRAGMENT_ENCODE_SET);
        editText.requestFocus();
    }

    boolean Z0() {
        String m5 = ZZcINlcxH.m();
        if (c1(m5)) {
            i1(m5);
            return true;
        }
        return false;
    }

    s.g a1(String str, String str2) {
        return new g(this, str, str2);
    }

    void b1() {
        String h6 = g4.g.a().h("inviteCode", HttpUrl.FRAGMENT_ENCODE_SET);
        if (c1(h6)) {
            g1(h6);
            return;
        }
        this.f7638u.f8305c.requestFocus();
        if (Z0()) {
            return;
        }
        this.f7638u.postDelayed(new d(), 100L);
    }

    void d1(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        k(createBitmap);
    }

    void e1(String str, String str2) {
        String trim = this.f7638u.f8305c.getText().toString().trim();
        String trim2 = this.f7639v.f8305c.getText().toString().trim();
        String trim3 = this.f7642y.f8305c.getText().toString().trim();
        String trim4 = this.f7640w.f8469b.getText().toString().trim();
        String str3 = this.C;
        String trim5 = (str3 == null || str3.length() <= 0) ? this.f7643z.f8305c.getText().toString().trim() : this.C;
        I0();
        r rVar = new r(trim, trim4, trim2, trim3, trim5, str, str2);
        com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "auth/json", rVar, false, a1(trim, trim4));
    }

    void f1() {
        boolean z5 = (this.f7638u.f8305c.getText().toString().trim().isEmpty() || this.f7639v.f8305c.getText().toString().trim().isEmpty() || this.f7640w.f8469b.getText().toString().trim().isEmpty()) ? false : true;
        this.B.setEnabled(z5);
        this.D.setEnabled(z5);
    }

    void g1(String str) {
        this.C = str;
        this.A.setVisibility(0);
        TextView textView = this.A;
        textView.setText("邀请码：" + str);
        this.f7643z.setVisibility(8);
    }

    void h1(String str, String str2) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        TextView c6 = g4.d.c(this, 16, -16777216, str, 17);
        TextView c7 = g4.d.c(this, 16, -16777216, str2, 17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, g4.i.r(40.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, g4.i.r(40.0f));
        linearLayout.addView(c6, layoutParams);
        linearLayout.addView(c7, layoutParams2);
        TextView c8 = g4.d.c(this, 20, -16776961, "BeautyBox", 17);
        linearLayout.addView(c8, new LinearLayout.LayoutParams(-2, g4.i.r(60.0f)));
        c8.setVisibility(8);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(17);
        linearLayout2.addView(linearLayout, new LinearLayout.LayoutParams(-2, -2));
        TextView c9 = g4.d.c(this, 14, Color.parseColor("#333333"), "请注意保存好你的账号密码照片，点击确认，将会保存你的账号密码图片到相册", 17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = g4.i.r(20.0f);
        linearLayout2.addView(c9, layoutParams3);
        x xVar = new x(this);
        xVar.e(linearLayout2);
        xVar.d(new String[]{s0(C0382R.string.ok)}, new f(xVar, str, str2, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}));
        x(xVar, null, false);
    }

    void i1(String str) {
        com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "auth/json", new j(str), false, new h(this, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7635r = C0;
        C0.setBackgroundColor(-1);
        N(this.f7635r, s0(C0382R.string.sign_up), s0(C0382R.string.sign_in), new a());
        LinearLayout e6 = e(this.f7635r);
        this.f7636s = e6;
        e6.setPadding(g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f));
        this.f7636s.setBackgroundColor(-1);
        int parseColor = Color.parseColor("#f00000");
        TextView b6 = g4.d.b(this, 14.0f, parseColor, "\t\t\t\t" + s0(C0382R.string.sign_up_hint));
        this.f7637t = b6;
        b6.setLineSpacing((float) g4.i.r(4.0f), 1.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = g4.i.r(10.0f);
        this.f7636s.addView(this.f7637t, layoutParams);
        com.secret.prettyhezi.controls.d dVar = new com.secret.prettyhezi.controls.d(this, 0);
        this.f7638u = dVar;
        dVar.f8305c.setHint(s0(C0382R.string.AccountHint));
        com.secret.prettyhezi.controls.j.a(this.f7638u.f8305c, 32, 6);
        this.f7636s.addView(this.f7638u, new LinearLayout.LayoutParams(-1, g4.i.r(48.0f)));
        com.secret.prettyhezi.controls.d dVar2 = new com.secret.prettyhezi.controls.d(this, 0);
        this.f7639v = dVar2;
        dVar2.f8305c.setHint(s0(C0382R.string.NickNameHint));
        this.f7639v.setMaxLength(10);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, g4.i.r(48.0f));
        layoutParams2.topMargin = g4.i.r(10.0f);
        this.f7636s.addView(this.f7639v, layoutParams2);
        v vVar = new v(this, 0);
        this.f7640w = vVar;
        vVar.f8469b.setHint(s0(C0382R.string.PasswordHint));
        this.f7640w.setMaxLength(32);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, g4.i.r(48.0f));
        layoutParams3.topMargin = g4.i.r(10.0f);
        this.f7636s.addView(this.f7640w, layoutParams3);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f7641x = linearLayout;
        linearLayout.setOrientation(0);
        this.f7641x.setGravity(16);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = g4.i.r(10.0f);
        this.f7636s.addView(this.f7641x, layoutParams4);
        com.secret.prettyhezi.controls.d dVar3 = new com.secret.prettyhezi.controls.d(this, 0);
        this.f7642y = dVar3;
        dVar3.f8305c.setHint(s0(C0382R.string.RegistrationCode));
        com.secret.prettyhezi.controls.j.a(this.f7642y.f8305c, 8, 6);
        this.f7641x.addView(this.f7642y, new LinearLayout.LayoutParams(0, g4.i.r(48.0f), 1.0f));
        TextView b7 = g4.d.b(this, 12.0f, -65536, "* 有邀请码的用户可以免费观看部分短视频 *");
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.topMargin = g4.i.r(10.0f);
        this.f7636s.addView(b7, layoutParams5);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, g4.i.r(48.0f));
        layoutParams6.topMargin = g4.i.r(4.0f);
        this.f7636s.addView(linearLayout2, layoutParams6);
        TextView c6 = g4.d.c(this, 16, Color.parseColor("#333333"), "邀请码： ", 16);
        this.A = c6;
        c6.setBackground(g4.i.b(Color.parseColor("#f2f2f2"), 4.0f));
        this.A.setPadding(g4.i.r(12.0f), 0, 0, 0);
        this.A.setVisibility(8);
        linearLayout2.addView(this.A, new LinearLayout.LayoutParams(-1, -1));
        com.secret.prettyhezi.controls.d dVar4 = new com.secret.prettyhezi.controls.d(this, 0);
        this.f7643z = dVar4;
        dVar4.f8305c.setHint(s0(C0382R.string.InviteCode));
        com.secret.prettyhezi.controls.j.a(this.f7643z.f8305c, 7, 6);
        linearLayout2.addView(this.f7643z, new LinearLayout.LayoutParams(-1, -1));
        TextView U = U(this.f7636s, s0(C0382R.string.sign_up), 10, 0);
        this.B = U;
        U.setEnabled(false);
        this.B.setOnClickListener(new b());
        TextView U2 = U(this.f7636s, s0(C0382R.string.CaptureScreenAndSave), g4.i.r(10.0f), 0);
        this.D = U2;
        U2.setEnabled(false);
        this.D.setOnClickListener(new c());
        this.f7638u.f8305c.addTextChangedListener(this.E);
        this.f7639v.f8305c.addTextChangedListener(this.E);
        this.f7640w.f8469b.addTextChangedListener(this.E);
        b1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        if (MainApplication.f6711r.c()) {
            return;
        }
        this.f7635r.postDelayed(new e(), 200L);
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
