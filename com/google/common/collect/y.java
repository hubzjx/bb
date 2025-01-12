package com.google.common.collect;

import com.google.common.collect.w;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public abstract class y extends w implements List, RandomAccess {
    private static final t1 EMPTY_ITR = new b(e1.EMPTY, 0);

    /* loaded from: classes.dex */
    public static final class a extends w.a {
        public a() {
            this(4);
        }

        @Override // com.google.common.collect.w.b
        /* renamed from: h */
        public a a(Object obj) {
            super.f(obj);
            return this;
        }

        public a i(Iterator it) {
            super.d(it);
            return this;
        }

        public y j() {
            this.f5729c = true;
            return y.asImmutableList(this.f5727a, this.f5728b);
        }

        a(int i6) {
            super(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends com.google.common.collect.a {

        /* renamed from: c  reason: collision with root package name */
        private final y f5736c;

        b(y yVar, int i6) {
            super(yVar.size(), i6);
            this.f5736c = yVar;
        }

        @Override // com.google.common.collect.a
        protected Object a(int i6) {
            return this.f5736c.get(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends y {
        private final transient y forwardList;

        c(y yVar) {
            this.forwardList = yVar;
        }

        private int reverseIndex(int i6) {
            return (size() - 1) - i6;
        }

        private int reversePosition(int i6) {
            return size() - i6;
        }

        @Override // com.google.common.collect.y, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return this.forwardList.contains(obj);
        }

        @Override // java.util.List
        public Object get(int i6) {
            com.google.common.base.j.h(i6, size());
            return this.forwardList.get(reverseIndex(i6));
        }

        @Override // com.google.common.collect.y, java.util.List
        public int indexOf(@NullableDecl Object obj) {
            int lastIndexOf = this.forwardList.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return reverseIndex(lastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.w
        boolean isPartialView() {
            return this.forwardList.isPartialView();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.y, java.util.List
        public int lastIndexOf(@NullableDecl Object obj) {
            int indexOf = this.forwardList.indexOf(obj);
            if (indexOf >= 0) {
                return reverseIndex(indexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.y, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.y
        public y reverse() {
            return this.forwardList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.forwardList.size();
        }

        @Override // com.google.common.collect.y, java.util.List
        public y subList(int i6, int i7) {
            com.google.common.base.j.n(i6, i7, size());
            return this.forwardList.subList(reversePosition(i7), reversePosition(i6)).reverse();
        }

        @Override // com.google.common.collect.y, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i6) {
            return super.listIterator(i6);
        }
    }

    /* loaded from: classes.dex */
    static class d implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return y.copyOf(this.elements);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends y {
        final transient int length;
        final transient int offset;

        e(int i6, int i7) {
            this.offset = i6;
            this.length = i7;
        }

        @Override // java.util.List
        public Object get(int i6) {
            com.google.common.base.j.h(i6, this.length);
            return y.this.get(i6 + this.offset);
        }

        @Override // com.google.common.collect.w
        Object[] internalArray() {
            return y.this.internalArray();
        }

        @Override // com.google.common.collect.w
        int internalArrayEnd() {
            return y.this.internalArrayStart() + this.offset + this.length;
        }

        @Override // com.google.common.collect.w
        int internalArrayStart() {
            return y.this.internalArrayStart() + this.offset;
        }

        @Override // com.google.common.collect.w
        boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.y, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.y, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // com.google.common.collect.y, java.util.List
        public y subList(int i6, int i7) {
            com.google.common.base.j.n(i6, i7, this.length);
            y yVar = y.this;
            int i8 = this.offset;
            return yVar.subList(i6 + i8, i7 + i8);
        }

        @Override // com.google.common.collect.y, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i6) {
            return super.listIterator(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> y asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    public static <E> a builder() {
        return new a();
    }

    public static <E> a builderWithExpectedSize(int i6) {
        i.b(i6, "expectedSize");
        return new a(i6);
    }

    private static <E> y construct(Object... objArr) {
        return asImmutableList(a1.b(objArr));
    }

    public static <E> y copyOf(Iterable<? extends E> iterable) {
        com.google.common.base.j.j(iterable);
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> y of() {
        return e1.EMPTY;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> y sortedCopyOf(Iterable<? extends E> iterable) {
        Comparable[] comparableArr = (Comparable[]) m0.f(iterable, new Comparable[0]);
        a1.b(comparableArr);
        Arrays.sort(comparableArr);
        return asImmutableList(comparableArr);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i6, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(int i6, Collection<Object> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.w
    public final y asList() {
        return this;
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public int copyIntoArray(Object[] objArr, int i6) {
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            objArr[i6 + i7] = get(i7);
        }
        return i6 + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        return p0.b(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i6 = 1;
        for (int i7 = 0; i7 < size; i7++) {
            i6 = ~(~((i6 * 31) + get(i7).hashCode()));
        }
        return i6;
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        return p0.c(this, obj);
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public s1 iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        return p0.e(this, obj);
    }

    @Override // java.util.List
    public t1 listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final Object remove(int i6) {
        throw new UnsupportedOperationException();
    }

    public y reverse() {
        return size() <= 1 ? this : new c(this);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final Object set(int i6, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public y subList(int i6, int i7) {
        com.google.common.base.j.n(i6, i7, size());
        int i8 = i7 - i6;
        return i8 == size() ? this : i8 == 0 ? of() : subListUnchecked(i6, i7);
    }

    y subListUnchecked(int i6, int i7) {
        return new e(i6, i7 - i6);
    }

    @Override // com.google.common.collect.w
    Object writeReplace() {
        return new d(toArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> y asImmutableList(Object[] objArr, int i6) {
        return i6 == 0 ? of() : new e1(objArr, i6);
    }

    public static <E> y copyOf(Collection<? extends E> collection) {
        if (collection instanceof w) {
            y asList = ((w) collection).asList();
            return asList.isPartialView() ? asImmutableList(asList.toArray()) : asList;
        }
        return construct(collection.toArray());
    }

    public static <E> y of(E e6) {
        return construct(e6);
    }

    public static <E> y sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        com.google.common.base.j.j(comparator);
        Object[] e6 = m0.e(iterable);
        a1.b(e6);
        Arrays.sort(e6, comparator);
        return asImmutableList(e6);
    }

    @Override // java.util.List
    public t1 listIterator(int i6) {
        com.google.common.base.j.l(i6, size());
        return isEmpty() ? EMPTY_ITR : new b(this, i6);
    }

    public static <E> y copyOf(Iterator<? extends E> it) {
        if (it.hasNext()) {
            E next = it.next();
            return !it.hasNext() ? of((Object) next) : new a().a(next).i(it).j();
        }
        return of();
    }

    public static <E> y of(E e6, E e7) {
        return construct(e6, e7);
    }

    public static <E> y copyOf(E[] eArr) {
        return eArr.length == 0 ? of() : construct((Object[]) eArr.clone());
    }

    public static <E> y of(E e6, E e7, E e8) {
        return construct(e6, e7, e8);
    }

    public static <E> y of(E e6, E e7, E e8, E e9) {
        return construct(e6, e7, e8, e9);
    }

    public static <E> y of(E e6, E e7, E e8, E e9, E e10) {
        return construct(e6, e7, e8, e9, e10);
    }

    public static <E> y of(E e6, E e7, E e8, E e9, E e10, E e11) {
        return construct(e6, e7, e8, e9, e10, e11);
    }

    public static <E> y of(E e6, E e7, E e8, E e9, E e10, E e11, E e12) {
        return construct(e6, e7, e8, e9, e10, e11, e12);
    }

    public static <E> y of(E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13) {
        return construct(e6, e7, e8, e9, e10, e11, e12, e13);
    }

    public static <E> y of(E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E e14) {
        return construct(e6, e7, e8, e9, e10, e11, e12, e13, e14);
    }

    public static <E> y of(E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E e14, E e15) {
        return construct(e6, e7, e8, e9, e10, e11, e12, e13, e14, e15);
    }

    public static <E> y of(E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E e14, E e15, E e16) {
        return construct(e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16);
    }

    @SafeVarargs
    public static <E> y of(E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E... eArr) {
        com.google.common.base.j.e(eArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 12];
        objArr[0] = e6;
        objArr[1] = e7;
        objArr[2] = e8;
        objArr[3] = e9;
        objArr[4] = e10;
        objArr[5] = e11;
        objArr[6] = e12;
        objArr[7] = e13;
        objArr[8] = e14;
        objArr[9] = e15;
        objArr[10] = e16;
        objArr[11] = e17;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        return construct(objArr);
    }
}
