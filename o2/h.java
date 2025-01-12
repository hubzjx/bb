package o2;

import android.util.Pair;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.q1;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.y1;
import java.util.Arrays;
import w1.v;
import w1.x0;
import w1.y0;
/* loaded from: classes.dex */
public abstract class h extends m {

    /* renamed from: c  reason: collision with root package name */
    private a f12447c;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f12448a;

        /* renamed from: b  reason: collision with root package name */
        private final int f12449b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f12450c;

        /* renamed from: d  reason: collision with root package name */
        private final int[] f12451d;

        /* renamed from: e  reason: collision with root package name */
        private final y0[] f12452e;

        /* renamed from: f  reason: collision with root package name */
        private final int[] f12453f;

        /* renamed from: g  reason: collision with root package name */
        private final int[][][] f12454g;

        /* renamed from: h  reason: collision with root package name */
        private final y0 f12455h;

        a(String[] strArr, int[] iArr, y0[] y0VarArr, int[] iArr2, int[][][] iArr3, y0 y0Var) {
            this.f12450c = strArr;
            this.f12451d = iArr;
            this.f12452e = y0VarArr;
            this.f12454g = iArr3;
            this.f12453f = iArr2;
            this.f12455h = y0Var;
            int length = iArr.length;
            this.f12449b = length;
            this.f12448a = length;
        }

        public int a(int i6, int i7, boolean z5) {
            int i8 = this.f12452e[i6].e(i7).f14093a;
            int[] iArr = new int[i8];
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                int f6 = f(i6, i7, i10);
                if (f6 == 4 || (z5 && f6 == 3)) {
                    iArr[i9] = i10;
                    i9++;
                }
            }
            return b(i6, i7, Arrays.copyOf(iArr, i9));
        }

        public int b(int i6, int i7, int[] iArr) {
            int i8 = 0;
            String str = null;
            boolean z5 = false;
            int i9 = 0;
            int i10 = 16;
            while (i8 < iArr.length) {
                String str2 = this.f12452e[i6].e(i7).e(iArr[i8]).f4056n;
                int i11 = i9 + 1;
                if (i9 == 0) {
                    str = str2;
                } else {
                    z5 |= !s0.c(str, str2);
                }
                i10 = Math.min(i10, o1.c(this.f12454g[i6][i7][i8]));
                i8++;
                i9 = i11;
            }
            return z5 ? Math.min(i10, this.f12453f[i6]) : i10;
        }

        public int c() {
            return this.f12449b;
        }

        public int d(int i6) {
            return this.f12451d[i6];
        }

        public y0 e(int i6) {
            return this.f12452e[i6];
        }

        public int f(int i6, int i7, int i8) {
            return o1.d(this.f12454g[i6][i7][i8]);
        }
    }

    private static int e(p1[] p1VarArr, x0 x0Var, int[] iArr, boolean z5) {
        int length = p1VarArr.length;
        int i6 = 0;
        boolean z6 = true;
        for (int i7 = 0; i7 < p1VarArr.length; i7++) {
            p1 p1Var = p1VarArr[i7];
            int i8 = 0;
            for (int i9 = 0; i9 < x0Var.f14093a; i9++) {
                i8 = Math.max(i8, o1.d(p1Var.a(x0Var.e(i9))));
            }
            boolean z7 = iArr[i7] == 0;
            if (i8 > i6 || (i8 == i6 && z5 && !z6 && z7)) {
                length = i7;
                z6 = z7;
                i6 = i8;
            }
        }
        return length;
    }

    private static int[] f(p1 p1Var, x0 x0Var) {
        int[] iArr = new int[x0Var.f14093a];
        for (int i6 = 0; i6 < x0Var.f14093a; i6++) {
            iArr[i6] = p1Var.a(x0Var.e(i6));
        }
        return iArr;
    }

    private static int[] g(p1[] p1VarArr) {
        int length = p1VarArr.length;
        int[] iArr = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = p1VarArr[i6].n();
        }
        return iArr;
    }

    @Override // o2.m
    public final void c(Object obj) {
        this.f12447c = (a) obj;
    }

    @Override // o2.m
    public final n d(p1[] p1VarArr, y0 y0Var, v.a aVar, y1 y1Var) {
        int[] iArr = new int[p1VarArr.length + 1];
        int length = p1VarArr.length + 1;
        x0[][] x0VarArr = new x0[length];
        int[][][] iArr2 = new int[p1VarArr.length + 1][];
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = y0Var.f14101a;
            x0VarArr[i6] = new x0[i7];
            iArr2[i6] = new int[i7];
        }
        int[] g6 = g(p1VarArr);
        for (int i8 = 0; i8 < y0Var.f14101a; i8++) {
            x0 e6 = y0Var.e(i8);
            int e7 = e(p1VarArr, e6, iArr, q.j(e6.e(0).f4056n) == 4);
            int[] f6 = e7 == p1VarArr.length ? new int[e6.f14093a] : f(p1VarArr[e7], e6);
            int i9 = iArr[e7];
            x0VarArr[e7][i9] = e6;
            iArr2[e7][i9] = f6;
            iArr[e7] = i9 + 1;
        }
        y0[] y0VarArr = new y0[p1VarArr.length];
        String[] strArr = new String[p1VarArr.length];
        int[] iArr3 = new int[p1VarArr.length];
        for (int i10 = 0; i10 < p1VarArr.length; i10++) {
            int i11 = iArr[i10];
            y0VarArr[i10] = new y0((x0[]) s0.y0(x0VarArr[i10], i11));
            iArr2[i10] = (int[][]) s0.y0(iArr2[i10], i11);
            strArr[i10] = p1VarArr[i10].f();
            iArr3[i10] = p1VarArr[i10].i();
        }
        a aVar2 = new a(strArr, iArr3, y0VarArr, g6, iArr2, new y0((x0[]) s0.y0(x0VarArr[p1VarArr.length], iArr[p1VarArr.length])));
        Pair h6 = h(aVar2, iArr2, g6);
        return new n((q1[]) h6.first, (j[]) h6.second, aVar2);
    }

    protected abstract Pair h(a aVar, int[][][] iArr, int[] iArr2);
}
