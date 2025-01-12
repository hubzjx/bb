package p;

import p.e;
/* loaded from: classes.dex */
public class a extends i {

    /* renamed from: y0  reason: collision with root package name */
    private int f12509y0 = 0;

    /* renamed from: z0  reason: collision with root package name */
    private boolean f12510z0 = true;
    private int A0 = 0;

    public boolean G0() {
        return this.f12510z0;
    }

    public int H0() {
        return this.f12509y0;
    }

    public int I0() {
        return this.A0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J0() {
        for (int i6 = 0; i6 < this.f12600x0; i6++) {
            e eVar = this.f12599w0[i6];
            int i7 = this.f12509y0;
            if (i7 == 0 || i7 == 1) {
                eVar.l0(0, true);
            } else if (i7 == 2 || i7 == 3) {
                eVar.l0(1, true);
            }
        }
    }

    public void K0(boolean z5) {
        this.f12510z0 = z5;
    }

    public void L0(int i6) {
        this.f12509y0 = i6;
    }

    public void M0(int i6) {
        this.A0 = i6;
    }

    @Override // p.e
    public void f(o.d dVar) {
        d[] dVarArr;
        boolean z5;
        o.i iVar;
        d dVar2;
        int i6;
        int i7;
        int i8;
        d[] dVarArr2 = this.J;
        dVarArr2[0] = this.B;
        dVarArr2[2] = this.C;
        dVarArr2[1] = this.D;
        dVarArr2[3] = this.E;
        int i9 = 0;
        while (true) {
            dVarArr = this.J;
            if (i9 >= dVarArr.length) {
                break;
            }
            d dVar3 = dVarArr[i9];
            dVar3.f12539g = dVar.q(dVar3);
            i9++;
        }
        int i10 = this.f12509y0;
        if (i10 < 0 || i10 >= 4) {
            return;
        }
        d dVar4 = dVarArr[i10];
        for (int i11 = 0; i11 < this.f12600x0; i11++) {
            e eVar = this.f12599w0[i11];
            if ((this.f12510z0 || eVar.g()) && ((((i7 = this.f12509y0) == 0 || i7 == 1) && eVar.w() == e.b.MATCH_CONSTRAINT && eVar.B.f12536d != null && eVar.D.f12536d != null) || (((i8 = this.f12509y0) == 2 || i8 == 3) && eVar.K() == e.b.MATCH_CONSTRAINT && eVar.C.f12536d != null && eVar.E.f12536d != null))) {
                z5 = true;
                break;
            }
        }
        z5 = false;
        boolean z6 = this.B.h() || this.D.h();
        boolean z7 = this.C.h() || this.E.h();
        int i12 = !(!z5 && (((i6 = this.f12509y0) == 0 && z6) || ((i6 == 2 && z7) || ((i6 == 1 && z6) || (i6 == 3 && z7))))) ? 4 : 5;
        for (int i13 = 0; i13 < this.f12600x0; i13++) {
            e eVar2 = this.f12599w0[i13];
            if (this.f12510z0 || eVar2.g()) {
                o.i q5 = dVar.q(eVar2.J[this.f12509y0]);
                d[] dVarArr3 = eVar2.J;
                int i14 = this.f12509y0;
                d dVar5 = dVarArr3[i14];
                dVar5.f12539g = q5;
                d dVar6 = dVar5.f12536d;
                int i15 = (dVar6 == null || dVar6.f12534b != this) ? 0 : dVar5.f12537e + 0;
                if (i14 == 0 || i14 == 2) {
                    dVar.i(dVar4.f12539g, q5, this.A0 - i15, z5);
                } else {
                    dVar.g(dVar4.f12539g, q5, this.A0 + i15, z5);
                }
                dVar.e(dVar4.f12539g, q5, this.A0 + i15, i12);
            }
        }
        int i16 = this.f12509y0;
        if (i16 == 0) {
            dVar.e(this.D.f12539g, this.B.f12539g, 0, 8);
            dVar.e(this.B.f12539g, this.N.D.f12539g, 0, 4);
            iVar = this.B.f12539g;
            dVar2 = this.N.B;
        } else if (i16 == 1) {
            dVar.e(this.B.f12539g, this.D.f12539g, 0, 8);
            dVar.e(this.B.f12539g, this.N.B.f12539g, 0, 4);
            iVar = this.B.f12539g;
            dVar2 = this.N.D;
        } else if (i16 == 2) {
            dVar.e(this.E.f12539g, this.C.f12539g, 0, 8);
            dVar.e(this.C.f12539g, this.N.E.f12539g, 0, 4);
            iVar = this.C.f12539g;
            dVar2 = this.N.C;
        } else if (i16 != 3) {
            return;
        } else {
            dVar.e(this.C.f12539g, this.E.f12539g, 0, 8);
            dVar.e(this.C.f12539g, this.N.C.f12539g, 0, 4);
            iVar = this.C.f12539g;
            dVar2 = this.N.E;
        }
        dVar.e(iVar, dVar2.f12539g, 0, 0);
    }

    @Override // p.e
    public boolean g() {
        return true;
    }

    @Override // p.e
    public String toString() {
        String str = "[Barrier] " + p() + " {";
        for (int i6 = 0; i6 < this.f12600x0; i6++) {
            e eVar = this.f12599w0[i6];
            if (i6 > 0) {
                str = str + ", ";
            }
            str = str + eVar.p();
        }
        return str + "}";
    }
}
