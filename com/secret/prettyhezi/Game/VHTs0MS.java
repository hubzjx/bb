package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.UoWMF;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class VHTs0MS extends UoWMF implements x0.b {

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f6507r;

    /* renamed from: s  reason: collision with root package name */
    public x0.a f6508s;

    /* renamed from: t  reason: collision with root package name */
    public RelativeLayout f6509t;

    /* renamed from: u  reason: collision with root package name */
    int f6510u = 0;

    /* renamed from: v  reason: collision with root package name */
    String f6511v = HttpUrl.FRAGMENT_ENCODE_SET;

    /* renamed from: w  reason: collision with root package name */
    a0 f6512w;

    /* renamed from: x  reason: collision with root package name */
    int f6513x;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            VHTs0MS.this.f6508s.scrollTo(0, 0);
        }
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setPadding(g4.i.r(12.0f), 0, g4.i.r(10.0f), 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(Color.parseColor("#cccccc"));
        this.f6507r.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(40.0f)));
        TextView b6 = g4.d.b(this, 12.0f, Color.parseColor("#666666"), "期号");
        TextView c6 = g4.d.c(this, 12, Color.parseColor("#666666"), "中奖号码", 17);
        TextView c7 = g4.d.c(this, 12, Color.parseColor("#666666"), "剩余人数", 17);
        TextView c8 = g4.d.c(this, 12, Color.parseColor("#666666"), "状态", 17);
        TextView c9 = g4.d.c(this, 12, Color.parseColor("#666666"), "详情", 17);
        linearLayout.addView(b6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(c6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(c7, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(c8, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(c9, new LinearLayout.LayoutParams(0, -2, 1.0f));
    }

    public void T0(int i6) {
        a0 a0Var = this.f6512w;
        if (a0Var != null) {
            a0Var.D(i6);
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
        if (this.f6513x == i6) {
            return;
        }
        this.f6513x = i6;
        T0(i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6507r = B0(3, 4);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6510u = extras.getInt("id");
            this.f6511v = extras.getString("extra");
        }
        LinearLayout linearLayout = this.f6507r;
        RelativeLayout M = M(linearLayout, this.f6511v + "-往期回顾");
        this.f6509t = M;
        M.setOnClickListener(new a());
        S0();
        W(this.f6507r, Color.parseColor("#888888"), 0.5f, 0, 0, 0);
        x0.a aVar = new x0.a(this);
        this.f6508s = aVar;
        aVar.setScrollViewCallbacks(this);
        this.f6507r.addView(this.f6508s, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        a0 a0Var = new a0(this, this.f6510u);
        this.f6512w = a0Var;
        this.f6508s.addView(a0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a0 a0Var = this.f6512w;
        if (a0Var != null) {
            a0Var.b();
        }
    }
}
