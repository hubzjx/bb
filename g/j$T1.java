package g;

import e.C0239j$m;
import f.C0256j$d;
import f.InterfaceC0255j$c;
import f.InterfaceC0257j$e;
import f.InterfaceC0274j$v;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.ToLongFunction;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class j$T1 extends AbstractC0285j$c implements j$M2 {

    /* renamed from: s  reason: collision with root package name */
    public static final /* synthetic */ int f10091s = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$T1(e.j$J j_j, int i6, boolean z5) {
        super(j_j, i6, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j$T1(AbstractC0285j$c abstractC0285j$c, int i6) {
        super(abstractC0285j$c, i6);
    }

    @Override // g.AbstractC0285j$c
    final e.j$J M0(AbstractC0350j$s0 abstractC0350j$s0, C0276j$a c0276j$a, boolean z5) {
        return new j$v3(abstractC0350j$s0, c0276j$a, z5);
    }

    public final j$M2 O0() {
        final int i6 = j$P2.f10058r | j$P2.f10065y;
        return new j$R1(this, i6) { // from class: g.j$o
            static j$E0 R0(AbstractC0285j$c abstractC0285j$c, e.j$J j_j) {
                j$F0 j_f0 = new j$F0(17);
                return new j$E0((Collection) new C0347j$r1(1, new j$F0(19), new j$F0(18), j_f0, 3).l(abstractC0285j$c, j_j));
            }

            @Override // g.AbstractC0285j$c
            final j$B0 E0(e.j$J j_j, InterfaceC0274j$v interfaceC0274j$v, AbstractC0285j$c abstractC0285j$c) {
                if (j$P2.f10046f.d(abstractC0285j$c.c0())) {
                    return abstractC0285j$c.u0(j_j, false, interfaceC0274j$v);
                }
                if (j$P2.f10048h.d(abstractC0285j$c.c0())) {
                    return R0(abstractC0285j$c, j_j);
                }
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                new j$N(new C0321j$l(0, atomicBoolean, concurrentHashMap), false).l(abstractC0285j$c, j_j);
                Set keySet = concurrentHashMap.keySet();
                if (atomicBoolean.get()) {
                    HashSet hashSet = new HashSet(keySet);
                    hashSet.add(null);
                    keySet = hashSet;
                }
                return new j$E0(keySet);
            }

            @Override // g.AbstractC0285j$c
            final e.j$J F0(AbstractC0285j$c abstractC0285j$c, e.j$J j_j) {
                return j$P2.f10046f.d(abstractC0285j$c.c0()) ? abstractC0285j$c.N0(j_j) : j$P2.f10048h.d(abstractC0285j$c.c0()) ? R0(abstractC0285j$c, j_j).spliterator() : new j$Y2(abstractC0285j$c.N0(j_j));
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // g.AbstractC0285j$c
            public final InterfaceC0284j$b2 H0(int i7, InterfaceC0284j$b2 interfaceC0284j$b2) {
                interfaceC0284j$b2.getClass();
                return j$P2.f10046f.d(i7) ? interfaceC0284j$b2 : j$P2.f10047g.d(i7) ? new j$X1(interfaceC0284j$b2) { // from class: g.j$m

                    /* renamed from: b  reason: collision with root package name */
                    boolean f10204b;

                    /* renamed from: c  reason: collision with root package name */
                    Object f10205c;

                    @Override // g.j$X1, g.InterfaceC0284j$b2
                    public final void h() {
                        this.f10204b = false;
                        this.f10205c = null;
                        this.f10102a.h();
                    }

                    @Override // g.InterfaceC0284j$b2
                    public final void i(long j6) {
                        this.f10204b = false;
                        this.f10205c = null;
                        this.f10102a.i(-1L);
                    }

                    @Override // f.InterfaceC0257j$e
                    public final void j(Object obj) {
                        InterfaceC0284j$b2 interfaceC0284j$b22 = this.f10102a;
                        if (obj != null) {
                            Object obj2 = this.f10205c;
                            if (obj2 != null && obj.equals(obj2)) {
                                return;
                            }
                        } else if (this.f10204b) {
                            return;
                        } else {
                            this.f10204b = true;
                            obj = null;
                        }
                        this.f10205c = obj;
                        interfaceC0284j$b22.j(obj);
                    }
                } : new C0329j$n(this, interfaceC0284j$b2);
            }
        };
    }

    public final InterfaceC0314j$j0 P0(ToLongFunction toLongFunction) {
        toLongFunction.getClass();
        return new C0361j$v(this, j$P2.f10061u | j$P2.f10059s, toLongFunction, 7);
    }

    public final C0239j$m Q0(InterfaceC0255j$c interfaceC0255j$c) {
        interfaceC0255j$c.getClass();
        return (C0239j$m) v0(new C0363j$v1(1, interfaceC0255j$c, 1));
    }

    public void b(InterfaceC0257j$e interfaceC0257j$e) {
        interfaceC0257j$e.getClass();
        v0(new j$N(interfaceC0257j$e, false));
    }

    public void e(C0256j$d c0256j$d) {
        c0256j$d.getClass();
        v0(new j$N(c0256j$d, true));
    }

    @Override // g.InterfaceC0305j$h
    public final Iterator iterator() {
        return e.j$X.i(spliterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0350j$s0
    public final InterfaceC0366j$w0 n0(long j6, InterfaceC0274j$v interfaceC0274j$v) {
        return AbstractC0350j$s0.L(j6, interfaceC0274j$v);
    }

    @Override // g.InterfaceC0305j$h
    public final InterfaceC0305j$h unordered() {
        if (B0()) {
            final int i6 = j$P2.f10063w;
            return new j$S1(this, i6) { // from class: g.j$O1
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
        return AbstractC0350j$s0.M(abstractC0350j$s0, j_j, z5, interfaceC0274j$v);
    }

    @Override // g.AbstractC0285j$c
    final void y0(e.j$J j_j, InterfaceC0284j$b2 interfaceC0284j$b2) {
        while (!interfaceC0284j$b2.o() && j_j.r(interfaceC0284j$b2)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0285j$c
    public final int z0() {
        return 1;
    }
}
