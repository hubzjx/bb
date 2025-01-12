package f;

import java.util.function.DoublePredicate;
/* renamed from: f.j$l  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0264j$l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoublePredicate f9719a;

    private /* synthetic */ C0264j$l(DoublePredicate doublePredicate) {
        this.f9719a = doublePredicate;
    }

    public static /* synthetic */ C0264j$l a(DoublePredicate doublePredicate) {
        if (doublePredicate == null) {
            return null;
        }
        return new C0264j$l(doublePredicate);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0264j$l) {
            obj = ((C0264j$l) obj).f9719a;
        }
        return this.f9719a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9719a.hashCode();
    }
}
