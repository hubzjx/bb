package f;

import java.util.function.DoubleBinaryOperator;
/* renamed from: f.j$f  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0258j$f implements InterfaceC0259j$g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleBinaryOperator f9716a;

    private /* synthetic */ C0258j$f(DoubleBinaryOperator doubleBinaryOperator) {
        this.f9716a = doubleBinaryOperator;
    }

    public static /* synthetic */ C0258j$f a(DoubleBinaryOperator doubleBinaryOperator) {
        if (doubleBinaryOperator == null) {
            return null;
        }
        return new C0258j$f(doubleBinaryOperator);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0258j$f) {
            obj = ((C0258j$f) obj).f9716a;
        }
        return this.f9716a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9716a.hashCode();
    }

    @Override // f.InterfaceC0259j$g
    public final /* synthetic */ double k(double d6, double d7) {
        return this.f9716a.applyAsDouble(d6, d7);
    }
}
