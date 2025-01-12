package g;

import java.util.Arrays;
import java.util.Spliterator;
/* loaded from: classes2.dex */
abstract class j$J2 extends AbstractC0293j$e implements Iterable {

    /* renamed from: e  reason: collision with root package name */
    Object f10013e;

    /* renamed from: f  reason: collision with root package name */
    Object[] f10014f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$J2() {
        this.f10013e = g(16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$J2(int i6) {
        super(i6);
        this.f10013e = g(1 << this.f10141a);
    }

    protected abstract Object[] A();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B() {
        long x5;
        if (this.f10142b == x(this.f10013e)) {
            if (this.f10014f == null) {
                Object[] A = A();
                this.f10014f = A;
                this.f10144d = new long[8];
                A[0] = this.f10013e;
            }
            int i6 = this.f10143c;
            int i7 = i6 + 1;
            Object[] objArr = this.f10014f;
            if (i7 >= objArr.length || objArr[i7] == null) {
                if (i6 == 0) {
                    x5 = x(this.f10013e);
                } else {
                    x5 = x(objArr[i6]) + this.f10144d[i6];
                }
                z(x5 + 1);
            }
            this.f10142b = 0;
            int i8 = this.f10143c + 1;
            this.f10143c = i8;
            this.f10013e = this.f10014f[i8];
        }
    }

    @Override // g.AbstractC0293j$e
    public final void clear() {
        Object[] objArr = this.f10014f;
        if (objArr != null) {
            this.f10013e = objArr[0];
            this.f10014f = null;
            this.f10144d = null;
        }
        this.f10142b = 0;
        this.f10143c = 0;
    }

    public abstract Object g(int i6);

    public Object k() {
        long count = count();
        if (count < 2147483639) {
            Object g6 = g((int) count);
            u(0, g6);
            return g6;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public void l(Object obj) {
        for (int i6 = 0; i6 < this.f10143c; i6++) {
            Object obj2 = this.f10014f[i6];
            w(obj2, 0, x(obj2), obj);
        }
        w(this.f10013e, 0, this.f10142b, obj);
    }

    public abstract e.j$J spliterator();

    @Override // java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return e.j$I.a(spliterator());
    }

    public void u(int i6, Object obj) {
        long j6 = i6;
        long count = count() + j6;
        if (count > x(obj) || count < j6) {
            throw new IndexOutOfBoundsException("does not fit");
        }
        if (this.f10143c == 0) {
            System.arraycopy(this.f10013e, 0, obj, i6, this.f10142b);
            return;
        }
        for (int i7 = 0; i7 < this.f10143c; i7++) {
            Object obj2 = this.f10014f[i7];
            System.arraycopy(obj2, 0, obj, i6, x(obj2));
            i6 += x(this.f10014f[i7]);
        }
        int i8 = this.f10142b;
        if (i8 > 0) {
            System.arraycopy(this.f10013e, 0, obj, i6, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void w(Object obj, int i6, int i7, Object obj2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int x(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int y(long j6) {
        if (this.f10143c == 0) {
            if (j6 < this.f10142b) {
                return 0;
            }
            throw new IndexOutOfBoundsException(Long.toString(j6));
        } else if (j6 < count()) {
            for (int i6 = 0; i6 <= this.f10143c; i6++) {
                if (j6 < this.f10144d[i6] + x(this.f10014f[i6])) {
                    return i6;
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j6));
        } else {
            throw new IndexOutOfBoundsException(Long.toString(j6));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void z(long j6) {
        long x5;
        int i6;
        int i7 = this.f10143c;
        if (i7 == 0) {
            x5 = x(this.f10013e);
        } else {
            x5 = x(this.f10014f[i7]) + this.f10144d[i7];
        }
        if (j6 <= x5) {
            return;
        }
        if (this.f10014f == null) {
            Object[] A = A();
            this.f10014f = A;
            this.f10144d = new long[8];
            A[0] = this.f10013e;
        }
        int i8 = this.f10143c;
        while (true) {
            i8++;
            if (j6 <= x5) {
                return;
            }
            Object[] objArr = this.f10014f;
            if (i8 >= objArr.length) {
                int length = objArr.length * 2;
                this.f10014f = Arrays.copyOf(objArr, length);
                this.f10144d = Arrays.copyOf(this.f10144d, length);
            }
            int i9 = this.f10141a;
            if (i8 != 0 && i8 != 1) {
                i9 = Math.min((i9 + i8) - 1, 30);
            }
            int i10 = 1 << i9;
            this.f10014f[i8] = g(i10);
            long[] jArr = this.f10144d;
            jArr[i8] = jArr[i8 - 1] + x(this.f10014f[i6]);
            x5 += i10;
        }
    }
}
