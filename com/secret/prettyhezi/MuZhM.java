package com.secret.prettyhezi;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.e0;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class MuZhM extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f6761r;

    /* renamed from: s  reason: collision with root package name */
    com.secret.prettyhezi.controls.d f6762s;

    /* renamed from: t  reason: collision with root package name */
    TextView f6763t;

    /* renamed from: u  reason: collision with root package name */
    long f6764u = 0;

    /* loaded from: classes.dex */
    class a extends e0 {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            MuZhM.this.f6763t.setEnabled(MuZhM.this.f6762s.f8305c.getText().toString().trim().length() >= 2);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {

        /* loaded from: classes.dex */
        class a implements a.f {
            a() {
            }

            @Override // com.secret.prettyhezi.Device.a.f
            public void a(String str) {
                MuZhM.this.T0(false);
            }
        }

        b() {
        }

        @Override // g4.f
        public void a(View view) {
            com.secret.prettyhezi.Device.a.b(MuZhM.this, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f6768b;

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                MuZhM.this.T0(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ZZcINlcxH zZcINlcxH, boolean z5) {
            super(zZcINlcxH);
            this.f6768b = z5;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            com.secret.prettyhezi.Server.b bVar = (com.secret.prettyhezi.Server.b) f.d(str, com.secret.prettyhezi.Server.b.class);
            if (bVar.code == 200) {
                MainApplication.f6711r.r().count.box++;
                if (this.f6768b) {
                    MainApplication.f6711r.r().integral.all -= MuZhM.this.f6764u;
                }
                EjNkL.N.f6165r.j();
                EjNkL.N.f6165r.i();
                MainApplication.f6711r.x();
                View R0 = EjNkL.N.R0();
                if (R0 instanceof com.secret.prettyhezi.View.f) {
                    ((com.secret.prettyhezi.View.f) R0).y(bVar.data);
                }
                MuZhM.this.finish();
            } else if (!bVar.err.equals("BoxIsMax")) {
                f(bVar.err);
            } else {
                MuZhM.this.C("已超过免费创建限额，需要" + MuZhM.this.f6764u + "积分创建", new String[]{MuZhM.this.s0(C0382R.string.cancel), MuZhM.this.f6764u + "积分创建"}, new a(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d extends v.f {
        public boolean buy;
        public String name;

        public d(String str, boolean z5) {
            this.name = str;
            this.buy = z5;
        }
    }

    void S0() {
        String[] split = MainApplication.f6711r.k().sys.max_box.split("\\|");
        if (split.length == 2) {
            int parseInt = Integer.parseInt(split[0]);
            this.f6764u = Long.parseLong(split[1]);
            TextView c6 = g4.d.c(this, 12, -65536, "可以免费创建" + parseInt + "个盒子，超额后需要花费" + this.f6764u + "积分创建盒子", 17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = g4.i.r(20.0f);
            layoutParams.bottomMargin = g4.i.r(20.0f);
            this.f6761r.addView(c6, layoutParams);
        }
    }

    void T0(boolean z5) {
        I0();
        String trim = this.f6762s.f8305c.getText().toString().trim();
        j.r(com.secret.prettyhezi.Server.v.f7132a + com.secret.prettyhezi.Server.v.a(), new d(trim, z5), true, new c(this, z5));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        C0.setBackgroundColor(-1);
        M(C0, s0(C0382R.string.add_box));
        this.f6761r = e(C0);
        int parseColor = Color.parseColor("#666666");
        TextView b6 = g4.d.b(this, 14.0f, parseColor, "\t\t\t\t" + s0(C0382R.string.add_box_hint));
        b6.setPadding(g4.i.r(20.0f), g4.i.r(12.0f), g4.i.r(20.0f), 0);
        b6.setLineSpacing((float) g4.i.r(4.0f), 1.0f);
        this.f6761r.addView(b6, new LinearLayout.LayoutParams(-1, -2));
        com.secret.prettyhezi.controls.d dVar = new com.secret.prettyhezi.controls.d(this, 0);
        this.f6762s = dVar;
        dVar.f8305c.setHint(s0(C0382R.string.BoxName));
        com.secret.prettyhezi.controls.j.a(this.f6762s.f8305c, 10, 7);
        this.f6762s.f8305c.addTextChangedListener(new a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g4.i.r(48.0f));
        layoutParams.topMargin = g4.i.r(30.0f);
        int r5 = g4.i.r(20.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        this.f6761r.addView(this.f6762s, layoutParams);
        TextView U = U(this.f6761r, s0(C0382R.string.Create), 20, 20);
        this.f6763t = U;
        U.setEnabled(false);
        this.f6763t.setOnClickListener(new b());
        S0();
    }
}
