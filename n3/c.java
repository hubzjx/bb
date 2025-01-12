package n3;

import com.google.gson.g;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
final class c extends b {

    /* renamed from: d  reason: collision with root package name */
    private static Class f12253d;

    /* renamed from: b  reason: collision with root package name */
    private final Object f12254b = d();

    /* renamed from: c  reason: collision with root package name */
    private final Field f12255c = c();

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object d() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f12253d = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // n3.b
    public void b(AccessibleObject accessibleObject) {
        if (e(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e6) {
            throw new g("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e6);
        }
    }

    boolean e(AccessibleObject accessibleObject) {
        if (this.f12254b != null && this.f12255c != null) {
            try {
                f12253d.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f12254b, accessibleObject, Long.valueOf(((Long) f12253d.getMethod("objectFieldOffset", Field.class).invoke(this.f12254b, this.f12255c)).longValue()), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
