package com.secret.prettyhezi.User;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.UoWMF;
/* loaded from: classes.dex */
public class R8yk5xS extends UoWMF {

    /* renamed from: u  reason: collision with root package name */
    public static b f7609u;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7610r;

    /* renamed from: s  reason: collision with root package name */
    public e f7611s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f7612t;

    @Override // com.secret.prettyhezi.ZZcINlcxH
    public void S(LinearLayout linearLayout, String str) {
        V(linearLayout, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        TextView b6 = g4.d.b(this, 14.0f, Color.parseColor("#666666"), str);
        b6.setPadding(g4.i.r(12.0f), 0, 0, 0);
        b6.setBackgroundColor(Color.parseColor("#dddddd"));
        b6.setGravity(16);
        linearLayout.addView(b6, new LinearLayout.LayoutParams(-1, g4.i.r(40.0f)));
        V(linearLayout, Color.parseColor("#cccccc"), 0.5f, 0, 0);
    }

    public void S0() {
        this.f7611s.p(true, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T0() {
        LinearLayout.LayoutParams layoutParams;
        View view;
        this.f7612t.removeAllViews();
        if (f7609u == null) {
            View b6 = g4.d.b(this, 14.0f, -65536, "暂未绑定设备，请尽快绑定!");
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int r5 = g4.i.r(18.0f);
            layoutParams.bottomMargin = r5;
            layoutParams.topMargin = r5;
            int r6 = g4.i.r(12.0f);
            layoutParams.rightMargin = r6;
            layoutParams.leftMargin = r6;
            view = b6;
        } else {
            c cVar = new c(this);
            cVar.b(f7609u);
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int r7 = g4.i.r(10.0f);
            layoutParams.bottomMargin = r7;
            layoutParams.topMargin = r7;
            view = cVar;
        }
        this.f7612t.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7610r = C0;
        M(C0, "设备管理");
        this.f7611s = null;
        S(this.f7610r, "已绑定设备");
        LinearLayout linearLayout = new LinearLayout(this);
        this.f7612t = linearLayout;
        linearLayout.setBackgroundColor(-1);
        this.f7610r.addView(this.f7612t, new LinearLayout.LayoutParams(-1, -2));
        S(this.f7610r, "登录设备");
        e eVar = new e(this);
        this.f7611s = eVar;
        this.f7610r.addView(eVar, new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }
}
