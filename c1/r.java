package c1;

import c1.s;
import c1.x;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public final class r implements x {

    /* renamed from: a  reason: collision with root package name */
    private final s f3223a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3224b;

    public r(s sVar, long j6) {
        this.f3223a = sVar;
        this.f3224b = j6;
    }

    private y a(long j6, long j7) {
        return new y((j6 * 1000000) / this.f3223a.f3229e, this.f3224b + j7);
    }

    @Override // c1.x
    public boolean f() {
        return true;
    }

    @Override // c1.x
    public x.a i(long j6) {
        com.google.android.exoplayer2.util.a.i(this.f3223a.f3235k);
        s sVar = this.f3223a;
        s.a aVar = sVar.f3235k;
        long[] jArr = aVar.f3237a;
        long[] jArr2 = aVar.f3238b;
        int i6 = s0.i(jArr, sVar.j(j6), true, false);
        y a6 = a(i6 == -1 ? 0L : jArr[i6], i6 != -1 ? jArr2[i6] : 0L);
        if (a6.f3253a == j6 || i6 == jArr.length - 1) {
            return new x.a(a6);
        }
        int i7 = i6 + 1;
        return new x.a(a6, a(jArr[i7], jArr2[i7]));
    }

    @Override // c1.x
    public long j() {
        return this.f3223a.g();
    }
}
