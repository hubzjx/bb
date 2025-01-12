package com.secret.prettyhezi.share.digital;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.Registration.k;
import com.secret.prettyhezi.Registration.l;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import g4.i;
/* loaded from: classes.dex */
public class WuXLOHsS extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f8993r;

    /* renamed from: s  reason: collision with root package name */
    LinearLayout f8994s;

    /* renamed from: t  reason: collision with root package name */
    TextView f8995t;

    /* renamed from: u  reason: collision with root package name */
    LinearLayout f8996u;

    /* renamed from: v  reason: collision with root package name */
    int f8997v = 0;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        public void a(View view) {
            WuXLOHsS.this.M0(P1o1yR.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.share.digital.d f8999d;

        b(com.secret.prettyhezi.share.digital.d dVar) {
            this.f8999d = dVar;
        }

        @Override // g4.f
        public void a(View view) {
            WuXLOHsS.this.N0(JqUSUBK.class, this.f8999d.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends s.g {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f9002a;

            a(int i6) {
                this.f9002a = i6;
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                WuXLOHsS wuXLOHsS = WuXLOHsS.this;
                int i6 = this.f9002a;
                wuXLOHsS.f8997v = i6;
                wuXLOHsS.N0(JqUSUBK.class, i6);
            }
        }

        c(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            com.secret.prettyhezi.share.digital.d[] dVarArr;
            com.secret.prettyhezi.share.digital.c cVar = (com.secret.prettyhezi.share.digital.c) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.share.digital.c.class);
            if (cVar.code != 200) {
                d(cVar.err);
                return;
            }
            WuXLOHsS.this.W0(cVar.data);
            com.secret.prettyhezi.share.digital.d dVar = null;
            int i6 = 0;
            for (com.secret.prettyhezi.share.digital.d dVar2 : cVar.data) {
                if (dVar2.status == 0) {
                    i6++;
                    dVar = dVar2;
                }
            }
            WuXLOHsS.this.f8995t.setVisibility(i6 > 0 ? 8 : 0);
            if (dVar != null) {
                int i7 = dVar.id;
                WuXLOHsS wuXLOHsS = WuXLOHsS.this;
                if (i7 != wuXLOHsS.f8997v) {
                    wuXLOHsS.D("有未支付的订单，请尽快支付", new a(i7), false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {
        d() {
        }

        @Override // g4.f
        public void a(View view) {
            WuXLOHsS.this.T0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f9005a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f9006b;

        e(x xVar, EditText editText) {
            this.f9005a = xVar;
            this.f9006b = editText;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            WuXLOHsS wuXLOHsS;
            String str;
            if (i6 == 0) {
                WuXLOHsS.this.j(this.f9005a);
                return;
            }
            String trim = this.f9006b.getText().toString().trim();
            if (trim.length() == 0) {
                wuXLOHsS = WuXLOHsS.this;
                str = "请输入积分数目";
            } else {
                long parseLong = Long.parseLong(trim);
                if (parseLong >= 1 && parseLong <= 1000) {
                    WuXLOHsS.this.j(this.f9005a);
                    WuXLOHsS.this.U0(parseLong * 10000);
                    return;
                }
                wuXLOHsS = WuXLOHsS.this;
                str = "请输入1到1000之间的数字";
            }
            wuXLOHsS.y(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements a.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f9008a;

        /* loaded from: classes.dex */
        class a extends s.g {
            a(ZZcINlcxH zZcINlcxH) {
                super(zZcINlcxH);
            }

            @Override // com.secret.prettyhezi.s.g
            public void g(String str) {
                h hVar = (h) com.secret.prettyhezi.f.d(str, h.class);
                if (hVar.code != 200) {
                    f(hVar.err);
                    return;
                }
                WuXLOHsS wuXLOHsS = WuXLOHsS.this;
                int i6 = hVar.data.id;
                wuXLOHsS.f8997v = i6;
                wuXLOHsS.N0(JqUSUBK.class, i6);
            }
        }

        f(long j6) {
            this.f9008a = j6;
        }

        @Override // com.secret.prettyhezi.Device.a.f
        public void a(String str) {
            WuXLOHsS.this.I0();
            j.r(v.f7132a + "tron/json", new g(this.f9008a), true, new a(WuXLOHsS.this));
        }
    }

    /* loaded from: classes.dex */
    static class g extends l {
        public long xd;

        public g(long j6) {
            super("c");
            this.xd = j6;
        }
    }

    /* loaded from: classes.dex */
    static class h extends w {
        public com.secret.prettyhezi.share.digital.d data;

        h() {
        }
    }

    void S0() {
        TextView c6 = g4.d.c(this, 16, -1, "TRC20-USDT兑换积分", 17);
        this.f8995t = c6;
        c6.setBackground(i.d(i.b(Color.parseColor("#333333"), 5.0f), i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(200.0f), i.r(38.0f));
        layoutParams.topMargin = i.r(6.0f);
        layoutParams.bottomMargin = i.r(12.0f);
        this.f8994s.addView(this.f8995t, layoutParams);
        this.f8995t.setOnClickListener(new d());
    }

    void T0() {
        x xVar = new x(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.addView(g4.d.b(this, 18.0f, -16777216, "兑换积分数量"), new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-2, -2));
        EditText editText = new EditText(this);
        editText.setText("5");
        editText.setTextColor(-16777216);
        editText.setTextSize(18.0f);
        editText.setBackground(i.c(-1, 5.0f, -16777216, 1.0f));
        editText.setPadding(i.r(5.0f), 0, i.r(5.0f), 0);
        editText.setGravity(16);
        editText.setInputType(2);
        com.secret.prettyhezi.controls.j.a(editText, 4, 2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.r(80.0f), i.r(36.0f));
        int r5 = i.r(6.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        int r6 = i.r(10.0f);
        layoutParams.bottomMargin = r6;
        layoutParams.topMargin = r6;
        linearLayout2.addView(editText, layoutParams);
        linearLayout2.addView(g4.d.b(this, 18.0f, -16777216, "0000积分"), new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(g4.d.c(this, 14, Color.parseColor("#333333"), "目前支持每次最少兑换1万，最多1000万", 3), new LinearLayout.LayoutParams(-2, -2));
        xVar.e(linearLayout);
        xVar.d(new String[]{s0(C0382R.string.cancel), s0(C0382R.string.ok)}, new e(xVar, editText));
        x(xVar, null, true);
    }

    void U0(long j6) {
        com.secret.prettyhezi.Device.a.b(this, new f(j6));
    }

    void V0() {
        j.r(v.f7132a + "tron/json", new k("b"), true, new c(this));
    }

    void W0(com.secret.prettyhezi.share.digital.d[] dVarArr) {
        this.f8996u.removeAllViews();
        if (dVarArr == null || dVarArr.length == 0) {
            return;
        }
        for (com.secret.prettyhezi.share.digital.d dVar : dVarArr) {
            com.secret.prettyhezi.share.digital.e eVar = new com.secret.prettyhezi.share.digital.e(this);
            eVar.b(dVar);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int r5 = i.r(4.0f);
            layoutParams.bottomMargin = r5;
            layoutParams.topMargin = r5;
            this.f8996u.addView(eVar, layoutParams);
            if (dVar.status != -2) {
                eVar.setOnClickListener(new b(dVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f8993r = C0;
        N(C0, "TRC20-USDT兑换积分", "兑换说明", new a());
        LinearLayout e6 = e(this.f8993r);
        this.f8994s = e6;
        e6.setGravity(1);
        this.f8994s.setPadding(i.r(12.0f), i.r(10.0f), i.r(12.0f), i.r(20.0f));
        S0();
        LinearLayout linearLayout = new LinearLayout(this);
        this.f8996u = linearLayout;
        linearLayout.setOrientation(1);
        this.f8994s.addView(this.f8996u, new LinearLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        I0();
        V0();
    }
}
