package g;

import e.C0241j$o;
import f.C0271j$s;
import f.InterfaceC0270j$r;
import f.InterfaceC0272j$t;
import f.InterfaceC0274j$v;
import j$.util.function.BiConsumer;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class j$Z extends AbstractC0285j$c implements InterfaceC0282j$b0 {

    /* renamed from: s  reason: collision with root package name */
    public static final /* synthetic */ int f10108s = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$Z(e.j$J j_j, int i6) {
        super(j_j, i6, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$Z(AbstractC0285j$c abstractC0285j$c, int i6) {
        super(abstractC0285j$c, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static e.j$D P0(e.j$J j_j) {
        if (j_j instanceof e.j$D) {
            return (e.j$D) j_j;
        }
        if (j$A3.f9953a) {
            j$A3.a(AbstractC0285j$c.class, "using IntStream.adapt(Spliterator<Integer> s)");
            throw null;
        }
        throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
    }

    @Override // g.AbstractC0285j$c
    final e.j$J M0(AbstractC0350j$s0 abstractC0350j$s0, C0276j$a c0276j$a, boolean z5) {
        return new j$c3(abstractC0350j$s0, c0276j$a, z5);
    }

    public final Object Q0(f.j$V j_v, f.j$P j_p, BiConsumer biConsumer) {
        C0337j$p c0337j$p = new C0337j$p(biConsumer, 1);
        j_v.getClass();
        j_p.getClass();
        return v0(new C0347j$r1(2, c0337j$p, j_p, j_v, 4));
    }

    public final C0241j$o R0(InterfaceC0270j$r interfaceC0270j$r) {
        interfaceC0270j$r.getClass();
        return (C0241j$o) v0(new C0363j$v1(2, interfaceC0270j$r, 2));
    }

    @Override // g.AbstractC0285j$c, g.InterfaceC0305j$h
    /* renamed from: S0 */
    public final e.j$D spliterator() {
        return P0(super.spliterator());
    }

    public void a(C0271j$s c0271j$s) {
        c0271j$s.getClass();
        v0(new j$L(c0271j$s, true));
    }

    public void i(InterfaceC0272j$t interfaceC0272j$t) {
        interfaceC0272j$t.getClass();
        v0(new j$L(interfaceC0272j$t, false));
    }

    @Override // g.InterfaceC0305j$h
    public final Iterator iterator() {
        return e.j$X.g(spliterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0350j$s0
    public final InterfaceC0366j$w0 n0(long j6, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.d0(j6);
    }

    @Override // g.InterfaceC0305j$h
    public final InterfaceC0305j$h unordered() {
        if (B0()) {
            final int i6 = j$P2.f10063w;
            return new j$Y(this, i6) { // from class: g.j$V
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // g.AbstractC0285j$c
                public final InterfaceC0284j$b2 H0(int i7, InterfaceC0284j$b2 interfaceC0284j$b2) {
                    return interfaceC0284j$b2;
                }
            };
        }
        return this;
    }

    @Override // g.AbstractC0285j$c
    final j$B0 x0(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, boolean z5, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.O(abstractC0350j$s0, j_j, z5);
    }

    @Override // g.AbstractC0285j$c
    final void y0(e.j$J j_j, InterfaceC0284j$b2 interfaceC0284j$b2) {
        InterfaceC0272j$t j_r;
        e.j$D P0 = P0(j_j);
        if (interfaceC0284j$b2 instanceof InterfaceC0272j$t) {
            j_r = (InterfaceC0272j$t) interfaceC0284j$b2;
        } else if (j$A3.f9953a) {
            j$A3.a(AbstractC0285j$c.class, "using IntStream.adapt(Sink<Integer> s)");
            throw null;
        } else {
            interfaceC0284j$b2.getClass();
            j_r = new j$R(0, interfaceC0284j$b2);
        }
        while (!interfaceC0284j$b2.o() && P0.g(j_r)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0285j$c
    public final int z0() {
        return 2;
    }
}
