package f;

import java.util.function.LongConsumer;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$D implements j$E {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongConsumer f9700a;

    private /* synthetic */ j$D(LongConsumer longConsumer) {
        this.f9700a = longConsumer;
    }

    public static /* synthetic */ j$D b(LongConsumer longConsumer) {
        if (longConsumer == null) {
            return null;
        }
        return new j$D(longConsumer);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$D) {
            obj = ((j$D) obj).f9700a;
        }
        return this.f9700a.equals(obj);
    }

    @Override // f.j$E
    public final /* synthetic */ void f(long j6) {
        this.f9700a.accept(j6);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9700a.hashCode();
    }
}
