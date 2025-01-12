package w1;

import com.google.android.exoplayer2.s1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import w1.t;
/* loaded from: classes.dex */
final class h0 implements t, t.a {

    /* renamed from: a  reason: collision with root package name */
    private final t[] f13843a;

    /* renamed from: c  reason: collision with root package name */
    private final i f13845c;

    /* renamed from: e  reason: collision with root package name */
    private t.a f13847e;

    /* renamed from: f  reason: collision with root package name */
    private y0 f13848f;

    /* renamed from: h  reason: collision with root package name */
    private s0 f13850h;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList f13846d = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final IdentityHashMap f13844b = new IdentityHashMap();

    /* renamed from: g  reason: collision with root package name */
    private t[] f13849g = new t[0];

    /* loaded from: classes.dex */
    private static final class a implements t, t.a {

        /* renamed from: a  reason: collision with root package name */
        private final t f13851a;

        /* renamed from: b  reason: collision with root package name */
        private final long f13852b;

        /* renamed from: c  reason: collision with root package name */
        private t.a f13853c;

        public a(t tVar, long j6) {
            this.f13851a = tVar;
            this.f13852b = j6;
        }

        @Override // w1.t, w1.s0
        public boolean a() {
            return this.f13851a.a();
        }

        @Override // w1.t
        public long c(long j6, s1 s1Var) {
            return this.f13851a.c(j6 - this.f13852b, s1Var) + this.f13852b;
        }

        @Override // w1.t, w1.s0
        public long d() {
            long d6 = this.f13851a.d();
            if (d6 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f13852b + d6;
        }

        @Override // w1.t, w1.s0
        public long f() {
            long f6 = this.f13851a.f();
            if (f6 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f13852b + f6;
        }

        @Override // w1.t.a
        public void g(t tVar) {
            ((t.a) com.google.android.exoplayer2.util.a.e(this.f13853c)).g(this);
        }

        @Override // w1.t, w1.s0
        public boolean h(long j6) {
            return this.f13851a.h(j6 - this.f13852b);
        }

        @Override // w1.t, w1.s0
        public void i(long j6) {
            this.f13851a.i(j6 - this.f13852b);
        }

        @Override // w1.s0.a
        /* renamed from: k */
        public void j(t tVar) {
            ((t.a) com.google.android.exoplayer2.util.a.e(this.f13853c)).j(this);
        }

        @Override // w1.t
        public long l() {
            long l6 = this.f13851a.l();
            if (l6 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f13852b + l6;
        }

        @Override // w1.t
        public y0 n() {
            return this.f13851a.n();
        }

        @Override // w1.t
        public void o(t.a aVar, long j6) {
            this.f13853c = aVar;
            this.f13851a.o(this, j6 - this.f13852b);
        }

        @Override // w1.t
        public long q(o2.j[] jVarArr, boolean[] zArr, r0[] r0VarArr, boolean[] zArr2, long j6) {
            r0[] r0VarArr2 = new r0[r0VarArr.length];
            int i6 = 0;
            while (true) {
                r0 r0Var = null;
                if (i6 >= r0VarArr.length) {
                    break;
                }
                b bVar = (b) r0VarArr[i6];
                if (bVar != null) {
                    r0Var = bVar.a();
                }
                r0VarArr2[i6] = r0Var;
                i6++;
            }
            long q5 = this.f13851a.q(jVarArr, zArr, r0VarArr2, zArr2, j6 - this.f13852b);
            for (int i7 = 0; i7 < r0VarArr.length; i7++) {
                r0 r0Var2 = r0VarArr2[i7];
                if (r0Var2 == null) {
                    r0VarArr[i7] = null;
                } else {
                    r0 r0Var3 = r0VarArr[i7];
                    if (r0Var3 == null || ((b) r0Var3).a() != r0Var2) {
                        r0VarArr[i7] = new b(r0Var2, this.f13852b);
                    }
                }
            }
            return q5 + this.f13852b;
        }

        @Override // w1.t
        public void s() {
            this.f13851a.s();
        }

        @Override // w1.t
        public void t(long j6, boolean z5) {
            this.f13851a.t(j6 - this.f13852b, z5);
        }

        @Override // w1.t
        public long u(long j6) {
            return this.f13851a.u(j6 - this.f13852b) + this.f13852b;
        }
    }

    /* loaded from: classes.dex */
    private static final class b implements r0 {

        /* renamed from: a  reason: collision with root package name */
        private final r0 f13854a;

        /* renamed from: b  reason: collision with root package name */
        private final long f13855b;

        public b(r0 r0Var, long j6) {
            this.f13854a = r0Var;
            this.f13855b = j6;
        }

        public r0 a() {
            return this.f13854a;
        }

        @Override // w1.r0
        public void b() {
            this.f13854a.b();
        }

        @Override // w1.r0
        public int e(com.google.android.exoplayer2.t0 t0Var, com.google.android.exoplayer2.decoder.j jVar, boolean z5) {
            int e6 = this.f13854a.e(t0Var, jVar, z5);
            if (e6 == -4) {
                jVar.f3602d = Math.max(0L, jVar.f3602d + this.f13855b);
            }
            return e6;
        }

        @Override // w1.r0
        public boolean g() {
            return this.f13854a.g();
        }

        @Override // w1.r0
        public int r(long j6) {
            return this.f13854a.r(j6 - this.f13855b);
        }
    }

    public h0(i iVar, long[] jArr, t... tVarArr) {
        this.f13845c = iVar;
        this.f13843a = tVarArr;
        this.f13850h = iVar.a(new s0[0]);
        for (int i6 = 0; i6 < tVarArr.length; i6++) {
            long j6 = jArr[i6];
            if (j6 != 0) {
                this.f13843a[i6] = new a(tVarArr[i6], j6);
            }
        }
    }

    @Override // w1.t, w1.s0
    public boolean a() {
        return this.f13850h.a();
    }

    @Override // w1.t
    public long c(long j6, s1 s1Var) {
        t[] tVarArr = this.f13849g;
        return (tVarArr.length > 0 ? tVarArr[0] : this.f13843a[0]).c(j6, s1Var);
    }

    @Override // w1.t, w1.s0
    public long d() {
        return this.f13850h.d();
    }

    public t e(int i6) {
        t tVar = this.f13843a[i6];
        return tVar instanceof a ? ((a) tVar).f13851a : tVar;
    }

    @Override // w1.t, w1.s0
    public long f() {
        return this.f13850h.f();
    }

    @Override // w1.t.a
    public void g(t tVar) {
        this.f13846d.remove(tVar);
        if (this.f13846d.isEmpty()) {
            int i6 = 0;
            for (t tVar2 : this.f13843a) {
                i6 += tVar2.n().f14101a;
            }
            x0[] x0VarArr = new x0[i6];
            int i7 = 0;
            for (t tVar3 : this.f13843a) {
                y0 n5 = tVar3.n();
                int i8 = n5.f14101a;
                int i9 = 0;
                while (i9 < i8) {
                    x0VarArr[i7] = n5.e(i9);
                    i9++;
                    i7++;
                }
            }
            this.f13848f = new y0(x0VarArr);
            ((t.a) com.google.android.exoplayer2.util.a.e(this.f13847e)).g(this);
        }
    }

    @Override // w1.t, w1.s0
    public boolean h(long j6) {
        if (this.f13846d.isEmpty()) {
            return this.f13850h.h(j6);
        }
        int size = this.f13846d.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((t) this.f13846d.get(i6)).h(j6);
        }
        return false;
    }

    @Override // w1.t, w1.s0
    public void i(long j6) {
        this.f13850h.i(j6);
    }

    @Override // w1.s0.a
    /* renamed from: k */
    public void j(t tVar) {
        ((t.a) com.google.android.exoplayer2.util.a.e(this.f13847e)).j(this);
    }

    @Override // w1.t
    public long l() {
        t[] tVarArr;
        t[] tVarArr2;
        long j6 = -9223372036854775807L;
        for (t tVar : this.f13849g) {
            long l6 = tVar.l();
            if (l6 != -9223372036854775807L) {
                if (j6 == -9223372036854775807L) {
                    for (t tVar2 : this.f13849g) {
                        if (tVar2 == tVar) {
                            break;
                        } else if (tVar2.u(l6) != l6) {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j6 = l6;
                } else if (l6 != j6) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (j6 != -9223372036854775807L && tVar.u(j6) != j6) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j6;
    }

    @Override // w1.t
    public y0 n() {
        return (y0) com.google.android.exoplayer2.util.a.e(this.f13848f);
    }

    @Override // w1.t
    public void o(t.a aVar, long j6) {
        this.f13847e = aVar;
        Collections.addAll(this.f13846d, this.f13843a);
        for (t tVar : this.f13843a) {
            tVar.o(this, j6);
        }
    }

    @Override // w1.t
    public long q(o2.j[] jVarArr, boolean[] zArr, r0[] r0VarArr, boolean[] zArr2, long j6) {
        int[] iArr = new int[jVarArr.length];
        int[] iArr2 = new int[jVarArr.length];
        for (int i6 = 0; i6 < jVarArr.length; i6++) {
            r0 r0Var = r0VarArr[i6];
            Integer num = r0Var == null ? null : (Integer) this.f13844b.get(r0Var);
            iArr[i6] = num == null ? -1 : num.intValue();
            iArr2[i6] = -1;
            o2.j jVar = jVarArr[i6];
            if (jVar != null) {
                x0 k6 = jVar.k();
                int i7 = 0;
                while (true) {
                    t[] tVarArr = this.f13843a;
                    if (i7 >= tVarArr.length) {
                        break;
                    } else if (tVarArr[i7].n().f(k6) != -1) {
                        iArr2[i6] = i7;
                        break;
                    } else {
                        i7++;
                    }
                }
            }
        }
        this.f13844b.clear();
        int length = jVarArr.length;
        r0[] r0VarArr2 = new r0[length];
        r0[] r0VarArr3 = new r0[jVarArr.length];
        o2.j[] jVarArr2 = new o2.j[jVarArr.length];
        ArrayList arrayList = new ArrayList(this.f13843a.length);
        long j7 = j6;
        int i8 = 0;
        while (i8 < this.f13843a.length) {
            for (int i9 = 0; i9 < jVarArr.length; i9++) {
                r0VarArr3[i9] = iArr[i9] == i8 ? r0VarArr[i9] : null;
                jVarArr2[i9] = iArr2[i9] == i8 ? jVarArr[i9] : null;
            }
            int i10 = i8;
            ArrayList arrayList2 = arrayList;
            o2.j[] jVarArr3 = jVarArr2;
            long q5 = this.f13843a[i8].q(jVarArr2, zArr, r0VarArr3, zArr2, j7);
            if (i10 == 0) {
                j7 = q5;
            } else if (q5 != j7) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z5 = false;
            for (int i11 = 0; i11 < jVarArr.length; i11++) {
                if (iArr2[i11] == i10) {
                    r0VarArr2[i11] = r0VarArr3[i11];
                    this.f13844b.put((r0) com.google.android.exoplayer2.util.a.e(r0VarArr3[i11]), Integer.valueOf(i10));
                    z5 = true;
                } else if (iArr[i11] == i10) {
                    com.google.android.exoplayer2.util.a.g(r0VarArr3[i11] == null);
                }
            }
            if (z5) {
                arrayList2.add(this.f13843a[i10]);
            }
            i8 = i10 + 1;
            arrayList = arrayList2;
            jVarArr2 = jVarArr3;
        }
        System.arraycopy(r0VarArr2, 0, r0VarArr, 0, length);
        t[] tVarArr2 = (t[]) arrayList.toArray(new t[0]);
        this.f13849g = tVarArr2;
        this.f13850h = this.f13845c.a(tVarArr2);
        return j7;
    }

    @Override // w1.t
    public void s() {
        for (t tVar : this.f13843a) {
            tVar.s();
        }
    }

    @Override // w1.t
    public void t(long j6, boolean z5) {
        for (t tVar : this.f13849g) {
            tVar.t(j6, z5);
        }
    }

    @Override // w1.t
    public long u(long j6) {
        long u5 = this.f13849g[0].u(j6);
        int i6 = 1;
        while (true) {
            t[] tVarArr = this.f13849g;
            if (i6 >= tVarArr.length) {
                return u5;
            }
            if (tVarArr[i6].u(u5) != u5) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i6++;
        }
    }
}
