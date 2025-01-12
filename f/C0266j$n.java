package f;

import java.util.function.DoubleToLongFunction;
/* renamed from: f.j$n  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0266j$n implements InterfaceC0267j$o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleToLongFunction f9721a;

    private /* synthetic */ C0266j$n(DoubleToLongFunction doubleToLongFunction) {
        this.f9721a = doubleToLongFunction;
    }

    public static /* synthetic */ C0266j$n a(DoubleToLongFunction doubleToLongFunction) {
        if (doubleToLongFunction == null) {
            return null;
        }
        return new C0266j$n(doubleToLongFunction);
    }

    @Override // f.InterfaceC0267j$o
    public final /* synthetic */ long d(double d6) {
        return this.f9721a.applyAsLong(d6);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0266j$n) {
            obj = ((C0266j$n) obj).f9721a;
        }
        return this.f9721a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9721a.hashCode();
    }
}
