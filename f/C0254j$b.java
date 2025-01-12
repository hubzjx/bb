package f;

import java.util.function.BinaryOperator;
/* renamed from: f.j$b  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0254j$b implements InterfaceC0255j$c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f9714a;

    private /* synthetic */ C0254j$b(BinaryOperator binaryOperator) {
        this.f9714a = binaryOperator;
    }

    public static /* synthetic */ C0254j$b a(BinaryOperator binaryOperator) {
        if (binaryOperator == null) {
            return null;
        }
        return new C0254j$b(binaryOperator);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0254j$b) {
            obj = ((C0254j$b) obj).f9714a;
        }
        return this.f9714a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9714a.hashCode();
    }

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ Object p(Object obj, Object obj2) {
        return this.f9714a.apply(obj, obj2);
    }
}
