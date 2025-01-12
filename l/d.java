package l;
/* loaded from: classes.dex */
public class d implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f11367e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private boolean f11368a;

    /* renamed from: b  reason: collision with root package name */
    private long[] f11369b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f11370c;

    /* renamed from: d  reason: collision with root package name */
    private int f11371d;

    public d() {
        this(10);
    }

    private void d() {
        int i6 = this.f11371d;
        long[] jArr = this.f11369b;
        Object[] objArr = this.f11370c;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            Object obj = objArr[i8];
            if (obj != f11367e) {
                if (i8 != i7) {
                    jArr[i7] = jArr[i8];
                    objArr[i7] = obj;
                    objArr[i8] = null;
                }
                i7++;
            }
        }
        this.f11368a = false;
        this.f11371d = i7;
    }

    public void a(long j6, Object obj) {
        int i6 = this.f11371d;
        if (i6 != 0 && j6 <= this.f11369b[i6 - 1]) {
            i(j6, obj);
            return;
        }
        if (this.f11368a && i6 >= this.f11369b.length) {
            d();
        }
        int i7 = this.f11371d;
        if (i7 >= this.f11369b.length) {
            int f6 = c.f(i7 + 1);
            long[] jArr = new long[f6];
            Object[] objArr = new Object[f6];
            long[] jArr2 = this.f11369b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f11370c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f11369b = jArr;
            this.f11370c = objArr;
        }
        this.f11369b[i7] = j6;
        this.f11370c[i7] = obj;
        this.f11371d = i7 + 1;
    }

    public void b() {
        int i6 = this.f11371d;
        Object[] objArr = this.f11370c;
        for (int i7 = 0; i7 < i6; i7++) {
            objArr[i7] = null;
        }
        this.f11371d = 0;
        this.f11368a = false;
    }

    /* renamed from: c */
    public d clone() {
        try {
            d dVar = (d) super.clone();
            dVar.f11369b = (long[]) this.f11369b.clone();
            dVar.f11370c = (Object[]) this.f11370c.clone();
            return dVar;
        } catch (CloneNotSupportedException e6) {
            throw new AssertionError(e6);
        }
    }

    public Object e(long j6) {
        return f(j6, null);
    }

    public Object f(long j6, Object obj) {
        Object obj2;
        int b6 = c.b(this.f11369b, this.f11371d, j6);
        return (b6 < 0 || (obj2 = this.f11370c[b6]) == f11367e) ? obj : obj2;
    }

    public int g(long j6) {
        if (this.f11368a) {
            d();
        }
        return c.b(this.f11369b, this.f11371d, j6);
    }

    public long h(int i6) {
        if (this.f11368a) {
            d();
        }
        return this.f11369b[i6];
    }

    public void i(long j6, Object obj) {
        int b6 = c.b(this.f11369b, this.f11371d, j6);
        if (b6 >= 0) {
            this.f11370c[b6] = obj;
            return;
        }
        int i6 = ~b6;
        int i7 = this.f11371d;
        if (i6 < i7) {
            Object[] objArr = this.f11370c;
            if (objArr[i6] == f11367e) {
                this.f11369b[i6] = j6;
                objArr[i6] = obj;
                return;
            }
        }
        if (this.f11368a && i7 >= this.f11369b.length) {
            d();
            i6 = ~c.b(this.f11369b, this.f11371d, j6);
        }
        int i8 = this.f11371d;
        if (i8 >= this.f11369b.length) {
            int f6 = c.f(i8 + 1);
            long[] jArr = new long[f6];
            Object[] objArr2 = new Object[f6];
            long[] jArr2 = this.f11369b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f11370c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f11369b = jArr;
            this.f11370c = objArr2;
        }
        int i9 = this.f11371d;
        if (i9 - i6 != 0) {
            long[] jArr3 = this.f11369b;
            int i10 = i6 + 1;
            System.arraycopy(jArr3, i6, jArr3, i10, i9 - i6);
            Object[] objArr4 = this.f11370c;
            System.arraycopy(objArr4, i6, objArr4, i10, this.f11371d - i6);
        }
        this.f11369b[i6] = j6;
        this.f11370c[i6] = obj;
        this.f11371d++;
    }

    public void j(long j6) {
        int b6 = c.b(this.f11369b, this.f11371d, j6);
        if (b6 >= 0) {
            Object[] objArr = this.f11370c;
            Object obj = objArr[b6];
            Object obj2 = f11367e;
            if (obj != obj2) {
                objArr[b6] = obj2;
                this.f11368a = true;
            }
        }
    }

    public void k(int i6) {
        Object[] objArr = this.f11370c;
        Object obj = objArr[i6];
        Object obj2 = f11367e;
        if (obj != obj2) {
            objArr[i6] = obj2;
            this.f11368a = true;
        }
    }

    public int l() {
        if (this.f11368a) {
            d();
        }
        return this.f11371d;
    }

    public Object m(int i6) {
        if (this.f11368a) {
            d();
        }
        return this.f11370c[i6];
    }

    public String toString() {
        if (l() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f11371d * 28);
        sb.append('{');
        for (int i6 = 0; i6 < this.f11371d; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(h(i6));
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

    public d(int i6) {
        this.f11368a = false;
        if (i6 == 0) {
            this.f11369b = c.f11365b;
            this.f11370c = c.f11366c;
            return;
        }
        int f6 = c.f(i6);
        this.f11369b = new long[f6];
        this.f11370c = new Object[f6];
    }
}
