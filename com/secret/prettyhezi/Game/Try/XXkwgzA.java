package com.secret.prettyhezi.Game.Try;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Game.Try.Hg8b72NJ;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.u;
import com.secret.prettyhezi.controls.z;
import com.secret.prettyhezi.f;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.i;
import java.io.Serializable;
/* loaded from: classes.dex */
public class XXkwgzA extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6493r;

    /* renamed from: s  reason: collision with root package name */
    RelativeLayout f6494s;

    /* renamed from: t  reason: collision with root package name */
    ScrollView f6495t;

    /* renamed from: u  reason: collision with root package name */
    LinearLayout f6496u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            d dVar = (d) f.d(str, d.class);
            if (dVar.code != 200) {
                f(dVar.err);
                return;
            }
            for (int i6 = 0; i6 < dVar.data.length; i6++) {
                XXkwgzA xXkwgzA = XXkwgzA.this;
                b bVar = new b(xXkwgzA, dVar.data[i6]);
                if (i6 > 0) {
                    bVar.a(true);
                }
                XXkwgzA.this.f6496u.addView(bVar, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        LinearLayout f6498b;

        /* renamed from: c  reason: collision with root package name */
        u f6499c;

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ XXkwgzA f6501d;

            a(XXkwgzA xXkwgzA) {
                this.f6501d = xXkwgzA;
            }

            @Override // g4.f
            protected void a(View view) {
                b bVar = b.this;
                bVar.a(bVar.f6498b.getVisibility() == 0);
            }
        }

        public b(ZZcINlcxH zZcINlcxH, c cVar) {
            super(zZcINlcxH);
            setOrientation(1);
            LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
            int i6 = 0;
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            linearLayout.setBackgroundColor(Color.parseColor("#555555"));
            linearLayout.setPadding(i.r(8.0f), 0, i.r(12.0f), 0);
            linearLayout.addView(g4.d.c(zZcINlcxH, 14, -1, cVar.trade_date, 16), new LinearLayout.LayoutParams(0, -2, 1.0f));
            this.f6499c = u.a(new z(zZcINlcxH, C0382R.drawable.ic_right_arrow), 7, 13);
            linearLayout.addView(this.f6499c, new LinearLayout.LayoutParams(i.r(20.0f), i.r(20.0f)));
            this.f6499c.setRotation(270.0f);
            linearLayout.setOnClickListener(new a(XXkwgzA.this));
            addView(linearLayout, new LinearLayout.LayoutParams(-1, i.r(40.0f)));
            XXkwgzA.this.V(this, Color.parseColor("#cccccc"), 1.0f, 0, 0);
            LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
            this.f6498b = linearLayout2;
            linearLayout2.setOrientation(1);
            addView(this.f6498b, new LinearLayout.LayoutParams(-1, -2));
            while (true) {
                Hg8b72NJ.c[] cVarArr = cVar.item;
                if (i6 >= cVarArr.length) {
                    return;
                }
                this.f6498b.addView(Hg8b72NJ.T0(zZcINlcxH, cVarArr[i6], i6), new LinearLayout.LayoutParams(-1, i.r(32.0f)));
                XXkwgzA.this.V(this.f6498b, Color.parseColor("#cccccc"), 0.5f, 0, 0);
                i6++;
            }
        }

        void a(boolean z5) {
            this.f6498b.setVisibility(z5 ? 8 : 0);
            this.f6499c.setRotation(z5 ? 90.0f : 270.0f);
        }
    }

    /* loaded from: classes.dex */
    static class c implements Serializable {
        public Hg8b72NJ.c[] item;
        public String trade_date;

        c() {
        }
    }

    /* loaded from: classes.dex */
    static class d extends w {
        public c[] data;

        d() {
        }
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setPadding(i.r(12.0f), 0, i.r(6.0f), 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(Color.parseColor("#cccccc"));
        this.f6493r.addView(linearLayout, new LinearLayout.LayoutParams(-1, i.r(40.0f)));
        TextView b6 = g4.d.b(this, 14.0f, -16777216, "名次");
        TextView b7 = g4.d.b(this, 14.0f, -16777216, "昵称");
        TextView b8 = g4.d.b(this, 14.0f, -16777216, "玩币");
        TextView b9 = g4.d.b(this, 14.0f, -16777216, "奖金");
        linearLayout.addView(b6, new LinearLayout.LayoutParams(0, -2, 2.0f));
        linearLayout.addView(b7, new LinearLayout.LayoutParams(0, -2, 3.0f));
        linearLayout.addView(b8, new LinearLayout.LayoutParams(0, -2, 3.0f));
        linearLayout.addView(b9, new LinearLayout.LayoutParams(0, -2, 3.0f));
    }

    void T0(int i6) {
        this.f6496u.removeAllViews();
        G0();
        String str = i6 == 0 ? "demo/day/integral/history/json" : "demo/week/integral/history/json";
        j.q(com.secret.prettyhezi.Game.i.a() + str, com.secret.prettyhezi.Game.i.f6608a.token.token, 3, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        int i6 = extras != null ? extras.getInt("id") : 0;
        LinearLayout B0 = B0(3, 4);
        this.f6493r = B0;
        this.f6494s = M(B0, i6 == 0 ? "日榜历史记录" : "周榜历史记录");
        S0();
        ScrollView scrollView = new ScrollView(this);
        this.f6495t = scrollView;
        scrollView.setScrollBarSize(0);
        this.f6495t.setVerticalScrollBarEnabled(false);
        this.f6493r.addView(this.f6495t, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout linearLayout = new LinearLayout(this);
        this.f6496u = linearLayout;
        linearLayout.setOrientation(1);
        this.f6495t.addView(this.f6496u, new LinearLayout.LayoutParams(-1, -2));
        T0(i6);
    }
}
