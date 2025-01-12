package e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.t1;
import java.util.WeakHashMap;
import u.c;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal f9233a = new ThreadLocal();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap f9234b = new WeakHashMap(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f9235c = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f9236a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f9237b;

        a(ColorStateList colorStateList, Configuration configuration) {
            this.f9236a = colorStateList;
            this.f9237b = configuration;
        }
    }

    private static void a(Context context, int i6, ColorStateList colorStateList) {
        synchronized (f9235c) {
            WeakHashMap weakHashMap = f9234b;
            SparseArray sparseArray = (SparseArray) weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(i6, new a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static ColorStateList b(Context context, int i6) {
        a aVar;
        synchronized (f9235c) {
            SparseArray sparseArray = (SparseArray) f9234b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (aVar = (a) sparseArray.get(i6)) != null) {
                if (aVar.f9237b.equals(context.getResources().getConfiguration())) {
                    return aVar.f9236a;
                }
                sparseArray.remove(i6);
            }
            return null;
        }
    }

    public static ColorStateList c(Context context, int i6) {
        ColorStateList colorStateList;
        if (Build.VERSION.SDK_INT >= 23) {
            colorStateList = context.getColorStateList(i6);
            return colorStateList;
        }
        ColorStateList b6 = b(context, i6);
        if (b6 != null) {
            return b6;
        }
        ColorStateList f6 = f(context, i6);
        if (f6 != null) {
            a(context, i6, f6);
            return f6;
        }
        return c.b(context, i6);
    }

    public static Drawable d(Context context, int i6) {
        return t1.h().j(context, i6);
    }

    private static TypedValue e() {
        ThreadLocal threadLocal = f9233a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    private static ColorStateList f(Context context, int i6) {
        if (g(context, i6)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return v.a.a(resources, resources.getXml(i6), context.getTheme());
        } catch (Exception e6) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e6);
            return null;
        }
    }

    private static boolean g(Context context, int i6) {
        Resources resources = context.getResources();
        TypedValue e6 = e();
        resources.getValue(i6, e6, true);
        int i7 = e6.type;
        return i7 >= 28 && i7 <= 31;
    }
}
