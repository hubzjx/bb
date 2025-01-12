package j$.util.function;
/* loaded from: classes2.dex */
public interface ToIntFunction {

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements ToIntFunction {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.ToIntFunction f11133a;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToIntFunction toIntFunction) {
            this.f11133a = toIntFunction;
        }

        public static /* synthetic */ ToIntFunction convert(java.util.function.ToIntFunction toIntFunction) {
            if (toIntFunction == null) {
                return null;
            }
            return new VivifiedWrapper(toIntFunction);
        }

        @Override // j$.util.function.ToIntFunction
        public final /* synthetic */ int a(Object obj) {
            return this.f11133a.applyAsInt(obj);
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f11133a;
            }
            return this.f11133a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f11133a.hashCode();
        }
    }

    int a(Object obj);
}
