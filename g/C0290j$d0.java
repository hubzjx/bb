package g;
/* renamed from: g.j$d0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0290j$d0 extends j$W1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10135b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AbstractC0285j$c f10136c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0290j$d0(AbstractC0285j$c abstractC0285j$c, InterfaceC0284j$b2 interfaceC0284j$b2, int i6) {
        super(interfaceC0284j$b2);
        this.f10135b = i6;
        this.f10136c = abstractC0285j$c;
    }

    @Override // g.InterfaceC0284j$b2
    public final void f(long j6) {
        int i6 = this.f10135b;
        AbstractC0285j$c abstractC0285j$c = this.f10136c;
        InterfaceC0284j$b2 interfaceC0284j$b2 = this.f10100a;
        switch (i6) {
            case 0:
                interfaceC0284j$b2.d(j6);
                return;
            case 1:
                interfaceC0284j$b2.f(((f.j$L) ((C0361j$v) abstractC0285j$c).f10289u).f(j6));
                return;
            case 2:
                interfaceC0284j$b2.j(((f.j$G) ((C0353j$t) abstractC0285j$c).f10274u).t(j6));
                return;
            case 3:
                interfaceC0284j$b2.e(((f.j$J) ((C0357j$u) abstractC0285j$c).f10282u).f9704a.applyAsInt(j6));
                return;
            case 4:
                interfaceC0284j$b2.d(((f.j$I) ((C0349j$s) abstractC0285j$c).f10261u).f9703a.applyAsDouble(j6));
                return;
            case 5:
                InterfaceC0314j$j0 interfaceC0314j$j0 = (InterfaceC0314j$j0) ((f.j$G) ((C0361j$v) abstractC0285j$c).f10289u).t(j6);
                if (interfaceC0314j$j0 != null) {
                    try {
                        interfaceC0314j$j0.sequential().c(new C0286j$c0(1, this));
                    } catch (Throwable th) {
                        try {
                            ((AbstractC0285j$c) interfaceC0314j$j0).close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (interfaceC0314j$j0 != null) {
                    ((AbstractC0285j$c) interfaceC0314j$j0).close();
                    return;
                }
                return;
            case 6:
                if (((f.j$H) ((C0361j$v) abstractC0285j$c).f10289u).f9702a.test(j6)) {
                    interfaceC0284j$b2.f(j6);
                    return;
                }
                return;
            default:
                ((f.j$E) ((C0361j$v) abstractC0285j$c).f10289u).f(j6);
                interfaceC0284j$b2.f(j6);
                return;
        }
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        int i6 = this.f10135b;
        InterfaceC0284j$b2 interfaceC0284j$b2 = this.f10100a;
        switch (i6) {
            case 5:
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
}
