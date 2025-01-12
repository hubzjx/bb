package g;

import e.C0240j$n;
import f.C0260j$h;
import f.InterfaceC0259j$g;
import f.InterfaceC0261j$i;
import f.InterfaceC0274j$v;
import j$.util.function.BiConsumer;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class j$A extends AbstractC0285j$c implements j$C {

    /* renamed from: s  reason: collision with root package name */
    public static final /* synthetic */ int f9946s = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$A(e.j$J j_j, int i6) {
        super(j_j, i6, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$A(AbstractC0285j$c abstractC0285j$c, int i6) {
        super(abstractC0285j$c, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static e.j$B P0(e.j$J j_j) {
        if (j_j instanceof e.j$B) {
            return (e.j$B) j_j;
        }
        if (j$A3.f9953a) {
            j$A3.a(AbstractC0285j$c.class, "using DoubleStream.adapt(Spliterator<Double> s)");
            throw null;
        }
        throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    @Override // g.AbstractC0285j$c
    final e.j$J M0(AbstractC0350j$s0 abstractC0350j$s0, C0276j$a c0276j$a, boolean z5) {
        return new C0280j$a3(abstractC0350j$s0, c0276j$a, z5);
    }

    public final Object Q0(f.j$V j_v, f.j$N j_n, BiConsumer biConsumer) {
        C0337j$p c0337j$p = new C0337j$p(biConsumer, 0);
        j_v.getClass();
        j_n.getClass();
        return v0(new C0347j$r1(4, c0337j$p, j_n, j_v, 1));
    }

    public final C0240j$n R0(InterfaceC0259j$g interfaceC0259j$g) {
        interfaceC0259j$g.getClass();
        return (C0240j$n) v0(new C0363j$v1(4, interfaceC0259j$g, 0));
    }

    @Override // g.AbstractC0285j$c, g.InterfaceC0305j$h
    /* renamed from: S0 */
    public final e.j$B spliterator() {
        return P0(super.spliterator());
    }

    @Override // g.j$C
    public void d(InterfaceC0261j$i interfaceC0261j$i) {
        interfaceC0261j$i.getClass();
        v0(new j$K(interfaceC0261j$i, false));
    }

    @Override // g.j$C
    public void h(C0260j$h c0260j$h) {
        c0260j$h.getClass();
        v0(new j$K(c0260j$h, true));
    }

    @Override // g.InterfaceC0305j$h
    public final Iterator iterator() {
        return e.j$X.f(spliterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0350j$s0
    public final InterfaceC0366j$w0 n0(long j6, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.T(j6);
    }

    @Override // g.InterfaceC0305j$h
    public final InterfaceC0305j$h unordered() {
        return !B0() ? this : new C0365j$w(this, j$P2.f10063w, 0);
    }

    @Override // g.AbstractC0285j$c
    final j$B0 x0(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, boolean z5, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.N(abstractC0350j$s0, j_j, z5);
    }

    @Override // g.AbstractC0285j$c
    final void y0(e.j$J j_j, InterfaceC0284j$b2 interfaceC0284j$b2) {
        InterfaceC0261j$i c0341j$q;
        e.j$B P0 = P0(j_j);
        if (interfaceC0284j$b2 instanceof InterfaceC0261j$i) {
            c0341j$q = (InterfaceC0261j$i) interfaceC0284j$b2;
        } else if (j$A3.f9953a) {
            j$A3.a(AbstractC0285j$c.class, "using DoubleStream.adapt(Sink<Double> s)");
            throw null;
        } else {
            interfaceC0284j$b2.getClass();
            c0341j$q = new C0341j$q(0, interfaceC0284j$b2);
        }
        while (!interfaceC0284j$b2.o() && P0.n(c0341j$q)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0285j$c
    public final int z0() {
        return 4;
    }
}
