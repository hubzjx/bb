package com.secret.prettyhezi.Game.Number;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class d extends RelativeLayout {
    public d(Context context, int i6, boolean z5) {
        super(context);
        setBackground(g4.i.e(g4.i.c(a(i6), 8.0f, -16777216, 2.0f), g4.i.c(b(i6), 8.0f, -16777216, 2.0f), g4.i.c(Color.parseColor("#cccccc"), 8.0f, Color.parseColor("#666666"), 2.0f)));
        View c6 = g4.d.c(context, d(i6), c(i6), e(i6), 17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = g4.i.r(6.0f);
        addView(c6, layoutParams);
        View c7 = g4.d.c(context, 14, -65536, z5 ? k5.d.ANY_NON_NULL_MARKER : "X", 17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(g4.i.r(18.0f), g4.i.r(18.0f));
        layoutParams2.addRule(11, -1);
        c7.setBackground(g4.i.b(-16777216, 9.0f));
        addView(c7, layoutParams2);
    }

    public static int a(int i6) {
        if (i6 < 1000) {
            return -16711936;
        }
        return i6 < 10000 ? -16776961 : -256;
    }

    public static int b(int i6) {
        return Color.parseColor(i6 < 1000 ? "#00bb00" : i6 < 10000 ? "#0000bb" : "#bbbb00");
    }

    public static int c(int i6) {
        return (i6 >= 1000 && i6 < 10000) ? -1 : -16777216;
    }

    public static int d(int i6) {
        if (i6 < 1000) {
            return 14;
        }
        return (i6 >= 10000 && i6 < 100000000) ? 18 : 16;
    }

    public static String e(int i6) {
        if (i6 < 1000) {
            return i6 + HttpUrl.FRAGMENT_ENCODE_SET;
        } else if (i6 < 10000 && i6 % 1000 == 0) {
            return (i6 / 1000) + "千";
        } else if (i6 % 10000 == 0) {
            return (i6 / 10000) + "万";
        } else {
            return i6 + HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }
}
