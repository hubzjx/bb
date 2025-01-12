package com.secret.prettyhezi.View;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Yzg4R57AT;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class d0 extends u {

    /* renamed from: m  reason: collision with root package name */
    private com.secret.prettyhezi.Server.c0 f7890m;

    /* renamed from: n  reason: collision with root package name */
    private ZZcINlcxH f7891n;

    /* renamed from: o  reason: collision with root package name */
    private RelativeLayout f7892o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f7893p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f7894q;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7895d;

        a(ZZcINlcxH zZcINlcxH) {
            this.f7895d = zZcINlcxH;
        }

        @Override // g4.f
        public void a(View view) {
            this.f7895d.N0(Yzg4R57AT.class, d0.this.f7890m.uu);
        }
    }

    /* loaded from: classes.dex */
    class b extends ZZcINlcxH.q {

        /* loaded from: classes.dex */
        class a implements s.f {
            a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                d0.this.j().z(d0.this.f7890m, d0.this);
            }
        }

        b() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            com.secret.prettyhezi.s.g(d0.this.f7890m.id, d0.this.f7891n, new a());
        }
    }

    public d0(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH, i6);
        this.f7891n = zZcINlcxH;
        setGravity(1);
        int r5 = g4.i.r(160.0f);
        double d6 = i6 * 0.6d;
        int i7 = ((double) r5) > d6 ? (int) d6 : r5;
        this.f7892o = new RelativeLayout(zZcINlcxH);
        d dVar = new d(zZcINlcxH);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i7);
        layoutParams.addRule(13, -1);
        layoutParams.topMargin = g4.i.r(20.0f);
        layoutParams.bottomMargin = g4.i.r(10.0f);
        this.f7892o.addView(dVar, layoutParams);
        addView(this.f7892o, new LinearLayout.LayoutParams(-1, -2));
        TextView c6 = g4.d.c(zZcINlcxH, 14, -16777216, HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f7893p = c6;
        addView(c6, new LinearLayout.LayoutParams(-2, g4.i.r(20.0f)));
        zZcINlcxH.W(this, Color.parseColor("#cccccc"), 0.5f, 10, 10, 10);
        TextView c7 = g4.d.c(zZcINlcxH, 12, Color.parseColor("#888888"), HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f7894q = c7;
        addView(c7, new LinearLayout.LayoutParams(-2, g4.i.r(40.0f)));
        this.f8037b = i7 + g4.i.r(100.0f);
        setBackground(g4.i.d(g4.i.c(-1, 5.0f, Color.parseColor("#cccccc"), 0.5f), g4.i.c(-256, 5.0f, Color.parseColor("#cccccc"), 0.5f)));
        setOnClickListener(new a(zZcINlcxH));
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        com.secret.prettyhezi.Server.c0 c0Var = (com.secret.prettyhezi.Server.c0) nVar;
        this.f7890m = c0Var;
        this.f7893p.setText(c0Var.nk);
        this.f7894q.setText(this.f7890m.tj.box + this.f7891n.s0(C0382R.string.Boxes));
    }

    @Override // com.secret.prettyhezi.View.u
    public RelativeLayout getTopRelativeLayout() {
        return this.f7892o;
    }

    @Override // com.secret.prettyhezi.View.u
    public void k() {
        this.f7891n.B(this.f7891n.s0(C0382R.string.UnfollowUser) + "：" + this.f7890m.nk + "?", new b(), true);
    }
}
