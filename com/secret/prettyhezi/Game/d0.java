package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d0 extends LinearLayout {

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6580d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b0 f6581e;

        a(ZZcINlcxH zZcINlcxH, b0 b0Var) {
            this.f6580d = zZcINlcxH;
            this.f6581e = b0Var;
        }

        @Override // g4.f
        protected void a(View view) {
            ZZcINlcxH zZcINlcxH = this.f6580d;
            b0 b0Var = this.f6581e;
            zZcINlcxH.O0(VfHLXJ.class, b0Var.id, b0Var.ltyid);
        }
    }

    public d0(ZZcINlcxH zZcINlcxH, b0 b0Var) {
        super(zZcINlcxH);
        setPadding(g4.i.r(12.0f), g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        setOrientation(1);
        setBackgroundColor(-1);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(30.0f)));
        linearLayout.addView(g4.d.b(zZcINlcxH, 18.0f, -16777216, b0Var.title), new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(g4.d.c(zZcINlcxH, 14, -65536, b0Var.Price() + "金币/注", 5), new LinearLayout.LayoutParams(0, -2, 1.0f));
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        addView(linearLayout2, new LinearLayout.LayoutParams(-1, g4.i.r(46.0f)));
        linearLayout2.addView(g4.d.b(zZcINlcxH, 14.0f, Color.parseColor("#888888"), String.format("当期编号:%s\n夺宝进度:%d/%d", b0Var.order_no, Integer.valueOf(b0Var.share - b0Var.sy_share), Integer.valueOf(b0Var.share))), new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView c6 = g4.d.c(zZcINlcxH, 16, -1, "立即夺宝", 17);
        linearLayout2.addView(c6, new LinearLayout.LayoutParams(g4.i.r(80.0f), g4.i.r(38.0f)));
        c6.setBackground(g4.i.d(g4.i.b(-65536, 6.0f), g4.i.b(Color.parseColor("#bb0000"), 6.0f)));
        setBackground(g4.i.d(g4.i.b(-1, 0.0f), g4.i.b(Color.parseColor("#dddddd"), 0.0f)));
        setOnClickListener(new a(zZcINlcxH, b0Var));
    }
}
