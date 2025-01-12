package com.secret.prettyhezi.Upload;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.abc;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Server.s;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CheckBaseActivity extends UoWMF {
    TextView A;
    int B = g4.i.r(8.0f);

    /* renamed from: r  reason: collision with root package name */
    int f7242r;

    /* renamed from: s  reason: collision with root package name */
    int f7243s;

    /* renamed from: t  reason: collision with root package name */
    boolean f7244t;

    /* renamed from: u  reason: collision with root package name */
    LinearLayout f7245u;

    /* renamed from: v  reason: collision with root package name */
    public LinearLayout f7246v;

    /* renamed from: w  reason: collision with root package name */
    TextView f7247w;

    /* renamed from: x  reason: collision with root package name */
    TextView f7248x;

    /* renamed from: y  reason: collision with root package name */
    TextView f7249y;

    /* renamed from: z  reason: collision with root package name */
    TextView f7250z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            if (CheckBaseActivity.this.isDestroyed() || CheckBaseActivity.this.isFinishing()) {
                return;
            }
            CheckBaseActivity.this.a1(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            s.a GetItem = com.secret.prettyhezi.Server.s.GetItem(p.a(CheckBaseActivity.this.f7243s));
            if (GetItem != null) {
                com.secret.prettyhezi.controls.x E = CheckBaseActivity.this.E(GetItem.name, GetItem.content, null, true);
                E.b();
                E.f8479f.setGravity(3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {
        c() {
        }

        @Override // g4.f
        protected void a(View view) {
            CheckBaseActivity.this.c1(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {
        d() {
        }

        @Override // g4.f
        protected void a(View view) {
            CheckBaseActivity.this.c1(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {
        e() {
        }

        @Override // g4.f
        protected void a(View view) {
            CheckBaseActivity.this.c1(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {
        f() {
        }

        @Override // g4.f
        protected void a(View view) {
            CheckBaseActivity.this.X0(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends g4.f {
        g() {
        }

        @Override // g4.f
        protected void a(View view) {
            CheckBaseActivity.this.X0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f7258a;

        /* loaded from: classes.dex */
        class a extends s.g {
            a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                if (CheckBaseActivity.this.isDestroyed() || CheckBaseActivity.this.isFinishing()) {
                    return;
                }
                com.secret.prettyhezi.Server.z zVar = (com.secret.prettyhezi.Server.z) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.Server.z.class);
                if (zVar.code != 200) {
                    d(zVar.err);
                    return;
                }
                int size = ZZcINlcxH.f8162n.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    Activity activity = (Activity) ZZcINlcxH.f8162n.get(size);
                    if (activity instanceof UwfeFVz0V) {
                        ((UwfeFVz0V) activity).S0();
                        break;
                    }
                    size--;
                }
                CheckBaseActivity.this.finish();
            }
        }

        h(int i6) {
            this.f7258a = i6;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            CheckBaseActivity.this.I0();
            StringBuilder sb = new StringBuilder();
            sb.append(com.secret.prettyhezi.Server.v.f7132a);
            sb.append(CheckBaseActivity.this.f7244t ? "appeal" : "report");
            sb.append("/audit/json");
            com.secret.prettyhezi.j.r(sb.toString(), new k(this.f7258a), true, new a(CheckBaseActivity.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f7261a;

        /* loaded from: classes.dex */
        class a extends s.g {
            a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                if (CheckBaseActivity.this.isDestroyed() || CheckBaseActivity.this.isFinishing()) {
                    return;
                }
                com.secret.prettyhezi.Server.z zVar = (com.secret.prettyhezi.Server.z) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.Server.z.class);
                if (zVar.code == 200) {
                    CheckBaseActivity.this.H("操作成功!");
                } else {
                    d(zVar.err);
                }
            }
        }

        i(boolean z5) {
            this.f7261a = z5;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            CheckBaseActivity.this.I0();
            com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "report/perm/json", new j(this.f7261a), true, new a(CheckBaseActivity.this));
        }
    }

    /* loaded from: classes.dex */
    class j implements Serializable {
        public int id;

        /* renamed from: p  reason: collision with root package name */
        public int f7264p;

        /* renamed from: t  reason: collision with root package name */
        public int f7265t;

        j(boolean z5) {
            this.id = CheckBaseActivity.this.f7242r;
            this.f7265t = CheckBaseActivity.this.f7243s;
            this.f7264p = z5 ? 1 : 2;
        }
    }

    /* loaded from: classes.dex */
    class k implements Serializable {
        public int id;
        public int ok;

        /* renamed from: t  reason: collision with root package name */
        public int f7266t;

        k(int i6) {
            this.id = CheckBaseActivity.this.f7242r;
            this.f7266t = CheckBaseActivity.this.f7243s;
            this.ok = i6;
        }
    }

    void S0() {
        U(this.f7246v, "违规", 30, 50).setOnClickListener(new c());
        TextView U = U(this.f7246v, "不违规", 30, 50);
        U.setBackground(g4.i.e(ZZcINlcxH.f0(Color.parseColor("#00dd00"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#00ff00"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#cccccc"), 2.5f)));
        U.setOnClickListener(new d());
        if (this.f7244t) {
            return;
        }
        TextView U2 = U(this.f7246v, "不确定", 30, 50);
        U2.setBackground(g4.i.e(ZZcINlcxH.f0(Color.parseColor("#000000"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#555555"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#cccccc"), 2.5f)));
        U2.setOnClickListener(new e());
        TextView U3 = U(this.f7246v, "取消上传者上传权限", 60, 50);
        U3.setBackground(g4.i.e(ZZcINlcxH.f0(Color.parseColor("#b00000"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#800000"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#cccccc"), 2.5f)));
        U3.setOnClickListener(new f());
        TextView U4 = U(this.f7246v, "取消举报者举报权限", 30, 50);
        U4.setBackground(g4.i.e(ZZcINlcxH.f0(Color.parseColor("#b00000"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#800000"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#cccccc"), 2.5f)));
        U4.setOnClickListener(new g());
    }

    void T0() {
        this.f7247w = g4.d.b(this, 12.0f, -16777216, "ID: ");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int r5 = g4.i.r(4.0f);
        layoutParams.bottomMargin = r5;
        layoutParams.topMargin = r5;
        layoutParams.leftMargin = this.B;
        this.f7246v.addView(this.f7247w, layoutParams);
    }

    void U0() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        this.f7246v.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        TextView a6 = g4.d.a(this, 14.0f, -16777216);
        this.f7248x = a6;
        a6.setPadding(this.B, g4.i.r(4.0f), g4.i.r(2.0f), g4.i.r(4.0f));
        this.f7248x.setSingleLine();
        this.f7248x.setGravity(16);
        linearLayout.addView(this.f7248x, new LinearLayout.LayoutParams(-1, -2));
        TextView a7 = g4.d.a(this, 14.0f, -16777216);
        this.f7249y = a7;
        a7.setPadding(this.B, 0, g4.i.r(2.0f), 0);
        linearLayout.addView(this.f7249y, new LinearLayout.LayoutParams(-1, -2));
    }

    protected void V0() {
    }

    void W0() {
        this.f7250z = g4.d.b(this, 14.0f, -65536, "被举报原因：");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(20.0f);
        layoutParams.bottomMargin = g4.i.r(20.0f);
        int i6 = this.B;
        layoutParams.rightMargin = i6;
        layoutParams.leftMargin = i6;
        this.f7246v.addView(this.f7250z, layoutParams);
        if (this.f7244t) {
            this.A = g4.d.b(this, 14.0f, -65536, "申诉理由：");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = g4.i.r(20.0f);
            layoutParams2.bottomMargin = g4.i.r(20.0f);
            int i7 = this.B;
            layoutParams2.rightMargin = i7;
            layoutParams2.leftMargin = i7;
            this.f7246v.addView(this.A, layoutParams2);
        }
    }

    void X0(boolean z5) {
        C(z5 ? "取消上传者上传权限?" : "取消举报者举报权限？", new String[]{"再想想", s0(C0382R.string.ok)}, new i(z5), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Y0() {
        return Math.min(g4.i.r(320.0f), (o().y * 6) / 10);
    }

    void Z0() {
        N(this.f7245u, this.f7244t ? abc.ams("s12") : "审核", "规则", new b());
    }

    protected void a1(String str) {
    }

    void b1() {
        G0();
        StringBuilder sb = new StringBuilder();
        sb.append(com.secret.prettyhezi.Server.v.f7132a);
        sb.append(this.f7244t ? "appeal" : "report");
        sb.append("/show/json?t=");
        sb.append(this.f7243s);
        sb.append("&id=");
        sb.append(this.f7242r);
        com.secret.prettyhezi.j.m(sb.toString(), new a(this));
    }

    void c1(int i6) {
        String ams;
        String str;
        if (i6 == 0) {
            ams = abc.ams("s15");
            str = "不违规";
        } else if (i6 != 1) {
            ams = abc.ams("s13");
            str = abc.ams("s14");
        } else {
            ams = abc.ams("s16");
            str = "违规";
        }
        C(ams, new String[]{s0(C0382R.string.cancel), str}, new h(i6), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d1(int i6, String str, String str2, String str3, String str4) {
        boolean z5;
        TextView textView = this.f7247w;
        textView.setText("ID：" + i6);
        TextView textView2 = this.f7250z;
        textView2.setText("被举报原因：" + str);
        if (this.f7244t && str2 != null) {
            TextView textView3 = this.A;
            textView3.setText("申诉理由：" + str2);
        }
        if (str3 == null || str3.isEmpty() || (str4 != null && str4.equals(str3))) {
            z5 = false;
        } else {
            this.f7248x.setText(str3);
            z5 = true;
        }
        this.f7248x.setVisibility(z5 ? 0 : 8);
        if (str4 == null || str4.isEmpty()) {
            this.f7249y.setVisibility(8);
            return;
        }
        TextView textView4 = this.f7249y;
        textView4.setText(s0(C0382R.string.ContentIntroduce) + "：" + str4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7242r = extras.getInt("id");
            this.f7243s = extras.getInt("type");
            this.f7244t = extras.getInt("extra") > 0;
        }
        this.f7245u = C0();
        Z0();
        LinearLayout e6 = e(this.f7245u);
        this.f7246v = e6;
        e6.setGravity(1);
        this.f7246v.setPadding(0, 0, 0, g4.i.r(20.0f));
        V0();
        T0();
        U0();
        W(this.f7246v, Color.parseColor("#aaaaaa"), 0.5f, 0, 10, 0);
        W0();
        S0();
        b1();
    }
}
