package kotlin.jvm.internal;

import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class l {
    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj) {
        if (obj == null) {
            j();
        }
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) g(new NullPointerException(str + " must not be null")));
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            k(str);
        }
    }

    public static int e(int i6, int i7) {
        if (i6 < i7) {
            return -1;
        }
        return i6 == i7 ? 0 : 1;
    }

    private static String f(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    private static Throwable g(Throwable th) {
        return h(th, l.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Throwable h(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i6 = -1;
        for (int i7 = 0; i7 < length; i7++) {
            if (str.equals(stackTrace[i7].getClassName())) {
                i6 = i7;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i6 + 1, length));
        return th;
    }

    public static String i(String str, Object obj) {
        return str + obj;
    }

    public static void j() {
        throw ((NullPointerException) g(new NullPointerException()));
    }

    private static void k(String str) {
        throw ((NullPointerException) g(new NullPointerException(f(str))));
    }

    public static void l(String str) {
        throw ((h4.p) g(new h4.p(str)));
    }

    public static void m(String str) {
        l("lateinit property " + str + " has not been initialized");
    }
}
