package g;

import java.util.stream.Collector;
/* renamed from: g.j$j  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0313j$j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Collector f10182a;

    private /* synthetic */ C0313j$j(Collector collector) {
        this.f10182a = collector;
    }

    public static /* synthetic */ C0313j$j a(Collector collector) {
        if (collector == null) {
            return null;
        }
        return new C0313j$j(collector);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0313j$j) {
            obj = ((C0313j$j) obj).f10182a;
        }
        return this.f10182a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f10182a.hashCode();
    }
}
