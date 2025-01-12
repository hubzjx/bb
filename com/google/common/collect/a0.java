package com.google.common.collect;

import com.google.common.collect.w;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public abstract class a0 implements Map, Serializable, j$.util.Map {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    @LazyInit
    private transient h0 entrySet;
    @RetainedWith
    @LazyInit
    private transient h0 keySet;
    @LazyInit
    private transient i0 multimapView;
    @RetainedWith
    @LazyInit
    private transient w values;

    /* loaded from: classes.dex */
    class a extends s1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s1 f5598a;

        a(s1 s1Var) {
            this.f5598a = s1Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5598a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return ((Map.Entry) this.f5598a.next()).getKey();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        Comparator f5600a;

        /* renamed from: b  reason: collision with root package name */
        Object[] f5601b;

        /* renamed from: c  reason: collision with root package name */
        int f5602c;

        /* renamed from: d  reason: collision with root package name */
        boolean f5603d;

        public b() {
            this(4);
        }

        private void b(int i6) {
            int i7 = i6 * 2;
            Object[] objArr = this.f5601b;
            if (i7 > objArr.length) {
                this.f5601b = Arrays.copyOf(objArr, w.b.e(objArr.length, i7));
                this.f5603d = false;
            }
        }

        public a0 a() {
            f();
            this.f5603d = true;
            return f1.create(this.f5602c, this.f5601b);
        }

        public b c(Object obj, Object obj2) {
            b(this.f5602c + 1);
            i.a(obj, obj2);
            Object[] objArr = this.f5601b;
            int i6 = this.f5602c;
            objArr[i6 * 2] = obj;
            objArr[(i6 * 2) + 1] = obj2;
            this.f5602c = i6 + 1;
            return this;
        }

        public b d(Map.Entry entry) {
            return c(entry.getKey(), entry.getValue());
        }

        public b e(Iterable iterable) {
            if (iterable instanceof Collection) {
                b(this.f5602c + ((Collection) iterable).size());
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                d((Map.Entry) it.next());
            }
            return this;
        }

        void f() {
            int i6;
            if (this.f5600a != null) {
                if (this.f5603d) {
                    this.f5601b = Arrays.copyOf(this.f5601b, this.f5602c * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.f5602c];
                int i7 = 0;
                while (true) {
                    i6 = this.f5602c;
                    if (i7 >= i6) {
                        break;
                    }
                    Object[] objArr = this.f5601b;
                    int i8 = i7 * 2;
                    entryArr[i7] = new AbstractMap.SimpleImmutableEntry(objArr[i8], objArr[i8 + 1]);
                    i7++;
                }
                Arrays.sort(entryArr, 0, i6, c1.from(this.f5600a).onResultOf(s0.k()));
                for (int i9 = 0; i9 < this.f5602c; i9++) {
                    int i10 = i9 * 2;
                    this.f5601b[i10] = entryArr[i9].getKey();
                    this.f5601b[i10 + 1] = entryArr[i9].getValue();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i6) {
            this.f5601b = new Object[i6 * 2];
            this.f5602c = 0;
            this.f5603d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c extends a0 {

        /* loaded from: classes.dex */
        class a extends b0 {
            a() {
            }

            @Override // com.google.common.collect.h0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public s1 iterator() {
                return c.this.entryIterator();
            }

            @Override // com.google.common.collect.b0
            a0 map() {
                return c.this;
            }
        }

        c() {
        }

        @Override // com.google.common.collect.a0
        h0 createEntrySet() {
            return new a();
        }

        @Override // com.google.common.collect.a0
        h0 createKeySet() {
            return new c0(this);
        }

        @Override // com.google.common.collect.a0
        w createValues() {
            return new d0(this);
        }

        abstract s1 entryIterator();

        @Override // com.google.common.collect.a0, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.a0, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.a0, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* loaded from: classes.dex */
    private final class d extends c {

        /* loaded from: classes.dex */
        class a extends s1 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Iterator f5604a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.google.common.collect.a0$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0054a extends com.google.common.collect.c {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Map.Entry f5606a;

                C0054a(Map.Entry entry) {
                    this.f5606a = entry;
                }

                @Override // com.google.common.collect.c, java.util.Map.Entry
                /* renamed from: a */
                public h0 getValue() {
                    return h0.of(this.f5606a.getValue());
                }

                @Override // com.google.common.collect.c, java.util.Map.Entry
                public Object getKey() {
                    return this.f5606a.getKey();
                }
            }

            a(Iterator it) {
                this.f5604a = it;
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry next() {
                return new C0054a((Map.Entry) this.f5604a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f5604a.hasNext();
            }
        }

        private d() {
        }

        @Override // com.google.common.collect.a0, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return a0.this.containsKey(obj);
        }

        @Override // com.google.common.collect.a0.c, com.google.common.collect.a0
        h0 createKeySet() {
            return a0.this.keySet();
        }

        @Override // com.google.common.collect.a0.c
        s1 entryIterator() {
            return new a(a0.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.a0, java.util.Map
        public h0 get(@NullableDecl Object obj) {
            Object obj2 = a0.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return h0.of(obj2);
        }

        @Override // com.google.common.collect.a0, java.util.Map
        public int hashCode() {
            return a0.this.hashCode();
        }

        @Override // com.google.common.collect.a0
        boolean isHashCodeFast() {
            return a0.this.isHashCodeFast();
        }

        @Override // com.google.common.collect.a0
        boolean isPartialView() {
            return a0.this.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return a0.this.size();
        }

        /* synthetic */ d(a0 a0Var, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    static class e implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        e(a0 a0Var) {
            this.keys = new Object[a0Var.size()];
            this.values = new Object[a0Var.size()];
            s1 it = a0Var.entrySet().iterator();
            int i6 = 0;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                this.keys[i6] = entry.getKey();
                this.values[i6] = entry.getValue();
                i6++;
            }
        }

        Object createMap(b bVar) {
            int i6 = 0;
            while (true) {
                Object[] objArr = this.keys;
                if (i6 >= objArr.length) {
                    return bVar.a();
                }
                bVar.c(objArr[i6], this.values[i6]);
                i6++;
            }
        }

        Object readResolve() {
            return createMap(new b(this.keys.length));
        }
    }

    public static <K, V> b builder() {
        return new b();
    }

    public static <K, V> b builderWithExpectedSize(int i6) {
        i.b(i6, "expectedSize");
        return new b(i6);
    }

    static void checkNoConflict(boolean z5, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (!z5) {
            throw conflictException(str, entry, entry2);
        }
    }

    static IllegalArgumentException conflictException(String str, Object obj, Object obj2) {
        return new IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
    }

    public static <K, V> a0 copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        b bVar = new b(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        bVar.e(iterable);
        return bVar.a();
    }

    static <K, V> Map.Entry<K, V> entryOf(K k6, V v5) {
        i.a(k6, v5);
        return new AbstractMap.SimpleImmutableEntry(k6, v5);
    }

    public static <K, V> a0 of() {
        return f1.EMPTY;
    }

    public i0 asMultimap() {
        if (isEmpty()) {
            return i0.of();
        }
        i0 i0Var = this.multimapView;
        if (i0Var == null) {
            i0 i0Var2 = new i0(new d(this, null), size(), null);
            this.multimapView = i0Var2;
            return i0Var2;
        }
        return i0Var;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
    }

    @Override // java.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    abstract h0 createEntrySet();

    abstract h0 createKeySet();

    abstract w createValues();

    @Override // java.util.Map
    public h0 entrySet() {
        h0 h0Var = this.entrySet;
        if (h0Var == null) {
            h0 createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }
        return h0Var;
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        return s0.c(this, obj);
    }

    @Override // java.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    @Override // java.util.Map
    public abstract Object get(@NullableDecl Object obj);

    @Override // java.util.Map, j$.util.Map
    public final Object getOrDefault(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public int hashCode() {
        return m1.b(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isHashCodeFast() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isPartialView();

    /* JADX INFO: Access modifiers changed from: package-private */
    public s1 keyIterator() {
        return new a(entrySet().iterator());
    }

    @Override // java.util.Map
    public h0 keySet() {
        h0 h0Var = this.keySet;
        if (h0Var == null) {
            h0 createKeySet = createKeySet();
            this.keySet = createKeySet;
            return createKeySet;
        }
        return h0Var;
    }

    @Override // java.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<Object, Object> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return get(obj);
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return get(obj);
    }

    @Override // java.util.Map
    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public String toString() {
        return s0.j(this);
    }

    @Override // java.util.Map
    public w values() {
        w wVar = this.values;
        if (wVar == null) {
            w createValues = createValues();
            this.values = createValues;
            return createValues;
        }
        return wVar;
    }

    Object writeReplace() {
        return new e(this);
    }

    public static <K, V> a0 copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof a0) && !(map instanceof SortedMap)) {
            a0 a0Var = (a0) map;
            if (!a0Var.isPartialView()) {
                return a0Var;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> a0 of(K k6, V v5) {
        i.a(k6, v5);
        return f1.create(1, new Object[]{k6, v5});
    }

    @Override // j$.util.Map
    public /* synthetic */ Object compute(Object obj, j$.util.function.BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, j$.util.function.Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, j$.util.function.BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(j$.util.function.BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, j$.util.function.BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.$default$remove(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.CC.$default$replace(this, obj, obj2, obj3);
    }

    @Override // j$.util.Map
    public /* synthetic */ void replaceAll(j$.util.function.BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    public static <K, V> a0 of(K k6, V v5, K k7, V v6) {
        i.a(k6, v5);
        i.a(k7, v6);
        return f1.create(2, new Object[]{k6, v5, k7, v6});
    }

    public static <K, V> a0 of(K k6, V v5, K k7, V v6, K k8, V v7) {
        i.a(k6, v5);
        i.a(k7, v6);
        i.a(k8, v7);
        return f1.create(3, new Object[]{k6, v5, k7, v6, k8, v7});
    }

    public static <K, V> a0 of(K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8) {
        i.a(k6, v5);
        i.a(k7, v6);
        i.a(k8, v7);
        i.a(k9, v8);
        return f1.create(4, new Object[]{k6, v5, k7, v6, k8, v7, k9, v8});
    }

    public static <K, V> a0 of(K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9) {
        i.a(k6, v5);
        i.a(k7, v6);
        i.a(k8, v7);
        i.a(k9, v8);
        i.a(k10, v9);
        return f1.create(5, new Object[]{k6, v5, k7, v6, k8, v7, k9, v8, k10, v9});
    }
}
