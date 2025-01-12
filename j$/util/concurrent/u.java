package j$.util.concurrent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;
/* loaded from: classes2.dex */
abstract class u {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f11116a;

    static {
        Field b6 = b();
        b6.setAccessible(true);
        try {
            f11116a = (Unsafe) b6.get(null);
        } catch (IllegalAccessException e6) {
            throw new Error("Couldn't get the Unsafe", e6);
        }
    }

    public static final int a(Unsafe unsafe, Object obj, long j6) {
        int intVolatile;
        do {
            intVolatile = unsafe.getIntVolatile(obj, j6);
        } while (!unsafe.compareAndSwapInt(obj, j6, intVolatile, intVolatile - 4));
        return intVolatile;
    }

    private static Field b() {
        Field[] declaredFields;
        try {
            return Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e6) {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) && Unsafe.class.isAssignableFrom(field.getType())) {
                    return field;
                }
            }
            throw new Error("Couldn't find the Unsafe", e6);
        }
    }

    public static Unsafe c() {
        return f11116a;
    }
}
