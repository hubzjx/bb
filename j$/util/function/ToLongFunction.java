package j$.util.function;
/* loaded from: classes2.dex */
public interface ToLongFunction {

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements ToLongFunction {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.ToLongFunction f11134a;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToLongFunction toLongFunction) {
            this.f11134a = toLongFunction;
        }

        public static /* synthetic */ ToLongFunction convert(java.util.function.ToLongFunction toLongFunction) {
            if (toLongFunction == null) {
                return null;
            }
            return new VivifiedWrapper(toLongFunction);
        }

        @Override // j$.util.function.ToLongFunction
        public final /* synthetic */ long c(Object obj) {
            return this.f11134a.applyAsLong(obj);
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f11134a;
            }
            return this.f11134a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f11134a.hashCode();
        }
    }

    long c(Object obj);
}
