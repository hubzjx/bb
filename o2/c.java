package o2;

import android.os.SystemClock;
import com.google.android.exoplayer2.s0;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import w1.x0;
/* loaded from: classes.dex */
public abstract class c implements j {

    /* renamed from: a  reason: collision with root package name */
    protected final x0 f12363a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f12364b;

    /* renamed from: c  reason: collision with root package name */
    protected final int[] f12365c;

    /* renamed from: d  reason: collision with root package name */
    private final s0[] f12366d;

    /* renamed from: e  reason: collision with root package name */
    private final long[] f12367e;

    /* renamed from: f  reason: collision with root package name */
    private int f12368f;

    public c(x0 x0Var, int... iArr) {
        int i6 = 0;
        com.google.android.exoplayer2.util.a.g(iArr.length > 0);
        this.f12363a = (x0) com.google.android.exoplayer2.util.a.e(x0Var);
        int length = iArr.length;
        this.f12364b = length;
        this.f12366d = new s0[length];
        for (int i7 = 0; i7 < iArr.length; i7++) {
            this.f12366d[i7] = x0Var.e(iArr[i7]);
        }
        Arrays.sort(this.f12366d, new Comparator() { // from class: o2.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int u5;
                u5 = c.u((s0) obj, (s0) obj2);
                return u5;
            }
        });
        this.f12365c = new int[this.f12364b];
        while (true) {
            int i8 = this.f12364b;
            if (i6 >= i8) {
                this.f12367e = new long[i8];
                return;
            } else {
                this.f12365c[i6] = x0Var.f(this.f12366d[i6]);
                i6++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int u(s0 s0Var, s0 s0Var2) {
        return s0Var2.f4052h - s0Var.f4052h;
    }

    @Override // o2.j
    public final boolean a(int i6, long j6) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean t5 = t(i6, elapsedRealtime);
        int i7 = 0;
        while (i7 < this.f12364b && !t5) {
            t5 = (i7 == i6 || t(i7, elapsedRealtime)) ? false : true;
            i7++;
        }
        if (t5) {
            long[] jArr = this.f12367e;
            jArr[i6] = Math.max(jArr[i6], com.google.android.exoplayer2.util.s0.b(elapsedRealtime, j6, Long.MAX_VALUE));
            return true;
        }
        return false;
    }

    @Override // o2.j
    public final s0 c(int i6) {
        return this.f12366d[i6];
    }

    @Override // o2.j
    public void d() {
    }

    @Override // o2.j
    public void e() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f12363a == cVar.f12363a && Arrays.equals(this.f12365c, cVar.f12365c);
    }

    @Override // o2.j
    public final int f(int i6) {
        return this.f12365c[i6];
    }

    @Override // o2.j
    public int g(long j6, List list) {
        return list.size();
    }

    @Override // o2.j
    public final int h(s0 s0Var) {
        for (int i6 = 0; i6 < this.f12364b; i6++) {
            if (this.f12366d[i6] == s0Var) {
                return i6;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.f12368f == 0) {
            this.f12368f = (System.identityHashCode(this.f12363a) * 31) + Arrays.hashCode(this.f12365c);
        }
        return this.f12368f;
    }

    @Override // o2.j
    public /* synthetic */ boolean i(long j6, y1.e eVar, List list) {
        return i.b(this, j6, eVar, list);
    }

    @Override // o2.j
    public final int j() {
        return this.f12365c[n()];
    }

    @Override // o2.j
    public final x0 k() {
        return this.f12363a;
    }

    @Override // o2.j
    public final s0 l() {
        return this.f12366d[n()];
    }

    @Override // o2.j
    public final int length() {
        return this.f12365c.length;
    }

    @Override // o2.j
    public void o(float f6) {
    }

    @Override // o2.j
    public /* synthetic */ void q() {
        i.a(this);
    }

    @Override // o2.j
    public final int r(int i6) {
        for (int i7 = 0; i7 < this.f12364b; i7++) {
            if (this.f12365c[i7] == i6) {
                return i7;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean t(int i6, long j6) {
        return this.f12367e[i6] > j6;
    }
}
