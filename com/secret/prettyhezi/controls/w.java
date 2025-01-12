package com.secret.prettyhezi.controls;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class w extends LinearLayout {
    public w(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH);
        setLayoutParams(a());
    }

    public RelativeLayout.LayoutParams a() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13, 1);
        int r5 = g4.i.r(20.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        return layoutParams;
    }
}
