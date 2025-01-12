package w1;

import com.google.android.exoplayer2.y1;
import java.io.IOException;
import java.util.ArrayList;
import w1.v;
/* loaded from: classes.dex */
public final class e extends g {

    /* renamed from: l  reason: collision with root package name */
    private final v f13808l;

    /* renamed from: m  reason: collision with root package name */
    private final long f13809m;

    /* renamed from: n  reason: collision with root package name */
    private final long f13810n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f13811o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f13812p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f13813q;

    /* renamed from: r  reason: collision with root package name */
    private final ArrayList f13814r;

    /* renamed from: s  reason: collision with root package name */
    private final y1.c f13815s;

    /* renamed from: t  reason: collision with root package name */
    private a f13816t;

    /* renamed from: u  reason: collision with root package name */
    private b f13817u;

    /* renamed from: v  reason: collision with root package name */
    private long f13818v;

    /* renamed from: w  reason: collision with root package name */
    private long f13819w;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends n {

        /* renamed from: c  reason: collision with root package name */
        private final long f13820c;

        /* renamed from: d  reason: collision with root package name */
        private final long f13821d;

        /* renamed from: e  reason: collision with root package name */
        private final long f13822e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f13823f;

        public a(y1 y1Var, long j6, long j7) {
            super(y1Var);
            boolean z5 = false;
            if (y1Var.i() != 1) {
                throw new b(0);
            }
            y1.c m5 = y1Var.m(0, new y1.c());
            long max = Math.max(0L, j6);
            if (!m5.f4845k && max != 0 && !m5.f4842h) {
                throw new b(1);
            }
            long max2 = j7 == Long.MIN_VALUE ? m5.f4849o : Math.max(0L, j7);
            long j8 = m5.f4849o;
            if (j8 != -9223372036854775807L) {
                max2 = max2 > j8 ? j8 : max2;
                if (max > max2) {
                    throw new b(2);
                }
            }
            this.f13820c = max;
            this.f13821d = max2;
            int i6 = (max2 > (-9223372036854775807L) ? 1 : (max2 == (-9223372036854775807L) ? 0 : -1));
            this.f13822e = i6 == 0 ? -9223372036854775807L : max2 - max;
            if (m5.f4843i && (i6 == 0 || (j8 != -9223372036854775807L && max2 == j8))) {
                z5 = true;
            }
            this.f13823f = z5;
        }

        @Override // w1.n, com.google.android.exoplayer2.y1
        public y1.b g(int i6, y1.b bVar, boolean z5) {
            this.f13883b.g(0, bVar, z5);
            long k6 = bVar.k() - this.f13820c;
            long j6 = this.f13822e;
            return bVar.m(bVar.f4827a, bVar.f4828b, 0, j6 == -9223372036854775807L ? -9223372036854775807L : j6 - k6, k6);
        }

        @Override // w1.n, com.google.android.exoplayer2.y1
        public y1.c n(int i6, y1.c cVar, long j6) {
            this.f13883b.n(0, cVar, 0L);
            long j7 = cVar.f4850p;
            long j8 = this.f13820c;
            cVar.f4850p = j7 + j8;
            cVar.f4849o = this.f13822e;
            cVar.f4843i = this.f13823f;
            long j9 = cVar.f4848n;
            if (j9 != -9223372036854775807L) {
                long max = Math.max(j9, j8);
                cVar.f4848n = max;
                long j10 = this.f13821d;
                if (j10 != -9223372036854775807L) {
                    max = Math.min(max, j10);
                }
                cVar.f4848n = max - this.f13820c;
            }
            long b6 = com.google.android.exoplayer2.p.b(this.f13820c);
            long j11 = cVar.f4839e;
            if (j11 != -9223372036854775807L) {
                cVar.f4839e = j11 + b6;
            }
            long j12 = cVar.f4840f;
            if (j12 != -9223372036854775807L) {
                cVar.f4840f = j12 + b6;
            }
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(int i6) {
            super(r0.length() != 0 ? "Illegal clipping: ".concat(r0) : new String("Illegal clipping: "));
            String valueOf = String.valueOf(getReasonDescription(i6));
            this.reason = i6;
        }

        private static String getReasonDescription(int i6) {
            return i6 != 0 ? i6 != 1 ? i6 != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    public e(v vVar, long j6, long j7, boolean z5, boolean z6, boolean z7) {
        com.google.android.exoplayer2.util.a.a(j6 >= 0);
        this.f13808l = (v) com.google.android.exoplayer2.util.a.e(vVar);
        this.f13809m = j6;
        this.f13810n = j7;
        this.f13811o = z5;
        this.f13812p = z6;
        this.f13813q = z7;
        this.f13814r = new ArrayList();
        this.f13815s = new y1.c();
    }

    private void M(y1 y1Var) {
        long j6;
        long j7;
        y1Var.m(0, this.f13815s);
        long d6 = this.f13815s.d();
        if (this.f13816t == null || this.f13814r.isEmpty() || this.f13812p) {
            long j8 = this.f13809m;
            long j9 = this.f13810n;
            if (this.f13813q) {
                long b6 = this.f13815s.b();
                j8 += b6;
                j9 += b6;
            }
            this.f13818v = d6 + j8;
            this.f13819w = this.f13810n != Long.MIN_VALUE ? d6 + j9 : Long.MIN_VALUE;
            int size = this.f13814r.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((d) this.f13814r.get(i6)).v(this.f13818v, this.f13819w);
            }
            j6 = j8;
            j7 = j9;
        } else {
            long j10 = this.f13818v - d6;
            j7 = this.f13810n != Long.MIN_VALUE ? this.f13819w - d6 : Long.MIN_VALUE;
            j6 = j10;
        }
        try {
            a aVar = new a(y1Var, j6, j7);
            this.f13816t = aVar;
            B(aVar);
        } catch (b e6) {
            this.f13817u = e6;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.g, w1.a
    public void A(q2.i0 i0Var) {
        super.A(i0Var);
        J(null, this.f13808l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.g, w1.a
    public void C() {
        super.C();
        this.f13817u = null;
        this.f13816t = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.g
    /* renamed from: K */
    public long F(Void r7, long j6) {
        if (j6 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long b6 = com.google.android.exoplayer2.p.b(this.f13809m);
        long max = Math.max(0L, j6 - b6);
        long j7 = this.f13810n;
        return j7 != Long.MIN_VALUE ? Math.min(com.google.android.exoplayer2.p.b(j7) - b6, max) : max;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w1.g
    /* renamed from: L */
    public void I(Void r12, v vVar, y1 y1Var) {
        if (this.f13817u != null) {
            return;
        }
        M(y1Var);
    }

    @Override // w1.v
    public com.google.android.exoplayer2.w0 a() {
        return this.f13808l.a();
    }

    @Override // w1.g, w1.v
    public void e() {
        b bVar = this.f13817u;
        if (bVar != null) {
            throw bVar;
        }
        super.e();
    }

    @Override // w1.v
    public void i(t tVar) {
        com.google.android.exoplayer2.util.a.g(this.f13814r.remove(tVar));
        this.f13808l.i(((d) tVar).f13795a);
        if (!this.f13814r.isEmpty() || this.f13812p) {
            return;
        }
        M(((a) com.google.android.exoplayer2.util.a.e(this.f13816t)).f13883b);
    }

    @Override // w1.v
    public t o(v.a aVar, q2.b bVar, long j6) {
        d dVar = new d(this.f13808l.o(aVar, bVar, j6), this.f13811o, this.f13818v, this.f13819w);
        this.f13814r.add(dVar);
        return dVar;
    }
}
