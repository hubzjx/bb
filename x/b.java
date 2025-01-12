package x;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static Method f14143a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f14144b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f14145c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f14146d;

    public static void a(Drawable drawable, Resources.Theme theme) {
        drawable.applyTheme(theme);
    }

    public static boolean b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static void c(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        Drawable b6;
        int i6 = Build.VERSION.SDK_INT;
        drawable.clearColorFilter();
        if (i6 >= 23) {
            return;
        }
        if (drawable instanceof InsetDrawable) {
            b6 = ((InsetDrawable) drawable).getDrawable();
        } else if (!(drawable instanceof f)) {
            if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
                return;
            }
            int childCount = drawableContainerState.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                Drawable child = drawableContainerState.getChild(i7);
                if (child != null) {
                    c(child);
                }
            }
            return;
        } else {
            b6 = ((f) drawable).b();
        }
        c(b6);
    }

    public static int d(Drawable drawable) {
        return drawable.getAlpha();
    }

    public static ColorFilter e(Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static int f(Drawable drawable) {
        int layoutDirection;
        if (Build.VERSION.SDK_INT >= 23) {
            layoutDirection = drawable.getLayoutDirection();
            return layoutDirection;
        }
        if (!f14146d) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f14145c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e6) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e6);
            }
            f14146d = true;
        }
        Method method = f14145c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e7) {
                Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e7);
                f14145c = null;
            }
        }
        return 0;
    }

    public static void g(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean h(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static void i(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(Drawable drawable, boolean z5) {
        drawable.setAutoMirrored(z5);
    }

    public static void k(Drawable drawable, float f6, float f7) {
        drawable.setHotspot(f6, f7);
    }

    public static void l(Drawable drawable, int i6, int i7, int i8, int i9) {
        drawable.setHotspotBounds(i6, i7, i8, i9);
    }

    public static boolean m(Drawable drawable, int i6) {
        boolean layoutDirection;
        if (Build.VERSION.SDK_INT >= 23) {
            layoutDirection = drawable.setLayoutDirection(i6);
            return layoutDirection;
        }
        if (!f14144b) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f14143a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e6) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e6);
            }
            f14144b = true;
        }
        Method method = f14143a;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i6));
                return true;
            } catch (Exception e7) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e7);
                f14143a = null;
            }
        }
        return false;
    }

    public static void n(Drawable drawable, int i6) {
        drawable.setTint(i6);
    }

    public static void o(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void p(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }

    public static Drawable q(Drawable drawable) {
        return drawable instanceof f ? ((f) drawable).b() : drawable;
    }

    public static Drawable r(Drawable drawable) {
        return (Build.VERSION.SDK_INT < 23 && !(drawable instanceof e)) ? new h(drawable) : drawable;
    }
}
