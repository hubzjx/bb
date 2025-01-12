package com.secret.prettyhezi.View;

import android.app.AlertDialog;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.LpyhZ;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.PTnimM;
import com.secret.prettyhezi.SLUjG;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.s;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class e extends u {

    /* renamed from: m  reason: collision with root package name */
    private com.secret.prettyhezi.Server.d f7899m;

    /* renamed from: n  reason: collision with root package name */
    private ZZcINlcxH f7900n;

    /* renamed from: o  reason: collision with root package name */
    private RelativeLayout f7901o;

    /* renamed from: p  reason: collision with root package name */
    private com.secret.prettyhezi.controls.r f7902p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f7903q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f7904r;

    /* renamed from: s  reason: collision with root package name */
    private RelativeLayout f7905s;

    /* renamed from: t  reason: collision with root package name */
    private g f7906t;

    /* renamed from: u  reason: collision with root package name */
    private p f7907u;

    /* renamed from: v  reason: collision with root package name */
    private LinearLayout f7908v;

    /* renamed from: w  reason: collision with root package name */
    View.OnClickListener f7909w;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            e.this.t();
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {

        /* loaded from: classes.dex */
        class a implements s.f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f7912a;

            a(View view) {
                this.f7912a = view;
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                this.f7912a.setVisibility(8);
                MainApplication.f6711r.r().integral.all -= MainApplication.f6711r.j();
                MainApplication.f6711r.x();
                EjNkL.N.f6165r.j();
            }
        }

        b() {
        }

        @Override // g4.f
        public void a(View view) {
            com.secret.prettyhezi.s.b(e.this.f7899m.id, e.this.f7900n, new a(view));
        }
    }

    /* loaded from: classes.dex */
    class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            e.this.f7900n.O0(PTnimM.class, e.this.f7899m.id, 1);
        }
    }

    /* loaded from: classes.dex */
    class d implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.x f7915a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f7916b;

        /* loaded from: classes.dex */
        class a implements s.f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f7918a;

            a(String str) {
                this.f7918a = str;
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                e.this.f7899m.na = this.f7918a;
                e.this.f7904r.setText(this.f7918a);
            }
        }

        d(com.secret.prettyhezi.controls.x xVar, EditText editText) {
            this.f7915a = xVar;
            this.f7916b = editText;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            Object tag = this.f7915a.getTag();
            if (tag == null) {
                return;
            }
            this.f7915a.setTag(null);
            ((AlertDialog) tag).dismiss();
            if (i6 == 1) {
                String trim = this.f7916b.getText().toString().trim();
                if (trim.length() <= 0 || trim.equals(e.this.f7899m.na)) {
                    return;
                }
                e.this.f7900n.I0();
                com.secret.prettyhezi.Server.v.t(e.this.f7899m.id, trim, new s.e(e.this.f7900n, new a(trim)));
            }
        }
    }

    /* renamed from: com.secret.prettyhezi.View.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0126e extends ZZcINlcxH.q {

        /* renamed from: com.secret.prettyhezi.View.e$e$a */
        /* loaded from: classes.dex */
        class a implements a.f {

            /* renamed from: com.secret.prettyhezi.View.e$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0127a implements s.f {
                C0127a() {
                }

                @Override // com.secret.prettyhezi.s.f
                public void a(String str) {
                    e.this.j().z(e.this.f7899m, e.this);
                    a0.a aVar = MainApplication.f6711r.r().count;
                    aVar.box--;
                    MainApplication.f6711r.x();
                    EjNkL.N.f6165r.j();
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                com.secret.prettyhezi.s.a(e.this.f7899m.id, e.this.f7900n, new C0127a());
            }
        }

        /* renamed from: com.secret.prettyhezi.View.e$e$b */
        /* loaded from: classes.dex */
        class b implements s.f {
            b() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                e.this.j().z(e.this.f7899m, e.this);
            }
        }

        C0126e() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            e eVar = e.this;
            if (eVar.f8038c) {
                com.secret.prettyhezi.Device.a.b(eVar.f7900n, new a());
            } else {
                com.secret.prettyhezi.s.f(eVar.f7899m.id, e.this.f7900n, new b());
            }
        }
    }

    public e(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH, i6);
        this.f7908v = null;
        this.f7909w = new c();
        this.f7900n = zZcINlcxH;
        RelativeLayout relativeLayout = new RelativeLayout(zZcINlcxH);
        this.f7901o = relativeLayout;
        addView(relativeLayout, new LinearLayout.LayoutParams(i6, 100));
        com.secret.prettyhezi.controls.r rVar = new com.secret.prettyhezi.controls.r(zZcINlcxH, HttpUrl.FRAGMENT_ENCODE_SET);
        this.f7902p = rVar;
        this.f7901o.addView(rVar, new RelativeLayout.LayoutParams(-1, -1));
        this.f7902p.setBackgroundColor(Color.parseColor("#cccccc"));
        this.f7902p.setOnClickListener(new a());
        TextView c6 = g4.d.c(zZcINlcxH, 12, -1, HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f7903q = c6;
        c6.setPadding(g4.i.r(2.0f), 0, g4.i.r(2.0f), 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, g4.i.r(16.0f));
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.f7901o.addView(this.f7903q, layoutParams);
        this.f7903q.setOnClickListener(this.f7909w);
        RelativeLayout relativeLayout2 = new RelativeLayout(zZcINlcxH);
        this.f7905s = relativeLayout2;
        addView(relativeLayout2, new LinearLayout.LayoutParams(-1, g4.i.r(46.0f)));
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(1);
        this.f7905s.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
        int r5 = g4.i.r(8.0f);
        TextView c7 = g4.d.c(zZcINlcxH, 14, -16777216, HttpUrl.FRAGMENT_ENCODE_SET, 16);
        this.f7904r = c7;
        c7.setPadding(r5, 0, g4.i.r(2.0f), 0);
        this.f7904r.setSingleLine();
        linearLayout.addView(this.f7904r, new LinearLayout.LayoutParams(-2, g4.i.r(20.0f)));
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(19);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, g4.i.r(26.0f));
        layoutParams2.leftMargin = r5;
        linearLayout.addView(linearLayout2, layoutParams2);
        this.f7906t = new g(zZcINlcxH);
        this.f7907u = new p(zZcINlcxH, C0382R.drawable.ic_add);
        linearLayout2.addView(this.f7906t, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = g4.i.r(10.0f);
        linearLayout2.addView(this.f7907u, layoutParams3);
        this.f7907u.setOnClickListener(this.f7909w);
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(com.secret.prettyhezi.Server.n nVar) {
        int i6;
        this.f7899m = (com.secret.prettyhezi.Server.d) nVar;
        this.f7902p.setBackgroundColor(Color.parseColor("#cccccc"));
        com.secret.prettyhezi.Server.l lVar = this.f7899m.co;
        if (lVar != null) {
            this.f7902p.b(lVar.f7128p);
        }
        com.secret.prettyhezi.Server.l lVar2 = this.f7899m.co;
        this.f8037b = (lVar2 == null || (i6 = lVar2.f7129w) < 1) ? g4.i.r(40.0f) : (lVar2.f7127h * this.f8039d) / i6;
        this.f7901o.setLayoutParams(new LinearLayout.LayoutParams(this.f8039d, this.f8037b));
        this.f7903q.setText(this.f7899m.tj.fc + this.f7900n.s0(C0382R.string.followers));
        this.f7904r.setText(this.f7899m.na);
        this.f7906t.c(this.f7899m.tj.cc);
        this.f7907u.a(Integer.toString(this.f7899m.tj.fc));
        this.f8037b += g4.i.r(46.0f);
        if (this.f8038c) {
            this.f8041f = true;
        }
    }

    @Override // com.secret.prettyhezi.View.u
    public RelativeLayout getTopRelativeLayout() {
        return this.f7901o;
    }

    @Override // com.secret.prettyhezi.View.u
    public View i() {
        return this.f8038c ? d() : c();
    }

    @Override // com.secret.prettyhezi.View.u
    public void k() {
        if (this.f7900n instanceof LpyhZ) {
            super.k();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8038c ? "删除盒子将扣除用户关注盒子所获得的积分，确定删除" : this.f7900n.s0(C0382R.string.UnfollowBox));
        sb.append("：");
        sb.append(this.f7899m.na);
        sb.append("?");
        this.f7900n.B(sb.toString(), new C0126e(), true);
    }

    @Override // com.secret.prettyhezi.View.u
    public void l() {
        com.secret.prettyhezi.controls.x xVar = new com.secret.prettyhezi.controls.x(this.f7900n);
        xVar.f(this.f7900n.s0(C0382R.string.ChangeBoxName));
        LinearLayout linearLayout = new LinearLayout(this.f7900n);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setPadding(g4.i.r(12.0f), g4.i.r(10.0f), g4.i.r(12.0f), 0);
        EditText editText = new EditText(getContext());
        editText.setTextSize(16.0f);
        editText.setTextColor(-16777216);
        editText.setPadding(g4.i.r(4.0f), g4.i.r(6.0f), g4.i.r(4.0f), g4.i.r(6.0f));
        editText.setGravity(16);
        editText.setBackground(g4.i.c(Color.parseColor("#f2f2f2"), 4.0f, Color.parseColor("#888888"), 1.0f));
        editText.setText(this.f7899m.na);
        com.secret.prettyhezi.controls.j.a(editText, 10, 7);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(160.0f), g4.i.r(40.0f));
        layoutParams.topMargin = g4.i.r(10.0f);
        layoutParams.bottomMargin = g4.i.r(4.0f);
        linearLayout.addView(editText, layoutParams);
        xVar.e(linearLayout);
        xVar.d(new String[]{this.f7900n.s0(C0382R.string.cancel), this.f7900n.s0(C0382R.string.ok)}, new d(xVar, editText));
        this.f7900n.x(xVar, null, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        LinearLayout linearLayout = this.f7908v;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            return;
        }
        ZZcINlcxH j6 = g4.i.j();
        LinearLayout linearLayout2 = new LinearLayout(j6);
        this.f7908v = linearLayout2;
        linearLayout2.setGravity(17);
        this.f7908v.setOrientation(1);
        this.f7908v.setPadding(g4.i.r(6.0f), g4.i.r(2.0f), g4.i.r(6.0f), g4.i.r(2.0f));
        this.f7908v.addView(new com.secret.prettyhezi.controls.z(j6, C0382R.drawable.ic_add), new LinearLayout.LayoutParams(g4.i.r(20.0f), g4.i.r(20.0f)));
        this.f7908v.addView(g4.d.b(j6, 10.0f, Color.parseColor("#888888"), this.f7900n.s0(C0382R.string.follow)), new LinearLayout.LayoutParams(-2, -2));
        this.f7908v.setBackground(g4.i.d(null, g4.i.b(Color.parseColor("#aaaaaa"), 4.0f)));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = g4.i.r(6.0f);
        layoutParams.addRule(11, -1);
        layoutParams.addRule(15, -1);
        this.f7905s.addView(this.f7908v, layoutParams);
        this.f7908v.setOnClickListener(new b());
    }

    void t() {
        this.f7900n.N0(SLUjG.class, this.f7899m.id);
        com.secret.prettyhezi.d.Box.addItem((com.secret.prettyhezi.Server.d) com.secret.prettyhezi.f.a(this.f7899m, com.secret.prettyhezi.Server.d.class));
    }
}
