package p;

import p.e;
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    static boolean[] f12601a = new boolean[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(f fVar, o.d dVar, e eVar) {
        eVar.f12560j = -1;
        eVar.f12562k = -1;
        e.b bVar = fVar.M[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.M[0] == e.b.MATCH_PARENT) {
            int i6 = eVar.B.f12537e;
            int N = fVar.N() - eVar.D.f12537e;
            d dVar2 = eVar.B;
            dVar2.f12539g = dVar.q(dVar2);
            d dVar3 = eVar.D;
            dVar3.f12539g = dVar.q(dVar3);
            dVar.f(eVar.B.f12539g, i6);
            dVar.f(eVar.D.f12539g, N);
            eVar.f12560j = 2;
            eVar.h0(i6, N);
        }
        if (fVar.M[1] == bVar2 || eVar.M[1] != e.b.MATCH_PARENT) {
            return;
        }
        int i7 = eVar.C.f12537e;
        int t5 = fVar.t() - eVar.E.f12537e;
        d dVar4 = eVar.C;
        dVar4.f12539g = dVar.q(dVar4);
        d dVar5 = eVar.E;
        dVar5.f12539g = dVar.q(dVar5);
        dVar.f(eVar.C.f12539g, i7);
        dVar.f(eVar.E.f12539g, t5);
        if (eVar.Y > 0 || eVar.M() == 8) {
            d dVar6 = eVar.F;
            dVar6.f12539g = dVar.q(dVar6);
            dVar.f(eVar.F.f12539g, eVar.Y + i7);
        }
        eVar.f12562k = 2;
        eVar.v0(i7, t5);
    }

    public static final boolean b(int i6, int i7) {
        return (i6 & i7) == i7;
    }
}
