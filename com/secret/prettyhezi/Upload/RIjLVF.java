package com.secret.prettyhezi.Upload;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Pc3DTln6R;
import com.secret.prettyhezi.Server.d0;
import com.secret.prettyhezi.Server.e0;
import com.secret.prettyhezi.Upload.o;
import com.secret.prettyhezi.Video.MSqCZ2mQ;
import com.secret.prettyhezi.Video.NRxYacSEB;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class RIjLVF extends ZZcINlcxH {

    /* renamed from: q  reason: collision with root package name */
    int f7378q;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7379r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f7380s;

    /* renamed from: t  reason: collision with root package name */
    o.a f7381t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d0 f7382d;

        a(d0 d0Var) {
            this.f7382d = d0Var;
        }

        @Override // g4.f
        protected void a(View view) {
            d0 d0Var = this.f7382d;
            e0 e0Var = d0Var.f7110me;
            if (e0Var != null) {
                RIjLVF.this.Z0(e0Var);
                return;
            }
            RIjLVF rIjLVF = RIjLVF.this;
            if (rIjLVF.f7378q == 2) {
                rIjLVF.D(rIjLVF.s0(C0382R.string.NoPlayHotResource), new ZZcINlcxH.q(), false);
            } else {
                Pc3DTln6R.R0(rIjLVF, d0Var.ps, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ZZcINlcxH.q {
        b() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            o.a aVar = RIjLVF.this.f7381t;
            if (aVar != null) {
                aVar.b();
            }
            RIjLVF.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {
        c() {
        }

        @Override // g4.f
        protected void a(View view) {
            RIjLVF.this.V0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                RIjLVF.this.X0();
            }
        }

        d() {
        }

        @Override // g4.f
        protected void a(View view) {
            RIjLVF rIjLVF = RIjLVF.this;
            rIjLVF.C("举报将会扣除20积分作为保证金，举报被通过，返还保证金并奖励10积分，举报不通过，不会返还保证金", new String[]{rIjLVF.s0(C0382R.string.cancel), RIjLVF.this.s0(C0382R.string.report)}, new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements s.f {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainApplication.f6711r.r().integral.all -= 20.0d;
                MainApplication.f6711r.x();
                EjNkL.N.f6165r.j();
                RIjLVF.this.finish();
            }
        }

        e() {
        }

        @Override // com.secret.prettyhezi.s.f
        public void a(String str) {
            RIjLVF.this.f7379r.postDelayed(new a(), 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f implements Serializable {
        int[] ids;

        /* renamed from: t  reason: collision with root package name */
        int f7390t;

        f(int i6, int i7, int i8) {
            this.f7390t = i6;
            this.ids = new int[]{i7, i8};
        }
    }

    void R0() {
        U(this.f7380s, "视频内容不重复", 30, 30).setOnClickListener(new c());
        U(this.f7380s, "举报重复视频", 40, 30).setOnClickListener(new d());
    }

    void S0() {
        LinearLayout T0 = T0();
        T0.setGravity(17);
        int r5 = (o().x - g4.i.r(10.0f)) / 2;
        o.a aVar = this.f7381t;
        com.secret.prettyhezi.Server.l lVar = aVar.f7507a.co;
        com.secret.prettyhezi.Server.l lVar2 = aVar.f7508b.co;
        int max = Math.max((lVar.f7127h * r5) / lVar.f7129w, (lVar2.f7127h * r5) / lVar2.f7129w);
        T0.addView(W0(this.f7381t.f7507a, r5, max), 0, new LinearLayout.LayoutParams(0, max, 1.0f));
        T0.addView(W0(this.f7381t.f7508b, r5, max), new LinearLayout.LayoutParams(0, max, 1.0f));
    }

    LinearLayout T0() {
        LinearLayout linearLayout = new LinearLayout(this);
        this.f7380s.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        View view = new View(this);
        view.setBackgroundColor(Color.parseColor("#888888"));
        linearLayout.addView(view, new LinearLayout.LayoutParams(g4.i.r(1.5f), -1));
        return linearLayout;
    }

    void U0() {
        String Y0 = Y0(this.f7381t.f7507a);
        String Y02 = Y0(this.f7381t.f7508b);
        if (Y0.isEmpty() && Y02.isEmpty()) {
            return;
        }
        LinearLayout T0 = T0();
        TextView b6 = g4.d.b(this, 14.0f, -16777216, Y0);
        b6.setPadding(g4.i.r(6.0f), g4.i.r(8.0f), g4.i.r(6.0f), g4.i.r(8.0f));
        TextView b7 = g4.d.b(this, 14.0f, -16777216, Y02);
        b7.setPadding(g4.i.r(6.0f), g4.i.r(8.0f), g4.i.r(6.0f), g4.i.r(8.0f));
        T0.addView(b6, 0, new LinearLayout.LayoutParams(0, -2, 1.0f));
        T0.addView(b7, new LinearLayout.LayoutParams(0, -2, 1.0f));
    }

    void V0() {
        B("取消举报此视频?", new b(), false);
    }

    RelativeLayout W0(d0 d0Var, int i6, int i7) {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        com.secret.prettyhezi.controls.q qVar = new com.secret.prettyhezi.controls.q(this, d0Var.co.f7128p, i6, i7);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        relativeLayout.addView(qVar, layoutParams);
        com.secret.prettyhezi.controls.z zVar = new com.secret.prettyhezi.controls.z(this, C0382R.drawable.play_normal);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(g4.i.r(40.0f), g4.i.r(40.0f));
        layoutParams2.addRule(13, -1);
        relativeLayout.addView(zVar, layoutParams2);
        a aVar = new a(d0Var);
        zVar.setOnClickListener(aVar);
        qVar.setOnClickListener(aVar);
        return relativeLayout;
    }

    void X0() {
        int i6 = this.f7378q;
        o.a aVar = this.f7381t;
        com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "repeatedly/new/json", new f(i6, aVar.f7507a.id, aVar.f7508b.id), true, new s.e(this, new e()));
    }

    String Y0(d0 d0Var) {
        String str;
        String str2 = d0Var.na;
        String str3 = (str2 == null || str2.isEmpty() || ((str = d0Var.mt) != null && str.contains(d0Var.na))) ? HttpUrl.FRAGMENT_ENCODE_SET : d0Var.na;
        String str4 = d0Var.mt;
        if (str4 == null || str4.isEmpty()) {
            return str3;
        }
        if (str3.isEmpty()) {
            return d0Var.mt;
        }
        return str3 + "\\n" + d0Var.mt;
    }

    public void Z0(e0 e0Var) {
        if (!g4.g.a().b("keyVideoAutoLandscape") || e0Var.f7129w <= e0Var.f7127h) {
            MSqCZ2mQ.T0(this, e0Var.f7128p, this.f7378q, 0, 0L);
        } else {
            NRxYacSEB.z1(this, e0Var.f7128p, this.f7378q, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        o.a aVar;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int i6 = extras.getInt("type");
            this.f7378q = i6;
            if (i6 == 2) {
                aVar = o.f7505a;
            } else if (i6 == 5) {
                aVar = o.f7506b;
            }
            this.f7381t = aVar;
        }
        LinearLayout C0 = C0();
        this.f7379r = C0;
        M(C0, "举报重复视频");
        LinearLayout e6 = e(this.f7379r);
        this.f7380s = e6;
        e6.setPadding(0, g4.i.r(12.0f), 0, g4.i.r(30.0f));
        S0();
        U0();
        R0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH
    public void v0() {
        V0();
    }
}
