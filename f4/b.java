package f4;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.secret.prettyhezi.Cache.g;
import com.secret.prettyhezi.Fc3zRvpgB;
import com.secret.prettyhezi.MainApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.NavigableSet;
import q2.o;
import r2.b;
import r2.c;
import r2.j;
import r2.m;
import r2.n;
import r2.r;
import r2.s;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static s f9896a;

    public static s a(Context context) {
        if (f9896a == null) {
            f9896a = new s(b(context), new r(Fc3zRvpgB.S0() * 1073741824), new z0.c(context));
        }
        return f9896a;
    }

    public static File b(Context context) {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        sb.append(str);
        sb.append(context.getFilesDir().getAbsolutePath());
        sb.append(str);
        sb.append("hlsCache");
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean c(String str, Context context) {
        s a6 = a(context);
        n d6 = a6.d(str);
        if (d6 == null) {
            return false;
        }
        long a7 = m.a(d6);
        long j6 = 0;
        if (a7 <= 0) {
            return false;
        }
        Log.e("isCached", str + " contentLen:  " + a7);
        NavigableSet<j> n5 = a6.n(str);
        if (n5 == null || n5.size() == 0) {
            return false;
        }
        for (j jVar : n5) {
            j6 += jVar.f12976c;
        }
        Log.e("isCached", str + " contentLen:  " + a7 + "  cached: " + j6);
        return j6 == a7;
    }

    public static long d(String str, OutputStream outputStream) {
        s a6 = a(MainApplication.f6711r);
        r2.c a7 = new c.C0212c().d(a6).g(new b1.b(g.DownloadClient(), "ExoplayerDownload")).f(new b.C0211b().c(a6).b(1048576).d(Long.MAX_VALUE)).a();
        try {
            try {
                long b6 = a7.b(new o(Uri.parse(str)));
                if (b6 < 0) {
                    return -1L;
                }
                byte[] bArr = new byte[20480];
                while (true) {
                    int read = a7.read(bArr, 0, 20480);
                    if (read == -1) {
                        a7.close();
                        outputStream.close();
                        return b6;
                    }
                    outputStream.write(bArr, 0, read);
                }
            } catch (Exception unused) {
                return -1L;
            }
        } catch (Exception unused2) {
            outputStream.close();
            return -1L;
        }
    }

    public static long e(String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
        try {
            return d(str, new FileOutputStream(str2));
        } catch (Exception unused) {
            return -1L;
        }
    }
}
