package com.secret.prettyhezi;

import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import c.abc;
import com.secret.SideMenu.c;
import com.secret.prettyhezi.Device.CGYegUL;
import com.secret.prettyhezi.Device.Ck9lZ;
import com.secret.prettyhezi.Game.Q65u46F;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.z;
import com.secret.prettyhezi.Upload.BNyrYM5KT;
import com.secret.prettyhezi.Upload.DQhPo8kDB;
import com.secret.prettyhezi.Upload.KLNPK;
import com.secret.prettyhezi.Upload.UwfeFVz0V;
import com.secret.prettyhezi.User.FtP1P;
import com.secret.prettyhezi.User.SwSRMV;
import com.secret.prettyhezi.User.T6FSl1UsM;
import com.secret.prettyhezi.User.TK1dGVzP;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.message.HYYYBI;
import com.secret.prettyhezi.message.d;
import com.secret.prettyhezi.s;
import com.secret.prettyhezi.share.DyOuR;
import com.secret.prettyhezi.share.KQHNLjV;
import java.util.Date;
/* loaded from: classes.dex */
public class q extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    EjNkL f8748b;

    /* renamed from: c  reason: collision with root package name */
    com.secret.SideMenu.c f8749c;

    /* renamed from: d  reason: collision with root package name */
    int f8750d;

    /* renamed from: e  reason: collision with root package name */
    LinearLayout f8751e;

    /* renamed from: f  reason: collision with root package name */
    LinearLayout f8752f;

    /* renamed from: g  reason: collision with root package name */
    LinearLayout f8753g;

    /* renamed from: h  reason: collision with root package name */
    LinearLayout f8754h;

    /* renamed from: i  reason: collision with root package name */
    LinearLayout f8755i;

    /* renamed from: j  reason: collision with root package name */
    LinearLayout f8756j;

    /* renamed from: k  reason: collision with root package name */
    LinearLayout f8757k;

    /* renamed from: l  reason: collision with root package name */
    LinearLayout f8758l;

    /* renamed from: m  reason: collision with root package name */
    LinearLayout f8759m;

    /* renamed from: n  reason: collision with root package name */
    com.secret.prettyhezi.controls.y f8760n;

    /* renamed from: o  reason: collision with root package name */
    TextView f8761o;

    /* renamed from: p  reason: collision with root package name */
    TextView f8762p;

    /* renamed from: q  reason: collision with root package name */
    LinearLayout f8763q;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EjNkL f8764d;

        a(EjNkL ejNkL) {
            this.f8764d = ejNkL;
        }

        @Override // g4.f
        public void a(View view) {
            this.f8764d.M0(Fc3zRvpgB.class);
            q.this.h();
        }
    }

    /* loaded from: classes.dex */
    class b implements c.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EjNkL f8766a;

        /* loaded from: classes.dex */
        class a extends j.e {

            /* renamed from: com.secret.prettyhezi.q$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0139a implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ com.secret.prettyhezi.message.d f8769a;

                RunnableC0139a(com.secret.prettyhezi.message.d dVar) {
                    this.f8769a = dVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    MainApplication.f6715v = this.f8769a.data;
                    q.this.l();
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.j.e
            public void c(String str) {
                com.secret.prettyhezi.message.d dVar = (com.secret.prettyhezi.message.d) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.message.d.class);
                if (dVar.code == 200) {
                    b.this.f8766a.runOnUiThread(new RunnableC0139a(dVar));
                }
            }
        }

        b(EjNkL ejNkL) {
            this.f8766a = ejNkL;
        }

        @Override // com.secret.SideMenu.c.f
        public void a() {
            q.this.e();
            q.this.d();
            q.this.l();
            if (MainApplication.f6711r.r() == null) {
                return;
            }
            com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + "notify/isread/json", true, new a());
            com.secret.prettyhezi.message.c.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {
        d() {
        }

        @Override // g4.f
        protected void a(View view) {
            q.this.f8748b.N0(UwfeFVz0V.class, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {
        e() {
        }

        @Override // g4.f
        protected void a(View view) {
            q.this.f8748b.N0(KLNPK.class, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {
        f() {
        }

        @Override // g4.f
        protected void a(View view) {
            q.this.f8748b.M0(DQhPo8kDB.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends g4.f {
        g() {
        }

        @Override // g4.f
        protected void a(View view) {
            q.this.f8748b.M0(UFlsvW6LF.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends g4.f {
        h() {
        }

        @Override // g4.f
        public void a(View view) {
            q.this.f8748b.M0(DyOuR.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends g4.f {
        i() {
        }

        @Override // g4.f
        public void a(View view) {
            q.this.f8748b.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends g4.f {
        j() {
        }

        @Override // g4.f
        public void a(View view) {
            q.this.f8748b.M0(SwSRMV.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k extends g4.f {
        k() {
        }

        @Override // g4.f
        protected void a(View view) {
            q.this.a();
            q.this.f8748b.M0(Ck9lZ.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends s.g {
        l(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            y yVar = (y) com.secret.prettyhezi.f.d(str, y.class);
            if (yVar.code != 200) {
                f(yVar.err);
                return;
            }
            MainApplication.f6711r.r().level = yVar.data;
            MainApplication.f6711r.x();
            q.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m extends g4.f {
        m() {
        }

        @Override // g4.f
        public void a(View view) {
            q.this.f8748b.M0(KQHNLjV.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n extends g4.f {
        n() {
        }

        @Override // g4.f
        public void a(View view) {
            q.this.f8748b.M0(FtP1P.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o extends g4.f {
        o() {
        }

        @Override // g4.f
        public void a(View view) {
            q.this.f8748b.M0(TK1dGVzP.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p extends g4.f {
        p() {
        }

        @Override // g4.f
        public void a(View view) {
            q.this.f8748b.M0(T6FSl1UsM.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.secret.prettyhezi.q$q  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0140q extends g4.f {
        C0140q() {
        }

        @Override // g4.f
        protected void a(View view) {
            q.this.a();
            q.this.f8748b.M0(CGYegUL.class);
        }
    }

    /* loaded from: classes.dex */
    class r extends g4.f {
        r() {
        }

        @Override // g4.f
        public void a(View view) {
        }
    }

    /* loaded from: classes.dex */
    class s extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EjNkL f8787d;

        /* loaded from: classes.dex */
        class a extends s.g {
            a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                z zVar = (z) com.secret.prettyhezi.f.d(str, z.class);
                if (zVar.code != 200) {
                    f(zVar.err);
                    return;
                }
                a0 r5 = MainApplication.f6711r.r();
                r5.upload = true;
                r5.is_up = false;
                MainApplication.f6711r.A(r5);
                this.f8825a.M0(BNyrYM5KT.class);
                q.this.h();
            }
        }

        s(EjNkL ejNkL) {
            this.f8787d = ejNkL;
        }

        @Override // g4.f
        public void a(View view) {
            a0 r5 = MainApplication.f6711r.r();
            if (r5.upload) {
                this.f8787d.M0(BNyrYM5KT.class);
                q.this.h();
            } else if (r5.is_up) {
                this.f8787d.I0();
                com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + "/user/upuser/json", true, new a(this.f8787d));
            }
        }
    }

    /* loaded from: classes.dex */
    class t extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EjNkL f8790d;

        t(EjNkL ejNkL) {
            this.f8790d = ejNkL;
        }

        @Override // g4.f
        public void a(View view) {
            if (MainApplication.f6711r.r() == null) {
                this.f8790d.M0(TK1dGVzP.class);
                return;
            }
            this.f8790d.M0(QQfREcfuV.class);
            q.this.h();
        }
    }

    /* loaded from: classes.dex */
    class u extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EjNkL f8792d;

        u(EjNkL ejNkL) {
            this.f8792d = ejNkL;
        }

        @Override // g4.f
        public void a(View view) {
            EjNkL ejNkL;
            Class cls;
            if (MainApplication.f6711r.r() == null) {
                ejNkL = this.f8792d;
                cls = A0TdcT.class;
            } else {
                ejNkL = this.f8792d;
                cls = HYYYBI.class;
            }
            ejNkL.M0(cls);
            q.this.h();
        }
    }

    /* loaded from: classes.dex */
    class v extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EjNkL f8794d;

        v(EjNkL ejNkL) {
            this.f8794d = ejNkL;
        }

        @Override // g4.f
        public void a(View view) {
            if (!MainApplication.f6711r.r().isa) {
                this.f8794d.z("正在开发中");
            } else if (this.f8794d.X()) {
            } else {
                this.f8794d.M0(Q65u46F.class);
            }
        }
    }

    /* loaded from: classes.dex */
    class w extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EjNkL f8796d;

        w(EjNkL ejNkL) {
            this.f8796d = ejNkL;
        }

        @Override // g4.f
        public void a(View view) {
            this.f8796d.M0(KQHNLjV.class);
        }
    }

    /* loaded from: classes.dex */
    class x extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EjNkL f8798d;

        x(EjNkL ejNkL) {
            this.f8798d = ejNkL;
        }

        @Override // g4.f
        public void a(View view) {
            this.f8798d.M0(BlGCvC4F.class);
            q.this.h();
        }
    }

    /* loaded from: classes.dex */
    static class y extends com.secret.prettyhezi.Server.w {
        public a0.f data;

        y() {
        }
    }

    public q(EjNkL ejNkL) {
        super(ejNkL);
        this.f8751e = null;
        this.f8752f = null;
        this.f8753g = null;
        this.f8754h = null;
        this.f8755i = null;
        this.f8756j = null;
        this.f8757k = null;
        this.f8758l = null;
        this.f8759m = null;
        this.f8760n = null;
        this.f8761o = null;
        this.f8762p = null;
        this.f8748b = ejNkL;
        this.f8750d = g4.i.r(290.0f);
        com.secret.SideMenu.c cVar = new com.secret.SideMenu.c(ejNkL);
        this.f8749c = cVar;
        cVar.setMode(0);
        this.f8749c.setTouchModeAbove(1);
        this.f8749c.setTouchModeBehind(1);
        this.f8749c.setShadowWidth(0);
        this.f8749c.setBehindOffset(ejNkL.o().x - this.f8750d);
        this.f8749c.setFadeDegree(0.35f);
        this.f8749c.e(ejNkL, 1);
        this.f8749c.setMenu(this);
        setBackgroundColor(-1);
        setOrientation(1);
        setGravity(1);
        setOnClickListener(new r());
        LinearLayout linearLayout = new LinearLayout(ejNkL);
        this.f8751e = linearLayout;
        linearLayout.setOrientation(0);
        this.f8751e.setBackgroundColor(Color.parseColor("#171616"));
        this.f8751e.setGravity(17);
        addView(this.f8751e, new LinearLayout.LayoutParams(-1, -2));
        RelativeLayout relativeLayout = new RelativeLayout(ejNkL);
        addView(relativeLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        relativeLayout.setBackgroundColor(Color.parseColor("#e1e1e1"));
        ScrollView scrollView = new ScrollView(ejNkL);
        scrollView.setVerticalScrollBarEnabled(false);
        relativeLayout.addView(scrollView, new RelativeLayout.LayoutParams(-1, -1));
        View view = new View(ejNkL);
        view.setBackgroundResource(C0382R.drawable.ic_shadow);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(13.0f), -1);
        layoutParams.addRule(11, -1);
        relativeLayout.addView(view, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(ejNkL);
        this.f8763q = linearLayout2;
        linearLayout2.setPadding(0, g4.i.r(0.0f), 0, 0);
        scrollView.addView(this.f8763q, new FrameLayout.LayoutParams(-1, -2));
        this.f8763q.setOrientation(1);
        com.secret.prettyhezi.r rVar = new com.secret.prettyhezi.r(ejNkL, this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.bottomMargin = g4.i.r(10.0f);
        this.f8763q.addView(rVar, layoutParams2);
        LinearLayout f6 = f(this.f8763q, C0382R.drawable.ic_my_downloads, g(C0382R.string.my_uploads));
        this.f8754h = f6;
        f6.getChildAt(0).setRotation(90.0f);
        this.f8754h.setOnClickListener(new s(ejNkL));
        f(this.f8763q, C0382R.drawable.ic_my_downloads, g(C0382R.string.Downloads)).setOnClickListener(new t(ejNkL));
        this.f8759m = f(this.f8763q, C0382R.drawable.ic_feedback, g(C0382R.string.BulletinAndSuggest));
        this.f8760n = new com.secret.prettyhezi.controls.y(ejNkL);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(24.0f), g4.i.r(20.0f));
        layoutParams3.leftMargin = g4.i.r(4.0f);
        this.f8759m.addView(this.f8760n, layoutParams3);
        this.f8759m.setOnClickListener(new u(ejNkL));
        LinearLayout f7 = f(this.f8763q, C0382R.drawable.ic_my_application, "金币游戏");
        f7.setOnClickListener(new v(ejNkL));
        if (MainApplication.f6711r.r().isa) {
            ((TextView) f7.getChildAt(1)).setTextColor(-65536);
        }
        f(this.f8763q, C0382R.drawable.ic_share, g(C0382R.string.ShareToFriends)).setOnClickListener(new w(ejNkL));
        f(this.f8763q, C0382R.drawable.ic_help, g(C0382R.string.FAQ)).setOnClickListener(new x(ejNkL));
        f(this.f8763q, C0382R.drawable.ic_settings, g(C0382R.string.Settings)).setOnClickListener(new a(ejNkL));
        j();
        this.f8749c.setOnOpenListener(new b(ejNkL));
    }

    private void k() {
        this.f8751e.removeAllViews();
        a0 r5 = MainApplication.f6711r.r();
        if (r5 == null) {
            this.f8751e.setOrientation(0);
            TextView b6 = g4.d.b(this.f8748b, 16.0f, Color.parseColor("#b9b9b9"), g(C0382R.string.sign_in));
            b6.setGravity(17);
            b6.setBackground(g4.i.d(g4.i.c(Color.parseColor("#171616"), 5.0f, Color.parseColor("#717070"), 0.5f), g4.i.c(Color.parseColor("#3d3d3d"), 5.0f, Color.parseColor("#717070"), 0.5f)));
            TextView b7 = g4.d.b(this.f8748b, 16.0f, Color.parseColor("#171616"), g(C0382R.string.sign_up));
            b7.setBackground(g4.i.d(g4.i.c(Color.parseColor("#c6c6c6"), 5.0f, Color.parseColor("#717070"), 0.5f), g4.i.c(Color.parseColor("#818181"), 5.0f, Color.parseColor("#717070"), 0.5f)));
            b7.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(96.0f), g4.i.r(40.0f));
            int r6 = g4.i.r(13.0f);
            layoutParams.bottomMargin = r6;
            layoutParams.topMargin = r6;
            this.f8751e.addView(b6, layoutParams);
            b6.setOnClickListener(new o());
            if (MainApplication.f6711r.c()) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(96.0f), g4.i.r(40.0f));
                layoutParams2.leftMargin = g4.i.r(16.0f);
                this.f8751e.addView(b7, layoutParams2);
                b7.setOnClickListener(new p());
            }
            this.f8751e.setOnClickListener(null);
            return;
        }
        this.f8751e.setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(this.f8748b);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.f8751e.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(56.0f)));
        com.secret.prettyhezi.View.d dVar = new com.secret.prettyhezi.View.d(this.f8748b);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(40.0f), g4.i.r(40.0f));
        layoutParams3.leftMargin = g4.i.r(15.0f);
        layoutParams3.rightMargin = g4.i.r(12.0f);
        linearLayout.addView(dVar, layoutParams3);
        linearLayout.addView(g4.d.b(this.f8748b, 16.0f, Color.parseColor("#9a9a9a"), MainApplication.f6711r.r().nickname), new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView c6 = g4.d.c(this.f8748b, 12, -16777216, "APK备份&分享", 17);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(g4.i.r(90.0f), g4.i.r(32.0f));
        layoutParams4.rightMargin = g4.i.r(12.0f);
        linearLayout.addView(c6, layoutParams4);
        c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#fcfcfc"), 5.0f), g4.i.b(Color.parseColor("#8c8c8c"), 5.0f)));
        c6.setOnClickListener(new m());
        linearLayout.setOnClickListener(new n());
        LinearLayout linearLayout2 = new LinearLayout(this.f8748b);
        this.f8752f = linearLayout2;
        linearLayout2.setOrientation(0);
        this.f8752f.setGravity(16);
        this.f8752f.setPadding(g4.i.r(15.0f), g4.i.r(0.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        this.f8751e.addView(this.f8752f, new LinearLayout.LayoutParams(-1, -2));
        n();
        if (r5.grade > 0) {
            LinearLayout linearLayout3 = new LinearLayout(this.f8748b);
            this.f8753g = linearLayout3;
            linearLayout3.setOrientation(0);
            this.f8753g.setGravity(16);
            this.f8753g.setBackground(g4.i.d(g4.i.b(Color.parseColor("#fcfcfc"), 5.0f), g4.i.b(Color.parseColor("#8c8c8c"), 5.0f)));
            this.f8753g.setPadding(g4.i.r(5.0f), g4.i.r(5.0f), g4.i.r(5.0f), g4.i.r(5.0f));
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams5.leftMargin = g4.i.r(15.0f);
            layoutParams5.rightMargin = g4.i.r(12.0f);
            layoutParams5.topMargin = g4.i.r(4.0f);
            layoutParams5.bottomMargin = g4.i.r(8.0f);
            this.f8751e.addView(this.f8753g, layoutParams5);
            m();
        }
    }

    public void a() {
        this.f8749c.i();
    }

    public boolean b() {
        return this.f8749c.g();
    }

    public void c() {
        this.f8749c.k();
    }

    public void d() {
        TextView textView = this.f8762p;
        if (textView != null) {
            removeView(textView);
            this.f8762p = null;
        }
        a0 r5 = MainApplication.f6711r.r();
        if (r5 == null || !r5.HasForgetBindDevice()) {
            return;
        }
        this.f8762p = g4.d.c(this.f8748b, 14, -65536, "你已挂失绑定设备\n若非本人操作，请取消", 17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(50.0f));
        this.f8762p.setBackgroundColor(-1);
        addView(this.f8762p, 1, layoutParams);
        this.f8762p.setOnClickListener(new C0140q());
    }

    public void e() {
        String str;
        TextView textView = this.f8761o;
        if (textView != null) {
            removeView(textView);
            this.f8761o = null;
        }
        a0 r5 = MainApplication.f6711r.r();
        if (r5 == null || !r5.HasForgetExchangePassword()) {
            return;
        }
        if (r5.IsTimeToResetExchangePassword()) {
            str = "你已挂失支付密码，\n现在可以重置";
        } else {
            Date date = new Date(r5.fp.created_at * 1000);
            str = "你已挂失支付密码,\n" + String.format("%02d月%02d日%02d时%02d分", Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes())) + "后可以重置";
        }
        this.f8761o = g4.d.c(this.f8748b, 14, -65536, str, 17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(50.0f));
        this.f8761o.setBackgroundColor(-1);
        addView(this.f8761o, 1, layoutParams);
        this.f8761o.setOnClickListener(new k());
    }

    public LinearLayout f(LinearLayout linearLayout, int i6, String str) {
        LinearLayout linearLayout2 = new LinearLayout(this.f8748b);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setBackground(g4.i.f(0, Color.parseColor("#a4a4a4")));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, g4.i.r(42.0f)));
        com.secret.prettyhezi.controls.z zVar = new com.secret.prettyhezi.controls.z(this.f8748b, i6);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(24.0f), g4.i.r(22.5f));
        layoutParams.leftMargin = g4.i.r(21.0f);
        layoutParams.rightMargin = g4.i.r(16.0f);
        linearLayout2.addView(zVar, layoutParams);
        linearLayout2.addView(g4.d.b(this.f8748b, 16.0f, Color.parseColor("#212121"), str), new LinearLayout.LayoutParams(-2, -2));
        return linearLayout2;
    }

    String g(int i6) {
        return this.f8748b.s0(i6);
    }

    void h() {
        postDelayed(new c(), 200L);
    }

    public void i() {
        if (MainApplication.f6711r.r().grade == 0) {
            return;
        }
        com.secret.prettyhezi.j.m(com.secret.prettyhezi.Server.v.f7132a + "user/level/json", new l(this.f8748b));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0087, code lost:
        if (r7 == r4) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j() {
        boolean z5;
        k();
        a0 r5 = MainApplication.f6711r.r();
        boolean z6 = false;
        TextView textView = (TextView) this.f8759m.getChildAt(1);
        if (r5 != null) {
            textView.setText(g(C0382R.string.BulletinAndMessage));
            d.a aVar = MainApplication.f6715v;
            if (aVar != null) {
                this.f8760n.b(aVar.GetTotalCount());
            }
        } else {
            textView.setText(g(C0382R.string.BulletinAndSuggest));
            this.f8760n.b(0);
        }
        if (r5 != null) {
            if (r5.upload) {
                ((TextView) this.f8754h.getChildAt(1)).setText(g(C0382R.string.my_uploads));
                this.f8754h.setVisibility(0);
            } else {
                if (r5.is_up) {
                    int d6 = g4.g.a().d("lastShowAskUploadTime", 0);
                    int currentTimeMillis = (int) (((System.currentTimeMillis() / 1000) / 3600) / 24);
                    if (currentTimeMillis - d6 >= 30) {
                        g4.g.a().n("lastShowAskUploadTime", currentTimeMillis);
                    }
                    z5 = true;
                    if (z5) {
                        this.f8754h.setVisibility(0);
                        TextView textView2 = (TextView) this.f8754h.getChildAt(1);
                        textView2.setText("申请上传");
                        textView2.setTextColor(-65536);
                    }
                }
                z5 = false;
                if (z5) {
                }
            }
            if (Fc3zRvpgB.f6210z && r5 != null) {
                z6 = true;
            }
            if (z6) {
                return;
            }
            if (r5.mas && this.f8756j == null) {
                LinearLayout f6 = f(this.f8763q, C0382R.drawable.ic_examine, abc.ams("s0"));
                this.f8756j = f6;
                f6.setOnClickListener(new d());
            }
            if (r5.auditor && this.f8755i == null) {
                LinearLayout f7 = f(this.f8763q, C0382R.drawable.ic_examine, abc.ams("s1"));
                this.f8755i = f7;
                f7.setOnClickListener(new e());
            }
            if (r5.rer && this.f8757k == null) {
                LinearLayout f8 = f(this.f8763q, C0382R.drawable.ic_examine, abc.ams("s2"));
                this.f8757k = f8;
                f8.setOnClickListener(new f());
            }
            if (r5.isb && this.f8758l == null) {
                LinearLayout f9 = f(this.f8763q, C0382R.drawable.ic_examine, abc.ams("s3"));
                this.f8758l = f9;
                f9.setOnClickListener(new g());
                return;
            }
            return;
        }
        this.f8754h.setVisibility(8);
        if (Fc3zRvpgB.f6210z) {
            z6 = true;
        }
        if (z6) {
        }
    }

    public void l() {
        int i6 = com.secret.prettyhezi.Server.r.GetNoticeVersion() > g4.g.a().d(com.secret.prettyhezi.Server.r.keyCheckedNoticeVersion, 0) ? 1 : 0;
        d.a aVar = MainApplication.f6715v;
        if (aVar != null) {
            i6 += aVar.GetTotalCount();
        }
        this.f8760n.b(i6 + com.secret.prettyhezi.message.c.e());
    }

    void m() {
        if (MainApplication.f6711r.r().grade == 0) {
            return;
        }
        this.f8753g.removeAllViews();
        a0 r5 = MainApplication.f6711r.r();
        if (r5 == null || r5.level == null) {
            this.f8753g.setVisibility(8);
            return;
        }
        this.f8753g.addView(g4.d.b(this.f8748b, 14.0f, Color.parseColor("#333333"), "经验值:" + r5.level.exp + " 等级:" + r5.level.level + " >"), new LinearLayout.LayoutParams(-2, -2));
        this.f8753g.setOnClickListener(new j());
    }

    public void n() {
        a0.e eVar;
        this.f8752f.removeAllViews();
        if (MainApplication.f6711r.r().grade <= 0) {
            this.f8752f.addView(g4.d.b(this.f8748b, 14.0f, -65536, "非正式会员只能使用部分功能"), new LinearLayout.LayoutParams(-2, -2));
            this.f8752f.setOnClickListener(new i());
            return;
        }
        float f6 = 14;
        this.f8752f.addView(g4.d.b(this.f8748b, f6, Color.parseColor("#9a9a9a"), this.f8748b.s0(C0382R.string.Score) + ": "), new LinearLayout.LayoutParams(-2, -2));
        double d6 = MainApplication.f6711r.r().integral.last;
        StringBuilder sb = new StringBuilder();
        sb.append(d6 < 0.0d ? "-" : k5.d.ANY_NON_NULL_MARKER);
        sb.append(g4.i.F(Math.abs(d6)));
        String sb2 = sb.toString();
        this.f8752f.addView(g4.d.b(this.f8748b, f6, Color.parseColor("#9a9a9a"), g4.i.F(eVar.all) + "(" + sb2 + ")"), new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.f8752f.setOnClickListener(new h());
        TextView c6 = g4.d.c(this.f8748b, 16, Color.parseColor("#000000"), this.f8748b.s0(C0382R.string.ScoreAndAccess), 17);
        this.f8752f.addView(c6, new LinearLayout.LayoutParams(g4.i.r(110.0f), g4.i.r(32.0f)));
        c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#fcfcfc"), 5.0f), g4.i.b(Color.parseColor("#8c8c8c"), 5.0f)));
    }
}
