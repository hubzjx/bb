package l1;

import c1.a;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
final class e0 extends c1.a {

    /* loaded from: classes.dex */
    private static final class a implements a.f {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.k0 f11466a;

        /* renamed from: b  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.y f11467b = new com.google.android.exoplayer2.util.y();

        /* renamed from: c  reason: collision with root package name */
        private final int f11468c;

        /* renamed from: d  reason: collision with root package name */
        private final int f11469d;

        public a(int i6, com.google.android.exoplayer2.util.k0 k0Var, int i7) {
            this.f11468c = i6;
            this.f11466a = k0Var;
            this.f11469d = i7;
        }

        private a.e c(com.google.android.exoplayer2.util.y yVar, long j6, long j7) {
            int a6;
            int a7;
            int e6 = yVar.e();
            long j8 = -1;
            long j9 = -1;
            long j10 = -9223372036854775807L;
            while (yVar.a() >= 188 && (a7 = (a6 = j0.a(yVar.c(), yVar.d(), e6)) + 188) <= e6) {
                long b6 = j0.b(yVar, a6, this.f11468c);
                if (b6 != -9223372036854775807L) {
                    long b7 = this.f11466a.b(b6);
                    if (b7 > j6) {
                        return j10 == -9223372036854775807L ? a.e.d(b7, j7) : a.e.e(j7 + j9);
                    } else if (100000 + b7 > j6) {
                        return a.e.e(j7 + a6);
                    } else {
                        j9 = a6;
                        j10 = b7;
                    }
                }
                yVar.M(a7);
                j8 = a7;
            }
            return j10 != -9223372036854775807L ? a.e.f(j10, j7 + j8) : a.e.f3152d;
        }

        @Override // c1.a.f
        public void a() {
            this.f11467b.J(s0.f4678f);
        }

        @Override // c1.a.f
        public a.e b(c1.j jVar, long j6) {
            long p5 = jVar.p();
            int min = (int) Math.min(this.f11469d, jVar.a() - p5);
            this.f11467b.I(min);
            jVar.n(this.f11467b.c(), 0, min);
            return c(this.f11467b, j6, p5);
        }
    }

    public e0(com.google.android.exoplayer2.util.k0 k0Var, long j6, long j7, int i6, int i7) {
        super(new a.b(), new a(i6, k0Var, i7), j6, 0L, j6 + 1, 0L, j7, 188L, 940);
    }
}
