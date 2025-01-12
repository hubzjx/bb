package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class w extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    TextView f6670b;

    /* renamed from: c  reason: collision with root package name */
    TextView f6671c;

    /* renamed from: d  reason: collision with root package name */
    TextView f6672d;

    /* renamed from: e  reason: collision with root package name */
    TextView f6673e;

    public w(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        setOrientation(0);
        setGravity(16);
        this.f6670b = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#666666"));
        this.f6671c = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#333333"));
        this.f6672d = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#333333"));
        this.f6673e = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#333333"));
        addView(this.f6670b, new LinearLayout.LayoutParams(0, -2, 3.0f));
        addView(this.f6671c, new LinearLayout.LayoutParams(0, -2, 1.0f));
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(0);
        linearLayout.addView(this.f6672d, new LinearLayout.LayoutParams(-2, -2));
        addView(linearLayout, new LinearLayout.LayoutParams(0, -2, 3.0f));
        addView(this.f6673e, new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.f6672d.setBackground(g4.i.b(Color.parseColor("#f0f0f0"), 5.0f));
        this.f6672d.setPadding(g4.i.r(5.0f), g4.i.r(6.0f), g4.i.r(5.0f), g4.i.r(6.0f));
    }

    public static LinearLayout a(ZZcINlcxH zZcINlcxH) {
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        TextView b6 = g4.d.b(zZcINlcxH, 12.0f, Color.parseColor("#333333"), "时间");
        TextView b7 = g4.d.b(zZcINlcxH, 12.0f, Color.parseColor("#333333"), "数量");
        TextView b8 = g4.d.b(zZcINlcxH, 12.0f, Color.parseColor("#333333"), "号码");
        TextView b9 = g4.d.b(zZcINlcxH, 12.0f, Color.parseColor("#333333"), "中奖");
        linearLayout.addView(b6, new LinearLayout.LayoutParams(0, -2, 3.0f));
        linearLayout.addView(b7, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(b8, new LinearLayout.LayoutParams(0, -2, 3.0f));
        linearLayout.addView(b9, new LinearLayout.LayoutParams(0, -2, 1.0f));
        return linearLayout;
    }

    public void b(v vVar) {
        TextView textView;
        int parseColor;
        this.f6670b.setText(g4.i.w(vVar.created_at_hm / 1000));
        this.f6671c.setText(HttpUrl.FRAGMENT_ENCODE_SET + vVar.num);
        String str = vVar.lucky_number;
        if (vVar.num > 1) {
            int parseInt = Integer.parseInt(str);
            str = (str + " - ") + ((parseInt + vVar.num) - 1);
        }
        this.f6672d.setText(str);
        this.f6673e.setText(vVar.bonus_state == 0 ? "未开奖" : vVar.bonus > 0 ? "已中奖" : "未中奖");
        if (vVar.bonus > 0) {
            textView = this.f6673e;
            parseColor = -65536;
        } else {
            textView = this.f6673e;
            parseColor = Color.parseColor("#666666");
        }
        textView.setTextColor(parseColor);
    }
}
