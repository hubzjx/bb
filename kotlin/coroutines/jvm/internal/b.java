package kotlin.coroutines.jvm.internal;
/* loaded from: classes.dex */
public final class b implements j4.a {

    /* renamed from: a  reason: collision with root package name */
    public static final b f11304a = new b();

    private b() {
    }

    @Override // j4.a
    public j4.c getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // j4.a
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
