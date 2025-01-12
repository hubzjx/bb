package o;

import java.util.Arrays;
import java.util.HashMap;
import o.i;
import p.d;
/* loaded from: classes.dex */
public class d {

    /* renamed from: q  reason: collision with root package name */
    private static int f12278q = 1000;

    /* renamed from: r  reason: collision with root package name */
    public static boolean f12279r = true;

    /* renamed from: s  reason: collision with root package name */
    public static long f12280s;

    /* renamed from: t  reason: collision with root package name */
    public static long f12281t;

    /* renamed from: c  reason: collision with root package name */
    private a f12284c;

    /* renamed from: f  reason: collision with root package name */
    o.b[] f12287f;

    /* renamed from: m  reason: collision with root package name */
    final c f12294m;

    /* renamed from: p  reason: collision with root package name */
    private a f12297p;

    /* renamed from: a  reason: collision with root package name */
    int f12282a = 0;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f12283b = null;

    /* renamed from: d  reason: collision with root package name */
    private int f12285d = 32;

    /* renamed from: e  reason: collision with root package name */
    private int f12286e = 32;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12288g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12289h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean[] f12290i = new boolean[32];

    /* renamed from: j  reason: collision with root package name */
    int f12291j = 1;

    /* renamed from: k  reason: collision with root package name */
    int f12292k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f12293l = 32;

    /* renamed from: n  reason: collision with root package name */
    private i[] f12295n = new i[f12278q];

    /* renamed from: o  reason: collision with root package name */
    private int f12296o = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(i iVar);

        i b(d dVar, boolean[] zArr);

        void c(a aVar);

        void clear();

        i getKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends o.b {
        public b(c cVar) {
            this.f12272e = new j(this, cVar);
        }
    }

    public d() {
        this.f12287f = null;
        this.f12287f = new o.b[32];
        C();
        c cVar = new c();
        this.f12294m = cVar;
        this.f12284c = new h(cVar);
        this.f12297p = f12279r ? new b(cVar) : new o.b(cVar);
    }

    private final int B(a aVar, boolean z5) {
        for (int i6 = 0; i6 < this.f12291j; i6++) {
            this.f12290i[i6] = false;
        }
        boolean z6 = false;
        int i7 = 0;
        while (!z6) {
            i7++;
            if (i7 >= this.f12291j * 2) {
                return i7;
            }
            if (aVar.getKey() != null) {
                this.f12290i[aVar.getKey().f12314c] = true;
            }
            i b6 = aVar.b(this, this.f12290i);
            if (b6 != null) {
                boolean[] zArr = this.f12290i;
                int i8 = b6.f12314c;
                if (zArr[i8]) {
                    return i7;
                }
                zArr[i8] = true;
            }
            if (b6 != null) {
                float f6 = Float.MAX_VALUE;
                int i9 = -1;
                for (int i10 = 0; i10 < this.f12292k; i10++) {
                    o.b bVar = this.f12287f[i10];
                    if (bVar.f12268a.f12321j != i.a.UNRESTRICTED && !bVar.f12273f && bVar.t(b6)) {
                        float g6 = bVar.f12272e.g(b6);
                        if (g6 < 0.0f) {
                            float f7 = (-bVar.f12269b) / g6;
                            if (f7 < f6) {
                                i9 = i10;
                                f6 = f7;
                            }
                        }
                    }
                }
                if (i9 > -1) {
                    o.b bVar2 = this.f12287f[i9];
                    bVar2.f12268a.f12315d = -1;
                    bVar2.y(b6);
                    i iVar = bVar2.f12268a;
                    iVar.f12315d = i9;
                    iVar.g(bVar2);
                }
            } else {
                z6 = true;
            }
        }
        return i7;
    }

    private void C() {
        int i6 = 0;
        if (f12279r) {
            while (true) {
                o.b[] bVarArr = this.f12287f;
                if (i6 >= bVarArr.length) {
                    return;
                }
                o.b bVar = bVarArr[i6];
                if (bVar != null) {
                    this.f12294m.f12274a.a(bVar);
                }
                this.f12287f[i6] = null;
                i6++;
            }
        } else {
            while (true) {
                o.b[] bVarArr2 = this.f12287f;
                if (i6 >= bVarArr2.length) {
                    return;
                }
                o.b bVar2 = bVarArr2[i6];
                if (bVar2 != null) {
                    this.f12294m.f12275b.a(bVar2);
                }
                this.f12287f[i6] = null;
                i6++;
            }
        }
    }

    private i a(i.a aVar, String str) {
        i iVar = (i) this.f12294m.f12276c.b();
        if (iVar == null) {
            iVar = new i(aVar, str);
        } else {
            iVar.d();
        }
        iVar.f(aVar, str);
        int i6 = this.f12296o;
        int i7 = f12278q;
        if (i6 >= i7) {
            int i8 = i7 * 2;
            f12278q = i8;
            this.f12295n = (i[]) Arrays.copyOf(this.f12295n, i8);
        }
        i[] iVarArr = this.f12295n;
        int i9 = this.f12296o;
        this.f12296o = i9 + 1;
        iVarArr[i9] = iVar;
        return iVar;
    }

    private final void l(o.b bVar) {
        o.b bVar2;
        f fVar;
        if (f12279r) {
            bVar2 = this.f12287f[this.f12292k];
            if (bVar2 != null) {
                fVar = this.f12294m.f12274a;
                fVar.a(bVar2);
            }
        } else {
            bVar2 = this.f12287f[this.f12292k];
            if (bVar2 != null) {
                fVar = this.f12294m.f12275b;
                fVar.a(bVar2);
            }
        }
        o.b[] bVarArr = this.f12287f;
        int i6 = this.f12292k;
        bVarArr[i6] = bVar;
        i iVar = bVar.f12268a;
        iVar.f12315d = i6;
        this.f12292k = i6 + 1;
        iVar.g(bVar);
    }

    private void n() {
        for (int i6 = 0; i6 < this.f12292k; i6++) {
            o.b bVar = this.f12287f[i6];
            bVar.f12268a.f12317f = bVar.f12269b;
        }
    }

    public static o.b s(d dVar, i iVar, i iVar2, float f6) {
        return dVar.r().j(iVar, iVar2, f6);
    }

    private int u(a aVar) {
        float f6;
        boolean z5;
        int i6 = 0;
        while (true) {
            f6 = 0.0f;
            if (i6 >= this.f12292k) {
                z5 = false;
                break;
            }
            o.b bVar = this.f12287f[i6];
            if (bVar.f12268a.f12321j != i.a.UNRESTRICTED && bVar.f12269b < 0.0f) {
                z5 = true;
                break;
            }
            i6++;
        }
        if (z5) {
            boolean z6 = false;
            int i7 = 0;
            while (!z6) {
                i7++;
                float f7 = Float.MAX_VALUE;
                int i8 = 0;
                int i9 = -1;
                int i10 = -1;
                int i11 = 0;
                while (i8 < this.f12292k) {
                    o.b bVar2 = this.f12287f[i8];
                    if (bVar2.f12268a.f12321j != i.a.UNRESTRICTED && !bVar2.f12273f && bVar2.f12269b < f6) {
                        int i12 = 1;
                        while (i12 < this.f12291j) {
                            i iVar = this.f12294m.f12277d[i12];
                            float g6 = bVar2.f12272e.g(iVar);
                            if (g6 > f6) {
                                for (int i13 = 0; i13 < 9; i13++) {
                                    float f8 = iVar.f12319h[i13] / g6;
                                    if ((f8 < f7 && i13 == i11) || i13 > i11) {
                                        i11 = i13;
                                        f7 = f8;
                                        i9 = i8;
                                        i10 = i12;
                                    }
                                }
                            }
                            i12++;
                            f6 = 0.0f;
                        }
                    }
                    i8++;
                    f6 = 0.0f;
                }
                if (i9 != -1) {
                    o.b bVar3 = this.f12287f[i9];
                    bVar3.f12268a.f12315d = -1;
                    bVar3.y(this.f12294m.f12277d[i10]);
                    i iVar2 = bVar3.f12268a;
                    iVar2.f12315d = i9;
                    iVar2.g(bVar3);
                } else {
                    z6 = true;
                }
                if (i7 > this.f12291j / 2) {
                    z6 = true;
                }
                f6 = 0.0f;
            }
            return i7;
        }
        return 0;
    }

    public static e w() {
        return null;
    }

    private void y() {
        int i6 = this.f12285d * 2;
        this.f12285d = i6;
        this.f12287f = (o.b[]) Arrays.copyOf(this.f12287f, i6);
        c cVar = this.f12294m;
        cVar.f12277d = (i[]) Arrays.copyOf(cVar.f12277d, this.f12285d);
        int i7 = this.f12285d;
        this.f12290i = new boolean[i7];
        this.f12286e = i7;
        this.f12293l = i7;
    }

    void A(a aVar) {
        u(aVar);
        B(aVar, false);
        n();
    }

    public void D() {
        c cVar;
        int i6 = 0;
        while (true) {
            cVar = this.f12294m;
            i[] iVarArr = cVar.f12277d;
            if (i6 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i6];
            if (iVar != null) {
                iVar.d();
            }
            i6++;
        }
        cVar.f12276c.c(this.f12295n, this.f12296o);
        this.f12296o = 0;
        Arrays.fill(this.f12294m.f12277d, (Object) null);
        HashMap hashMap = this.f12283b;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f12282a = 0;
        this.f12284c.clear();
        this.f12291j = 1;
        for (int i7 = 0; i7 < this.f12292k; i7++) {
            this.f12287f[i7].f12270c = false;
        }
        C();
        this.f12292k = 0;
        this.f12297p = f12279r ? new b(this.f12294m) : new o.b(this.f12294m);
    }

    public void b(p.e eVar, p.e eVar2, float f6, int i6) {
        d.b bVar = d.b.LEFT;
        i q5 = q(eVar.k(bVar));
        d.b bVar2 = d.b.TOP;
        i q6 = q(eVar.k(bVar2));
        d.b bVar3 = d.b.RIGHT;
        i q7 = q(eVar.k(bVar3));
        d.b bVar4 = d.b.BOTTOM;
        i q8 = q(eVar.k(bVar4));
        i q9 = q(eVar2.k(bVar));
        i q10 = q(eVar2.k(bVar2));
        i q11 = q(eVar2.k(bVar3));
        i q12 = q(eVar2.k(bVar4));
        o.b r5 = r();
        double d6 = f6;
        double d7 = i6;
        r5.q(q6, q8, q10, q12, (float) (Math.sin(d6) * d7));
        d(r5);
        o.b r6 = r();
        r6.q(q5, q7, q9, q11, (float) (Math.cos(d6) * d7));
        d(r6);
    }

    public void c(i iVar, i iVar2, int i6, float f6, i iVar3, i iVar4, int i7, int i8) {
        o.b r5 = r();
        r5.h(iVar, iVar2, i6, f6, iVar3, iVar4, i7);
        if (i8 != 8) {
            r5.d(this, i8);
        }
        d(r5);
    }

    public void d(o.b bVar) {
        i w5;
        if (bVar == null) {
            return;
        }
        boolean z5 = true;
        if (this.f12292k + 1 >= this.f12293l || this.f12291j + 1 >= this.f12286e) {
            y();
        }
        boolean z6 = false;
        if (!bVar.f12273f) {
            bVar.D(this);
            if (bVar.u()) {
                return;
            }
            bVar.r();
            if (bVar.f(this)) {
                i p5 = p();
                bVar.f12268a = p5;
                l(bVar);
                this.f12297p.c(bVar);
                B(this.f12297p, true);
                if (p5.f12315d == -1) {
                    if (bVar.f12268a == p5 && (w5 = bVar.w(p5)) != null) {
                        bVar.y(w5);
                    }
                    if (!bVar.f12273f) {
                        bVar.f12268a.g(bVar);
                    }
                    this.f12292k--;
                }
            } else {
                z5 = false;
            }
            if (!bVar.s()) {
                return;
            }
            z6 = z5;
        }
        if (z6) {
            return;
        }
        l(bVar);
    }

    public o.b e(i iVar, i iVar2, int i6, int i7) {
        if (i7 == 8 && iVar2.f12318g && iVar.f12315d == -1) {
            iVar.e(this, iVar2.f12317f + i6);
            return null;
        }
        o.b r5 = r();
        r5.n(iVar, iVar2, i6);
        if (i7 != 8) {
            r5.d(this, i7);
        }
        d(r5);
        return r5;
    }

    public void f(i iVar, int i6) {
        o.b r5;
        int i7 = iVar.f12315d;
        if (i7 == -1) {
            iVar.e(this, i6);
            return;
        }
        if (i7 != -1) {
            o.b bVar = this.f12287f[i7];
            if (!bVar.f12273f) {
                if (bVar.f12272e.d() == 0) {
                    bVar.f12273f = true;
                } else {
                    r5 = r();
                    r5.m(iVar, i6);
                }
            }
            bVar.f12269b = i6;
            return;
        }
        r5 = r();
        r5.i(iVar, i6);
        d(r5);
    }

    public void g(i iVar, i iVar2, int i6, boolean z5) {
        o.b r5 = r();
        i t5 = t();
        t5.f12316e = 0;
        r5.o(iVar, iVar2, t5, i6);
        d(r5);
    }

    public void h(i iVar, i iVar2, int i6, int i7) {
        o.b r5 = r();
        i t5 = t();
        t5.f12316e = 0;
        r5.o(iVar, iVar2, t5, i6);
        if (i7 != 8) {
            m(r5, (int) (r5.f12272e.g(t5) * (-1.0f)), i7);
        }
        d(r5);
    }

    public void i(i iVar, i iVar2, int i6, boolean z5) {
        o.b r5 = r();
        i t5 = t();
        t5.f12316e = 0;
        r5.p(iVar, iVar2, t5, i6);
        d(r5);
    }

    public void j(i iVar, i iVar2, int i6, int i7) {
        o.b r5 = r();
        i t5 = t();
        t5.f12316e = 0;
        r5.p(iVar, iVar2, t5, i6);
        if (i7 != 8) {
            m(r5, (int) (r5.f12272e.g(t5) * (-1.0f)), i7);
        }
        d(r5);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f6, int i6) {
        o.b r5 = r();
        r5.k(iVar, iVar2, iVar3, iVar4, f6);
        if (i6 != 8) {
            r5.d(this, i6);
        }
        d(r5);
    }

    void m(o.b bVar, int i6, int i7) {
        bVar.e(o(i7, null), i6);
    }

    public i o(int i6, String str) {
        if (this.f12291j + 1 >= this.f12286e) {
            y();
        }
        i a6 = a(i.a.ERROR, str);
        int i7 = this.f12282a + 1;
        this.f12282a = i7;
        this.f12291j++;
        a6.f12314c = i7;
        a6.f12316e = i6;
        this.f12294m.f12277d[i7] = a6;
        this.f12284c.a(a6);
        return a6;
    }

    public i p() {
        if (this.f12291j + 1 >= this.f12286e) {
            y();
        }
        i a6 = a(i.a.SLACK, null);
        int i6 = this.f12282a + 1;
        this.f12282a = i6;
        this.f12291j++;
        a6.f12314c = i6;
        this.f12294m.f12277d[i6] = a6;
        return a6;
    }

    public i q(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f12291j + 1 >= this.f12286e) {
            y();
        }
        if (obj instanceof p.d) {
            p.d dVar = (p.d) obj;
            iVar = dVar.e();
            if (iVar == null) {
                dVar.l(this.f12294m);
                iVar = dVar.e();
            }
            int i6 = iVar.f12314c;
            if (i6 == -1 || i6 > this.f12282a || this.f12294m.f12277d[i6] == null) {
                if (i6 != -1) {
                    iVar.d();
                }
                int i7 = this.f12282a + 1;
                this.f12282a = i7;
                this.f12291j++;
                iVar.f12314c = i7;
                iVar.f12321j = i.a.UNRESTRICTED;
                this.f12294m.f12277d[i7] = iVar;
            }
        }
        return iVar;
    }

    public o.b r() {
        o.b bVar;
        if (f12279r) {
            bVar = (o.b) this.f12294m.f12274a.b();
            if (bVar == null) {
                bVar = new b(this.f12294m);
                f12281t++;
            }
            bVar.z();
        } else {
            bVar = (o.b) this.f12294m.f12275b.b();
            if (bVar == null) {
                bVar = new o.b(this.f12294m);
                f12280s++;
            }
            bVar.z();
        }
        i.b();
        return bVar;
    }

    public i t() {
        if (this.f12291j + 1 >= this.f12286e) {
            y();
        }
        i a6 = a(i.a.SLACK, null);
        int i6 = this.f12282a + 1;
        this.f12282a = i6;
        this.f12291j++;
        a6.f12314c = i6;
        this.f12294m.f12277d[i6] = a6;
        return a6;
    }

    public c v() {
        return this.f12294m;
    }

    public int x(Object obj) {
        i e6 = ((p.d) obj).e();
        if (e6 != null) {
            return (int) (e6.f12317f + 0.5f);
        }
        return 0;
    }

    public void z() {
        if (this.f12288g || this.f12289h) {
            boolean z5 = false;
            int i6 = 0;
            while (true) {
                if (i6 >= this.f12292k) {
                    z5 = true;
                    break;
                } else if (!this.f12287f[i6].f12273f) {
                    break;
                } else {
                    i6++;
                }
            }
            if (z5) {
                n();
                return;
            }
        }
        A(this.f12284c);
    }
}
