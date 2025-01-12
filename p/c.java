package p;

import java.util.ArrayList;
import p.e;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    protected e f12511a;

    /* renamed from: b  reason: collision with root package name */
    protected e f12512b;

    /* renamed from: c  reason: collision with root package name */
    protected e f12513c;

    /* renamed from: d  reason: collision with root package name */
    protected e f12514d;

    /* renamed from: e  reason: collision with root package name */
    protected e f12515e;

    /* renamed from: f  reason: collision with root package name */
    protected e f12516f;

    /* renamed from: g  reason: collision with root package name */
    protected e f12517g;

    /* renamed from: h  reason: collision with root package name */
    protected ArrayList f12518h;

    /* renamed from: i  reason: collision with root package name */
    protected int f12519i;

    /* renamed from: j  reason: collision with root package name */
    protected int f12520j;

    /* renamed from: k  reason: collision with root package name */
    protected float f12521k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    int f12522l;

    /* renamed from: m  reason: collision with root package name */
    int f12523m;

    /* renamed from: n  reason: collision with root package name */
    int f12524n;

    /* renamed from: o  reason: collision with root package name */
    boolean f12525o;

    /* renamed from: p  reason: collision with root package name */
    private int f12526p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f12527q;

    /* renamed from: r  reason: collision with root package name */
    protected boolean f12528r;

    /* renamed from: s  reason: collision with root package name */
    protected boolean f12529s;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f12530t;

    /* renamed from: u  reason: collision with root package name */
    protected boolean f12531u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f12532v;

    public c(e eVar, int i6, boolean z5) {
        this.f12511a = eVar;
        this.f12526p = i6;
        this.f12527q = z5;
    }

    private void b() {
        int i6 = this.f12526p * 2;
        e eVar = this.f12511a;
        boolean z5 = true;
        this.f12525o = true;
        e eVar2 = eVar;
        boolean z6 = false;
        while (!z6) {
            this.f12519i++;
            e[] eVarArr = eVar.f12579s0;
            int i7 = this.f12526p;
            e eVar3 = null;
            eVarArr[i7] = null;
            eVar.f12577r0[i7] = null;
            if (eVar.M() != 8) {
                this.f12522l++;
                e.b q5 = eVar.q(this.f12526p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (q5 != bVar) {
                    this.f12523m += eVar.y(this.f12526p);
                }
                int b6 = this.f12523m + eVar.J[i6].b();
                this.f12523m = b6;
                int i8 = i6 + 1;
                this.f12523m = b6 + eVar.J[i8].b();
                int b7 = this.f12524n + eVar.J[i6].b();
                this.f12524n = b7;
                this.f12524n = b7 + eVar.J[i8].b();
                if (this.f12512b == null) {
                    this.f12512b = eVar;
                }
                this.f12514d = eVar;
                e.b[] bVarArr = eVar.M;
                int i9 = this.f12526p;
                if (bVarArr[i9] == bVar) {
                    int i10 = eVar.f12568n[i9];
                    if (i10 == 0 || i10 == 3 || i10 == 2) {
                        this.f12520j++;
                        float f6 = eVar.f12575q0[i9];
                        if (f6 > 0.0f) {
                            this.f12521k += f6;
                        }
                        if (c(eVar, i9)) {
                            if (f6 < 0.0f) {
                                this.f12528r = true;
                            } else {
                                this.f12529s = true;
                            }
                            if (this.f12518h == null) {
                                this.f12518h = new ArrayList();
                            }
                            this.f12518h.add(eVar);
                        }
                        if (this.f12516f == null) {
                            this.f12516f = eVar;
                        }
                        e eVar4 = this.f12517g;
                        if (eVar4 != null) {
                            eVar4.f12577r0[this.f12526p] = eVar;
                        }
                        this.f12517g = eVar;
                    }
                    if (this.f12526p != 0 ? !(eVar.f12566m == 0 && eVar.f12576r == 0 && eVar.f12578s == 0) : !(eVar.f12564l == 0 && eVar.f12570o == 0 && eVar.f12572p == 0)) {
                        this.f12525o = false;
                    }
                    if (eVar.Q != 0.0f) {
                        this.f12525o = false;
                        this.f12531u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.f12579s0[this.f12526p] = eVar;
            }
            d dVar = eVar.J[i6 + 1].f12536d;
            if (dVar != null) {
                e eVar5 = dVar.f12534b;
                d dVar2 = eVar5.J[i6].f12536d;
                if (dVar2 != null && dVar2.f12534b == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z6 = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f12512b;
        if (eVar6 != null) {
            this.f12523m -= eVar6.J[i6].b();
        }
        e eVar7 = this.f12514d;
        if (eVar7 != null) {
            this.f12523m -= eVar7.J[i6 + 1].b();
        }
        this.f12513c = eVar;
        if (this.f12526p == 0 && this.f12527q) {
            this.f12515e = eVar;
        } else {
            this.f12515e = this.f12511a;
        }
        this.f12530t = (this.f12529s && this.f12528r) ? false : false;
    }

    private static boolean c(e eVar, int i6) {
        int i7;
        return eVar.M() != 8 && eVar.M[i6] == e.b.MATCH_CONSTRAINT && ((i7 = eVar.f12568n[i6]) == 0 || i7 == 3);
    }

    public void a() {
        if (!this.f12532v) {
            b();
        }
        this.f12532v = true;
    }
}
