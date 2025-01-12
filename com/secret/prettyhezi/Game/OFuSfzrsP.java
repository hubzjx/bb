package com.secret.prettyhezi.Game;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class OFuSfzrsP extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6413r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6414s;

    /* renamed from: t  reason: collision with root package name */
    int f6415t;

    /* renamed from: u  reason: collision with root package name */
    String f6416u = HttpUrl.FRAGMENT_ENCODE_SET;

    /* renamed from: v  reason: collision with root package name */
    int f6417v = 86;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c.a f6418d;

        a(c.a aVar) {
            this.f6418d = aVar;
        }

        @Override // g4.f
        protected void a(View view) {
            Intent intent = new Intent(OFuSfzrsP.this, VhXQU.class);
            Bundle bundle = new Bundle();
            bundle.putInt("id", OFuSfzrsP.this.f6415t);
            intent.putExtras(bundle);
            intent.putExtra("extra", this.f6418d.order_alltime);
            OFuSfzrsP.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends s.g {
        b(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            c cVar = (c) com.secret.prettyhezi.f.d(str, c.class);
            if (cVar.code == 200) {
                OFuSfzrsP.this.W0(cVar.data);
            } else {
                OFuSfzrsP.this.w0(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    static class c extends com.secret.prettyhezi.Server.w {
        a data;

        /* loaded from: classes.dex */
        public static class a implements Serializable {
            public int add_num;
            public long award_at;
            public int id;
            public int is_new;
            public String number_no;
            public long order_alltime;
            public int order_integral;
            public long order_lasttime;
            public int order_total;
            public String sha256_str;
        }

        c() {
        }
    }

    public static LinearLayout S0(ZZcINlcxH zZcINlcxH, LinearLayout linearLayout, String str, int i6) {
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        linearLayout2.setOrientation(0);
        linearLayout2.setPadding(0, g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        TextView c6 = g4.d.c(zZcINlcxH, 12, Color.parseColor("#333333"), str, 5);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(i6), -2);
        layoutParams.rightMargin = g4.i.r(12.0f);
        linearLayout2.addView(c6, layoutParams);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        ZZcINlcxH.R(zZcINlcxH, linearLayout, Color.parseColor("#cccccc"), 1.0f, 12, 0, 12);
        return linearLayout2;
    }

    public static LinearLayout U0(ZZcINlcxH zZcINlcxH, LinearLayout linearLayout, String str, String str2, int i6) {
        LinearLayout S0 = S0(zZcINlcxH, linearLayout, str, i6);
        S0.addView(g4.d.b(zZcINlcxH, 12.0f, Color.parseColor("#333333"), str2), new LinearLayout.LayoutParams(0, -2, 1.0f));
        return S0;
    }

    LinearLayout T0(String str) {
        return S0(this, this.f6414s, str, this.f6417v);
    }

    LinearLayout V0(String str, String str2) {
        return U0(this, this.f6414s, str, str2, this.f6417v);
    }

    void W0(c.a aVar) {
        String substring;
        String substring2;
        this.f6414s.removeAllViews();
        this.f6417v = aVar.is_new == 1 ? 96 : 86;
        V0("订单数", aVar.order_total + HttpUrl.FRAGMENT_ENCODE_SET);
        V0("总金币", aVar.order_integral + HttpUrl.FRAGMENT_ENCODE_SET);
        if (aVar.is_new == 2) {
            LinearLayout V0 = V0("下单时间相关数", aVar.order_alltime + " - ");
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) V0.getChildAt(1).getLayoutParams();
            layoutParams.weight = 0.0f;
            layoutParams.width = -2;
            V0.getChildAt(1).setLayoutParams(layoutParams);
            TextView b6 = g4.d.b(this, 12.0f, Color.parseColor("#0000ff"), "任选50条订单详情");
            V0.addView(b6, new LinearLayout.LayoutParams(-2, -2));
            b6.setOnClickListener(new a(aVar));
        } else {
            long j6 = aVar.order_lasttime;
            long j7 = j6 / 1000;
            long j8 = j6 % 1000;
            V0("最后一单时间", g4.i.w(j7) + String.format(".%03d", Long.valueOf(j8)) + "(" + aVar.order_lasttime + ")");
            if (aVar.is_new == 1) {
                V0("最后一单毫秒数", String.format("%03d", Long.valueOf(j8)));
            }
        }
        int i6 = aVar.is_new;
        V0("加密方式", i6 != 1 ? i6 != 2 ? "SHA256(订单数+总金币+最后一单时间)" : "SHA256(订单数+总金币+下单时间相关数)" : "SHA256(订单数+总金币+最后一单时间的毫秒数)");
        V0("加密后哈希", aVar.sha256_str);
        V0("五段数字来源", "将64位哈希取中间60位,分成5段");
        int i7 = 5;
        String[] strArr = new String[5];
        int i8 = 0;
        while (i8 < 5) {
            int i9 = i8 + 1;
            strArr[i8] = aVar.sha256_str.substring((i8 * 12) + 2, (i9 * 12) + 2);
            i8 = i9;
        }
        String[] strArr2 = {"一", "二", "三", "四", "五"};
        String str = " 转十进制:";
        String str2 = "段字符";
        int i10 = 16;
        if (aVar.add_num > 0) {
            String[] strArr3 = new String[5];
            substring2 = HttpUrl.FRAGMENT_ENCODE_SET;
            int i11 = 0;
            while (i11 < i7) {
                int i12 = i11;
                long parseLong = Long.parseLong(strArr[i11], i10);
                V0("第" + strArr2[i12] + str2, strArr[i12] + str + parseLong);
                String str3 = str;
                long j9 = parseLong % 10;
                int i13 = ((int) j9) + aVar.add_num;
                String substring3 = (parseLong + HttpUrl.FRAGMENT_ENCODE_SET).substring(i13 - 1, i13);
                substring2 = substring2 + substring3;
                strArr3[i12] = "第" + strArr2[i12] + "段字符十进制第" + i13 + "(尾数" + j9 + "+2)位:" + substring3;
                i11 = i12 + 1;
                str = str3;
                str2 = str2;
                strArr = strArr;
                i7 = 5;
                i10 = 16;
            }
            V0("开奖计算过程", HttpUrl.FRAGMENT_ENCODE_SET);
            for (int i14 = 0; i14 < 5; i14++) {
                V0("第" + strArr2[i14] + "位", strArr3[i14]);
            }
            substring = substring2.substring(0, 3);
        } else {
            long j10 = 0;
            int i15 = 0;
            while (i15 < 5) {
                int i16 = i15 + 1;
                String substring4 = aVar.sha256_str.substring((i15 * 12) + 2, (i16 * 12) + 2);
                long parseLong2 = Long.parseLong(substring4, 16);
                j10 += parseLong2;
                V0("第" + strArr2[i15] + "段字符", substring4 + " 转十进制:" + parseLong2);
                i15 = i16;
            }
            String str4 = j10 + HttpUrl.FRAGMENT_ENCODE_SET;
            V0("五段数字之和", j10 + HttpUrl.FRAGMENT_ENCODE_SET);
            String substring5 = str4.substring(0, 1);
            V0("开奖计算过程", str4 + "第一位数字是" + substring5 + "\n从第" + substring5 + "位开始 截取 3/5 个数字");
            int parseInt = Integer.parseInt(substring5) - 1;
            substring = str4.substring(parseInt, parseInt + 3);
            substring2 = str4.substring(parseInt, parseInt + 5);
        }
        LinearLayout T0 = T0("开奖数字");
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        T0.addView(linearLayout, new LinearLayout.LayoutParams(0, -2, 1.0f));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        TextView b7 = g4.d.b(this, 12.0f, -65536, substring);
        TextView b8 = g4.d.b(this, 12.0f, Color.parseColor("#666666"), " (三位数字用于数字游戏开奖)");
        linearLayout2.addView(b7, new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.addView(b8, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
        TextView b9 = g4.d.b(this, 12.0f, -65536, substring2);
        TextView b10 = g4.d.b(this, 12.0f, Color.parseColor("#666666"), "(五位数字用于同期夺宝开奖)");
        linearLayout3.addView(b9, new LinearLayout.LayoutParams(-2, -2));
        linearLayout3.addView(b10, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout T02 = T0("三位数字之和");
        LinearLayout linearLayout4 = new LinearLayout(this);
        linearLayout4.setOrientation(1);
        T02.addView(linearLayout4, new LinearLayout.LayoutParams(0, -2, 1.0f));
        int parseInt2 = Integer.parseInt(substring);
        int i17 = parseInt2 / 100;
        int i18 = (parseInt2 % 100) / 10;
        int i19 = parseInt2 % 10;
        int i20 = i17 + i18 + i19;
        linearLayout4.addView(g4.d.b(this, 12.0f, -65536, String.format("(%d+%d+%d=%d)", Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i20))), new LinearLayout.LayoutParams(-2, -2));
        linearLayout4.addView(g4.d.b(this, 12.0f, Color.parseColor("#666666"), "(0到13为小 14到27为大)"), new LinearLayout.LayoutParams(-2, -2));
        String str5 = (i20 < 14 ? "小" : "大") + " ";
        StringBuilder sb = new StringBuilder();
        sb.append(str5);
        sb.append(i20 % 2 == 0 ? "双" : "单");
        ((TextView) V0("开奖结果", sb.toString()).getChildAt(1)).setTextColor(-65536);
        V0("开奖时间", g4.i.w(aVar.award_at));
    }

    void X0() {
        I0();
        com.secret.prettyhezi.j.q(i.a() + "number/awards/view/json?id=" + this.f6415t, i.f6608a.token.token, 3, new b(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6415t = extras.getInt("id");
            this.f6416u = extras.getString("extra");
        }
        LinearLayout C0 = C0();
        this.f6413r = C0;
        M(C0, this.f6416u + "期-开奖详情");
        W(this.f6413r, Color.parseColor("#cccccc"), 0.5f, 0, 0, 0);
        LinearLayout e6 = e(this.f6413r);
        this.f6414s = e6;
        e6.setBackgroundColor(Color.parseColor("#f0f0f0"));
        this.f6414s.setPadding(0, g4.i.r(10.0f), 0, g4.i.r(20.0f));
        X0();
    }
}
