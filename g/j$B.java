package g;

import e.AbstractC0227j$a;
import e.AbstractC0233j$g;
import e.C0232j$f;
import e.C0240j$n;
import e.C0244j$r;
import f.C0258j$f;
import f.C0260j$h;
import f.C0262j$j;
import f.C0264j$l;
import f.C0265j$m;
import f.C0266j$n;
import f.C0268j$p;
import f.InterfaceC0274j$v;
import j$.util.function.BiConsumer;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.OptionalDouble;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$B implements DoubleStream {

    /* renamed from: a */
    public final /* synthetic */ j$C f9954a;

    private /* synthetic */ j$B(j$C j_c) {
        this.f9954a = j_c;
    }

    public static /* synthetic */ j$B g(j$C j_c) {
        if (j_c == null) {
            return null;
        }
        return new j$B(j_c);
    }

    @Override // java.util.stream.DoubleStream
    public final boolean allMatch(DoublePredicate doublePredicate) {
        j$C j_c = this.f9954a;
        C0264j$l a6 = C0264j$l.a(doublePredicate);
        j$A j_a = (j$A) j_c;
        j_a.getClass();
        return ((Boolean) j_a.v0(AbstractC0350j$s0.i0(a6, EnumC0338j$p0.ALL))).booleanValue();
    }

    @Override // java.util.stream.DoubleStream
    public final boolean anyMatch(DoublePredicate doublePredicate) {
        j$C j_c = this.f9954a;
        C0264j$l a6 = C0264j$l.a(doublePredicate);
        j$A j_a = (j$A) j_c;
        j_a.getClass();
        return ((Boolean) j_a.v0(AbstractC0350j$s0.i0(a6, EnumC0338j$p0.ANY))).booleanValue();
    }

    @Override // java.util.stream.DoubleStream
    public final OptionalDouble average() {
        C0240j$n a6;
        j$A j_a = (j$A) this.f9954a;
        j_a.getClass();
        double[] dArr = (double[]) j_a.Q0(new C0281j$b(5), new C0281j$b(6), new C0281j$b(7));
        if (dArr[2] > 0.0d) {
            int i6 = AbstractC0317j$k.f10187a;
            double d6 = dArr[0] + dArr[1];
            double d7 = dArr[dArr.length - 1];
            if (Double.isNaN(d6) && Double.isInfinite(d7)) {
                d6 = d7;
            }
            a6 = C0240j$n.d(d6 / dArr[2]);
        } else {
            a6 = C0240j$n.a();
        }
        return AbstractC0227j$a.u(a6);
    }

    @Override // java.util.stream.DoubleStream
    public final Stream boxed() {
        j$A j_a = (j$A) this.f9954a;
        j_a.getClass();
        return j$L2.g(new C0353j$t(j_a, j$P2.f10061u | j$P2.f10059s, new j$F0(22), 0));
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        ((AbstractC0285j$c) this.f9954a).close();
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return ((j$A) this.f9954a).Q0(f.j$U.a(supplier), f.j$M.a(objDoubleConsumer), BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    @Override // java.util.stream.DoubleStream
    public final long count() {
        j$A j_a = (j$A) this.f9954a;
        j_a.getClass();
        return new C0361j$v(j_a, j$P2.f10061u | j$P2.f10059s, new C0281j$b(4), 0).sum();
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream distinct() {
        j$A j_a = (j$A) this.f9954a;
        j_a.getClass();
        j$F0 j_f0 = new j$F0(22);
        int i6 = j$P2.f10061u;
        int i7 = j$P2.f10059s;
        return g(new C0349j$s((j$T1) new C0353j$t(j_a, i6 | i7, j_f0, 0).O0(), i6 | i7, new C0281j$b(8), 6));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        j$C j_c = this.f9954a;
        if (obj instanceof j$B) {
            obj = ((j$B) obj).f9954a;
        }
        return j_c.equals(obj);
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream filter(DoublePredicate doublePredicate) {
        j$C j_c = this.f9954a;
        C0264j$l a6 = C0264j$l.a(doublePredicate);
        j$A j_a = (j$A) j_c;
        j_a.getClass();
        a6.getClass();
        return g(new C0349j$s(j_a, j$P2.f10065y, a6, 2));
    }

    @Override // java.util.stream.DoubleStream
    public final OptionalDouble findAny() {
        return AbstractC0227j$a.u((C0240j$n) ((j$A) this.f9954a).v0(new j$D(false, 4, C0240j$n.a(), new j$F0(25), new C0281j$b(10))));
    }

    @Override // java.util.stream.DoubleStream
    public final OptionalDouble findFirst() {
        return AbstractC0227j$a.u((C0240j$n) ((j$A) this.f9954a).v0(new j$D(true, 4, C0240j$n.a(), new j$F0(25), new C0281j$b(10))));
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream flatMap(DoubleFunction doubleFunction) {
        j$C j_c = this.f9954a;
        C0262j$j a6 = C0262j$j.a(doubleFunction);
        j$A j_a = (j$A) j_c;
        j_a.getClass();
        return g(new C0349j$s(j_a, j$P2.f10061u | j$P2.f10059s | j$P2.f10065y, a6, 1));
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.f9954a.d(C0260j$h.b(doubleConsumer));
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.f9954a.h(C0260j$h.b(doubleConsumer));
    }

    public final /* synthetic */ int hashCode() {
        return this.f9954a.hashCode();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return ((AbstractC0285j$c) this.f9954a).isParallel();
    }

    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    public final Iterator<Double> iterator() {
        return e.j$X.f(((j$A) this.f9954a).spliterator());
    }

    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    /* renamed from: iterator */
    public final Iterator<Double> iterator2() {
        return C0244j$r.a(e.j$X.f(((j$A) this.f9954a).spliterator()));
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream limit(long j6) {
        j$A j_a = (j$A) this.f9954a;
        j_a.getClass();
        if (j6 >= 0) {
            return g(AbstractC0350j$s0.h0(j_a, 0L, j6));
        }
        throw new IllegalArgumentException(Long.toString(j6));
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream map(DoubleUnaryOperator doubleUnaryOperator) {
        j$C j_c = this.f9954a;
        C0268j$p a6 = C0268j$p.a(doubleUnaryOperator);
        j$A j_a = (j$A) j_c;
        j_a.getClass();
        a6.getClass();
        return g(new C0349j$s(j_a, j$P2.f10061u | j$P2.f10059s, a6, 0));
    }

    @Override // java.util.stream.DoubleStream
    public final IntStream mapToInt(DoubleToIntFunction doubleToIntFunction) {
        j$C j_c = this.f9954a;
        C0265j$m a6 = C0265j$m.a(doubleToIntFunction);
        j$A j_a = (j$A) j_c;
        j_a.getClass();
        a6.getClass();
        return C0277j$a0.g(new C0357j$u(j_a, j$P2.f10061u | j$P2.f10059s, a6, 0));
    }

    @Override // java.util.stream.DoubleStream
    public final LongStream mapToLong(DoubleToLongFunction doubleToLongFunction) {
        j$C j_c = this.f9954a;
        C0266j$n a6 = C0266j$n.a(doubleToLongFunction);
        j$A j_a = (j$A) j_c;
        j_a.getClass();
        a6.getClass();
        return C0310j$i0.g(new C0361j$v(j_a, j$P2.f10061u | j$P2.f10059s, a6, 0));
    }

    @Override // java.util.stream.DoubleStream
    public final Stream mapToObj(DoubleFunction doubleFunction) {
        j$C j_c = this.f9954a;
        C0262j$j a6 = C0262j$j.a(doubleFunction);
        j$A j_a = (j$A) j_c;
        j_a.getClass();
        a6.getClass();
        return j$L2.g(new C0353j$t(j_a, j$P2.f10061u | j$P2.f10059s, a6, 0));
    }

    @Override // java.util.stream.DoubleStream
    public final OptionalDouble max() {
        j$A j_a = (j$A) this.f9954a;
        j_a.getClass();
        return AbstractC0227j$a.u(j_a.R0(new j$F0(21)));
    }

    @Override // java.util.stream.DoubleStream
    public final OptionalDouble min() {
        j$A j_a = (j$A) this.f9954a;
        j_a.getClass();
        return AbstractC0227j$a.u(j_a.R0(new j$F0(20)));
    }

    @Override // java.util.stream.DoubleStream
    public final boolean noneMatch(DoublePredicate doublePredicate) {
        j$C j_c = this.f9954a;
        C0264j$l a6 = C0264j$l.a(doublePredicate);
        j$A j_a = (j$A) j_c;
        j_a.getClass();
        return ((Boolean) j_a.v0(AbstractC0350j$s0.i0(a6, EnumC0338j$p0.NONE))).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.stream.BaseStream, java.util.stream.DoubleStream] */
    @Override // java.util.stream.BaseStream
    public final /* synthetic */ DoubleStream onClose(Runnable runnable) {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f9954a;
        abstractC0285j$c.D0(runnable);
        return C0301j$g.g(abstractC0285j$c);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.BaseStream, java.util.stream.DoubleStream] */
    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    public final /* synthetic */ DoubleStream parallel() {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f9954a;
        abstractC0285j$c.I0();
        return C0301j$g.g(abstractC0285j$c);
    }

    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    /* renamed from: parallel */
    public final /* synthetic */ DoubleStream parallel2() {
        return g(this.f9954a.parallel());
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream peek(DoubleConsumer doubleConsumer) {
        j$C j_c = this.f9954a;
        C0260j$h b6 = C0260j$h.b(doubleConsumer);
        j$A j_a = (j$A) j_c;
        j_a.getClass();
        b6.getClass();
        return g(new C0349j$s(j_a, 0, b6, 3));
    }

    @Override // java.util.stream.DoubleStream
    public final double reduce(final double d6, DoubleBinaryOperator doubleBinaryOperator) {
        j$C j_c = this.f9954a;
        final C0258j$f a6 = C0258j$f.a(doubleBinaryOperator);
        j$A j_a = (j$A) j_c;
        j_a.getClass();
        a6.getClass();
        return ((Double) j_a.v0(new AbstractC0350j$s0() { // from class: g.j$t1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // g.AbstractC0350j$s0
            public final j$K1 q0() {
                return new C0359j$u1(d6, a6);
            }
        })).doubleValue();
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return AbstractC0227j$a.u(((j$A) this.f9954a).R0(C0258j$f.a(doubleBinaryOperator)));
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.BaseStream, java.util.stream.DoubleStream] */
    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    public final /* synthetic */ DoubleStream sequential() {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f9954a;
        abstractC0285j$c.J0();
        return C0301j$g.g(abstractC0285j$c);
    }

    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    /* renamed from: sequential */
    public final /* synthetic */ DoubleStream sequential2() {
        return g(this.f9954a.sequential());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [g.j$C] */
    @Override // java.util.stream.DoubleStream
    public final DoubleStream skip(long j6) {
        j$A j_a = (j$A) this.f9954a;
        j_a.getClass();
        int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        j$A j_a2 = j_a;
        if (i6 >= 0) {
            if (i6 != 0) {
                j_a2 = AbstractC0350j$s0.h0(j_a, j6, -1L);
            }
            return g(j_a2);
        }
        throw new IllegalArgumentException(Long.toString(j6));
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream sorted() {
        j$A j_a = (j$A) this.f9954a;
        j_a.getClass();
        return g(new AbstractC0373j$y(j_a) { // from class: g.j$s2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i6 = j$P2.f10062v | j$P2.f10060t;
            }

            @Override // g.AbstractC0285j$c
            public final j$B0 E0(e.j$J j_j, InterfaceC0274j$v interfaceC0274j$v, AbstractC0285j$c abstractC0285j$c) {
                if (j$P2.f10047g.d(abstractC0285j$c.c0())) {
                    return abstractC0285j$c.u0(j_j, false, interfaceC0274j$v);
                }
                double[] dArr = (double[]) ((InterfaceC0370j$x0) abstractC0285j$c.u0(j_j, true, interfaceC0274j$v)).k();
                Arrays.sort(dArr);
                return new j$N0(dArr);
            }

            @Override // g.AbstractC0285j$c
            public final InterfaceC0284j$b2 H0(int i6, final InterfaceC0284j$b2 interfaceC0284j$b2) {
                interfaceC0284j$b2.getClass();
                return j$P2.f10047g.d(i6) ? interfaceC0284j$b2 : j$P2.f10049i.d(i6) ? new AbstractC0324j$l2(interfaceC0284j$b2) { // from class: g.j$x2

                    /* renamed from: c  reason: collision with root package name */
                    private double[] f10304c;

                    /* renamed from: d  reason: collision with root package name */
                    private int f10305d;

                    @Override // g.InterfaceC0284j$b2
                    public final void d(double d6) {
                        double[] dArr = this.f10304c;
                        int i7 = this.f10305d;
                        this.f10305d = i7 + 1;
                        dArr[i7] = d6;
                    }

                    @Override // g.j$U1, g.InterfaceC0284j$b2
                    public final void h() {
                        int i7 = 0;
                        Arrays.sort(this.f10304c, 0, this.f10305d);
                        InterfaceC0284j$b2 interfaceC0284j$b22 = this.f10094a;
                        interfaceC0284j$b22.i(this.f10305d);
                        if (this.f10203b) {
                            while (i7 < this.f10305d && !interfaceC0284j$b22.o()) {
                                interfaceC0284j$b22.d(this.f10304c[i7]);
                                i7++;
                            }
                        } else {
                            while (i7 < this.f10305d) {
                                interfaceC0284j$b22.d(this.f10304c[i7]);
                                i7++;
                            }
                        }
                        interfaceC0284j$b22.h();
                        this.f10304c = null;
                    }

                    @Override // g.InterfaceC0284j$b2
                    public final void i(long j6) {
                        if (j6 >= 2147483639) {
                            throw new IllegalArgumentException("Stream size exceeds max array size");
                        }
                        this.f10304c = new double[(int) j6];
                    }
                } : new AbstractC0324j$l2(interfaceC0284j$b2) { // from class: g.j$p2

                    /* renamed from: c  reason: collision with root package name */
                    private j$D2 f10242c;

                    @Override // g.InterfaceC0284j$b2
                    public final void d(double d6) {
                        this.f10242c.d(d6);
                    }

                    @Override // g.j$U1, g.InterfaceC0284j$b2
                    public final void h() {
                        double[] dArr = (double[]) this.f10242c.k();
                        Arrays.sort(dArr);
                        InterfaceC0284j$b2 interfaceC0284j$b22 = this.f10094a;
                        interfaceC0284j$b22.i(dArr.length);
                        int i7 = 0;
                        if (this.f10203b) {
                            int length = dArr.length;
                            while (i7 < length) {
                                double d6 = dArr[i7];
                                if (interfaceC0284j$b22.o()) {
                                    break;
                                }
                                interfaceC0284j$b22.d(d6);
                                i7++;
                            }
                        } else {
                            int length2 = dArr.length;
                            while (i7 < length2) {
                                interfaceC0284j$b22.d(dArr[i7]);
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
                        this.f10242c = j6 > 0 ? new j$D2((int) j6) : new j$D2();
                    }
                };
            }
        });
    }

    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    public final /* synthetic */ Spliterator<Double> spliterator() {
        return e.j$A.a(((j$A) this.f9954a).spliterator());
    }

    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    /* renamed from: spliterator */
    public final /* synthetic */ Spliterator<Double> spliterator2() {
        return e.j$I.a(((j$A) this.f9954a).spliterator());
    }

    @Override // java.util.stream.DoubleStream
    public final double sum() {
        j$A j_a = (j$A) this.f9954a;
        j_a.getClass();
        double[] dArr = (double[]) j_a.Q0(new C0281j$b(9), new C0281j$b(2), new C0281j$b(3));
        int i6 = AbstractC0317j$k.f10187a;
        double d6 = dArr[0] + dArr[1];
        double d7 = dArr[dArr.length - 1];
        return (Double.isNaN(d6) && Double.isInfinite(d7)) ? d7 : d6;
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleSummaryStatistics summaryStatistics() {
        j$A j_a = (j$A) this.f9954a;
        j_a.getClass();
        return AbstractC0233j$g.a((C0232j$f) j_a.Q0(new j$F0(14), new j$F0(23), new j$F0(24)));
    }

    @Override // java.util.stream.DoubleStream
    public final double[] toArray() {
        j$A j_a = (j$A) this.f9954a;
        j_a.getClass();
        return (double[]) AbstractC0350j$s0.Z((InterfaceC0370j$x0) j_a.w0(new C0281j$b(1))).k();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.stream.BaseStream, java.util.stream.DoubleStream] */
    @Override // java.util.stream.BaseStream
    public final /* synthetic */ DoubleStream unordered() {
        return C0301j$g.g(((j$A) this.f9954a).unordered());
    }
}
