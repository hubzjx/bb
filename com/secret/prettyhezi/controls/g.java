package com.secret.prettyhezi.controls;

import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.secret.prettyhezi.C0382R;
import com.secret.prettyhezi.ZZcINlcxH;
import java.io.FileOutputStream;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes.dex */
public class g extends w {

    /* renamed from: j  reason: collision with root package name */
    static OkHttpClient f8322j;

    /* renamed from: b  reason: collision with root package name */
    String f8323b;

    /* renamed from: c  reason: collision with root package name */
    c f8324c;

    /* renamed from: d  reason: collision with root package name */
    long f8325d;

    /* renamed from: e  reason: collision with root package name */
    long f8326e;

    /* renamed from: f  reason: collision with root package name */
    View f8327f;

    /* renamed from: g  reason: collision with root package name */
    TextView f8328g;

    /* renamed from: h  reason: collision with root package name */
    long f8329h;

    /* renamed from: i  reason: collision with root package name */
    LinearLayout.LayoutParams f8330i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            long j6 = gVar.f8325d;
            if (j6 > 0) {
                gVar.f8330i.width = (int) ((gVar.f8329h * gVar.f8326e) / j6);
                gVar.f8327f.requestLayout();
                g gVar2 = g.this;
                gVar2.f8328g.setText(String.format("%.2fM/%.2fM", Float.valueOf((((float) gVar2.f8326e) / 1024.0f) / 1024.0f), Float.valueOf((((float) g.this.f8325d) / 1024.0f) / 1024.0f)));
            }
            g gVar3 = g.this;
            long j7 = gVar3.f8326e;
            if (j7 < gVar3.f8325d || j7 == 0) {
                gVar3.c();
            }
        }
    }

    /* loaded from: classes.dex */
    private class b extends AsyncTask {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements e {
            a() {
            }

            @Override // com.secret.prettyhezi.controls.g.e
            public void a(String str, long j6, long j7, boolean z5) {
                g gVar = g.this;
                gVar.f8325d = j7;
                gVar.f8326e = j6;
            }
        }

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            return b(strArr[0]);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0089, code lost:
            r7.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x008c, code lost:
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        String b(String str) {
            Response execute;
            int i6 = 0;
            while (true) {
                try {
                    execute = g.b().newBuilder().addInterceptor(new d(new a())).build().newCall(new Request.Builder().url(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).cacheControl(CacheControl.FORCE_NETWORK).get().build()).execute();
                    int code = execute.code();
                    if (code == 200) {
                        FileOutputStream fileOutputStream = new FileOutputStream(g.this.f8323b);
                        fileOutputStream.write(execute.body().bytes());
                        fileOutputStream.close();
                        execute.close();
                        return g.this.f8323b;
                    } else if (code / 100 != 3 || i6 >= 3) {
                        break;
                    } else {
                        i6++;
                        String header = execute.header("Location", HttpUrl.FRAGMENT_ENCODE_SET);
                        if (header == null || header.isEmpty()) {
                            break;
                        }
                        execute.close();
                        str = header;
                    }
                } catch (Exception unused) {
                }
            }
            execute.close();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onPostExecute(String str) {
            if (str == null || str.length() <= 0) {
                g.this.f8324c.a();
                return;
            }
            g gVar = g.this;
            gVar.f8326e = gVar.f8325d;
            gVar.f8324c.b();
        }

        /* synthetic */ b(g gVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public class d implements Interceptor {

        /* renamed from: a  reason: collision with root package name */
        private e f8334a;

        public d(e eVar) {
            this.f8334a = eVar;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) {
            Response proceed = chain.proceed(chain.request());
            return proceed.newBuilder().body(new f(chain.request().url().url().toString(), proceed.body(), this.f8334a)).build();
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(String str, long j6, long j7, boolean z5);
    }

    /* loaded from: classes.dex */
    public class f extends ResponseBody {

        /* renamed from: a  reason: collision with root package name */
        private final ResponseBody f8336a;

        /* renamed from: b  reason: collision with root package name */
        private final e f8337b;

        /* renamed from: c  reason: collision with root package name */
        private BufferedSource f8338c;

        /* renamed from: d  reason: collision with root package name */
        private final String f8339d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends ForwardingSource {

            /* renamed from: a  reason: collision with root package name */
            long f8341a;

            a(Source source) {
                super(source);
                this.f8341a = 0L;
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j6) {
                long read = super.read(buffer, j6);
                int i6 = (read > (-1L) ? 1 : (read == (-1L) ? 0 : -1));
                this.f8341a += i6 != 0 ? read : 0L;
                f.this.f8337b.a(f.this.f8339d, this.f8341a, f.this.f8336a.contentLength(), i6 == 0);
                return read;
            }
        }

        f(String str, ResponseBody responseBody, e eVar) {
            this.f8336a = responseBody;
            this.f8337b = eVar;
            this.f8339d = str;
        }

        private Source d(Source source) {
            return new a(source);
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f8336a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f8336a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            if (this.f8338c == null) {
                this.f8338c = Okio.buffer(d(this.f8336a.source()));
            }
            return this.f8338c;
        }
    }

    public g(ZZcINlcxH zZcINlcxH, String str, String str2, c cVar) {
        super(zZcINlcxH);
        this.f8325d = 0L;
        this.f8326e = 0L;
        setOrientation(1);
        setGravity(1);
        this.f8323b = str2;
        this.f8324c = cVar;
        new b(this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str);
        setBackgroundColor(-1);
        View b6 = g4.d.b(zZcINlcxH, 16.0f, -16777216, zZcINlcxH.s0(C0382R.string.Downloading));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = g4.i.r(23.0f);
        layoutParams.bottomMargin = g4.i.r(0.0f);
        addView(b6, layoutParams);
        TextView c6 = g4.d.c(zZcINlcxH, 14, Color.parseColor("#333333"), HttpUrl.FRAGMENT_ENCODE_SET, 17);
        this.f8328g = c6;
        addView(c6, new LinearLayout.LayoutParams(-1, g4.i.r(40.0f)));
        LinearLayout linearLayout = new LinearLayout(zZcINlcxH);
        linearLayout.setBackground(ZZcINlcxH.f0(Color.parseColor("#cccccc"), 5.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, g4.i.r(10.0f));
        layoutParams2.topMargin = g4.i.r(10.0f);
        layoutParams2.bottomMargin = g4.i.r(35.0f);
        int r5 = g4.i.r(20.0f);
        layoutParams2.rightMargin = r5;
        layoutParams2.leftMargin = r5;
        addView(linearLayout, layoutParams2);
        this.f8329h = zZcINlcxH.o().x - g4.i.r(80.0f);
        View view = new View(zZcINlcxH);
        this.f8327f = view;
        view.setBackground(ZZcINlcxH.f0(Color.parseColor("#10caa5"), 5.0f));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, g4.i.r(10.0f));
        this.f8330i = layoutParams3;
        linearLayout.addView(this.f8327f, layoutParams3);
        c();
    }

    public static OkHttpClient b() {
        if (f8322j == null) {
            f8322j = com.secret.prettyhezi.j.l(2000, 3000, true);
        }
        return f8322j;
    }

    public void c() {
        postDelayed(new a(), 50L);
    }
}
