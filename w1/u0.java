package w1;

import android.net.Uri;
import com.google.android.exoplayer2.w0;
import com.google.android.exoplayer2.y1;
/* loaded from: classes.dex */
public final class u0 extends y1 {

    /* renamed from: n  reason: collision with root package name */
    private static final Object f14037n = new Object();

    /* renamed from: o  reason: collision with root package name */
    private static final com.google.android.exoplayer2.w0 f14038o = new w0.b().c("com.google.android.exoplayer2.source.SinglePeriodTimeline").g(Uri.EMPTY).a();

    /* renamed from: b  reason: collision with root package name */
    private final long f14039b;

    /* renamed from: c  reason: collision with root package name */
    private final long f14040c;

    /* renamed from: d  reason: collision with root package name */
    private final long f14041d;

    /* renamed from: e  reason: collision with root package name */
    private final long f14042e;

    /* renamed from: f  reason: collision with root package name */
    private final long f14043f;

    /* renamed from: g  reason: collision with root package name */
    private final long f14044g;

    /* renamed from: h  reason: collision with root package name */
    private final long f14045h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f14046i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f14047j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f14048k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f14049l;

    /* renamed from: m  reason: collision with root package name */
    private final com.google.android.exoplayer2.w0 f14050m;

    public u0(long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z5, boolean z6, boolean z7, Object obj, com.google.android.exoplayer2.w0 w0Var) {
        this.f14039b = j6;
        this.f14040c = j7;
        this.f14041d = j8;
        this.f14042e = j9;
        this.f14043f = j10;
        this.f14044g = j11;
        this.f14045h = j12;
        this.f14046i = z5;
        this.f14047j = z6;
        this.f14048k = z7;
        this.f14049l = obj;
        this.f14050m = (com.google.android.exoplayer2.w0) com.google.android.exoplayer2.util.a.e(w0Var);
    }

    @Override // com.google.android.exoplayer2.y1
    public int b(Object obj) {
        return f14037n.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.y1
    public y1.b g(int i6, y1.b bVar, boolean z5) {
        com.google.android.exoplayer2.util.a.c(i6, 0, 1);
        return bVar.m(null, z5 ? f14037n : null, 0, this.f14042e, -this.f14044g);
    }

    @Override // com.google.android.exoplayer2.y1
    public int i() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.y1
    public Object l(int i6) {
        com.google.android.exoplayer2.util.a.c(i6, 0, 1);
        return f14037n;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r1 > r3) goto L7;
     */
    @Override // com.google.android.exoplayer2.y1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public y1.c n(int i6, y1.c cVar, long j6) {
        long j7;
        com.google.android.exoplayer2.util.a.c(i6, 0, 1);
        long j8 = this.f14045h;
        boolean z5 = this.f14047j;
        if (z5 && j6 != 0) {
            long j9 = this.f14043f;
            if (j9 != -9223372036854775807L) {
                j8 += j6;
            }
            j7 = -9223372036854775807L;
            return cVar.e(y1.c.f4833q, this.f14050m, this.f14049l, this.f14039b, this.f14040c, this.f14041d, this.f14046i, z5, this.f14048k, j7, this.f14043f, 0, 0, this.f14044g);
        }
        j7 = j8;
        return cVar.e(y1.c.f4833q, this.f14050m, this.f14049l, this.f14039b, this.f14040c, this.f14041d, this.f14046i, z5, this.f14048k, j7, this.f14043f, 0, 0, this.f14044g);
    }

    @Override // com.google.android.exoplayer2.y1
    public int o() {
        return 1;
    }

    public u0(long j6, long j7, long j8, long j9, boolean z5, boolean z6, boolean z7, Object obj, com.google.android.exoplayer2.w0 w0Var) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j6, j7, j8, j9, z5, z6, z7, obj, w0Var);
    }

    public u0(long j6, boolean z5, boolean z6, boolean z7, Object obj, com.google.android.exoplayer2.w0 w0Var) {
        this(j6, j6, 0L, 0L, z5, z6, z7, obj, w0Var);
    }
}
