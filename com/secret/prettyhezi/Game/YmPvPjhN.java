package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.secret.prettyhezi.UoWMF;
/* loaded from: classes.dex */
public class YmPvPjhN extends UoWMF implements x0.b {

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f6549r;

    /* renamed from: s  reason: collision with root package name */
    public x0.a f6550s;

    /* renamed from: t  reason: collision with root package name */
    public RelativeLayout f6551t;

    /* renamed from: u  reason: collision with root package name */
    h0 f6552u;

    /* renamed from: v  reason: collision with root package name */
    int f6553v;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            YmPvPjhN.this.f6550s.scrollTo(0, 0);
        }
    }

    public void S0(int i6) {
        h0 h0Var = this.f6552u;
        if (h0Var != null) {
            h0Var.D(i6);
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
        if (this.f6553v == i6) {
            return;
        }
        this.f6553v = i6;
        S0(i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout B0 = B0(3, 4);
        this.f6549r = B0;
        RelativeLayout M = M(B0, "我的夺宝订单");
        this.f6551t = M;
        M.setOnClickListener(new a());
        W(this.f6549r, Color.parseColor("#888888"), 0.5f, 0, 0, 0);
        x0.a aVar = new x0.a(this);
        this.f6550s = aVar;
        aVar.setScrollViewCallbacks(this);
        this.f6549r.addView(this.f6550s, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        h0 h0Var = new h0(this);
        this.f6552u = h0Var;
        this.f6550s.addView(h0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        h0 h0Var = this.f6552u;
        if (h0Var != null) {
            h0Var.b();
        }
    }
}
