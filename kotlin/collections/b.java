package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public abstract class b extends kotlin.collections.a implements List {
    public static final a Companion = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final void a(int i6, int i7, int i8) {
            if (i6 < 0 || i7 > i8) {
                throw new IndexOutOfBoundsException("startIndex: " + i6 + ", endIndex: " + i7 + ", size: " + i8);
            } else if (i6 <= i7) {
            } else {
                throw new IllegalArgumentException("startIndex: " + i6 + " > endIndex: " + i7);
            }
        }

        public final void b(int i6, int i7) {
            if (i6 < 0 || i6 >= i7) {
                throw new IndexOutOfBoundsException("index: " + i6 + ", size: " + i7);
            }
        }

        public final void c(int i6, int i7) {
            if (i6 < 0 || i6 > i7) {
                throw new IndexOutOfBoundsException("index: " + i6 + ", size: " + i7);
            }
        }

        public final void d(int i6, int i7, int i8) {
            if (i6 < 0 || i7 > i8) {
                throw new IndexOutOfBoundsException("fromIndex: " + i6 + ", toIndex: " + i7 + ", size: " + i8);
            } else if (i6 <= i7) {
            } else {
                throw new IllegalArgumentException("fromIndex: " + i6 + " > toIndex: " + i7);
            }
        }

        public final boolean e(Collection collection, Collection collection2) {
            kotlin.jvm.internal.l.d(collection, "c");
            kotlin.jvm.internal.l.d(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator it = collection2.iterator();
            for (Object obj : collection) {
                if (!kotlin.jvm.internal.l.a(obj, it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int f(Collection collection) {
            kotlin.jvm.internal.l.d(collection, "c");
            Iterator it = collection.iterator();
            int i6 = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i6 = (i6 * 31) + (next != null ? next.hashCode() : 0);
            }
            return i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: kotlin.collections.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0186b implements Iterator, q4.a {

        /* renamed from: a  reason: collision with root package name */
        private int f11289a;

        public C0186b() {
        }

        protected final int a() {
            return this.f11289a;
        }

        protected final void b(int i6) {
            this.f11289a = i6;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11289a < b.this.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                b bVar = b.this;
                int i6 = this.f11289a;
                this.f11289a = i6 + 1;
                return bVar.get(i6);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: classes.dex */
    private class c extends C0186b implements ListIterator {
        public c(int i6) {
            super();
            b.Companion.c(i6, b.this.size());
            b(i6);
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public Object previous() {
            if (hasPrevious()) {
                b bVar = b.this;
                b(a() - 1);
                return bVar.get(a());
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: classes.dex */
    private static final class d extends b implements RandomAccess {

        /* renamed from: a  reason: collision with root package name */
        private final b f11292a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11293b;

        /* renamed from: c  reason: collision with root package name */
        private int f11294c;

        public d(b bVar, int i6, int i7) {
            kotlin.jvm.internal.l.d(bVar, "list");
            this.f11292a = bVar;
            this.f11293b = i6;
            b.Companion.d(i6, i7, bVar.size());
            this.f11294c = i7 - i6;
        }

        @Override // kotlin.collections.b, java.util.List
        public Object get(int i6) {
            b.Companion.b(i6, this.f11294c);
            return this.f11292a.get(this.f11293b + i6);
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return this.f11294c;
        }
    }

    @Override // java.util.List
    public void add(int i6, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i6, Collection<Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.e(this, (Collection) obj);
        }
        return false;
    }

    @Override // java.util.List
    public abstract Object get(int i6);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.f(this);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int i6 = 0;
        for (Object obj2 : this) {
            if (kotlin.jvm.internal.l.a(obj2, obj)) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<Object> iterator() {
        return new C0186b();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.l.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public Object remove(int i6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Object set(int i6, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<Object> subList(int i6, int i7) {
        return new d(this, i6, i7);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int i6) {
        return new c(i6);
    }
}
