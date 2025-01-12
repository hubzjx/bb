package com.google.common.collect;

import com.google.common.collect.a0;
import com.google.common.collect.e0;
import com.google.common.collect.y;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public class z extends e0 {
    private static final long serialVersionUID = 0;
    @RetainedWith
    @LazyInit
    private transient z inverse;

    /* loaded from: classes.dex */
    public static final class a extends e0.c {
        public z h() {
            return (z) super.a();
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

        public a m(Object obj, Object... objArr) {
            super.g(obj, objArr);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(a0 a0Var, int i6) {
        super(a0Var, i6);
    }

    public static <K, V> a builder() {
        return new a();
    }

    public static <K, V> z copyOf(t0 t0Var) {
        if (t0Var.isEmpty()) {
            return of();
        }
        if (t0Var instanceof z) {
            z zVar = (z) t0Var;
            if (!zVar.isPartialView()) {
                return zVar;
            }
        }
        return fromMapEntries(t0Var.asMap().entrySet(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> z fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, @NullableDecl Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        a0.b bVar = new a0.b(collection.size());
        int i6 = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            Collection<? extends V> value = entry.getValue();
            y copyOf = comparator == null ? y.copyOf((Collection) value) : y.sortedCopyOf(comparator, value);
            if (!copyOf.isEmpty()) {
                bVar.c(key, copyOf);
                i6 += copyOf.size();
            }
        }
        return new z(bVar.a(), i6);
    }

    private z invert() {
        a builder = builder();
        s1 it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.c(entry.getValue(), entry.getKey());
        }
        z h6 = builder.h();
        h6.inverse = this;
        return h6;
    }

    public static <K, V> z of() {
        return p.INSTANCE;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
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
            y.a builder2 = y.builder();
            for (int i8 = 0; i8 < readInt2; i8++) {
                builder2.a(objectInputStream.readObject());
            }
            builder.c(readObject, builder2.j());
            i6 += readInt2;
        }
        try {
            e0.e.f5642a.b(this, builder.a());
            e0.e.f5643b.a(this, i6);
        } catch (IllegalArgumentException e6) {
            throw ((InvalidObjectException) new InvalidObjectException(e6.getMessage()).initCause(e6));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        l1.d(this, objectOutputStream);
    }

    @Override // com.google.common.collect.e0
    public z inverse() {
        z zVar = this.inverse;
        if (zVar == null) {
            z invert = invert();
            this.inverse = invert;
            return invert;
        }
        return zVar;
    }

    @Override // com.google.common.collect.e0
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ w replaceValues(Object obj, Iterable iterable) {
        return replaceValues(obj, (Iterable<Object>) iterable);
    }

    public static <K, V> z copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().k(iterable).h();
    }

    public static <K, V> z of(K k6, V v5) {
        a builder = builder();
        builder.c(k6, v5);
        return builder.h();
    }

    @Override // com.google.common.collect.e0
    public y get(@NullableDecl Object obj) {
        y yVar = (y) this.map.get(obj);
        return yVar == null ? y.of() : yVar;
    }

    @Override // com.google.common.collect.e0
    @CanIgnoreReturnValue
    @Deprecated
    public y removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.e0
    @CanIgnoreReturnValue
    @Deprecated
    public y replaceValues(Object obj, Iterable<Object> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> z of(K k6, V v5, K k7, V v6) {
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

    public static <K, V> z of(K k6, V v5, K k7, V v6, K k8, V v7) {
        a builder = builder();
        builder.c(k6, v5);
        builder.c(k7, v6);
        builder.c(k8, v7);
        return builder.h();
    }

    @Override // com.google.common.collect.e0
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ List replaceValues(Object obj, Iterable iterable) {
        return replaceValues(obj, (Iterable<Object>) iterable);
    }

    public static <K, V> z of(K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8) {
        a builder = builder();
        builder.c(k6, v5);
        builder.c(k7, v6);
        builder.c(k8, v7);
        builder.c(k9, v8);
        return builder.h();
    }

    public static <K, V> z of(K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9) {
        a builder = builder();
        builder.c(k6, v5);
        builder.c(k7, v6);
        builder.c(k8, v7);
        builder.c(k9, v8);
        builder.c(k10, v9);
        return builder.h();
    }
}
