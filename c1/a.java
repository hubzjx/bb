package c1;

import c1.x;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final C0033a f3133a;

    /* renamed from: b  reason: collision with root package name */
    protected final f f3134b;

    /* renamed from: c  reason: collision with root package name */
    protected c f3135c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3136d;

    /* renamed from: c1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0033a implements x {

        /* renamed from: a  reason: collision with root package name */
        private final d f3137a;

        /* renamed from: b  reason: collision with root package name */
        private final long f3138b;

        /* renamed from: c  reason: collision with root package name */
        private final long f3139c;

        /* renamed from: d  reason: collision with root package name */
        private final long f3140d;

        /* renamed from: e  reason: collision with root package name */
        private final long f3141e;

        /* renamed from: f  reason: collision with root package name */
        private final long f3142f;

        /* renamed from: g  reason: collision with root package name */
        private final long f3143g;

        public C0033a(d dVar, long j6, long j7, long j8, long j9, long j10, long j11) {
            this.f3137a = dVar;
            this.f3138b = j6;
            this.f3139c = j7;
            this.f3140d = j8;
            this.f3141e = j9;
            this.f3142f = j10;
            this.f3143g = j11;
        }

        @Override // c1.x
        public boolean f() {
            return true;
        }

        @Override // c1.x
        public x.a i(long j6) {
            return new x.a(new y(j6, c.h(this.f3137a.a(j6), this.f3139c, this.f3140d, this.f3141e, this.f3142f, this.f3143g)));
        }

        @Override // c1.x
        public long j() {
            return this.f3138b;
        }

        public long k(long j6) {
            return this.f3137a.a(j6);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements d {
        @Override // c1.a.d
        public long a(long j6) {
            return j6;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private final long f3144a;

        /* renamed from: b  reason: collision with root package name */
        private final long f3145b;

        /* renamed from: c  reason: collision with root package name */
        private final long f3146c;

        /* renamed from: d  reason: collision with root package name */
        private long f3147d;

        /* renamed from: e  reason: collision with root package name */
        private long f3148e;

        /* renamed from: f  reason: collision with root package name */
        private long f3149f;

        /* renamed from: g  reason: collision with root package name */
        private long f3150g;

        /* renamed from: h  reason: collision with root package name */
        private long f3151h;

        protected c(long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
            this.f3144a = j6;
            this.f3145b = j7;
            this.f3147d = j8;
            this.f3148e = j9;
            this.f3149f = j10;
            this.f3150g = j11;
            this.f3146c = j12;
            this.f3151h = h(j7, j8, j9, j10, j11, j12);
        }

        protected static long h(long j6, long j7, long j8, long j9, long j10, long j11) {
            if (j9 + 1 >= j10 || j7 + 1 >= j8) {
                return j9;
            }
            long j12 = ((float) (j6 - j7)) * (((float) (j10 - j9)) / ((float) (j8 - j7)));
            return s0.s(((j12 + j9) - j11) - (j12 / 20), j9, j10 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long i() {
            return this.f3150g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long j() {
            return this.f3149f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long k() {
            return this.f3151h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long l() {
            return this.f3144a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long m() {
            return this.f3145b;
        }

        private void n() {
            this.f3151h = h(this.f3145b, this.f3147d, this.f3148e, this.f3149f, this.f3150g, this.f3146c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(long j6, long j7) {
            this.f3148e = j6;
            this.f3150g = j7;
            n();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(long j6, long j7) {
            this.f3147d = j6;
            this.f3149f = j7;
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface d {
        long a(long j6);
    }

    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: d  reason: collision with root package name */
        public static final e f3152d = new e(-3, -9223372036854775807L, -1);

        /* renamed from: a  reason: collision with root package name */
        private final int f3153a;

        /* renamed from: b  reason: collision with root package name */
        private final long f3154b;

        /* renamed from: c  reason: collision with root package name */
        private final long f3155c;

        private e(int i6, long j6, long j7) {
            this.f3153a = i6;
            this.f3154b = j6;
            this.f3155c = j7;
        }

        public static e d(long j6, long j7) {
            return new e(-1, j6, j7);
        }

        public static e e(long j6) {
            return new e(0, -9223372036854775807L, j6);
        }

        public static e f(long j6, long j7) {
            return new e(-2, j6, j7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface f {
        void a();

        e b(j jVar, long j6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(d dVar, f fVar, long j6, long j7, long j8, long j9, long j10, long j11, int i6) {
        this.f3134b = fVar;
        this.f3136d = i6;
        this.f3133a = new C0033a(dVar, j6, j7, j8, j9, j10, j11);
    }

    protected c a(long j6) {
        return new c(j6, this.f3133a.k(j6), this.f3133a.f3139c, this.f3133a.f3140d, this.f3133a.f3141e, this.f3133a.f3142f, this.f3133a.f3143g);
    }

    public final x b() {
        return this.f3133a;
    }

    public int c(j jVar, w wVar) {
        while (true) {
            c cVar = (c) com.google.android.exoplayer2.util.a.i(this.f3135c);
            long j6 = cVar.j();
            long i6 = cVar.i();
            long k6 = cVar.k();
            if (i6 - j6 <= this.f3136d) {
                e(false, j6);
                return g(jVar, j6, wVar);
            } else if (!i(jVar, k6)) {
                return g(jVar, k6, wVar);
            } else {
                jVar.g();
                e b6 = this.f3134b.b(jVar, cVar.m());
                int i7 = b6.f3153a;
                if (i7 == -3) {
                    e(false, k6);
                    return g(jVar, k6, wVar);
                } else if (i7 == -2) {
                    cVar.p(b6.f3154b, b6.f3155c);
                } else if (i7 != -1) {
                    if (i7 == 0) {
                        i(jVar, b6.f3155c);
                        e(true, b6.f3155c);
                        return g(jVar, b6.f3155c, wVar);
                    }
                    throw new IllegalStateException("Invalid case");
                } else {
                    cVar.o(b6.f3154b, b6.f3155c);
                }
            }
        }
    }

    public final boolean d() {
        return this.f3135c != null;
    }

    protected final void e(boolean z5, long j6) {
        this.f3135c = null;
        this.f3134b.a();
        f(z5, j6);
    }

    protected void f(boolean z5, long j6) {
    }

    protected final int g(j jVar, long j6, w wVar) {
        if (j6 == jVar.p()) {
            return 0;
        }
        wVar.f3247a = j6;
        return 1;
    }

    public final void h(long j6) {
        c cVar = this.f3135c;
        if (cVar == null || cVar.l() != j6) {
            this.f3135c = a(j6);
        }
    }

    protected final boolean i(j jVar, long j6) {
        long p5 = j6 - jVar.p();
        if (p5 < 0 || p5 > 262144) {
            return false;
        }
        jVar.h((int) p5);
        return true;
    }
}
