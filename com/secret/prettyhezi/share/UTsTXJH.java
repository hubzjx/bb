package com.secret.prettyhezi.share;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.z;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class UTsTXJH extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f8913r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f8914s;

    /* renamed from: t  reason: collision with root package name */
    TextView f8915t;

    /* renamed from: u  reason: collision with root package name */
    TextView f8916u;

    /* renamed from: v  reason: collision with root package name */
    EditText f8917v;

    /* renamed from: w  reason: collision with root package name */
    TextView f8918w;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: com.secret.prettyhezi.share.UTsTXJH$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0142a extends ZZcINlcxH.q {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f8920a;

            /* renamed from: com.secret.prettyhezi.share.UTsTXJH$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0143a implements a.f {
                C0143a() {
                }

                @Override // com.secret.prettyhezi.Device.a.f
                public void a(String str) {
                    C0142a c0142a = C0142a.this;
                    UTsTXJH.this.S0(c0142a.f8920a);
                }
            }

            C0142a(int i6) {
                this.f8920a = i6;
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                com.secret.prettyhezi.Device.a.b(UTsTXJH.this, new C0143a());
            }
        }

        a() {
        }

        @Override // g4.f
        public void a(View view) {
            UTsTXJH uTsTXJH;
            String str;
            String trim = UTsTXJH.this.f8917v.getText().toString().trim();
            if (trim.isEmpty()) {
                return;
            }
            int parseInt = Integer.parseInt(trim);
            if (parseInt > UTsTXJH.this.T0()) {
                uTsTXJH = UTsTXJH.this;
                str = "最多可以兑换" + UTsTXJH.this.T0() + "积分";
            } else if (parseInt % 100 == 0 && parseInt > 0) {
                UTsTXJH.this.B(String.format("确定花费%d贡献值和%d分享值兑换%d积分？", Integer.valueOf(parseInt), Integer.valueOf(parseInt / 100), Integer.valueOf(parseInt)), new C0142a(parseInt), true);
                return;
            } else {
                uTsTXJH = UTsTXJH.this;
                str = "只能兑换100的整数倍积分";
            }
            uTsTXJH.D(str, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8923b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ZZcINlcxH zZcINlcxH, int i6) {
            super(zZcINlcxH);
            this.f8923b = i6;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            z zVar = (z) com.secret.prettyhezi.f.d(str, z.class);
            if (zVar.code != 200) {
                f(zVar.err);
                return;
            }
            a0.e eVar = MainApplication.f6711r.r().integral;
            double d6 = eVar.all;
            int i6 = this.f8923b;
            eVar.all = d6 + i6;
            eVar.contribution -= i6;
            eVar.invite -= i6 / 100;
            MainApplication.f6711r.x();
            EjNkL.N.f6165r.j();
            UTsTXJH.this.F(" 你已成功兑换了" + this.f8923b + "积分。", null, UTsTXJH.this.s0(C0382R.string.IKnow), null, true);
            UTsTXJH.this.U0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends v.f {
        public int contribution;
        public int invite;

        c(int i6) {
            this.contribution = i6;
            this.invite = i6 / 100;
        }
    }

    void S0(int i6) {
        c cVar = new c(i6);
        com.secret.prettyhezi.j.s(v.f7132a + "user/integral/value/json", com.secret.prettyhezi.f.e(cVar), true, new b(this, i6));
    }

    int T0() {
        a0.e eVar = MainApplication.f6711r.r().integral;
        return Math.min(((int) eVar.contribution) / 100, (int) eVar.invite) * 100;
    }

    void U0() {
        a0.e eVar = MainApplication.f6711r.r().integral;
        TextView textView = this.f8915t;
        textView.setText("贡献值：" + g4.i.F(eVar.contribution));
        TextView textView2 = this.f8916u;
        textView2.setText("\t\t分享值：" + g4.i.F(eVar.invite));
        TextView textView3 = this.f8918w;
        textView3.setText("最多可以兑换" + T0() + "积分");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout B0 = B0(3, 4);
        this.f8913r = B0;
        B0.setGravity(1);
        M(this.f8913r, "兑换积分");
        LinearLayout e6 = e(this.f8913r);
        this.f8914s = e6;
        e6.setPadding(g4.i.r(12.0f), g4.i.r(6.0f), g4.i.r(12.0f), g4.i.r(12.0f));
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g4.i.r(12.0f);
        this.f8914s.addView(linearLayout, layoutParams);
        this.f8915t = g4.d.c(this, 16, -16777216, "贡献值：", 17);
        this.f8916u = g4.d.c(this, 16, -16777216, "分享值：", 17);
        linearLayout.addView(this.f8915t, new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(this.f8916u, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = g4.i.r(6.0f);
        this.f8914s.addView(linearLayout2, layoutParams2);
        linearLayout2.setGravity(16);
        linearLayout2.addView(g4.d.b(this, 15.0f, -16777216, "兑换积分(100的整数倍): "), new LinearLayout.LayoutParams(-2, -2));
        EditText editText = new EditText(this);
        this.f8917v = editText;
        editText.setBackground(g4.i.c(-1, 5.0f, -16777216, 1.0f));
        this.f8917v.setPadding(g4.i.r(5.0f), 0, g4.i.r(5.0f), 0);
        this.f8917v.setGravity(16);
        this.f8917v.setInputType(2);
        this.f8917v.setTextColor(-16777216);
        this.f8917v.setTextSize(15.0f);
        linearLayout2.addView(this.f8917v, new LinearLayout.LayoutParams(g4.i.r(75.0f), g4.i.r(32.0f)));
        TextView c6 = g4.d.c(this, 15, -1, "兑换", 17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(34.0f));
        layoutParams3.leftMargin = g4.i.r(10.0f);
        c6.setBackground(g4.i.e(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        linearLayout2.addView(c6, layoutParams3);
        c6.setOnClickListener(new a());
        this.f8918w = g4.d.b(this, 14.0f, Color.parseColor("#333333"), "最多可以兑换100积分");
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.bottomMargin = g4.i.r(16.0f);
        this.f8914s.addView(this.f8918w, layoutParams4);
        U0();
        this.f8914s.addView(g4.d.b(this, 16.0f, -65536, "100贡献值 + 1分享值 兑换100积分"), new LinearLayout.LayoutParams(-2, g4.i.r(36.0f)));
        this.f8914s.addView(g4.d.b(this, 16.0f, -65536, "举例：用户兑换一月精华权限消耗600积分，你可以获得180积分分成 + 180贡献值 + 1分享值"), new LinearLayout.LayoutParams(-1, g4.i.r(46.0f)));
    }
}
