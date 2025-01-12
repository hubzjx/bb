package t;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
/* loaded from: classes.dex */
public abstract class j {
    public static Intent a(Activity activity) {
        Intent parentActivityIntent = activity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        String c6 = c(activity);
        if (c6 == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, c6);
        try {
            return d(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + c6 + "' in manifest");
            return null;
        }
    }

    public static Intent b(Context context, ComponentName componentName) {
        String d6 = d(context, componentName);
        if (d6 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), d6);
        return d(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String c(Activity activity) {
        try {
            return d(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    public static String d(Context context, ComponentName componentName) {
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i6 = Build.VERSION.SDK_INT;
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i6 >= 29 ? 269222528 : i6 >= 24 ? 787072 : 640);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) == '.') {
            return context.getPackageName() + string;
        }
        return string;
    }

    public static void e(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }

    public static boolean f(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }
}
