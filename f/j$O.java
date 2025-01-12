package f;

import java.util.function.ObjIntConsumer;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$O implements j$P {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ObjIntConsumer f9707a;

    private /* synthetic */ j$O(ObjIntConsumer objIntConsumer) {
        this.f9707a = objIntConsumer;
    }

    public static /* synthetic */ j$O a(ObjIntConsumer objIntConsumer) {
        if (objIntConsumer == null) {
            return null;
        }
        return new j$O(objIntConsumer);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof j$O) {
            obj = ((j$O) obj).f9707a;
        }
        return this.f9707a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9707a.hashCode();
    }

    @Override // f.j$P
    public final /* synthetic */ void p(int i6, Object obj) {
        this.f9707a.accept(obj, i6);
    }
}
