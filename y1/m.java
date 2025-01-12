package y1;

import com.google.android.exoplayer2.s0;
/* loaded from: classes.dex */
public abstract class m extends e {

    /* renamed from: j  reason: collision with root package name */
    public final long f14331j;

    public m(q2.l lVar, q2.o oVar, s0 s0Var, int i6, Object obj, long j6, long j7, long j8) {
        super(lVar, oVar, 1, s0Var, i6, obj, j6, j7);
        com.google.android.exoplayer2.util.a.e(s0Var);
        this.f14331j = j8;
    }

    public long g() {
        long j6 = this.f14331j;
        if (j6 != -1) {
            return 1 + j6;
        }
        return -1L;
    }

    public abstract boolean h();
}
