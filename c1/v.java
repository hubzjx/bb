package c1;

import c1.x;
import com.google.android.exoplayer2.util.s0;
/* loaded from: classes.dex */
public final class v implements x {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f3243a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f3244b;

    /* renamed from: c  reason: collision with root package name */
    private final long f3245c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3246d;

    public v(long[] jArr, long[] jArr2, long j6) {
        com.google.android.exoplayer2.util.a.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z5 = length > 0;
        this.f3246d = z5;
        if (!z5 || jArr2[0] <= 0) {
            this.f3243a = jArr;
            this.f3244b = jArr2;
        } else {
            int i6 = length + 1;
            long[] jArr3 = new long[i6];
            this.f3243a = jArr3;
            long[] jArr4 = new long[i6];
            this.f3244b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f3245c = j6;
    }

    @Override // c1.x
    public boolean f() {
        return this.f3246d;
    }

    @Override // c1.x
    public x.a i(long j6) {
        if (this.f3246d) {
            int i6 = s0.i(this.f3244b, j6, true, true);
            y yVar = new y(this.f3244b[i6], this.f3243a[i6]);
            if (yVar.f3253a == j6 || i6 == this.f3244b.length - 1) {
                return new x.a(yVar);
            }
            int i7 = i6 + 1;
            return new x.a(yVar, new y(this.f3244b[i7], this.f3243a[i7]));
        }
        return new x.a(y.f3252c);
    }

    @Override // c1.x
    public long j() {
        return this.f3245c;
    }
}
