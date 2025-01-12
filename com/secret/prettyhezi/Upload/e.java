package com.secret.prettyhezi.Upload;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
class e extends com.secret.prettyhezi.View.u {

    /* renamed from: o  reason: collision with root package name */
    static final int f7460o = Color.parseColor("#333333");

    /* renamed from: m  reason: collision with root package name */
    TextView f7461m;

    /* renamed from: n  reason: collision with root package name */
    TextView f7462n;

    public e(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        setPadding(g4.i.r(12.0f), g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        setOrientation(0);
        setGravity(17);
        int i6 = f7460o;
        TextView c6 = g4.d.c(zZcINlcxH, 14, i6, HttpUrl.FRAGMENT_ENCODE_SET, 5);
        this.f7461m = c6;
        addView(c6, new LinearLayout.LayoutParams(g4.i.r(100.0f), -2));
        this.f7462n = g4.d.c(zZcINlcxH, 16, i6, HttpUrl.FRAGMENT_ENCODE_SET, 16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(100.0f), -2);
        layoutParams.leftMargin = g4.i.r(40.0f);
        addView(this.f7462n, layoutParams);
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        c cVar = (c) nVar;
        TextView textView = this.f7462n;
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.score < 0.0d ? "-" : k5.d.ANY_NON_NULL_MARKER);
        sb.append(g4.i.F(Math.abs(cVar.score)));
        textView.setText(sb.toString());
        this.f7461m.setText(g4.i.u(cVar.today));
    }
}
