package com.secret.prettyhezi;

import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static f f8522a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f8523b = true;

    /* renamed from: c  reason: collision with root package name */
    static OkHttpClient f8524c = j();

    /* renamed from: d  reason: collision with root package name */
    public static final MediaType f8525d = MediaType.parse("application/json; charset=utf-8");

    /* renamed from: e  reason: collision with root package name */
    public static OkHttpClient f8526e = k(2000, 3000);

    /* renamed from: f  reason: collision with root package name */
    static OkHttpClient[] f8527f = new OkHttpClient[4];

    /* renamed from: g  reason: collision with root package name */
    static int f8528g = 0;

    /* renamed from: h  reason: collision with root package name */
    static OkHttpClient f8529h = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements X509TrustManager {
        a() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements HostnameVerifier {
        b() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f8530a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f8531b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8532c;

        c(String str, e eVar, int i6) {
            this.f8530a = str;
            this.f8531b = eVar;
            this.f8532c = i6;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            MainApplication.f6711r.v(0, this.f8530a);
            j.f8523b = false;
            this.f8531b.a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            j.f8523b = true;
            if (response.isSuccessful()) {
                try {
                    this.f8531b.c(this.f8532c > 0 ? g4.e.b(com.secret.prettyhezi.Server.e.b(response.body().bytes(), this.f8532c)) : response.body().string());
                    return;
                } catch (Exception unused) {
                    this.f8531b.b(0);
                    return;
                }
            }
            int code = response.code();
            MainApplication.f6711r.v(code, this.f8530a);
            this.f8531b.b(code);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f8533a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f8534b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8535c;

        d(String str, e eVar, int i6) {
            this.f8533a = str;
            this.f8534b = eVar;
            this.f8535c = i6;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            j.f8523b = false;
            MainApplication.f6711r.v(0, this.f8533a);
            this.f8534b.a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            j.f8523b = true;
            if (response.code() == 200) {
                try {
                    this.f8534b.c(this.f8535c > 0 ? g4.e.b(com.secret.prettyhezi.Server.e.b(response.body().bytes(), this.f8535c)) : response.body().string());
                    return;
                } catch (Exception unused) {
                    this.f8534b.b(0);
                    return;
                }
            }
            int code = response.code();
            MainApplication.f6711r.v(code, this.f8533a);
            this.f8534b.b(code);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {
        public void a(IOException iOException) {
        }

        public void b(int i6) {
        }

        public abstract void c(String str);
    }

    /* loaded from: classes.dex */
    public static class f implements Dns {

        /* renamed from: a  reason: collision with root package name */
        private static final Dns f8536a = Dns.SYSTEM;

        @Override // okhttp3.Dns
        public List lookup(String str) {
            List d6 = com.secret.prettyhezi.Server.i.d(str);
            return d6 != null ? d6 : f8536a.lookup(str);
        }
    }

    public static long a(String str) {
        return b(f8526e, str);
    }

    public static long b(OkHttpClient okHttpClient, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Response execute = okHttpClient.newCall(v(new Request.Builder().url(str).cacheControl(CacheControl.FORCE_NETWORK).get()).build()).execute();
            long currentTimeMillis2 = execute.code() == 200 ? System.currentTimeMillis() - currentTimeMillis : -1L;
            execute.close();
            return currentTimeMillis2;
        } catch (Exception e6) {
            e6.printStackTrace();
            return -1L;
        }
    }

    public static f c() {
        if (f8522a == null) {
            f8522a = new f();
        }
        return f8522a;
    }

    public static OkHttpClient d() {
        int i6 = f8528g + 1;
        f8528g = i6;
        int i7 = i6 % 4;
        if (i6 > 9999) {
            f8528g = 0;
        }
        OkHttpClient[] okHttpClientArr = f8527f;
        if (okHttpClientArr[i7] == null) {
            okHttpClientArr[i7] = l(3000, 60000, true);
        }
        return f8527f[i7];
    }

    public static int e(String str, String str2) {
        return f(d(), str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0068, code lost:
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006b, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int f(OkHttpClient okHttpClient, String str, String str2) {
        Response execute;
        int i6 = -1;
        int i7 = 0;
        while (true) {
            try {
                execute = okHttpClient.newCall(v(new Request.Builder().url(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).cacheControl(CacheControl.FORCE_NETWORK).get()).build()).execute();
                i6 = execute.code();
                if (i6 == 200) {
                    FileOutputStream fileOutputStream = new FileOutputStream(str2);
                    fileOutputStream.write(execute.body().bytes());
                    fileOutputStream.close();
                    execute.close();
                    return i6;
                } else if (i6 / 100 != 3 || i7 >= 3) {
                    break;
                } else {
                    i7++;
                    String header = execute.header("Location", HttpUrl.FRAGMENT_ENCODE_SET);
                    if (header == null || header.isEmpty()) {
                        break;
                    }
                    execute.close();
                    str = header;
                }
            } catch (Exception e6) {
                if (e6 instanceof SocketTimeoutException) {
                    return 408;
                }
                return i6;
            }
        }
        execute.close();
        return i6;
    }

    static OkHttpClient g() {
        if (f8529h == null) {
            f8529h = k(3000, 4000);
        }
        return f8529h;
    }

    public static int h(String str) {
        return i(g(), str);
    }

    public static int i(OkHttpClient okHttpClient, String str) {
        try {
            Response execute = okHttpClient.newCall(v(new Request.Builder().url(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).cacheControl(CacheControl.FORCE_NETWORK).get()).build()).execute();
            int code = execute.code();
            execute.close();
            return code;
        } catch (Exception e6) {
            return e6 instanceof SocketTimeoutException ? 408 : 0;
        }
    }

    public static OkHttpClient j() {
        return k(3000, 60000);
    }

    public static OkHttpClient k(int i6, int i7) {
        return l(i6, i7, true);
    }

    public static OkHttpClient l(int i6, int i7, boolean z5) {
        try {
            SSLContext.getInstance("SSL").init(null, new TrustManager[]{new a()}, new SecureRandom());
        } catch (KeyManagementException | NoSuchAlgorithmException e6) {
            e6.printStackTrace();
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long j6 = i7;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient build = builder.readTimeout(j6, timeUnit).connectTimeout(i6, timeUnit).writeTimeout(j6, timeUnit).cache(null).hostnameVerifier(new b()).build();
        return z5 ? build.newBuilder().dns(c()).build() : build;
    }

    public static void m(String str, e eVar) {
        q(str, MainApplication.e(), 1, eVar);
    }

    public static void n(String str, String str2, e eVar) {
        q(str, str2, 1, eVar);
    }

    public static void o(String str, boolean z5, e eVar) {
        q(str, z5 ? MainApplication.e() : null, 1, eVar);
    }

    public static void p(String str, e eVar) {
        q(str, null, 0, eVar);
    }

    public static void q(String str, String str2, int i6, e eVar) {
        Request.Builder cacheControl = new Request.Builder().url(str).cacheControl(CacheControl.FORCE_NETWORK);
        if (str2 != null && str2.length() > 0) {
            cacheControl = cacheControl.addHeader("Authorization", "Bearer " + str2);
        }
        f8524c.newCall(v(cacheControl).build()).enqueue(new c(str, eVar, i6));
    }

    public static void r(String str, Object obj, boolean z5, e eVar) {
        u(str, com.secret.prettyhezi.f.e(obj), z5, 1, eVar);
    }

    public static void s(String str, String str2, boolean z5, e eVar) {
        u(str, str2, z5, 1, eVar);
    }

    public static void t(String str, String str2, String str3, int i6, e eVar) {
        RequestBody create;
        if (i6 <= 0) {
            create = RequestBody.create(f8525d, str2);
        } else if (str.startsWith(com.secret.prettyhezi.Server.v.f7133b)) {
            try {
                create = RequestBody.create(f8525d, com.secret.prettyhezi.Server.e.e(g4.e.a(str2), i6));
            } catch (Exception unused) {
                create = null;
            }
        } else {
            create = RequestBody.create(f8525d, com.secret.prettyhezi.Server.e.c(str2, i6));
        }
        Request.Builder post = new Request.Builder().url(str).cacheControl(CacheControl.FORCE_NETWORK).post(create);
        if (str3 != null && str3.length() > 0) {
            post = post.addHeader("Authorization", "Bearer " + str3);
        }
        f8524c.newCall(v(post).build()).enqueue(new d(str, eVar, i6));
    }

    public static void u(String str, String str2, boolean z5, int i6, e eVar) {
        t(str, str2, z5 ? MainApplication.e() : null, i6, eVar);
    }

    public static Request.Builder v(Request.Builder builder) {
        Request.Builder addHeader = builder.addHeader("Device", Settings.Secure.getString(g4.i.j().getContentResolver(), "android_id")).addHeader("Os", g4.i.m());
        Request.Builder addHeader2 = addHeader.addHeader("Com", Build.MANUFACTURER + "(" + Build.MODEL + ")").addHeader("Ver", g4.a.c()).addHeader("Res", g4.i.j().p());
        String property = System.getProperty("http.agent");
        if (property == null) {
            property = "unknown";
        }
        return addHeader2.addHeader("User-Agent", property);
    }
}
