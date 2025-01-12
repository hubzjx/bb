package com.secret.prettyhezi.View;

import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.exoplayer2.h1;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.j1;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.w0;
import com.google.android.exoplayer2.y1;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.RcB8ALaRS;
import com.secret.prettyhezi.ZZcINlcxH;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.dnsoverhttps.DnsOverHttps;
import w1.y0;
/* loaded from: classes.dex */
public class c extends RelativeLayout {

    /* renamed from: p  reason: collision with root package name */
    static OkHttpClient f7869p;

    /* renamed from: b  reason: collision with root package name */
    ZZcINlcxH f7870b;

    /* renamed from: c  reason: collision with root package name */
    t1 f7871c;

    /* renamed from: d  reason: collision with root package name */
    boolean f7872d;

    /* renamed from: e  reason: collision with root package name */
    com.secret.prettyhezi.controls.z f7873e;

    /* renamed from: f  reason: collision with root package name */
    com.secret.prettyhezi.controls.z f7874f;

    /* renamed from: g  reason: collision with root package name */
    String f7875g;

    /* renamed from: h  reason: collision with root package name */
    String f7876h;

    /* renamed from: i  reason: collision with root package name */
    TextView f7877i;

    /* renamed from: j  reason: collision with root package name */
    TextView f7878j;

    /* renamed from: k  reason: collision with root package name */
    TextView f7879k;

    /* renamed from: l  reason: collision with root package name */
    SeekBar f7880l;

    /* renamed from: m  reason: collision with root package name */
    int f7881m;

    /* renamed from: n  reason: collision with root package name */
    long f7882n;

    /* renamed from: o  reason: collision with root package name */
    boolean f7883o;

    /* loaded from: classes.dex */
    class a extends g4.f {
        a() {
        }

        @Override // g4.f
        protected void a(View view) {
            c.this.f();
        }
    }

    /* loaded from: classes.dex */
    class b extends g4.f {
        b() {
        }

        @Override // g4.f
        protected void a(View view) {
            c.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.secret.prettyhezi.View.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0125c implements SeekBar.OnSeekBarChangeListener {
        C0125c() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i6, boolean z5) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            c cVar = c.this;
            if (cVar.f7882n <= 0) {
                cVar.f7882n = cVar.f7871c.Y();
            }
            c.this.f7871c.m((seekBar.getProgress() * c.this.f7882n) / 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements j1.a {
        d() {
        }

        @Override // com.google.android.exoplayer2.j1.a
        public /* synthetic */ void C(y1 y1Var, int i6) {
            i1.n(this, y1Var, i6);
        }

        @Override // com.google.android.exoplayer2.j1.a
        public void E(int i6) {
            if (i6 == 4) {
                c.this.d();
            }
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
        public /* synthetic */ void f(boolean z5, int i6) {
            i1.k(this, z5, i6);
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
            c.this.e(tVar);
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
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.i();
        }
    }

    public c(ZZcINlcxH zZcINlcxH, int i6) {
        super(zZcINlcxH);
        this.f7871c = null;
        this.f7872d = false;
        this.f7882n = 0L;
        this.f7883o = false;
        this.f7870b = zZcINlcxH;
        this.f7881m = i6;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4.i.r(50.0f), g4.i.r(50.0f));
        layoutParams.addRule(13, -1);
        this.f7873e = new com.secret.prettyhezi.controls.z(zZcINlcxH, C0382R.drawable.play_normal);
        this.f7874f = new com.secret.prettyhezi.controls.z(zZcINlcxH, C0382R.drawable.pause_normal);
        addView(this.f7873e, layoutParams);
        addView(this.f7874f, layoutParams);
        this.f7874f.setVisibility(8);
        this.f7874f.setOnClickListener(new a());
        this.f7873e.setOnClickListener(new b());
        this.f7878j = g4.d.c(zZcINlcxH, 14, -1, HttpUrl.FRAGMENT_ENCODE_SET, 5);
        this.f7879k = g4.d.c(zZcINlcxH, 14, -1, HttpUrl.FRAGMENT_ENCODE_SET, 3);
        this.f7877i = g4.d.c(zZcINlcxH, 18, -1, HttpUrl.FRAGMENT_ENCODE_SET, 1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = g4.i.r(10.0f);
        addView(this.f7877i, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(g4.i.r(40.0f), -2);
        layoutParams3.bottomMargin = g4.i.r(10.0f);
        layoutParams3.addRule(12, -1);
        addView(this.f7878j, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(g4.i.r(40.0f), -2);
        layoutParams4.bottomMargin = g4.i.r(10.0f);
        layoutParams4.addRule(12, -1);
        layoutParams4.addRule(11, -1);
        addView(this.f7879k, layoutParams4);
        c();
    }

    static OkHttpClient a() {
        if (f7869p == null) {
            f7869p = com.secret.prettyhezi.j.l(2000, 4000, true);
        }
        return f7869p;
    }

    public void b(String str, boolean z5) {
        this.f7872d = z5;
        this.f7882n = 0L;
        this.f7875g = str;
        this.f7876h = MainApplication.f6711r.s(str);
        h();
        ZZcINlcxH zZcINlcxH = this.f7870b;
        this.f7871c = new t1.b(zZcINlcxH, new com.google.android.exoplayer2.s(zZcINlcxH)).w(new q.a().b(new q2.p(true, DnsOverHttps.MAX_RESPONSE_SIZE)).c(10000, 40000, 2500, 6000).d(true).a()).u();
        w1.m mVar = new w1.m(Uri.parse(this.f7876h), new b1.b(a(), "ExoplayerDemo"), new c1.g(), null, null);
        this.f7871c.n0(mVar);
        this.f7871c.g0(mVar);
        this.f7871c.S(new d());
        this.f7877i.setVisibility(z5 ? 0 : 8);
    }

    void c() {
        this.f7880l = new SeekBar(this.f7870b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12, -1);
        int r5 = g4.i.r(40.0f);
        layoutParams.rightMargin = r5;
        layoutParams.leftMargin = r5;
        addView(this.f7880l, layoutParams);
        this.f7880l.setThumb(this.f7870b.getResources().getDrawable(C0382R.drawable.jz_bottom_seek_thumb));
        this.f7880l.setProgressDrawable(this.f7870b.getResources().getDrawable(C0382R.drawable.jz_bottom_seek_progress));
        this.f7880l.setPadding(g4.i.r(12.0f), g4.i.r(8.0f), g4.i.r(12.0f), g4.i.r(10.0f));
        this.f7880l.setMax(100);
        if (Build.VERSION.SDK_INT >= 29) {
            this.f7880l.setMinHeight(g4.i.r(1.0f));
            this.f7880l.setMaxHeight(g4.i.r(1.0f));
        }
        this.f7880l.setOnSeekBarChangeListener(new C0125c());
    }

    void d() {
        this.f7871c.p0(false);
        this.f7871c.m(0L);
        this.f7873e.setVisibility(0);
        this.f7874f.setVisibility(8);
        this.f7880l.setProgress(1);
    }

    void e(com.google.android.exoplayer2.t tVar) {
        MainApplication.f6711r.v(0, this.f7875g);
        w wVar = new w(this.f7870b, 7, this.f7881m, this.f7876h);
        wVar.a();
        addView(wVar, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void f() {
        t1 t1Var = this.f7871c;
        if (t1Var != null) {
            t1Var.p0(false);
        }
        this.f7873e.setVisibility(0);
        this.f7874f.setVisibility(8);
    }

    public void g() {
        this.f7871c.p0(true);
        this.f7873e.setVisibility(8);
        this.f7874f.setVisibility(0);
        j();
        if (this.f7872d) {
            ZZcINlcxH zZcINlcxH = this.f7870b;
            if (zZcINlcxH instanceof RcB8ALaRS) {
                ((RcB8ALaRS) zZcINlcxH).z1();
            }
        }
    }

    public void h() {
        if (this.f7871c != null) {
            f();
            this.f7871c.i0();
            this.f7871c = null;
        }
    }

    void i() {
        this.f7883o = false;
        t1 t1Var = this.f7871c;
        if (t1Var == null) {
            return;
        }
        if (this.f7882n <= 0) {
            long Y = t1Var.Y();
            this.f7882n = Y;
            if (Y < 0) {
                this.f7882n = 0L;
            }
        }
        long k6 = this.f7871c.k();
        long j6 = this.f7882n;
        if (j6 > 0) {
            long j7 = (j6 - k6) / 1000;
            TextView textView = this.f7877i;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f7872d ? "试听还剩：" : HttpUrl.FRAGMENT_ENCODE_SET);
            sb.append(j7);
            sb.append("秒");
            textView.setText(sb.toString());
            if (this.f7872d) {
                TextView textView2 = this.f7877i;
                textView2.setText("试听" + (this.f7882n / 1000) + "秒");
            }
        }
        TextView textView3 = this.f7878j;
        textView3.setText(HttpUrl.FRAGMENT_ENCODE_SET + (k6 / 1000));
        TextView textView4 = this.f7879k;
        textView4.setText(HttpUrl.FRAGMENT_ENCODE_SET + ((this.f7882n - k6) / 1000));
        long j8 = k6 * 100;
        long j9 = this.f7882n;
        if (j9 <= 0) {
            j9 = 1;
        }
        this.f7880l.setProgress((int) (j8 / j9));
        postDelayed(new e(), 1000L);
        this.f7883o = true;
    }

    void j() {
        if (this.f7883o) {
            return;
        }
        i();
    }
}
