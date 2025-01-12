package g;

import f.C0275j$w;
import f.InterfaceC0272j$t;
import f.InterfaceC0274j$v;
/* loaded from: classes2.dex */
final class j$T extends j$V1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10089b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AbstractC0285j$c f10090c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j$T(AbstractC0285j$c abstractC0285j$c, InterfaceC0284j$b2 interfaceC0284j$b2, int i6) {
        super(interfaceC0284j$b2);
        this.f10089b = i6;
        this.f10090c = abstractC0285j$c;
    }

    @Override // g.InterfaceC0284j$b2
    public final void e(int i6) {
        int i7 = this.f10089b;
        AbstractC0285j$c abstractC0285j$c = this.f10090c;
        InterfaceC0284j$b2 interfaceC0284j$b2 = this.f10096a;
        switch (i7) {
            case 0:
                interfaceC0284j$b2.f(i6);
                return;
            case 1:
                ((InterfaceC0272j$t) ((C0357j$u) abstractC0285j$c).f10282u).e(i6);
                interfaceC0284j$b2.e(i6);
                return;
            case 2:
                interfaceC0284j$b2.d(i6);
                return;
            case 3:
                interfaceC0284j$b2.e(((f.j$A) ((C0357j$u) abstractC0285j$c).f10282u).f9698a.applyAsInt(i6));
                return;
            case 4:
                interfaceC0284j$b2.j(((InterfaceC0274j$v) ((C0353j$t) abstractC0285j$c).f10274u).r(i6));
                return;
            case 5:
                interfaceC0284j$b2.f(((f.j$z) ((C0361j$v) abstractC0285j$c).f10289u).h(i6));
                return;
            case 6:
                interfaceC0284j$b2.d(((f.j$x) ((C0349j$s) abstractC0285j$c).f10261u).f9727a.applyAsDouble(i6));
                return;
            case 7:
                InterfaceC0282j$b0 interfaceC0282j$b0 = (InterfaceC0282j$b0) ((InterfaceC0274j$v) ((C0357j$u) abstractC0285j$c).f10282u).r(i6);
                if (interfaceC0282j$b0 != null) {
                    try {
                        interfaceC0282j$b0.sequential().i(new j$R(1, this));
                    } catch (Throwable th) {
                        try {
                            ((AbstractC0285j$c) interfaceC0282j$b0).close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (interfaceC0282j$b0 != null) {
                    ((AbstractC0285j$c) interfaceC0282j$b0).close();
                    return;
                }
                return;
            default:
                if (((C0275j$w) ((C0357j$u) abstractC0285j$c).f10282u).f9726a.test(i6)) {
                    interfaceC0284j$b2.e(i6);
                    return;
                }
                return;
        }
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        int i6 = this.f10089b;
        InterfaceC0284j$b2 interfaceC0284j$b2 = this.f10096a;
        switch (i6) {
            case 7:
                interfaceC0284j$b2.i(-1L);
                return;
            case 8:
                interfaceC0284j$b2.i(-1L);
                return;
            default:
                interfaceC0284j$b2.i(j6);
                return;
        }
    }
}
