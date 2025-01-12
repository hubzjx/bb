package e;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class j$X {

    /* renamed from: a  reason: collision with root package name */
    private static final j$J f9276a = new j$T();

    /* renamed from: b  reason: collision with root package name */
    private static final j$D f9277b = new j$R();

    /* renamed from: c  reason: collision with root package name */
    private static final j$F f9278c = new j$S();

    /* renamed from: d  reason: collision with root package name */
    private static final j$B f9279d = new j$Q();

    private static void a(int i6, int i7, int i8) {
        if (i7 <= i8) {
            if (i7 < 0) {
                throw new ArrayIndexOutOfBoundsException(i7);
            }
            if (i8 > i6) {
                throw new ArrayIndexOutOfBoundsException(i8);
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException("origin(" + i7 + ") > fence(" + i8 + ")");
    }

    public static j$B b() {
        return f9279d;
    }

    public static j$D c() {
        return f9277b;
    }

    public static j$F d() {
        return f9278c;
    }

    public static j$J e() {
        return f9276a;
    }

    public static InterfaceC0245j$s f(j$B j_b) {
        j_b.getClass();
        return new j$N(j_b);
    }

    public static InterfaceC0248j$v g(j$D j_d) {
        j_d.getClass();
        return new j$L(j_d);
    }

    public static InterfaceC0251j$y h(j$F j_f) {
        j_f.getClass();
        return new j$M(j_f);
    }

    public static Iterator i(j$J j_j) {
        j_j.getClass();
        return new j$K(j_j);
    }

    public static j$B j(double[] dArr, int i6, int i7) {
        dArr.getClass();
        a(dArr.length, i6, i7);
        return new j$P(dArr, i6, i7, 1040);
    }

    public static j$D k(int[] iArr, int i6, int i7) {
        iArr.getClass();
        a(iArr.length, i6, i7);
        return new j$U(iArr, i6, i7, 1040);
    }

    public static j$F l(long[] jArr, int i6, int i7) {
        jArr.getClass();
        a(jArr.length, i6, i7);
        return new j$W(jArr, i6, i7, 1040);
    }

    public static j$J m(Object[] objArr, int i6, int i7) {
        objArr.getClass();
        a(objArr.length, i6, i7);
        return new j$O(objArr, i6, i7, 1040);
    }
}
