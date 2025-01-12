package com.secret.prettyhezi.Game;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class HFqjgQ extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    int f6249r;

    /* renamed from: s  reason: collision with root package name */
    public LinearLayout f6250s;

    /* renamed from: t  reason: collision with root package name */
    public ScrollView f6251t;

    /* renamed from: u  reason: collision with root package name */
    public RelativeLayout f6252u;

    /* renamed from: v  reason: collision with root package name */
    TextView f6253v;

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f6254w;

    /* renamed from: x  reason: collision with root package name */
    String f6255x;

    /* renamed from: y  reason: collision with root package name */
    q[] f6256y;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            HFqjgQ.this.f6251t.scrollTo(0, 0);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                HFqjgQ.this.T0();
            }
        }

        b() {
        }

        @Override // g4.f
        protected void a(View view) {
            g4.i.j().B("撤销所有可以撤销的期号？", new a(), true);
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
            e eVar = (e) com.secret.prettyhezi.f.d(str, e.class);
            if (eVar.code != 200) {
                HFqjgQ.this.w0(eVar);
                return;
            }
            q[] qVarArr = eVar.data;
            if (qVarArr == null || qVarArr.length <= 0) {
                return;
            }
            HFqjgQ.this.f6254w.removeAllViews();
            HFqjgQ.this.U0(eVar.data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends s.g {
        d(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            com.secret.prettyhezi.Server.z zVar = (com.secret.prettyhezi.Server.z) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.Server.z.class);
            if (zVar.code == 200) {
                HFqjgQ.this.f6253v.setVisibility(8);
            } else {
                f(zVar.err);
            }
            HFqjgQ.this.V0();
        }
    }

    /* loaded from: classes.dex */
    static class e extends com.secret.prettyhezi.Server.w {
        public q[] data;

        e() {
        }
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setPadding(g4.i.r(12.0f), 0, g4.i.r(10.0f), 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(Color.parseColor("#cccccc"));
        this.f6250s.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(32.0f)));
        KhdftsixH.V0(this, linearLayout, "金币");
    }

    public void T0() {
        I0();
        com.secret.prettyhezi.j.q(i.a() + "order/cancel/json?ids=" + Uri.encode(this.f6255x), i.f6608a.token.token, 3, new d(this));
    }

    void U0(q[] qVarArr) {
        this.f6256y = qVarArr;
        for (q qVar : qVarArr) {
            r rVar = new r(this);
            rVar.b(qVar);
            this.f6254w.addView(rVar, new LinearLayout.LayoutParams(-1, g4.i.r(36.0f)));
            V(this.f6254w, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        }
        W0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V0() {
        I0();
        com.secret.prettyhezi.j.q(i.a() + "order/record/zh/view/json?order_id=" + this.f6249r, i.f6608a.token.token, 3, new c(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W0() {
        this.f6255x = HttpUrl.FRAGMENT_ENCODE_SET;
        int i6 = 0;
        boolean z5 = false;
        while (true) {
            q[] qVarArr = this.f6256y;
            if (i6 >= qVarArr.length) {
                break;
            }
            q qVar = qVarArr[i6];
            if (qVar.is_cancel > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f6255x);
                sb.append(this.f6255x.isEmpty() ? HttpUrl.FRAGMENT_ENCODE_SET : ",");
                sb.append(qVar.id);
                this.f6255x = sb.toString();
                z5 = true;
            }
            i6++;
        }
        this.f6253v.setVisibility(z5 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6249r = extras.getInt("id");
        }
        LinearLayout B0 = B0(3, 4);
        this.f6250s = B0;
        RelativeLayout M = M(B0, "追单详情");
        this.f6252u = M;
        M.setOnClickListener(new a());
        TextView b6 = g4.d.b(this, 14.0f, -1, "撤单所有");
        this.f6253v = b6;
        b6.setGravity(17);
        this.f6253v.setBackground(g4.i.d(g4.i.b(-65536, 4.0f), g4.i.b(Color.parseColor("#aa0000"), 4.0f)));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(90.0f), g4.i.r(36.0f));
        layoutParams.rightMargin = g4.i.r(12.0f);
        layoutParams.addRule(11, -1);
        layoutParams.addRule(15, -1);
        this.f6252u.addView(this.f6253v, layoutParams);
        this.f6253v.setOnClickListener(new b());
        this.f6253v.setVisibility(8);
        S0();
        W(this.f6250s, Color.parseColor("#888888"), 0.5f, 0, 0, 0);
        ScrollView scrollView = new ScrollView(this);
        this.f6251t = scrollView;
        scrollView.setVerticalScrollBarEnabled(false);
        this.f6250s.addView(this.f6251t, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout linearLayout = new LinearLayout(this);
        this.f6254w = linearLayout;
        linearLayout.setOrientation(1);
        this.f6251t.addView(this.f6254w, new ViewGroup.LayoutParams(-1, -2));
        V0();
    }
}
