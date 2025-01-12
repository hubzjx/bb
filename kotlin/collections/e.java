package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class e extends c {

    /* renamed from: d  reason: collision with root package name */
    public static final a f11297d = new a(null);

    /* renamed from: e  reason: collision with root package name */
    private static final Object[] f11298e = new Object[0];

    /* renamed from: a  reason: collision with root package name */
    private int f11299a;

    /* renamed from: b  reason: collision with root package name */
    private Object[] f11300b = f11298e;

    /* renamed from: c  reason: collision with root package name */
    private int f11301c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final int a(int i6, int i7) {
            int i8 = i6 + (i6 >> 1);
            if (i8 - i7 < 0) {
                i8 = i7;
            }
            return i8 - 2147483639 > 0 ? i7 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i8;
        }
    }

    private final void e(int i6, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f11300b.length;
        while (i6 < length && it.hasNext()) {
            this.f11300b[i6] = it.next();
            i6++;
        }
        int i7 = this.f11299a;
        for (int i8 = 0; i8 < i7 && it.hasNext(); i8++) {
            this.f11300b[i8] = it.next();
        }
        this.f11301c = size() + collection.size();
    }

    private final void f(int i6) {
        Object[] objArr = new Object[i6];
        Object[] objArr2 = this.f11300b;
        i.e(objArr2, objArr, 0, this.f11299a, objArr2.length);
        Object[] objArr3 = this.f11300b;
        int length = objArr3.length;
        int i7 = this.f11299a;
        i.e(objArr3, objArr, length - i7, 0, i7);
        this.f11299a = 0;
        this.f11300b = objArr;
    }

    private final int g(int i6) {
        int r5;
        if (i6 == 0) {
            r5 = j.r(this.f11300b);
            return r5;
        }
        return i6 - 1;
    }

    private final void h(int i6) {
        int b6;
        if (i6 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f11300b;
        if (i6 <= objArr.length) {
            return;
        }
        if (objArr != f11298e) {
            f(f11297d.a(objArr.length, i6));
            return;
        }
        b6 = r4.f.b(i6, 10);
        this.f11300b = new Object[b6];
    }

    private final int i(int i6) {
        int r5;
        r5 = j.r(this.f11300b);
        if (i6 == r5) {
            return 0;
        }
        return i6 + 1;
    }

    private final int j(int i6) {
        return i6 < 0 ? i6 + this.f11300b.length : i6;
    }

    private final int k(int i6) {
        Object[] objArr = this.f11300b;
        return i6 >= objArr.length ? i6 - objArr.length : i6;
    }

    @Override // kotlin.collections.c
    public int a() {
        return this.f11301c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i6, Object obj) {
        b.Companion.c(i6, size());
        if (i6 == size()) {
            d(obj);
        } else if (i6 == 0) {
            c(obj);
        } else {
            h(size() + 1);
            int k6 = k(this.f11299a + i6);
            if (i6 < ((size() + 1) >> 1)) {
                int g6 = g(k6);
                int g7 = g(this.f11299a);
                int i7 = this.f11299a;
                if (g6 >= i7) {
                    Object[] objArr = this.f11300b;
                    objArr[g7] = objArr[i7];
                    i.e(objArr, objArr, i7, i7 + 1, g6 + 1);
                } else {
                    Object[] objArr2 = this.f11300b;
                    i.e(objArr2, objArr2, i7 - 1, i7, objArr2.length);
                    Object[] objArr3 = this.f11300b;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    i.e(objArr3, objArr3, 0, 1, g6 + 1);
                }
                this.f11300b[g6] = obj;
                this.f11299a = g7;
            } else {
                int k7 = k(this.f11299a + size());
                Object[] objArr4 = this.f11300b;
                if (k6 < k7) {
                    i.e(objArr4, objArr4, k6 + 1, k6, k7);
                } else {
                    i.e(objArr4, objArr4, 1, 0, k7);
                    Object[] objArr5 = this.f11300b;
                    objArr5[0] = objArr5[objArr5.length - 1];
                    i.e(objArr5, objArr5, k6 + 1, k6, objArr5.length - 1);
                }
                this.f11300b[k6] = obj;
            }
            this.f11301c = size() + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i6, Collection collection) {
        kotlin.jvm.internal.l.d(collection, "elements");
        b.Companion.c(i6, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i6 == size()) {
            return addAll(collection);
        }
        h(size() + collection.size());
        int k6 = k(this.f11299a + size());
        int k7 = k(this.f11299a + i6);
        int size = collection.size();
        if (i6 < ((size() + 1) >> 1)) {
            int i7 = this.f11299a;
            int i8 = i7 - size;
            if (k7 < i7) {
                Object[] objArr = this.f11300b;
                i.e(objArr, objArr, i8, i7, objArr.length);
                Object[] objArr2 = this.f11300b;
                if (size >= k7) {
                    i.e(objArr2, objArr2, objArr2.length - size, 0, k7);
                } else {
                    i.e(objArr2, objArr2, objArr2.length - size, 0, size);
                    Object[] objArr3 = this.f11300b;
                    i.e(objArr3, objArr3, 0, size, k7);
                }
            } else if (i8 >= 0) {
                Object[] objArr4 = this.f11300b;
                i.e(objArr4, objArr4, i8, i7, k7);
            } else {
                Object[] objArr5 = this.f11300b;
                i8 += objArr5.length;
                int i9 = k7 - i7;
                int length = objArr5.length - i8;
                if (length >= i9) {
                    i.e(objArr5, objArr5, i8, i7, k7);
                } else {
                    i.e(objArr5, objArr5, i8, i7, i7 + length);
                    Object[] objArr6 = this.f11300b;
                    i.e(objArr6, objArr6, 0, this.f11299a + length, k7);
                }
            }
            this.f11299a = i8;
            e(j(k7 - size), collection);
        } else {
            int i10 = k7 + size;
            if (k7 < k6) {
                int i11 = size + k6;
                Object[] objArr7 = this.f11300b;
                if (i11 > objArr7.length) {
                    if (i10 >= objArr7.length) {
                        i10 -= objArr7.length;
                    } else {
                        int length2 = k6 - (i11 - objArr7.length);
                        i.e(objArr7, objArr7, 0, length2, k6);
                        Object[] objArr8 = this.f11300b;
                        i.e(objArr8, objArr8, i10, k7, length2);
                    }
                }
                i.e(objArr7, objArr7, i10, k7, k6);
            } else {
                Object[] objArr9 = this.f11300b;
                i.e(objArr9, objArr9, size, 0, k6);
                Object[] objArr10 = this.f11300b;
                if (i10 >= objArr10.length) {
                    i.e(objArr10, objArr10, i10 - objArr10.length, k7, objArr10.length);
                } else {
                    i.e(objArr10, objArr10, 0, objArr10.length - size, objArr10.length);
                    Object[] objArr11 = this.f11300b;
                    i.e(objArr11, objArr11, i10, k7, objArr11.length - size);
                }
            }
            e(k7, collection);
        }
        return true;
    }

    @Override // kotlin.collections.c
    public Object b(int i6) {
        int h6;
        int h7;
        b.Companion.b(i6, size());
        h6 = n.h(this);
        if (i6 == h6) {
            return m();
        }
        if (i6 == 0) {
            return l();
        }
        int k6 = k(this.f11299a + i6);
        Object obj = this.f11300b[k6];
        if (i6 < (size() >> 1)) {
            int i7 = this.f11299a;
            if (k6 >= i7) {
                Object[] objArr = this.f11300b;
                i.e(objArr, objArr, i7 + 1, i7, k6);
            } else {
                Object[] objArr2 = this.f11300b;
                i.e(objArr2, objArr2, 1, 0, k6);
                Object[] objArr3 = this.f11300b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i8 = this.f11299a;
                i.e(objArr3, objArr3, i8 + 1, i8, objArr3.length - 1);
            }
            Object[] objArr4 = this.f11300b;
            int i9 = this.f11299a;
            objArr4[i9] = null;
            this.f11299a = i(i9);
        } else {
            int i10 = this.f11299a;
            h7 = n.h(this);
            int k7 = k(i10 + h7);
            Object[] objArr5 = this.f11300b;
            if (k6 <= k7) {
                i.e(objArr5, objArr5, k6, k6 + 1, k7 + 1);
            } else {
                i.e(objArr5, objArr5, k6, k6 + 1, objArr5.length);
                Object[] objArr6 = this.f11300b;
                objArr6[objArr6.length - 1] = objArr6[0];
                i.e(objArr6, objArr6, 0, 1, k7 + 1);
            }
            this.f11300b[k7] = null;
        }
        this.f11301c = size() - 1;
        return obj;
    }

    public final void c(Object obj) {
        h(size() + 1);
        int g6 = g(this.f11299a);
        this.f11299a = g6;
        this.f11300b[g6] = obj;
        this.f11301c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int k6 = k(this.f11299a + size());
        int i6 = this.f11299a;
        if (i6 < k6) {
            i.k(this.f11300b, null, i6, k6);
        } else if (!isEmpty()) {
            Object[] objArr = this.f11300b;
            i.k(objArr, null, this.f11299a, objArr.length);
            i.k(this.f11300b, null, 0, k6);
        }
        this.f11299a = 0;
        this.f11301c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(Object obj) {
        h(size() + 1);
        this.f11300b[k(this.f11299a + size())] = obj;
        this.f11301c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i6) {
        b.Companion.b(i6, size());
        return this.f11300b[k(this.f11299a + i6)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int k6 = k(this.f11299a + size());
        int i6 = this.f11299a;
        if (i6 < k6) {
            while (i6 < k6) {
                if (!kotlin.jvm.internal.l.a(obj, this.f11300b[i6])) {
                    i6++;
                }
            }
            return -1;
        } else if (i6 < k6) {
            return -1;
        } else {
            int length = this.f11300b.length;
            while (true) {
                if (i6 >= length) {
                    for (int i7 = 0; i7 < k6; i7++) {
                        if (kotlin.jvm.internal.l.a(obj, this.f11300b[i7])) {
                            i6 = i7 + this.f11300b.length;
                        }
                    }
                    return -1;
                } else if (kotlin.jvm.internal.l.a(obj, this.f11300b[i6])) {
                    break;
                } else {
                    i6++;
                }
            }
        }
        return i6 - this.f11299a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final Object l() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f11300b;
        int i6 = this.f11299a;
        Object obj = objArr[i6];
        objArr[i6] = null;
        this.f11299a = i(i6);
        this.f11301c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int r5;
        int k6 = k(this.f11299a + size());
        int i6 = this.f11299a;
        if (i6 < k6) {
            r5 = k6 - 1;
            if (i6 <= r5) {
                while (!kotlin.jvm.internal.l.a(obj, this.f11300b[r5])) {
                    if (r5 != i6) {
                        r5--;
                    }
                }
                return r5 - this.f11299a;
            }
            return -1;
        }
        if (i6 > k6) {
            int i7 = k6 - 1;
            while (true) {
                if (-1 >= i7) {
                    r5 = j.r(this.f11300b);
                    int i8 = this.f11299a;
                    if (i8 <= r5) {
                        while (!kotlin.jvm.internal.l.a(obj, this.f11300b[r5])) {
                            if (r5 != i8) {
                                r5--;
                            }
                        }
                    }
                } else if (kotlin.jvm.internal.l.a(obj, this.f11300b[i7])) {
                    r5 = i7 + this.f11300b.length;
                    break;
                } else {
                    i7--;
                }
            }
        }
        return -1;
    }

    public final Object m() {
        int h6;
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int i6 = this.f11299a;
        h6 = n.h(this);
        int k6 = k(i6 + h6);
        Object[] objArr = this.f11300b;
        Object obj = objArr[k6];
        objArr[k6] = null;
        this.f11301c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        int k6;
        kotlin.jvm.internal.l.d(collection, "elements");
        boolean z5 = false;
        z5 = false;
        z5 = false;
        if (!isEmpty()) {
            if (!(this.f11300b.length == 0)) {
                int k7 = k(this.f11299a + size());
                int i6 = this.f11299a;
                if (i6 < k7) {
                    k6 = i6;
                    while (i6 < k7) {
                        Object obj = this.f11300b[i6];
                        if (!collection.contains(obj)) {
                            this.f11300b[k6] = obj;
                            k6++;
                        } else {
                            z5 = true;
                        }
                        i6++;
                    }
                    i.k(this.f11300b, null, k6, k7);
                } else {
                    int length = this.f11300b.length;
                    int i7 = i6;
                    boolean z6 = false;
                    while (i6 < length) {
                        Object[] objArr = this.f11300b;
                        Object obj2 = objArr[i6];
                        objArr[i6] = null;
                        if (!collection.contains(obj2)) {
                            this.f11300b[i7] = obj2;
                            i7++;
                        } else {
                            z6 = true;
                        }
                        i6++;
                    }
                    k6 = k(i7);
                    for (int i8 = 0; i8 < k7; i8++) {
                        Object[] objArr2 = this.f11300b;
                        Object obj3 = objArr2[i8];
                        objArr2[i8] = null;
                        if (!collection.contains(obj3)) {
                            this.f11300b[k6] = obj3;
                            k6 = i(k6);
                        } else {
                            z6 = true;
                        }
                    }
                    z5 = z6;
                }
                if (z5) {
                    this.f11301c = j(k6 - this.f11299a);
                }
            }
        }
        return z5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        int k6;
        kotlin.jvm.internal.l.d(collection, "elements");
        boolean z5 = false;
        z5 = false;
        z5 = false;
        if (!isEmpty()) {
            if (!(this.f11300b.length == 0)) {
                int k7 = k(this.f11299a + size());
                int i6 = this.f11299a;
                if (i6 < k7) {
                    k6 = i6;
                    while (i6 < k7) {
                        Object obj = this.f11300b[i6];
                        if (collection.contains(obj)) {
                            this.f11300b[k6] = obj;
                            k6++;
                        } else {
                            z5 = true;
                        }
                        i6++;
                    }
                    i.k(this.f11300b, null, k6, k7);
                } else {
                    int length = this.f11300b.length;
                    int i7 = i6;
                    boolean z6 = false;
                    while (i6 < length) {
                        Object[] objArr = this.f11300b;
                        Object obj2 = objArr[i6];
                        objArr[i6] = null;
                        if (collection.contains(obj2)) {
                            this.f11300b[i7] = obj2;
                            i7++;
                        } else {
                            z6 = true;
                        }
                        i6++;
                    }
                    k6 = k(i7);
                    for (int i8 = 0; i8 < k7; i8++) {
                        Object[] objArr2 = this.f11300b;
                        Object obj3 = objArr2[i8];
                        objArr2[i8] = null;
                        if (collection.contains(obj3)) {
                            this.f11300b[k6] = obj3;
                            k6 = i(k6);
                        } else {
                            z6 = true;
                        }
                    }
                    z5 = z6;
                }
                if (z5) {
                    this.f11301c = j(k6 - this.f11299a);
                }
            }
        }
        return z5;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i6, Object obj) {
        b.Companion.b(i6, size());
        int k6 = k(this.f11299a + i6);
        Object[] objArr = this.f11300b;
        Object obj2 = objArr[k6];
        objArr[k6] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        d(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        kotlin.jvm.internal.l.d(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        h(size() + collection.size());
        e(k(this.f11299a + size()), collection);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        kotlin.jvm.internal.l.d(objArr, "array");
        if (objArr.length < size()) {
            objArr = g.a(objArr, size());
        }
        int k6 = k(this.f11299a + size());
        int i6 = this.f11299a;
        if (i6 < k6) {
            i.g(this.f11300b, objArr, 0, i6, k6, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f11300b;
            i.e(objArr2, objArr, 0, this.f11299a, objArr2.length);
            Object[] objArr3 = this.f11300b;
            i.e(objArr3, objArr, objArr3.length - this.f11299a, 0, k6);
        }
        if (objArr.length > size()) {
            objArr[size()] = null;
        }
        return objArr;
    }
}
