package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;
/* loaded from: classes.dex */
abstract class p1 {
    public static Comparator a(SortedSet sortedSet) {
        Comparator comparator = sortedSet.comparator();
        return comparator == null ? c1.natural() : comparator;
    }

    public static boolean b(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        com.google.common.base.j.j(comparator);
        com.google.common.base.j.j(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else if (!(iterable instanceof o1)) {
            return false;
        } else {
            comparator2 = ((o1) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
