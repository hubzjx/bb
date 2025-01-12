package com.google.gson.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes.dex */
public final class h extends AbstractMap implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new a();
    Comparator<Object> comparator;
    private com.google.gson.internal.h.b entrySet;
    final e header;
    private com.google.gson.internal.h.c keySet;
    int modCount;
    e root;
    int size;

    /* loaded from: classes.dex */
    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* loaded from: classes.dex */
    class b extends AbstractSet {

        /* loaded from: classes.dex */
        class a extends d {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public Map.Entry next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e findByEntry;
            if ((obj instanceof Map.Entry) && (findByEntry = h.this.findByEntry((Map.Entry) obj)) != null) {
                h.this.removeInternal(findByEntry, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.size;
        }
    }

    /* loaded from: classes.dex */
    final class c extends AbstractSet {

        /* loaded from: classes.dex */
        class a extends d {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return a().f5817f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class d implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        e f5808a;

        /* renamed from: b  reason: collision with root package name */
        e f5809b = null;

        /* renamed from: c  reason: collision with root package name */
        int f5810c;

        d() {
            this.f5808a = h.this.header.f5815d;
            this.f5810c = h.this.modCount;
        }

        final e a() {
            e eVar = this.f5808a;
            h hVar = h.this;
            if (eVar != hVar.header) {
                if (hVar.modCount == this.f5810c) {
                    this.f5808a = eVar.f5815d;
                    this.f5809b = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f5808a != h.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e eVar = this.f5809b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            h.this.removeInternal(eVar, true);
            this.f5809b = null;
            this.f5810c = h.this.modCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e implements Map.Entry {

        /* renamed from: a  reason: collision with root package name */
        e f5812a;

        /* renamed from: b  reason: collision with root package name */
        e f5813b;

        /* renamed from: c  reason: collision with root package name */
        e f5814c;

        /* renamed from: d  reason: collision with root package name */
        e f5815d;

        /* renamed from: e  reason: collision with root package name */
        e f5816e;

        /* renamed from: f  reason: collision with root package name */
        final Object f5817f;

        /* renamed from: g  reason: collision with root package name */
        Object f5818g;

        /* renamed from: h  reason: collision with root package name */
        int f5819h;

        e() {
            this.f5817f = null;
            this.f5816e = this;
            this.f5815d = this;
        }

        public e a() {
            e eVar = this;
            for (e eVar2 = this.f5813b; eVar2 != null; eVar2 = eVar2.f5813b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e b() {
            e eVar = this;
            for (e eVar2 = this.f5814c; eVar2 != null; eVar2 = eVar2.f5814c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = this.f5817f;
                if (obj2 == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!obj2.equals(entry.getKey())) {
                    return false;
                }
                Object obj3 = this.f5818g;
                Object value = entry.getValue();
                if (obj3 == null) {
                    if (value != null) {
                        return false;
                    }
                } else if (!obj3.equals(value)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f5817f;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f5818g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f5817f;
            int hashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.f5818g;
            return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.f5818g;
            this.f5818g = obj;
            return obj2;
        }

        public String toString() {
            return this.f5817f + "=" + this.f5818g;
        }

        e(e eVar, Object obj, e eVar2, e eVar3) {
            this.f5812a = eVar;
            this.f5817f = obj;
            this.f5819h = 1;
            this.f5815d = eVar2;
            this.f5816e = eVar3;
            eVar3.f5815d = this;
            eVar2.f5816e = this;
        }
    }

    public h() {
        this(NATURAL_ORDER);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private void rebalance(e eVar, boolean z5) {
        while (eVar != null) {
            e eVar2 = eVar.f5813b;
            e eVar3 = eVar.f5814c;
            int i6 = eVar2 != null ? eVar2.f5819h : 0;
            int i7 = eVar3 != null ? eVar3.f5819h : 0;
            int i8 = i6 - i7;
            if (i8 == -2) {
                e eVar4 = eVar3.f5813b;
                e eVar5 = eVar3.f5814c;
                int i9 = (eVar4 != null ? eVar4.f5819h : 0) - (eVar5 != null ? eVar5.f5819h : 0);
                if (i9 != -1 && (i9 != 0 || z5)) {
                    rotateRight(eVar3);
                }
                rotateLeft(eVar);
                if (z5) {
                    return;
                }
            } else if (i8 == 2) {
                e eVar6 = eVar2.f5813b;
                e eVar7 = eVar2.f5814c;
                int i10 = (eVar6 != null ? eVar6.f5819h : 0) - (eVar7 != null ? eVar7.f5819h : 0);
                if (i10 != 1 && (i10 != 0 || z5)) {
                    rotateLeft(eVar2);
                }
                rotateRight(eVar);
                if (z5) {
                    return;
                }
            } else if (i8 == 0) {
                eVar.f5819h = i6 + 1;
                if (z5) {
                    return;
                }
            } else {
                eVar.f5819h = Math.max(i6, i7) + 1;
                if (!z5) {
                    return;
                }
            }
            eVar = eVar.f5812a;
        }
    }

    private void replaceInParent(e eVar, e eVar2) {
        e eVar3 = eVar.f5812a;
        eVar.f5812a = null;
        if (eVar2 != null) {
            eVar2.f5812a = eVar3;
        }
        if (eVar3 == null) {
            this.root = eVar2;
        } else if (eVar3.f5813b == eVar) {
            eVar3.f5813b = eVar2;
        } else {
            eVar3.f5814c = eVar2;
        }
    }

    private void rotateLeft(e eVar) {
        e eVar2 = eVar.f5813b;
        e eVar3 = eVar.f5814c;
        e eVar4 = eVar3.f5813b;
        e eVar5 = eVar3.f5814c;
        eVar.f5814c = eVar4;
        if (eVar4 != null) {
            eVar4.f5812a = eVar;
        }
        replaceInParent(eVar, eVar3);
        eVar3.f5813b = eVar;
        eVar.f5812a = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.f5819h : 0, eVar4 != null ? eVar4.f5819h : 0) + 1;
        eVar.f5819h = max;
        eVar3.f5819h = Math.max(max, eVar5 != null ? eVar5.f5819h : 0) + 1;
    }

    private void rotateRight(e eVar) {
        e eVar2 = eVar.f5813b;
        e eVar3 = eVar.f5814c;
        e eVar4 = eVar2.f5813b;
        e eVar5 = eVar2.f5814c;
        eVar.f5813b = eVar5;
        if (eVar5 != null) {
            eVar5.f5812a = eVar;
        }
        replaceInParent(eVar, eVar2);
        eVar2.f5814c = eVar;
        eVar.f5812a = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.f5819h : 0, eVar5 != null ? eVar5.f5819h : 0) + 1;
        eVar.f5819h = max;
        eVar2.f5819h = Math.max(max, eVar4 != null ? eVar4.f5819h : 0) + 1;
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e eVar = this.header;
        eVar.f5816e = eVar;
        eVar.f5815d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        com.google.gson.internal.h.b bVar = this.entrySet;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        this.entrySet = bVar2;
        return bVar2;
    }

    e find(Object obj, boolean z5) {
        int i6;
        e eVar;
        Comparator<Object> comparator = this.comparator;
        e eVar2 = this.root;
        if (eVar2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) obj : null;
            while (true) {
                Object obj2 = eVar2.f5817f;
                i6 = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (i6 == 0) {
                    return eVar2;
                }
                e eVar3 = i6 < 0 ? eVar2.f5813b : eVar2.f5814c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i6 = 0;
        }
        if (z5) {
            e eVar4 = this.header;
            if (eVar2 != null) {
                eVar = new e(eVar2, obj, eVar4, eVar4.f5816e);
                if (i6 < 0) {
                    eVar2.f5813b = eVar;
                } else {
                    eVar2.f5814c = eVar;
                }
                rebalance(eVar2, true);
            } else if (comparator == NATURAL_ORDER && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            } else {
                eVar = new e(eVar2, obj, eVar4, eVar4.f5816e);
                this.root = eVar;
            }
            this.size++;
            this.modCount++;
            return eVar;
        }
        return null;
    }

    e findByEntry(Map.Entry<?, ?> entry) {
        e findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.f5818g, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    e findByObject(Object obj) {
        if (obj != null) {
            try {
                return find(obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        e findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.f5818g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Object> keySet() {
        com.google.gson.internal.h.c cVar = this.keySet;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.keySet = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj != null) {
            e find = find(obj, true);
            Object obj3 = find.f5818g;
            find.f5818g = obj2;
            return obj3;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        e removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f5818g;
        }
        return null;
    }

    void removeInternal(e eVar, boolean z5) {
        int i6;
        if (z5) {
            e eVar2 = eVar.f5816e;
            eVar2.f5815d = eVar.f5815d;
            eVar.f5815d.f5816e = eVar2;
        }
        e eVar3 = eVar.f5813b;
        e eVar4 = eVar.f5814c;
        e eVar5 = eVar.f5812a;
        int i7 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                replaceInParent(eVar, eVar3);
                eVar.f5813b = null;
            } else if (eVar4 != null) {
                replaceInParent(eVar, eVar4);
                eVar.f5814c = null;
            } else {
                replaceInParent(eVar, null);
            }
            rebalance(eVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        e b6 = eVar3.f5819h > eVar4.f5819h ? eVar3.b() : eVar4.a();
        removeInternal(b6, false);
        e eVar6 = eVar.f5813b;
        if (eVar6 != null) {
            i6 = eVar6.f5819h;
            b6.f5813b = eVar6;
            eVar6.f5812a = b6;
            eVar.f5813b = null;
        } else {
            i6 = 0;
        }
        e eVar7 = eVar.f5814c;
        if (eVar7 != null) {
            i7 = eVar7.f5819h;
            b6.f5814c = eVar7;
            eVar7.f5812a = b6;
            eVar.f5814c = null;
        }
        b6.f5819h = Math.max(i6, i7) + 1;
        replaceInParent(eVar, b6);
    }

    e removeInternalByKey(Object obj) {
        e findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public h(Comparator<Object> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new e();
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
    }
}
