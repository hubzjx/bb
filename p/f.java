package p;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import p.e;
import q.b;
/* loaded from: classes.dex */
public class f extends k {
    int C0;
    int D0;
    int E0;
    int F0;

    /* renamed from: x0  reason: collision with root package name */
    q.b f12591x0 = new q.b(this);

    /* renamed from: y0  reason: collision with root package name */
    public q.e f12592y0 = new q.e(this);

    /* renamed from: z0  reason: collision with root package name */
    protected b.InterfaceC0206b f12593z0 = null;
    private boolean A0 = false;
    protected o.d B0 = new o.d();
    int G0 = 0;
    int H0 = 0;
    c[] I0 = new c[4];
    c[] J0 = new c[4];
    public boolean K0 = false;
    public boolean L0 = false;
    public boolean M0 = false;
    public int N0 = 0;
    public int O0 = 0;
    private int P0 = 263;
    public boolean Q0 = false;
    private boolean R0 = false;
    private boolean S0 = false;
    int T0 = 0;

    private void L0(e eVar) {
        int i6 = this.G0 + 1;
        c[] cVarArr = this.J0;
        if (i6 >= cVarArr.length) {
            this.J0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.J0[this.G0] = new c(eVar, 0, V0());
        this.G0++;
    }

    private void M0(e eVar) {
        int i6 = this.H0 + 1;
        c[] cVarArr = this.I0;
        if (i6 >= cVarArr.length) {
            this.I0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.I0[this.H0] = new c(eVar, 1, V0());
        this.H0++;
    }

    private void Z0() {
        this.G0 = 0;
        this.H0 = 0;
    }

    @Override // p.e
    public void E0(boolean z5, boolean z6) {
        super.E0(z5, z6);
        int size = this.f12602w0.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((e) this.f12602w0.get(i6)).E0(z5, z6);
        }
    }

    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [boolean] */
    @Override // p.k
    public void G0() {
        boolean z5;
        ?? r11;
        boolean z6;
        this.S = 0;
        this.T = 0;
        int max = Math.max(0, N());
        int max2 = Math.max(0, t());
        this.R0 = false;
        this.S0 = false;
        boolean z7 = Y0(64) || Y0(128);
        o.d dVar = this.B0;
        dVar.f12288g = false;
        dVar.f12289h = false;
        if (this.P0 != 0 && z7) {
            dVar.f12289h = true;
        }
        e.b[] bVarArr = this.M;
        e.b bVar = bVarArr[1];
        e.b bVar2 = bVarArr[0];
        ArrayList arrayList = this.f12602w0;
        e.b w5 = w();
        e.b bVar3 = e.b.WRAP_CONTENT;
        boolean z8 = w5 == bVar3 || K() == bVar3;
        Z0();
        int size = this.f12602w0.size();
        for (int i6 = 0; i6 < size; i6++) {
            e eVar = (e) this.f12602w0.get(i6);
            if (eVar instanceof k) {
                ((k) eVar).G0();
            }
        }
        int i7 = 0;
        boolean z9 = true;
        boolean z10 = false;
        while (z9) {
            int i8 = i7 + 1;
            try {
                this.B0.D();
                Z0();
                j(this.B0);
                for (int i9 = 0; i9 < size; i9++) {
                    ((e) this.f12602w0.get(i9)).j(this.B0);
                }
                z9 = K0(this.B0);
                if (z9) {
                    this.B0.z();
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                PrintStream printStream = System.out;
                printStream.println("EXCEPTION : " + e6);
            }
            o.d dVar2 = this.B0;
            if (z9) {
                d1(dVar2, j.f12601a);
            } else {
                F0(dVar2);
                for (int i10 = 0; i10 < size; i10++) {
                    ((e) this.f12602w0.get(i10)).F0(this.B0);
                }
            }
            if (z8 && i8 < 8 && j.f12601a[2]) {
                int i11 = 0;
                int i12 = 0;
                for (int i13 = 0; i13 < size; i13++) {
                    e eVar2 = (e) this.f12602w0.get(i13);
                    i11 = Math.max(i11, eVar2.S + eVar2.N());
                    i12 = Math.max(i12, eVar2.T + eVar2.t());
                }
                int max3 = Math.max(this.Z, i11);
                int max4 = Math.max(this.f12543a0, i12);
                e.b bVar4 = e.b.WRAP_CONTENT;
                if (bVar2 != bVar4 || N() >= max3) {
                    z5 = false;
                } else {
                    A0(max3);
                    this.M[0] = bVar4;
                    z5 = true;
                    z10 = true;
                }
                if (bVar == bVar4 && t() < max4) {
                    e0(max4);
                    this.M[1] = bVar4;
                    z5 = true;
                    z10 = true;
                }
            } else {
                z5 = false;
            }
            int max5 = Math.max(this.Z, N());
            if (max5 > N()) {
                A0(max5);
                this.M[0] = e.b.FIXED;
                z5 = true;
                z10 = true;
            }
            int max6 = Math.max(this.f12543a0, t());
            if (max6 > t()) {
                e0(max6);
                r11 = 1;
                this.M[1] = e.b.FIXED;
                z5 = true;
                z6 = true;
            } else {
                r11 = 1;
                z6 = z10;
            }
            if (!z6) {
                e.b bVar5 = this.M[0];
                e.b bVar6 = e.b.WRAP_CONTENT;
                if (bVar5 == bVar6 && max > 0 && N() > max) {
                    this.R0 = r11;
                    this.M[0] = e.b.FIXED;
                    A0(max);
                    z5 = true;
                    z6 = true;
                }
                if (this.M[r11] == bVar6 && max2 > 0 && t() > max2) {
                    this.S0 = r11;
                    this.M[r11] = e.b.FIXED;
                    e0(max2);
                    z9 = true;
                    z10 = true;
                    i7 = i8;
                }
            }
            z9 = z5;
            z10 = z6;
            i7 = i8;
        }
        this.f12602w0 = arrayList;
        if (z10) {
            e.b[] bVarArr2 = this.M;
            bVarArr2[0] = bVar2;
            bVarArr2[1] = bVar;
        }
        X(this.B0.v());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J0(e eVar, int i6) {
        if (i6 == 0) {
            L0(eVar);
        } else if (i6 == 1) {
            M0(eVar);
        }
    }

    public boolean K0(o.d dVar) {
        f(dVar);
        int size = this.f12602w0.size();
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            e eVar = (e) this.f12602w0.get(i6);
            eVar.l0(0, false);
            eVar.l0(1, false);
            if (eVar instanceof a) {
                z5 = true;
            }
        }
        if (z5) {
            for (int i7 = 0; i7 < size; i7++) {
                e eVar2 = (e) this.f12602w0.get(i7);
                if (eVar2 instanceof a) {
                    ((a) eVar2).J0();
                }
            }
        }
        for (int i8 = 0; i8 < size; i8++) {
            e eVar3 = (e) this.f12602w0.get(i8);
            if (eVar3.e()) {
                eVar3.f(dVar);
            }
        }
        for (int i9 = 0; i9 < size; i9++) {
            e eVar4 = (e) this.f12602w0.get(i9);
            if (eVar4 instanceof f) {
                e.b[] bVarArr = eVar4.M;
                e.b bVar = bVarArr[0];
                e.b bVar2 = bVarArr[1];
                e.b bVar3 = e.b.WRAP_CONTENT;
                if (bVar == bVar3) {
                    eVar4.i0(e.b.FIXED);
                }
                if (bVar2 == bVar3) {
                    eVar4.w0(e.b.FIXED);
                }
                eVar4.f(dVar);
                if (bVar == bVar3) {
                    eVar4.i0(bVar);
                }
                if (bVar2 == bVar3) {
                    eVar4.w0(bVar2);
                }
            } else {
                j.a(this, dVar, eVar4);
                if (!eVar4.e()) {
                    eVar4.f(dVar);
                }
            }
        }
        if (this.G0 > 0) {
            b.a(this, dVar, 0);
        }
        if (this.H0 > 0) {
            b.a(this, dVar, 1);
        }
        return true;
    }

    public boolean N0(boolean z5) {
        return this.f12592y0.f(z5);
    }

    public boolean O0(boolean z5) {
        return this.f12592y0.g(z5);
    }

    public boolean P0(boolean z5, int i6) {
        return this.f12592y0.h(z5, i6);
    }

    public b.InterfaceC0206b Q0() {
        return this.f12593z0;
    }

    public int R0() {
        return this.P0;
    }

    public void S0() {
        this.f12592y0.j();
    }

    public void T0() {
        this.f12592y0.k();
    }

    public boolean U0() {
        return this.S0;
    }

    public boolean V0() {
        return this.A0;
    }

    @Override // p.k, p.e
    public void W() {
        this.B0.D();
        this.C0 = 0;
        this.E0 = 0;
        this.D0 = 0;
        this.F0 = 0;
        this.Q0 = false;
        super.W();
    }

    public boolean W0() {
        return this.R0;
    }

    public long X0(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        this.C0 = i13;
        this.D0 = i14;
        return this.f12591x0.d(this, i6, i13, i14, i7, i8, i9, i10, i11, i12);
    }

    public boolean Y0(int i6) {
        return (this.P0 & i6) == i6;
    }

    public void a1(b.InterfaceC0206b interfaceC0206b) {
        this.f12593z0 = interfaceC0206b;
        this.f12592y0.n(interfaceC0206b);
    }

    public void b1(int i6) {
        this.P0 = i6;
        o.d.f12279r = j.b(i6, 256);
    }

    public void c1(boolean z5) {
        this.A0 = z5;
    }

    public void d1(o.d dVar, boolean[] zArr) {
        zArr[2] = false;
        F0(dVar);
        int size = this.f12602w0.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((e) this.f12602w0.get(i6)).F0(dVar);
        }
    }

    public void e1() {
        this.f12591x0.e(this);
    }
}
