package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    private static Method f1669a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1670b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f1671c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f1672d;

    public static void a(PopupWindow popupWindow, boolean z5) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z5);
            return;
        }
        if (!f1672d) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f1671c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e6) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e6);
            }
            f1672d = true;
        }
        Field field = f1671c;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z5));
            } catch (IllegalAccessException e7) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e7);
            }
        }
    }

    public static void b(PopupWindow popupWindow, int i6) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i6);
            return;
        }
        if (!f1670b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f1669a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f1670b = true;
        }
        Method method = f1669a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i6));
            } catch (Exception unused2) {
            }
        }
    }

    public static void c(PopupWindow popupWindow, View view, int i6, int i7, int i8) {
        popupWindow.showAsDropDown(view, i6, i7, i8);
    }
}
