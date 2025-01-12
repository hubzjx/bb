package c1;

import c1.x;
import com.google.android.exoplayer2.util.s0;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class d implements x {

    /* renamed from: a  reason: collision with root package name */
    public final int f3186a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f3187b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f3188c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f3189d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f3190e;

    /* renamed from: f  reason: collision with root package name */
    private final long f3191f;

    public d(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f3187b = iArr;
        this.f3188c = jArr;
        this.f3189d = jArr2;
        this.f3190e = jArr3;
        int length = iArr.length;
        this.f3186a = length;
        if (length > 0) {
            this.f3191f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f3191f = 0L;
        }
    }

    public int a(long j6) {
        return s0.i(this.f3190e, j6, true, true);
    }

    @Override // c1.x
    public boolean f() {
        return true;
    }

    @Override // c1.x
    public x.a i(long j6) {
        int a6 = a(j6);
        y yVar = new y(this.f3190e[a6], this.f3188c[a6]);
        if (yVar.f3253a >= j6 || a6 == this.f3186a - 1) {
            return new x.a(yVar);
        }
        int i6 = a6 + 1;
        return new x.a(yVar, new y(this.f3190e[i6], this.f3188c[i6]));
    }

    @Override // c1.x
    public long j() {
        return this.f3191f;
    }

    public String toString() {
        int i6 = this.f3186a;
        String arrays = Arrays.toString(this.f3187b);
        String arrays2 = Arrays.toString(this.f3188c);
        String arrays3 = Arrays.toString(this.f3190e);
        String arrays4 = Arrays.toString(this.f3189d);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 71 + String.valueOf(arrays2).length() + String.valueOf(arrays3).length() + String.valueOf(arrays4).length());
        sb.append("ChunkIndex(length=");
        sb.append(i6);
        sb.append(", sizes=");
        sb.append(arrays);
        sb.append(", offsets=");
        sb.append(arrays2);
        sb.append(", timeUs=");
        sb.append(arrays3);
        sb.append(", durationsUs=");
        sb.append(arrays4);
        sb.append(")");
        return sb.toString();
    }
}
