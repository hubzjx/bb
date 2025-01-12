package com.google.common.collect;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f1 extends a0 {
    private static final int ABSENT = -1;
    static final a0 EMPTY = new f1(null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    final transient Object[] alternatingKeysAndValues;
    private final transient int[] hashTable;
    private final transient int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends h0 {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int keyOffset;
        private final transient a0 map;
        private final transient int size;

        /* renamed from: com.google.common.collect.f1$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0056a extends y {
            C0056a() {
            }

            @Override // com.google.common.collect.w
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.size;
            }

            @Override // java.util.List
            public Map.Entry<Object, Object> get(int i6) {
                com.google.common.base.j.h(i6, a.this.size);
                int i7 = i6 * 2;
                return new AbstractMap.SimpleImmutableEntry(a.this.alternatingKeysAndValues[a.this.keyOffset + i7], a.this.alternatingKeysAndValues[i7 + (a.this.keyOffset ^ 1)]);
            }
        }

        a(a0 a0Var, Object[] objArr, int i6, int i7) {
            this.map = a0Var;
            this.alternatingKeysAndValues = objArr;
            this.keyOffset = i6;
            this.size = i7;
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                return value != null && value.equals(this.map.get(key));
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w
        public int copyIntoArray(Object[] objArr, int i6) {
            return asList().copyIntoArray(objArr, i6);
        }

        @Override // com.google.common.collect.h0
        y createAsList() {
            return new C0056a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public s1 iterator() {
            return asList().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.size;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends h0 {
        private final transient y list;
        private final transient a0 map;

        b(a0 a0Var, y yVar) {
            this.map = a0Var;
            this.list = yVar;
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.w
        public y asList() {
            return this.list;
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return this.map.get(obj) != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w
        public int copyIntoArray(Object[] objArr, int i6) {
            return asList().copyIntoArray(objArr, i6);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public s1 iterator() {
            return asList().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int offset;
        private final transient int size;

        c(Object[] objArr, int i6, int i7) {
            this.alternatingKeysAndValues = objArr;
            this.offset = i6;
            this.size = i7;
        }

        @Override // java.util.List
        public Object get(int i6) {
            com.google.common.base.j.h(i6, this.size);
            return this.alternatingKeysAndValues[(i6 * 2) + this.offset];
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }
    }

    private f1(int[] iArr, Object[] objArr, int i6) {
        this.hashTable = iArr;
        this.alternatingKeysAndValues = objArr;
        this.size = i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> f1 create(int i6, Object[] objArr) {
        if (i6 == 0) {
            return (f1) EMPTY;
        }
        if (i6 == 1) {
            i.a(objArr[0], objArr[1]);
            return new f1(null, objArr, 1);
        }
        com.google.common.base.j.l(i6, objArr.length >> 1);
        return new f1(createHashTable(objArr, i6, h0.chooseTableSize(i6), 0), objArr, i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        r12[r7] = r5;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static int[] createHashTable(Object[] objArr, int i6, int i7, int i8) {
        if (i6 == 1) {
            i.a(objArr[i8], objArr[i8 ^ 1]);
            return null;
        }
        int i9 = i7 - 1;
        int[] iArr = new int[i7];
        Arrays.fill(iArr, -1);
        int i10 = 0;
        while (i10 < i6) {
            int i11 = i10 * 2;
            int i12 = i11 + i8;
            Object obj = objArr[i12];
            Object obj2 = objArr[i11 + (i8 ^ 1)];
            i.a(obj, obj2);
            int b6 = v.b(obj.hashCode());
            while (true) {
                int i13 = b6 & i9;
                int i14 = iArr[i13];
                if (i14 == -1) {
                    break;
                } else if (objArr[i14].equals(obj)) {
                    throw new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i14] + "=" + objArr[i14 ^ 1]);
                } else {
                    b6 = i13 + 1;
                }
            }
        }
        return iArr;
    }

    @Override // com.google.common.collect.a0
    h0 createEntrySet() {
        return new a(this, this.alternatingKeysAndValues, 0, this.size);
    }

    @Override // com.google.common.collect.a0
    h0 createKeySet() {
        return new b(this, new c(this.alternatingKeysAndValues, 0, this.size));
    }

    @Override // com.google.common.collect.a0
    w createValues() {
        return new c(this.alternatingKeysAndValues, 1, this.size);
    }

    @Override // com.google.common.collect.a0, java.util.Map
    @NullableDecl
    public Object get(@NullableDecl Object obj) {
        return get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.a0
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }

    static Object get(@NullableDecl int[] iArr, @NullableDecl Object[] objArr, int i6, int i7, @NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        if (i6 == 1) {
            if (objArr[i7].equals(obj)) {
                return objArr[i7 ^ 1];
            }
            return null;
        } else if (iArr == null) {
            return null;
        } else {
            int length = iArr.length - 1;
            int b6 = v.b(obj.hashCode());
            while (true) {
                int i8 = b6 & length;
                int i9 = iArr[i8];
                if (i9 == -1) {
                    return null;
                }
                if (objArr[i9].equals(obj)) {
                    return objArr[i9 ^ 1];
                }
                b6 = i8 + 1;
            }
        }
    }
}
