package e1;

import android.net.Uri;
import c1.a0;
import c1.i;
import c1.j;
import c1.k;
import c1.n;
import c1.o;
import c1.p;
import c1.q;
import c1.r;
import c1.s;
import c1.w;
import c1.x;
import com.google.android.exoplayer2.util.s0;
import com.google.android.exoplayer2.util.y;
import java.util.Map;
/* loaded from: classes.dex */
public final class d implements i {

    /* renamed from: o  reason: collision with root package name */
    public static final o f9413o = new o() { // from class: e1.c
        @Override // c1.o
        public final i[] a() {
            i[] k6;
            k6 = d.k();
            return k6;
        }

        @Override // c1.o
        public /* synthetic */ i[] b(Uri uri, Map map) {
            return n.a(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f9414a;

    /* renamed from: b  reason: collision with root package name */
    private final y f9415b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9416c;

    /* renamed from: d  reason: collision with root package name */
    private final p.a f9417d;

    /* renamed from: e  reason: collision with root package name */
    private k f9418e;

    /* renamed from: f  reason: collision with root package name */
    private a0 f9419f;

    /* renamed from: g  reason: collision with root package name */
    private int f9420g;

    /* renamed from: h  reason: collision with root package name */
    private n1.a f9421h;

    /* renamed from: i  reason: collision with root package name */
    private s f9422i;

    /* renamed from: j  reason: collision with root package name */
    private int f9423j;

    /* renamed from: k  reason: collision with root package name */
    private int f9424k;

    /* renamed from: l  reason: collision with root package name */
    private b f9425l;

    /* renamed from: m  reason: collision with root package name */
    private int f9426m;

    /* renamed from: n  reason: collision with root package name */
    private long f9427n;

    public d() {
        this(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
        r5.M(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0027, code lost:
        return r4.f9417d.f3221a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long e(y yVar, boolean z5) {
        boolean z6;
        com.google.android.exoplayer2.util.a.e(this.f9422i);
        int d6 = yVar.d();
        while (true) {
            if (d6 > yVar.e() - 16) {
                if (!z5) {
                    yVar.M(d6);
                    return -1L;
                }
                while (d6 <= yVar.e() - this.f9423j) {
                    yVar.M(d6);
                    try {
                        z6 = p.d(yVar, this.f9422i, this.f9424k, this.f9417d);
                    } catch (IndexOutOfBoundsException unused) {
                        z6 = false;
                    }
                    if (!(yVar.d() <= yVar.e() ? z6 : false)) {
                        d6++;
                    }
                }
                yVar.M(yVar.e());
                return -1L;
            }
            yVar.M(d6);
            if (p.d(yVar, this.f9422i, this.f9424k, this.f9417d)) {
                break;
            }
            d6++;
        }
    }

    private void f(j jVar) {
        this.f9424k = q.b(jVar);
        ((k) s0.j(this.f9418e)).r(i(jVar.p(), jVar.a()));
        this.f9420g = 5;
    }

    private x i(long j6, long j7) {
        com.google.android.exoplayer2.util.a.e(this.f9422i);
        s sVar = this.f9422i;
        if (sVar.f3235k != null) {
            return new r(sVar, j6);
        }
        if (j7 == -1 || sVar.f3234j <= 0) {
            return new x.b(sVar.g());
        }
        b bVar = new b(sVar, this.f9424k, j6, j7);
        this.f9425l = bVar;
        return bVar.b();
    }

    private void j(j jVar) {
        byte[] bArr = this.f9414a;
        jVar.n(bArr, 0, bArr.length);
        jVar.g();
        this.f9420g = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i[] k() {
        return new i[]{new d()};
    }

    private void l() {
        ((a0) s0.j(this.f9419f)).d((this.f9427n * 1000000) / ((s) s0.j(this.f9422i)).f3229e, 1, this.f9426m, 0, null);
    }

    private int m(j jVar, w wVar) {
        boolean z5;
        com.google.android.exoplayer2.util.a.e(this.f9419f);
        com.google.android.exoplayer2.util.a.e(this.f9422i);
        b bVar = this.f9425l;
        if (bVar == null || !bVar.d()) {
            if (this.f9427n == -1) {
                this.f9427n = p.i(jVar, this.f9422i);
                return 0;
            }
            int e6 = this.f9415b.e();
            if (e6 < 32768) {
                int read = jVar.read(this.f9415b.c(), e6, 32768 - e6);
                z5 = read == -1;
                if (!z5) {
                    this.f9415b.L(e6 + read);
                } else if (this.f9415b.a() == 0) {
                    l();
                    return -1;
                }
            } else {
                z5 = false;
            }
            int d6 = this.f9415b.d();
            int i6 = this.f9426m;
            int i7 = this.f9423j;
            if (i6 < i7) {
                y yVar = this.f9415b;
                yVar.N(Math.min(i7 - i6, yVar.a()));
            }
            long e7 = e(this.f9415b, z5);
            int d7 = this.f9415b.d() - d6;
            this.f9415b.M(d6);
            this.f9419f.a(this.f9415b, d7);
            this.f9426m += d7;
            if (e7 != -1) {
                l();
                this.f9426m = 0;
                this.f9427n = e7;
            }
            if (this.f9415b.a() < 16) {
                System.arraycopy(this.f9415b.c(), this.f9415b.d(), this.f9415b.c(), 0, this.f9415b.a());
                y yVar2 = this.f9415b;
                yVar2.I(yVar2.a());
            }
            return 0;
        }
        return this.f9425l.c(jVar, wVar);
    }

    private void n(j jVar) {
        this.f9421h = q.d(jVar, !this.f9416c);
        this.f9420g = 1;
    }

    private void o(j jVar) {
        q.a aVar = new q.a(this.f9422i);
        boolean z5 = false;
        while (!z5) {
            z5 = q.e(jVar, aVar);
            this.f9422i = (s) s0.j(aVar.f3222a);
        }
        com.google.android.exoplayer2.util.a.e(this.f9422i);
        this.f9423j = Math.max(this.f9422i.f3227c, 6);
        ((a0) s0.j(this.f9419f)).e(this.f9422i.h(this.f9414a, this.f9421h));
        this.f9420g = 4;
    }

    private void p(j jVar) {
        q.j(jVar);
        this.f9420g = 3;
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(k kVar) {
        this.f9418e = kVar;
        this.f9419f = kVar.e(0, 1);
        kVar.g();
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        if (j6 == 0) {
            this.f9420g = 0;
        } else {
            b bVar = this.f9425l;
            if (bVar != null) {
                bVar.h(j7);
            }
        }
        this.f9427n = j7 != 0 ? -1L : 0L;
        this.f9426m = 0;
        this.f9415b.I(0);
    }

    @Override // c1.i
    public int g(j jVar, w wVar) {
        int i6 = this.f9420g;
        if (i6 == 0) {
            n(jVar);
            return 0;
        } else if (i6 == 1) {
            j(jVar);
            return 0;
        } else if (i6 == 2) {
            p(jVar);
            return 0;
        } else if (i6 == 3) {
            o(jVar);
            return 0;
        } else if (i6 == 4) {
            f(jVar);
            return 0;
        } else if (i6 == 5) {
            return m(jVar, wVar);
        } else {
            throw new IllegalStateException();
        }
    }

    @Override // c1.i
    public boolean h(j jVar) {
        q.c(jVar, false);
        return q.a(jVar);
    }

    public d(int i6) {
        this.f9414a = new byte[42];
        this.f9415b = new y(new byte[32768], 0);
        this.f9416c = (i6 & 1) != 0;
        this.f9417d = new p.a();
        this.f9420g = 0;
    }
}
