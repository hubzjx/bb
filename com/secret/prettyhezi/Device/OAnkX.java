package com.secret.prettyhezi.Device;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.Fc3zRvpgB;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Registration.k;
import com.secret.prettyhezi.Registration.q;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.p;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.y;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.e;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.i;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class OAnkX extends UoWMF {

    /* renamed from: y  reason: collision with root package name */
    public static boolean f6116y;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6117r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6118s;

    /* renamed from: t  reason: collision with root package name */
    TextView f6119t;

    /* renamed from: u  reason: collision with root package name */
    com.secret.prettyhezi.controls.e f6120u;

    /* renamed from: v  reason: collision with root package name */
    TextView f6121v;

    /* renamed from: w  reason: collision with root package name */
    String f6122w;

    /* renamed from: x  reason: collision with root package name */
    boolean f6123x = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6124a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f6125b;

        /* renamed from: com.secret.prettyhezi.Device.OAnkX$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0073a extends s.g {

            /* renamed from: com.secret.prettyhezi.Device.OAnkX$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0074a extends ZZcINlcxH.q {
                C0074a() {
                }

                @Override // com.secret.prettyhezi.ZZcINlcxH.q
                public void b() {
                    Class cls;
                    a aVar = a.this;
                    boolean z5 = aVar.f6125b;
                    ZZcINlcxH zZcINlcxH = aVar.f6124a;
                    if (z5) {
                        zZcINlcxH.Z();
                        OAnkX.f6116y = true;
                        zZcINlcxH = a.this.f6124a;
                        cls = EjNkL.class;
                    } else {
                        cls = WIKdIA.class;
                    }
                    zZcINlcxH.M0(cls);
                }
            }

            C0073a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                y yVar = (y) com.secret.prettyhezi.f.d(str, y.class);
                if (yVar.code != 200) {
                    f(yVar.err);
                } else if (yVar.data) {
                    a.this.f6124a.D("本设备已经绑定其他账号", new C0074a(), false);
                } else {
                    a.this.f6124a.M0(OAnkX.class);
                }
            }
        }

        a(ZZcINlcxH zZcINlcxH, boolean z5) {
            this.f6124a = zZcINlcxH;
            this.f6125b = z5;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void a() {
            if (this.f6125b) {
                this.f6124a.Z();
                this.f6124a.M0(EjNkL.class);
            }
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            if (this.f6124a.X()) {
                return;
            }
            j.r(v.f7132a + "cert/json", new k("a"), true, new C0073a(this.f6124a));
        }
    }

    /* loaded from: classes.dex */
    class b implements e.a {
        b() {
        }

        @Override // com.secret.prettyhezi.controls.e.a
        public void a(CharSequence charSequence, int i6) {
            OAnkX oAnkX = OAnkX.this;
            if (oAnkX.f6122w == null) {
                oAnkX.f6122w = oAnkX.f6120u.getText().toString();
                OAnkX.this.U0();
                return;
            }
            if (OAnkX.this.f6122w.equals(oAnkX.f6120u.getText().toString())) {
                OAnkX.this.V0();
            } else {
                OAnkX.this.W0();
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OAnkX.this.f6120u.requestFocus();
            OAnkX.this.f6120u.d();
        }
    }

    /* loaded from: classes.dex */
    class d implements SwipeBackLayout.c {
        d() {
        }

        @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.c
        public void a() {
            OAnkX.this.f6120u.c();
        }

        @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.b
        public void b() {
            OAnkX.this.f6120u.c();
        }

        @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.b
        public void c(int i6) {
        }

        @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.b
        public void d(int i6, float f6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
            alphaAnimation.setDuration(400L);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            OAnkX.this.f6120u.startAnimation(alphaAnimation);
            OAnkX.this.f6120u.d();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends s.g {
        f(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            p pVar = (p) com.secret.prettyhezi.f.d(str, p.class);
            if (pVar.code != 200) {
                f(pVar.err);
                return;
            }
            MainApplication.f6711r.A(pVar.data);
            OAnkX.this.Z();
            OAnkX.this.M0(EjNkL.class);
            EjNkL.N.f6165r.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends s.g {
        g(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            com.secret.prettyhezi.Device.a.e();
            p pVar = (p) com.secret.prettyhezi.f.d(str, p.class);
            if (pVar.code != 200) {
                f(pVar.err);
                return;
            }
            MainApplication.f6711r.A(pVar.data);
            OAnkX.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends s.g {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                OAnkX.this.Z();
                OAnkX.this.M0(EjNkL.class);
            }
        }

        h(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            p pVar = (p) com.secret.prettyhezi.f.d(str, p.class);
            if (pVar.code == 200) {
                MainApplication.f6711r.A(pVar.data);
                OAnkX.this.Z();
                OAnkX.this.M0(EjNkL.class);
                return;
            }
            String str2 = pVar.err;
            if (str2 == null || !str2.equals("DeviceIsAlready")) {
                f(pVar.err);
            } else {
                OAnkX.this.E("绑定失败", "本设备数字证书已绑定其他账号", new a(), false);
            }
        }
    }

    public static void S0(ZZcINlcxH zZcINlcxH) {
        zZcINlcxH.C("随着账号价值的提高，为了保护你的劳动成果，请为账户设置支付密码，很多功能都要用到支付密码，请慎重设置。", new String[]{"暂不设置", zZcINlcxH.s0(C0382R.string.ok)}, new a(zZcINlcxH, !(zZcINlcxH instanceof Fc3zRvpgB)), false);
    }

    void T0() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation.setDuration(400L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.f6120u.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new e());
    }

    void U0() {
        this.f6120u.setText(HttpUrl.FRAGMENT_ENCODE_SET);
        this.f6119t.setText("请再次输入支付密码");
        T0();
    }

    void V0() {
        String str;
        q qVar;
        j.e hVar;
        I0();
        if (this.f6123x) {
            str = v.f7132a + "user/edit/json?query=forget";
            qVar = new q(this.f6122w);
            hVar = new f(this);
        } else if (MainApplication.f6711r.r().bindcert) {
            v.q(this.f6122w, new g(this));
            return;
        } else {
            str = v.f7132a + "user/payment/password/json";
            qVar = new q(this.f6122w);
            hVar = new h(this);
        }
        j.r(str, qVar, true, hVar);
    }

    void W0() {
        this.f6122w = null;
        this.f6120u.setText(HttpUrl.FRAGMENT_ENCODE_SET);
        y("两次密码不一样，请重新设置");
        this.f6119t.setText("设置支付密码");
        T0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6117r = C0();
        a0 r5 = MainApplication.f6711r.r();
        a0.d dVar = r5.fp;
        if (dVar != null && dVar.created_at > 0 && dVar.verify) {
            this.f6123x = true;
        }
        M(this.f6117r, this.f6123x ? "重置支付密码" : r5.bindcert ? "修改支付密码" : "设置支付密码");
        LinearLayout e6 = e(this.f6117r);
        this.f6118s = e6;
        e6.setGravity(1);
        this.f6118s.setPadding(i.r(12.0f), 0, i.r(12.0f), i.r(20.0f));
        this.f6119t = g4.d.c(this, 14, -16777216, "设置支付密码", 17);
        this.f6118s.addView(this.f6119t, new LinearLayout.LayoutParams(-1, i.r(80.0f)));
        this.f6120u = new com.secret.prettyhezi.controls.e(this, 6);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i.r(50.0f));
        layoutParams.bottomMargin = i.r(60.0f);
        int r6 = i.r(10.0f);
        layoutParams.rightMargin = r6;
        layoutParams.leftMargin = r6;
        this.f6118s.addView(this.f6120u, layoutParams);
        this.f6120u.setOnTextFinishListener(new b());
        TextView c6 = g4.d.c(this, 12, -65536, "支付密码非常重要，请一定不要忘记\n\n在进行积分相关操作的时候都需要支付密码", 1);
        this.f6121v = c6;
        this.f6118s.addView(c6, new LinearLayout.LayoutParams(-1, -2));
        this.f6118s.postDelayed(new c(), 100L);
        R0().o(new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH
    public void v0() {
        this.f6120u.c();
        if (MainApplication.f6711r.r().bindcert) {
            finish();
            return;
        }
        Z();
        M0(EjNkL.class);
    }
}
