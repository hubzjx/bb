package y1;

import com.google.android.exoplayer2.s0;
/* loaded from: classes.dex */
public abstract class a extends m {

    /* renamed from: k  reason: collision with root package name */
    public final long f14254k;

    /* renamed from: l  reason: collision with root package name */
    public final long f14255l;

    /* renamed from: m  reason: collision with root package name */
    private c f14256m;

    /* renamed from: n  reason: collision with root package name */
    private int[] f14257n;

    public a(q2.l lVar, q2.o oVar, s0 s0Var, int i6, Object obj, long j6, long j7, long j8, long j9, long j10) {
        super(lVar, oVar, s0Var, i6, obj, j6, j7, j10);
        this.f14254k = j8;
        this.f14255l = j9;
    }

    public final int i(int i6) {
        return ((int[]) com.google.android.exoplayer2.util.a.i(this.f14257n))[i6];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final c j() {
        return (c) com.google.android.exoplayer2.util.a.i(this.f14256m);
    }

    public void k(c cVar) {
        this.f14256m = cVar;
        this.f14257n = cVar.a();
    }
}
