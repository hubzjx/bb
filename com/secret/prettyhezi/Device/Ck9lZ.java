package com.secret.prettyhezi.Device;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.User.R8yk5xS;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.f;
import g4.i;
import java.util.Date;
/* loaded from: classes.dex */
public class Ck9lZ extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6104r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6105s;

    /* loaded from: classes.dex */
    class a extends f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a0 f6106d;

        /* renamed from: com.secret.prettyhezi.Device.Ck9lZ$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0070a implements s.f {

            /* renamed from: com.secret.prettyhezi.Device.Ck9lZ$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0071a extends ZZcINlcxH.q {
                C0071a() {
                }

                @Override // com.secret.prettyhezi.ZZcINlcxH.q
                public void b() {
                    a.this.f6106d.fp = new a0.d();
                    a.this.f6106d.fp.created_at = (System.currentTimeMillis() / 1000) + 259200;
                    a.this.f6106d.fp.verify = false;
                    MainApplication.f6711r.x();
                    Ck9lZ.this.finish();
                    EjNkL.N.f6165r.e();
                }
            }

            C0070a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                Ck9lZ.this.D("挂失成功，3日后可以重置支付密码", new C0071a(), false);
            }
        }

        a(a0 a0Var) {
            this.f6106d = a0Var;
        }

        @Override // g4.f
        protected void a(View view) {
            Ck9lZ.this.I0();
            j.o(v.f7132a + "user/forget/payment/add/json", true, new s.e(Ck9lZ.this, new C0070a()));
        }
    }

    /* loaded from: classes.dex */
    class b extends f {
        b() {
        }

        @Override // g4.f
        protected void a(View view) {
            Ck9lZ.this.finish();
            Ck9lZ.this.M0(OAnkX.class);
        }
    }

    /* loaded from: classes.dex */
    class c extends f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a0 f6111d;

        /* loaded from: classes.dex */
        class a implements s.f {

            /* renamed from: com.secret.prettyhezi.Device.Ck9lZ$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0072a extends ZZcINlcxH.q {
                C0072a() {
                }

                @Override // com.secret.prettyhezi.ZZcINlcxH.q
                public void b() {
                    c.this.f6111d.fp = null;
                    MainApplication.f6711r.x();
                    Ck9lZ.this.finish();
                    EjNkL.N.f6165r.e();
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                Ck9lZ.this.D("取消成功", new C0072a(), false);
            }
        }

        c(a0 a0Var) {
            this.f6111d = a0Var;
        }

        @Override // g4.f
        protected void a(View view) {
            Ck9lZ.this.I0();
            j.o(v.f7132a + "user/forget/payment/del/json", true, new s.e(Ck9lZ.this, new a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends f {
        d() {
        }

        @Override // g4.f
        protected void a(View view) {
            Ck9lZ.this.finish();
            Ck9lZ.this.M0(CGYegUL.class);
        }
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(5);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i.r(30.0f));
        layoutParams.topMargin = i.r(30.0f);
        this.f6105s.addView(linearLayout, layoutParams);
        TextView c6 = g4.d.c(this, 16, -16776961, "找不到已绑定的设备？", 17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.rightMargin = i.r(40.0f);
        linearLayout.addView(c6, layoutParams2);
        c6.setOnClickListener(new d());
    }

    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6104r = C0;
        M(C0, "挂失支付密码");
        LinearLayout e6 = e(this.f6104r);
        this.f6105s = e6;
        e6.setGravity(1);
        this.f6105s.setPadding(i.r(12.0f), i.r(20.0f), i.r(12.0f), i.r(20.0f));
        this.f6105s.addView(g4.d.c(this, 14, -16777216, "忘记支付密码只能在已绑定设备上挂失，三日后可在已绑定设备上重置。", 17), new LinearLayout.LayoutParams(-1, i.r(80.0f)));
        a0 r5 = MainApplication.f6711r.r();
        if (!r5.HasForgetExchangePassword()) {
            U(this.f6105s, "挂失支付密码", 20, 40).setOnClickListener(new a(r5));
            if (!(x0() instanceof R8yk5xS) || r5.bindcert) {
                return;
            }
            S0();
            return;
        }
        if (r5.IsTimeToResetExchangePassword()) {
            U(this.f6105s, "重置支付密码", 20, 40).setOnClickListener(new b());
        } else {
            Date date = new Date(r5.fp.created_at * 1000);
            String format = String.format("%d年%02d月%02d日%02d时%02d分", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()));
            TextView c6 = g4.d.c(this, 16, -65536, format + "之后可以重置支付密码，若你已经记得支付密码或者不需要重置，可以点击取消挂失支付密码", 17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = i.r(20.0f);
            this.f6105s.addView(c6, layoutParams);
        }
        U(this.f6105s, "取消挂失支付密码", 20, 40).setOnClickListener(new c(r5));
    }
}
