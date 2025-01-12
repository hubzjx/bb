package l;

import java.util.ConcurrentModificationException;
import java.util.Map;
/* loaded from: classes.dex */
public class g {

    /* renamed from: d  reason: collision with root package name */
    static Object[] f11395d;

    /* renamed from: e  reason: collision with root package name */
    static int f11396e;

    /* renamed from: f  reason: collision with root package name */
    static Object[] f11397f;

    /* renamed from: g  reason: collision with root package name */
    static int f11398g;

    /* renamed from: a  reason: collision with root package name */
    int[] f11399a;

    /* renamed from: b  reason: collision with root package name */
    Object[] f11400b;

    /* renamed from: c  reason: collision with root package name */
    int f11401c;

    public g() {
        this.f11399a = c.f11364a;
        this.f11400b = c.f11366c;
        this.f11401c = 0;
    }

    private void a(int i6) {
        if (i6 == 8) {
            synchronized (g.class) {
                Object[] objArr = f11397f;
                if (objArr != null) {
                    this.f11400b = objArr;
                    f11397f = (Object[]) objArr[0];
                    this.f11399a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f11398g--;
                    return;
                }
            }
        } else if (i6 == 4) {
            synchronized (g.class) {
                Object[] objArr2 = f11395d;
                if (objArr2 != null) {
                    this.f11400b = objArr2;
                    f11395d = (Object[]) objArr2[0];
                    this.f11399a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f11396e--;
                    return;
                }
            }
        }
        this.f11399a = new int[i6];
        this.f11400b = new Object[i6 << 1];
    }

    private static int b(int[] iArr, int i6, int i7) {
        try {
            return c.a(iArr, i6, i7);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i6) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                if (f11398g < 10) {
                    objArr[0] = f11397f;
                    objArr[1] = iArr;
                    for (int i7 = (i6 << 1) - 1; i7 >= 2; i7--) {
                        objArr[i7] = null;
                    }
                    f11397f = objArr;
                    f11398g++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (g.class) {
                if (f11396e < 10) {
                    objArr[0] = f11395d;
                    objArr[1] = iArr;
                    for (int i8 = (i6 << 1) - 1; i8 >= 2; i8--) {
                        objArr[i8] = null;
                    }
                    f11395d = objArr;
                    f11396e++;
                }
            }
        }
    }

    public void c(int i6) {
        int i7 = this.f11401c;
        int[] iArr = this.f11399a;
        if (iArr.length < i6) {
            Object[] objArr = this.f11400b;
            a(i6);
            if (this.f11401c > 0) {
                System.arraycopy(iArr, 0, this.f11399a, 0, i7);
                System.arraycopy(objArr, 0, this.f11400b, 0, i7 << 1);
            }
            d(iArr, objArr, i7);
        }
        if (this.f11401c != i7) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i6 = this.f11401c;
        if (i6 > 0) {
            int[] iArr = this.f11399a;
            Object[] objArr = this.f11400b;
            this.f11399a = c.f11364a;
            this.f11400b = c.f11366c;
            this.f11401c = 0;
            d(iArr, objArr, i6);
        }
        if (this.f11401c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    int e(Object obj, int i6) {
        int i7 = this.f11401c;
        if (i7 == 0) {
            return -1;
        }
        int b6 = b(this.f11399a, i7, i6);
        if (b6 >= 0 && !obj.equals(this.f11400b[b6 << 1])) {
            int i8 = b6 + 1;
            while (i8 < i7 && this.f11399a[i8] == i6) {
                if (obj.equals(this.f11400b[i8 << 1])) {
                    return i8;
                }
                i8++;
            }
            for (int i9 = b6 - 1; i9 >= 0 && this.f11399a[i9] == i6; i9--) {
                if (obj.equals(this.f11400b[i9 << 1])) {
                    return i9;
                }
            }
            return ~i8;
        }
        return b6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i6 = 0; i6 < this.f11401c; i6++) {
                try {
                    Object i7 = i(i6);
                    Object m5 = m(i6);
                    Object obj2 = gVar.get(i7);
                    if (m5 == null) {
                        if (obj2 != null || !gVar.containsKey(i7)) {
                            return false;
                        }
                    } else if (!m5.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i8 = 0; i8 < this.f11401c; i8++) {
                try {
                    Object i9 = i(i8);
                    Object m6 = m(i8);
                    Object obj3 = map.get(i9);
                    if (m6 == null) {
                        if (obj3 != null || !map.containsKey(i9)) {
                            return false;
                        }
                    } else if (!m6.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i6 = this.f11401c;
        if (i6 == 0) {
            return -1;
        }
        int b6 = b(this.f11399a, i6, 0);
        if (b6 >= 0 && this.f11400b[b6 << 1] != null) {
            int i7 = b6 + 1;
            while (i7 < i6 && this.f11399a[i7] == 0) {
                if (this.f11400b[i7 << 1] == null) {
                    return i7;
                }
                i7++;
            }
            for (int i8 = b6 - 1; i8 >= 0 && this.f11399a[i8] == 0; i8--) {
                if (this.f11400b[i8 << 1] == null) {
                    return i8;
                }
            }
            return ~i7;
        }
        return b6;
    }

    public Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int f6 = f(obj);
        return f6 >= 0 ? this.f11400b[(f6 << 1) + 1] : obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(Object obj) {
        int i6 = this.f11401c * 2;
        Object[] objArr = this.f11400b;
        if (obj == null) {
            for (int i7 = 1; i7 < i6; i7 += 2) {
                if (objArr[i7] == null) {
                    return i7 >> 1;
                }
            }
            return -1;
        }
        for (int i8 = 1; i8 < i6; i8 += 2) {
            if (obj.equals(objArr[i8])) {
                return i8 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f11399a;
        Object[] objArr = this.f11400b;
        int i6 = this.f11401c;
        int i7 = 1;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            Object obj = objArr[i7];
            i9 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i8];
            i8++;
            i7 += 2;
        }
        return i9;
    }

    public Object i(int i6) {
        return this.f11400b[i6 << 1];
    }

    public boolean isEmpty() {
        return this.f11401c <= 0;
    }

    public void j(g gVar) {
        int i6 = gVar.f11401c;
        c(this.f11401c + i6);
        if (this.f11401c != 0) {
            for (int i7 = 0; i7 < i6; i7++) {
                put(gVar.i(i7), gVar.m(i7));
            }
        } else if (i6 > 0) {
            System.arraycopy(gVar.f11399a, 0, this.f11399a, 0, i6);
            System.arraycopy(gVar.f11400b, 0, this.f11400b, 0, i6 << 1);
            this.f11401c = i6;
        }
    }

    public Object k(int i6) {
        Object[] objArr = this.f11400b;
        int i7 = i6 << 1;
        Object obj = objArr[i7 + 1];
        int i8 = this.f11401c;
        int i9 = 0;
        if (i8 <= 1) {
            d(this.f11399a, objArr, i8);
            this.f11399a = c.f11364a;
            this.f11400b = c.f11366c;
        } else {
            int i10 = i8 - 1;
            int[] iArr = this.f11399a;
            if (iArr.length <= 8 || i8 >= iArr.length / 3) {
                if (i6 < i10) {
                    int i11 = i6 + 1;
                    int i12 = i10 - i6;
                    System.arraycopy(iArr, i11, iArr, i6, i12);
                    Object[] objArr2 = this.f11400b;
                    System.arraycopy(objArr2, i11 << 1, objArr2, i7, i12 << 1);
                }
                Object[] objArr3 = this.f11400b;
                int i13 = i10 << 1;
                objArr3[i13] = null;
                objArr3[i13 + 1] = null;
            } else {
                a(i8 > 8 ? i8 + (i8 >> 1) : 8);
                if (i8 != this.f11401c) {
                    throw new ConcurrentModificationException();
                }
                if (i6 > 0) {
                    System.arraycopy(iArr, 0, this.f11399a, 0, i6);
                    System.arraycopy(objArr, 0, this.f11400b, 0, i7);
                }
                if (i6 < i10) {
                    int i14 = i6 + 1;
                    int i15 = i10 - i6;
                    System.arraycopy(iArr, i14, this.f11399a, i6, i15);
                    System.arraycopy(objArr, i14 << 1, this.f11400b, i7, i15 << 1);
                }
            }
            i9 = i10;
        }
        if (i8 == this.f11401c) {
            this.f11401c = i9;
            return obj;
        }
        throw new ConcurrentModificationException();
    }

    public Object l(int i6, Object obj) {
        int i7 = (i6 << 1) + 1;
        Object[] objArr = this.f11400b;
        Object obj2 = objArr[i7];
        objArr[i7] = obj;
        return obj2;
    }

    public Object m(int i6) {
        return this.f11400b[(i6 << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i6;
        int e6;
        int i7 = this.f11401c;
        if (obj == null) {
            e6 = g();
            i6 = 0;
        } else {
            int hashCode = obj.hashCode();
            i6 = hashCode;
            e6 = e(obj, hashCode);
        }
        if (e6 >= 0) {
            int i8 = (e6 << 1) + 1;
            Object[] objArr = this.f11400b;
            Object obj3 = objArr[i8];
            objArr[i8] = obj2;
            return obj3;
        }
        int i9 = ~e6;
        int[] iArr = this.f11399a;
        if (i7 >= iArr.length) {
            int i10 = 8;
            if (i7 >= 8) {
                i10 = (i7 >> 1) + i7;
            } else if (i7 < 4) {
                i10 = 4;
            }
            Object[] objArr2 = this.f11400b;
            a(i10);
            if (i7 != this.f11401c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f11399a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f11400b, 0, objArr2.length);
            }
            d(iArr, objArr2, i7);
        }
        if (i9 < i7) {
            int[] iArr3 = this.f11399a;
            int i11 = i9 + 1;
            System.arraycopy(iArr3, i9, iArr3, i11, i7 - i9);
            Object[] objArr3 = this.f11400b;
            System.arraycopy(objArr3, i9 << 1, objArr3, i11 << 1, (this.f11401c - i9) << 1);
        }
        int i12 = this.f11401c;
        if (i7 == i12) {
            int[] iArr4 = this.f11399a;
            if (i9 < iArr4.length) {
                iArr4[i9] = i6;
                Object[] objArr4 = this.f11400b;
                int i13 = i9 << 1;
                objArr4[i13] = obj;
                objArr4[i13 + 1] = obj2;
                this.f11401c = i12 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int f6 = f(obj);
        if (f6 >= 0) {
            return k(f6);
        }
        return null;
    }

    public Object replace(Object obj, Object obj2) {
        int f6 = f(obj);
        if (f6 >= 0) {
            return l(f6, obj2);
        }
        return null;
    }

    public int size() {
        return this.f11401c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f11401c * 28);
        sb.append('{');
        for (int i6 = 0; i6 < this.f11401c; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            Object i7 = i(i6);
            if (i7 != this) {
                sb.append(i7);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object m5 = m(i6);
            if (m5 != this) {
                sb.append(m5);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public g(int i6) {
        if (i6 == 0) {
            this.f11399a = c.f11364a;
            this.f11400b = c.f11366c;
        } else {
            a(i6);
        }
        this.f11401c = 0;
    }

    public boolean remove(Object obj, Object obj2) {
        int f6 = f(obj);
        if (f6 >= 0) {
            Object m5 = m(f6);
            if (obj2 == m5 || (obj2 != null && obj2.equals(m5))) {
                k(f6);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int f6 = f(obj);
        if (f6 >= 0) {
            Object m5 = m(f6);
            if (m5 == obj2 || (obj2 != null && obj2.equals(m5))) {
                l(f6, obj3);
                return true;
            }
            return false;
        }
        return false;
    }

    public g(g gVar) {
        this();
        if (gVar != null) {
            j(gVar);
        }
    }
}
