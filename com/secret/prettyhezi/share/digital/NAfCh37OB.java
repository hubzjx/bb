package com.secret.prettyhezi.share.digital;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Registration.l;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.f;
import g4.i;
/* loaded from: classes.dex */
public class NAfCh37OB extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f8960r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f8961s;

    /* renamed from: t  reason: collision with root package name */
    TextView f8962t;

    /* loaded from: classes.dex */
    class a extends f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            NAfCh37OB.this.S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f8964a;

        /* loaded from: classes.dex */
        class a implements a.f {

            /* renamed from: com.secret.prettyhezi.share.digital.NAfCh37OB$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0148a implements s.f {

                /* renamed from: com.secret.prettyhezi.share.digital.NAfCh37OB$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class C0149a extends ZZcINlcxH.q {
                    C0149a() {
                    }

                    @Override // com.secret.prettyhezi.ZZcINlcxH.q
                    public void b() {
                        NAfCh37OB.this.finish();
                    }
                }

                C0148a() {
                }

                @Override // com.secret.prettyhezi.s.f
                public void a(String str) {
                    a0 r5 = MainApplication.f6711r.r();
                    r5.digital = true;
                    r5.is_digital = false;
                    MainApplication.f6711r.A(r5);
                    NAfCh37OB.this.D("申请已提交，请留意系统消息查询审核结果", new C0149a(), false);
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                j.r(v.f7132a + "tron/json", new l("a"), true, new s.e(NAfCh37OB.this, new C0148a()));
            }
        }

        b(x xVar) {
            this.f8964a = xVar;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            NAfCh37OB.this.j(this.f8964a);
            if (i6 == 1) {
                com.secret.prettyhezi.Device.a.e();
                com.secret.prettyhezi.Device.a.b(NAfCh37OB.this, new a());
            }
        }
    }

    void S0() {
        x xVar = new x(this);
        com.secret.prettyhezi.controls.f fVar = new com.secret.prettyhezi.controls.f(this);
        float f6 = 14;
        fVar.a("开通TRC20-USDT与积分互换权限需要", -16777216, f6);
        fVar.a("500积分", -65536, f6);
        fVar.a("，不管是否参与交易都不退还", -16777216, f6);
        fVar.b();
        xVar.h("确认开通TRC20-USDT与积分互换权限", fVar.f8319b, 6);
        xVar.d(new String[]{s0(C0382R.string.cancel), "500积分开通"}, new b(xVar));
        x(xVar, null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f8960r = C0;
        M(C0, "开通TRC20-USDT与积分互换");
        LinearLayout e6 = e(this.f8960r);
        this.f8961s = e6;
        e6.setGravity(1);
        this.f8961s.setPadding(i.r(12.0f), i.r(10.0f), i.r(12.0f), i.r(20.0f));
        this.f8961s.addView(P1o1yR.S0(this), new LinearLayout.LayoutParams(-1, -2));
        TextView c6 = g4.d.c(this, 16, -1, "立即申请", 17);
        this.f8962t = c6;
        c6.setBackground(i.d(i.b(Color.parseColor("#333333"), 5.0f), i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(200.0f), i.r(38.0f));
        layoutParams.topMargin = i.r(30.0f);
        this.f8961s.addView(this.f8962t, layoutParams);
        this.f8962t.setOnClickListener(new a());
    }
}
