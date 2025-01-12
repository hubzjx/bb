package l1;

import android.net.Uri;
import android.util.SparseArray;
import c1.x;
import java.util.Map;
import l1.i0;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public final class a0 implements c1.i {

    /* renamed from: l  reason: collision with root package name */
    public static final c1.o f11418l = new c1.o() { // from class: l1.z
        @Override // c1.o
        public final c1.i[] a() {
            c1.i[] e6;
            e6 = a0.e();
            return e6;
        }

        @Override // c1.o
        public /* synthetic */ c1.i[] b(Uri uri, Map map) {
            return c1.n.a(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.k0 f11419a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray f11420b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11421c;

    /* renamed from: d  reason: collision with root package name */
    private final y f11422d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11423e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11424f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11425g;

    /* renamed from: h  reason: collision with root package name */
    private long f11426h;

    /* renamed from: i  reason: collision with root package name */
    private x f11427i;

    /* renamed from: j  reason: collision with root package name */
    private c1.k f11428j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11429k;

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final m f11430a;

        /* renamed from: b  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.k0 f11431b;

        /* renamed from: c  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.x f11432c = new com.google.android.exoplayer2.util.x(new byte[64]);

        /* renamed from: d  reason: collision with root package name */
        private boolean f11433d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f11434e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f11435f;

        /* renamed from: g  reason: collision with root package name */
        private int f11436g;

        /* renamed from: h  reason: collision with root package name */
        private long f11437h;

        public a(m mVar, com.google.android.exoplayer2.util.k0 k0Var) {
            this.f11430a = mVar;
            this.f11431b = k0Var;
        }

        private void b() {
            this.f11432c.r(8);
            this.f11433d = this.f11432c.g();
            this.f11434e = this.f11432c.g();
            this.f11432c.r(6);
            this.f11436g = this.f11432c.h(8);
        }

        private void c() {
            this.f11437h = 0L;
            if (this.f11433d) {
                this.f11432c.r(4);
                this.f11432c.r(1);
                this.f11432c.r(1);
                long h6 = (this.f11432c.h(3) << 30) | (this.f11432c.h(15) << 15) | this.f11432c.h(15);
                this.f11432c.r(1);
                if (!this.f11435f && this.f11434e) {
                    this.f11432c.r(4);
                    this.f11432c.r(1);
                    this.f11432c.r(1);
                    this.f11432c.r(1);
                    this.f11431b.b((this.f11432c.h(3) << 30) | (this.f11432c.h(15) << 15) | this.f11432c.h(15));
                    this.f11435f = true;
                }
                this.f11437h = this.f11431b.b(h6);
            }
        }

        public void a(com.google.android.exoplayer2.util.y yVar) {
            yVar.i(this.f11432c.f4688a, 0, 3);
            this.f11432c.p(0);
            b();
            yVar.i(this.f11432c.f4688a, 0, this.f11436g);
            this.f11432c.p(0);
            c();
            this.f11430a.e(this.f11437h, 4);
            this.f11430a.c(yVar);
            this.f11430a.d();
        }

        public void d() {
            this.f11435f = false;
            this.f11430a.a();
        }
    }

    public a0() {
        this(new com.google.android.exoplayer2.util.k0(0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c1.i[] e() {
        return new c1.i[]{new a0()};
    }

    private void f(long j6) {
        c1.k kVar;
        c1.x bVar;
        if (this.f11429k) {
            return;
        }
        this.f11429k = true;
        if (this.f11422d.c() != -9223372036854775807L) {
            x xVar = new x(this.f11422d.d(), this.f11422d.c(), j6);
            this.f11427i = xVar;
            kVar = this.f11428j;
            bVar = xVar.b();
        } else {
            kVar = this.f11428j;
            bVar = new x.b(this.f11422d.c());
        }
        kVar.r(bVar);
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(c1.k kVar) {
        this.f11428j = kVar;
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        if ((this.f11419a.e() == -9223372036854775807L) || (this.f11419a.c() != 0 && this.f11419a.c() != j7)) {
            this.f11419a.g();
            this.f11419a.h(j7);
        }
        x xVar = this.f11427i;
        if (xVar != null) {
            xVar.h(j7);
        }
        for (int i6 = 0; i6 < this.f11420b.size(); i6++) {
            ((a) this.f11420b.valueAt(i6)).d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00f8  */
    @Override // c1.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int g(c1.j jVar, c1.w wVar) {
        m mVar;
        int G;
        com.google.android.exoplayer2.util.a.i(this.f11428j);
        long a6 = jVar.a();
        int i6 = (a6 > (-1L) ? 1 : (a6 == (-1L) ? 0 : -1));
        if (!(i6 != 0) || this.f11422d.e()) {
            f(a6);
            x xVar = this.f11427i;
            if (xVar == null || !xVar.d()) {
                jVar.g();
                long m5 = i6 != 0 ? a6 - jVar.m() : -1L;
                if ((m5 == -1 || m5 >= 4) && jVar.l(this.f11421c.c(), 0, 4, true)) {
                    this.f11421c.M(0);
                    int k6 = this.f11421c.k();
                    if (k6 == 441) {
                        return -1;
                    }
                    if (k6 == 442) {
                        jVar.n(this.f11421c.c(), 0, 10);
                        this.f11421c.M(9);
                        G = (this.f11421c.A() & 7) + 14;
                    } else if (k6 != 443) {
                        if (((k6 & (-256)) >> 8) != 1) {
                            jVar.h(1);
                            return 0;
                        }
                        int i7 = k6 & 255;
                        a aVar = (a) this.f11420b.get(i7);
                        if (!this.f11423e) {
                            if (aVar == null) {
                                if (i7 == 189) {
                                    mVar = new c();
                                } else if ((i7 & 224) == 192) {
                                    mVar = new t();
                                } else if ((i7 & 240) == 224) {
                                    mVar = new n();
                                    this.f11425g = true;
                                    this.f11426h = jVar.p();
                                    if (mVar != null) {
                                        mVar.f(this.f11428j, new i0.d(i7, 256));
                                        aVar = new a(mVar, this.f11419a);
                                        this.f11420b.put(i7, aVar);
                                    }
                                } else {
                                    mVar = null;
                                    if (mVar != null) {
                                    }
                                }
                                this.f11424f = true;
                                this.f11426h = jVar.p();
                                if (mVar != null) {
                                }
                            }
                            if (jVar.p() > ((this.f11424f && this.f11425g) ? this.f11426h + 8192 : 1048576L)) {
                                this.f11423e = true;
                                this.f11428j.g();
                            }
                        }
                        jVar.n(this.f11421c.c(), 0, 2);
                        this.f11421c.M(0);
                        int G2 = this.f11421c.G() + 6;
                        if (aVar == null) {
                            jVar.h(G2);
                        } else {
                            this.f11421c.I(G2);
                            jVar.readFully(this.f11421c.c(), 0, G2);
                            this.f11421c.M(6);
                            aVar.a(this.f11421c);
                            com.google.android.exoplayer2.util.y yVar = this.f11421c;
                            yVar.L(yVar.b());
                        }
                        return 0;
                    } else {
                        jVar.n(this.f11421c.c(), 0, 2);
                        this.f11421c.M(0);
                        G = this.f11421c.G() + 6;
                    }
                    jVar.h(G);
                    return 0;
                }
                return -1;
            }
            return this.f11427i.c(jVar, wVar);
        }
        return this.f11422d.g(jVar, wVar);
    }

    @Override // c1.i
    public boolean h(c1.j jVar) {
        byte[] bArr = new byte[14];
        jVar.n(bArr, 0, 14);
        if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
            jVar.o(bArr[13] & 7);
            jVar.n(bArr, 0, 3);
            return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
        }
        return false;
    }

    public a0(com.google.android.exoplayer2.util.k0 k0Var) {
        this.f11419a = k0Var;
        this.f11421c = new com.google.android.exoplayer2.util.y((int) _BufferKt.SEGMENTING_THRESHOLD);
        this.f11420b = new SparseArray();
        this.f11422d = new y();
    }
}
