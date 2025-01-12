package k2;

import com.google.android.exoplayer2.util.s0;
import e2.f;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
final class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private final e2.b[] f11277a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f11278b;

    public b(e2.b[] bVarArr, long[] jArr) {
        this.f11277a = bVarArr;
        this.f11278b = jArr;
    }

    @Override // e2.f
    public int a(long j6) {
        int e6 = s0.e(this.f11278b, j6, false, false);
        if (e6 < this.f11278b.length) {
            return e6;
        }
        return -1;
    }

    @Override // e2.f
    public long b(int i6) {
        com.google.android.exoplayer2.util.a.a(i6 >= 0);
        com.google.android.exoplayer2.util.a.a(i6 < this.f11278b.length);
        return this.f11278b[i6];
    }

    @Override // e2.f
    public List c(long j6) {
        e2.b bVar;
        int i6 = s0.i(this.f11278b, j6, true, false);
        return (i6 == -1 || (bVar = this.f11277a[i6]) == e2.b.f9435p) ? Collections.emptyList() : Collections.singletonList(bVar);
    }

    @Override // e2.f
    public int d() {
        return this.f11278b.length;
    }
}
