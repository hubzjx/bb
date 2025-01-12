package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private static Map f1997a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map f1998b = new HashMap();

    private static b a(Constructor constructor, Object obj) {
        try {
            android.support.v4.media.a.a(constructor.newInstance(obj));
            return null;
        } catch (IllegalAccessException e6) {
            throw new RuntimeException(e6);
        } catch (InstantiationException e7) {
            throw new RuntimeException(e7);
        } catch (InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Constructor b(Class cls) {
        try {
            Package r02 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r02 != null ? r02.getName() : HttpUrl.FRAGMENT_ENCODE_SET;
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String c6 = c(canonicalName);
            if (!name.isEmpty()) {
                c6 = name + "." + c6;
            }
            Constructor declaredConstructor = Class.forName(c6).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException(e6);
        }
    }

    public static String c(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    private static int d(Class cls) {
        Integer num = (Integer) f1997a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int g6 = g(cls);
        f1997a.put(cls, Integer.valueOf(g6));
        return g6;
    }

    private static boolean e(Class cls) {
        return cls != null && e.class.isAssignableFrom(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d f(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        Class<?> cls = obj.getClass();
        if (d(cls) == 2) {
            List list = (List) f1998b.get(cls);
            if (list.size() == 1) {
                a((Constructor) list.get(0), obj);
                return new SingleGeneratedAdapterObserver(null);
            }
            b[] bVarArr = new b[list.size()];
            for (int i6 = 0; i6 < list.size(); i6++) {
                a((Constructor) list.get(i6), obj);
                bVarArr[i6] = null;
            }
            return new CompositeGeneratedAdaptersObserver(bVarArr);
        }
        return new ReflectiveGenericLifecycleObserver(obj);
    }

    private static int g(Class cls) {
        ArrayList arrayList;
        Class<?>[] interfaces;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor b6 = b(cls);
        if (b6 != null) {
            f1998b.put(cls, Collections.singletonList(b6));
            return 2;
        } else if (a.f1978c.d(cls)) {
            return 1;
        } else {
            Class superclass = cls.getSuperclass();
            if (!e(superclass)) {
                arrayList = null;
            } else if (d(superclass) == 1) {
                return 1;
            } else {
                arrayList = new ArrayList((Collection) f1998b.get(superclass));
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (e(cls2)) {
                    if (d(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll((Collection) f1998b.get(cls2));
                }
            }
            if (arrayList != null) {
                f1998b.put(cls, arrayList);
                return 2;
            }
            return 1;
        }
    }
}
