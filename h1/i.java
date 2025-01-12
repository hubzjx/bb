package h1;

import c1.x;
import com.google.android.exoplayer2.audio.c1;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
/* loaded from: classes.dex */
final class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private final long f10628a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10629b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10630c;

    /* renamed from: d  reason: collision with root package name */
    private final long f10631d;

    /* renamed from: e  reason: collision with root package name */
    private final long f10632e;

    /* renamed from: f  reason: collision with root package name */
    private final long[] f10633f;

    private i(long j6, int i6, long j7) {
        this(j6, i6, j7, -1L, null);
    }

    public static i a(long j6, long j7, c1.a aVar, y yVar) {
        int E;
        int i6 = aVar.f3350g;
        int i7 = aVar.f3347d;
        int k6 = yVar.k();
        if ((k6 & 1) != 1 || (E = yVar.E()) == 0) {
            return null;
        }
        long F0 = s0.F0(E, i6 * 1000000, i7);
        if ((k6 & 6) != 6) {
            return new i(j7, aVar.f3346c, F0);
        }
        long C = yVar.C();
        long[] jArr = new long[100];
        for (int i8 = 0; i8 < 100; i8++) {
            jArr[i8] = yVar.A();
        }
        if (j6 != -1) {
            long j8 = j7 + C;
            if (j6 != j8) {
                StringBuilder sb = new StringBuilder(67);
                sb.append("XING data size mismatch: ");
                sb.append(j6);
                sb.append(", ");
                sb.append(j8);
                n.h("XingSeeker", sb.toString());
            }
        }
        return new i(j7, aVar.f3346c, F0, C, jArr);
    }

    private long c(int i6) {
        return (this.f10630c * i6) / 100;
    }

    @Override // h1.g
    public long b(long j6) {
        long j7 = j6 - this.f10628a;
        if (!f() || j7 <= this.f10629b) {
            return 0L;
        }
        long[] jArr = (long[]) com.google.android.exoplayer2.util.a.i(this.f10633f);
        double d6 = (j7 * 256.0d) / this.f10631d;
        int i6 = s0.i(jArr, (long) d6, true, true);
        long c6 = c(i6);
        long j8 = jArr[i6];
        int i7 = i6 + 1;
        long c7 = c(i7);
        long j9 = i6 == 99 ? 256L : jArr[i7];
        return c6 + Math.round((j8 == j9 ? 0.0d : (d6 - j8) / (j9 - j8)) * (c7 - c6));
    }

    @Override // h1.g
    public long e() {
        return this.f10632e;
    }

    @Override // c1.x
    public boolean f() {
        return this.f10633f != null;
    }

    @Override // c1.x
    public x.a i(long j6) {
        long[] jArr;
        if (f()) {
            long s5 = s0.s(j6, 0L, this.f10630c);
            double d6 = (s5 * 100.0d) / this.f10630c;
            double d7 = 0.0d;
            if (d6 > 0.0d) {
                if (d6 >= 100.0d) {
                    d7 = 256.0d;
                } else {
                    int i6 = (int) d6;
                    double d8 = ((long[]) com.google.android.exoplayer2.util.a.i(this.f10633f))[i6];
                    d7 = d8 + ((d6 - i6) * ((i6 == 99 ? 256.0d : jArr[i6 + 1]) - d8));
                }
            }
            return new x.a(new c1.y(s5, this.f10628a + s0.s(Math.round((d7 / 256.0d) * this.f10631d), this.f10629b, this.f10631d - 1)));
        }
        return new x.a(new c1.y(0L, this.f10628a + this.f10629b));
    }

    @Override // c1.x
    public long j() {
        return this.f10630c;
    }

    private i(long j6, int i6, long j7, long j8, long[] jArr) {
        this.f10628a = j6;
        this.f10629b = i6;
        this.f10630c = j7;
        this.f10633f = jArr;
        this.f10631d = j8;
        this.f10632e = j8 != -1 ? j6 + j8 : -1L;
    }
}
