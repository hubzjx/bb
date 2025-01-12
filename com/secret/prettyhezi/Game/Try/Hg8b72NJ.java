package com.secret.prettyhezi.Game.Try;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.f;
import g4.i;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class Hg8b72NJ extends UoWMF {

    /* renamed from: w  reason: collision with root package name */
    public static int[] f6482w;

    /* renamed from: x  reason: collision with root package name */
    public static int[] f6483x;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6484r;

    /* renamed from: s  reason: collision with root package name */
    RelativeLayout f6485s;

    /* renamed from: t  reason: collision with root package name */
    ScrollView f6486t;

    /* renamed from: u  reason: collision with root package name */
    LinearLayout f6487u;

    /* renamed from: v  reason: collision with root package name */
    TextView f6488v;

    /* loaded from: classes.dex */
    class a extends f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f6489d;

        a(int i6) {
            this.f6489d = i6;
        }

        @Override // g4.f
        protected void a(View view) {
            Hg8b72NJ.this.N0(XXkwgzA.class, this.f6489d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f6491b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            this.f6491b = i6;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            d dVar = (d) com.secret.prettyhezi.f.d(str, d.class);
            if (dVar.code == 200) {
                Hg8b72NJ.this.V0(dVar.data, this.f6491b);
            } else {
                f(dVar.err);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Serializable {
        public long bonus;
        public long integral;
        public String nickname;
        public long uid;
    }

    /* loaded from: classes.dex */
    static class d extends w {
        public c[] data;

        d() {
        }
    }

    public static LinearLayout T0(ZZcINlcxH zZcINlcxH, c cVar, int i6) {
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setPadding(i.r(12.0f), 0, i.r(6.0f), 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(Color.parseColor(cVar.bonus > 0 ? "#f00000" : "#f0f0f0"));
        TextView b6 = g4.d.b(zZcINlcxH, 14.0f, -16777216, HttpUrl.FRAGMENT_ENCODE_SET + (i6 + 1));
        TextView b7 = g4.d.b(zZcINlcxH, 13.0f, -16777216, cVar.nickname);
        TextView b8 = g4.d.b(zZcINlcxH, 13.0f, -16777216, cVar.integral + HttpUrl.FRAGMENT_ENCODE_SET);
        TextView b9 = g4.d.b(zZcINlcxH, 13.0f, -16777216, cVar.bonus + HttpUrl.FRAGMENT_ENCODE_SET);
        linearLayout.addView(b6, new LinearLayout.LayoutParams(0, -2, 2.0f));
        linearLayout.addView(b7, new LinearLayout.LayoutParams(0, -2, 3.0f));
        linearLayout.addView(b8, new LinearLayout.LayoutParams(0, -2, 3.0f));
        linearLayout.addView(b9, new LinearLayout.LayoutParams(0, -2, 3.0f));
        return linearLayout;
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setPadding(i.r(12.0f), 0, i.r(6.0f), 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(Color.parseColor("#cccccc"));
        this.f6484r.addView(linearLayout, new LinearLayout.LayoutParams(-1, i.r(40.0f)));
        TextView b6 = g4.d.b(this, 14.0f, -16777216, "名次");
        TextView b7 = g4.d.b(this, 14.0f, -16777216, "昵称");
        TextView b8 = g4.d.b(this, 14.0f, -16777216, "玩币");
        TextView b9 = g4.d.b(this, 12.0f, -16777216, "预期奖金");
        linearLayout.addView(b6, new LinearLayout.LayoutParams(0, -2, 2.0f));
        linearLayout.addView(b7, new LinearLayout.LayoutParams(0, -2, 3.0f));
        linearLayout.addView(b8, new LinearLayout.LayoutParams(0, -2, 3.0f));
        linearLayout.addView(b9, new LinearLayout.LayoutParams(0, -2, 3.0f));
    }

    void U0(int i6) {
        String str;
        int[] iArr;
        int[] iArr2;
        int i7 = 0;
        if (i6 == 0 && (iArr2 = f6482w) != null && iArr2.length > 0) {
            str = "日榜前" + f6482w.length + "名分别奖励金币：";
            while (i7 < f6482w.length) {
                if (i7 != 0) {
                    str = str + ", ";
                }
                str = str + f6482w[i7];
                i7++;
            }
        } else if (i6 != 1 || (iArr = f6483x) == null || iArr.length <= 0) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            str = "周榜前" + f6483x.length + "名分别奖励金币：";
            while (i7 < f6483x.length) {
                if (i7 != 0) {
                    str = str + ", ";
                }
                str = str + f6483x[i7];
                i7++;
            }
        }
        this.f6488v.setText(str);
        this.f6487u.removeAllViews();
        G0();
        j.q(com.secret.prettyhezi.Game.i.a() + (i6 == 0 ? "demo/day/integral/json" : "demo/week/integral/json"), com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new b(this, i6));
    }

    void V0(c[] cVarArr, int i6) {
        for (int i7 = 0; i7 < cVarArr.length; i7++) {
            this.f6487u.addView(T0(this, cVarArr[i7], i7), new LinearLayout.LayoutParams(-1, i.r(32.0f)));
            V(this.f6487u, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        int i6 = extras != null ? extras.getInt("id") : 0;
        LinearLayout B0 = B0(3, 4);
        this.f6484r = B0;
        this.f6485s = N(B0, i6 == 0 ? "试玩日榜" : "试玩周榜", "历史榜单", new a(i6));
        TextView a6 = g4.d.a(this, 14.0f, -65536);
        this.f6488v = a6;
        a6.setBackgroundColor(-1);
        this.f6488v.setPadding(i.r(10.0f), i.r(6.0f), i.r(10.0f), i.r(6.0f));
        this.f6484r.addView(this.f6488v, new LinearLayout.LayoutParams(-1, -2));
        S0();
        ScrollView scrollView = new ScrollView(this);
        this.f6486t = scrollView;
        scrollView.setScrollBarSize(0);
        this.f6486t.setVerticalScrollBarEnabled(false);
        this.f6484r.addView(this.f6486t, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout linearLayout = new LinearLayout(this);
        this.f6487u = linearLayout;
        linearLayout.setOrientation(1);
        this.f6486t.addView(this.f6487u, new LinearLayout.LayoutParams(-1, -2));
        U0(i6);
    }
}
