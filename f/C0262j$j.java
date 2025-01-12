package f;

import java.util.function.DoubleFunction;
/* renamed from: f.j$j  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0262j$j implements InterfaceC0263j$k {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleFunction f9718a;

    private /* synthetic */ C0262j$j(DoubleFunction doubleFunction) {
        this.f9718a = doubleFunction;
    }

    public static /* synthetic */ C0262j$j a(DoubleFunction doubleFunction) {
        if (doubleFunction == null) {
            return null;
        }
        return new C0262j$j(doubleFunction);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0262j$j) {
            obj = ((C0262j$j) obj).f9718a;
        }
        return this.f9718a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9718a.hashCode();
    }

    @Override // f.InterfaceC0263j$k
    public final /* synthetic */ Object u(double d6) {
        return this.f9718a.apply(d6);
    }
}
