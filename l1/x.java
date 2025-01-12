package l1;

import c1.a;
import com.google.android.exoplayer2.util.s0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends c1.a {

    /* loaded from: classes.dex */
    private static final class b implements a.f {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.k0 f11770a;

        /* renamed from: b  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.y f11771b;

        private b(com.google.android.exoplayer2.util.k0 k0Var) {
            this.f11770a = k0Var;
            this.f11771b = new com.google.android.exoplayer2.util.y();
        }

        private a.e c(com.google.android.exoplayer2.util.y yVar, long j6, long j7) {
            int i6 = -1;
            long j8 = -9223372036854775807L;
            int i7 = -1;
            while (yVar.a() >= 4) {
                if (x.k(yVar.c(), yVar.d()) != 442) {
                    yVar.N(1);
                } else {
                    yVar.N(4);
                    long l6 = y.l(yVar);
                    if (l6 != -9223372036854775807L) {
                        long b6 = this.f11770a.b(l6);
                        if (b6 > j6) {
                            return j8 == -9223372036854775807L ? a.e.d(b6, j7) : a.e.e(j7 + i7);
                        } else if (100000 + b6 > j6) {
                            return a.e.e(j7 + yVar.d());
                        } else {
                            i7 = yVar.d();
                            j8 = b6;
                        }
                    }
                    d(yVar);
                    i6 = yVar.d();
                }
            }
            return j8 != -9223372036854775807L ? a.e.f(j8, j7 + i6) : a.e.f3152d;
        }

        private static void d(com.google.android.exoplayer2.util.y yVar) {
            int k6;
            int e6 = yVar.e();
            if (yVar.a() < 10) {
                yVar.M(e6);
                return;
            }
            yVar.N(9);
            int A = yVar.A() & 7;
            if (yVar.a() < A) {
                yVar.M(e6);
                return;
            }
            yVar.N(A);
            if (yVar.a() < 4) {
                yVar.M(e6);
                return;
            }
            if (x.k(yVar.c(), yVar.d()) == 443) {
                yVar.N(4);
                int G = yVar.G();
                if (yVar.a() < G) {
                    yVar.M(e6);
                    return;
                }
                yVar.N(G);
            }
            while (yVar.a() >= 4 && (k6 = x.k(yVar.c(), yVar.d())) != 442 && k6 != 441 && (k6 >>> 8) == 1) {
                yVar.N(4);
                if (yVar.a() < 2) {
                    yVar.M(e6);
                    return;
                }
                yVar.M(Math.min(yVar.e(), yVar.d() + yVar.G()));
            }
        }

        @Override // c1.a.f
        public void a() {
            this.f11771b.J(s0.f4678f);
        }

        @Override // c1.a.f
        public a.e b(c1.j jVar, long j6) {
            long p5 = jVar.p();
            int min = (int) Math.min(20000L, jVar.a() - p5);
            this.f11771b.I(min);
            jVar.n(this.f11771b.c(), 0, min);
            return c(this.f11771b, j6, p5);
        }
    }

    public x(com.google.android.exoplayer2.util.k0 k0Var, long j6, long j7) {
        super(new a.b(), new b(k0Var), j6, 0L, j6 + 1, 0L, j7, 188L, 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(byte[] bArr, int i6) {
        return (bArr[i6 + 3] & 255) | ((bArr[i6] & 255) << 24) | ((bArr[i6 + 1] & 255) << 16) | ((bArr[i6 + 2] & 255) << 8);
    }
}
