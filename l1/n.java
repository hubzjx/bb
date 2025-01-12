package l1;

import android.util.Pair;
import com.google.android.exoplayer2.s0;
import java.util.Arrays;
import java.util.Collections;
import l1.i0;
/* loaded from: classes.dex */
public final class n implements m {

    /* renamed from: q  reason: collision with root package name */
    private static final double[] f11587q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a  reason: collision with root package name */
    private String f11588a;

    /* renamed from: b  reason: collision with root package name */
    private c1.a0 f11589b;

    /* renamed from: c  reason: collision with root package name */
    private final k0 f11590c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11591d;

    /* renamed from: e  reason: collision with root package name */
    private final u f11592e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f11593f;

    /* renamed from: g  reason: collision with root package name */
    private final a f11594g;

    /* renamed from: h  reason: collision with root package name */
    private long f11595h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11596i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11597j;

    /* renamed from: k  reason: collision with root package name */
    private long f11598k;

    /* renamed from: l  reason: collision with root package name */
    private long f11599l;

    /* renamed from: m  reason: collision with root package name */
    private long f11600m;

    /* renamed from: n  reason: collision with root package name */
    private long f11601n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f11602o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f11603p;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: e  reason: collision with root package name */
        private static final byte[] f11604e = {0, 0, 1};

        /* renamed from: a  reason: collision with root package name */
        private boolean f11605a;

        /* renamed from: b  reason: collision with root package name */
        public int f11606b;

        /* renamed from: c  reason: collision with root package name */
        public int f11607c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f11608d;

        public a(int i6) {
            this.f11608d = new byte[i6];
        }

        public void a(byte[] bArr, int i6, int i7) {
            if (this.f11605a) {
                int i8 = i7 - i6;
                byte[] bArr2 = this.f11608d;
                int length = bArr2.length;
                int i9 = this.f11606b;
                if (length < i9 + i8) {
                    this.f11608d = Arrays.copyOf(bArr2, (i9 + i8) * 2);
                }
                System.arraycopy(bArr, i6, this.f11608d, this.f11606b, i8);
                this.f11606b += i8;
            }
        }

        public boolean b(int i6, int i7) {
            if (this.f11605a) {
                int i8 = this.f11606b - i7;
                this.f11606b = i8;
                if (this.f11607c != 0 || i6 != 181) {
                    this.f11605a = false;
                    return true;
                }
                this.f11607c = i8;
            } else if (i6 == 179) {
                this.f11605a = true;
            }
            byte[] bArr = f11604e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f11605a = false;
            this.f11606b = 0;
            this.f11607c = 0;
        }
    }

    public n() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair b(a aVar, String str) {
        float f6;
        int i6;
        float f7;
        int i7;
        long j6;
        int i8;
        byte[] copyOf = Arrays.copyOf(aVar.f11608d, aVar.f11606b);
        int i9 = copyOf[5] & 255;
        int i10 = ((copyOf[4] & 255) << 4) | (i9 >> 4);
        int i11 = ((i9 & 15) << 8) | (copyOf[6] & 255);
        int i12 = (copyOf[7] & 240) >> 4;
        if (i12 == 2) {
            f6 = i11 * 4;
            i6 = i10 * 3;
        } else if (i12 == 3) {
            f6 = i11 * 16;
            i6 = i10 * 9;
        } else if (i12 != 4) {
            f7 = 1.0f;
            s0 E = new s0.b().S(str).e0("video/mpeg2").j0(i10).Q(i11).a0(f7).T(Collections.singletonList(copyOf)).E();
            i7 = (copyOf[7] & 15) - 1;
            if (i7 >= 0) {
                double[] dArr = f11587q;
                if (i7 < dArr.length) {
                    double d6 = dArr[i7];
                    byte b6 = copyOf[aVar.f11607c + 9];
                    int i13 = (b6 & 96) >> 5;
                    if (i13 != (b6 & 31)) {
                        d6 *= (i13 + 1.0d) / (i8 + 1);
                    }
                    j6 = (long) (1000000.0d / d6);
                    return Pair.create(E, Long.valueOf(j6));
                }
            }
            j6 = 0;
            return Pair.create(E, Long.valueOf(j6));
        } else {
            f6 = i11 * b.j.K0;
            i6 = i10 * 100;
        }
        f7 = f6 / i6;
        s0 E2 = new s0.b().S(str).e0("video/mpeg2").j0(i10).Q(i11).a0(f7).T(Collections.singletonList(copyOf)).E();
        i7 = (copyOf[7] & 15) - 1;
        if (i7 >= 0) {
        }
        j6 = 0;
        return Pair.create(E2, Long.valueOf(j6));
    }

    @Override // l1.m
    public void a() {
        com.google.android.exoplayer2.util.r.a(this.f11593f);
        this.f11594g.c();
        u uVar = this.f11592e;
        if (uVar != null) {
            uVar.d();
        }
        this.f11595h = 0L;
        this.f11596i = false;
    }

    @Override // l1.m
    public void c(com.google.android.exoplayer2.util.y yVar) {
        int i6;
        com.google.android.exoplayer2.util.a.i(this.f11589b);
        int d6 = yVar.d();
        int e6 = yVar.e();
        byte[] c6 = yVar.c();
        this.f11595h += yVar.a();
        this.f11589b.a(yVar, yVar.a());
        while (true) {
            int c7 = com.google.android.exoplayer2.util.r.c(c6, d6, e6, this.f11593f);
            if (c7 == e6) {
                break;
            }
            int i7 = c7 + 3;
            int i8 = yVar.c()[i7] & 255;
            int i9 = c7 - d6;
            if (!this.f11597j) {
                if (i9 > 0) {
                    this.f11594g.a(c6, d6, c7);
                }
                if (this.f11594g.b(i8, i9 < 0 ? -i9 : 0)) {
                    Pair b6 = b(this.f11594g, (String) com.google.android.exoplayer2.util.a.e(this.f11588a));
                    this.f11589b.e((s0) b6.first);
                    this.f11598k = ((Long) b6.second).longValue();
                    this.f11597j = true;
                }
            }
            u uVar = this.f11592e;
            if (uVar != null) {
                if (i9 > 0) {
                    uVar.a(c6, d6, c7);
                    i6 = 0;
                } else {
                    i6 = -i9;
                }
                if (this.f11592e.b(i6)) {
                    u uVar2 = this.f11592e;
                    ((com.google.android.exoplayer2.util.y) com.google.android.exoplayer2.util.s0.j(this.f11591d)).K(this.f11592e.f11753d, com.google.android.exoplayer2.util.r.k(uVar2.f11753d, uVar2.f11754e));
                    ((k0) com.google.android.exoplayer2.util.s0.j(this.f11590c)).a(this.f11601n, this.f11591d);
                }
                if (i8 == 178 && yVar.c()[c7 + 2] == 1) {
                    this.f11592e.e(i8);
                }
            }
            if (i8 == 0 || i8 == 179) {
                int i10 = e6 - c7;
                if (this.f11596i && this.f11603p && this.f11597j) {
                    this.f11589b.d(this.f11601n, this.f11602o ? 1 : 0, ((int) (this.f11595h - this.f11600m)) - i10, i10, null);
                }
                boolean z5 = this.f11596i;
                if (!z5 || this.f11603p) {
                    this.f11600m = this.f11595h - i10;
                    long j6 = this.f11599l;
                    if (j6 == -9223372036854775807L) {
                        j6 = z5 ? this.f11601n + this.f11598k : 0L;
                    }
                    this.f11601n = j6;
                    this.f11602o = false;
                    this.f11599l = -9223372036854775807L;
                    this.f11596i = true;
                }
                this.f11603p = i8 == 0;
            } else if (i8 == 184) {
                this.f11602o = true;
            }
            d6 = i7;
        }
        if (!this.f11597j) {
            this.f11594g.a(c6, d6, e6);
        }
        u uVar3 = this.f11592e;
        if (uVar3 != null) {
            uVar3.a(c6, d6, e6);
        }
    }

    @Override // l1.m
    public void d() {
    }

    @Override // l1.m
    public void e(long j6, int i6) {
        this.f11599l = j6;
    }

    @Override // l1.m
    public void f(c1.k kVar, i0.d dVar) {
        dVar.a();
        this.f11588a = dVar.b();
        this.f11589b = kVar.e(dVar.c(), 2);
        k0 k0Var = this.f11590c;
        if (k0Var != null) {
            k0Var.b(kVar, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k0 k0Var) {
        com.google.android.exoplayer2.util.y yVar;
        this.f11590c = k0Var;
        this.f11593f = new boolean[4];
        this.f11594g = new a(128);
        if (k0Var != null) {
            this.f11592e = new u(178, 128);
            yVar = new com.google.android.exoplayer2.util.y();
        } else {
            yVar = null;
            this.f11592e = null;
        }
        this.f11591d = yVar;
    }
}
