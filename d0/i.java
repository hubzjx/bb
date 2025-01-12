package d0;
/* loaded from: classes.dex */
public abstract class i {
    public static void a(boolean z5, Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int b(int i6) {
        if (i6 >= 0) {
            return i6;
        }
        throw new IllegalArgumentException();
    }

    public static Object c(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object d(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }
}
