package f1;

import android.net.Uri;
import c1.i;
import c1.j;
import c1.k;
import c1.n;
import c1.o;
import c1.v;
import c1.w;
import c1.x;
import com.google.android.exoplayer2.util.y;
import java.util.Map;
/* loaded from: classes.dex */
public final class c implements i {

    /* renamed from: q  reason: collision with root package name */
    public static final o f9770q = new o() { // from class: f1.b
        @Override // c1.o
        public final i[] a() {
            i[] i6;
            i6 = c.i();
            return i6;
        }

        @Override // c1.o
        public /* synthetic */ i[] b(Uri uri, Map map) {
            return n.a(this, uri, map);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private k f9776f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9778h;

    /* renamed from: i  reason: collision with root package name */
    private long f9779i;

    /* renamed from: j  reason: collision with root package name */
    private int f9780j;

    /* renamed from: k  reason: collision with root package name */
    private int f9781k;

    /* renamed from: l  reason: collision with root package name */
    private int f9782l;

    /* renamed from: m  reason: collision with root package name */
    private long f9783m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f9784n;

    /* renamed from: o  reason: collision with root package name */
    private a f9785o;

    /* renamed from: p  reason: collision with root package name */
    private f f9786p;

    /* renamed from: a  reason: collision with root package name */
    private final y f9771a = new y(4);

    /* renamed from: b  reason: collision with root package name */
    private final y f9772b = new y(9);

    /* renamed from: c  reason: collision with root package name */
    private final y f9773c = new y(11);

    /* renamed from: d  reason: collision with root package name */
    private final y f9774d = new y();

    /* renamed from: e  reason: collision with root package name */
    private final d f9775e = new d();

    /* renamed from: g  reason: collision with root package name */
    private int f9777g = 1;

    private void e() {
        if (this.f9784n) {
            return;
        }
        this.f9776f.r(new x.b(-9223372036854775807L));
        this.f9784n = true;
    }

    private long f() {
        if (this.f9778h) {
            return this.f9779i + this.f9783m;
        }
        if (this.f9775e.d() == -9223372036854775807L) {
            return 0L;
        }
        return this.f9783m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i[] i() {
        return new i[]{new c()};
    }

    private y j(j jVar) {
        if (this.f9782l > this.f9774d.b()) {
            y yVar = this.f9774d;
            yVar.K(new byte[Math.max(yVar.b() * 2, this.f9782l)], 0);
        } else {
            this.f9774d.M(0);
        }
        this.f9774d.L(this.f9782l);
        jVar.readFully(this.f9774d.c(), 0, this.f9782l);
        return this.f9774d;
    }

    private boolean k(j jVar) {
        if (jVar.d(this.f9772b.c(), 0, 9, true)) {
            this.f9772b.M(0);
            this.f9772b.N(4);
            int A = this.f9772b.A();
            boolean z5 = (A & 4) != 0;
            boolean z6 = (A & 1) != 0;
            if (z5 && this.f9785o == null) {
                this.f9785o = new a(this.f9776f.e(8, 1));
            }
            if (z6 && this.f9786p == null) {
                this.f9786p = new f(this.f9776f.e(9, 2));
            }
            this.f9776f.g();
            this.f9780j = (this.f9772b.k() - 9) + 4;
            this.f9777g = 2;
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0071 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean l(j jVar) {
        boolean z5;
        boolean z6;
        e eVar;
        long f6 = f();
        int i6 = this.f9781k;
        if (i6 == 8 && this.f9785o != null) {
            e();
            eVar = this.f9785o;
        } else if (i6 != 9 || this.f9786p == null) {
            if (i6 != 18 || this.f9784n) {
                jVar.h(this.f9782l);
                z5 = false;
                z6 = false;
                if (!this.f9778h && z5) {
                    this.f9778h = true;
                    this.f9779i = this.f9775e.d() != -9223372036854775807L ? -this.f9783m : 0L;
                }
                this.f9780j = 4;
                this.f9777g = 2;
                return z6;
            }
            z5 = this.f9775e.a(j(jVar), f6);
            long d6 = this.f9775e.d();
            if (d6 != -9223372036854775807L) {
                this.f9776f.r(new v(this.f9775e.e(), this.f9775e.f(), d6));
                this.f9784n = true;
            }
            z6 = true;
            if (!this.f9778h) {
                this.f9778h = true;
                this.f9779i = this.f9775e.d() != -9223372036854775807L ? -this.f9783m : 0L;
            }
            this.f9780j = 4;
            this.f9777g = 2;
            return z6;
        } else {
            e();
            eVar = this.f9786p;
        }
        z5 = eVar.a(j(jVar), f6);
        z6 = true;
        if (!this.f9778h) {
        }
        this.f9780j = 4;
        this.f9777g = 2;
        return z6;
    }

    private boolean m(j jVar) {
        if (jVar.d(this.f9773c.c(), 0, 11, true)) {
            this.f9773c.M(0);
            this.f9781k = this.f9773c.A();
            this.f9782l = this.f9773c.D();
            this.f9783m = this.f9773c.D();
            this.f9783m = ((this.f9773c.A() << 24) | this.f9783m) * 1000;
            this.f9773c.N(3);
            this.f9777g = 4;
            return true;
        }
        return false;
    }

    private void n(j jVar) {
        jVar.h(this.f9780j);
        this.f9780j = 0;
        this.f9777g = 3;
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(k kVar) {
        this.f9776f = kVar;
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        if (j6 == 0) {
            this.f9777g = 1;
            this.f9778h = false;
        } else {
            this.f9777g = 3;
        }
        this.f9780j = 0;
    }

    @Override // c1.i
    public int g(j jVar, w wVar) {
        com.google.android.exoplayer2.util.a.i(this.f9776f);
        while (true) {
            int i6 = this.f9777g;
            if (i6 != 1) {
                if (i6 == 2) {
                    n(jVar);
                } else if (i6 != 3) {
                    if (i6 != 4) {
                        throw new IllegalStateException();
                    }
                    if (l(jVar)) {
                        return 0;
                    }
                } else if (!m(jVar)) {
                    return -1;
                }
            } else if (!k(jVar)) {
                return -1;
            }
        }
    }

    @Override // c1.i
    public boolean h(j jVar) {
        jVar.n(this.f9771a.c(), 0, 3);
        this.f9771a.M(0);
        if (this.f9771a.D() != 4607062) {
            return false;
        }
        jVar.n(this.f9771a.c(), 0, 2);
        this.f9771a.M(0);
        if ((this.f9771a.G() & 250) != 0) {
            return false;
        }
        jVar.n(this.f9771a.c(), 0, 4);
        this.f9771a.M(0);
        int k6 = this.f9771a.k();
        jVar.g();
        jVar.o(k6);
        jVar.n(this.f9771a.c(), 0, 4);
        this.f9771a.M(0);
        return this.f9771a.k() == 0;
    }
}
