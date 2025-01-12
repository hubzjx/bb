package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public abstract class p0 {

    /* loaded from: classes.dex */
    private static class a extends AbstractList implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        @NullableDecl
        final Object first;
        final Object[] rest;

        a(@NullableDecl Object obj, Object[] objArr) {
            this.first = obj;
            this.rest = (Object[]) com.google.common.base.j.j(objArr);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i6) {
            com.google.common.base.j.h(i6, size());
            return i6 == 0 ? this.first : this.rest[i6 - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return j3.a.d(this.rest.length, 1);
        }
    }

    public static List a(Object obj, Object[] objArr) {
        return new a(obj, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(List list, Object obj) {
        if (obj == com.google.common.base.j.j(list)) {
            return true;
        }
        if (obj instanceof List) {
            List list2 = (List) obj;
            int size = list.size();
            if (size != list2.size()) {
                return false;
            }
            if ((list instanceof RandomAccess) && (list2 instanceof RandomAccess)) {
                for (int i6 = 0; i6 < size; i6++) {
                    if (!com.google.common.base.h.a(list.get(i6), list2.get(i6))) {
                        return false;
                    }
                }
                return true;
            }
            return n0.d(list.iterator(), list2.iterator());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List list, Object obj) {
        if (list instanceof RandomAccess) {
            return d(list, obj);
        }
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (com.google.common.base.h.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int d(List list, Object obj) {
        int size = list.size();
        int i6 = 0;
        if (obj == null) {
            while (i6 < size) {
                if (list.get(i6) == null) {
                    return i6;
                }
                i6++;
            }
            return -1;
        }
        while (i6 < size) {
            if (obj.equals(list.get(i6))) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List list, Object obj) {
        if (list instanceof RandomAccess) {
            return f(list, obj);
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (com.google.common.base.h.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int f(List list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static ArrayList g() {
        return new ArrayList();
    }

    public static ArrayList h(Iterable iterable) {
        com.google.common.base.j.j(iterable);
        return iterable instanceof Collection ? new ArrayList(j.a(iterable)) : i(iterable.iterator());
    }

    public static ArrayList i(Iterator it) {
        ArrayList g6 = g();
        n0.a(g6, it);
        return g6;
    }
}
