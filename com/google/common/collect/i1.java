package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i1 extends j0 {
    static final i1 NATURAL_EMPTY_SET = new i1(y.of(), c1.natural());
    final transient y elements;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i1(y yVar, Comparator<Object> comparator) {
        super(comparator);
        this.elements = yVar;
    }

    private int unsafeBinarySearch(Object obj) {
        return Collections.binarySearch(this.elements, obj, unsafeComparator());
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.w
    public y asList() {
        return this.elements;
    }

    @Override // com.google.common.collect.j0, java.util.NavigableSet
    public Object ceiling(Object obj) {
        int tailIndex = tailIndex(obj, true);
        if (tailIndex == size()) {
            return null;
        }
        return this.elements.get(tailIndex);
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        if (obj != null) {
            try {
                return unsafeBinarySearch(obj) >= 0;
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof v0) {
            collection = ((v0) collection).elementSet();
        }
        if (!p1.b(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        s1 it = iterator();
        Iterator<?> it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        Object next2 = it.next();
        while (true) {
            try {
                int unsafeCompare = unsafeCompare(next2, next);
                if (unsafeCompare < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (unsafeCompare == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (unsafeCompare > 0) {
                    break;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public int copyIntoArray(Object[] objArr, int i6) {
        return this.elements.copyIntoArray(objArr, i6);
    }

    @Override // com.google.common.collect.j0
    j0 createDescendingSet() {
        Comparator reverseOrder = Collections.reverseOrder(this.comparator);
        return isEmpty() ? j0.emptySet(reverseOrder) : new i1(this.elements.reverse(), reverseOrder);
    }

    @Override // com.google.common.collect.j0, java.util.NavigableSet
    public s1 descendingIterator() {
        return this.elements.reverse().iterator();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034 A[Catch: ClassCastException | NoSuchElementException -> 0x0046, TryCatch #0 {ClassCastException | NoSuchElementException -> 0x0046, blocks: (B:17:0x002a, B:18:0x002e, B:20:0x0034, B:22:0x003e), top: B:29:0x002a }] */
    @Override // com.google.common.collect.h0, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            if (isEmpty()) {
                return true;
            }
            if (p1.b(this.comparator, set)) {
                Iterator it = set.iterator();
                try {
                    s1 it2 = iterator();
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        Object next2 = it.next();
                        if (next2 == null || unsafeCompare(next, next2) != 0) {
                            return false;
                        }
                        while (it2.hasNext()) {
                        }
                    }
                    return true;
                } catch (ClassCastException | NoSuchElementException unused) {
                    return false;
                }
            }
            return containsAll(set);
        }
        return false;
    }

    @Override // com.google.common.collect.j0, java.util.SortedSet
    public Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.elements.get(0);
    }

    @Override // com.google.common.collect.j0, java.util.NavigableSet
    public Object floor(Object obj) {
        int headIndex = headIndex(obj, true) - 1;
        if (headIndex == -1) {
            return null;
        }
        return this.elements.get(headIndex);
    }

    i1 getSubSet(int i6, int i7) {
        return (i6 == 0 && i7 == size()) ? this : i6 < i7 ? new i1(this.elements.subList(i6, i7), this.comparator) : j0.emptySet(this.comparator);
    }

    int headIndex(Object obj, boolean z5) {
        int binarySearch = Collections.binarySearch(this.elements, com.google.common.base.j.j(obj), comparator());
        return binarySearch >= 0 ? z5 ? binarySearch + 1 : binarySearch : ~binarySearch;
    }

    @Override // com.google.common.collect.j0
    j0 headSetImpl(Object obj, boolean z5) {
        return getSubSet(0, headIndex(obj, z5));
    }

    @Override // com.google.common.collect.j0, java.util.NavigableSet
    public Object higher(Object obj) {
        int tailIndex = tailIndex(obj, false);
        if (tailIndex == size()) {
            return null;
        }
        return this.elements.get(tailIndex);
    }

    @Override // com.google.common.collect.j0
    int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int binarySearch = Collections.binarySearch(this.elements, obj, unsafeComparator());
            if (binarySearch >= 0) {
                return binarySearch;
            }
            return -1;
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public Object[] internalArray() {
        return this.elements.internalArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public int internalArrayEnd() {
        return this.elements.internalArrayEnd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public int internalArrayStart() {
        return this.elements.internalArrayStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public boolean isPartialView() {
        return this.elements.isPartialView();
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.h0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public s1 iterator() {
        return this.elements.iterator();
    }

    @Override // com.google.common.collect.j0, java.util.SortedSet
    public Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.elements.get(size() - 1);
    }

    @Override // com.google.common.collect.j0, java.util.NavigableSet
    public Object lower(Object obj) {
        int headIndex = headIndex(obj, false) - 1;
        if (headIndex == -1) {
            return null;
        }
        return this.elements.get(headIndex);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.size();
    }

    @Override // com.google.common.collect.j0
    j0 subSetImpl(Object obj, boolean z5, Object obj2, boolean z6) {
        return tailSetImpl(obj, z5).headSetImpl(obj2, z6);
    }

    int tailIndex(Object obj, boolean z5) {
        int binarySearch = Collections.binarySearch(this.elements, com.google.common.base.j.j(obj), comparator());
        return binarySearch >= 0 ? z5 ? binarySearch : binarySearch + 1 : ~binarySearch;
    }

    @Override // com.google.common.collect.j0
    j0 tailSetImpl(Object obj, boolean z5) {
        return getSubSet(tailIndex(obj, z5), size());
    }

    Comparator<Object> unsafeComparator() {
        return this.comparator;
    }
}
