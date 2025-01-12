package com.secret.prettyhezi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import androidx.multidex.MultiDexApplication;
import com.secret.prettyhezi.Server.a0;
import com.secret.prettyhezi.Server.g;
import com.secret.prettyhezi.User.QlIdC;
import com.secret.prettyhezi.j;
import com.secret.prettyhezi.message.d;
import java.io.IOException;
import java.io.Serializable;
import java.lang.Thread;
import java.util.Iterator;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class MainApplication extends MultiDexApplication {

    /* renamed from: r  reason: collision with root package name */
    public static MainApplication f6711r = null;

    /* renamed from: s  reason: collision with root package name */
    static int f6712s = 0;

    /* renamed from: t  reason: collision with root package name */
    static String f6713t = null;

    /* renamed from: u  reason: collision with root package name */
    private static String f6714u = "keyCurConfigure";

    /* renamed from: v  reason: collision with root package name */
    public static d.a f6715v;

    /* renamed from: f  reason: collision with root package name */
    public EjNkL f6720f;

    /* renamed from: g  reason: collision with root package name */
    long f6721g;

    /* renamed from: j  reason: collision with root package name */
    ConnectionChangeReceiver f6724j;

    /* renamed from: b  reason: collision with root package name */
    private com.secret.prettyhezi.Cache.c f6716b = null;

    /* renamed from: c  reason: collision with root package name */
    private i f6717c = null;

    /* renamed from: d  reason: collision with root package name */
    private com.secret.prettyhezi.View.s f6718d = null;

    /* renamed from: e  reason: collision with root package name */
    private com.secret.prettyhezi.Upload.y f6719e = null;

    /* renamed from: h  reason: collision with root package name */
    public long f6722h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f6723i = 0;

    /* renamed from: k  reason: collision with root package name */
    long f6725k = 0;

    /* renamed from: l  reason: collision with root package name */
    com.secret.prettyhezi.Server.x[] f6726l = new com.secret.prettyhezi.Server.x[20];

    /* renamed from: m  reason: collision with root package name */
    int f6727m = -1;

    /* renamed from: n  reason: collision with root package name */
    public com.secret.prettyhezi.User.a f6728n = null;

    /* renamed from: o  reason: collision with root package name */
    public long f6729o = 0;

    /* renamed from: p  reason: collision with root package name */
    public a0 f6730p = null;

    /* renamed from: q  reason: collision with root package name */
    private com.secret.prettyhezi.Server.g f6731q = null;

    /* loaded from: classes.dex */
    public class ConnectionChangeReceiver extends BroadcastReceiver {
        public ConnectionChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if ((networkInfo == null || !networkInfo.isConnected()) && !networkInfo2.isConnected()) {
                if (g4.i.j() != null) {
                    g4.i.j().y(g4.i.j().s0(C0382R.string.NetworkNotAvailable));
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            MainApplication mainApplication = MainApplication.this;
            if (currentTimeMillis - mainApplication.f6721g > 10000) {
                mainApplication.g(true);
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainApplication.this.f6716b == null) {
                MainApplication.this.f6716b = new com.secret.prettyhezi.Cache.c();
            }
            MainApplication.this.f6716b.t();
            if (MainApplication.this.f6719e == null) {
                MainApplication.this.f6719e = new com.secret.prettyhezi.Upload.y();
                com.secret.prettyhezi.Upload.y unused = MainApplication.this.f6719e;
                com.secret.prettyhezi.Upload.y.B();
            }
            if (MainApplication.this.f6717c == null) {
                MainApplication.this.f6717c = new i();
                MainApplication.this.f6717c.a();
                MainApplication.this.f6717c.u(MainApplication.this.f6720f);
            }
            MKY2nH.S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6734a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f6735b;

        b(int i6, boolean z5) {
            this.f6734a = i6;
            this.f6735b = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainApplication.this.f6726l[this.f6734a].e(this.f6735b);
        }
    }

    /* loaded from: classes.dex */
    static class c implements Serializable {
        public String content;
        public String device = Settings.Secure.getString(g4.i.j().getContentResolver(), "android_id");
        public String os_version = g4.i.m();
        public String company = Build.MANUFACTURER + "(" + Build.MODEL + ")";
        public String appVersion = MainApplication.i();

        public c(String str) {
            this.content = str;
        }
    }

    /* loaded from: classes.dex */
    private class d implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        Thread.UncaughtExceptionHandler f6737a;

        /* loaded from: classes.dex */
        class a extends j.e {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Thread f6739a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Throwable f6740b;

            a(Thread thread, Throwable th) {
                this.f6739a = thread;
                this.f6740b = th;
            }

            @Override // com.secret.prettyhezi.j.e
            public void a(IOException iOException) {
                d.this.f6737a.uncaughtException(this.f6739a, iOException);
            }

            @Override // com.secret.prettyhezi.j.e
            public void b(int i6) {
                d.this.f6737a.uncaughtException(this.f6739a, this.f6740b);
            }

            @Override // com.secret.prettyhezi.j.e
            public void c(String str) {
                d.this.f6737a.uncaughtException(this.f6739a, this.f6740b);
            }
        }

        public d(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f6737a = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            ZZcINlcxH j6;
            String str = "Version: " + MainApplication.i() + "  OS: " + g4.i.l() + "  Device: " + g4.i.k() + "\n";
            try {
                if (g4.i.j() != null) {
                    str = str + j6.n();
                }
            } catch (Exception unused) {
            }
            j.t(com.secret.prettyhezi.Server.v.f7133b + "oslog/new", f.e(new c(str + Log.getStackTraceString(th))), null, 4, new a(thread, th));
        }
    }

    static {
        System.loadLibrary("ali");
    }

    public MainApplication() {
        f6711r = this;
    }

    private void I() {
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        ConnectionChangeReceiver connectionChangeReceiver = new ConnectionChangeReceiver();
        this.f6724j = connectionChangeReceiver;
        registerReceiver(connectionChangeReceiver, intentFilter);
    }

    private void L() {
        ConnectionChangeReceiver connectionChangeReceiver = this.f6724j;
        if (connectionChangeReceiver != null) {
            unregisterReceiver(connectionChangeReceiver);
            this.f6724j = null;
        }
    }

    public static String e() {
        String str = f6713t;
        if (str == null || str.length() == 0) {
            f6713t = g4.g.a().h("keyCurToken", HttpUrl.FRAGMENT_ENCODE_SET);
        }
        return f6713t;
    }

    public static int f() {
        if (f6712s <= 0) {
            f6712s = g4.g.a().d("keyCurUID", 0);
        }
        return f6712s;
    }

    public static String i() {
        return g4.a.c();
    }

    public static String q(String str) {
        int indexOf = str.indexOf(47, 8);
        return indexOf > 8 ? str.substring(0, indexOf) : str;
    }

    public static void z(int i6, String str) {
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        f6712s = i6;
        f6713t = str;
        g4.g.a().n("keyCurUID", f6712s);
        g4.g.a().o("keyCurToken", f6713t);
    }

    public void A(a0 a0Var) {
        this.f6730p = a0Var;
        x();
        if (a0Var == null) {
            z(0, HttpUrl.FRAGMENT_ENCODE_SET);
            this.f6728n = null;
            this.f6727m = -1;
            return;
        }
        z(a0Var.UserId(), a0Var.token.token);
        com.secret.prettyhezi.share.m.a();
        EjNkL ejNkL = EjNkL.N;
        if (ejNkL != null) {
            ejNkL.f6165r.j();
        }
        m().e();
        m().d();
        com.secret.prettyhezi.Upload.y.A(a0Var);
    }

    public boolean B() {
        if (this.f6727m == -1) {
            g4.g a6 = g4.g.a();
            this.f6727m = a6.d("keyCurDisabled" + f(), 0);
        }
        return this.f6727m > 0;
    }

    public void J(boolean z5) {
        this.f6727m = z5 ? 1 : 0;
        g4.g a6 = g4.g.a();
        a6.n("keyCurDisabled" + f(), this.f6727m);
    }

    public void K(EjNkL ejNkL) {
        this.f6720f = ejNkL;
        new Handler().postDelayed(new a(), 3000L);
    }

    public boolean a() {
        if (k() != null) {
            return k().sys.share;
        }
        return false;
    }

    public boolean b() {
        if (k() != null) {
            return k().sys.sign_in;
        }
        return false;
    }

    public boolean c() {
        if (k() != null) {
            return k().sys.sign_up;
        }
        return false;
    }

    public boolean d() {
        if (k() != null) {
            return k().sys.trade;
        }
        return false;
    }

    public void g(boolean z5) {
        if (this.f6731q == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f6725k < 3000) {
            return;
        }
        if (this.f6726l == null) {
            this.f6726l = new com.secret.prettyhezi.Server.x[20];
        }
        this.f6725k = currentTimeMillis;
        int[] iArr = {1, 15, 16, 4, 5, 12, 13, 8, 3, 9, 10, 11, 14, 18, 19, 17};
        for (int i6 = 0; i6 < 16; i6++) {
            int i7 = iArr[i6];
            com.secret.prettyhezi.Server.x[] xVarArr = this.f6726l;
            if (xVarArr[i7] == null) {
                xVarArr[i7] = new com.secret.prettyhezi.Server.x(i7);
            }
            new Handler().postDelayed(new b(i7, z5), i6 * 300);
        }
    }

    public void h(int i6, String str) {
        boolean z5;
        com.secret.prettyhezi.Server.x xVar = this.f6726l[i6];
        if (xVar == null || xVar.f7139b.size() <= 1) {
            return;
        }
        Iterator it = this.f6726l[i6].f7139b.iterator();
        while (true) {
            if (!it.hasNext()) {
                z5 = false;
                break;
            }
            g.b bVar = (g.b) it.next();
            if (str.contains(bVar.api_url)) {
                bVar.disableTime = System.currentTimeMillis() + 14400000;
                z5 = true;
                break;
            }
        }
        if (z5) {
            this.f6726l[i6].e(true);
        }
    }

    public int j() {
        if (k() != null) {
            return k().sys.box_follow;
        }
        return 2;
    }

    public com.secret.prettyhezi.Server.g k() {
        if (this.f6731q == null) {
            String h6 = g4.g.a().h(f6714u, HttpUrl.FRAGMENT_ENCODE_SET);
            if (h6.length() > 0) {
                try {
                    this.f6731q = (com.secret.prettyhezi.Server.g) f.d(com.secret.prettyhezi.Server.e.a(h6), com.secret.prettyhezi.Server.g.class);
                } catch (Exception unused) {
                }
            }
        }
        return this.f6731q;
    }

    public com.secret.prettyhezi.Cache.c l() {
        if (this.f6716b == null) {
            com.secret.prettyhezi.Cache.c p5 = com.secret.prettyhezi.Cache.c.p();
            this.f6716b = p5;
            if (p5 == null) {
                com.secret.prettyhezi.Cache.c cVar = new com.secret.prettyhezi.Cache.c();
                this.f6716b = cVar;
                cVar.t();
            }
        }
        return this.f6716b;
    }

    public com.secret.prettyhezi.View.s m() {
        if (this.f6718d == null) {
            this.f6718d = new com.secret.prettyhezi.View.s();
            com.secret.prettyhezi.Server.g k6 = k();
            if (k6 != null) {
                com.secret.prettyhezi.View.s sVar = this.f6718d;
                g.d dVar = k6.sys;
                sVar.a(dVar.cache, dVar.systime);
            }
        }
        return this.f6718d;
    }

    public com.secret.prettyhezi.Server.x n(int i6) {
        com.secret.prettyhezi.Server.x[] xVarArr = this.f6726l;
        if (xVarArr[i6] == null) {
            xVarArr[i6] = new com.secret.prettyhezi.Server.x(i6);
        }
        return this.f6726l[i6];
    }

    public int o(String str) {
        g.b[] bVarArr;
        for (g.b bVar : k().apiserves) {
            if (str.contains(bVar.api_url)) {
                return bVar.type;
            }
        }
        return 0;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        this.f6721g = System.currentTimeMillis();
        Thread.setDefaultUncaughtExceptionHandler(new d(Thread.getDefaultUncaughtExceptionHandler()));
        I();
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        com.secret.prettyhezi.Cache.c cVar = this.f6716b;
        if (cVar != null) {
            cVar.u();
            this.f6716b = null;
        }
        L();
    }

    public String p(int i6) {
        String a6 = n(i6).a();
        if (a6 == null || a6.endsWith("/")) {
            return a6;
        }
        return a6 + "/";
    }

    public a0 r() {
        if (this.f6730p == null && f() > 0) {
            g4.g a6 = g4.g.a();
            String h6 = a6.h("keyCurUser" + f(), HttpUrl.FRAGMENT_ENCODE_SET);
            if (h6.length() > 0) {
                this.f6730p = (a0) f.d(h6, a0.class);
            }
        }
        return this.f6730p;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String s(String str) {
        StringBuilder sb;
        String str2;
        int i6;
        int i7;
        com.secret.prettyhezi.User.a aVar;
        com.secret.prettyhezi.User.a aVar2;
        com.secret.prettyhezi.Server.x[] xVarArr;
        String b6;
        if (str.startsWith(g4.i.j().getFilesDir().getAbsolutePath())) {
            return str;
        }
        if (str.startsWith("type")) {
            int indexOf = str.indexOf(47);
            int parseInt = Integer.parseInt(str.substring(4, indexOf));
            int i8 = indexOf + 1;
            String substring = str.substring(i8);
            if (substring.startsWith("cdn")) {
                int indexOf2 = substring.indexOf(47);
                String substring2 = substring.substring(3, indexOf2);
                if (g4.i.P(substring2)) {
                    i7 = Integer.parseInt(substring2);
                    i6 = i8 + indexOf2;
                    aVar = this.f6728n;
                    if (aVar != null && aVar.isExpired() && (parseInt == 3 || parseInt == 8)) {
                        QlIdC.S0(null);
                    }
                    aVar2 = this.f6728n;
                    if (aVar2 == null && !aVar2.isExpired() && ((parseInt == 3 || parseInt == 4 || parseInt == 5 || parseInt == 8 || parseInt == 11 || parseInt == 12 || parseInt == 13 || parseInt == 14) && !B())) {
                        str = str.replace(str.substring(0, indexOf), this.f6728n.url.trim());
                    } else if ((parseInt >= 3 && parseInt <= 5) || ((parseInt >= 8 && parseInt <= 15) || parseInt == 18)) {
                        xVarArr = this.f6726l;
                        if (xVarArr[parseInt] == null) {
                            xVarArr[parseInt] = new com.secret.prettyhezi.Server.x(parseInt);
                        }
                        com.secret.prettyhezi.Server.x[] xVarArr2 = this.f6726l;
                        b6 = i7 != -1 ? xVarArr2[parseInt].b(i7) : xVarArr2[parseInt].a();
                        if (b6 != null) {
                            str = str.replace(str.substring(0, i6), b6.trim());
                        }
                    }
                }
            }
            i6 = indexOf;
            i7 = -1;
            aVar = this.f6728n;
            if (aVar != null) {
                QlIdC.S0(null);
            }
            aVar2 = this.f6728n;
            if (aVar2 == null) {
            }
            if (parseInt >= 3) {
                xVarArr = this.f6726l;
                if (xVarArr[parseInt] == null) {
                }
                com.secret.prettyhezi.Server.x[] xVarArr22 = this.f6726l;
                if (i7 != -1) {
                }
                if (b6 != null) {
                }
            }
            xVarArr = this.f6726l;
            if (xVarArr[parseInt] == null) {
            }
            com.secret.prettyhezi.Server.x[] xVarArr222 = this.f6726l;
            if (i7 != -1) {
            }
            if (b6 != null) {
            }
        }
        if (str.startsWith("http")) {
            return str;
        }
        if (str.startsWith("//")) {
            sb = new StringBuilder();
            str2 = "http:";
        } else {
            sb = new StringBuilder();
            str2 = "http://";
        }
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }

    public int t() {
        if (k() != null) {
            return this.f6731q.sys.notice;
        }
        return 0;
    }

    public void u() {
        if (f() > 0) {
            this.f6723i++;
        }
    }

    public void v(int i6, String str) {
        if (h.a()) {
            int parseInt = str.contains(com.secret.prettyhezi.Server.v.f7132a) ? 1 : str.startsWith("type") ? Integer.parseInt(str.substring(4, str.indexOf(47))) : -1;
            if (parseInt < 1 || parseInt > 20) {
                return;
            }
            this.f6726l[parseInt].d();
        }
    }

    public void w(com.secret.prettyhezi.Server.g gVar) {
        this.f6731q = gVar;
        if (gVar != null) {
            g4.g.a().o(f6714u, com.secret.prettyhezi.Server.e.d(f.e(gVar)));
            m();
        }
    }

    public void x() {
        a0 a0Var = this.f6730p;
        if (a0Var == null) {
            g4.g a6 = g4.g.a();
            a6.o("keyCurUser" + f(), HttpUrl.FRAGMENT_ENCODE_SET);
            return;
        }
        String e6 = f.e(a0Var);
        g4.g a7 = g4.g.a();
        a7.o("keyCurUser" + this.f6730p.UserId(), e6);
    }

    public String y() {
        return (k() == null || k().sys == null) ? HttpUrl.FRAGMENT_ENCODE_SET : this.f6731q.sys.app_version;
    }
}
