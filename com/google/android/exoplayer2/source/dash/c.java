package com.google.android.exoplayer2.source.dash;

import a2.h;
import a2.i;
import c1.a0;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s1;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.e;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.util.s0;
import i1.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import o2.j;
import q2.a0;
import q2.e0;
import q2.i0;
import q2.l;
import y1.f;
import y1.m;
import y1.n;
import y1.o;
/* loaded from: classes.dex */
public class c implements com.google.android.exoplayer2.source.dash.a {

    /* renamed from: a  reason: collision with root package name */
    private final e0 f4180a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f4181b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4182c;

    /* renamed from: d  reason: collision with root package name */
    private final l f4183d;

    /* renamed from: e  reason: collision with root package name */
    private final long f4184e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4185f;

    /* renamed from: g  reason: collision with root package name */
    private final e.c f4186g;

    /* renamed from: h  reason: collision with root package name */
    protected final b[] f4187h;

    /* renamed from: i  reason: collision with root package name */
    private j f4188i;

    /* renamed from: j  reason: collision with root package name */
    private a2.b f4189j;

    /* renamed from: k  reason: collision with root package name */
    private int f4190k;

    /* renamed from: l  reason: collision with root package name */
    private IOException f4191l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f4192m;

    /* renamed from: n  reason: collision with root package name */
    private long f4193n;

    /* loaded from: classes.dex */
    public static final class a implements a.InterfaceC0040a {

        /* renamed from: a  reason: collision with root package name */
        private final l.a f4194a;

        /* renamed from: b  reason: collision with root package name */
        private final int f4195b;

        public a(l.a aVar) {
            this(aVar, 1);
        }

        @Override // com.google.android.exoplayer2.source.dash.a.InterfaceC0040a
        public com.google.android.exoplayer2.source.dash.a a(e0 e0Var, a2.b bVar, int i6, int[] iArr, j jVar, int i7, long j6, boolean z5, List list, e.c cVar, i0 i0Var) {
            l a6 = this.f4194a.a();
            if (i0Var != null) {
                a6.i(i0Var);
            }
            return new c(e0Var, bVar, i6, iArr, jVar, i7, a6, j6, this.f4195b, z5, list, cVar);
        }

        public a(l.a aVar, int i6) {
            this.f4194a = aVar;
            this.f4195b = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final f f4196a;

        /* renamed from: b  reason: collision with root package name */
        public final i f4197b;

        /* renamed from: c  reason: collision with root package name */
        public final z1.d f4198c;

        /* renamed from: d  reason: collision with root package name */
        private final long f4199d;

        /* renamed from: e  reason: collision with root package name */
        private final long f4200e;

        b(long j6, int i6, i iVar, boolean z5, List list, a0 a0Var) {
            this(j6, iVar, d(i6, iVar, z5, list, a0Var), 0L, iVar.i());
        }

        private static f d(int i6, i iVar, boolean z5, List list, a0 a0Var) {
            c1.i gVar;
            String str = iVar.f98b.f4055m;
            if (q.p(str)) {
                if (!"application/x-rawcc".equals(str)) {
                    return null;
                }
                gVar = new k1.a(iVar.f98b);
            } else if (q.o(str)) {
                gVar = new g1.e(1);
            } else {
                gVar = new g(z5 ? 4 : 0, null, null, list, a0Var);
            }
            return new y1.d(gVar, i6, iVar.f98b);
        }

        b b(long j6, i iVar) {
            int g6;
            long a6;
            z1.d i6 = this.f4197b.i();
            z1.d i7 = iVar.i();
            if (i6 == null) {
                return new b(j6, iVar, this.f4196a, this.f4200e, i6);
            }
            if (i6.e() && (g6 = i6.g(j6)) != 0) {
                long f6 = i6.f();
                long b6 = i6.b(f6);
                long j7 = (g6 + f6) - 1;
                long f7 = i7.f();
                long b7 = i7.b(f7);
                long j8 = this.f4200e;
                int i8 = ((i6.b(j7) + i6.c(j7, j6)) > b7 ? 1 : ((i6.b(j7) + i6.c(j7, j6)) == b7 ? 0 : -1));
                if (i8 == 0) {
                    a6 = j8 + ((j7 + 1) - f7);
                } else if (i8 < 0) {
                    throw new w1.b();
                } else {
                    a6 = b7 < b6 ? j8 - (i7.a(b6, j6) - f6) : (i6.a(b7, j6) - f7) + j8;
                }
                return new b(j6, iVar, this.f4196a, a6, i7);
            }
            return new b(j6, iVar, this.f4196a, this.f4200e, i7);
        }

        b c(z1.d dVar) {
            return new b(this.f4199d, this.f4197b, this.f4196a, this.f4200e, dVar);
        }

        public long e(a2.b bVar, int i6, long j6) {
            if (h() != -1 || bVar.f56f == -9223372036854775807L) {
                return f();
            }
            return Math.max(f(), j(((j6 - p.a(bVar.f51a)) - p.a(bVar.d(i6).f84b)) - p.a(bVar.f56f)));
        }

        public long f() {
            return this.f4198c.f() + this.f4200e;
        }

        public long g(a2.b bVar, int i6, long j6) {
            int h6 = h();
            return (h6 == -1 ? j((j6 - p.a(bVar.f51a)) - p.a(bVar.d(i6).f84b)) : f() + h6) - 1;
        }

        public int h() {
            return this.f4198c.g(this.f4199d);
        }

        public long i(long j6) {
            return k(j6) + this.f4198c.c(j6 - this.f4200e, this.f4199d);
        }

        public long j(long j6) {
            return this.f4198c.a(j6, this.f4199d) + this.f4200e;
        }

        public long k(long j6) {
            return this.f4198c.b(j6 - this.f4200e);
        }

        public h l(long j6) {
            return this.f4198c.d(j6 - this.f4200e);
        }

        private b(long j6, i iVar, f fVar, long j7, z1.d dVar) {
            this.f4199d = j6;
            this.f4197b = iVar;
            this.f4200e = j7;
            this.f4196a = fVar;
            this.f4198c = dVar;
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.dash.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected static final class C0041c extends y1.b {

        /* renamed from: e  reason: collision with root package name */
        private final b f4201e;

        public C0041c(b bVar, long j6, long j7) {
            super(j6, j7);
            this.f4201e = bVar;
        }
    }

    public c(e0 e0Var, a2.b bVar, int i6, int[] iArr, j jVar, int i7, l lVar, long j6, int i8, boolean z5, List list, e.c cVar) {
        this.f4180a = e0Var;
        this.f4189j = bVar;
        this.f4181b = iArr;
        this.f4188i = jVar;
        this.f4182c = i7;
        this.f4183d = lVar;
        this.f4190k = i6;
        this.f4184e = j6;
        this.f4185f = i8;
        this.f4186g = cVar;
        long g6 = bVar.g(i6);
        this.f4193n = -9223372036854775807L;
        ArrayList l6 = l();
        this.f4187h = new b[jVar.length()];
        for (int i9 = 0; i9 < this.f4187h.length; i9++) {
            this.f4187h[i9] = new b(g6, i7, (i) l6.get(jVar.f(i9)), z5, list, cVar);
        }
    }

    private ArrayList l() {
        List list = this.f4189j.d(this.f4190k).f85c;
        ArrayList arrayList = new ArrayList();
        for (int i6 : this.f4181b) {
            arrayList.addAll(((a2.a) list.get(i6)).f47c);
        }
        return arrayList;
    }

    private long m(b bVar, m mVar, long j6, long j7, long j8) {
        return mVar != null ? mVar.g() : s0.s(bVar.j(j6), j7, j8);
    }

    private long p(long j6) {
        if (this.f4189j.f54d && this.f4193n != -9223372036854775807L) {
            return this.f4193n - j6;
        }
        return -9223372036854775807L;
    }

    private void q(b bVar, long j6) {
        this.f4193n = this.f4189j.f54d ? bVar.i(j6) : -9223372036854775807L;
    }

    @Override // y1.i
    public void a() {
        for (b bVar : this.f4187h) {
            f fVar = bVar.f4196a;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    @Override // y1.i
    public void b() {
        IOException iOException = this.f4191l;
        if (iOException != null) {
            throw iOException;
        }
        this.f4180a.b();
    }

    @Override // y1.i
    public long c(long j6, s1 s1Var) {
        b[] bVarArr;
        for (b bVar : this.f4187h) {
            if (bVar.f4198c != null) {
                long j7 = bVar.j(j6);
                long k6 = bVar.k(j7);
                return s1Var.a(j6, k6, (k6 >= j6 || j7 >= ((long) (bVar.h() + (-1)))) ? k6 : bVar.k(j7 + 1));
            }
        }
        return j6;
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void d(j jVar) {
        this.f4188i = jVar;
    }

    @Override // y1.i
    public int e(long j6, List list) {
        return (this.f4191l != null || this.f4188i.length() < 2) ? list.size() : this.f4188i.g(j6, list);
    }

    @Override // y1.i
    public void f(long j6, long j7, List list, y1.g gVar) {
        int i6;
        int i7;
        n[] nVarArr;
        long j8;
        if (this.f4191l != null) {
            return;
        }
        long j9 = j7 - j6;
        long p5 = p(j6);
        long a6 = p.a(this.f4189j.f51a) + p.a(this.f4189j.d(this.f4190k).f84b) + j7;
        e.c cVar = this.f4186g;
        if (cVar == null || !cVar.h(a6)) {
            long a7 = p.a(s0.X(this.f4184e));
            m mVar = list.isEmpty() ? null : (m) list.get(list.size() - 1);
            int length = this.f4188i.length();
            n[] nVarArr2 = new n[length];
            int i8 = 0;
            while (i8 < length) {
                b bVar = this.f4187h[i8];
                if (bVar.f4198c == null) {
                    nVarArr2[i8] = n.f14332a;
                    i6 = i8;
                    i7 = length;
                    nVarArr = nVarArr2;
                    j8 = a7;
                } else {
                    long e6 = bVar.e(this.f4189j, this.f4190k, a7);
                    long g6 = bVar.g(this.f4189j, this.f4190k, a7);
                    i6 = i8;
                    i7 = length;
                    nVarArr = nVarArr2;
                    j8 = a7;
                    long m5 = m(bVar, mVar, j7, e6, g6);
                    if (m5 < e6) {
                        nVarArr[i6] = n.f14332a;
                    } else {
                        nVarArr[i6] = new C0041c(bVar, m5, g6);
                    }
                }
                i8 = i6 + 1;
                length = i7;
                nVarArr2 = nVarArr;
                a7 = j8;
            }
            long j10 = a7;
            this.f4188i.b(j6, j9, p5, list, nVarArr2);
            b bVar2 = this.f4187h[this.f4188i.n()];
            f fVar = bVar2.f4196a;
            if (fVar != null) {
                i iVar = bVar2.f4197b;
                h k6 = fVar.f() == null ? iVar.k() : null;
                h j11 = bVar2.f4198c == null ? iVar.j() : null;
                if (k6 != null || j11 != null) {
                    gVar.f14289a = n(bVar2, this.f4183d, this.f4188i.l(), this.f4188i.m(), this.f4188i.p(), k6, j11);
                    return;
                }
            }
            long j12 = bVar2.f4199d;
            int i9 = (j12 > (-9223372036854775807L) ? 1 : (j12 == (-9223372036854775807L) ? 0 : -1));
            boolean z5 = i9 != 0;
            if (bVar2.h() == 0) {
                gVar.f14290b = z5;
                return;
            }
            long e7 = bVar2.e(this.f4189j, this.f4190k, j10);
            long g7 = bVar2.g(this.f4189j, this.f4190k, j10);
            q(bVar2, g7);
            boolean z6 = z5;
            long m6 = m(bVar2, mVar, j7, e7, g7);
            if (m6 < e7) {
                this.f4191l = new w1.b();
                return;
            }
            int i10 = (m6 > g7 ? 1 : (m6 == g7 ? 0 : -1));
            if (i10 > 0 || (this.f4192m && i10 >= 0)) {
                gVar.f14290b = z6;
            } else if (z6 && bVar2.k(m6) >= j12) {
                gVar.f14290b = true;
            } else {
                int min = (int) Math.min(this.f4185f, (g7 - m6) + 1);
                if (i9 != 0) {
                    while (min > 1 && bVar2.k((min + m6) - 1) >= j12) {
                        min--;
                    }
                }
                gVar.f14289a = o(bVar2, this.f4183d, this.f4182c, this.f4188i.l(), this.f4188i.m(), this.f4188i.p(), m6, min, list.isEmpty() ? j7 : -9223372036854775807L);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void g(a2.b bVar, int i6) {
        try {
            this.f4189j = bVar;
            this.f4190k = i6;
            long g6 = bVar.g(i6);
            ArrayList l6 = l();
            for (int i7 = 0; i7 < this.f4187h.length; i7++) {
                b[] bVarArr = this.f4187h;
                bVarArr[i7] = bVarArr[i7].b(g6, (i) l6.get(this.f4188i.f(i7)));
            }
        } catch (w1.b e6) {
            this.f4191l = e6;
        }
    }

    @Override // y1.i
    public boolean h(y1.e eVar, boolean z5, Exception exc, long j6) {
        b bVar;
        int h6;
        if (z5) {
            e.c cVar = this.f4186g;
            if (cVar == null || !cVar.i(eVar)) {
                if (!this.f4189j.f54d && (eVar instanceof m) && (exc instanceof a0.e) && ((a0.e) exc).responseCode == 404 && (h6 = (bVar = this.f4187h[this.f4188i.h(eVar.f14283d)]).h()) != -1 && h6 != 0) {
                    if (((m) eVar).g() > (bVar.f() + h6) - 1) {
                        this.f4192m = true;
                        return true;
                    }
                }
                if (j6 != -9223372036854775807L) {
                    j jVar = this.f4188i;
                    return jVar.a(jVar.h(eVar.f14283d), j6);
                }
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // y1.i
    public void i(y1.e eVar) {
        c1.d d6;
        if (eVar instanceof y1.l) {
            int h6 = this.f4188i.h(((y1.l) eVar).f14283d);
            b bVar = this.f4187h[h6];
            if (bVar.f4198c == null && (d6 = bVar.f4196a.d()) != null) {
                this.f4187h[h6] = bVar.c(new z1.f(d6, bVar.f4197b.f100d));
            }
        }
        e.c cVar = this.f4186g;
        if (cVar != null) {
            cVar.j(eVar);
        }
    }

    @Override // y1.i
    public boolean k(long j6, y1.e eVar, List list) {
        if (this.f4191l != null) {
            return false;
        }
        return this.f4188i.i(j6, eVar, list);
    }

    protected y1.e n(b bVar, l lVar, com.google.android.exoplayer2.s0 s0Var, int i6, Object obj, h hVar, h hVar2) {
        i iVar = bVar.f4197b;
        if (hVar == null || (hVar2 = hVar.a(hVar2, iVar.f99c)) != null) {
            hVar = hVar2;
        }
        return new y1.l(lVar, z1.e.a(iVar, hVar), s0Var, i6, obj, bVar.f4196a);
    }

    protected y1.e o(b bVar, l lVar, int i6, com.google.android.exoplayer2.s0 s0Var, int i7, Object obj, long j6, int i8, long j7) {
        i iVar = bVar.f4197b;
        long k6 = bVar.k(j6);
        h l6 = bVar.l(j6);
        String str = iVar.f99c;
        if (bVar.f4196a == null) {
            return new o(lVar, z1.e.a(iVar, l6), s0Var, i7, obj, k6, bVar.i(j6), j6, i6, s0Var);
        }
        int i9 = 1;
        int i10 = 1;
        while (i9 < i8) {
            h a6 = l6.a(bVar.l(i9 + j6), str);
            if (a6 == null) {
                break;
            }
            i10++;
            i9++;
            l6 = a6;
        }
        long i11 = bVar.i((i10 + j6) - 1);
        long j8 = bVar.f4199d;
        return new y1.j(lVar, z1.e.a(iVar, l6), s0Var, i7, obj, k6, i11, j7, (j8 == -9223372036854775807L || j8 > i11) ? -9223372036854775807L : j8, j6, i10, -iVar.f100d, bVar.f4196a);
    }
}
