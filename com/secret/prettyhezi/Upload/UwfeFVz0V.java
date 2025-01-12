package com.secret.prettyhezi.Upload;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.abc;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Server.s;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.View.n;
/* loaded from: classes.dex */
public class UwfeFVz0V extends UoWMF implements x0.b {

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f7392s;

    /* renamed from: w  reason: collision with root package name */
    public x0.a f7396w;

    /* renamed from: y  reason: collision with root package name */
    int f7398y;

    /* renamed from: r  reason: collision with root package name */
    boolean f7391r = false;

    /* renamed from: t  reason: collision with root package name */
    int[] f7393t = {1, 6, 2, 5};

    /* renamed from: u  reason: collision with root package name */
    int[] f7394u = {C0382R.string.Image, C0382R.string.Gallery, C0382R.string.ShortVideo, C0382R.string.LongVideo};

    /* renamed from: v  reason: collision with root package name */
    int f7395v = -1;

    /* renamed from: x  reason: collision with root package name */
    com.secret.prettyhezi.Upload.b f7397x = null;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            UwfeFVz0V.this.T0();
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        protected void a(View view) {
            UwfeFVz0V.this.M0(K318k2KH.class);
        }
    }

    /* loaded from: classes.dex */
    class c implements n.b {
        c() {
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void a(int i6) {
            UwfeFVz0V uwfeFVz0V = UwfeFVz0V.this;
            uwfeFVz0V.f7395v = i6;
            com.secret.prettyhezi.Upload.b bVar = uwfeFVz0V.f7397x;
            if (bVar != null) {
                uwfeFVz0V.f7396w.removeView(bVar);
            }
            UwfeFVz0V uwfeFVz0V2 = UwfeFVz0V.this;
            int i7 = uwfeFVz0V2.f7393t[i6];
            if (i7 != 3 && i7 != 7) {
                UwfeFVz0V uwfeFVz0V3 = UwfeFVz0V.this;
                uwfeFVz0V2.f7397x = new com.secret.prettyhezi.Upload.b(uwfeFVz0V3, uwfeFVz0V3.f7393t[i6], uwfeFVz0V3.f7391r);
                UwfeFVz0V uwfeFVz0V4 = UwfeFVz0V.this;
                uwfeFVz0V4.f7396w.addView(uwfeFVz0V4.f7397x, new LinearLayout.LayoutParams(-1, -2));
            }
            UwfeFVz0V.this.T0();
        }

        @Override // com.secret.prettyhezi.View.n.b
        public void b(int i6) {
        }
    }

    public void S0() {
        com.secret.prettyhezi.Upload.b bVar = this.f7397x;
        if (bVar != null) {
            bVar.V();
        }
    }

    void T0() {
        s.a GetItem = com.secret.prettyhezi.Server.s.GetItem(p.a(this.f7393t[this.f7395v]));
        if (GetItem != null) {
            com.secret.prettyhezi.controls.x E = E(GetItem.name, GetItem.content, null, false);
            E.b();
            E.f8479f.setGravity(3);
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
        if (this.f7398y == i6) {
            return;
        }
        this.f7398y = i6;
        com.secret.prettyhezi.Upload.b bVar = this.f7397x;
        if (bVar != null) {
            bVar.D(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7391r = extras.getInt("id") > 0;
        }
        LinearLayout C0 = C0();
        this.f7392s = C0;
        RelativeLayout N = N(C0, abc.ams(this.f7391r ? "s0" : "s5"), "规则", new a());
        if (!this.f7391r) {
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
        com.secret.prettyhezi.View.n nVar = new com.secret.prettyhezi.View.n(this, this.f7394u, new c());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, g4.i.r(42.0f));
        layoutParams2.topMargin = g4.i.r(1.0f);
        this.f7392s.addView(nVar, layoutParams2);
        x0.a aVar = new x0.a(this);
        this.f7396w = aVar;
        aVar.setScrollViewCallbacks(this);
        this.f7392s.addView(this.f7396w, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        nVar.setCurrentTab(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.secret.prettyhezi.Upload.b bVar = this.f7397x;
        if (bVar != null) {
            bVar.b();
        }
    }
}
