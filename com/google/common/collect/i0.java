package com.google.common.collect;

import com.google.common.collect.a0;
import com.google.common.collect.e0;
import com.google.common.collect.h0;
import com.google.common.collect.j0;
import com.google.common.collect.l1;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public class i0 extends e0 {
    private static final long serialVersionUID = 0;
    private final transient h0 emptySet;
    @MonotonicNonNullDecl
    private transient h0 entries;
    @RetainedWith
    @LazyInit
    @MonotonicNonNullDecl
    private transient i0 inverse;

    /* loaded from: classes.dex */
    public static final class a extends e0.c {
        @Override // com.google.common.collect.e0.c
        Collection b() {
            return d1.c();
        }

        public i0 h() {
            Collection entrySet = this.f5639a.entrySet();
            Comparator comparator = this.f5640b;
            if (comparator != null) {
                entrySet = c1.from(comparator).onKeys().immutableSortedCopy(entrySet);
            }
            return i0.fromMapEntries(entrySet, this.f5641c);
        }

        @Override // com.google.common.collect.e0.c
        /* renamed from: i */
        public a c(Object obj, Object obj2) {
            super.c(obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.e0.c
        /* renamed from: j */
        public a d(Map.Entry entry) {
            super.d(entry);
            return this;
        }

        public a k(Iterable iterable) {
            super.e(iterable);
            return this;
        }

        @Override // com.google.common.collect.e0.c
        /* renamed from: l */
        public a f(Object obj, Iterable iterable) {
            super.f(obj, iterable);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b extends h0 {
        @Weak
        private final transient i0 multimap;

        b(i0 i0Var) {
            this.multimap = i0Var;
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.multimap.containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public s1 iterator() {
            return this.multimap.m0entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.multimap.size();
        }
    }

    /* loaded from: classes.dex */
    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final l1.b f5653a = l1.a(i0.class, "emptySet");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(a0 a0Var, int i6, @NullableDecl Comparator<Object> comparator) {
        super(a0Var, i6);
        this.emptySet = emptySet(comparator);
    }

    public static <K, V> a builder() {
        return new a();
    }

    public static <K, V> i0 copyOf(t0 t0Var) {
        return copyOf(t0Var, null);
    }

    private static <V> h0 emptySet(@NullableDecl Comparator<? super V> comparator) {
        return comparator == null ? h0.of() : j0.emptySet(comparator);
    }

    static <K, V> i0 fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, @NullableDecl Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        a0.b bVar = new a0.b(collection.size());
        int i6 = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            h0 valueSet = valueSet(comparator, entry.getValue());
            if (!valueSet.isEmpty()) {
                bVar.c(key, valueSet);
                i6 += valueSet.size();
            }
        }
        return new i0(bVar.a(), i6, comparator);
    }

    private i0 invert() {
        a builder = builder();
        s1 it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.c(entry.getValue(), entry.getKey());
        }
        i0 h6 = builder.h();
        h6.inverse = this;
        return h6;
    }

    public static <K, V> i0 of() {
        return q.INSTANCE;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Invalid key count " + readInt);
        }
        a0.b builder = a0.builder();
        int i6 = 0;
        for (int i7 = 0; i7 < readInt; i7++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            if (readInt2 <= 0) {
                throw new InvalidObjectException("Invalid value count " + readInt2);
            }
            h0.a valuesBuilder = valuesBuilder(comparator);
            for (int i8 = 0; i8 < readInt2; i8++) {
                valuesBuilder.a(objectInputStream.readObject());
            }
            h0 l6 = valuesBuilder.l();
            if (l6.size() != readInt2) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + readObject);
            }
            builder.c(readObject, l6);
            i6 += readInt2;
        }
        try {
            e0.e.f5642a.b(this, builder.a());
            e0.e.f5643b.a(this, i6);
            c.f5653a.b(this, emptySet(comparator));
        } catch (IllegalArgumentException e6) {
            throw ((InvalidObjectException) new InvalidObjectException(e6.getMessage()).initCause(e6));
        }
    }

    private static <V> h0 valueSet(@NullableDecl Comparator<? super V> comparator, Collection<? extends V> collection) {
        return comparator == null ? h0.copyOf((Collection) collection) : j0.copyOf((Comparator) comparator, (Collection) collection);
    }

    private static <V> h0.a valuesBuilder(@NullableDecl Comparator<? super V> comparator) {
        return comparator == null ? new h0.a() : new j0.a(comparator);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(valueComparator());
        l1.d(this, objectOutputStream);
    }

    @Override // com.google.common.collect.e0
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ w replaceValues(Object obj, Iterable iterable) {
        return replaceValues(obj, (Iterable<Object>) iterable);
    }

    @NullableDecl
    Comparator<Object> valueComparator() {
        h0 h0Var = this.emptySet;
        if (h0Var instanceof j0) {
            return ((j0) h0Var).comparator();
        }
        return null;
    }

    private static <K, V> i0 copyOf(t0 t0Var, Comparator<? super V> comparator) {
        com.google.common.base.j.j(t0Var);
        if (t0Var.isEmpty() && comparator == null) {
            return of();
        }
        if (t0Var instanceof i0) {
            i0 i0Var = (i0) t0Var;
            if (!i0Var.isPartialView()) {
                return i0Var;
            }
        }
        return fromMapEntries(t0Var.asMap().entrySet(), comparator);
    }

    public static <K, V> i0 of(K k6, V v5) {
        a builder = builder();
        builder.c(k6, v5);
        return builder.h();
    }

    @Override // com.google.common.collect.e0, com.google.common.collect.d
    public h0 entries() {
        h0 h0Var = this.entries;
        if (h0Var == null) {
            b bVar = new b(this);
            this.entries = bVar;
            return bVar;
        }
        return h0Var;
    }

    @Override // com.google.common.collect.e0
    public h0 get(@NullableDecl Object obj) {
        return (h0) com.google.common.base.g.a((h0) this.map.get(obj), this.emptySet);
    }

    @Override // com.google.common.collect.e0
    public i0 inverse() {
        i0 i0Var = this.inverse;
        if (i0Var == null) {
            i0 invert = invert();
            this.inverse = invert;
            return invert;
        }
        return i0Var;
    }

    @Override // com.google.common.collect.e0
    @CanIgnoreReturnValue
    @Deprecated
    public h0 removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.e0
    @CanIgnoreReturnValue
    @Deprecated
    public h0 replaceValues(Object obj, Iterable<Object> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> i0 copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().k(iterable).h();
    }

    public static <K, V> i0 of(K k6, V v5, K k7, V v6) {
        a builder = builder();
        builder.c(k6, v5);
        builder.c(k7, v6);
        return builder.h();
    }

    @Override // com.google.common.collect.e0
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues(obj, (Iterable<Object>) iterable);
    }

    public static <K, V> i0 of(K k6, V v5, K k7, V v6, K k8, V v7) {
        a builder = builder();
        builder.c(k6, v5);
        builder.c(k7, v6);
        builder.c(k8, v7);
        return builder.h();
    }

    @Override // com.google.common.collect.e0
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
        return replaceValues(obj, (Iterable<Object>) iterable);
    }

    public static <K, V> i0 of(K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8) {
        a builder = builder();
        builder.c(k6, v5);
        builder.c(k7, v6);
        builder.c(k8, v7);
        builder.c(k9, v8);
        return builder.h();
    }

    public static <K, V> i0 of(K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9) {
        a builder = builder();
        builder.c(k6, v5);
        builder.c(k7, v6);
        builder.c(k8, v7);
        builder.c(k9, v8);
        builder.c(k10, v9);
        return builder.h();
    }
}
