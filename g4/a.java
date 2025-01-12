package g4;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.FileProvider;
import com.secret.prettyhezi.MainApplication;
import com.secret.prettyhezi.Server.g;
import com.secret.prettyhezi.Server.x;
import com.secret.prettyhezi.ZZcINlcxH;
import com.secret.prettyhezi.controls.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f10482a;

    /* renamed from: b  reason: collision with root package name */
    static ArrayList f10483b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    static com.secret.prettyhezi.controls.g f10484c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0170a implements g.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f10485a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g.c f10486b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f10487c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f10488d;

        C0170a(ZZcINlcxH zZcINlcxH, g.c cVar, String str, String str2) {
            this.f10485a = zZcINlcxH;
            this.f10486b = cVar;
            this.f10487c = str;
            this.f10488d = str2;
        }

        @Override // com.secret.prettyhezi.controls.g.c
        public void a() {
            this.f10485a.j(a.f10484c);
            a.f10483b.remove(this.f10487c);
            if (a.f10483b.size() == 0) {
                this.f10486b.a();
            } else {
                a.e(this.f10485a, (String) a.f10483b.get(0), this.f10488d, this.f10486b);
            }
        }

        @Override // com.secret.prettyhezi.controls.g.c
        public void b() {
            this.f10485a.j(a.f10484c);
            this.f10486b.b();
        }
    }

    /* loaded from: classes.dex */
    class b implements g.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10489a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ZZcINlcxH f10490b;

        b(String str, ZZcINlcxH zZcINlcxH) {
            this.f10489a = str;
            this.f10490b = zZcINlcxH;
        }

        @Override // com.secret.prettyhezi.controls.g.c
        public void a() {
            this.f10490b.y("Failed to download");
            this.f10490b.finish();
        }

        @Override // com.secret.prettyhezi.controls.g.c
        public void b() {
            a.b(this.f10489a);
        }
    }

    public static void a(ZZcINlcxH zZcINlcxH, String str, g.c cVar) {
        String latestApk = com.secret.prettyhezi.Server.g.latestApk();
        x n5 = MainApplication.f6711r.n(6);
        String substring = latestApk.substring(latestApk.indexOf("/", latestApk.startsWith("http") ? latestApk.indexOf("//") + 2 : 0));
        g.b bVar = n5.f7141d;
        if (bVar != null) {
            String str2 = bVar.api_url;
            if (!str2.startsWith("http")) {
                str2 = "http://" + str2;
            }
            f10483b.add(str2 + substring);
        }
        Iterator it = n5.f7139b.iterator();
        while (it.hasNext()) {
            String str3 = ((g.b) it.next()).api_url;
            if (!str3.startsWith("http")) {
                str3 = "http://" + str3;
            }
            String str4 = str3 + substring;
            if (!f10483b.contains(str4)) {
                f10483b.add(str4);
            }
        }
        e(zZcINlcxH, (String) f10483b.get(0), str, cVar);
    }

    public static void b(String str) {
        Uri fromFile;
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            fromFile = FileProvider.e(i.j(), "com.secret.prettyhezi.fileprovider", new File(str));
            intent.addFlags(1);
        } else {
            fromFile = Uri.fromFile(new File(str));
        }
        intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
        i.j().startActivity(intent);
    }

    public static String c() {
        String str = f10482a;
        if (str == null) {
            try {
                PackageInfo packageInfo = i.j() != null ? i.j().getPackageManager().getPackageInfo(i.j().getPackageName(), 0) : null;
                if (packageInfo != null) {
                    String str2 = packageInfo.versionName;
                    f10482a = str2;
                    return str2;
                }
            } catch (Exception unused) {
            }
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return str;
    }

    public static void d(ZZcINlcxH zZcINlcxH) {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("download");
        String sb2 = sb.toString();
        File file = new File(sb2);
        if (!file.exists()) {
            file.mkdir();
        }
        String str2 = sb2 + str + "beauty_box_latest.apk";
        a(zZcINlcxH, str2, new b(str2, zZcINlcxH));
    }

    static void e(ZZcINlcxH zZcINlcxH, String str, String str2, g.c cVar) {
        com.secret.prettyhezi.controls.g gVar = new com.secret.prettyhezi.controls.g(zZcINlcxH, str, str2, new C0170a(zZcINlcxH, cVar, str, str2));
        f10484c = gVar;
        zZcINlcxH.x(gVar, null, false);
    }
}
