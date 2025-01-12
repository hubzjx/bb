package com.google.common.collect;

import com.google.common.collect.v0;
import com.google.common.collect.w;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public abstract class f0 extends g0 implements v0 {
    @LazyInit
    private transient y asList;
    @LazyInit
    private transient h0 entrySet;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends s1 {

        /* renamed from: a  reason: collision with root package name */
        int f5644a;

        /* renamed from: b  reason: collision with root package name */
        Object f5645b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Iterator f5646c;

        a(Iterator it) {
            this.f5646c = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5644a > 0 || this.f5646c.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f5644a <= 0) {
                v0.a aVar = (v0.a) this.f5646c.next();
                this.f5645b = aVar.getElement();
                this.f5644a = aVar.getCount();
            }
            this.f5644a--;
            return this.f5645b;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends w.b {

        /* renamed from: a  reason: collision with root package name */
        b1 f5648a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5649b;

        /* renamed from: c  reason: collision with root package name */
        boolean f5650c;

        public b() {
            this(4);
        }

        static b1 l(Iterable iterable) {
            if (iterable instanceof g1) {
                return ((g1) iterable).contents;
            }
            if (iterable instanceof com.google.common.collect.b) {
                return ((com.google.common.collect.b) iterable).backingMap;
            }
            return null;
        }

        @Override // com.google.common.collect.w.b
        /* renamed from: f */
        public b a(Object obj) {
            return j(obj, 1);
        }

        public b g(Object... objArr) {
            super.b(objArr);
            return this;
        }

        public b h(Iterable iterable) {
            if (iterable instanceof v0) {
                v0 d6 = w0.d(iterable);
                b1 l6 = l(d6);
                if (l6 != null) {
                    b1 b1Var = this.f5648a;
                    b1Var.d(Math.max(b1Var.C(), l6.C()));
                    for (int e6 = l6.e(); e6 >= 0; e6 = l6.s(e6)) {
                        j(l6.i(e6), l6.k(e6));
                    }
                } else {
                    Set entrySet = d6.entrySet();
                    b1 b1Var2 = this.f5648a;
                    b1Var2.d(Math.max(b1Var2.C(), entrySet.size()));
                    for (v0.a aVar : d6.entrySet()) {
                        j(aVar.getElement(), aVar.getCount());
                    }
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        public b i(Iterator it) {
            super.d(it);
            return this;
        }

        public b j(Object obj, int i6) {
            if (i6 == 0) {
                return this;
            }
            if (this.f5649b) {
                this.f5648a = new b1(this.f5648a);
                this.f5650c = false;
            }
            this.f5649b = false;
            com.google.common.base.j.j(obj);
            b1 b1Var = this.f5648a;
            b1Var.u(obj, i6 + b1Var.f(obj));
            return this;
        }

        public f0 k() {
            if (this.f5648a.C() == 0) {
                return f0.of();
            }
            if (this.f5650c) {
                this.f5648a = new b1(this.f5648a);
                this.f5650c = false;
            }
            this.f5649b = true;
            return new g1(this.f5648a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i6) {
            this.f5649b = false;
            this.f5650c = false;
            this.f5648a = b1.c(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c extends l0 {
        private static final long serialVersionUID = 0;

        private c() {
        }

        @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof v0.a) {
                v0.a aVar = (v0.a) obj;
                return aVar.getCount() > 0 && f0.this.count(aVar.getElement()) == aVar.getCount();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.l0
        public v0.a get(int i6) {
            return f0.this.getEntry(i6);
        }

        @Override // com.google.common.collect.h0, java.util.Collection, java.util.Set
        public int hashCode() {
            return f0.this.hashCode();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w
        public boolean isPartialView() {
            return f0.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f0.this.elementSet().size();
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.w
        Object writeReplace() {
            return new d(f0.this);
        }

        /* synthetic */ c(f0 f0Var, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    static class d implements Serializable {
        final f0 multiset;

        d(f0 f0Var) {
            this.multiset = f0Var;
        }

        Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    public static <E> b builder() {
        return new b();
    }

    private static <E> f0 copyFromElements(E... eArr) {
        return new b().g(eArr).k();
    }

    static <E> f0 copyFromEntries(Collection<? extends v0.a> collection) {
        b bVar = new b(collection.size());
        for (v0.a aVar : collection) {
            bVar.j(aVar.getElement(), aVar.getCount());
        }
        return bVar.k();
    }

    public static <E> f0 copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof f0) {
            f0 f0Var = (f0) iterable;
            if (!f0Var.isPartialView()) {
                return f0Var;
            }
        }
        b bVar = new b(w0.g(iterable));
        bVar.h(iterable);
        return bVar.k();
    }

    private h0 createEntrySet() {
        return isEmpty() ? h0.of() : new c(this, null);
    }

    public static <E> f0 of() {
        return g1.EMPTY;
    }

    @Override // com.google.common.collect.v0
    @CanIgnoreReturnValue
    @Deprecated
    public final int add(Object obj, int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.w
    public y asList() {
        y yVar = this.asList;
        if (yVar == null) {
            y asList = super.asList();
            this.asList = asList;
            return asList;
        }
        return yVar;
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return count(obj) > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    public int copyIntoArray(Object[] objArr, int i6) {
        s1 it = entrySet().iterator();
        while (it.hasNext()) {
            v0.a aVar = (v0.a) it.next();
            Arrays.fill(objArr, i6, aVar.getCount() + i6, aVar.getElement());
            i6 += aVar.getCount();
        }
        return i6;
    }

    public abstract /* synthetic */ int count(@NullableDecl @CompatibleWith("E") Object obj);

    @Override // com.google.common.collect.v0
    public abstract h0 elementSet();

    @Override // com.google.common.collect.v0
    public h0 entrySet() {
        h0 h0Var = this.entrySet;
        if (h0Var == null) {
            h0 createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }
        return h0Var;
    }

    @Override // java.util.Collection
    public boolean equals(@NullableDecl Object obj) {
        return w0.e(this, obj);
    }

    abstract v0.a getEntry(int i6);

    @Override // java.util.Collection
    public int hashCode() {
        return m1.b(entrySet());
    }

    @Override // com.google.common.collect.w, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public s1 iterator() {
        return new a(entrySet().iterator());
    }

    @Override // com.google.common.collect.v0
    @CanIgnoreReturnValue
    @Deprecated
    public final int remove(Object obj, int i6) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final int setCount(Object obj, int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.w
    abstract Object writeReplace();

    public static <E> f0 copyOf(Iterator<? extends E> it) {
        return new b().i(it).k();
    }

    public static <E> f0 of(E e6) {
        return copyFromElements(e6);
    }

    @Override // com.google.common.collect.v0
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean setCount(Object obj, int i6, int i7) {
        throw new UnsupportedOperationException();
    }

    public static <E> f0 copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    public static <E> f0 of(E e6, E e7) {
        return copyFromElements(e6, e7);
    }

    public static <E> f0 of(E e6, E e7, E e8) {
        return copyFromElements(e6, e7, e8);
    }

    public static <E> f0 of(E e6, E e7, E e8, E e9) {
        return copyFromElements(e6, e7, e8, e9);
    }

    public static <E> f0 of(E e6, E e7, E e8, E e9, E e10) {
        return copyFromElements(e6, e7, e8, e9, e10);
    }

    public static <E> f0 of(E e6, E e7, E e8, E e9, E e10, E e11, E... eArr) {
        return new b().a(e6).a(e7).a(e8).a(e9).a(e10).a(e11).g(eArr).k();
    }
}
