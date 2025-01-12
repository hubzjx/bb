package kotlin.collections;

import io.jsonwebtoken.JwtParser;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public final class x implements List, Serializable, RandomAccess, q4.a {
    public static final x INSTANCE = new x();
    private static final long serialVersionUID = -7390468764508069838L;

    private x() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i6, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i6, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return contains((Void) obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        kotlin.jvm.internal.l.d(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return 1;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Void) {
            return indexOf((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return w.f11303a;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return lastIndexOf((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return w.f11303a;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object remove(int i6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object set(int i6, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public List subList(int i6, int i7) {
        if (i6 == 0 && i7 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i6 + ", toIndex: " + i7);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.f.a(this);
    }

    public String toString() {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public void add(int i6, Void r22) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Void r22) {
        kotlin.jvm.internal.l.d(r22, "element");
        return false;
    }

    @Override // java.util.List
    public Void get(int i6) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i6 + JwtParser.SEPARATOR_CHAR);
    }

    public int indexOf(Void r22) {
        kotlin.jvm.internal.l.d(r22, "element");
        return -1;
    }

    public int lastIndexOf(Void r22) {
        kotlin.jvm.internal.l.d(r22, "element");
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator(int i6) {
        if (i6 == 0) {
            return w.f11303a;
        }
        throw new IndexOutOfBoundsException("Index: " + i6);
    }

    @Override // java.util.List
    public Void remove(int i6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void set(int i6, Void r22) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        kotlin.jvm.internal.l.d(tArr, "array");
        return (T[]) kotlin.jvm.internal.f.b(this, tArr);
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Void r22) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
