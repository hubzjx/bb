package com.secret.prettyhezi.controls;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class y extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    TextView f8485b;

    /* renamed from: c  reason: collision with root package name */
    int f8486c;

    public y(Context context) {
        super(context);
        setGravity(16);
        TextView a6 = g4.d.a(context, 10.0f, -1);
        this.f8485b = a6;
        a6.setGravity(17);
        this.f8486c = 0;
        addView(this.f8485b, new LinearLayout.LayoutParams(-1, -1));
        this.f8485b.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-65536);
        gradientDrawable.setCornerRadius(g4.i.s(8.0f));
        this.f8485b.setBackground(gradientDrawable);
    }

    public int a() {
        return this.f8486c;
    }

    public void b(int i6) {
        TextView textView;
        LinearLayout.LayoutParams layoutParams;
        String str;
        TextView textView2 = this.f8485b;
        if (i6 == 0) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            if (i6 < 10) {
                textView = this.f8485b;
                layoutParams = new LinearLayout.LayoutParams(g4.i.r(16.0f), g4.i.r(16.0f));
            } else {
                textView = this.f8485b;
                layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(16.0f));
            }
            textView.setLayoutParams(layoutParams);
            TextView textView3 = this.f8485b;
            if (i6 <= 99) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + i6;
            } else {
                str = "99+";
            }
            textView3.setText(str);
        }
        this.f8486c = i6;
    }
}
