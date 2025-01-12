package f;

import java.util.function.ObjLongConsumer;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$Q implements j$R {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ObjLongConsumer f9708a;

    private /* synthetic */ j$Q(ObjLongConsumer objLongConsumer) {
        this.f9708a = objLongConsumer;
    }

    public static /* synthetic */ j$Q a(ObjLongConsumer objLongConsumer) {
        if (objLongConsumer == null) {
            return null;
        }
        return new j$Q(objLongConsumer);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$Q) {
            obj = ((j$Q) obj).f9708a;
        }
        return this.f9708a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9708a.hashCode();
    }

    @Override // f.j$R
    public final /* synthetic */ void l(Object obj, long j6) {
        this.f9708a.accept(obj, j6);
    }
}
