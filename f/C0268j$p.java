package f;

import java.util.function.DoubleUnaryOperator;
/* renamed from: f.j$p  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0268j$p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleUnaryOperator f9722a;

    private /* synthetic */ C0268j$p(DoubleUnaryOperator doubleUnaryOperator) {
        this.f9722a = doubleUnaryOperator;
    }

    public static /* synthetic */ C0268j$p a(DoubleUnaryOperator doubleUnaryOperator) {
        if (doubleUnaryOperator == null) {
            return null;
        }
        return new C0268j$p(doubleUnaryOperator);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0268j$p) {
            obj = ((C0268j$p) obj).f9722a;
        }
        return this.f9722a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9722a.hashCode();
    }
}
