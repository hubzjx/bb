package q;

import java.util.ArrayList;
import p.d;
import p.e;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f12636a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private a f12637b = new a();

    /* renamed from: c  reason: collision with root package name */
    private p.f f12638c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public e.b f12639a;

        /* renamed from: b  reason: collision with root package name */
        public e.b f12640b;

        /* renamed from: c  reason: collision with root package name */
        public int f12641c;

        /* renamed from: d  reason: collision with root package name */
        public int f12642d;

        /* renamed from: e  reason: collision with root package name */
        public int f12643e;

        /* renamed from: f  reason: collision with root package name */
        public int f12644f;

        /* renamed from: g  reason: collision with root package name */
        public int f12645g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f12646h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f12647i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f12648j;
    }

    /* renamed from: q.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0206b {
        void a();

        void b(p.e eVar, a aVar);
    }

    public b(p.f fVar) {
        this.f12638c = fVar;
    }

    private boolean a(InterfaceC0206b interfaceC0206b, p.e eVar, boolean z5) {
        this.f12637b.f12639a = eVar.w();
        this.f12637b.f12640b = eVar.K();
        this.f12637b.f12641c = eVar.N();
        this.f12637b.f12642d = eVar.t();
        a aVar = this.f12637b;
        aVar.f12647i = false;
        aVar.f12648j = z5;
        e.b bVar = aVar.f12639a;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        boolean z6 = bVar == bVar2;
        boolean z7 = aVar.f12640b == bVar2;
        boolean z8 = z6 && eVar.Q > 0.0f;
        boolean z9 = z7 && eVar.Q > 0.0f;
        if (z8 && eVar.f12568n[0] == 4) {
            aVar.f12639a = e.b.FIXED;
        }
        if (z9 && eVar.f12568n[1] == 4) {
            aVar.f12640b = e.b.FIXED;
        }
        interfaceC0206b.b(eVar, aVar);
        eVar.A0(this.f12637b.f12643e);
        eVar.e0(this.f12637b.f12644f);
        eVar.d0(this.f12637b.f12646h);
        eVar.Y(this.f12637b.f12645g);
        a aVar2 = this.f12637b;
        aVar2.f12648j = false;
        return aVar2.f12647i;
    }

    private void b(p.f fVar) {
        int size = fVar.f12602w0.size();
        InterfaceC0206b Q0 = fVar.Q0();
        for (int i6 = 0; i6 < size; i6++) {
            p.e eVar = (p.e) fVar.f12602w0.get(i6);
            if (!(eVar instanceof p.g) && (!eVar.f12550e.f12690e.f12669j || !eVar.f12552f.f12690e.f12669j)) {
                e.b q5 = eVar.q(0);
                boolean z5 = true;
                e.b q6 = eVar.q(1);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (!((q5 != bVar || eVar.f12564l == 1 || q6 != bVar || eVar.f12566m == 1) ? false : false)) {
                    a(Q0, eVar, false);
                }
            }
        }
        Q0.a();
    }

    private void c(p.f fVar, String str, int i6, int i7) {
        int C = fVar.C();
        int B = fVar.B();
        fVar.q0(0);
        fVar.p0(0);
        fVar.A0(i6);
        fVar.e0(i7);
        fVar.q0(C);
        fVar.p0(B);
        this.f12638c.G0();
    }

    public long d(p.f fVar, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        boolean z5;
        int i15;
        boolean z6;
        boolean z7;
        int i16;
        int i17;
        int i18;
        InterfaceC0206b interfaceC0206b;
        InterfaceC0206b Q0 = fVar.Q0();
        int size = fVar.f12602w0.size();
        int N = fVar.N();
        int t5 = fVar.t();
        boolean b6 = p.j.b(i6, 128);
        boolean z8 = b6 || p.j.b(i6, 64);
        if (z8) {
            for (int i19 = 0; i19 < size; i19++) {
                p.e eVar = (p.e) fVar.f12602w0.get(i19);
                e.b w5 = eVar.w();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                boolean z9 = (w5 == bVar) && (eVar.K() == bVar) && eVar.r() > 0.0f;
                if ((eVar.T() && z9) || ((eVar.V() && z9) || eVar.T() || eVar.V())) {
                    z8 = false;
                    break;
                }
            }
        }
        if (z8) {
            boolean z10 = o.d.f12279r;
        }
        if (z8 && ((i9 == 1073741824 && i11 == 1073741824) || b6)) {
            int min = Math.min(fVar.A(), i10);
            int min2 = Math.min(fVar.z(), i12);
            if (i9 == 1073741824 && fVar.N() != min) {
                fVar.A0(min);
                fVar.S0();
            }
            if (i11 == 1073741824 && fVar.t() != min2) {
                fVar.e0(min2);
                fVar.S0();
            }
            if (i9 == 1073741824 && i11 == 1073741824) {
                z5 = fVar.N0(b6);
                i15 = 2;
            } else {
                z5 = fVar.O0(b6);
                if (i9 == 1073741824) {
                    z5 &= fVar.P0(b6, 0);
                    i15 = 1;
                } else {
                    i15 = 0;
                }
                if (i11 == 1073741824) {
                    z5 &= fVar.P0(b6, 1);
                    i15++;
                }
            }
            if (z5) {
                fVar.E0(i9 == 1073741824, i11 == 1073741824);
            }
        } else {
            z5 = false;
            i15 = 0;
        }
        if (z5 && i15 == 2) {
            return 0L;
        }
        if (size > 0) {
            b(fVar);
        }
        int R0 = fVar.R0();
        int size2 = this.f12636a.size();
        if (size > 0) {
            c(fVar, "First pass", N, t5);
        }
        if (size2 > 0) {
            e.b w6 = fVar.w();
            e.b bVar2 = e.b.WRAP_CONTENT;
            boolean z11 = w6 == bVar2;
            boolean z12 = fVar.K() == bVar2;
            int max = Math.max(fVar.N(), this.f12638c.C());
            int max2 = Math.max(fVar.t(), this.f12638c.B());
            for (int i20 = 0; i20 < size2; i20++) {
                p.e eVar2 = (p.e) this.f12636a.get(i20);
            }
            int i21 = 0;
            boolean z13 = false;
            for (int i22 = 2; i21 < i22; i22 = 2) {
                int i23 = 0;
                while (i23 < size2) {
                    p.e eVar3 = (p.e) this.f12636a.get(i23);
                    if ((eVar3 instanceof p.h) || (eVar3 instanceof p.g)) {
                        i16 = size2;
                    } else {
                        i16 = size2;
                        if (eVar3.M() != 8 && (!eVar3.f12550e.f12690e.f12669j || !eVar3.f12552f.f12690e.f12669j)) {
                            int N2 = eVar3.N();
                            int t6 = eVar3.t();
                            i17 = R0;
                            int l6 = eVar3.l();
                            i18 = i21;
                            z13 |= a(Q0, eVar3, true);
                            int N3 = eVar3.N();
                            interfaceC0206b = Q0;
                            int t7 = eVar3.t();
                            if (N3 != N2) {
                                eVar3.A0(N3);
                                if (z11 && eVar3.G() > max) {
                                    max = Math.max(max, eVar3.G() + eVar3.k(d.b.RIGHT).b());
                                }
                                z13 = true;
                            }
                            if (t7 != t6) {
                                eVar3.e0(t7);
                                if (z12 && eVar3.n() > max2) {
                                    max2 = Math.max(max2, eVar3.n() + eVar3.k(d.b.BOTTOM).b());
                                }
                                z13 = true;
                            }
                            if (eVar3.Q() && l6 != eVar3.l()) {
                                z13 = true;
                            }
                            i23++;
                            size2 = i16;
                            R0 = i17;
                            i21 = i18;
                            Q0 = interfaceC0206b;
                        }
                    }
                    i17 = R0;
                    interfaceC0206b = Q0;
                    i18 = i21;
                    i23++;
                    size2 = i16;
                    R0 = i17;
                    i21 = i18;
                    Q0 = interfaceC0206b;
                }
                int i24 = R0;
                int i25 = size2;
                InterfaceC0206b interfaceC0206b2 = Q0;
                int i26 = i21;
                if (z13) {
                    c(fVar, "intermediate pass", N, t5);
                    z13 = false;
                }
                i21 = i26 + 1;
                size2 = i25;
                R0 = i24;
                Q0 = interfaceC0206b2;
            }
            int i27 = R0;
            if (z13) {
                c(fVar, "2nd pass", N, t5);
                if (fVar.N() < max) {
                    fVar.A0(max);
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (fVar.t() < max2) {
                    fVar.e0(max2);
                    z7 = true;
                } else {
                    z7 = z6;
                }
                if (z7) {
                    c(fVar, "3rd pass", N, t5);
                }
            }
            R0 = i27;
        }
        fVar.b1(R0);
        return 0L;
    }

    public void e(p.f fVar) {
        int i6;
        this.f12636a.clear();
        int size = fVar.f12602w0.size();
        while (i6 < size) {
            p.e eVar = (p.e) fVar.f12602w0.get(i6);
            e.b w5 = eVar.w();
            e.b bVar = e.b.MATCH_CONSTRAINT;
            if (w5 != bVar) {
                e.b w6 = eVar.w();
                e.b bVar2 = e.b.MATCH_PARENT;
                i6 = (w6 == bVar2 || eVar.K() == bVar || eVar.K() == bVar2) ? 0 : i6 + 1;
            }
            this.f12636a.add(eVar);
        }
        fVar.S0();
    }
}
