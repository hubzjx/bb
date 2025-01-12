package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static Field f1666a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1667b;

    public static Drawable a(CompoundButton compoundButton) {
        Drawable buttonDrawable;
        if (Build.VERSION.SDK_INT >= 23) {
            buttonDrawable = compoundButton.getButtonDrawable();
            return buttonDrawable;
        }
        if (!f1667b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f1666a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e6) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e6);
            }
            f1667b = true;
        }
        Field field = f1666a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e7) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e7);
                f1666a = null;
            }
        }
        return null;
    }

    public static ColorStateList b(CompoundButton compoundButton) {
        return compoundButton.getButtonTintList();
    }

    public static void c(CompoundButton compoundButton, ColorStateList colorStateList) {
        compoundButton.setButtonTintList(colorStateList);
    }

    public static void d(CompoundButton compoundButton, PorterDuff.Mode mode) {
        compoundButton.setButtonTintMode(mode);
    }
}
