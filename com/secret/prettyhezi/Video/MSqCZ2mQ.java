package com.secret.prettyhezi.Video;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.exoplayer2.h1;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.j1;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.w0;
import com.google.android.exoplayer2.y1;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.D8ZS9RTR;
import com.secret.prettyhezi.LQS1CVD;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.x;
import com.secret.prettyhezi.UoWMF;
import com.secret.prettyhezi.User.QlIdC;
import com.secret.prettyhezi.Video.MSqCZ2mQ;
import com.secret.prettyhezi.Video.a;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.z;
import java.util.Timer;
import java.util.TimerTask;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.dnsoverhttps.DnsOverHttps;
import okhttp3.internal.ws.RealWebSocket;
import r2.b;
import r2.c;
import w1.m;
import w1.y0;
/* loaded from: classes.dex */
public class MSqCZ2mQ extends UoWMF {

    /* renamed from: t0  reason: collision with root package name */
    public static long f7744t0;

    /* renamed from: u0  reason: collision with root package name */
    static OkHttpClient f7745u0;

    /* renamed from: v0  reason: collision with root package name */
    public static ArrayMap f7746v0 = new ArrayMap(2);
    t1 A;
    TextureView C;
    RelativeLayout D;
    public View E;
    TextView G;
    public ProgressBar J;
    public View K;
    public TextView L;
    public SeekBar M;
    public TextView N;
    public TextView O;
    ImageView P;
    View Q;
    TextView R;
    public TextView T;
    public LinearLayout U;
    LinearLayout V;
    ImageView W;

    /* renamed from: g0  reason: collision with root package name */
    int f7753g0;

    /* renamed from: h0  reason: collision with root package name */
    int f7754h0;

    /* renamed from: m0  reason: collision with root package name */
    TextView f7759m0;

    /* renamed from: n0  reason: collision with root package name */
    int f7760n0;

    /* renamed from: q0  reason: collision with root package name */
    protected Timer f7763q0;

    /* renamed from: r0  reason: collision with root package name */
    protected u f7765r0;

    /* renamed from: s  reason: collision with root package name */
    String f7766s;

    /* renamed from: u  reason: collision with root package name */
    int f7769u;

    /* renamed from: v  reason: collision with root package name */
    int f7770v;

    /* renamed from: x  reason: collision with root package name */
    public FrameLayout f7772x;

    /* renamed from: z  reason: collision with root package name */
    RelativeLayout f7774z;

    /* renamed from: r  reason: collision with root package name */
    long f7764r = 0;

    /* renamed from: t  reason: collision with root package name */
    String f7768t = null;

    /* renamed from: w  reason: collision with root package name */
    long f7771w = 0;

    /* renamed from: y  reason: collision with root package name */
    boolean f7773y = false;
    com.secret.prettyhezi.Video.a B = null;
    RelativeLayout F = null;
    TextView H = null;
    TextView I = null;
    h1 S = new h1(1.0f, 1.0f);
    f4.d X = null;
    long Y = 0;
    LinearLayout Z = null;

    /* renamed from: a0  reason: collision with root package name */
    TextView f7747a0 = null;

    /* renamed from: b0  reason: collision with root package name */
    int f7748b0 = 0;

    /* renamed from: c0  reason: collision with root package name */
    boolean f7749c0 = false;

    /* renamed from: d0  reason: collision with root package name */
    boolean f7750d0 = false;

    /* renamed from: e0  reason: collision with root package name */
    boolean f7751e0 = false;

    /* renamed from: f0  reason: collision with root package name */
    public int f7752f0 = -1;

    /* renamed from: i0  reason: collision with root package name */
    s2.l f7755i0 = new d();

    /* renamed from: j0  reason: collision with root package name */
    boolean f7756j0 = false;

    /* renamed from: k0  reason: collision with root package name */
    j1.a f7757k0 = new e();

    /* renamed from: l0  reason: collision with root package name */
    public int f7758l0 = 0;

    /* renamed from: o0  reason: collision with root package name */
    Runnable f7761o0 = null;

    /* renamed from: p0  reason: collision with root package name */
    public boolean f7762p0 = false;

    /* renamed from: s0  reason: collision with root package name */
    boolean f7767s0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f7775a;

        /* renamed from: com.secret.prettyhezi.Video.MSqCZ2mQ$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0123a extends ZZcINlcxH.q {
            C0123a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                MSqCZ2mQ.this.finish();
                MSqCZ2mQ.this.M0(QlIdC.class);
            }
        }

        a(long j6) {
            this.f7775a = j6;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MSqCZ2mQ.this.isDestroyed() || MSqCZ2mQ.this.isFinishing() || MSqCZ2mQ.this.K.getVisibility() != 0) {
                return;
            }
            long j6 = this.f7775a;
            if (j6 - MSqCZ2mQ.f7744t0 > 3600) {
                MSqCZ2mQ.f7744t0 = j6;
                MSqCZ2mQ.this.B("网络太卡，试试视频加速服务？", new C0123a(), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g4.f {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LQS1CVD f7778d;

        b(LQS1CVD lqs1cvd) {
            this.f7778d = lqs1cvd;
        }

        @Override // g4.f
        public void a(View view) {
            MSqCZ2mQ.this.Z0(true);
            MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
            if (mSqCZ2mQ.f7750d0) {
                mSqCZ2mQ.H(mSqCZ2mQ.s0(C0382R.string.VideoDownloadedHint));
            } else if (MainApplication.f6711r.l().c(MSqCZ2mQ.this)) {
                MainApplication.f6711r.l().b(MSqCZ2mQ.this.f7769u, this.f7778d.N);
                MSqCZ2mQ mSqCZ2mQ2 = MSqCZ2mQ.this;
                mSqCZ2mQ2.H(mSqCZ2mQ2.s0(C0382R.string.DownloadingHint));
                MSqCZ2mQ.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g4.f {
        c() {
        }

        @Override // g4.f
        public void a(View view) {
            MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
            if (mSqCZ2mQ.f7751e0) {
                mSqCZ2mQ.H(mSqCZ2mQ.s0(C0382R.string.SavedToAlbum));
                return;
            }
            String str = mSqCZ2mQ.f7766s.startsWith(mSqCZ2mQ.getFilesDir().getAbsolutePath()) ? MSqCZ2mQ.this.f7766s : MSqCZ2mQ.this.f7768t;
            Log.e("tvExportToAlbum", str);
            f4.c.b(str);
            MSqCZ2mQ mSqCZ2mQ2 = MSqCZ2mQ.this;
            mSqCZ2mQ2.f7751e0 = true;
            mSqCZ2mQ2.I.setText(mSqCZ2mQ2.s0(C0382R.string.SavedToAlbum));
        }
    }

    /* loaded from: classes.dex */
    class d implements s2.l {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MSqCZ2mQ.this.d1();
            }
        }

        d() {
        }

        @Override // s2.l
        public void M(int i6, int i7) {
        }

        @Override // s2.l
        public void c(int i6, int i7, int i8, float f6) {
            MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
            mSqCZ2mQ.f7753g0 = i6;
            mSqCZ2mQ.f7754h0 = i7;
            int width = mSqCZ2mQ.f7772x.getWidth();
            int height = MSqCZ2mQ.this.f7772x.getHeight();
            if (width == 0 || height == 0) {
                width = MSqCZ2mQ.this.o().x;
                height = MSqCZ2mQ.this.o().y;
            }
            float f7 = i6;
            float f8 = i7;
            float min = Math.min(width / f7, height / f8);
            int i9 = (int) (f7 * min);
            int i10 = (int) (f8 * min);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i9, i10);
            layoutParams.leftMargin = (width - i9) / 2;
            layoutParams.topMargin = (height - i10) / 2;
            MSqCZ2mQ.this.C.setLayoutParams(layoutParams);
            if (height > width) {
                MSqCZ2mQ mSqCZ2mQ2 = MSqCZ2mQ.this;
                if (mSqCZ2mQ2.f7754h0 < mSqCZ2mQ2.f7753g0) {
                    mSqCZ2mQ2.runOnUiThread(new a());
                }
            }
        }

        @Override // s2.l
        public void t() {
        }
    }

    /* loaded from: classes.dex */
    class e implements j1.a {

        /* loaded from: classes.dex */
        class a implements com.secret.prettyhezi.e {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ x f7784a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ com.google.android.exoplayer2.t f7785b;

            a(x xVar, com.google.android.exoplayer2.t tVar) {
                this.f7784a = xVar;
                this.f7785b = tVar;
            }

            @Override // com.secret.prettyhezi.e
            public void a(int i6) {
                this.f7784a.c(null);
                MSqCZ2mQ.this.q1(this.f7784a, this.f7785b, i6 == 0);
            }
        }

        e() {
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void C(y1 y1Var, int i6) {
            i1.n(this, y1Var, i6);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void E(int i6) {
            i1.h(this, i6);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void F(boolean z5, int i6) {
            i1.f(this, z5, i6);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void P(boolean z5) {
            i1.a(this, z5);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void V(boolean z5) {
            i1.c(this, z5);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void d(h1 h1Var) {
            i1.g(this, h1Var);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void e(int i6) {
            i1.i(this, i6);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public void f(boolean z5, int i6) {
            MSqCZ2mQ mSqCZ2mQ;
            int i7;
            if (z5 && i6 < 3) {
                MSqCZ2mQ mSqCZ2mQ2 = MSqCZ2mQ.this;
                if (mSqCZ2mQ2.f7758l0 != 3) {
                    mSqCZ2mQ2.K.setVisibility(0);
                    MSqCZ2mQ.this.V0();
                    MSqCZ2mQ.this.y1();
                    return;
                }
                return;
            }
            if (i6 == 3) {
                MSqCZ2mQ.this.K.setVisibility(4);
                MSqCZ2mQ mSqCZ2mQ3 = MSqCZ2mQ.this;
                if (mSqCZ2mQ3.f7758l0 != 0) {
                    return;
                }
                if (mSqCZ2mQ3.X == null) {
                    mSqCZ2mQ3.X = new f4.d(mSqCZ2mQ3);
                    ((FrameLayout) MSqCZ2mQ.this.findViewById(C0382R.id.surface_container)).setOnTouchListener(MSqCZ2mQ.this.X);
                }
                mSqCZ2mQ = MSqCZ2mQ.this;
                i7 = 1;
            } else if (i6 != 4) {
                return;
            } else {
                mSqCZ2mQ = MSqCZ2mQ.this;
                i7 = 2;
            }
            mSqCZ2mQ.S0(i7);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void g(y0 y0Var, o2.k kVar) {
            i1.p(this, y0Var, kVar);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void h(boolean z5) {
            i1.d(this, z5);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void i(int i6) {
            i1.l(this, i6);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void p(y1 y1Var, Object obj, int i6) {
            i1.o(this, y1Var, obj, i6);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public void r(com.google.android.exoplayer2.t tVar) {
            MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
            if (!mSqCZ2mQ.f7756j0) {
                mSqCZ2mQ.f7756j0 = true;
                String str = (String) MSqCZ2mQ.f7746v0.get(mSqCZ2mQ.f7766s);
                if (str.startsWith("type")) {
                    x n5 = MainApplication.f6711r.n(Integer.parseInt(str.substring(4, str.indexOf(47))));
                    if (n5 != null && n5.f7139b.size() > 1) {
                        MSqCZ2mQ.this.I0();
                        n5.c(new a(n5, tVar));
                        n5.d();
                        return;
                    }
                }
            }
            MainApplication.f6711r.v(0, (String) MSqCZ2mQ.f7746v0.get(MSqCZ2mQ.this.f7766s));
            MSqCZ2mQ.this.m1();
            MSqCZ2mQ.this.u1(tVar);
            MSqCZ2mQ.this.S0(3);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void s(boolean z5) {
            i1.b(this, z5);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void u() {
            i1.m(this);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void w(w0 w0Var, int i6) {
            i1.e(this, w0Var, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f7787a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f7788b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.android.exoplayer2.t f7789c;

        f(boolean z5, x xVar, com.google.android.exoplayer2.t tVar) {
            this.f7787a = z5;
            this.f7788b = xVar;
            this.f7789c = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            MSqCZ2mQ.this.j0();
            if (!this.f7787a || this.f7788b.f7141d.IsSameHost(MSqCZ2mQ.this.f7766s)) {
                MSqCZ2mQ.this.m1();
                MSqCZ2mQ.this.u1(this.f7789c);
                MSqCZ2mQ.this.S0(3);
                return;
            }
            MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
            mSqCZ2mQ.f7771w = mSqCZ2mQ.e1();
            String str = (String) MSqCZ2mQ.f7746v0.get(MSqCZ2mQ.this.f7766s);
            MSqCZ2mQ.f7746v0.remove(MSqCZ2mQ.this.f7766s);
            t1 t1Var = MSqCZ2mQ.this.A;
            if (t1Var != null) {
                t1Var.i0();
                MSqCZ2mQ.this.A = null;
            }
            String s5 = MainApplication.f6711r.s(str);
            MSqCZ2mQ.f7746v0.put(s5, str);
            MSqCZ2mQ mSqCZ2mQ2 = MSqCZ2mQ.this;
            mSqCZ2mQ2.f7766s = s5;
            mSqCZ2mQ2.j1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* loaded from: classes.dex */
        class a extends ZZcINlcxH.q {
            a() {
            }

            @Override // com.secret.prettyhezi.ZZcINlcxH.q
            public void b() {
                MSqCZ2mQ.this.finish();
            }
        }

        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MSqCZ2mQ.this.D("视频还没下载完，无法继续播放", new a(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends g4.f {
        h() {
        }

        @Override // g4.f
        public void a(View view) {
            t1 t1Var = MSqCZ2mQ.this.A;
            if (t1Var != null) {
                t1Var.k0();
                MSqCZ2mQ.this.S0(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends g4.f {

        /* loaded from: classes.dex */
        class a extends AsyncTask {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public String doInBackground(String... strArr) {
                return g4.i.J(strArr[0]);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: b */
            public void onPostExecute(String str) {
                super.onPostExecute(str);
                MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
                com.secret.prettyhezi.controls.r.e(mSqCZ2mQ.f7760n0, mSqCZ2mQ.f7769u, mSqCZ2mQ.f7770v, mSqCZ2mQ.f7766s, str);
            }
        }

        i() {
        }

        @Override // g4.f
        protected void a(View view) {
            g4.i.j().I0();
            new a().execute(MSqCZ2mQ.this.f7766s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
            if (mSqCZ2mQ.f7761o0 != null) {
                mSqCZ2mQ.h1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f7797a;

        k(long j6) {
            this.f7797a = j6;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = MSqCZ2mQ.this.L;
            textView.setText("加载中(" + MSqCZ2mQ.this.g1(this.f7797a / 8) + ")...");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends g4.f {
        l() {
        }

        @Override // g4.f
        public void a(View view) {
            long k6 = MSqCZ2mQ.this.A.k();
            MSqCZ2mQ.this.finish();
            MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
            NRxYacSEB.z1(mSqCZ2mQ, mSqCZ2mQ.f7766s, mSqCZ2mQ.f7769u, mSqCZ2mQ.f7770v, k6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m implements r2.i {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f7800b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f7801c;

        m(String str, String str2) {
            this.f7800b = str;
            this.f7801c = str2;
        }

        private String b(Uri uri) {
            return g4.i.Q(uri.toString().replace(this.f7800b, this.f7801c));
        }

        @Override // r2.i
        public String a(q2.o oVar) {
            String str = oVar.f12802i;
            return str != null ? str : b(oVar.f12794a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
            int i6 = mSqCZ2mQ.f7748b0 - 1;
            mSqCZ2mQ.f7748b0 = i6;
            if (i6 > 0) {
                TextView textView = mSqCZ2mQ.f7747a0;
                textView.setText(HttpUrl.FRAGMENT_ENCODE_SET + MSqCZ2mQ.this.f7748b0);
                MSqCZ2mQ.this.a1();
                return;
            }
            mSqCZ2mQ.D.removeView(mSqCZ2mQ.Z);
            t1 t1Var = MSqCZ2mQ.this.A;
            if (t1Var != null) {
                t1Var.p0(true);
                RelativeLayout relativeLayout = MSqCZ2mQ.this.F;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            }
            MSqCZ2mQ.this.X0();
            MSqCZ2mQ.this.D.removeViewAt(0);
            if (com.secret.AD.c.b(8)) {
                MSqCZ2mQ.this.D.addView(new com.secret.AD.e(MSqCZ2mQ.this, 8), 0, new RelativeLayout.LayoutParams(-1, -1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o extends g4.f {
        o() {
        }

        @Override // g4.f
        public void a(View view) {
            MSqCZ2mQ.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p extends g4.f {
        p() {
        }

        @Override // g4.f
        public void a(View view) {
            MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
            int i6 = mSqCZ2mQ.f7758l0;
            if (i6 != 1) {
                if (i6 == 2) {
                    mSqCZ2mQ.A.m(0L);
                    MSqCZ2mQ.this.S = new h1(1.0f, 1.0f);
                    MSqCZ2mQ mSqCZ2mQ2 = MSqCZ2mQ.this;
                    mSqCZ2mQ2.A.q0(mSqCZ2mQ2.S);
                    MSqCZ2mQ.this.A.p0(true);
                    MSqCZ2mQ.this.S0(1);
                    MSqCZ2mQ.this.h1();
                    return;
                }
                return;
            }
            if (mSqCZ2mQ.A.Z()) {
                MSqCZ2mQ mSqCZ2mQ3 = MSqCZ2mQ.this;
                if (mSqCZ2mQ3.S.f3778a == 1.0f) {
                    mSqCZ2mQ3.A.p0(false);
                    MSqCZ2mQ.this.Q.setVisibility(4);
                    MSqCZ2mQ.this.x1();
                    MSqCZ2mQ.this.f7761o0 = null;
                    if (com.secret.AD.c.b(8) && MSqCZ2mQ.this.D.getChildCount() == 0) {
                        MSqCZ2mQ.this.D.addView(new com.secret.AD.e(MSqCZ2mQ.this, 8), 0, new RelativeLayout.LayoutParams(-1, -1));
                    }
                    MSqCZ2mQ.this.X0();
                }
            }
            MSqCZ2mQ mSqCZ2mQ4 = MSqCZ2mQ.this;
            if (mSqCZ2mQ4.S.f3778a > 1.0f) {
                mSqCZ2mQ4.R.setVisibility(8);
                MSqCZ2mQ.this.S = new h1(1.0f, 1.0f);
                MSqCZ2mQ mSqCZ2mQ5 = MSqCZ2mQ.this;
                mSqCZ2mQ5.A.q0(mSqCZ2mQ5.S);
                MSqCZ2mQ mSqCZ2mQ6 = MSqCZ2mQ.this;
                mSqCZ2mQ6.A.q0(mSqCZ2mQ6.S);
            } else {
                mSqCZ2mQ4.A.p0(true);
            }
            MSqCZ2mQ.this.h1();
            MSqCZ2mQ.this.X0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q extends g4.f {
        q() {
        }

        @Override // g4.f
        public void a(View view) {
            if (MSqCZ2mQ.this.A.Z()) {
                MSqCZ2mQ.this.P.setImageResource(C0382R.drawable.jz_click_play_selector);
                MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
                float f6 = mSqCZ2mQ.S.f3778a + 0.5f;
                if (f6 > 3.0f) {
                    f6 = 1.5f;
                }
                mSqCZ2mQ.S = new h1(f6, 1.0f);
                MSqCZ2mQ mSqCZ2mQ2 = MSqCZ2mQ.this;
                mSqCZ2mQ2.A.q0(mSqCZ2mQ2.S);
                if (f6 > 1.0f) {
                    MSqCZ2mQ.this.R.setVisibility(0);
                    TextView textView = MSqCZ2mQ.this.R;
                    textView.setText(g4.i.A(f6) + "X");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class r implements SeekBar.OnSeekBarChangeListener {
        r() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i6, boolean z5) {
            if (z5) {
                MSqCZ2mQ.this.N.setText(f4.d.h((i6 * MSqCZ2mQ.this.f1()) / 100));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Log.i("MSqCZ2mQ", "bottomProgress onStartTrackingTouch [" + hashCode() + "] ");
            MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
            mSqCZ2mQ.f7762p0 = true;
            mSqCZ2mQ.f7761o0 = null;
            for (ViewParent parent = mSqCZ2mQ.M.getParent(); parent != null; parent = parent.getParent()) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Log.i("MSqCZ2mQ", "bottomProgress onStopTrackingTouch [" + hashCode() + "] ");
            MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
            mSqCZ2mQ.f7762p0 = false;
            for (ViewParent parent = mSqCZ2mQ.M.getParent(); parent != null; parent = parent.getParent()) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
            if (MSqCZ2mQ.this.f7758l0 != 1) {
                return;
            }
            long progress = (seekBar.getProgress() * MSqCZ2mQ.this.f1()) / 100;
            MSqCZ2mQ.this.f7752f0 = seekBar.getProgress();
            MSqCZ2mQ mSqCZ2mQ2 = MSqCZ2mQ.this;
            mSqCZ2mQ2.J.setProgress(mSqCZ2mQ2.f7752f0);
            MSqCZ2mQ.this.t1(progress);
            MSqCZ2mQ.this.h1();
            Log.i("MSqCZ2mQ", "seekTo " + progress + " [" + hashCode() + "] ");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class s extends g4.f {
        s() {
        }

        @Override // g4.f
        public void a(View view) {
            MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
            D8ZS9RTR.S0(mSqCZ2mQ, mSqCZ2mQ.f7770v, mSqCZ2mQ.f7769u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class t extends AsyncTask {
        t() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(String... strArr) {
            return Integer.valueOf(com.secret.prettyhezi.j.h(strArr[0]));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            MSqCZ2mQ.this.f7760n0 = num.intValue();
            TextView textView = MSqCZ2mQ.this.f7759m0;
            textView.setText("视频播放失败:" + MSqCZ2mQ.this.f7760n0);
        }
    }

    /* loaded from: classes.dex */
    public class u extends TimerTask {
        public u() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            long e12 = MSqCZ2mQ.this.e1();
            long f12 = MSqCZ2mQ.this.f1();
            int i6 = (int) ((100 * e12) / (f12 == 0 ? 1L : f12));
            MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
            if (mSqCZ2mQ.f7762p0) {
                return;
            }
            mSqCZ2mQ.r1(i6, e12, f12);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MSqCZ2mQ mSqCZ2mQ = MSqCZ2mQ.this;
            if (mSqCZ2mQ.f7758l0 == 1) {
                mSqCZ2mQ.f7772x.post(new Runnable() { // from class: f4.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        MSqCZ2mQ.u.this.b();
                    }
                });
            }
        }
    }

    public static void T0(ZZcINlcxH zZcINlcxH, String str, int i6, int i7, long j6) {
        if (c1(zZcINlcxH, str, i6, i7) && !str.startsWith(MainApplication.f6711r.getFilesDir().getAbsolutePath())) {
            zZcINlcxH.y(zZcINlcxH.s0(C0382R.string.DownloadingHint));
            return;
        }
        Intent intent = new Intent();
        intent.setClass(zZcINlcxH, MSqCZ2mQ.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putInt("id", i7);
        bundle.putLong("pos", j6);
        bundle.putInt("type", i6);
        intent.putExtras(bundle);
        zZcINlcxH.startActivity(intent);
    }

    static OkHttpClient U0() {
        if (f7745u0 == null) {
            f7745u0 = com.secret.prettyhezi.j.l(2000, 4000, true);
        }
        return f7745u0;
    }

    public static boolean c1(ZZcINlcxH zZcINlcxH, String str, int i6, int i7) {
        return MainApplication.f6711r.l().e(i6, false, i7) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
        if (r7 != 3) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void S0(int i6) {
        this.f7758l0 = i6;
        x1();
        X0();
        Y0();
        int i7 = 0;
        LinearLayout linearLayout = this.U;
        if (i6 == 3) {
            linearLayout.setVisibility(0);
            if (this.f7773y) {
                runOnUiThread(new g());
            }
        } else {
            linearLayout.setVisibility(4);
        }
        this.K.setVisibility(i6 == 0 ? 0 : 4);
        y1();
        if (i6 != 0) {
            if (i6 == 1) {
                this.J.setVisibility(0);
                this.K.setVisibility(4);
                w1();
            } else if (i6 == 2) {
                h1();
                this.J.setProgress(100);
                this.P.setVisibility(0);
                this.T.setVisibility(0);
                this.Q.setVisibility(8);
                Y0();
            }
            View view = this.E;
            if (i6 != 3 && i6 != 2) {
                i7 = 8;
            }
            view.setVisibility(i7);
        }
        this.V.setVisibility(4);
        this.J.setVisibility(4);
        this.J.setProgress(0);
        this.P.setVisibility(4);
        this.Q.setVisibility(8);
        s1();
        View view2 = this.E;
        if (i6 != 3) {
            i7 = 8;
        }
        view2.setVisibility(i7);
    }

    void V0() {
        if (MainApplication.f6711r.r() == null || !MainApplication.f6711r.k().sys.proxy || f7744t0 > 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        com.secret.prettyhezi.User.a aVar = MainApplication.f6711r.f6728n;
        if (aVar == null || aVar.isExpired()) {
            long j6 = this.f7764r;
            if (j6 == 0) {
                this.f7764r = currentTimeMillis;
            } else if (currentTimeMillis - j6 < 120000) {
                this.f7774z.postDelayed(new a(currentTimeMillis), 2000L);
            }
        }
    }

    public void W0() {
        Timer timer = this.f7763q0;
        if (timer != null) {
            timer.cancel();
            this.f7763q0 = null;
        }
        u uVar = this.f7765r0;
        if (uVar != null) {
            uVar.cancel();
            this.f7765r0 = null;
        }
    }

    void X0() {
        t1 t1Var = this.A;
        this.D.setVisibility(t1Var == null || !t1Var.Z() ? 0 : 8);
    }

    void Y0() {
        Z0(false);
    }

    void Z0(boolean z5) {
        TextView textView;
        if (this.F == null || this.f7768t == null) {
            return;
        }
        t1 t1Var = this.A;
        this.F.setVisibility(t1Var != null && this.f7748b0 == 0 && (!t1Var.Z() || this.f7758l0 == 2) ? 0 : 8);
        if (this.f7749c0 || n1()) {
            this.f7749c0 = true;
            if (z5 && (textView = this.H) != null && !this.f7750d0) {
                this.f7750d0 = true;
                textView.setText(s0(C0382R.string.Downloaded));
                MainApplication.f6711r.l().a(this.f7769u, ((LQS1CVD) x0()).N, this.f7768t);
            }
        }
        TextView textView2 = this.I;
        if (textView2 != null) {
            textView2.setVisibility(this.f7749c0 ? 0 : 8);
        }
    }

    void a1() {
        this.D.postDelayed(new n(), 990L);
    }

    TextView b1(String str) {
        TextView b6 = g4.d.b(this, 14.0f, -1, str);
        b6.setGravity(17);
        b6.setBackground(g4.i.d(g4.i.b(-65536, 4.0f), g4.i.b(Color.parseColor("#aa0000"), 4.0f)));
        return b6;
    }

    public void d1() {
        this.W.setVisibility(0);
        this.W.setOnClickListener(new l());
    }

    public long e1() {
        t1 t1Var = this.A;
        if (t1Var != null) {
            return t1Var.k();
        }
        return 0L;
    }

    public long f1() {
        long j6 = this.Y;
        if (j6 > 0) {
            return j6;
        }
        t1 t1Var = this.A;
        if (t1Var != null) {
            this.Y = t1Var.Y();
        }
        return this.Y;
    }

    String g1(long j6) {
        if (j6 > 1048576) {
            return g4.i.A(j6 / 1048576.0d) + "M/秒";
        } else if (j6 > RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            return (j6 / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) + "K/秒";
        } else {
            return j6 + "B/秒";
        }
    }

    public void h1() {
        t1 t1Var = this.A;
        if (t1Var != null && (t1Var.Z() || this.f7767s0)) {
            this.V.setVisibility(4);
            this.J.setVisibility(0);
            this.P.setVisibility(4);
        }
        this.Q.setVisibility(8);
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        this.f7761o0 = null;
    }

    void i1() {
        this.F = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, g4.i.r(32.0f));
        layoutParams.bottomMargin = g4.i.r(45.0f);
        int r5 = g4.i.r(6.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        layoutParams.addRule(12, -1);
        this.f7774z.addView(this.F, layoutParams);
        if (this.f7770v <= 0 || this.f7769u <= 0) {
            return;
        }
        this.G = b1(s0(C0382R.string.collect));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(g4.i.r(58.0f), g4.i.r(30.0f));
        this.G.setOnClickListener(new s());
        this.F.addView(this.G, layoutParams2);
        if (x0() instanceof LQS1CVD) {
            LQS1CVD lqs1cvd = (LQS1CVD) x0();
            if (lqs1cvd.z1()) {
                this.H = b1(s0(this.f7750d0 ? C0382R.string.Downloaded : C0382R.string.Download));
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(g4.i.r(66.0f), g4.i.r(30.0f));
                layoutParams3.addRule(14, -1);
                this.H.setOnClickListener(new b(lqs1cvd));
                this.F.addView(this.H, layoutParams3);
            }
        }
        if (this.f7766s.endsWith(".mp4")) {
            this.I = b1(s0(C0382R.string.SaveToAlbum));
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(g4.i.r(100.0f), g4.i.r(30.0f));
            layoutParams4.addRule(11, -1);
            this.I.setOnClickListener(new c());
            this.F.addView(this.I, layoutParams4);
            this.I.setVisibility(this.f7749c0 ? 0 : 8);
        }
    }

    void j1() {
        com.secret.prettyhezi.Video.a a6 = new a.b(this).e(1L).a();
        this.B = a6;
        a6.i(this);
        boolean z5 = true;
        t1 u5 = new t1.b(this, new com.google.android.exoplayer2.s(this)).v(this.B).w(new q.a().b(new q2.p(true, DnsOverHttps.MAX_RESPONSE_SIZE)).c(10000, 40000, 2500, 6000).d(true).a()).u();
        this.A = u5;
        u5.t0(this.C);
        if (this.f7766s.startsWith(getFilesDir().getAbsolutePath())) {
            this.A.n((this.f7766s.contains(".m3u8") ? new w0.b().g(Uri.parse(this.f7766s)).d("application/x-mpegURL") : new w0.b().g(Uri.parse(this.f7766s))).a());
        } else {
            r2.s a7 = f4.b.a(this);
            String str = (String) f7746v0.get(this.f7766s);
            String substring = str.substring(0, str.indexOf(47));
            c.C0212c e6 = new c.C0212c().d(a7).g(new b1.b(U0(), "ExoplayerVideo")).f(new b.C0211b().c(a7).b(1048576).d(Long.MAX_VALUE)).e(new m(g4.i.I(this.f7766s), substring));
            this.A.n0(this.f7766s.contains(".m3u8") ? new HlsMediaSource.Factory(e6).e(Uri.parse(this.f7766s)) : new m.d(e6).e(Uri.parse(this.f7766s)));
        }
        this.A.U(this.f7755i0);
        this.A.S(this.f7757k0);
        this.A.f0();
        long j6 = this.f7771w;
        if (j6 > 0) {
            this.A.m(j6);
        }
        t1 t1Var = this.A;
        if (!this.f7756j0 && com.secret.AD.c.b(7)) {
            z5 = false;
        }
        t1Var.p0(z5);
    }

    void k1() {
        o1();
        l1();
        this.f7772x = (FrameLayout) findViewById(C0382R.id.surface_container);
        TextureView textureView = new TextureView(this);
        this.C = textureView;
        this.f7772x.addView(textureView, new FrameLayout.LayoutParams(-1, -1));
        j1();
    }

    void l1() {
        this.D = (RelativeLayout) findViewById(C0382R.id.ad_container);
        if (com.secret.AD.c.b(7)) {
            com.secret.AD.e eVar = new com.secret.AD.e(this, 7);
            this.D.addView(eVar, new RelativeLayout.LayoutParams(-1, -1));
            int i6 = eVar.f5893c.loading;
            this.f7748b0 = i6;
            if (i6 < 2) {
                this.f7748b0 = 5;
            }
            LinearLayout linearLayout = new LinearLayout(this);
            this.Z = linearLayout;
            linearLayout.setOrientation(0);
            this.Z.setGravity(17);
            TextView b6 = g4.d.b(this, 16.0f, -1, "广告");
            TextView b7 = g4.d.b(this, 16.0f, -1, "秒");
            this.f7747a0 = g4.d.b(this, 16.0f, -65536, HttpUrl.FRAGMENT_ENCODE_SET + this.f7748b0);
            this.Z.addView(b6, new LinearLayout.LayoutParams(-2, -2));
            this.Z.addView(this.f7747a0, new LinearLayout.LayoutParams(-2, -2));
            this.Z.addView(b7, new LinearLayout.LayoutParams(-2, -2));
            this.Z.setPadding(g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f), g4.i.r(6.0f));
            this.Z.setBackgroundColor(Color.parseColor("#aa000000"));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11, -1);
            this.D.addView(this.Z, layoutParams);
            a1();
        } else {
            this.D.setVisibility(8);
        }
        this.K = findViewById(C0382R.id.loading);
        this.L = (TextView) findViewById(C0382R.id.loading_speed);
        this.V = (LinearLayout) findViewById(C0382R.id.layout_bottom_seek);
        this.N = (TextView) findViewById(C0382R.id.current);
        this.O = (TextView) findViewById(C0382R.id.total);
        this.J = (ProgressBar) findViewById(C0382R.id.bottom_progress);
        this.M = (SeekBar) findViewById(C0382R.id.bottom_seek_progress);
        this.P = (ImageView) findViewById(C0382R.id.start);
        View findViewById = findViewById(C0382R.id.play_forward);
        this.Q = findViewById;
        findViewById.setBackground(g4.i.d(g4.i.b(Color.parseColor("#55000000"), 22.5f), g4.i.b(Color.parseColor("#22000000"), 22.5f)));
        TextView textView = (TextView) findViewById(C0382R.id.play_forward_text);
        this.R = textView;
        textView.setBackground(g4.i.b(Color.parseColor("#66888888"), 5.0f));
        this.R.setVisibility(8);
        this.T = (TextView) findViewById(C0382R.id.replay_text);
        this.W = (ImageView) findViewById(C0382R.id.fullscreen);
        com.secret.prettyhezi.controls.u a6 = com.secret.prettyhezi.controls.u.a(new z(this, C0382R.drawable.ic_back), 32, 32);
        this.E = a6;
        a6.setBackground(g4.i.d(g4.i.b(Color.parseColor("#aaffffff"), 18.0f), g4.i.b(Color.parseColor("#88ffffff"), 18.0f)));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(g4.i.r(36.0f), g4.i.r(36.0f));
        int r5 = g4.i.r(6.0f);
        layoutParams2.topMargin = r5;
        layoutParams2.leftMargin = r5;
        this.f7774z.addView(this.E, layoutParams2);
        this.E.setOnClickListener(new o());
        this.E.setVisibility(8);
        this.P.setOnClickListener(new p());
        this.Q.setOnClickListener(new q());
        this.U = (LinearLayout) findViewById(C0382R.id.retry_layout);
        i1();
        this.M.setOnSeekBarChangeListener(new r());
        this.W.setVisibility(8);
        S0(0);
    }

    void m1() {
        if (this.U.getChildCount() == 0) {
            this.f7759m0 = g4.d.c(this, 12, -1, "视频播放失败:0", 17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = g4.i.r(20.0f);
            this.U.addView(this.f7759m0, layoutParams);
            TextView c6 = g4.d.c(this, 14, -1, s0(C0382R.string.click_to_restart), 17);
            c6.setBackground(g4.i.d(g4.i.c(-16777216, 5.0f, -1, 1.0f), g4.i.c(Color.parseColor("#333333"), 5.0f, -1, 1.0f)));
            c6.setPadding(g4.i.r(8.0f), 0, g4.i.r(8.0f), 0);
            c6.setOnClickListener(new h());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, g4.i.r(40.0f));
            layoutParams2.bottomMargin = g4.i.r(40.0f);
            this.U.addView(c6, layoutParams2);
            if (this.f7769u <= 0 || this.f7770v <= 0 || !this.f7766s.startsWith("http")) {
                return;
            }
            TextView c7 = g4.d.c(this, 14, -1, "提交反馈", 17);
            c7.setBackground(g4.i.d(g4.i.c(-16777216, 5.0f, -1, 1.0f), g4.i.c(Color.parseColor("#333333"), 5.0f, -1, 1.0f)));
            c7.setOnClickListener(new i());
            this.U.addView(c7, new LinearLayout.LayoutParams(g4.i.r(80.0f), g4.i.r(40.0f)));
        }
    }

    public boolean n1() {
        String str = this.f7768t;
        if (str == null) {
            return false;
        }
        return f4.b.c(str, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void o1() {
        String GetDownloadedPath;
        String s5 = MainApplication.f6711r.s(this.f7766s);
        f7746v0.put(s5, this.f7766s);
        this.f7766s = s5;
        if (s5.startsWith(getFilesDir().getAbsolutePath())) {
            this.f7750d0 = true;
            this.f7749c0 = true;
        } else {
            com.secret.prettyhezi.Cache.g e6 = MainApplication.f6711r.l().e(this.f7769u, true, this.f7770v);
            if (e6 != null) {
                GetDownloadedPath = e6.GetDownloadedPath();
                if (GetDownloadedPath == null) {
                    this.f7766s = GetDownloadedPath;
                    this.f7750d0 = true;
                    this.f7749c0 = true;
                    return;
                } else if (this.f7749c0 || this.f7766s.startsWith(getFilesDir().getAbsolutePath()) || !this.f7766s.endsWith(".mp4")) {
                    return;
                } else {
                    String str = (String) f7746v0.get(this.f7766s);
                    this.f7768t = str;
                    this.f7768t = g4.i.Q(str);
                    this.f7749c0 = n1();
                    return;
                }
            }
        }
        GetDownloadedPath = null;
        if (GetDownloadedPath == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.UoWMF, com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        y0();
        getWindow().setFlags(128, 128);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7766s = extras.getString("url");
            this.f7769u = extras.getInt("type");
            this.f7770v = extras.getInt("id");
            if (extras.containsKey("pos")) {
                this.f7771w = extras.getLong("pos");
            }
        }
        this.f7773y = c1(this, this.f7766s, this.f7769u, this.f7770v);
        setContentView(C0382R.layout.video_layout_std);
        this.f7774z = (RelativeLayout) findViewById(C0382R.id.video_root);
        k1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        W0();
        f7746v0.remove(this.f7766s);
        t1 t1Var = this.A;
        if (t1Var != null) {
            t1Var.i0();
            this.A = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onPause() {
        super.onPause();
        t1 t1Var = this.A;
        if (t1Var != null && t1Var.Z()) {
            this.A.p0(false);
            this.f7767s0 = true;
        }
        Y0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.secret.prettyhezi.ZZcINlcxH, android.app.Activity
    public void onResume() {
        t1 t1Var;
        super.onResume();
        if (this.f7767s0 && (t1Var = this.A) != null) {
            t1Var.p0(true);
        }
        this.f7767s0 = false;
    }

    public void p1() {
        x1();
        Y0();
        this.V.setVisibility(0);
        this.J.setVisibility(4);
        this.P.setVisibility(0);
        this.Q.setVisibility(0);
        if (this.f7758l0 == 1) {
            j jVar = new j();
            this.f7761o0 = jVar;
            this.f7772x.postDelayed(jVar, 2000L);
        }
        this.E.setVisibility(0);
        this.F.setVisibility(0);
    }

    void q1(x xVar, com.google.android.exoplayer2.t tVar, boolean z5) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        runOnUiThread(new f(z5, xVar, tVar));
    }

    public void r1(int i6, long j6, long j7) {
        if (!this.X.f9899b) {
            int i7 = this.f7752f0;
            if (i7 != -1) {
                if (i7 > i6) {
                    return;
                }
                this.f7752f0 = -1;
            } else if (i6 != 0) {
                this.M.setProgress(i6);
                this.J.setProgress(i6);
            }
        }
        if (j6 != 0) {
            this.N.setText(f4.d.h(j6));
        }
        this.O.setText(f4.d.h(j7));
    }

    public void s1() {
        this.M.setProgress(0);
        this.M.setSecondaryProgress(0);
        this.N.setText(f4.d.h(0L));
        this.O.setText(f4.d.h(0L));
    }

    public void t1(long j6) {
        if (this.A == null || j6 >= f1()) {
            return;
        }
        this.f7764r = 0L;
        this.A.m(j6);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void u1(com.google.android.exoplayer2.t tVar) {
        int i6;
        int i7 = tVar.type;
        if (i7 == 0) {
            i6 = 404;
        } else if (i7 == 3) {
            i6 = 502;
        } else if (i7 != 5) {
            this.f7760n0 = 0;
            TextView textView = this.f7759m0;
            textView.setText("视频播放失败:" + this.f7760n0);
            if (this.f7766s.startsWith("http")) {
                return;
            }
            new t().execute(this.f7766s);
            return;
        } else {
            i6 = 408;
        }
        this.f7760n0 = i6;
        TextView textView2 = this.f7759m0;
        textView2.setText("视频播放失败:" + this.f7760n0);
        if (this.f7766s.startsWith("http")) {
        }
    }

    public boolean v1() {
        return this.D.getVisibility() == 0;
    }

    public void w1() {
        Log.i("MSqCZ2mQ", "startProgressTimer:  [" + hashCode() + "] ");
        W0();
        this.f7763q0 = new Timer();
        u uVar = new u();
        this.f7765r0 = uVar;
        this.f7763q0.schedule(uVar, 0L, 300L);
    }

    public void x1() {
        ImageView imageView;
        int i6 = this.f7758l0;
        int i7 = C0382R.drawable.jz_click_play_selector;
        boolean z5 = true;
        if (i6 != 1) {
            if (i6 == 3) {
                return;
            }
            if (i6 == 2) {
                imageView = this.P;
                i7 = C0382R.drawable.jz_click_replay_selector;
            } else {
                imageView = this.P;
            }
            imageView.setImageResource(i7);
            return;
        }
        t1 t1Var = this.A;
        if (t1Var != null) {
            z5 = (t1Var.Z() && this.S.f3778a == 1.0f) ? false : false;
            ImageView imageView2 = this.P;
            if (z5) {
                i7 = C0382R.drawable.jz_click_pause_selector;
            }
            imageView2.setImageResource(i7);
        }
        this.T.setVisibility(4);
    }

    public void y1() {
        if (this.B == null || this.K.getVisibility() != 0) {
            return;
        }
        long e6 = this.B.e();
        if (e6 > 1) {
            runOnUiThread(new k(e6));
        }
    }
}
