package g;

import f.InterfaceC0255j$c;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$r1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0347j$r1 extends AbstractC0350j$s0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10255h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Object f10256i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Object f10257j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Object f10258k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0347j$r1(int i6, Object obj, Object obj2, Object obj3, int i7) {
        super(i6);
        this.f10255h = i7;
        this.f10256i = obj;
        this.f10258k = obj2;
        this.f10257j = obj3;
    }

    @Override // g.AbstractC0350j$s0
    public final j$K1 q0() {
        int i6 = this.f10255h;
        Object obj = this.f10256i;
        Object obj2 = this.f10258k;
        Object obj3 = this.f10257j;
        switch (i6) {
            case 0:
                return new C0351j$s1((f.j$V) obj3, (f.j$R) obj2, (InterfaceC0255j$c) obj);
            case 1:
                return new C0371j$x1((f.j$V) obj3, (f.j$N) obj2, (InterfaceC0255j$c) obj);
            case 2:
                return new C0375j$y1(obj3, (BiFunction) obj2, (InterfaceC0255j$c) obj);
            case 3:
                return new j$C1((f.j$V) obj3, (BiConsumer) obj2, (BiConsumer) obj);
            default:
                return new j$G1((f.j$V) obj3, (f.j$P) obj2, (InterfaceC0255j$c) obj);
        }
    }
}
