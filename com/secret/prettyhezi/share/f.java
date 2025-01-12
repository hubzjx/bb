package com.secret.prettyhezi.share;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Server.n;
import com.secret.prettyhezi.View.u;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class f extends u {

    /* renamed from: p  reason: collision with root package name */
    static final int f9028p = Color.parseColor("#333333");

    /* renamed from: m  reason: collision with root package name */
    TextView f9029m;

    /* renamed from: n  reason: collision with root package name */
    TextView f9030n;

    /* renamed from: o  reason: collision with root package name */
    TextView f9031o;

    public f(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        setPadding(g4.i.r(0.0f), g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        setOrientation(0);
        setGravity(80);
        int i6 = f9028p;
        this.f9029m = g4.d.c(zZcINlcxH, 14, i6, HttpUrl.FRAGMENT_ENCODE_SET, 21);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(110.0f), -2);
        layoutParams.rightMargin = g4.i.r(12.0f);
        addView(this.f9029m, layoutParams);
        TextView a6 = g4.d.a(zZcINlcxH, 14.0f, i6);
        this.f9030n = a6;
        addView(a6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView a7 = g4.d.a(zZcINlcxH, 12.0f, i6);
        this.f9031o = a7;
        addView(a7, new LinearLayout.LayoutParams(-2, -2));
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(n nVar) {
        e eVar = (e) nVar;
        TextView textView = this.f9029m;
        StringBuilder sb = new StringBuilder();
        sb.append(eVar.value < 0.0d ? "-" : k5.d.ANY_NON_NULL_MARKER);
        sb.append(g4.i.F(Math.abs(eVar.value)));
        textView.setText(sb.toString());
        this.f9030n.setText(eVar.GetType());
        this.f9031o.setText(g4.i.z(eVar.created_at));
    }
}
