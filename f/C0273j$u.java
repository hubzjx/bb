package f;

import java.util.function.IntFunction;
/* renamed from: f.j$u  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0273j$u implements InterfaceC0274j$v {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntFunction f9725a;

    private /* synthetic */ C0273j$u(IntFunction intFunction) {
        this.f9725a = intFunction;
    }

    public static /* synthetic */ C0273j$u a(IntFunction intFunction) {
        if (intFunction == null) {
            return null;
        }
        return new C0273j$u(intFunction);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0273j$u) {
            obj = ((C0273j$u) obj).f9725a;
        }
        return this.f9725a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9725a.hashCode();
    }

    @Override // f.InterfaceC0274j$v
    public final /* synthetic */ Object r(int i6) {
        return this.f9725a.apply(i6);
    }
}
