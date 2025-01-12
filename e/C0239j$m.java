package e;

import java.util.NoSuchElementException;
/* renamed from: e.j$m  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0239j$m {

    /* renamed from: b  reason: collision with root package name */
    private static final C0239j$m f9304b = new C0239j$m();

    /* renamed from: a  reason: collision with root package name */
    private final Object f9305a;

    private C0239j$m() {
        this.f9305a = null;
    }

    private C0239j$m(Object obj) {
        obj.getClass();
        this.f9305a = obj;
    }

    public static C0239j$m a() {
        return f9304b;
    }

    public static C0239j$m d(Object obj) {
        return new C0239j$m(obj);
    }

    public final Object b() {
        Object obj = this.f9305a;
        if (obj != null) {
            return obj;
        }
        throw new NoSuchElementException("No value present");
    }

    public final boolean c() {
        return this.f9305a != null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0239j$m) {
            return AbstractC0227j$a.x(this.f9305a, ((C0239j$m) obj).f9305a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f9305a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        Object obj = this.f9305a;
        return obj != null ? String.format("Optional[%s]", obj) : "Optional.empty";
    }
}
