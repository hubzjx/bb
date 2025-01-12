package h1;

import android.util.Pair;
import c1.x;
import c1.y;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.util.s0;
import s1.k;
/* loaded from: classes.dex */
final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f10599a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f10600b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10601c;

    private c(long[] jArr, long[] jArr2, long j6) {
        this.f10599a = jArr;
        this.f10600b = jArr2;
        this.f10601c = j6 == -9223372036854775807L ? p.a(jArr2[jArr2.length - 1]) : j6;
    }

    public static c a(long j6, k kVar, long j7) {
        int length = kVar.f13159e.length;
        int i6 = length + 1;
        long[] jArr = new long[i6];
        long[] jArr2 = new long[i6];
        jArr[0] = j6;
        long j8 = 0;
        jArr2[0] = 0;
        for (int i7 = 1; i7 <= length; i7++) {
            int i8 = i7 - 1;
            j6 += kVar.f13157c + kVar.f13159e[i8];
            j8 += kVar.f13158d + kVar.f13160f[i8];
            jArr[i7] = j6;
            jArr2[i7] = j8;
        }
        return new c(jArr, jArr2, j7);
    }

    private static Pair c(long j6, long[] jArr, long[] jArr2) {
        Long valueOf;
        Long valueOf2;
        int i6 = s0.i(jArr, j6, true, true);
        long j7 = jArr[i6];
        long j8 = jArr2[i6];
        int i7 = i6 + 1;
        if (i7 == jArr.length) {
            valueOf = Long.valueOf(j7);
            valueOf2 = Long.valueOf(j8);
        } else {
            long j9 = jArr[i7];
            long j10 = jArr2[i7];
            double d6 = j9 == j7 ? 0.0d : (j6 - j7) / (j9 - j7);
            valueOf = Long.valueOf(j6);
            valueOf2 = Long.valueOf(((long) (d6 * (j10 - j8))) + j8);
        }
        return Pair.create(valueOf, valueOf2);
    }

    @Override // h1.g
    public long b(long j6) {
        return p.a(((Long) c(j6, this.f10599a, this.f10600b).second).longValue());
    }

    @Override // h1.g
    public long e() {
        return -1L;
    }

    @Override // c1.x
    public boolean f() {
        return true;
    }

    @Override // c1.x
    public x.a i(long j6) {
        Pair c6 = c(p.b(s0.s(j6, 0L, this.f10601c)), this.f10600b, this.f10599a);
        return new x.a(new y(p.a(((Long) c6.first).longValue()), ((Long) c6.second).longValue()));
    }

    @Override // c1.x
    public long j() {
        return this.f10601c;
    }
}
