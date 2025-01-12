package com.secret.prettyhezi.share;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.n;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.View.u;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import okhttp3.HttpUrl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends u {

    /* renamed from: m  reason: collision with root package name */
    TextView f9036m;

    /* renamed from: n  reason: collision with root package name */
    TextView f9037n;

    /* renamed from: o  reason: collision with root package name */
    k f9038o;

    /* renamed from: p  reason: collision with root package name */
    View f9039p;

    /* renamed from: q  reason: collision with root package name */
    TextView f9040q;

    /* renamed from: r  reason: collision with root package name */
    TextView f9041r;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            l.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f9043a;

        /* loaded from: classes.dex */
        class a implements a.f {

            /* renamed from: com.secret.prettyhezi.share.l$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0152a extends s.g {

                /* renamed from: com.secret.prettyhezi.share.l$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class C0153a extends ZZcINlcxH.q {
                    C0153a() {
                    }

                    @Override // com.secret.prettyhezi.ZZcINlcxH.q
                    public void b() {
                        b.this.f9043a.finish();
                    }
                }

                C0152a(ZZcINlcxH zZcINlcxH) {
                    super(zZcINlcxH);
                }

                @Override // com.secret.prettyhezi.s.g
                public void g(String str) {
                    d dVar = (d) com.secret.prettyhezi.f.d(str, d.class);
                    if (dVar.code != 200) {
                        f(dVar.err);
                        return;
                    }
                    if (dVar.data.integral != null) {
                        MainApplication.f6711r.r().integral = dVar.data.integral;
                    }
                    if (dVar.data.permission != null) {
                        MainApplication.f6711r.r().permission = dVar.data.permission;
                    }
                    if (dVar.data.expire != null) {
                        MainApplication.f6711r.r().expire = dVar.data.expire;
                    }
                    if (l.this.f9038o.download) {
                        a0 r5 = MainApplication.f6711r.r();
                        if (l.this.f9038o.type == 1) {
                            r5.py1 = 1;
                        } else {
                            r5.py2 = 1;
                        }
                    }
                    MainApplication.f6711r.x();
                    EjNkL.N.f6165r.j();
                    EjNkL.N.f6165r.i();
                    ZZcINlcxH zZcINlcxH = b.this.f9043a;
                    zZcINlcxH.F(" 你已兑换了" + l.this.f9038o.name + "，你也可以通过邀请他人兑换权限获取积分。", null, b.this.f9043a.s0(C0382R.string.IKnow), new C0153a(), false);
                }
            }

            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                b.this.f9043a.I0();
                com.secret.prettyhezi.j.r(v.f7132a + "user/order/buy/json", new v.g(l.this.f9038o.id), true, new C0152a(b.this.f9043a));
            }
        }

        b(ZZcINlcxH zZcINlcxH) {
            this.f9043a = zZcINlcxH;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            com.secret.prettyhezi.Device.a.b(this.f9043a, new a());
        }
    }

    public l(ZZcINlcxH zZcINlcxH) {
        super(zZcINlcxH, 0);
        setOrientation(0);
        setGravity(16);
        setBackground(g4.i.c(-1, 5.0f, -16777216, 1.0f));
        setPadding(g4.i.r(6.0f), 0, g4.i.r(6.0f), 0);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        addView(linearLayout, new LinearLayout.LayoutParams(0, -2, 1.0f));
        View c6 = g4.d.c(zZcINlcxH, 18, -1, "兑换", 17);
        c6.setOnClickListener(new a());
        c6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(40.0f));
        layoutParams.leftMargin = g4.i.r(6.0f);
        int r5 = g4.i.r(6.0f);
        layoutParams.bottomMargin = r5;
        layoutParams.topMargin = r5;
        addView(c6, layoutParams);
        this.f9036m = g4.d.c(zZcINlcxH, 16, -16777216, HttpUrl.FRAGMENT_ENCODE_SET, 16);
        this.f9037n = g4.d.c(zZcINlcxH, 14, Color.parseColor("#ff0000"), HttpUrl.FRAGMENT_ENCODE_SET, 16);
        LinearLayout linearLayout2 = new LinearLayout(zZcINlcxH);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.addView(this.f9036m, new LinearLayout.LayoutParams(0, g4.i.r(36.0f), 1.0f));
        linearLayout2.addView(this.f9037n, new LinearLayout.LayoutParams(-2, g4.i.r(30.0f)));
        View view = new View(zZcINlcxH);
        this.f9039p = view;
        view.setBackgroundColor(Color.parseColor("#aaaaaa"));
        linearLayout.addView(this.f9039p, new LinearLayout.LayoutParams(-1, g4.i.r(0.5f)));
        this.f9040q = g4.d.c(zZcINlcxH, 14, -16777216, HttpUrl.FRAGMENT_ENCODE_SET, 16);
        this.f9041r = g4.d.c(zZcINlcxH, 14, -16777216, "下载", 16);
        linearLayout.addView(this.f9040q, new LinearLayout.LayoutParams(-2, g4.i.r(26.0f)));
        linearLayout.addView(this.f9041r, new LinearLayout.LayoutParams(-2, g4.i.r(26.0f)));
    }

    @Override // com.secret.prettyhezi.View.u
    public void a(n nVar) {
        k kVar = (k) nVar;
        this.f9038o = kVar;
        this.f9036m.setText(kVar.name);
        this.f9037n.setText(this.f9038o.GetPrice());
        float f6 = this.f9038o.signin;
        int i6 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
        this.f9039p.setVisibility(i6 > 0 ? 0 : 8);
        this.f9040q.setVisibility(i6 > 0 ? 0 : 8);
        if (i6 > 0) {
            TextView textView = this.f9040q;
            textView.setText("每次登陆积分+" + g4.i.F(f6));
        }
        if (!this.f9038o.download) {
            this.f9041r.setVisibility(8);
            return;
        }
        this.f9041r.setVisibility(0);
        this.f9041r.setText(this.f9038o.type == 1 ? "下载部分影视视频" : "下载部分解锁后的上传区视频");
    }

    void p() {
        a0.e eVar = MainApplication.f6711r.r().integral;
        double d6 = eVar.all;
        k kVar = this.f9038o;
        if (d6 < kVar.value) {
            ((ZZcINlcxH) getContext()).q("积分不够");
            return;
        }
        int i6 = (eVar.contribution > kVar.contribution ? 1 : (eVar.contribution == kVar.contribution ? 0 : -1));
        ZZcINlcxH zZcINlcxH = (ZZcINlcxH) getContext();
        if (i6 < 0) {
            zZcINlcxH.q("推广贡献值不够");
            return;
        }
        String format = String.format("你将花费" + this.f9038o.GetPrice() + "兑换" + this.f9038o.name, new Object[0]);
        com.secret.prettyhezi.controls.f fVar = new com.secret.prettyhezi.controls.f();
        StringBuilder sb = new StringBuilder();
        sb.append(format);
        sb.append("\n\n");
        fVar.a(sb.toString(), -16777216, 16.0f);
        fVar.a(this.f9038o.type == 1 ? "注：此权限不包含上传区内容" : "注：此权限不包含采集量达到999的图片，短视频，影视，小说等非上传区内容。", -65536, 16.0f);
        zZcINlcxH.B(format, new b(zZcINlcxH), true).f8478e.setText(fVar.f8321d);
    }
}
