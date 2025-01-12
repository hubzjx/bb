package com.secret.prettyhezi.Server;

import android.os.AsyncTask;
import android.util.Log;
import c.abc;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static OkHttpClient f7113a;

    /* renamed from: b  reason: collision with root package name */
    static HashMap f7114b;

    /* renamed from: c  reason: collision with root package name */
    static long f7115c;

    /* renamed from: d  reason: collision with root package name */
    static long f7116d;

    /* renamed from: e  reason: collision with root package name */
    static String[] f7117e = {"https://45.61.200.158:10053", "https://45.61.244.69:10053", "https://z555b.com:20053", "https://g333d.com:20053"};

    /* loaded from: classes.dex */
    public static class a implements Serializable {

        /* renamed from: n  reason: collision with root package name */
        public String f7118n;

        /* renamed from: r  reason: collision with root package name */
        public String[] f7119r;
    }

    /* loaded from: classes.dex */
    public static class b implements Serializable {

        /* renamed from: v  reason: collision with root package name */
        public String f7121v = "1.1";

        /* renamed from: k  reason: collision with root package name */
        public String f7120k = abc.c(6);
    }

    /* loaded from: classes.dex */
    public static class c implements Serializable {

        /* renamed from: s  reason: collision with root package name */
        public a[] f7122s;

        /* renamed from: t  reason: collision with root package name */
        public long f7123t;
    }

    /* loaded from: classes.dex */
    public static class d extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        com.secret.prettyhezi.e f7124a;

        /* renamed from: b  reason: collision with root package name */
        int f7125b;

        public d(com.secret.prettyhezi.e eVar) {
            this.f7124a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            this.f7125b = i.c() ? 200 : 0;
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r22) {
            com.secret.prettyhezi.e eVar = this.f7124a;
            if (eVar != null) {
                eVar.a(this.f7125b);
            }
        }
    }

    public static OkHttpClient a() {
        if (f7113a == null) {
            f7113a = com.secret.prettyhezi.j.l(2000, 3000, false);
        }
        return f7113a;
    }

    public static void b(com.secret.prettyhezi.e eVar) {
        f7116d = System.currentTimeMillis();
        new d(eVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static boolean c() {
        for (int i6 = 0; i6 < f7117e.length; i6++) {
            if (f(f7117e[i6] + "/query?v=1.2")) {
                if (i6 != 0) {
                    String[] strArr = f7117e;
                    String str = strArr[0];
                    strArr[0] = strArr[i6];
                    strArr[i6] = str;
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public static List d(String str) {
        if (f7114b == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (f7115c < currentTimeMillis && f7116d + 2000 < currentTimeMillis) {
            b(null);
        }
        return (List) f7114b.get(str);
    }

    static void e(c cVar) {
        HashMap hashMap = new HashMap();
        int i6 = 0;
        while (true) {
            a[] aVarArr = cVar.f7122s;
            if (i6 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i6];
            ArrayList arrayList = new ArrayList();
            int i7 = 0;
            while (true) {
                String[] strArr = aVar.f7119r;
                if (i7 >= strArr.length) {
                    break;
                }
                String[] split = strArr[i7].split("\\.");
                byte[] bArr = new byte[split.length];
                for (int i8 = 0; i8 < split.length; i8++) {
                    bArr[i8] = (byte) Integer.parseInt(split[i8]);
                }
                try {
                    arrayList.add(InetAddress.getByAddress(bArr));
                } catch (Exception e6) {
                    Log.e("OnIpAddress", e6.getMessage());
                }
                i7++;
            }
            if (!arrayList.isEmpty()) {
                hashMap.put(aVar.f7118n, arrayList);
            }
            i6++;
        }
        if (hashMap.isEmpty()) {
            return;
        }
        f7114b = hashMap;
        f7115c = (cVar.f7123t * 1000) + System.currentTimeMillis();
    }

    public static boolean f(String str) {
        try {
            Response execute = a().newCall(com.secret.prettyhezi.j.v(new Request.Builder().url(str).cacheControl(CacheControl.FORCE_NETWORK).post(RequestBody.create(com.secret.prettyhezi.j.f8525d, e.c(com.secret.prettyhezi.f.e(new b()), 5)))).build()).execute();
            if (execute.code() != 200) {
                execute.close();
                return false;
            }
            e((c) com.secret.prettyhezi.f.d(new String(e.b(execute.body().bytes(), 5)), c.class));
            execute.close();
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }
}
