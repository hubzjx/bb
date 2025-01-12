package g;

import f.C0264j$l;
import f.C0265j$m;
import f.C0268j$p;
import f.InterfaceC0261j$i;
import f.InterfaceC0263j$k;
import f.InterfaceC0267j$o;
/* renamed from: g.j$r  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0345j$r extends j$U1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10252b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AbstractC0285j$c f10253c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0345j$r(AbstractC0285j$c abstractC0285j$c, InterfaceC0284j$b2 interfaceC0284j$b2, int i6) {
        super(interfaceC0284j$b2);
        this.f10252b = i6;
        this.f10253c = abstractC0285j$c;
    }

    @Override // g.InterfaceC0284j$b2
    public final void d(double d6) {
        int i6 = this.f10252b;
        InterfaceC0284j$b2 interfaceC0284j$b2 = this.f10094a;
        AbstractC0285j$c abstractC0285j$c = this.f10253c;
        switch (i6) {
            case 0:
                interfaceC0284j$b2.d(((C0268j$p) ((C0349j$s) abstractC0285j$c).f10261u).f9722a.applyAsDouble(d6));
                return;
            case 1:
                interfaceC0284j$b2.j(((InterfaceC0263j$k) ((C0353j$t) abstractC0285j$c).f10274u).u(d6));
                return;
            case 2:
                interfaceC0284j$b2.e(((C0265j$m) ((C0357j$u) abstractC0285j$c).f10282u).f9720a.applyAsInt(d6));
                return;
            case 3:
                interfaceC0284j$b2.f(((InterfaceC0267j$o) ((C0361j$v) abstractC0285j$c).f10289u).d(d6));
                return;
            case 4:
                j$C j_c = (j$C) ((InterfaceC0263j$k) ((C0349j$s) abstractC0285j$c).f10261u).u(d6);
                if (j_c != null) {
                    try {
                        j_c.sequential().d(new C0341j$q(1, this));
                    } catch (Throwable th) {
                        try {
                            ((AbstractC0285j$c) j_c).close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (j_c != null) {
                    ((AbstractC0285j$c) j_c).close();
                    return;
                }
                return;
            case 5:
                if (((C0264j$l) ((C0349j$s) abstractC0285j$c).f10261u).f9719a.test(d6)) {
                    interfaceC0284j$b2.d(d6);
                    return;
                }
                return;
            default:
                ((InterfaceC0261j$i) ((C0349j$s) abstractC0285j$c).f10261u).d(d6);
                interfaceC0284j$b2.d(d6);
                return;
        }
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        int i6 = this.f10252b;
        InterfaceC0284j$b2 interfaceC0284j$b2 = this.f10094a;
        switch (i6) {
            case 4:
                interfaceC0284j$b2.i(-1L);
                return;
            case 5:
                interfaceC0284j$b2.i(-1L);
                return;
            default:
                interfaceC0284j$b2.i(j6);
                return;
        }
    }
}
