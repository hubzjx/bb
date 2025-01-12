package l1;

import android.net.Uri;
import c1.x;
import com.google.android.exoplayer2.f1;
import java.io.EOFException;
import java.util.Map;
import l1.i0;
/* loaded from: classes.dex */
public final class h implements c1.i {

    /* renamed from: m  reason: collision with root package name */
    public static final c1.o f11492m = new c1.o() { // from class: l1.g
        @Override // c1.o
        public final c1.i[] a() {
            c1.i[] j6;
            j6 = h.j();
            return j6;
        }

        @Override // c1.o
        public /* synthetic */ c1.i[] b(Uri uri, Map map) {
            return c1.n.a(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f11493a;

    /* renamed from: b  reason: collision with root package name */
    private final i f11494b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11495c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11496d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.x f11497e;

    /* renamed from: f  reason: collision with root package name */
    private c1.k f11498f;

    /* renamed from: g  reason: collision with root package name */
    private long f11499g;

    /* renamed from: h  reason: collision with root package name */
    private long f11500h;

    /* renamed from: i  reason: collision with root package name */
    private int f11501i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11502j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11503k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11504l;

    public h() {
        this(0);
    }

    private void e(c1.j jVar) {
        int h6;
        if (this.f11502j) {
            return;
        }
        this.f11501i = -1;
        jVar.g();
        long j6 = 0;
        if (jVar.p() == 0) {
            l(jVar);
        }
        int i6 = 0;
        int i7 = 0;
        do {
            try {
                if (!jVar.l(this.f11496d.c(), 0, 2, true)) {
                    break;
                }
                this.f11496d.M(0);
                if (!i.m(this.f11496d.G())) {
                    break;
                } else if (!jVar.l(this.f11496d.c(), 0, 4, true)) {
                    break;
                } else {
                    this.f11497e.p(14);
                    h6 = this.f11497e.h(13);
                    if (h6 <= 6) {
                        this.f11502j = true;
                        throw new f1("Malformed ADTS stream");
                    }
                    j6 += h6;
                    i7++;
                    if (i7 == 1000) {
                        break;
                    }
                }
            } catch (EOFException unused) {
            }
        } while (jVar.j(h6 - 6, true));
        i6 = i7;
        jVar.g();
        if (i6 > 0) {
            this.f11501i = (int) (j6 / i6);
        } else {
            this.f11501i = -1;
        }
        this.f11502j = true;
    }

    private static int f(int i6, long j6) {
        return (int) (((i6 * 8) * 1000000) / j6);
    }

    private c1.x i(long j6) {
        return new c1.e(j6, this.f11500h, f(this.f11501i, this.f11494b.k()), this.f11501i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c1.i[] j() {
        return new c1.i[]{new h()};
    }

    private void k(long j6, boolean z5, boolean z6) {
        if (this.f11504l) {
            return;
        }
        boolean z7 = z5 && this.f11501i > 0;
        if (z7 && this.f11494b.k() == -9223372036854775807L && !z6) {
            return;
        }
        if (!z7 || this.f11494b.k() == -9223372036854775807L) {
            this.f11498f.r(new x.b(-9223372036854775807L));
        } else {
            this.f11498f.r(i(j6));
        }
        this.f11504l = true;
    }

    private int l(c1.j jVar) {
        int i6 = 0;
        while (true) {
            jVar.n(this.f11496d.c(), 0, 10);
            this.f11496d.M(0);
            if (this.f11496d.D() != 4801587) {
                break;
            }
            this.f11496d.N(3);
            int z5 = this.f11496d.z();
            i6 += z5 + 10;
            jVar.o(z5);
        }
        jVar.g();
        jVar.o(i6);
        if (this.f11500h == -1) {
            this.f11500h = i6;
        }
        return i6;
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(c1.k kVar) {
        this.f11498f = kVar;
        this.f11494b.f(kVar, new i0.d(0, 1));
        kVar.g();
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        this.f11503k = false;
        this.f11494b.a();
        this.f11499g = j7;
    }

    @Override // c1.i
    public int g(c1.j jVar, c1.w wVar) {
        com.google.android.exoplayer2.util.a.i(this.f11498f);
        long a6 = jVar.a();
        boolean z5 = ((this.f11493a & 1) == 0 || a6 == -1) ? false : true;
        if (z5) {
            e(jVar);
        }
        int read = jVar.read(this.f11495c.c(), 0, 2048);
        boolean z6 = read == -1;
        k(a6, z5, z6);
        if (z6) {
            return -1;
        }
        this.f11495c.M(0);
        this.f11495c.L(read);
        if (!this.f11503k) {
            this.f11494b.e(this.f11499g, 4);
            this.f11503k = true;
        }
        this.f11494b.c(this.f11495c);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
        r9.g();
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
        if ((r3 - r0) < 8192) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
        return false;
     */
    @Override // c1.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean h(c1.j jVar) {
        int l6 = l(jVar);
        int i6 = l6;
        while (true) {
            int i7 = 0;
            int i8 = 0;
            while (true) {
                jVar.n(this.f11496d.c(), 0, 2);
                this.f11496d.M(0);
                if (!i.m(this.f11496d.G())) {
                    break;
                }
                i7++;
                if (i7 >= 4 && i8 > 188) {
                    return true;
                }
                jVar.n(this.f11496d.c(), 0, 4);
                this.f11497e.p(14);
                int h6 = this.f11497e.h(13);
                if (h6 <= 6) {
                    return false;
                }
                jVar.o(h6 - 6);
                i8 += h6;
            }
            jVar.o(i6);
        }
    }

    public h(int i6) {
        this.f11493a = i6;
        this.f11494b = new i(true);
        this.f11495c = new com.google.android.exoplayer2.util.y(2048);
        this.f11501i = -1;
        this.f11500h = -1L;
        com.google.android.exoplayer2.util.y yVar = new com.google.android.exoplayer2.util.y(10);
        this.f11496d = yVar;
        this.f11497e = new com.google.android.exoplayer2.util.x(yVar.c());
    }
}
