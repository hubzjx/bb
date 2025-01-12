package com.secret.prettyhezi.Game;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.Yzg4R57AT;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class VfHLXJ extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    int f6515r;

    /* renamed from: t  reason: collision with root package name */
    x f6517t;

    /* renamed from: u  reason: collision with root package name */
    public LinearLayout f6518u;

    /* renamed from: v  reason: collision with root package name */
    public LinearLayout f6519v;

    /* renamed from: w  reason: collision with root package name */
    public c0 f6520w;

    /* renamed from: x  reason: collision with root package name */
    LinearLayout f6521x;

    /* renamed from: y  reason: collision with root package name */
    com.secret.prettyhezi.Game.a f6522y;

    /* renamed from: s  reason: collision with root package name */
    int f6516s = -1;

    /* renamed from: z  reason: collision with root package name */
    public LinearLayout f6523z = null;
    TextView A = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            n nVar = (n) com.secret.prettyhezi.f.d(str, n.class);
            if (nVar.code != 200) {
                VfHLXJ.this.d1();
                if (!nVar.err.equals("GameEndedErr")) {
                    f(nVar.err);
                    return;
                }
                VfHLXJ.this.z("已抢完");
                VfHLXJ.this.c1();
                return;
            }
            VfHLXJ vfHLXJ = VfHLXJ.this;
            vfHLXJ.z("恭喜您抢到" + nVar.data.num + "注");
            VfHLXJ.this.T0(nVar.data);
            int Price = nVar.data.num * VfHLXJ.this.f6517t.Price();
            l0 l0Var = com.secret.prettyhezi.Game.i.f6608a;
            l0Var.integral = l0Var.integral - Price;
            TextView textView = VfHLXJ.this.A;
            textView.setText(com.secret.prettyhezi.Game.i.f6608a.integral + HttpUrl.FRAGMENT_ENCODE_SET);
            VfHLXJ.this.d1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends s.g {
        b(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            p pVar = (p) com.secret.prettyhezi.f.d(str, p.class);
            if (pVar.code != 200) {
                f(pVar.err);
                return;
            }
            VfHLXJ vfHLXJ = VfHLXJ.this;
            x xVar = vfHLXJ.f6517t;
            int i6 = xVar.id;
            p.a aVar = pVar.data;
            if (i6 == aVar.id) {
                xVar.sy_share = aVar.sy_share;
                vfHLXJ.f6520w.b(xVar);
                VfHLXJ vfHLXJ2 = VfHLXJ.this;
                if (vfHLXJ2.f6517t.sy_share == 0) {
                    vfHLXJ2.c1();
                }
            }
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
            v[] vVarArr = oVar.data;
            if (vVarArr == null || vVarArr.length <= 0) {
                return;
            }
            int i6 = 0;
            while (true) {
                v[] vVarArr2 = oVar.data;
                if (i6 >= vVarArr2.length) {
                    return;
                }
                VfHLXJ.this.T0(vVarArr2[i6]);
                i6++;
            }
        }
    }

    /* loaded from: classes.dex */
    class d extends g4.f {
        d() {
        }

        @Override // g4.f
        protected void a(View view) {
            Intent intent = new Intent(VfHLXJ.this, VHTs0MS.class);
            Bundle bundle = new Bundle();
            bundle.putInt("id", VfHLXJ.this.f6516s);
            bundle.putString("extra", VfHLXJ.this.f6517t.title);
            intent.putExtras(bundle);
            VfHLXJ.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {
        e() {
        }

        @Override // g4.f
        protected void a(View view) {
            VfHLXJ.this.a1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {
        f() {
        }

        @Override // g4.f
        protected void a(View view) {
            VfHLXJ.this.N0(Mrg1FaeY.class, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends g4.f {
        g() {
        }

        @Override // g4.f
        protected void a(View view) {
            VfHLXJ.this.M0(YmPvPjhN.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends g4.f {
        h() {
        }

        @Override // g4.f
        protected void a(View view) {
            VfHLXJ vfHLXJ = VfHLXJ.this;
            vfHLXJ.O0(Yzg4R57AT.class, vfHLXJ.f6517t.win_user.user_id, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends g4.f {
        i() {
        }

        @Override // g4.f
        protected void a(View view) {
            VfHLXJ vfHLXJ = VfHLXJ.this;
            vfHLXJ.N0(RP0JS.class, vfHLXJ.f6517t.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e0 f6533d;

        j(e0 e0Var) {
            this.f6533d = e0Var;
        }

        @Override // g4.f
        protected void a(View view) {
            Intent intent = new Intent(VfHLXJ.this, OFuSfzrsP.class);
            Bundle bundle = new Bundle();
            bundle.putInt("id", this.f6533d.number_id);
            bundle.putString("extra", this.f6533d.number_no);
            intent.putExtras(bundle);
            VfHLXJ.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k extends s.g {

        /* loaded from: classes.dex */
        class a extends g4.f {
            a() {
            }

            @Override // g4.f
            protected void a(View view) {
                VfHLXJ.this.c1();
            }
        }

        k(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            y yVar = (y) com.secret.prettyhezi.f.d(str, y.class);
            if (yVar.code != 200) {
                VfHLXJ.this.w0(yVar);
                return;
            }
            VfHLXJ vfHLXJ = VfHLXJ.this;
            x xVar = yVar.data;
            vfHLXJ.f6517t = xVar;
            vfHLXJ.f6520w.a(xVar);
            VfHLXJ.this.f6521x.removeAllViews();
            VfHLXJ vfHLXJ2 = VfHLXJ.this;
            x xVar2 = vfHLXJ2.f6517t;
            int i6 = xVar2.open;
            if (i6 == 1 || (i6 == 2 && xVar2.result == 0)) {
                vfHLXJ2.z(i6 == 1 ? "暂时不能下注，请稍后再来" : "你已经暂停夺宝游戏，不能夺宝");
            }
            VfHLXJ vfHLXJ3 = VfHLXJ.this;
            int i7 = vfHLXJ3.f6517t.result;
            if (i7 == 0) {
                vfHLXJ3.S0();
            } else if (i7 == 1) {
                TextView c6 = g4.d.c(vfHLXJ3, 22, -65536, "正在生成抽奖结果", 17);
                VfHLXJ.this.f6521x.addView(c6, new LinearLayout.LayoutParams(-1, g4.i.r(100.0f)));
                c6.setOnClickListener(new a());
            } else if (i7 > 1) {
                vfHLXJ3.X0();
                VfHLXJ.this.W0();
            }
            VfHLXJ vfHLXJ4 = VfHLXJ.this;
            vfHLXJ4.Z0(vfHLXJ4.f6515r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6537a;

        /* loaded from: classes.dex */
        class a implements a.f {
            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                l lVar = l.this;
                VfHLXJ.this.b1(lVar.f6537a);
            }
        }

        l(int i6) {
            this.f6537a = i6;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            com.secret.prettyhezi.Device.a.b(VfHLXJ.this, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class m implements Serializable {
        int buyNums;
        int id;
        String passwd = com.secret.prettyhezi.Device.a.a();

        public m(int i6, int i7) {
            this.id = i6;
            this.buyNums = i7;
        }
    }

    /* loaded from: classes.dex */
    static class n extends com.secret.prettyhezi.Server.w {
        public v data;

        n() {
        }
    }

    /* loaded from: classes.dex */
    static class o extends com.secret.prettyhezi.Server.w {
        public v[] data;

        o() {
        }
    }

    /* loaded from: classes.dex */
    static class p extends com.secret.prettyhezi.Server.w {
        a data;

        /* loaded from: classes.dex */
        static class a implements Serializable {
            public int id;
            public int sy_share;

            a() {
            }
        }

        p() {
        }
    }

    void S0() {
        this.f6522y = new com.secret.prettyhezi.Game.a(this, "下", "注");
        this.f6521x.addView(this.f6522y, new LinearLayout.LayoutParams(-2, g4.i.r(42.0f)));
        TextView c6 = g4.d.c(this, 16, -1, "立即夺宝", 17);
        c6.setBackground(g4.i.e(g4.i.b(-65536, 5.0f), g4.i.b(Color.parseColor("#aa0000"), 5.0f), g4.i.b(Color.parseColor("#cccccc"), 5.0f)));
        int i6 = this.f6517t.open;
        if (i6 == 1 || i6 == 2) {
            c6.setEnabled(false);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(150.0f), g4.i.r(42.0f));
        layoutParams.topMargin = g4.i.r(20.0f);
        c6.setOnClickListener(new e());
        this.f6521x.addView(c6, layoutParams);
        Q(this.f6521x, Color.parseColor("#cccccc"), 0.5f, 12, 20, 12);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setPadding(0, g4.i.r(12.0f), 0, g4.i.r(6.0f));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        this.f6521x.addView(linearLayout, new LinearLayout.LayoutParams(-2, -2));
        TextView b6 = g4.d.b(this, 12.0f, Color.parseColor("#555555"), "  我的金币: ");
        this.A = g4.d.a(this, 14.0f, Color.parseColor("#ffcc00"));
        linearLayout.addView(b6, new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(this.A, new LinearLayout.LayoutParams(-2, -2));
        TextView textView = this.A;
        textView.setText(com.secret.prettyhezi.Game.i.f6608a.integral + HttpUrl.FRAGMENT_ENCODE_SET);
        TextView c7 = g4.d.c(this, 14, -1, "充币", 17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(32.0f));
        layoutParams2.leftMargin = g4.i.r(12.0f);
        c7.setBackground(g4.i.d(g4.i.b(-16777216, 5.0f), g4.i.b(Color.parseColor("#666666"), 6.0f)));
        linearLayout.addView(c7, layoutParams2);
        linearLayout.setOnClickListener(new f());
        TextView c8 = g4.d.c(this, 14, -1, "我的夺宝", 17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(80.0f), g4.i.r(32.0f));
        layoutParams3.leftMargin = g4.i.r(12.0f);
        c8.setBackground(g4.i.d(g4.i.b(-16777216, 5.0f), g4.i.b(Color.parseColor("#666666"), 6.0f)));
        linearLayout.addView(c8, layoutParams3);
        c8.setOnClickListener(new g());
    }

    void T0(v vVar) {
        if (this.f6523z == null) {
            LinearLayout linearLayout = new LinearLayout(this);
            this.f6523z = linearLayout;
            linearLayout.setPadding(g4.i.r(12.0f), g4.i.r(20.0f), g4.i.r(12.0f), 0);
            this.f6523z.setOrientation(1);
            new LinearLayout.LayoutParams(-1, -2).topMargin = g4.i.r(16.0f);
            this.f6519v.addView(this.f6523z);
            this.f6523z.addView(g4.d.b(this, 16.0f, -16777216, "我的夺宝号码"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = g4.i.r(10.0f);
            this.f6523z.addView(w.a(this), layoutParams);
            W(this.f6523z, Color.parseColor("#cccccc"), 0.5f, 0, 10, 0);
        }
        w wVar = new w(this);
        wVar.b(vVar);
        this.f6523z.addView(wVar, new LinearLayout.LayoutParams(-1, g4.i.r(36.0f)));
        Q(this.f6523z, Color.parseColor("#cccccc"), 0.5f, 0, 0, 0);
    }

    LinearLayout U0(String str) {
        return OFuSfzrsP.S0(this, this.f6521x, str, 65);
    }

    void V0(String str, String str2) {
        OFuSfzrsP.U0(this, this.f6521x, str, str2, 65);
    }

    void W0() {
        TextView b6 = g4.d.b(this, 14.0f, -16777216, "开奖详情:");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = g4.i.r(8.0f);
        layoutParams.leftMargin = g4.i.r(12.0f);
        this.f6521x.addView(b6, layoutParams);
        e0 e0Var = this.f6517t.open_award;
        V0("起止号码", HttpUrl.FRAGMENT_ENCODE_SET + e0Var.begin_number);
        LinearLayout U0 = U0("时间求和");
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        U0.addView(linearLayout, new LinearLayout.LayoutParams(0, -2, 1.0f));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        int parseColor = Color.parseColor("#333333");
        linearLayout2.addView(g4.d.b(this, 12.0f, parseColor, e0Var.limit_n_num + " - "), new LinearLayout.LayoutParams(-2, -2));
        TextView b7 = g4.d.b(this, 12.0f, Color.parseColor("#0000ff"), "夺宝下注详情");
        linearLayout2.addView(b7, new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(g4.d.b(this, 12.0f, Color.parseColor("#666666"), "(任选50条订单时间求和,不足50取全部订单)"), new LinearLayout.LayoutParams(-2, -2));
        b7.setOnClickListener(new i());
        LinearLayout U02 = U0("5位数字");
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(1);
        U02.addView(linearLayout3, new LinearLayout.LayoutParams(0, -2, 1.0f));
        LinearLayout linearLayout4 = new LinearLayout(this);
        linearLayout4.setOrientation(0);
        linearLayout3.addView(linearLayout4, new LinearLayout.LayoutParams(-1, -2));
        int parseColor2 = Color.parseColor("#333333");
        linearLayout4.addView(g4.d.b(this, 12.0f, parseColor2, e0Var.str_sum + " - "), new LinearLayout.LayoutParams(-2, -2));
        TextView b8 = g4.d.b(this, 12.0f, Color.parseColor("#0000ff"), "数字游戏详情");
        linearLayout4.addView(b8, new LinearLayout.LayoutParams(-2, -2));
        linearLayout3.addView(g4.d.b(this, 12.0f, Color.parseColor("#666666"), "(同期数字游戏开奖串五位数字)"), new LinearLayout.LayoutParams(-2, -2));
        b8.setOnClickListener(new j(e0Var));
        LinearLayout U03 = U0("余数计算");
        LinearLayout linearLayout5 = new LinearLayout(this);
        linearLayout5.setOrientation(1);
        U03.addView(linearLayout5, new LinearLayout.LayoutParams(0, -2, 1.0f));
        long parseLong = (e0Var.limit_n_num + Long.parseLong(e0Var.str_sum)) % this.f6517t.share;
        linearLayout5.addView(g4.d.b(this, 12.0f, Color.parseColor("#333333"), "(" + e0Var.limit_n_num + k5.d.ANY_NON_NULL_MARKER + e0Var.str_sum + ")%" + this.f6517t.share + "=" + parseLong), new LinearLayout.LayoutParams(-2, -2));
        linearLayout5.addView(g4.d.b(this, 12.0f, Color.parseColor("#666666"), "(时间之和+五位数字) 除以 总注数 取余数"), new LinearLayout.LayoutParams(-2, -2));
        StringBuilder sb = new StringBuilder();
        sb.append(HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(parseLong);
        V0("余数", sb.toString());
        LinearLayout U04 = U0("幸运数字");
        LinearLayout linearLayout6 = new LinearLayout(this);
        linearLayout6.setOrientation(1);
        U04.addView(linearLayout6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout6.addView(g4.d.b(this, 12.0f, Color.parseColor("#333333"), e0Var.begin_number + k5.d.ANY_NON_NULL_MARKER + parseLong + "=" + (e0Var.begin_number + parseLong)), new LinearLayout.LayoutParams(-2, -2));
        linearLayout6.addView(g4.d.b(this, 12.0f, Color.parseColor("#666666"), "(起止号码 + 余数)"), new LinearLayout.LayoutParams(-2, -2));
    }

    void X0() {
        if (this.f6517t.win_user != null) {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setBackground(g4.i.d(g4.i.b(Color.parseColor("#ff0000"), 10.0f), g4.i.b(Color.parseColor("#ee0000"), 10.0f)));
            linearLayout.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(100.0f));
            int r5 = g4.i.r(12.0f);
            layoutParams.rightMargin = r5;
            layoutParams.leftMargin = r5;
            layoutParams.topMargin = g4.i.r(12.0f);
            layoutParams.bottomMargin = g4.i.r(20.0f);
            this.f6521x.addView(linearLayout, layoutParams);
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(81);
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
            linearLayout2.addView(g4.d.c(this, 14, Color.parseColor("#f0f0f0"), "幸运号码:", 5), new LinearLayout.LayoutParams(g4.i.r(80.0f), -2));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(190.0f), -2);
            layoutParams2.leftMargin = g4.i.r(10.0f);
            int parseColor = Color.parseColor("#f0f0f0");
            linearLayout2.addView(g4.d.b(this, 28.0f, parseColor, HttpUrl.FRAGMENT_ENCODE_SET + this.f6517t.open_award.lucky_number), layoutParams2);
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(0);
            linearLayout3.setGravity(81);
            linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
            linearLayout3.addView(g4.d.c(this, 14, Color.parseColor("#f0f0f0"), "中奖人:", 5), new LinearLayout.LayoutParams(g4.i.r(80.0f), -2));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(190.0f), -2);
            layoutParams3.leftMargin = g4.i.r(10.0f);
            int parseColor2 = Color.parseColor("#f0f0f0");
            TextView b6 = g4.d.b(this, 28.0f, parseColor2, HttpUrl.FRAGMENT_ENCODE_SET + this.f6517t.win_user.username);
            b6.setSingleLine();
            linearLayout3.addView(b6, layoutParams3);
            linearLayout.setOnClickListener(new h());
        }
    }

    void Y0() {
        LinearLayout linearLayout = this.f6523z;
        if (linearLayout == null) {
            return;
        }
        int childCount = linearLayout.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 3) {
                return;
            }
            this.f6523z.removeViewAt(childCount);
        }
    }

    public void Z0(int i6) {
        Y0();
        com.secret.prettyhezi.j.q(com.secret.prettyhezi.Game.i.a() + "loot/record/json?lootid=" + i6, com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new c(this));
    }

    void a1() {
        long j6 = this.f6517t.pn;
        if (j6 > 0 && j6 > System.currentTimeMillis() / 1000) {
            z("您的对应权限未过期，不能夺宝本内容");
            return;
        }
        int a6 = this.f6522y.a();
        if (a6 <= 0) {
            q("请填写正确的下注额");
            return;
        }
        B("确定花" + (this.f6517t.Price() * a6) + "金币下" + a6 + "注" + this.f6517t.title + "?", new l(a6), false);
    }

    void b1(int i6) {
        I0();
        com.secret.prettyhezi.j.t(com.secret.prettyhezi.Game.i.a() + "loot/bet/json", com.secret.prettyhezi.f.e(new m(this.f6517t.id, i6)), com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new a(this));
    }

    void c1() {
        I0();
        com.secret.prettyhezi.j.q(com.secret.prettyhezi.Game.i.a() + "loot/view/json?id=" + this.f6515r, com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new k(this));
    }

    void d1() {
        com.secret.prettyhezi.j.q(com.secret.prettyhezi.Game.i.a() + "loot/syshare/json?id=" + this.f6517t.id, com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new b(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6515r = extras.getInt("id");
            this.f6516s = extras.getInt("type", -1);
        }
        LinearLayout C0 = C0();
        this.f6518u = C0;
        if (this.f6516s == -1) {
            M(C0, "夺宝详情");
        } else {
            N(C0, "夺宝游戏", "往期回顾", new d());
        }
        W(this.f6518u, Color.parseColor("#cccccc"), 0.5f, 0, 0, 0);
        LinearLayout e6 = e(this.f6518u);
        this.f6519v = e6;
        e6.setBackgroundColor(Color.parseColor("#f0f0f0"));
        this.f6519v.setPadding(0, 0, 0, g4.i.r(20.0f));
        this.f6519v.setBackgroundColor(-1);
        c0 c0Var = new c0(this);
        this.f6520w = c0Var;
        this.f6519v.addView(c0Var, new LinearLayout.LayoutParams(-1, -2));
        W(this.f6519v, Color.parseColor("#cccccc"), 0.5f, 12, 12, 12);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f6521x = linearLayout;
        linearLayout.setOrientation(1);
        this.f6521x.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(12.0f);
        this.f6519v.addView(this.f6521x, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        x xVar = this.f6517t;
        if (xVar == null || xVar.result < 2) {
            c1();
        }
    }
}
