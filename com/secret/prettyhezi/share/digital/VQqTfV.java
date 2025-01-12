package com.secret.prettyhezi.share.digital;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.f;
import g4.i;
/* loaded from: classes.dex */
public class VQqTfV extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    a f8990r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f8991s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f8992t;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f8990r = (a) f.d(extras.getString("extra"), a.class);
        }
        LinearLayout C0 = C0();
        this.f8991s = C0;
        M(C0, "兑换USDT详情");
        this.f8991s.setBackgroundColor(-1);
        V(this.f8991s, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        LinearLayout e6 = e(this.f8991s);
        this.f8992t = e6;
        e6.setPadding(i.r(12.0f), i.r(6.0f), i.r(12.0f), i.r(20.0f));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.f8992t.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView b6 = g4.d.b(this, 14.0f, -16777216, "预兑换USDT: " + this.f8990r.amount);
        StringBuilder sb = new StringBuilder();
        if (this.f8990r.status == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("消耗: ");
            str = "#cccccc";
            sb2.append(i.F(this.f8990r.score2));
            str2 = sb2.toString();
        } else {
            str = "#cccccc";
            str2 = "冻结: " + i.F(this.f8990r.score1);
        }
        sb.append(str2);
        sb.append("积分");
        TextView b7 = g4.d.b(this, 14.0f, -16777216, sb.toString());
        linearLayout2.addView(b6, new LinearLayout.LayoutParams(-2, i.r(22.0f)));
        linearLayout2.addView(b7, new LinearLayout.LayoutParams(-2, i.r(22.0f)));
        if (this.f8990r.fee > 0.0d) {
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(0);
            linearLayout3.setGravity(16);
            linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(-1, i.r(22.0f)));
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f8990r.status == 2 ? "到账: " : "预到账: ");
            sb3.append(i.C(this.f8990r.actual_amount));
            sb3.append("USDT");
            TextView b8 = g4.d.b(this, 14.0f, -65536, sb3.toString());
            TextView b9 = g4.d.b(this, 14.0f, -65536, "  手续费: " + i.C(this.f8990r.fee) + "USDT");
            linearLayout3.addView(b8, new LinearLayout.LayoutParams(-2, -2));
            linearLayout3.addView(b9, new LinearLayout.LayoutParams(-2, -2));
        }
        View c6 = g4.d.c(this, 14, -16777216, this.f8990r.Status(), 17);
        c6.setBackground(i.c(-1, 5.0f, Color.parseColor(str), 1.0f));
        linearLayout.addView(c6, new LinearLayout.LayoutParams(i.r(70.0f), i.r(40.0f)));
        Q(this.f8992t, Color.parseColor(str), 0.5f, 0, 6, 0);
        TextView b10 = g4.d.b(this, 12.0f, -65536, "申请时人民币兑USDT汇率: " + i.C(this.f8990r.cny1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = i.r(6.0f);
        layoutParams.bottomMargin = i.r(4.0f);
        this.f8992t.addView(b10, layoutParams);
        com.secret.prettyhezi.controls.f fVar = new com.secret.prettyhezi.controls.f();
        fVar.a("由于币的价格波动,为了保证交易能够完成，冻结的积分会比需要的积分多,", Color.parseColor("#666666"), 12.0f);
        fVar.a("审核通过后系统会根据即时价格计算出积分", -65536, 12.0f);
        TextView a6 = g4.d.a(this, 14.0f, Color.parseColor("#666666"));
        a6.setText(fVar.f8321d);
        this.f8992t.addView(a6, new LinearLayout.LayoutParams(-1, -2));
        TextView b11 = g4.d.b(this, 12.0f, Color.parseColor("#333333"), "提币地址: " + this.f8990r.address);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = i.r(8.0f);
        this.f8992t.addView(b11, layoutParams2);
        TextView b12 = g4.d.b(this, 12.0f, Color.parseColor("#666666"), "申请时间: " + i.v(this.f8990r.created_at));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = i.r(6.0f);
        this.f8992t.addView(b12, layoutParams3);
        String str3 = this.f8990r.txid;
        if (str3 != null && !str3.isEmpty()) {
            Q(this.f8992t, Color.parseColor(str), 0.5f, 0, 10, 0);
            TextView b13 = g4.d.b(this, 12.0f, -65536, "结算时人民币兑USDT汇率: " + i.C(this.f8990r.cny2));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = i.r(6.0f);
            layoutParams4.bottomMargin = i.r(6.0f);
            this.f8992t.addView(b13, layoutParams4);
            int parseColor = Color.parseColor("#666666");
            this.f8992t.addView(g4.d.b(this, 12.0f, parseColor, "所需积分: " + (this.f8990r.amount + "/" + this.f8990r.cny2 + "*100=" + i.F(this.f8990r.score2))), new LinearLayout.LayoutParams(-1, -2));
            TextView b14 = g4.d.b(this, 12.0f, Color.parseColor("#333333"), "TXID: " + this.f8990r.txid);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.topMargin = i.r(6.0f);
            this.f8992t.addView(b14, layoutParams5);
        }
        if (this.f8990r.updated_at > 0) {
            TextView b15 = g4.d.b(this, 12.0f, Color.parseColor("#666666"), "更新时间: " + i.v(this.f8990r.updated_at));
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams6.topMargin = i.r(6.0f);
            this.f8992t.addView(b15, layoutParams6);
        }
    }
}
