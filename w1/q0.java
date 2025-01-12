package w1;

import android.os.Looper;
import android.util.Log;
import c1.a0;
import com.google.android.exoplayer2.drm.m;
import com.google.android.exoplayer2.drm.t;
/* loaded from: classes.dex */
public class q0 implements c1.a0 {
    private boolean A;
    private com.google.android.exoplayer2.s0 B;
    private com.google.android.exoplayer2.s0 C;
    private com.google.android.exoplayer2.s0 D;
    private int E;
    private boolean F;
    private boolean G;
    private long H;
    private boolean I;

    /* renamed from: a  reason: collision with root package name */
    private final p0 f13985a;

    /* renamed from: c  reason: collision with root package name */
    private final Looper f13987c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.v f13988d;

    /* renamed from: e  reason: collision with root package name */
    private final t.a f13989e;

    /* renamed from: f  reason: collision with root package name */
    private b f13990f;

    /* renamed from: g  reason: collision with root package name */
    private com.google.android.exoplayer2.s0 f13991g;

    /* renamed from: h  reason: collision with root package name */
    private com.google.android.exoplayer2.drm.m f13992h;

    /* renamed from: q  reason: collision with root package name */
    private int f14001q;

    /* renamed from: r  reason: collision with root package name */
    private int f14002r;

    /* renamed from: s  reason: collision with root package name */
    private int f14003s;

    /* renamed from: t  reason: collision with root package name */
    private int f14004t;

    /* renamed from: x  reason: collision with root package name */
    private boolean f14008x;

    /* renamed from: b  reason: collision with root package name */
    private final a f13986b = new a();

    /* renamed from: i  reason: collision with root package name */
    private int f13993i = 1000;

    /* renamed from: j  reason: collision with root package name */
    private int[] f13994j = new int[1000];

    /* renamed from: k  reason: collision with root package name */
    private long[] f13995k = new long[1000];

    /* renamed from: n  reason: collision with root package name */
    private long[] f13998n = new long[1000];

    /* renamed from: m  reason: collision with root package name */
    private int[] f13997m = new int[1000];

    /* renamed from: l  reason: collision with root package name */
    private int[] f13996l = new int[1000];

    /* renamed from: o  reason: collision with root package name */
    private a0.a[] f13999o = new a0.a[1000];

    /* renamed from: p  reason: collision with root package name */
    private com.google.android.exoplayer2.s0[] f14000p = new com.google.android.exoplayer2.s0[1000];

    /* renamed from: u  reason: collision with root package name */
    private long f14005u = Long.MIN_VALUE;

    /* renamed from: v  reason: collision with root package name */
    private long f14006v = Long.MIN_VALUE;

    /* renamed from: w  reason: collision with root package name */
    private long f14007w = Long.MIN_VALUE;

    /* renamed from: z  reason: collision with root package name */
    private boolean f14010z = true;

    /* renamed from: y  reason: collision with root package name */
    private boolean f14009y = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f14011a;

        /* renamed from: b  reason: collision with root package name */
        public long f14012b;

        /* renamed from: c  reason: collision with root package name */
        public a0.a f14013c;

        a() {
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void b(com.google.android.exoplayer2.s0 s0Var);
    }

    public q0(q2.b bVar, Looper looper, com.google.android.exoplayer2.drm.v vVar, t.a aVar) {
        this.f13987c = looper;
        this.f13988d = vVar;
        this.f13989e = aVar;
        this.f13985a = new p0(bVar);
    }

    private int A(int i6) {
        int i7 = this.f14003s + i6;
        int i8 = this.f13993i;
        return i7 < i8 ? i7 : i7 - i8;
    }

    private boolean E() {
        return this.f14004t != this.f14001q;
    }

    private boolean I(int i6) {
        com.google.android.exoplayer2.drm.m mVar = this.f13992h;
        return mVar == null || mVar.getState() == 4 || ((this.f13997m[i6] & 1073741824) == 0 && this.f13992h.a());
    }

    private void K(com.google.android.exoplayer2.s0 s0Var, com.google.android.exoplayer2.t0 t0Var) {
        com.google.android.exoplayer2.s0 s0Var2 = this.f13991g;
        boolean z5 = s0Var2 == null;
        com.google.android.exoplayer2.drm.k kVar = z5 ? null : s0Var2.f4059q;
        this.f13991g = s0Var;
        com.google.android.exoplayer2.drm.k kVar2 = s0Var.f4059q;
        t0Var.f4441b = s0Var.f(this.f13988d.d(s0Var));
        t0Var.f4440a = this.f13992h;
        if (z5 || !com.google.android.exoplayer2.util.s0.c(kVar, kVar2)) {
            com.google.android.exoplayer2.drm.m mVar = this.f13992h;
            com.google.android.exoplayer2.drm.m c6 = this.f13988d.c(this.f13987c, this.f13989e, s0Var);
            this.f13992h = c6;
            t0Var.f4440a = c6;
            if (mVar != null) {
                mVar.d(this.f13989e);
            }
        }
    }

    private synchronized int O(com.google.android.exoplayer2.t0 t0Var, com.google.android.exoplayer2.decoder.j jVar, boolean z5, boolean z6, a aVar) {
        jVar.f3601c = false;
        if (!E()) {
            if (!z6 && !this.f14008x) {
                com.google.android.exoplayer2.s0 s0Var = this.C;
                if (s0Var == null || (!z5 && s0Var == this.f13991g)) {
                    return -3;
                }
                K((com.google.android.exoplayer2.s0) com.google.android.exoplayer2.util.a.e(s0Var), t0Var);
                return -5;
            }
            jVar.setFlags(4);
            return -4;
        }
        int A = A(this.f14004t);
        if (!z5 && this.f14000p[A] == this.f13991g) {
            if (!I(A)) {
                jVar.f3601c = true;
                return -3;
            }
            jVar.setFlags(this.f13997m[A]);
            long j6 = this.f13998n[A];
            jVar.f3602d = j6;
            if (j6 < this.f14005u) {
                jVar.addFlag(Integer.MIN_VALUE);
            }
            if (jVar.i()) {
                return -4;
            }
            aVar.f14011a = this.f13996l[A];
            aVar.f14012b = this.f13995k[A];
            aVar.f14013c = this.f13999o[A];
            this.f14004t++;
            return -4;
        }
        K(this.f14000p[A], t0Var);
        return -5;
    }

    private void Q() {
        com.google.android.exoplayer2.drm.m mVar = this.f13992h;
        if (mVar != null) {
            mVar.d(this.f13989e);
            this.f13992h = null;
            this.f13991g = null;
        }
    }

    private synchronized void T() {
        this.f14004t = 0;
        this.f13985a.m();
    }

    private synchronized boolean Y(com.google.android.exoplayer2.s0 s0Var) {
        this.f14010z = false;
        if (com.google.android.exoplayer2.util.s0.c(s0Var, this.C)) {
            return false;
        }
        if (com.google.android.exoplayer2.util.s0.c(s0Var, this.D)) {
            s0Var = this.D;
        }
        this.C = s0Var;
        com.google.android.exoplayer2.s0 s0Var2 = this.C;
        this.F = com.google.android.exoplayer2.util.q.a(s0Var2.f4056n, s0Var2.f4053k);
        this.G = false;
        return true;
    }

    private synchronized boolean g(long j6) {
        if (this.f14001q == 0) {
            return j6 > this.f14006v;
        } else if (x() >= j6) {
            return false;
        } else {
            q(this.f14002r + i(j6));
            return true;
        }
    }

    private synchronized void h(long j6, int i6, long j7, int i7, a0.a aVar) {
        int i8 = this.f14001q;
        if (i8 > 0) {
            int A = A(i8 - 1);
            com.google.android.exoplayer2.util.a.a(this.f13995k[A] + ((long) this.f13996l[A]) <= j7);
        }
        this.f14008x = (536870912 & i6) != 0;
        this.f14007w = Math.max(this.f14007w, j6);
        int A2 = A(this.f14001q);
        this.f13998n[A2] = j6;
        long[] jArr = this.f13995k;
        jArr[A2] = j7;
        this.f13996l[A2] = i7;
        this.f13997m[A2] = i6;
        this.f13999o[A2] = aVar;
        com.google.android.exoplayer2.s0[] s0VarArr = this.f14000p;
        com.google.android.exoplayer2.s0 s0Var = this.C;
        s0VarArr[A2] = s0Var;
        this.f13994j[A2] = this.E;
        this.D = s0Var;
        int i9 = this.f14001q + 1;
        this.f14001q = i9;
        int i10 = this.f13993i;
        if (i9 == i10) {
            int i11 = i10 + 1000;
            int[] iArr = new int[i11];
            long[] jArr2 = new long[i11];
            long[] jArr3 = new long[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            a0.a[] aVarArr = new a0.a[i11];
            com.google.android.exoplayer2.s0[] s0VarArr2 = new com.google.android.exoplayer2.s0[i11];
            int i12 = this.f14003s;
            int i13 = i10 - i12;
            System.arraycopy(jArr, i12, jArr2, 0, i13);
            System.arraycopy(this.f13998n, this.f14003s, jArr3, 0, i13);
            System.arraycopy(this.f13997m, this.f14003s, iArr2, 0, i13);
            System.arraycopy(this.f13996l, this.f14003s, iArr3, 0, i13);
            System.arraycopy(this.f13999o, this.f14003s, aVarArr, 0, i13);
            System.arraycopy(this.f14000p, this.f14003s, s0VarArr2, 0, i13);
            System.arraycopy(this.f13994j, this.f14003s, iArr, 0, i13);
            int i14 = this.f14003s;
            System.arraycopy(this.f13995k, 0, jArr2, i13, i14);
            System.arraycopy(this.f13998n, 0, jArr3, i13, i14);
            System.arraycopy(this.f13997m, 0, iArr2, i13, i14);
            System.arraycopy(this.f13996l, 0, iArr3, i13, i14);
            System.arraycopy(this.f13999o, 0, aVarArr, i13, i14);
            System.arraycopy(this.f14000p, 0, s0VarArr2, i13, i14);
            System.arraycopy(this.f13994j, 0, iArr, i13, i14);
            this.f13995k = jArr2;
            this.f13998n = jArr3;
            this.f13997m = iArr2;
            this.f13996l = iArr3;
            this.f13999o = aVarArr;
            this.f14000p = s0VarArr2;
            this.f13994j = iArr;
            this.f14003s = 0;
            this.f13993i = i11;
        }
    }

    private int i(long j6) {
        int i6 = this.f14001q;
        int A = A(i6 - 1);
        while (i6 > this.f14004t && this.f13998n[A] >= j6) {
            i6--;
            A--;
            if (A == -1) {
                A = this.f13993i - 1;
            }
        }
        return i6;
    }

    private synchronized long j(long j6, boolean z5, boolean z6) {
        int i6;
        int i7 = this.f14001q;
        if (i7 != 0) {
            long[] jArr = this.f13998n;
            int i8 = this.f14003s;
            if (j6 >= jArr[i8]) {
                if (z6 && (i6 = this.f14004t) != i7) {
                    i7 = i6 + 1;
                }
                int s5 = s(i8, i7, j6, z5);
                if (s5 == -1) {
                    return -1L;
                }
                return m(s5);
            }
        }
        return -1L;
    }

    private synchronized long k() {
        int i6 = this.f14001q;
        if (i6 == 0) {
            return -1L;
        }
        return m(i6);
    }

    private long m(int i6) {
        int i7;
        this.f14006v = Math.max(this.f14006v, y(i6));
        int i8 = this.f14001q - i6;
        this.f14001q = i8;
        this.f14002r += i6;
        int i9 = this.f14003s + i6;
        this.f14003s = i9;
        int i10 = this.f13993i;
        if (i9 >= i10) {
            this.f14003s = i9 - i10;
        }
        int i11 = this.f14004t - i6;
        this.f14004t = i11;
        if (i11 < 0) {
            this.f14004t = 0;
        }
        if (i8 == 0) {
            int i12 = this.f14003s;
            if (i12 != 0) {
                i10 = i12;
            }
            return this.f13995k[i10 - 1] + this.f13996l[i7];
        }
        return this.f13995k[this.f14003s];
    }

    private long q(int i6) {
        int D = D() - i6;
        boolean z5 = false;
        com.google.android.exoplayer2.util.a.a(D >= 0 && D <= this.f14001q - this.f14004t);
        int i7 = this.f14001q - D;
        this.f14001q = i7;
        this.f14007w = Math.max(this.f14006v, y(i7));
        if (D == 0 && this.f14008x) {
            z5 = true;
        }
        this.f14008x = z5;
        int i8 = this.f14001q;
        if (i8 != 0) {
            int A = A(i8 - 1);
            return this.f13995k[A] + this.f13996l[A];
        }
        return 0L;
    }

    private int s(int i6, int i7, long j6, boolean z5) {
        int i8 = -1;
        for (int i9 = 0; i9 < i7 && this.f13998n[i6] <= j6; i9++) {
            if (!z5 || (this.f13997m[i6] & 1) != 0) {
                i8 = i9;
            }
            i6++;
            if (i6 == this.f13993i) {
                i6 = 0;
            }
        }
        return i8;
    }

    private long y(int i6) {
        long j6 = Long.MIN_VALUE;
        if (i6 == 0) {
            return Long.MIN_VALUE;
        }
        int A = A(i6 - 1);
        for (int i7 = 0; i7 < i6; i7++) {
            j6 = Math.max(j6, this.f13998n[A]);
            if ((this.f13997m[A] & 1) != 0) {
                break;
            }
            A--;
            if (A == -1) {
                A = this.f13993i - 1;
            }
        }
        return j6;
    }

    public final synchronized int B(long j6, boolean z5) {
        int A = A(this.f14004t);
        if (E() && j6 >= this.f13998n[A]) {
            if (j6 > this.f14007w && z5) {
                return this.f14001q - this.f14004t;
            }
            int s5 = s(A, this.f14001q - this.f14004t, j6, true);
            if (s5 == -1) {
                return 0;
            }
            return s5;
        }
        return 0;
    }

    public final synchronized com.google.android.exoplayer2.s0 C() {
        return this.f14010z ? null : this.C;
    }

    public final int D() {
        return this.f14002r + this.f14001q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F() {
        this.A = true;
    }

    public final synchronized boolean G() {
        return this.f14008x;
    }

    public synchronized boolean H(boolean z5) {
        com.google.android.exoplayer2.s0 s0Var;
        boolean z6 = true;
        if (E()) {
            int A = A(this.f14004t);
            if (this.f14000p[A] != this.f13991g) {
                return true;
            }
            return I(A);
        }
        if (!z5 && !this.f14008x && ((s0Var = this.C) == null || s0Var == this.f13991g)) {
            z6 = false;
        }
        return z6;
    }

    public void J() {
        com.google.android.exoplayer2.drm.m mVar = this.f13992h;
        if (mVar != null && mVar.getState() == 1) {
            throw ((m.a) com.google.android.exoplayer2.util.a.e(this.f13992h.f()));
        }
    }

    public final synchronized int L() {
        return E() ? this.f13994j[A(this.f14004t)] : this.E;
    }

    public void M() {
        o();
        Q();
    }

    public int N(com.google.android.exoplayer2.t0 t0Var, com.google.android.exoplayer2.decoder.j jVar, boolean z5, boolean z6) {
        int O = O(t0Var, jVar, z5, z6, this.f13986b);
        if (O == -4 && !jVar.isEndOfStream() && !jVar.i()) {
            this.f13985a.k(jVar, this.f13986b);
        }
        return O;
    }

    public void P() {
        S(true);
        Q();
    }

    public final void R() {
        S(false);
    }

    public void S(boolean z5) {
        this.f13985a.l();
        this.f14001q = 0;
        this.f14002r = 0;
        this.f14003s = 0;
        this.f14004t = 0;
        this.f14009y = true;
        this.f14005u = Long.MIN_VALUE;
        this.f14006v = Long.MIN_VALUE;
        this.f14007w = Long.MIN_VALUE;
        this.f14008x = false;
        this.D = null;
        if (z5) {
            this.B = null;
            this.C = null;
            this.f14010z = true;
        }
    }

    public final synchronized boolean U(int i6) {
        T();
        int i7 = this.f14002r;
        if (i6 >= i7 && i6 <= this.f14001q + i7) {
            this.f14005u = Long.MIN_VALUE;
            this.f14004t = i6 - i7;
            return true;
        }
        return false;
    }

    public final synchronized boolean V(long j6, boolean z5) {
        T();
        int A = A(this.f14004t);
        if (E() && j6 >= this.f13998n[A] && (j6 <= this.f14007w || z5)) {
            int s5 = s(A, this.f14001q - this.f14004t, j6, true);
            if (s5 == -1) {
                return false;
            }
            this.f14005u = j6;
            this.f14004t += s5;
            return true;
        }
        return false;
    }

    public final void W(long j6) {
        if (this.H != j6) {
            this.H = j6;
            F();
        }
    }

    public final void X(long j6) {
        this.f14005u = j6;
    }

    public final void Z(b bVar) {
        this.f13990f = bVar;
    }

    @Override // c1.a0
    public /* synthetic */ void a(com.google.android.exoplayer2.util.y yVar, int i6) {
        c1.z.b(this, yVar, i6);
    }

    public final synchronized void a0(int i6) {
        boolean z5;
        if (i6 >= 0) {
            try {
                if (this.f14004t + i6 <= this.f14001q) {
                    z5 = true;
                    com.google.android.exoplayer2.util.a.a(z5);
                    this.f14004t += i6;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z5 = false;
        com.google.android.exoplayer2.util.a.a(z5);
        this.f14004t += i6;
    }

    @Override // c1.a0
    public /* synthetic */ int b(q2.h hVar, int i6, boolean z5) {
        return c1.z.a(this, hVar, i6, z5);
    }

    public final void b0(int i6) {
        this.E = i6;
    }

    @Override // c1.a0
    public final int c(q2.h hVar, int i6, boolean z5, int i7) {
        return this.f13985a.n(hVar, i6, z5);
    }

    public final void c0() {
        this.I = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    @Override // c1.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(long j6, int i6, int i7, int i8, a0.a aVar) {
        int i9;
        if (this.A) {
            e((com.google.android.exoplayer2.s0) com.google.android.exoplayer2.util.a.i(this.B));
        }
        int i10 = i6 & 1;
        boolean z5 = i10 != 0;
        if (this.f14009y) {
            if (!z5) {
                return;
            }
            this.f14009y = false;
        }
        long j7 = this.H + j6;
        if (this.F) {
            if (j7 < this.f14005u) {
                return;
            }
            if (i10 == 0) {
                if (!this.G) {
                    String valueOf = String.valueOf(this.C);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 50);
                    sb.append("Overriding unexpected non-sync sample for format: ");
                    sb.append(valueOf);
                    Log.w("SampleQueue", sb.toString());
                    this.G = true;
                }
                i9 = i6 | 1;
                if (this.I) {
                    if (!z5 || !g(j7)) {
                        return;
                    }
                    this.I = false;
                }
                h(j7, i9, (this.f13985a.e() - i7) - i8, i7, aVar);
            }
        }
        i9 = i6;
        if (this.I) {
        }
        h(j7, i9, (this.f13985a.e() - i7) - i8, i7, aVar);
    }

    @Override // c1.a0
    public final void e(com.google.android.exoplayer2.s0 s0Var) {
        com.google.android.exoplayer2.s0 t5 = t(s0Var);
        this.A = false;
        this.B = s0Var;
        boolean Y = Y(t5);
        b bVar = this.f13990f;
        if (bVar == null || !Y) {
            return;
        }
        bVar.b(t5);
    }

    @Override // c1.a0
    public final void f(com.google.android.exoplayer2.util.y yVar, int i6, int i7) {
        this.f13985a.o(yVar, i6);
    }

    public synchronized long l() {
        int i6 = this.f14004t;
        if (i6 == 0) {
            return -1L;
        }
        return m(i6);
    }

    public final void n(long j6, boolean z5, boolean z6) {
        this.f13985a.c(j(j6, z5, z6));
    }

    public final void o() {
        this.f13985a.c(k());
    }

    public final void p() {
        this.f13985a.c(l());
    }

    public final void r(int i6) {
        this.f13985a.d(q(i6));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.google.android.exoplayer2.s0 t(com.google.android.exoplayer2.s0 s0Var) {
        return (this.H == 0 || s0Var.f4060r == Long.MAX_VALUE) ? s0Var : s0Var.e().i0(s0Var.f4060r + this.H).E();
    }

    public final int u() {
        return this.f14002r;
    }

    public final synchronized long v() {
        return this.f14001q == 0 ? Long.MIN_VALUE : this.f13998n[this.f14003s];
    }

    public final synchronized long w() {
        return this.f14007w;
    }

    public final synchronized long x() {
        return Math.max(this.f14006v, y(this.f14004t));
    }

    public final int z() {
        return this.f14002r + this.f14004t;
    }
}
