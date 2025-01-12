package g;

import e.C0232j$f;
import e.C0234j$h;
import e.C0237j$k;
import e.C0239j$m;
import e.C0240j$n;
import e.C0241j$o;
import e.C0242j$p;
import f.InterfaceC0255j$c;
import f.InterfaceC0257j$e;
import f.InterfaceC0259j$g;
import f.InterfaceC0263j$k;
import f.InterfaceC0270j$r;
import f.InterfaceC0274j$v;
import j$.util.function.BiConsumer;
import j$.util.function.ToLongFunction;
import java.util.LinkedHashSet;
/* loaded from: classes2.dex */
public final /* synthetic */ class j$F0 implements InterfaceC0255j$c, f.j$G, InterfaceC0274j$v, ToLongFunction, InterfaceC0257j$e, f.j$V, BiConsumer, InterfaceC0259j$g, InterfaceC0263j$k, f.j$N, f.j$T, InterfaceC0270j$r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f9984a;

    public /* synthetic */ j$F0(int i6) {
        this.f9984a = i6;
    }

    @Override // f.j$N
    public final void b(Object obj, double d6) {
        ((C0232j$f) obj).d(d6);
    }

    @Override // j$.util.function.ToLongFunction
    public final long c(Object obj) {
        int i6 = j$T1.f10091s;
        return 1L;
    }

    @Override // f.InterfaceC0270j$r
    public final int g(int i6, int i7) {
        return Math.min(i6, i7);
    }

    @Override // f.j$V
    public final Object get() {
        switch (this.f9984a) {
            case 14:
                return new C0232j$f();
            case 15:
                return new C0234j$h();
            case 16:
                return new C0237j$k();
            default:
                return new LinkedHashSet();
        }
    }

    @Override // f.InterfaceC0257j$e
    public final void j(Object obj) {
    }

    @Override // f.InterfaceC0259j$g
    public final double k(double d6, double d7) {
        switch (this.f9984a) {
            case 20:
                return Math.min(d6, d7);
            default:
                return Math.max(d6, d7);
        }
    }

    @Override // f.j$T
    public final boolean l(Object obj) {
        switch (this.f9984a) {
            case 25:
                return ((C0240j$n) obj).c();
            case 26:
                return ((C0242j$p) obj).c();
            case 27:
                return ((C0239j$m) obj).c();
            default:
                return ((C0241j$o) obj).c();
        }
    }

    @Override // j$.util.function.BiConsumer
    public final void n(Object obj, Object obj2) {
        switch (this.f9984a) {
            case 18:
                ((LinkedHashSet) obj).add(obj2);
                return;
            case 19:
                ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
                return;
            default:
                ((C0232j$f) obj).b((C0232j$f) obj2);
                return;
        }
    }

    @Override // j$.util.function.BiFunction
    public final Object p(Object obj, Object obj2) {
        switch (this.f9984a) {
            case 0:
                return new j$I0((InterfaceC0370j$x0) obj, (InterfaceC0370j$x0) obj2);
            case 1:
            case 3:
            default:
                return new j$M0((j$B0) obj, (j$B0) obj2);
            case 2:
                return new j$J0((InterfaceC0374j$y0) obj, (InterfaceC0374j$y0) obj2);
            case 4:
                return new j$K0((InterfaceC0378j$z0) obj, (InterfaceC0378j$z0) obj2);
        }
    }

    @Override // f.InterfaceC0274j$v
    public final Object r(int i6) {
        switch (this.f9984a) {
            case 6:
                int i7 = j$T1.f10091s;
                return new Object[i6];
            case 7:
            default:
                int i8 = C0316j$j2.f10184v;
                return new Double[i6];
            case 8:
                return new Object[i6];
            case 9:
                int i9 = C0300j$f2.f10162v;
                return new Integer[i6];
            case 10:
                int i10 = C0308j$h2.f10170v;
                return new Long[i6];
        }
    }

    @Override // f.j$G
    public final Object t(long j6) {
        switch (this.f9984a) {
            case 1:
                return AbstractC0350j$s0.d0(j6);
            default:
                return AbstractC0350j$s0.f0(j6);
        }
    }

    @Override // f.InterfaceC0263j$k
    public final Object u(double d6) {
        return Double.valueOf(d6);
    }
}
