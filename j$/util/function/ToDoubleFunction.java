package j$.util.function;
/* loaded from: classes2.dex */
public interface ToDoubleFunction {

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements ToDoubleFunction {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.ToDoubleFunction f11132a;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToDoubleFunction toDoubleFunction) {
            this.f11132a = toDoubleFunction;
        }

        public static /* synthetic */ ToDoubleFunction convert(java.util.function.ToDoubleFunction toDoubleFunction) {
            if (toDoubleFunction == null) {
                return null;
            }
            return new VivifiedWrapper(toDoubleFunction);
        }

        @Override // j$.util.function.ToDoubleFunction
        public final /* synthetic */ double e(Object obj) {
            return this.f11132a.applyAsDouble(obj);
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f11132a;
            }
            return this.f11132a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f11132a.hashCode();
        }
    }

    double e(Object obj);
}
