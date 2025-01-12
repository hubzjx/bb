package q;

import p.d;
import p.e;
import q.f;
import q.m;
/* loaded from: classes.dex */
public class l extends m {

    /* renamed from: k  reason: collision with root package name */
    public f f12683k;

    /* renamed from: l  reason: collision with root package name */
    g f12684l;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12685a;

        static {
            int[] iArr = new int[m.b.values().length];
            f12685a = iArr;
            try {
                iArr[m.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12685a[m.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12685a[m.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(p.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f12683k = fVar;
        this.f12684l = null;
        this.f12693h.f12664e = f.a.TOP;
        this.f12694i.f12664e = f.a.BOTTOM;
        fVar.f12664e = f.a.BASELINE;
        this.f12691f = 1;
    }

    @Override // q.m, q.d
    public void a(d dVar) {
        int i6;
        float r5;
        int i7 = a.f12685a[this.f12695j.ordinal()];
        if (i7 == 1) {
            p(dVar);
        } else if (i7 == 2) {
            o(dVar);
        } else if (i7 == 3) {
            p.e eVar = this.f12687b;
            n(dVar, eVar.C, eVar.E, 1);
            return;
        }
        g gVar = this.f12690e;
        if (gVar.f12662c && !gVar.f12669j && this.f12689d == e.b.MATCH_CONSTRAINT) {
            p.e eVar2 = this.f12687b;
            int i8 = eVar2.f12566m;
            if (i8 == 2) {
                p.e E = eVar2.E();
                if (E != null) {
                    g gVar2 = E.f12552f.f12690e;
                    if (gVar2.f12669j) {
                        i6 = (int) ((gVar2.f12666g * this.f12687b.f12580t) + 0.5f);
                        this.f12690e.d(i6);
                    }
                }
            } else if (i8 == 3 && eVar2.f12550e.f12690e.f12669j) {
                int s5 = eVar2.s();
                if (s5 != -1) {
                    if (s5 == 0) {
                        p.e eVar3 = this.f12687b;
                        r5 = eVar3.f12550e.f12690e.f12666g * eVar3.r();
                        i6 = (int) (r5 + 0.5f);
                        this.f12690e.d(i6);
                    } else if (s5 != 1) {
                        i6 = 0;
                        this.f12690e.d(i6);
                    }
                }
                p.e eVar4 = this.f12687b;
                r5 = eVar4.f12550e.f12690e.f12666g / eVar4.r();
                i6 = (int) (r5 + 0.5f);
                this.f12690e.d(i6);
            }
        }
        f fVar = this.f12693h;
        if (fVar.f12662c) {
            f fVar2 = this.f12694i;
            if (fVar2.f12662c) {
                if (fVar.f12669j && fVar2.f12669j && this.f12690e.f12669j) {
                    return;
                }
                if (!this.f12690e.f12669j && this.f12689d == e.b.MATCH_CONSTRAINT) {
                    p.e eVar5 = this.f12687b;
                    if (eVar5.f12564l == 0 && !eVar5.V()) {
                        int i9 = ((f) this.f12693h.f12671l.get(0)).f12666g;
                        f fVar3 = this.f12693h;
                        int i10 = i9 + fVar3.f12665f;
                        int i11 = ((f) this.f12694i.f12671l.get(0)).f12666g + this.f12694i.f12665f;
                        fVar3.d(i10);
                        this.f12694i.d(i11);
                        this.f12690e.d(i11 - i10);
                        return;
                    }
                }
                if (!this.f12690e.f12669j && this.f12689d == e.b.MATCH_CONSTRAINT && this.f12686a == 1 && this.f12693h.f12671l.size() > 0 && this.f12694i.f12671l.size() > 0) {
                    int i12 = (((f) this.f12694i.f12671l.get(0)).f12666g + this.f12694i.f12665f) - (((f) this.f12693h.f12671l.get(0)).f12666g + this.f12693h.f12665f);
                    g gVar3 = this.f12690e;
                    int i13 = gVar3.f12672m;
                    if (i12 < i13) {
                        gVar3.d(i12);
                    } else {
                        gVar3.d(i13);
                    }
                }
                if (this.f12690e.f12669j && this.f12693h.f12671l.size() > 0 && this.f12694i.f12671l.size() > 0) {
                    f fVar4 = (f) this.f12693h.f12671l.get(0);
                    f fVar5 = (f) this.f12694i.f12671l.get(0);
                    int i14 = fVar4.f12666g + this.f12693h.f12665f;
                    int i15 = fVar5.f12666g + this.f12694i.f12665f;
                    float I = this.f12687b.I();
                    if (fVar4 == fVar5) {
                        i14 = fVar4.f12666g;
                        i15 = fVar5.f12666g;
                        I = 0.5f;
                    }
                    this.f12693h.d((int) (i14 + 0.5f + (((i15 - i14) - this.f12690e.f12666g) * I)));
                    this.f12694i.d(this.f12693h.f12666g + this.f12690e.f12666g);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02d9, code lost:
        if (r10.f12687b.Q() != false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02db, code lost:
        r0 = r10.f12683k;
        r1 = r10.f12693h;
        r2 = r10.f12684l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x032e, code lost:
        if (r0.f12689d == r1) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x035e, code lost:
        if (r10.f12687b.Q() != false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x03d3, code lost:
        if (r0.f12689d == r1) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x03d5, code lost:
        r0.f12690e.f12670k.add(r10.f12690e);
        r10.f12690e.f12671l.add(r10.f12687b.f12550e.f12690e);
        r10.f12690e.f12660a = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    @Override // q.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        p.e E;
        j jVar;
        f fVar;
        f fVar2;
        g gVar;
        m mVar;
        f fVar3;
        f fVar4;
        int i6;
        p.e E2;
        p.e eVar = this.f12687b;
        if (eVar.f12542a) {
            this.f12690e.d(eVar.t());
        }
        if (!this.f12690e.f12669j) {
            this.f12689d = this.f12687b.K();
            if (this.f12687b.Q()) {
                this.f12684l = new q.a(this);
            }
            e.b bVar = this.f12689d;
            if (bVar != e.b.MATCH_CONSTRAINT) {
                if (bVar == e.b.MATCH_PARENT && (E2 = this.f12687b.E()) != null && E2.K() == e.b.FIXED) {
                    int t5 = (E2.t() - this.f12687b.C.b()) - this.f12687b.E.b();
                    b(this.f12693h, E2.f12552f.f12693h, this.f12687b.C.b());
                    b(this.f12694i, E2.f12552f.f12694i, -this.f12687b.E.b());
                    this.f12690e.d(t5);
                    return;
                } else if (this.f12689d == e.b.FIXED) {
                    this.f12690e.d(this.f12687b.t());
                }
            }
        } else if (this.f12689d == e.b.MATCH_PARENT && (E = this.f12687b.E()) != null && E.K() == e.b.FIXED) {
            b(this.f12693h, E.f12552f.f12693h, this.f12687b.C.b());
            b(this.f12694i, E.f12552f.f12694i, -this.f12687b.E.b());
            return;
        }
        g gVar2 = this.f12690e;
        boolean z5 = gVar2.f12669j;
        if (z5) {
            p.e eVar2 = this.f12687b;
            if (eVar2.f12542a) {
                p.d[] dVarArr = eVar2.J;
                p.d dVar = dVarArr[2];
                p.d dVar2 = dVar.f12536d;
                if (dVar2 != null && dVarArr[3].f12536d != null) {
                    if (eVar2.V()) {
                        this.f12693h.f12665f = this.f12687b.J[2].b();
                        this.f12694i.f12665f = -this.f12687b.J[3].b();
                    } else {
                        f h6 = h(this.f12687b.J[2]);
                        if (h6 != null) {
                            b(this.f12693h, h6, this.f12687b.J[2].b());
                        }
                        f h7 = h(this.f12687b.J[3]);
                        if (h7 != null) {
                            b(this.f12694i, h7, -this.f12687b.J[3].b());
                        }
                        this.f12693h.f12661b = true;
                        this.f12694i.f12661b = true;
                    }
                    if (!this.f12687b.Q()) {
                        return;
                    }
                } else if (dVar2 != null) {
                    f h8 = h(dVar);
                    if (h8 == null) {
                        return;
                    }
                    b(this.f12693h, h8, this.f12687b.J[2].b());
                    b(this.f12694i, this.f12693h, this.f12690e.f12666g);
                    if (!this.f12687b.Q()) {
                        return;
                    }
                } else {
                    p.d dVar3 = dVarArr[3];
                    if (dVar3.f12536d != null) {
                        f h9 = h(dVar3);
                        if (h9 != null) {
                            b(this.f12694i, h9, -this.f12687b.J[3].b());
                            b(this.f12693h, this.f12694i, -this.f12690e.f12666g);
                        }
                        if (!this.f12687b.Q()) {
                            return;
                        }
                    } else {
                        p.d dVar4 = dVarArr[4];
                        if (dVar4.f12536d != null) {
                            f h10 = h(dVar4);
                            if (h10 != null) {
                                b(this.f12683k, h10, 0);
                                b(this.f12693h, this.f12683k, -this.f12687b.l());
                                fVar3 = this.f12694i;
                                fVar4 = this.f12693h;
                                i6 = this.f12690e.f12666g;
                                b(fVar3, fVar4, i6);
                                return;
                            }
                            return;
                        } else if ((eVar2 instanceof p.h) || eVar2.E() == null || this.f12687b.k(d.b.CENTER).f12536d != null) {
                            return;
                        } else {
                            b(this.f12693h, this.f12687b.E().f12552f.f12693h, this.f12687b.P());
                            b(this.f12694i, this.f12693h, this.f12690e.f12666g);
                            if (!this.f12687b.Q()) {
                                return;
                            }
                        }
                    }
                }
                fVar3 = this.f12683k;
                fVar4 = this.f12693h;
                i6 = this.f12687b.l();
                b(fVar3, fVar4, i6);
                return;
            }
        }
        if (z5 || this.f12689d != e.b.MATCH_CONSTRAINT) {
            gVar2.b(this);
        } else {
            p.e eVar3 = this.f12687b;
            int i7 = eVar3.f12566m;
            if (i7 == 2) {
                p.e E3 = eVar3.E();
                if (E3 != null) {
                    mVar = E3.f12552f;
                    g gVar3 = mVar.f12690e;
                    this.f12690e.f12671l.add(gVar3);
                    gVar3.f12670k.add(this.f12690e);
                    g gVar4 = this.f12690e;
                    gVar4.f12661b = true;
                    gVar4.f12670k.add(this.f12693h);
                    this.f12690e.f12670k.add(this.f12694i);
                }
            } else if (i7 == 3 && !eVar3.V()) {
                p.e eVar4 = this.f12687b;
                if (eVar4.f12564l != 3) {
                    mVar = eVar4.f12550e;
                    g gVar32 = mVar.f12690e;
                    this.f12690e.f12671l.add(gVar32);
                    gVar32.f12670k.add(this.f12690e);
                    g gVar42 = this.f12690e;
                    gVar42.f12661b = true;
                    gVar42.f12670k.add(this.f12693h);
                    this.f12690e.f12670k.add(this.f12694i);
                }
            }
        }
        p.e eVar5 = this.f12687b;
        p.d[] dVarArr2 = eVar5.J;
        p.d dVar5 = dVarArr2[2];
        p.d dVar6 = dVar5.f12536d;
        if (dVar6 == null || dVarArr2[3].f12536d == null) {
            if (dVar6 != null) {
                f h11 = h(dVar5);
                if (h11 != null) {
                    b(this.f12693h, h11, this.f12687b.J[2].b());
                    c(this.f12694i, this.f12693h, 1, this.f12690e);
                    if (this.f12687b.Q()) {
                        c(this.f12683k, this.f12693h, 1, this.f12684l);
                    }
                    e.b bVar2 = this.f12689d;
                    e.b bVar3 = e.b.MATCH_CONSTRAINT;
                    if (bVar2 == bVar3 && this.f12687b.r() > 0.0f) {
                        jVar = this.f12687b.f12550e;
                    }
                }
            } else {
                p.d dVar7 = dVarArr2[3];
                if (dVar7.f12536d != null) {
                    f h12 = h(dVar7);
                    if (h12 != null) {
                        b(this.f12694i, h12, -this.f12687b.J[3].b());
                        c(this.f12693h, this.f12694i, -1, this.f12690e);
                    }
                } else {
                    p.d dVar8 = dVarArr2[4];
                    if (dVar8.f12536d != null) {
                        f h13 = h(dVar8);
                        if (h13 != null) {
                            b(this.f12683k, h13, 0);
                            c(this.f12693h, this.f12683k, -1, this.f12684l);
                            fVar = this.f12694i;
                            fVar2 = this.f12693h;
                            gVar = this.f12690e;
                        }
                    } else if (!(eVar5 instanceof p.h) && eVar5.E() != null) {
                        b(this.f12693h, this.f12687b.E().f12552f.f12693h, this.f12687b.P());
                        c(this.f12694i, this.f12693h, 1, this.f12690e);
                        if (this.f12687b.Q()) {
                            c(this.f12683k, this.f12693h, 1, this.f12684l);
                        }
                        e.b bVar4 = this.f12689d;
                        e.b bVar5 = e.b.MATCH_CONSTRAINT;
                        if (bVar4 == bVar5 && this.f12687b.r() > 0.0f) {
                            jVar = this.f12687b.f12550e;
                        }
                    }
                }
            }
            if (this.f12690e.f12671l.size() != 0) {
                this.f12690e.f12662c = true;
                return;
            }
            return;
        } else if (eVar5.V()) {
            this.f12693h.f12665f = this.f12687b.J[2].b();
            this.f12694i.f12665f = -this.f12687b.J[3].b();
        } else {
            f h14 = h(this.f12687b.J[2]);
            f h15 = h(this.f12687b.J[3]);
            h14.b(this);
            h15.b(this);
            this.f12695j = m.b.CENTER;
        }
        c(fVar, fVar2, 1, gVar);
        if (this.f12690e.f12671l.size() != 0) {
        }
    }

    @Override // q.m
    public void e() {
        f fVar = this.f12693h;
        if (fVar.f12669j) {
            this.f12687b.C0(fVar.f12666g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.m
    public void f() {
        this.f12688c = null;
        this.f12693h.c();
        this.f12694i.c();
        this.f12683k.c();
        this.f12690e.c();
        this.f12692g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.m
    public boolean m() {
        return this.f12689d != e.b.MATCH_CONSTRAINT || this.f12687b.f12566m == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.f12692g = false;
        this.f12693h.c();
        this.f12693h.f12669j = false;
        this.f12694i.c();
        this.f12694i.f12669j = false;
        this.f12683k.c();
        this.f12683k.f12669j = false;
        this.f12690e.f12669j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f12687b.p();
    }
}
