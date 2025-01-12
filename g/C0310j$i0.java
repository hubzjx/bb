package g;

import e.AbstractC0227j$a;
import e.AbstractC0238j$l;
import e.C0237j$k;
import e.C0240j$n;
import e.C0242j$p;
import e.C0250j$x;
import f.InterfaceC0274j$v;
import j$.util.function.BiConsumer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
/* renamed from: g.j$i0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0310j$i0 implements LongStream {

    /* renamed from: a */
    public final /* synthetic */ InterfaceC0314j$j0 f10177a;

    private /* synthetic */ C0310j$i0(InterfaceC0314j$j0 interfaceC0314j$j0) {
        this.f10177a = interfaceC0314j$j0;
    }

    public static /* synthetic */ C0310j$i0 g(InterfaceC0314j$j0 interfaceC0314j$j0) {
        if (interfaceC0314j$j0 == null) {
            return null;
        }
        return new C0310j$i0(interfaceC0314j$j0);
    }

    @Override // java.util.stream.LongStream
    public final boolean allMatch(LongPredicate longPredicate) {
        InterfaceC0314j$j0 interfaceC0314j$j0 = this.f10177a;
        f.j$H a6 = f.j$H.a(longPredicate);
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) interfaceC0314j$j0;
        abstractC0306j$h0.getClass();
        return ((Boolean) abstractC0306j$h0.v0(AbstractC0350j$s0.m0(a6, EnumC0338j$p0.ALL))).booleanValue();
    }

    @Override // java.util.stream.LongStream
    public final boolean anyMatch(LongPredicate longPredicate) {
        InterfaceC0314j$j0 interfaceC0314j$j0 = this.f10177a;
        f.j$H a6 = f.j$H.a(longPredicate);
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) interfaceC0314j$j0;
        abstractC0306j$h0.getClass();
        return ((Boolean) abstractC0306j$h0.v0(AbstractC0350j$s0.m0(a6, EnumC0338j$p0.ANY))).booleanValue();
    }

    @Override // java.util.stream.LongStream
    public final DoubleStream asDoubleStream() {
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) this.f10177a;
        abstractC0306j$h0.getClass();
        return j$B.g(new C0365j$w(abstractC0306j$h0, j$P2.f10061u | j$P2.f10059s, 2));
    }

    @Override // java.util.stream.LongStream
    public final OptionalDouble average() {
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) this.f10177a;
        abstractC0306j$h0.getClass();
        long[] jArr = (long[]) abstractC0306j$h0.Q0(new C0281j$b(25), new C0281j$b(26), new C0281j$b(27));
        long j6 = jArr[0];
        return AbstractC0227j$a.u(j6 > 0 ? C0240j$n.d(jArr[1] / j6) : C0240j$n.a());
    }

    @Override // java.util.stream.LongStream
    public final Stream boxed() {
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) this.f10177a;
        abstractC0306j$h0.getClass();
        return j$L2.g(new C0353j$t(abstractC0306j$h0, j$P2.f10061u | j$P2.f10059s, new j$S(6), 2));
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        ((AbstractC0285j$c) this.f10177a).close();
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        return ((AbstractC0306j$h0) this.f10177a).Q0(f.j$U.a(supplier), f.j$Q.a(objLongConsumer), BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    @Override // java.util.stream.LongStream
    public final long count() {
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) this.f10177a;
        abstractC0306j$h0.getClass();
        return new C0361j$v(abstractC0306j$h0, j$P2.f10061u | j$P2.f10059s, new C0281j$b(22), 2).sum();
    }

    @Override // java.util.stream.LongStream
    public final LongStream distinct() {
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) this.f10177a;
        abstractC0306j$h0.getClass();
        return g(((j$T1) new C0353j$t(abstractC0306j$h0, j$P2.f10061u | j$P2.f10059s, new j$S(6), 2).O0()).P0(new C0281j$b(23)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        InterfaceC0314j$j0 interfaceC0314j$j0 = this.f10177a;
        if (obj instanceof C0310j$i0) {
            obj = ((C0310j$i0) obj).f10177a;
        }
        return interfaceC0314j$j0.equals(obj);
    }

    @Override // java.util.stream.LongStream
    public final LongStream filter(LongPredicate longPredicate) {
        InterfaceC0314j$j0 interfaceC0314j$j0 = this.f10177a;
        f.j$H a6 = f.j$H.a(longPredicate);
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) interfaceC0314j$j0;
        abstractC0306j$h0.getClass();
        a6.getClass();
        return g(new C0361j$v(abstractC0306j$h0, j$P2.f10065y, a6, 4));
    }

    @Override // java.util.stream.LongStream
    public final OptionalLong findAny() {
        return AbstractC0227j$a.w((C0242j$p) ((AbstractC0306j$h0) this.f10177a).v0(new j$D(false, 3, C0242j$p.a(), new j$F0(26), new C0281j$b(11))));
    }

    @Override // java.util.stream.LongStream
    public final OptionalLong findFirst() {
        return AbstractC0227j$a.w((C0242j$p) ((AbstractC0306j$h0) this.f10177a).v0(new j$D(true, 3, C0242j$p.a(), new j$F0(26), new C0281j$b(11))));
    }

    @Override // java.util.stream.LongStream
    public final LongStream flatMap(LongFunction longFunction) {
        InterfaceC0314j$j0 interfaceC0314j$j0 = this.f10177a;
        f.j$F a6 = f.j$F.a(longFunction);
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) interfaceC0314j$j0;
        abstractC0306j$h0.getClass();
        return g(new C0361j$v(abstractC0306j$h0, j$P2.f10061u | j$P2.f10059s | j$P2.f10065y, a6, 3));
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ void forEach(LongConsumer longConsumer) {
        this.f10177a.c(f.j$D.b(longConsumer));
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ void forEachOrdered(LongConsumer longConsumer) {
        this.f10177a.f(f.j$D.b(longConsumer));
    }

    public final /* synthetic */ int hashCode() {
        return this.f10177a.hashCode();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return ((AbstractC0285j$c) this.f10177a).isParallel();
    }

    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    public final Iterator<Long> iterator() {
        return e.j$X.h(((AbstractC0306j$h0) this.f10177a).spliterator());
    }

    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    /* renamed from: iterator */
    public final Iterator<Long> iterator2() {
        return C0250j$x.a(e.j$X.h(((AbstractC0306j$h0) this.f10177a).spliterator()));
    }

    @Override // java.util.stream.LongStream
    public final LongStream limit(long j6) {
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) this.f10177a;
        abstractC0306j$h0.getClass();
        if (j6 >= 0) {
            return g(AbstractC0350j$s0.l0(abstractC0306j$h0, 0L, j6));
        }
        throw new IllegalArgumentException(Long.toString(j6));
    }

    @Override // java.util.stream.LongStream
    public final LongStream map(LongUnaryOperator longUnaryOperator) {
        InterfaceC0314j$j0 interfaceC0314j$j0 = this.f10177a;
        f.j$K a6 = f.j$K.a(longUnaryOperator);
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) interfaceC0314j$j0;
        abstractC0306j$h0.getClass();
        a6.getClass();
        return g(new C0361j$v(abstractC0306j$h0, j$P2.f10061u | j$P2.f10059s, a6, 2));
    }

    @Override // java.util.stream.LongStream
    public final DoubleStream mapToDouble(LongToDoubleFunction longToDoubleFunction) {
        InterfaceC0314j$j0 interfaceC0314j$j0 = this.f10177a;
        f.j$I a6 = f.j$I.a(longToDoubleFunction);
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) interfaceC0314j$j0;
        abstractC0306j$h0.getClass();
        a6.getClass();
        return j$B.g(new C0349j$s(abstractC0306j$h0, j$P2.f10061u | j$P2.f10059s, a6, 5));
    }

    @Override // java.util.stream.LongStream
    public final IntStream mapToInt(LongToIntFunction longToIntFunction) {
        InterfaceC0314j$j0 interfaceC0314j$j0 = this.f10177a;
        f.j$J a6 = f.j$J.a(longToIntFunction);
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) interfaceC0314j$j0;
        abstractC0306j$h0.getClass();
        a6.getClass();
        return C0277j$a0.g(new C0357j$u(abstractC0306j$h0, j$P2.f10061u | j$P2.f10059s, a6, 5));
    }

    @Override // java.util.stream.LongStream
    public final Stream mapToObj(LongFunction longFunction) {
        InterfaceC0314j$j0 interfaceC0314j$j0 = this.f10177a;
        f.j$F a6 = f.j$F.a(longFunction);
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) interfaceC0314j$j0;
        abstractC0306j$h0.getClass();
        a6.getClass();
        return j$L2.g(new C0353j$t(abstractC0306j$h0, j$P2.f10061u | j$P2.f10059s, a6, 2));
    }

    @Override // java.util.stream.LongStream
    public final OptionalLong max() {
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) this.f10177a;
        abstractC0306j$h0.getClass();
        return AbstractC0227j$a.w(abstractC0306j$h0.R0(new j$S(5)));
    }

    @Override // java.util.stream.LongStream
    public final OptionalLong min() {
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) this.f10177a;
        abstractC0306j$h0.getClass();
        return AbstractC0227j$a.w(abstractC0306j$h0.R0(new j$S(4)));
    }

    @Override // java.util.stream.LongStream
    public final boolean noneMatch(LongPredicate longPredicate) {
        InterfaceC0314j$j0 interfaceC0314j$j0 = this.f10177a;
        f.j$H a6 = f.j$H.a(longPredicate);
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) interfaceC0314j$j0;
        abstractC0306j$h0.getClass();
        return ((Boolean) abstractC0306j$h0.v0(AbstractC0350j$s0.m0(a6, EnumC0338j$p0.NONE))).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.stream.LongStream, java.util.stream.BaseStream] */
    @Override // java.util.stream.BaseStream
    public final /* synthetic */ LongStream onClose(Runnable runnable) {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f10177a;
        abstractC0285j$c.D0(runnable);
        return C0301j$g.g(abstractC0285j$c);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.LongStream, java.util.stream.BaseStream] */
    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    public final /* synthetic */ LongStream parallel() {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f10177a;
        abstractC0285j$c.I0();
        return C0301j$g.g(abstractC0285j$c);
    }

    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    /* renamed from: parallel */
    public final /* synthetic */ LongStream parallel2() {
        return g(this.f10177a.parallel());
    }

    @Override // java.util.stream.LongStream
    public final LongStream peek(LongConsumer longConsumer) {
        InterfaceC0314j$j0 interfaceC0314j$j0 = this.f10177a;
        f.j$D b6 = f.j$D.b(longConsumer);
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) interfaceC0314j$j0;
        abstractC0306j$h0.getClass();
        b6.getClass();
        return g(new C0361j$v(abstractC0306j$h0, 0, b6, 5));
    }

    @Override // java.util.stream.LongStream
    public final long reduce(long j6, LongBinaryOperator longBinaryOperator) {
        InterfaceC0314j$j0 interfaceC0314j$j0 = this.f10177a;
        f.j$B a6 = f.j$B.a(longBinaryOperator);
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) interfaceC0314j$j0;
        abstractC0306j$h0.getClass();
        a6.getClass();
        return ((Long) abstractC0306j$h0.v0(new j$H1(a6, j6))).longValue();
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ OptionalLong reduce(LongBinaryOperator longBinaryOperator) {
        return AbstractC0227j$a.w(((AbstractC0306j$h0) this.f10177a).R0(f.j$B.a(longBinaryOperator)));
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.LongStream, java.util.stream.BaseStream] */
    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    public final /* synthetic */ LongStream sequential() {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f10177a;
        abstractC0285j$c.J0();
        return C0301j$g.g(abstractC0285j$c);
    }

    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    /* renamed from: sequential */
    public final /* synthetic */ LongStream sequential2() {
        return g(this.f10177a.sequential());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [g.j$j0] */
    @Override // java.util.stream.LongStream
    public final LongStream skip(long j6) {
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) this.f10177a;
        abstractC0306j$h0.getClass();
        int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        AbstractC0306j$h0 abstractC0306j$h02 = abstractC0306j$h0;
        if (i6 >= 0) {
            if (i6 != 0) {
                abstractC0306j$h02 = AbstractC0350j$s0.l0(abstractC0306j$h0, j6, -1L);
            }
            return g(abstractC0306j$h02);
        }
        throw new IllegalArgumentException(Long.toString(j6));
    }

    @Override // java.util.stream.LongStream
    public final LongStream sorted() {
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) this.f10177a;
        abstractC0306j$h0.getClass();
        return g(new AbstractC0298j$f0(abstractC0306j$h0) { // from class: g.j$u2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i6 = j$P2.f10062v | j$P2.f10060t;
            }

            @Override // g.AbstractC0285j$c
            public final j$B0 E0(e.j$J j_j, InterfaceC0274j$v interfaceC0274j$v, AbstractC0285j$c abstractC0285j$c) {
                if (j$P2.f10047g.d(abstractC0285j$c.c0())) {
                    return abstractC0285j$c.u0(j_j, false, interfaceC0274j$v);
                }
                long[] jArr = (long[]) ((InterfaceC0378j$z0) abstractC0285j$c.u0(j_j, true, interfaceC0274j$v)).k();
                Arrays.sort(jArr);
                return new C0299j$f1(jArr);
            }

            @Override // g.AbstractC0285j$c
            public final InterfaceC0284j$b2 H0(int i6, final InterfaceC0284j$b2 interfaceC0284j$b2) {
                interfaceC0284j$b2.getClass();
                return j$P2.f10047g.d(i6) ? interfaceC0284j$b2 : j$P2.f10049i.d(i6) ? new AbstractC0332j$n2(interfaceC0284j$b2) { // from class: g.j$z2

                    /* renamed from: c  reason: collision with root package name */
                    private long[] f10314c;

                    /* renamed from: d  reason: collision with root package name */
                    private int f10315d;

                    @Override // g.InterfaceC0284j$b2
                    public final void f(long j6) {
                        long[] jArr = this.f10314c;
                        int i7 = this.f10315d;
                        this.f10315d = i7 + 1;
                        jArr[i7] = j6;
                    }

                    @Override // g.j$W1, g.InterfaceC0284j$b2
                    public final void h() {
                        int i7 = 0;
                        Arrays.sort(this.f10314c, 0, this.f10315d);
                        InterfaceC0284j$b2 interfaceC0284j$b22 = this.f10100a;
                        interfaceC0284j$b22.i(this.f10315d);
                        if (this.f10221b) {
                            while (i7 < this.f10315d && !interfaceC0284j$b22.o()) {
                                interfaceC0284j$b22.f(this.f10314c[i7]);
                                i7++;
                            }
                        } else {
                            while (i7 < this.f10315d) {
                                interfaceC0284j$b22.f(this.f10314c[i7]);
                                i7++;
                            }
                        }
                        interfaceC0284j$b22.h();
                        this.f10314c = null;
                    }

                    @Override // g.InterfaceC0284j$b2
                    public final void i(long j6) {
                        if (j6 >= 2147483639) {
                            throw new IllegalArgumentException("Stream size exceeds max array size");
                        }
                        this.f10314c = new long[(int) j6];
                    }
                } : new AbstractC0332j$n2(interfaceC0284j$b2) { // from class: g.j$r2

                    /* renamed from: c  reason: collision with root package name */
                    private j$H2 f10259c;

                    @Override // g.InterfaceC0284j$b2
                    public final void f(long j6) {
                        this.f10259c.f(j6);
                    }

                    @Override // g.j$W1, g.InterfaceC0284j$b2
                    public final void h() {
                        long[] jArr = (long[]) this.f10259c.k();
                        Arrays.sort(jArr);
                        InterfaceC0284j$b2 interfaceC0284j$b22 = this.f10100a;
                        interfaceC0284j$b22.i(jArr.length);
                        int i7 = 0;
                        if (this.f10221b) {
                            int length = jArr.length;
                            while (i7 < length) {
                                long j6 = jArr[i7];
                                if (interfaceC0284j$b22.o()) {
                                    break;
                                }
                                interfaceC0284j$b22.f(j6);
                                i7++;
                            }
                        } else {
                            int length2 = jArr.length;
                            while (i7 < length2) {
                                interfaceC0284j$b22.f(jArr[i7]);
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
                        this.f10259c = j6 > 0 ? new j$H2((int) j6) : new j$H2();
                    }
                };
            }
        });
    }

    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    public final /* synthetic */ Spliterator<Long> spliterator() {
        return e.j$E.a(((AbstractC0306j$h0) this.f10177a).spliterator());
    }

    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    /* renamed from: spliterator */
    public final /* synthetic */ Spliterator<Long> spliterator2() {
        return e.j$I.a(((AbstractC0306j$h0) this.f10177a).spliterator());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ long sum() {
        return ((AbstractC0306j$h0) this.f10177a).sum();
    }

    @Override // java.util.stream.LongStream
    public final LongSummaryStatistics summaryStatistics() {
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) this.f10177a;
        abstractC0306j$h0.getClass();
        return AbstractC0238j$l.a((C0237j$k) abstractC0306j$h0.Q0(new j$F0(16), new j$S(7), new j$S(8)));
    }

    @Override // java.util.stream.LongStream
    public final long[] toArray() {
        AbstractC0306j$h0 abstractC0306j$h0 = (AbstractC0306j$h0) this.f10177a;
        abstractC0306j$h0.getClass();
        return (long[]) AbstractC0350j$s0.b0((InterfaceC0378j$z0) abstractC0306j$h0.w0(new C0281j$b(24))).k();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.stream.LongStream, java.util.stream.BaseStream] */
    @Override // java.util.stream.BaseStream
    public final /* synthetic */ LongStream unordered() {
        return C0301j$g.g(((AbstractC0306j$h0) this.f10177a).unordered());
    }
}
