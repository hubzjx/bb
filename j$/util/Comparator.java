package j$.util;

import e.AbstractC0227j$a;
import e.C0229j$c;
import e.C0230j$d;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
/* loaded from: classes2.dex */
public interface Comparator {

    /* renamed from: j$.util.Comparator$-CC */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        public static java.util.Comparator $default$thenComparing(java.util.Comparator comparator, Function function) {
            function.getClass();
            return AbstractC0227j$a.B(comparator, new C0229j$c(3, function));
        }

        public static java.util.Comparator $default$thenComparing(java.util.Comparator comparator, Function function, java.util.Comparator comparator2) {
            function.getClass();
            comparator2.getClass();
            return AbstractC0227j$a.B(comparator, new C0230j$d(comparator2, function, 1));
        }

        public static java.util.Comparator $default$thenComparing(java.util.Comparator comparator, java.util.Comparator comparator2) {
            comparator2.getClass();
            return new C0230j$d(comparator, comparator2, 0);
        }

        public static java.util.Comparator $default$thenComparingDouble(java.util.Comparator comparator, ToDoubleFunction toDoubleFunction) {
            toDoubleFunction.getClass();
            return AbstractC0227j$a.B(comparator, new C0229j$c(0, toDoubleFunction));
        }

        public static java.util.Comparator $default$thenComparingInt(java.util.Comparator comparator, ToIntFunction toIntFunction) {
            toIntFunction.getClass();
            return AbstractC0227j$a.B(comparator, new C0229j$c(1, toIntFunction));
        }

        public static java.util.Comparator $default$thenComparingLong(java.util.Comparator comparator, ToLongFunction toLongFunction) {
            toLongFunction.getClass();
            return AbstractC0227j$a.B(comparator, new C0229j$c(2, toLongFunction));
        }

        public static java.util.Comparator a() {
            return a.f11050a;
        }
    }

    java.util.Comparator reversed();

    java.util.Comparator thenComparing(Function function);

    java.util.Comparator thenComparing(Function function, java.util.Comparator comparator);

    java.util.Comparator thenComparing(java.util.Comparator comparator);

    java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction);

    java.util.Comparator thenComparingInt(ToIntFunction toIntFunction);

    java.util.Comparator thenComparingLong(ToLongFunction toLongFunction);
}
