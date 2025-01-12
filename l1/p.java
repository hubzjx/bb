package l1;

import android.util.SparseArray;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.s0;
import java.util.ArrayList;
import java.util.Arrays;
import l1.i0;
/* loaded from: classes.dex */
public final class p implements m {

    /* renamed from: a  reason: collision with root package name */
    private final d0 f11635a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11636b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11637c;

    /* renamed from: g  reason: collision with root package name */
    private long f11641g;

    /* renamed from: i  reason: collision with root package name */
    private String f11643i;

    /* renamed from: j  reason: collision with root package name */
    private c1.a0 f11644j;

    /* renamed from: k  reason: collision with root package name */
    private b f11645k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11646l;

    /* renamed from: m  reason: collision with root package name */
    private long f11647m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f11648n;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f11642h = new boolean[3];

    /* renamed from: d  reason: collision with root package name */
    private final u f11638d = new u(7, 128);

    /* renamed from: e  reason: collision with root package name */
    private final u f11639e = new u(8, 128);

    /* renamed from: f  reason: collision with root package name */
    private final u f11640f = new u(6, 128);

    /* renamed from: o  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11649o = new com.google.android.exoplayer2.util.y();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final c1.a0 f11650a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f11651b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f11652c;

        /* renamed from: f  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.z f11655f;

        /* renamed from: g  reason: collision with root package name */
        private byte[] f11656g;

        /* renamed from: h  reason: collision with root package name */
        private int f11657h;

        /* renamed from: i  reason: collision with root package name */
        private int f11658i;

        /* renamed from: j  reason: collision with root package name */
        private long f11659j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f11660k;

        /* renamed from: l  reason: collision with root package name */
        private long f11661l;

        /* renamed from: o  reason: collision with root package name */
        private boolean f11664o;

        /* renamed from: p  reason: collision with root package name */
        private long f11665p;

        /* renamed from: q  reason: collision with root package name */
        private long f11666q;

        /* renamed from: r  reason: collision with root package name */
        private boolean f11667r;

        /* renamed from: d  reason: collision with root package name */
        private final SparseArray f11653d = new SparseArray();

        /* renamed from: e  reason: collision with root package name */
        private final SparseArray f11654e = new SparseArray();

        /* renamed from: m  reason: collision with root package name */
        private a f11662m = new a();

        /* renamed from: n  reason: collision with root package name */
        private a f11663n = new a();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private boolean f11668a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f11669b;

            /* renamed from: c  reason: collision with root package name */
            private r.b f11670c;

            /* renamed from: d  reason: collision with root package name */
            private int f11671d;

            /* renamed from: e  reason: collision with root package name */
            private int f11672e;

            /* renamed from: f  reason: collision with root package name */
            private int f11673f;

            /* renamed from: g  reason: collision with root package name */
            private int f11674g;

            /* renamed from: h  reason: collision with root package name */
            private boolean f11675h;

            /* renamed from: i  reason: collision with root package name */
            private boolean f11676i;

            /* renamed from: j  reason: collision with root package name */
            private boolean f11677j;

            /* renamed from: k  reason: collision with root package name */
            private boolean f11678k;

            /* renamed from: l  reason: collision with root package name */
            private int f11679l;

            /* renamed from: m  reason: collision with root package name */
            private int f11680m;

            /* renamed from: n  reason: collision with root package name */
            private int f11681n;

            /* renamed from: o  reason: collision with root package name */
            private int f11682o;

            /* renamed from: p  reason: collision with root package name */
            private int f11683p;

            private a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean c(a aVar) {
                int i6;
                int i7;
                int i8;
                boolean z5;
                if (this.f11668a) {
                    if (aVar.f11668a) {
                        r.b bVar = (r.b) com.google.android.exoplayer2.util.a.i(this.f11670c);
                        r.b bVar2 = (r.b) com.google.android.exoplayer2.util.a.i(aVar.f11670c);
                        return (this.f11673f == aVar.f11673f && this.f11674g == aVar.f11674g && this.f11675h == aVar.f11675h && (!this.f11676i || !aVar.f11676i || this.f11677j == aVar.f11677j) && (((i6 = this.f11671d) == (i7 = aVar.f11671d) || (i6 != 0 && i7 != 0)) && (((i8 = bVar.f4669k) != 0 || bVar2.f4669k != 0 || (this.f11680m == aVar.f11680m && this.f11681n == aVar.f11681n)) && ((i8 != 1 || bVar2.f4669k != 1 || (this.f11682o == aVar.f11682o && this.f11683p == aVar.f11683p)) && (z5 = this.f11678k) == aVar.f11678k && (!z5 || this.f11679l == aVar.f11679l))))) ? false : true;
                    }
                    return true;
                }
                return false;
            }

            public void b() {
                this.f11669b = false;
                this.f11668a = false;
            }

            public boolean d() {
                int i6;
                return this.f11669b && ((i6 = this.f11672e) == 7 || i6 == 2);
            }

            public void e(r.b bVar, int i6, int i7, int i8, int i9, boolean z5, boolean z6, boolean z7, boolean z8, int i10, int i11, int i12, int i13, int i14) {
                this.f11670c = bVar;
                this.f11671d = i6;
                this.f11672e = i7;
                this.f11673f = i8;
                this.f11674g = i9;
                this.f11675h = z5;
                this.f11676i = z6;
                this.f11677j = z7;
                this.f11678k = z8;
                this.f11679l = i10;
                this.f11680m = i11;
                this.f11681n = i12;
                this.f11682o = i13;
                this.f11683p = i14;
                this.f11668a = true;
                this.f11669b = true;
            }

            public void f(int i6) {
                this.f11672e = i6;
                this.f11669b = true;
            }
        }

        public b(c1.a0 a0Var, boolean z5, boolean z6) {
            this.f11650a = a0Var;
            this.f11651b = z5;
            this.f11652c = z6;
            byte[] bArr = new byte[128];
            this.f11656g = bArr;
            this.f11655f = new com.google.android.exoplayer2.util.z(bArr, 0, 0);
            g();
        }

        private void d(int i6) {
            boolean z5 = this.f11667r;
            this.f11650a.d(this.f11666q, z5 ? 1 : 0, (int) (this.f11659j - this.f11665p), i6, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x014e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(byte[] bArr, int i6, int i7) {
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            int g6;
            if (this.f11660k) {
                int i13 = i7 - i6;
                byte[] bArr2 = this.f11656g;
                int length = bArr2.length;
                int i14 = this.f11657h;
                if (length < i14 + i13) {
                    this.f11656g = Arrays.copyOf(bArr2, (i14 + i13) * 2);
                }
                System.arraycopy(bArr, i6, this.f11656g, this.f11657h, i13);
                int i15 = this.f11657h + i13;
                this.f11657h = i15;
                this.f11655f.i(this.f11656g, 0, i15);
                if (this.f11655f.b(8)) {
                    this.f11655f.k();
                    int e6 = this.f11655f.e(2);
                    this.f11655f.l(5);
                    if (this.f11655f.c()) {
                        this.f11655f.h();
                        if (this.f11655f.c()) {
                            int h6 = this.f11655f.h();
                            if (!this.f11652c) {
                                this.f11660k = false;
                                this.f11663n.f(h6);
                            } else if (this.f11655f.c()) {
                                int h7 = this.f11655f.h();
                                if (this.f11654e.indexOfKey(h7) < 0) {
                                    this.f11660k = false;
                                    return;
                                }
                                r.a aVar = (r.a) this.f11654e.get(h7);
                                r.b bVar = (r.b) this.f11653d.get(aVar.f4657b);
                                if (bVar.f4666h) {
                                    if (!this.f11655f.b(2)) {
                                        return;
                                    }
                                    this.f11655f.l(2);
                                }
                                if (this.f11655f.b(bVar.f4668j)) {
                                    int e7 = this.f11655f.e(bVar.f4668j);
                                    if (bVar.f4667i) {
                                        z5 = false;
                                    } else if (!this.f11655f.b(1)) {
                                        return;
                                    } else {
                                        boolean d6 = this.f11655f.d();
                                        if (d6) {
                                            if (this.f11655f.b(1)) {
                                                z5 = d6;
                                                z7 = this.f11655f.d();
                                                z6 = true;
                                                z8 = this.f11658i != 5;
                                                if (z8) {
                                                    i8 = 0;
                                                } else if (!this.f11655f.c()) {
                                                    return;
                                                } else {
                                                    i8 = this.f11655f.h();
                                                }
                                                i9 = bVar.f4669k;
                                                if (i9 != 0) {
                                                    if (!this.f11655f.b(bVar.f4670l)) {
                                                        return;
                                                    }
                                                    int e8 = this.f11655f.e(bVar.f4670l);
                                                    if (aVar.f4658c && !z5) {
                                                        if (this.f11655f.c()) {
                                                            i12 = this.f11655f.g();
                                                            i10 = e8;
                                                            i11 = 0;
                                                            g6 = 0;
                                                            this.f11663n.e(bVar, e6, h6, e7, h7, z5, z6, z7, z8, i8, i10, i12, i11, g6);
                                                            this.f11660k = false;
                                                        }
                                                        return;
                                                    }
                                                    i10 = e8;
                                                } else if (i9 == 1 && !bVar.f4671m) {
                                                    if (this.f11655f.c()) {
                                                        int g7 = this.f11655f.g();
                                                        if (!aVar.f4658c || z5) {
                                                            i11 = g7;
                                                            i10 = 0;
                                                            i12 = 0;
                                                            g6 = 0;
                                                            this.f11663n.e(bVar, e6, h6, e7, h7, z5, z6, z7, z8, i8, i10, i12, i11, g6);
                                                            this.f11660k = false;
                                                        } else if (this.f11655f.c()) {
                                                            g6 = this.f11655f.g();
                                                            i11 = g7;
                                                            i10 = 0;
                                                            i12 = 0;
                                                            this.f11663n.e(bVar, e6, h6, e7, h7, z5, z6, z7, z8, i8, i10, i12, i11, g6);
                                                            this.f11660k = false;
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                } else {
                                                    i10 = 0;
                                                }
                                                i12 = 0;
                                                i11 = 0;
                                                g6 = 0;
                                                this.f11663n.e(bVar, e6, h6, e7, h7, z5, z6, z7, z8, i8, i10, i12, i11, g6);
                                                this.f11660k = false;
                                            }
                                            return;
                                        }
                                        z5 = d6;
                                    }
                                    z6 = false;
                                    z7 = false;
                                    if (this.f11658i != 5) {
                                    }
                                    if (z8) {
                                    }
                                    i9 = bVar.f4669k;
                                    if (i9 != 0) {
                                    }
                                    i12 = 0;
                                    i11 = 0;
                                    g6 = 0;
                                    this.f11663n.e(bVar, e6, h6, e7, h7, z5, z6, z7, z8, i8, i10, i12, i11, g6);
                                    this.f11660k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean b(long j6, int i6, boolean z5, boolean z6) {
            boolean z7 = false;
            if (this.f11658i == 9 || (this.f11652c && this.f11663n.c(this.f11662m))) {
                if (z5 && this.f11664o) {
                    d(i6 + ((int) (j6 - this.f11659j)));
                }
                this.f11665p = this.f11659j;
                this.f11666q = this.f11661l;
                this.f11667r = false;
                this.f11664o = true;
            }
            if (this.f11651b) {
                z6 = this.f11663n.d();
            }
            boolean z8 = this.f11667r;
            int i7 = this.f11658i;
            if (i7 == 5 || (z6 && i7 == 1)) {
                z7 = true;
            }
            boolean z9 = z8 | z7;
            this.f11667r = z9;
            return z9;
        }

        public boolean c() {
            return this.f11652c;
        }

        public void e(r.a aVar) {
            this.f11654e.append(aVar.f4656a, aVar);
        }

        public void f(r.b bVar) {
            this.f11653d.append(bVar.f4662d, bVar);
        }

        public void g() {
            this.f11660k = false;
            this.f11664o = false;
            this.f11663n.b();
        }

        public void h(long j6, int i6, long j7) {
            this.f11658i = i6;
            this.f11661l = j7;
            this.f11659j = j6;
            if (!this.f11651b || i6 != 1) {
                if (!this.f11652c) {
                    return;
                }
                if (i6 != 5 && i6 != 1 && i6 != 2) {
                    return;
                }
            }
            a aVar = this.f11662m;
            this.f11662m = this.f11663n;
            this.f11663n = aVar;
            aVar.b();
            this.f11657h = 0;
            this.f11660k = true;
        }
    }

    public p(d0 d0Var, boolean z5, boolean z6) {
        this.f11635a = d0Var;
        this.f11636b = z5;
        this.f11637c = z6;
    }

    private void b() {
        com.google.android.exoplayer2.util.a.i(this.f11644j);
        s0.j(this.f11645k);
    }

    private void g(long j6, int i6, int i7, long j7) {
        u uVar;
        if (!this.f11646l || this.f11645k.c()) {
            this.f11638d.b(i7);
            this.f11639e.b(i7);
            if (this.f11646l) {
                if (this.f11638d.c()) {
                    u uVar2 = this.f11638d;
                    this.f11645k.f(com.google.android.exoplayer2.util.r.i(uVar2.f11753d, 3, uVar2.f11754e));
                    uVar = this.f11638d;
                } else if (this.f11639e.c()) {
                    u uVar3 = this.f11639e;
                    this.f11645k.e(com.google.android.exoplayer2.util.r.h(uVar3.f11753d, 3, uVar3.f11754e));
                    uVar = this.f11639e;
                }
            } else if (this.f11638d.c() && this.f11639e.c()) {
                ArrayList arrayList = new ArrayList();
                u uVar4 = this.f11638d;
                arrayList.add(Arrays.copyOf(uVar4.f11753d, uVar4.f11754e));
                u uVar5 = this.f11639e;
                arrayList.add(Arrays.copyOf(uVar5.f11753d, uVar5.f11754e));
                u uVar6 = this.f11638d;
                r.b i8 = com.google.android.exoplayer2.util.r.i(uVar6.f11753d, 3, uVar6.f11754e);
                u uVar7 = this.f11639e;
                r.a h6 = com.google.android.exoplayer2.util.r.h(uVar7.f11753d, 3, uVar7.f11754e);
                this.f11644j.e(new s0.b().S(this.f11643i).e0("video/avc").I(com.google.android.exoplayer2.util.d.a(i8.f4659a, i8.f4660b, i8.f4661c)).j0(i8.f4663e).Q(i8.f4664f).a0(i8.f4665g).T(arrayList).E());
                this.f11646l = true;
                this.f11645k.f(i8);
                this.f11645k.e(h6);
                this.f11638d.d();
                uVar = this.f11639e;
            }
            uVar.d();
        }
        if (this.f11640f.b(i7)) {
            u uVar8 = this.f11640f;
            this.f11649o.K(this.f11640f.f11753d, com.google.android.exoplayer2.util.r.k(uVar8.f11753d, uVar8.f11754e));
            this.f11649o.M(4);
            this.f11635a.a(j7, this.f11649o);
        }
        if (this.f11645k.b(j6, i6, this.f11646l, this.f11648n)) {
            this.f11648n = false;
        }
    }

    private void h(byte[] bArr, int i6, int i7) {
        if (!this.f11646l || this.f11645k.c()) {
            this.f11638d.a(bArr, i6, i7);
            this.f11639e.a(bArr, i6, i7);
        }
        this.f11640f.a(bArr, i6, i7);
        this.f11645k.a(bArr, i6, i7);
    }

    private void i(long j6, int i6, long j7) {
        if (!this.f11646l || this.f11645k.c()) {
            this.f11638d.e(i6);
            this.f11639e.e(i6);
        }
        this.f11640f.e(i6);
        this.f11645k.h(j6, i6, j7);
    }

    @Override // l1.m
    public void a() {
        this.f11641g = 0L;
        this.f11648n = false;
        com.google.android.exoplayer2.util.r.a(this.f11642h);
        this.f11638d.d();
        this.f11639e.d();
        this.f11640f.d();
        b bVar = this.f11645k;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // l1.m
    public void c(com.google.android.exoplayer2.util.y yVar) {
        b();
        int d6 = yVar.d();
        int e6 = yVar.e();
        byte[] c6 = yVar.c();
        this.f11641g += yVar.a();
        this.f11644j.a(yVar, yVar.a());
        while (true) {
            int c7 = com.google.android.exoplayer2.util.r.c(c6, d6, e6, this.f11642h);
            if (c7 == e6) {
                h(c6, d6, e6);
                return;
            }
            int f6 = com.google.android.exoplayer2.util.r.f(c6, c7);
            int i6 = c7 - d6;
            if (i6 > 0) {
                h(c6, d6, c7);
            }
            int i7 = e6 - c7;
            long j6 = this.f11641g - i7;
            g(j6, i7, i6 < 0 ? -i6 : 0, this.f11647m);
            i(j6, f6, this.f11647m);
            d6 = c7 + 3;
        }
    }

    @Override // l1.m
    public void d() {
    }

    @Override // l1.m
    public void e(long j6, int i6) {
        this.f11647m = j6;
        this.f11648n |= (i6 & 2) != 0;
    }

    @Override // l1.m
    public void f(c1.k kVar, i0.d dVar) {
        dVar.a();
        this.f11643i = dVar.b();
        c1.a0 e6 = kVar.e(dVar.c(), 2);
        this.f11644j = e6;
        this.f11645k = new b(e6, this.f11636b, this.f11637c);
        this.f11635a.b(kVar, dVar);
    }
}
