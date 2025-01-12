package f;

import java.util.function.LongFunction;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$F implements j$G {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongFunction f9701a;

    private /* synthetic */ j$F(LongFunction longFunction) {
        this.f9701a = longFunction;
    }

    public static /* synthetic */ j$F a(LongFunction longFunction) {
        if (longFunction == null) {
            return null;
        }
        return new j$F(longFunction);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$F) {
            obj = ((j$F) obj).f9701a;
        }
        return this.f9701a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9701a.hashCode();
    }

    @Override // f.j$G
    public final /* synthetic */ Object t(long j6) {
        return this.f9701a.apply(j6);
    }
}
