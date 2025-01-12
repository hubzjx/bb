package i1;

import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
final class r {

    /* renamed from: a  reason: collision with root package name */
    public final o f11021a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11022b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f11023c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f11024d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11025e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f11026f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f11027g;

    /* renamed from: h  reason: collision with root package name */
    public final long f11028h;

    public r(o oVar, long[] jArr, int[] iArr, int i6, long[] jArr2, int[] iArr2, long j6) {
        com.google.android.exoplayer2.util.a.a(iArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.a(jArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.a(iArr2.length == jArr2.length);
        this.f11021a = oVar;
        this.f11023c = jArr;
        this.f11024d = iArr;
        this.f11025e = i6;
        this.f11026f = jArr2;
        this.f11027g = iArr2;
        this.f11028h = j6;
        this.f11022b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j6) {
        for (int i6 = s0.i(this.f11026f, j6, true, false); i6 >= 0; i6--) {
            if ((this.f11027g[i6] & 1) != 0) {
                return i6;
            }
        }
        return -1;
    }

    public int b(long j6) {
        for (int e6 = s0.e(this.f11026f, j6, true, false); e6 < this.f11026f.length; e6++) {
            if ((this.f11027g[e6] & 1) != 0) {
                return e6;
            }
        }
        return -1;
    }
}
