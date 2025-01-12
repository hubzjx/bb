package com.secret.prettyhezi.share;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Server.n;
import com.secret.prettyhezi.Server.o;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class YadO5U extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f8925r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f8926s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f8927t;

    /* renamed from: u  reason: collision with root package name */
    LinearLayout f8928u;

    /* renamed from: v  reason: collision with root package name */
    int f8929v = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8930b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            this.f8930b = i6;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            o c6 = com.secret.prettyhezi.f.c(str, k.class);
            if (c6.code != 200) {
                f(c6.err);
                return;
            }
            n[] nVarArr = c6.data.items;
            if (nVarArr != null && nVarArr.length > 0) {
                for (n nVar : nVarArr) {
                    k kVar = (k) nVar;
                    kVar.type = this.f8930b;
                    kVar.value = Math.abs(kVar.value);
                    kVar.contribution = Math.abs(kVar.contribution);
                }
            }
            YadO5U yadO5U = YadO5U.this;
            int i6 = this.f8930b;
            yadO5U.T0(i6, i6 == 1 ? yadO5U.f8927t : yadO5U.f8928u, c6.data.items);
        }
    }

    void S0(int i6) {
        com.secret.prettyhezi.j.o(v.f7132a + "user/order/json?id=" + i6, true, new a(this, i6));
    }

    void T0(int i6, LinearLayout linearLayout, n[] nVarArr) {
        linearLayout.removeAllViews();
        linearLayout.setVisibility(0);
        if (this.f8929v == 0) {
            TextView c6 = g4.d.c(this, 16, -16777216, i6 == 1 ? "热门内容权限兑换" : "精华上传内容权限兑换", 17);
            c6.setPadding(0, g4.i.r(5.0f), 0, g4.i.r(5.0f));
            linearLayout.addView(c6, new LinearLayout.LayoutParams(-1, -2));
        }
        TextView c7 = g4.d.c(this, 16, -16777216, i6 == 1 ? "查看采集量达到999的图片+短视频+影视+小说" : "免解锁观看解锁量达到999的上传内容", 17);
        c7.setPadding(0, g4.i.r(5.0f), 0, g4.i.r(10.0f));
        linearLayout.addView(c7, new LinearLayout.LayoutParams(-1, -2));
        TextView c8 = g4.d.c(this, 16, -65536, i6 == 1 ? "注：此权限不包含上传区内容" : "注：此权限不包含采集量达到999的图片，短视频，影视，小说等非上传区内容。", 17);
        c8.setPadding(0, g4.i.r(5.0f), 0, g4.i.r(10.0f));
        linearLayout.addView(c8, new LinearLayout.LayoutParams(-1, -2));
        if (nVarArr == null || nVarArr.length <= 0) {
            return;
        }
        for (n nVar : nVarArr) {
            l lVar = new l(this);
            lVar.b(nVar);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = g4.i.r(6.0f);
            linearLayout.addView(lVar, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f8929v = extras.getInt("id");
        }
        int i6 = this.f8929v;
        if (i6 == 1) {
            S0(1);
            str = "热门内容权限兑换";
        } else if (i6 == 2) {
            S0(2);
            str = "精华上传内容权限兑换";
        } else {
            this.f8929v = 0;
            S0(1);
            S0(2);
            str = "权限兑换";
        }
        LinearLayout C0 = C0();
        this.f8925r = C0;
        C0.setGravity(1);
        M(this.f8925r, str);
        LinearLayout e6 = e(this.f8925r);
        this.f8926s = e6;
        e6.setPadding(g4.i.r(6.0f), g4.i.r(10.0f), g4.i.r(6.0f), g4.i.r(10.0f));
        this.f8926s.setGravity(1);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f8927t = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = g4.i.r(10.0f);
        this.f8926s.addView(this.f8927t, layoutParams);
        this.f8927t.setVisibility(8);
        LinearLayout linearLayout2 = new LinearLayout(this);
        this.f8928u = linearLayout2;
        linearLayout2.setOrientation(1);
        this.f8926s.addView(this.f8928u, new LinearLayout.LayoutParams(-1, -2));
        this.f8928u.setVisibility(8);
    }
}
