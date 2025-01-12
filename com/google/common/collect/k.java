package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends AbstractMap implements Serializable {
    static final float DEFAULT_LOAD_FACTOR = 1.0f;
    static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;
    @MonotonicNonNullDecl
    transient long[] entries;
    @MonotonicNonNullDecl
    private transient Set<Map.Entry<Object, Object>> entrySetView;
    @MonotonicNonNullDecl
    private transient Set<Object> keySetView;
    @MonotonicNonNullDecl
    transient Object[] keys;
    transient float loadFactor;
    transient int modCount;
    private transient int size;
    @MonotonicNonNullDecl
    private transient int[] table;
    private transient int threshold;
    @MonotonicNonNullDecl
    transient Object[] values;
    @MonotonicNonNullDecl
    private transient Collection<Object> valuesView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends e {
        a() {
            super(k.this, null);
        }

        @Override // com.google.common.collect.k.e
        Object b(int i6) {
            return k.this.keys[i6];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends e {
        b() {
            super(k.this, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.k.e
        /* renamed from: c */
        public Map.Entry b(int i6) {
            return new g(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends e {
        c() {
            super(k.this, null);
        }

        @Override // com.google.common.collect.k.e
        Object b(int i6) {
            return k.this.values[i6];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AbstractSet {
        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            k.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int indexOf = k.this.indexOf(entry.getKey());
                return indexOf != -1 && com.google.common.base.h.a(k.this.values[indexOf], entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return k.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int indexOf = k.this.indexOf(entry.getKey());
                if (indexOf == -1 || !com.google.common.base.h.a(k.this.values[indexOf], entry.getValue())) {
                    return false;
                }
                k.this.removeEntry(indexOf);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return k.this.size;
        }
    }

    /* loaded from: classes.dex */
    private abstract class e implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        int f5659a;

        /* renamed from: b  reason: collision with root package name */
        int f5660b;

        /* renamed from: c  reason: collision with root package name */
        int f5661c;

        private e() {
            this.f5659a = k.this.modCount;
            this.f5660b = k.this.firstEntryIndex();
            this.f5661c = -1;
        }

        private void a() {
            if (k.this.modCount != this.f5659a) {
                throw new ConcurrentModificationException();
            }
        }

        abstract Object b(int i6);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5660b >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (hasNext()) {
                int i6 = this.f5660b;
                this.f5661c = i6;
                Object b6 = b(i6);
                this.f5660b = k.this.getSuccessor(this.f5660b);
                return b6;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            i.d(this.f5661c >= 0);
            this.f5659a++;
            k.this.removeEntry(this.f5661c);
            this.f5660b = k.this.adjustAfterRemove(this.f5660b, this.f5661c);
            this.f5661c = -1;
        }

        /* synthetic */ e(k kVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends AbstractSet {
        f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            k.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return k.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return k.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int indexOf = k.this.indexOf(obj);
            if (indexOf == -1) {
                return false;
            }
            k.this.removeEntry(indexOf);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return k.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class g extends com.google.common.collect.c {

        /* renamed from: a  reason: collision with root package name */
        private final Object f5664a;

        /* renamed from: b  reason: collision with root package name */
        private int f5665b;

        g(int i6) {
            this.f5664a = k.this.keys[i6];
            this.f5665b = i6;
        }

        private void a() {
            int i6 = this.f5665b;
            if (i6 == -1 || i6 >= k.this.size() || !com.google.common.base.h.a(this.f5664a, k.this.keys[this.f5665b])) {
                this.f5665b = k.this.indexOf(this.f5664a);
            }
        }

        @Override // com.google.common.collect.c, java.util.Map.Entry
        public Object getKey() {
            return this.f5664a;
        }

        @Override // com.google.common.collect.c, java.util.Map.Entry
        public Object getValue() {
            a();
            int i6 = this.f5665b;
            if (i6 == -1) {
                return null;
            }
            return k.this.values[i6];
        }

        @Override // com.google.common.collect.c, java.util.Map.Entry
        public Object setValue(Object obj) {
            a();
            int i6 = this.f5665b;
            if (i6 == -1) {
                k.this.put(this.f5664a, obj);
                return null;
            }
            Object[] objArr = k.this.values;
            Object obj2 = objArr[i6];
            objArr[i6] = obj;
            return obj2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends AbstractCollection {
        h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            k.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return k.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return k.this.size;
        }
    }

    k() {
        init(3, DEFAULT_LOAD_FACTOR);
    }

    public static <K, V> k create() {
        return new k();
    }

    public static <K, V> k createWithExpectedSize(int i6) {
        return new k(i6);
    }

    private static int getHash(long j6) {
        return (int) (j6 >>> 32);
    }

    private static int getNext(long j6) {
        return (int) j6;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOf(@NullableDecl Object obj) {
        int c6 = v.c(obj);
        int i6 = this.table[hashTableMask() & c6];
        while (i6 != -1) {
            long j6 = this.entries[i6];
            if (getHash(j6) == c6 && com.google.common.base.h.a(obj, this.keys[i6])) {
                return i6;
            }
            i6 = getNext(j6);
        }
        return -1;
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
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public Object removeEntry(int i6) {
        return remove(this.keys[i6], getHash(this.entries[i6]));
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
        for (int i6 = 0; i6 < this.size; i6++) {
            objectOutputStream.writeObject(this.keys[i6]);
            objectOutputStream.writeObject(this.values[i6]);
        }
    }

    void accessEntry(int i6) {
    }

    int adjustAfterRemove(int i6, int i7) {
        return i6 - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        for (int i6 = 0; i6 < this.size; i6++) {
            if (com.google.common.base.h.a(obj, this.values[i6])) {
                return true;
            }
        }
        return false;
    }

    Set<Map.Entry<Object, Object>> createEntrySet() {
        return new d();
    }

    Set<Object> createKeySet() {
        return new f();
    }

    Collection<Object> createValues() {
        return new h();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        Set<Map.Entry<Object, Object>> set = this.entrySetView;
        if (set == null) {
            Set<Map.Entry<Object, Object>> createEntrySet = createEntrySet();
            this.entrySetView = createEntrySet;
            return createEntrySet;
        }
        return set;
    }

    Iterator<Map.Entry<Object, Object>> entrySetIterator() {
        return new b();
    }

    int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(@NullableDecl Object obj) {
        int indexOf = indexOf(obj);
        accessEntry(indexOf);
        if (indexOf == -1) {
            return null;
        }
        return this.values[indexOf];
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
        this.keys = new Object[i6];
        this.values = new Object[i6];
        this.entries = newEntries(i6);
        this.threshold = Math.max(1, (int) (a6 * f6));
    }

    void insertEntry(int i6, @NullableDecl Object obj, @NullableDecl Object obj2, int i7) {
        this.entries[i6] = (i7 << 32) | NEXT_MASK;
        this.keys[i6] = obj;
        this.values[i6] = obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Object> keySet() {
        Set<Object> set = this.keySetView;
        if (set == null) {
            Set<Object> createKeySet = createKeySet();
            this.keySetView = createKeySet;
            return createKeySet;
        }
        return set;
    }

    Iterator<Object> keySetIterator() {
        return new a();
    }

    void moveLastEntry(int i6) {
        int size = size() - 1;
        if (i6 >= size) {
            this.keys[i6] = null;
            this.values[i6] = null;
            this.entries[i6] = -1;
            return;
        }
        Object[] objArr = this.keys;
        objArr[i6] = objArr[size];
        Object[] objArr2 = this.values;
        objArr2[i6] = objArr2[size];
        objArr[size] = null;
        objArr2[size] = null;
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

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public Object put(@NullableDecl Object obj, @NullableDecl Object obj2) {
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
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
                    Object obj3 = objArr2[i7];
                    objArr2[i7] = obj2;
                    accessEntry(i7);
                    return obj3;
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
            insertEntry(i6, obj, obj2, c6);
            this.size = i8;
            if (i6 >= this.threshold) {
                resizeTable(this.table.length * 2);
            }
            this.modCount++;
            return null;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public Object remove(@NullableDecl Object obj) {
        return remove(obj, v.c(obj));
    }

    void resizeEntries(int i6) {
        this.keys = Arrays.copyOf(this.keys, i6);
        this.values = Arrays.copyOf(this.values, i6);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i6);
        if (i6 > length) {
            Arrays.fill(copyOf, length, i6, -1L);
        }
        this.entries = copyOf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
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

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<Object> values() {
        Collection<Object> collection = this.valuesView;
        if (collection == null) {
            Collection<Object> createValues = createValues();
            this.valuesView = createValues;
            return createValues;
        }
        return collection;
    }

    Iterator<Object> valuesIterator() {
        return new c();
    }

    k(int i6) {
        this(i6, DEFAULT_LOAD_FACTOR);
    }

    @NullableDecl
    private Object remove(@NullableDecl Object obj, int i6) {
        int hashTableMask = hashTableMask() & i6;
        int i7 = this.table[hashTableMask];
        if (i7 == -1) {
            return null;
        }
        int i8 = -1;
        while (true) {
            if (getHash(this.entries[i7]) == i6 && com.google.common.base.h.a(obj, this.keys[i7])) {
                Object obj2 = this.values[i7];
                if (i8 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i7]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i8] = swapNext(jArr[i8], getNext(jArr[i7]));
                }
                moveLastEntry(i7);
                this.size--;
                this.modCount++;
                return obj2;
            }
            int next = getNext(this.entries[i7]);
            if (next == -1) {
                return null;
            }
            i8 = i7;
            i7 = next;
        }
    }

    k(int i6, float f6) {
        init(i6, f6);
    }
}
