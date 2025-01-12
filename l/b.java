package l;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class b implements Collection, Set {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f11353e = new int[0];

    /* renamed from: f  reason: collision with root package name */
    private static final Object[] f11354f = new Object[0];

    /* renamed from: g  reason: collision with root package name */
    private static Object[] f11355g;

    /* renamed from: h  reason: collision with root package name */
    private static int f11356h;

    /* renamed from: k  reason: collision with root package name */
    private static Object[] f11357k;

    /* renamed from: l  reason: collision with root package name */
    private static int f11358l;

    /* renamed from: a  reason: collision with root package name */
    private int[] f11359a;

    /* renamed from: b  reason: collision with root package name */
    Object[] f11360b;

    /* renamed from: c  reason: collision with root package name */
    int f11361c;

    /* renamed from: d  reason: collision with root package name */
    private f f11362d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends f {
        a() {
        }

        @Override // l.f
        protected void a() {
            b.this.clear();
        }

        @Override // l.f
        protected Object b(int i6, int i7) {
            return b.this.f11360b[i6];
        }

        @Override // l.f
        protected Map c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // l.f
        protected int d() {
            return b.this.f11361c;
        }

        @Override // l.f
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // l.f
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // l.f
        protected void g(Object obj, Object obj2) {
            b.this.add(obj);
        }

        @Override // l.f
        protected void h(int i6) {
            b.this.g(i6);
        }

        @Override // l.f
        protected Object i(int i6, Object obj) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    private void a(int i6) {
        if (i6 == 8) {
            synchronized (b.class) {
                Object[] objArr = f11357k;
                if (objArr != null) {
                    this.f11360b = objArr;
                    f11357k = (Object[]) objArr[0];
                    this.f11359a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f11358l--;
                    return;
                }
            }
        } else if (i6 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f11355g;
                if (objArr2 != null) {
                    this.f11360b = objArr2;
                    f11355g = (Object[]) objArr2[0];
                    this.f11359a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f11356h--;
                    return;
                }
            }
        }
        this.f11359a = new int[i6];
        this.f11360b = new Object[i6];
    }

    private static void c(int[] iArr, Object[] objArr, int i6) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f11358l < 10) {
                    objArr[0] = f11357k;
                    objArr[1] = iArr;
                    for (int i7 = i6 - 1; i7 >= 2; i7--) {
                        objArr[i7] = null;
                    }
                    f11357k = objArr;
                    f11358l++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (f11356h < 10) {
                    objArr[0] = f11355g;
                    objArr[1] = iArr;
                    for (int i8 = i6 - 1; i8 >= 2; i8--) {
                        objArr[i8] = null;
                    }
                    f11355g = objArr;
                    f11356h++;
                }
            }
        }
    }

    private f d() {
        if (this.f11362d == null) {
            this.f11362d = new a();
        }
        return this.f11362d;
    }

    private int e(Object obj, int i6) {
        int i7 = this.f11361c;
        if (i7 == 0) {
            return -1;
        }
        int a6 = c.a(this.f11359a, i7, i6);
        if (a6 >= 0 && !obj.equals(this.f11360b[a6])) {
            int i8 = a6 + 1;
            while (i8 < i7 && this.f11359a[i8] == i6) {
                if (obj.equals(this.f11360b[i8])) {
                    return i8;
                }
                i8++;
            }
            for (int i9 = a6 - 1; i9 >= 0 && this.f11359a[i9] == i6; i9--) {
                if (obj.equals(this.f11360b[i9])) {
                    return i9;
                }
            }
            return ~i8;
        }
        return a6;
    }

    private int f() {
        int i6 = this.f11361c;
        if (i6 == 0) {
            return -1;
        }
        int a6 = c.a(this.f11359a, i6, 0);
        if (a6 >= 0 && this.f11360b[a6] != null) {
            int i7 = a6 + 1;
            while (i7 < i6 && this.f11359a[i7] == 0) {
                if (this.f11360b[i7] == null) {
                    return i7;
                }
                i7++;
            }
            for (int i8 = a6 - 1; i8 >= 0 && this.f11359a[i8] == 0; i8--) {
                if (this.f11360b[i8] == null) {
                    return i8;
                }
            }
            return ~i7;
        }
        return a6;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i6;
        int e6;
        if (obj == null) {
            e6 = f();
            i6 = 0;
        } else {
            int hashCode = obj.hashCode();
            i6 = hashCode;
            e6 = e(obj, hashCode);
        }
        if (e6 >= 0) {
            return false;
        }
        int i7 = ~e6;
        int i8 = this.f11361c;
        int[] iArr = this.f11359a;
        if (i8 >= iArr.length) {
            int i9 = 8;
            if (i8 >= 8) {
                i9 = (i8 >> 1) + i8;
            } else if (i8 < 4) {
                i9 = 4;
            }
            Object[] objArr = this.f11360b;
            a(i9);
            int[] iArr2 = this.f11359a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f11360b, 0, objArr.length);
            }
            c(iArr, objArr, this.f11361c);
        }
        int i10 = this.f11361c;
        if (i7 < i10) {
            int[] iArr3 = this.f11359a;
            int i11 = i7 + 1;
            System.arraycopy(iArr3, i7, iArr3, i11, i10 - i7);
            Object[] objArr2 = this.f11360b;
            System.arraycopy(objArr2, i7, objArr2, i11, this.f11361c - i7);
        }
        this.f11359a[i7] = i6;
        this.f11360b[i7] = obj;
        this.f11361c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        b(this.f11361c + collection.size());
        boolean z5 = false;
        for (Object obj : collection) {
            z5 |= add(obj);
        }
        return z5;
    }

    public void b(int i6) {
        int[] iArr = this.f11359a;
        if (iArr.length < i6) {
            Object[] objArr = this.f11360b;
            a(i6);
            int i7 = this.f11361c;
            if (i7 > 0) {
                System.arraycopy(iArr, 0, this.f11359a, 0, i7);
                System.arraycopy(objArr, 0, this.f11360b, 0, this.f11361c);
            }
            c(iArr, objArr, this.f11361c);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i6 = this.f11361c;
        if (i6 != 0) {
            c(this.f11359a, this.f11360b, i6);
            this.f11359a = f11353e;
            this.f11360b = f11354f;
            this.f11361c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i6 = 0; i6 < this.f11361c; i6++) {
                try {
                    if (!set.contains(h(i6))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public Object g(int i6) {
        Object[] objArr = this.f11360b;
        Object obj = objArr[i6];
        int i7 = this.f11361c;
        if (i7 <= 1) {
            c(this.f11359a, objArr, i7);
            this.f11359a = f11353e;
            this.f11360b = f11354f;
            this.f11361c = 0;
        } else {
            int[] iArr = this.f11359a;
            if (iArr.length <= 8 || i7 >= iArr.length / 3) {
                int i8 = i7 - 1;
                this.f11361c = i8;
                if (i6 < i8) {
                    int i9 = i6 + 1;
                    System.arraycopy(iArr, i9, iArr, i6, i8 - i6);
                    Object[] objArr2 = this.f11360b;
                    System.arraycopy(objArr2, i9, objArr2, i6, this.f11361c - i6);
                }
                this.f11360b[this.f11361c] = null;
            } else {
                a(i7 > 8 ? i7 + (i7 >> 1) : 8);
                this.f11361c--;
                if (i6 > 0) {
                    System.arraycopy(iArr, 0, this.f11359a, 0, i6);
                    System.arraycopy(objArr, 0, this.f11360b, 0, i6);
                }
                int i10 = this.f11361c;
                if (i6 < i10) {
                    int i11 = i6 + 1;
                    System.arraycopy(iArr, i11, this.f11359a, i6, i10 - i6);
                    System.arraycopy(objArr, i11, this.f11360b, i6, this.f11361c - i6);
                }
            }
        }
        return obj;
    }

    public Object h(int i6) {
        return this.f11360b[i6];
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f11359a;
        int i6 = this.f11361c;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            i7 += iArr[i8];
        }
        return i7;
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f11361c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            g(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        boolean z5 = false;
        for (Object obj : collection) {
            z5 |= remove(obj);
        }
        return z5;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        boolean z5 = false;
        for (int i6 = this.f11361c - 1; i6 >= 0; i6--) {
            if (!collection.contains(this.f11360b[i6])) {
                g(i6);
                z5 = true;
            }
        }
        return z5;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f11361c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i6 = this.f11361c;
        Object[] objArr = new Object[i6];
        System.arraycopy(this.f11360b, 0, objArr, 0, i6);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f11361c * 14);
        sb.append('{');
        for (int i6 = 0; i6 < this.f11361c; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            Object h6 = h(i6);
            if (h6 != this) {
                sb.append(h6);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i6) {
        if (i6 == 0) {
            this.f11359a = f11353e;
            this.f11360b = f11354f;
        } else {
            a(i6);
        }
        this.f11361c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f11361c) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f11361c);
        }
        System.arraycopy(this.f11360b, 0, objArr, 0, this.f11361c);
        int length = objArr.length;
        int i6 = this.f11361c;
        if (length > i6) {
            objArr[i6] = null;
        }
        return objArr;
    }
}
