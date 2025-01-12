package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.Game.Number.POjTJ;
import com.secret.prettyhezi.Game.Try.a;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.s;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class Q65u46F extends UoWMF {

    /* renamed from: x  reason: collision with root package name */
    static long f6421x;

    /* renamed from: y  reason: collision with root package name */
    static m f6422y;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6423r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6424s;

    /* renamed from: u  reason: collision with root package name */
    TextView f6426u;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f6425t = null;

    /* renamed from: v  reason: collision with root package name */
    int f6427v = Color.parseColor("#ffff00");

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f6428w = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            n nVar = (n) com.secret.prettyhezi.f.d(str, n.class);
            if (nVar.code == 200) {
                Q65u46F.f6422y = nVar.data;
                Q65u46F.this.c1();
                Q65u46F.this.Z0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements a.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6430a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f6431b;

        /* loaded from: classes.dex */
        class a extends s.g {
            a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                com.secret.prettyhezi.Server.z zVar = (com.secret.prettyhezi.Server.z) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.Server.z.class);
                if (zVar.code == 200) {
                    Q65u46F.this.Y0();
                } else {
                    f(zVar.err);
                }
            }
        }

        b(int i6, long j6) {
            this.f6430a = i6;
            this.f6431b = j6;
        }

        @Override // com.secret.prettyhezi.Device.a.f
        public void a(String str) {
            Q65u46F.this.I0();
            com.secret.prettyhezi.j.t(com.secret.prettyhezi.Game.i.a() + "auth/stop/json", com.secret.prettyhezi.f.e(new l(this.f6430a, this.f6431b)), com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new a(Q65u46F.this));
        }
    }

    /* loaded from: classes.dex */
    class c extends g4.f {
        c() {
        }

        @Override // g4.f
        protected void a(View view) {
            if (com.secret.prettyhezi.Game.i.f6608a == null) {
                Q65u46F.this.q("暂时不可用，请稍后再试");
            } else {
                Q65u46F.this.M0(NPHwyx5X.class);
            }
        }
    }

    /* loaded from: classes.dex */
    class d extends g4.f {
        d() {
        }

        @Override // g4.f
        protected void a(View view) {
            if (com.secret.prettyhezi.Game.i.f6608a == null) {
                Q65u46F.this.q("暂时不可用，请稍后再试");
            } else {
                Q65u46F.this.V0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements com.secret.prettyhezi.e {
        e() {
        }

        @Override // com.secret.prettyhezi.e
        public void a(int i6) {
            Q65u46F.this.d1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {
        f() {
        }

        @Override // g4.f
        protected void a(View view) {
            if (com.secret.prettyhezi.Game.i.f6608a == null) {
                Q65u46F.this.q("暂时不可用，请稍后再试");
            } else {
                Q65u46F.this.N0(Mrg1FaeY.class, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends g4.f {
        g() {
        }

        @Override // g4.f
        protected void a(View view) {
            if (com.secret.prettyhezi.Game.i.f6608a == null) {
                Q65u46F.this.q("暂时不可用，请稍后再试");
            } else {
                Q65u46F.this.N0(Mrg1FaeY.class, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends g4.f {
        h() {
        }

        @Override // g4.f
        protected void a(View view) {
            if (com.secret.prettyhezi.Game.i.f6608a == null) {
                Q65u46F.this.q("暂时不可用，请稍后再试");
            } else {
                Q65u46F.this.M0(CAr0jaumF.class);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Class f6440d;

        i(Class cls) {
            this.f6440d = cls;
        }

        @Override // g4.f
        protected void a(View view) {
            if (com.secret.prettyhezi.Game.i.f6608a == null) {
                Q65u46F.this.q("暂时不可用，请稍后再试");
            } else {
                Q65u46F.this.M0(this.f6440d);
            }
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
            q qVar = (q) com.secret.prettyhezi.f.d(str, q.class);
            if (qVar.code != 200) {
                Q65u46F.this.w0(qVar);
                return;
            }
            Q65u46F.f6421x = System.currentTimeMillis();
            com.secret.prettyhezi.Game.i.f6608a = qVar.data;
            Q65u46F.this.d1();
            Q65u46F.this.a1();
            if (Q65u46F.f6422y == null) {
                Q65u46F.this.Y0();
            } else {
                Q65u46F.this.c1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k extends s.g {
        k(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            a.c cVar = (a.c) com.secret.prettyhezi.f.d(str, a.c.class);
            if (cVar.code != 200) {
                f(cVar.err);
                return;
            }
            com.secret.prettyhezi.Game.Try.a.f6503a = cVar.data;
            Q65u46F.this.N0(POjTJ.class, 1);
        }
    }

    /* loaded from: classes.dex */
    static class l implements Serializable {

        /* renamed from: d  reason: collision with root package name */
        public long f6444d;
        public String passwd = com.secret.prettyhezi.Device.a.a();

        /* renamed from: t  reason: collision with root package name */
        public int f6445t;

        l(int i6, long j6) {
            this.f6445t = i6;
            this.f6444d = j6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class m implements Serializable {

        /* renamed from: g1  reason: collision with root package name */
        public long f6446g1;
        public long g1_at;
        public long[] g1_button;

        /* renamed from: g2  reason: collision with root package name */
        public long f6447g2;
        public long g2_at;
        public long[] g2_button;

        m() {
        }
    }

    /* loaded from: classes.dex */
    static class n extends com.secret.prettyhezi.Server.w {
        public m data;

        n() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        int f6448b;

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Q65u46F f6450d;

            a(Q65u46F q65u46F) {
                this.f6450d = q65u46F;
            }

            @Override // g4.f
            protected void a(View view) {
                o.this.b(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ com.secret.prettyhezi.controls.c[] f6452d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f6453e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ long[] f6454f;

            b(com.secret.prettyhezi.controls.c[] cVarArr, int i6, long[] jArr) {
                this.f6452d = cVarArr;
                this.f6453e = i6;
                this.f6454f = jArr;
            }

            @Override // g4.f
            protected void a(View view) {
                boolean isSelected = this.f6452d[this.f6453e].isSelected();
                if (!isSelected) {
                    for (int i6 = 0; i6 < this.f6454f.length; i6++) {
                        if (i6 != this.f6453e) {
                            this.f6452d[i6].setSelected(false);
                        }
                    }
                }
                this.f6452d[this.f6453e].setSelected(!isSelected);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements x.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ com.secret.prettyhezi.controls.x f6456a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ com.secret.prettyhezi.controls.c[] f6457b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ long[] f6458c;

            /* loaded from: classes.dex */
            class a extends ZZcINlcxH.q {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ long f6460a;

                a(long j6) {
                    this.f6460a = j6;
                }

                @Override // com.secret.prettyhezi.ZZcINlcxH.q
                public void b() {
                    o oVar = o.this;
                    Q65u46F.this.b1(oVar.f6448b, this.f6460a);
                }
            }

            c(com.secret.prettyhezi.controls.x xVar, com.secret.prettyhezi.controls.c[] cVarArr, long[] jArr) {
                this.f6456a = xVar;
                this.f6457b = cVarArr;
                this.f6458c = jArr;
            }

            @Override // com.secret.prettyhezi.controls.x.c
            public void a(int i6) {
                long j6;
                Q65u46F.this.j(this.f6456a);
                if (i6 == 1) {
                    int i7 = 0;
                    while (true) {
                        com.secret.prettyhezi.controls.c[] cVarArr = this.f6457b;
                        if (i7 >= cVarArr.length) {
                            j6 = 0;
                            break;
                        } else if (cVarArr[i7].isSelected()) {
                            j6 = this.f6458c[i7];
                            break;
                        } else {
                            i7++;
                        }
                    }
                    if (j6 == 0) {
                        Q65u46F.this.q("请选择停用时长");
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("确定停用");
                    sb.append(o.this.f6448b == 1 ? "数字" : "夺宝");
                    sb.append("游戏");
                    sb.append(o.this.a(j6));
                    sb.append("?\n\n停用到期前无法再开启");
                    Q65u46F.this.B(sb.toString(), new a(j6), false);
                }
            }
        }

        public o(int i6) {
            super(Q65u46F.this);
            long j6;
            long j7;
            this.f6448b = i6;
            setOrientation(1);
            setGravity(1);
            m mVar = Q65u46F.f6422y;
            if (i6 == 1) {
                j6 = mVar.f6446g1;
                j7 = mVar.g1_at;
            } else {
                j6 = mVar.f6447g2;
                j7 = mVar.g2_at;
            }
            if (j6 != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(i6 != 1 ? "夺宝" : "数字");
                sb.append("游戏已停用至:");
                sb.append(j6 >= 9999 ? "永久" : g4.i.u(j7));
                addView(g4.d.c(Q65u46F.this, 12, Color.parseColor("#ff0000"), sb.toString(), 17), new LinearLayout.LayoutParams(g4.i.r(260.0f), g4.i.r(32.0f)));
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("停用");
            sb2.append(i6 != 1 ? "夺宝" : "数字");
            sb2.append("游戏?");
            TextView c6 = g4.d.c(Q65u46F.this, 12, Color.parseColor("#888888"), sb2.toString(), 17);
            addView(c6, new LinearLayout.LayoutParams(g4.i.r(100.0f), g4.i.r(32.0f)));
            c6.setOnClickListener(new a(Q65u46F.this));
        }

        String a(long j6) {
            if (j6 < 7) {
                return j6 + "天";
            } else if (j6 < 30) {
                return (j6 / 7) + "周";
            } else if (j6 < 360) {
                return (j6 / 30) + "月";
            } else if (j6 < 9999) {
                return (j6 / 360) + "年";
            } else {
                return "永久";
            }
        }

        void b(boolean z5) {
            long[] jArr = this.f6448b == 1 ? Q65u46F.f6422y.g1_button : Q65u46F.f6422y.g2_button;
            LinearLayout linearLayout = new LinearLayout(Q65u46F.this);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            StringBuilder sb = new StringBuilder();
            sb.append("请选择停用");
            sb.append(this.f6448b == 1 ? "数字" : "夺宝");
            sb.append("游戏时长");
            String sb2 = sb.toString();
            int r5 = g4.i.r(90.0f);
            com.secret.prettyhezi.controls.c[] cVarArr = new com.secret.prettyhezi.controls.c[jArr.length];
            for (int i6 = 0; i6 < jArr.length; i6++) {
                com.secret.prettyhezi.controls.c cVar = new com.secret.prettyhezi.controls.c(Q65u46F.this, C0382R.drawable.gesture_normal_green, C0382R.drawable.gesture_pressed_green, a(jArr[i6]));
                cVarArr[i6] = cVar;
                cVar.f8302b.setLayoutParams(new LinearLayout.LayoutParams(g4.i.r(24.0f), g4.i.r(24.0f)));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r5, -2);
                layoutParams.bottomMargin = g4.i.r(6.0f);
                cVarArr[i6].setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
                linearLayout.addView(cVarArr[i6], layoutParams);
                cVarArr[i6].setOnClickListener(new b(cVarArr, i6, jArr));
            }
            com.secret.prettyhezi.controls.x xVar = new com.secret.prettyhezi.controls.x(Q65u46F.this);
            xVar.h(sb2, linearLayout, 20);
            xVar.d(new String[]{Q65u46F.this.s0(C0382R.string.cancel), Q65u46F.this.s0(C0382R.string.ok)}, new c(xVar, cVarArr, jArr));
            Q65u46F.this.x(xVar, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p implements Serializable {
        public String cert;
        public String password;
        public String username;

        public p() {
            init();
        }

        public void init() {
            this.cert = com.secret.prettyhezi.Device.a.f();
            this.username = g4.g.a().e();
            this.password = g4.g.a().f();
        }
    }

    /* loaded from: classes.dex */
    class q extends com.secret.prettyhezi.Server.w {
        l0 data;

        q() {
        }
    }

    TextView S0(String str) {
        TextView c6 = g4.d.c(this, 18, -1, str, 17);
        c6.setBackground(g4.i.e(g4.i.b(-16777216, 5.0f), g4.i.b(Color.parseColor("#666666"), 5.0f), g4.i.b(Color.parseColor("#666666"), 5.0f)));
        return c6;
    }

    View T0(String str, String str2, int i6, Class cls) {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackground(g4.i.e(g4.i.c(-16777216, 10.0f, this.f6427v, 5.0f), g4.i.c(Color.parseColor("#666666"), 10.0f, this.f6427v, 5.0f), g4.i.c(Color.parseColor("#666666"), 10.0f, this.f6427v, 5.0f)));
        frameLayout.setOnClickListener(new i(cls));
        frameLayout.addView(g4.d.c(this, 30, this.f6427v, str, 17), new FrameLayout.LayoutParams(-1, -1));
        TextView c6 = g4.d.c(this, 14, Color.parseColor("#f0f000"), str2, 17);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) (i6 * 0.8d);
        frameLayout.addView(c6, 0, layoutParams);
        return frameLayout;
    }

    void U0() {
        I0();
        com.secret.prettyhezi.j.t(com.secret.prettyhezi.Game.i.a() + "auth/login/json", com.secret.prettyhezi.f.e(new p()), null, 3, new j(this));
    }

    void V0() {
        I0();
        com.secret.prettyhezi.j.t(com.secret.prettyhezi.Game.i.a() + "demo/auth/login/json", "{}", com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new k(this));
    }

    void W0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setPadding(0, g4.i.r(20.0f), 0, g4.i.r(20.0f));
        this.f6424s.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        int r5 = g4.i.r(10.0f);
        int i6 = o().x;
        int i7 = (i6 - r5) / 2;
        int r6 = g4.i.r(160.0f);
        if (i7 > r6) {
            r5 = (i6 - (r6 * 2)) / 3;
            i7 = r6;
        }
        View T0 = T0("数字\n游戏", "(猜大小)", i7, POjTJ.class);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i7, i7);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        linearLayout.addView(T0, layoutParams);
        View T02 = T0("夺宝\n游戏", "(以小博大)", i7, XCDYdzJ.class);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i7, i7);
        layoutParams2.rightMargin = r5;
        linearLayout.addView(T02, layoutParams2);
    }

    void X0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        this.f6424s.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setBackgroundColor(Color.parseColor("#f0f0f0"));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(10.0f);
        layoutParams.bottomMargin = g4.i.r(10.0f);
        linearLayout.addView(linearLayout2, layoutParams);
        linearLayout2.addView(g4.d.b(this, 16.0f, -16777216, "当前筹码:   "), new LinearLayout.LayoutParams(-2, -2));
        TextView b6 = g4.d.b(this, 26.0f, -16777216, "0");
        this.f6426u = b6;
        b6.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        this.f6426u.setBackground(g4.i.b(this.f6427v, 5.0f));
        linearLayout2.addView(this.f6426u, new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.addView(g4.d.b(this, 16.0f, -16777216, "   金币"), new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.bottomMargin = g4.i.r(20.0f);
        linearLayout.addView(linearLayout3, layoutParams2);
        TextView S0 = S0("充值");
        S0.setOnClickListener(new f());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(80.0f), g4.i.r(38.0f));
        layoutParams3.rightMargin = g4.i.r(20.0f);
        linearLayout3.addView(S0, layoutParams3);
        TextView S02 = S0("提现");
        S02.setOnClickListener(new g());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(g4.i.r(80.0f), g4.i.r(38.0f));
        layoutParams4.rightMargin = g4.i.r(20.0f);
        linearLayout3.addView(S02, layoutParams4);
        TextView S03 = S0("记录");
        S03.setOnClickListener(new h());
        linearLayout3.addView(S03, new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(38.0f)));
    }

    void Y0() {
        com.secret.prettyhezi.j.q(com.secret.prettyhezi.Game.i.a() + "auth/button/close/json", com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new a(this));
    }

    void Z0() {
        com.secret.prettyhezi.Game.i.b(this, new e());
    }

    void a1() {
        l0 l0Var = com.secret.prettyhezi.Game.i.f6608a;
        if (l0Var == null) {
            return;
        }
        String str = l0Var.notice;
        if (str == null || str.isEmpty()) {
            LinearLayout linearLayout = this.f6425t;
            if (linearLayout != null) {
                ((ViewGroup) linearLayout.getParent()).removeView(this.f6425t);
                this.f6425t = null;
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = this.f6425t;
        if (linearLayout2 == null) {
            LinearLayout linearLayout3 = new LinearLayout(this);
            this.f6425t = linearLayout3;
            linearLayout3.setOrientation(1);
            this.f6425t.setGravity(17);
            this.f6425t.setBackgroundColor(-65536);
            this.f6425t.setPadding(g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f));
            this.f6424s.addView(this.f6425t, 0, new LinearLayout.LayoutParams(-1, -2));
        } else {
            linearLayout2.removeAllViews();
        }
        this.f6425t.addView(g4.d.b(this, 18.0f, -1, "公告"), new LinearLayout.LayoutParams(-2, -2));
        TextView c6 = g4.d.c(this, 16, -1, str, 3);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(8.0f);
        this.f6425t.addView(c6, layoutParams);
    }

    void b1(int i6, long j6) {
        com.secret.prettyhezi.Device.a.e();
        com.secret.prettyhezi.Device.a.b(this, new b(i6, j6));
    }

    void c1() {
        if (f6422y == null) {
            return;
        }
        if (this.f6428w == null) {
            LinearLayout linearLayout = new LinearLayout(this);
            this.f6428w = linearLayout;
            linearLayout.setOrientation(1);
            this.f6428w.setGravity(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = g4.i.r(40.0f);
            this.f6424s.addView(this.f6428w, layoutParams);
        }
        this.f6428w.removeAllViews();
        this.f6428w.addView(new o(1), new LinearLayout.LayoutParams(-1, -2));
        this.f6428w.addView(new o(2), new LinearLayout.LayoutParams(-1, -2));
    }

    void d1() {
        TextView textView = this.f6426u;
        textView.setText(com.secret.prettyhezi.Game.i.f6608a.integral + HttpUrl.FRAGMENT_ENCODE_SET);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f6423r = C0;
        M(C0, "金币游戏");
        this.f6423r.setBackgroundColor(-1);
        V(this.f6423r, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        LinearLayout e6 = e(this.f6423r);
        this.f6424s = e6;
        e6.setGravity(1);
        X0();
        V(this.f6424s, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        W0();
        Q(this.f6424s, Color.parseColor("#aaaaaa"), 0.5f, 12, 0, 12);
        TextView b6 = g4.d.b(this, 20.0f, -16777216, "* 绝对公正 *");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = g4.i.r(20.0f);
        layoutParams.bottomMargin = g4.i.r(10.0f);
        this.f6424s.addView(b6, layoutParams);
        this.f6424s.addView(g4.d.b(this, 16.0f, -16777216, "小赌怡情  大赌伤身"), new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setBackground(g4.i.d(g4.i.b(-65536, 10.0f), g4.i.b(Color.parseColor("#dd000000"), 10.0f)));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(200.0f), g4.i.r(100.0f));
        layoutParams2.topMargin = g4.i.r(30.0f);
        layoutParams2.bottomMargin = g4.i.r(20.0f);
        this.f6424s.addView(linearLayout, layoutParams2);
        linearLayout.addView(g4.d.c(this, 28, -1, "赢家榜", 17), new LinearLayout.LayoutParams(-2, -2));
        TextView b7 = g4.d.b(this, 14.0f, -1, "看看大家都赢了多少");
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = g4.i.r(6.0f);
        linearLayout.addView(b7, layoutParams3);
        linearLayout.setOnClickListener(new c());
        com.secret.prettyhezi.Game.Try.a.b(this, this.f6424s).setOnClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        if ((System.currentTimeMillis() - f6421x) / 1000 > 3600 || com.secret.prettyhezi.Game.i.f6608a == null) {
            if (com.secret.prettyhezi.Game.i.f6608a == null) {
                f6422y = null;
            }
            U0();
            return;
        }
        d1();
        a1();
        Z0();
        c1();
    }
}
