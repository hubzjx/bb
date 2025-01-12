package com.google.common.collect;

import com.google.common.collect.y;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public abstract class w extends AbstractCollection implements Serializable {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class a extends b {

        /* renamed from: a  reason: collision with root package name */
        Object[] f5727a;

        /* renamed from: b  reason: collision with root package name */
        int f5728b;

        /* renamed from: c  reason: collision with root package name */
        boolean f5729c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i6) {
            i.b(i6, "initialCapacity");
            this.f5727a = new Object[i6];
            this.f5728b = 0;
        }

        private void g(int i6) {
            Object[] objArr = this.f5727a;
            if (objArr.length < i6) {
                this.f5727a = Arrays.copyOf(objArr, b.e(objArr.length, i6));
            } else if (!this.f5729c) {
                return;
            } else {
                this.f5727a = (Object[]) objArr.clone();
            }
            this.f5729c = false;
        }

        @Override // com.google.common.collect.w.b
        public b b(Object... objArr) {
            a1.b(objArr);
            g(this.f5728b + objArr.length);
            System.arraycopy(objArr, 0, this.f5727a, this.f5728b, objArr.length);
            this.f5728b += objArr.length;
            return this;
        }

        public a f(Object obj) {
            com.google.common.base.j.j(obj);
            g(this.f5728b + 1);
            Object[] objArr = this.f5727a;
            int i6 = this.f5728b;
            this.f5728b = i6 + 1;
            objArr[i6] = obj;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static int e(int i6, int i7) {
            if (i7 >= 0) {
                int i8 = i6 + (i6 >> 1) + 1;
                if (i8 < i7) {
                    i8 = Integer.highestOneBit(i7 - 1) << 1;
                }
                if (i8 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i8;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        public abstract b a(Object obj);

        public b b(Object... objArr) {
            for (Object obj : objArr) {
                a(obj);
            }
            return this;
        }

        public b c(Iterable iterable) {
            for (Object obj : iterable) {
                a(obj);
            }
            return this;
        }

        public b d(Iterator it) {
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(Collection<Object> collection) {
        throw new UnsupportedOperationException();
    }

    public y asList() {
        return isEmpty() ? y.of() : y.asImmutableList(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@NullableDecl Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int copyIntoArray(Object[] objArr, int i6) {
        s1 it = iterator();
        while (it.hasNext()) {
            objArr[i6] = it.next();
            i6++;
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] internalArray() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract s1 iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    Object writeReplace() {
        return new y.d(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] tArr) {
        com.google.common.base.j.j(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] internalArray = internalArray();
            if (internalArray != null) {
                return (T[]) d1.a(internalArray, internalArrayStart(), internalArrayEnd(), tArr);
            }
            tArr = (T[]) a1.d(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }
}
