package g4;

import android.util.Log;
import g4.c;
import java.io.File;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f10491c;

    /* renamed from: d  reason: collision with root package name */
    static long f10492d;

    /* renamed from: a  reason: collision with root package name */
    String f10493a;

    /* renamed from: b  reason: collision with root package name */
    public Object f10494b = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f10495a;

        a(long j6) {
            this.f10495a = j6;
        }

        @Override // g4.c.a
        public boolean a(File file) {
            return file.lastModified() <= this.f10495a;
        }
    }

    public b(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        this.f10493a = str;
    }

    public static void b() {
        if (System.currentTimeMillis() - f10492d > 18000000) {
            f10492d = System.currentTimeMillis();
            long f6 = f(g().h());
            Log.e("cacheSize", f6 + HttpUrl.FRAGMENT_ENCODE_SET);
            if (f6 > 204800000) {
                c(10.0f);
            }
        }
    }

    public static void c(float f6) {
        c.j(g().h(), new a(System.currentTimeMillis() - (f6 * 8.64E7f)));
    }

    private String e(String str) {
        return this.f10493a + str.replaceAll("[^\\w]", HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public static long f(String str) {
        return c.d(str);
    }

    public static b g() {
        if (f10491c == null) {
            String str = i.j().getFilesDir().getAbsolutePath() + "/defaultcache";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            f10491c = new b(str);
        }
        return f10491c;
    }

    public String a(String str, String str2, boolean z5) {
        String e6;
        synchronized (this.f10494b) {
            e6 = e(str);
            if (z5) {
                c.i(str2, e6);
            } else {
                c.b(str2, e6);
            }
        }
        return e6;
    }

    public String d(String str) {
        String e6 = e(str);
        if (c.e(e6)) {
            try {
                new File(e6).setLastModified(System.currentTimeMillis());
            } catch (Exception unused) {
            }
            return e6;
        }
        return null;
    }

    public String h() {
        return this.f10493a;
    }
}
