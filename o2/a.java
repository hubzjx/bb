package o2;

import com.google.android.exoplayer2.s0;
import com.google.common.collect.m0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import o2.j;
import w1.x0;
/* loaded from: classes.dex */
public class a extends o2.c {

    /* renamed from: g  reason: collision with root package name */
    private final b f12342g;

    /* renamed from: h  reason: collision with root package name */
    private final long f12343h;

    /* renamed from: i  reason: collision with root package name */
    private final long f12344i;

    /* renamed from: j  reason: collision with root package name */
    private final long f12345j;

    /* renamed from: k  reason: collision with root package name */
    private final float f12346k;

    /* renamed from: l  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.c f12347l;

    /* renamed from: m  reason: collision with root package name */
    private float f12348m;

    /* renamed from: n  reason: collision with root package name */
    private int f12349n;

    /* renamed from: o  reason: collision with root package name */
    private int f12350o;

    /* renamed from: p  reason: collision with root package name */
    private long f12351p;

    /* renamed from: q  reason: collision with root package name */
    private y1.m f12352q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        long a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c implements b {

        /* renamed from: a  reason: collision with root package name */
        private final q2.e f12353a;

        /* renamed from: b  reason: collision with root package name */
        private final float f12354b;

        /* renamed from: c  reason: collision with root package name */
        private final long f12355c;

        /* renamed from: d  reason: collision with root package name */
        private long[][] f12356d;

        c(q2.e eVar, float f6, long j6) {
            this.f12353a = eVar;
            this.f12354b = f6;
            this.f12355c = j6;
        }

        @Override // o2.a.b
        public long a() {
            long[][] jArr;
            long max = Math.max(0L, (((float) this.f12353a.e()) * this.f12354b) - this.f12355c);
            if (this.f12356d == null) {
                return max;
            }
            int i6 = 1;
            while (true) {
                jArr = this.f12356d;
                if (i6 >= jArr.length - 1 || jArr[i6][0] >= max) {
                    break;
                }
                i6++;
            }
            long[] jArr2 = jArr[i6 - 1];
            long[] jArr3 = jArr[i6];
            long j6 = jArr2[0];
            long j7 = jArr2[1];
            return j7 + ((((float) (max - j6)) / ((float) (jArr3[0] - j6))) * ((float) (jArr3[1] - j7)));
        }

        void b(long[][] jArr) {
            com.google.android.exoplayer2.util.a.a(jArr.length >= 2);
            this.f12356d = jArr;
        }
    }

    /* loaded from: classes.dex */
    public static class d implements j.b {

        /* renamed from: a  reason: collision with root package name */
        private final int f12357a;

        /* renamed from: b  reason: collision with root package name */
        private final int f12358b;

        /* renamed from: c  reason: collision with root package name */
        private final int f12359c;

        /* renamed from: d  reason: collision with root package name */
        private final float f12360d;

        /* renamed from: e  reason: collision with root package name */
        private final float f12361e;

        /* renamed from: f  reason: collision with root package name */
        private final com.google.android.exoplayer2.util.c f12362f;

        public d() {
            this(10000, 25000, 25000, 0.7f, 0.75f, com.google.android.exoplayer2.util.c.f4589a);
        }

        @Override // o2.j.b
        public final j[] a(j.a[] aVarArr, q2.e eVar) {
            j[] jVarArr = new j[aVarArr.length];
            int i6 = 0;
            for (int i7 = 0; i7 < aVarArr.length; i7++) {
                j.a aVar = aVarArr[i7];
                if (aVar != null) {
                    int[] iArr = aVar.f12457b;
                    if (iArr.length == 1) {
                        jVarArr[i7] = new g(aVar.f12456a, iArr[0], aVar.f12458c, aVar.f12459d);
                        int i8 = aVar.f12456a.e(aVar.f12457b[0]).f4052h;
                        if (i8 != -1) {
                            i6 += i8;
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i9 = 0; i9 < aVarArr.length; i9++) {
                j.a aVar2 = aVarArr[i9];
                if (aVar2 != null) {
                    int[] iArr2 = aVar2.f12457b;
                    if (iArr2.length > 1) {
                        a b6 = b(aVar2.f12456a, eVar, iArr2, i6);
                        arrayList.add(b6);
                        jVarArr[i9] = b6;
                    }
                }
            }
            if (arrayList.size() > 1) {
                long[][] jArr = new long[arrayList.size()];
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    a aVar3 = (a) arrayList.get(i10);
                    jArr[i10] = new long[aVar3.length()];
                    for (int i11 = 0; i11 < aVar3.length(); i11++) {
                        jArr[i10][i11] = aVar3.c((aVar3.length() - i11) - 1).f4052h;
                    }
                }
                long[][][] A = a.A(jArr);
                for (int i12 = 0; i12 < arrayList.size(); i12++) {
                    ((a) arrayList.get(i12)).z(A[i12]);
                }
            }
            return jVarArr;
        }

        protected a b(x0 x0Var, q2.e eVar, int[] iArr, int i6) {
            return new a(x0Var, iArr, new c(eVar, this.f12360d, i6), this.f12357a, this.f12358b, this.f12359c, this.f12361e, this.f12362f);
        }

        public d(int i6, int i7, int i8, float f6, float f7, com.google.android.exoplayer2.util.c cVar) {
            this.f12357a = i6;
            this.f12358b = i7;
            this.f12359c = i8;
            this.f12360d = f6;
            this.f12361e = f7;
            this.f12362f = cVar;
        }
    }

    private a(x0 x0Var, int[] iArr, b bVar, long j6, long j7, long j8, float f6, com.google.android.exoplayer2.util.c cVar) {
        super(x0Var, iArr);
        this.f12342g = bVar;
        this.f12343h = j6 * 1000;
        this.f12344i = j7 * 1000;
        this.f12345j = j8 * 1000;
        this.f12346k = f6;
        this.f12347l = cVar;
        this.f12348m = 1.0f;
        this.f12350o = 0;
        this.f12351p = -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long[][][] A(long[][] jArr) {
        int i6;
        double[][] B = B(jArr);
        double[][] D = D(B);
        int x5 = x(D) + 3;
        long[][][] jArr2 = (long[][][]) Array.newInstance(Long.TYPE, B.length, x5, 2);
        int[] iArr = new int[B.length];
        F(jArr2, 1, jArr, iArr);
        int i7 = 2;
        while (true) {
            i6 = x5 - 1;
            if (i7 >= i6) {
                break;
            }
            double d6 = Double.MAX_VALUE;
            int i8 = 0;
            for (int i9 = 0; i9 < B.length; i9++) {
                int i10 = iArr[i9];
                if (i10 + 1 != B[i9].length) {
                    double d7 = D[i9][i10];
                    if (d7 < d6) {
                        i8 = i9;
                        d6 = d7;
                    }
                }
            }
            iArr[i8] = iArr[i8] + 1;
            F(jArr2, i7, jArr, iArr);
            i7++;
        }
        for (long[][] jArr3 : jArr2) {
            long[] jArr4 = jArr3[i6];
            long[] jArr5 = jArr3[x5 - 2];
            jArr4[0] = jArr5[0] * 2;
            jArr4[1] = jArr5[1] * 2;
        }
        return jArr2;
    }

    private static double[][] B(long[][] jArr) {
        double[][] dArr = new double[jArr.length];
        for (int i6 = 0; i6 < jArr.length; i6++) {
            dArr[i6] = new double[jArr[i6].length];
            int i7 = 0;
            while (true) {
                long[] jArr2 = jArr[i6];
                if (i7 < jArr2.length) {
                    double[] dArr2 = dArr[i6];
                    long j6 = jArr2[i7];
                    dArr2[i7] = j6 == -1 ? 0.0d : Math.log(j6);
                    i7++;
                }
            }
        }
        return dArr;
    }

    private static double[][] D(double[][] dArr) {
        double[][] dArr2 = new double[dArr.length];
        for (int i6 = 0; i6 < dArr.length; i6++) {
            double[] dArr3 = new double[dArr[i6].length - 1];
            dArr2[i6] = dArr3;
            if (dArr3.length != 0) {
                double[] dArr4 = dArr[i6];
                double d6 = dArr4[dArr4.length - 1] - dArr4[0];
                int i7 = 0;
                while (true) {
                    double[] dArr5 = dArr[i6];
                    if (i7 < dArr5.length - 1) {
                        int i8 = i7 + 1;
                        dArr2[i6][i7] = d6 == 0.0d ? 1.0d : (((dArr5[i7] + dArr5[i8]) * 0.5d) - dArr5[0]) / d6;
                        i7 = i8;
                    }
                }
            }
        }
        return dArr2;
    }

    private long E(long j6) {
        return (j6 > (-9223372036854775807L) ? 1 : (j6 == (-9223372036854775807L) ? 0 : -1)) != 0 && (j6 > this.f12343h ? 1 : (j6 == this.f12343h ? 0 : -1)) <= 0 ? ((float) j6) * this.f12346k : this.f12343h;
    }

    private static void F(long[][][] jArr, int i6, long[][] jArr2, int[] iArr) {
        long j6 = 0;
        for (int i7 = 0; i7 < jArr.length; i7++) {
            long[] jArr3 = jArr[i7][i6];
            long j7 = jArr2[i7][iArr[i7]];
            jArr3[1] = j7;
            j6 += j7;
        }
        for (long[][] jArr4 : jArr) {
            jArr4[i6][0] = j6;
        }
    }

    private static int x(double[][] dArr) {
        int i6 = 0;
        for (double[] dArr2 : dArr) {
            i6 += dArr2.length;
        }
        return i6;
    }

    private int y(long j6) {
        long a6 = this.f12342g.a();
        int i6 = 0;
        for (int i7 = 0; i7 < this.f12364b; i7++) {
            if (j6 == Long.MIN_VALUE || !t(i7, j6)) {
                s0 c6 = c(i7);
                if (w(c6, c6.f4052h, this.f12348m, a6)) {
                    return i7;
                }
                i6 = i7;
            }
        }
        return i6;
    }

    protected long C() {
        return this.f12345j;
    }

    protected boolean G(long j6, List list) {
        long j7 = this.f12351p;
        return j7 == -9223372036854775807L || j6 - j7 >= 1000 || !(list.isEmpty() || ((y1.m) m0.c(list)).equals(this.f12352q));
    }

    @Override // o2.j
    public void b(long j6, long j7, long j8, List list, y1.n[] nVarArr) {
        long c6 = this.f12347l.c();
        int i6 = this.f12350o;
        if (i6 == 0) {
            this.f12350o = 1;
            this.f12349n = y(c6);
            return;
        }
        int i7 = this.f12349n;
        int h6 = list.isEmpty() ? -1 : h(((y1.m) m0.c(list)).f14283d);
        if (h6 != -1) {
            i6 = ((y1.m) m0.c(list)).f14284e;
            i7 = h6;
        }
        int y5 = y(c6);
        if (!t(i7, c6)) {
            s0 c7 = c(i7);
            s0 c8 = c(y5);
            if ((c8.f4052h > c7.f4052h && j7 < E(j8)) || (c8.f4052h < c7.f4052h && j7 >= this.f12344i)) {
                y5 = i7;
            }
        }
        if (y5 != i7) {
            i6 = 3;
        }
        this.f12350o = i6;
        this.f12349n = y5;
    }

    @Override // o2.c, o2.j
    public void d() {
        this.f12351p = -9223372036854775807L;
        this.f12352q = null;
    }

    @Override // o2.c, o2.j
    public void e() {
        this.f12352q = null;
    }

    @Override // o2.c, o2.j
    public int g(long j6, List list) {
        int i6;
        int i7;
        long c6 = this.f12347l.c();
        if (G(c6, list)) {
            this.f12351p = c6;
            this.f12352q = list.isEmpty() ? null : (y1.m) m0.c(list);
            if (list.isEmpty()) {
                return 0;
            }
            int size = list.size();
            long b02 = com.google.android.exoplayer2.util.s0.b0(((y1.m) list.get(size - 1)).f14286g - j6, this.f12348m);
            long C = C();
            if (b02 < C) {
                return size;
            }
            s0 c7 = c(y(c6));
            for (int i8 = 0; i8 < size; i8++) {
                y1.m mVar = (y1.m) list.get(i8);
                s0 s0Var = mVar.f14283d;
                if (com.google.android.exoplayer2.util.s0.b0(mVar.f14286g - j6, this.f12348m) >= C && s0Var.f4052h < c7.f4052h && (i6 = s0Var.f4062t) != -1 && i6 < 720 && (i7 = s0Var.f4061s) != -1 && i7 < 1280 && i6 < c7.f4062t) {
                    return i8;
                }
            }
            return size;
        }
        return list.size();
    }

    @Override // o2.j
    public int m() {
        return this.f12350o;
    }

    @Override // o2.j
    public int n() {
        return this.f12349n;
    }

    @Override // o2.c, o2.j
    public void o(float f6) {
        this.f12348m = f6;
    }

    @Override // o2.j
    public Object p() {
        return null;
    }

    protected boolean w(s0 s0Var, int i6, float f6, long j6) {
        return ((long) Math.round(((float) i6) * f6)) <= j6;
    }

    public void z(long[][] jArr) {
        ((c) this.f12342g).b(jArr);
    }
}
