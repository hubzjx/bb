package com.secret.prettyhezi.share;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Server.n;
import com.secret.prettyhezi.View.u;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
class j extends u {

    /* renamed from: m  reason: collision with root package name */
    TextView f9033m;

    /* renamed from: n  reason: collision with root package name */
    TextView f9034n;

    /* renamed from: o  reason: collision with root package name */
    TextView f9035o;

    public j(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        setOrientation(1);
        setBackground(null);
        this.f8037b = g4.i.r(33.0f);
        setPadding(g4.i.r(12.0f), 0, g4.i.r(12.0f), 0);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        View view = new View(zZcINlcxH);
        view.setBackgroundColor(Color.parseColor("#888888"));
        addView(view, new LinearLayout.LayoutParams(-1, g4.i.r(0.5f)));
        this.f9033m = g4.d.c(zZcINlcxH, 16, -16777216, HttpUrl.FRAGMENT_ENCODE_SET, 16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, g4.i.r(32.0f));
        this.f9034n = g4.d.c(zZcINlcxH, 16, -16777216, HttpUrl.FRAGMENT_ENCODE_SET, 17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, g4.i.r(32.0f), 1.0f);
        this.f9035o = g4.d.c(zZcINlcxH, 16, -16777216, HttpUrl.FRAGMENT_ENCODE_SET, 16);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, g4.i.r(32.0f));
        linearLayout.addView(this.f9033m, layoutParams);
        linearLayout.addView(this.f9034n, layoutParams2);
        linearLayout.addView(this.f9035o, layoutParams3);
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(n nVar) {
        i iVar = (i) nVar;
        this.f9033m.setText(g4.i.u(iVar.today));
        TextView textView = this.f9034n;
        textView.setText("邀请人数：" + iVar.invite_count);
        TextView textView2 = this.f9035o;
        textView2.setText("获得积分：" + g4.i.F(iVar.invite_score));
    }
}
