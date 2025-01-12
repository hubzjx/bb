package com.secret.prettyhezi;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.Server.z;
import com.secret.prettyhezi.User.TK1dGVzP;
import com.secret.prettyhezi.View.o;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.x;
import com.secret.prettyhezi.j;
import java.io.IOException;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends ZZcINlcxH.q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f8810a;

        a(ZZcINlcxH zZcINlcxH) {
            this.f8810a = zZcINlcxH;
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void a() {
            this.f8810a.l0();
        }

        @Override // com.secret.prettyhezi.ZZcINlcxH.q
        public void b() {
            this.f8810a.M0(TK1dGVzP.class);
        }
    }

    /* loaded from: classes.dex */
    class b implements x.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f8811a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.secret.prettyhezi.controls.x f8812b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8813c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ f f8814d;

        b(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.controls.x xVar, int i6, f fVar) {
            this.f8811a = zZcINlcxH;
            this.f8812b = xVar;
            this.f8813c = i6;
            this.f8814d = fVar;
        }

        @Override // com.secret.prettyhezi.controls.x.c
        public void a(int i6) {
            if (this.f8811a.j(this.f8812b) && i6 == 1) {
                int j6 = MainApplication.f6711r.j();
                if (MainApplication.f6711r.r().integral.all < j6) {
                    ZZcINlcxH zZcINlcxH = this.f8811a;
                    zZcINlcxH.D(String.format(zZcINlcxH.s0(C0382R.string.ScoreNotEnough), Integer.valueOf(j6)), null, true);
                    return;
                }
                this.f8811a.I0();
                com.secret.prettyhezi.Server.v.u(this.f8813c, new e(this.f8811a, this.f8814d));
                MainApplication.f6711r.m().e();
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements o.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f8815a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8816b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f8817c;

        c(ZZcINlcxH zZcINlcxH, int i6, f fVar) {
            this.f8815a = zZcINlcxH;
            this.f8816b = i6;
            this.f8817c = fVar;
        }

        @Override // com.secret.prettyhezi.View.o.c
        public void a() {
            int i6 = (MainApplication.f6711r.r().integral.all > 2.0d ? 1 : (MainApplication.f6711r.r().integral.all == 2.0d ? 0 : -1));
            ZZcINlcxH zZcINlcxH = this.f8815a;
            if (i6 < 0) {
                zZcINlcxH.D(String.format(zZcINlcxH.s0(C0382R.string.ScoreNotEnough), 2), null, true);
                return;
            }
            zZcINlcxH.I0();
            com.secret.prettyhezi.Server.v.v(this.f8816b, new e(this.f8815a, this.f8817c));
        }
    }

    /* loaded from: classes.dex */
    public static class d extends j.e {

        /* renamed from: a  reason: collision with root package name */
        ZZcINlcxH f8818a;

        /* renamed from: b  reason: collision with root package name */
        com.secret.prettyhezi.View.t f8819b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f8820a;

            a(String str) {
                this.f8820a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.e(this.f8820a);
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f8822a;

            b(String str) {
                this.f8822a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f(this.f8822a);
            }
        }

        public d(ZZcINlcxH zZcINlcxH, com.secret.prettyhezi.View.t tVar) {
            this.f8818a = zZcINlcxH;
            this.f8819b = tVar;
        }

        @Override // com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
            ZZcINlcxH zZcINlcxH;
            int i6;
            if (h.a()) {
                zZcINlcxH = this.f8818a;
                i6 = C0382R.string.SeverNotAvailable;
            } else {
                zZcINlcxH = this.f8818a;
                i6 = C0382R.string.NetworkNotAvailable;
            }
            d(zZcINlcxH.s0(i6));
        }

        @Override // com.secret.prettyhezi.j.e
        public void b(int i6) {
            d("Error: " + i6);
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            try {
                this.f8818a.runOnUiThread(new b(str));
            } catch (Exception unused) {
            }
        }

        public void d(String str) {
            try {
                this.f8818a.runOnUiThread(new a(str));
            } catch (Exception unused) {
            }
        }

        public void e(String str) {
            s.d(this.f8818a, str);
            this.f8819b.A();
        }

        public abstract void f(String str);
    }

    /* loaded from: classes.dex */
    public static class e extends g {

        /* renamed from: b  reason: collision with root package name */
        f f8824b;

        public e(ZZcINlcxH zZcINlcxH, f fVar) {
            super(zZcINlcxH);
            this.f8824b = fVar;
        }

        @Override // com.secret.prettyhezi.s.g
        public void g(String str) {
            e(str, this.f8824b);
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(String str);
    }

    /* loaded from: classes.dex */
    public static class g extends j.e {

        /* renamed from: a  reason: collision with root package name */
        ZZcINlcxH f8825a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f8826a;

            a(String str) {
                this.f8826a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g.this.f8825a.L0()) {
                    g.this.f8825a.j0();
                }
                g gVar = g.this;
                String str = this.f8826a;
                if (str == null) {
                    str = "未知错误";
                }
                gVar.f(str);
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f8828a;

            b(String str) {
                this.f8828a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.f8825a.j0();
                g.this.g(this.f8828a);
            }
        }

        public g(ZZcINlcxH zZcINlcxH) {
            this.f8825a = zZcINlcxH;
        }

        @Override // com.secret.prettyhezi.j.e
        public void a(IOException iOException) {
            d(h.a() ? "Server not available, please try later" : "Network not available, please check your internet connection");
        }

        @Override // com.secret.prettyhezi.j.e
        public void b(int i6) {
            d("Error: " + i6);
        }

        @Override // com.secret.prettyhezi.j.e
        public void c(String str) {
            this.f8825a.runOnUiThread(new b(str));
        }

        public void d(String str) {
            if (str != null && str.equals("WrongPaymentPassword")) {
                com.secret.prettyhezi.Device.a.e();
            }
            ZZcINlcxH j6 = g4.i.j();
            ZZcINlcxH zZcINlcxH = this.f8825a;
            if (j6 == zZcINlcxH) {
                zZcINlcxH.runOnUiThread(new a(str));
            }
        }

        public void e(String str, f fVar) {
            ZZcINlcxH j6 = g4.i.j();
            z zVar = (z) com.secret.prettyhezi.f.d(str, z.class);
            if (zVar.code != 200) {
                d(zVar.err);
                return;
            }
            String str2 = zVar.data;
            if (fVar != null) {
                fVar.a(str2);
            } else {
                s.e(j6, str2);
            }
        }

        public void f(String str) {
            s.d(this.f8825a, str);
        }

        public abstract void g(String str);
    }

    public static void a(int i6, ZZcINlcxH zZcINlcxH, f fVar) {
        zZcINlcxH.I0();
        com.secret.prettyhezi.Server.v.s(i6, new e(zZcINlcxH, fVar));
    }

    public static void b(int i6, ZZcINlcxH zZcINlcxH, f fVar) {
        if (MainApplication.f6711r.r() == null) {
            zZcINlcxH.M0(TK1dGVzP.class);
            return;
        }
        com.secret.prettyhezi.controls.x xVar = new com.secret.prettyhezi.controls.x(zZcINlcxH);
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        TextView c6 = g4.d.c(zZcINlcxH, 16, -16777216, HttpUrl.FRAGMENT_ENCODE_SET, 1);
        c6.setText(String.format(zZcINlcxH.s0(C0382R.string.FollowBoxHint), Integer.valueOf(MainApplication.f6711r.j())));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = g4.i.r(10.0f);
        linearLayout.addView(c6, layoutParams);
        TextView c7 = g4.d.c(zZcINlcxH, 14, -65536, HttpUrl.FRAGMENT_ENCODE_SET, 1);
        c7.setText("关注盒子绝对不会获赠积分或者权限，谨防被骗");
        linearLayout.addView(c7);
        xVar.e(linearLayout);
        xVar.d(new String[]{zZcINlcxH.s0(C0382R.string.cancel), zZcINlcxH.s0(C0382R.string.ok)}, new b(zZcINlcxH, xVar, i6, fVar));
        zZcINlcxH.x(xVar, null, false);
    }

    public static void c(int i6, ZZcINlcxH zZcINlcxH, f fVar) {
        if (MainApplication.f6711r.r() == null) {
            zZcINlcxH.M0(TK1dGVzP.class);
        } else {
            com.secret.prettyhezi.View.o.a(5, new c(zZcINlcxH, i6, fVar));
        }
    }

    public static void d(ZZcINlcxH zZcINlcxH, String str) {
        if (str == null) {
            str = "未知错误";
        } else if (str.equals("WrongPaymentPassword")) {
            com.secret.prettyhezi.Device.a.e();
        } else if (str.equals("AccountByAnother")) {
            zZcINlcxH.D("账号在别的设备登录，请重新登录", new a(zZcINlcxH), false);
            return;
        } else if (str.equals("IsNewUser")) {
            com.secret.prettyhezi.User.f.j(zZcINlcxH);
            return;
        }
        zZcINlcxH.y(com.secret.prettyhezi.c.b(str));
    }

    public static void e(ZZcINlcxH zZcINlcxH, String str) {
        zZcINlcxH.z(com.secret.prettyhezi.c.b(str));
    }

    public static void f(int i6, ZZcINlcxH zZcINlcxH, f fVar) {
        zZcINlcxH.I0();
        com.secret.prettyhezi.Server.v.B(i6, new e(zZcINlcxH, fVar));
        MainApplication.f6711r.m().e();
    }

    public static void g(int i6, ZZcINlcxH zZcINlcxH, f fVar) {
        zZcINlcxH.I0();
        com.secret.prettyhezi.Server.v.C(i6, new e(zZcINlcxH, fVar));
    }
}
