package j$.util.function;

import f.C0254j$b;
import java.util.function.BinaryOperator;
/* loaded from: classes2.dex */
public interface BiFunction {

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements BiFunction {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.BiFunction f11130a;

        private /* synthetic */ VivifiedWrapper(java.util.function.BiFunction biFunction) {
            this.f11130a = biFunction;
        }

        public static /* synthetic */ BiFunction convert(java.util.function.BiFunction biFunction) {
            if (biFunction == null) {
                return null;
            }
            return biFunction instanceof BinaryOperator ? C0254j$b.a((BinaryOperator) biFunction) : new VivifiedWrapper(biFunction);
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f11130a;
            }
            return this.f11130a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f11130a.hashCode();
        }

        @Override // j$.util.function.BiFunction
        public final /* synthetic */ Object p(Object obj, Object obj2) {
            return this.f11130a.apply(obj, obj2);
        }
    }

    Object p(Object obj, Object obj2);
}
