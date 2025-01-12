package b2;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import b2.e;
import b2.f;
import b2.j;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.util.s0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import q2.c0;
import q2.d0;
import q2.f0;
import w1.e0;
import w1.p;
import w1.s;
/* loaded from: classes.dex */
public final class c implements j, d0.b {

    /* renamed from: s  reason: collision with root package name */
    public static final j.a f2909s = new j.a() { // from class: b2.b
        @Override // b2.j.a
        public final j a(com.google.android.exoplayer2.source.hls.g gVar, c0 c0Var, i iVar) {
            return new c(gVar, c0Var, iVar);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.source.hls.g f2910a;

    /* renamed from: b  reason: collision with root package name */
    private final i f2911b;

    /* renamed from: c  reason: collision with root package name */
    private final c0 f2912c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap f2913d;

    /* renamed from: e  reason: collision with root package name */
    private final List f2914e;

    /* renamed from: f  reason: collision with root package name */
    private final double f2915f;

    /* renamed from: g  reason: collision with root package name */
    private f0.a f2916g;

    /* renamed from: h  reason: collision with root package name */
    private e0.a f2917h;

    /* renamed from: k  reason: collision with root package name */
    private d0 f2918k;

    /* renamed from: l  reason: collision with root package name */
    private Handler f2919l;

    /* renamed from: m  reason: collision with root package name */
    private j.e f2920m;

    /* renamed from: n  reason: collision with root package name */
    private e f2921n;

    /* renamed from: o  reason: collision with root package name */
    private Uri f2922o;

    /* renamed from: p  reason: collision with root package name */
    private f f2923p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f2924q;

    /* renamed from: r  reason: collision with root package name */
    private long f2925r;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements d0.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f2926a;

        /* renamed from: b  reason: collision with root package name */
        private final d0 f2927b = new d0("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* renamed from: c  reason: collision with root package name */
        private final f0 f2928c;

        /* renamed from: d  reason: collision with root package name */
        private f f2929d;

        /* renamed from: e  reason: collision with root package name */
        private long f2930e;

        /* renamed from: f  reason: collision with root package name */
        private long f2931f;

        /* renamed from: g  reason: collision with root package name */
        private long f2932g;

        /* renamed from: h  reason: collision with root package name */
        private long f2933h;

        /* renamed from: k  reason: collision with root package name */
        private boolean f2934k;

        /* renamed from: l  reason: collision with root package name */
        private IOException f2935l;

        public a(Uri uri) {
            this.f2926a = uri;
            this.f2928c = new f0(c.this.f2910a.a(4), uri, 4, c.this.f2916g);
        }

        private boolean d(long j6) {
            this.f2933h = SystemClock.elapsedRealtime() + j6;
            return this.f2926a.equals(c.this.f2922o) && !c.this.F();
        }

        private void h() {
            long n5 = this.f2927b.n(this.f2928c, this, c.this.f2912c.d(this.f2928c.f12756c));
            e0.a aVar = c.this.f2917h;
            f0 f0Var = this.f2928c;
            aVar.z(new p(f0Var.f12754a, f0Var.f12755b, n5), this.f2928c.f12756c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(f fVar, p pVar) {
            f fVar2 = this.f2929d;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f2930e = elapsedRealtime;
            f B = c.this.B(fVar2, fVar);
            this.f2929d = B;
            if (B != fVar2) {
                this.f2935l = null;
                this.f2931f = elapsedRealtime;
                c.this.L(this.f2926a, B);
            } else if (!B.f2968l) {
                f fVar3 = this.f2929d;
                if (fVar.f2965i + fVar.f2971o.size() < fVar3.f2965i) {
                    this.f2935l = new j.c(this.f2926a);
                    c.this.H(this.f2926a, -9223372036854775807L);
                } else if (elapsedRealtime - this.f2931f > com.google.android.exoplayer2.p.b(fVar3.f2967k) * c.this.f2915f) {
                    this.f2935l = new j.d(this.f2926a);
                    long c6 = c.this.f2912c.c(new c0.a(pVar, new s(4), this.f2935l, 1));
                    c.this.H(this.f2926a, c6);
                    if (c6 != -9223372036854775807L) {
                        d(c6);
                    }
                }
            }
            f fVar4 = this.f2929d;
            this.f2932g = elapsedRealtime + com.google.android.exoplayer2.p.b(fVar4 != fVar2 ? fVar4.f2967k : fVar4.f2967k / 2);
            if (!this.f2926a.equals(c.this.f2922o) || this.f2929d.f2968l) {
                return;
            }
            g();
        }

        public f e() {
            return this.f2929d;
        }

        public boolean f() {
            int i6;
            if (this.f2929d == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(30000L, com.google.android.exoplayer2.p.b(this.f2929d.f2972p));
            f fVar = this.f2929d;
            return fVar.f2968l || (i6 = fVar.f2960d) == 2 || i6 == 1 || this.f2930e + max > elapsedRealtime;
        }

        public void g() {
            this.f2933h = 0L;
            if (this.f2934k || this.f2927b.j() || this.f2927b.i()) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime >= this.f2932g) {
                h();
                return;
            }
            this.f2934k = true;
            c.this.f2919l.postDelayed(this, this.f2932g - elapsedRealtime);
        }

        public void i() {
            this.f2927b.b();
            IOException iOException = this.f2935l;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // q2.d0.b
        /* renamed from: j */
        public void p(f0 f0Var, long j6, long j7, boolean z5) {
            p pVar = new p(f0Var.f12754a, f0Var.f12755b, f0Var.f(), f0Var.d(), j6, j7, f0Var.b());
            c.this.f2912c.a(f0Var.f12754a);
            c.this.f2917h.q(pVar, 4);
        }

        @Override // q2.d0.b
        /* renamed from: l */
        public void m(f0 f0Var, long j6, long j7) {
            g gVar = (g) f0Var.e();
            p pVar = new p(f0Var.f12754a, f0Var.f12755b, f0Var.f(), f0Var.d(), j6, j7, f0Var.b());
            if (gVar instanceof f) {
                o((f) gVar, pVar);
                c.this.f2917h.t(pVar, 4);
            } else {
                this.f2935l = new f1("Loaded playlist has unexpected type.");
                c.this.f2917h.x(pVar, 4, this.f2935l, true);
            }
            c.this.f2912c.a(f0Var.f12754a);
        }

        @Override // q2.d0.b
        /* renamed from: n */
        public d0.c k(f0 f0Var, long j6, long j7, IOException iOException, int i6) {
            d0.c cVar;
            p pVar = new p(f0Var.f12754a, f0Var.f12755b, f0Var.f(), f0Var.d(), j6, j7, f0Var.b());
            c0.a aVar = new c0.a(pVar, new s(f0Var.f12756c), iOException, i6);
            long c6 = c.this.f2912c.c(aVar);
            boolean z5 = c6 != -9223372036854775807L;
            boolean z6 = c.this.H(this.f2926a, c6) || !z5;
            if (z5) {
                z6 |= d(c6);
            }
            if (z6) {
                long b6 = c.this.f2912c.b(aVar);
                cVar = b6 != -9223372036854775807L ? d0.h(false, b6) : d0.f12729g;
            } else {
                cVar = d0.f12728f;
            }
            boolean c7 = true ^ cVar.c();
            c.this.f2917h.x(pVar, f0Var.f12756c, iOException, c7);
            if (c7) {
                c.this.f2912c.a(f0Var.f12754a);
            }
            return cVar;
        }

        public void q() {
            this.f2927b.l();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2934k = false;
            h();
        }
    }

    public c(com.google.android.exoplayer2.source.hls.g gVar, c0 c0Var, i iVar) {
        this(gVar, c0Var, iVar, 3.5d);
    }

    private static f.a A(f fVar, f fVar2) {
        int i6 = (int) (fVar2.f2965i - fVar.f2965i);
        List list = fVar.f2971o;
        if (i6 < list.size()) {
            return (f.a) list.get(i6);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f B(f fVar, f fVar2) {
        return !fVar2.f(fVar) ? fVar2.f2968l ? fVar.d() : fVar : fVar2.c(D(fVar, fVar2), C(fVar, fVar2));
    }

    private int C(f fVar, f fVar2) {
        f.a A;
        if (fVar2.f2963g) {
            return fVar2.f2964h;
        }
        f fVar3 = this.f2923p;
        int i6 = fVar3 != null ? fVar3.f2964h : 0;
        return (fVar == null || (A = A(fVar, fVar2)) == null) ? i6 : (fVar.f2964h + A.f2977e) - ((f.a) fVar2.f2971o.get(0)).f2977e;
    }

    private long D(f fVar, f fVar2) {
        if (fVar2.f2969m) {
            return fVar2.f2962f;
        }
        f fVar3 = this.f2923p;
        long j6 = fVar3 != null ? fVar3.f2962f : 0L;
        if (fVar == null) {
            return j6;
        }
        int size = fVar.f2971o.size();
        f.a A = A(fVar, fVar2);
        return A != null ? fVar.f2962f + A.f2978f : ((long) size) == fVar2.f2965i - fVar.f2965i ? fVar.e() : j6;
    }

    private boolean E(Uri uri) {
        List list = this.f2921n.f2941e;
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (uri.equals(((e.b) list.get(i6)).f2954a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F() {
        List list = this.f2921n.f2941e;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i6 = 0; i6 < size; i6++) {
            a aVar = (a) this.f2913d.get(((e.b) list.get(i6)).f2954a);
            if (elapsedRealtime > aVar.f2933h) {
                this.f2922o = aVar.f2926a;
                aVar.g();
                return true;
            }
        }
        return false;
    }

    private void G(Uri uri) {
        if (uri.equals(this.f2922o) || !E(uri)) {
            return;
        }
        f fVar = this.f2923p;
        if (fVar == null || !fVar.f2968l) {
            this.f2922o = uri;
            ((a) this.f2913d.get(uri)).g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H(Uri uri, long j6) {
        int size = this.f2914e.size();
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            z5 |= !((j.b) this.f2914e.get(i6)).k(uri, j6);
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(Uri uri, f fVar) {
        if (uri.equals(this.f2922o)) {
            if (this.f2923p == null) {
                this.f2924q = !fVar.f2968l;
                this.f2925r = fVar.f2962f;
            }
            this.f2923p = fVar;
            this.f2920m.h(fVar);
        }
        int size = this.f2914e.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((j.b) this.f2914e.get(i6)).e();
        }
    }

    private void z(List list) {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            Uri uri = (Uri) list.get(i6);
            this.f2913d.put(uri, new a(uri));
        }
    }

    @Override // q2.d0.b
    /* renamed from: I */
    public void p(f0 f0Var, long j6, long j7, boolean z5) {
        p pVar = new p(f0Var.f12754a, f0Var.f12755b, f0Var.f(), f0Var.d(), j6, j7, f0Var.b());
        this.f2912c.a(f0Var.f12754a);
        this.f2917h.q(pVar, 4);
    }

    @Override // q2.d0.b
    /* renamed from: J */
    public void m(f0 f0Var, long j6, long j7) {
        g gVar = (g) f0Var.e();
        boolean z5 = gVar instanceof f;
        e e6 = z5 ? e.e(gVar.f2985a) : (e) gVar;
        this.f2921n = e6;
        this.f2916g = this.f2911b.a(e6);
        this.f2922o = ((e.b) e6.f2941e.get(0)).f2954a;
        z(e6.f2940d);
        a aVar = (a) this.f2913d.get(this.f2922o);
        p pVar = new p(f0Var.f12754a, f0Var.f12755b, f0Var.f(), f0Var.d(), j6, j7, f0Var.b());
        if (z5) {
            aVar.o((f) gVar, pVar);
        } else {
            aVar.g();
        }
        this.f2912c.a(f0Var.f12754a);
        this.f2917h.t(pVar, 4);
    }

    @Override // q2.d0.b
    /* renamed from: K */
    public d0.c k(f0 f0Var, long j6, long j7, IOException iOException, int i6) {
        p pVar = new p(f0Var.f12754a, f0Var.f12755b, f0Var.f(), f0Var.d(), j6, j7, f0Var.b());
        long b6 = this.f2912c.b(new c0.a(pVar, new s(f0Var.f12756c), iOException, i6));
        boolean z5 = b6 == -9223372036854775807L;
        this.f2917h.x(pVar, f0Var.f12756c, iOException, z5);
        if (z5) {
            this.f2912c.a(f0Var.f12754a);
        }
        return z5 ? d0.f12729g : d0.h(false, b6);
    }

    @Override // b2.j
    public boolean a() {
        return this.f2924q;
    }

    @Override // b2.j
    public void b(j.b bVar) {
        this.f2914e.remove(bVar);
    }

    @Override // b2.j
    public e c() {
        return this.f2921n;
    }

    @Override // b2.j
    public boolean d(Uri uri) {
        return ((a) this.f2913d.get(uri)).f();
    }

    @Override // b2.j
    public void e() {
        d0 d0Var = this.f2918k;
        if (d0Var != null) {
            d0Var.b();
        }
        Uri uri = this.f2922o;
        if (uri != null) {
            f(uri);
        }
    }

    @Override // b2.j
    public void f(Uri uri) {
        ((a) this.f2913d.get(uri)).i();
    }

    @Override // b2.j
    public void g(Uri uri) {
        ((a) this.f2913d.get(uri)).g();
    }

    @Override // b2.j
    public void h(j.b bVar) {
        com.google.android.exoplayer2.util.a.e(bVar);
        this.f2914e.add(bVar);
    }

    @Override // b2.j
    public f i(Uri uri, boolean z5) {
        f e6 = ((a) this.f2913d.get(uri)).e();
        if (e6 != null && z5) {
            G(uri);
        }
        return e6;
    }

    @Override // b2.j
    public long j() {
        return this.f2925r;
    }

    @Override // b2.j
    public void l(Uri uri, e0.a aVar, j.e eVar) {
        this.f2919l = s0.x();
        this.f2917h = aVar;
        this.f2920m = eVar;
        f0 f0Var = new f0(this.f2910a.a(4), uri, 4, this.f2911b.b());
        com.google.android.exoplayer2.util.a.g(this.f2918k == null);
        d0 d0Var = new d0("DefaultHlsPlaylistTracker:MasterPlaylist");
        this.f2918k = d0Var;
        aVar.z(new p(f0Var.f12754a, f0Var.f12755b, d0Var.n(f0Var, this, this.f2912c.d(f0Var.f12756c))), f0Var.f12756c);
    }

    @Override // b2.j
    public void stop() {
        this.f2922o = null;
        this.f2923p = null;
        this.f2921n = null;
        this.f2925r = -9223372036854775807L;
        this.f2918k.l();
        this.f2918k = null;
        for (a aVar : this.f2913d.values()) {
            aVar.q();
        }
        this.f2919l.removeCallbacksAndMessages(null);
        this.f2919l = null;
        this.f2913d.clear();
    }

    public c(com.google.android.exoplayer2.source.hls.g gVar, c0 c0Var, i iVar, double d6) {
        this.f2910a = gVar;
        this.f2911b = iVar;
        this.f2912c = c0Var;
        this.f2915f = d6;
        this.f2914e = new ArrayList();
        this.f2913d = new HashMap();
        this.f2925r = -9223372036854775807L;
    }
}
