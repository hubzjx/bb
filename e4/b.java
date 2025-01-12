package e4;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f9511a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9512b = false;

    /* renamed from: c  reason: collision with root package name */
    private float f9513c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    private int f9514d = 51;

    /* renamed from: e  reason: collision with root package name */
    private int f9515e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f9516f;

    /* renamed from: g  reason: collision with root package name */
    private int f9517g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9518h;

    /* renamed from: i  reason: collision with root package name */
    private int f9519i;

    /* renamed from: j  reason: collision with root package name */
    private int f9520j;

    public b() {
        r(0);
        l(false);
        s(0.0f);
        m(0);
        o(0);
        k(true);
    }

    public int a() {
        return this.f9514d;
    }

    public int b() {
        return this.f9515e;
    }

    public int c() {
        return this.f9511a == 0 ? this.f9519i : this.f9520j;
    }

    public int d() {
        return this.f9511a == 0 ? this.f9516f : this.f9517g;
    }

    public int e() {
        return this.f9511a == 0 ? this.f9517g : this.f9516f;
    }

    public int f() {
        return this.f9511a;
    }

    public int g() {
        return this.f9511a == 0 ? this.f9520j : this.f9519i;
    }

    public float h() {
        return this.f9513c;
    }

    public boolean i() {
        return this.f9518h;
    }

    public boolean j() {
        return this.f9512b;
    }

    public void k(boolean z5) {
        this.f9518h = z5;
    }

    public void l(boolean z5) {
        this.f9512b = z5;
    }

    public void m(int i6) {
        this.f9514d = i6;
    }

    public void n(int i6) {
        this.f9520j = i6;
    }

    public void o(int i6) {
        if (i6 != 1) {
            i6 = 0;
        }
        this.f9515e = i6;
    }

    public void p(int i6) {
        this.f9517g = i6;
    }

    public void q(int i6) {
        this.f9516f = i6;
    }

    public void r(int i6) {
        if (i6 != 1) {
            i6 = 0;
        }
        this.f9511a = i6;
    }

    public void s(float f6) {
        this.f9513c = Math.max(0.0f, f6);
    }

    public void t(int i6) {
        this.f9519i = i6;
    }
}
