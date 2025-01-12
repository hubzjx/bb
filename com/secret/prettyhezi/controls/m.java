package com.secret.prettyhezi.controls;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import com.secret.prettyhezi.ZZcINlcxH;
/* loaded from: classes.dex */
public class m extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public Switch f8407b;

    public m(Context context, String str, int i6, int i7) {
        super(context);
        ZZcINlcxH zZcINlcxH = (ZZcINlcxH) context;
        setOrientation(0);
        setGravity(16);
        setPadding(ZZcINlcxH.i0(i6), 0, ZZcINlcxH.i0(i7), 0);
        View b6 = g4.d.b(context, 16.0f, -16777216, str);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        addView(b6, layoutParams);
        this.f8407b = new Switch(context);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(50.0f), g4.i.r(24.0f));
        this.f8407b.setTextSize(16.0f);
        addView(this.f8407b, layoutParams2);
        this.f8407b.setChecked(false);
    }
}
