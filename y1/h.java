package y1;

import android.os.Looper;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.s1;
import com.google.android.exoplayer2.t0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import q2.c0;
import q2.d0;
import w1.e0;
import w1.p;
import w1.q0;
import w1.r0;
import w1.s;
import w1.s0;
/* loaded from: classes.dex */
public class h implements r0, s0, d0.b, d0.f {

    /* renamed from: a  reason: collision with root package name */
    public final int f14291a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f14292b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.s0[] f14293c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean[] f14294d;

    /* renamed from: e  reason: collision with root package name */
    private final i f14295e;

    /* renamed from: f  reason: collision with root package name */
    private final s0.a f14296f;

    /* renamed from: g  reason: collision with root package name */
    private final e0.a f14297g;

    /* renamed from: h  reason: collision with root package name */
    private final c0 f14298h;

    /* renamed from: k  reason: collision with root package name */
    private final d0 f14299k;

    /* renamed from: l  reason: collision with root package name */
    private final g f14300l;

    /* renamed from: m  reason: collision with root package name */
    private final ArrayList f14301m;

    /* renamed from: n  reason: collision with root package name */
    private final List f14302n;

    /* renamed from: o  reason: collision with root package name */
    private final q0 f14303o;

    /* renamed from: p  reason: collision with root package name */
    private final q0[] f14304p;

    /* renamed from: q  reason: collision with root package name */
    private final c f14305q;

    /* renamed from: r  reason: collision with root package name */
    private e f14306r;

    /* renamed from: s  reason: collision with root package name */
    private com.google.android.exoplayer2.s0 f14307s;

    /* renamed from: t  reason: collision with root package name */
    private b f14308t;

    /* renamed from: u  reason: collision with root package name */
    private long f14309u;

    /* renamed from: v  reason: collision with root package name */
    private long f14310v;

    /* renamed from: w  reason: collision with root package name */
    private int f14311w;

    /* renamed from: x  reason: collision with root package name */
    private y1.a f14312x;

    /* renamed from: y  reason: collision with root package name */
    boolean f14313y;

    /* loaded from: classes.dex */
    public final class a implements r0 {

        /* renamed from: a  reason: collision with root package name */
        public final h f14314a;

        /* renamed from: b  reason: collision with root package name */
        private final q0 f14315b;

        /* renamed from: c  reason: collision with root package name */
        private final int f14316c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f14317d;

        public a(h hVar, q0 q0Var, int i6) {
            this.f14314a = hVar;
            this.f14315b = q0Var;
            this.f14316c = i6;
        }

        private void a() {
            if (this.f14317d) {
                return;
            }
            h.this.f14297g.i(h.this.f14292b[this.f14316c], h.this.f14293c[this.f14316c], 0, null, h.this.f14310v);
            this.f14317d = true;
        }

        @Override // w1.r0
        public void b() {
        }

        public void c() {
            com.google.android.exoplayer2.util.a.g(h.this.f14294d[this.f14316c]);
            h.this.f14294d[this.f14316c] = false;
        }

        @Override // w1.r0
        public int e(t0 t0Var, com.google.android.exoplayer2.decoder.j jVar, boolean z5) {
            if (h.this.I()) {
                return -3;
            }
            if (h.this.f14312x == null || h.this.f14312x.i(this.f14316c + 1) > this.f14315b.z()) {
                a();
                return this.f14315b.N(t0Var, jVar, z5, h.this.f14313y);
            }
            return -3;
        }

        @Override // w1.r0
        public boolean g() {
            return !h.this.I() && this.f14315b.H(h.this.f14313y);
        }

        @Override // w1.r0
        public int r(long j6) {
            if (h.this.I()) {
                return 0;
            }
            int B = this.f14315b.B(j6, h.this.f14313y);
            if (h.this.f14312x != null) {
                B = Math.min(B, h.this.f14312x.i(this.f14316c + 1) - this.f14315b.z());
            }
            this.f14315b.a0(B);
            if (B > 0) {
                a();
            }
            return B;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void e(h hVar);
    }

    public h(int i6, int[] iArr, com.google.android.exoplayer2.s0[] s0VarArr, i iVar, s0.a aVar, q2.b bVar, long j6, v vVar, t.a aVar2, c0 c0Var, e0.a aVar3) {
        this.f14291a = i6;
        int i7 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f14292b = iArr;
        this.f14293c = s0VarArr == null ? new com.google.android.exoplayer2.s0[0] : s0VarArr;
        this.f14295e = iVar;
        this.f14296f = aVar;
        this.f14297g = aVar3;
        this.f14298h = c0Var;
        this.f14299k = new d0("Loader:ChunkSampleStream");
        this.f14300l = new g();
        ArrayList arrayList = new ArrayList();
        this.f14301m = arrayList;
        this.f14302n = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.f14304p = new q0[length];
        this.f14294d = new boolean[length];
        int i8 = length + 1;
        int[] iArr2 = new int[i8];
        q0[] q0VarArr = new q0[i8];
        q0 q0Var = new q0(bVar, (Looper) com.google.android.exoplayer2.util.a.e(Looper.myLooper()), vVar, aVar2);
        this.f14303o = q0Var;
        iArr2[0] = i6;
        q0VarArr[0] = q0Var;
        while (i7 < length) {
            q0 q0Var2 = new q0(bVar, (Looper) com.google.android.exoplayer2.util.a.e(Looper.myLooper()), u.c(), aVar2);
            this.f14304p[i7] = q0Var2;
            int i9 = i7 + 1;
            q0VarArr[i9] = q0Var2;
            iArr2[i9] = this.f14292b[i7];
            i7 = i9;
        }
        this.f14305q = new c(iArr2, q0VarArr);
        this.f14309u = j6;
        this.f14310v = j6;
    }

    private void B(int i6) {
        int min = Math.min(O(i6, 0), this.f14311w);
        if (min > 0) {
            com.google.android.exoplayer2.util.s0.E0(this.f14301m, 0, min);
            this.f14311w -= min;
        }
    }

    private void C(int i6) {
        com.google.android.exoplayer2.util.a.g(!this.f14299k.j());
        int size = this.f14301m.size();
        while (true) {
            if (i6 >= size) {
                i6 = -1;
                break;
            } else if (!G(i6)) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 == -1) {
            return;
        }
        long j6 = F().f14287h;
        y1.a D = D(i6);
        if (this.f14301m.isEmpty()) {
            this.f14309u = this.f14310v;
        }
        this.f14313y = false;
        this.f14297g.D(this.f14291a, D.f14286g, j6);
    }

    private y1.a D(int i6) {
        y1.a aVar = (y1.a) this.f14301m.get(i6);
        ArrayList arrayList = this.f14301m;
        com.google.android.exoplayer2.util.s0.E0(arrayList, i6, arrayList.size());
        this.f14311w = Math.max(this.f14311w, this.f14301m.size());
        q0 q0Var = this.f14303o;
        int i7 = 0;
        while (true) {
            q0Var.r(aVar.i(i7));
            q0[] q0VarArr = this.f14304p;
            if (i7 >= q0VarArr.length) {
                return aVar;
            }
            q0Var = q0VarArr[i7];
            i7++;
        }
    }

    private y1.a F() {
        ArrayList arrayList = this.f14301m;
        return (y1.a) arrayList.get(arrayList.size() - 1);
    }

    private boolean G(int i6) {
        int z5;
        y1.a aVar = (y1.a) this.f14301m.get(i6);
        if (this.f14303o.z() > aVar.i(0)) {
            return true;
        }
        int i7 = 0;
        do {
            q0[] q0VarArr = this.f14304p;
            if (i7 >= q0VarArr.length) {
                return false;
            }
            z5 = q0VarArr[i7].z();
            i7++;
        } while (z5 <= aVar.i(i7));
        return true;
    }

    private boolean H(e eVar) {
        return eVar instanceof y1.a;
    }

    private void J() {
        int O = O(this.f14303o.z(), this.f14311w - 1);
        while (true) {
            int i6 = this.f14311w;
            if (i6 > O) {
                return;
            }
            this.f14311w = i6 + 1;
            K(i6);
        }
    }

    private void K(int i6) {
        y1.a aVar = (y1.a) this.f14301m.get(i6);
        com.google.android.exoplayer2.s0 s0Var = aVar.f14283d;
        if (!s0Var.equals(this.f14307s)) {
            this.f14297g.i(this.f14291a, s0Var, aVar.f14284e, aVar.f14285f, aVar.f14286g);
        }
        this.f14307s = s0Var;
    }

    private int O(int i6, int i7) {
        do {
            i7++;
            if (i7 >= this.f14301m.size()) {
                return this.f14301m.size() - 1;
            }
        } while (((y1.a) this.f14301m.get(i7)).i(0) <= i6);
        return i7 - 1;
    }

    private void R() {
        this.f14303o.R();
        for (q0 q0Var : this.f14304p) {
            q0Var.R();
        }
    }

    public i E() {
        return this.f14295e;
    }

    boolean I() {
        return this.f14309u != -9223372036854775807L;
    }

    @Override // q2.d0.b
    /* renamed from: L */
    public void p(e eVar, long j6, long j7, boolean z5) {
        this.f14306r = null;
        this.f14312x = null;
        p pVar = new p(eVar.f14280a, eVar.f14281b, eVar.f(), eVar.e(), j6, j7, eVar.b());
        this.f14298h.a(eVar.f14280a);
        this.f14297g.r(pVar, eVar.f14282c, this.f14291a, eVar.f14283d, eVar.f14284e, eVar.f14285f, eVar.f14286g, eVar.f14287h);
        if (z5) {
            return;
        }
        if (I()) {
            R();
        } else if (H(eVar)) {
            D(this.f14301m.size() - 1);
            if (this.f14301m.isEmpty()) {
                this.f14309u = this.f14310v;
            }
        }
        this.f14296f.j(this);
    }

    @Override // q2.d0.b
    /* renamed from: M */
    public void m(e eVar, long j6, long j7) {
        this.f14306r = null;
        this.f14295e.i(eVar);
        p pVar = new p(eVar.f14280a, eVar.f14281b, eVar.f(), eVar.e(), j6, j7, eVar.b());
        this.f14298h.a(eVar.f14280a);
        this.f14297g.u(pVar, eVar.f14282c, this.f14291a, eVar.f14283d, eVar.f14284e, eVar.f14285f, eVar.f14286g, eVar.f14287h);
        this.f14296f.j(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0100  */
    @Override // q2.d0.b
    /* renamed from: N */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d0.c k(e eVar, long j6, long j7, IOException iOException, int i6) {
        d0.c cVar;
        boolean z5;
        long b6 = eVar.b();
        boolean H = H(eVar);
        int size = this.f14301m.size() - 1;
        boolean z6 = (b6 != 0 && H && G(size)) ? false : true;
        p pVar = new p(eVar.f14280a, eVar.f14281b, eVar.f(), eVar.e(), j6, j7, b6);
        c0.a aVar = new c0.a(pVar, new s(eVar.f14282c, this.f14291a, eVar.f14283d, eVar.f14284e, eVar.f14285f, com.google.android.exoplayer2.p.b(eVar.f14286g), com.google.android.exoplayer2.p.b(eVar.f14287h)), iOException, i6);
        if (this.f14295e.h(eVar, z6, iOException, z6 ? this.f14298h.c(aVar) : -9223372036854775807L)) {
            if (z6) {
                cVar = d0.f12728f;
                if (H) {
                    com.google.android.exoplayer2.util.a.g(D(size) == eVar);
                    if (this.f14301m.isEmpty()) {
                        this.f14309u = this.f14310v;
                    }
                }
                if (cVar == null) {
                    long b7 = this.f14298h.b(aVar);
                    cVar = b7 != -9223372036854775807L ? d0.h(false, b7) : d0.f12729g;
                }
                z5 = !cVar.c();
                this.f14297g.w(pVar, eVar.f14282c, this.f14291a, eVar.f14283d, eVar.f14284e, eVar.f14285f, eVar.f14286g, eVar.f14287h, iOException, z5);
                if (z5) {
                    this.f14306r = null;
                    this.f14298h.a(eVar.f14280a);
                    this.f14296f.j(this);
                }
                return cVar;
            }
            com.google.android.exoplayer2.util.n.h("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
        }
        cVar = null;
        if (cVar == null) {
        }
        z5 = !cVar.c();
        this.f14297g.w(pVar, eVar.f14282c, this.f14291a, eVar.f14283d, eVar.f14284e, eVar.f14285f, eVar.f14286g, eVar.f14287h, iOException, z5);
        if (z5) {
        }
        return cVar;
    }

    public void P() {
        Q(null);
    }

    public void Q(b bVar) {
        this.f14308t = bVar;
        this.f14303o.M();
        for (q0 q0Var : this.f14304p) {
            q0Var.M();
        }
        this.f14299k.m(this);
    }

    public void S(long j6) {
        y1.a aVar;
        this.f14310v = j6;
        if (I()) {
            this.f14309u = j6;
            return;
        }
        for (int i6 = 0; i6 < this.f14301m.size(); i6++) {
            aVar = (y1.a) this.f14301m.get(i6);
            int i7 = (aVar.f14286g > j6 ? 1 : (aVar.f14286g == j6 ? 0 : -1));
            if (i7 == 0 && aVar.f14254k == -9223372036854775807L) {
                break;
            } else if (i7 > 0) {
                break;
            }
        }
        aVar = null;
        if (aVar != null ? this.f14303o.U(aVar.i(0)) : this.f14303o.V(j6, j6 < d())) {
            this.f14311w = O(this.f14303o.z(), 0);
            for (q0 q0Var : this.f14304p) {
                q0Var.V(j6, true);
            }
            return;
        }
        this.f14309u = j6;
        this.f14313y = false;
        this.f14301m.clear();
        this.f14311w = 0;
        if (this.f14299k.j()) {
            this.f14299k.f();
            return;
        }
        this.f14299k.g();
        R();
    }

    public a T(long j6, int i6) {
        for (int i7 = 0; i7 < this.f14304p.length; i7++) {
            if (this.f14292b[i7] == i6) {
                com.google.android.exoplayer2.util.a.g(!this.f14294d[i7]);
                this.f14294d[i7] = true;
                this.f14304p[i7].V(j6, true);
                return new a(this, this.f14304p[i7], i7);
            }
        }
        throw new IllegalStateException();
    }

    @Override // w1.s0
    public boolean a() {
        return this.f14299k.j();
    }

    @Override // w1.r0
    public void b() {
        this.f14299k.b();
        this.f14303o.J();
        if (this.f14299k.j()) {
            return;
        }
        this.f14295e.b();
    }

    public long c(long j6, s1 s1Var) {
        return this.f14295e.c(j6, s1Var);
    }

    @Override // w1.s0
    public long d() {
        if (I()) {
            return this.f14309u;
        }
        if (this.f14313y) {
            return Long.MIN_VALUE;
        }
        return F().f14287h;
    }

    @Override // w1.r0
    public int e(t0 t0Var, com.google.android.exoplayer2.decoder.j jVar, boolean z5) {
        if (I()) {
            return -3;
        }
        y1.a aVar = this.f14312x;
        if (aVar == null || aVar.i(0) > this.f14303o.z()) {
            J();
            return this.f14303o.N(t0Var, jVar, z5, this.f14313y);
        }
        return -3;
    }

    @Override // w1.s0
    public long f() {
        if (this.f14313y) {
            return Long.MIN_VALUE;
        }
        if (I()) {
            return this.f14309u;
        }
        long j6 = this.f14310v;
        y1.a F = F();
        if (!F.h()) {
            if (this.f14301m.size() > 1) {
                ArrayList arrayList = this.f14301m;
                F = (y1.a) arrayList.get(arrayList.size() - 2);
            } else {
                F = null;
            }
        }
        if (F != null) {
            j6 = Math.max(j6, F.f14287h);
        }
        return Math.max(j6, this.f14303o.w());
    }

    @Override // w1.r0
    public boolean g() {
        return !I() && this.f14303o.H(this.f14313y);
    }

    @Override // w1.s0
    public boolean h(long j6) {
        List list;
        long j7;
        if (this.f14313y || this.f14299k.j() || this.f14299k.i()) {
            return false;
        }
        boolean I = I();
        if (I) {
            list = Collections.emptyList();
            j7 = this.f14309u;
        } else {
            list = this.f14302n;
            j7 = F().f14287h;
        }
        this.f14295e.f(j6, j7, list, this.f14300l);
        g gVar = this.f14300l;
        boolean z5 = gVar.f14290b;
        e eVar = gVar.f14289a;
        gVar.a();
        if (z5) {
            this.f14309u = -9223372036854775807L;
            this.f14313y = true;
            return true;
        } else if (eVar == null) {
            return false;
        } else {
            this.f14306r = eVar;
            if (H(eVar)) {
                y1.a aVar = (y1.a) eVar;
                if (I) {
                    long j8 = aVar.f14286g;
                    long j9 = this.f14309u;
                    if (j8 != j9) {
                        this.f14303o.X(j9);
                        for (q0 q0Var : this.f14304p) {
                            q0Var.X(this.f14309u);
                        }
                    }
                    this.f14309u = -9223372036854775807L;
                }
                aVar.k(this.f14305q);
                this.f14301m.add(aVar);
            } else if (eVar instanceof l) {
                ((l) eVar).g(this.f14305q);
            }
            this.f14297g.A(new p(eVar.f14280a, eVar.f14281b, this.f14299k.n(eVar, this, this.f14298h.d(eVar.f14282c))), eVar.f14282c, this.f14291a, eVar.f14283d, eVar.f14284e, eVar.f14285f, eVar.f14286g, eVar.f14287h);
            return true;
        }
    }

    @Override // w1.s0
    public void i(long j6) {
        if (this.f14299k.i() || I()) {
            return;
        }
        if (!this.f14299k.j()) {
            int e6 = this.f14295e.e(j6, this.f14302n);
            if (e6 < this.f14301m.size()) {
                C(e6);
                return;
            }
            return;
        }
        e eVar = (e) com.google.android.exoplayer2.util.a.e(this.f14306r);
        if (!(H(eVar) && G(this.f14301m.size() - 1)) && this.f14295e.k(j6, eVar, this.f14302n)) {
            this.f14299k.f();
            if (H(eVar)) {
                this.f14312x = (y1.a) eVar;
            }
        }
    }

    @Override // q2.d0.f
    public void j() {
        this.f14303o.P();
        for (q0 q0Var : this.f14304p) {
            q0Var.P();
        }
        this.f14295e.a();
        b bVar = this.f14308t;
        if (bVar != null) {
            bVar.e(this);
        }
    }

    @Override // w1.r0
    public int r(long j6) {
        if (I()) {
            return 0;
        }
        int B = this.f14303o.B(j6, this.f14313y);
        y1.a aVar = this.f14312x;
        if (aVar != null) {
            B = Math.min(B, aVar.i(0) - this.f14303o.z());
        }
        this.f14303o.a0(B);
        J();
        return B;
    }

    public void t(long j6, boolean z5) {
        if (I()) {
            return;
        }
        int u5 = this.f14303o.u();
        this.f14303o.n(j6, z5, true);
        int u6 = this.f14303o.u();
        if (u6 > u5) {
            long v5 = this.f14303o.v();
            int i6 = 0;
            while (true) {
                q0[] q0VarArr = this.f14304p;
                if (i6 >= q0VarArr.length) {
                    break;
                }
                q0VarArr[i6].n(v5, z5, this.f14294d[i6]);
                i6++;
            }
        }
        B(u6);
    }
}
