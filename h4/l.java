package h4;

import h4.k;
/* loaded from: classes.dex */
public abstract class l {
    public static final Object a(Throwable th) {
        kotlin.jvm.internal.l.d(th, "exception");
        return new k.b(th);
    }

    public static final void b(Object obj) {
        if (obj instanceof k.b) {
            throw ((k.b) obj).exception;
        }
    }
}
