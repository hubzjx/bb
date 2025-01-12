package l;
/* loaded from: classes.dex */
public class h implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f11402e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private boolean f11403a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f11404b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f11405c;

    /* renamed from: d  reason: collision with root package name */
    private int f11406d;

    public h() {
        this(10);
    }

    private void d() {
        int i6 = this.f11406d;
        int[] iArr = this.f11404b;
        Object[] objArr = this.f11405c;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            Object obj = objArr[i8];
            if (obj != f11402e) {
                if (i8 != i7) {
                    iArr[i7] = iArr[i8];
                    objArr[i7] = obj;
                    objArr[i8] = null;
                }
                i7++;
            }
        }
        this.f11403a = false;
        this.f11406d = i7;
    }

    public void a(int i6, Object obj) {
        int i7 = this.f11406d;
        if (i7 != 0 && i6 <= this.f11404b[i7 - 1]) {
            i(i6, obj);
            return;
        }
        if (this.f11403a && i7 >= this.f11404b.length) {
            d();
        }
        int i8 = this.f11406d;
        if (i8 >= this.f11404b.length) {
            int e6 = c.e(i8 + 1);
            int[] iArr = new int[e6];
            Object[] objArr = new Object[e6];
            int[] iArr2 = this.f11404b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f11405c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f11404b = iArr;
            this.f11405c = objArr;
        }
        this.f11404b[i8] = i6;
        this.f11405c[i8] = obj;
        this.f11406d = i8 + 1;
    }

    public void b() {
        int i6 = this.f11406d;
        Object[] objArr = this.f11405c;
        for (int i7 = 0; i7 < i6; i7++) {
            objArr[i7] = null;
        }
        this.f11406d = 0;
        this.f11403a = false;
    }

    /* renamed from: c */
    public h clone() {
        try {
            h hVar = (h) super.clone();
            hVar.f11404b = (int[]) this.f11404b.clone();
            hVar.f11405c = (Object[]) this.f11405c.clone();
            return hVar;
        } catch (CloneNotSupportedException e6) {
            throw new AssertionError(e6);
        }
    }

    public Object e(int i6) {
        return f(i6, null);
    }

    public Object f(int i6, Object obj) {
        Object obj2;
        int a6 = c.a(this.f11404b, this.f11406d, i6);
        return (a6 < 0 || (obj2 = this.f11405c[a6]) == f11402e) ? obj : obj2;
    }

    public int g(Object obj) {
        if (this.f11403a) {
            d();
        }
        for (int i6 = 0; i6 < this.f11406d; i6++) {
            if (this.f11405c[i6] == obj) {
                return i6;
            }
        }
        return -1;
    }

    public int h(int i6) {
        if (this.f11403a) {
            d();
        }
        return this.f11404b[i6];
    }

    public void i(int i6, Object obj) {
        int a6 = c.a(this.f11404b, this.f11406d, i6);
        if (a6 >= 0) {
            this.f11405c[a6] = obj;
            return;
        }
        int i7 = ~a6;
        int i8 = this.f11406d;
        if (i7 < i8) {
            Object[] objArr = this.f11405c;
            if (objArr[i7] == f11402e) {
                this.f11404b[i7] = i6;
                objArr[i7] = obj;
                return;
            }
        }
        if (this.f11403a && i8 >= this.f11404b.length) {
            d();
            i7 = ~c.a(this.f11404b, this.f11406d, i6);
        }
        int i9 = this.f11406d;
        if (i9 >= this.f11404b.length) {
            int e6 = c.e(i9 + 1);
            int[] iArr = new int[e6];
            Object[] objArr2 = new Object[e6];
            int[] iArr2 = this.f11404b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f11405c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f11404b = iArr;
            this.f11405c = objArr2;
        }
        int i10 = this.f11406d;
        if (i10 - i7 != 0) {
            int[] iArr3 = this.f11404b;
            int i11 = i7 + 1;
            System.arraycopy(iArr3, i7, iArr3, i11, i10 - i7);
            Object[] objArr4 = this.f11405c;
            System.arraycopy(objArr4, i7, objArr4, i11, this.f11406d - i7);
        }
        this.f11404b[i7] = i6;
        this.f11405c[i7] = obj;
        this.f11406d++;
    }

    public void j(int i6) {
        int a6 = c.a(this.f11404b, this.f11406d, i6);
        if (a6 >= 0) {
            Object[] objArr = this.f11405c;
            Object obj = objArr[a6];
            Object obj2 = f11402e;
            if (obj != obj2) {
                objArr[a6] = obj2;
                this.f11403a = true;
            }
        }
    }

    public int k() {
        if (this.f11403a) {
            d();
        }
        return this.f11406d;
    }

    public Object l(int i6) {
        if (this.f11403a) {
            d();
        }
        return this.f11405c[i6];
    }

    public String toString() {
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f11406d * 28);
        sb.append('{');
        for (int i6 = 0; i6 < this.f11406d; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(h(i6));
            sb.append('=');
            Object l6 = l(i6);
            if (l6 != this) {
                sb.append(l6);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public h(int i6) {
        this.f11403a = false;
        if (i6 == 0) {
            this.f11404b = c.f11364a;
            this.f11405c = c.f11366c;
            return;
        }
        int e6 = c.e(i6);
        this.f11404b = new int[e6];
        this.f11405c = new Object[e6];
    }
}
