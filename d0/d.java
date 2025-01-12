package d0;

import java.util.Objects;
/* loaded from: classes.dex */
public abstract class d {
    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int b(Object... objArr) {
        return Objects.hash(objArr);
    }
}
