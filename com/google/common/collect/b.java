package com.google.common.collect;

import com.google.common.collect.v0;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class b extends e implements Serializable {
    private static final long serialVersionUID = 0;
    transient b1 backingMap;
    transient long size;

    /* loaded from: classes.dex */
    class a extends c {
        a() {
            super();
        }

        @Override // com.google.common.collect.b.c
        Object b(int i6) {
            return b.this.backingMap.i(i6);
        }
    }

    /* renamed from: com.google.common.collect.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0055b extends c {
        C0055b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.b.c
        /* renamed from: c */
        public v0.a b(int i6) {
            return b.this.backingMap.g(i6);
        }
    }

    /* loaded from: classes.dex */
    abstract class c implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        int f5610a;

        /* renamed from: b  reason: collision with root package name */
        int f5611b = -1;

        /* renamed from: c  reason: collision with root package name */
        int f5612c;

        c() {
            this.f5610a = b.this.backingMap.e();
            this.f5612c = b.this.backingMap.f5617d;
        }

        private void a() {
            if (b.this.backingMap.f5617d != this.f5612c) {
                throw new ConcurrentModificationException();
            }
        }

        abstract Object b(int i6);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f5610a >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                Object b6 = b(this.f5610a);
                int i6 = this.f5610a;
                this.f5611b = i6;
                this.f5610a = b.this.backingMap.s(i6);
                return b6;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            b bVar;
            a();
            i.d(this.f5611b != -1);
            b.this.size -= bVar.backingMap.x(this.f5611b);
            this.f5610a = b.this.backingMap.t(this.f5610a, this.f5611b);
            this.f5611b = -1;
            this.f5612c = b.this.backingMap.f5617d;
        }
    }

    b(int i6) {
        init(i6);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int c6 = l1.c(objectInputStream);
        init(3);
        l1.b(this, objectInputStream, c6);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        l1.e(this, objectOutputStream);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.v0
    @CanIgnoreReturnValue
    public final int add(@NullableDecl Object obj, int i6) {
        if (i6 == 0) {
            return count(obj);
        }
        com.google.common.base.j.f(i6 > 0, "occurrences cannot be negative: %s", i6);
        int m5 = this.backingMap.m(obj);
        if (m5 == -1) {
            this.backingMap.u(obj, i6);
            this.size += i6;
            return 0;
        }
        int k6 = this.backingMap.k(m5);
        long j6 = i6;
        long j7 = k6 + j6;
        com.google.common.base.j.g(j7 <= 2147483647L, "too many occurrences: %s", j7);
        this.backingMap.B(m5, (int) j7);
        this.size += j6;
        return k6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addTo(v0 v0Var) {
        com.google.common.base.j.j(v0Var);
        int e6 = this.backingMap.e();
        while (e6 >= 0) {
            v0Var.add(this.backingMap.i(e6), this.backingMap.k(e6));
            e6 = this.backingMap.s(e6);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.a();
        this.size = 0L;
    }

    @Override // com.google.common.collect.v0
    public final int count(@NullableDecl Object obj) {
        return this.backingMap.f(obj);
    }

    @Override // com.google.common.collect.e
    final int distinctElements() {
        return this.backingMap.C();
    }

    @Override // com.google.common.collect.e
    final Iterator<Object> elementIterator() {
        return new a();
    }

    @Override // com.google.common.collect.e
    final Iterator<v0.a> entryIterator() {
        return new C0055b();
    }

    abstract void init(int i6);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<Object> iterator() {
        return w0.h(this);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.v0
    @CanIgnoreReturnValue
    public final int remove(@NullableDecl Object obj, int i6) {
        if (i6 == 0) {
            return count(obj);
        }
        com.google.common.base.j.f(i6 > 0, "occurrences cannot be negative: %s", i6);
        int m5 = this.backingMap.m(obj);
        if (m5 == -1) {
            return 0;
        }
        int k6 = this.backingMap.k(m5);
        if (k6 > i6) {
            this.backingMap.B(m5, k6 - i6);
        } else {
            this.backingMap.x(m5);
            i6 = k6;
        }
        this.size -= i6;
        return k6;
    }

    @CanIgnoreReturnValue
    public final int setCount(@NullableDecl Object obj, int i6) {
        i.b(i6, "count");
        b1 b1Var = this.backingMap;
        int v5 = i6 == 0 ? b1Var.v(obj) : b1Var.u(obj, i6);
        this.size += i6 - v5;
        return v5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.v0
    public final int size() {
        return com.google.common.primitives.b.g(this.size);
    }

    @Override // com.google.common.collect.v0
    public final boolean setCount(@NullableDecl Object obj, int i6, int i7) {
        long j6;
        i.b(i6, "oldCount");
        i.b(i7, "newCount");
        int m5 = this.backingMap.m(obj);
        if (m5 == -1) {
            if (i6 != 0) {
                return false;
            }
            if (i7 > 0) {
                this.backingMap.u(obj, i7);
                this.size += i7;
            }
            return true;
        } else if (this.backingMap.k(m5) != i6) {
            return false;
        } else {
            b1 b1Var = this.backingMap;
            if (i7 == 0) {
                b1Var.x(m5);
                j6 = this.size - i6;
            } else {
                b1Var.B(m5, i7);
                j6 = this.size + (i7 - i6);
            }
            this.size = j6;
            return true;
        }
    }
}
