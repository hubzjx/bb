package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;
/* loaded from: classes.dex */
abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static Field f403a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f404b;

    /* renamed from: c  reason: collision with root package name */
    private static Class f405c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f406d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f407e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f408f;

    /* renamed from: g  reason: collision with root package name */
    private static Field f409g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f410h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Resources resources) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 28) {
            return;
        }
        if (i6 >= 24) {
            d(resources);
        } else if (i6 >= 23) {
            c(resources);
        } else {
            b(resources);
        }
    }

    private static void b(Resources resources) {
        Map map;
        if (!f404b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f403a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e6) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e6);
            }
            f404b = true;
        }
        Field field = f403a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e7) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e7);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void c(Resources resources) {
        Object obj;
        if (!f404b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f403a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e6) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e6);
            }
            f404b = true;
        }
        Field field = f403a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e7) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e7);
            }
            if (obj != null) {
                return;
            }
            e(obj);
            return;
        }
        obj = null;
        if (obj != null) {
        }
    }

    private static void d(Resources resources) {
        Object obj;
        if (!f410h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f409g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e6) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e6);
            }
            f410h = true;
        }
        Field field = f409g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e7) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e7);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f404b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f403a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e8);
            }
            f404b = true;
        }
        Field field2 = f403a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e9) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e9);
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    private static void e(Object obj) {
        LongSparseArray longSparseArray;
        if (!f406d) {
            try {
                f405c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e6) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e6);
            }
            f406d = true;
        }
        Class cls = f405c;
        if (cls == null) {
            return;
        }
        if (!f408f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f407e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e7) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e7);
            }
            f408f = true;
        }
        Field field = f407e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e8) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e8);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
