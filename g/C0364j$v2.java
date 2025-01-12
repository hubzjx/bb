package g;

import e.AbstractC0227j$a;
import f.InterfaceC0274j$v;
import j$.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
/* renamed from: g.j$v2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0364j$v2 extends j$R1 {

    /* renamed from: t  reason: collision with root package name */
    private final boolean f10292t;

    /* renamed from: u  reason: collision with root package name */
    private final Comparator f10293u;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0364j$v2(j$T1 j_t1) {
        super(j_t1, j$P2.f10062v | j$P2.f10060t);
        this.f10292t = true;
        this.f10293u = Comparator.CC.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0364j$v2(j$T1 j_t1, java.util.Comparator comparator) {
        super(j_t1, j$P2.f10062v | j$P2.f10061u);
        this.f10292t = false;
        comparator.getClass();
        this.f10293u = comparator;
    }

    @Override // g.AbstractC0285j$c
    public final j$B0 E0(e.j$J j_j, InterfaceC0274j$v interfaceC0274j$v, AbstractC0285j$c abstractC0285j$c) {
        if (j$P2.f10047g.d(abstractC0285j$c.c0()) && this.f10292t) {
            return abstractC0285j$c.u0(j_j, false, interfaceC0274j$v);
        }
        Object[] n5 = abstractC0285j$c.u0(j_j, true, interfaceC0274j$v).n(interfaceC0274j$v);
        Arrays.sort(n5, this.f10293u);
        return new j$D0(n5);
    }

    @Override // g.AbstractC0285j$c
    public final InterfaceC0284j$b2 H0(int i6, final InterfaceC0284j$b2 interfaceC0284j$b2) {
        interfaceC0284j$b2.getClass();
        if (j$P2.f10047g.d(i6) && this.f10292t) {
            return interfaceC0284j$b2;
        }
        if (j$P2.f10049i.d(i6)) {
            final java.util.Comparator comparator = this.f10293u;
            return new AbstractC0336j$o2(interfaceC0284j$b2, comparator) { // from class: g.j$A2

                /* renamed from: d  reason: collision with root package name */
                private Object[] f9951d;

                /* renamed from: e  reason: collision with root package name */
                private int f9952e;

                @Override // g.j$X1, g.InterfaceC0284j$b2
                public final void h() {
                    int i7 = 0;
                    Arrays.sort(this.f9951d, 0, this.f9952e, this.f10229b);
                    InterfaceC0284j$b2 interfaceC0284j$b22 = this.f10102a;
                    interfaceC0284j$b22.i(this.f9952e);
                    if (this.f10230c) {
                        while (i7 < this.f9952e && !interfaceC0284j$b22.o()) {
                            interfaceC0284j$b22.j(this.f9951d[i7]);
                            i7++;
                        }
                    } else {
                        while (i7 < this.f9952e) {
                            interfaceC0284j$b22.j(this.f9951d[i7]);
                            i7++;
                        }
                    }
                    interfaceC0284j$b22.h();
                    this.f9951d = null;
                }

                @Override // g.InterfaceC0284j$b2
                public final void i(long j6) {
                    if (j6 >= 2147483639) {
                        throw new IllegalArgumentException("Stream size exceeds max array size");
                    }
                    this.f9951d = new Object[(int) j6];
                }

                @Override // f.InterfaceC0257j$e
                public final void j(Object obj) {
                    Object[] objArr = this.f9951d;
                    int i7 = this.f9952e;
                    this.f9952e = i7 + 1;
                    objArr[i7] = obj;
                }
            };
        }
        final java.util.Comparator comparator2 = this.f10293u;
        return new AbstractC0336j$o2(interfaceC0284j$b2, comparator2) { // from class: g.j$w2

            /* renamed from: d  reason: collision with root package name */
            private ArrayList f10298d;

            @Override // g.j$X1, g.InterfaceC0284j$b2
            public final void h() {
                AbstractC0227j$a.z(this.f10298d, this.f10229b);
                InterfaceC0284j$b2 interfaceC0284j$b22 = this.f10102a;
                interfaceC0284j$b22.i(this.f10298d.size());
                if (this.f10230c) {
                    Iterator it = this.f10298d.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (interfaceC0284j$b22.o()) {
                            break;
                        }
                        interfaceC0284j$b22.j(next);
                    }
                } else {
                    ArrayList arrayList = this.f10298d;
                    interfaceC0284j$b22.getClass();
                    AbstractC0227j$a.y(arrayList, new C0276j$a(3, interfaceC0284j$b22));
                }
                interfaceC0284j$b22.h();
                this.f10298d = null;
            }

            @Override // g.InterfaceC0284j$b2
            public final void i(long j6) {
                if (j6 >= 2147483639) {
                    throw new IllegalArgumentException("Stream size exceeds max array size");
                }
                this.f10298d = j6 >= 0 ? new ArrayList((int) j6) : new ArrayList();
            }

            @Override // f.InterfaceC0257j$e
            public final void j(Object obj) {
                this.f10298d.add(obj);
            }
        };
    }
}
