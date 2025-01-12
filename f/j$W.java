package f;

import j$.util.function.Function;
import java.util.function.UnaryOperator;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$W implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnaryOperator f9711a;

    private /* synthetic */ j$W(UnaryOperator unaryOperator) {
        this.f9711a = unaryOperator;
    }

    public static /* synthetic */ j$W b(UnaryOperator unaryOperator) {
        if (unaryOperator == null) {
            return null;
        }
        return new j$W(unaryOperator);
    }

    @Override // j$.util.function.Function
    public final /* synthetic */ Object a(Object obj) {
        return this.f9711a.apply(obj);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$W) {
            obj = ((j$W) obj).f9711a;
        }
        return this.f9711a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9711a.hashCode();
    }
}
