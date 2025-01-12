package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements Collection, q4.a {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f11295a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11296b;

    public d(Object[] objArr, boolean z5) {
        kotlin.jvm.internal.l.d(objArr, "values");
        this.f11295a = objArr;
        this.f11296b = z5;
    }

    public int a() {
        return this.f11295a.length;
    }

    @Override // java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return j.o(this.f11295a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        kotlin.jvm.internal.l.d(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f11295a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return kotlin.jvm.internal.b.a(this.f11295a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return m.a(this.f11295a, this.f11296b);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        kotlin.jvm.internal.l.d(objArr, "array");
        return kotlin.jvm.internal.f.b(this, objArr);
    }
}
