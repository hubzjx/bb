package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class s extends r {
    public static boolean s(Collection collection, Iterable iterable) {
        kotlin.jvm.internal.l.d(collection, "<this>");
        kotlin.jvm.internal.l.d(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z5 = false;
        for (Object obj : iterable) {
            if (collection.add(obj)) {
                z5 = true;
            }
        }
        return z5;
    }

    public static boolean t(Collection collection, Object[] objArr) {
        List c6;
        kotlin.jvm.internal.l.d(collection, "<this>");
        kotlin.jvm.internal.l.d(objArr, "elements");
        c6 = i.c(objArr);
        return collection.addAll(c6);
    }

    private static final boolean u(Iterable iterable, p4.l lVar, boolean z5) {
        Iterator it = iterable.iterator();
        boolean z6 = false;
        while (it.hasNext()) {
            if (((Boolean) lVar.invoke(it.next())).booleanValue() == z5) {
                it.remove();
                z6 = true;
            }
        }
        return z6;
    }

    public static Object v(List list) {
        kotlin.jvm.internal.l.d(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(l.h(list));
    }

    public static boolean w(Iterable iterable, p4.l lVar) {
        kotlin.jvm.internal.l.d(iterable, "<this>");
        kotlin.jvm.internal.l.d(lVar, "predicate");
        return u(iterable, lVar, false);
    }
}
