package com.secret.prettyhezi.User;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Device.a;
import com.secret.prettyhezi.EjNkL;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.v;
import com.secret.prettyhezi.Server.w;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import com.secret.prettyhezi.share.DyOuR;
import java.io.IOException;
/* loaded from: classes.dex */
public class QlIdC extends UoWMF {

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f7567r;

    /* renamed from: s  reason: collision with root package name */
    RelativeLayout f7568s;

    /* renamed from: t  reason: collision with root package name */
    LinearLayout f7569t;

    /* renamed from: v  reason: collision with root package name */
    LinearLayout f7571v;

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f7572w;

    /* renamed from: x  reason: collision with root package name */
    LinearLayout f7573x;

    /* renamed from: u  reason: collision with root package name */
    TextView f7570u = null;

    /* renamed from: y  reason: collision with root package name */
    com.secret.prettyhezi.User.a f7574y = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s.g {
        a(ZZcINlcxH zZcINlcxH) {
            super(zZcINlcxH);
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            k kVar = (k) com.secret.prettyhezi.f.d(str, k.class);
            if (kVar.code == 200) {
                QlIdC.this.Z0(kVar.data);
            } else {
                f(kVar.err);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QlIdC.this.f7571v.removeAllViews();
            QlIdC.this.f7571v.addView(g4.d.c(QlIdC.this, 16, -16777216, "当前无加速", 17), new LinearLayout.LayoutParams(-1, g4.i.r(48.0f)));
            if (MainApplication.f6711r.B()) {
                MainApplication.f6711r.J(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends ZZcINlcxH.q {
        c() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            MainApplication.f6711r.J(false);
            QlIdC.this.f7570u.setText("停用加速");
            QlIdC.this.f7570u.setBackground(g4.i.d(g4.i.b(Color.parseColor("#666666"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g4.f {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                MainApplication.f6711r.J(true);
                QlIdC.this.f7570u.setText("启用加速");
                QlIdC.this.H("在权限有效期内可以随时开启加速");
                QlIdC.this.f7570u.setBackground(g4.i.d(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
            }
        }

        d() {
        }

        @Override // g4.f
        public void a(View view) {
            if (!MainApplication.f6711r.B()) {
                QlIdC.this.B("很抱歉加速服务器未能起到应有的效果，但是停用加速服务器系统不退款也不延长此权限的有效期，确定要使用默认服务器播放吗？", new a(), true);
                return;
            }
            MainApplication.f6711r.J(false);
            QlIdC.this.H("加速已开启");
            QlIdC.this.f7570u.setText("停用加速");
            QlIdC.this.f7570u.setBackground(g4.i.d(g4.i.b(Color.parseColor("#666666"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends s.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f7580b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(ZZcINlcxH zZcINlcxH, long j6) {
            super(zZcINlcxH);
            this.f7580b = j6;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            i iVar = (i) com.secret.prettyhezi.f.d(str, i.class);
            if (iVar.code != 200) {
                f(iVar.err);
                return;
            }
            MainApplication mainApplication = MainApplication.f6711r;
            mainApplication.f6728n = iVar.data;
            if (mainApplication.B()) {
                MainApplication.f6711r.J(false);
                TextView textView = QlIdC.this.f7570u;
                if (textView != null) {
                    textView.setBackground(g4.i.d(g4.i.b(Color.parseColor("#666666"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
                    QlIdC.this.f7570u.setText("停用加速");
                }
            }
            QlIdC.this.a1(iVar.data);
            MainApplication.f6711r.r().integral.all -= this.f7580b;
            MainApplication.f6711r.x();
            EjNkL.N.f6165r.j();
            EjNkL.N.f6165r.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements a.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.User.a f7582a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j.e f7583b;

        f(com.secret.prettyhezi.User.a aVar, j.e eVar) {
            this.f7582a = aVar;
            this.f7583b = eVar;
        }

        @Override // com.secret.prettyhezi.Device.a.f
        public void a(String str) {
            QlIdC.this.I0();
            com.secret.prettyhezi.j.r(v.f7132a + "host/new/json", new v.g(this.f7582a.id), true, this.f7583b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f7585a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.User.a f7586b;

        g(long j6, com.secret.prettyhezi.User.a aVar) {
            this.f7585a = j6;
            this.f7586b = aVar;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            long j6 = this.f7585a;
            if (j6 <= 0) {
                QlIdC.this.W0(this.f7586b, j6);
                return;
            }
            double d6 = MainApplication.f6711r.r().integral.all;
            long j7 = this.f7585a;
            int i6 = (d6 > j7 ? 1 : (d6 == j7 ? 0 : -1));
            QlIdC qlIdC = QlIdC.this;
            if (i6 < 0) {
                qlIdC.q("积分不够");
            } else {
                qlIdC.W0(this.f7586b, j7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends j.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f7588a;

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ QlIdC f7589a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ i f7590b;

            a(QlIdC qlIdC, i iVar) {
                this.f7589a = qlIdC;
                this.f7590b = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7589a.a1(this.f7590b.data);
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ DyOuR f7592a;

            b(DyOuR dyOuR) {
                this.f7592a = dyOuR;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7592a.U0();
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ DyOuR f7594a;

            c(DyOuR dyOuR) {
                this.f7594a = dyOuR;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7594a.U0();
            }
        }

        /* loaded from: classes.dex */
        class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ QlIdC f7596a;

            d(QlIdC qlIdC) {
                this.f7596a = qlIdC;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7596a.T0();
            }
        }

        h(ZZcINlcxH zZcINlcxH) {
            this.f7588a = zZcINlcxH;
        }

        @Override // com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
        }

        @Override // com.secret.prettyhezi.j.e
        public void b(int i6) {
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            i iVar = (i) com.secret.prettyhezi.f.d(str, i.class);
            if (iVar.code == 200) {
                MainApplication.f6711r.f6728n = iVar.data;
                ZZcINlcxH zZcINlcxH = this.f7588a;
                if (zZcINlcxH != null && !zZcINlcxH.isDestroyed() && !this.f7588a.isFinishing()) {
                    ZZcINlcxH zZcINlcxH2 = this.f7588a;
                    if (zZcINlcxH2 instanceof QlIdC) {
                        QlIdC qlIdC = (QlIdC) zZcINlcxH2;
                        qlIdC.runOnUiThread(new a(qlIdC, iVar));
                    } else if (zZcINlcxH2 instanceof DyOuR) {
                        DyOuR dyOuR = (DyOuR) zZcINlcxH2;
                        dyOuR.runOnUiThread(new b(dyOuR));
                    }
                }
            } else {
                MainApplication.f6711r.f6728n = null;
                ZZcINlcxH zZcINlcxH3 = this.f7588a;
                if (zZcINlcxH3 != null && !zZcINlcxH3.isDestroyed() && !this.f7588a.isFinishing()) {
                    ZZcINlcxH zZcINlcxH4 = this.f7588a;
                    if (zZcINlcxH4 instanceof QlIdC) {
                        ((QlIdC) zZcINlcxH4).U0();
                    } else if (zZcINlcxH4 instanceof DyOuR) {
                        DyOuR dyOuR2 = (DyOuR) zZcINlcxH4;
                        dyOuR2.runOnUiThread(new c(dyOuR2));
                    }
                }
            }
            ZZcINlcxH zZcINlcxH5 = this.f7588a;
            if (zZcINlcxH5 == null || zZcINlcxH5.isDestroyed() || this.f7588a.isFinishing()) {
                return;
            }
            ZZcINlcxH zZcINlcxH6 = this.f7588a;
            if (zZcINlcxH6 instanceof QlIdC) {
                QlIdC qlIdC2 = (QlIdC) zZcINlcxH6;
                qlIdC2.runOnUiThread(new d(qlIdC2));
            }
        }
    }

    /* loaded from: classes.dex */
    class i extends w {
        public com.secret.prettyhezi.User.a data;

        i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        com.secret.prettyhezi.User.a f7598b;

        /* renamed from: c  reason: collision with root package name */
        TextView f7599c;

        /* renamed from: d  reason: collision with root package name */
        TextView f7600d;

        /* loaded from: classes.dex */
        class a extends g4.f {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ QlIdC f7602d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ com.secret.prettyhezi.User.a f7603e;

            a(QlIdC qlIdC, com.secret.prettyhezi.User.a aVar) {
                this.f7602d = qlIdC;
                this.f7603e = aVar;
            }

            @Override // g4.f
            public void a(View view) {
                QlIdC.this.Y0(this.f7603e);
            }
        }

        public j(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.User.a aVar) {
            super(zZcINlcxH);
            this.f7598b = aVar;
            setOrientation(0);
            setGravity(16);
            TextView b6 = g4.d.b(zZcINlcxH, 16.0f, -16777216, aVar.name);
            b6.setPadding(g4.i.r(12.0f), 0, 0, 0);
            addView(b6, new LinearLayout.LayoutParams(0, -2, 1.0f));
            View b7 = g4.d.b(zZcINlcxH, 16.0f, -16777216, aVar.price + "积分/天");
            addView(b7, new LinearLayout.LayoutParams(g4.i.r(100.0f), -2));
            TextView b8 = g4.d.b(zZcINlcxH, 14.0f, -16777216, "延迟：检测中");
            this.f7599c = b8;
            addView(b8, new LinearLayout.LayoutParams(g4.i.r(120.0f), -2));
            new l(this, aVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            if (aVar.expired_at != 0) {
                b7.setVisibility(8);
                TextView b9 = g4.d.b(zZcINlcxH, 14.0f, -16777216, QlIdC.this.f7574y.GetExpire() + "到期");
                b9.setPadding(0, 0, g4.i.r(12.0f), 0);
                addView(b9, new LinearLayout.LayoutParams(-2, -2));
                return;
            }
            this.f7600d = g4.d.c(zZcINlcxH, 16, -1, QlIdC.this.f7574y == null ? "购买" : "切换", 17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(60.0f), g4.i.r(38.0f));
            layoutParams.rightMargin = g4.i.r(12.0f);
            this.f7600d.setBackground(g4.i.e(g4.i.b(Color.parseColor("#333333"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
            addView(this.f7600d, layoutParams);
            this.f7600d.setOnClickListener(new a(QlIdC.this, aVar));
            if (QlIdC.this.f7574y != null) {
                a();
            }
        }

        public void a() {
            TextView textView;
            int i6;
            this.f7600d.setText("切换");
            com.secret.prettyhezi.User.a aVar = QlIdC.this.f7574y;
            int i7 = aVar.id;
            com.secret.prettyhezi.User.a aVar2 = this.f7598b;
            if (i7 == aVar2.id && aVar.url.equals(aVar2.url)) {
                textView = this.f7600d;
                i6 = 4;
            } else {
                textView = this.f7600d;
                i6 = 0;
            }
            textView.setVisibility(i6);
        }

        public void b() {
            String str;
            int i6 = (this.f7598b.delay > 0L ? 1 : (this.f7598b.delay == 0L ? 0 : -1));
            TextView textView = this.f7599c;
            if (i6 < 0) {
                str = "延迟：不可用";
            } else {
                str = "延迟：" + this.f7598b.delay + "毫秒";
            }
            textView.setText(str);
        }
    }

    /* loaded from: classes.dex */
    class k extends w {
        public com.secret.prettyhezi.User.a[] data;

        k() {
        }
    }

    /* loaded from: classes.dex */
    private class l extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        com.secret.prettyhezi.User.a f7605a;

        /* renamed from: b  reason: collision with root package name */
        j f7606b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.f7606b.b();
            }
        }

        l(j jVar, com.secret.prettyhezi.User.a aVar) {
            this.f7606b = jVar;
            this.f7605a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Long doInBackground(Void... voidArr) {
            return Long.valueOf(QlIdC.this.V0(this.f7605a.url));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Long l6) {
            long longValue = l6.longValue();
            if (longValue > 400) {
                longValue = ((int) (Math.random() * 20.0d)) + 380;
            }
            this.f7605a.delay = longValue;
            this.f7606b.post(new a());
        }
    }

    public static void S0(ZZcINlcxH zZcINlcxH) {
        if (MainApplication.f6711r.k().sys.proxy) {
            com.secret.prettyhezi.j.o(v.f7132a + "host/show/json", true, new h(zZcINlcxH));
        }
    }

    void T0() {
        I0();
        com.secret.prettyhezi.j.o(v.f7132a + "host/json", true, new a(this));
    }

    void U0() {
        runOnUiThread(new b());
    }

    long V0(String str) {
        String str2 = str + "/echo.js";
        if (!str2.startsWith("http")) {
            str2 = "http://" + str2;
        }
        long a6 = com.secret.prettyhezi.j.a(str2);
        X0(str2 + " " + a6);
        return a6;
    }

    void W0(com.secret.prettyhezi.User.a aVar, long j6) {
        e eVar = new e(this, j6);
        if (this.f7574y == null) {
            com.secret.prettyhezi.Device.a.b(this, new f(aVar, eVar));
            return;
        }
        I0();
        com.secret.prettyhezi.j.o(v.f7132a + "host/update/json?id=" + aVar.id, true, eVar);
    }

    void X0(String str) {
    }

    public void Y0(com.secret.prettyhezi.User.a aVar) {
        StringBuilder sb;
        String str;
        String sb2;
        long j6;
        com.secret.prettyhezi.User.a aVar2 = this.f7574y;
        if (aVar2 == null) {
            sb2 = "你将花费" + aVar.price + "积分购买一天视频加速服务器使用权限";
            j6 = aVar.price;
        } else {
            long j7 = aVar.price;
            long j8 = aVar2.price;
            if (j7 > j8) {
                j6 = j7 - j8;
                sb2 = "你将切换到新的加速服务器" + aVar.name + ", 并补交" + j6 + "积分";
            } else {
                if (j7 < j8) {
                    sb = new StringBuilder();
                    sb.append("你将切换到新的加速服务器");
                    sb.append(aVar.name);
                    str = ", 当前服务器差价不可退还";
                } else {
                    sb = new StringBuilder();
                    sb.append("你将切换到新的加速服务器");
                    str = aVar.name;
                }
                sb.append(str);
                sb2 = sb.toString();
                j6 = 0;
            }
        }
        B(sb2, new g(j6, aVar), true);
    }

    void Z0(com.secret.prettyhezi.User.a[] aVarArr) {
        this.f7572w.removeAllViews();
        for (int i6 = 0; i6 < aVarArr.length; i6++) {
            this.f7572w.addView(new j(this, aVarArr[i6]), new LinearLayout.LayoutParams(-1, g4.i.r(48.0f)));
            if (i6 < aVarArr.length - 1) {
                W(this.f7572w, Color.parseColor("#cccccc"), 0.5f, 12, 0, 12);
            }
        }
    }

    void a1(com.secret.prettyhezi.User.a aVar) {
        this.f7574y = aVar;
        this.f7571v.removeAllViews();
        this.f7571v.addView(new j(this, aVar), new LinearLayout.LayoutParams(-1, g4.i.r(52.0f)));
        int childCount = this.f7572w.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = this.f7572w.getChildAt(i6);
            if (childAt instanceof j) {
                ((j) childAt).a();
            }
        }
        if (this.f7570u == null) {
            this.f7569t.setGravity(1);
            boolean B = MainApplication.f6711r.B();
            if (B) {
                B("播放加速已暂停，立即开启？", new c(), true);
            }
            this.f7570u = g4.d.c(this, 16, -1, B ? "启用加速" : "停用加速", 17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g4.i.r(160.0f), g4.i.r(38.0f));
            layoutParams.topMargin = g4.i.r(20.0f);
            layoutParams.bottomMargin = g4.i.r(12.0f);
            this.f7570u.setBackground(g4.i.d(g4.i.b(Color.parseColor(B ? "#333333" : "#666666"), 5.0f), g4.i.b(Color.parseColor("#aaaaaa"), 5.0f)));
            this.f7569t.addView(this.f7570u, layoutParams);
            this.f7570u.setOnClickListener(new d());
        }
    }

    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout C0 = C0();
        this.f7567r = C0;
        C0.setBackgroundColor(-1);
        this.f7568s = M(this.f7567r, "播放加速");
        LinearLayout e6 = e(this.f7567r);
        this.f7569t = e6;
        e6.setPadding(0, 0, 0, g4.i.r(40.0f));
        this.f7571v = T(this.f7569t, "当前加速");
        this.f7572w = T(this.f7569t, "可用节点");
        this.f7573x = T(this.f7569t, "说明");
        TextView a6 = g4.d.a(this, 14.0f, -16777216);
        a6.setPadding(g4.i.r(12.0f), g4.i.r(12.0f), g4.i.r(12.0f), 0);
        a6.setText("服务器已经竭尽所能的优化了，如果还是有卡的现象，主要就是你所在网络运营商链接服务器线路的问题，推荐使用加速服务器，100积分/24小时，24小时内可以在所有服务器之间切换寻找最快的线路.");
        this.f7573x.addView(a6, new LinearLayout.LayoutParams(-1, -2));
        S0(this);
    }
}
