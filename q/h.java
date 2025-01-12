package q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends m {
    public h(p.e eVar) {
        super(eVar);
        eVar.f12550e.f();
        eVar.f12552f.f();
        this.f12691f = ((p.g) eVar).G0();
    }

    private void q(f fVar) {
        this.f12693h.f12670k.add(fVar);
        fVar.f12671l.add(this.f12693h);
    }

    @Override // q.m, q.d
    public void a(d dVar) {
        f fVar = this.f12693h;
        if (fVar.f12662c && !fVar.f12669j) {
            this.f12693h.d((int) ((((f) fVar.f12671l.get(0)).f12666g * ((p.g) this.f12687b).J0()) + 0.5f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.m
    public void d() {
        f fVar;
        m mVar;
        f fVar2;
        p.g gVar = (p.g) this.f12687b;
        int H0 = gVar.H0();
        int I0 = gVar.I0();
        gVar.J0();
        if (gVar.G0() == 1) {
            f fVar3 = this.f12693h;
            if (H0 != -1) {
                fVar3.f12671l.add(this.f12687b.N.f12550e.f12693h);
                this.f12687b.N.f12550e.f12693h.f12670k.add(this.f12693h);
                fVar2 = this.f12693h;
            } else if (I0 != -1) {
                fVar3.f12671l.add(this.f12687b.N.f12550e.f12694i);
                this.f12687b.N.f12550e.f12694i.f12670k.add(this.f12693h);
                fVar2 = this.f12693h;
                H0 = -I0;
            } else {
                fVar3.f12661b = true;
                fVar3.f12671l.add(this.f12687b.N.f12550e.f12694i);
                this.f12687b.N.f12550e.f12694i.f12670k.add(this.f12693h);
                q(this.f12687b.f12550e.f12693h);
                mVar = this.f12687b.f12550e;
            }
            fVar2.f12665f = H0;
            q(this.f12687b.f12550e.f12693h);
            mVar = this.f12687b.f12550e;
        } else {
            f fVar4 = this.f12693h;
            if (H0 != -1) {
                fVar4.f12671l.add(this.f12687b.N.f12552f.f12693h);
                this.f12687b.N.f12552f.f12693h.f12670k.add(this.f12693h);
                fVar = this.f12693h;
            } else if (I0 != -1) {
                fVar4.f12671l.add(this.f12687b.N.f12552f.f12694i);
                this.f12687b.N.f12552f.f12694i.f12670k.add(this.f12693h);
                fVar = this.f12693h;
                H0 = -I0;
            } else {
                fVar4.f12661b = true;
                fVar4.f12671l.add(this.f12687b.N.f12552f.f12694i);
                this.f12687b.N.f12552f.f12694i.f12670k.add(this.f12693h);
                q(this.f12687b.f12552f.f12693h);
                mVar = this.f12687b.f12552f;
            }
            fVar.f12665f = H0;
            q(this.f12687b.f12552f.f12693h);
            mVar = this.f12687b.f12552f;
        }
        q(mVar.f12694i);
    }

    @Override // q.m
    public void e() {
        if (((p.g) this.f12687b).G0() == 1) {
            this.f12687b.B0(this.f12693h.f12666g);
        } else {
            this.f12687b.C0(this.f12693h.f12666g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.m
    public void f() {
        this.f12693h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.m
    public boolean m() {
        return false;
    }
}
