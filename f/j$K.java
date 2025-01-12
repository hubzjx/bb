package f;

import java.util.function.LongUnaryOperator;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$K implements j$L {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongUnaryOperator f9705a;

    private /* synthetic */ j$K(LongUnaryOperator longUnaryOperator) {
        this.f9705a = longUnaryOperator;
    }

    public static /* synthetic */ j$K a(LongUnaryOperator longUnaryOperator) {
        if (longUnaryOperator == null) {
            return null;
        }
        return new j$K(longUnaryOperator);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$K) {
            obj = ((j$K) obj).f9705a;
        }
        return this.f9705a.equals(obj);
    }

    @Override // f.j$L
    public final /* synthetic */ long f(long j6) {
        return this.f9705a.applyAsLong(j6);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9705a.hashCode();
    }
}
