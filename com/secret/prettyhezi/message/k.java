package com.secret.prettyhezi.message;

import android.graphics.Color;
import android.widget.LinearLayout;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class k extends LinearLayout {
    public k(ZZcINlcxH zZcINlcxH, String str) {
        super(zZcINlcxH);
        setPadding(g4.i.r(12.0f), g4.i.r(10.0f), g4.i.r(12.0f), g4.i.r(10.0f));
        addView(g4.d.b(zZcINlcxH, 16.0f, Color.parseColor("#333333"), str), new LinearLayout.LayoutParams(-1, -2));
        setBackground(g4.i.f(0, Color.parseColor("#aaaaaa")));
    }
}
