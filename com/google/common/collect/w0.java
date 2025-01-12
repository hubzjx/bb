package com.google.common.collect;

import com.google.common.collect.m1;
import com.google.common.collect.v0;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* loaded from: classes.dex */
public abstract class w0 {

    /* loaded from: classes.dex */
    static abstract class a implements v0.a {
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof v0.a) {
                v0.a aVar = (v0.a) obj;
                return getCount() == aVar.getCount() && com.google.common.base.h.a(getElement(), aVar.getElement());
            }
            return false;
        }

        public int hashCode() {
            Object element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            return valueOf + " x " + count;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class b extends m1.a {
        abstract v0 a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return a().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return a().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().entrySet().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c extends m1.a {
        abstract v0 a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof v0.a) {
                v0.a aVar = (v0.a) obj;
                return aVar.getCount() > 0 && a().count(aVar.getElement()) == aVar.getCount();
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof v0.a) {
                v0.a aVar = (v0.a) obj;
                Object element = aVar.getElement();
                int count = aVar.getCount();
                if (count != 0) {
                    return a().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class d extends a implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;
        @NullableDecl
        private final Object element;

        d(@NullableDecl Object obj, int i6) {
            this.element = obj;
            this.count = i6;
            i.b(i6, "count");
        }

        @Override // com.google.common.collect.v0.a
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.v0.a
        @NullableDecl
        public final Object getElement() {
            return this.element;
        }

        public d nextInBucket() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        private final v0 f5730a;

        /* renamed from: b  reason: collision with root package name */
        private final Iterator f5731b;

        /* renamed from: c  reason: collision with root package name */
        private v0.a f5732c;

        /* renamed from: d  reason: collision with root package name */
        private int f5733d;

        /* renamed from: e  reason: collision with root package name */
        private int f5734e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f5735f;

        e(v0 v0Var, Iterator it) {
            this.f5730a = v0Var;
            this.f5731b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5733d > 0 || this.f5731b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                if (this.f5733d == 0) {
                    v0.a aVar = (v0.a) this.f5731b.next();
                    this.f5732c = aVar;
                    int count = aVar.getCount();
                    this.f5733d = count;
                    this.f5734e = count;
                }
                this.f5733d--;
                this.f5735f = true;
                return this.f5732c.getElement();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            i.d(this.f5735f);
            if (this.f5734e == 1) {
                this.f5731b.remove();
            } else {
                this.f5730a.remove(this.f5732c.getElement());
            }
            this.f5734e--;
            this.f5735f = false;
        }
    }

    private static boolean a(v0 v0Var, com.google.common.collect.b bVar) {
        if (bVar.isEmpty()) {
            return false;
        }
        bVar.addTo(v0Var);
        return true;
    }

    private static boolean b(v0 v0Var, v0 v0Var2) {
        if (v0Var2 instanceof com.google.common.collect.b) {
            return a(v0Var, (com.google.common.collect.b) v0Var2);
        }
        if (v0Var2.isEmpty()) {
            return false;
        }
        for (v0.a aVar : v0Var2.entrySet()) {
            v0Var.add(aVar.getElement(), aVar.getCount());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(v0 v0Var, Collection collection) {
        com.google.common.base.j.j(v0Var);
        com.google.common.base.j.j(collection);
        if (collection instanceof v0) {
            return b(v0Var, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return n0.a(v0Var, collection.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static v0 d(Iterable iterable) {
        return (v0) iterable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(v0 v0Var, Object obj) {
        if (obj == v0Var) {
            return true;
        }
        if (obj instanceof v0) {
            v0 v0Var2 = (v0) obj;
            if (v0Var.size() == v0Var2.size() && v0Var.entrySet().size() == v0Var2.entrySet().size()) {
                for (v0.a aVar : v0Var2.entrySet()) {
                    if (v0Var.count(aVar.getElement()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static v0.a f(Object obj, int i6) {
        return new d(obj, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(Iterable iterable) {
        if (iterable instanceof v0) {
            return ((v0) iterable).elementSet().size();
        }
        return 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Iterator h(v0 v0Var) {
        return new e(v0Var, v0Var.entrySet().iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(v0 v0Var, Collection collection) {
        if (collection instanceof v0) {
            collection = ((v0) collection).elementSet();
        }
        return v0Var.elementSet().removeAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(v0 v0Var, Collection collection) {
        com.google.common.base.j.j(collection);
        if (collection instanceof v0) {
            collection = ((v0) collection).elementSet();
        }
        return v0Var.elementSet().retainAll(collection);
    }
}
