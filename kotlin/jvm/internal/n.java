package kotlin.jvm.internal;
/* loaded from: classes.dex */
public final class n implements d {

    /* renamed from: a  reason: collision with root package name */
    private final Class f11321a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11322b;

    public n(Class cls, String str) {
        l.d(cls, "jClass");
        l.d(str, "moduleName");
        this.f11321a = cls;
        this.f11322b = str;
    }

    @Override // kotlin.jvm.internal.d
    public Class b() {
        return this.f11321a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof n) && l.a(b(), ((n) obj).b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
