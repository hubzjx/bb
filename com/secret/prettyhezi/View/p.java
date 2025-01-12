package com.secret.prettyhezi.View;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class p extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f7975b;

    public p(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH);
        setGravity(16);
        View zVar = new com.secret.prettyhezi.controls.z(zZcINlcxH, i6);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(12.0f), g4.i.r(12.0f));
        layoutParams.rightMargin = g4.i.r(4.0f);
        addView(zVar, layoutParams);
        TextView a6 = g4.d.a(zZcINlcxH, 12.0f, -16777216);
        this.f7975b = a6;
        addView(a6, new LinearLayout.LayoutParams(-2, g4.i.r(16.0f)));
    }

    public void a(String str) {
        this.f7975b.setText(str);
    }
}
