package com.secret.prettyhezi.controls;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class u extends RelativeLayout {
    public u(Context context) {
        super(context);
    }

    public static u a(View view, int i6, int i7) {
        u uVar = new u(view.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(i6), g4.i.r(i7));
        layoutParams.addRule(13, 1);
        uVar.addView(view, layoutParams);
        return uVar;
    }
}
