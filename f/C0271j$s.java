package f;

import java.util.function.IntConsumer;
/* renamed from: f.j$s  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0271j$s implements InterfaceC0272j$t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntConsumer f9724a;

    private /* synthetic */ C0271j$s(IntConsumer intConsumer) {
        this.f9724a = intConsumer;
    }

    public static /* synthetic */ C0271j$s b(IntConsumer intConsumer) {
        if (intConsumer == null) {
            return null;
        }
        return new C0271j$s(intConsumer);
    }

    @Override // f.InterfaceC0272j$t
    public final /* synthetic */ void e(int i6) {
        this.f9724a.accept(i6);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0271j$s) {
            obj = ((C0271j$s) obj).f9724a;
        }
        return this.f9724a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9724a.hashCode();
    }
}
