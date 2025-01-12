package f;

import java.util.function.DoubleConsumer;
/* renamed from: f.j$h  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0260j$h implements InterfaceC0261j$i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleConsumer f9717a;

    private /* synthetic */ C0260j$h(DoubleConsumer doubleConsumer) {
        this.f9717a = doubleConsumer;
    }

    public static /* synthetic */ C0260j$h b(DoubleConsumer doubleConsumer) {
        if (doubleConsumer == null) {
            return null;
        }
        return new C0260j$h(doubleConsumer);
    }

    @Override // f.InterfaceC0261j$i
    public final /* synthetic */ void d(double d6) {
        this.f9717a.accept(d6);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0260j$h) {
            obj = ((C0260j$h) obj).f9717a;
        }
        return this.f9717a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9717a.hashCode();
    }
}
