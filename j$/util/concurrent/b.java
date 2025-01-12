package j$.util.concurrent;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class b implements Collection, Serializable {

    /* renamed from: a  reason: collision with root package name */
    final ConcurrentHashMap f11078a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ConcurrentHashMap concurrentHashMap) {
        this.f11078a = concurrentHashMap;
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f11078a.clear();
    }

    @Override // java.util.Collection
    public abstract boolean contains(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:6:0x000c  */
    @Override // java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean containsAll(Collection collection) {
        if (collection != this) {
            for (Object obj : collection) {
                if (obj == null || !contains(obj)) {
                    return false;
                }
                while (r2.hasNext()) {
                }
            }
            return true;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f11078a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public abstract Iterator iterator();

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        collection.getClass();
        Iterator it = iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z5 = true;
            }
        }
        return z5;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        Iterator it = iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z5 = true;
            }
        }
        return z5;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f11078a.size();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        long l6 = this.f11078a.l();
        if (l6 < 0) {
            l6 = 0;
        }
        if (l6 <= 2147483639) {
            int i6 = (int) l6;
            Object[] objArr = new Object[i6];
            Iterator it = iterator();
            int i7 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                if (i7 == i6) {
                    if (i6 >= 2147483639) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    int i8 = i6 < 1073741819 ? (i6 >>> 1) + 1 + i6 : 2147483639;
                    objArr = Arrays.copyOf(objArr, i8);
                    i6 = i8;
                }
                objArr[i7] = next;
                i7++;
            }
            return i7 == i6 ? objArr : Arrays.copyOf(objArr, i7);
        }
        throw new OutOfMemoryError("Required array size too large");
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        long l6 = this.f11078a.l();
        if (l6 < 0) {
            l6 = 0;
        }
        if (l6 <= 2147483639) {
            int i6 = (int) l6;
            Object[] objArr2 = objArr.length >= i6 ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i6);
            int length = objArr2.length;
            Iterator it = iterator();
            int i7 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                if (i7 == length) {
                    if (length >= 2147483639) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    int i8 = length < 1073741819 ? (length >>> 1) + 1 + length : 2147483639;
                    objArr2 = Arrays.copyOf(objArr2, i8);
                    length = i8;
                }
                objArr2[i7] = next;
                i7++;
            }
            if (objArr != objArr2 || i7 >= length) {
                return i7 == length ? objArr2 : Arrays.copyOf(objArr2, i7);
            }
            objArr2[i7] = null;
            return objArr2;
        }
        throw new OutOfMemoryError("Required array size too large");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        if (it.hasNext()) {
            while (true) {
                Object next = it.next();
                if (next == this) {
                    next = "(this Collection)";
                }
                sb.append(next);
                if (!it.hasNext()) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
