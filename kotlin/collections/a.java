package kotlin.collections;

import java.util.Collection;
/* loaded from: classes.dex */
public abstract class a implements Collection, q4.a {

    /* renamed from: kotlin.collections.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0185a extends kotlin.jvm.internal.m implements p4.l {
        C0185a() {
            super(1);
        }

        @Override // p4.l
        public final CharSequence invoke(Object obj) {
            return obj == a.this ? "(this Collection)" : String.valueOf(obj);
        }
    }

    @Override // java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        for (Object obj2 : this) {
            if (kotlin.jvm.internal.l.a(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
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

    public abstract int getSize();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.f.a(this);
    }

    public String toString() {
        String F;
        F = v.F(this, ", ", "[", "]", 0, null, new C0185a(), 24, null);
        return F;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        kotlin.jvm.internal.l.d(tArr, "array");
        return (T[]) kotlin.jvm.internal.f.b(this, tArr);
    }
}
