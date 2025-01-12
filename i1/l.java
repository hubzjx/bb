package i1;

import android.net.Uri;
import c1.a0;
import c1.t;
import c1.w;
import c1.x;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import i1.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class l implements c1.i, x {

    /* renamed from: v  reason: collision with root package name */
    public static final c1.o f10956v = new c1.o() { // from class: i1.j
        @Override // c1.o
        public final c1.i[] a() {
            c1.i[] r5;
            r5 = l.r();
            return r5;
        }

        @Override // c1.o
        public /* synthetic */ c1.i[] b(Uri uri, Map map) {
            return c1.n.a(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f10957a;

    /* renamed from: b  reason: collision with root package name */
    private final y f10958b;

    /* renamed from: c  reason: collision with root package name */
    private final y f10959c;

    /* renamed from: d  reason: collision with root package name */
    private final y f10960d;

    /* renamed from: e  reason: collision with root package name */
    private final y f10961e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque f10962f;

    /* renamed from: g  reason: collision with root package name */
    private int f10963g;

    /* renamed from: h  reason: collision with root package name */
    private int f10964h;

    /* renamed from: i  reason: collision with root package name */
    private long f10965i;

    /* renamed from: j  reason: collision with root package name */
    private int f10966j;

    /* renamed from: k  reason: collision with root package name */
    private y f10967k;

    /* renamed from: l  reason: collision with root package name */
    private int f10968l;

    /* renamed from: m  reason: collision with root package name */
    private int f10969m;

    /* renamed from: n  reason: collision with root package name */
    private int f10970n;

    /* renamed from: o  reason: collision with root package name */
    private int f10971o;

    /* renamed from: p  reason: collision with root package name */
    private c1.k f10972p;

    /* renamed from: q  reason: collision with root package name */
    private a[] f10973q;

    /* renamed from: r  reason: collision with root package name */
    private long[][] f10974r;

    /* renamed from: s  reason: collision with root package name */
    private int f10975s;

    /* renamed from: t  reason: collision with root package name */
    private long f10976t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f10977u;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final o f10978a;

        /* renamed from: b  reason: collision with root package name */
        public final r f10979b;

        /* renamed from: c  reason: collision with root package name */
        public final a0 f10980c;

        /* renamed from: d  reason: collision with root package name */
        public int f10981d;

        public a(o oVar, r rVar, a0 a0Var) {
            this.f10978a = oVar;
            this.f10979b = rVar;
            this.f10980c = a0Var;
        }
    }

    public l() {
        this(0);
    }

    private static boolean A(int i6) {
        return i6 == 1836019574 || i6 == 1953653099 || i6 == 1835297121 || i6 == 1835626086 || i6 == 1937007212 || i6 == 1701082227 || i6 == 1835365473;
    }

    private static boolean B(int i6) {
        return i6 == 1835296868 || i6 == 1836476516 || i6 == 1751411826 || i6 == 1937011556 || i6 == 1937011827 || i6 == 1937011571 || i6 == 1668576371 || i6 == 1701606260 || i6 == 1937011555 || i6 == 1937011578 || i6 == 1937013298 || i6 == 1937007471 || i6 == 1668232756 || i6 == 1953196132 || i6 == 1718909296 || i6 == 1969517665 || i6 == 1801812339 || i6 == 1768715124;
    }

    private void C(long j6) {
        a[] aVarArr;
        for (a aVar : this.f10973q) {
            r rVar = aVar.f10979b;
            int a6 = rVar.a(j6);
            if (a6 == -1) {
                a6 = rVar.b(j6);
            }
            aVar.f10981d = a6;
        }
    }

    private static long[][] m(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i6 = 0; i6 < aVarArr.length; i6++) {
            jArr[i6] = new long[aVarArr[i6].f10979b.f11022b];
            jArr2[i6] = aVarArr[i6].f10979b.f11026f[0];
        }
        long j6 = 0;
        int i7 = 0;
        while (i7 < aVarArr.length) {
            long j7 = Long.MAX_VALUE;
            int i8 = -1;
            for (int i9 = 0; i9 < aVarArr.length; i9++) {
                if (!zArr[i9]) {
                    long j8 = jArr2[i9];
                    if (j8 <= j7) {
                        i8 = i9;
                        j7 = j8;
                    }
                }
            }
            int i10 = iArr[i8];
            long[] jArr3 = jArr[i8];
            jArr3[i10] = j6;
            r rVar = aVarArr[i8].f10979b;
            j6 += rVar.f11024d[i10];
            int i11 = i10 + 1;
            iArr[i8] = i11;
            if (i11 < jArr3.length) {
                jArr2[i8] = rVar.f11026f[i11];
            } else {
                zArr[i8] = true;
                i7++;
            }
        }
        return jArr;
    }

    private void n() {
        this.f10963g = 0;
        this.f10966j = 0;
    }

    private static int o(r rVar, long j6) {
        int a6 = rVar.a(j6);
        return a6 == -1 ? rVar.b(j6) : a6;
    }

    private int p(long j6) {
        int i6 = -1;
        int i7 = -1;
        long j7 = Long.MAX_VALUE;
        boolean z5 = true;
        long j8 = Long.MAX_VALUE;
        boolean z6 = true;
        long j9 = Long.MAX_VALUE;
        for (int i8 = 0; i8 < ((a[]) s0.j(this.f10973q)).length; i8++) {
            a aVar = this.f10973q[i8];
            int i9 = aVar.f10981d;
            r rVar = aVar.f10979b;
            if (i9 != rVar.f11022b) {
                long j10 = rVar.f11023c[i9];
                long j11 = ((long[][]) s0.j(this.f10974r))[i8][i9];
                long j12 = j10 - j6;
                boolean z7 = j12 < 0 || j12 >= 262144;
                if ((!z7 && z6) || (z7 == z6 && j12 < j9)) {
                    z6 = z7;
                    j9 = j12;
                    i7 = i8;
                    j8 = j11;
                }
                if (j11 < j7) {
                    z5 = z7;
                    i6 = i8;
                    j7 = j11;
                }
            }
        }
        return (j7 == Long.MAX_VALUE || !z5 || j8 < j7 + 10485760) ? i7 : i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o q(o oVar) {
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c1.i[] r() {
        return new c1.i[]{new l()};
    }

    private static long s(r rVar, long j6, long j7) {
        int o5 = o(rVar, j6);
        return o5 == -1 ? j7 : Math.min(rVar.f11023c[o5], j7);
    }

    private void t(c1.j jVar) {
        this.f10960d.I(8);
        jVar.n(this.f10960d.c(), 0, 8);
        this.f10960d.N(4);
        if (this.f10960d.k() == 1751411826) {
            jVar.g();
        } else {
            jVar.h(4);
        }
    }

    private void u(long j6) {
        while (!this.f10962f.isEmpty() && ((a.C0178a) this.f10962f.peek()).f10871b == j6) {
            a.C0178a c0178a = (a.C0178a) this.f10962f.pop();
            if (c0178a.f10870a == 1836019574) {
                w(c0178a);
                this.f10962f.clear();
                this.f10963g = 2;
            } else if (!this.f10962f.isEmpty()) {
                ((a.C0178a) this.f10962f.peek()).d(c0178a);
            }
        }
        if (this.f10963g != 2) {
            n();
        }
    }

    private static boolean v(y yVar) {
        yVar.M(8);
        if (yVar.k() == 1903435808) {
            return true;
        }
        yVar.N(4);
        while (yVar.a() > 0) {
            if (yVar.k() == 1903435808) {
                return true;
            }
        }
        return false;
    }

    private void w(a.C0178a c0178a) {
        n1.a aVar;
        List list;
        int i6;
        l lVar = this;
        ArrayList arrayList = new ArrayList();
        t tVar = new t();
        a.b g6 = c0178a.g(1969517665);
        if (g6 != null) {
            n1.a y5 = b.y(g6, lVar.f10977u);
            if (y5 != null) {
                tVar.c(y5);
            }
            aVar = y5;
        } else {
            aVar = null;
        }
        a.C0178a f6 = c0178a.f(1835365473);
        n1.a l6 = f6 != null ? b.l(f6) : null;
        List x5 = b.x(c0178a, tVar, -9223372036854775807L, null, (lVar.f10957a & 1) != 0, lVar.f10977u, new com.google.common.base.e() { // from class: i1.k
            @Override // com.google.common.base.e
            public final Object apply(Object obj) {
                o q5;
                q5 = l.q((o) obj);
                return q5;
            }
        });
        c1.k kVar = (c1.k) com.google.android.exoplayer2.util.a.e(lVar.f10972p);
        int size = x5.size();
        long j6 = -9223372036854775807L;
        long j7 = -9223372036854775807L;
        int i7 = 0;
        int i8 = -1;
        while (i7 < size) {
            r rVar = (r) x5.get(i7);
            if (rVar.f11022b == 0) {
                list = x5;
                i6 = size;
            } else {
                o oVar = rVar.f11021a;
                list = x5;
                long j8 = oVar.f10990e;
                if (j8 == j6) {
                    j8 = rVar.f11028h;
                }
                long max = Math.max(j7, j8);
                a aVar2 = new a(oVar, rVar, kVar.e(i7, oVar.f10987b));
                i6 = size;
                s0.b e6 = oVar.f10991f.e();
                e6.W(rVar.f11025e + 30);
                if (oVar.f10987b == 2 && j8 > 0) {
                    int i9 = rVar.f11022b;
                    if (i9 > 1) {
                        e6.P(i9 / (((float) j8) / 1000000.0f));
                    }
                }
                i.k(oVar.f10987b, aVar, l6, tVar, e6);
                aVar2.f10980c.e(e6.E());
                if (oVar.f10987b == 2 && i8 == -1) {
                    i8 = arrayList.size();
                }
                arrayList.add(aVar2);
                j7 = max;
            }
            i7++;
            x5 = list;
            size = i6;
            j6 = -9223372036854775807L;
            lVar = this;
        }
        l lVar2 = lVar;
        lVar2.f10975s = i8;
        lVar2.f10976t = j7;
        a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
        lVar2.f10973q = aVarArr;
        lVar2.f10974r = m(aVarArr);
        kVar.g();
        kVar.r(lVar2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean x(c1.j jVar) {
        long p5;
        a.C0178a c0178a;
        y yVar;
        if (this.f10966j == 0) {
            if (!jVar.d(this.f10961e.c(), 0, 8, true)) {
                return false;
            }
            this.f10966j = 8;
            this.f10961e.M(0);
            this.f10965i = this.f10961e.C();
            this.f10964h = this.f10961e.k();
        }
        long j6 = this.f10965i;
        if (j6 != 1) {
            if (j6 == 0) {
                long a6 = jVar.a();
                if (a6 == -1 && (c0178a = (a.C0178a) this.f10962f.peek()) != null) {
                    a6 = c0178a.f10871b;
                }
                if (a6 != -1) {
                    p5 = (a6 - jVar.p()) + this.f10966j;
                }
            }
            if (this.f10965i < this.f10966j) {
                if (A(this.f10964h)) {
                    long p6 = jVar.p();
                    long j7 = this.f10965i;
                    int i6 = this.f10966j;
                    long j8 = (p6 + j7) - i6;
                    if (j7 != i6 && this.f10964h == 1835365473) {
                        t(jVar);
                    }
                    this.f10962f.push(new a.C0178a(this.f10964h, j8));
                    if (this.f10965i == this.f10966j) {
                        u(j8);
                    } else {
                        n();
                    }
                } else {
                    if (B(this.f10964h)) {
                        com.google.android.exoplayer2.util.a.g(this.f10966j == 8);
                        com.google.android.exoplayer2.util.a.g(this.f10965i <= 2147483647L);
                        yVar = new y((int) this.f10965i);
                        System.arraycopy(this.f10961e.c(), 0, yVar.c(), 0, 8);
                    } else {
                        yVar = null;
                    }
                    this.f10967k = yVar;
                    this.f10963g = 1;
                }
                return true;
            }
            throw new f1("Atom size less than header length (unsupported).");
        }
        jVar.readFully(this.f10961e.c(), 8, 8);
        this.f10966j += 8;
        p5 = this.f10961e.F();
        this.f10965i = p5;
        if (this.f10965i < this.f10966j) {
        }
    }

    private boolean y(c1.j jVar, w wVar) {
        boolean z5;
        long j6 = this.f10965i - this.f10966j;
        long p5 = jVar.p() + j6;
        y yVar = this.f10967k;
        if (yVar != null) {
            jVar.readFully(yVar.c(), this.f10966j, (int) j6);
            if (this.f10964h == 1718909296) {
                this.f10977u = v(yVar);
            } else if (!this.f10962f.isEmpty()) {
                ((a.C0178a) this.f10962f.peek()).e(new a.b(this.f10964h, yVar));
            }
        } else if (j6 >= 262144) {
            wVar.f3247a = jVar.p() + j6;
            z5 = true;
            u(p5);
            return (z5 || this.f10963g == 2) ? false : true;
        } else {
            jVar.h((int) j6);
        }
        z5 = false;
        u(p5);
        if (z5) {
        }
    }

    private int z(c1.j jVar, w wVar) {
        long p5 = jVar.p();
        if (this.f10968l == -1) {
            int p6 = p(p5);
            this.f10968l = p6;
            if (p6 == -1) {
                return -1;
            }
        }
        a aVar = ((a[]) com.google.android.exoplayer2.util.s0.j(this.f10973q))[this.f10968l];
        a0 a0Var = aVar.f10980c;
        int i6 = aVar.f10981d;
        r rVar = aVar.f10979b;
        long j6 = rVar.f11023c[i6];
        int i7 = rVar.f11024d[i6];
        long j7 = (j6 - p5) + this.f10969m;
        if (j7 < 0 || j7 >= 262144) {
            wVar.f3247a = j6;
            return 1;
        }
        if (aVar.f10978a.f10992g == 1) {
            j7 += 8;
            i7 -= 8;
        }
        jVar.h((int) j7);
        o oVar = aVar.f10978a;
        if (oVar.f10995j == 0) {
            if ("audio/ac4".equals(oVar.f10991f.f4056n)) {
                if (this.f10970n == 0) {
                    com.google.android.exoplayer2.audio.c.a(i7, this.f10960d);
                    a0Var.a(this.f10960d, 7);
                    this.f10970n += 7;
                }
                i7 += 7;
            }
            while (true) {
                int i8 = this.f10970n;
                if (i8 >= i7) {
                    break;
                }
                int b6 = a0Var.b(jVar, i7 - i8, false);
                this.f10969m += b6;
                this.f10970n += b6;
                this.f10971o -= b6;
            }
        } else {
            byte[] c6 = this.f10959c.c();
            c6[0] = 0;
            c6[1] = 0;
            c6[2] = 0;
            int i9 = aVar.f10978a.f10995j;
            int i10 = 4 - i9;
            while (this.f10970n < i7) {
                int i11 = this.f10971o;
                if (i11 == 0) {
                    jVar.readFully(c6, i10, i9);
                    this.f10969m += i9;
                    this.f10959c.M(0);
                    int k6 = this.f10959c.k();
                    if (k6 < 0) {
                        throw new f1("Invalid NAL length");
                    }
                    this.f10971o = k6;
                    this.f10958b.M(0);
                    a0Var.a(this.f10958b, 4);
                    this.f10970n += 4;
                    i7 += i10;
                } else {
                    int b7 = a0Var.b(jVar, i11, false);
                    this.f10969m += b7;
                    this.f10970n += b7;
                    this.f10971o -= b7;
                }
            }
        }
        r rVar2 = aVar.f10979b;
        a0Var.d(rVar2.f11026f[i6], rVar2.f11027g[i6], i7, 0, null);
        aVar.f10981d++;
        this.f10968l = -1;
        this.f10969m = 0;
        this.f10970n = 0;
        this.f10971o = 0;
        return 0;
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(c1.k kVar) {
        this.f10972p = kVar;
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        this.f10962f.clear();
        this.f10966j = 0;
        this.f10968l = -1;
        this.f10969m = 0;
        this.f10970n = 0;
        this.f10971o = 0;
        if (j6 == 0) {
            n();
        } else if (this.f10973q != null) {
            C(j7);
        }
    }

    @Override // c1.x
    public boolean f() {
        return true;
    }

    @Override // c1.i
    public int g(c1.j jVar, w wVar) {
        while (true) {
            int i6 = this.f10963g;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2) {
                        return z(jVar, wVar);
                    }
                    throw new IllegalStateException();
                } else if (y(jVar, wVar)) {
                    return 1;
                }
            } else if (!x(jVar)) {
                return -1;
            }
        }
    }

    @Override // c1.i
    public boolean h(c1.j jVar) {
        return n.d(jVar);
    }

    @Override // c1.x
    public x.a i(long j6) {
        long j7;
        long j8;
        long j9;
        long j10;
        int b6;
        if (((a[]) com.google.android.exoplayer2.util.a.e(this.f10973q)).length == 0) {
            return new x.a(c1.y.f3252c);
        }
        int i6 = this.f10975s;
        if (i6 != -1) {
            r rVar = this.f10973q[i6].f10979b;
            int o5 = o(rVar, j6);
            if (o5 == -1) {
                return new x.a(c1.y.f3252c);
            }
            long j11 = rVar.f11026f[o5];
            j7 = rVar.f11023c[o5];
            if (j11 >= j6 || o5 >= rVar.f11022b - 1 || (b6 = rVar.b(j6)) == -1 || b6 == o5) {
                j10 = -1;
                j9 = -9223372036854775807L;
            } else {
                j9 = rVar.f11026f[b6];
                j10 = rVar.f11023c[b6];
            }
            j8 = j10;
            j6 = j11;
        } else {
            j7 = Long.MAX_VALUE;
            j8 = -1;
            j9 = -9223372036854775807L;
        }
        int i7 = 0;
        while (true) {
            a[] aVarArr = this.f10973q;
            if (i7 >= aVarArr.length) {
                break;
            }
            if (i7 != this.f10975s) {
                r rVar2 = aVarArr[i7].f10979b;
                long s5 = s(rVar2, j6, j7);
                if (j9 != -9223372036854775807L) {
                    j8 = s(rVar2, j9, j8);
                }
                j7 = s5;
            }
            i7++;
        }
        c1.y yVar = new c1.y(j6, j7);
        return j9 == -9223372036854775807L ? new x.a(yVar) : new x.a(yVar, new c1.y(j9, j8));
    }

    @Override // c1.x
    public long j() {
        return this.f10976t;
    }

    public l(int i6) {
        this.f10957a = i6;
        this.f10961e = new y(16);
        this.f10962f = new ArrayDeque();
        this.f10958b = new y(com.google.android.exoplayer2.util.r.f4652a);
        this.f10959c = new y(4);
        this.f10960d = new y();
        this.f10968l = -1;
    }
}
