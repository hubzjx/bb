package d1;

import android.net.Uri;
import c1.a0;
import c1.e;
import c1.i;
import c1.j;
import c1.k;
import c1.n;
import c1.o;
import c1.w;
import c1.x;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.s0;
import java.io.EOFException;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes.dex */
public final class b implements i {

    /* renamed from: r  reason: collision with root package name */
    private static final int[] f9118r;

    /* renamed from: u  reason: collision with root package name */
    private static final int f9121u;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f9122a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9123b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9124c;

    /* renamed from: d  reason: collision with root package name */
    private long f9125d;

    /* renamed from: e  reason: collision with root package name */
    private int f9126e;

    /* renamed from: f  reason: collision with root package name */
    private int f9127f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9128g;

    /* renamed from: h  reason: collision with root package name */
    private long f9129h;

    /* renamed from: i  reason: collision with root package name */
    private int f9130i;

    /* renamed from: j  reason: collision with root package name */
    private int f9131j;

    /* renamed from: k  reason: collision with root package name */
    private long f9132k;

    /* renamed from: l  reason: collision with root package name */
    private k f9133l;

    /* renamed from: m  reason: collision with root package name */
    private a0 f9134m;

    /* renamed from: n  reason: collision with root package name */
    private x f9135n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9136o;

    /* renamed from: p  reason: collision with root package name */
    public static final o f9116p = new o() { // from class: d1.a
        @Override // c1.o
        public final i[] a() {
            i[] n5;
            n5 = b.n();
            return n5;
        }

        @Override // c1.o
        public /* synthetic */ i[] b(Uri uri, Map map) {
            return n.a(this, uri, map);
        }
    };

    /* renamed from: q  reason: collision with root package name */
    private static final int[] f9117q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: s  reason: collision with root package name */
    private static final byte[] f9119s = s0.h0("#!AMR\n");

    /* renamed from: t  reason: collision with root package name */
    private static final byte[] f9120t = s0.h0("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f9118r = iArr;
        f9121u = iArr[8];
    }

    public b() {
        this(0);
    }

    private void e() {
        com.google.android.exoplayer2.util.a.i(this.f9134m);
        s0.j(this.f9133l);
    }

    private static int f(int i6, long j6) {
        return (int) (((i6 * 8) * 1000000) / j6);
    }

    private x i(long j6) {
        return new e(j6, this.f9129h, f(this.f9130i, 20000L), this.f9130i);
    }

    private int j(int i6) {
        if (l(i6)) {
            return this.f9124c ? f9118r[i6] : f9117q[i6];
        }
        String str = this.f9124c ? "WB" : "NB";
        StringBuilder sb = new StringBuilder(str.length() + 35);
        sb.append("Illegal AMR ");
        sb.append(str);
        sb.append(" frame type ");
        sb.append(i6);
        throw new f1(sb.toString());
    }

    private boolean k(int i6) {
        return !this.f9124c && (i6 < 12 || i6 > 14);
    }

    private boolean l(int i6) {
        return i6 >= 0 && i6 <= 15 && (m(i6) || k(i6));
    }

    private boolean m(int i6) {
        return this.f9124c && (i6 < 10 || i6 > 13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i[] n() {
        return new i[]{new b()};
    }

    private void o() {
        if (this.f9136o) {
            return;
        }
        this.f9136o = true;
        boolean z5 = this.f9124c;
        this.f9134m.e(new s0.b().e0(z5 ? "audio/amr-wb" : "audio/3gpp").W(f9121u).H(1).f0(z5 ? 16000 : 8000).E());
    }

    private void p(long j6, int i6) {
        x bVar;
        int i7;
        if (this.f9128g) {
            return;
        }
        if ((this.f9123b & 1) == 0 || j6 == -1 || !((i7 = this.f9130i) == -1 || i7 == this.f9126e)) {
            bVar = new x.b(-9223372036854775807L);
        } else if (this.f9131j < 20 && i6 != -1) {
            return;
        } else {
            bVar = i(j6);
        }
        this.f9135n = bVar;
        this.f9133l.r(bVar);
        this.f9128g = true;
    }

    private static boolean q(j jVar, byte[] bArr) {
        jVar.g();
        byte[] bArr2 = new byte[bArr.length];
        jVar.n(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int r(j jVar) {
        jVar.g();
        jVar.n(this.f9122a, 0, 1);
        byte b6 = this.f9122a[0];
        if ((b6 & 131) <= 0) {
            return j((b6 >> 3) & 15);
        }
        StringBuilder sb = new StringBuilder(42);
        sb.append("Invalid padding bits for frame header ");
        sb.append((int) b6);
        throw new f1(sb.toString());
    }

    private boolean s(j jVar) {
        int length;
        byte[] bArr = f9119s;
        if (q(jVar, bArr)) {
            this.f9124c = false;
            length = bArr.length;
        } else {
            byte[] bArr2 = f9120t;
            if (!q(jVar, bArr2)) {
                return false;
            }
            this.f9124c = true;
            length = bArr2.length;
        }
        jVar.h(length);
        return true;
    }

    private int t(j jVar) {
        if (this.f9127f == 0) {
            try {
                int r5 = r(jVar);
                this.f9126e = r5;
                this.f9127f = r5;
                if (this.f9130i == -1) {
                    this.f9129h = jVar.p();
                    this.f9130i = this.f9126e;
                }
                if (this.f9130i == this.f9126e) {
                    this.f9131j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int b6 = this.f9134m.b(jVar, this.f9127f, true);
        if (b6 == -1) {
            return -1;
        }
        int i6 = this.f9127f - b6;
        this.f9127f = i6;
        if (i6 > 0) {
            return 0;
        }
        this.f9134m.d(this.f9132k + this.f9125d, 1, this.f9126e, 0, null);
        this.f9125d += 20000;
        return 0;
    }

    @Override // c1.i
    public void a() {
    }

    @Override // c1.i
    public void c(k kVar) {
        this.f9133l = kVar;
        this.f9134m = kVar.e(0, 1);
        kVar.g();
    }

    @Override // c1.i
    public void d(long j6, long j7) {
        this.f9125d = 0L;
        this.f9126e = 0;
        this.f9127f = 0;
        if (j6 != 0) {
            x xVar = this.f9135n;
            if (xVar instanceof e) {
                this.f9132k = ((e) xVar).c(j6);
                return;
            }
        }
        this.f9132k = 0L;
    }

    @Override // c1.i
    public int g(j jVar, w wVar) {
        e();
        if (jVar.p() != 0 || s(jVar)) {
            o();
            int t5 = t(jVar);
            p(jVar.a(), t5);
            return t5;
        }
        throw new f1("Could not find AMR header.");
    }

    @Override // c1.i
    public boolean h(j jVar) {
        return s(jVar);
    }

    public b(int i6) {
        this.f9123b = i6;
        this.f9122a = new byte[1];
        this.f9130i = -1;
    }
}
