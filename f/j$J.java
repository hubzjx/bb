package f;

import java.util.function.LongToIntFunction;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$J {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongToIntFunction f9704a;

    private /* synthetic */ j$J(LongToIntFunction longToIntFunction) {
        this.f9704a = longToIntFunction;
    }

    public static /* synthetic */ j$J a(LongToIntFunction longToIntFunction) {
        if (longToIntFunction == null) {
            return null;
        }
        return new j$J(longToIntFunction);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$J) {
            obj = ((j$J) obj).f9704a;
        }
        return this.f9704a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9704a.hashCode();
    }
}
