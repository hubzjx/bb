package com.secret.prettyhezi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.d0;
import com.secret.prettyhezi.Server.e0;
import e4.c;
/* loaded from: classes.dex */
public class E3cZm7B extends LQS1CVD {
    LinearLayout P;
    e4.c Q;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f6157d;

        a(int i6) {
            this.f6157d = i6;
        }

        @Override // g4.f
        protected void a(View view) {
            E3cZm7B.this.P1(this.f6157d);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f6159d;

        b(int i6) {
            this.f6159d = i6;
        }

        @Override // g4.f
        public void a(View view) {
            E3cZm7B.this.M1(this.f6159d);
        }
    }

    /* loaded from: classes.dex */
    class c extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f6161d;

        c(int i6) {
            this.f6161d = i6;
        }

        @Override // g4.f
        public void a(View view) {
            E3cZm7B.this.O1(this.f6161d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {
        d() {
        }

        @Override // g4.f
        public void a(View view) {
            if (!E3cZm7B.this.D1()) {
                E3cZm7B e3cZm7B = E3cZm7B.this;
                e3cZm7B.F("兑换了年或永久热门视频权限即可获取下载权限", null, e3cZm7B.s0(C0382R.string.IKnow), null, true);
                return;
            }
            String A1 = E3cZm7B.this.A1();
            if (A1 != null) {
                E3cZm7B.this.Y0(A1);
            }
            com.secret.prettyhezi.Cache.c l6 = MainApplication.f6711r.l();
            E3cZm7B e3cZm7B2 = E3cZm7B.this;
            l6.b(e3cZm7B2.f8110r, e3cZm7B2.N);
            E3cZm7B e3cZm7B3 = E3cZm7B.this;
            e3cZm7B3.Y0(e3cZm7B3.s0(C0382R.string.downloading));
        }
    }

    @Override // com.secret.prettyhezi.LQS1CVD
    public boolean C1() {
        return this.N.vs.length == 1;
    }

    @Override // com.secret.prettyhezi.LQS1CVD
    public boolean D1() {
        a0 r5 = MainApplication.f6711r.r();
        return r5.f7102p1 || r5.py1 > 0;
    }

    @Override // com.secret.prettyhezi.LQS1CVD
    boolean E1() {
        d0 d0Var = this.N;
        if (d0Var.fc >= 999 || d0Var.dur >= 600) {
            return MainApplication.f6711r.r().permission.f7107p1;
        }
        return true;
    }

    @Override // com.secret.prettyhezi.LQS1CVD
    public void G1() {
        P1(0);
    }

    @Override // com.secret.prettyhezi.LQS1CVD
    public void H1() {
        String A1;
        if (!E1()) {
            y1();
        } else if (this.N.vs == null) {
            o1();
        } else if (!z1() || (A1 = A1()) == null) {
            J1();
        } else {
            Y0(A1);
        }
    }

    @Override // com.secret.prettyhezi.LQS1CVD
    public void I1() {
        super.I1();
        this.P.removeAllViews();
        this.Q = null;
        e0[] e0VarArr = this.N.vs;
        if (e0VarArr != null && e0VarArr.length > 1) {
            e4.c cVar = new e4.c(this);
            cVar.setPadding(0, g4.i.r(8.0f), g4.i.r(6.0f), 0);
            this.P.addView(cVar, new LinearLayout.LayoutParams(-1, -2));
            int i6 = 0;
            while (i6 < this.N.vs.length) {
                int i7 = i6 + 1;
                TextView c6 = g4.d.c(this, 12, Color.parseColor("#000000"), String.format(s0(C0382R.string.EpisodeFormat), Integer.valueOf(i7)), 17);
                c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#aaaa00"), 6.0f), g4.i.b(Color.parseColor("#ffff00"), 6.0f)));
                c6.setMinWidth(g4.i.r(60.0f));
                c6.setPadding(g4.i.r(8.0f), 0, g4.i.r(8.0f), 0);
                c.a aVar = new c.a(-2, g4.i.r(32.0f));
                ((ViewGroup.MarginLayoutParams) aVar).leftMargin = g4.i.r(8.0f);
                ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = g4.i.r(8.0f);
                cVar.addView(c6, aVar);
                c6.setOnClickListener(new a(i6));
                i6 = i7;
            }
        }
        d0.a[] aVarArr = this.N.as;
        if (aVarArr != null && aVarArr.length > 0) {
            int i8 = 0;
            while (true) {
                d0.a[] aVarArr2 = this.N.as;
                if (i8 >= aVarArr2.length) {
                    break;
                }
                TextView K1 = K1(aVarArr2[i8].na);
                K1.setBackground(g4.i.d(g4.i.c(0, 6.0f, Color.parseColor("#ff0000"), 1.0f), g4.i.c(Color.parseColor("#ffffff"), 6.0f, Color.parseColor("#ff0000"), 1.0f)));
                K1.setOnClickListener(new b(i8));
                i8++;
            }
        }
        d0.a[] aVarArr3 = this.N.tg;
        if (aVarArr3 == null || aVarArr3.length <= 0) {
            return;
        }
        int i9 = 0;
        while (true) {
            d0.a[] aVarArr4 = this.N.tg;
            if (i9 >= aVarArr4.length) {
                return;
            }
            TextView K12 = K1(aVarArr4[i9].na);
            K12.setBackground(g4.i.d(g4.i.c(0, 6.0f, Color.parseColor("#000000"), 1.0f), g4.i.c(Color.parseColor("#ffffff"), 6.0f, Color.parseColor("#000000"), 1.0f)));
            K12.setOnClickListener(new c(i9));
            i9++;
        }
    }

    void J1() {
        Y0(s0(C0382R.string.Download)).setOnClickListener(new d());
    }

    TextView K1(String str) {
        TextView c6 = g4.d.c(this, 12, Color.parseColor("#000000"), str, 17);
        c6.setMinWidth(g4.i.r(60.0f));
        c6.setPadding(g4.i.r(8.0f), 0, g4.i.r(8.0f), 0);
        c.a aVar = new c.a(-2, g4.i.r(32.0f));
        ((ViewGroup.MarginLayoutParams) aVar).leftMargin = g4.i.r(8.0f);
        ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = g4.i.r(8.0f);
        L1().addView(c6, aVar);
        return c6;
    }

    e4.c L1() {
        if (this.Q == null) {
            if (this.P.getChildCount() > 0) {
                W(this.P, Color.parseColor("#cccccc"), 0.5f, 6, 0, 6);
            }
            e4.c cVar = new e4.c(this);
            this.Q = cVar;
            cVar.setPadding(0, g4.i.r(8.0f), g4.i.r(6.0f), 0);
            this.P.addView(this.Q, new LinearLayout.LayoutParams(-1, -2));
        }
        return this.Q;
    }

    void M1(int i6) {
        z("演员: " + this.N.as[i6].na);
    }

    void N1(d0.a aVar, int i6) {
        McNiD.S0(this, aVar.na, "film/json?t=" + i6 + "&id=" + aVar.id + "&page=999", 4);
    }

    void O1(int i6) {
        N1(this.N.tg[i6], 2);
    }

    void P1(int i6) {
        if (E1()) {
            F1(this.N.vs[i6]);
        } else {
            B1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.LQS1CVD, com.secret.prettyhezi.WVGAB1kU
    public void X0() {
        super.X0();
        LinearLayout linearLayout = new LinearLayout(this);
        this.P = linearLayout;
        linearLayout.setOrientation(1);
        this.P.setBackgroundColor(Color.parseColor("#f0f0f0"));
        this.f8115w.addView(this.P, new LinearLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.WVGAB1kU, com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
