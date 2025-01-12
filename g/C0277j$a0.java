package g;

import e.AbstractC0227j$a;
import e.AbstractC0235j$i;
import e.C0234j$h;
import e.C0240j$n;
import e.C0241j$o;
import e.C0247j$u;
import f.C0269j$q;
import f.C0271j$s;
import f.C0273j$u;
import f.C0275j$w;
import f.InterfaceC0274j$v;
import j$.util.function.BiConsumer;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
/* renamed from: g.j$a0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0277j$a0 implements IntStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0282j$b0 f10113a;

    private /* synthetic */ C0277j$a0(InterfaceC0282j$b0 interfaceC0282j$b0) {
        this.f10113a = interfaceC0282j$b0;
    }

    public static /* synthetic */ C0277j$a0 g(InterfaceC0282j$b0 interfaceC0282j$b0) {
        if (interfaceC0282j$b0 == null) {
            return null;
        }
        return new C0277j$a0(interfaceC0282j$b0);
    }

    @Override // java.util.stream.IntStream
    public final boolean allMatch(IntPredicate intPredicate) {
        InterfaceC0282j$b0 interfaceC0282j$b0 = this.f10113a;
        C0275j$w a6 = C0275j$w.a(intPredicate);
        j$Z j_z = (j$Z) interfaceC0282j$b0;
        j_z.getClass();
        return ((Boolean) j_z.v0(AbstractC0350j$s0.k0(a6, EnumC0338j$p0.ALL))).booleanValue();
    }

    @Override // java.util.stream.IntStream
    public final boolean anyMatch(IntPredicate intPredicate) {
        InterfaceC0282j$b0 interfaceC0282j$b0 = this.f10113a;
        C0275j$w a6 = C0275j$w.a(intPredicate);
        j$Z j_z = (j$Z) interfaceC0282j$b0;
        j_z.getClass();
        return ((Boolean) j_z.v0(AbstractC0350j$s0.k0(a6, EnumC0338j$p0.ANY))).booleanValue();
    }

    @Override // java.util.stream.IntStream
    public final DoubleStream asDoubleStream() {
        j$Z j_z = (j$Z) this.f10113a;
        j_z.getClass();
        return j$B.g(new C0365j$w(j_z, j$P2.f10061u | j$P2.f10059s, 1));
    }

    @Override // java.util.stream.IntStream
    public final LongStream asLongStream() {
        j$Z j_z = (j$Z) this.f10113a;
        j_z.getClass();
        return C0310j$i0.g(new j$U(j_z, j$P2.f10061u | j$P2.f10059s, 0));
    }

    @Override // java.util.stream.IntStream
    public final OptionalDouble average() {
        j$Z j_z = (j$Z) this.f10113a;
        j_z.getClass();
        long[] jArr = (long[]) j_z.Q0(new C0281j$b(18), new C0281j$b(19), new C0281j$b(20));
        long j6 = jArr[0];
        return AbstractC0227j$a.u(j6 > 0 ? C0240j$n.d(jArr[1] / j6) : C0240j$n.a());
    }

    @Override // java.util.stream.IntStream
    public final Stream boxed() {
        j$Z j_z = (j$Z) this.f10113a;
        j_z.getClass();
        return j$L2.g(new C0353j$t(j_z, j$P2.f10061u | j$P2.f10059s, new j$S(2), 1));
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        ((AbstractC0285j$c) this.f10113a).close();
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
        return ((j$Z) this.f10113a).Q0(f.j$U.a(supplier), f.j$O.a(objIntConsumer), BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    @Override // java.util.stream.IntStream
    public final long count() {
        j$Z j_z = (j$Z) this.f10113a;
        j_z.getClass();
        return new C0361j$v(j_z, j$P2.f10061u | j$P2.f10059s, new C0281j$b(16), 1).sum();
    }

    @Override // java.util.stream.IntStream
    public final IntStream distinct() {
        j$Z j_z = (j$Z) this.f10113a;
        j_z.getClass();
        j$S j_s = new j$S(2);
        int i6 = j$P2.f10061u;
        int i7 = j$P2.f10059s;
        return g(new C0357j$u((j$T1) new C0353j$t(j_z, i6 | i7, j_s, 1).O0(), i6 | i7, new C0281j$b(15), 6));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        InterfaceC0282j$b0 interfaceC0282j$b0 = this.f10113a;
        if (obj instanceof C0277j$a0) {
            obj = ((C0277j$a0) obj).f10113a;
        }
        return interfaceC0282j$b0.equals(obj);
    }

    @Override // java.util.stream.IntStream
    public final IntStream filter(IntPredicate intPredicate) {
        InterfaceC0282j$b0 interfaceC0282j$b0 = this.f10113a;
        C0275j$w a6 = C0275j$w.a(intPredicate);
        j$Z j_z = (j$Z) interfaceC0282j$b0;
        j_z.getClass();
        a6.getClass();
        return g(new C0357j$u(j_z, j$P2.f10065y, a6, 4));
    }

    @Override // java.util.stream.IntStream
    public final OptionalInt findAny() {
        return AbstractC0227j$a.v((C0241j$o) ((j$Z) this.f10113a).v0(new j$D(false, 2, C0241j$o.a(), new j$F0(28), new C0281j$b(13))));
    }

    @Override // java.util.stream.IntStream
    public final OptionalInt findFirst() {
        return AbstractC0227j$a.v((C0241j$o) ((j$Z) this.f10113a).v0(new j$D(true, 2, C0241j$o.a(), new j$F0(28), new C0281j$b(13))));
    }

    @Override // java.util.stream.IntStream
    public final IntStream flatMap(IntFunction intFunction) {
        InterfaceC0282j$b0 interfaceC0282j$b0 = this.f10113a;
        C0273j$u a6 = C0273j$u.a(intFunction);
        j$Z j_z = (j$Z) interfaceC0282j$b0;
        j_z.getClass();
        return g(new C0357j$u(j_z, j$P2.f10061u | j$P2.f10059s | j$P2.f10065y, a6, 3));
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ void forEach(IntConsumer intConsumer) {
        this.f10113a.i(C0271j$s.b(intConsumer));
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
        this.f10113a.a(C0271j$s.b(intConsumer));
    }

    public final /* synthetic */ int hashCode() {
        return this.f10113a.hashCode();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return ((AbstractC0285j$c) this.f10113a).isParallel();
    }

    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    public final Iterator<Integer> iterator() {
        return e.j$X.g(((j$Z) this.f10113a).spliterator());
    }

    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    /* renamed from: iterator  reason: avoid collision after fix types in other method */
    public final Iterator<Integer> iterator2() {
        return C0247j$u.a(e.j$X.g(((j$Z) this.f10113a).spliterator()));
    }

    @Override // java.util.stream.IntStream
    public final IntStream limit(long j6) {
        j$Z j_z = (j$Z) this.f10113a;
        j_z.getClass();
        if (j6 >= 0) {
            return g(AbstractC0350j$s0.j0(j_z, 0L, j6));
        }
        throw new IllegalArgumentException(Long.toString(j6));
    }

    @Override // java.util.stream.IntStream
    public final IntStream map(IntUnaryOperator intUnaryOperator) {
        InterfaceC0282j$b0 interfaceC0282j$b0 = this.f10113a;
        f.j$A a6 = f.j$A.a(intUnaryOperator);
        j$Z j_z = (j$Z) interfaceC0282j$b0;
        j_z.getClass();
        a6.getClass();
        return g(new C0357j$u(j_z, j$P2.f10061u | j$P2.f10059s, a6, 2));
    }

    @Override // java.util.stream.IntStream
    public final DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction) {
        InterfaceC0282j$b0 interfaceC0282j$b0 = this.f10113a;
        f.j$x a6 = f.j$x.a(intToDoubleFunction);
        j$Z j_z = (j$Z) interfaceC0282j$b0;
        j_z.getClass();
        a6.getClass();
        return j$B.g(new C0349j$s(j_z, j$P2.f10061u | j$P2.f10059s, a6, 4));
    }

    @Override // java.util.stream.IntStream
    public final LongStream mapToLong(IntToLongFunction intToLongFunction) {
        InterfaceC0282j$b0 interfaceC0282j$b0 = this.f10113a;
        f.j$y a6 = f.j$y.a(intToLongFunction);
        j$Z j_z = (j$Z) interfaceC0282j$b0;
        j_z.getClass();
        a6.getClass();
        return C0310j$i0.g(new C0361j$v(j_z, j$P2.f10061u | j$P2.f10059s, a6, 1));
    }

    @Override // java.util.stream.IntStream
    public final Stream mapToObj(IntFunction intFunction) {
        InterfaceC0282j$b0 interfaceC0282j$b0 = this.f10113a;
        C0273j$u a6 = C0273j$u.a(intFunction);
        j$Z j_z = (j$Z) interfaceC0282j$b0;
        j_z.getClass();
        a6.getClass();
        return j$L2.g(new C0353j$t(j_z, j$P2.f10061u | j$P2.f10059s, a6, 1));
    }

    @Override // java.util.stream.IntStream
    public final OptionalInt max() {
        j$Z j_z = (j$Z) this.f10113a;
        j_z.getClass();
        return AbstractC0227j$a.v(j_z.R0(new j$S(3)));
    }

    @Override // java.util.stream.IntStream
    public final OptionalInt min() {
        j$Z j_z = (j$Z) this.f10113a;
        j_z.getClass();
        return AbstractC0227j$a.v(j_z.R0(new j$F0(29)));
    }

    @Override // java.util.stream.IntStream
    public final boolean noneMatch(IntPredicate intPredicate) {
        InterfaceC0282j$b0 interfaceC0282j$b0 = this.f10113a;
        C0275j$w a6 = C0275j$w.a(intPredicate);
        j$Z j_z = (j$Z) interfaceC0282j$b0;
        j_z.getClass();
        return ((Boolean) j_z.v0(AbstractC0350j$s0.k0(a6, EnumC0338j$p0.NONE))).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
    @Override // java.util.stream.BaseStream
    public final /* synthetic */ IntStream onClose(Runnable runnable) {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f10113a;
        abstractC0285j$c.D0(runnable);
        return C0301j$g.g(abstractC0285j$c);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    public final /* synthetic */ IntStream parallel() {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f10113a;
        abstractC0285j$c.I0();
        return C0301j$g.g(abstractC0285j$c);
    }

    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    /* renamed from: parallel  reason: avoid collision after fix types in other method */
    public final /* synthetic */ IntStream parallel2() {
        return g(this.f10113a.parallel());
    }

    @Override // java.util.stream.IntStream
    public final IntStream peek(IntConsumer intConsumer) {
        InterfaceC0282j$b0 interfaceC0282j$b0 = this.f10113a;
        C0271j$s b6 = C0271j$s.b(intConsumer);
        j$Z j_z = (j$Z) interfaceC0282j$b0;
        j_z.getClass();
        b6.getClass();
        return g(new C0357j$u(j_z, 0, b6, 1));
    }

    @Override // java.util.stream.IntStream
    public final int reduce(int i6, IntBinaryOperator intBinaryOperator) {
        InterfaceC0282j$b0 interfaceC0282j$b0 = this.f10113a;
        C0269j$q a6 = C0269j$q.a(intBinaryOperator);
        j$Z j_z = (j$Z) interfaceC0282j$b0;
        j_z.getClass();
        a6.getClass();
        return ((Integer) j_z.v0(new j$D1(a6, i6))).intValue();
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ OptionalInt reduce(IntBinaryOperator intBinaryOperator) {
        return AbstractC0227j$a.v(((j$Z) this.f10113a).R0(C0269j$q.a(intBinaryOperator)));
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    public final /* synthetic */ IntStream sequential() {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f10113a;
        abstractC0285j$c.J0();
        return C0301j$g.g(abstractC0285j$c);
    }

    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    /* renamed from: sequential  reason: avoid collision after fix types in other method */
    public final /* synthetic */ IntStream sequential2() {
        return g(this.f10113a.sequential());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [g.j$b0] */
    @Override // java.util.stream.IntStream
    public final IntStream skip(long j6) {
        j$Z j_z = (j$Z) this.f10113a;
        j_z.getClass();
        int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        j$Z j_z2 = j_z;
        if (i6 >= 0) {
            if (i6 != 0) {
                j_z2 = AbstractC0350j$s0.j0(j_z, j6, -1L);
            }
            return g(j_z2);
        }
        throw new IllegalArgumentException(Long.toString(j6));
    }

    @Override // java.util.stream.IntStream
    public final IntStream sorted() {
        final j$Z j_z = (j$Z) this.f10113a;
        j_z.getClass();
        return g(new j$X(j_z) { // from class: g.j$t2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i6 = j$P2.f10062v | j$P2.f10060t;
            }

            @Override // g.AbstractC0285j$c
            public final j$B0 E0(e.j$J j_j, InterfaceC0274j$v interfaceC0274j$v, AbstractC0285j$c abstractC0285j$c) {
                if (j$P2.f10047g.d(abstractC0285j$c.c0())) {
                    return abstractC0285j$c.u0(j_j, false, interfaceC0274j$v);
                }
                int[] iArr = (int[]) ((InterfaceC0374j$y0) abstractC0285j$c.u0(j_j, true, interfaceC0274j$v)).k();
                Arrays.sort(iArr);
                return new j$W0(iArr);
            }

            @Override // g.AbstractC0285j$c
            public final InterfaceC0284j$b2 H0(int i6, final InterfaceC0284j$b2 interfaceC0284j$b2) {
                interfaceC0284j$b2.getClass();
                return j$P2.f10047g.d(i6) ? interfaceC0284j$b2 : j$P2.f10049i.d(i6) ? new AbstractC0328j$m2(interfaceC0284j$b2) { // from class: g.j$y2

                    /* renamed from: c  reason: collision with root package name */
                    private int[] f10309c;

                    /* renamed from: d  reason: collision with root package name */
                    private int f10310d;

                    @Override // g.InterfaceC0284j$b2
                    public final void e(int i7) {
                        int[] iArr = this.f10309c;
                        int i8 = this.f10310d;
                        this.f10310d = i8 + 1;
                        iArr[i8] = i7;
                    }

                    @Override // g.j$V1, g.InterfaceC0284j$b2
                    public final void h() {
                        int i7 = 0;
                        Arrays.sort(this.f10309c, 0, this.f10310d);
                        InterfaceC0284j$b2 interfaceC0284j$b22 = this.f10096a;
                        interfaceC0284j$b22.i(this.f10310d);
                        if (this.f10215b) {
                            while (i7 < this.f10310d && !interfaceC0284j$b22.o()) {
                                interfaceC0284j$b22.e(this.f10309c[i7]);
                                i7++;
                            }
                        } else {
                            while (i7 < this.f10310d) {
                                interfaceC0284j$b22.e(this.f10309c[i7]);
                                i7++;
                            }
                        }
                        interfaceC0284j$b22.h();
                        this.f10309c = null;
                    }

                    @Override // g.InterfaceC0284j$b2
                    public final void i(long j6) {
                        if (j6 >= 2147483639) {
                            throw new IllegalArgumentException("Stream size exceeds max array size");
                        }
                        this.f10309c = new int[(int) j6];
                    }
                } : new AbstractC0328j$m2(interfaceC0284j$b2) { // from class: g.j$q2

                    /* renamed from: c  reason: collision with root package name */
                    private j$F2 f10250c;

                    @Override // g.InterfaceC0284j$b2
                    public final void e(int i7) {
                        this.f10250c.e(i7);
                    }

                    @Override // g.j$V1, g.InterfaceC0284j$b2
                    public final void h() {
                        int[] iArr = (int[]) this.f10250c.k();
                        Arrays.sort(iArr);
                        InterfaceC0284j$b2 interfaceC0284j$b22 = this.f10096a;
                        interfaceC0284j$b22.i(iArr.length);
                        int i7 = 0;
                        if (this.f10215b) {
                            int length = iArr.length;
                            while (i7 < length) {
                                int i8 = iArr[i7];
                                if (interfaceC0284j$b22.o()) {
                                    break;
                                }
                                interfaceC0284j$b22.e(i8);
                                i7++;
                            }
                        } else {
                            int length2 = iArr.length;
                            while (i7 < length2) {
                                interfaceC0284j$b22.e(iArr[i7]);
                                i7++;
                            }
                        }
                        interfaceC0284j$b22.h();
                    }

                    @Override // g.InterfaceC0284j$b2
                    public final void i(long j6) {
                        if (j6 >= 2147483639) {
                            throw new IllegalArgumentException("Stream size exceeds max array size");
                        }
                        this.f10250c = j6 > 0 ? new j$F2((int) j6) : new j$F2();
                    }
                };
            }
        });
    }

    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    public final /* synthetic */ Spliterator<Integer> spliterator() {
        return e.j$C.a(((j$Z) this.f10113a).spliterator());
    }

    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    /* renamed from: spliterator  reason: avoid collision after fix types in other method */
    public final /* synthetic */ Spliterator<Integer> spliterator2() {
        return e.j$I.a(((j$Z) this.f10113a).spliterator());
    }

    @Override // java.util.stream.IntStream
    public final int sum() {
        j$Z j_z = (j$Z) this.f10113a;
        j_z.getClass();
        return ((Integer) j_z.v0(new j$D1(new C0281j$b(17), 0))).intValue();
    }

    @Override // java.util.stream.IntStream
    public final IntSummaryStatistics summaryStatistics() {
        j$Z j_z = (j$Z) this.f10113a;
        j_z.getClass();
        return AbstractC0235j$i.a((C0234j$h) j_z.Q0(new j$F0(15), new j$S(0), new j$S(1)));
    }

    @Override // java.util.stream.IntStream
    public final int[] toArray() {
        j$Z j_z = (j$Z) this.f10113a;
        j_z.getClass();
        return (int[]) AbstractC0350j$s0.a0((InterfaceC0374j$y0) j_z.w0(new C0281j$b(21))).k();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
    @Override // java.util.stream.BaseStream
    public final /* synthetic */ IntStream unordered() {
        return C0301j$g.g(((j$Z) this.f10113a).unordered());
    }
}
