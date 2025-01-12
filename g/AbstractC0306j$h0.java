package g;

import e.C0242j$p;
import f.InterfaceC0274j$v;
import j$.util.function.BiConsumer;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$h0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0306j$h0 extends AbstractC0285j$c implements InterfaceC0314j$j0 {

    /* renamed from: s  reason: collision with root package name */
    public static final /* synthetic */ int f10169s = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0306j$h0(e.j$J j_j, int i6) {
        super(j_j, i6, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0306j$h0(AbstractC0285j$c abstractC0285j$c, int i6) {
        super(abstractC0285j$c, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static e.j$F P0(e.j$J j_j) {
        if (j_j instanceof e.j$F) {
            return (e.j$F) j_j;
        }
        if (j$A3.f9953a) {
            j$A3.a(AbstractC0285j$c.class, "using LongStream.adapt(Spliterator<Long> s)");
            throw null;
        }
        throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    @Override // g.AbstractC0285j$c
    final e.j$J M0(AbstractC0350j$s0 abstractC0350j$s0, C0276j$a c0276j$a, boolean z5) {
        return new j$e3(abstractC0350j$s0, c0276j$a, z5);
    }

    public final Object Q0(f.j$V j_v, f.j$R j_r, BiConsumer biConsumer) {
        C0337j$p c0337j$p = new C0337j$p(biConsumer, 2);
        j_v.getClass();
        j_r.getClass();
        return v0(new C0347j$r1(3, c0337j$p, j_r, j_v, 0));
    }

    public final C0242j$p R0(f.j$C j_c) {
        j_c.getClass();
        return (C0242j$p) v0(new C0363j$v1(3, j_c, 3));
    }

    @Override // g.AbstractC0285j$c, g.InterfaceC0305j$h
    /* renamed from: S0 */
    public final e.j$F spliterator() {
        return P0(super.spliterator());
    }

    public void c(f.j$E j_e) {
        j_e.getClass();
        v0(new j$M(j_e, false));
    }

    public void f(f.j$D j_d) {
        j_d.getClass();
        v0(new j$M(j_d, true));
    }

    @Override // g.InterfaceC0305j$h
    public final Iterator iterator() {
        return e.j$X.h(spliterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0350j$s0
    public final InterfaceC0366j$w0 n0(long j6, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.f0(j6);
    }

    public final long sum() {
        return ((Long) v0(new j$H1(new C0281j$b(28), 0L))).longValue();
    }

    @Override // g.InterfaceC0305j$h
    public final InterfaceC0305j$h unordered() {
        return !B0() ? this : new j$U(this, j$P2.f10063w, 1);
    }

    @Override // g.AbstractC0285j$c
    final j$B0 x0(AbstractC0350j$s0 abstractC0350j$s0, e.j$J j_j, boolean z5, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.P(abstractC0350j$s0, j_j, z5);
    }

    @Override // g.AbstractC0285j$c
    final void y0(e.j$J j_j, InterfaceC0284j$b2 interfaceC0284j$b2) {
        f.j$E c0286j$c0;
        e.j$F P0 = P0(j_j);
        if (interfaceC0284j$b2 instanceof f.j$E) {
            c0286j$c0 = (f.j$E) interfaceC0284j$b2;
        } else if (j$A3.f9953a) {
            j$A3.a(AbstractC0285j$c.class, "using LongStream.adapt(Sink<Long> s)");
            throw null;
        } else {
            interfaceC0284j$b2.getClass();
            c0286j$c0 = new C0286j$c0(0, interfaceC0284j$b2);
        }
        while (!interfaceC0284j$b2.o() && P0.p(c0286j$c0)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0285j$c
    public final int z0() {
        return 3;
    }
}
