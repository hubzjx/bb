package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
final class a implements Iterator, q4.a {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f11311a;

    /* renamed from: b  reason: collision with root package name */
    private int f11312b;

    public a(Object[] objArr) {
        l.d(objArr, "array");
        this.f11311a = objArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f11312b < this.f11311a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.f11311a;
            int i6 = this.f11312b;
            this.f11312b = i6 + 1;
            return objArr[i6];
        } catch (ArrayIndexOutOfBoundsException e6) {
            this.f11312b--;
            throw new NoSuchElementException(e6.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
