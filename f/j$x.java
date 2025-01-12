package f;

import java.util.function.IntToDoubleFunction;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$x {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntToDoubleFunction f9727a;

    private /* synthetic */ j$x(IntToDoubleFunction intToDoubleFunction) {
        this.f9727a = intToDoubleFunction;
    }

    public static /* synthetic */ j$x a(IntToDoubleFunction intToDoubleFunction) {
        if (intToDoubleFunction == null) {
            return null;
        }
        return new j$x(intToDoubleFunction);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$x) {
            obj = ((j$x) obj).f9727a;
        }
        return this.f9727a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9727a.hashCode();
    }
}
