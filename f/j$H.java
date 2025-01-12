package f;

import java.util.function.LongPredicate;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$H {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongPredicate f9702a;

    private /* synthetic */ j$H(LongPredicate longPredicate) {
        this.f9702a = longPredicate;
    }

    public static /* synthetic */ j$H a(LongPredicate longPredicate) {
        if (longPredicate == null) {
            return null;
        }
        return new j$H(longPredicate);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$H) {
            obj = ((j$H) obj).f9702a;
        }
        return this.f9702a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9702a.hashCode();
    }
}
