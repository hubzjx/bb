package f;

import java.util.function.DoubleToIntFunction;
/* renamed from: f.j$m  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0265j$m {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleToIntFunction f9720a;

    private /* synthetic */ C0265j$m(DoubleToIntFunction doubleToIntFunction) {
        this.f9720a = doubleToIntFunction;
    }

    public static /* synthetic */ C0265j$m a(DoubleToIntFunction doubleToIntFunction) {
        if (doubleToIntFunction == null) {
            return null;
        }
        return new C0265j$m(doubleToIntFunction);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0265j$m) {
            obj = ((C0265j$m) obj).f9720a;
        }
        return this.f9720a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9720a.hashCode();
    }
}
