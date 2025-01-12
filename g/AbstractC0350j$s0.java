package g;

import f.C0256j$d;
import f.C0260j$h;
import f.C0264j$l;
import f.C0271j$s;
import f.C0275j$w;
import f.InterfaceC0257j$e;
import f.InterfaceC0261j$i;
import f.InterfaceC0272j$t;
import f.InterfaceC0274j$v;
import okhttp3.internal.http2.Http2;
/* renamed from: g.j$s0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0350j$s0 implements j$x3 {

    /* renamed from: a  reason: collision with root package name */
    private static final j$T0 f10262a = new j$U0() { // from class: g.j$T0
        @Override // g.j$B0
        public final /* bridge */ /* synthetic */ void b(InterfaceC0257j$e interfaceC0257j$e) {
        }

        @Override // g.j$B0
        public final /* bridge */ /* synthetic */ void p(Object[] objArr, int i6) {
        }

        @Override // g.j$B0
        public final e.j$J spliterator() {
            return e.j$X.e();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final InterfaceC0374j$y0 f10263b = new j$R0();

    /* renamed from: c  reason: collision with root package name */
    private static final InterfaceC0378j$z0 f10264c = new j$S0();

    /* renamed from: d  reason: collision with root package name */
    private static final InterfaceC0370j$x0 f10265d = new j$Q0();

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f10266e = new int[0];

    /* renamed from: f  reason: collision with root package name */
    private static final long[] f10267f = new long[0];

    /* renamed from: g  reason: collision with root package name */
    private static final double[] f10268g = new double[0];

    public AbstractC0350j$s0() {
    }

    public AbstractC0350j$s0(int i6) {
    }

    public static void A(InterfaceC0378j$z0 interfaceC0378j$z0, InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof f.j$E) {
            interfaceC0378j$z0.l((f.j$E) interfaceC0257j$e);
        } else if (j$A3.f9953a) {
            j$A3.a(interfaceC0378j$z0.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
            throw null;
        } else {
            ((e.j$F) interfaceC0378j$z0.spliterator()).b(interfaceC0257j$e);
        }
    }

    public static InterfaceC0370j$x0 B(InterfaceC0370j$x0 interfaceC0370j$x0, long j6, long j7) {
        if (j6 == 0 && j7 == interfaceC0370j$x0.count()) {
            return interfaceC0370j$x0;
        }
        long j8 = j7 - j6;
        e.j$B j_b = (e.j$B) interfaceC0370j$x0.spliterator();
        InterfaceC0354j$t0 T = T(j8);
        T.i(j8);
        for (int i6 = 0; i6 < j6 && j_b.n(new j$f3(1)); i6++) {
        }
        for (int i7 = 0; i7 < j8 && j_b.n(T); i7++) {
        }
        T.h();
        return T.a();
    }

    public static InterfaceC0374j$y0 C(InterfaceC0374j$y0 interfaceC0374j$y0, long j6, long j7) {
        if (j6 == 0 && j7 == interfaceC0374j$y0.count()) {
            return interfaceC0374j$y0;
        }
        long j8 = j7 - j6;
        e.j$D j_d = (e.j$D) interfaceC0374j$y0.spliterator();
        InterfaceC0358j$u0 d02 = d0(j8);
        d02.i(j8);
        for (int i6 = 0; i6 < j6 && j_d.g(new j$h3(1)); i6++) {
        }
        for (int i7 = 0; i7 < j8 && j_d.g(d02); i7++) {
        }
        d02.h();
        return d02.a();
    }

    public static InterfaceC0378j$z0 D(InterfaceC0378j$z0 interfaceC0378j$z0, long j6, long j7) {
        if (j6 == 0 && j7 == interfaceC0378j$z0.count()) {
            return interfaceC0378j$z0;
        }
        long j8 = j7 - j6;
        e.j$F j_f = (e.j$F) interfaceC0378j$z0.spliterator();
        InterfaceC0362j$v0 f02 = f0(j8);
        f02.i(j8);
        for (int i6 = 0; i6 < j6 && j_f.p(new j$j3(1)); i6++) {
        }
        for (int i7 = 0; i7 < j8 && j_f.p(f02); i7++) {
        }
        f02.h();
        return f02.a();
    }

    public static j$B0 E(j$B0 j_b0, long j6, long j7, InterfaceC0274j$v interfaceC0274j$v) {
        if (j6 == 0 && j7 == j_b0.count()) {
            return j_b0;
        }
        e.j$J spliterator = j_b0.spliterator();
        long j8 = j7 - j6;
        InterfaceC0366j$w0 L = L(j8, interfaceC0274j$v);
        L.i(j8);
        for (int i6 = 0; i6 < j6 && spliterator.r(new j$S(9)); i6++) {
        }
        for (int i7 = 0; i7 < j8 && spliterator.r(L); i7++) {
        }
        L.h();
        return L.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long F(long j6, long j7) {
        long j8 = j7 >= 0 ? j6 + j7 : Long.MAX_VALUE;
        if (j8 >= 0) {
            return j8;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.j$J G(int i6, e.j$J j_j, long j6, long j7) {
        long j8 = j7 >= 0 ? j6 + j7 : Long.MAX_VALUE;
        long j9 = j8 >= 0 ? j8 : Long.MAX_VALUE;
        if (i6 != 0) {
            int i7 = i6 - 1;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 == 3) {
                            return new j$g3((e.j$B) j_j, j6, j9);
                        }
                        throw new IllegalStateException("Unknown shape ".concat(j$Q2.a(i6)));
                    }
                    return new j$k3((e.j$F) j_j, j6, j9);
                }
                return new j$i3((e.j$D) j_j, j6, j9);
            }
            return new j$m3(j_j, j6, j9);
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long H(long j6, long j7, long j8) {
        if (j6 >= 0) {
            return Math.max(-1L, Math.min(j6 - j7, j8));
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InterfaceC0366j$w0 L(long j6, InterfaceC0274j$v interfaceC0274j$v) {
        return (j6 < 0 || j6 >= 2147483639) ? new C0331j$n1() : new j$V0(j6, interfaceC0274j$v);
    }

    public static j$B0 M(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, boolean z5, InterfaceC0274j$v interfaceC0274j$v) {
        long W = abstractC0350j$s0.W(j_j);
        if (W < 0 || !j_j.hasCharacteristics(Http2.INITIAL_MAX_FRAME_SIZE)) {
            j$B0 j_b0 = (j$B0) new j$G0(j_j, interfaceC0274j$v, abstractC0350j$s0).invoke();
            return z5 ? Y(j_b0, interfaceC0274j$v) : j_b0;
        } else if (W < 2147483639) {
            Object[] objArr = (Object[]) interfaceC0274j$v.r((int) W);
            new C0323j$l1(j_j, abstractC0350j$s0, objArr).invoke();
            return new j$D0(objArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static InterfaceC0370j$x0 N(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, boolean z5) {
        long W = abstractC0350j$s0.W(j_j);
        if (W < 0 || !j_j.hasCharacteristics(Http2.INITIAL_MAX_FRAME_SIZE)) {
            InterfaceC0370j$x0 interfaceC0370j$x0 = (InterfaceC0370j$x0) new j$G0(0, j_j, abstractC0350j$s0).invoke();
            return z5 ? Z(interfaceC0370j$x0) : interfaceC0370j$x0;
        } else if (W < 2147483639) {
            double[] dArr = new double[(int) W];
            new C0311j$i1(j_j, abstractC0350j$s0, dArr).invoke();
            return new j$N0(dArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static InterfaceC0374j$y0 O(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, boolean z5) {
        long W = abstractC0350j$s0.W(j_j);
        if (W < 0 || !j_j.hasCharacteristics(Http2.INITIAL_MAX_FRAME_SIZE)) {
            InterfaceC0374j$y0 interfaceC0374j$y0 = (InterfaceC0374j$y0) new j$G0(1, j_j, abstractC0350j$s0).invoke();
            return z5 ? a0(interfaceC0374j$y0) : interfaceC0374j$y0;
        } else if (W < 2147483639) {
            int[] iArr = new int[(int) W];
            new C0315j$j1(j_j, abstractC0350j$s0, iArr).invoke();
            return new j$W0(iArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static InterfaceC0378j$z0 P(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, boolean z5) {
        long W = abstractC0350j$s0.W(j_j);
        if (W < 0 || !j_j.hasCharacteristics(Http2.INITIAL_MAX_FRAME_SIZE)) {
            InterfaceC0378j$z0 interfaceC0378j$z0 = (InterfaceC0378j$z0) new j$G0(2, j_j, abstractC0350j$s0).invoke();
            return z5 ? b0(interfaceC0378j$z0) : interfaceC0378j$z0;
        } else if (W < 2147483639) {
            long[] jArr = new long[(int) W];
            new C0319j$k1(j_j, abstractC0350j$s0, jArr).invoke();
            return new C0299j$f1(jArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j$C0 Q(int i6, j$B0 j_b0, j$B0 j_b02) {
        if (i6 != 0) {
            int i7 = i6 - 1;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 == 3) {
                            return new j$I0((InterfaceC0370j$x0) j_b0, (InterfaceC0370j$x0) j_b02);
                        }
                        throw new IllegalStateException("Unknown shape ".concat(j$Q2.a(i6)));
                    }
                    return new j$K0((InterfaceC0378j$z0) j_b0, (InterfaceC0378j$z0) j_b02);
                }
                return new j$J0((InterfaceC0374j$y0) j_b0, (InterfaceC0374j$y0) j_b02);
            }
            return new j$M0(j_b0, j_b02);
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InterfaceC0354j$t0 T(long j6) {
        return (j6 < 0 || j6 >= 2147483639) ? new j$P0() : new j$O0(j6);
    }

    public static j$C U(final e.j$B j_b) {
        final int c6 = j$P2.c(j_b);
        return new j$A(j_b, c6) { // from class: g.j$x
            @Override // g.AbstractC0285j$c
            final boolean G0() {
                throw new UnsupportedOperationException();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // g.AbstractC0285j$c
            public final InterfaceC0284j$b2 H0(int i6, InterfaceC0284j$b2 interfaceC0284j$b2) {
                throw new UnsupportedOperationException();
            }

            @Override // g.j$A, g.j$C
            public final void d(InterfaceC0261j$i interfaceC0261j$i) {
                e.j$B P0;
                if (isParallel()) {
                    super.d(interfaceC0261j$i);
                    return;
                }
                P0 = j$A.P0(L0());
                P0.k(interfaceC0261j$i);
            }

            @Override // g.j$A, g.j$C
            public final void h(C0260j$h c0260j$h) {
                e.j$B P0;
                if (isParallel()) {
                    super.h(c0260j$h);
                    return;
                }
                P0 = j$A.P0(L0());
                P0.k(c0260j$h);
            }

            @Override // g.j$C
            public final /* bridge */ /* synthetic */ j$C parallel() {
                I0();
                return this;
            }

            @Override // g.j$C
            public final /* bridge */ /* synthetic */ j$C sequential() {
                J0();
                return this;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j$U0 V(int i6) {
        j$B0 j_b0;
        if (i6 != 0) {
            int i7 = i6 - 1;
            if (i7 != 0) {
                if (i7 == 1) {
                    j_b0 = f10263b;
                } else if (i7 == 2) {
                    j_b0 = f10264c;
                } else if (i7 != 3) {
                    throw new IllegalStateException("Unknown shape ".concat(j$Q2.a(i6)));
                } else {
                    j_b0 = f10265d;
                }
                return (j$U0) j_b0;
            }
            return f10262a;
        }
        throw null;
    }

    private static int X(long j6) {
        return (j6 != -1 ? j$P2.f10066z : 0) | j$P2.f10065y;
    }

    public static j$B0 Y(j$B0 j_b0, InterfaceC0274j$v interfaceC0274j$v) {
        if (j_b0.t() > 0) {
            long count = j_b0.count();
            if (count < 2147483639) {
                Object[] objArr = (Object[]) interfaceC0274j$v.r((int) count);
                new C0339j$p1(j_b0, objArr).invoke();
                return new j$D0(objArr);
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return j_b0;
    }

    public static InterfaceC0370j$x0 Z(InterfaceC0370j$x0 interfaceC0370j$x0) {
        if (interfaceC0370j$x0.t() > 0) {
            long count = interfaceC0370j$x0.count();
            if (count < 2147483639) {
                double[] dArr = new double[(int) count];
                new C0335j$o1(interfaceC0370j$x0, dArr).invoke();
                return new j$N0(dArr);
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return interfaceC0370j$x0;
    }

    public static InterfaceC0374j$y0 a0(InterfaceC0374j$y0 interfaceC0374j$y0) {
        if (interfaceC0374j$y0.t() > 0) {
            long count = interfaceC0374j$y0.count();
            if (count < 2147483639) {
                int[] iArr = new int[(int) count];
                new C0335j$o1(interfaceC0374j$y0, iArr).invoke();
                return new j$W0(iArr);
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return interfaceC0374j$y0;
    }

    public static InterfaceC0378j$z0 b0(InterfaceC0378j$z0 interfaceC0378j$z0) {
        if (interfaceC0378j$z0.t() > 0) {
            long count = interfaceC0378j$z0.count();
            if (count < 2147483639) {
                long[] jArr = new long[(int) count];
                new C0335j$o1(interfaceC0378j$z0, jArr).invoke();
                return new C0299j$f1(jArr);
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return interfaceC0378j$z0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InterfaceC0358j$u0 d0(long j6) {
        return (j6 < 0 || j6 >= 2147483639) ? new j$Y0() : new j$X0(j6);
    }

    public static InterfaceC0282j$b0 e0(final e.j$D j_d) {
        final int c6 = j$P2.c(j_d);
        return new j$Z(j_d, c6) { // from class: g.j$W
            @Override // g.AbstractC0285j$c
            final boolean G0() {
                throw new UnsupportedOperationException();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // g.AbstractC0285j$c
            public final InterfaceC0284j$b2 H0(int i6, InterfaceC0284j$b2 interfaceC0284j$b2) {
                throw new UnsupportedOperationException();
            }

            @Override // g.j$Z, g.InterfaceC0282j$b0
            public final void a(C0271j$s c0271j$s) {
                e.j$D P0;
                if (isParallel()) {
                    super.a(c0271j$s);
                    return;
                }
                P0 = j$Z.P0(L0());
                P0.l(c0271j$s);
            }

            @Override // g.j$Z, g.InterfaceC0282j$b0
            public final void i(InterfaceC0272j$t interfaceC0272j$t) {
                e.j$D P0;
                if (isParallel()) {
                    super.i(interfaceC0272j$t);
                    return;
                }
                P0 = j$Z.P0(L0());
                P0.l(interfaceC0272j$t);
            }

            @Override // g.InterfaceC0282j$b0
            public final /* bridge */ /* synthetic */ InterfaceC0282j$b0 parallel() {
                I0();
                return this;
            }

            @Override // g.InterfaceC0282j$b0
            public final /* bridge */ /* synthetic */ InterfaceC0282j$b0 sequential() {
                J0();
                return this;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InterfaceC0362j$v0 f0(long j6) {
        return (j6 < 0 || j6 >= 2147483639) ? new C0307j$h1() : new C0303j$g1(j6);
    }

    public static InterfaceC0314j$j0 g0(final e.j$F j_f) {
        final int c6 = j$P2.c(j_f);
        return new AbstractC0306j$h0(j_f, c6) { // from class: g.j$e0
            @Override // g.AbstractC0285j$c
            final boolean G0() {
                throw new UnsupportedOperationException();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // g.AbstractC0285j$c
            public final InterfaceC0284j$b2 H0(int i6, InterfaceC0284j$b2 interfaceC0284j$b2) {
                throw new UnsupportedOperationException();
            }

            @Override // g.AbstractC0306j$h0, g.InterfaceC0314j$j0
            public final void c(f.j$E j_e) {
                e.j$F P0;
                if (isParallel()) {
                    super.c(j_e);
                    return;
                }
                P0 = AbstractC0306j$h0.P0(L0());
                P0.c(j_e);
            }

            @Override // g.AbstractC0306j$h0, g.InterfaceC0314j$j0
            public final void f(f.j$D j_d) {
                e.j$F P0;
                if (isParallel()) {
                    super.f(j_d);
                    return;
                }
                P0 = AbstractC0306j$h0.P0(L0());
                P0.c(j_d);
            }

            @Override // g.InterfaceC0314j$j0
            public final /* bridge */ /* synthetic */ InterfaceC0314j$j0 parallel() {
                I0();
                return this;
            }

            @Override // g.InterfaceC0314j$j0
            public final /* bridge */ /* synthetic */ InterfaceC0314j$j0 sequential() {
                J0();
                return this;
            }
        };
    }

    public static j$C h0(j$A j_a, long j6, long j7) {
        if (j6 >= 0) {
            return new C0316j$j2(j_a, X(j7), j6, j7);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j6);
    }

    public static C0342j$q0 i0(C0264j$l c0264j$l, EnumC0338j$p0 enumC0338j$p0) {
        c0264j$l.getClass();
        return new C0342j$q0(4, enumC0338j$p0, new C0321j$l(3, enumC0338j$p0, c0264j$l));
    }

    public static void j() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static InterfaceC0282j$b0 j0(j$Z j_z, long j6, long j7) {
        if (j6 >= 0) {
            return new C0300j$f2(j_z, X(j7), j6, j7);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j6);
    }

    public static C0342j$q0 k0(C0275j$w c0275j$w, EnumC0338j$p0 enumC0338j$p0) {
        c0275j$w.getClass();
        return new C0342j$q0(2, enumC0338j$p0, new C0321j$l(1, enumC0338j$p0, c0275j$w));
    }

    public static InterfaceC0314j$j0 l0(AbstractC0306j$h0 abstractC0306j$h0, long j6, long j7) {
        if (j6 >= 0) {
            return new C0308j$h2(abstractC0306j$h0, X(j7), j6, j7);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j6);
    }

    public static void m(j$Y1 j_y1, Double d6) {
        if (j$A3.f9953a) {
            j$A3.a(j_y1.getClass(), "{0} calling Sink.OfDouble.accept(Double)");
            throw null;
        } else {
            j_y1.d(d6.doubleValue());
        }
    }

    public static C0342j$q0 m0(f.j$H j_h, EnumC0338j$p0 enumC0338j$p0) {
        j_h.getClass();
        return new C0342j$q0(3, enumC0338j$p0, new C0321j$l(4, enumC0338j$p0, j_h));
    }

    public static void o(j$Z1 j_z1, Integer num) {
        if (j$A3.f9953a) {
            j$A3.a(j_z1.getClass(), "{0} calling Sink.OfInt.accept(Integer)");
            throw null;
        } else {
            j_z1.e(num.intValue());
        }
    }

    public static C0342j$q0 o0(f.j$S j_s, EnumC0338j$p0 enumC0338j$p0) {
        j_s.getClass();
        return new C0342j$q0(1, enumC0338j$p0, new C0321j$l(2, enumC0338j$p0, j_s));
    }

    public static j$M2 p0(j$T1 j_t1, long j6, long j7) {
        if (j6 >= 0) {
            return new C0292j$d2(j_t1, X(j7), j6, j7);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j6);
    }

    public static void q(InterfaceC0279j$a2 interfaceC0279j$a2, Long l6) {
        if (j$A3.f9953a) {
            j$A3.a(interfaceC0279j$a2.getClass(), "{0} calling Sink.OfLong.accept(Long)");
            throw null;
        } else {
            interfaceC0279j$a2.f(l6.longValue());
        }
    }

    public static j$M2 r0(final e.j$J j_j, final boolean z5) {
        j_j.getClass();
        final int c6 = j$P2.c(j_j);
        return new j$T1(j_j, c6, z5) { // from class: g.j$Q1
            @Override // g.AbstractC0285j$c
            final boolean G0() {
                throw new UnsupportedOperationException();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // g.AbstractC0285j$c
            public final InterfaceC0284j$b2 H0(int i6, InterfaceC0284j$b2 interfaceC0284j$b2) {
                throw new UnsupportedOperationException();
            }

            @Override // g.j$T1, g.j$M2
            public final void b(InterfaceC0257j$e interfaceC0257j$e) {
                if (isParallel()) {
                    super.b(interfaceC0257j$e);
                } else {
                    L0().b(interfaceC0257j$e);
                }
            }

            @Override // g.j$T1, g.j$M2
            public final void e(C0256j$d c0256j$d) {
                if (isParallel()) {
                    super.e(c0256j$d);
                } else {
                    L0().b(c0256j$d);
                }
            }
        };
    }

    public static void s() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void t() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static Object[] u(j$A0 j_a0, InterfaceC0274j$v interfaceC0274j$v) {
        if (j$A3.f9953a) {
            j$A3.a(j_a0.getClass(), "{0} calling Node.OfPrimitive.asArray");
            throw null;
        } else if (j_a0.count() < 2147483639) {
            Object[] objArr = (Object[]) interfaceC0274j$v.r((int) j_a0.count());
            j_a0.p(objArr, 0);
            return objArr;
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static void v(InterfaceC0370j$x0 interfaceC0370j$x0, Double[] dArr, int i6) {
        if (j$A3.f9953a) {
            j$A3.a(interfaceC0370j$x0.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
            throw null;
        }
        double[] dArr2 = (double[]) interfaceC0370j$x0.k();
        for (int i7 = 0; i7 < dArr2.length; i7++) {
            dArr[i6 + i7] = Double.valueOf(dArr2[i7]);
        }
    }

    public static void w(InterfaceC0374j$y0 interfaceC0374j$y0, Integer[] numArr, int i6) {
        if (j$A3.f9953a) {
            j$A3.a(interfaceC0374j$y0.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
            throw null;
        }
        int[] iArr = (int[]) interfaceC0374j$y0.k();
        for (int i7 = 0; i7 < iArr.length; i7++) {
            numArr[i6 + i7] = Integer.valueOf(iArr[i7]);
        }
    }

    public static void x(InterfaceC0378j$z0 interfaceC0378j$z0, Long[] lArr, int i6) {
        if (j$A3.f9953a) {
            j$A3.a(interfaceC0378j$z0.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
            throw null;
        }
        long[] jArr = (long[]) interfaceC0378j$z0.k();
        for (int i7 = 0; i7 < jArr.length; i7++) {
            lArr[i6 + i7] = Long.valueOf(jArr[i7]);
        }
    }

    public static void y(InterfaceC0370j$x0 interfaceC0370j$x0, InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof InterfaceC0261j$i) {
            interfaceC0370j$x0.l((InterfaceC0261j$i) interfaceC0257j$e);
        } else if (j$A3.f9953a) {
            j$A3.a(interfaceC0370j$x0.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
            throw null;
        } else {
            ((e.j$B) interfaceC0370j$x0.spliterator()).b(interfaceC0257j$e);
        }
    }

    public static void z(InterfaceC0374j$y0 interfaceC0374j$y0, InterfaceC0257j$e interfaceC0257j$e) {
        if (interfaceC0257j$e instanceof InterfaceC0272j$t) {
            interfaceC0374j$y0.l((InterfaceC0272j$t) interfaceC0257j$e);
        } else if (j$A3.f9953a) {
            j$A3.a(interfaceC0374j$y0.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
            throw null;
        } else {
            ((e.j$D) interfaceC0374j$y0.spliterator()).b(interfaceC0257j$e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void R(e.j$J j_j, InterfaceC0284j$b2 interfaceC0284j$b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void S(e.j$J j_j, InterfaceC0284j$b2 interfaceC0284j$b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long W(e.j$J j_j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int c0();

    @Override // g.j$x3
    public Object g(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j) {
        j$K1 q02 = q0();
        abstractC0350j$s0.s0(j_j, q02);
        return q02.get();
    }

    @Override // g.j$x3
    public /* synthetic */ int k() {
        return 0;
    }

    @Override // g.j$x3
    public Object l(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j) {
        return ((j$K1) new j$M1(this, abstractC0350j$s0, j_j).invoke()).get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract InterfaceC0366j$w0 n0(long j6, InterfaceC0274j$v interfaceC0274j$v);

    public abstract j$K1 q0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract InterfaceC0284j$b2 s0(e.j$J j_j, InterfaceC0284j$b2 interfaceC0284j$b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract InterfaceC0284j$b2 t0(InterfaceC0284j$b2 interfaceC0284j$b2);
}
