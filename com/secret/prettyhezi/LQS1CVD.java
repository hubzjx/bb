package com.secret.prettyhezi;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Server.d0;
import com.secret.prettyhezi.Server.e0;
import com.secret.prettyhezi.Video.MSqCZ2mQ;
import com.secret.prettyhezi.Video.NRxYacSEB;
import com.secret.prettyhezi.View.c0;
import com.secret.prettyhezi.controls.z;
import com.secret.prettyhezi.share.DyOuR;
/* loaded from: classes.dex */
public class LQS1CVD extends WVGAB1kU {
    public d0 N;
    RelativeLayout O;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            LQS1CVD.this.G1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            LQS1CVD.this.B1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            if (MainApplication.f6711r.l().c(LQS1CVD.this)) {
                if (MainApplication.f6711r.r().grade == 0) {
                    com.secret.prettyhezi.User.f.j(LQS1CVD.this);
                    return;
                }
                LQS1CVD lqs1cvd = LQS1CVD.this;
                lqs1cvd.Y0(lqs1cvd.s0(C0382R.string.downloading));
                com.secret.prettyhezi.Cache.c l6 = MainApplication.f6711r.l();
                LQS1CVD lqs1cvd2 = LQS1CVD.this;
                l6.b(lqs1cvd2.f8110r, lqs1cvd2.N);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String A1() {
        int i6;
        com.secret.prettyhezi.Cache.c l6 = MainApplication.f6711r.l();
        if (l6.e(this.f8110r, true, this.f8111s) != null) {
            i6 = C0382R.string.Downloaded;
        } else if (l6.e(this.f8110r, false, this.f8111s) == null) {
            return null;
        } else {
            i6 = C0382R.string.downloading;
        }
        return s0(i6);
    }

    public void B1() {
        DyOuR.S0(C0382R.string.NoPlayHotResource);
    }

    public boolean C1() {
        return this.N.f7110me.downloadUrl().endsWith(".mp4");
    }

    public boolean D1() {
        return true;
    }

    boolean E1() {
        e0 e0Var = this.N.f7110me;
        if (e0Var == null || e0Var.f7128p == null) {
            return MainApplication.f6711r.r().permission.f7107p1;
        }
        return true;
    }

    public void F1(e0 e0Var) {
        if (!g4.g.a().b("keyVideoAutoLandscape") || e0Var.f7129w <= e0Var.f7127h) {
            MSqCZ2mQ.T0(this, e0Var.f7128p, this.f8110r, this.f8111s, 0L);
        } else {
            NRxYacSEB.z1(this, e0Var.f7128p, this.f8110r, this.f8111s, 0L);
        }
    }

    public void G1() {
        e0 e0Var = this.N.f7110me;
        if (e0Var != null) {
            F1(e0Var);
        } else if (MainApplication.f6711r.r().grade != 0) {
            B1();
        } else {
            ZZcINlcxH x02 = x0();
            finish();
            com.secret.prettyhezi.User.f.k(x02, 2);
        }
    }

    public void H1() {
        l1();
        if (!E1()) {
            y1();
        } else if (this.N.f7110me == null) {
            o1();
        } else if (z1()) {
            String A1 = A1();
            if (A1 == null && f4.b.c(this.N.f7110me.f7128p, this)) {
                A1 = s0(C0382R.string.Cached);
            }
            if (A1 != null) {
                Y0(A1);
            } else {
                Y0(s0(C0382R.string.Download)).setOnClickListener(new c());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0026, code lost:
        if (r4 > r0) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void I1() {
        super.v1(this.N);
        this.O.removeAllViews();
        int i6 = o().x;
        int b12 = b1();
        com.secret.prettyhezi.Server.l lVar = this.N.co;
        int i7 = lVar.f7129w;
        int i8 = lVar.f7127h;
        int i9 = (i7 * b12) / i8;
        int i10 = (i8 * i6) / i7;
        if (i10 <= b12) {
            b12 = i10;
        }
        i6 = i9;
        this.O.setLayoutParams(new LinearLayout.LayoutParams(i6, b12));
        com.secret.prettyhezi.controls.r rVar = new com.secret.prettyhezi.controls.r(this, this.N.co.f7128p);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, b12);
        layoutParams.addRule(13, -1);
        this.O.addView(rVar, layoutParams);
        if (this.f8110r == 5) {
            c0 c0Var = new c0(this, this.N.uc);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(10, -1);
            this.O.addView(c0Var, layoutParams2);
        }
        TextView c6 = g4.d.c(this, 12, -1, g4.i.G(this.N.dur), 16);
        c6.setBackgroundColor(Color.parseColor("#55000000"));
        c6.setPadding(g4.i.r(4.0f), g4.i.r(2.0f), g4.i.r(4.0f), g4.i.r(2.0f));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(21, -1);
        layoutParams3.addRule(10, -1);
        this.O.addView(c6, layoutParams3);
        z zVar = new z(this, C0382R.drawable.play_normal);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(g4.i.r(40.0f), g4.i.r(40.0f));
        layoutParams4.addRule(13, -1);
        this.O.addView(zVar, layoutParams4);
        this.O.setOnClickListener(new a());
        H1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.WVGAB1kU
    public void X0() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.O = relativeLayout;
        this.f8115w.addView(relativeLayout, new LinearLayout.LayoutParams(-1, b1()));
    }

    @Override // com.secret.prettyhezi.WVGAB1kU
    protected void h1(String str) {
        u uVar = (u) f.d(str, u.class);
        if (uVar.code != 200) {
            w0(uVar);
            return;
        }
        this.N = uVar.data;
        I1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.WVGAB1kU, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.N != null) {
            H1();
        }
    }

    public void y1() {
        Y0("兑换热门视频权限").setOnClickListener(new b());
    }

    public boolean z1() {
        return D1() && C1();
    }
}
