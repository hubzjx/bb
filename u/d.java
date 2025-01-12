package u;

import android.content.Context;
import android.os.Process;
import t.e;
/* loaded from: classes.dex */
public abstract class d {
    public static int a(Context context, String str, int i6, int i7, String str2) {
        if (context.checkPermission(str, i6, i7) == -1) {
            return -1;
        }
        String b6 = e.b(str);
        if (b6 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i7);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return e.a(context, b6, str2) != 0 ? -2 : 0;
    }

    public static int b(Context context, String str) {
        return a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
