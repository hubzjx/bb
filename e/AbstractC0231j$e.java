package e;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* renamed from: e.j$e  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0231j$e {

    /* renamed from: a  reason: collision with root package name */
    public static final Class f9286a;

    /* renamed from: b  reason: collision with root package name */
    static final Class f9287b;

    /* renamed from: c  reason: collision with root package name */
    private static final Field f9288c;

    /* renamed from: d  reason: collision with root package name */
    private static final Field f9289d;

    static {
        Field field;
        Field field2;
        Constructor<?> constructor;
        Class<?> cls = Collections.synchronizedCollection(new ArrayList()).getClass();
        f9286a = cls;
        f9287b = Collections.synchronizedList(new LinkedList()).getClass();
        Constructor<?> constructor2 = null;
        try {
            field = cls.getDeclaredField("mutex");
        } catch (NoSuchFieldException unused) {
            field = null;
        }
        f9288c = field;
        if (field != null) {
            field.setAccessible(true);
        }
        try {
            field2 = cls.getDeclaredField("c");
        } catch (NoSuchFieldException unused2) {
            field2 = null;
        }
        f9289d = field2;
        if (field2 != null) {
            field2.setAccessible(true);
        }
        try {
            constructor = Collections.synchronizedSet(new HashSet()).getClass().getDeclaredConstructor(Set.class, Object.class);
        } catch (NoSuchMethodException unused3) {
            constructor = null;
        }
        if (constructor != null) {
            constructor.setAccessible(true);
        }
        try {
            constructor2 = cls.getDeclaredConstructor(Collection.class, Object.class);
        } catch (NoSuchMethodException unused4) {
        }
        if (constructor2 != null) {
            constructor2.setAccessible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Collection collection, f.j$S j_s) {
        boolean c6;
        Field field = f9288c;
        if (field == null) {
            try {
                Collection collection2 = (Collection) f9289d.get(collection);
                return collection2 instanceof InterfaceC0228j$b ? ((InterfaceC0228j$b) collection2).c(j_s) : AbstractC0227j$a.j(collection2, j_s);
            } catch (IllegalAccessException e6) {
                throw new Error("Runtime illegal access in synchronized collection removeIf fall-back.", e6);
            }
        }
        try {
            synchronized (field.get(collection)) {
                Collection collection3 = (Collection) f9289d.get(collection);
                c6 = collection3 instanceof InterfaceC0228j$b ? ((InterfaceC0228j$b) collection3).c(j_s) : AbstractC0227j$a.j(collection3, j_s);
            }
            return c6;
        } catch (IllegalAccessException e7) {
            throw new Error("Runtime illegal access in synchronized collection removeIf.", e7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(List list, Comparator comparator) {
        Field field = f9288c;
        if (field == null) {
            try {
                AbstractC0227j$a.z((List) f9289d.get(list), comparator);
                return;
            } catch (IllegalAccessException e6) {
                throw new Error("Runtime illegal access in synchronized collection sort fall-back.", e6);
            }
        }
        try {
            synchronized (field.get(list)) {
                AbstractC0227j$a.z((List) f9289d.get(list), comparator);
            }
        } catch (IllegalAccessException e7) {
            throw new Error("Runtime illegal access in synchronized list sort.", e7);
        }
    }
}
