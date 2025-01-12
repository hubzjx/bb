package p0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f12603a = {"com.mumu.launcher", "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.bluestacks.appmart", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f12604b = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f12605c = {"/data/data/com.android.flysilkworm", "/data/data/com.bluestacks.filemanager"};

    private static List a(Context context) {
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            try {
                String[] strArr = f12603a;
                if (i7 >= strArr.length) {
                    break;
                }
                try {
                    context.getPackageManager().getPackageInfo(strArr[i7], 1);
                    arrayList.add(strArr[i7]);
                } catch (PackageManager.NameNotFoundException unused) {
                }
                i7++;
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        if (arrayList.size() == 0) {
            while (true) {
                String[] strArr2 = f12605c;
                if (i6 >= strArr2.length) {
                    break;
                }
                if (new File(strArr2[i6]).exists()) {
                    arrayList.add(strArr2[i6]);
                }
                i6++;
            }
        }
        return arrayList;
    }

    private static String b(List list) {
        if (list.size() == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String str = (String) list.get(0);
        if (str.contains("mumu")) {
            return "mumu";
        }
        if (str.contains("ami")) {
            return "AMIDuOS";
        }
        if (str.contains("bluestacks")) {
            return "蓝叠";
        }
        if (str.contains("kaopu001") || str.contains("tiantian")) {
            return "天天";
        }
        if (str.contains("kpzs")) {
            return "靠谱助手";
        }
        if (!str.contains("genymotion")) {
            return str.contains("uc") ? "uc" : str.contains("blue") ? "blue" : str.contains("microvirt") ? "逍遥" : str.contains("itools") ? "itools" : str.contains("syd") ? "手游岛" : str.contains("bignox") ? "夜神" : str.contains("haimawan") ? "海马玩" : str.contains("windroy") ? "windroy" : str.contains("flysilkworm") ? "雷电" : str.contains("emu") ? "emu" : str.contains("le8") ? "le8" : str.contains("vphone") ? "vphone" : str.contains("duoyi") ? "多益" : HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String str2 = Build.MODEL;
        return str2.contains("iTools") ? "iTools" : str2.contains("ChangWan") ? "畅玩" : "genymotion";
    }

    public static boolean c(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            String b6 = b(a(context));
            if (TextUtils.isEmpty(b6)) {
                List d6 = d(context);
                if (d6.size() > 0) {
                    arrayList.add(d6.get(0));
                }
            } else {
                arrayList.add(b6);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return !arrayList.isEmpty();
    }

    public static List d(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        for (int i6 = 0; i6 < queryIntentActivities.size(); i6++) {
            ActivityInfo activityInfo = queryIntentActivities.get(i6).activityInfo;
            String str = activityInfo.packageName;
            String str2 = activityInfo.name;
            activityInfo.loadLabel(context.getPackageManager());
            if (!TextUtils.isEmpty(str) && str.contains("bluestacks")) {
                arrayList.add("蓝叠");
                return arrayList;
            }
        }
        return arrayList;
    }
}
