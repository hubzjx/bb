package g;

import e.C0239j$m;
import f.InterfaceC0267j$o;
import f.InterfaceC0270j$r;
import f.InterfaceC0274j$v;
import j$.util.function.BiConsumer;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
/* renamed from: g.j$b  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0281j$b implements InterfaceC0274j$v, f.j$N, BiConsumer, InterfaceC0267j$o, f.j$V, ToDoubleFunction, ToIntFunction, f.j$z, InterfaceC0270j$r, f.j$P, f.j$L, ToLongFunction, f.j$R, f.j$C, f.j$G {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10114a;

    public /* synthetic */ C0281j$b(int i6) {
        this.f10114a = i6;
    }

    @Override // j$.util.function.ToIntFunction
    public final int a(Object obj) {
        int i6 = j$Z.f10108s;
        return ((Integer) obj).intValue();
    }

    @Override // f.j$N
    public final void b(Object obj, double d6) {
        switch (this.f10114a) {
            case 2:
                double[] dArr = (double[]) obj;
                int i6 = j$A.f9946s;
                AbstractC0317j$k.a(dArr, d6);
                dArr[2] = dArr[2] + d6;
                return;
            default:
                double[] dArr2 = (double[]) obj;
                int i7 = j$A.f9946s;
                dArr2[2] = dArr2[2] + 1.0d;
                AbstractC0317j$k.a(dArr2, d6);
                dArr2[3] = dArr2[3] + d6;
                return;
        }
    }

    @Override // j$.util.function.ToLongFunction
    public final long c(Object obj) {
        int i6 = AbstractC0306j$h0.f10169s;
        return ((Long) obj).longValue();
    }

    @Override // f.InterfaceC0267j$o
    public final long d(double d6) {
        int i6 = j$A.f9946s;
        return 1L;
    }

    @Override // j$.util.function.ToDoubleFunction
    public final double e(Object obj) {
        int i6 = j$A.f9946s;
        return ((Double) obj).doubleValue();
    }

    @Override // f.j$L
    public final long f(long j6) {
        int i6 = AbstractC0306j$h0.f10169s;
        return 1L;
    }

    @Override // f.InterfaceC0270j$r
    public final int g(int i6, int i7) {
        int i8 = j$Z.f10108s;
        return i6 + i7;
    }

    @Override // f.j$V
    public final Object get() {
        switch (this.f10114a) {
            case 5:
                int i6 = j$A.f9946s;
                return new double[4];
            case 9:
                int i7 = j$A.f9946s;
                return new double[3];
            case 10:
                return new j$E();
            case 11:
                return new j$G();
            case 12:
                return new j$I() { // from class: g.j$H
                    @Override // f.j$V
                    public final Object get() {
                        if (this.f9998a) {
                            return C0239j$m.d(this.f9999b);
                        }
                        return null;
                    }
                };
            case 13:
                return new j$F();
            case 18:
                int i8 = j$Z.f10108s;
                return new long[2];
            default:
                int i9 = AbstractC0306j$h0.f10169s;
                return new long[2];
        }
    }

    @Override // f.j$z
    public final long h(int i6) {
        int i7 = j$Z.f10108s;
        return 1L;
    }

    @Override // f.j$C
    public final long k(long j6, long j7) {
        int i6 = AbstractC0306j$h0.f10169s;
        return j6 + j7;
    }

    @Override // f.j$R
    public final void l(Object obj, long j6) {
        long[] jArr = (long[]) obj;
        int i6 = AbstractC0306j$h0.f10169s;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + j6;
    }

    @Override // j$.util.function.BiConsumer
    public final void n(Object obj, Object obj2) {
        switch (this.f10114a) {
            case 3:
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                int i6 = j$A.f9946s;
                AbstractC0317j$k.a(dArr, dArr2[0]);
                AbstractC0317j$k.a(dArr, dArr2[1]);
                dArr[2] = dArr[2] + dArr2[2];
                return;
            case 7:
                double[] dArr3 = (double[]) obj;
                double[] dArr4 = (double[]) obj2;
                int i7 = j$A.f9946s;
                AbstractC0317j$k.a(dArr3, dArr4[0]);
                AbstractC0317j$k.a(dArr3, dArr4[1]);
                dArr3[2] = dArr3[2] + dArr4[2];
                dArr3[3] = dArr3[3] + dArr4[3];
                return;
            case 20:
                long[] jArr = (long[]) obj;
                long[] jArr2 = (long[]) obj2;
                int i8 = j$Z.f10108s;
                jArr[0] = jArr[0] + jArr2[0];
                jArr[1] = jArr[1] + jArr2[1];
                return;
            default:
                long[] jArr3 = (long[]) obj;
                long[] jArr4 = (long[]) obj2;
                int i9 = AbstractC0306j$h0.f10169s;
                jArr3[0] = jArr3[0] + jArr4[0];
                jArr3[1] = jArr3[1] + jArr4[1];
                return;
        }
    }

    @Override // f.j$P
    public final void p(int i6, Object obj) {
        long[] jArr = (long[]) obj;
        int i7 = j$Z.f10108s;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + i6;
    }

    @Override // f.InterfaceC0274j$v
    public final Object r(int i6) {
        switch (this.f10114a) {
            case 0:
                return new Object[i6];
            case 1:
                int i7 = j$A.f9946s;
                return new Double[i6];
            case 14:
                int i8 = j$P.f10036h;
                return new Object[i6];
            case 21:
                int i9 = j$Z.f10108s;
                return new Integer[i6];
            default:
                int i10 = AbstractC0306j$h0.f10169s;
                return new Long[i6];
        }
    }

    @Override // f.j$G
    public final Object t(long j6) {
        return AbstractC0350j$s0.T(j6);
    }
}
