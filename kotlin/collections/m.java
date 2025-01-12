package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class m {
    public static final Object[] a(Object[] objArr, boolean z5) {
        kotlin.jvm.internal.l.d(objArr, "<this>");
        if (z5 && kotlin.jvm.internal.l.a(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        kotlin.jvm.internal.l.c(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    public static List b(Object obj) {
        List singletonList = Collections.singletonList(obj);
        kotlin.jvm.internal.l.c(singletonList, "singletonList(element)");
        return singletonList;
    }
}
