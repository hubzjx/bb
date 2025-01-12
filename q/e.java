package q;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p.e;
import q.b;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private p.f f12651a;

    /* renamed from: d  reason: collision with root package name */
    private p.f f12654d;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12652b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12653c = true;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList f12655e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList f12656f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private b.InterfaceC0206b f12657g = null;

    /* renamed from: h  reason: collision with root package name */
    private b.a f12658h = new b.a();

    /* renamed from: i  reason: collision with root package name */
    ArrayList f12659i = new ArrayList();

    public e(p.f fVar) {
        this.f12651a = fVar;
        this.f12654d = fVar;
    }

    private void a(f fVar, int i6, int i7, f fVar2, ArrayList arrayList, k kVar) {
        m mVar = fVar.f12663d;
        if (mVar.f12688c == null) {
            p.f fVar3 = this.f12651a;
            if (mVar == fVar3.f12550e || mVar == fVar3.f12552f) {
                return;
            }
            if (kVar == null) {
                kVar = new k(mVar, i7);
                arrayList.add(kVar);
            }
            mVar.f12688c = kVar;
            kVar.a(mVar);
            for (d dVar : mVar.f12693h.f12670k) {
                if (dVar instanceof f) {
                    a((f) dVar, i6, 0, fVar2, arrayList, kVar);
                }
            }
            for (d dVar2 : mVar.f12694i.f12670k) {
                if (dVar2 instanceof f) {
                    a((f) dVar2, i6, 1, fVar2, arrayList, kVar);
                }
            }
            if (i6 == 1 && (mVar instanceof l)) {
                for (d dVar3 : ((l) mVar).f12683k.f12670k) {
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i6, 2, fVar2, arrayList, kVar);
                    }
                }
            }
            for (f fVar4 : mVar.f12693h.f12671l) {
                if (fVar4 == fVar2) {
                    kVar.f12677b = true;
                }
                a(fVar4, i6, 0, fVar2, arrayList, kVar);
            }
            for (f fVar5 : mVar.f12694i.f12671l) {
                if (fVar5 == fVar2) {
                    kVar.f12677b = true;
                }
                a(fVar5, i6, 1, fVar2, arrayList, kVar);
            }
            if (i6 == 1 && (mVar instanceof l)) {
                for (f fVar6 : ((l) mVar).f12683k.f12671l) {
                    a(fVar6, i6, 2, fVar2, arrayList, kVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0074, code lost:
        if (r2.f12566m == 0) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(p.f fVar) {
        int i6;
        e.b bVar;
        int i7;
        e.b bVar2;
        e eVar;
        p.e eVar2;
        e.b[] bVarArr;
        e.b bVar3;
        g gVar;
        int t5;
        e.b bVar4;
        e.b bVar5;
        Iterator it = fVar.f12602w0.iterator();
        while (it.hasNext()) {
            p.e eVar3 = (p.e) it.next();
            e.b[] bVarArr2 = eVar3.M;
            e.b bVar6 = bVarArr2[0];
            e.b bVar7 = bVarArr2[1];
            if (eVar3.M() != 8) {
                if (eVar3.f12574q < 1.0f && bVar6 == e.b.MATCH_CONSTRAINT) {
                    eVar3.f12564l = 2;
                }
                if (eVar3.f12580t < 1.0f && bVar7 == e.b.MATCH_CONSTRAINT) {
                    eVar3.f12566m = 2;
                }
                if (eVar3.r() > 0.0f) {
                    e.b bVar8 = e.b.MATCH_CONSTRAINT;
                    if (bVar6 == bVar8 && (bVar7 == e.b.WRAP_CONTENT || bVar7 == e.b.FIXED)) {
                        eVar3.f12564l = 3;
                    } else {
                        if (bVar7 != bVar8 || (bVar6 != e.b.WRAP_CONTENT && bVar6 != e.b.FIXED)) {
                            if (bVar6 == bVar8 && bVar7 == bVar8) {
                                if (eVar3.f12564l == 0) {
                                    eVar3.f12564l = 3;
                                }
                            }
                        }
                        eVar3.f12566m = 3;
                    }
                }
                e.b bVar9 = e.b.MATCH_CONSTRAINT;
                if (bVar6 == bVar9 && eVar3.f12564l == 1 && (eVar3.B.f12536d == null || eVar3.D.f12536d == null)) {
                    bVar6 = e.b.WRAP_CONTENT;
                }
                e.b bVar10 = bVar6;
                if (bVar7 == bVar9 && eVar3.f12566m == 1 && (eVar3.C.f12536d == null || eVar3.E.f12536d == null)) {
                    bVar7 = e.b.WRAP_CONTENT;
                }
                e.b bVar11 = bVar7;
                j jVar = eVar3.f12550e;
                jVar.f12689d = bVar10;
                int i8 = eVar3.f12564l;
                jVar.f12686a = i8;
                l lVar = eVar3.f12552f;
                lVar.f12689d = bVar11;
                int i9 = eVar3.f12566m;
                lVar.f12686a = i9;
                e.b bVar12 = e.b.MATCH_PARENT;
                if ((bVar10 == bVar12 || bVar10 == e.b.FIXED || bVar10 == e.b.WRAP_CONTENT) && (bVar11 == bVar12 || bVar11 == e.b.FIXED || bVar11 == e.b.WRAP_CONTENT)) {
                    int N = eVar3.N();
                    if (bVar10 == bVar12) {
                        i6 = (fVar.N() - eVar3.B.f12537e) - eVar3.D.f12537e;
                        bVar = e.b.FIXED;
                    } else {
                        i6 = N;
                        bVar = bVar10;
                    }
                    int t6 = eVar3.t();
                    if (bVar11 == bVar12) {
                        i7 = (fVar.t() - eVar3.C.f12537e) - eVar3.E.f12537e;
                        bVar2 = e.b.FIXED;
                    } else {
                        i7 = t6;
                        bVar2 = bVar11;
                    }
                    eVar = this;
                    eVar2 = eVar3;
                } else {
                    if (bVar10 == bVar9 && (bVar11 == (bVar5 = e.b.WRAP_CONTENT) || bVar11 == e.b.FIXED)) {
                        if (i8 == 3) {
                            if (bVar11 == bVar5) {
                                l(eVar3, bVar5, 0, bVar5, 0);
                            }
                            i7 = eVar3.t();
                            i6 = (int) ((i7 * eVar3.Q) + 0.5f);
                            bVar2 = e.b.FIXED;
                            eVar = this;
                            eVar2 = eVar3;
                            bVar = bVar2;
                        } else if (i8 == 1) {
                            l(eVar3, bVar5, 0, bVar11, 0);
                            gVar = eVar3.f12550e.f12690e;
                            t5 = eVar3.N();
                            gVar.f12672m = t5;
                        } else if (i8 == 2) {
                            e.b bVar13 = fVar.M[0];
                            bVar5 = e.b.FIXED;
                            if (bVar13 == bVar5 || bVar13 == bVar12) {
                                i6 = (int) ((eVar3.f12574q * fVar.N()) + 0.5f);
                                i7 = eVar3.t();
                                eVar = this;
                                eVar2 = eVar3;
                                bVar = bVar5;
                                bVar2 = bVar11;
                            }
                        } else {
                            p.d[] dVarArr = eVar3.J;
                            if (dVarArr[0].f12536d == null || dVarArr[1].f12536d == null) {
                                i6 = 0;
                                i7 = 0;
                                eVar = this;
                                eVar2 = eVar3;
                                bVar = bVar5;
                                bVar2 = bVar11;
                            }
                        }
                    }
                    if (bVar11 == bVar9 && (bVar10 == (bVar4 = e.b.WRAP_CONTENT) || bVar10 == e.b.FIXED)) {
                        if (i9 == 3) {
                            if (bVar10 == bVar4) {
                                l(eVar3, bVar4, 0, bVar4, 0);
                            }
                            i6 = eVar3.N();
                            float f6 = eVar3.Q;
                            if (eVar3.s() == -1) {
                                f6 = 1.0f / f6;
                            }
                            i7 = (int) ((i6 * f6) + 0.5f);
                            bVar2 = e.b.FIXED;
                            eVar = this;
                            eVar2 = eVar3;
                            bVar = bVar2;
                        } else if (i9 == 1) {
                            l(eVar3, bVar10, 0, bVar4, 0);
                            gVar = eVar3.f12552f.f12690e;
                            t5 = eVar3.t();
                            gVar.f12672m = t5;
                        } else if (i9 == 2) {
                            e.b bVar14 = fVar.M[1];
                            e.b bVar15 = e.b.FIXED;
                            if (bVar14 == bVar15 || bVar14 == bVar12) {
                                float f7 = eVar3.f12580t;
                                i6 = eVar3.N();
                                eVar = this;
                                eVar2 = eVar3;
                                bVar = bVar10;
                                bVar2 = bVar15;
                                i7 = (int) ((f7 * fVar.t()) + 0.5f);
                            }
                        } else {
                            p.d[] dVarArr2 = eVar3.J;
                            if (dVarArr2[2].f12536d == null || dVarArr2[3].f12536d == null) {
                                i6 = 0;
                                i7 = 0;
                                eVar = this;
                                eVar2 = eVar3;
                                bVar = bVar4;
                                bVar2 = bVar11;
                            }
                        }
                    }
                    if (bVar10 == bVar9 && bVar11 == bVar9) {
                        if (i8 == 1 || i9 == 1) {
                            e.b bVar16 = e.b.WRAP_CONTENT;
                            l(eVar3, bVar16, 0, bVar16, 0);
                            eVar3.f12550e.f12690e.f12672m = eVar3.N();
                            gVar = eVar3.f12552f.f12690e;
                            t5 = eVar3.t();
                            gVar.f12672m = t5;
                        } else if (i9 == 2 && i8 == 2 && ((bVar3 = (bVarArr = fVar.M)[0]) == (bVar2 = e.b.FIXED) || bVar3 == bVar2)) {
                            e.b bVar17 = bVarArr[1];
                            if (bVar17 == bVar2 || bVar17 == bVar2) {
                                float f8 = eVar3.f12574q;
                                float f9 = eVar3.f12580t;
                                i6 = (int) ((f8 * fVar.N()) + 0.5f);
                                i7 = (int) ((f9 * fVar.t()) + 0.5f);
                                eVar = this;
                                eVar2 = eVar3;
                                bVar = bVar2;
                            }
                        }
                    }
                }
                eVar.l(eVar2, bVar, i6, bVar2, i7);
                eVar3.f12550e.f12690e.d(eVar3.N());
                eVar3.f12552f.f12690e.d(eVar3.t());
            }
            eVar3.f12542a = true;
        }
        return false;
    }

    private int e(p.f fVar, int i6) {
        int size = this.f12659i.size();
        long j6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            j6 = Math.max(j6, ((k) this.f12659i.get(i7)).b(fVar, i6));
        }
        return (int) j6;
    }

    private void i(m mVar, int i6, ArrayList arrayList) {
        for (d dVar : mVar.f12693h.f12670k) {
            if (dVar instanceof f) {
                a((f) dVar, i6, 0, mVar.f12694i, arrayList, null);
            } else if (dVar instanceof m) {
                a(((m) dVar).f12693h, i6, 0, mVar.f12694i, arrayList, null);
            }
        }
        for (d dVar2 : mVar.f12694i.f12670k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i6, 1, mVar.f12693h, arrayList, null);
            } else if (dVar2 instanceof m) {
                a(((m) dVar2).f12694i, i6, 1, mVar.f12693h, arrayList, null);
            }
        }
        if (i6 == 1) {
            for (d dVar3 : ((l) mVar).f12683k.f12670k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i6, 2, null, arrayList, null);
                }
            }
        }
    }

    private void l(p.e eVar, e.b bVar, int i6, e.b bVar2, int i7) {
        b.a aVar = this.f12658h;
        aVar.f12639a = bVar;
        aVar.f12640b = bVar2;
        aVar.f12641c = i6;
        aVar.f12642d = i7;
        this.f12657g.b(eVar, aVar);
        eVar.A0(this.f12658h.f12643e);
        eVar.e0(this.f12658h.f12644f);
        eVar.d0(this.f12658h.f12646h);
        eVar.Y(this.f12658h.f12645g);
    }

    public void c() {
        d(this.f12655e);
        this.f12659i.clear();
        k.f12675h = 0;
        i(this.f12651a.f12550e, 0, this.f12659i);
        i(this.f12651a.f12552f, 1, this.f12659i);
        this.f12652b = false;
    }

    public void d(ArrayList arrayList) {
        m hVar;
        arrayList.clear();
        this.f12654d.f12550e.f();
        this.f12654d.f12552f.f();
        arrayList.add(this.f12654d.f12550e);
        arrayList.add(this.f12654d.f12552f);
        Iterator it = this.f12654d.f12602w0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            p.e eVar = (p.e) it.next();
            if (eVar instanceof p.g) {
                hVar = new h(eVar);
            } else {
                if (eVar.T()) {
                    if (eVar.f12546c == null) {
                        eVar.f12546c = new c(eVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f12546c);
                } else {
                    arrayList.add(eVar.f12550e);
                }
                if (eVar.V()) {
                    if (eVar.f12548d == null) {
                        eVar.f12548d = new c(eVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f12548d);
                } else {
                    arrayList.add(eVar.f12552f);
                }
                if (eVar instanceof p.i) {
                    hVar = new i(eVar);
                }
            }
            arrayList.add(hVar);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((m) it2.next()).f();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            m mVar = (m) it3.next();
            if (mVar.f12687b != this.f12654d) {
                mVar.d();
            }
        }
    }

    public boolean f(boolean z5) {
        boolean z6;
        boolean z7 = true;
        boolean z8 = z5 & true;
        if (this.f12652b || this.f12653c) {
            Iterator it = this.f12651a.f12602w0.iterator();
            while (it.hasNext()) {
                p.e eVar = (p.e) it.next();
                eVar.f12542a = false;
                eVar.f12550e.r();
                eVar.f12552f.q();
            }
            p.f fVar = this.f12651a;
            fVar.f12542a = false;
            fVar.f12550e.r();
            this.f12651a.f12552f.q();
            this.f12653c = false;
        }
        if (b(this.f12654d)) {
            return false;
        }
        this.f12651a.B0(0);
        this.f12651a.C0(0);
        e.b q5 = this.f12651a.q(0);
        e.b q6 = this.f12651a.q(1);
        if (this.f12652b) {
            c();
        }
        int O = this.f12651a.O();
        int P = this.f12651a.P();
        this.f12651a.f12550e.f12693h.d(O);
        this.f12651a.f12552f.f12693h.d(P);
        m();
        e.b bVar = e.b.WRAP_CONTENT;
        if (q5 == bVar || q6 == bVar) {
            if (z8) {
                Iterator it2 = this.f12655e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (!((m) it2.next()).m()) {
                        z8 = false;
                        break;
                    }
                }
            }
            if (z8 && q5 == e.b.WRAP_CONTENT) {
                this.f12651a.i0(e.b.FIXED);
                p.f fVar2 = this.f12651a;
                fVar2.A0(e(fVar2, 0));
                p.f fVar3 = this.f12651a;
                fVar3.f12550e.f12690e.d(fVar3.N());
            }
            if (z8 && q6 == e.b.WRAP_CONTENT) {
                this.f12651a.w0(e.b.FIXED);
                p.f fVar4 = this.f12651a;
                fVar4.e0(e(fVar4, 1));
                p.f fVar5 = this.f12651a;
                fVar5.f12552f.f12690e.d(fVar5.t());
            }
        }
        p.f fVar6 = this.f12651a;
        e.b bVar2 = fVar6.M[0];
        e.b bVar3 = e.b.FIXED;
        if (bVar2 == bVar3 || bVar2 == e.b.MATCH_PARENT) {
            int N = fVar6.N() + O;
            this.f12651a.f12550e.f12694i.d(N);
            this.f12651a.f12550e.f12690e.d(N - O);
            m();
            p.f fVar7 = this.f12651a;
            e.b bVar4 = fVar7.M[1];
            if (bVar4 == bVar3 || bVar4 == e.b.MATCH_PARENT) {
                int t5 = fVar7.t() + P;
                this.f12651a.f12552f.f12694i.d(t5);
                this.f12651a.f12552f.f12690e.d(t5 - P);
            }
            m();
            z6 = true;
        } else {
            z6 = false;
        }
        Iterator it3 = this.f12655e.iterator();
        while (it3.hasNext()) {
            m mVar = (m) it3.next();
            if (mVar.f12687b != this.f12651a || mVar.f12692g) {
                mVar.e();
            }
        }
        Iterator it4 = this.f12655e.iterator();
        while (it4.hasNext()) {
            m mVar2 = (m) it4.next();
            if (z6 || mVar2.f12687b != this.f12651a) {
                if (!mVar2.f12693h.f12669j || ((!mVar2.f12694i.f12669j && !(mVar2 instanceof h)) || (!mVar2.f12690e.f12669j && !(mVar2 instanceof c) && !(mVar2 instanceof h)))) {
                    z7 = false;
                    break;
                }
            }
        }
        this.f12651a.i0(q5);
        this.f12651a.w0(q6);
        return z7;
    }

    public boolean g(boolean z5) {
        if (this.f12652b) {
            Iterator it = this.f12651a.f12602w0.iterator();
            while (it.hasNext()) {
                p.e eVar = (p.e) it.next();
                eVar.f12542a = false;
                j jVar = eVar.f12550e;
                jVar.f12690e.f12669j = false;
                jVar.f12692g = false;
                jVar.r();
                l lVar = eVar.f12552f;
                lVar.f12690e.f12669j = false;
                lVar.f12692g = false;
                lVar.q();
            }
            p.f fVar = this.f12651a;
            fVar.f12542a = false;
            j jVar2 = fVar.f12550e;
            jVar2.f12690e.f12669j = false;
            jVar2.f12692g = false;
            jVar2.r();
            l lVar2 = this.f12651a.f12552f;
            lVar2.f12690e.f12669j = false;
            lVar2.f12692g = false;
            lVar2.q();
            c();
        }
        if (b(this.f12654d)) {
            return false;
        }
        this.f12651a.B0(0);
        this.f12651a.C0(0);
        this.f12651a.f12550e.f12693h.d(0);
        this.f12651a.f12552f.f12693h.d(0);
        return true;
    }

    public boolean h(boolean z5, int i6) {
        boolean z6;
        e.b bVar;
        g gVar;
        int t5;
        boolean z7 = true;
        boolean z8 = z5 & true;
        e.b q5 = this.f12651a.q(0);
        e.b q6 = this.f12651a.q(1);
        int O = this.f12651a.O();
        int P = this.f12651a.P();
        if (z8 && (q5 == (bVar = e.b.WRAP_CONTENT) || q6 == bVar)) {
            Iterator it = this.f12655e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m mVar = (m) it.next();
                if (mVar.f12691f == i6 && !mVar.m()) {
                    z8 = false;
                    break;
                }
            }
            if (i6 == 0) {
                if (z8 && q5 == e.b.WRAP_CONTENT) {
                    this.f12651a.i0(e.b.FIXED);
                    p.f fVar = this.f12651a;
                    fVar.A0(e(fVar, 0));
                    p.f fVar2 = this.f12651a;
                    gVar = fVar2.f12550e.f12690e;
                    t5 = fVar2.N();
                    gVar.d(t5);
                }
            } else if (z8 && q6 == e.b.WRAP_CONTENT) {
                this.f12651a.w0(e.b.FIXED);
                p.f fVar3 = this.f12651a;
                fVar3.e0(e(fVar3, 1));
                p.f fVar4 = this.f12651a;
                gVar = fVar4.f12552f.f12690e;
                t5 = fVar4.t();
                gVar.d(t5);
            }
        }
        p.f fVar5 = this.f12651a;
        if (i6 == 0) {
            e.b bVar2 = fVar5.M[0];
            if (bVar2 == e.b.FIXED || bVar2 == e.b.MATCH_PARENT) {
                int N = fVar5.N() + O;
                this.f12651a.f12550e.f12694i.d(N);
                this.f12651a.f12550e.f12690e.d(N - O);
                z6 = true;
            }
            z6 = false;
        } else {
            e.b bVar3 = fVar5.M[1];
            if (bVar3 == e.b.FIXED || bVar3 == e.b.MATCH_PARENT) {
                int t6 = fVar5.t() + P;
                this.f12651a.f12552f.f12694i.d(t6);
                this.f12651a.f12552f.f12690e.d(t6 - P);
                z6 = true;
            }
            z6 = false;
        }
        m();
        Iterator it2 = this.f12655e.iterator();
        while (it2.hasNext()) {
            m mVar2 = (m) it2.next();
            if (mVar2.f12691f == i6 && (mVar2.f12687b != this.f12651a || mVar2.f12692g)) {
                mVar2.e();
            }
        }
        Iterator it3 = this.f12655e.iterator();
        while (it3.hasNext()) {
            m mVar3 = (m) it3.next();
            if (mVar3.f12691f == i6 && (z6 || mVar3.f12687b != this.f12651a)) {
                if (!mVar3.f12693h.f12669j || !mVar3.f12694i.f12669j || (!(mVar3 instanceof c) && !mVar3.f12690e.f12669j)) {
                    z7 = false;
                    break;
                }
            }
        }
        this.f12651a.i0(q5);
        this.f12651a.w0(q6);
        return z7;
    }

    public void j() {
        this.f12652b = true;
    }

    public void k() {
        this.f12653c = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0008 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m() {
        g gVar;
        int N;
        g gVar2;
        int N2;
        g gVar3;
        Iterator it = this.f12651a.f12602w0.iterator();
        while (it.hasNext()) {
            p.e eVar = (p.e) it.next();
            if (!eVar.f12542a) {
                e.b[] bVarArr = eVar.M;
                boolean z5 = false;
                e.b bVar = bVarArr[0];
                e.b bVar2 = bVarArr[1];
                int i6 = eVar.f12564l;
                int i7 = eVar.f12566m;
                e.b bVar3 = e.b.WRAP_CONTENT;
                boolean z6 = bVar == bVar3 || (bVar == e.b.MATCH_CONSTRAINT && i6 == 1);
                if (bVar2 == bVar3 || (bVar2 == e.b.MATCH_CONSTRAINT && i7 == 1)) {
                    z5 = true;
                }
                g gVar4 = eVar.f12550e.f12690e;
                boolean z7 = gVar4.f12669j;
                g gVar5 = eVar.f12552f.f12690e;
                boolean z8 = gVar5.f12669j;
                if (z7 && z8) {
                    e.b bVar4 = e.b.FIXED;
                    l(eVar, bVar4, gVar4.f12666g, bVar4, gVar5.f12666g);
                } else if (z7 && z5) {
                    l(eVar, e.b.FIXED, gVar4.f12666g, bVar3, gVar5.f12666g);
                    if (bVar2 == e.b.MATCH_CONSTRAINT) {
                        gVar2 = eVar.f12552f.f12690e;
                        N2 = eVar.t();
                        gVar2.f12672m = N2;
                        if (!eVar.f12542a) {
                            gVar3.d(eVar.l());
                        }
                    } else {
                        gVar = eVar.f12552f.f12690e;
                        N = eVar.t();
                        gVar.d(N);
                    }
                } else {
                    if (z8 && z6) {
                        l(eVar, bVar3, gVar4.f12666g, e.b.FIXED, gVar5.f12666g);
                        if (bVar == e.b.MATCH_CONSTRAINT) {
                            gVar2 = eVar.f12550e.f12690e;
                            N2 = eVar.N();
                            gVar2.f12672m = N2;
                        } else {
                            gVar = eVar.f12550e.f12690e;
                            N = eVar.N();
                            gVar.d(N);
                        }
                    }
                    if (!eVar.f12542a && (gVar3 = eVar.f12552f.f12684l) != null) {
                        gVar3.d(eVar.l());
                    }
                }
                eVar.f12542a = true;
                if (!eVar.f12542a) {
                }
            }
        }
    }

    public void n(b.InterfaceC0206b interfaceC0206b) {
        this.f12657g = interfaceC0206b;
    }
}
