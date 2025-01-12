package com.google.common.collect;

import com.google.common.collect.w;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public abstract class h0 extends w implements Set {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;
    @RetainedWith
    @NullableDecl
    @LazyInit
    private transient y asList;

    /* loaded from: classes.dex */
    public static class a extends w.a {

        /* renamed from: d  reason: collision with root package name */
        Object[] f5651d;

        /* renamed from: e  reason: collision with root package name */
        private int f5652e;

        public a() {
            super(4);
        }

        private void k(Object obj) {
            int length = this.f5651d.length - 1;
            int hashCode = obj.hashCode();
            int b6 = v.b(hashCode);
            while (true) {
                int i6 = b6 & length;
                Object[] objArr = this.f5651d;
                Object obj2 = objArr[i6];
                if (obj2 == null) {
                    objArr[i6] = obj;
                    this.f5652e += hashCode;
                    super.f(obj);
                    return;
                } else if (obj2.equals(obj)) {
                    return;
                } else {
                    b6 = i6 + 1;
                }
            }
        }

        @Override // com.google.common.collect.w.b
        /* renamed from: h */
        public a a(Object obj) {
            com.google.common.base.j.j(obj);
            if (this.f5651d != null && h0.chooseTableSize(this.f5728b) <= this.f5651d.length) {
                k(obj);
                return this;
            }
            this.f5651d = null;
            super.f(obj);
            return this;
        }

        public a i(Object... objArr) {
            if (this.f5651d != null) {
                for (Object obj : objArr) {
                    a(obj);
                }
            } else {
                super.b(objArr);
            }
            return this;
        }

        public a j(Iterator it) {
            com.google.common.base.j.j(it);
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public h0 l() {
            h0 construct;
            int i6 = this.f5728b;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (this.f5651d == null || h0.chooseTableSize(i6) != this.f5651d.length) {
                        construct = h0.construct(this.f5728b, this.f5727a);
                        this.f5728b = construct.size();
                    } else {
                        Object[] copyOf = h0.shouldTrim(this.f5728b, this.f5727a.length) ? Arrays.copyOf(this.f5727a, this.f5728b) : this.f5727a;
                        int i7 = this.f5652e;
                        Object[] objArr = this.f5651d;
                        construct = new h1(copyOf, i7, objArr, objArr.length - 1, this.f5728b);
                    }
                    this.f5729c = true;
                    this.f5651d = null;
                    return construct;
                }
                return h0.of(this.f5727a[0]);
            }
            return h0.of();
        }

        a(int i6) {
            super(i6);
            this.f5651d = new Object[h0.chooseTableSize(i6)];
        }
    }

    /* loaded from: classes.dex */
    private static class b implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        b(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return h0.copyOf(this.elements);
        }
    }

    public static <E> a builder() {
        return new a();
    }

    public static <E> a builderWithExpectedSize(int i6) {
        i.b(i6, "expectedSize");
        return new a(i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int chooseTableSize(int i6) {
        int max = Math.max(i6, 2);
        if (max >= CUTOFF) {
            com.google.common.base.j.e(max < MAX_TABLE_SIZE, "collection too large");
            return MAX_TABLE_SIZE;
        }
        int highestOneBit = Integer.highestOneBit(max - 1) << 1;
        while (highestOneBit * DESIRED_LOAD_FACTOR < max) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> h0 construct(int i6, Object... objArr) {
        if (i6 != 0) {
            if (i6 != 1) {
                int chooseTableSize = chooseTableSize(i6);
                Object[] objArr2 = new Object[chooseTableSize];
                int i7 = chooseTableSize - 1;
                int i8 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < i6; i10++) {
                    Object a6 = a1.a(objArr[i10], i10);
                    int hashCode = a6.hashCode();
                    int b6 = v.b(hashCode);
                    while (true) {
                        int i11 = b6 & i7;
                        Object obj = objArr2[i11];
                        if (obj == null) {
                            objArr[i9] = a6;
                            objArr2[i11] = a6;
                            i8 += hashCode;
                            i9++;
                            break;
                        } else if (obj.equals(a6)) {
                            break;
                        } else {
                            b6++;
                        }
                    }
                }
                Arrays.fill(objArr, i9, i6, (Object) null);
                if (i9 == 1) {
                    return new n1(objArr[0], i8);
                }
                if (chooseTableSize(i9) < chooseTableSize / 2) {
                    return construct(i9, objArr);
                }
                if (shouldTrim(i9, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i9);
                }
                return new h1(objArr, i8, objArr2, i7, i9);
            }
            return of(objArr[0]);
        }
        return of();
    }

    public static <E> h0 copyOf(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> h0 of() {
        return h1.EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldTrim(int i6, int i7) {
        return i6 < (i7 >> 1) + (i7 >> 2);
    }

    @Override // com.google.common.collect.w
    public y asList() {
        y yVar = this.asList;
        if (yVar == null) {
            y createAsList = createAsList();
            this.asList = createAsList;
            return createAsList;
        }
        return yVar;
    }

    y createAsList() {
        return y.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof h0) && isHashCodeFast() && ((h0) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return m1.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return m1.b(this);
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public abstract s1 iterator();

    @Override // com.google.common.collect.w
    Object writeReplace() {
        return new b(toArray());
    }

    public static <E> h0 copyOf(Collection<? extends E> collection) {
        if ((collection instanceof h0) && !(collection instanceof SortedSet)) {
            h0 h0Var = (h0) collection;
            if (!h0Var.isPartialView()) {
                return h0Var;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> h0 of(E e6) {
        return new n1(e6);
    }

    public static <E> h0 copyOf(Iterator<? extends E> it) {
        if (it.hasNext()) {
            E next = it.next();
            return !it.hasNext() ? of((Object) next) : new a().a(next).j(it).l();
        }
        return of();
    }

    public static <E> h0 of(E e6, E e7) {
        return construct(2, e6, e7);
    }

    public static <E> h0 copyOf(E[] eArr) {
        int length = eArr.length;
        return length != 0 ? length != 1 ? construct(eArr.length, (Object[]) eArr.clone()) : of((Object) eArr[0]) : of();
    }

    public static <E> h0 of(E e6, E e7, E e8) {
        return construct(3, e6, e7, e8);
    }

    public static <E> h0 of(E e6, E e7, E e8, E e9) {
        return construct(4, e6, e7, e8, e9);
    }

    public static <E> h0 of(E e6, E e7, E e8, E e9, E e10) {
        return construct(5, e6, e7, e8, e9, e10);
    }

    @SafeVarargs
    public static <E> h0 of(E e6, E e7, E e8, E e9, E e10, E e11, E... eArr) {
        com.google.common.base.j.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e6;
        objArr[1] = e7;
        objArr[2] = e8;
        objArr[3] = e9;
        objArr[4] = e10;
        objArr[5] = e11;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }
}
