package c1;

import c1.x;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public class e implements x {

    /* renamed from: a  reason: collision with root package name */
    private final long f3192a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3193b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3194c;

    /* renamed from: d  reason: collision with root package name */
    private final long f3195d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3196e;

    /* renamed from: f  reason: collision with root package name */
    private final long f3197f;

    public e(long j6, long j7, int i6, int i7) {
        long d6;
        this.f3192a = j6;
        this.f3193b = j7;
        this.f3194c = i7 == -1 ? 1 : i7;
        this.f3196e = i6;
        if (j6 == -1) {
            this.f3195d = -1L;
            d6 = -9223372036854775807L;
        } else {
            this.f3195d = j6 - j7;
            d6 = d(j6, j7, i6);
        }
        this.f3197f = d6;
    }

    private long a(long j6) {
        int i6 = this.f3194c;
        return this.f3193b + s0.s((((j6 * this.f3196e) / 8000000) / i6) * i6, 0L, this.f3195d - i6);
    }

    private static long d(long j6, long j7, int i6) {
        return ((Math.max(0L, j6 - j7) * 8) * 1000000) / i6;
    }

    public long c(long j6) {
        return d(j6, this.f3193b, this.f3196e);
    }

    @Override // c1.x
    public boolean f() {
        return this.f3195d != -1;
    }

    @Override // c1.x
    public x.a i(long j6) {
        if (this.f3195d == -1) {
            return new x.a(new y(0L, this.f3193b));
        }
        long a6 = a(j6);
        long c6 = c(a6);
        y yVar = new y(c6, a6);
        if (c6 < j6) {
            int i6 = this.f3194c;
            if (i6 + a6 < this.f3192a) {
                long j7 = a6 + i6;
                return new x.a(yVar, new y(c(j7), j7));
            }
        }
        return new x.a(yVar);
    }

    @Override // c1.x
    public long j() {
        return this.f3197f;
    }
}
