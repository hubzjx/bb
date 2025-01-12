package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
class h extends com.secret.prettyhezi.View.u {

    /* renamed from: m  reason: collision with root package name */
    TextView f6603m;

    /* renamed from: n  reason: collision with root package name */
    TextView f6604n;

    /* renamed from: o  reason: collision with root package name */
    TextView f6605o;

    /* renamed from: p  reason: collision with root package name */
    TextView f6606p;

    /* renamed from: q  reason: collision with root package name */
    boolean f6607q;

    public h(ZZcINlcxH zZcINlcxH, boolean z5) {
        super(zZcINlcxH, 0);
        this.f6607q = z5;
        this.f8037b = g4.i.r(60.0f);
        setPadding(g4.i.r(12.0f), 0, g4.i.r(12.0f), 0);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(30.0f)));
        TextView a6 = g4.d.a(zZcINlcxH, 16.0f, -16777216);
        this.f6603m = a6;
        linearLayout.addView(a6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView a7 = g4.d.a(zZcINlcxH, 16.0f, -16777216);
        this.f6605o = a7;
        linearLayout.addView(a7, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        TextView a8 = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#888888"));
        this.f6604n = a8;
        linearLayout2.addView(a8, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView a9 = g4.d.a(zZcINlcxH, 12.0f, Color.parseColor("#888888"));
        this.f6606p = a9;
        linearLayout2.addView(a9, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(20.0f));
        layoutParams.bottomMargin = g4.i.r(10.0f);
        addView(linearLayout2, layoutParams);
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        TextView textView;
        String GetType;
        TextView textView2;
        StringBuilder sb;
        String str;
        g gVar = (g) nVar;
        if (this.f6607q && gVar.f6591t == 1) {
            textView = this.f6603m;
            GetType = "系统赠送";
        } else {
            textView = this.f6603m;
            GetType = gVar.GetType();
        }
        textView.setText(GetType);
        this.f6604n.setText(g4.i.v(gVar.created_at));
        TextView textView3 = this.f6606p;
        textView3.setText("余额 " + g4.i.F(gVar.overvalue));
        if (gVar.isAdd()) {
            this.f6605o.setTextColor(Color.parseColor("#ff0000"));
            textView2 = this.f6605o;
            sb = new StringBuilder();
            str = k5.d.ANY_NON_NULL_MARKER;
        } else {
            this.f6605o.setTextColor(-16711936);
            textView2 = this.f6605o;
            sb = new StringBuilder();
            str = "-";
        }
        sb.append(str);
        sb.append(g4.i.F(gVar.value));
        textView2.setText(sb.toString());
    }
}
