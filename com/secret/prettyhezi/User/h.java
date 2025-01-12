package com.secret.prettyhezi.User;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Server.n;
import com.secret.prettyhezi.View.u;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
class h extends u {

    /* renamed from: p  reason: collision with root package name */
    static final int f7739p = Color.parseColor("#333333");

    /* renamed from: m  reason: collision with root package name */
    TextView f7740m;

    /* renamed from: n  reason: collision with root package name */
    TextView f7741n;

    /* renamed from: o  reason: collision with root package name */
    TextView f7742o;

    public h(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        setPadding(g4.i.r(0.0f), g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        setOrientation(0);
        setGravity(80);
        int i6 = f7739p;
        this.f7740m = g4.d.c(zZcINlcxH, 14, i6, HttpUrl.FRAGMENT_ENCODE_SET, 21);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(110.0f), -2);
        layoutParams.rightMargin = g4.i.r(12.0f);
        addView(this.f7740m, layoutParams);
        TextView a6 = g4.d.a(zZcINlcxH, 14.0f, i6);
        this.f7741n = a6;
        addView(a6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView a7 = g4.d.a(zZcINlcxH, 12.0f, i6);
        this.f7742o = a7;
        addView(a7, new LinearLayout.LayoutParams(-2, -2));
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(n nVar) {
        g gVar = (g) nVar;
        TextView textView = this.f7740m;
        textView.setText(k5.d.ANY_NON_NULL_MARKER + g4.i.F(gVar.exp));
        this.f7741n.setText(gVar.GetType());
        this.f7742o.setText(g4.i.z(gVar.created_at));
    }
}
