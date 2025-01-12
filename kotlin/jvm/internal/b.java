package kotlin.jvm.internal;

import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class b {
    public static final Iterator a(Object[] objArr) {
        l.d(objArr, "array");
        return new a(objArr);
    }
}
