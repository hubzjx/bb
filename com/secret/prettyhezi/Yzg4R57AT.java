package com.secret.prettyhezi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Game.m0;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.b0;
import com.secret.prettyhezi.Server.c0;
import com.secret.prettyhezi.View.e0;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.l;
import com.secret.prettyhezi.controls.z;
import com.secret.prettyhezi.s;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class Yzg4R57AT extends UoWMF {
    int A;

    /* renamed from: r  reason: collision with root package name */
    FrameLayout f8142r;

    /* renamed from: s  reason: collision with root package name */
    RelativeLayout f8143s;

    /* renamed from: t  reason: collision with root package name */
    TextView f8144t;

    /* renamed from: u  reason: collision with root package name */
    p f8145u;

    /* renamed from: v  reason: collision with root package name */
    com.secret.prettyhezi.controls.l f8146v;

    /* renamed from: w  reason: collision with root package name */
    c0 f8147w;

    /* renamed from: x  reason: collision with root package name */
    int f8148x;

    /* renamed from: z  reason: collision with root package name */
    LinearLayout f8150z;

    /* renamed from: y  reason: collision with root package name */
    boolean f8149y = false;
    com.secret.prettyhezi.View.f B = null;
    com.secret.prettyhezi.View.f C = null;
    e0 D = null;
    m0 E = null;
    l.f F = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            b0 b0Var = (b0) com.secret.prettyhezi.f.d(str, b0.class);
            if (b0Var.code != 200) {
                d(b0Var.err);
                return;
            }
            Yzg4R57AT yzg4R57AT = Yzg4R57AT.this;
            yzg4R57AT.f8147w = b0Var.data;
            yzg4R57AT.S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            Yzg4R57AT.this.M0(Fc3zRvpgB.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {

        /* loaded from: classes.dex */
        class a implements s.f {
            a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                Yzg4R57AT.this.f8145u.b(false);
            }
        }

        /* loaded from: classes.dex */
        class b implements s.f {
            b() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                Yzg4R57AT.this.f8145u.b(true);
                MainApplication.f6711r.r().integral.all -= 2.0d;
                MainApplication.f6711r.x();
                EjNkL.N.f6165r.j();
            }
        }

        c() {
        }

        @Override // g4.f
        public void a(View view) {
            Yzg4R57AT yzg4R57AT = Yzg4R57AT.this;
            if (yzg4R57AT.f8145u.f8746d) {
                s.g(yzg4R57AT.f8148x, yzg4R57AT, new a());
            } else {
                s.c(yzg4R57AT.f8148x, yzg4R57AT, new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {

            /* renamed from: com.secret.prettyhezi.Yzg4R57AT$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0130a implements s.f {
                C0130a() {
                }

                @Override // com.secret.prettyhezi.s.f
                public void a(String str) {
                    Yzg4R57AT.this.H("操作成功");
                    Yzg4R57AT.this.finish();
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                Yzg4R57AT.this.I0();
                j.o(com.secret.prettyhezi.Server.v.f7132a + "user/status/json?id=" + Yzg4R57AT.this.f8148x, true, new s.e(Yzg4R57AT.this, new C0130a()));
            }
        }

        d() {
        }

        @Override // g4.f
        protected void a(View view) {
            Yzg4R57AT.this.B("关闭该用户?", new a(), true);
        }
    }

    /* loaded from: classes.dex */
    class e implements l.f {
        e() {
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public int a() {
            return Yzg4R57AT.this.A;
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public String b(int i6) {
            Yzg4R57AT yzg4R57AT;
            int i7;
            if (i6 == 0) {
                yzg4R57AT = Yzg4R57AT.this;
                i7 = C0382R.string.Boxes;
            } else if (i6 == 1) {
                yzg4R57AT = Yzg4R57AT.this;
                i7 = C0382R.string.Followed_Boxes;
            } else if (i6 == 2) {
                return "中奖记录";
            } else {
                if (i6 != 3) {
                    return "错误";
                }
                yzg4R57AT = Yzg4R57AT.this;
                i7 = C0382R.string.Followed_Users;
            }
            return yzg4R57AT.s0(i7);
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public String c(int i6) {
            StringBuilder sb;
            int i7;
            if (i6 == 0) {
                sb = new StringBuilder();
                i7 = Yzg4R57AT.this.f8147w.tj.box;
            } else if (i6 == 1) {
                sb = new StringBuilder();
                i7 = Yzg4R57AT.this.f8147w.tj.box_follow;
            } else if (i6 == 2) {
                return "最新";
            } else {
                if (i6 != 3) {
                    return "0";
                }
                sb = new StringBuilder();
                i7 = Yzg4R57AT.this.f8147w.tj.follow;
            }
            sb.append(i7);
            sb.append(HttpUrl.FRAGMENT_ENCODE_SET);
            return sb.toString();
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public View d(int i6) {
            if (i6 == 0) {
                Yzg4R57AT yzg4R57AT = Yzg4R57AT.this;
                if (yzg4R57AT.f8147w.tj.box == 0) {
                    return yzg4R57AT.f8146v.r();
                }
                if (yzg4R57AT.B == null) {
                    yzg4R57AT.B = new com.secret.prettyhezi.View.f(Yzg4R57AT.this);
                    Yzg4R57AT yzg4R57AT2 = Yzg4R57AT.this;
                    yzg4R57AT2.B.g(com.secret.prettyhezi.Server.v.k(yzg4R57AT2.f8148x, 999));
                    Yzg4R57AT.this.B.S = true;
                }
                return Yzg4R57AT.this.B;
            } else if (i6 == 1) {
                Yzg4R57AT yzg4R57AT3 = Yzg4R57AT.this;
                if (yzg4R57AT3.f8147w.tj.box_follow == 0) {
                    return yzg4R57AT3.f8146v.r();
                }
                if (yzg4R57AT3.C == null) {
                    yzg4R57AT3.C = new com.secret.prettyhezi.View.f(Yzg4R57AT.this);
                    Yzg4R57AT yzg4R57AT4 = Yzg4R57AT.this;
                    yzg4R57AT4.C.g(com.secret.prettyhezi.Server.v.f(yzg4R57AT4.f8148x, 999));
                }
                return Yzg4R57AT.this.C;
            } else if (i6 == 2) {
                Yzg4R57AT yzg4R57AT5 = Yzg4R57AT.this;
                if (yzg4R57AT5.E == null) {
                    Yzg4R57AT yzg4R57AT6 = Yzg4R57AT.this;
                    yzg4R57AT5.E = new m0(yzg4R57AT6, yzg4R57AT6.f8148x);
                }
                return Yzg4R57AT.this.E;
            } else if (i6 == 3) {
                Yzg4R57AT yzg4R57AT7 = Yzg4R57AT.this;
                if (yzg4R57AT7.f8147w.tj.follow == 0) {
                    return yzg4R57AT7.f8146v.r();
                }
                if (yzg4R57AT7.D == null) {
                    yzg4R57AT7.D = new e0(Yzg4R57AT.this);
                    Yzg4R57AT yzg4R57AT8 = Yzg4R57AT.this;
                    yzg4R57AT8.D.g(com.secret.prettyhezi.Server.v.h(yzg4R57AT8.f8148x, 999));
                }
                return Yzg4R57AT.this.D;
            } else {
                return null;
            }
        }

        @Override // com.secret.prettyhezi.controls.l.f
        public View e() {
            return Yzg4R57AT.this.f8150z;
        }
    }

    /* loaded from: classes.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ZZcINlcxH j6 = g4.i.j();
            Yzg4R57AT yzg4R57AT = Yzg4R57AT.this;
            if (j6 != yzg4R57AT) {
                yzg4R57AT.f8146v.t();
            }
        }
    }

    void S0() {
        a0 r5;
        LinearLayout linearLayout = new LinearLayout(this);
        this.f8150z = linearLayout;
        linearLayout.setOrientation(1);
        this.f8150z.setBackgroundColor(-1);
        RelativeLayout M = M(this.f8150z, HttpUrl.FRAGMENT_ENCODE_SET);
        this.f8143s = M;
        this.f8144t = (TextView) M.findViewById(12);
        this.A = this.f8143s.getLayoutParams().height;
        boolean z5 = MainApplication.f() == this.f8148x;
        p pVar = new p(this);
        this.f8145u = pVar;
        pVar.f8744b.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(11, -1);
        this.f8143s.addView(this.f8145u, layoutParams);
        if (z5) {
            View zVar = new z(this, C0382R.drawable.ic_settings);
            int r6 = g4.i.r(8.0f);
            zVar.setPadding(r6, r6, r6, r6);
            zVar.setBackground(g4.i.d(null, g4.i.b(Color.parseColor("#cccccc"), 4.0f)));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g4.i.r(42.0f), g4.i.r(42.0f));
            layoutParams2.rightMargin = g4.i.r(12.0f);
            zVar.setLayoutParams(layoutParams2);
            p pVar2 = this.f8145u;
            pVar2.removeView(pVar2.f8744b);
            this.f8145u.addView(zVar);
            zVar.setOnClickListener(new b());
        } else {
            this.f8145u.f8744b.setOnClickListener(new c());
            this.f8145u.b(this.f8147w.is_follow);
        }
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(g4.i.r(16.0f), 0, 0, 0);
        this.f8150z.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        View dVar = new com.secret.prettyhezi.View.d(this);
        float f6 = 64;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(f6), g4.i.r(f6));
        int r7 = g4.i.r(10.0f);
        layoutParams3.bottomMargin = r7;
        layoutParams3.topMargin = r7;
        linearLayout2.addView(dVar, layoutParams3);
        this.A += g4.i.r(84);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = g4.i.r(6.0f);
        linearLayout2.addView(linearLayout3, layoutParams4);
        TextView b6 = g4.d.b(this, 18.0f, -16777216, this.f8147w.nk);
        b6.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
        linearLayout3.addView(b6, new LinearLayout.LayoutParams(-2, -2));
        com.secret.prettyhezi.controls.l lVar = new com.secret.prettyhezi.controls.l(this, 3, this.F);
        this.f8146v = lVar;
        lVar.f(this.f8149y ? 2 : 0);
        this.f8142r.addView(this.f8146v, new FrameLayout.LayoutParams(-1, -1));
        if (Fc3zRvpgB.f6210z && (r5 = MainApplication.f6711r.r()) != null && r5.mas) {
            this.f8145u.setVisibility(8);
            TextView c6 = g4.d.c(this, 14, -1, "关闭", 17);
            c6.setBackground(g4.i.d(g4.i.b(-65536, 5.0f), g4.i.b(Color.parseColor("#88ff0000"), 5.0f)));
            c6.setOnClickListener(new d());
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(36.0f));
            layoutParams5.addRule(11, -1);
            layoutParams5.addRule(15, -1);
            layoutParams5.rightMargin = g4.i.r(12.0f);
            this.f8143s.addView(c6, layoutParams5);
        }
    }

    void T0(Intent intent) {
        this.B = null;
        this.C = null;
        I0();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.f8148x = extras.getInt("id");
            this.f8149y = extras.getInt("type") > 0;
        }
        j.o(com.secret.prettyhezi.Server.v.f7132a + com.secret.prettyhezi.Server.v.l(this.f8148x), true, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8142r = A0(3, 4);
        T0(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.secret.prettyhezi.View.f fVar = this.B;
        if (fVar != null) {
            fVar.b();
        }
        com.secret.prettyhezi.View.f fVar2 = this.C;
        if (fVar2 != null) {
            fVar2.b();
        }
        e0 e0Var = this.D;
        if (e0Var != null) {
            e0Var.b();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f8142r.removeAllViews();
        T0(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onPause() {
        super.onPause();
        com.secret.prettyhezi.controls.l lVar = this.f8146v;
        if (lVar != null) {
            lVar.postDelayed(new f(), 1000L);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        if (this.f8146v == null || System.currentTimeMillis() - this.f8146v.A >= 500) {
            super.startActivity(intent);
        }
    }
}
