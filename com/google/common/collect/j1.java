package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
/* loaded from: classes.dex */
final class j1 extends c1 implements Serializable {
    static final j1 INSTANCE = new j1();
    private static final long serialVersionUID = 0;

    private j1() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.c1, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        com.google.common.base.j.j(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.c1
    public <E extends Comparable> E max(E e6, E e7) {
        return (E) x0.INSTANCE.min(e6, e7);
    }

    @Override // com.google.common.collect.c1
    public <E extends Comparable> E min(E e6, E e7) {
        return (E) x0.INSTANCE.max(e6, e7);
    }

    @Override // com.google.common.collect.c1
    public <S extends Comparable> c1 reverse() {
        return c1.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    @Override // com.google.common.collect.c1
    public <E extends Comparable> E max(E e6, E e7, E e8, E... eArr) {
        return (E) x0.INSTANCE.min(e6, e7, e8, eArr);
    }

    @Override // com.google.common.collect.c1
    public <E extends Comparable> E min(E e6, E e7, E e8, E... eArr) {
        return (E) x0.INSTANCE.max(e6, e7, e8, eArr);
    }

    @Override // com.google.common.collect.c1
    public <E extends Comparable> E max(Iterable<E> iterable) {
        return (E) x0.INSTANCE.min(iterable);
    }

    @Override // com.google.common.collect.c1
    public <E extends Comparable> E min(Iterable<E> iterable) {
        return (E) x0.INSTANCE.max(iterable);
    }

    @Override // com.google.common.collect.c1
    public <E extends Comparable> E max(Iterator<E> it) {
        return (E) x0.INSTANCE.min(it);
    }

    @Override // com.google.common.collect.c1
    public <E extends Comparable> E min(Iterator<E> it) {
        return (E) x0.INSTANCE.max(it);
    }

    @Override // com.google.common.collect.c1
    public /* bridge */ /* synthetic */ Object max(Iterable iterable) {
        return max((Iterable<Comparable>) iterable);
    }

    @Override // com.google.common.collect.c1
    public /* bridge */ /* synthetic */ Object min(Iterable iterable) {
        return min((Iterable<Comparable>) iterable);
    }

    @Override // com.google.common.collect.c1
    public /* bridge */ /* synthetic */ Object max(Iterator it) {
        return max((Iterator<Comparable>) it);
    }

    @Override // com.google.common.collect.c1
    public /* bridge */ /* synthetic */ Object min(Iterator it) {
        return min((Iterator<Comparable>) it);
    }
}
