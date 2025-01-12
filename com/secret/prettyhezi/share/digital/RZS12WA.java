package com.secret.prettyhezi.share.digital;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Registration.k;
import com.secret.prettyhezi.Registration.l;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.Server.z;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.i;
/* loaded from: classes.dex */
public class RZS12WA extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f8974r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f8975s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f8976t;

    /* renamed from: u  reason: collision with root package name */
    EditText f8977u;

    /* renamed from: v  reason: collision with root package name */
    EditText f8978v;

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f8979w;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            RZS12WA.this.N0(P1o1yR.class, 1);
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
            char c6;
            g gVar = (g) com.secret.prettyhezi.f.d(str, g.class);
            if (gVar.code != 200) {
                d(gVar.err);
                return;
            }
            RZS12WA.this.W0(gVar.data);
            com.secret.prettyhezi.share.digital.a[] aVarArr = gVar.data;
            int length = aVarArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    c6 = 0;
                    break;
                }
                int i7 = aVarArr[i6].status;
                c6 = 1;
                if (i7 == 0 || i7 == 1) {
                    break;
                }
                i6++;
            }
            RZS12WA.this.f8976t.setVisibility(c6 > 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            RZS12WA.this.T0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f8983a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f8984b;

        d(String str, long j6) {
            this.f8983a = str;
            this.f8984b = j6;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            RZS12WA.this.U0(this.f8983a, this.f8984b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements a.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f8986a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f8987b;

        /* loaded from: classes.dex */
        class a extends s.g {
            a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                z zVar = (z) com.secret.prettyhezi.f.d(str, z.class);
                if (zVar.code == 200) {
                    RZS12WA.this.z("已提交申请");
                    RZS12WA.this.V0();
                } else if (zVar.err.equals("TronAddressFormat")) {
                    RZS12WA.this.y("请输入正确的TRC20-USDT地址");
                } else {
                    f(zVar.err);
                }
            }
        }

        e(String str, long j6) {
            this.f8986a = str;
            this.f8987b = j6;
        }

        @Override // com.secret.prettyhezi.Device.a.f
        public void a(String str) {
            RZS12WA.this.I0();
            j.r(v.f7132a + "tron/json", new f(this.f8986a, this.f8987b), true, new a(RZS12WA.this));
        }
    }

    /* loaded from: classes.dex */
    static class f extends l {
        public String xg;
        public long xh;

        public f(String str, long j6) {
            super("g");
            this.xg = str;
            this.xh = j6;
        }
    }

    /* loaded from: classes.dex */
    static class g extends w {
        public com.secret.prettyhezi.share.digital.a[] data;

        g() {
        }
    }

    void S0() {
        LinearLayout linearLayout = new LinearLayout(this);
        this.f8976t = linearLayout;
        linearLayout.setOrientation(1);
        this.f8976t.setGravity(1);
        this.f8975s.addView(this.f8976t, new LinearLayout.LayoutParams(-1, -2));
        EditText editText = new EditText(this);
        this.f8978v = editText;
        g4.d.d(editText, 14.0f, -16777216);
        this.f8978v.setHintTextColor(Color.parseColor("#666666"));
        this.f8978v.setHint("TRC20-USDT地址");
        this.f8978v.setBackground(i.c(-1, 5.0f, -16777216, 1.0f));
        this.f8978v.setPadding(i.r(6.0f), i.r(6.0f), 0, i.r(6.0f));
        com.secret.prettyhezi.controls.j.a(this.f8978v, 40, 7);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(320.0f), i.r(40.0f));
        layoutParams.topMargin = i.r(6.0f);
        this.f8976t.addView(this.f8978v, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(81);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = i.r(10.0f);
        layoutParams2.bottomMargin = i.r(6.0f);
        this.f8976t.addView(linearLayout2, layoutParams2);
        linearLayout2.addView(g4.d.b(this, 14.0f, Color.parseColor("#333333"), "兑换数量:"), new LinearLayout.LayoutParams(-2, -2));
        EditText editText2 = new EditText(this);
        this.f8977u = editText2;
        g4.d.d(editText2, 16.0f, -16777216);
        this.f8977u.setText("1");
        this.f8977u.setBackground(i.c(-1, 5.0f, -16777216, 1.0f));
        this.f8977u.setPadding(i.r(5.0f), 0, i.r(5.0f), 0);
        this.f8977u.setGravity(17);
        this.f8977u.setInputType(2);
        com.secret.prettyhezi.controls.j.a(this.f8977u, 4, 2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i.r(40.0f), i.r(32.0f));
        int r5 = i.r(6.0f);
        layoutParams3.rightMargin = r5;
        layoutParams3.leftMargin = r5;
        linearLayout2.addView(this.f8977u, layoutParams3);
        linearLayout2.addView(g4.d.b(this, 16.0f, -16777216, "00USDT"), new LinearLayout.LayoutParams(-2, -2));
        double d6 = MainApplication.f6711r.r().integral.all;
        int parseColor = Color.parseColor("#666666");
        TextView b6 = g4.d.b(this, 14.0f, parseColor, "当前积分:" + i.F(d6));
        long j6 = ((long) ((d6 / 100.0d) / 7.0d)) / 100;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.bottomMargin = i.r(12.0f);
        this.f8976t.addView(b6, layoutParams4);
        this.f8976t.addView(g4.d.c(this, 14, Color.parseColor("#333333"), "目前支持每次最少兑换100USDT，最多100000USDT", 17), new LinearLayout.LayoutParams(-1, -2));
        TextView c6 = g4.d.c(this, 16, -1, "兑换TRC20-USDT", 17);
        c6.setBackground(i.d(i.b(Color.parseColor("#333333"), 5.0f), i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(i.r(200.0f), i.r(38.0f));
        layoutParams5.topMargin = i.r(10.0f);
        layoutParams5.bottomMargin = i.r(12.0f);
        this.f8976t.addView(c6, layoutParams5);
        c6.setOnClickListener(new c());
    }

    void T0() {
        String trim = this.f8978v.getText().toString().trim();
        if (trim.length() < 10) {
            y("请输入正确的TRC20-USDT地址");
            return;
        }
        String trim2 = this.f8977u.getText().toString().trim();
        if (trim2.isEmpty()) {
            y("请输入正确的USDT数量");
            return;
        }
        long parseLong = Long.parseLong(trim2);
        if (parseLong < 1 || parseLong > 1000) {
            y("请输入1到1000之间的USDT数字");
            return;
        }
        long j6 = parseLong * 100;
        if (6 * j6 * 100 > MainApplication.f6711r.r().integral.all) {
            y("当前积分不够兑换所需USDT");
            return;
        }
        B("确认兑换 " + j6 + " USDT?", new d(trim, parseLong), false);
    }

    void U0(String str, long j6) {
        com.secret.prettyhezi.Device.a.e();
        com.secret.prettyhezi.Device.a.b(this, new e(str, j6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V0() {
        I0();
        j.r(v.f7132a + "tron/json", new k("h"), true, new b(this));
    }

    void W0(com.secret.prettyhezi.share.digital.a[] aVarArr) {
        this.f8979w.removeAllViews();
        if (aVarArr == null || aVarArr.length == 0) {
            return;
        }
        for (com.secret.prettyhezi.share.digital.a aVar : aVarArr) {
            com.secret.prettyhezi.share.digital.b bVar = new com.secret.prettyhezi.share.digital.b(this, aVar);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int r5 = i.r(4.0f);
            layoutParams.bottomMargin = r5;
            layoutParams.topMargin = r5;
            this.f8979w.addView(bVar, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f8974r = C0;
        N(C0, "兑换TRC20-USDT", "兑换说明", new a());
        LinearLayout e6 = e(this.f8974r);
        this.f8975s = e6;
        e6.setGravity(1);
        this.f8975s.setPadding(i.r(12.0f), i.r(10.0f), i.r(12.0f), i.r(20.0f));
        S0();
        this.f8976t.setVisibility(8);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f8979w = linearLayout;
        linearLayout.setOrientation(1);
        this.f8975s.addView(this.f8979w, new LinearLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        V0();
    }
}
