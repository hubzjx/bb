package com.secret.prettyhezi.View;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.h;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class h extends i {

    /* renamed from: n  reason: collision with root package name */
    private RelativeLayout f7936n;

    /* renamed from: o  reason: collision with root package name */
    private com.secret.prettyhezi.controls.r f7937o;

    /* renamed from: p  reason: collision with root package name */
    com.secret.prettyhezi.controls.z f7938p;

    /* renamed from: q  reason: collision with root package name */
    private c0 f7939q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f7940r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f7941s;

    /* renamed from: t  reason: collision with root package name */
    private x f7942t;

    /* loaded from: classes.dex */
    class a implements h.b {
        a() {
        }

        @Override // com.secret.prettyhezi.controls.h.b
        public void a(int i6, String str, String str2, String str3) {
            com.secret.prettyhezi.Server.l lVar;
            com.secret.prettyhezi.Server.h hVar = h.this.f7945m;
            if (hVar == null || (lVar = hVar.co) == null || !lVar.f7128p.equals(str)) {
                return;
            }
            com.secret.prettyhezi.controls.r rVar = h.this.f7937o;
            com.secret.prettyhezi.Server.h hVar2 = h.this.f7945m;
            rVar.f(i6, hVar2.f7112t, hVar2.id, str2, str3);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            h.this.p();
        }
    }

    public h(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH, i6);
        RelativeLayout relativeLayout = new RelativeLayout(zZcINlcxH);
        this.f7936n = relativeLayout;
        addView(relativeLayout, new LinearLayout.LayoutParams(i6, 100));
        com.secret.prettyhezi.controls.r rVar = new com.secret.prettyhezi.controls.r(zZcINlcxH, HttpUrl.FRAGMENT_ENCODE_SET);
        this.f7937o = rVar;
        rVar.setBackgroundColor(Color.parseColor("#cccccc"));
        this.f7936n.addView(this.f7937o, new RelativeLayout.LayoutParams(-1, -1));
        this.f7937o.a(new a());
        this.f7938p = new com.secret.prettyhezi.controls.z((ZZcINlcxH) getContext(), C0382R.drawable.play_normal);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(40.0f), g4.i.r(40.0f));
        layoutParams.addRule(13, -1);
        this.f7936n.addView(this.f7938p, layoutParams);
        x xVar = new x(zZcINlcxH, 0);
        this.f7942t = xVar;
        xVar.setId(999);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, g4.i.r(18.0f));
        layoutParams2.addRule(10, -1);
        this.f7936n.addView(this.f7942t, layoutParams2);
        this.f7939q = new c0(zZcINlcxH, 0);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, g4.i.r(18.0f));
        layoutParams3.addRule(10, -1);
        layoutParams3.addRule(1, this.f7942t.getId());
        layoutParams3.leftMargin = g4.i.r(6.0f);
        this.f7936n.addView(this.f7939q, layoutParams3);
        TextView c6 = g4.d.c(zZcINlcxH, 12, -1, HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f7940r = c6;
        c6.setBackgroundColor(Color.parseColor("#55000000"));
        this.f7940r.setPadding(g4.i.r(4.0f), 0, g4.i.r(4.0f), 0);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, g4.i.r(18.0f));
        layoutParams4.addRule(21, -1);
        layoutParams4.addRule(10, -1);
        this.f7936n.addView(this.f7940r, layoutParams4);
        TextView b6 = g4.d.b(zZcINlcxH, 12.0f, -1, HttpUrl.FRAGMENT_ENCODE_SET);
        this.f7941s = b6;
        b6.setBackgroundColor(Color.parseColor("#55000000"));
        this.f7941s.setPadding(g4.i.r(4.0f), g4.i.r(4.0f), g4.i.r(4.0f), g4.i.r(4.0f));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(12, -1);
        this.f7936n.addView(this.f7941s, layoutParams5);
        this.f7941s.setMaxLines(2);
        this.f7936n.setOnClickListener(new b());
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        this.f7945m = (com.secret.prettyhezi.Server.h) nVar;
        this.f7937o.setBackgroundColor(Color.parseColor("#cccccc"));
        com.secret.prettyhezi.Server.l lVar = this.f7945m.co;
        this.f7937o.b(lVar.f7128p);
        this.f8037b = (lVar.f7127h * this.f8039d) / lVar.f7129w;
        this.f7936n.setLayoutParams(new LinearLayout.LayoutParams(this.f8039d, this.f8037b));
        if (com.secret.prettyhezi.g.c(this.f7945m.f7112t)) {
            TextView textView = this.f7940r;
            textView.setText(HttpUrl.FRAGMENT_ENCODE_SET + this.f7945m.am);
            this.f7938p.setVisibility(8);
        } else {
            this.f7940r.setText(g4.i.G(this.f7945m.dur));
            this.f7938p.setVisibility(0);
        }
        if (com.secret.prettyhezi.g.d(this.f7945m.f7112t)) {
            this.f7939q.a(this.f7945m.uc);
            this.f7939q.setVisibility(0);
            if (this.f7945m.ut == 100) {
                View c6 = c();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c6.getLayoutParams();
                layoutParams.removeRule(11);
                c6.setLayoutParams(layoutParams);
            }
        } else {
            this.f7939q.setVisibility(8);
        }
        String str = this.f7945m.na;
        if (str == null || str.isEmpty()) {
            this.f7941s.setVisibility(8);
        } else {
            this.f7941s.setVisibility(0);
            this.f7941s.setText(this.f7945m.na);
        }
        this.f7942t.a(this.f7945m.fc);
    }

    @Override // com.secret.prettyhezi.View.u
    public RelativeLayout getTopRelativeLayout() {
        return this.f7936n;
    }

    @Override // com.secret.prettyhezi.View.u
    public View i() {
        return this.f8038c ? e() : c();
    }
}
