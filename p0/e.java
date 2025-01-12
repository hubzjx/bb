package p0;

import android.content.Context;
import java.io.File;
/* loaded from: classes.dex */
public class e {

    /* loaded from: classes.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final e f12608a = new e();
    }

    private e() {
    }

    public static final e b() {
        return b.f12608a;
    }

    private int c() {
        String b6 = p0.b.c().b("ro.secure");
        return (b6 != null && "0".equals(b6)) ? 0 : 1;
    }

    private boolean e() {
        String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        for (int i6 = 0; i6 < 8; i6++) {
            if (new File(strArr[i6]).exists()) {
                return true;
            }
        }
        return false;
    }

    public boolean a(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public boolean d() {
        if (c() == 0) {
            return true;
        }
        return e();
    }

    public boolean f() {
        try {
            throw new Exception("gg");
        } catch (Exception e6) {
            for (StackTraceElement stackTraceElement : e6.getStackTrace()) {
                if (stackTraceElement.getClassName().contains("de.robv.android.xposed.XposedBridge")) {
                    return true;
                }
            }
            return false;
        }
    }
}
