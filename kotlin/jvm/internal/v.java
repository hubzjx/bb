package kotlin.jvm.internal;

import java.util.List;
/* loaded from: classes.dex */
public abstract class v {
    public static List a(Object obj) {
        if ((obj instanceof q4.a) && !(obj instanceof q4.b)) {
            h(obj, "kotlin.collections.MutableList");
        }
        return c(obj);
    }

    public static Object b(Object obj, int i6) {
        if (obj != null && !e(obj, i6)) {
            h(obj, "kotlin.jvm.functions.Function" + i6);
        }
        return obj;
    }

    public static List c(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e6) {
            throw g(e6);
        }
    }

    public static int d(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).getArity();
        }
        if (obj instanceof p4.a) {
            return 0;
        }
        if (obj instanceof p4.l) {
            return 1;
        }
        return obj instanceof p4.p ? 2 : -1;
    }

    public static boolean e(Object obj, int i6) {
        return (obj instanceof h4.c) && d(obj) == i6;
    }

    private static Throwable f(Throwable th) {
        return l.h(th, v.class.getName());
    }

    public static ClassCastException g(ClassCastException classCastException) {
        throw ((ClassCastException) f(classCastException));
    }

    public static void h(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        i(name + " cannot be cast to " + str);
    }

    public static void i(String str) {
        throw g(new ClassCastException(str));
    }
}
