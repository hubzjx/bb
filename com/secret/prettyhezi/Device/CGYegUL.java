package com.secret.prettyhezi.Device;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Registration.k;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.y;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.f;
import g4.i;
/* loaded from: classes.dex */
public class CGYegUL extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6090r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6091s;

    /* loaded from: classes.dex */
    class a extends f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a0 f6092d;

        /* renamed from: com.secret.prettyhezi.Device.CGYegUL$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0068a implements s.f {

            /* renamed from: com.secret.prettyhezi.Device.CGYegUL$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0069a extends ZZcINlcxH.q {
                C0069a() {
                }

                @Override // com.secret.prettyhezi.ZZcINlcxH.q
                public void b() {
                    a.this.f6092d.fc = new a0.c();
                    a.this.f6092d.fc.created_at = System.currentTimeMillis() / 1000;
                    MainApplication.f6711r.x();
                    CGYegUL.this.finish();
                    EjNkL.N.f6165r.d();
                }
            }

            C0068a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                CGYegUL.this.D("挂失成功，请每日留意系统消息", new C0069a(), false);
            }
        }

        a(a0 a0Var) {
            this.f6092d = a0Var;
        }

        @Override // g4.f
        protected void a(View view) {
            CGYegUL.this.I0();
            j.o(v.f7132a + "user/forget/cert/add/json", true, new s.e(CGYegUL.this, new C0068a()));
        }
    }

    /* loaded from: classes.dex */
    class b extends f {

        /* loaded from: classes.dex */
        class a implements a.f {
            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                CGYegUL.this.T0(1);
            }
        }

        b() {
        }

        @Override // g4.f
        protected void a(View view) {
            if (MainApplication.f6711r.r().bindcert) {
                CGYegUL.this.T0(0);
            } else {
                com.secret.prettyhezi.Device.a.d(CGYegUL.this, new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements s.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                MainApplication.f6711r.r().fc = null;
                MainApplication.f6711r.x();
                CGYegUL.this.finish();
                EjNkL.N.f6165r.d();
            }
        }

        c() {
        }

        @Override // com.secret.prettyhezi.s.f
        public void a(String str) {
            CGYegUL.this.D("取消成功", new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6100b;

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                CGYegUL.this.finish();
                d.this.f6100b.M0(WIKdIA.class);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ZZcINlcxH zZcINlcxH, ZZcINlcxH zZcINlcxH2) {
            super(zZcINlcxH);
            this.f6100b = zZcINlcxH2;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            y yVar = (y) com.secret.prettyhezi.f.d(str, y.class);
            if (yVar.code == 200 && yVar.data) {
                this.f6100b.D("本设备已经绑定其他账号", new a(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e extends v.f {

        /* renamed from: t  reason: collision with root package name */
        public int f6103t;

        public e(int i6) {
            this.f6103t = i6;
        }
    }

    void S0() {
        j.r(v.f7132a + "cert/json", new k("a"), true, new d(this, this));
    }

    void T0(int i6) {
        I0();
        j.r(v.f7132a + "user/forget/cert/del/json", new e(i6), true, new s.e(this, new c()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6090r = C0;
        M(C0, "挂失已绑定设备");
        LinearLayout e6 = e(this.f6090r);
        this.f6091s = e6;
        e6.setGravity(1);
        this.f6091s.setPadding(i.r(12.0f), i.r(20.0f), i.r(12.0f), i.r(20.0f));
        this.f6091s.addView(g4.d.c(this, 14, -16777216, "如果你已绑定的设备丢失并且已经忘记支付密码，可以尝试挂失绑定设备取消本账号跟丢失设备的绑定关系，系统经过一段时间分析，如果认为已绑定设备确实已丢失，会解除绑定关系，你就可以重新设置支付密码", 3), new LinearLayout.LayoutParams(-1, i.r(80.0f)));
        a0 r5 = MainApplication.f6711r.r();
        if (!r5.HasForgetBindDevice()) {
            S0();
            U(this.f6091s, "挂失已绑定设备", 20, 40).setOnClickListener(new a(r5));
            return;
        }
        TextView c6 = g4.d.c(this, 12, -65536, "你已挂失绑定设备\n若非本人操作，请在绑定设备取消或者输入支付密码取消\n\n*如果你的账号被未知设备挂失，请及时修改登录密码*", 17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = i.r(20.0f);
        this.f6091s.addView(c6, layoutParams);
        U(this.f6091s, "取消挂失已绑定设备", 20, 40).setOnClickListener(new b());
    }
}
