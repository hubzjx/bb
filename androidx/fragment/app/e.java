package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final l.g f1777a = new l.g();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class c(ClassLoader classLoader, String str) {
        l.g gVar = f1777a;
        Class cls = (Class) gVar.get(str);
        if (cls == null) {
            Class<?> cls2 = Class.forName(str, false, classLoader);
            gVar.put(str, cls2);
            return cls2;
        }
        return cls;
    }

    public static Class d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e6) {
            throw new Fragment.e("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e6);
        } catch (ClassNotFoundException e7) {
            throw new Fragment.e("Unable to instantiate fragment " + str + ": make sure class name exists", e7);
        }
    }

    public Fragment a(ClassLoader classLoader, String str) {
        try {
            return (Fragment) d(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e6) {
            throw new Fragment.e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e6);
        } catch (InstantiationException e7) {
            throw new Fragment.e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e7);
        } catch (NoSuchMethodException e8) {
            throw new Fragment.e("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e8);
        } catch (InvocationTargetException e9) {
            throw new Fragment.e("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e9);
        }
    }
}
