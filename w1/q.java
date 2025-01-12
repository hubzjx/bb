package w1;

import com.google.android.exoplayer2.s1;
import java.io.IOException;
import w1.t;
import w1.v;
/* loaded from: classes.dex */
public final class q implements t, t.a {

    /* renamed from: a  reason: collision with root package name */
    public final v f13976a;

    /* renamed from: b  reason: collision with root package name */
    public final v.a f13977b;

    /* renamed from: c  reason: collision with root package name */
    private final q2.b f13978c;

    /* renamed from: d  reason: collision with root package name */
    private t f13979d;

    /* renamed from: e  reason: collision with root package name */
    private t.a f13980e;

    /* renamed from: f  reason: collision with root package name */
    private long f13981f;

    /* renamed from: g  reason: collision with root package name */
    private a f13982g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13983h;

    /* renamed from: k  reason: collision with root package name */
    private long f13984k = -9223372036854775807L;

    /* loaded from: classes.dex */
    public interface a {
        void a(v.a aVar);

        void b(v.a aVar, IOException iOException);
    }

    public q(v vVar, v.a aVar, q2.b bVar, long j6) {
        this.f13977b = aVar;
        this.f13978c = bVar;
        this.f13976a = vVar;
        this.f13981f = j6;
    }

    private long r(long j6) {
        long j7 = this.f13984k;
        return j7 != -9223372036854775807L ? j7 : j6;
    }

    @Override // w1.t, w1.s0
    public boolean a() {
        t tVar = this.f13979d;
        return tVar != null && tVar.a();
    }

    @Override // w1.t
    public long c(long j6, s1 s1Var) {
        return ((t) com.google.android.exoplayer2.util.s0.j(this.f13979d)).c(j6, s1Var);
    }

    @Override // w1.t, w1.s0
    public long d() {
        return ((t) com.google.android.exoplayer2.util.s0.j(this.f13979d)).d();
    }

    public void e(v.a aVar) {
        long r5 = r(this.f13981f);
        t o5 = this.f13976a.o(aVar, this.f13978c, r5);
        this.f13979d = o5;
        if (this.f13980e != null) {
            o5.o(this, r5);
        }
    }

    @Override // w1.t, w1.s0
    public long f() {
        return ((t) com.google.android.exoplayer2.util.s0.j(this.f13979d)).f();
    }

    @Override // w1.t.a
    public void g(t tVar) {
        ((t.a) com.google.android.exoplayer2.util.s0.j(this.f13980e)).g(this);
        a aVar = this.f13982g;
        if (aVar != null) {
            aVar.a(this.f13977b);
        }
    }

    @Override // w1.t, w1.s0
    public boolean h(long j6) {
        t tVar = this.f13979d;
        return tVar != null && tVar.h(j6);
    }

    @Override // w1.t, w1.s0
    public void i(long j6) {
        ((t) com.google.android.exoplayer2.util.s0.j(this.f13979d)).i(j6);
    }

    public long k() {
        return this.f13984k;
    }

    @Override // w1.t
    public long l() {
        return ((t) com.google.android.exoplayer2.util.s0.j(this.f13979d)).l();
    }

    @Override // w1.t
    public y0 n() {
        return ((t) com.google.android.exoplayer2.util.s0.j(this.f13979d)).n();
    }

    @Override // w1.t
    public void o(t.a aVar, long j6) {
        this.f13980e = aVar;
        t tVar = this.f13979d;
        if (tVar != null) {
            tVar.o(this, r(this.f13981f));
        }
    }

    public long p() {
        return this.f13981f;
    }

    @Override // w1.t
    public long q(o2.j[] jVarArr, boolean[] zArr, r0[] r0VarArr, boolean[] zArr2, long j6) {
        long j7;
        long j8 = this.f13984k;
        if (j8 == -9223372036854775807L || j6 != this.f13981f) {
            j7 = j6;
        } else {
            this.f13984k = -9223372036854775807L;
            j7 = j8;
        }
        return ((t) com.google.android.exoplayer2.util.s0.j(this.f13979d)).q(jVarArr, zArr, r0VarArr, zArr2, j7);
    }

    @Override // w1.t
    public void s() {
        try {
            t tVar = this.f13979d;
            if (tVar != null) {
                tVar.s();
            } else {
                this.f13976a.e();
            }
        } catch (IOException e6) {
            a aVar = this.f13982g;
            if (aVar == null) {
                throw e6;
            }
            if (this.f13983h) {
                return;
            }
            this.f13983h = true;
            aVar.b(this.f13977b, e6);
        }
    }

    @Override // w1.t
    public void t(long j6, boolean z5) {
        ((t) com.google.android.exoplayer2.util.s0.j(this.f13979d)).t(j6, z5);
    }

    @Override // w1.t
    public long u(long j6) {
        return ((t) com.google.android.exoplayer2.util.s0.j(this.f13979d)).u(j6);
    }

    @Override // w1.s0.a
    /* renamed from: v */
    public void j(t tVar) {
        ((t.a) com.google.android.exoplayer2.util.s0.j(this.f13980e)).j(this);
    }

    public void w(long j6) {
        this.f13984k = j6;
    }

    public void x() {
        t tVar = this.f13979d;
        if (tVar != null) {
            this.f13976a.i(tVar);
        }
    }
}
