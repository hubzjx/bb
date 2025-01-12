package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class c0 extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    TextView f6569b;

    /* renamed from: c  reason: collision with root package name */
    TextView f6570c;

    /* renamed from: d  reason: collision with root package name */
    TextView f6571d;

    /* renamed from: e  reason: collision with root package name */
    TextView f6572e;

    /* renamed from: f  reason: collision with root package name */
    TextView f6573f;

    /* renamed from: g  reason: collision with root package name */
    int f6574g;

    /* renamed from: h  reason: collision with root package name */
    View f6575h;

    /* renamed from: i  reason: collision with root package name */
    TextView f6576i;

    /* renamed from: j  reason: collision with root package name */
    TextView f6577j;

    /* renamed from: k  reason: collision with root package name */
    LinearLayout f6578k;

    /* renamed from: l  reason: collision with root package name */
    TextView f6579l;

    public c0(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        setPadding(g4.i.r(12.0f), g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        setOrientation(1);
        setBackgroundColor(-1);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        TextView b6 = g4.d.b(zZcINlcxH, 18.0f, -16777216, HttpUrl.FRAGMENT_ENCODE_SET);
        this.f6569b = b6;
        linearLayout.addView(b6, new LinearLayout.LayoutParams(-2, -2));
        TextView c6 = g4.d.c(zZcINlcxH, 14, -65536, "金币/注", 5);
        this.f6570c = c6;
        linearLayout.addView(c6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(4.0f);
        addView(linearLayout2, layoutParams);
        TextView b7 = g4.d.b(zZcINlcxH, 14.0f, Color.parseColor("#666666"), "当期编号");
        this.f6571d = b7;
        linearLayout2.addView(b7, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView b8 = g4.d.b(zZcINlcxH, 14.0f, -16777216, HttpUrl.FRAGMENT_ENCODE_SET);
        this.f6572e = b8;
        linearLayout2.addView(b8, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout3 = new LinearLayout(zZcINlcxH);
        this.f6578k = linearLayout3;
        linearLayout3.setOrientation(1);
        this.f6578k.setGravity(16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(g4.i.r(1.0f), Color.parseColor("#cccccc"), g4.i.r(4.0f), g4.i.r(4.0f));
        this.f6578k.setBackground(gradientDrawable);
        this.f6578k.setPadding(g4.i.r(10.0f), g4.i.r(10.0f), g4.i.r(10.0f), g4.i.r(10.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = g4.i.r(6.0f);
        addView(this.f6578k, layoutParams2);
        TextView a6 = g4.d.a(zZcINlcxH, 14.0f, Color.parseColor("#333333"));
        this.f6579l = a6;
        this.f6578k.addView(a6, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout4 = new LinearLayout(zZcINlcxH);
        linearLayout4.setOrientation(1);
        linearLayout4.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = g4.i.r(10.0f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setStroke(g4.i.r(1.0f), Color.parseColor("#cccccc"), g4.i.r(4.0f), g4.i.r(4.0f));
        linearLayout4.setBackground(gradientDrawable2);
        linearLayout4.setPadding(g4.i.r(10.0f), g4.i.r(10.0f), g4.i.r(10.0f), g4.i.r(10.0f));
        addView(linearLayout4, layoutParams3);
        TextView b9 = g4.d.b(zZcINlcxH, 14.0f, -16777216, HttpUrl.FRAGMENT_ENCODE_SET);
        this.f6573f = b9;
        linearLayout4.addView(b9, new LinearLayout.LayoutParams(-1, -2));
        this.f6574g = zZcINlcxH.o().x - g4.i.r(48.0f);
        LinearLayout linearLayout5 = new LinearLayout(zZcINlcxH);
        linearLayout5.setBackground(g4.i.b(Color.parseColor("#cccccc"), 6.0f));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, g4.i.r(12.0f));
        int r5 = g4.i.r(4.0f);
        layoutParams4.bottomMargin = r5;
        layoutParams4.topMargin = r5;
        linearLayout4.addView(linearLayout5, layoutParams4);
        View view = new View(zZcINlcxH);
        this.f6575h = view;
        view.setBackground(g4.i.b(Color.parseColor("#ffff00"), 6.0f));
        linearLayout5.addView(this.f6575h, new LinearLayout.LayoutParams(g4.i.r(1.0f), -1));
        LinearLayout linearLayout6 = new LinearLayout(zZcINlcxH);
        linearLayout6.setOrientation(0);
        linearLayout4.addView(linearLayout6, new LinearLayout.LayoutParams(-1, -2));
        this.f6576i = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#333333"));
        this.f6577j = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#333333"));
        linearLayout6.addView(this.f6576i, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout6.addView(this.f6577j, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout7 = new LinearLayout(zZcINlcxH);
        linearLayout6.setOrientation(0);
        linearLayout4.addView(linearLayout7, new LinearLayout.LayoutParams(-1, -2));
        linearLayout7.addView(g4.d.b(zZcINlcxH, 12.0f, Color.parseColor("#666666"), "已下注"), new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout7.addView(g4.d.b(zZcINlcxH, 12.0f, Color.parseColor("#666666"), "可下注"), new LinearLayout.LayoutParams(-2, -2));
    }

    public void a(b0 b0Var) {
        this.f6569b.setText(b0Var.title);
        if (b0Var.Price() > 0) {
            TextView textView = this.f6570c;
            textView.setText(b0Var.Price() + "金币/注");
            this.f6570c.setVisibility(0);
        } else {
            this.f6570c.setVisibility(8);
        }
        TextView textView2 = this.f6571d;
        textView2.setText("本期编号:" + b0Var.order_no);
        TextView textView3 = this.f6572e;
        textView3.setText("价值:" + b0Var.integral + "金币");
        TextView textView4 = this.f6573f;
        textView4.setText("总需:" + b0Var.share + "注");
        String str = b0Var.ct;
        if (str == null || str.isEmpty()) {
            this.f6578k.setVisibility(8);
        } else {
            this.f6578k.setVisibility(0);
            this.f6579l.setText(b0Var.ct);
        }
        b(b0Var);
    }

    public void b(b0 b0Var) {
        int i6 = b0Var.share - b0Var.sy_share;
        TextView textView = this.f6576i;
        textView.setText(HttpUrl.FRAGMENT_ENCODE_SET + i6);
        TextView textView2 = this.f6577j;
        textView2.setText(b0Var.sy_share + HttpUrl.FRAGMENT_ENCODE_SET);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f6575h.getLayoutParams();
        int i7 = b0Var.sy_share;
        int i8 = i7 == 0 ? -1 : (this.f6574g * i6) / b0Var.share;
        layoutParams.width = i8;
        if (i7 > 0 && i6 > 0) {
            int i9 = this.f6574g;
            if (i8 < i9 / 100) {
                layoutParams.width = i9 / 100;
            }
        }
        this.f6575h.setLayoutParams(layoutParams);
    }
}
