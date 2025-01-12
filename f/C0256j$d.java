package f;

import java.util.function.Consumer;
/* renamed from: f.j$d  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0256j$d implements InterfaceC0257j$e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f9715a;

    private /* synthetic */ C0256j$d(Consumer consumer) {
        this.f9715a = consumer;
    }

    public static /* synthetic */ C0256j$d b(Consumer consumer) {
        if (consumer == null) {
            return null;
        }
        return new C0256j$d(consumer);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0256j$d) {
            obj = ((C0256j$d) obj).f9715a;
        }
        return this.f9715a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9715a.hashCode();
    }

    @Override // f.InterfaceC0257j$e
    public final /* synthetic */ void j(Object obj) {
        this.f9715a.accept(obj);
    }
}
