package f;

import java.util.function.IntBinaryOperator;
/* renamed from: f.j$q  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0269j$q implements InterfaceC0270j$r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntBinaryOperator f9723a;

    private /* synthetic */ C0269j$q(IntBinaryOperator intBinaryOperator) {
        this.f9723a = intBinaryOperator;
    }

    public static /* synthetic */ C0269j$q a(IntBinaryOperator intBinaryOperator) {
        if (intBinaryOperator == null) {
            return null;
        }
        return new C0269j$q(intBinaryOperator);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0269j$q) {
            obj = ((C0269j$q) obj).f9723a;
        }
        return this.f9723a.equals(obj);
    }

    @Override // f.InterfaceC0270j$r
    public final /* synthetic */ int g(int i6, int i7) {
        return this.f9723a.applyAsInt(i6, i7);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9723a.hashCode();
    }
}
