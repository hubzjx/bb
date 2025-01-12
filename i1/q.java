package i1;

import com.google.android.exoplayer2.util.y;
/* loaded from: classes.dex */
final class q {

    /* renamed from: a  reason: collision with root package name */
    public c f11002a;

    /* renamed from: b  reason: collision with root package name */
    public long f11003b;

    /* renamed from: c  reason: collision with root package name */
    public long f11004c;

    /* renamed from: d  reason: collision with root package name */
    public long f11005d;

    /* renamed from: e  reason: collision with root package name */
    public int f11006e;

    /* renamed from: f  reason: collision with root package name */
    public int f11007f;

    /* renamed from: m  reason: collision with root package name */
    public boolean f11014m;

    /* renamed from: o  reason: collision with root package name */
    public p f11016o;

    /* renamed from: q  reason: collision with root package name */
    public boolean f11018q;

    /* renamed from: r  reason: collision with root package name */
    public long f11019r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f11020s;

    /* renamed from: g  reason: collision with root package name */
    public long[] f11008g = new long[0];

    /* renamed from: h  reason: collision with root package name */
    public int[] f11009h = new int[0];

    /* renamed from: i  reason: collision with root package name */
    public int[] f11010i = new int[0];

    /* renamed from: j  reason: collision with root package name */
    public int[] f11011j = new int[0];

    /* renamed from: k  reason: collision with root package name */
    public long[] f11012k = new long[0];

    /* renamed from: l  reason: collision with root package name */
    public boolean[] f11013l = new boolean[0];

    /* renamed from: n  reason: collision with root package name */
    public boolean[] f11015n = new boolean[0];

    /* renamed from: p  reason: collision with root package name */
    public final y f11017p = new y();

    public void a(c1.j jVar) {
        jVar.readFully(this.f11017p.c(), 0, this.f11017p.e());
        this.f11017p.M(0);
        this.f11018q = false;
    }

    public void b(y yVar) {
        yVar.i(this.f11017p.c(), 0, this.f11017p.e());
        this.f11017p.M(0);
        this.f11018q = false;
    }

    public long c(int i6) {
        return this.f11012k[i6] + this.f11011j[i6];
    }

    public void d(int i6) {
        this.f11017p.I(i6);
        this.f11014m = true;
        this.f11018q = true;
    }

    public void e(int i6, int i7) {
        this.f11006e = i6;
        this.f11007f = i7;
        if (this.f11009h.length < i6) {
            this.f11008g = new long[i6];
            this.f11009h = new int[i6];
        }
        if (this.f11010i.length < i7) {
            int i8 = (i7 * 125) / 100;
            this.f11010i = new int[i8];
            this.f11011j = new int[i8];
            this.f11012k = new long[i8];
            this.f11013l = new boolean[i8];
            this.f11015n = new boolean[i8];
        }
    }

    public void f() {
        this.f11006e = 0;
        this.f11019r = 0L;
        this.f11020s = false;
        this.f11014m = false;
        this.f11018q = false;
        this.f11016o = null;
    }

    public boolean g(int i6) {
        return this.f11014m && this.f11015n[i6];
    }
}
