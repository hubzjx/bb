package f;

import java.util.function.IntPredicate;
/* renamed from: f.j$w  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0275j$w {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntPredicate f9726a;

    private /* synthetic */ C0275j$w(IntPredicate intPredicate) {
        this.f9726a = intPredicate;
    }

    public static /* synthetic */ C0275j$w a(IntPredicate intPredicate) {
        if (intPredicate == null) {
            return null;
        }
        return new C0275j$w(intPredicate);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0275j$w) {
            obj = ((C0275j$w) obj).f9726a;
        }
        return this.f9726a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9726a.hashCode();
    }
}
