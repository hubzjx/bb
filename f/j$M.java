package f;

import java.util.function.ObjDoubleConsumer;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$M implements j$N {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ObjDoubleConsumer f9706a;

    private /* synthetic */ j$M(ObjDoubleConsumer objDoubleConsumer) {
        this.f9706a = objDoubleConsumer;
    }

    public static /* synthetic */ j$M a(ObjDoubleConsumer objDoubleConsumer) {
        if (objDoubleConsumer == null) {
            return null;
        }
        return new j$M(objDoubleConsumer);
    }

    @Override // f.j$N
    public final /* synthetic */ void b(Object obj, double d6) {
        this.f9706a.accept(obj, d6);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$M) {
            obj = ((j$M) obj).f9706a;
        }
        return this.f9706a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9706a.hashCode();
    }
}
