package j$.util.function;
/* loaded from: classes2.dex */
public interface BiConsumer {

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements BiConsumer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.function.BiConsumer f11129a;

        private /* synthetic */ VivifiedWrapper(java.util.function.BiConsumer biConsumer) {
            this.f11129a = biConsumer;
        }

        public static /* synthetic */ BiConsumer convert(java.util.function.BiConsumer biConsumer) {
            if (biConsumer == null) {
                return null;
            }
            return new VivifiedWrapper(biConsumer);
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f11129a;
            }
            return this.f11129a.equals(obj);
        }

        public final /* synthetic */ int hashCode() {
            return this.f11129a.hashCode();
        }

        @Override // j$.util.function.BiConsumer
        public final /* synthetic */ void n(Object obj, Object obj2) {
            this.f11129a.accept(obj, obj2);
        }
    }

    void n(Object obj, Object obj2);
}
