package f;

import java.util.function.Supplier;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$U implements j$V {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Supplier f9710a;

    private /* synthetic */ j$U(Supplier supplier) {
        this.f9710a = supplier;
    }

    public static /* synthetic */ j$U a(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        return new j$U(supplier);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$U) {
            obj = ((j$U) obj).f9710a;
        }
        return this.f9710a.equals(obj);
    }

    @Override // f.j$V
    public final /* synthetic */ Object get() {
        return this.f9710a.get();
    }

    public final /* synthetic */ int hashCode() {
        return this.f9710a.hashCode();
    }
}
