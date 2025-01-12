package com.secret.prettyhezi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import c.abc;
import com.secret.prettyhezi.Device.OAnkX;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.g;
import com.secret.prettyhezi.Server.z;
import com.secret.prettyhezi.User.QlIdC;
import com.secret.prettyhezi.User.T6FSl1UsM;
import com.secret.prettyhezi.User.TK1dGVzP;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.s;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class UQGjREUX extends ZZcINlcxH {

    /* renamed from: q  reason: collision with root package name */
    RelativeLayout f7159q;

    /* renamed from: v  reason: collision with root package name */
    g.e f7164v;

    /* renamed from: r  reason: collision with root package name */
    public boolean f7160r = false;

    /* renamed from: s  reason: collision with root package name */
    public boolean f7161s = true;

    /* renamed from: t  reason: collision with root package name */
    Set f7162t = new HashSet();

    /* renamed from: u  reason: collision with root package name */
    boolean f7163u = false;

    /* renamed from: w  reason: collision with root package name */
    volatile boolean f7165w = false;

    /* renamed from: x  reason: collision with root package name */
    com.secret.AD.h f7166x = null;

    /* renamed from: y  reason: collision with root package name */
    boolean f7167y = false;

    /* renamed from: z  reason: collision with root package name */
    boolean f7168z = false;
    boolean A = false;
    j.e B = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends j.e {
        a() {
        }

        @Override // com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
        }

        @Override // com.secret.prettyhezi.j.e
        public void b(int i6) {
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            com.secret.prettyhezi.Server.s.SavePages(MainApplication.f6711r.k().sys.page, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UQGjREUX.this.Y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends ZZcINlcxH.q {
        c() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void a() {
            UQGjREUX.this.finish();
            System.exit(0);
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            UQGjREUX.this.m1();
        }
    }

    /* loaded from: classes.dex */
    class d extends ZZcINlcxH.q {
        d() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            UQGjREUX.this.finish();
            System.exit(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements com.secret.prettyhezi.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.Server.x f7173a;

        e(com.secret.prettyhezi.Server.x xVar) {
            this.f7173a = xVar;
        }

        @Override // com.secret.prettyhezi.e
        public void a(int i6) {
            this.f7173a.c(null);
            UQGjREUX.this.X0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends j.e {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f7176a;

            a(String str) {
                this.f7176a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.secret.prettyhezi.Server.p pVar = (com.secret.prettyhezi.Server.p) com.secret.prettyhezi.f.d(this.f7176a, com.secret.prettyhezi.Server.p.class);
                if (pVar.code == 200) {
                    MainApplication.f6711r.A(pVar.data);
                    g4.g.a().q(pVar.data.token);
                    QlIdC.S0(null);
                } else {
                    UQGjREUX uQGjREUX = UQGjREUX.this;
                    if (!uQGjREUX.A) {
                        uQGjREUX.n1();
                        return;
                    } else {
                        MainApplication.f6711r.A(null);
                        com.secret.prettyhezi.s.d(UQGjREUX.this, pVar.err);
                    }
                }
                UQGjREUX uQGjREUX2 = UQGjREUX.this;
                uQGjREUX2.f7168z = true;
                uQGjREUX2.d1();
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UQGjREUX uQGjREUX = UQGjREUX.this;
                uQGjREUX.f7168z = true;
                uQGjREUX.d1();
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UQGjREUX uQGjREUX = UQGjREUX.this;
                if (!uQGjREUX.A) {
                    uQGjREUX.n1();
                    return;
                }
                uQGjREUX.f7168z = true;
                uQGjREUX.d1();
            }
        }

        f() {
        }

        @Override // com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
            UQGjREUX.this.f7159q.post(new b());
        }

        @Override // com.secret.prettyhezi.j.e
        public void b(int i6) {
            UQGjREUX.this.f7159q.post(new c());
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            UQGjREUX.this.f7159q.post(new a(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UQGjREUX uQGjREUX = UQGjREUX.this;
            uQGjREUX.f7168z = true;
            uQGjREUX.d1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements Runnable {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                UQGjREUX.this.finish();
                System.exit(0);
            }
        }

        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UQGjREUX uQGjREUX = UQGjREUX.this;
            uQGjREUX.D(uQGjREUX.s0(C0382R.string.SeverNotAvailable), new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements Runnable {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void a() {
                UQGjREUX.this.finish();
                System.exit(0);
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                UQGjREUX.this.M0(MKY2nH.class);
                UQGjREUX.this.finish();
            }
        }

        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UQGjREUX uQGjREUX = UQGjREUX.this;
            uQGjREUX.C(uQGjREUX.s0(C0382R.string.SeverNotAvailable), new String[]{UQGjREUX.this.s0(C0382R.string.ExitApp), UQGjREUX.this.s0(C0382R.string.LatestSite)}, new a(), false);
        }
    }

    /* loaded from: classes.dex */
    class j extends ZZcINlcxH.q {
        j() {
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            UQGjREUX.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class k implements com.secret.prettyhezi.e {
        k() {
        }

        @Override // com.secret.prettyhezi.e
        public void a(int i6) {
            UQGjREUX.this.S0(com.secret.prettyhezi.Server.v.f7133b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends j.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7187a;

        l(String str) {
            this.f7187a = str;
        }

        @Override // com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
            UQGjREUX uQGjREUX = UQGjREUX.this;
            if (uQGjREUX.f7163u) {
                uQGjREUX.Z0();
                return;
            }
            uQGjREUX.f7163u = true;
            uQGjREUX.S0(com.secret.prettyhezi.Server.v.b());
        }

        @Override // com.secret.prettyhezi.j.e
        public void b(int i6) {
            UQGjREUX uQGjREUX = UQGjREUX.this;
            if (uQGjREUX.f7163u) {
                uQGjREUX.Z0();
                return;
            }
            uQGjREUX.f7163u = true;
            uQGjREUX.S0(com.secret.prettyhezi.Server.v.b());
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            String str2 = this.f7187a;
            if (str2 != com.secret.prettyhezi.Server.v.f7133b) {
                com.secret.prettyhezi.Server.v.m(str2);
            }
            UQGjREUX.this.j1(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m extends j.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7189a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f7190b;

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: com.secret.prettyhezi.UQGjREUX$m$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0110a implements Runnable {
                RunnableC0110a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    MainApplication.f6711r.n(1).d();
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                new Handler().postDelayed(new RunnableC0110a(), 1500L);
            }
        }

        m(String str, long j6) {
            this.f7189a = str;
            this.f7190b = j6;
        }

        @Override // com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
            d();
        }

        @Override // com.secret.prettyhezi.j.e
        public void b(int i6) {
            d();
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            long currentTimeMillis = System.currentTimeMillis();
            z zVar = (z) com.secret.prettyhezi.f.d(str, z.class);
            String str2 = this.f7189a;
            if (str2 != com.secret.prettyhezi.Server.v.f7132a) {
                com.secret.prettyhezi.Server.v.n(str2);
            }
            if (zVar.code != 200) {
                UQGjREUX.this.Y0();
                return;
            }
            UQGjREUX.this.i1();
            if (currentTimeMillis - this.f7190b > 2000) {
                UQGjREUX.this.runOnUiThread(new a());
            }
        }

        void d() {
            UQGjREUX.this.f7162t.add(this.f7189a);
            String b12 = UQGjREUX.this.b1(1);
            if (b12 == null) {
                UQGjREUX.this.Y0();
            } else {
                UQGjREUX.this.T0(b12);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UQGjREUX.this.f7165w = true;
            if (UQGjREUX.this.f7160r) {
                if (com.secret.prettyhezi.Device.a.f() != null) {
                    UQGjREUX.this.c1();
                } else {
                    UQGjREUX.this.k1();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements s.f {
        o() {
        }

        @Override // com.secret.prettyhezi.s.f
        public void a(String str) {
            com.secret.prettyhezi.Device.a.l(str);
            UQGjREUX.this.c1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p extends s.e {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                UQGjREUX.this.l0();
            }
        }

        p(ZZcINlcxH zZcINlcxH, s.f fVar) {
            super(zZcINlcxH, fVar);
        }

        @Override // com.secret.prettyhezi.s.g
        public void f(String str) {
            UQGjREUX.this.D(com.secret.prettyhezi.c.b(str), new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7198a;

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                UQGjREUX.this.e1();
            }
        }

        /* loaded from: classes.dex */
        class b extends ZZcINlcxH.q {
            b() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                ZZcINlcxH.g(com.secret.prettyhezi.Server.g.latestApk());
                UQGjREUX.this.H("已复制下载地址到剪贴板");
                UQGjREUX.this.finish();
            }
        }

        /* loaded from: classes.dex */
        class c extends ZZcINlcxH.q {
            c() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                UQGjREUX.this.finish();
            }
        }

        /* loaded from: classes.dex */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UQGjREUX.this.d1();
            }
        }

        q(String str) {
            this.f7198a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            UQGjREUX uQGjREUX;
            String b12;
            UQGjREUX uQGjREUX2;
            String str;
            ZZcINlcxH.q bVar;
            s sVar = (s) com.secret.prettyhezi.f.d(this.f7198a, s.class);
            if (sVar.code != 200) {
                UQGjREUX.this.y(sVar.err);
                UQGjREUX.this.W0();
                return;
            }
            MainApplication.f6711r.w(sVar.data);
            String c6 = g4.a.c();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j6 = sVar.data.sys.systime;
            int i6 = (int) (currentTimeMillis - j6);
            g4.g.a().n("keySysDiffTime", i6);
            g4.i.f10512b = i6;
            if (MainApplication.f6711r.y().compareTo(c6) > 0) {
                MainApplication.f6711r.n(6).d();
                uQGjREUX2 = UQGjREUX.this;
                str = uQGjREUX2.s0(C0382R.string.UpdateHint);
                bVar = new a();
            } else if (MainApplication.f6711r.y().compareTo(c6) >= 0) {
                if (currentTimeMillis > j6 + 90000 || currentTimeMillis < j6 - 90000) {
                    UQGjREUX.this.D("你的手机时间不正确，请修正后启动", new c(), false);
                    return;
                }
                g4.g.a().p();
                if (com.secret.AD.h.i()) {
                    UQGjREUX.this.f7166x = new com.secret.AD.h(UQGjREUX.this, new d());
                    UQGjREUX uQGjREUX3 = UQGjREUX.this;
                    uQGjREUX3.f7159q.addView(uQGjREUX3.f7166x, new RelativeLayout.LayoutParams(-1, -1));
                }
                if (MainApplication.f6711r.t() > com.secret.prettyhezi.Server.r.savedNoticeVersion) {
                    UQGjREUX.this.o1();
                } else {
                    com.secret.prettyhezi.Server.r.LoadPrevious();
                }
                if (MainApplication.f6711r.k().sys.page > com.secret.prettyhezi.Server.s.savedPageVersion) {
                    UQGjREUX.this.p1();
                } else {
                    com.secret.prettyhezi.Server.s.LoadPrevious();
                }
                MainApplication.f6711r.g(true);
                UQGjREUX.this.f7162t.clear();
                if (UQGjREUX.this.f1(1, com.secret.prettyhezi.Server.v.f7132a)) {
                    uQGjREUX = UQGjREUX.this;
                    b12 = com.secret.prettyhezi.Server.v.f7132a;
                } else {
                    uQGjREUX = UQGjREUX.this;
                    b12 = uQGjREUX.b1(1);
                }
                uQGjREUX.T0(b12);
                return;
            } else {
                uQGjREUX2 = UQGjREUX.this;
                str = "你所用的版本不是官方版本，请到官网下载并先卸载后安装 \n" + com.secret.prettyhezi.Server.g.latestApk();
                bVar = new b();
            }
            uQGjREUX2.D(str, bVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class r extends j.e {
        r() {
        }

        @Override // com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
        }

        @Override // com.secret.prettyhezi.j.e
        public void b(int i6) {
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            com.secret.prettyhezi.Server.r.SaveNotices(MainApplication.f6711r.t(), str);
        }
    }

    /* loaded from: classes.dex */
    static class s extends com.secret.prettyhezi.Server.w {
        com.secret.prettyhezi.Server.g data;

        s() {
        }
    }

    public static String h1(String str) {
        if (!str.startsWith("http")) {
            str = "http://" + str;
        }
        if (str.endsWith("/")) {
            return str;
        }
        return str + "/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES"), androidx.constraintlayout.widget.g.T0);
    }

    void S0(String str) {
        com.secret.prettyhezi.j.t(str + com.secret.prettyhezi.Server.v.f7134c, com.secret.prettyhezi.f.e(this.f7164v), null, 4, new l(str));
    }

    void T0(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        com.secret.prettyhezi.j.p(str + "echo/json", new m(str, currentTimeMillis));
    }

    void U0() {
        if (T6FSl1UsM.c1(g4.g.a().h("inviteCode", HttpUrl.FRAGMENT_ENCODE_SET))) {
            return;
        }
        String f6 = g4.c.f("invite.dat");
        if (T6FSl1UsM.c1(f6)) {
            g4.g.a().o("inviteCode", f6);
        }
    }

    void V0() {
        if (g4.g.a().h("newServerAPI", HttpUrl.FRAGMENT_ENCODE_SET).equals("4")) {
            return;
        }
        String absolutePath = getFilesDir().getAbsolutePath();
        String[] strArr = {"itemListCache", "photos"};
        for (int i6 = 0; i6 < 2; i6++) {
            String str = strArr[i6];
            g4.c.a(absolutePath + File.separator + str, true);
        }
        new com.secret.prettyhezi.Cache.c().j();
        String[] strArr2 = {"photo.json", "video.json", "uploadHis.json", "film.json", "book.json", "box.json", "lastBookPosition", "VideoDownload/all", "VideoDownload/completed", "VideoDownload/m3u8all", "VideoDownload/m3u8completed"};
        for (int i7 = 0; i7 < 11; i7++) {
            String str2 = strArr2[i7];
            g4.c.c(absolutePath + File.separator + str2);
        }
        g4.g.a().o("newServerAPI", "4");
    }

    void W0() {
        this.f7159q.postDelayed(new b(), 1000L);
    }

    void X0() {
        com.secret.prettyhezi.Server.x n5 = MainApplication.f6711r.n(6);
        if (n5.f7144g) {
            n5.c(new e(n5));
        } else {
            g4.a.d(this);
        }
    }

    void Y0() {
        runOnUiThread(new h());
    }

    void Z0() {
        runOnUiThread(new i());
    }

    j.e a1() {
        if (this.B == null) {
            this.B = new f();
        }
        return this.B;
    }

    String b1(int i6) {
        g.b[] bVarArr;
        String str;
        for (g.b bVar : MainApplication.f6711r.k().apiserves) {
            if (bVar.type == i6 && (str = bVar.api_url) != null) {
                String h12 = h1(str);
                if (!this.f7162t.contains(h12)) {
                    return h12;
                }
            }
        }
        return null;
    }

    void c1() {
        if (MainApplication.f6711r.b()) {
            String g6 = g4.g.a().g();
            if (g6 == null || g6.length() <= 0) {
                n1();
            } else {
                com.secret.prettyhezi.Server.v.w(g6, a1());
            }
        }
        if (this.B == null) {
            this.f7159q.postDelayed(new g(), 400L);
        }
    }

    public void d1() {
        Class cls;
        if (this.f7161s || !this.f7168z) {
            return;
        }
        com.secret.AD.h hVar = this.f7166x;
        if (hVar == null || hVar.g()) {
            a0 r5 = MainApplication.f6711r.r();
            if (r5 == null) {
                cls = TK1dGVzP.class;
            } else if (!r5.payment_password && r5.grade != 0) {
                OAnkX.S0(this);
                return;
            } else {
                cls = EjNkL.class;
            }
            M0(cls);
            finish();
        }
    }

    void e1() {
        if (this.f7160r) {
            g1();
        } else {
            this.f7167y = true;
        }
    }

    boolean f1(int i6, String str) {
        g.b[] bVarArr;
        String str2;
        for (g.b bVar : MainApplication.f6711r.k().apiserves) {
            if (bVar.type == i6 && (str2 = bVar.api_url) != null && h1(str2).equals(str)) {
                return true;
            }
        }
        return false;
    }

    void g1() {
        boolean canRequestPackageInstalls;
        if (Build.VERSION.SDK_INT >= 26) {
            canRequestPackageInstalls = getPackageManager().canRequestPackageInstalls();
            if (!canRequestPackageInstalls) {
                B(s0(C0382R.string.AllowInstallUnknownSourceApp), new c(), false);
                return;
            }
        }
        X0();
    }

    void i1() {
        com.secret.prettyhezi.Game.b.c();
        runOnUiThread(new n());
    }

    void j1(String str) {
        this.f7159q.post(new q(str));
    }

    void k1() {
        com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "auth/json", new com.secret.prettyhezi.Registration.g("i"), false, new p(this, new o()));
    }

    String[] l1() {
        return new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
    }

    @Override // com.secret.prettyhezi.ZZcINlcxH
    public View n0() {
        return this.f7159q;
    }

    void n1() {
        String e6 = g4.g.a().e();
        String f6 = g4.g.a().f();
        if (e6.isEmpty() || f6.isEmpty()) {
            return;
        }
        this.A = true;
        String c6 = abc.c(9);
        com.secret.prettyhezi.j.r(com.secret.prettyhezi.Server.v.f7132a + "auth/json", new com.secret.prettyhezi.Registration.p(e6, f6, c6, "26,37"), false, a1());
    }

    void o1() {
        com.secret.prettyhezi.j.q(com.secret.prettyhezi.Server.v.f7133b + "notice/1", null, 4, new r());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onActivityResult(int i6, int i7, Intent intent) {
        super.onActivityResult(i6, i7, intent);
        if (i6 == 101) {
            g1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.secret.prettyhezi.View.s.c();
        V0();
        if (p0.d.b().d(this, null)) {
            l0();
            return;
        }
        y0();
        if ((getIntent().getFlags() & 4194304) != 0) {
            finish();
            return;
        }
        MainApplication.f6711r.A(null);
        abc.abe(this);
        this.f7159q = E0();
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(C0382R.drawable.loading);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(255.6f), g4.i.r(79.2f));
        layoutParams.addRule(13, -1);
        this.f7159q.addView(imageView, layoutParams);
        r0();
        if (p0.e.b().a(this)) {
            H("破解要小心哦~");
        }
        if (!com.secret.prettyhezi.h.a()) {
            D(s0(C0382R.string.NetworkNotAvailable), new j(), false);
        } else if (p0.a.c(this)) {
            l0();
        } else {
            if (p0.e.b().d()) {
                l0();
            }
            this.f7164v = new g.e();
            com.secret.prettyhezi.Server.i.b(new k());
            H0();
            boolean p02 = p0(l1());
            this.f7160r = p02;
            if (p02) {
                com.secret.prettyhezi.Device.a.i();
            }
            U0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f7161s = true;
    }

    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        if (i6 != 100) {
            return;
        }
        boolean p02 = p0(l1());
        this.f7160r = p02;
        if (!p02) {
            D("本应用需要存储权限，请在下次打开应用时允许，或在设置中打开该应用的权限", new d(), false);
            return;
        }
        com.secret.prettyhezi.Device.a.i();
        if (this.f7167y) {
            g1();
        } else if (this.f7165w) {
            i1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f7161s = false;
        if (!this.f7160r) {
            requestPermissions(l1(), 100);
        }
        d1();
    }

    void p1() {
        com.secret.prettyhezi.j.q(com.secret.prettyhezi.Server.v.f7133b + "pages", null, 4, new a());
    }

    @Override // com.secret.prettyhezi.ZZcINlcxH
    protected boolean t0() {
        return true;
    }
}
