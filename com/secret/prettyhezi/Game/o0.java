package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
class o0 extends com.secret.prettyhezi.View.u {

    /* renamed from: m  reason: collision with root package name */
    TextView f6639m;

    /* renamed from: n  reason: collision with root package name */
    TextView f6640n;

    public o0(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        setOrientation(0);
        setGravity(17);
        this.f8037b = g4.i.r(40.0f);
        setPadding(g4.i.r(12.0f), 0, g4.i.r(12.0f), 0);
        setBackground(g4.i.f(-1, Color.parseColor("#eeeeee")));
        this.f6640n = g4.d.a(zZcINlcxH, 12.0f, -65536);
        this.f6639m = g4.d.c(zZcINlcxH, 12, Color.parseColor("#888888"), HttpUrl.FRAGMENT_ENCODE_SET, 5);
        addView(this.f6640n, new LinearLayout.LayoutParams(0, -2, 1.0f));
        addView(this.f6639m, new LinearLayout.LayoutParams(g4.i.r(90.0f), -2));
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        n0 n0Var = (n0) nVar;
        this.f6639m.setText(g4.i.x(n0Var.created_at));
        this.f6640n.setText(n0Var.bonus);
    }
}
