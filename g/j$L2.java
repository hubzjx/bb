package g;

import e.AbstractC0227j$a;
import e.C0239j$m;
import f.C0253j$a;
import f.C0254j$b;
import f.C0256j$d;
import f.C0273j$u;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.BaseStream;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$L2 implements Stream {

    /* renamed from: a */
    public final /* synthetic */ j$M2 f10020a;

    private /* synthetic */ j$L2(j$M2 j_m2) {
        this.f10020a = j_m2;
    }

    public static /* synthetic */ j$L2 g(j$M2 j_m2) {
        if (j_m2 == null) {
            return null;
        }
        return new j$L2(j_m2);
    }

    @Override // java.util.stream.Stream
    public final boolean allMatch(Predicate predicate) {
        j$M2 j_m2 = this.f10020a;
        f.j$S a6 = f.j$S.a(predicate);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        return ((Boolean) j_t1.v0(AbstractC0350j$s0.o0(a6, EnumC0338j$p0.ALL))).booleanValue();
    }

    @Override // java.util.stream.Stream
    public final boolean anyMatch(Predicate predicate) {
        j$M2 j_m2 = this.f10020a;
        f.j$S a6 = f.j$S.a(predicate);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        return ((Boolean) j_t1.v0(AbstractC0350j$s0.o0(a6, EnumC0338j$p0.ANY))).booleanValue();
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        ((AbstractC0285j$c) this.f10020a).close();
    }

    @Override // java.util.stream.Stream
    public final Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        j$M2 j_m2 = this.f10020a;
        f.j$U a6 = f.j$U.a(supplier);
        j$.util.function.BiConsumer convert = BiConsumer.VivifiedWrapper.convert(biConsumer);
        j$.util.function.BiConsumer convert2 = BiConsumer.VivifiedWrapper.convert(biConsumer2);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        a6.getClass();
        convert.getClass();
        convert2.getClass();
        return j_t1.v0(new C0347j$r1(1, convert2, convert, a6, 3));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // java.util.stream.Stream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collect(Collector collector) {
        Object v02;
        j$M2 j_m2 = this.f10020a;
        final C0313j$j a6 = C0313j$j.a(collector);
        j$T1 j_t1 = (j$T1) j_m2;
        if (j_t1.isParallel() && a6.f10182a.characteristics().contains(EnumC0309j$i.CONCURRENT)) {
            boolean B0 = j_t1.B0();
            Collector collector2 = a6.f10182a;
            if (!B0 || collector2.characteristics().contains(EnumC0309j$i.UNORDERED)) {
                v02 = f.j$U.a(collector2.supplier()).get();
                j_t1.b(new C0321j$l(5, BiConsumer.VivifiedWrapper.convert(collector2.accumulator()), v02));
                return !a6.f10182a.characteristics().contains(EnumC0309j$i.IDENTITY_FINISH) ? v02 : Function.VivifiedWrapper.convert(a6.f10182a.finisher()).a(v02);
            }
        }
        a6.getClass();
        Collector collector3 = a6.f10182a;
        final f.j$U a7 = f.j$U.a(collector3.supplier());
        final j$.util.function.BiConsumer convert = BiConsumer.VivifiedWrapper.convert(collector3.accumulator());
        final C0254j$b a8 = C0254j$b.a(collector3.combiner());
        v02 = j_t1.v0(new AbstractC0350j$s0() { // from class: g.j$A1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // g.AbstractC0350j$s0, g.j$x3
            public final int k() {
                if (a6.f10182a.characteristics().contains(EnumC0309j$i.UNORDERED)) {
                    return j$P2.f10063w;
                }
                return 0;
            }

            @Override // g.AbstractC0350j$s0
            public final j$K1 q0() {
                return new j$B1(a7, convert, a8);
            }
        });
        if (!a6.f10182a.characteristics().contains(EnumC0309j$i.IDENTITY_FINISH)) {
        }
    }

    @Override // java.util.stream.Stream
    public final long count() {
        j$T1 j_t1 = (j$T1) this.f10020a;
        j_t1.getClass();
        return ((AbstractC0306j$h0) j_t1.P0(new j$F0(7))).sum();
    }

    @Override // java.util.stream.Stream
    public final /* synthetic */ Stream distinct() {
        return g(((j$T1) this.f10020a).O0());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        j$M2 j_m2 = this.f10020a;
        if (obj instanceof j$L2) {
            obj = ((j$L2) obj).f10020a;
        }
        return j_m2.equals(obj);
    }

    @Override // java.util.stream.Stream
    public final Stream filter(Predicate predicate) {
        j$M2 j_m2 = this.f10020a;
        f.j$S a6 = f.j$S.a(predicate);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        a6.getClass();
        return g(new C0353j$t(j_t1, j$P2.f10065y, a6, 4));
    }

    @Override // java.util.stream.Stream
    public final Optional findAny() {
        return AbstractC0227j$a.t((C0239j$m) ((j$T1) this.f10020a).v0(new j$D(false, 1, C0239j$m.a(), new j$F0(27), new C0281j$b(12))));
    }

    @Override // java.util.stream.Stream
    public final Optional findFirst() {
        return AbstractC0227j$a.t((C0239j$m) ((j$T1) this.f10020a).v0(new j$D(true, 1, C0239j$m.a(), new j$F0(27), new C0281j$b(12))));
    }

    @Override // java.util.stream.Stream
    public final Stream flatMap(java.util.function.Function function) {
        j$M2 j_m2 = this.f10020a;
        Function convert = Function.VivifiedWrapper.convert(function);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        convert.getClass();
        return g(new j$P1(j_t1, j$P2.f10061u | j$P2.f10059s | j$P2.f10065y, convert, 1));
    }

    @Override // java.util.stream.Stream
    public final DoubleStream flatMapToDouble(java.util.function.Function function) {
        j$M2 j_m2 = this.f10020a;
        Function convert = Function.VivifiedWrapper.convert(function);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        convert.getClass();
        return j$B.g(new C0349j$s(j_t1, j$P2.f10061u | j$P2.f10059s | j$P2.f10065y, convert, 7));
    }

    @Override // java.util.stream.Stream
    public final IntStream flatMapToInt(java.util.function.Function function) {
        j$M2 j_m2 = this.f10020a;
        Function convert = Function.VivifiedWrapper.convert(function);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        convert.getClass();
        return C0277j$a0.g(new C0357j$u(j_t1, j$P2.f10061u | j$P2.f10059s | j$P2.f10065y, convert, 7));
    }

    @Override // java.util.stream.Stream
    public final LongStream flatMapToLong(java.util.function.Function function) {
        j$M2 j_m2 = this.f10020a;
        Function convert = Function.VivifiedWrapper.convert(function);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        convert.getClass();
        return C0310j$i0.g(new C0361j$v(j_t1, j$P2.f10061u | j$P2.f10059s | j$P2.f10065y, convert, 6));
    }

    @Override // java.util.stream.Stream
    public final /* synthetic */ void forEach(Consumer consumer) {
        this.f10020a.b(C0256j$d.b(consumer));
    }

    @Override // java.util.stream.Stream
    public final /* synthetic */ void forEachOrdered(Consumer consumer) {
        this.f10020a.e(C0256j$d.b(consumer));
    }

    public final /* synthetic */ int hashCode() {
        return this.f10020a.hashCode();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return ((AbstractC0285j$c) this.f10020a).isParallel();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ Iterator iterator() {
        return ((j$T1) this.f10020a).iterator();
    }

    @Override // java.util.stream.Stream
    public final Stream limit(long j6) {
        j$T1 j_t1 = (j$T1) this.f10020a;
        j_t1.getClass();
        if (j6 >= 0) {
            return g(AbstractC0350j$s0.p0(j_t1, 0L, j6));
        }
        throw new IllegalArgumentException(Long.toString(j6));
    }

    @Override // java.util.stream.Stream
    public final Stream map(java.util.function.Function function) {
        j$M2 j_m2 = this.f10020a;
        Function convert = Function.VivifiedWrapper.convert(function);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        convert.getClass();
        return g(new j$P1(j_t1, j$P2.f10061u | j$P2.f10059s, convert, 0));
    }

    @Override // java.util.stream.Stream
    public final DoubleStream mapToDouble(ToDoubleFunction toDoubleFunction) {
        j$M2 j_m2 = this.f10020a;
        j$.util.function.ToDoubleFunction convert = ToDoubleFunction.VivifiedWrapper.convert(toDoubleFunction);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        convert.getClass();
        return j$B.g(new C0349j$s(j_t1, j$P2.f10061u | j$P2.f10059s, convert, 6));
    }

    @Override // java.util.stream.Stream
    public final IntStream mapToInt(ToIntFunction toIntFunction) {
        j$M2 j_m2 = this.f10020a;
        j$.util.function.ToIntFunction convert = ToIntFunction.VivifiedWrapper.convert(toIntFunction);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        convert.getClass();
        return C0277j$a0.g(new C0357j$u(j_t1, j$P2.f10061u | j$P2.f10059s, convert, 6));
    }

    @Override // java.util.stream.Stream
    public final /* synthetic */ LongStream mapToLong(ToLongFunction toLongFunction) {
        return C0310j$i0.g(((j$T1) this.f10020a).P0(ToLongFunction.VivifiedWrapper.convert(toLongFunction)));
    }

    @Override // java.util.stream.Stream
    public final Optional max(Comparator comparator) {
        j$T1 j_t1 = (j$T1) this.f10020a;
        j_t1.getClass();
        comparator.getClass();
        return AbstractC0227j$a.t(j_t1.Q0(new C0253j$a(comparator, 0)));
    }

    @Override // java.util.stream.Stream
    public final Optional min(Comparator comparator) {
        j$T1 j_t1 = (j$T1) this.f10020a;
        j_t1.getClass();
        comparator.getClass();
        return AbstractC0227j$a.t(j_t1.Q0(new C0253j$a(comparator, 1)));
    }

    @Override // java.util.stream.Stream
    public final boolean noneMatch(Predicate predicate) {
        j$M2 j_m2 = this.f10020a;
        f.j$S a6 = f.j$S.a(predicate);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        return ((Boolean) j_t1.v0(AbstractC0350j$s0.o0(a6, EnumC0338j$p0.NONE))).booleanValue();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f10020a;
        abstractC0285j$c.D0(runnable);
        return C0301j$g.g(abstractC0285j$c);
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream parallel() {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f10020a;
        abstractC0285j$c.I0();
        return C0301j$g.g(abstractC0285j$c);
    }

    @Override // java.util.stream.Stream
    public final Stream peek(Consumer consumer) {
        j$M2 j_m2 = this.f10020a;
        C0256j$d b6 = C0256j$d.b(consumer);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        b6.getClass();
        return g(new C0353j$t(j_t1, 0, b6, 3));
    }

    @Override // java.util.stream.Stream
    public final Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        j$M2 j_m2 = this.f10020a;
        j$.util.function.BiFunction convert = BiFunction.VivifiedWrapper.convert(biFunction);
        C0254j$b a6 = C0254j$b.a(binaryOperator);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        convert.getClass();
        a6.getClass();
        return j_t1.v0(new C0347j$r1(1, a6, convert, obj, 2));
    }

    @Override // java.util.stream.Stream
    public final Object reduce(Object obj, BinaryOperator binaryOperator) {
        j$M2 j_m2 = this.f10020a;
        C0254j$b a6 = C0254j$b.a(binaryOperator);
        j$T1 j_t1 = (j$T1) j_m2;
        j_t1.getClass();
        a6.getClass();
        a6.getClass();
        return j_t1.v0(new C0347j$r1(1, a6, a6, obj, 2));
    }

    @Override // java.util.stream.Stream
    public final /* synthetic */ Optional reduce(BinaryOperator binaryOperator) {
        return AbstractC0227j$a.t(((j$T1) this.f10020a).Q0(C0254j$b.a(binaryOperator)));
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream sequential() {
        AbstractC0285j$c abstractC0285j$c = (AbstractC0285j$c) this.f10020a;
        abstractC0285j$c.J0();
        return C0301j$g.g(abstractC0285j$c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [g.j$M2] */
    @Override // java.util.stream.Stream
    public final Stream skip(long j6) {
        j$T1 j_t1 = (j$T1) this.f10020a;
        j_t1.getClass();
        int i6 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        j$T1 j_t12 = j_t1;
        if (i6 >= 0) {
            if (i6 != 0) {
                j_t12 = AbstractC0350j$s0.p0(j_t1, j6, -1L);
            }
            return g(j_t12);
        }
        throw new IllegalArgumentException(Long.toString(j6));
    }

    @Override // java.util.stream.Stream
    public final Stream sorted() {
        j$T1 j_t1 = (j$T1) this.f10020a;
        j_t1.getClass();
        return g(new C0364j$v2(j_t1));
    }

    @Override // java.util.stream.Stream
    public final Stream sorted(Comparator comparator) {
        j$T1 j_t1 = (j$T1) this.f10020a;
        j_t1.getClass();
        return g(new C0364j$v2(j_t1, comparator));
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ Spliterator spliterator() {
        return e.j$I.a(((AbstractC0285j$c) this.f10020a).spliterator());
    }

    @Override // java.util.stream.Stream
    public final Object[] toArray() {
        j$T1 j_t1 = (j$T1) this.f10020a;
        j_t1.getClass();
        j$F0 j_f0 = new j$F0(6);
        return AbstractC0350j$s0.Y(j_t1.w0(j_f0), j_f0).n(j_f0);
    }

    @Override // java.util.stream.Stream
    public final Object[] toArray(IntFunction intFunction) {
        j$M2 j_m2 = this.f10020a;
        C0273j$u a6 = C0273j$u.a(intFunction);
        return AbstractC0350j$s0.Y(((j$T1) j_m2).w0(a6), a6).n(a6);
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream unordered() {
        return C0301j$g.g(((j$T1) this.f10020a).unordered());
    }
}
