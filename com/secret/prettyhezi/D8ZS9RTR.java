package com.secret.prettyhezi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.u;
import com.secret.prettyhezi.User.TK1dGVzP;
import com.secret.prettyhezi.View.o;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.z;
import com.secret.prettyhezi.s;
/* loaded from: classes.dex */
public class D8ZS9RTR extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    int f6065r;

    /* renamed from: s  reason: collision with root package name */
    int f6066s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f6067t;

    /* renamed from: u  reason: collision with root package name */
    RelativeLayout f6068u;

    /* renamed from: v  reason: collision with root package name */
    LinearLayout f6069v;

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f6070w;

    /* renamed from: x  reason: collision with root package name */
    u.a f6071x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements o.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f6072a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f6073b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f6074c;

        a(ZZcINlcxH zZcINlcxH, int i6, int i7) {
            this.f6072a = zZcINlcxH;
            this.f6073b = i6;
            this.f6074c = i7;
        }

        @Override // com.secret.prettyhezi.View.o.c
        public void a() {
            Intent intent = new Intent(this.f6072a, D8ZS9RTR.class);
            Bundle bundle = new Bundle();
            bundle.putInt("id", this.f6073b);
            bundle.putInt("type", this.f6074c);
            intent.putExtras(bundle);
            this.f6072a.startActivity(intent);
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            D8ZS9RTR.this.M0(MuZhM.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends s.g {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ com.secret.prettyhezi.Server.u f6077a;

            a(com.secret.prettyhezi.Server.u uVar) {
                this.f6077a = uVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                D8ZS9RTR.this.j0();
                com.secret.prettyhezi.Server.u uVar = this.f6077a;
                if (uVar.code == 200) {
                    D8ZS9RTR.this.U0(uVar.data);
                } else {
                    c.this.f(uVar.err);
                }
            }
        }

        c(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            D8ZS9RTR.this.f6070w.post(new a((com.secret.prettyhezi.Server.u) com.secret.prettyhezi.f.d(str, com.secret.prettyhezi.Server.u.class)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends ZZcINlcxH.q {
        d() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void a() {
            D8ZS9RTR.this.finish();
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            D8ZS9RTR.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f6080d;

        e(int i6) {
            this.f6080d = i6;
        }

        @Override // g4.f
        public void a(View view) {
            D8ZS9RTR.this.T0(this.f6080d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements a.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6082a;

        /* loaded from: classes.dex */
        class a implements s.f {
            a() {
            }

            @Override // com.secret.prettyhezi.s.f
            public void a(String str) {
                D8ZS9RTR.this.finish();
            }
        }

        f(int i6) {
            this.f6082a = i6;
        }

        @Override // com.secret.prettyhezi.Device.a.f
        public void a(String str) {
            D8ZS9RTR.this.I0();
            D8ZS9RTR d8zs9rtr = D8ZS9RTR.this;
            com.secret.prettyhezi.Server.v.p(d8zs9rtr.f6065r, d8zs9rtr.f6066s, this.f6082a, new s.e(d8zs9rtr, new a()));
        }
    }

    public static void S0(ZZcINlcxH zZcINlcxH, int i6, int i7) {
        a0 r5 = MainApplication.f6711r.r();
        if (r5 == null) {
            zZcINlcxH.M0(TK1dGVzP.class);
        } else if (r5.integral.all < 0.0d) {
            zZcINlcxH.D(zZcINlcxH.s0(C0382R.string.CollectScoreNegativeHint), null, true);
        } else {
            com.secret.prettyhezi.View.o.a(2, new a(zZcINlcxH, i6, i7));
        }
    }

    void T0(int i6) {
        com.secret.prettyhezi.Device.a.b(this, new f(i6));
    }

    void U0(u.a aVar) {
        this.f6071x = aVar;
        this.f6069v.removeAllViews();
        this.f6070w.removeAllViews();
        int parseColor = Color.parseColor("#f4a536");
        int r5 = g4.i.r(15.0f);
        int[] iArr = this.f6071x.inbox;
        if (iArr == null || iArr.length < 2) {
            V(this.f6069v, Color.parseColor("#cccccc"), 0.5f, 0, 0);
        } else {
            D(s0(C0382R.string.already_collected), new d(), false);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setGravity(16);
            linearLayout.setPadding(r5, 0, 0, g4.i.r(6.0f));
            linearLayout.setBackgroundColor(parseColor);
            this.f6069v.addView(linearLayout, new LinearLayout.LayoutParams(-1, g4.i.r(48.0f)));
            String str = "已采集到盒子：";
            for (int i6 = 0; i6 < this.f6071x.inbox.length; i6++) {
                int i7 = 0;
                while (true) {
                    u.a aVar2 = this.f6071x;
                    u.b[] bVarArr = aVar2.items;
                    if (i7 >= bVarArr.length) {
                        break;
                    } else if (bVarArr[i7].id == aVar2.inbox[i6]) {
                        str = str + this.f6071x.items[i7].name + " ";
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            TextView b6 = g4.d.b(this, 14.0f, parseColor, "!");
            b6.setGravity(17);
            b6.setPadding(0, 0, 0, 0);
            b6.setBackground(g4.i.b(-1, g4.i.r(10.0f)));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(20.0f), g4.i.r(20.0f));
            layoutParams.rightMargin = g4.i.r(12.0f);
            linearLayout.addView(b6, layoutParams);
            TextView b7 = g4.d.b(this, 14.0f, -1, str);
            b7.setPadding(0, 0, 0, 0);
            b7.setSingleLine();
            linearLayout.addView(b7, new LinearLayout.LayoutParams(0, -2, 1.0f));
        }
        u.b[] bVarArr2 = this.f6071x.items;
        if (bVarArr2 == null || bVarArr2.length <= 0) {
            TextView b8 = g4.d.b(this, 16.0f, -16777216, "请先创建盒子");
            b8.setGravity(17);
            this.f6070w.addView(b8, new LinearLayout.LayoutParams(-1, g4.i.r(400.0f)));
            return;
        }
        int i8 = 0;
        while (true) {
            u.b[] bVarArr3 = this.f6071x.items;
            if (i8 >= bVarArr3.length) {
                return;
            }
            TextView b9 = g4.d.b(this, 16.0f, -16777216, bVarArr3[i8].name);
            b9.setPadding(r5, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, g4.i.r(48.0f));
            b9.setGravity(19);
            this.f6070w.addView(b9, layoutParams2);
            b9.setBackground(g4.i.i(0, Color.parseColor("#aaaaaa"), Color.parseColor("#e49730")));
            u.a aVar3 = this.f6071x;
            int i9 = aVar3.items[i8].id;
            int[] iArr2 = aVar3.inbox;
            if (iArr2 != null && iArr2.length > 0) {
                int i10 = 0;
                while (true) {
                    int[] iArr3 = this.f6071x.inbox;
                    if (i10 >= iArr3.length) {
                        break;
                    } else if (i9 == iArr3[i10]) {
                        b9.setSelected(true);
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            if (!b9.isSelected()) {
                b9.setOnClickListener(new e(i9));
            }
            i8++;
        }
    }

    void V0() {
        I0();
        com.secret.prettyhezi.Server.v.x(this.f6065r, this.f6066s, new c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6065r = extras.getInt("id");
            this.f6066s = extras.getInt("type");
        }
        LinearLayout C0 = C0();
        this.f6067t = C0;
        C0.setBackgroundColor(-1);
        this.f6068u = M(this.f6067t, s0(C0382R.string.select_box));
        com.secret.prettyhezi.controls.u a6 = com.secret.prettyhezi.controls.u.a(new z(this, C0382R.drawable.ic_addbox), 24, 24);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(42.0f), g4.i.r(42.0f));
        layoutParams.addRule(15, -1);
        layoutParams.addRule(11, -1);
        layoutParams.rightMargin = g4.i.r(6.0f);
        a6.setBackground(g4.i.d(null, g4.i.b(Color.parseColor("#aaaaaa"), 21.0f)));
        this.f6068u.addView(a6, layoutParams);
        a6.setOnClickListener(new b());
        LinearLayout linearLayout = new LinearLayout(this);
        this.f6069v = linearLayout;
        this.f6067t.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        ScrollView scrollView = new ScrollView(this);
        this.f6067t.addView(scrollView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout linearLayout2 = new LinearLayout(this);
        this.f6070w = linearLayout2;
        linearLayout2.setOrientation(1);
        this.f6070w.setPadding(0, 0, 0, g4.i.r(30.0f));
        scrollView.addView(this.f6070w, new ViewGroup.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        V0();
    }
}
