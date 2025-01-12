package g;

import f.InterfaceC0257j$e;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
/* loaded from: classes2.dex */
final class j$N1 extends j$X1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10026b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AbstractC0285j$c f10027c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j$N1(AbstractC0285j$c abstractC0285j$c, InterfaceC0284j$b2 interfaceC0284j$b2, int i6) {
        super(interfaceC0284j$b2);
        this.f10026b = i6;
        this.f10027c = abstractC0285j$c;
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        int i6 = this.f10026b;
        InterfaceC0284j$b2 interfaceC0284j$b2 = this.f10102a;
        switch (i6) {
            case 1:
                interfaceC0284j$b2.i(-1L);
                return;
            case 6:
                interfaceC0284j$b2.i(-1L);
                return;
            default:
                interfaceC0284j$b2.i(j6);
                return;
        }
    }

    @Override // f.InterfaceC0257j$e
    public final void j(Object obj) {
        int i6 = this.f10026b;
        InterfaceC0284j$b2 interfaceC0284j$b2 = this.f10102a;
        AbstractC0285j$c abstractC0285j$c = this.f10027c;
        switch (i6) {
            case 0:
                ((InterfaceC0257j$e) ((C0353j$t) abstractC0285j$c).f10274u).j(obj);
                interfaceC0284j$b2.j(obj);
                return;
            case 1:
                if (((f.j$T) ((C0353j$t) abstractC0285j$c).f10274u).l(obj)) {
                    interfaceC0284j$b2.j(obj);
                    return;
                }
                return;
            case 2:
                interfaceC0284j$b2.j(((j$P1) abstractC0285j$c).f10045u.a(obj));
                return;
            case 3:
                interfaceC0284j$b2.e(((ToIntFunction) ((C0357j$u) abstractC0285j$c).f10282u).a(obj));
                return;
            case 4:
                interfaceC0284j$b2.f(((ToLongFunction) ((C0361j$v) abstractC0285j$c).f10289u).c(obj));
                return;
            case 5:
                interfaceC0284j$b2.d(((ToDoubleFunction) ((C0349j$s) abstractC0285j$c).f10261u).e(obj));
                return;
            default:
                j$M2 j_m2 = (j$M2) ((j$P1) abstractC0285j$c).f10045u.a(obj);
                if (j_m2 != null) {
                    try {
                        AbstractC0285j$c abstractC0285j$c2 = (AbstractC0285j$c) j_m2;
                        abstractC0285j$c2.J0();
                        ((j$M2) abstractC0285j$c2).b(interfaceC0284j$b2);
                    } catch (Throwable th) {
                        try {
                            ((AbstractC0285j$c) j_m2).close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (j_m2 != null) {
                    ((AbstractC0285j$c) j_m2).close();
                    return;
                }
                return;
        }
    }
}
