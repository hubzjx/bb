package i4;

import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import kotlin.jvm.internal.l;
/* loaded from: classes.dex */
final class f implements Comparator, j$.util.Comparator {

    /* renamed from: a  reason: collision with root package name */
    public static final f f11034a = new f();

    private f() {
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Comparable comparable, Comparable comparable2) {
        l.d(comparable, "a");
        l.d(comparable2, "b");
        return comparable2.compareTo(comparable);
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public final Comparator reversed() {
        return e.f11033a;
    }

    @Override // java.util.Comparator
    public /* synthetic */ Comparator thenComparing(Function function) {
        return thenComparing(Function.VivifiedWrapper.convert(function));
    }

    @Override // java.util.Comparator
    public /* synthetic */ Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return thenComparingDouble(ToDoubleFunction.VivifiedWrapper.convert(toDoubleFunction));
    }

    @Override // java.util.Comparator
    public /* synthetic */ Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return thenComparingInt(ToIntFunction.VivifiedWrapper.convert(toIntFunction));
    }

    @Override // java.util.Comparator
    public /* synthetic */ Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return thenComparingLong(ToLongFunction.VivifiedWrapper.convert(toLongFunction));
    }

    @Override // java.util.Comparator
    public /* synthetic */ Comparator thenComparing(java.util.function.Function function, Comparator comparator) {
        return thenComparing(Function.VivifiedWrapper.convert(function), comparator);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ Comparator thenComparingDouble(j$.util.function.ToDoubleFunction toDoubleFunction) {
        return toDoubleFunction.getClass();
    }

    @Override // j$.util.Comparator
    public /* synthetic */ Comparator thenComparingInt(j$.util.function.ToIntFunction toIntFunction) {
        return toIntFunction.getClass();
    }

    @Override // j$.util.Comparator
    public /* synthetic */ Comparator thenComparingLong(j$.util.function.ToLongFunction toLongFunction) {
        return toLongFunction.getClass();
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return comparator.getClass();
    }

    @Override // j$.util.Comparator
    public /* synthetic */ Comparator thenComparing(j$.util.function.Function function) {
        return function.getClass();
    }

    @Override // j$.util.Comparator
    public /* synthetic */ Comparator thenComparing(j$.util.function.Function function, Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, function, comparator);
    }
}
