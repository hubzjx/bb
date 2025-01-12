package com.secret.prettyhezi.Upload;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.Upload.p;
import com.secret.prettyhezi.WVGAB1kU;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.s;
import java.util.ArrayList;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class JzFuV extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    int f7319r;

    /* renamed from: s  reason: collision with root package name */
    int f7320s;

    /* renamed from: t  reason: collision with root package name */
    long f7321t;

    /* renamed from: u  reason: collision with root package name */
    LinearLayout f7322u;

    /* renamed from: v  reason: collision with root package name */
    LinearLayout f7323v;

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f7324w;

    /* renamed from: x  reason: collision with root package name */
    com.secret.prettyhezi.controls.c[] f7325x;

    /* loaded from: classes.dex */
    class a extends g4.f {

        /* renamed from: com.secret.prettyhezi.Upload.JzFuV$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0111a extends ZZcINlcxH.q {
            C0111a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                int i6 = (MainApplication.f6711r.r().integral.all > 20.0d ? 1 : (MainApplication.f6711r.r().integral.all == 20.0d ? 0 : -1));
                JzFuV jzFuV = JzFuV.this;
                if (i6 < 0) {
                    jzFuV.D("积分不够", null, true);
                } else {
                    jzFuV.S0();
                }
            }
        }

        a() {
        }

        @Override // g4.f
        public void a(View view) {
            int T0 = JzFuV.this.T0();
            if (T0 == 0) {
                JzFuV.this.D("请选择举报原因", null, false);
            } else if (T0 == 15) {
                JzFuV.this.D("最多只能选三项", null, false);
            } else {
                JzFuV jzFuV = JzFuV.this;
                jzFuV.C("举报将会扣除20积分作为保证金，举报被通过，返还保证金并奖励10积分，举报不通过，不会返还保证金", new String[]{jzFuV.s0(C0382R.string.cancel), JzFuV.this.s0(C0382R.string.report)}, new C0111a(), true);
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        public void a(View view) {
            JzFuV.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends s.g {
        c(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            p.b bVar = (p.b) com.secret.prettyhezi.f.d(str, p.b.class);
            if (bVar.code != 200) {
                f(bVar.err);
                return;
            }
            p.c(JzFuV.this.f7319r, bVar.data);
            JzFuV.this.U0(bVar.data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements s.f {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainApplication.f6711r.r().integral.all -= 20.0d;
                MainApplication.f6711r.x();
                EjNkL.N.f6165r.j();
                ZZcINlcxH x02 = JzFuV.this.x0();
                if (x02 != null && (x02 instanceof WVGAB1kU)) {
                    ((WVGAB1kU) x02).i1();
                }
                JzFuV.this.finish();
            }
        }

        d() {
        }

        @Override // com.secret.prettyhezi.s.f
        public void a(String str) {
            JzFuV.this.f7322u.postDelayed(new a(), 500L);
        }
    }

    void S0() {
        I0();
        n nVar = new n();
        nVar.id = this.f7320s;
        nVar.f7504t = this.f7319r;
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (true) {
            com.secret.prettyhezi.controls.c[] cVarArr = this.f7325x;
            if (i6 >= cVarArr.length) {
                String[] strArr = new String[arrayList.size()];
                nVar.ts = strArr;
                nVar.ts = (String[]) arrayList.toArray(strArr);
                com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "report/post/json", nVar, true, new s.e(this, new d()));
                return;
            }
            com.secret.prettyhezi.controls.c cVar = cVarArr[i6];
            if (cVar != null && cVar.isSelected()) {
                arrayList.add(((p.a) this.f7325x[i6].getTag()).id + HttpUrl.FRAGMENT_ENCODE_SET);
            }
            i6++;
        }
    }

    int T0() {
        int i6 = 0;
        if (this.f7325x == null) {
            return 0;
        }
        int i7 = 0;
        while (true) {
            com.secret.prettyhezi.controls.c[] cVarArr = this.f7325x;
            if (i6 >= cVarArr.length) {
                return i7;
            }
            com.secret.prettyhezi.controls.c cVar = cVarArr[i6];
            if (cVar != null && cVar.isSelected()) {
                i7 += 1 << i6;
            }
            i6++;
        }
    }

    void U0(p.a[] aVarArr) {
        this.f7324w.removeAllViews();
        this.f7325x = new com.secret.prettyhezi.controls.c[aVarArr.length];
        for (int i6 = 0; i6 < aVarArr.length; i6++) {
            p.a aVar = aVarArr[i6];
            if (aVar.enable_at <= this.f7321t) {
                this.f7325x[i6] = new com.secret.prettyhezi.controls.c(this, aVarArr[i6].name);
                this.f7324w.addView(this.f7325x[i6], new LinearLayout.LayoutParams(-1, -2));
                this.f7325x[i6].setTag(aVar);
            }
        }
    }

    void V0() {
        I0();
        com.secret.prettyhezi.j.o(com.secret.prettyhezi.Server.v.f7132a + "report/json?t=" + this.f7319r, true, new c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7319r = extras.getInt("type");
            this.f7320s = extras.getInt("id");
            this.f7321t = extras.getLong("extra");
        }
        LinearLayout C0 = C0();
        this.f7322u = C0;
        M(C0, "举报有奖");
        LinearLayout e6 = e(this.f7322u);
        this.f7323v = e6;
        e6.setPadding(g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(6.0f));
        int i6 = this.f7319r;
        String str = (i6 == 2 || i6 == 5) ? "视频" : "图片";
        this.f7323v.addView(g4.d.c(this, 16, -16777216, str + "内容，标题或简介包含以下信息：", 3), new LinearLayout.LayoutParams(-2, g4.i.r(30.0f)));
        LinearLayout linearLayout = new LinearLayout(this);
        this.f7324w = linearLayout;
        linearLayout.setOrientation(1);
        this.f7323v.addView(this.f7324w, new LinearLayout.LayoutParams(-1, -2));
        p.a[] b6 = p.b(this.f7319r);
        if (b6 == null) {
            V0();
        } else {
            U0(b6);
        }
        TextView b7 = g4.d.b(this, 14.0f, -65536, "举报将会扣除20积分作为保证金，举报被通过，返还保证金并奖励10积分，举报不通过，不会返还保证金");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = g4.i.r(12.0f);
        this.f7323v.addView(b7, layoutParams);
        U(this.f7323v, s0(C0382R.string.report), 20, 30).setOnClickListener(new a());
        U(this.f7323v, s0(C0382R.string.cancel), 20, 30).setOnClickListener(new b());
    }
}
