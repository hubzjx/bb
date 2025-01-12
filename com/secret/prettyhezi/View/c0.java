package com.secret.prettyhezi.View;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class c0 extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    TextView f7889b;

    public c0(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH);
        setOrientation(0);
        setPadding(g4.i.r(4.0f), g4.i.r(2.0f), g4.i.r(4.0f), g4.i.r(2.0f));
        setGravity(16);
        setBackgroundColor(Color.parseColor("#55000000"));
        View zVar = new com.secret.prettyhezi.controls.z(zZcINlcxH, C0382R.drawable.icn_unlocked);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(12.0f), g4.i.r(12.0f));
        layoutParams.rightMargin = g4.i.r(2.0f);
        addView(zVar, layoutParams);
        TextView c6 = g4.d.c(zZcINlcxH, 12, -1, HttpUrl.FRAGMENT_ENCODE_SET + i6, 17);
        this.f7889b = c6;
        addView(c6, new LinearLayout.LayoutParams(-2, -2));
    }

    public void a(int i6) {
        TextView textView = this.f7889b;
        textView.setText(i6 + HttpUrl.FRAGMENT_ENCODE_SET);
    }
}
