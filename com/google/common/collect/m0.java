package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public abstract class m0 {
    private static Collection a(Iterable iterable) {
        return iterable instanceof Collection ? (Collection) iterable : p0.i(iterable.iterator());
    }

    public static Object b(Iterable iterable, Object obj) {
        return n0.h(iterable.iterator(), obj);
    }

    public static Object c(Iterable iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                throw new NoSuchElementException();
            }
            return d(list);
        }
        return n0.g(iterable.iterator());
    }

    private static Object d(List list) {
        return list.get(list.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] e(Iterable iterable) {
        return a(iterable).toArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] f(Iterable iterable, Object[] objArr) {
        return a(iterable).toArray(objArr);
    }

    public static String g(Iterable iterable) {
        return n0.k(iterable.iterator());
    }
}
