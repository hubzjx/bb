package l1;

import com.google.android.exoplayer2.s0;
import java.util.Arrays;
import java.util.Collections;
import l1.i0;
/* loaded from: classes.dex */
public final class o implements m {

    /* renamed from: l  reason: collision with root package name */
    private static final float[] f11609l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private final k0 f11610a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11611b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean[] f11612c = new boolean[4];

    /* renamed from: d  reason: collision with root package name */
    private final a f11613d = new a(128);

    /* renamed from: e  reason: collision with root package name */
    private final u f11614e;

    /* renamed from: f  reason: collision with root package name */
    private b f11615f;

    /* renamed from: g  reason: collision with root package name */
    private long f11616g;

    /* renamed from: h  reason: collision with root package name */
    private String f11617h;

    /* renamed from: i  reason: collision with root package name */
    private c1.a0 f11618i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11619j;

    /* renamed from: k  reason: collision with root package name */
    private long f11620k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: f  reason: collision with root package name */
        private static final byte[] f11621f = {0, 0, 1};

        /* renamed from: a  reason: collision with root package name */
        private boolean f11622a;

        /* renamed from: b  reason: collision with root package name */
        private int f11623b;

        /* renamed from: c  reason: collision with root package name */
        public int f11624c;

        /* renamed from: d  reason: collision with root package name */
        public int f11625d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f11626e;

        public a(int i6) {
            this.f11626e = new byte[i6];
        }

        public void a(byte[] bArr, int i6, int i7) {
            if (this.f11622a) {
                int i8 = i7 - i6;
                byte[] bArr2 = this.f11626e;
                int length = bArr2.length;
                int i9 = this.f11624c;
                if (length < i9 + i8) {
                    this.f11626e = Arrays.copyOf(bArr2, (i9 + i8) * 2);
                }
                System.arraycopy(bArr, i6, this.f11626e, this.f11624c, i8);
                this.f11624c += i8;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
            if (r9 != 181) goto L24;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean b(int i6, int i7) {
            int i8 = this.f11623b;
            if (i8 != 0) {
                int i9 = 2;
                if (i8 != 1) {
                    if (i8 != 2) {
                        i9 = 4;
                        if (i8 == 3) {
                            if ((i6 & 240) == 32) {
                                this.f11625d = this.f11624c;
                                this.f11623b = i9;
                            }
                            com.google.android.exoplayer2.util.n.h("H263Reader", "Unexpected start code value");
                            c();
                        } else if (i8 != 4) {
                            throw new IllegalStateException();
                        } else {
                            if (i6 == 179 || i6 == 181) {
                                this.f11624c -= i7;
                                this.f11622a = false;
                                return true;
                            }
                        }
                    } else {
                        if (i6 <= 31) {
                            this.f11623b = 3;
                        }
                        com.google.android.exoplayer2.util.n.h("H263Reader", "Unexpected start code value");
                        c();
                    }
                }
            } else if (i6 == 176) {
                this.f11623b = 1;
                this.f11622a = true;
            }
            byte[] bArr = f11621f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f11622a = false;
            this.f11624c = 0;
            this.f11623b = 0;
        }
    }

    /* loaded from: classes.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final c1.a0 f11627a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f11628b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f11629c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f11630d;

        /* renamed from: e  reason: collision with root package name */
        private int f11631e;

        /* renamed from: f  reason: collision with root package name */
        private int f11632f;

        /* renamed from: g  reason: collision with root package name */
        private long f11633g;

        /* renamed from: h  reason: collision with root package name */
        private long f11634h;

        public b(c1.a0 a0Var) {
            this.f11627a = a0Var;
        }

        public void a(byte[] bArr, int i6, int i7) {
            if (this.f11629c) {
                int i8 = this.f11632f;
                int i9 = (i6 + 1) - i8;
                if (i9 >= i7) {
                    this.f11632f = i8 + (i7 - i6);
                    return;
                }
                this.f11630d = ((bArr[i9] & 192) >> 6) == 0;
                this.f11629c = false;
            }
        }

        public void b(long j6, int i6, boolean z5) {
            if (this.f11631e == 182 && z5 && this.f11628b) {
                boolean z6 = this.f11630d;
                this.f11627a.d(this.f11634h, z6 ? 1 : 0, (int) (j6 - this.f11633g), i6, null);
            }
            if (this.f11631e != 179) {
                this.f11633g = j6;
            }
        }

        public void c(int i6, long j6) {
            this.f11631e = i6;
            this.f11630d = false;
            this.f11628b = i6 == 182 || i6 == 179;
            this.f11629c = i6 == 182;
            this.f11632f = 0;
            this.f11634h = j6;
        }

        public void d() {
            this.f11628b = false;
            this.f11629c = false;
            this.f11630d = false;
            this.f11631e = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k0 k0Var) {
        com.google.android.exoplayer2.util.y yVar;
        this.f11610a = k0Var;
        if (k0Var != null) {
            this.f11614e = new u(178, 128);
            yVar = new com.google.android.exoplayer2.util.y();
        } else {
            yVar = null;
            this.f11614e = null;
        }
        this.f11611b = yVar;
    }

    private static s0 b(a aVar, int i6, String str) {
        byte[] copyOf = Arrays.copyOf(aVar.f11626e, aVar.f11624c);
        com.google.android.exoplayer2.util.x xVar = new com.google.android.exoplayer2.util.x(copyOf);
        xVar.s(i6);
        xVar.s(4);
        xVar.q();
        xVar.r(8);
        if (xVar.g()) {
            xVar.r(4);
            xVar.r(3);
        }
        int h6 = xVar.h(4);
        float f6 = 1.0f;
        if (h6 == 15) {
            int h7 = xVar.h(8);
            int h8 = xVar.h(8);
            if (h8 != 0) {
                f6 = h7 / h8;
            }
            com.google.android.exoplayer2.util.n.h("H263Reader", "Invalid aspect ratio");
        } else {
            float[] fArr = f11609l;
            if (h6 < fArr.length) {
                f6 = fArr[h6];
            }
            com.google.android.exoplayer2.util.n.h("H263Reader", "Invalid aspect ratio");
        }
        if (xVar.g()) {
            xVar.r(2);
            xVar.r(1);
            if (xVar.g()) {
                xVar.r(15);
                xVar.q();
                xVar.r(15);
                xVar.q();
                xVar.r(15);
                xVar.q();
                xVar.r(3);
                xVar.r(11);
                xVar.q();
                xVar.r(15);
                xVar.q();
            }
        }
        if (xVar.h(2) != 0) {
            com.google.android.exoplayer2.util.n.h("H263Reader", "Unhandled video object layer shape");
        }
        xVar.q();
        int h9 = xVar.h(16);
        xVar.q();
        if (xVar.g()) {
            if (h9 == 0) {
                com.google.android.exoplayer2.util.n.h("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i7 = 0;
                for (int i8 = h9 - 1; i8 > 0; i8 >>= 1) {
                    i7++;
                }
                xVar.r(i7);
            }
        }
        xVar.q();
        int h10 = xVar.h(13);
        xVar.q();
        int h11 = xVar.h(13);
        xVar.q();
        xVar.q();
        return new s0.b().S(str).e0("video/mp4v-es").j0(h10).Q(h11).a0(f6).T(Collections.singletonList(copyOf)).E();
    }

    @Override // l1.m
    public void a() {
        com.google.android.exoplayer2.util.r.a(this.f11612c);
        this.f11613d.c();
        b bVar = this.f11615f;
        if (bVar != null) {
            bVar.d();
        }
        u uVar = this.f11614e;
        if (uVar != null) {
            uVar.d();
        }
        this.f11616g = 0L;
    }

    @Override // l1.m
    public void c(com.google.android.exoplayer2.util.y yVar) {
        com.google.android.exoplayer2.util.a.i(this.f11615f);
        com.google.android.exoplayer2.util.a.i(this.f11618i);
        int d6 = yVar.d();
        int e6 = yVar.e();
        byte[] c6 = yVar.c();
        this.f11616g += yVar.a();
        this.f11618i.a(yVar, yVar.a());
        while (true) {
            int c7 = com.google.android.exoplayer2.util.r.c(c6, d6, e6, this.f11612c);
            if (c7 == e6) {
                break;
            }
            int i6 = c7 + 3;
            int i7 = yVar.c()[i6] & 255;
            int i8 = c7 - d6;
            int i9 = 0;
            if (!this.f11619j) {
                if (i8 > 0) {
                    this.f11613d.a(c6, d6, c7);
                }
                if (this.f11613d.b(i7, i8 < 0 ? -i8 : 0)) {
                    c1.a0 a0Var = this.f11618i;
                    a aVar = this.f11613d;
                    a0Var.e(b(aVar, aVar.f11625d, (String) com.google.android.exoplayer2.util.a.e(this.f11617h)));
                    this.f11619j = true;
                }
            }
            this.f11615f.a(c6, d6, c7);
            u uVar = this.f11614e;
            if (uVar != null) {
                if (i8 > 0) {
                    uVar.a(c6, d6, c7);
                } else {
                    i9 = -i8;
                }
                if (this.f11614e.b(i9)) {
                    u uVar2 = this.f11614e;
                    ((com.google.android.exoplayer2.util.y) com.google.android.exoplayer2.util.s0.j(this.f11611b)).K(this.f11614e.f11753d, com.google.android.exoplayer2.util.r.k(uVar2.f11753d, uVar2.f11754e));
                    ((k0) com.google.android.exoplayer2.util.s0.j(this.f11610a)).a(this.f11620k, this.f11611b);
                }
                if (i7 == 178 && yVar.c()[c7 + 2] == 1) {
                    this.f11614e.e(i7);
                }
            }
            int i10 = e6 - c7;
            this.f11615f.b(this.f11616g - i10, i10, this.f11619j);
            this.f11615f.c(i7, this.f11620k);
            d6 = i6;
        }
        if (!this.f11619j) {
            this.f11613d.a(c6, d6, e6);
        }
        this.f11615f.a(c6, d6, e6);
        u uVar3 = this.f11614e;
        if (uVar3 != null) {
            uVar3.a(c6, d6, e6);
        }
    }

    @Override // l1.m
    public void d() {
    }

    @Override // l1.m
    public void e(long j6, int i6) {
        this.f11620k = j6;
    }

    @Override // l1.m
    public void f(c1.k kVar, i0.d dVar) {
        dVar.a();
        this.f11617h = dVar.b();
        c1.a0 e6 = kVar.e(dVar.c(), 2);
        this.f11618i = e6;
        this.f11615f = new b(e6);
        k0 k0Var = this.f11610a;
        if (k0Var != null) {
            k0Var.b(kVar, dVar);
        }
    }
}
