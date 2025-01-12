package f;

import java.util.function.LongBinaryOperator;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$B implements j$C {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongBinaryOperator f9699a;

    private /* synthetic */ j$B(LongBinaryOperator longBinaryOperator) {
        this.f9699a = longBinaryOperator;
    }

    public static /* synthetic */ j$B a(LongBinaryOperator longBinaryOperator) {
        if (longBinaryOperator == null) {
            return null;
        }
        return new j$B(longBinaryOperator);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$B) {
            obj = ((j$B) obj).f9699a;
        }
        return this.f9699a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9699a.hashCode();
    }

    @Override // f.j$C
    public final /* synthetic */ long k(long j6, long j7) {
        return this.f9699a.applyAsLong(j6, j7);
    }
}
