package com.google.common.collect;

import com.google.common.collect.l1;
import com.google.common.collect.v0;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public abstract class e0 extends com.google.common.collect.g implements Serializable {
    private static final long serialVersionUID = 0;
    final transient a0 map;
    final transient int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s1 {

        /* renamed from: a  reason: collision with root package name */
        final Iterator f5632a;

        /* renamed from: b  reason: collision with root package name */
        Object f5633b = null;

        /* renamed from: c  reason: collision with root package name */
        Iterator f5634c = n0.e();

        a() {
            this.f5632a = e0.this.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry next() {
            if (!this.f5634c.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f5632a.next();
                this.f5633b = entry.getKey();
                this.f5634c = ((w) entry.getValue()).iterator();
            }
            return s0.d(this.f5633b, this.f5634c.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5634c.hasNext() || this.f5632a.hasNext();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends s1 {

        /* renamed from: a  reason: collision with root package name */
        Iterator f5636a;

        /* renamed from: b  reason: collision with root package name */
        Iterator f5637b = n0.e();

        b() {
            this.f5636a = e0.this.map.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5637b.hasNext() || this.f5636a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f5637b.hasNext()) {
                this.f5637b = ((w) this.f5636a.next()).iterator();
            }
            return this.f5637b.next();
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        Map f5639a = d1.d();

        /* renamed from: b  reason: collision with root package name */
        Comparator f5640b;

        /* renamed from: c  reason: collision with root package name */
        Comparator f5641c;

        public e0 a() {
            Collection entrySet = this.f5639a.entrySet();
            Comparator comparator = this.f5640b;
            if (comparator != null) {
                entrySet = c1.from(comparator).onKeys().immutableSortedCopy(entrySet);
            }
            return z.fromMapEntries(entrySet, this.f5641c);
        }

        Collection b() {
            return new ArrayList();
        }

        public c c(Object obj, Object obj2) {
            i.a(obj, obj2);
            Collection collection = (Collection) this.f5639a.get(obj);
            if (collection == null) {
                Map map = this.f5639a;
                Collection b6 = b();
                map.put(obj, b6);
                collection = b6;
            }
            collection.add(obj2);
            return this;
        }

        public c d(Map.Entry entry) {
            return c(entry.getKey(), entry.getValue());
        }

        public c e(Iterable iterable) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                d((Map.Entry) it.next());
            }
            return this;
        }

        public c f(Object obj, Iterable iterable) {
            if (obj == null) {
                throw new NullPointerException("null key in entry: null=" + m0.g(iterable));
            }
            Collection collection = (Collection) this.f5639a.get(obj);
            Iterator it = iterable.iterator();
            if (collection != null) {
                while (it.hasNext()) {
                    Object next = it.next();
                    i.a(obj, next);
                    collection.add(next);
                }
                return this;
            } else if (it.hasNext()) {
                Collection b6 = b();
                while (it.hasNext()) {
                    Object next2 = it.next();
                    i.a(obj, next2);
                    b6.add(next2);
                }
                this.f5639a.put(obj, b6);
                return this;
            } else {
                return this;
            }
        }

        public c g(Object obj, Object... objArr) {
            return f(obj, Arrays.asList(objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends w {
        private static final long serialVersionUID = 0;
        @Weak
        final e0 multimap;

        d(e0 e0Var) {
            this.multimap = e0Var;
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.multimap.containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public s1 iterator() {
            return this.multimap.m0entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }
    }

    /* loaded from: classes.dex */
    static class e {

        /* renamed from: a  reason: collision with root package name */
        static final l1.b f5642a = l1.a(e0.class, "map");

        /* renamed from: b  reason: collision with root package name */
        static final l1.b f5643b = l1.a(e0.class, "size");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends f0 {
        f() {
        }

        @Override // com.google.common.collect.f0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return e0.this.containsKey(obj);
        }

        @Override // com.google.common.collect.f0, com.google.common.collect.v0
        public int count(@NullableDecl Object obj) {
            Collection collection = (Collection) e0.this.map.get(obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.common.collect.f0, com.google.common.collect.v0
        public h0 elementSet() {
            return e0.this.m2keySet();
        }

        @Override // com.google.common.collect.f0
        v0.a getEntry(int i6) {
            Map.Entry entry = (Map.Entry) e0.this.map.entrySet().asList().get(i6);
            return w0.f(entry.getKey(), ((Collection) entry.getValue()).size());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.v0
        public int size() {
            return e0.this.size();
        }

        @Override // com.google.common.collect.f0, com.google.common.collect.w
        Object writeReplace() {
            return new g(e0.this);
        }
    }

    /* loaded from: classes.dex */
    private static final class g implements Serializable {
        final e0 multimap;

        g(e0 e0Var) {
            this.multimap = e0Var;
        }

        Object readResolve() {
            return this.multimap.keys();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class h extends w {
        private static final long serialVersionUID = 0;
        @Weak
        private final transient e0 multimap;

        h(e0 e0Var) {
            this.multimap = e0Var;
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return this.multimap.containsValue(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w
        public int copyIntoArray(Object[] objArr, int i6) {
            s1 it = this.multimap.map.values().iterator();
            while (it.hasNext()) {
                i6 = ((w) it.next()).copyIntoArray(objArr, i6);
            }
            return i6;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public s1 iterator() {
            return this.multimap.m5valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(a0 a0Var, int i6) {
        this.map = a0Var;
        this.size = i6;
    }

    public static <K, V> c builder() {
        return new c();
    }

    public static <K, V> e0 copyOf(t0 t0Var) {
        if (t0Var instanceof e0) {
            e0 e0Var = (e0) t0Var;
            if (!e0Var.isPartialView()) {
                return e0Var;
            }
        }
        return z.copyOf(t0Var);
    }

    public static <K, V> e0 of() {
        return z.of();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.t0
    public a0 asMap() {
        return this.map;
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.d
    public boolean containsValue(@NullableDecl Object obj) {
        return obj != null && super.containsValue(obj);
    }

    Map<Object, Collection<Object>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public w createEntries() {
        return new d(this);
    }

    Set<Object> createKeySet() {
        throw new AssertionError("unreachable");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public f0 createKeys() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public w createValues() {
        return new h(this);
    }

    @Override // com.google.common.collect.d
    public w entries() {
        return (w) super.entries();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: entryIterator */
    public s1 m0entryIterator() {
        return new a();
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    /* renamed from: get */
    public abstract w m1get(Object obj);

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract e0 inverse();

    @Override // com.google.common.collect.d, com.google.common.collect.t0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    /* renamed from: keySet */
    public h0 m2keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.d
    public f0 keys() {
        return (f0) super.keys();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(t0 t0Var) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: removeAll */
    public w m3removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public w replaceValues(Object obj, Iterable<Object> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.t0
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: valueIterator */
    public s1 m5valueIterator() {
        return new b();
    }

    @Override // com.google.common.collect.d
    public w values() {
        return (w) super.values();
    }

    public static <K, V> e0 copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return z.copyOf((Iterable) iterable);
    }

    public static <K, V> e0 of(K k6, V v5) {
        return z.of((Object) k6, (Object) v5);
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(Object obj, Iterable<Object> iterable) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: replaceValues  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Collection m4replaceValues(Object obj, Iterable iterable) {
        return replaceValues(obj, (Iterable<Object>) iterable);
    }

    public static <K, V> e0 of(K k6, V v5, K k7, V v6) {
        return z.of((Object) k6, (Object) v5, (Object) k7, (Object) v6);
    }

    public static <K, V> e0 of(K k6, V v5, K k7, V v6, K k8, V v7) {
        return z.of((Object) k6, (Object) v5, (Object) k7, (Object) v6, (Object) k8, (Object) v7);
    }

    public static <K, V> e0 of(K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8) {
        return z.of((Object) k6, (Object) v5, (Object) k7, (Object) v6, (Object) k8, (Object) v7, (Object) k9, (Object) v8);
    }

    public static <K, V> e0 of(K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9) {
        return z.of((Object) k6, (Object) v5, (Object) k7, (Object) v6, (Object) k8, (Object) v7, (Object) k9, (Object) v8, (Object) k10, (Object) v9);
    }
}
