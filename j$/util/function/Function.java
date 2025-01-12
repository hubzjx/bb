package j$.util.function;

import f.j$W;
import java.util.function.UnaryOperator;
/* loaded from: classes2.dex */
public interface Function {

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements Function {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.Function f11131a;

        private /* synthetic */ VivifiedWrapper(java.util.function.Function function) {
            this.f11131a = function;
        }

        public static /* synthetic */ Function convert(java.util.function.Function function) {
            if (function == null) {
                return null;
            }
            return function instanceof UnaryOperator ? j$W.b((UnaryOperator) function) : new VivifiedWrapper(function);
        }

        @Override // j$.util.function.Function
        public final /* synthetic */ Object a(Object obj) {
            return this.f11131a.apply(obj);
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f11131a;
            }
            return this.f11131a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f11131a.hashCode();
        }
    }

    Object a(Object obj);
}
