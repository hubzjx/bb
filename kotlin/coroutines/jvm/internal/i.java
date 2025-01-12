package kotlin.coroutines.jvm.internal;
/* loaded from: classes.dex */
public abstract class i extends a {
    public i(j4.a aVar) {
        super(aVar);
        if (aVar != null) {
            if (!(aVar.getContext() == j4.d.INSTANCE)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.a, j4.a
    public j4.c getContext() {
        return j4.d.INSTANCE;
    }
}
