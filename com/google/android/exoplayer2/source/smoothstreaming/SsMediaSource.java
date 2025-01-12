package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.r0;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.a;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.w0;
import d2.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import q2.c0;
import q2.d0;
import q2.e0;
import q2.f0;
import q2.i0;
import q2.l;
import u1.d;
import w1.e0;
import w1.g0;
import w1.i;
import w1.j;
import w1.s;
import w1.t;
import w1.u0;
import w1.v;
import w1.w;
/* loaded from: classes.dex */
public final class SsMediaSource extends w1.a implements d0.b {
    private d2.a A;
    private Handler B;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f4387g;

    /* renamed from: h  reason: collision with root package name */
    private final Uri f4388h;

    /* renamed from: k  reason: collision with root package name */
    private final w0.e f4389k;

    /* renamed from: l  reason: collision with root package name */
    private final w0 f4390l;

    /* renamed from: m  reason: collision with root package name */
    private final l.a f4391m;

    /* renamed from: n  reason: collision with root package name */
    private final b.a f4392n;

    /* renamed from: o  reason: collision with root package name */
    private final i f4393o;

    /* renamed from: p  reason: collision with root package name */
    private final v f4394p;

    /* renamed from: q  reason: collision with root package name */
    private final c0 f4395q;

    /* renamed from: r  reason: collision with root package name */
    private final long f4396r;

    /* renamed from: s  reason: collision with root package name */
    private final e0.a f4397s;

    /* renamed from: t  reason: collision with root package name */
    private final f0.a f4398t;

    /* renamed from: u  reason: collision with root package name */
    private final ArrayList f4399u;

    /* renamed from: v  reason: collision with root package name */
    private l f4400v;

    /* renamed from: w  reason: collision with root package name */
    private d0 f4401w;

    /* renamed from: x  reason: collision with root package name */
    private q2.e0 f4402x;

    /* renamed from: y  reason: collision with root package name */
    private i0 f4403y;

    /* renamed from: z  reason: collision with root package name */
    private long f4404z;

    /* loaded from: classes.dex */
    public static final class Factory implements g0 {

        /* renamed from: a  reason: collision with root package name */
        private final b.a f4405a;

        /* renamed from: b  reason: collision with root package name */
        private final w f4406b;

        /* renamed from: c  reason: collision with root package name */
        private final l.a f4407c;

        /* renamed from: d  reason: collision with root package name */
        private i f4408d;

        /* renamed from: e  reason: collision with root package name */
        private v f4409e;

        /* renamed from: f  reason: collision with root package name */
        private c0 f4410f;

        /* renamed from: g  reason: collision with root package name */
        private long f4411g;

        /* renamed from: h  reason: collision with root package name */
        private f0.a f4412h;

        /* renamed from: i  reason: collision with root package name */
        private List f4413i;

        /* renamed from: j  reason: collision with root package name */
        private Object f4414j;

        public Factory(b.a aVar, l.a aVar2) {
            this.f4405a = (b.a) com.google.android.exoplayer2.util.a.e(aVar);
            this.f4407c = aVar2;
            this.f4406b = new w();
            this.f4410f = new q2.w();
            this.f4411g = 30000L;
            this.f4408d = new j();
            this.f4413i = Collections.emptyList();
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
        @Override // w1.g0
        /* renamed from: e */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public SsMediaSource c(w0 w0Var) {
            w0.b a6;
            w0.b f6;
            v vVar;
            w0 w0Var2 = w0Var;
            com.google.android.exoplayer2.util.a.e(w0Var2.f4702b);
            f0.a aVar = this.f4412h;
            if (aVar == null) {
                aVar = new d2.b();
            }
            List list = !w0Var2.f4702b.f4743d.isEmpty() ? w0Var2.f4702b.f4743d : this.f4413i;
            d dVar = !list.isEmpty() ? new d(aVar, list) : aVar;
            w0.e eVar = w0Var2.f4702b;
            boolean z5 = true;
            boolean z6 = eVar.f4747h == null && this.f4414j != null;
            z5 = (!eVar.f4743d.isEmpty() || list.isEmpty()) ? false : false;
            if (!z6 || !z5) {
                if (!z6) {
                    if (z5) {
                        a6 = w0Var.a();
                    }
                    w0 w0Var3 = w0Var2;
                    l.a aVar2 = this.f4407c;
                    b.a aVar3 = this.f4405a;
                    i iVar = this.f4408d;
                    vVar = this.f4409e;
                    if (vVar == null) {
                    }
                    return new SsMediaSource(w0Var3, null, aVar2, dVar, aVar3, iVar, vVar, this.f4410f, this.f4411g);
                }
                f6 = w0Var.a().f(this.f4414j);
                w0Var2 = f6.a();
                w0 w0Var32 = w0Var2;
                l.a aVar22 = this.f4407c;
                b.a aVar32 = this.f4405a;
                i iVar2 = this.f4408d;
                vVar = this.f4409e;
                if (vVar == null) {
                    vVar = this.f4406b.a(w0Var32);
                }
                return new SsMediaSource(w0Var32, null, aVar22, dVar, aVar32, iVar2, vVar, this.f4410f, this.f4411g);
            }
            a6 = w0Var.a().f(this.f4414j);
            f6 = a6.e(list);
            w0Var2 = f6.a();
            w0 w0Var322 = w0Var2;
            l.a aVar222 = this.f4407c;
            b.a aVar322 = this.f4405a;
            i iVar22 = this.f4408d;
            vVar = this.f4409e;
            if (vVar == null) {
            }
            return new SsMediaSource(w0Var322, null, aVar222, dVar, aVar322, iVar22, vVar, this.f4410f, this.f4411g);
        }

        @Override // w1.g0
        /* renamed from: f */
        public Factory b(v vVar) {
            this.f4409e = vVar;
            return this;
        }

        @Override // w1.g0
        /* renamed from: g */
        public Factory d(c0 c0Var) {
            if (c0Var == null) {
                c0Var = new q2.w();
            }
            this.f4410f = c0Var;
            return this;
        }

        @Override // w1.g0
        /* renamed from: h */
        public Factory a(List list) {
            if (list == null) {
                list = Collections.emptyList();
            }
            this.f4413i = list;
            return this;
        }

        public Factory(l.a aVar) {
            this(new a.C0042a(aVar), aVar);
        }
    }

    static {
        r0.a("goog.exo.smoothstreaming");
    }

    private SsMediaSource(w0 w0Var, d2.a aVar, l.a aVar2, f0.a aVar3, b.a aVar4, i iVar, v vVar, c0 c0Var, long j6) {
        com.google.android.exoplayer2.util.a.g(aVar == null || !aVar.f9140d);
        this.f4390l = w0Var;
        w0.e eVar = (w0.e) com.google.android.exoplayer2.util.a.e(w0Var.f4702b);
        this.f4389k = eVar;
        this.A = aVar;
        this.f4388h = eVar.f4740a.equals(Uri.EMPTY) ? null : s0.C(eVar.f4740a);
        this.f4391m = aVar2;
        this.f4398t = aVar3;
        this.f4392n = aVar4;
        this.f4393o = iVar;
        this.f4394p = vVar;
        this.f4395q = c0Var;
        this.f4396r = j6;
        this.f4397s = v(null);
        this.f4387g = aVar != null;
        this.f4399u = new ArrayList();
    }

    private void H() {
        a.b[] bVarArr;
        u0 u0Var;
        for (int i6 = 0; i6 < this.f4399u.size(); i6++) {
            ((c) this.f4399u.get(i6)).w(this.A);
        }
        long j6 = Long.MIN_VALUE;
        long j7 = Long.MAX_VALUE;
        for (a.b bVar : this.A.f9142f) {
            if (bVar.f9158k > 0) {
                j7 = Math.min(j7, bVar.e(0));
                j6 = Math.max(j6, bVar.e(bVar.f9158k - 1) + bVar.c(bVar.f9158k - 1));
            }
        }
        if (j7 == Long.MAX_VALUE) {
            long j8 = this.A.f9140d ? -9223372036854775807L : 0L;
            d2.a aVar = this.A;
            boolean z5 = aVar.f9140d;
            u0Var = new u0(j8, 0L, 0L, 0L, true, z5, z5, aVar, this.f4390l);
        } else {
            d2.a aVar2 = this.A;
            if (aVar2.f9140d) {
                long j9 = aVar2.f9144h;
                if (j9 != -9223372036854775807L && j9 > 0) {
                    j7 = Math.max(j7, j6 - j9);
                }
                long j10 = j7;
                long j11 = j6 - j10;
                long a6 = j11 - p.a(this.f4396r);
                if (a6 < 5000000) {
                    a6 = Math.min(5000000L, j11 / 2);
                }
                u0Var = new u0(-9223372036854775807L, j11, j10, a6, true, true, true, this.A, this.f4390l);
            } else {
                long j12 = aVar2.f9143g;
                long j13 = j12 != -9223372036854775807L ? j12 : j6 - j7;
                u0Var = new u0(j7 + j13, j13, j7, 0L, true, false, false, this.A, this.f4390l);
            }
        }
        B(u0Var);
    }

    private void I() {
        if (this.A.f9140d) {
            this.B.postDelayed(new Runnable() { // from class: c2.a
                @Override // java.lang.Runnable
                public final void run() {
                    SsMediaSource.this.J();
                }
            }, Math.max(0L, (this.f4404z + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (this.f4401w.i()) {
            return;
        }
        f0 f0Var = new f0(this.f4400v, this.f4388h, 4, this.f4398t);
        this.f4397s.z(new w1.p(f0Var.f12754a, f0Var.f12755b, this.f4401w.n(f0Var, this, this.f4395q.d(f0Var.f12756c))), f0Var.f12756c);
    }

    @Override // w1.a
    protected void A(i0 i0Var) {
        this.f4403y = i0Var;
        this.f4394p.b();
        if (this.f4387g) {
            this.f4402x = new e0.a();
            H();
            return;
        }
        this.f4400v = this.f4391m.a();
        d0 d0Var = new d0("Loader:Manifest");
        this.f4401w = d0Var;
        this.f4402x = d0Var;
        this.B = s0.x();
        J();
    }

    @Override // w1.a
    protected void C() {
        this.A = this.f4387g ? this.A : null;
        this.f4400v = null;
        this.f4404z = 0L;
        d0 d0Var = this.f4401w;
        if (d0Var != null) {
            d0Var.l();
            this.f4401w = null;
        }
        Handler handler = this.B;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.B = null;
        }
        this.f4394p.a();
    }

    @Override // q2.d0.b
    /* renamed from: E */
    public void p(f0 f0Var, long j6, long j7, boolean z5) {
        w1.p pVar = new w1.p(f0Var.f12754a, f0Var.f12755b, f0Var.f(), f0Var.d(), j6, j7, f0Var.b());
        this.f4395q.a(f0Var.f12754a);
        this.f4397s.q(pVar, f0Var.f12756c);
    }

    @Override // q2.d0.b
    /* renamed from: F */
    public void m(f0 f0Var, long j6, long j7) {
        w1.p pVar = new w1.p(f0Var.f12754a, f0Var.f12755b, f0Var.f(), f0Var.d(), j6, j7, f0Var.b());
        this.f4395q.a(f0Var.f12754a);
        this.f4397s.t(pVar, f0Var.f12756c);
        this.A = (d2.a) f0Var.e();
        this.f4404z = j6 - j7;
        H();
        I();
    }

    @Override // q2.d0.b
    /* renamed from: G */
    public d0.c k(f0 f0Var, long j6, long j7, IOException iOException, int i6) {
        w1.p pVar = new w1.p(f0Var.f12754a, f0Var.f12755b, f0Var.f(), f0Var.d(), j6, j7, f0Var.b());
        long b6 = this.f4395q.b(new c0.a(pVar, new s(f0Var.f12756c), iOException, i6));
        d0.c h6 = b6 == -9223372036854775807L ? d0.f12729g : d0.h(false, b6);
        boolean z5 = !h6.c();
        this.f4397s.x(pVar, f0Var.f12756c, iOException, z5);
        if (z5) {
            this.f4395q.a(f0Var.f12754a);
        }
        return h6;
    }

    @Override // w1.v
    public w0 a() {
        return this.f4390l;
    }

    @Override // w1.v
    public void e() {
        this.f4402x.b();
    }

    @Override // w1.v
    public void i(t tVar) {
        ((c) tVar).v();
        this.f4399u.remove(tVar);
    }

    @Override // w1.v
    public t o(v.a aVar, q2.b bVar, long j6) {
        e0.a v5 = v(aVar);
        c cVar = new c(this.A, this.f4392n, this.f4403y, this.f4393o, this.f4394p, t(aVar), this.f4395q, v5, this.f4402x, bVar);
        this.f4399u.add(cVar);
        return cVar;
    }
}
