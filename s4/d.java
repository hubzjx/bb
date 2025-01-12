package s4;

import kotlin.jvm.internal.l;
/* loaded from: classes.dex */
public abstract class d {
    public static final Object a(c cVar, Object obj) {
        l.d(cVar, "<this>");
        if (cVar.c(obj)) {
            if (obj != null) {
                return obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
        }
        throw new ClassCastException("Value cannot be cast to " + cVar.a());
    }
}
