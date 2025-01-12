package g;

import f.InterfaceC0255j$c;
import j$.util.function.BiConsumer;
/* renamed from: g.j$p  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0337j$p implements InterfaceC0255j$c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10232a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f10233b;

    public /* synthetic */ C0337j$p(BiConsumer biConsumer, int i6) {
        this.f10232a = i6;
        this.f10233b = biConsumer;
    }

    @Override // j$.util.function.BiFunction
    public final Object p(Object obj, Object obj2) {
        int i6 = this.f10232a;
        BiConsumer biConsumer = this.f10233b;
        switch (i6) {
            case 0:
                biConsumer.n(obj, obj2);
                return obj;
            case 1:
                int i7 = j$Z.f10108s;
                biConsumer.n(obj, obj2);
                return obj;
            default:
                int i8 = AbstractC0306j$h0.f10169s;
                biConsumer.n(obj, obj2);
                return obj;
        }
    }
}
