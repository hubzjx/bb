package j1;

import c1.a0;
import c1.k;
import c1.w;
import c1.x;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private final e f11191a = new e();

    /* renamed from: b  reason: collision with root package name */
    private a0 f11192b;

    /* renamed from: c  reason: collision with root package name */
    private k f11193c;

    /* renamed from: d  reason: collision with root package name */
    private g f11194d;

    /* renamed from: e  reason: collision with root package name */
    private long f11195e;

    /* renamed from: f  reason: collision with root package name */
    private long f11196f;

    /* renamed from: g  reason: collision with root package name */
    private long f11197g;

    /* renamed from: h  reason: collision with root package name */
    private int f11198h;

    /* renamed from: i  reason: collision with root package name */
    private int f11199i;

    /* renamed from: j  reason: collision with root package name */
    private b f11200j;

    /* renamed from: k  reason: collision with root package name */
    private long f11201k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11202l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f11203m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        s0 f11204a;

        /* renamed from: b  reason: collision with root package name */
        g f11205b;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c implements g {
        private c() {
        }

        @Override // j1.g
        public x a() {
            return new x.b(-9223372036854775807L);
        }

        @Override // j1.g
        public long b(c1.j jVar) {
            return -1L;
        }

        @Override // j1.g
        public void c(long j6) {
        }
    }

    private int g(c1.j jVar) {
        boolean z5 = true;
        while (z5) {
            if (!this.f11191a.d(jVar)) {
                this.f11198h = 3;
                return -1;
            }
            this.f11201k = jVar.p() - this.f11196f;
            z5 = h(this.f11191a.c(), this.f11196f, this.f11200j);
            if (z5) {
                this.f11196f = jVar.p();
            }
        }
        s0 s0Var = this.f11200j.f11204a;
        this.f11199i = s0Var.B;
        if (!this.f11203m) {
            this.f11192b.e(s0Var);
            this.f11203m = true;
        }
        g gVar = this.f11200j.f11205b;
        if (gVar != null) {
            this.f11194d = gVar;
        } else if (jVar.a() == -1) {
            this.f11194d = new c();
        } else {
            f b6 = this.f11191a.b();
            this.f11194d = new j1.a(this, this.f11196f, jVar.a(), b6.f11185h + b6.f11186i, b6.f11180c, (b6.f11179b & 4) != 0);
        }
        this.f11200j = null;
        this.f11198h = 2;
        this.f11191a.f();
        return 0;
    }

    private int i(c1.j jVar, w wVar) {
        long b6 = this.f11194d.b(jVar);
        if (b6 >= 0) {
            wVar.f3247a = b6;
            return 1;
        }
        if (b6 < -1) {
            d(-(b6 + 2));
        }
        if (!this.f11202l) {
            this.f11193c.r((x) com.google.android.exoplayer2.util.a.i(this.f11194d.a()));
            this.f11202l = true;
        }
        if (this.f11201k <= 0 && !this.f11191a.d(jVar)) {
            this.f11198h = 3;
            return -1;
        }
        this.f11201k = 0L;
        y c6 = this.f11191a.c();
        long e6 = e(c6);
        if (e6 >= 0) {
            long j6 = this.f11197g;
            if (j6 + e6 >= this.f11195e) {
                long a6 = a(j6);
                this.f11192b.a(c6, c6.e());
                this.f11192b.d(a6, 1, c6.e(), 0, null);
                this.f11195e = -1L;
            }
        }
        this.f11197g += e6;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long a(long j6) {
        return (j6 * 1000000) / this.f11199i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long b(long j6) {
        return (this.f11199i * j6) / 1000000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(k kVar, a0 a0Var) {
        this.f11193c = kVar;
        this.f11192b = a0Var;
        j(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(long j6) {
        this.f11197g = j6;
    }

    protected abstract long e(y yVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int f(c1.j jVar, w wVar) {
        int i6 = this.f11198h;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 == 2) {
                    return i(jVar, wVar);
                }
                throw new IllegalStateException();
            }
            jVar.h((int) this.f11196f);
            this.f11198h = 2;
            return 0;
        }
        return g(jVar);
    }

    protected abstract boolean h(y yVar, long j6, b bVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(boolean z5) {
        int i6;
        if (z5) {
            this.f11200j = new b();
            this.f11196f = 0L;
            i6 = 0;
        } else {
            i6 = 1;
        }
        this.f11198h = i6;
        this.f11195e = -1L;
        this.f11197g = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(long j6, long j7) {
        this.f11191a.e();
        if (j6 == 0) {
            j(!this.f11202l);
        } else if (this.f11198h != 0) {
            long b6 = b(j7);
            this.f11195e = b6;
            this.f11194d.c(b6);
            this.f11198h = 2;
        }
    }
}
