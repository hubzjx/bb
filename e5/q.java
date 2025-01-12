package e5;
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private f5.d f9623a;

    /* renamed from: b  reason: collision with root package name */
    private f5.c f9624b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9625c;

    /* renamed from: d  reason: collision with root package name */
    private f5.e f9626d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9627e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9628f;

    /* renamed from: g  reason: collision with root package name */
    private f5.a f9629g;

    /* renamed from: h  reason: collision with root package name */
    private f5.b f9630h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9631i;

    /* renamed from: j  reason: collision with root package name */
    private long f9632j;

    /* renamed from: k  reason: collision with root package name */
    private String f9633k;

    /* renamed from: l  reason: collision with root package name */
    private String f9634l;

    /* renamed from: m  reason: collision with root package name */
    private long f9635m;

    /* renamed from: n  reason: collision with root package name */
    private long f9636n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9637o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f9638p;

    /* renamed from: q  reason: collision with root package name */
    private String f9639q;

    /* renamed from: r  reason: collision with root package name */
    private String f9640r;

    /* renamed from: s  reason: collision with root package name */
    private a f9641s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f9642t;

    /* loaded from: classes.dex */
    public enum a {
        INCLUDE_LINK_ONLY,
        INCLUDE_LINKED_FILE_ONLY,
        INCLUDE_LINK_AND_LINKED_FILE
    }

    public q() {
        this.f9623a = f5.d.DEFLATE;
        this.f9624b = f5.c.NORMAL;
        this.f9625c = false;
        this.f9626d = f5.e.NONE;
        this.f9627e = true;
        this.f9628f = true;
        this.f9629g = f5.a.KEY_STRENGTH_256;
        this.f9630h = f5.b.TWO;
        this.f9631i = true;
        this.f9635m = System.currentTimeMillis();
        this.f9636n = -1L;
        this.f9637o = true;
        this.f9638p = true;
        this.f9641s = a.INCLUDE_LINKED_FILE_ONLY;
    }

    public void A(long j6) {
        this.f9636n = j6;
    }

    public void B(String str) {
        this.f9634l = str;
    }

    public void C(long j6) {
        if (j6 <= 0) {
            return;
        }
        this.f9635m = j6;
    }

    public void D(boolean z5) {
        this.f9637o = z5;
    }

    public f5.a a() {
        return this.f9629g;
    }

    public f5.b b() {
        return this.f9630h;
    }

    public f5.c c() {
        return this.f9624b;
    }

    public Object clone() {
        return super.clone();
    }

    public f5.d d() {
        return this.f9623a;
    }

    public String e() {
        return this.f9633k;
    }

    public f5.e f() {
        return this.f9626d;
    }

    public long g() {
        return this.f9632j;
    }

    public long h() {
        return this.f9636n;
    }

    public g i() {
        return null;
    }

    public String j() {
        return this.f9640r;
    }

    public String k() {
        return this.f9634l;
    }

    public long l() {
        return this.f9635m;
    }

    public String m() {
        return this.f9639q;
    }

    public a n() {
        return this.f9641s;
    }

    public boolean o() {
        return this.f9625c;
    }

    public boolean p() {
        return this.f9631i;
    }

    public boolean q() {
        return this.f9638p;
    }

    public boolean r() {
        return this.f9627e;
    }

    public boolean s() {
        return this.f9628f;
    }

    public boolean t() {
        return this.f9642t;
    }

    public boolean u() {
        return this.f9637o;
    }

    public void v(f5.c cVar) {
        this.f9624b = cVar;
    }

    public void w(f5.d dVar) {
        this.f9623a = dVar;
    }

    public void x(boolean z5) {
        this.f9625c = z5;
    }

    public void y(f5.e eVar) {
        this.f9626d = eVar;
    }

    public void z(long j6) {
        this.f9632j = j6;
    }

    public q(q qVar) {
        this.f9623a = f5.d.DEFLATE;
        this.f9624b = f5.c.NORMAL;
        this.f9625c = false;
        this.f9626d = f5.e.NONE;
        this.f9627e = true;
        this.f9628f = true;
        this.f9629g = f5.a.KEY_STRENGTH_256;
        this.f9630h = f5.b.TWO;
        this.f9631i = true;
        this.f9635m = System.currentTimeMillis();
        this.f9636n = -1L;
        this.f9637o = true;
        this.f9638p = true;
        this.f9641s = a.INCLUDE_LINKED_FILE_ONLY;
        this.f9623a = qVar.d();
        this.f9624b = qVar.c();
        this.f9625c = qVar.o();
        this.f9626d = qVar.f();
        this.f9627e = qVar.r();
        this.f9628f = qVar.s();
        this.f9629g = qVar.a();
        this.f9630h = qVar.b();
        this.f9631i = qVar.p();
        this.f9632j = qVar.g();
        this.f9633k = qVar.e();
        this.f9634l = qVar.k();
        this.f9635m = qVar.l();
        this.f9636n = qVar.h();
        this.f9637o = qVar.u();
        this.f9638p = qVar.q();
        this.f9639q = qVar.m();
        this.f9640r = qVar.j();
        this.f9641s = qVar.n();
        qVar.i();
        this.f9642t = qVar.t();
    }
}
