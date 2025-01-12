package y1;

import com.google.android.exoplayer2.s0;
import q2.g0;
import y1.f;
/* loaded from: classes.dex */
public class j extends a {

    /* renamed from: o  reason: collision with root package name */
    private final int f14319o;

    /* renamed from: p  reason: collision with root package name */
    private final long f14320p;

    /* renamed from: q  reason: collision with root package name */
    private final f f14321q;

    /* renamed from: r  reason: collision with root package name */
    private long f14322r;

    /* renamed from: s  reason: collision with root package name */
    private volatile boolean f14323s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f14324t;

    public j(q2.l lVar, q2.o oVar, s0 s0Var, int i6, Object obj, long j6, long j7, long j8, long j9, long j10, int i7, long j11, f fVar) {
        super(lVar, oVar, s0Var, i6, obj, j6, j7, j8, j9, j10);
        this.f14319o = i7;
        this.f14320p = j11;
        this.f14321q = fVar;
    }

    @Override // q2.d0.e
    public final void a() {
        if (this.f14322r == 0) {
            c j6 = j();
            j6.b(this.f14320p);
            f fVar = this.f14321q;
            f.a l6 = l(j6);
            long j7 = this.f14254k;
            long j8 = j7 == -9223372036854775807L ? -9223372036854775807L : j7 - this.f14320p;
            long j9 = this.f14255l;
            fVar.c(l6, j8, j9 == -9223372036854775807L ? -9223372036854775807L : j9 - this.f14320p);
        }
        try {
            q2.o e6 = this.f14281b.e(this.f14322r);
            g0 g0Var = this.f14288i;
            c1.f fVar2 = new c1.f(g0Var, e6.f12800g, g0Var.b(e6));
            while (!this.f14323s && this.f14321q.b(fVar2)) {
            }
            this.f14322r = fVar2.p() - this.f14281b.f12800g;
            com.google.android.exoplayer2.util.s0.o(this.f14288i);
            this.f14324t = !this.f14323s;
        } catch (Throwable th) {
            com.google.android.exoplayer2.util.s0.o(this.f14288i);
            throw th;
        }
    }

    @Override // q2.d0.e
    public final void c() {
        this.f14323s = true;
    }

    @Override // y1.m
    public long g() {
        return this.f14331j + this.f14319o;
    }

    @Override // y1.m
    public boolean h() {
        return this.f14324t;
    }

    protected f.a l(c cVar) {
        return cVar;
    }
}
