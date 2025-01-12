package com.secret.prettyhezi.Game.Number;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.abc;
import com.secret.prettyhezi.Game.Number.k;
import com.secret.prettyhezi.Game.i;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import e4.c;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class c extends LinearLayout implements i {

    /* renamed from: m  reason: collision with root package name */
    public static final String[] f6337m = {"大", "小", "单", "双", "大单", "大双", "小单", "小双"};

    /* renamed from: n  reason: collision with root package name */
    static int f6338n;

    /* renamed from: b  reason: collision with root package name */
    POjTJ f6339b;

    /* renamed from: c  reason: collision with root package name */
    com.secret.prettyhezi.Game.Number.b[] f6340c;

    /* renamed from: d  reason: collision with root package name */
    e4.c f6341d;

    /* renamed from: e  reason: collision with root package name */
    e4.c f6342e;

    /* renamed from: f  reason: collision with root package name */
    TextView f6343f;

    /* renamed from: g  reason: collision with root package name */
    int f6344g;

    /* renamed from: h  reason: collision with root package name */
    TextView f6345h;

    /* renamed from: i  reason: collision with root package name */
    com.secret.prettyhezi.Game.Number.a f6346i;

    /* renamed from: j  reason: collision with root package name */
    TextView f6347j;

    /* renamed from: k  reason: collision with root package name */
    TextView f6348k;

    /* renamed from: l  reason: collision with root package name */
    LinearLayout f6349l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f6350b;

        a(int i6) {
            this.f6350b = i6;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.n(this.f6350b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f6352b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f6353c;

        b(boolean z5, int i6) {
            this.f6352b = z5;
            this.f6353c = i6;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f6352b) {
                c cVar = c.this;
                cVar.f6344g += cVar.f6339b.L.buttons[this.f6353c];
                c.a aVar = new c.a(view.getWidth(), view.getHeight());
                ((ViewGroup.MarginLayoutParams) aVar).rightMargin = g4.i.r(4.0f);
                ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = g4.i.r(4.0f);
                c cVar2 = c.this;
                cVar2.f6342e.addView(cVar2.j(this.f6353c, false), aVar);
            } else {
                c cVar3 = c.this;
                cVar3.f6344g -= cVar3.f6339b.L.buttons[this.f6353c];
                ((ViewGroup) view.getParent()).removeView(view);
            }
            c.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.secret.prettyhezi.Game.Number.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0080c implements com.secret.prettyhezi.e {
        C0080c() {
        }

        @Override // com.secret.prettyhezi.e
        public void a(int i6) {
            c.this.m();
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
                c.this.c();
            }
        }

        d() {
        }

        @Override // g4.f
        protected void a(View view) {
            c.this.f6339b.B("清空所有下注筹码？", new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {
        e() {
        }

        @Override // g4.f
        protected void a(View view) {
            c.this.l();
        }
    }

    /* loaded from: classes.dex */
    class f extends s.g {
        f(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            if (c.this.f6339b.f6308y != 7) {
                return;
            }
            k.g gVar = (k.g) com.secret.prettyhezi.f.d(str, k.g.class);
            if (gVar.code == 200) {
                com.secret.prettyhezi.Game.Number.b.c(c.this.f6340c, gVar.data);
            } else {
                f(gVar.err);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends s.g {
        g(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            k.h hVar = (k.h) com.secret.prettyhezi.f.d(str, k.h.class);
            if (hVar.code != 200) {
                c.this.f6339b.w0(hVar);
                return;
            }
            c.f6338n = hVar.data.quota_integral;
            c.this.f6339b.q1();
        }
    }

    public c(POjTJ pOjTJ) {
        super(pOjTJ);
        this.f6339b = pOjTJ;
        setOrientation(1);
        h();
        i();
        g();
        k();
    }

    public static TextView d(ZZcINlcxH zZcINlcxH, LinearLayout linearLayout) {
        return e(zZcINlcxH, "投注", linearLayout);
    }

    public static TextView e(ZZcINlcxH zZcINlcxH, String str, LinearLayout linearLayout) {
        TextView c6 = g4.d.c(zZcINlcxH, 14, -65536, str, 17);
        c6.setTextColor(g4.i.q(-65536, -65536, -65536, -1));
        c6.setBackground(g4.i.e(g4.i.b(-256, 5.0f), g4.i.b(Color.parseColor("#666666"), 5.0f), g4.i.b(Color.parseColor("#999999"), 5.0f)));
        linearLayout.addView(c6, new LinearLayout.LayoutParams(g4.i.r(70.0f), g4.i.r(32.0f)));
        return c6;
    }

    public static TextView f(ZZcINlcxH zZcINlcxH, LinearLayout linearLayout) {
        TextView c6 = g4.d.c(zZcINlcxH, 14, -1, "清空", 17);
        c6.setBackground(g4.i.e(g4.i.b(-16777216, 5.0f), g4.i.b(Color.parseColor("#666666"), 5.0f), g4.i.b(Color.parseColor("#999999"), 5.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(70.0f), g4.i.r(32.0f));
        layoutParams.rightMargin = g4.i.r(12.0f);
        linearLayout.addView(c6, layoutParams);
        return c6;
    }

    @Override // com.secret.prettyhezi.Game.Number.i
    public LinearLayout a() {
        return this.f6349l;
    }

    @Override // com.secret.prettyhezi.Game.Number.i
    public void b(int i6) {
        String str;
        if (i6 > 0) {
            int i7 = (i6 / 100) + ((i6 % 100) / 10) + (i6 % 10);
            String str2 = i7 >= 14 ? "大" : "小";
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(i7 % 2 == 1 ? "单" : "双");
            str = sb.toString();
        } else {
            str = "  ";
        }
        for (int i8 = 0; i8 < this.f6340c.length; i8++) {
            boolean contains = str.contains(f6337m[i8]);
            this.f6340c[i8].setSelected(contains);
            if (contains) {
                this.f6339b.f(this.f6340c[i8], 0.8f);
            }
        }
    }

    @Override // com.secret.prettyhezi.Game.Number.i
    public void c() {
        this.f6342e.removeAllViews();
        this.f6344g = 0;
        com.secret.prettyhezi.Game.Number.a aVar = this.f6346i;
        if (aVar != null) {
            aVar.c(1);
        }
        m();
    }

    void g() {
        int i6;
        int i7;
        int r5 = this.f6339b.o().x - g4.i.r(20.0f);
        int r6 = r5 > g4.i.r(500.0f) ? g4.i.r(40.0f) : g4.i.r(10.0f);
        int r7 = g4.i.r(16.0f);
        int i8 = (r5 - (r7 * 6)) / 5;
        int r8 = g4.i.r(80.0f);
        if (i8 > r8) {
            r7 = (r5 - (r8 * 5)) / 6;
            i8 = r8;
        }
        e4.c cVar = new e4.c(this.f6339b);
        this.f6341d = cVar;
        int i9 = r6 / 2;
        cVar.setPadding(i9, g4.i.r(20.0f), i9, 0);
        addView(this.f6341d, new LinearLayout.LayoutParams(-1, -2));
        for (int i10 = 0; i10 < this.f6339b.L.buttons.length; i10++) {
            if (i10 >= 5) {
                i7 = (i8 * 5) / 4;
                i6 = (r7 * 6) / 5;
            } else {
                i6 = r7;
                i7 = i8;
            }
            RelativeLayout j6 = j(i10, true);
            c.a aVar = new c.a(i7, g4.i.r(40.0f));
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = i6;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = g4.i.r(10.0f);
            this.f6341d.addView(j6, aVar);
        }
    }

    void h() {
        int r5 = ((this.f6339b.o().x - (g4.i.r(12.0f) * 2)) / 4) - g4.i.r(2.0f);
        int r6 = g4.i.r(100.0f);
        if (r5 > r6) {
            r5 = r6;
        }
        LinearLayout linearLayout = new LinearLayout(this.f6339b);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setPadding(0, g4.i.r(1.0f), 0, g4.i.r(1.0f));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(this.f6339b);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        linearLayout2.setPadding(0, g4.i.r(1.0f), 0, g4.i.r(1.0f));
        addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        this.f6340c = new com.secret.prettyhezi.Game.Number.b[8];
        for (int i6 = 0; i6 < 8; i6++) {
            this.f6340c[i6] = new com.secret.prettyhezi.Game.Number.b(this.f6339b, f6337m[i6]);
            this.f6340c[i6].setBackground(g4.i.h(g4.i.c(Color.parseColor("#888888"), 5.0f, Color.parseColor("#aaaaaa"), 4.0f), g4.i.c(-16777216, 5.0f, -65536, 4.0f), g4.i.c(-16777216, 5.0f, -65536, 4.0f)));
            this.f6340c[i6].setOnClickListener(new a(i6));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r5, g4.i.r(70.0f));
            if (i6 % 4 != 3) {
                layoutParams.rightMargin = g4.i.r(2.0f);
            }
            com.secret.prettyhezi.Game.Number.b[] bVarArr = this.f6340c;
            if (i6 < 4) {
                linearLayout.addView(bVarArr[i6], layoutParams);
            } else {
                linearLayout2.addView(bVarArr[i6], layoutParams);
            }
        }
    }

    void i() {
        LinearLayout linearLayout = new LinearLayout(this.f6339b);
        linearLayout.setOrientation(1);
        linearLayout.setBackground(g4.i.c(Color.parseColor("#dddddd"), 5.0f, -16777216, 2.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int r5 = g4.i.r(12.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        layoutParams.topMargin = g4.i.r(6.0f);
        addView(linearLayout, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.f6339b);
        relativeLayout.setMinimumHeight(g4.i.r(60.0f));
        linearLayout.addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -2));
        e4.c cVar = new e4.c(this.f6339b);
        this.f6342e = cVar;
        cVar.setPadding(g4.i.r(8.0f), g4.i.r(8.0f), g4.i.r(8.0f), 0);
        this.f6342e.setMinimumHeight(g4.i.r(60.0f));
        relativeLayout.addView(this.f6342e, new RelativeLayout.LayoutParams(-1, -2));
        this.f6339b.Q(linearLayout, Color.parseColor("#666666"), 0.5f, 8, 4, 8);
        POjTJ pOjTJ = this.f6339b;
        if (pOjTJ.M.buy_num > 1) {
            this.f6346i = new com.secret.prettyhezi.Game.Number.a(pOjTJ, new C0080c());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = g4.i.r(2.0f);
            linearLayout.addView(this.f6346i, layoutParams2);
            this.f6339b.Q(linearLayout, Color.parseColor("#666666"), 0.5f, 8, 4, 8);
        }
        LinearLayout linearLayout2 = new LinearLayout(this.f6339b);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(21);
        linearLayout2.setPadding(g4.i.r(8.0f), 0, g4.i.r(8.0f), 0);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, g4.i.r(42.0f)));
        this.f6343f = g4.d.b(this.f6339b, 14.0f, -65536, "请先选择投注方位");
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.rightMargin = g4.i.r(10.0f);
        linearLayout2.addView(this.f6343f, layoutParams3);
        POjTJ pOjTJ2 = this.f6339b;
        TextView c6 = g4.d.c(pOjTJ2, 16, -65536, "0" + this.f6339b.d1(), 17);
        this.f6345h = c6;
        c6.setMinWidth(g4.i.r(40.0f));
        linearLayout2.addView(this.f6345h, new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.addView(new View(this.f6339b), new LinearLayout.LayoutParams(0, g4.i.r(20.0f), 1.0f));
        TextView f6 = f(this.f6339b, linearLayout2);
        this.f6347j = f6;
        f6.setOnClickListener(new d());
        TextView d6 = d(this.f6339b, linearLayout2);
        this.f6348k = d6;
        d6.setOnClickListener(new e());
        LinearLayout linearLayout3 = new LinearLayout(this.f6339b);
        this.f6349l = linearLayout3;
        linearLayout3.setOrientation(1);
        linearLayout.addView(this.f6349l, new LinearLayout.LayoutParams(-1, -2));
    }

    RelativeLayout j(int i6, boolean z5) {
        com.secret.prettyhezi.Game.Number.d dVar = new com.secret.prettyhezi.Game.Number.d(this.f6339b, this.f6339b.L.buttons[i6], z5);
        dVar.setOnClickListener(new b(z5, i6));
        return dVar;
    }

    void k() {
        int i6 = 0;
        while (true) {
            com.secret.prettyhezi.Game.Number.b[] bVarArr = this.f6340c;
            if (i6 >= bVarArr.length) {
                break;
            }
            bVarArr[i6].d(i6 < 4 ? this.f6339b.M.pl.vote_type8 : this.f6339b.M.pl.vote_type9);
            i6++;
        }
        int i7 = 0;
        while (true) {
            com.secret.prettyhezi.Game.Number.b[] bVarArr2 = this.f6340c;
            if (i7 >= bVarArr2.length) {
                break;
            }
            bVarArr2[i7].setSelected(false);
            i7++;
        }
        this.f6348k.setEnabled(this.f6339b.L.open == 0);
        q();
        p();
    }

    void l() {
        if (f6338n - this.f6339b.a1() < this.f6344g) {
            this.f6339b.q("下注金额超过最大配额");
            return;
        }
        k.b bVar = new k.b();
        k.f.a aVar = this.f6339b.M;
        bVar.id = aVar.id;
        if (aVar.buy_num > 1) {
            int a6 = this.f6346i.a();
            bVar.num = a6;
            bVar.integralSum = this.f6344g * a6;
            bVar.is_bonus_stop = this.f6346i.b() ? 1 : 0;
        } else {
            bVar.integralSum = this.f6344g;
        }
        if (!com.secret.prettyhezi.Game.Number.b.a(this.f6340c, bVar, this.f6344g)) {
            this.f6339b.q("请选择投注方位");
            return;
        }
        bVar.vote_type = bVar.calcDXType();
        this.f6339b.S0(bVar);
    }

    void m() {
        int i6 = this.f6344g;
        if (this.f6339b.M.buy_num > 1) {
            i6 *= this.f6346i.a();
        }
        TextView textView = this.f6345h;
        textView.setText(i6 + this.f6339b.d1());
    }

    void n(int i6) {
        if (this.f6339b.f6303t != 1) {
            return;
        }
        int i7 = 0;
        while (true) {
            com.secret.prettyhezi.Game.Number.b[] bVarArr = this.f6340c;
            if (i7 >= bVarArr.length) {
                q();
                return;
            } else {
                bVarArr[i7].setSelected(i6 == i7);
                i7++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        if (this.f6339b.f6308y != 7) {
            return;
        }
        com.secret.prettyhezi.j.q(this.f6339b.j1() + abc.amu("u0") + "id=" + this.f6339b.M.id, com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new f(this.f6339b));
    }

    void p() {
        com.secret.prettyhezi.j.t(this.f6339b.j1() + "order/quota/json", com.secret.prettyhezi.f.e(new i.b()), com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new g(this.f6339b));
    }

    void q() {
        String str;
        TextView textView;
        float f6;
        int i6 = 0;
        while (true) {
            com.secret.prettyhezi.Game.Number.b[] bVarArr = this.f6340c;
            if (i6 >= bVarArr.length) {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
                break;
            } else if (bVarArr[i6].isSelected()) {
                str = f6337m[i6];
                break;
            } else {
                i6++;
            }
        }
        if (str.length() > 0) {
            this.f6343f.setText(str);
            textView = this.f6343f;
            f6 = 18.0f;
        } else {
            this.f6343f.setText("请先选择投注方位");
            textView = this.f6343f;
            f6 = 14.0f;
        }
        textView.setTextSize(f6);
    }

    @Override // com.secret.prettyhezi.Game.Number.i
    public void setGameEnabled(boolean z5) {
        int childCount = this.f6341d.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            this.f6341d.getChildAt(i6).setEnabled(z5);
        }
        this.f6347j.setEnabled(z5);
        if (this.f6339b.L.open == 0) {
            this.f6348k.setEnabled(z5 && this.f6344g > 0);
        }
        int i7 = 0;
        while (true) {
            com.secret.prettyhezi.Game.Number.b[] bVarArr = this.f6340c;
            if (i7 >= bVarArr.length) {
                return;
            }
            bVarArr[i7].setEnabled(z5);
            if (!z5) {
                this.f6340c[i7].setSelected(false);
            }
            i7++;
        }
    }
}
