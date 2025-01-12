package com.secret.prettyhezi.Upload;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.abc;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.SLUjG;
import com.secret.prettyhezi.Server.j;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.io.Serializable;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class a extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    int f7427b;

    /* renamed from: c  reason: collision with root package name */
    int f7428c;

    /* renamed from: d  reason: collision with root package name */
    boolean f7429d;

    /* renamed from: e  reason: collision with root package name */
    TextView f7430e;

    /* renamed from: f  reason: collision with root package name */
    TextView f7431f;

    /* renamed from: g  reason: collision with root package name */
    TextView f7432g;

    /* renamed from: h  reason: collision with root package name */
    TextView f7433h;

    /* renamed from: i  reason: collision with root package name */
    TextView f7434i;

    /* renamed from: j  reason: collision with root package name */
    TextView f7435j;

    /* renamed from: k  reason: collision with root package name */
    TextView f7436k;

    /* renamed from: l  reason: collision with root package name */
    KLNPK f7437l;

    /* renamed from: m  reason: collision with root package name */
    int f7438m;

    /* renamed from: com.secret.prettyhezi.Upload.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0112a extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ j.a f7439d;

        C0112a(j.a aVar) {
            this.f7439d = aVar;
        }

        @Override // g4.f
        protected void a(View view) {
            a.this.f7437l.N0(SLUjG.class, this.f7439d.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends s.g {
        b(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            if (a.this.f7437l.isDestroyed() || a.this.f7437l.isFinishing()) {
                return;
            }
            a.this.f7437l.f7338w.z();
            a.this.g(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {
        c() {
        }

        @Override // g4.f
        protected void a(View view) {
            a.this.j(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {
        d() {
        }

        @Override // g4.f
        protected void a(View view) {
            a.this.j(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {
        e() {
        }

        @Override // g4.f
        protected void a(View view) {
            a.this.j(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends g4.f {
        f() {
        }

        @Override // g4.f
        protected void a(View view) {
            a.this.f(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends g4.f {
        g() {
        }

        @Override // g4.f
        protected void a(View view) {
            a.this.f(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f7447a;

        /* renamed from: com.secret.prettyhezi.Upload.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0113a extends s.g {
            C0113a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                if (a.this.f7437l.isDestroyed() || a.this.f7437l.isFinishing()) {
                    return;
                }
                com.secret.prettyhezi.Server.z zVar = (com.secret.prettyhezi.Server.z) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.Server.z.class);
                if (zVar.code != 200) {
                    d(zVar.err);
                    return;
                }
                a.this.f7437l.H("操作成功!");
                a.this.f7437l.S0();
            }
        }

        h(int i6) {
            this.f7447a = i6;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            a.this.f7437l.I0();
            StringBuilder sb = new StringBuilder();
            sb.append(com.secret.prettyhezi.Server.v.f7132a);
            sb.append(a.this.f7429d ? "appeal" : "report");
            sb.append("/audit/json");
            com.secret.prettyhezi.j.r(sb.toString(), new k(this.f7447a), true, new C0113a(a.this.f7437l));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f7450a;

        /* renamed from: com.secret.prettyhezi.Upload.a$i$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0114a extends s.g {
            C0114a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                if (a.this.f7437l.isDestroyed() || a.this.f7437l.isFinishing()) {
                    return;
                }
                com.secret.prettyhezi.Server.z zVar = (com.secret.prettyhezi.Server.z) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.Server.z.class);
                if (zVar.code == 200) {
                    a.this.f7437l.H("操作成功!");
                } else {
                    d(zVar.err);
                }
            }
        }

        i(boolean z5) {
            this.f7450a = z5;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            a.this.f7437l.I0();
            com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "report/perm/json", new j(this.f7450a), true, new C0114a(a.this.f7437l));
        }
    }

    /* loaded from: classes.dex */
    class j implements Serializable {
        public int id;

        /* renamed from: p  reason: collision with root package name */
        public int f7453p;

        /* renamed from: t  reason: collision with root package name */
        public int f7454t;

        j(boolean z5) {
            this.id = a.this.f7427b;
            this.f7454t = a.this.f7428c;
            this.f7453p = z5 ? 1 : 2;
        }
    }

    /* loaded from: classes.dex */
    class k implements Serializable {
        public int id;
        public int ok;

        /* renamed from: t  reason: collision with root package name */
        public int f7455t;

        k(int i6) {
            this.id = a.this.f7427b;
            this.f7455t = a.this.f7428c;
            this.ok = i6;
        }
    }

    public a(KLNPK klnpk, int i6, boolean z5) {
        super(klnpk);
        this.f7438m = g4.i.r(8.0f);
        this.f7437l = klnpk;
        this.f7428c = i6;
        this.f7429d = z5;
        setOrientation(1);
        setGravity(1);
        setPadding(0, 0, 0, g4.i.r(20.0f));
        i();
    }

    void a() {
        this.f7437l.U(this, "违规", 30, 50).setOnClickListener(new c());
        TextView U = this.f7437l.U(this, "不违规", 30, 50);
        U.setBackground(g4.i.e(ZZcINlcxH.f0(Color.parseColor("#00dd00"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#00ff00"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#cccccc"), 2.5f)));
        U.setOnClickListener(new d());
        if (this.f7429d) {
            return;
        }
        TextView U2 = this.f7437l.U(this, "不确定", 30, 50);
        U2.setBackground(g4.i.e(ZZcINlcxH.f0(Color.parseColor("#000000"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#555555"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#cccccc"), 2.5f)));
        U2.setOnClickListener(new e());
        TextView U3 = this.f7437l.U(this, "取消上传者上传权限", 60, 50);
        U3.setBackground(g4.i.e(ZZcINlcxH.f0(Color.parseColor("#b00000"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#800000"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#cccccc"), 2.5f)));
        U3.setOnClickListener(new f());
        TextView U4 = this.f7437l.U(this, "取消举报者举报权限", 30, 50);
        U4.setBackground(g4.i.e(ZZcINlcxH.f0(Color.parseColor("#b00000"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#800000"), 2.5f), ZZcINlcxH.f0(Color.parseColor("#cccccc"), 2.5f)));
        U4.setOnClickListener(new g());
    }

    void b() {
        LinearLayout linearLayout = new LinearLayout(this.f7437l);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int r5 = g4.i.r(4.0f);
        layoutParams.bottomMargin = r5;
        layoutParams.topMargin = r5;
        int i6 = this.f7438m;
        layoutParams.rightMargin = i6;
        layoutParams.leftMargin = i6;
        addView(linearLayout, layoutParams);
        TextView b6 = g4.d.b(this.f7437l, 12.0f, -16777216, "ID: ");
        this.f7430e = b6;
        linearLayout.addView(b6, new LinearLayout.LayoutParams(-2, -2));
        TextView c6 = g4.d.c(this.f7437l, 12, -16777216, "2023-02-31", 5);
        this.f7431f = c6;
        linearLayout.addView(c6, new LinearLayout.LayoutParams(0, -2, 1.0f));
    }

    void c() {
        LinearLayout linearLayout = new LinearLayout(this.f7437l);
        linearLayout.setOrientation(1);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        TextView a6 = g4.d.a(this.f7437l, 14.0f, -16777216);
        this.f7432g = a6;
        a6.setPadding(this.f7438m, g4.i.r(4.0f), g4.i.r(2.0f), g4.i.r(4.0f));
        this.f7432g.setSingleLine();
        this.f7432g.setGravity(16);
        linearLayout.addView(this.f7432g, new LinearLayout.LayoutParams(-1, -2));
        TextView a7 = g4.d.a(this.f7437l, 14.0f, -16777216);
        this.f7433h = a7;
        a7.setPadding(this.f7438m, 0, g4.i.r(2.0f), 0);
        linearLayout.addView(this.f7433h, new LinearLayout.LayoutParams(-1, -2));
        TextView c6 = g4.d.c(this.f7437l, 14, -65536, "上传到的盒子：", 19);
        this.f7434i = c6;
        c6.setPadding(this.f7438m, 0, g4.i.r(2.0f), 0);
        linearLayout.addView(this.f7434i, new LinearLayout.LayoutParams(-1, g4.i.r(30.0f)));
    }

    protected abstract void d();

    void e() {
        this.f7435j = g4.d.b(this.f7437l, 14.0f, -65536, "被举报原因：");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(20.0f);
        layoutParams.bottomMargin = g4.i.r(20.0f);
        int i6 = this.f7438m;
        layoutParams.rightMargin = i6;
        layoutParams.leftMargin = i6;
        addView(this.f7435j, layoutParams);
        if (this.f7429d) {
            this.f7436k = g4.d.b(this.f7437l, 14.0f, -65536, "申诉理由：");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = g4.i.r(20.0f);
            layoutParams2.bottomMargin = g4.i.r(20.0f);
            int i7 = this.f7438m;
            layoutParams2.rightMargin = i7;
            layoutParams2.leftMargin = i7;
            addView(this.f7436k, layoutParams2);
        }
    }

    void f(boolean z5) {
        String str = z5 ? "取消上传者上传权限?" : "取消举报者举报权限？";
        KLNPK klnpk = this.f7437l;
        klnpk.C(str, new String[]{"再想想", klnpk.s0(C0382R.string.ok)}, new i(z5), true);
    }

    protected abstract void g(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public int getMaxContentHeight() {
        return Math.min(g4.i.r(320.0f), (this.f7437l.o().y * 6) / 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        addView(g4.d.c(this.f7437l, 18, -16777216, "该类型没有内容需要审核", 17), new LinearLayout.LayoutParams(-1, g4.i.r(120.0f)));
    }

    void i() {
        StringBuilder sb = new StringBuilder();
        sb.append(com.secret.prettyhezi.Server.v.f7132a);
        sb.append(this.f7429d ? "appeal" : "report");
        sb.append("/show/json?t=");
        sb.append(this.f7428c);
        com.secret.prettyhezi.j.m(sb.toString(), new b(this.f7437l));
    }

    void j(int i6) {
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
        KLNPK klnpk = this.f7437l;
        klnpk.C(ams, new String[]{klnpk.s0(C0382R.string.cancel), str}, new h(i6), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(int i6, long j6, String str, String str2, String str3, String str4, j.a aVar) {
        boolean z5;
        d();
        b();
        c();
        this.f7437l.W(this, Color.parseColor("#aaaaaa"), 0.5f, 0, 10, 0);
        e();
        a();
        this.f7427b = i6;
        this.f7430e.setText("ID：" + i6);
        this.f7431f.setText(g4.i.w(j6));
        this.f7435j.setText("被举报原因：" + str);
        if (this.f7429d && str2 != null) {
            this.f7436k.setText("申诉理由：" + str2);
        }
        if (str3 == null || str3.isEmpty() || (str4 != null && str4.equals(str3))) {
            z5 = false;
        } else {
            this.f7432g.setText(str3);
            z5 = true;
        }
        this.f7432g.setVisibility(z5 ? 0 : 8);
        if (str4 == null || str4.isEmpty()) {
            this.f7433h.setVisibility(8);
        } else {
            this.f7433h.setText(this.f7437l.s0(C0382R.string.ContentIntroduce) + "：" + str4);
        }
        if (aVar == null || aVar.id == 0) {
            this.f7434i.setVisibility(8);
            return;
        }
        String str5 = aVar.na;
        if (str5 == null || str5.length() == 0) {
            str5 = HttpUrl.FRAGMENT_ENCODE_SET + aVar.id;
        }
        this.f7434i.setText("上传到的盒子：" + str5);
        this.f7434i.setOnClickListener(new C0112a(aVar));
    }
}
