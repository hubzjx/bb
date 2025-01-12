package com.secret.prettyhezi.Game.Number;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.Game.Mrg1FaeY;
import com.secret.prettyhezi.Game.N6LuR;
import com.secret.prettyhezi.Game.Number.k;
import com.secret.prettyhezi.Game.Try.Hg8b72NJ;
import com.secret.prettyhezi.Game.i;
import com.secret.prettyhezi.Server.z;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class POjTJ extends UoWMF {
    int A;
    com.secret.prettyhezi.Game.Number.g C;
    LinearLayout D;
    com.secret.prettyhezi.Game.Number.i E;
    TextView G;
    TextView H;
    TextView I;
    TextView J;
    com.secret.prettyhezi.Game.Number.f K;
    k.e.a L;
    k.f.a M;
    com.secret.prettyhezi.Game.Number.j O;

    /* renamed from: v  reason: collision with root package name */
    LinearLayout f6305v;

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f6306w;

    /* renamed from: x  reason: collision with root package name */
    com.secret.prettyhezi.controls.i f6307x;

    /* renamed from: y  reason: collision with root package name */
    int f6308y;

    /* renamed from: z  reason: collision with root package name */
    com.secret.prettyhezi.Game.Number.l f6309z;

    /* renamed from: r  reason: collision with root package name */
    final String f6301r = "keyNumberGameTypeIdx";

    /* renamed from: s  reason: collision with root package name */
    boolean f6302s = false;

    /* renamed from: t  reason: collision with root package name */
    int f6303t = 0;

    /* renamed from: u  reason: collision with root package name */
    int f6304u = 0;
    long B = 0;
    int F = (int) (Math.random() * 5.0d);
    ArrayList N = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            String str2;
            k.i iVar = (k.i) com.secret.prettyhezi.f.d(str, k.i.class);
            if (iVar.code != 200) {
                POjTJ.this.w0(iVar);
                return;
            }
            k.i.a aVar = iVar.data;
            if (aVar == null || (str2 = aVar.open_num) == null || str2.isEmpty()) {
                return;
            }
            k.i.a aVar2 = iVar.data;
            int i6 = aVar2.id;
            POjTJ pOjTJ = POjTJ.this;
            if (i6 == pOjTJ.M.id) {
                pOjTJ.f6304u = Integer.parseInt(aVar2.open_num);
                POjTJ pOjTJ2 = POjTJ.this;
                if (pOjTJ2.f6303t == 2) {
                    pOjTJ2.f6303t = 3;
                    pOjTJ2.n1();
                }
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
            POjTJ.this.Y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends s.g {

        /* loaded from: classes.dex */
        class a implements com.secret.prettyhezi.e {
            a() {
            }

            @Override // com.secret.prettyhezi.e
            public void a(int i6) {
                POjTJ.this.r1();
                POjTJ.this.z("操作成功！");
            }
        }

        c(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            z zVar = (z) com.secret.prettyhezi.f.d(str, z.class);
            if (zVar.code == 200) {
                com.secret.prettyhezi.Game.Try.a.a(POjTJ.this, new a());
            } else {
                f(zVar.err);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {
        d() {
        }

        @Override // g4.f
        protected void a(View view) {
            POjTJ.this.M0(N6LuR.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements com.secret.prettyhezi.e {
        e() {
        }

        @Override // com.secret.prettyhezi.e
        public void a(int i6) {
            POjTJ.this.f6309z.setVisibility(i6 > 0 ? 0 : 8);
            if (i6 > 0) {
                ((ScrollView) POjTJ.this.f6306w.getParent()).scrollTo(0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            POjTJ.this.p1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends g4.f {
        g() {
        }

        @Override // g4.f
        protected void a(View view) {
            POjTJ pOjTJ = POjTJ.this;
            if (pOjTJ.f6302s) {
                pOjTJ.e1();
            } else {
                pOjTJ.N0(Mrg1FaeY.class, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends s.g {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }
        }

        h(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            k.e eVar = (k.e) com.secret.prettyhezi.f.d(str, k.e.class);
            if (eVar.code != 200) {
                POjTJ.this.w0(eVar);
                return;
            }
            POjTJ pOjTJ = POjTJ.this;
            k.e.a aVar = eVar.data;
            pOjTJ.L = aVar;
            int i6 = aVar.open;
            if (i6 == 1 || i6 == 2) {
                pOjTJ.D(i6 == 1 ? "没开场，请晚些再来" : "你已经暂停数字游戏，不能投注", new a(), true);
            }
            POjTJ pOjTJ2 = POjTJ.this;
            if (pOjTJ2.f6302s) {
                pOjTJ2.O.f6395b.setVisibility(pOjTJ2.L.day_show.equals("1") ? 0 : 8);
                POjTJ pOjTJ3 = POjTJ.this;
                pOjTJ3.O.f6396c.setVisibility(pOjTJ3.L.week_show.equals("1") ? 0 : 8);
                k.e.a aVar2 = POjTJ.this.L;
                Hg8b72NJ.f6482w = aVar2.day_bonus;
                Hg8b72NJ.f6483x = aVar2.week_bonus;
            }
            POjTJ.this.g1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends s.g {

        /* loaded from: classes.dex */
        class a implements com.secret.prettyhezi.e {
            a() {
            }

            @Override // com.secret.prettyhezi.e
            public void a(int i6) {
                TextView textView = POjTJ.this.G;
                textView.setText(HttpUrl.FRAGMENT_ENCODE_SET + com.secret.prettyhezi.Game.i.f6608a.integral);
            }
        }

        /* loaded from: classes.dex */
        class b implements com.secret.prettyhezi.e {
            b() {
            }

            @Override // com.secret.prettyhezi.e
            public void a(int i6) {
                POjTJ.this.r1();
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                POjTJ.this.K.d();
            }
        }

        i(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            k.f fVar = (k.f) com.secret.prettyhezi.f.d(str, k.f.class);
            if (fVar.code != 200) {
                POjTJ.this.w0(fVar);
                return;
            }
            POjTJ pOjTJ = POjTJ.this;
            k.f.a aVar = fVar.data;
            pOjTJ.M = aVar;
            pOjTJ.C.f6374b.setText(aVar.number_no);
            POjTJ pOjTJ2 = POjTJ.this;
            pOjTJ2.A = pOjTJ2.M.end_num;
            pOjTJ2.B = System.currentTimeMillis();
            POjTJ.this.N.clear();
            POjTJ pOjTJ3 = POjTJ.this;
            pOjTJ3.f6303t = 0;
            pOjTJ3.l1();
            POjTJ.this.p1();
            POjTJ.this.h1();
            POjTJ pOjTJ4 = POjTJ.this;
            if (pOjTJ4.f6302s) {
                com.secret.prettyhezi.Game.Try.a.a(pOjTJ4, new b());
            } else {
                com.secret.prettyhezi.Game.i.b(pOjTJ4, new a());
            }
            POjTJ.this.f6305v.postDelayed(new c(), 996L);
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
            k.d dVar = (k.d) com.secret.prettyhezi.f.d(str, k.d.class);
            if (dVar.code != 200) {
                POjTJ.this.w0(dVar);
                return;
            }
            POjTJ.this.N.clear();
            int i6 = 0;
            while (true) {
                k.c[] cVarArr = dVar.data;
                if (i6 >= cVarArr.length) {
                    POjTJ.this.c1();
                    POjTJ.this.q1();
                    return;
                }
                POjTJ.this.N.add(cVarArr[i6]);
                i6++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements s.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k.b f6325a;

        k(k.b bVar) {
            this.f6325a = bVar;
        }

        @Override // com.secret.prettyhezi.s.f
        public void a(String str) {
            TextView textView;
            StringBuilder sb;
            int i6;
            POjTJ.this.E.c();
            POjTJ pOjTJ = POjTJ.this;
            if (pOjTJ.f6302s) {
                com.secret.prettyhezi.Game.Try.a.f6503a.integral -= this.f6325a.integralSum;
                textView = pOjTJ.G;
                sb = new StringBuilder();
                sb.append(HttpUrl.FRAGMENT_ENCODE_SET);
                i6 = com.secret.prettyhezi.Game.Try.a.f6503a.integral;
            } else {
                com.secret.prettyhezi.Game.i.f6608a.integral -= this.f6325a.integralSum;
                textView = pOjTJ.G;
                sb = new StringBuilder();
                sb.append(HttpUrl.FRAGMENT_ENCODE_SET);
                i6 = com.secret.prettyhezi.Game.i.f6608a.integral;
            }
            sb.append(i6);
            textView.setText(sb.toString());
            POjTJ.this.N.add(0, this.f6325a);
            POjTJ.this.c1();
            if (this.f6325a.isDXType()) {
                POjTJ.this.q1();
            }
            com.secret.prettyhezi.Game.Number.i iVar = POjTJ.this.E;
            if (iVar instanceof com.secret.prettyhezi.Game.Number.c) {
                ((com.secret.prettyhezi.Game.Number.c) iVar).o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k.b f6327a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s.f f6328b;

        /* loaded from: classes.dex */
        class a implements a.f {
            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                POjTJ.this.I0();
                l.this.f6327a.passwd = com.secret.prettyhezi.Device.a.a();
                String e6 = com.secret.prettyhezi.f.e(l.this.f6327a);
                String str2 = com.secret.prettyhezi.Game.i.f6608a.token.token;
                l lVar = l.this;
                com.secret.prettyhezi.j.t(POjTJ.this.j1() + "order/bet/json", e6, str2, 3, new s.e(POjTJ.this, lVar.f6328b));
            }
        }

        l(k.b bVar, s.f fVar) {
            this.f6327a = bVar;
            this.f6328b = fVar;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            POjTJ pOjTJ = POjTJ.this;
            if (!pOjTJ.f6302s) {
                com.secret.prettyhezi.Device.a.b(pOjTJ, new a());
                return;
            }
            this.f6327a.passwd = HttpUrl.FRAGMENT_ENCODE_SET;
            com.secret.prettyhezi.j.t(POjTJ.this.j1() + "order/bet/json", com.secret.prettyhezi.f.e(this.f6327a), com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new s.e(POjTJ.this, this.f6328b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S0(k.b bVar) {
        int i6 = bVar.integralSum;
        if ((this.f6302s ? com.secret.prettyhezi.Game.Try.a.f6503a.integral : com.secret.prettyhezi.Game.i.f6608a.integral) < i6) {
            q(d1() + "不够");
            return;
        }
        k kVar = new k(bVar);
        String Name = bVar.Name();
        if (bVar.num > 1) {
            String str = Name + "(" + bVar.num + "期";
            if (bVar.is_bonus_stop > 0) {
                str = str + ",中奖即停";
            }
            Name = str + ")";
        }
        B("确定投注\n" + Name + "\n" + i6 + " " + d1() + "?", new l(bVar, kVar), false);
    }

    void T0() {
        this.f6309z = new com.secret.prettyhezi.Game.Number.l(this);
        this.f6306w.addView(this.f6309z, new LinearLayout.LayoutParams(-1, -2));
        this.f6309z.setVisibility(8);
        this.f6309z.setCurGameType(this.f6308y);
    }

    void U0() {
        Q(this.f6306w, Color.parseColor("#cccccc"), 0.5f, 12, 12, 12);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setPadding(0, g4.i.r(6.0f), 0, g4.i.r(6.0f));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        this.f6306w.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        this.H = g4.d.b(this, 12.0f, Color.parseColor("#555555"), "可投注额度: ");
        this.I = g4.d.a(this, 14.0f, Color.parseColor("#ffcc00"));
        linearLayout.addView(this.H, new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(this.I, new LinearLayout.LayoutParams(-2, -2));
        int parseColor = Color.parseColor("#555555");
        TextView b6 = g4.d.b(this, 12.0f, parseColor, "   我的" + d1() + ": ");
        this.G = g4.d.a(this, 14.0f, Color.parseColor("#ffcc00"));
        linearLayout.addView(b6, new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(this.G, new LinearLayout.LayoutParams(-2, -2));
        TextView textView = this.G;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6302s ? com.secret.prettyhezi.Game.Try.a.f6503a.integral : com.secret.prettyhezi.Game.i.f6608a.integral);
        sb.append(HttpUrl.FRAGMENT_ENCODE_SET);
        textView.setText(sb.toString());
        this.J = g4.d.c(this, 14, -1, this.f6302s ? "免费领币" : "充币", 17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(66.0f), g4.i.r(26.0f));
        layoutParams.leftMargin = g4.i.r(12.0f);
        this.J.setBackground(g4.i.d(g4.i.b(-16777216, 5.0f), g4.i.b(Color.parseColor("#666666"), 6.0f)));
        linearLayout.addView(this.J, layoutParams);
        linearLayout.setOnClickListener(new g());
    }

    void V0() {
        this.K = new com.secret.prettyhezi.Game.Number.f(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int r5 = g4.i.r(12.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        layoutParams.topMargin = g4.i.r(6.0f);
        this.f6306w.addView(this.K, layoutParams);
    }

    void W0(k.c cVar) {
        LinearLayout a6 = this.E.a();
        W(a6, Color.parseColor("#666666"), 0.5f, 0, 0, 0);
        a6.addView(com.secret.prettyhezi.Game.Number.f.c(this, cVar), new LinearLayout.LayoutParams(-1, g4.i.r(34.0f)));
    }

    void X0() {
        this.O = new com.secret.prettyhezi.Game.Number.j(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(8.0f);
        layoutParams.bottomMargin = g4.i.r(8.0f);
        this.f6306w.addView(this.O, layoutParams);
    }

    void Y0() {
        G0();
        com.secret.prettyhezi.j.t(j1() + "click/integral/json", com.secret.prettyhezi.f.e(new i.b()), com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new c(this));
    }

    int Z0() {
        Iterator it = this.N.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += ((k.c) it.next()).Value();
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a1() {
        Iterator it = this.N.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            k.c cVar = (k.c) it.next();
            if (cVar.isDXType()) {
                i6 += cVar.Value();
            }
        }
        return i6;
    }

    void b1() {
        this.f6308y = g4.g.a().d("keyNumberGameTypeIdx", 7);
        StringBuilder sb = new StringBuilder();
        sb.append(com.secret.prettyhezi.Game.Number.k.f6403a[this.f6308y].f6405b);
        sb.append(this.f6302s ? "(试玩)" : HttpUrl.FRAGMENT_ENCODE_SET);
        String sb2 = sb.toString();
        RelativeLayout N = N(this.f6305v, HttpUrl.FRAGMENT_ENCODE_SET, "往期回顾", new d());
        com.secret.prettyhezi.controls.i iVar = new com.secret.prettyhezi.controls.i(this, sb2);
        this.f6307x = iVar;
        iVar.a(new e());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(180.0f), g4.i.r(40.0f));
        layoutParams.addRule(13, -1);
        N.addView(this.f6307x, layoutParams);
    }

    void c1() {
        this.E.a().removeAllViews();
        Iterator it = this.N.iterator();
        while (it.hasNext()) {
            W0((k.c) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d1() {
        return !this.f6302s ? "金币" : "玩币";
    }

    void e1() {
        String str;
        String str2;
        k.e.a aVar = this.L;
        if (aVar == null) {
            return;
        }
        long j6 = aVar.end_value;
        if (com.secret.prettyhezi.Game.Try.a.f6503a.integral + Z0() >= j6) {
            E("提示", "当玩币数量低于" + j6 + "(包括已下注)时可以重新获取。", null, true);
            return;
        }
        String str3 = ("每局比赛每个人可以免费领取3次玩币，超过3次后需要花费" + com.secret.prettyhezi.Game.Try.a.f6503a.spend + "金币兑换玩币.") + "你已经免费领取" + com.secret.prettyhezi.Game.Try.a.f6503a.get_num + "次,";
        if (com.secret.prettyhezi.Game.Try.a.f6503a.get_num < 3) {
            str = str3 + "本次免费领取";
            str2 = "免费领取";
        } else {
            str = str3 + "本次领取需要花费" + com.secret.prettyhezi.Game.Try.a.f6503a.spend + "金币兑换.";
            str2 = com.secret.prettyhezi.Game.Try.a.f6503a.spend + "金币兑换";
        }
        C(str, new String[]{s0(C0382R.string.cancel), str2}, new b(), true);
    }

    void f1() {
        I0();
        com.secret.prettyhezi.j.q(j1() + "order/button/json", com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new h(this));
    }

    void g1() {
        com.secret.prettyhezi.j.t(j1() + "number/iscurrent/json", com.secret.prettyhezi.f.e(new i.b()), com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new i(this));
    }

    void h1() {
        com.secret.prettyhezi.j.q(j1() + "order/record/current/json", com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new j(this));
    }

    void i1() {
        com.secret.prettyhezi.j.q(com.secret.prettyhezi.Game.i.a() + "number/award/json?id=" + this.M.id, com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j1() {
        if (this.f6302s) {
            return com.secret.prettyhezi.Game.i.a() + "demo/";
        }
        return com.secret.prettyhezi.Game.i.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k1(int i6) {
        this.f6308y = i6;
        g4.g.a().n("keyNumberGameTypeIdx", i6);
        com.secret.prettyhezi.controls.i iVar = this.f6307x;
        StringBuilder sb = new StringBuilder();
        sb.append(com.secret.prettyhezi.Game.Number.k.f6403a[i6].f6405b);
        sb.append(this.f6302s ? "(试玩)" : HttpUrl.FRAGMENT_ENCODE_SET);
        iVar.b(false, sb.toString());
        this.f6309z.setVisibility(8);
        if (this.D == null || this.E == null) {
            return;
        }
        l1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.secret.prettyhezi.Game.Number.c, com.secret.prettyhezi.Game.Number.i] */
    void l1() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout linearLayout;
        com.secret.prettyhezi.Game.Number.h hVar;
        this.D.removeAllViews();
        if (this.f6308y == 7) {
            ?? cVar = new com.secret.prettyhezi.Game.Number.c(this);
            this.E = cVar;
            LinearLayout linearLayout2 = this.D;
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            hVar = cVar;
            linearLayout = linearLayout2;
        } else {
            com.secret.prettyhezi.Game.Number.h hVar2 = new com.secret.prettyhezi.Game.Number.h(this, this.f6308y);
            this.E = hVar2;
            LinearLayout linearLayout3 = this.D;
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            hVar = hVar2;
            linearLayout = linearLayout3;
        }
        linearLayout.addView(hVar, layoutParams);
        int i6 = this.f6303t;
        if (i6 == 1) {
            m1();
        } else if (i6 == 2) {
            o1();
        } else if (i6 == 3) {
            n1();
        }
        c1();
    }

    void m1() {
        this.C.f6375c.setText("下注剩余时间:");
        this.E.setGameEnabled(true);
    }

    void n1() {
        this.E.setGameEnabled(false);
        this.C.f6375c.setText("正在开奖:");
        this.E.b(this.f6304u);
    }

    void o1() {
        this.E.c();
        this.C.f6375c.setText("等待开奖:");
        this.E.setGameEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6302s = extras.getInt("id") == 1;
        } else {
            this.f6302s = false;
        }
        this.f6305v = C0();
        b1();
        this.f6305v.setBackgroundColor(-1);
        V(this.f6305v, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        LinearLayout e6 = e(this.f6305v);
        this.f6306w = e6;
        e6.setGravity(1);
        this.f6306w.setPadding(0, 0, 0, g4.i.r(40.0f));
        T0();
        this.A = 300;
        com.secret.prettyhezi.Game.Number.g gVar = new com.secret.prettyhezi.Game.Number.g(this);
        this.C = gVar;
        this.f6306w.addView(gVar, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(this);
        this.D = linearLayout;
        linearLayout.setOrientation(1);
        this.f6306w.addView(this.D, new LinearLayout.LayoutParams(-1, -2));
        U0();
        if (this.f6302s) {
            X0();
        }
        V0();
        f1();
    }

    void p1() {
        int currentTimeMillis = this.A - ((int) ((System.currentTimeMillis() - this.B) / 1000));
        if (currentTimeMillis <= 0) {
            this.f6304u = 0;
            g1();
            return;
        }
        k.f.a aVar = this.M;
        int i6 = aVar.open_time + aVar.stop_time;
        if (currentTimeMillis > i6) {
            currentTimeMillis -= i6;
            this.f6303t = 1;
            m1();
            if (currentTimeMillis % 5 == this.F && this.L.open != 1) {
                com.secret.prettyhezi.Game.Number.i iVar = this.E;
                if (iVar instanceof com.secret.prettyhezi.Game.Number.c) {
                    ((com.secret.prettyhezi.Game.Number.c) iVar).o();
                }
            }
        } else {
            int i7 = this.f6303t;
            if (i7 != 3) {
                if (i7 != 2) {
                    this.f6303t = 2;
                    com.secret.prettyhezi.Game.Number.i iVar2 = this.E;
                    if (iVar2 instanceof com.secret.prettyhezi.Game.Number.c) {
                        ((com.secret.prettyhezi.Game.Number.c) iVar2).o();
                    }
                    o1();
                }
                if (currentTimeMillis <= this.M.stop_time) {
                    i1();
                }
                int i8 = this.M.stop_time;
                if (currentTimeMillis >= i8 && this.f6303t == 2) {
                    currentTimeMillis -= i8;
                }
            }
        }
        this.C.f6376d.setText(String.format("%02d:%02d", Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)));
        if (isDestroyed() || isFinishing()) {
            return;
        }
        this.f6305v.postDelayed(new f(), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q1() {
        if (this.f6308y != 7) {
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            return;
        }
        this.H.setVisibility(0);
        this.I.setVisibility(0);
        com.secret.prettyhezi.Game.Number.c cVar = (com.secret.prettyhezi.Game.Number.c) this.E;
        int i6 = com.secret.prettyhezi.Game.Number.c.f6338n;
        if (this.f6302s && i6 == 9999999) {
            this.I.setText("无限");
            return;
        }
        TextView textView = this.I;
        textView.setText(HttpUrl.FRAGMENT_ENCODE_SET + (i6 - a1()));
    }

    void r1() {
        TextView textView = this.G;
        textView.setText(HttpUrl.FRAGMENT_ENCODE_SET + com.secret.prettyhezi.Game.Try.a.f6503a.integral);
        this.J.setText(com.secret.prettyhezi.Game.Try.a.f6503a.get_num >= 3 ? "兑换玩币" : "免费领币");
    }
}
