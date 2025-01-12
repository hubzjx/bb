package com.google.common.collect;

import com.google.common.collect.h0;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public abstract class j0 extends k0 implements NavigableSet, o1 {
    final transient Comparator<Object> comparator;
    @LazyInit
    transient j0 descendingSet;

    /* loaded from: classes.dex */
    public static final class a extends h0.a {

        /* renamed from: f  reason: collision with root package name */
        private final Comparator f5654f;

        public a(Comparator comparator) {
            this.f5654f = (Comparator) com.google.common.base.j.j(comparator);
        }

        @Override // com.google.common.collect.h0.a
        /* renamed from: m */
        public a h(Object obj) {
            super.a(obj);
            return this;
        }

        public a n(Object... objArr) {
            super.i(objArr);
            return this;
        }

        @Override // com.google.common.collect.h0.a
        /* renamed from: o */
        public a j(Iterator it) {
            super.j(it);
            return this;
        }

        @Override // com.google.common.collect.h0.a
        /* renamed from: p */
        public j0 l() {
            j0 construct = j0.construct(this.f5654f, this.f5728b, this.f5727a);
            this.f5728b = construct.size();
            this.f5729c = true;
            return construct;
        }
    }

    /* loaded from: classes.dex */
    private static class b implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<Object> comparator;
        final Object[] elements;

        public b(Comparator<Object> comparator, Object[] objArr) {
            this.comparator = comparator;
            this.elements = objArr;
        }

        Object readResolve() {
            return new a(this.comparator).n(this.elements).l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(Comparator<Object> comparator) {
        this.comparator = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> j0 construct(Comparator<? super E> comparator, int i6, E... eArr) {
        if (i6 == 0) {
            return emptySet(comparator);
        }
        a1.c(eArr, i6);
        Arrays.sort(eArr, 0, i6, comparator);
        int i7 = 1;
        for (int i8 = 1; i8 < i6; i8++) {
            Object obj = (Object) eArr[i8];
            if (comparator.compare(obj, (Object) eArr[i7 - 1]) != 0) {
                eArr[i7] = obj;
                i7++;
            }
        }
        Arrays.fill(eArr, i7, i6, (Object) null);
        if (i7 < eArr.length / 2) {
            eArr = (E[]) Arrays.copyOf(eArr, i7);
        }
        return new i1(y.asImmutableList(eArr, i7), comparator);
    }

    public static <E> j0 copyOf(Iterable<? extends E> iterable) {
        return copyOf(c1.natural(), iterable);
    }

    public static <E> j0 copyOfSorted(SortedSet<E> sortedSet) {
        Comparator a6 = p1.a(sortedSet);
        y copyOf = y.copyOf((Collection) sortedSet);
        return copyOf.isEmpty() ? emptySet(a6) : new i1(copyOf, a6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> i1 emptySet(Comparator<? super E> comparator) {
        return c1.natural().equals(comparator) ? i1.NATURAL_EMPTY_SET : new i1(y.of(), comparator);
    }

    public static <E extends Comparable<?>> a naturalOrder() {
        return new a(c1.natural());
    }

    public static <E> j0 of() {
        return i1.NATURAL_EMPTY_SET;
    }

    public static <E> a orderedBy(Comparator<E> comparator) {
        return new a(comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> a reverseOrder() {
        return new a(Collections.reverseOrder());
    }

    public Object ceiling(Object obj) {
        return m0.b(tailSet(obj, true), null);
    }

    @Override // java.util.SortedSet, com.google.common.collect.o1
    public Comparator<Object> comparator() {
        return this.comparator;
    }

    abstract j0 createDescendingSet();

    @Override // java.util.NavigableSet
    public abstract s1 descendingIterator();

    @Override // java.util.NavigableSet
    public j0 descendingSet() {
        j0 j0Var = this.descendingSet;
        if (j0Var == null) {
            j0 createDescendingSet = createDescendingSet();
            this.descendingSet = createDescendingSet;
            createDescendingSet.descendingSet = this;
            return createDescendingSet;
        }
        return j0Var;
    }

    public Object first() {
        return iterator().next();
    }

    public Object floor(Object obj) {
        return n0.h(headSet(obj, true).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public j0 headSet(Object obj) {
        return headSet(obj, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract j0 headSetImpl(Object obj, boolean z5);

    public Object higher(Object obj) {
        return m0.b(tailSet(obj, false), null);
    }

    abstract int indexOf(@NullableDecl Object obj);

    @Override // com.google.common.collect.h0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public abstract s1 iterator();

    public Object last() {
        return descendingIterator().next();
    }

    public Object lower(Object obj) {
        return n0.h(headSet(obj, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @CanIgnoreReturnValue
    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @CanIgnoreReturnValue
    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public j0 subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    abstract j0 subSetImpl(Object obj, boolean z5, Object obj2, boolean z6);

    @Override // java.util.NavigableSet, java.util.SortedSet
    public j0 tailSet(Object obj) {
        return tailSet(obj, true);
    }

    abstract j0 tailSetImpl(Object obj, boolean z5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.w
    Object writeReplace() {
        return new b(this.comparator, toArray());
    }

    public static <E> j0 copyOf(Collection<? extends E> collection) {
        return copyOf((Comparator) c1.natural(), (Collection) collection);
    }

    public static <E extends Comparable<? super E>> j0 of(E e6) {
        return new i1(y.of(e6), c1.natural());
    }

    static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.NavigableSet
    public j0 headSet(Object obj, boolean z5) {
        return headSetImpl(com.google.common.base.j.j(obj), z5);
    }

    @Override // java.util.NavigableSet
    public j0 subSet(Object obj, boolean z5, Object obj2, boolean z6) {
        com.google.common.base.j.j(obj);
        com.google.common.base.j.j(obj2);
        com.google.common.base.j.d(this.comparator.compare(obj, obj2) <= 0);
        return subSetImpl(obj, z5, obj2, z6);
    }

    @Override // java.util.NavigableSet
    public j0 tailSet(Object obj, boolean z5) {
        return tailSetImpl(com.google.common.base.j.j(obj), z5);
    }

    public static <E> j0 copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        com.google.common.base.j.j(comparator);
        if (p1.b(comparator, iterable) && (iterable instanceof j0)) {
            j0 j0Var = (j0) iterable;
            if (!j0Var.isPartialView()) {
                return j0Var;
            }
        }
        Object[] e6 = m0.e(iterable);
        return construct(comparator, e6.length, e6);
    }

    public static <E extends Comparable<? super E>> j0 of(E e6, E e7) {
        return construct(c1.natural(), 2, e6, e7);
    }

    public static <E> j0 copyOf(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return copyOf((Comparator) comparator, (Iterable) collection);
    }

    public static <E extends Comparable<? super E>> j0 of(E e6, E e7, E e8) {
        return construct(c1.natural(), 3, e6, e7, e8);
    }

    public static <E> j0 copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        return new a(comparator).j(it).l();
    }

    public static <E extends Comparable<? super E>> j0 of(E e6, E e7, E e8, E e9) {
        return construct(c1.natural(), 4, e6, e7, e8, e9);
    }

    public static <E> j0 copyOf(Iterator<? extends E> it) {
        return copyOf(c1.natural(), it);
    }

    public static <E extends Comparable<? super E>> j0 of(E e6, E e7, E e8, E e9, E e10) {
        return construct(c1.natural(), 5, e6, e7, e8, e9, e10);
    }

    public static <E extends Comparable<? super E>> j0 copyOf(E[] eArr) {
        return construct(c1.natural(), eArr.length, (Object[]) eArr.clone());
    }

    public static <E extends Comparable<? super E>> j0 of(E e6, E e7, E e8, E e9, E e10, E e11, E... eArr) {
        int length = eArr.length + 6;
        Comparable[] comparableArr = new Comparable[length];
        comparableArr[0] = e6;
        comparableArr[1] = e7;
        comparableArr[2] = e8;
        comparableArr[3] = e9;
        comparableArr[4] = e10;
        comparableArr[5] = e11;
        System.arraycopy(eArr, 0, comparableArr, 6, eArr.length);
        return construct(c1.natural(), length, comparableArr);
    }
}
