package com.google.common.collect;

import com.google.common.collect.v0;
import com.google.common.collect.w0;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
abstract class e extends AbstractCollection implements v0 {
    @MonotonicNonNullDecl
    private transient Set<Object> elementSet;
    @MonotonicNonNullDecl
    private transient Set<v0.a> entrySet;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends w0.b {
        a() {
        }

        @Override // com.google.common.collect.w0.b
        v0 a() {
            return e.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return e.this.elementIterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends w0.c {
        b() {
        }

        @Override // com.google.common.collect.w0.c
        v0 a() {
            return e.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return e.this.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return e.this.distinctElements();
        }
    }

    public abstract int add(Object obj, int i6);

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean add(@NullableDecl Object obj) {
        add(obj, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean addAll(Collection<Object> collection) {
        return w0.c(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.v0
    public boolean contains(@NullableDecl Object obj) {
        return count(obj) > 0;
    }

    Set<Object> createElementSet() {
        return new a();
    }

    Set<v0.a> createEntrySet() {
        return new b();
    }

    abstract int distinctElements();

    abstract Iterator elementIterator();

    @Override // com.google.common.collect.v0
    public Set<Object> elementSet() {
        Set<Object> set = this.elementSet;
        if (set == null) {
            Set<Object> createElementSet = createElementSet();
            this.elementSet = createElementSet;
            return createElementSet;
        }
        return set;
    }

    abstract Iterator entryIterator();

    @Override // com.google.common.collect.v0
    public Set<v0.a> entrySet() {
        Set<v0.a> set = this.entrySet;
        if (set == null) {
            Set<v0.a> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }
        return set;
    }

    @Override // java.util.Collection
    public final boolean equals(@NullableDecl Object obj) {
        return w0.e(this, obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    public abstract int remove(Object obj, int i6);

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.v0
    @CanIgnoreReturnValue
    public final boolean remove(@NullableDecl Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean removeAll(Collection<?> collection) {
        return w0.i(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean retainAll(Collection<?> collection) {
        return w0.j(this, collection);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }
}
