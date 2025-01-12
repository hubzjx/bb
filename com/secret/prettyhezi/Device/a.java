package com.secret.prettyhezi.Device;

import android.os.Environment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Fc3zRvpgB;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.y;
import com.secret.prettyhezi.User.SysychU;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.e;
import com.secret.prettyhezi.controls.w;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.i;
import java.io.File;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6141a;

    /* renamed from: b  reason: collision with root package name */
    private static String f6142b;

    /* renamed from: c  reason: collision with root package name */
    static String f6143c;

    /* renamed from: d  reason: collision with root package name */
    private static long f6144d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.secret.prettyhezi.Device.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0077a extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6145a;

        C0077a(ZZcINlcxH zZcINlcxH) {
            this.f6145a = zZcINlcxH;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            this.f6145a.M0(Fc3zRvpgB.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6146d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ w f6147e;

        b(ZZcINlcxH zZcINlcxH, w wVar) {
            this.f6146d = zZcINlcxH;
            this.f6147e = wVar;
        }

        @Override // g4.f
        protected void a(View view) {
            this.f6146d.j(this.f6147e);
            this.f6146d.M0(Ck9lZ.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.e f6148a;

        c(com.secret.prettyhezi.controls.e eVar) {
            this.f6148a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6148a.requestFocus();
            this.f6148a.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.e f6149a;

        d(com.secret.prettyhezi.controls.e eVar) {
            this.f6149a = eVar;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void a() {
            this.f6149a.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.e f6150a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6151b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ w f6152c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a0 f6153d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ f f6154e;

        /* renamed from: com.secret.prettyhezi.Device.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0078a extends s.g {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f6155b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0078a(ZZcINlcxH zZcINlcxH, String str) {
                super(zZcINlcxH);
                this.f6155b = str;
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                y yVar = (y) com.secret.prettyhezi.f.d(str, y.class);
                if (yVar.code != 200) {
                    f(yVar.err);
                } else if (!yVar.data) {
                    e.this.f6151b.y("支付密码错误");
                } else {
                    String str2 = this.f6155b;
                    a.f6143c = str2;
                    e.this.f6154e.a(str2);
                }
            }
        }

        e(com.secret.prettyhezi.controls.e eVar, ZZcINlcxH zZcINlcxH, w wVar, a0 a0Var, f fVar) {
            this.f6150a = eVar;
            this.f6151b = zZcINlcxH;
            this.f6152c = wVar;
            this.f6153d = a0Var;
            this.f6154e = fVar;
        }

        @Override // com.secret.prettyhezi.controls.e.a
        public void a(CharSequence charSequence, int i6) {
            String obj = this.f6150a.getText().toString();
            this.f6151b.j(this.f6152c);
            a0 a0Var = this.f6153d;
            if (a0Var == null || !a0Var.bindcert) {
                a.f6143c = obj;
                this.f6154e.a(obj);
                return;
            }
            j.r(v.f7132a + "user/pverify/json", new v.f(obj), true, new C0078a(this.f6151b, obj));
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(String str);
    }

    public static String a() {
        return f6143c;
    }

    public static void b(ZZcINlcxH zZcINlcxH, f fVar) {
        c(zZcINlcxH, "请输入支付密码", fVar, false);
    }

    public static void c(ZZcINlcxH zZcINlcxH, String str, f fVar, boolean z5) {
        if (System.currentTimeMillis() - f6144d < 2000) {
            return;
        }
        String str2 = f6143c;
        if (str2 != null && str2.length() == 6) {
            fVar.a(f6143c);
            return;
        }
        a0 r5 = MainApplication.f6711r.r();
        if (r5 != null) {
            if (!r5.payment_password) {
                zZcINlcxH.C("此操作需先设置支付密码", new String[]{"暂不设置", "去设置"}, new C0077a(zZcINlcxH), true);
                return;
            } else if (!z5 && !r5.bindcert) {
                zZcINlcxH.y("请在绑定的设备上进行本操作");
                return;
            }
        }
        if (r5 != null || (zZcINlcxH instanceof SysychU)) {
            w wVar = new w(zZcINlcxH);
            wVar.setOrientation(1);
            wVar.addView(g4.d.c(zZcINlcxH, 14, -16777216, str, 17), new LinearLayout.LayoutParams(-1, i.r(80.0f)));
            com.secret.prettyhezi.controls.e eVar = new com.secret.prettyhezi.controls.e(zZcINlcxH, 6);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i.r(50.0f));
            layoutParams.bottomMargin = i.r(20.0f);
            int r6 = i.r(12.0f);
            layoutParams.rightMargin = r6;
            layoutParams.leftMargin = r6;
            wVar.addView(eVar, layoutParams);
            LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
            linearLayout.setGravity(5);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, i.r(30.0f));
            layoutParams2.bottomMargin = i.r(20.0f);
            wVar.addView(linearLayout, layoutParams2);
            TextView c6 = g4.d.c(zZcINlcxH, 16, -16776961, "忘记支付密码？", 17);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams3.rightMargin = i.r(12.0f);
            linearLayout.addView(c6, layoutParams3);
            c6.setOnClickListener(new b(zZcINlcxH, wVar));
            wVar.postDelayed(new c(eVar), 200L);
            zZcINlcxH.x(wVar, new d(eVar), true);
            eVar.setOnTextFinishListener(new e(eVar, zZcINlcxH, wVar, r5, fVar));
        }
    }

    public static void d(ZZcINlcxH zZcINlcxH, f fVar) {
        c(zZcINlcxH, "请输入支付密码", fVar, true);
    }

    public static void e() {
        f6143c = null;
    }

    public static String f() {
        String str = f6142b;
        if (str == null || str.isEmpty()) {
            f6142b = j();
        }
        return f6142b;
    }

    private static String g() {
        return i.j().getFilesDir().getAbsolutePath() + File.separator + ".b2083da9e08d621f1390a73c78b2ec1b";
    }

    private static String h() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android" + File.separator + ".b2083da9e08d621f1390a73c78b2ec1b";
    }

    public static void i() {
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        f6141a = equals;
        if (equals) {
            File file = new File(Environment.getExternalStorageDirectory().toString() + "/Android");
            if (!file.exists()) {
                file.mkdir();
            }
        }
        String j6 = j();
        f6142b = j6;
        if (j6 == null) {
            String k6 = k();
            f6142b = k6;
            if (k6 != null) {
                m();
                return;
            }
            return;
        }
        String k7 = k();
        if (k7 == null || !f6142b.equals(k7)) {
            n();
        }
    }

    private static String j() {
        String h6 = g4.c.h(g());
        if (h6 == null || h6.length() <= 10) {
            return null;
        }
        return h6;
    }

    private static String k() {
        if (f6141a) {
            String h6 = g4.c.h(h());
            return (h6 == null || h6.length() <= 10) ? HttpUrl.FRAGMENT_ENCODE_SET : h6;
        }
        return null;
    }

    public static void l(String str) {
        f6142b = str;
        m();
        n();
    }

    static void m() {
        g4.c.k(g(), f6142b);
    }

    static void n() {
        if (f6141a) {
            g4.c.k(h(), f6142b);
        }
    }
}
