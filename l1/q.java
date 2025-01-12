package l1;

import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.s0;
import java.util.Collections;
import l1.i0;
/* loaded from: classes.dex */
public final class q implements m {

    /* renamed from: a  reason: collision with root package name */
    private final d0 f11684a;

    /* renamed from: b  reason: collision with root package name */
    private String f11685b;

    /* renamed from: c  reason: collision with root package name */
    private c1.a0 f11686c;

    /* renamed from: d  reason: collision with root package name */
    private a f11687d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11688e;

    /* renamed from: l  reason: collision with root package name */
    private long f11695l;

    /* renamed from: m  reason: collision with root package name */
    private long f11696m;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f11689f = new boolean[3];

    /* renamed from: g  reason: collision with root package name */
    private final u f11690g = new u(32, 128);

    /* renamed from: h  reason: collision with root package name */
    private final u f11691h = new u(33, 128);

    /* renamed from: i  reason: collision with root package name */
    private final u f11692i = new u(34, 128);

    /* renamed from: j  reason: collision with root package name */
    private final u f11693j = new u(39, 128);

    /* renamed from: k  reason: collision with root package name */
    private final u f11694k = new u(40, 128);

    /* renamed from: n  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11697n = new com.google.android.exoplayer2.util.y();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final c1.a0 f11698a;

        /* renamed from: b  reason: collision with root package name */
        private long f11699b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f11700c;

        /* renamed from: d  reason: collision with root package name */
        private int f11701d;

        /* renamed from: e  reason: collision with root package name */
        private long f11702e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f11703f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f11704g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f11705h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f11706i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f11707j;

        /* renamed from: k  reason: collision with root package name */
        private long f11708k;

        /* renamed from: l  reason: collision with root package name */
        private long f11709l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f11710m;

        public a(c1.a0 a0Var) {
            this.f11698a = a0Var;
        }

        private static boolean b(int i6) {
            return (32 <= i6 && i6 <= 35) || i6 == 39;
        }

        private static boolean c(int i6) {
            return i6 < 32 || i6 == 40;
        }

        private void d(int i6) {
            boolean z5 = this.f11710m;
            this.f11698a.d(this.f11709l, z5 ? 1 : 0, (int) (this.f11699b - this.f11708k), i6, null);
        }

        public void a(long j6, int i6, boolean z5) {
            if (this.f11707j && this.f11704g) {
                this.f11710m = this.f11700c;
                this.f11707j = false;
            } else if (this.f11705h || this.f11704g) {
                if (z5 && this.f11706i) {
                    d(i6 + ((int) (j6 - this.f11699b)));
                }
                this.f11708k = this.f11699b;
                this.f11709l = this.f11702e;
                this.f11710m = this.f11700c;
                this.f11706i = true;
            }
        }

        public void e(byte[] bArr, int i6, int i7) {
            if (this.f11703f) {
                int i8 = this.f11701d;
                int i9 = (i6 + 2) - i8;
                if (i9 >= i7) {
                    this.f11701d = i8 + (i7 - i6);
                    return;
                }
                this.f11704g = (bArr[i9] & 128) != 0;
                this.f11703f = false;
            }
        }

        public void f() {
            this.f11703f = false;
            this.f11704g = false;
            this.f11705h = false;
            this.f11706i = false;
            this.f11707j = false;
        }

        public void g(long j6, int i6, int i7, long j7, boolean z5) {
            boolean z6 = false;
            this.f11704g = false;
            this.f11705h = false;
            this.f11702e = j7;
            this.f11701d = 0;
            this.f11699b = j6;
            if (!c(i7)) {
                if (this.f11706i && !this.f11707j) {
                    if (z5) {
                        d(i6);
                    }
                    this.f11706i = false;
                }
                if (b(i7)) {
                    this.f11705h = !this.f11707j;
                    this.f11707j = true;
                }
            }
            boolean z7 = i7 >= 16 && i7 <= 21;
            this.f11700c = z7;
            this.f11703f = (z7 || i7 <= 9) ? true : true;
        }
    }

    public q(d0 d0Var) {
        this.f11684a = d0Var;
    }

    private void b() {
        com.google.android.exoplayer2.util.a.i(this.f11686c);
        s0.j(this.f11687d);
    }

    private void g(long j6, int i6, int i7, long j7) {
        this.f11687d.a(j6, i6, this.f11688e);
        if (!this.f11688e) {
            this.f11690g.b(i7);
            this.f11691h.b(i7);
            this.f11692i.b(i7);
            if (this.f11690g.c() && this.f11691h.c() && this.f11692i.c()) {
                this.f11686c.e(i(this.f11685b, this.f11690g, this.f11691h, this.f11692i));
                this.f11688e = true;
            }
        }
        if (this.f11693j.b(i7)) {
            u uVar = this.f11693j;
            this.f11697n.K(this.f11693j.f11753d, com.google.android.exoplayer2.util.r.k(uVar.f11753d, uVar.f11754e));
            this.f11697n.N(5);
            this.f11684a.a(j7, this.f11697n);
        }
        if (this.f11694k.b(i7)) {
            u uVar2 = this.f11694k;
            this.f11697n.K(this.f11694k.f11753d, com.google.android.exoplayer2.util.r.k(uVar2.f11753d, uVar2.f11754e));
            this.f11697n.N(5);
            this.f11684a.a(j7, this.f11697n);
        }
    }

    private void h(byte[] bArr, int i6, int i7) {
        this.f11687d.e(bArr, i6, i7);
        if (!this.f11688e) {
            this.f11690g.a(bArr, i6, i7);
            this.f11691h.a(bArr, i6, i7);
            this.f11692i.a(bArr, i6, i7);
        }
        this.f11693j.a(bArr, i6, i7);
        this.f11694k.a(bArr, i6, i7);
    }

    private static com.google.android.exoplayer2.s0 i(String str, u uVar, u uVar2, u uVar3) {
        int i6 = uVar.f11754e;
        byte[] bArr = new byte[uVar2.f11754e + i6 + uVar3.f11754e];
        System.arraycopy(uVar.f11753d, 0, bArr, 0, i6);
        System.arraycopy(uVar2.f11753d, 0, bArr, uVar.f11754e, uVar2.f11754e);
        System.arraycopy(uVar3.f11753d, 0, bArr, uVar.f11754e + uVar2.f11754e, uVar3.f11754e);
        com.google.android.exoplayer2.util.z zVar = new com.google.android.exoplayer2.util.z(uVar2.f11753d, 0, uVar2.f11754e);
        zVar.l(44);
        int e6 = zVar.e(3);
        zVar.k();
        zVar.l(88);
        zVar.l(8);
        int i7 = 0;
        for (int i8 = 0; i8 < e6; i8++) {
            if (zVar.d()) {
                i7 += 89;
            }
            if (zVar.d()) {
                i7 += 8;
            }
        }
        zVar.l(i7);
        if (e6 > 0) {
            zVar.l((8 - e6) * 2);
        }
        zVar.h();
        int h6 = zVar.h();
        if (h6 == 3) {
            zVar.k();
        }
        int h7 = zVar.h();
        int h8 = zVar.h();
        if (zVar.d()) {
            int h9 = zVar.h();
            int h10 = zVar.h();
            int h11 = zVar.h();
            int h12 = zVar.h();
            h7 -= ((h6 == 1 || h6 == 2) ? 2 : 1) * (h9 + h10);
            h8 -= (h6 == 1 ? 2 : 1) * (h11 + h12);
        }
        zVar.h();
        zVar.h();
        int h13 = zVar.h();
        int i9 = zVar.d() ? 0 : e6;
        while (true) {
            zVar.h();
            zVar.h();
            zVar.h();
            if (i9 > e6) {
                break;
            }
            i9++;
        }
        zVar.h();
        zVar.h();
        zVar.h();
        if (zVar.d() && zVar.d()) {
            j(zVar);
        }
        zVar.l(2);
        if (zVar.d()) {
            zVar.l(8);
            zVar.h();
            zVar.h();
            zVar.k();
        }
        k(zVar);
        if (zVar.d()) {
            for (int i10 = 0; i10 < zVar.h(); i10++) {
                zVar.l(h13 + 4 + 1);
            }
        }
        zVar.l(2);
        float f6 = 1.0f;
        if (zVar.d() && zVar.d()) {
            int e7 = zVar.e(8);
            if (e7 == 255) {
                int e8 = zVar.e(16);
                int e9 = zVar.e(16);
                if (e8 != 0 && e9 != 0) {
                    f6 = e8 / e9;
                }
            } else {
                float[] fArr = com.google.android.exoplayer2.util.r.f4653b;
                if (e7 < fArr.length) {
                    f6 = fArr[e7];
                } else {
                    StringBuilder sb = new StringBuilder(46);
                    sb.append("Unexpected aspect_ratio_idc value: ");
                    sb.append(e7);
                    com.google.android.exoplayer2.util.n.h("H265Reader", sb.toString());
                }
            }
        }
        return new s0.b().S(str).e0("video/hevc").j0(h7).Q(h8).a0(f6).T(Collections.singletonList(bArr)).E();
    }

    private static void j(com.google.android.exoplayer2.util.z zVar) {
        for (int i6 = 0; i6 < 4; i6++) {
            int i7 = 0;
            while (i7 < 6) {
                int i8 = 1;
                if (zVar.d()) {
                    int min = Math.min(64, 1 << ((i6 << 1) + 4));
                    if (i6 > 1) {
                        zVar.g();
                    }
                    for (int i9 = 0; i9 < min; i9++) {
                        zVar.g();
                    }
                } else {
                    zVar.h();
                }
                if (i6 == 3) {
                    i8 = 3;
                }
                i7 += i8;
            }
        }
    }

    private static void k(com.google.android.exoplayer2.util.z zVar) {
        int h6 = zVar.h();
        boolean z5 = false;
        int i6 = 0;
        for (int i7 = 0; i7 < h6; i7++) {
            if (i7 != 0) {
                z5 = zVar.d();
            }
            if (z5) {
                zVar.k();
                zVar.h();
                for (int i8 = 0; i8 <= i6; i8++) {
                    if (zVar.d()) {
                        zVar.k();
                    }
                }
            } else {
                int h7 = zVar.h();
                int h8 = zVar.h();
                int i9 = h7 + h8;
                for (int i10 = 0; i10 < h7; i10++) {
                    zVar.h();
                    zVar.k();
                }
                for (int i11 = 0; i11 < h8; i11++) {
                    zVar.h();
                    zVar.k();
                }
                i6 = i9;
            }
        }
    }

    private void l(long j6, int i6, int i7, long j7) {
        this.f11687d.g(j6, i6, i7, j7, this.f11688e);
        if (!this.f11688e) {
            this.f11690g.e(i7);
            this.f11691h.e(i7);
            this.f11692i.e(i7);
        }
        this.f11693j.e(i7);
        this.f11694k.e(i7);
    }

    @Override // l1.m
    public void a() {
        this.f11695l = 0L;
        com.google.android.exoplayer2.util.r.a(this.f11689f);
        this.f11690g.d();
        this.f11691h.d();
        this.f11692i.d();
        this.f11693j.d();
        this.f11694k.d();
        a aVar = this.f11687d;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // l1.m
    public void c(com.google.android.exoplayer2.util.y yVar) {
        b();
        while (yVar.a() > 0) {
            int d6 = yVar.d();
            int e6 = yVar.e();
            byte[] c6 = yVar.c();
            this.f11695l += yVar.a();
            this.f11686c.a(yVar, yVar.a());
            while (d6 < e6) {
                int c7 = com.google.android.exoplayer2.util.r.c(c6, d6, e6, this.f11689f);
                if (c7 == e6) {
                    h(c6, d6, e6);
                    return;
                }
                int e7 = com.google.android.exoplayer2.util.r.e(c6, c7);
                int i6 = c7 - d6;
                if (i6 > 0) {
                    h(c6, d6, c7);
                }
                int i7 = e6 - c7;
                long j6 = this.f11695l - i7;
                g(j6, i7, i6 < 0 ? -i6 : 0, this.f11696m);
                l(j6, i7, e7, this.f11696m);
                d6 = c7 + 3;
            }
        }
    }

    @Override // l1.m
    public void d() {
    }

    @Override // l1.m
    public void e(long j6, int i6) {
        this.f11696m = j6;
    }

    @Override // l1.m
    public void f(c1.k kVar, i0.d dVar) {
        dVar.a();
        this.f11685b = dVar.b();
        c1.a0 e6 = kVar.e(dVar.c(), 2);
        this.f11686c = e6;
        this.f11687d = new a(e6);
        this.f11684a.b(kVar, dVar);
    }
}
