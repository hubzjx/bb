package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends AbstractSet implements Serializable {
    private static final float DEFAULT_LOAD_FACTOR = 1.0f;
    private static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;
    @MonotonicNonNullDecl
    transient Object[] elements;
    @MonotonicNonNullDecl
    private transient long[] entries;
    transient float loadFactor;
    transient int modCount;
    private transient int size;
    @MonotonicNonNullDecl
    private transient int[] table;
    private transient int threshold;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        int f5668a;

        /* renamed from: b  reason: collision with root package name */
        int f5669b;

        /* renamed from: c  reason: collision with root package name */
        int f5670c = -1;

        a() {
            this.f5668a = l.this.modCount;
            this.f5669b = l.this.firstEntryIndex();
        }

        private void a() {
            if (l.this.modCount != this.f5668a) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5669b >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (hasNext()) {
                int i6 = this.f5669b;
                this.f5670c = i6;
                l lVar = l.this;
                Object obj = lVar.elements[i6];
                this.f5669b = lVar.getSuccessor(i6);
                return obj;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            i.d(this.f5670c >= 0);
            this.f5668a++;
            l lVar = l.this;
            lVar.remove(lVar.elements[this.f5670c], l.getHash(lVar.entries[this.f5670c]));
            this.f5669b = l.this.adjustAfterRemove(this.f5669b, this.f5670c);
            this.f5670c = -1;
        }
    }

    l() {
        init(3, DEFAULT_LOAD_FACTOR);
    }

    public static <E> l create() {
        return new l();
    }

    public static <E> l createWithExpectedSize(int i6) {
        return new l(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getHash(long j6) {
        return (int) (j6 >>> 32);
    }

    private static int getNext(long j6) {
        return (int) j6;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    private static long[] newEntries(int i6) {
        long[] jArr = new long[i6];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] newTable(int i6) {
        int[] iArr = new int[i6];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        init(3, DEFAULT_LOAD_FACTOR);
        int readInt = objectInputStream.readInt();
        while (true) {
            readInt--;
            if (readInt < 0) {
                return;
            }
            add(objectInputStream.readObject());
        }
    }

    private void resizeMeMaybe(int i6) {
        int length = this.entries.length;
        if (i6 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                resizeEntries(max);
            }
        }
    }

    private void resizeTable(int i6) {
        if (this.table.length >= MAXIMUM_CAPACITY) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i7 = ((int) (i6 * this.loadFactor)) + 1;
        int[] newTable = newTable(i6);
        long[] jArr = this.entries;
        int length = newTable.length - 1;
        for (int i8 = 0; i8 < this.size; i8++) {
            int hash = getHash(jArr[i8]);
            int i9 = hash & length;
            int i10 = newTable[i9];
            newTable[i9] = i8;
            jArr[i8] = (hash << 32) | (i10 & NEXT_MASK);
        }
        this.threshold = i7;
        this.table = newTable;
    }

    private static long swapNext(long j6, int i6) {
        return (j6 & HASH_MASK) | (NEXT_MASK & i6);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        Iterator<Object> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean add(@NullableDecl Object obj) {
        long[] jArr = this.entries;
        Object[] objArr = this.elements;
        int c6 = v.c(obj);
        int hashTableMask = hashTableMask() & c6;
        int i6 = this.size;
        int[] iArr = this.table;
        int i7 = iArr[hashTableMask];
        if (i7 == -1) {
            iArr[hashTableMask] = i6;
        } else {
            while (true) {
                long j6 = jArr[i7];
                if (getHash(j6) == c6 && com.google.common.base.h.a(obj, objArr[i7])) {
                    return false;
                }
                int next = getNext(j6);
                if (next == -1) {
                    jArr[i7] = swapNext(j6, i6);
                    break;
                }
                i7 = next;
            }
        }
        if (i6 != Integer.MAX_VALUE) {
            int i8 = i6 + 1;
            resizeMeMaybe(i8);
            insertEntry(i6, obj, c6);
            this.size = i8;
            if (i6 >= this.threshold) {
                resizeTable(this.table.length * 2);
            }
            this.modCount++;
            return true;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    int adjustAfterRemove(int i6, int i7) {
        return i6 - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.modCount++;
        Arrays.fill(this.elements, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        int c6 = v.c(obj);
        int i6 = this.table[hashTableMask() & c6];
        while (i6 != -1) {
            long j6 = this.entries[i6];
            if (getHash(j6) == c6 && com.google.common.base.h.a(obj, this.elements[i6])) {
                return true;
            }
            i6 = getNext(j6);
        }
        return false;
    }

    int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    int getSuccessor(int i6) {
        int i7 = i6 + 1;
        if (i7 < this.size) {
            return i7;
        }
        return -1;
    }

    void init(int i6, float f6) {
        com.google.common.base.j.e(i6 >= 0, "Initial capacity must be non-negative");
        com.google.common.base.j.e(f6 > 0.0f, "Illegal load factor");
        int a6 = v.a(i6, f6);
        this.table = newTable(a6);
        this.loadFactor = f6;
        this.elements = new Object[i6];
        this.entries = newEntries(i6);
        this.threshold = Math.max(1, (int) (a6 * f6));
    }

    void insertEntry(int i6, Object obj, int i7) {
        this.entries[i6] = (i7 << 32) | NEXT_MASK;
        this.elements[i6] = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Object> iterator() {
        return new a();
    }

    void moveEntry(int i6) {
        int size = size() - 1;
        if (i6 >= size) {
            this.elements[i6] = null;
            this.entries[i6] = -1;
            return;
        }
        Object[] objArr = this.elements;
        objArr[i6] = objArr[size];
        objArr[size] = null;
        long[] jArr = this.entries;
        long j6 = jArr[size];
        jArr[i6] = j6;
        jArr[size] = -1;
        int hash = getHash(j6) & hashTableMask();
        int[] iArr = this.table;
        int i7 = iArr[hash];
        if (i7 == size) {
            iArr[hash] = i6;
            return;
        }
        while (true) {
            long j7 = this.entries[i7];
            int next = getNext(j7);
            if (next == size) {
                this.entries[i7] = swapNext(j7, i6);
                return;
            }
            i7 = next;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj) {
        return remove(obj, v.c(obj));
    }

    void resizeEntries(int i6) {
        this.elements = Arrays.copyOf(this.elements, i6);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i6);
        if (i6 > length) {
            Arrays.fill(copyOf, length, i6, -1L);
        }
        this.entries = copyOf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return Arrays.copyOf(this.elements, this.size);
    }

    public void trimToSize() {
        int i6 = this.size;
        if (i6 < this.entries.length) {
            resizeEntries(i6);
        }
        int max = Math.max(1, Integer.highestOneBit((int) (i6 / this.loadFactor)));
        if (max < MAXIMUM_CAPACITY && i6 / max > this.loadFactor) {
            max <<= 1;
        }
        if (max < this.table.length) {
            resizeTable(max);
        }
    }

    l(int i6) {
        init(i6, DEFAULT_LOAD_FACTOR);
    }

    public static <E> l create(Collection<? extends E> collection) {
        l createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public boolean remove(Object obj, int i6) {
        int hashTableMask = hashTableMask() & i6;
        int i7 = this.table[hashTableMask];
        if (i7 == -1) {
            return false;
        }
        int i8 = -1;
        while (true) {
            if (getHash(this.entries[i7]) == i6 && com.google.common.base.h.a(obj, this.elements[i7])) {
                if (i8 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i7]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i8] = swapNext(jArr[i8], getNext(jArr[i7]));
                }
                moveEntry(i7);
                this.size--;
                this.modCount++;
                return true;
            }
            int next = getNext(this.entries[i7]);
            if (next == -1) {
                return false;
            }
            i8 = i7;
            i7 = next;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        return (T[]) a1.e(this.elements, 0, this.size, tArr);
    }

    public static <E> l create(E... eArr) {
        l createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }
}
