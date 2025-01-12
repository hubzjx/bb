package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.util.Date;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class VhXQU extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    int f6540r;

    /* renamed from: s  reason: collision with root package name */
    long f6541s;

    /* renamed from: t  reason: collision with root package name */
    public LinearLayout f6542t;

    /* renamed from: u  reason: collision with root package name */
    public LinearLayout f6543u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            t[] tVarArr;
            j jVar = (j) com.secret.prettyhezi.f.d(str, j.class);
            if (jVar.code != 200) {
                VhXQU.this.w0(jVar);
                return;
            }
            t[] tVarArr2 = jVar.data;
            if (tVarArr2 == null || tVarArr2.length <= 0) {
                VhXQU.this.H("无人下注，采用游戏截止时间");
                return;
            }
            long j6 = 0;
            int i6 = 0;
            while (true) {
                tVarArr = jVar.data;
                if (i6 >= tVarArr.length) {
                    break;
                }
                VhXQU.this.T0(tVarArr[i6]);
                j6 += (new Date(jVar.data[i6].order_time).getSeconds() * 1000) + (jVar.data[i6].order_time % 1000);
                i6++;
            }
            VhXQU vhXQU = VhXQU.this;
            if (tVarArr.length < 4) {
                long j7 = vhXQU.f6541s - j6;
                LinearLayout linearLayout = new LinearLayout(vhXQU);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(16);
                VhXQU.this.f6543u.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(40.0f)));
                TextView c6 = g4.d.c(vhXQU, 12, Color.parseColor("#333333"), "订单数少于4，添加系统随机数:", 5);
                c6.setPadding(0, 0, g4.i.r(4.0f), 0);
                linearLayout.addView(c6, new LinearLayout.LayoutParams(0, -2, 3.8f));
                linearLayout.addView(g4.d.b(vhXQU, 12.0f, -16777216, HttpUrl.FRAGMENT_ENCODE_SET + j7), new LinearLayout.LayoutParams(0, -2, 1.0f));
                VhXQU vhXQU2 = VhXQU.this;
                vhXQU2.Q(vhXQU2.f6543u, Color.parseColor("#cccccc"), 0.5f, 0, 0, 0);
            } else {
                long j8 = vhXQU.f6541s;
            }
            LinearLayout linearLayout2 = new LinearLayout(vhXQU);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            VhXQU.this.f6543u.addView(linearLayout2, new LinearLayout.LayoutParams(-1, g4.i.r(40.0f)));
            TextView c7 = g4.d.c(vhXQU, 12, Color.parseColor("#333333"), "总和:", 5);
            c7.setPadding(0, 0, g4.i.r(4.0f), 0);
            linearLayout2.addView(c7, new LinearLayout.LayoutParams(0, -2, 3.8f));
            linearLayout2.addView(g4.d.b(vhXQU, 12.0f, -65536, HttpUrl.FRAGMENT_ENCODE_SET + VhXQU.this.f6541s), new LinearLayout.LayoutParams(0, -2, 1.0f));
            VhXQU vhXQU3 = VhXQU.this;
            vhXQU3.Q(vhXQU3.f6543u, Color.parseColor("#cccccc"), 0.5f, 0, 0, 0);
        }
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(Color.parseColor("#cccccc"));
        linearLayout.setPadding(g4.i.r(10.0f), 0, g4.i.r(10.0f), g4.i.r(0.0f));
        this.f6542t.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(36.0f)));
        TextView b6 = g4.d.b(this, 12.0f, Color.parseColor("#333333"), "昵称");
        TextView b7 = g4.d.b(this, 12.0f, Color.parseColor("#333333"), "游戏类型");
        TextView b8 = g4.d.b(this, 12.0f, Color.parseColor("#333333"), "下注时间");
        TextView b9 = g4.d.b(this, 12.0f, Color.parseColor("#333333"), "时间值");
        linearLayout.addView(b6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(b7, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(b8, new LinearLayout.LayoutParams(0, -2, 1.7f));
        linearLayout.addView(b9, new LinearLayout.LayoutParams(0, -2, 0.8f));
    }

    void T0(t tVar) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.f6543u.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(36.0f)));
        TextView b6 = g4.d.b(this, 10.0f, Color.parseColor("#333333"), tVar.nickname);
        TextView b7 = g4.d.b(this, 10.0f, Color.parseColor("#333333"), com.secret.prettyhezi.Game.Number.k.a(tVar.vote_type));
        long j6 = tVar.order_time;
        long j7 = j6 / 1000;
        long j8 = j6 % 1000;
        int parseColor = Color.parseColor("#333333");
        TextView b8 = g4.d.b(this, 10.0f, parseColor, g4.i.w(j7) + "." + String.format("%03d", Long.valueOf(j8)));
        int parseColor2 = Color.parseColor("#333333");
        TextView b9 = g4.d.b(this, 12.0f, parseColor2, (((long) (new Date(tVar.order_time).getSeconds() * 1000)) + j8) + HttpUrl.FRAGMENT_ENCODE_SET);
        linearLayout.addView(b6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(b7, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(b8, new LinearLayout.LayoutParams(0, -2, 1.7f));
        linearLayout.addView(b9, new LinearLayout.LayoutParams(0, -2, 0.8f));
        Q(this.f6543u, Color.parseColor("#cccccc"), 0.5f, 0, 0, 0);
    }

    void U0() {
        I0();
        com.secret.prettyhezi.j.q(i.a() + "number/awards/view/limit/json?id=" + this.f6540r, i.f6608a.token.token, 3, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6540r = extras.getInt("id");
            this.f6541s = extras.getLong("extra");
        }
        LinearLayout B0 = B0(3, 4);
        this.f6542t = B0;
        M(B0, "下注详情");
        S0();
        LinearLayout e6 = e(this.f6542t);
        this.f6543u = e6;
        e6.setBackgroundColor(-1);
        this.f6543u.setPadding(g4.i.r(10.0f), 0, g4.i.r(10.0f), g4.i.r(20.0f));
        U0();
    }
}
