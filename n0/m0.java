package n0;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
abstract class m0 {

    /* renamed from: a  reason: collision with root package name */
    private static Method f12139a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f12140b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f12141c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f12142d;

    private void b() {
        if (f12140b) {
            return;
        }
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
            f12139a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e6) {
            Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e6);
        }
        f12140b = true;
    }

    public abstract void a(View view);

    public abstract float c(View view);

    public abstract void d(View view);

    public void e(View view, int i6, int i7, int i8, int i9) {
        b();
        Method method = f12139a;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e6) {
                throw new RuntimeException(e6.getCause());
            }
        }
    }

    public abstract void f(View view, float f6);

    public void g(View view, int i6) {
        if (!f12142d) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f12141c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f12142d = true;
        }
        Field field = f12141c;
        if (field != null) {
            try {
                f12141c.setInt(view, i6 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract void h(View view, Matrix matrix);

    public abstract void i(View view, Matrix matrix);
}
