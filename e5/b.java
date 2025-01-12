package e5;

import java.util.List;
/* loaded from: classes.dex */
public abstract class b extends o {

    /* renamed from: b  reason: collision with root package name */
    private int f9551b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f9552c;

    /* renamed from: d  reason: collision with root package name */
    private f5.d f9553d;

    /* renamed from: e  reason: collision with root package name */
    private long f9554e;

    /* renamed from: i  reason: collision with root package name */
    private int f9558i;

    /* renamed from: j  reason: collision with root package name */
    private int f9559j;

    /* renamed from: k  reason: collision with root package name */
    private String f9560k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9561l;

    /* renamed from: n  reason: collision with root package name */
    private boolean f9563n;

    /* renamed from: o  reason: collision with root package name */
    private n f9564o;

    /* renamed from: p  reason: collision with root package name */
    private a f9565p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f9566q;

    /* renamed from: r  reason: collision with root package name */
    private List f9567r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f9568s;

    /* renamed from: f  reason: collision with root package name */
    private long f9555f = 0;

    /* renamed from: g  reason: collision with root package name */
    private long f9556g = 0;

    /* renamed from: h  reason: collision with root package name */
    private long f9557h = 0;

    /* renamed from: m  reason: collision with root package name */
    private f5.e f9562m = f5.e.NONE;

    public void A(f5.e eVar) {
        this.f9562m = eVar;
    }

    public void B(List list) {
        this.f9567r = list;
    }

    public void C(int i6) {
        this.f9559j = i6;
    }

    public void D(String str) {
        this.f9560k = str;
    }

    public void E(int i6) {
        this.f9558i = i6;
    }

    public void F(boolean z5) {
        this.f9566q = z5;
    }

    public void G(byte[] bArr) {
        this.f9552c = bArr;
    }

    public void H(long j6) {
        this.f9554e = j6;
    }

    public void I(long j6) {
        this.f9557h = j6;
    }

    public void J(int i6) {
        this.f9551b = i6;
    }

    public void K(n nVar) {
        this.f9564o = nVar;
    }

    public a c() {
        return this.f9565p;
    }

    public long d() {
        return this.f9556g;
    }

    public f5.d e() {
        return this.f9553d;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            return j().equals(((b) obj).j());
        }
        return false;
    }

    public long f() {
        return this.f9555f;
    }

    public f5.e g() {
        return this.f9562m;
    }

    public List h() {
        return this.f9567r;
    }

    public int i() {
        return this.f9559j;
    }

    public String j() {
        return this.f9560k;
    }

    public int k() {
        return this.f9558i;
    }

    public byte[] l() {
        return this.f9552c;
    }

    public long m() {
        return this.f9554e;
    }

    public long n() {
        return this.f9557h;
    }

    public int o() {
        return this.f9551b;
    }

    public n p() {
        return this.f9564o;
    }

    public boolean q() {
        return this.f9563n;
    }

    public boolean r() {
        return this.f9561l;
    }

    public boolean s() {
        return this.f9566q;
    }

    public void t(a aVar) {
        this.f9565p = aVar;
    }

    public void u(long j6) {
        this.f9556g = j6;
    }

    public void v(f5.d dVar) {
        this.f9553d = dVar;
    }

    public void w(long j6) {
        this.f9555f = j6;
    }

    public void x(boolean z5) {
        this.f9563n = z5;
    }

    public void y(boolean z5) {
        this.f9568s = z5;
    }

    public void z(boolean z5) {
        this.f9561l = z5;
    }
}
