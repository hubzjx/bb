package q;

import java.util.List;
import p.d;
import p.e;
import q.f;
import q.m;
/* loaded from: classes.dex */
public class j extends m {

    /* renamed from: k  reason: collision with root package name */
    private static int[] f12673k = new int[2];

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12674a;

        static {
            int[] iArr = new int[m.b.values().length];
            f12674a = iArr;
            try {
                iArr[m.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12674a[m.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12674a[m.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public j(p.e eVar) {
        super(eVar);
        this.f12693h.f12664e = f.a.LEFT;
        this.f12694i.f12664e = f.a.RIGHT;
        this.f12691f = 0;
    }

    private void q(int[] iArr, int i6, int i7, int i8, int i9, float f6, int i10) {
        int i11 = i7 - i6;
        int i12 = i9 - i8;
        if (i10 != -1) {
            if (i10 == 0) {
                iArr[0] = (int) ((i12 * f6) + 0.5f);
                iArr[1] = i12;
                return;
            } else if (i10 != 1) {
                return;
            } else {
                iArr[0] = i11;
                iArr[1] = (int) ((i11 * f6) + 0.5f);
                return;
            }
        }
        int i13 = (int) ((i12 * f6) + 0.5f);
        int i14 = (int) ((i11 / f6) + 0.5f);
        if (i13 <= i11) {
            iArr[0] = i13;
            iArr[1] = i12;
        } else if (i14 <= i12) {
            iArr[0] = i11;
            iArr[1] = i14;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x0295, code lost:
        if (r14 != 1) goto L130;
     */
    @Override // q.m, q.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar) {
        int i6;
        int g6;
        int g7;
        float f6;
        g gVar;
        int g8;
        int g9;
        float f7;
        float r5;
        int i7 = a.f12674a[this.f12695j.ordinal()];
        if (i7 == 1) {
            p(dVar);
        } else if (i7 == 2) {
            o(dVar);
        } else if (i7 == 3) {
            p.e eVar = this.f12687b;
            n(dVar, eVar.B, eVar.D, 0);
            return;
        }
        if (!this.f12690e.f12669j && this.f12689d == e.b.MATCH_CONSTRAINT) {
            p.e eVar2 = this.f12687b;
            int i8 = eVar2.f12564l;
            if (i8 == 2) {
                p.e E = eVar2.E();
                if (E != null) {
                    g gVar2 = E.f12550e.f12690e;
                    if (gVar2.f12669j) {
                        i6 = (int) ((gVar2.f12666g * this.f12687b.f12574q) + 0.5f);
                        this.f12690e.d(i6);
                    }
                }
            } else if (i8 == 3) {
                int i9 = eVar2.f12566m;
                if (i9 == 0 || i9 == 3) {
                    l lVar = eVar2.f12552f;
                    f fVar = lVar.f12693h;
                    f fVar2 = lVar.f12694i;
                    boolean z5 = eVar2.B.f12536d != null;
                    boolean z6 = eVar2.C.f12536d != null;
                    boolean z7 = eVar2.D.f12536d != null;
                    boolean z8 = eVar2.E.f12536d != null;
                    int s5 = eVar2.s();
                    if (z5 && z6 && z7 && z8) {
                        float r6 = this.f12687b.r();
                        if (fVar.f12669j && fVar2.f12669j) {
                            f fVar3 = this.f12693h;
                            if (fVar3.f12662c && this.f12694i.f12662c) {
                                q(f12673k, ((f) fVar3.f12671l.get(0)).f12666g + this.f12693h.f12665f, ((f) this.f12694i.f12671l.get(0)).f12666g - this.f12694i.f12665f, fVar.f12666g + fVar.f12665f, fVar2.f12666g - fVar2.f12665f, r6, s5);
                                this.f12690e.d(f12673k[0]);
                                this.f12687b.f12552f.f12690e.d(f12673k[1]);
                                return;
                            }
                            return;
                        }
                        f fVar4 = this.f12693h;
                        if (fVar4.f12669j) {
                            f fVar5 = this.f12694i;
                            if (fVar5.f12669j) {
                                if (!fVar.f12662c || !fVar2.f12662c) {
                                    return;
                                }
                                q(f12673k, fVar4.f12666g + fVar4.f12665f, fVar5.f12666g - fVar5.f12665f, ((f) fVar.f12671l.get(0)).f12666g + fVar.f12665f, ((f) fVar2.f12671l.get(0)).f12666g - fVar2.f12665f, r6, s5);
                                this.f12690e.d(f12673k[0]);
                                this.f12687b.f12552f.f12690e.d(f12673k[1]);
                            }
                        }
                        f fVar6 = this.f12693h;
                        if (!fVar6.f12662c || !this.f12694i.f12662c || !fVar.f12662c || !fVar2.f12662c) {
                            return;
                        }
                        q(f12673k, ((f) fVar6.f12671l.get(0)).f12666g + this.f12693h.f12665f, ((f) this.f12694i.f12671l.get(0)).f12666g - this.f12694i.f12665f, ((f) fVar.f12671l.get(0)).f12666g + fVar.f12665f, ((f) fVar2.f12671l.get(0)).f12666g - fVar2.f12665f, r6, s5);
                        this.f12690e.d(f12673k[0]);
                        gVar = this.f12687b.f12552f.f12690e;
                        g6 = f12673k[1];
                    } else if (z5 && z7) {
                        if (!this.f12693h.f12662c || !this.f12694i.f12662c) {
                            return;
                        }
                        float r7 = this.f12687b.r();
                        int i10 = ((f) this.f12693h.f12671l.get(0)).f12666g + this.f12693h.f12665f;
                        int i11 = ((f) this.f12694i.f12671l.get(0)).f12666g - this.f12694i.f12665f;
                        if (s5 == -1 || s5 == 0) {
                            g8 = g(i11 - i10, 0);
                            int i12 = (int) ((g8 * r7) + 0.5f);
                            g9 = g(i12, 1);
                            if (i12 != g9) {
                                f7 = g9 / r7;
                                g8 = (int) (f7 + 0.5f);
                            }
                            this.f12690e.d(g8);
                            this.f12687b.f12552f.f12690e.d(g9);
                        } else if (s5 == 1) {
                            g8 = g(i11 - i10, 0);
                            int i13 = (int) ((g8 / r7) + 0.5f);
                            g9 = g(i13, 1);
                            if (i13 != g9) {
                                f7 = g9 * r7;
                                g8 = (int) (f7 + 0.5f);
                            }
                            this.f12690e.d(g8);
                            this.f12687b.f12552f.f12690e.d(g9);
                        }
                    } else if (z6 && z8) {
                        if (!fVar.f12662c || !fVar2.f12662c) {
                            return;
                        }
                        float r8 = this.f12687b.r();
                        int i14 = ((f) fVar.f12671l.get(0)).f12666g + fVar.f12665f;
                        int i15 = ((f) fVar2.f12671l.get(0)).f12666g - fVar2.f12665f;
                        if (s5 != -1) {
                            if (s5 == 0) {
                                g6 = g(i15 - i14, 1);
                                int i16 = (int) ((g6 * r8) + 0.5f);
                                g7 = g(i16, 0);
                                if (i16 != g7) {
                                    f6 = g7 / r8;
                                    g6 = (int) (f6 + 0.5f);
                                }
                                this.f12690e.d(g7);
                                gVar = this.f12687b.f12552f.f12690e;
                            }
                        }
                        g6 = g(i15 - i14, 1);
                        int i17 = (int) ((g6 / r8) + 0.5f);
                        g7 = g(i17, 0);
                        if (i17 != g7) {
                            f6 = g7 * r8;
                            g6 = (int) (f6 + 0.5f);
                        }
                        this.f12690e.d(g7);
                        gVar = this.f12687b.f12552f.f12690e;
                    }
                    gVar.d(g6);
                } else {
                    int s6 = eVar2.s();
                    if (s6 != -1) {
                        if (s6 == 0) {
                            p.e eVar3 = this.f12687b;
                            r5 = eVar3.f12552f.f12690e.f12666g / eVar3.r();
                            i6 = (int) (r5 + 0.5f);
                            this.f12690e.d(i6);
                        } else if (s6 != 1) {
                            i6 = 0;
                            this.f12690e.d(i6);
                        }
                    }
                    p.e eVar4 = this.f12687b;
                    r5 = eVar4.f12552f.f12690e.f12666g * eVar4.r();
                    i6 = (int) (r5 + 0.5f);
                    this.f12690e.d(i6);
                }
            }
        }
        f fVar7 = this.f12693h;
        if (fVar7.f12662c) {
            f fVar8 = this.f12694i;
            if (fVar8.f12662c) {
                if (fVar7.f12669j && fVar8.f12669j && this.f12690e.f12669j) {
                    return;
                }
                if (!this.f12690e.f12669j && this.f12689d == e.b.MATCH_CONSTRAINT) {
                    p.e eVar5 = this.f12687b;
                    if (eVar5.f12564l == 0 && !eVar5.T()) {
                        int i18 = ((f) this.f12693h.f12671l.get(0)).f12666g;
                        f fVar9 = this.f12693h;
                        int i19 = i18 + fVar9.f12665f;
                        int i20 = ((f) this.f12694i.f12671l.get(0)).f12666g + this.f12694i.f12665f;
                        fVar9.d(i19);
                        this.f12694i.d(i20);
                        this.f12690e.d(i20 - i19);
                        return;
                    }
                }
                if (!this.f12690e.f12669j && this.f12689d == e.b.MATCH_CONSTRAINT && this.f12686a == 1 && this.f12693h.f12671l.size() > 0 && this.f12694i.f12671l.size() > 0) {
                    int min = Math.min((((f) this.f12694i.f12671l.get(0)).f12666g + this.f12694i.f12665f) - (((f) this.f12693h.f12671l.get(0)).f12666g + this.f12693h.f12665f), this.f12690e.f12672m);
                    p.e eVar6 = this.f12687b;
                    int i21 = eVar6.f12572p;
                    int max = Math.max(eVar6.f12570o, min);
                    if (i21 > 0) {
                        max = Math.min(i21, max);
                    }
                    this.f12690e.d(max);
                }
                if (this.f12690e.f12669j) {
                    f fVar10 = (f) this.f12693h.f12671l.get(0);
                    f fVar11 = (f) this.f12694i.f12671l.get(0);
                    int i22 = fVar10.f12666g + this.f12693h.f12665f;
                    int i23 = fVar11.f12666g + this.f12694i.f12665f;
                    float u5 = this.f12687b.u();
                    if (fVar10 == fVar11) {
                        i22 = fVar10.f12666g;
                        i23 = fVar11.f12666g;
                        u5 = 0.5f;
                    }
                    this.f12693h.d((int) (i22 + 0.5f + (((i23 - i22) - this.f12690e.f12666g) * u5)));
                    this.f12694i.d(this.f12693h.f12666g + this.f12690e.f12666g);
                }
            }
        }
    }

    @Override // q.m
    void d() {
        p.e E;
        f fVar;
        f fVar2;
        int O;
        f fVar3;
        p.d dVar;
        List list;
        d dVar2;
        f fVar4;
        f fVar5;
        f fVar6;
        int O2;
        f fVar7;
        f fVar8;
        int i6;
        p.e E2;
        p.e eVar = this.f12687b;
        if (eVar.f12542a) {
            this.f12690e.d(eVar.N());
        }
        if (this.f12690e.f12669j) {
            e.b bVar = this.f12689d;
            e.b bVar2 = e.b.MATCH_PARENT;
            if (bVar == bVar2 && (((E = this.f12687b.E()) != null && E.w() == e.b.FIXED) || E.w() == bVar2)) {
                b(this.f12693h, E.f12550e.f12693h, this.f12687b.B.b());
                b(this.f12694i, E.f12550e.f12694i, -this.f12687b.D.b());
                return;
            }
        } else {
            e.b w5 = this.f12687b.w();
            this.f12689d = w5;
            if (w5 != e.b.MATCH_CONSTRAINT) {
                e.b bVar3 = e.b.MATCH_PARENT;
                if (w5 == bVar3 && (((E2 = this.f12687b.E()) != null && E2.w() == e.b.FIXED) || E2.w() == bVar3)) {
                    int N = (E2.N() - this.f12687b.B.b()) - this.f12687b.D.b();
                    b(this.f12693h, E2.f12550e.f12693h, this.f12687b.B.b());
                    b(this.f12694i, E2.f12550e.f12694i, -this.f12687b.D.b());
                    this.f12690e.d(N);
                    return;
                } else if (this.f12689d == e.b.FIXED) {
                    this.f12690e.d(this.f12687b.N());
                }
            }
        }
        g gVar = this.f12690e;
        if (gVar.f12669j) {
            p.e eVar2 = this.f12687b;
            if (eVar2.f12542a) {
                p.d[] dVarArr = eVar2.J;
                p.d dVar3 = dVarArr[0];
                p.d dVar4 = dVar3.f12536d;
                if (dVar4 != null && dVarArr[1].f12536d != null) {
                    if (eVar2.T()) {
                        this.f12693h.f12665f = this.f12687b.J[0].b();
                        fVar3 = this.f12694i;
                        dVar = this.f12687b.J[1];
                        fVar3.f12665f = -dVar.b();
                        return;
                    }
                    f h6 = h(this.f12687b.J[0]);
                    if (h6 != null) {
                        b(this.f12693h, h6, this.f12687b.J[0].b());
                    }
                    f h7 = h(this.f12687b.J[1]);
                    if (h7 != null) {
                        b(this.f12694i, h7, -this.f12687b.J[1].b());
                    }
                    this.f12693h.f12661b = true;
                    this.f12694i.f12661b = true;
                    return;
                }
                if (dVar4 != null) {
                    fVar5 = h(dVar3);
                    if (fVar5 == null) {
                        return;
                    }
                    fVar6 = this.f12693h;
                    O2 = this.f12687b.J[0].b();
                } else {
                    p.d dVar5 = dVarArr[1];
                    if (dVar5.f12536d != null) {
                        f h8 = h(dVar5);
                        if (h8 != null) {
                            b(this.f12694i, h8, -this.f12687b.J[1].b());
                            fVar7 = this.f12693h;
                            fVar8 = this.f12694i;
                            i6 = -this.f12690e.f12666g;
                            b(fVar7, fVar8, i6);
                            return;
                        }
                        return;
                    } else if ((eVar2 instanceof p.h) || eVar2.E() == null || this.f12687b.k(d.b.CENTER).f12536d != null) {
                        return;
                    } else {
                        fVar5 = this.f12687b.E().f12550e.f12693h;
                        fVar6 = this.f12693h;
                        O2 = this.f12687b.O();
                    }
                }
                b(fVar6, fVar5, O2);
                fVar7 = this.f12694i;
                fVar8 = this.f12693h;
                i6 = this.f12690e.f12666g;
                b(fVar7, fVar8, i6);
                return;
            }
        }
        if (this.f12689d == e.b.MATCH_CONSTRAINT) {
            p.e eVar3 = this.f12687b;
            int i7 = eVar3.f12564l;
            if (i7 == 2) {
                p.e E3 = eVar3.E();
                if (E3 != null) {
                    g gVar2 = E3.f12552f.f12690e;
                    this.f12690e.f12671l.add(gVar2);
                    gVar2.f12670k.add(this.f12690e);
                    g gVar3 = this.f12690e;
                    gVar3.f12661b = true;
                    gVar3.f12670k.add(this.f12693h);
                    list = this.f12690e.f12670k;
                    dVar2 = this.f12694i;
                    list.add(dVar2);
                }
            } else if (i7 == 3) {
                if (eVar3.f12566m == 3) {
                    this.f12693h.f12660a = this;
                    this.f12694i.f12660a = this;
                    l lVar = eVar3.f12552f;
                    lVar.f12693h.f12660a = this;
                    lVar.f12694i.f12660a = this;
                    gVar.f12660a = this;
                    if (eVar3.V()) {
                        this.f12690e.f12671l.add(this.f12687b.f12552f.f12690e);
                        this.f12687b.f12552f.f12690e.f12670k.add(this.f12690e);
                        l lVar2 = this.f12687b.f12552f;
                        lVar2.f12690e.f12660a = this;
                        this.f12690e.f12671l.add(lVar2.f12693h);
                        this.f12690e.f12671l.add(this.f12687b.f12552f.f12694i);
                        this.f12687b.f12552f.f12693h.f12670k.add(this.f12690e);
                        list = this.f12687b.f12552f.f12694i.f12670k;
                        dVar2 = this.f12690e;
                        list.add(dVar2);
                    } else if (this.f12687b.T()) {
                        this.f12687b.f12552f.f12690e.f12671l.add(this.f12690e);
                        list = this.f12690e.f12670k;
                        dVar2 = this.f12687b.f12552f.f12690e;
                        list.add(dVar2);
                    } else {
                        fVar4 = this.f12687b.f12552f.f12690e;
                    }
                } else {
                    g gVar4 = eVar3.f12552f.f12690e;
                    gVar.f12671l.add(gVar4);
                    gVar4.f12670k.add(this.f12690e);
                    this.f12687b.f12552f.f12693h.f12670k.add(this.f12690e);
                    this.f12687b.f12552f.f12694i.f12670k.add(this.f12690e);
                    g gVar5 = this.f12690e;
                    gVar5.f12661b = true;
                    gVar5.f12670k.add(this.f12693h);
                    this.f12690e.f12670k.add(this.f12694i);
                    this.f12693h.f12671l.add(this.f12690e);
                    fVar4 = this.f12694i;
                }
                list = fVar4.f12671l;
                dVar2 = this.f12690e;
                list.add(dVar2);
            }
            fVar3.f12665f = -dVar.b();
            return;
        }
        p.e eVar4 = this.f12687b;
        p.d[] dVarArr2 = eVar4.J;
        p.d dVar6 = dVarArr2[0];
        p.d dVar7 = dVar6.f12536d;
        if (dVar7 != null && dVarArr2[1].f12536d != null) {
            if (eVar4.T()) {
                this.f12693h.f12665f = this.f12687b.J[0].b();
                fVar3 = this.f12694i;
                dVar = this.f12687b.J[1];
                fVar3.f12665f = -dVar.b();
                return;
            }
            f h9 = h(this.f12687b.J[0]);
            f h10 = h(this.f12687b.J[1]);
            h9.b(this);
            h10.b(this);
            this.f12695j = m.b.CENTER;
            return;
        }
        if (dVar7 != null) {
            fVar = h(dVar6);
            if (fVar == null) {
                return;
            }
            fVar2 = this.f12693h;
            O = this.f12687b.J[0].b();
        } else {
            p.d dVar8 = dVarArr2[1];
            if (dVar8.f12536d != null) {
                f h11 = h(dVar8);
                if (h11 != null) {
                    b(this.f12694i, h11, -this.f12687b.J[1].b());
                    c(this.f12693h, this.f12694i, -1, this.f12690e);
                    return;
                }
                return;
            } else if ((eVar4 instanceof p.h) || eVar4.E() == null) {
                return;
            } else {
                fVar = this.f12687b.E().f12550e.f12693h;
                fVar2 = this.f12693h;
                O = this.f12687b.O();
            }
        }
        b(fVar2, fVar, O);
        c(this.f12694i, this.f12693h, 1, this.f12690e);
    }

    @Override // q.m
    public void e() {
        f fVar = this.f12693h;
        if (fVar.f12669j) {
            this.f12687b.B0(fVar.f12666g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.m
    public void f() {
        this.f12688c = null;
        this.f12693h.c();
        this.f12694i.c();
        this.f12690e.c();
        this.f12692g = false;
    }

    @Override // q.m
    boolean m() {
        return this.f12689d != e.b.MATCH_CONSTRAINT || this.f12687b.f12564l == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.f12692g = false;
        this.f12693h.c();
        this.f12693h.f12669j = false;
        this.f12694i.c();
        this.f12694i.f12669j = false;
        this.f12690e.f12669j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f12687b.p();
    }
}
