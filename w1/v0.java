package w1;

import com.google.android.exoplayer2.s1;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import okio.Segment;
import q2.c0;
import q2.d0;
import q2.l;
import w1.e0;
import w1.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v0 implements t, d0.b {

    /* renamed from: a  reason: collision with root package name */
    private final q2.o f14056a;

    /* renamed from: b  reason: collision with root package name */
    private final l.a f14057b;

    /* renamed from: c  reason: collision with root package name */
    private final q2.i0 f14058c;

    /* renamed from: d  reason: collision with root package name */
    private final q2.c0 f14059d;

    /* renamed from: e  reason: collision with root package name */
    private final e0.a f14060e;

    /* renamed from: f  reason: collision with root package name */
    private final y0 f14061f;

    /* renamed from: h  reason: collision with root package name */
    private final long f14063h;

    /* renamed from: l  reason: collision with root package name */
    final com.google.android.exoplayer2.s0 f14065l;

    /* renamed from: m  reason: collision with root package name */
    final boolean f14066m;

    /* renamed from: n  reason: collision with root package name */
    boolean f14067n;

    /* renamed from: o  reason: collision with root package name */
    byte[] f14068o;

    /* renamed from: p  reason: collision with root package name */
    int f14069p;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList f14062g = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    final q2.d0 f14064k = new q2.d0("Loader:SingleSampleMediaPeriod");

    /* loaded from: classes.dex */
    private final class b implements r0 {

        /* renamed from: a  reason: collision with root package name */
        private int f14070a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f14071b;

        private b() {
        }

        private void a() {
            if (this.f14071b) {
                return;
            }
            v0.this.f14060e.i(com.google.android.exoplayer2.util.q.j(v0.this.f14065l.f4056n), v0.this.f14065l, 0, null, 0L);
            this.f14071b = true;
        }

        @Override // w1.r0
        public void b() {
            v0 v0Var = v0.this;
            if (v0Var.f14066m) {
                return;
            }
            v0Var.f14064k.b();
        }

        public void c() {
            if (this.f14070a == 2) {
                this.f14070a = 1;
            }
        }

        @Override // w1.r0
        public int e(com.google.android.exoplayer2.t0 t0Var, com.google.android.exoplayer2.decoder.j jVar, boolean z5) {
            a();
            int i6 = this.f14070a;
            if (i6 == 2) {
                jVar.addFlag(4);
                return -4;
            } else if (z5 || i6 == 0) {
                t0Var.f4441b = v0.this.f14065l;
                this.f14070a = 1;
                return -5;
            } else {
                v0 v0Var = v0.this;
                if (v0Var.f14067n) {
                    if (v0Var.f14068o != null) {
                        jVar.addFlag(1);
                        jVar.f3602d = 0L;
                        if (jVar.i()) {
                            return -4;
                        }
                        jVar.f(v0.this.f14069p);
                        ByteBuffer byteBuffer = jVar.f3600b;
                        v0 v0Var2 = v0.this;
                        byteBuffer.put(v0Var2.f14068o, 0, v0Var2.f14069p);
                    } else {
                        jVar.addFlag(4);
                    }
                    this.f14070a = 2;
                    return -4;
                }
                return -3;
            }
        }

        @Override // w1.r0
        public boolean g() {
            return v0.this.f14067n;
        }

        @Override // w1.r0
        public int r(long j6) {
            a();
            if (j6 <= 0 || this.f14070a == 2) {
                return 0;
            }
            this.f14070a = 2;
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c implements d0.e {

        /* renamed from: a  reason: collision with root package name */
        public final long f14073a = p.a();

        /* renamed from: b  reason: collision with root package name */
        public final q2.o f14074b;

        /* renamed from: c  reason: collision with root package name */
        private final q2.g0 f14075c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f14076d;

        public c(q2.o oVar, q2.l lVar) {
            this.f14074b = oVar;
            this.f14075c = new q2.g0(lVar);
        }

        @Override // q2.d0.e
        public void a() {
            this.f14075c.t();
            try {
                this.f14075c.b(this.f14074b);
                int i6 = 0;
                while (i6 != -1) {
                    int q5 = (int) this.f14075c.q();
                    byte[] bArr = this.f14076d;
                    if (bArr == null) {
                        this.f14076d = new byte[Segment.SHARE_MINIMUM];
                    } else if (q5 == bArr.length) {
                        this.f14076d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    q2.g0 g0Var = this.f14075c;
                    byte[] bArr2 = this.f14076d;
                    i6 = g0Var.read(bArr2, q5, bArr2.length - q5);
                }
            } finally {
                com.google.android.exoplayer2.util.s0.o(this.f14075c);
            }
        }

        @Override // q2.d0.e
        public void c() {
        }
    }

    public v0(q2.o oVar, l.a aVar, q2.i0 i0Var, com.google.android.exoplayer2.s0 s0Var, long j6, q2.c0 c0Var, e0.a aVar2, boolean z5) {
        this.f14056a = oVar;
        this.f14057b = aVar;
        this.f14058c = i0Var;
        this.f14065l = s0Var;
        this.f14063h = j6;
        this.f14059d = c0Var;
        this.f14060e = aVar2;
        this.f14066m = z5;
        this.f14061f = new y0(new x0(s0Var));
    }

    @Override // w1.t, w1.s0
    public boolean a() {
        return this.f14064k.j();
    }

    @Override // w1.t
    public long c(long j6, s1 s1Var) {
        return j6;
    }

    @Override // w1.t, w1.s0
    public long d() {
        return (this.f14067n || this.f14064k.j()) ? Long.MIN_VALUE : 0L;
    }

    @Override // q2.d0.b
    /* renamed from: e */
    public void p(c cVar, long j6, long j7, boolean z5) {
        q2.g0 g0Var = cVar.f14075c;
        p pVar = new p(cVar.f14073a, cVar.f14074b, g0Var.r(), g0Var.s(), j6, j7, g0Var.q());
        this.f14059d.a(cVar.f14073a);
        this.f14060e.r(pVar, 1, -1, null, 0, null, 0L, this.f14063h);
    }

    @Override // w1.t, w1.s0
    public long f() {
        return this.f14067n ? Long.MIN_VALUE : 0L;
    }

    @Override // q2.d0.b
    /* renamed from: g */
    public void m(c cVar, long j6, long j7) {
        this.f14069p = (int) cVar.f14075c.q();
        this.f14068o = (byte[]) com.google.android.exoplayer2.util.a.e(cVar.f14076d);
        this.f14067n = true;
        q2.g0 g0Var = cVar.f14075c;
        p pVar = new p(cVar.f14073a, cVar.f14074b, g0Var.r(), g0Var.s(), j6, j7, this.f14069p);
        this.f14059d.a(cVar.f14073a);
        this.f14060e.u(pVar, 1, -1, this.f14065l, 0, null, 0L, this.f14063h);
    }

    @Override // w1.t, w1.s0
    public boolean h(long j6) {
        if (this.f14067n || this.f14064k.j() || this.f14064k.i()) {
            return false;
        }
        q2.l a6 = this.f14057b.a();
        q2.i0 i0Var = this.f14058c;
        if (i0Var != null) {
            a6.i(i0Var);
        }
        c cVar = new c(this.f14056a, a6);
        this.f14060e.A(new p(cVar.f14073a, this.f14056a, this.f14064k.n(cVar, this, this.f14059d.d(1))), 1, -1, this.f14065l, 0, null, 0L, this.f14063h);
        return true;
    }

    @Override // w1.t, w1.s0
    public void i(long j6) {
    }

    @Override // q2.d0.b
    /* renamed from: j */
    public d0.c k(c cVar, long j6, long j7, IOException iOException, int i6) {
        d0.c h6;
        q2.g0 g0Var = cVar.f14075c;
        p pVar = new p(cVar.f14073a, cVar.f14074b, g0Var.r(), g0Var.s(), j6, j7, g0Var.q());
        long b6 = this.f14059d.b(new c0.a(pVar, new s(1, -1, this.f14065l, 0, null, 0L, com.google.android.exoplayer2.p.b(this.f14063h)), iOException, i6));
        int i7 = (b6 > (-9223372036854775807L) ? 1 : (b6 == (-9223372036854775807L) ? 0 : -1));
        boolean z5 = i7 == 0 || i6 >= this.f14059d.d(1);
        if (this.f14066m && z5) {
            this.f14067n = true;
            h6 = q2.d0.f12728f;
        } else {
            h6 = i7 != 0 ? q2.d0.h(false, b6) : q2.d0.f12729g;
        }
        boolean z6 = !h6.c();
        this.f14060e.w(pVar, 1, -1, this.f14065l, 0, null, 0L, this.f14063h, iOException, z6);
        if (z6) {
            this.f14059d.a(cVar.f14073a);
        }
        return h6;
    }

    @Override // w1.t
    public long l() {
        return -9223372036854775807L;
    }

    @Override // w1.t
    public y0 n() {
        return this.f14061f;
    }

    @Override // w1.t
    public void o(t.a aVar, long j6) {
        aVar.g(this);
    }

    @Override // w1.t
    public long q(o2.j[] jVarArr, boolean[] zArr, r0[] r0VarArr, boolean[] zArr2, long j6) {
        for (int i6 = 0; i6 < jVarArr.length; i6++) {
            r0 r0Var = r0VarArr[i6];
            if (r0Var != null && (jVarArr[i6] == null || !zArr[i6])) {
                this.f14062g.remove(r0Var);
                r0VarArr[i6] = null;
            }
            if (r0VarArr[i6] == null && jVarArr[i6] != null) {
                b bVar = new b();
                this.f14062g.add(bVar);
                r0VarArr[i6] = bVar;
                zArr2[i6] = true;
            }
        }
        return j6;
    }

    public void r() {
        this.f14064k.l();
    }

    @Override // w1.t
    public void s() {
    }

    @Override // w1.t
    public void t(long j6, boolean z5) {
    }

    @Override // w1.t
    public long u(long j6) {
        for (int i6 = 0; i6 < this.f14062g.size(); i6++) {
            ((b) this.f14062g.get(i6)).c();
        }
        return j6;
    }
}
