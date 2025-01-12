package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class RP0JS extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    int f6462r;

    /* renamed from: s  reason: collision with root package name */
    public LinearLayout f6463s;

    /* renamed from: t  reason: collision with root package name */
    public LinearLayout f6464t;

    /* renamed from: u  reason: collision with root package name */
    int f6465u = -1;

    /* renamed from: v  reason: collision with root package name */
    boolean f6466v = false;

    /* renamed from: w  reason: collision with root package name */
    int f6467w = g4.i.r(100.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            u uVar = (u) com.secret.prettyhezi.f.d(str, u.class);
            if (uVar.code != 200) {
                RP0JS.this.w0(uVar);
                return;
            }
            i0[] i0VarArr = uVar.data;
            if (i0VarArr == null || i0VarArr.length <= 0) {
                return;
            }
            long j6 = 0;
            int i6 = 0;
            while (true) {
                i0[] i0VarArr2 = uVar.data;
                if (i6 >= i0VarArr2.length) {
                    break;
                }
                RP0JS.this.T0(i0VarArr2[i6]);
                j6 += Long.parseLong(uVar.data[i6].time_char);
                i6++;
            }
            RP0JS rp0js = RP0JS.this;
            LinearLayout linearLayout = new LinearLayout(rp0js);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            RP0JS.this.f6464t.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(40.0f)));
            TextView c6 = g4.d.c(rp0js, 12, Color.parseColor("#333333"), "总和:", 5);
            c6.setPadding(0, 0, g4.i.r(4.0f), 0);
            linearLayout.addView(c6, new LinearLayout.LayoutParams(0, -2, 3.8f));
            linearLayout.addView(g4.d.b(rp0js, 12.0f, -65536, HttpUrl.FRAGMENT_ENCODE_SET + j6), new LinearLayout.LayoutParams(0, -2, 1.0f));
            RP0JS rp0js2 = RP0JS.this;
            rp0js2.Q(rp0js2.f6464t, Color.parseColor("#cccccc"), 0.5f, 0, 0, 0);
            if (uVar.data.length >= 50) {
                RP0JS.this.U0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnScrollChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ScrollView f6469a;

        b(ScrollView scrollView) {
            this.f6469a = scrollView;
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i6, int i7, int i8, int i9) {
            RP0JS rp0js = RP0JS.this;
            if (rp0js.f6465u < 0 || rp0js.f6466v || i7 <= i9) {
                return;
            }
            int height = i7 + this.f6469a.getHeight();
            int height2 = RP0JS.this.f6464t.getHeight();
            RP0JS rp0js2 = RP0JS.this;
            if (height > height2 - rp0js2.f6467w) {
                rp0js2.V0();
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
            d.a aVar;
            int i6 = 0;
            RP0JS.this.f6466v = false;
            d dVar = (d) com.secret.prettyhezi.f.d(str, d.class);
            if (dVar.code != 200) {
                f(dVar.err);
                return;
            }
            d.a aVar2 = dVar.data;
            if (aVar2 == null || aVar2.items.length <= 0) {
                RP0JS.this.f6465u = -1;
                return;
            }
            RP0JS.this.f6465u++;
            while (true) {
                aVar = dVar.data;
                i0[] i0VarArr = aVar.items;
                if (i6 >= i0VarArr.length) {
                    break;
                }
                RP0JS.this.T0(i0VarArr[i6]);
                i6++;
            }
            int i7 = aVar.pages;
            RP0JS rp0js = RP0JS.this;
            if (i7 < rp0js.f6465u) {
                rp0js.f6465u = -1;
            }
            if (Build.VERSION.SDK_INT >= 23 || rp0js.f6465u <= 0) {
                return;
            }
            rp0js.V0();
        }
    }

    /* loaded from: classes.dex */
    static class d extends com.secret.prettyhezi.Server.w {
        public a data;

        /* loaded from: classes.dex */
        public static class a implements Serializable {
            public i0[] items;
            public int pages;
            public int total;
        }

        d() {
        }
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(Color.parseColor("#cccccc"));
        linearLayout.setPadding(g4.i.r(6.0f), 0, g4.i.r(6.0f), g4.i.r(0.0f));
        this.f6463s.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(36.0f)));
        TextView b6 = g4.d.b(this, 11.0f, Color.parseColor("#333333"), "昵称");
        TextView b7 = g4.d.b(this, 11.0f, Color.parseColor("#333333"), "数量");
        TextView b8 = g4.d.b(this, 11.0f, Color.parseColor("#333333"), "号码");
        TextView b9 = g4.d.b(this, 11.0f, Color.parseColor("#333333"), "中奖");
        TextView b10 = g4.d.b(this, 11.0f, Color.parseColor("#333333"), "下注时间");
        TextView b11 = g4.d.b(this, 11.0f, Color.parseColor("#333333"), "时间值");
        linearLayout.addView(b6, new LinearLayout.LayoutParams(0, -2, 1.8f));
        linearLayout.addView(b7, new LinearLayout.LayoutParams(0, -2, 0.7f));
        linearLayout.addView(b8, new LinearLayout.LayoutParams(0, -2, 2.4f));
        linearLayout.addView(b9, new LinearLayout.LayoutParams(0, -2, 0.7f));
        linearLayout.addView(b10, new LinearLayout.LayoutParams(0, -2, 2.2f));
        linearLayout.addView(b11, new LinearLayout.LayoutParams(0, -2, 1.4f));
    }

    void T0(i0 i0Var) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.f6464t.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(36.0f)));
        TextView b6 = g4.d.b(this, 10.0f, Color.parseColor("#333333"), i0Var.username);
        TextView b7 = g4.d.b(this, 10.0f, Color.parseColor("#333333"), i0Var.num + HttpUrl.FRAGMENT_ENCODE_SET);
        String str = i0Var.first_number;
        if (i0Var.num > 1) {
            int parseInt = Integer.parseInt(str);
            str = (str + " - ") + ((parseInt + i0Var.num) - 1);
        }
        TextView b8 = g4.d.b(this, 9.0f, Color.parseColor("#333333"), str);
        TextView b9 = g4.d.b(this, 10.0f, Color.parseColor(i0Var.is_win > 0 ? "#f00000" : "#333333"), i0Var.is_win > 0 ? "是" : "-");
        long j6 = i0Var.created_at_hm;
        TextView b10 = g4.d.b(this, 9.0f, Color.parseColor("#333333"), g4.i.x(j6 / 1000) + "." + String.format("%03d", Long.valueOf(j6 % 1000)));
        TextView b11 = g4.d.b(this, 10.0f, Color.parseColor("#333333"), i0Var.time_char);
        linearLayout.addView(b6, new LinearLayout.LayoutParams(0, -2, 1.8f));
        linearLayout.addView(b7, new LinearLayout.LayoutParams(0, -2, 0.7f));
        linearLayout.addView(b8, new LinearLayout.LayoutParams(0, -2, 2.4f));
        linearLayout.addView(b9, new LinearLayout.LayoutParams(0, -2, 0.7f));
        linearLayout.addView(b10, new LinearLayout.LayoutParams(0, -2, 2.2f));
        linearLayout.addView(b11, new LinearLayout.LayoutParams(0, -2, 1.4f));
        Q(this.f6464t, Color.parseColor("#cccccc"), 0.5f, 0, 0, 0);
    }

    void U0() {
        this.f6465u = 1;
        TextView c6 = g4.d.c(this, 12, Color.parseColor("#505050"), "其他下注记录：", 16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(36.0f));
        layoutParams.topMargin = g4.i.r(30.0f);
        this.f6464t.addView(c6, layoutParams);
        W(this.f6464t, Color.parseColor("#cccccc"), 0.5f, 0, 0, 0);
        if (Build.VERSION.SDK_INT < 23) {
            V0();
            return;
        }
        ScrollView scrollView = (ScrollView) this.f6464t.getParent();
        scrollView.setOnScrollChangeListener(new b(scrollView));
    }

    void V0() {
        this.f6466v = true;
        com.secret.prettyhezi.j.q(i.a() + "loot/orders/record/json?lootid=" + this.f6462r + "&page=" + this.f6465u, i.f6608a.token.token, 3, new c(this));
    }

    void W0() {
        I0();
        com.secret.prettyhezi.j.q(i.a() + "loot/orders/limitnums/json?lootid=" + this.f6462r, i.f6608a.token.token, 3, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6462r = extras.getInt("id");
        }
        LinearLayout B0 = B0(3, 4);
        this.f6463s = B0;
        M(B0, "夺宝下注详情");
        S0();
        LinearLayout e6 = e(this.f6463s);
        this.f6464t = e6;
        e6.setBackgroundColor(-1);
        this.f6464t.setPadding(g4.i.r(6.0f), 0, g4.i.r(6.0f), g4.i.r(30.0f));
        W0();
    }
}
