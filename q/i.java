package q;

import q.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends m {
    public i(p.e eVar) {
        super(eVar);
    }

    private void q(f fVar) {
        this.f12693h.f12670k.add(fVar);
        fVar.f12671l.add(this.f12693h);
    }

    @Override // q.m, q.d
    public void a(d dVar) {
        p.a aVar = (p.a) this.f12687b;
        int H0 = aVar.H0();
        int i6 = 0;
        int i7 = -1;
        for (f fVar : this.f12693h.f12671l) {
            int i8 = fVar.f12666g;
            if (i7 == -1 || i8 < i7) {
                i7 = i8;
            }
            if (i6 < i8) {
                i6 = i8;
            }
        }
        if (H0 == 0 || H0 == 2) {
            this.f12693h.d(i7 + aVar.I0());
        } else {
            this.f12693h.d(i6 + aVar.I0());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.m
    public void d() {
        m mVar;
        p.e eVar = this.f12687b;
        if (eVar instanceof p.a) {
            this.f12693h.f12661b = true;
            p.a aVar = (p.a) eVar;
            int H0 = aVar.H0();
            boolean G0 = aVar.G0();
            int i6 = 0;
            if (H0 == 0) {
                this.f12693h.f12664e = f.a.LEFT;
                while (i6 < aVar.f12600x0) {
                    p.e eVar2 = aVar.f12599w0[i6];
                    if (G0 || eVar2.M() != 8) {
                        f fVar = eVar2.f12550e.f12693h;
                        fVar.f12670k.add(this.f12693h);
                        this.f12693h.f12671l.add(fVar);
                    }
                    i6++;
                }
            } else if (H0 != 1) {
                if (H0 == 2) {
                    this.f12693h.f12664e = f.a.TOP;
                    while (i6 < aVar.f12600x0) {
                        p.e eVar3 = aVar.f12599w0[i6];
                        if (G0 || eVar3.M() != 8) {
                            f fVar2 = eVar3.f12552f.f12693h;
                            fVar2.f12670k.add(this.f12693h);
                            this.f12693h.f12671l.add(fVar2);
                        }
                        i6++;
                    }
                } else if (H0 != 3) {
                    return;
                } else {
                    this.f12693h.f12664e = f.a.BOTTOM;
                    while (i6 < aVar.f12600x0) {
                        p.e eVar4 = aVar.f12599w0[i6];
                        if (G0 || eVar4.M() != 8) {
                            f fVar3 = eVar4.f12552f.f12694i;
                            fVar3.f12670k.add(this.f12693h);
                            this.f12693h.f12671l.add(fVar3);
                        }
                        i6++;
                    }
                }
                q(this.f12687b.f12552f.f12693h);
                mVar = this.f12687b.f12552f;
                q(mVar.f12694i);
            } else {
                this.f12693h.f12664e = f.a.RIGHT;
                while (i6 < aVar.f12600x0) {
                    p.e eVar5 = aVar.f12599w0[i6];
                    if (G0 || eVar5.M() != 8) {
                        f fVar4 = eVar5.f12550e.f12694i;
                        fVar4.f12670k.add(this.f12693h);
                        this.f12693h.f12671l.add(fVar4);
                    }
                    i6++;
                }
            }
            q(this.f12687b.f12550e.f12693h);
            mVar = this.f12687b.f12550e;
            q(mVar.f12694i);
        }
    }

    @Override // q.m
    public void e() {
        p.e eVar = this.f12687b;
        if (eVar instanceof p.a) {
            int H0 = ((p.a) eVar).H0();
            if (H0 == 0 || H0 == 1) {
                this.f12687b.B0(this.f12693h.f12666g);
            } else {
                this.f12687b.C0(this.f12693h.f12666g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.m
    public void f() {
        this.f12688c = null;
        this.f12693h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.m
    public boolean m() {
        return false;
    }
}
