package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
class g0 extends com.secret.prettyhezi.View.u {

    /* renamed from: m  reason: collision with root package name */
    TextView f6592m;

    /* renamed from: n  reason: collision with root package name */
    TextView f6593n;

    /* renamed from: o  reason: collision with root package name */
    TextView f6594o;

    /* renamed from: p  reason: collision with root package name */
    TextView f6595p;

    /* renamed from: q  reason: collision with root package name */
    TextView f6596q;

    /* renamed from: r  reason: collision with root package name */
    boolean f6597r;

    /* renamed from: s  reason: collision with root package name */
    int f6598s;

    /* renamed from: t  reason: collision with root package name */
    String f6599t;

    /* renamed from: u  reason: collision with root package name */
    boolean f6600u;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6601d;

        a(ZZcINlcxH zZcINlcxH) {
            this.f6601d = zZcINlcxH;
        }

        @Override // g4.f
        protected void a(View view) {
            g0 g0Var = g0.this;
            if (g0Var.f6600u) {
                this.f6601d.z("此夺宝已被系统撤销，金币已返还");
            } else {
                this.f6601d.N0(VfHLXJ.class, g0Var.f6598s);
            }
        }
    }

    public g0(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        this.f6597r = false;
        this.f6600u = false;
        this.f8037b = g4.i.r(70.0f);
        setPadding(g4.i.r(12.0f), 0, g4.i.r(10.0f), 0);
        setOrientation(0);
        setGravity(16);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(1);
        addView(linearLayout, new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.f6592m = g4.d.a(zZcINlcxH, 16.0f, -16777216);
        this.f6593n = g4.d.a(zZcINlcxH, 16.0f, -65536);
        this.f6594o = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#888888"));
        this.f6595p = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#888888"));
        this.f6596q = g4.d.a(zZcINlcxH, 14.0f, -65536);
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.addView(this.f6592m, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout2.addView(this.f6593n, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout3 = new LinearLayout(zZcINlcxH);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(4.0f);
        linearLayout.addView(linearLayout3, layoutParams);
        LinearLayout linearLayout4 = new LinearLayout(zZcINlcxH);
        linearLayout4.setOrientation(1);
        linearLayout3.addView(linearLayout4, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout4.addView(this.f6594o, new LinearLayout.LayoutParams(-2, -2));
        linearLayout4.addView(this.f6595p, new LinearLayout.LayoutParams(-2, -2));
        linearLayout3.addView(this.f6596q, new LinearLayout.LayoutParams(-2, -2));
        View zVar = new com.secret.prettyhezi.controls.z(zZcINlcxH, C0382R.drawable.ic_right_arrow);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(7.0f), g4.i.r(13.0f));
        layoutParams2.leftMargin = g4.i.r(12.0f);
        addView(zVar, layoutParams2);
        setBackground(g4.i.f(-1, Color.parseColor("#f0f0f0")));
        setOnClickListener(new a(zZcINlcxH));
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        TextView textView;
        int parseColor;
        f0 f0Var = (f0) nVar;
        this.f6598s = f0Var.loot_id;
        String str = f0Var.title;
        this.f6599t = str;
        this.f6592m.setText(str);
        TextView textView2 = this.f6593n;
        textView2.setText(f0Var.num + "注");
        TextView textView3 = this.f6594o;
        textView3.setText("订单编号:" + f0Var.project_no);
        this.f6595p.setText(g4.i.w(f0Var.created_at_hm / 1000));
        int i6 = f0Var.bonus_state;
        if (i6 == 0) {
            this.f6596q.setText("未开奖");
            this.f6596q.setTextColor(-16777216);
            this.f6597r = true;
        } else if (i6 > 0) {
            this.f6597r = false;
            if (f0Var.bonus > 0) {
                this.f6596q.setText("已中奖");
                textView = this.f6596q;
                parseColor = -65536;
            } else {
                this.f6596q.setText("未中奖");
                textView = this.f6596q;
                parseColor = Color.parseColor("#666666");
            }
            textView.setTextColor(parseColor);
        } else {
            this.f6596q.setText("已撤销");
            this.f6596q.setTextColor(Color.parseColor("#333333"));
            this.f6597r = false;
        }
        this.f6600u = f0Var.bonus_state < 0;
    }
}
