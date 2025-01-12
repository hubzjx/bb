package y1;

import c1.a0;
import com.google.android.exoplayer2.s0;
/* loaded from: classes.dex */
public final class o extends a {

    /* renamed from: o  reason: collision with root package name */
    private final int f14333o;

    /* renamed from: p  reason: collision with root package name */
    private final s0 f14334p;

    /* renamed from: q  reason: collision with root package name */
    private long f14335q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f14336r;

    public o(q2.l lVar, q2.o oVar, s0 s0Var, int i6, Object obj, long j6, long j7, long j8, int i7, s0 s0Var2) {
        super(lVar, oVar, s0Var, i6, obj, j6, j7, -9223372036854775807L, -9223372036854775807L, j8);
        this.f14333o = i7;
        this.f14334p = s0Var2;
    }

    @Override // q2.d0.e
    public void a() {
        c j6 = j();
        j6.b(0L);
        a0 e6 = j6.e(0, this.f14333o);
        e6.e(this.f14334p);
        try {
            long b6 = this.f14288i.b(this.f14281b.e(this.f14335q));
            if (b6 != -1) {
                b6 += this.f14335q;
            }
            c1.f fVar = new c1.f(this.f14288i, this.f14335q, b6);
            for (int i6 = 0; i6 != -1; i6 = e6.b(fVar, Integer.MAX_VALUE, true)) {
                this.f14335q += i6;
            }
            e6.d(this.f14286g, 1, (int) this.f14335q, 0, null);
            com.google.android.exoplayer2.util.s0.o(this.f14288i);
            this.f14336r = true;
        } catch (Throwable th) {
            com.google.android.exoplayer2.util.s0.o(this.f14288i);
            throw th;
        }
    }

    @Override // q2.d0.e
    public void c() {
    }

    @Override // y1.m
    public boolean h() {
        return this.f14336r;
    }
}
