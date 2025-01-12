package com.secret.prettyhezi.share.digital;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Registration.k;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.y;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.f;
import g4.i;
/* loaded from: classes.dex */
public class DbfQJY extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f8932r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f8933s;

    /* loaded from: classes.dex */
    class a extends f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            DbfQJY.this.M0(P1o1yR.class);
        }
    }

    /* loaded from: classes.dex */
    class b extends f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {

            /* renamed from: com.secret.prettyhezi.share.digital.DbfQJY$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0144a extends s.g {
                C0144a(ZZcINlcxH zZcINlcxH) {
                    super(zZcINlcxH);
                }

                @Override // com.secret.prettyhezi.s.g
                public void g(String str) {
                    y yVar = (y) com.secret.prettyhezi.f.d(str, y.class);
                    if (yVar.code != 200) {
                        f(yVar.err);
                    } else if (!yVar.data) {
                        DbfQJY.this.y("开通失败，请咨询管理员");
                    } else {
                        MainApplication.f6711r.x();
                        DbfQJY.this.finish();
                        DbfQJY.this.M0(WuXLOHsS.class);
                    }
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                DbfQJY.this.I0();
                j.r(v.f7132a + "tron/json", new k("a"), true, new C0144a(DbfQJY.this));
            }
        }

        b() {
        }

        @Override // g4.f
        public void a(View view) {
            DbfQJY.this.B("已准备好使用USDT与积分互换？", new a(), true);
        }
    }

    /* loaded from: classes.dex */
    class c extends f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            DbfQJY.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f8932r = C0;
        N(C0, "USDT说明", "兑换说明", new a());
        LinearLayout e6 = e(this.f8932r);
        this.f8933s = e6;
        e6.setGravity(1);
        this.f8933s.setPadding(i.r(12.0f), i.r(20.0f), i.r(12.0f), i.r(20.0f));
        this.f8933s.addView(g4.d.b(this, 16.0f, -65536, "系统升级，兑换积分需使用USDT(TRC20-USDT)，请重新阅读兑换说明，考虑是否使用USDT兑换积分"), new LinearLayout.LayoutParams(-1, -2));
        TextView c6 = g4.d.c(this, 16, -1, "确认使用USDT兑换", 17);
        c6.setBackground(i.d(i.b(Color.parseColor("#333333"), 5.0f), i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(200.0f), i.r(38.0f));
        layoutParams.topMargin = i.r(26.0f);
        layoutParams.bottomMargin = i.r(12.0f);
        this.f8933s.addView(c6, layoutParams);
        c6.setOnClickListener(new b());
        TextView c7 = g4.d.c(this, 16, -1, "暂不使用USDT", 17);
        c7.setBackground(i.d(i.b(Color.parseColor("#333333"), 5.0f), i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i.r(200.0f), i.r(38.0f));
        layoutParams2.topMargin = i.r(26.0f);
        layoutParams2.bottomMargin = i.r(12.0f);
        this.f8933s.addView(c7, layoutParams2);
        c7.setOnClickListener(new c());
    }
}
