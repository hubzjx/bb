package f;

import java.util.function.LongToDoubleFunction;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$I {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongToDoubleFunction f9703a;

    private /* synthetic */ j$I(LongToDoubleFunction longToDoubleFunction) {
        this.f9703a = longToDoubleFunction;
    }

    public static /* synthetic */ j$I a(LongToDoubleFunction longToDoubleFunction) {
        if (longToDoubleFunction == null) {
            return null;
        }
        return new j$I(longToDoubleFunction);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$I) {
            obj = ((j$I) obj).f9703a;
        }
        return this.f9703a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9703a.hashCode();
    }
}
