package com.secret.prettyhezi.share;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.View.a0;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class MWCuVB extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f8901r;

    /* renamed from: s  reason: collision with root package name */
    RelativeLayout f8902s;

    /* renamed from: t  reason: collision with root package name */
    ScrollView f8903t;

    /* renamed from: u  reason: collision with root package name */
    LinearLayout f8904u;

    /* renamed from: v  reason: collision with root package name */
    a0[] f8905v;

    /* renamed from: w  reason: collision with root package name */
    TextView f8906w;

    /* renamed from: x  reason: collision with root package name */
    int f8907x = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8908d;

        a(int i6) {
            this.f8908d = i6;
        }

        @Override // g4.f
        protected void a(View view) {
            MWCuVB.this.U0(this.f8908d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8910b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            this.f8910b = i6;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            c[] cVarArr;
            e eVar = (e) com.secret.prettyhezi.f.d(str, e.class);
            if (eVar.code != 200) {
                f(eVar.err);
                return;
            }
            d dVar = eVar.data;
            if (dVar == null || (cVarArr = dVar.items) == null || cVarArr.length <= 0) {
                MWCuVB.this.W0();
            } else {
                MWCuVB.this.V0(cVarArr, this.f8910b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements Serializable {
        public long effective;
        public long score;
        public long today;
        public long total;

        c() {
        }
    }

    /* loaded from: classes.dex */
    static class d implements Serializable {
        public c[] items;
        public int pages;
        public int total;

        d() {
        }
    }

    /* loaded from: classes.dex */
    static class e extends w {
        public d data;

        e() {
        }
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setPadding(g4.i.r(12.0f), 0, g4.i.r(6.0f), 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(Color.parseColor("#cccccc"));
        this.f8901r.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(40.0f)));
        TextView b6 = g4.d.b(this, 14.0f, -16777216, "日期");
        TextView b7 = g4.d.b(this, 14.0f, -16777216, "总人数");
        this.f8906w = g4.d.b(this, 14.0f, -16777216, "有效人数");
        TextView b8 = g4.d.b(this, 14.0f, -16777216, "奖励积分");
        linearLayout.addView(b6, new LinearLayout.LayoutParams(0, -2, 3.0f));
        linearLayout.addView(b7, new LinearLayout.LayoutParams(0, -2, 2.0f));
        linearLayout.addView(this.f8906w, new LinearLayout.LayoutParams(0, -2, 2.0f));
        linearLayout.addView(b8, new LinearLayout.LayoutParams(0, -2, 3.0f));
    }

    void T0() {
        LinearLayout linearLayout = new LinearLayout(this);
        int i6 = 0;
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(14, -1);
        this.f8902s.addView(linearLayout, layoutParams);
        a0[] a0VarArr = new a0[2];
        this.f8905v = a0VarArr;
        a0VarArr[0] = new a0(this, "邀请码记录");
        this.f8905v[1] = new a0(this, "注册码记录");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(106.0f), -1);
        linearLayout.addView(this.f8905v[0], layoutParams2);
        linearLayout.addView(this.f8905v[1], layoutParams2);
        while (true) {
            a0[] a0VarArr2 = this.f8905v;
            if (i6 >= a0VarArr2.length) {
                return;
            }
            a0VarArr2[i6].setOnClickListener(new a(i6));
            i6++;
        }
    }

    void U0(int i6) {
        if (this.f8907x == i6) {
            this.f8903t.scrollTo(0, 0);
            return;
        }
        this.f8907x = i6;
        this.f8906w.setVisibility(i6 == 0 ? 0 : 8);
        int i7 = 0;
        while (true) {
            a0[] a0VarArr = this.f8905v;
            boolean z5 = true;
            if (i7 >= a0VarArr.length) {
                break;
            }
            a0 a0Var = a0VarArr[i7];
            if (i7 != i6) {
                z5 = false;
            }
            a0Var.b(z5);
            i7++;
        }
        this.f8904u.removeAllViews();
        G0();
        String str = i6 == 1 ? "user/invite/show/json" : "user/share/show/json";
        com.secret.prettyhezi.j.o(v.f7132a + str, true, new b(this, i6));
    }

    void V0(c[] cVarArr, int i6) {
        for (c cVar : cVarArr) {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setPadding(g4.i.r(12.0f), 0, g4.i.r(6.0f), 0);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            linearLayout.setBackgroundColor(Color.parseColor("#f0f0f0"));
            this.f8904u.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(32.0f)));
            TextView b6 = g4.d.b(this, 14.0f, -16777216, g4.i.u(cVar.today));
            TextView b7 = g4.d.b(this, 12.0f, -16777216, cVar.total + HttpUrl.FRAGMENT_ENCODE_SET);
            TextView b8 = g4.d.b(this, 12.0f, -16777216, cVar.score + HttpUrl.FRAGMENT_ENCODE_SET);
            linearLayout.addView(b6, new LinearLayout.LayoutParams(0, -2, 3.0f));
            linearLayout.addView(b7, new LinearLayout.LayoutParams(0, -2, 2.0f));
            linearLayout.addView(b8, new LinearLayout.LayoutParams(0, -2, 3.0f));
            if (i6 == 0) {
                linearLayout.addView(g4.d.b(this, 12.0f, -16777216, cVar.effective + HttpUrl.FRAGMENT_ENCODE_SET), 2, new LinearLayout.LayoutParams(0, -2, 2.0f));
            }
            V(this.f8904u, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        }
    }

    void W0() {
        this.f8904u.addView(g4.d.c(this, 18, -16777216, s0(C0382R.string.no_data), 17), new LinearLayout.LayoutParams(-1, g4.i.r(120.0f)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout B0 = B0(3, 4);
        this.f8901r = B0;
        this.f8902s = L(B0);
        T0();
        S0();
        ScrollView scrollView = new ScrollView(this);
        this.f8903t = scrollView;
        scrollView.setScrollBarSize(0);
        this.f8903t.setVerticalScrollBarEnabled(false);
        this.f8901r.addView(this.f8903t, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout linearLayout = new LinearLayout(this);
        this.f8904u = linearLayout;
        linearLayout.setOrientation(1);
        this.f8903t.addView(this.f8904u, new LinearLayout.LayoutParams(-1, -2));
        U0(0);
    }
}
