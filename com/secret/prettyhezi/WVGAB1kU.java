package com.secret.prettyhezi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.Server.d0;
import com.secret.prettyhezi.Server.j;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Upload.JzFuV;
import com.secret.prettyhezi.Upload.RIjLVF;
import com.secret.prettyhezi.Upload.o;
import com.secret.prettyhezi.User.Ticket.Alv5GBDA;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.controls.z;
import com.secret.prettyhezi.s;
import com.secret.prettyhezi.share.DyOuR;
import com.secret.prettyhezi.share.KQHNLjV;
import java.io.Serializable;
import java.util.HashSet;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class WVGAB1kU extends UoWMF {
    TextView A;
    RelativeLayout B;
    com.secret.prettyhezi.View.g C;
    TextView D;
    LinearLayout E;
    TextView F;

    /* renamed from: r  reason: collision with root package name */
    public int f8110r;

    /* renamed from: s  reason: collision with root package name */
    public int f8111s;

    /* renamed from: t  reason: collision with root package name */
    public com.secret.prettyhezi.Server.j f8112t;

    /* renamed from: u  reason: collision with root package name */
    LinearLayout f8113u;

    /* renamed from: v  reason: collision with root package name */
    ScrollView f8114v;

    /* renamed from: w  reason: collision with root package name */
    public LinearLayout f8115w;

    /* renamed from: z  reason: collision with root package name */
    TextView f8118z;

    /* renamed from: x  reason: collision with root package name */
    public TextView f8116x = null;

    /* renamed from: y  reason: collision with root package name */
    public TextView f8117y = null;
    protected com.secret.AD.d G = null;
    LinearLayout H = null;
    TextView I = null;
    protected com.secret.prettyhezi.View.m J = null;
    HashSet K = new HashSet();
    int L = 0;
    o.a M = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            WVGAB1kU wVGAB1kU = WVGAB1kU.this;
            wVGAB1kU.N0(SLUjG.class, wVGAB1kU.f8112t.cl.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            WVGAB1kU.this.m1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends s.g {
        c(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            o oVar = (o) com.secret.prettyhezi.f.d(str, o.class);
            if (oVar.code != 200) {
                f(oVar.err);
                return;
            }
            WVGAB1kU wVGAB1kU = WVGAB1kU.this;
            o.a aVar = oVar.data;
            wVGAB1kU.L = aVar.pages;
            wVGAB1kU.M = aVar;
            wVGAB1kU.u1();
        }
    }

    /* loaded from: classes.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ZZcINlcxH j6 = g4.i.j();
            WVGAB1kU wVGAB1kU = WVGAB1kU.this;
            if (j6 != wVGAB1kU) {
                wVGAB1kU.H.removeView(wVGAB1kU.J);
                WVGAB1kU.this.J = null;
            }
        }
    }

    /* loaded from: classes.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ZZcINlcxH j6 = g4.i.j();
            WVGAB1kU wVGAB1kU = WVGAB1kU.this;
            if (j6 == wVGAB1kU) {
                wVGAB1kU.u1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {
        f() {
        }

        @Override // g4.f
        public void a(View view) {
            Intent intent = new Intent(WVGAB1kU.this, JzFuV.class);
            Bundle bundle = new Bundle();
            bundle.putInt("type", WVGAB1kU.this.f8110r);
            bundle.putInt("id", WVGAB1kU.this.f8111s);
            bundle.putLong("extra", WVGAB1kU.this.f8112t.ct);
            intent.putExtras(bundle);
            WVGAB1kU.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends g4.f {
        g() {
        }

        @Override // g4.f
        public void a(View view) {
            WVGAB1kU.this.M0(KQHNLjV.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                WVGAB1kU.this.finish();
            }
        }

        h() {
        }

        @Override // g4.f
        public void a(View view) {
            WVGAB1kU wVGAB1kU = WVGAB1kU.this;
            o.a aVar = wVGAB1kU.f8110r == 2 ? com.secret.prettyhezi.Upload.o.f7505a : com.secret.prettyhezi.Upload.o.f7506b;
            aVar.a((d0) wVGAB1kU.f8112t);
            if (aVar.f7508b == null) {
                WVGAB1kU wVGAB1kU2 = WVGAB1kU.this;
                wVGAB1kU2.D(wVGAB1kU2.f8110r == 2 ? "请找到另一与此视频重复的短视频并举报" : "请找到另一与此视频重复的长视频并举报", new a(), false);
                return;
            }
            WVGAB1kU.this.f8117y.setVisibility(8);
            WVGAB1kU wVGAB1kU3 = WVGAB1kU.this;
            wVGAB1kU3.O0(RIjLVF.class, 0, wVGAB1kU3.f8110r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends g4.f {
        i() {
        }

        @Override // g4.f
        public void a(View view) {
            WVGAB1kU wVGAB1kU = WVGAB1kU.this;
            D8ZS9RTR.S0(wVGAB1kU, wVGAB1kU.f8111s, com.secret.prettyhezi.g.a(wVGAB1kU.f8110r));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends s.g {
        j(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            if (WVGAB1kU.this.isDestroyed() || WVGAB1kU.this.isFinishing()) {
                return;
            }
            WVGAB1kU.this.h1(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f8130a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.x f8131b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f8132c;

        k(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.controls.x xVar, boolean z5) {
            this.f8130a = zZcINlcxH;
            this.f8131b = xVar;
            this.f8132c = z5;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
        /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        @Override // com.secret.prettyhezi.controls.x.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int i6) {
            ZZcINlcxH zZcINlcxH;
            Class cls;
            if (!this.f8130a.j(this.f8131b)) {
                return;
            }
            if (i6 != 1) {
                if (i6 == 2) {
                    zZcINlcxH = this.f8130a;
                    cls = DyOuR.class;
                }
                if (this.f8132c) {
                    return;
                }
                this.f8130a.finish();
                return;
            }
            zZcINlcxH = this.f8130a;
            cls = Alv5GBDA.class;
            zZcINlcxH.M0(cls);
            if (this.f8132c) {
            }
        }
    }

    /* loaded from: classes.dex */
    class l extends g4.f {
        l() {
        }

        @Override // g4.f
        protected void a(View view) {
            WVGAB1kU.this.j1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m extends ZZcINlcxH.q {

        /* loaded from: classes.dex */
        class a implements a.f {

            /* renamed from: com.secret.prettyhezi.WVGAB1kU$m$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0129a extends s.g {
                C0129a(ZZcINlcxH zZcINlcxH) {
                    super(zZcINlcxH);
                }

                @Override // com.secret.prettyhezi.s.g
                public void g(String str) {
                    MainApplication.f6711r.m().f(WVGAB1kU.this.f8110r);
                    if (WVGAB1kU.this.isDestroyed() || WVGAB1kU.this.isFinishing()) {
                        return;
                    }
                    WVGAB1kU.this.k1(str);
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + WVGAB1kU.this.f1(), new v.g(WVGAB1kU.this.f8111s), true, new C0129a(WVGAB1kU.this));
            }
        }

        m() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            com.secret.prettyhezi.Device.a.b(WVGAB1kU.this, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.x f8137a;

        n(com.secret.prettyhezi.controls.x xVar) {
            this.f8137a = xVar;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            if (WVGAB1kU.this.j(this.f8137a) && i6 == 1) {
                WVGAB1kU.this.startActivity(new Intent(WVGAB1kU.this, DyOuR.class));
                WVGAB1kU.this.finish();
            }
        }
    }

    /* loaded from: classes.dex */
    public class o extends com.secret.prettyhezi.Server.w {
        public a data;

        /* loaded from: classes.dex */
        public class a implements Serializable {
            public com.secret.prettyhezi.Server.d[] items;
            public int pages;

            public a() {
            }
        }

        public o() {
        }
    }

    public static Class Z0(int i6) {
        if (com.secret.prettyhezi.g.c(i6)) {
            return XSQp3A.class;
        }
        if (i6 != 2) {
            if (i6 != 3) {
                if (i6 != 4) {
                    if (i6 != 5) {
                        if (i6 != 7) {
                            return null;
                        }
                        return RcB8ALaRS.class;
                    }
                    return DHwJuV.class;
                }
                return E3cZm7B.class;
            }
            return KUCHO6J.class;
        }
        return LQS1CVD.class;
    }

    public static void r1(ZZcINlcxH zZcINlcxH, String str, boolean z5) {
        com.secret.prettyhezi.controls.x xVar = new com.secret.prettyhezi.controls.x(zZcINlcxH);
        xVar.f(str);
        xVar.d(new String[]{zZcINlcxH.s0(C0382R.string.cancel), "使用权限卡", "开通权限"}, new k(zZcINlcxH, xVar, z5));
        zZcINlcxH.x(xVar, null, false);
    }

    public static void s1(ZZcINlcxH zZcINlcxH, boolean z5) {
        r1(zZcINlcxH, "需要热门权限才能观看本内容，使用超级浏览权限卡或开通热门权限无限制观看。", z5);
    }

    void S0() {
        if (com.secret.prettyhezi.Game.b.a() && (!com.secret.AD.c.b(5) || Math.random() > 0.75d)) {
            com.secret.prettyhezi.Game.c cVar = new com.secret.prettyhezi.Game.c(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, cVar.f());
            layoutParams.topMargin = g4.i.r(6.0f);
            this.f8115w.addView(cVar, layoutParams);
        } else if (com.secret.AD.c.b(5)) {
            com.secret.AD.d dVar = new com.secret.AD.d(this, 5);
            this.G = dVar;
            dVar.g();
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.G.f());
            layoutParams2.topMargin = g4.i.r(6.0f);
            this.f8115w.addView(this.G, layoutParams2);
        }
    }

    void T0() {
        LinearLayout linearLayout = new LinearLayout(this);
        this.H = linearLayout;
        linearLayout.setOrientation(1);
        this.f8115w.addView(this.H, new LinearLayout.LayoutParams(-1, -2));
        V(this.H, Color.parseColor("#cccccc"), 0.5f, 0, 2);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setBackgroundColor(Color.parseColor("#dddddd"));
        this.H.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        TextView b6 = g4.d.b(this, 16.0f, -16777216, String.format(s0(C0382R.string.CollectedByBoxesFormat), c1()));
        b6.setGravity(19);
        b6.setPadding(g4.i.r(12.0f), 0, 0, 0);
        linearLayout2.addView(b6, new LinearLayout.LayoutParams(0, g4.i.r(40.0f), 1.0f));
        this.I = g4.d.c(this, 14, -65536, s0(C0382R.string.Switch), 17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(80.0f), g4.i.r(32.0f));
        layoutParams.rightMargin = g4.i.r(8.0f);
        int r5 = g4.i.r(6.0f);
        layoutParams.bottomMargin = r5;
        layoutParams.topMargin = r5;
        this.I.setBackground(g4.i.b(-1, 8.0f));
        linearLayout2.addView(this.I, layoutParams);
        this.I.setOnClickListener(new b());
        V(this.H, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        m1();
    }

    void U0() {
        LinearLayout linearLayout = new LinearLayout(this);
        this.E = linearLayout;
        linearLayout.setOrientation(0);
        this.E.setGravity(16);
        this.E.setPadding(g4.i.r(6.0f), 0, g4.i.r(6.0f), 0);
        this.f8115w.addView(this.E, new LinearLayout.LayoutParams(-1, -2));
        this.E.addView(g4.d.b(this, 12.0f, Color.parseColor("#333333"), "该内容最早由此盒子收藏："), new LinearLayout.LayoutParams(-2, -2));
        TextView a6 = g4.d.a(this, 14.0f, -65536);
        this.F = a6;
        a6.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        this.F.setOnClickListener(new a());
        this.E.addView(this.F, new LinearLayout.LayoutParams(-2, -2));
        this.E.setVisibility(8);
    }

    public void V0() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.B = relativeLayout;
        relativeLayout.setPadding(g4.i.r(8.0f), g4.i.r(4.0f), g4.i.r(12.0f), g4.i.r(4.0f));
        this.f8115w.addView(this.B, new LinearLayout.LayoutParams(-1, g4.i.r(32.0f)));
        TextView b6 = g4.d.b(this, 12.0f, -16777216, "ID:" + this.f8111s);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15, -1);
        this.B.addView(b6, layoutParams);
        this.C = new com.secret.prettyhezi.View.g(this, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.secret.prettyhezi.View.g.b());
        layoutParams2.addRule(15, -1);
        layoutParams2.leftMargin = g4.i.r(72.0f);
        this.B.addView(this.C, layoutParams2);
        this.D = g4.d.a(this, 12.0f, Color.parseColor("#888888"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15, -1);
        layoutParams3.addRule(11, -1);
        this.B.addView(this.D, layoutParams3);
    }

    void W0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        this.f8115w.addView(linearLayout, this.f8110r == 3 ? 0 : -1, new LinearLayout.LayoutParams(-1, -2));
        TextView a6 = g4.d.a(this, 14.0f, -16777216);
        this.f8118z = a6;
        a6.setPadding(g4.i.r(4.0f), g4.i.r(4.0f), g4.i.r(2.0f), g4.i.r(4.0f));
        this.f8118z.setGravity(16);
        linearLayout.addView(this.f8118z, new LinearLayout.LayoutParams(-1, -2));
        TextView a7 = g4.d.a(this, 14.0f, -16777216);
        this.A = a7;
        a7.setPadding(g4.i.r(4.0f), 0, g4.i.r(2.0f), 0);
        linearLayout.addView(this.A, new LinearLayout.LayoutParams(-1, -2));
    }

    protected void X0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView Y0(String str) {
        l1();
        TextView c6 = g4.d.c(this, 14, -65536, str, 17);
        c6.setBackground(g4.i.d(g4.i.c(-256, 5.0f, -16777216, 1.0f), g4.i.c(-7829368, 5.0f, -16777216, 1.0f)));
        c6.setPadding(g4.i.r(6.0f), 0, g4.i.r(6.0f), 0);
        c6.setMinWidth(g4.i.r(80.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, g4.i.r(46.0f));
        layoutParams.addRule(13, -1);
        this.B.addView(c6, layoutParams);
        return c6;
    }

    public String a1() {
        return com.secret.prettyhezi.g.b(this.f8110r) + "/show/json?id=" + this.f8111s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b1() {
        return Math.min(g4.i.r(320.0f), (o().y * 6) / 10);
    }

    protected String c1() {
        int i6;
        int i7 = this.f8110r;
        if (i7 == 1) {
            return s0(C0382R.string.Image);
        }
        if (i7 == 6) {
            i6 = C0382R.string.Gallery;
        } else if (i7 == 7) {
            i6 = C0382R.string.Audios;
        } else if (i7 == 2) {
            i6 = C0382R.string.ShortVideo;
        } else if (i7 == 4) {
            i6 = C0382R.string.Film;
        } else if (i7 == 3) {
            i6 = C0382R.string.Novel;
        } else if (i7 != 5) {
            return s0(C0382R.string.Image);
        } else {
            i6 = C0382R.string.LongVideo;
        }
        return s0(i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d1() {
        String str;
        if (this.f8112t.f7126p2) {
            str = "兑换精华上传权限";
        } else {
            str = g4.i.F(this.f8112t.sc) + "积分解锁";
        }
        return str + e1();
    }

    String e1() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public String f1() {
        return com.secret.prettyhezi.g.b(this.f8110r) + "/unlock/json";
    }

    void g1() {
        View view;
        View.OnClickListener hVar;
        RelativeLayout L = L(this.f8113u);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(11, -1);
        L.addView(linearLayout, layoutParams);
        int i6 = this.f8110r;
        if (i6 != 3 && i6 != 7 && i6 != 4) {
            TextView b6 = g4.d.b(this, 14.0f, -1, "举报有奖");
            this.f8116x = b6;
            b6.setGravity(17);
            this.f8116x.setBackground(g4.i.d(g4.i.b(-65536, 4.0f), g4.i.b(Color.parseColor("#aa0000"), 4.0f)));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(66.0f), g4.i.r(30.0f));
            layoutParams2.rightMargin = g4.i.r(12.0f);
            linearLayout.addView(this.f8116x, layoutParams2);
            this.f8116x.setOnClickListener(new f());
        }
        int i7 = this.f8110r;
        if (i7 != 2 && i7 != 5) {
            if (MainApplication.f6711r.a()) {
                view = new z(this, C0382R.drawable.ic_share);
                int r5 = g4.i.r(8.0f);
                view.setPadding(r5, r5, r5, r5);
                view.setBackground(g4.i.d(null, g4.i.b(Color.parseColor("#cccccc"), 4.0f)));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(42.0f), g4.i.r(42.0f));
                layoutParams3.rightMargin = g4.i.r(18.0f);
                layoutParams3.leftMargin = g4.i.r(6.0f);
                linearLayout.addView(view, layoutParams3);
                hVar = new g();
            }
            TextView b7 = g4.d.b(this, 14.0f, -1, s0(C0382R.string.collect));
            b7.setGravity(17);
            b7.setBackground(g4.i.d(g4.i.b(-65536, 4.0f), g4.i.b(Color.parseColor("#aa0000"), 4.0f)));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(g4.i.r(58.0f), g4.i.r(30.0f));
            layoutParams4.rightMargin = g4.i.r(18.0f);
            linearLayout.addView(b7, layoutParams4);
            b7.setOnClickListener(new i());
        }
        TextView b8 = g4.d.b(this, 14.0f, -1, "举报重复视频");
        this.f8117y = b8;
        b8.setGravity(17);
        this.f8117y.setPadding(g4.i.r(6.0f), 0, g4.i.r(6.0f), 0);
        this.f8117y.setBackground(g4.i.d(g4.i.b(-65536, 4.0f), g4.i.b(Color.parseColor("#aa0000"), 4.0f)));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, g4.i.r(30.0f));
        layoutParams5.rightMargin = g4.i.r(12.0f);
        linearLayout.addView(this.f8117y, layoutParams5);
        this.f8117y.setVisibility(8);
        view = this.f8117y;
        hVar = new h();
        view.setOnClickListener(hVar);
        TextView b72 = g4.d.b(this, 14.0f, -1, s0(C0382R.string.collect));
        b72.setGravity(17);
        b72.setBackground(g4.i.d(g4.i.b(-65536, 4.0f), g4.i.b(Color.parseColor("#aa0000"), 4.0f)));
        LinearLayout.LayoutParams layoutParams42 = new LinearLayout.LayoutParams(g4.i.r(58.0f), g4.i.r(30.0f));
        layoutParams42.rightMargin = g4.i.r(18.0f);
        linearLayout.addView(b72, layoutParams42);
        b72.setOnClickListener(new i());
    }

    protected void h1(String str) {
    }

    public void i1() {
        TextView textView = this.f8116x;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.f8117y;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    public void j1() {
        com.secret.prettyhezi.Server.j jVar = this.f8112t;
        if (jVar.f7126p2) {
            q1();
        } else {
            p1(jVar.sc);
        }
    }

    protected void k1(String str) {
    }

    public void l1() {
        while (this.B.getChildCount() > 3) {
            this.B.removeViewAt(3);
        }
    }

    public void m1() {
        int random;
        int i6 = this.L;
        int i7 = 1;
        if (i6 == 0) {
            i6 = (this.f8112t.fc / 6) - 1;
        }
        int i8 = 0;
        int i9 = -1;
        if (this.f8112t.fc < 50) {
            while (i8 < 10) {
                random = ((int) (Math.random() * i6)) + 1;
                if (!this.K.contains(new Integer(random))) {
                    i9 = random;
                    break;
                }
                i8++;
            }
        } else {
            while (i8 < 10) {
                random = i6 - ((int) ((Math.random() * i6) / 2.0d));
                if (!this.K.contains(new Integer(random))) {
                    i9 = random;
                    break;
                }
                i8++;
            }
        }
        if (i9 < 0 && i6 > 0) {
            int i10 = i6;
            while (true) {
                if (i10 <= 0) {
                    break;
                } else if (!this.K.contains(new Integer(i10))) {
                    i9 = i10;
                    break;
                } else {
                    i10--;
                }
            }
        }
        if (i9 > 0 && i9 <= i6) {
            i7 = i9;
        }
        this.K.add(new Integer(i7));
        n1(i7);
    }

    void n1(int i6) {
        com.secret.prettyhezi.j.m(com.secret.prettyhezi.Server.v.f7132a + "box/tips/json?t=" + this.f8110r + "&id=" + this.f8111s + "&page=" + i6, new c(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o1() {
        G0();
        com.secret.prettyhezi.j.m(com.secret.prettyhezi.Server.v.f7132a + a1(), new j(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MainApplication.f6711r.u();
        RcB8ALaRS.y1(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f8111s = extras.getInt("id");
            int i6 = extras.getInt("type");
            this.f8110r = i6;
            if (i6 == 0) {
                return;
            }
        }
        LinearLayout B0 = B0(3, 4);
        this.f8113u = B0;
        B0.setBackgroundColor(-1);
        g1();
        ScrollView scrollView = new ScrollView(this);
        this.f8114v = scrollView;
        scrollView.setVerticalScrollBarEnabled(false);
        this.f8113u.addView(this.f8114v, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout linearLayout = new LinearLayout(this);
        this.f8115w = linearLayout;
        linearLayout.setOrientation(1);
        this.f8115w.setGravity(1);
        this.f8114v.addView(this.f8115w, new FrameLayout.LayoutParams(-1, -2));
        X0();
        V0();
        V(this.f8115w, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        S0();
        V(this.f8115w, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        U0();
        W0();
        o1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.secret.AD.d dVar = this.G;
        if (dVar != null) {
            dVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.J != null) {
            this.f8113u.postDelayed(new d(), 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.M != null) {
            this.f8113u.postDelayed(new e(), 300L);
        }
    }

    public void p1(double d6) {
        String c12 = c1();
        com.secret.prettyhezi.controls.f fVar = new com.secret.prettyhezi.controls.f(this);
        fVar.a("解锁该" + c12 + "永久观看权限，并消耗", -16777216, 16.0f).a(g4.i.F(d6), -65536, 16.0f).a("积分感谢你的邀请人和上传内容者？", -16777216, 16.0f);
        B("解锁该" + c12 + "永久观看权限，并消耗" + g4.i.F(d6) + "积分感谢你的邀请人和上传内容者？", new m(), true).f8478e.setText(fVar.f8321d);
    }

    void q1() {
        com.secret.prettyhezi.controls.x xVar = new com.secret.prettyhezi.controls.x(this);
        xVar.f("兑换精华上传内容权限？");
        xVar.d(new String[]{s0(C0382R.string.cancel), s0(C0382R.string.RedeemNow)}, new n(xVar));
        x(xVar, null, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t1() {
        Y0(d1()).setOnClickListener(new l());
    }

    void u1() {
        com.secret.prettyhezi.Server.d[] dVarArr = this.M.items;
        if (dVarArr != null && dVarArr.length > 0) {
            com.secret.prettyhezi.View.m mVar = this.J;
            if (mVar != null) {
                this.H.removeView(mVar);
            }
            com.secret.prettyhezi.View.m mVar2 = new com.secret.prettyhezi.View.m(this, 100);
            this.J = mVar2;
            this.H.addView(mVar2, new LinearLayout.LayoutParams(-1, -2));
            for (com.secret.prettyhezi.Server.d dVar : this.M.items) {
                this.J.a(dVar);
            }
            this.J.c();
        }
        this.I.setVisibility(this.L <= this.K.size() ? 8 : 0);
    }

    public void v1(com.secret.prettyhezi.Server.j jVar) {
        this.f8112t = jVar;
        TextView textView = this.f8116x;
        if (textView != null) {
            textView.setVisibility(jVar.ir ? 8 : 0);
        }
        TextView textView2 = this.f8117y;
        if (textView2 != null) {
            if (jVar.ry) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                d0 d0Var = (this.f8110r == 2 ? com.secret.prettyhezi.Upload.o.f7505a : com.secret.prettyhezi.Upload.o.f7506b).f7507a;
                if (d0Var != null && d0Var.id == this.f8111s) {
                    this.f8117y.setText("请找到另一视频并举报");
                    this.f8117y.setEnabled(false);
                }
            }
        }
        this.C.c(jVar.fc);
        this.D.setText(g4.i.u(jVar.ct));
        j.a aVar = jVar.cl;
        if (aVar != null && aVar.id > 0 && !aVar.na.isEmpty() && (jVar.fc >= 199 || this.f8110r != 4)) {
            this.E.setVisibility(0);
            this.F.setText(jVar.cl.na);
        }
        w1();
        if (jVar.fc <= 0 || this.H != null) {
            return;
        }
        T0();
    }

    @Override // com.secret.prettyhezi.ZZcINlcxH
    public void w0(com.secret.prettyhezi.Server.w wVar) {
        int i6;
        String str = wVar.err;
        if (MainApplication.f6711r.r().grade == 0 && (str.equals("LimitReached") || str.equals("PermissionDenied"))) {
            ZZcINlcxH x02 = x0();
            finish();
            com.secret.prettyhezi.User.f.k(x02, str.equals("LimitReached") ? 3 : 1);
        } else if (str.equals("LimitReached")) {
            r1(this, "今日额度已用完，使用超级浏览权限卡或开通热门权限无限制观看。", true);
        } else if (str.equals("PermissionDenied") && MainApplication.f6711r.r().grade > 0 && ((i6 = this.f8110r) == 3 || i6 == 2 || i6 == 4 || i6 == 1)) {
            s1(this, true);
        } else {
            super.w0(wVar);
        }
    }

    void w1() {
        String str;
        com.secret.prettyhezi.Server.j jVar;
        String str2;
        String str3 = this.f8112t.na;
        String str4 = null;
        if (str3 == null || str3.isEmpty() || ((str2 = (jVar = this.f8112t).mt) != null && str2.contains(jVar.na))) {
            str = null;
        } else {
            str = this.f8112t.na;
            this.f8118z.setText(str);
        }
        String str5 = this.f8112t.mt;
        if (str5 != null && !str5.isEmpty()) {
            str4 = this.f8112t.mt;
            this.A.setText(str4);
        }
        this.f8118z.setVisibility(str == null ? 8 : 0);
        this.A.setVisibility(str4 != null ? 0 : 8);
    }

    public void x1() {
        MainApplication.f6711r.r().integral.all -= this.f8112t.sc;
        MainApplication.f6711r.x();
        EjNkL.N.f6165r.j();
        EjNkL.N.f6165r.i();
    }
}
