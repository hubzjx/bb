package com.secret.prettyhezi.Upload;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import c.abc;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Server.s;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.View.n;
import com.secret.prettyhezi.controls.PullToRefresh.f;
/* loaded from: classes.dex */
public class KLNPK extends UoWMF {

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f7334s;

    /* renamed from: w  reason: collision with root package name */
    com.secret.prettyhezi.controls.PullToRefresh.i f7338w;

    /* renamed from: r  reason: collision with root package name */
    boolean f7333r = false;

    /* renamed from: t  reason: collision with root package name */
    int[] f7335t = {1, 6, 2, 5};

    /* renamed from: u  reason: collision with root package name */
    int[] f7336u = {C0382R.string.Image, C0382R.string.Gallery, C0382R.string.ShortVideo, C0382R.string.LongVideo};

    /* renamed from: v  reason: collision with root package name */
    int f7337v = -1;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            KLNPK.this.T0();
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        protected void a(View view) {
            KLNPK.this.M0(K318k2KH.class);
        }
    }

    /* loaded from: classes.dex */
    class c implements n.b {
        c() {
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void a(int i6) {
            KLNPK klnpk = KLNPK.this;
            klnpk.f7337v = i6;
            klnpk.f7338w.p(true, 0L);
            KLNPK.this.T0();
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void b(int i6) {
            KLNPK.this.f7338w.p(true, 0L);
        }
    }

    /* loaded from: classes.dex */
    class d extends f.h {
        d() {
        }

        @Override // com.secret.prettyhezi.controls.PullToRefresh.f.h
        public void a(com.secret.prettyhezi.controls.PullToRefresh.f fVar) {
            super.a(fVar);
            KLNPK.this.S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S0() {
        ScrollView scrollView;
        View tVar;
        ViewGroup.LayoutParams layoutParams;
        ((ScrollView) this.f7338w.getRefreshableView()).removeAllViews();
        int i6 = this.f7335t[this.f7337v];
        if (i6 == 1 || i6 == 6) {
            scrollView = (ScrollView) this.f7338w.getRefreshableView();
            tVar = new t(this, i6, this.f7333r);
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        } else if (i6 != 2 && i6 != 5) {
            this.f7338w.z();
            return;
        } else {
            scrollView = (ScrollView) this.f7338w.getRefreshableView();
            tVar = new v(this, i6, this.f7333r);
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        scrollView.addView(tVar, layoutParams);
    }

    void T0() {
        s.a GetItem = com.secret.prettyhezi.Server.s.GetItem(p.a(this.f7335t[this.f7337v]));
        if (GetItem != null) {
            com.secret.prettyhezi.controls.x E = E(GetItem.name, GetItem.content, null, false);
            E.b();
            E.f8479f.setGravity(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7333r = extras.getInt("id") > 0;
        }
        LinearLayout C0 = C0();
        this.f7334s = C0;
        RelativeLayout N = N(C0, abc.ams(this.f7333r ? "s0" : "s5"), "规则", new a());
        if (!this.f7333r) {
            TextView b6 = g4.d.b(this, 16.0f, Color.parseColor("#333333"), abc.ams("s6"));
            b6.setTextColor(g4.i.q(Color.parseColor("#333333"), -16777216, -7829368, -7829368));
            b6.setPadding(g4.i.r(12.0f), 0, g4.i.r(12.0f), 0);
            b6.setGravity(17);
            b6.setTextAlignment(4);
            b6.setBackground(g4.i.f(0, Color.parseColor("#f0f0f0")));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(11, -1);
            layoutParams.rightMargin = g4.i.r(60.0f);
            N.addView(b6, layoutParams);
            b6.setId(13);
            b6.setOnClickListener(new b());
        }
        com.secret.prettyhezi.View.n nVar = new com.secret.prettyhezi.View.n(this, this.f7336u, new c());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, g4.i.r(42.0f));
        layoutParams2.topMargin = g4.i.r(1.0f);
        this.f7334s.addView(nVar, layoutParams2);
        com.secret.prettyhezi.controls.PullToRefresh.i iVar = new com.secret.prettyhezi.controls.PullToRefresh.i(this);
        this.f7338w = iVar;
        iVar.setScrollBarSize(0);
        this.f7334s.addView(this.f7338w, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f7338w.setOnRefreshListener(new d());
        nVar.setCurrentTab(0);
    }
}
