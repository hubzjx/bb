package com.secret.prettyhezi;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import c.abc;
import com.secret.prettyhezi.View.n;
import com.secret.prettyhezi.controls.PullToRefresh.f;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class UFlsvW6LF extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7149r;

    /* renamed from: s  reason: collision with root package name */
    com.secret.prettyhezi.controls.PullToRefresh.i f7150s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f7151t;

    /* renamed from: u  reason: collision with root package name */
    int[] f7152u = {1, 2};

    /* renamed from: v  reason: collision with root package name */
    String[] f7153v = {"积分", "注册码"};

    /* renamed from: w  reason: collision with root package name */
    int f7154w = -1;

    /* renamed from: x  reason: collision with root package name */
    com.secret.prettyhezi.View.n f7155x;

    /* loaded from: classes.dex */
    class a implements n.b {
        a() {
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void a(int i6) {
            UFlsvW6LF uFlsvW6LF = UFlsvW6LF.this;
            uFlsvW6LF.f7154w = i6;
            uFlsvW6LF.f7150s.p(true, 0L);
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void b(int i6) {
            UFlsvW6LF.this.f7150s.p(true, 0L);
        }
    }

    /* loaded from: classes.dex */
    class b extends f.h {
        b() {
        }

        @Override // com.secret.prettyhezi.controls.PullToRefresh.f.h
        public void a(com.secret.prettyhezi.controls.PullToRefresh.f fVar) {
            super.a(fVar);
            UFlsvW6LF.this.S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends s.g {
        c(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void d(String str) {
            super.d(str);
            UFlsvW6LF.this.f7150s.z();
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            UFlsvW6LF.this.f7150s.z();
            UFlsvW6LF.this.f7151t.removeAllViews();
            com.secret.prettyhezi.ScoreExchange.c cVar = (com.secret.prettyhezi.ScoreExchange.c) f.d(str, com.secret.prettyhezi.ScoreExchange.c.class);
            if (cVar.code != 200) {
                f(cVar.err);
                return;
            }
            com.secret.prettyhezi.ScoreExchange.b[] bVarArr = cVar.data;
            if (bVarArr == null || bVarArr.length == 0) {
                UFlsvW6LF.this.T0();
                return;
            }
            for (com.secret.prettyhezi.ScoreExchange.b bVar : bVarArr) {
                com.secret.prettyhezi.View.u eVar = UFlsvW6LF.this.f7154w == 0 ? new com.secret.prettyhezi.ScoreExchange.e(UFlsvW6LF.this) : new com.secret.prettyhezi.Registration.a(UFlsvW6LF.this);
                eVar.b(bVar);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, eVar.getItemHeight());
                layoutParams.topMargin = g4.i.r(6.0f);
                UFlsvW6LF.this.f7151t.addView(eVar, layoutParams);
            }
        }
    }

    void S0() {
        j.m(com.secret.prettyhezi.Server.v.f7132a + "appeal/c2c/json?t=" + this.f7152u[this.f7154w], new c(this));
    }

    void T0() {
        this.f7151t.addView(g4.d.c(this, 18, -16777216, s0(C0382R.string.no_data), 17), new LinearLayout.LayoutParams(-1, g4.i.r(120.0f)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7149r = C0;
        M(C0, abc.ams("s11"));
        this.f7155x = new com.secret.prettyhezi.View.n(this, this.f7153v, new a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(42.0f));
        layoutParams.topMargin = g4.i.r(1.0f);
        this.f7149r.addView(this.f7155x, layoutParams);
        com.secret.prettyhezi.controls.PullToRefresh.i iVar = new com.secret.prettyhezi.controls.PullToRefresh.i(this);
        this.f7150s = iVar;
        iVar.setScrollBarSize(0);
        this.f7149r.addView(this.f7150s, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout linearLayout = new LinearLayout(this);
        this.f7151t = linearLayout;
        linearLayout.setOrientation(1);
        this.f7151t.setPadding(0, 0, 0, g4.i.r(20.0f));
        this.f7150s.setOnRefreshListener(new b());
        ((ScrollView) this.f7150s.getRefreshableView()).addView(this.f7151t, new LinearLayout.LayoutParams(-1, -2));
        this.f7151t.setGravity(1);
        this.f7151t.setPadding(0, 0, 0, g4.i.r(20.0f));
        this.f7151t.setBackgroundColor(Color.parseColor("#f0f0f0"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f7154w == -1) {
            this.f7155x.setCurrentTab(0);
        } else {
            this.f7150s.p(true, 0L);
        }
    }
}
