package g;

import e.C0234j$h;
import e.C0237j$k;
import f.InterfaceC0257j$e;
import f.InterfaceC0270j$r;
import f.InterfaceC0274j$v;
import j$.util.function.BiConsumer;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$S implements f.j$P, BiConsumer, InterfaceC0274j$v, InterfaceC0270j$r, f.j$C, f.j$G, f.j$R, InterfaceC0257j$e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10087a;

    public /* synthetic */ j$S(int i6) {
        this.f10087a = i6;
    }

    @Override // f.InterfaceC0270j$r
    public final int g(int i6, int i7) {
        return Math.max(i6, i7);
    }

    @Override // f.InterfaceC0257j$e
    public final void j(Object obj) {
    }

    @Override // f.j$C
    public final long k(long j6, long j7) {
        switch (this.f10087a) {
            case 4:
                return Math.min(j6, j7);
            default:
                return Math.max(j6, j7);
        }
    }

    @Override // f.j$R
    public final void l(Object obj, long j6) {
        ((C0237j$k) obj).f(j6);
    }

    @Override // j$.util.function.BiConsumer
    public final void n(Object obj, Object obj2) {
        switch (this.f10087a) {
            case 1:
                ((C0234j$h) obj).b((C0234j$h) obj2);
                return;
            default:
                ((C0237j$k) obj).b((C0237j$k) obj2);
                return;
        }
    }

    @Override // f.j$P
    public final void p(int i6, Object obj) {
        ((C0234j$h) obj).e(i6);
    }

    @Override // f.InterfaceC0274j$v
    public final Object r(int i6) {
        return Integer.valueOf(i6);
    }

    @Override // f.j$G
    public final Object t(long j6) {
        return Long.valueOf(j6);
    }
}
