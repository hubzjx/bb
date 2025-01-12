package f;

import java.util.function.Predicate;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$S implements j$T {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f9709a;

    private /* synthetic */ j$S(Predicate predicate) {
        this.f9709a = predicate;
    }

    public static /* synthetic */ j$S a(Predicate predicate) {
        if (predicate == null) {
            return null;
        }
        return new j$S(predicate);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$S) {
            obj = ((j$S) obj).f9709a;
        }
        return this.f9709a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9709a.hashCode();
    }

    @Override // f.j$T
    public final /* synthetic */ boolean l(Object obj) {
        return this.f9709a.test(obj);
    }
}
