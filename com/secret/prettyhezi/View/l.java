package com.secret.prettyhezi.View;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class l extends i {

    /* renamed from: n  reason: collision with root package name */
    private RelativeLayout f7949n;

    /* renamed from: o  reason: collision with root package name */
    private c0 f7950o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f7951p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f7952q;

    /* renamed from: r  reason: collision with root package name */
    private x f7953r;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        protected void a(View view) {
            l.this.p();
        }
    }

    public l(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH, 0);
        this.f7950o = null;
        int i7 = i6 == 7 ? 88 : 55;
        this.f7949n = new RelativeLayout(zZcINlcxH);
        setBackground(null);
        setPadding(g4.i.r(6.0f), g4.i.r(1.0f), g4.i.r(6.0f), g4.i.r(1.0f));
        this.f7949n.setBackground(g4.i.c(-1, 4.0f, -16777216, 1.0f));
        addView(this.f7949n, new LinearLayout.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = new RelativeLayout(zZcINlcxH);
        relativeLayout.setBackgroundColor(Color.parseColor("#888888"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(i7), -1);
        layoutParams.addRule(11, -1);
        this.f7949n.addView(relativeLayout, layoutParams);
        relativeLayout.setPadding(0, g4.i.r(2.0f), 0, g4.i.r(2.0f));
        TextView c6 = g4.d.c(zZcINlcxH, 12, -1, HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f7951p = c6;
        c6.setPadding(g4.i.r(4.0f), g4.i.r(2.0f), g4.i.r(4.0f), g4.i.r(2.0f));
        relativeLayout.addView(this.f7951p, new RelativeLayout.LayoutParams(-2, -2));
        this.f7953r = new x(zZcINlcxH, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, g4.i.r(18.0f));
        layoutParams2.addRule(12, -1);
        relativeLayout.addView(this.f7953r, layoutParams2);
        this.f7953r.setBackgroundColor(0);
        if (i6 == 7) {
            c0 c0Var = new c0(zZcINlcxH, 0);
            this.f7950o = c0Var;
            c0Var.setPadding(g4.i.r(4.0f), g4.i.r(2.0f), 0, g4.i.r(2.0f));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, g4.i.r(18.0f));
            layoutParams3.addRule(12, -1);
            layoutParams3.leftMargin = g4.i.r(44.0f);
            relativeLayout.addView(this.f7950o, layoutParams3);
            this.f7950o.setBackgroundColor(0);
        }
        this.f7952q = g4.d.c(zZcINlcxH, 14, -16777216, HttpUrl.FRAGMENT_ENCODE_SET, 16);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.rightMargin = g4.i.r(i7 + 2);
        layoutParams4.leftMargin = g4.i.r(4.0f);
        this.f7949n.addView(this.f7952q, layoutParams4);
        this.f7952q.setMaxLines(2);
        this.f7949n.setOnClickListener(new a());
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        this.f8037b = g4.i.r(50.0f);
        com.secret.prettyhezi.Server.h hVar = (com.secret.prettyhezi.Server.h) nVar;
        this.f7945m = hVar;
        this.f7951p.setText(hVar.f7112t == 7 ? g4.i.G(hVar.dur) : String.format("共%d节", Integer.valueOf(hVar.am)));
        c0 c0Var = this.f7950o;
        if (c0Var != null) {
            c0Var.a(this.f7945m.uc);
            if (this.f7945m.ut == 100) {
                View c6 = c();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c6.getLayoutParams();
                layoutParams.removeRule(11);
                c6.setLayoutParams(layoutParams);
            }
        }
        String str = this.f7945m.na;
        if (str == null || str.isEmpty()) {
            this.f7952q.setVisibility(8);
        } else {
            this.f7952q.setVisibility(0);
            this.f7952q.setText(this.f7945m.na);
        }
        this.f7953r.a(this.f7945m.fc);
    }

    @Override // com.secret.prettyhezi.View.u
    public RelativeLayout getTopRelativeLayout() {
        return this.f7949n;
    }

    @Override // com.secret.prettyhezi.View.u
    public View i() {
        return this.f8038c ? new View(getContext()) : c();
    }
}
