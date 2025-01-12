package m1;

import c1.x;
import c1.y;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
final class e implements x {

    /* renamed from: a  reason: collision with root package name */
    private final c f11994a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11995b;

    /* renamed from: c  reason: collision with root package name */
    private final long f11996c;

    /* renamed from: d  reason: collision with root package name */
    private final long f11997d;

    /* renamed from: e  reason: collision with root package name */
    private final long f11998e;

    public e(c cVar, int i6, long j6, long j7) {
        this.f11994a = cVar;
        this.f11995b = i6;
        this.f11996c = j6;
        long j8 = (j7 - j6) / cVar.f11989e;
        this.f11997d = j8;
        this.f11998e = a(j8);
    }

    private long a(long j6) {
        return s0.F0(j6 * this.f11995b, 1000000L, this.f11994a.f11987c);
    }

    @Override // c1.x
    public boolean f() {
        return true;
    }

    @Override // c1.x
    public x.a i(long j6) {
        long s5 = s0.s((this.f11994a.f11987c * j6) / (this.f11995b * 1000000), 0L, this.f11997d - 1);
        long j7 = this.f11996c + (this.f11994a.f11989e * s5);
        long a6 = a(s5);
        y yVar = new y(a6, j7);
        if (a6 >= j6 || s5 == this.f11997d - 1) {
            return new x.a(yVar);
        }
        long j8 = s5 + 1;
        return new x.a(yVar, new y(a(j8), this.f11996c + (this.f11994a.f11989e * j8)));
    }

    @Override // c1.x
    public long j() {
        return this.f11998e;
    }
}
