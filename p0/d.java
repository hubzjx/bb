package p0;

import android.content.Context;
import android.hardware.SensorManager;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class d {

    /* loaded from: classes.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final d f12607a = new d();
    }

    private d() {
    }

    private String a(String str) {
        String b6 = p0.b.c().b(str);
        if (TextUtils.isEmpty(b6)) {
            return null;
        }
        return b6;
    }

    public static final d b() {
        return b.f12607a;
    }

    private int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return str.split("package:").length;
    }

    public boolean d(Context context, c cVar) {
        if (context != null) {
            String a6 = a("gsm.version.baseband");
            int i6 = (a6 == null || a6.contains("1.0.0.0")) ? 1 : 0;
            String a7 = a("ro.build.flavor");
            if (a7 != null && (a7.contains("vbox") || a7.contains("sdk_gphone"))) {
                i6++;
            }
            String a8 = a("ro.product.board");
            if (a8 != null && (a8.contains("android") | a8.contains("goldfish"))) {
                i6++;
            }
            String a9 = a("ro.board.platform");
            if (a9 == null || a9.contains("android")) {
                i6++;
            }
            String a10 = a("ro.hardware");
            if (a10 == null) {
                i6++;
            } else if (a10.toLowerCase().contains("ttvm") || a10.toLowerCase().contains("nox")) {
                i6 += 10;
            }
            boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
            if (!hasSystemFeature) {
                i6++;
            }
            String str = hasSystemFeature ? "support CameraFlash" : "unsupport CameraFlash";
            int size = ((SensorManager) context.getSystemService("sensor")).getSensorList(-1).size();
            if (size < 7) {
                i6++;
            }
            String str2 = "sensorNum" + size;
            int c6 = c(p0.b.c().a("pm list package -3"));
            if (c6 < 5) {
                i6++;
            }
            String str3 = "userAppNum" + c6;
            String a11 = p0.b.c().a("cat /proc/self/cgroup");
            if (a11 == null) {
                i6++;
            }
            if (cVar != null) {
                StringBuffer stringBuffer = new StringBuffer("ceshi start|");
                stringBuffer.append(a6);
                stringBuffer.append("|");
                stringBuffer.append(a7);
                stringBuffer.append("|");
                stringBuffer.append(a8);
                stringBuffer.append("|");
                stringBuffer.append(a9);
                stringBuffer.append("|");
                stringBuffer.append(a10);
                stringBuffer.append("|");
                stringBuffer.append(str);
                stringBuffer.append("|");
                stringBuffer.append(str2);
                stringBuffer.append("|");
                stringBuffer.append(str3);
                stringBuffer.append("|");
                stringBuffer.append(a11);
                stringBuffer.append("|end");
                cVar.a(stringBuffer.toString());
            }
            return i6 > 3;
        }
        throw new IllegalArgumentException("context must not be null");
    }
}
