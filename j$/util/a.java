package j$.util;

import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class a implements java.util.Comparator, Comparator {

    /* renamed from: a  reason: collision with root package name */
    public static final a f11050a;

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ a[] f11051b;

    static {
        a aVar = new a();
        f11050a = aVar;
        f11051b = new a[]{aVar};
    }

    private a() {
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f11051b.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo((Comparable) obj2);
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public final java.util.Comparator reversed() {
        return Collections.reverseOrder();
    }

    @Override // j$.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparing(Function function) {
        return function.getClass();
    }

    @Override // j$.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, function, comparator);
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
        return comparator.getClass();
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparing(java.util.function.Function function) {
        return Function.VivifiedWrapper.convert(function).getClass();
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparing(java.util.function.Function function, java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, Function.VivifiedWrapper.convert(function), comparator);
    }

    @Override // j$.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return toDoubleFunction.getClass();
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingDouble(java.util.function.ToDoubleFunction toDoubleFunction) {
        return ToDoubleFunction.VivifiedWrapper.convert(toDoubleFunction).getClass();
    }

    @Override // j$.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return toIntFunction.getClass();
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingInt(java.util.function.ToIntFunction toIntFunction) {
        return ToIntFunction.VivifiedWrapper.convert(toIntFunction).getClass();
    }

    @Override // j$.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return toLongFunction.getClass();
    }

    @Override // java.util.Comparator
    public final /* synthetic */ java.util.Comparator thenComparingLong(java.util.function.ToLongFunction toLongFunction) {
        return ToLongFunction.VivifiedWrapper.convert(toLongFunction).getClass();
    }
}
