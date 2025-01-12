package com.google.common.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public abstract class c1 implements Comparator {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    /* loaded from: classes.dex */
    static class a extends c1 {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f5625a = new AtomicInteger(0);

        /* renamed from: b  reason: collision with root package name */
        private final ConcurrentMap f5626b = d1.e(new q0()).i();

        a() {
        }

        private Integer a(Object obj) {
            Integer num = (Integer) this.f5626b.get(obj);
            if (num == null) {
                Integer valueOf = Integer.valueOf(this.f5625a.getAndIncrement());
                Integer num2 = (Integer) this.f5626b.putIfAbsent(obj, valueOf);
                return num2 != null ? num2 : valueOf;
            }
            return num;
        }

        int b(Object obj) {
            return System.identityHashCode(obj);
        }

        @Override // com.google.common.collect.c1, java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int b6 = b(obj);
            int b7 = b(obj2);
            if (b6 != b7) {
                return b6 < b7 ? -1 : 1;
            }
            int compareTo = a(obj).compareTo(a(obj2));
            if (compareTo != 0) {
                return compareTo;
            }
            throw new AssertionError();
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    /* loaded from: classes.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        static final c1 f5627a = new a();
    }

    /* loaded from: classes.dex */
    static class c extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Object obj) {
            super("Cannot compare value: " + obj);
            this.value = obj;
        }
    }

    public static c1 allEqual() {
        return f.INSTANCE;
    }

    public static c1 arbitrary() {
        return b.f5627a;
    }

    public static <T> c1 compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new o(iterable);
    }

    public static <T> c1 explicit(T t5, T... tArr) {
        return explicit(p0.a(t5, tArr));
    }

    @Deprecated
    public static <T> c1 from(c1 c1Var) {
        return (c1) com.google.common.base.j.j(c1Var);
    }

    public static <C extends Comparable> c1 natural() {
        return x0.INSTANCE;
    }

    public static c1 usingToString() {
        return u1.INSTANCE;
    }

    @Deprecated
    public int binarySearch(List<Object> list, @NullableDecl Object obj) {
        return Collections.binarySearch(list, obj, this);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public <E> List<E> greatestOf(Iterable<E> iterable, int i6) {
        return reverse().leastOf(iterable, i6);
    }

    public <E> y immutableSortedCopy(Iterable<E> iterable) {
        return y.sortedCopyOf(this, iterable);
    }

    public boolean isOrdered(Iterable<Object> iterable) {
        Iterator<Object> it = iterable.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                Object next2 = it.next();
                if (compare(next, next2) > 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<Object> iterable) {
        Iterator<Object> it = iterable.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                Object next2 = it.next();
                if (compare(next, next2) >= 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public <E> List<E> leastOf(Iterable<E> iterable, int i6) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= i6 * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > i6) {
                    array = Arrays.copyOf(array, i6);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return leastOf(iterable.iterator(), i6);
    }

    public <S> c1 lexicographical() {
        return new o0(this);
    }

    public <E> E max(Iterable<E> iterable) {
        return (E) max(iterable.iterator());
    }

    public <E> E min(Iterable<E> iterable) {
        return (E) min(iterable.iterator());
    }

    public <S> c1 nullsFirst() {
        return new y0(this);
    }

    public <S> c1 nullsLast() {
        return new z0(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T2> c1 onKeys() {
        return onResultOf(s0.f());
    }

    public <F> c1 onResultOf(com.google.common.base.e eVar) {
        return new h(eVar, this);
    }

    public <S> c1 reverse() {
        return new k1(this);
    }

    public <E> List<E> sortedCopy(Iterable<E> iterable) {
        Object[] e6 = m0.e(iterable);
        Arrays.sort(e6, this);
        return p0.h(Arrays.asList(e6));
    }

    public static <T> c1 explicit(List<T> list) {
        return new r(list);
    }

    public static <T> c1 from(Comparator<T> comparator) {
        return comparator instanceof c1 ? (c1) comparator : new m(comparator);
    }

    public <U> c1 compound(Comparator<? super U> comparator) {
        return new o(this, (Comparator) com.google.common.base.j.j(comparator));
    }

    public <E> List<E> greatestOf(Iterator<E> it, int i6) {
        return reverse().leastOf(it, i6);
    }

    public <E> List<E> leastOf(Iterator<E> it, int i6) {
        com.google.common.base.j.j(it);
        i.b(i6, "k");
        if (i6 == 0 || !it.hasNext()) {
            return Collections.emptyList();
        }
        if (i6 < 1073741823) {
            q1 a6 = q1.a(i6, this);
            a6.c(it);
            return a6.f();
        }
        ArrayList i7 = p0.i(it);
        Collections.sort(i7, this);
        if (i7.size() > i6) {
            i7.subList(i6, i7.size()).clear();
        }
        i7.trimToSize();
        return Collections.unmodifiableList(i7);
    }

    public <E> E max(@NullableDecl E e6, @NullableDecl E e7) {
        return compare(e6, e7) >= 0 ? e6 : e7;
    }

    public <E> E min(@NullableDecl E e6, @NullableDecl E e7) {
        return compare(e6, e7) <= 0 ? e6 : e7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E> E max(@NullableDecl E e6, @NullableDecl E e7, @NullableDecl E e8, E... eArr) {
        E e9 = (E) max(max(e6, e7), e8);
        for (E e10 : eArr) {
            e9 = (E) max(e9, e10);
        }
        return e9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E> E min(@NullableDecl E e6, @NullableDecl E e7, @NullableDecl E e8, E... eArr) {
        E e9 = (E) min(min(e6, e7), e8);
        for (E e10 : eArr) {
            e9 = (E) min(e9, e10);
        }
        return e9;
    }

    public <E> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) max(next, it.next());
        }
        return next;
    }

    public <E> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) min(next, it.next());
        }
        return next;
    }
}
