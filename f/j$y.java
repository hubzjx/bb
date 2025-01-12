package f;

import java.util.function.IntToLongFunction;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$y implements j$z {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntToLongFunction f9728a;

    private /* synthetic */ j$y(IntToLongFunction intToLongFunction) {
        this.f9728a = intToLongFunction;
    }

    public static /* synthetic */ j$y a(IntToLongFunction intToLongFunction) {
        if (intToLongFunction == null) {
            return null;
        }
        return new j$y(intToLongFunction);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$y) {
            obj = ((j$y) obj).f9728a;
        }
        return this.f9728a.equals(obj);
    }

    @Override // f.j$z
    public final /* synthetic */ long h(int i6) {
        return this.f9728a.applyAsLong(i6);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9728a.hashCode();
    }
}
