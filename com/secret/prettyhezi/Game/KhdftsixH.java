package com.secret.prettyhezi.Game;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.UoWMF;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class KhdftsixH extends UoWMF implements x0.b {

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f6262r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f6263s;

    /* renamed from: t  reason: collision with root package name */
    public x0.a f6264t;

    /* renamed from: u  reason: collision with root package name */
    public RelativeLayout f6265u;

    /* renamed from: x  reason: collision with root package name */
    int f6268x;

    /* renamed from: v  reason: collision with root package name */
    com.secret.prettyhezi.View.t f6266v = null;

    /* renamed from: w  reason: collision with root package name */
    boolean f6267w = false;

    /* renamed from: y  reason: collision with root package name */
    b[] f6269y = null;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            KhdftsixH.this.f6264t.scrollTo(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends com.secret.prettyhezi.View.a0 {

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ KhdftsixH f6272d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ boolean f6273e;

            a(KhdftsixH khdftsixH, boolean z5) {
                this.f6272d = khdftsixH;
                this.f6273e = z5;
            }

            @Override // g4.f
            public void a(View view) {
                b bVar = b.this;
                boolean z5 = bVar.f7848f;
                KhdftsixH khdftsixH = KhdftsixH.this;
                if (z5) {
                    khdftsixH.f6264t.scrollTo(0, 0);
                } else {
                    khdftsixH.X0(this.f6273e);
                }
            }
        }

        public b(String str, boolean z5) {
            super(KhdftsixH.this, str);
            setOnClickListener(new a(KhdftsixH.this, z5));
        }
    }

    public static void V0(Activity activity, LinearLayout linearLayout, String str) {
        int i6 = r.f6648y;
        View b6 = g4.d.b(activity, 14.0f, i6, "期号");
        View b7 = g4.d.b(activity, 14.0f, i6, "投注");
        View b8 = g4.d.b(activity, 14.0f, i6, str);
        View b9 = g4.d.b(activity, 14.0f, i6, "开奖");
        View b10 = g4.d.b(activity, 14.0f, i6, "奖金");
        linearLayout.addView(b6, new LinearLayout.LayoutParams(0, -2, 4.0f));
        linearLayout.addView(b7, new LinearLayout.LayoutParams(0, -2, 3.0f));
        linearLayout.addView(b8, new LinearLayout.LayoutParams(0, -2, 3.0f));
        linearLayout.addView(b9, new LinearLayout.LayoutParams(0, -2, 3.0f));
        linearLayout.addView(b10, new LinearLayout.LayoutParams(0, -2, 3.0f));
        View view = new View(activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(7.0f), -1);
        layoutParams.leftMargin = g4.i.r(6.0f);
        linearLayout.addView(view, layoutParams);
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        this.f6263s = linearLayout;
        linearLayout.setPadding(g4.i.r(12.0f), 0, g4.i.r(10.0f), 0);
        this.f6263s.setOrientation(0);
        this.f6263s.setGravity(16);
        this.f6263s.setBackgroundColor(Color.parseColor("#cccccc"));
        this.f6262r.addView(this.f6263s, new LinearLayout.LayoutParams(-1, g4.i.r(32.0f)));
    }

    void T0() {
        this.f6269y = new b[2];
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        this.f6269y[0] = new b("普通投注", false);
        this.f6269y[1] = new b("追号投注", true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(106.0f), -1);
        linearLayout.addView(this.f6269y[0], layoutParams);
        linearLayout.addView(this.f6269y[1], layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(14, -1);
        this.f6265u.addView(linearLayout, layoutParams2);
    }

    void U0() {
        int i6 = r.f6648y;
        TextView b6 = g4.d.b(this, 14.0f, i6, "开始期号");
        TextView b7 = g4.d.b(this, 14.0f, i6, "投注");
        TextView b8 = g4.d.b(this, 14.0f, i6, "每期金币");
        TextView b9 = g4.d.b(this, 14.0f, i6, "进度");
        TextView b10 = g4.d.b(this, 14.0f, i6, "中奖即停");
        this.f6263s.addView(b6, new LinearLayout.LayoutParams(0, -2, 4.0f));
        this.f6263s.addView(b7, new LinearLayout.LayoutParams(0, -2, 3.0f));
        this.f6263s.addView(b8, new LinearLayout.LayoutParams(0, -2, 3.0f));
        this.f6263s.addView(b9, new LinearLayout.LayoutParams(0, -2, 3.0f));
        this.f6263s.addView(b10, new LinearLayout.LayoutParams(0, -2, 3.0f));
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(7.0f), -1);
        layoutParams.leftMargin = g4.i.r(6.0f);
        this.f6263s.addView(view, layoutParams);
    }

    public void W0(int i6) {
        com.secret.prettyhezi.View.t tVar = this.f6266v;
        if (tVar != null) {
            tVar.D(i6);
        }
    }

    void X0(boolean z5) {
        com.secret.prettyhezi.View.t mVar;
        this.f6263s.removeAllViews();
        com.secret.prettyhezi.View.t tVar = this.f6266v;
        if (tVar != null) {
            this.f6264t.removeView(tVar);
            this.f6266v.b();
        }
        if (z5) {
            U0();
            mVar = new m(this);
        } else {
            V0(this, this.f6263s, this.f6267w ? "玩币" : "金币");
            mVar = new s(this, this.f6267w);
        }
        this.f6266v = mVar;
        this.f6264t.addView(this.f6266v);
        b[] bVarArr = this.f6269y;
        if (bVarArr != null) {
            if (z5) {
                bVarArr[0].b(false);
                this.f6269y[1].b(true);
                return;
            }
            bVarArr[0].b(true);
            this.f6269y[1].b(false);
        }
    }

    @Override // x0.b
    public void a(x0.c cVar) {
    }

    @Override // x0.b
    public void b() {
    }

    @Override // x0.b
    public void c(int i6, boolean z5, boolean z6) {
        if (this.f6268x == i6) {
            return;
        }
        this.f6268x = i6;
        W0(i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6267w = extras.getInt("id") == 1;
        } else {
            this.f6267w = false;
        }
        LinearLayout B0 = B0(3, 4);
        this.f6262r = B0;
        RelativeLayout M = M(B0, this.f6267w ? "我的投注记录" : HttpUrl.FRAGMENT_ENCODE_SET);
        this.f6265u = M;
        if (this.f6267w) {
            M.setOnClickListener(new a());
        } else {
            T0();
        }
        S0();
        W(this.f6262r, Color.parseColor("#888888"), 0.5f, 0, 0, 0);
        x0.a aVar = new x0.a(this);
        this.f6264t = aVar;
        aVar.setScrollViewCallbacks(this);
        this.f6262r.addView(this.f6264t, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        X0(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.secret.prettyhezi.View.t tVar = this.f6266v;
        if (tVar != null) {
            tVar.b();
        }
    }
}
