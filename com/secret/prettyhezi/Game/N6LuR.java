package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.UoWMF;
/* loaded from: classes.dex */
public class N6LuR extends UoWMF implements x0.b {

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f6289r;

    /* renamed from: s  reason: collision with root package name */
    public x0.a f6290s;

    /* renamed from: t  reason: collision with root package name */
    public RelativeLayout f6291t;

    /* renamed from: u  reason: collision with root package name */
    p f6292u;

    /* renamed from: v  reason: collision with root package name */
    int f6293v;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            N6LuR.this.f6290s.scrollTo(0, 0);
        }
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setPadding(g4.i.r(12.0f), 0, g4.i.r(10.0f), 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(Color.parseColor("#cccccc"));
        this.f6289r.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(40.0f)));
        TextView b6 = g4.d.b(this, 12.0f, Color.parseColor("#333333"), "期号");
        TextView c6 = g4.d.c(this, 12, Color.parseColor("#000000"), "数字", 17);
        linearLayout.addView(b6, new LinearLayout.LayoutParams(0, -2, 3.0f));
        linearLayout.addView(c6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        String[] strArr = {"大", "小", "单", "双", "组3", "组6"};
        for (int i6 = 0; i6 < 6; i6++) {
            linearLayout.addView(g4.d.c(this, 12, Color.parseColor("#333333"), strArr[i6], 17), new LinearLayout.LayoutParams(0, -1, 1.0f));
        }
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(7.0f), -1);
        layoutParams.leftMargin = g4.i.r(6.0f);
        linearLayout.addView(view, layoutParams);
    }

    public void T0(int i6) {
        p pVar = this.f6292u;
        if (pVar != null) {
            pVar.D(i6);
        }
    }

    @Override // x0.b
    public void a(x0.c cVar) {
    }

    @Override // x0.b
    public void b() {
    }

    @Override // x0.b
    public void c(int i6, boolean z5, boolean z6) {
        if (this.f6293v == i6) {
            return;
        }
        this.f6293v = i6;
        T0(i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout B0 = B0(3, 4);
        this.f6289r = B0;
        RelativeLayout M = M(B0, "数字游戏往期回顾");
        this.f6291t = M;
        M.setOnClickListener(new a());
        S0();
        W(this.f6289r, Color.parseColor("#888888"), 0.5f, 0, 0, 0);
        x0.a aVar = new x0.a(this);
        this.f6290s = aVar;
        aVar.setScrollViewCallbacks(this);
        this.f6289r.addView(this.f6290s, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        p pVar = new p(this);
        this.f6292u = pVar;
        this.f6290s.addView(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        p pVar = this.f6292u;
        if (pVar != null) {
            pVar.b();
        }
    }
}
