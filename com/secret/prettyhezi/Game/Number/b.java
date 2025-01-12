package com.secret.prettyhezi.Game.Number;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Game.Number.k;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
class b extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    TextView f6335b;

    /* renamed from: c  reason: collision with root package name */
    TextView f6336c;

    public b(ZZcINlcxH zZcINlcxH, String str) {
        super(zZcINlcxH);
        setOrientation(1);
        setGravity(17);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = g4.i.r(6.0f);
        addView(linearLayout, layoutParams);
        TextView b6 = g4.d.b(zZcINlcxH, 18.0f, -1, str);
        b6.setTextColor(g4.i.p(-1, -65536, -65536));
        linearLayout.addView(b6, new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(g4.d.b(zZcINlcxH, 14.0f, -1, " "), new LinearLayout.LayoutParams(-2, -2));
        TextView b7 = g4.d.b(zZcINlcxH, 14.0f, -1, "1.82");
        this.f6335b = b7;
        linearLayout.addView(b7);
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        linearLayout2.setGravity(17);
        addView(linearLayout2, new LinearLayout.LayoutParams(-2, -2));
        TextView b8 = g4.d.b(zZcINlcxH, 14.0f, Color.parseColor("#ffff00"), "0");
        this.f6336c = b8;
        linearLayout2.addView(b8, new LinearLayout.LayoutParams(-2, -2));
    }

    public static boolean a(b[] bVarArr, k.c cVar, int i6) {
        if (bVarArr[0].isSelected()) {
            cVar.integral_1 = i6;
        } else if (bVarArr[1].isSelected()) {
            cVar.integral_2 = i6;
        } else if (bVarArr[2].isSelected()) {
            cVar.integral_3 = i6;
        } else if (bVarArr[3].isSelected()) {
            cVar.integral_4 = i6;
        } else if (bVarArr[4].isSelected()) {
            cVar.integral_5 = i6;
        } else if (bVarArr[5].isSelected()) {
            cVar.integral_6 = i6;
        } else if (bVarArr[6].isSelected()) {
            cVar.integral_7 = i6;
        } else if (!bVarArr[7].isSelected()) {
            return false;
        } else {
            cVar.integral_8 = i6;
        }
        return true;
    }

    public static void c(b[] bVarArr, k.g.a aVar) {
        bVarArr[0].b(aVar.integral1Sum);
        bVarArr[1].b(aVar.integral2Sum);
        bVarArr[2].b(aVar.integral3Sum);
        bVarArr[3].b(aVar.integral4Sum);
        bVarArr[4].b(aVar.integral5Sum);
        bVarArr[5].b(aVar.integral6Sum);
        bVarArr[6].b(aVar.integral7Sum);
        bVarArr[7].b(aVar.integral8Sum);
    }

    public void b(int i6) {
        TextView textView = this.f6336c;
        textView.setText(i6 + HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public void d(double d6) {
        this.f6335b.setText(g4.i.B(d6));
    }
}
