package g;

import f.InterfaceC0261j$i;
import f.InterfaceC0272j$t;
import j$.util.function.Function;
import java.util.HashSet;
import java.util.Set;
/* renamed from: g.j$n  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0329j$n extends j$X1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10216b = 0;

    /* renamed from: c  reason: collision with root package name */
    Object f10217c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AbstractC0285j$c f10218d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0329j$n(C0333j$o c0333j$o, InterfaceC0284j$b2 interfaceC0284j$b2) {
        super(interfaceC0284j$b2);
        this.f10218d = c0333j$o;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0329j$n(C0349j$s c0349j$s, InterfaceC0284j$b2 interfaceC0284j$b2) {
        super(interfaceC0284j$b2);
        this.f10218d = c0349j$s;
        this.f10217c = new C0341j$q(0, interfaceC0284j$b2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0329j$n(C0357j$u c0357j$u, InterfaceC0284j$b2 interfaceC0284j$b2) {
        super(interfaceC0284j$b2);
        this.f10218d = c0357j$u;
        this.f10217c = new j$R(0, interfaceC0284j$b2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0329j$n(C0361j$v c0361j$v, InterfaceC0284j$b2 interfaceC0284j$b2) {
        super(interfaceC0284j$b2);
        this.f10218d = c0361j$v;
        this.f10217c = new C0286j$c0(0, interfaceC0284j$b2);
    }

    @Override // g.j$X1, g.InterfaceC0284j$b2
    public final void h() {
        switch (this.f10216b) {
            case 0:
                this.f10217c = null;
                this.f10102a.h();
                return;
            default:
                super.h();
                return;
        }
    }

    @Override // g.InterfaceC0284j$b2
    public final void i(long j6) {
        int i6 = this.f10216b;
        InterfaceC0284j$b2 interfaceC0284j$b2 = this.f10102a;
        switch (i6) {
            case 0:
                this.f10217c = new HashSet();
                interfaceC0284j$b2.i(-1L);
                return;
            case 1:
                interfaceC0284j$b2.i(-1L);
                return;
            case 2:
                interfaceC0284j$b2.i(-1L);
                return;
            default:
                interfaceC0284j$b2.i(-1L);
                return;
        }
    }

    @Override // f.InterfaceC0257j$e
    public final void j(Object obj) {
        int i6 = this.f10216b;
        AbstractC0285j$c abstractC0285j$c = this.f10218d;
        switch (i6) {
            case 0:
                if (((Set) this.f10217c).contains(obj)) {
                    return;
                }
                ((Set) this.f10217c).add(obj);
                this.f10102a.j(obj);
                return;
            case 1:
                InterfaceC0314j$j0 interfaceC0314j$j0 = (InterfaceC0314j$j0) ((Function) ((C0361j$v) abstractC0285j$c).f10289u).a(obj);
                if (interfaceC0314j$j0 != null) {
                    try {
                        interfaceC0314j$j0.sequential().c((f.j$E) this.f10217c);
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
            case 2:
                InterfaceC0282j$b0 interfaceC0282j$b0 = (InterfaceC0282j$b0) ((Function) ((C0357j$u) abstractC0285j$c).f10282u).a(obj);
                if (interfaceC0282j$b0 != null) {
                    try {
                        interfaceC0282j$b0.sequential().i((InterfaceC0272j$t) this.f10217c);
                    } catch (Throwable th3) {
                        try {
                            ((AbstractC0285j$c) interfaceC0282j$b0).close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                }
                if (interfaceC0282j$b0 != null) {
                    ((AbstractC0285j$c) interfaceC0282j$b0).close();
                    return;
                }
                return;
            default:
                j$C j_c = (j$C) ((Function) ((C0349j$s) abstractC0285j$c).f10261u).a(obj);
                if (j_c != null) {
                    try {
                        j_c.sequential().d((InterfaceC0261j$i) this.f10217c);
                    } catch (Throwable th5) {
                        try {
                            ((AbstractC0285j$c) j_c).close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
                if (j_c != null) {
                    ((AbstractC0285j$c) j_c).close();
                    return;
                }
                return;
        }
    }
}
