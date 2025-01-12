package f;

import java.util.function.IntUnaryOperator;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$A {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntUnaryOperator f9698a;

    private /* synthetic */ j$A(IntUnaryOperator intUnaryOperator) {
        this.f9698a = intUnaryOperator;
    }

    public static /* synthetic */ j$A a(IntUnaryOperator intUnaryOperator) {
        if (intUnaryOperator == null) {
            return null;
        }
        return new j$A(intUnaryOperator);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$A) {
            obj = ((j$A) obj).f9698a;
        }
        return this.f9698a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9698a.hashCode();
    }
}
