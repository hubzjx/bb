package com.secret.prettyhezi.controls;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.secret.prettyhezi.C0382R;
/* loaded from: classes.dex */
public class n extends LinearLayout {
    public n(Context context) {
        super(context);
        a("加载失败");
    }

    void a(String str) {
        setGravity(16);
        addView(new z(getContext(), C0382R.drawable.home_menu), new LinearLayout.LayoutParams(g4.i.r(32.0f), g4.i.r(28.0f)));
        View b6 = g4.d.b(getContext(), 16.0f, -16777216, str);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = g4.i.r(15.0f);
        addView(b6, layoutParams);
    }
}
