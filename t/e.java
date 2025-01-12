package t;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
/* loaded from: classes.dex */
public abstract class e {
    public static int a(Context context, String str, String str2) {
        Object systemService;
        int noteProxyOpNoThrow;
        if (Build.VERSION.SDK_INT >= 23) {
            systemService = context.getSystemService(AppOpsManager.class);
            noteProxyOpNoThrow = ((AppOpsManager) systemService).noteProxyOpNoThrow(str, str2);
            return noteProxyOpNoThrow;
        }
        return 1;
    }

    public static String b(String str) {
        String permissionToOp;
        if (Build.VERSION.SDK_INT >= 23) {
            permissionToOp = AppOpsManager.permissionToOp(str);
            return permissionToOp;
        }
        return null;
    }
}
