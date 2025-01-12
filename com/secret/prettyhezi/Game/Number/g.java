package com.secret.prettyhezi.Game.Number;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class g extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f6374b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6375c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6376d;

    public g(Context context) {
        super(context);
        setOrientation(0);
        setGravity(80);
        setPadding(g4.i.r(12.0f), g4.i.r(10.0f), g4.i.r(12.0f), g4.i.r(12.0f));
        addView(g4.d.b(context, 14.0f, Color.parseColor("#666666"), "当前游戏:  "), new LinearLayout.LayoutParams(-2, -2));
        TextView b6 = g4.d.b(context, 16.0f, -16777216, "20230403-187");
        this.f6374b = b6;
        addView(b6, new LinearLayout.LayoutParams(-2, -2));
        TextView c6 = g4.d.c(context, 14, Color.parseColor("#666666"), "剩余时间:", 5);
        this.f6375c = c6;
        addView(c6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView c7 = g4.d.c(context, 16, -65536, HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f6376d = c7;
        c7.setBackground(g4.i.c(-1, 5.0f, -65536, 2.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(28.0f));
        layoutParams.leftMargin = g4.i.r(6.0f);
        addView(this.f6376d, layoutParams);
    }
}
