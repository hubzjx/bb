package y1;

import com.google.android.exoplayer2.s0;
import q2.g0;
import y1.f;
/* loaded from: classes.dex */
public final class l extends e {

    /* renamed from: j  reason: collision with root package name */
    private final f f14327j;

    /* renamed from: k  reason: collision with root package name */
    private f.a f14328k;

    /* renamed from: l  reason: collision with root package name */
    private long f14329l;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f14330m;

    public l(q2.l lVar, q2.o oVar, s0 s0Var, int i6, Object obj, f fVar) {
        super(lVar, oVar, 2, s0Var, i6, obj, -9223372036854775807L, -9223372036854775807L);
        this.f14327j = fVar;
    }

    @Override // q2.d0.e
    public void a() {
        if (this.f14329l == 0) {
            this.f14327j.c(this.f14328k, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            q2.o e6 = this.f14281b.e(this.f14329l);
            g0 g0Var = this.f14288i;
            c1.f fVar = new c1.f(g0Var, e6.f12800g, g0Var.b(e6));
            while (!this.f14330m && this.f14327j.b(fVar)) {
            }
            this.f14329l = fVar.p() - this.f14281b.f12800g;
        } finally {
            com.google.android.exoplayer2.util.s0.o(this.f14288i);
        }
    }

    @Override // q2.d0.e
    public void c() {
        this.f14330m = true;
    }

    public void g(f.a aVar) {
        this.f14328k = aVar;
    }
}
