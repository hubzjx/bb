package com.google.common.base;
/* loaded from: classes.dex */
public abstract class j {
    private static String a(int i6, int i7, String str) {
        if (i6 < 0) {
            return l.a("%s (%s) must not be negative", str, Integer.valueOf(i6));
        }
        if (i7 >= 0) {
            return l.a("%s (%s) must be less than size (%s)", str, Integer.valueOf(i6), Integer.valueOf(i7));
        }
        throw new IllegalArgumentException("negative size: " + i7);
    }

    private static String b(int i6, int i7, String str) {
        if (i6 < 0) {
            return l.a("%s (%s) must not be negative", str, Integer.valueOf(i6));
        }
        if (i7 >= 0) {
            return l.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i6), Integer.valueOf(i7));
        }
        throw new IllegalArgumentException("negative size: " + i7);
    }

    private static String c(int i6, int i7, int i8) {
        return (i6 < 0 || i6 > i8) ? b(i6, i8, "start index") : (i7 < 0 || i7 > i8) ? b(i7, i8, "end index") : l.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i7), Integer.valueOf(i6));
    }

    public static void d(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z5, Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z5, String str, int i6) {
        if (!z5) {
            throw new IllegalArgumentException(l.a(str, Integer.valueOf(i6)));
        }
    }

    public static void g(boolean z5, String str, long j6) {
        if (!z5) {
            throw new IllegalArgumentException(l.a(str, Long.valueOf(j6)));
        }
    }

    public static int h(int i6, int i7) {
        return i(i6, i7, "index");
    }

    public static int i(int i6, int i7, String str) {
        if (i6 < 0 || i6 >= i7) {
            throw new IndexOutOfBoundsException(a(i6, i7, str));
        }
        return i6;
    }

    public static Object j(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object k(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static int l(int i6, int i7) {
        return m(i6, i7, "index");
    }

    public static int m(int i6, int i7, String str) {
        if (i6 < 0 || i6 > i7) {
            throw new IndexOutOfBoundsException(b(i6, i7, str));
        }
        return i6;
    }

    public static void n(int i6, int i7, int i8) {
        if (i6 < 0 || i7 < i6 || i7 > i8) {
            throw new IndexOutOfBoundsException(c(i6, i7, i8));
        }
    }

    public static void o(boolean z5, Object obj) {
        if (!z5) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void p(boolean z5, String str, int i6) {
        if (!z5) {
            throw new IllegalStateException(l.a(str, Integer.valueOf(i6)));
        }
    }

    public static void q(boolean z5, String str, Object obj) {
        if (!z5) {
            throw new IllegalStateException(l.a(str, obj));
        }
    }
}
