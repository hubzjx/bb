package p;

import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class k extends e {

    /* renamed from: w0  reason: collision with root package name */
    public ArrayList f12602w0 = new ArrayList();

    public abstract void G0();

    public void H0(e eVar) {
        this.f12602w0.remove(eVar);
        eVar.s0(null);
    }

    public void I0() {
        this.f12602w0.clear();
    }

    @Override // p.e
    public void W() {
        this.f12602w0.clear();
        super.W();
    }

    @Override // p.e
    public void X(o.c cVar) {
        super.X(cVar);
        int size = this.f12602w0.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((e) this.f12602w0.get(i6)).X(cVar);
        }
    }

    public void c(e eVar) {
        this.f12602w0.add(eVar);
        if (eVar.E() != null) {
            ((k) eVar.E()).H0(eVar);
        }
        eVar.s0(this);
    }
}
