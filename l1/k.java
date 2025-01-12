package l1;

import com.google.android.exoplayer2.audio.z0;
import com.google.android.exoplayer2.s0;
import l1.i0;
/* loaded from: classes.dex */
public final class k implements m {

    /* renamed from: b  reason: collision with root package name */
    private final String f11569b;

    /* renamed from: c  reason: collision with root package name */
    private String f11570c;

    /* renamed from: d  reason: collision with root package name */
    private c1.a0 f11571d;

    /* renamed from: f  reason: collision with root package name */
    private int f11573f;

    /* renamed from: g  reason: collision with root package name */
    private int f11574g;

    /* renamed from: h  reason: collision with root package name */
    private long f11575h;

    /* renamed from: i  reason: collision with root package name */
    private s0 f11576i;

    /* renamed from: j  reason: collision with root package name */
    private int f11577j;

    /* renamed from: k  reason: collision with root package name */
    private long f11578k;

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11568a = new com.google.android.exoplayer2.util.y(new byte[18]);

    /* renamed from: e  reason: collision with root package name */
    private int f11572e = 0;

    public k(String str) {
        this.f11569b = str;
    }

    private boolean b(com.google.android.exoplayer2.util.y yVar, byte[] bArr, int i6) {
        int min = Math.min(yVar.a(), i6 - this.f11573f);
        yVar.i(bArr, this.f11573f, min);
        int i7 = this.f11573f + min;
        this.f11573f = i7;
        return i7 == i6;
    }

    private void g() {
        byte[] c6 = this.f11568a.c();
        if (this.f11576i == null) {
            s0 g6 = z0.g(c6, this.f11570c, this.f11569b, null);
            this.f11576i = g6;
            this.f11571d.e(g6);
        }
        this.f11577j = z0.a(c6);
        this.f11575h = (int) ((z0.f(c6) * 1000000) / this.f11576i.B);
    }

    private boolean h(com.google.android.exoplayer2.util.y yVar) {
        while (yVar.a() > 0) {
            int i6 = this.f11574g << 8;
            this.f11574g = i6;
            int A = i6 | yVar.A();
            this.f11574g = A;
            if (z0.d(A)) {
                byte[] c6 = this.f11568a.c();
                int i7 = this.f11574g;
                c6[0] = (byte) ((i7 >> 24) & 255);
                c6[1] = (byte) ((i7 >> 16) & 255);
                c6[2] = (byte) ((i7 >> 8) & 255);
                c6[3] = (byte) (i7 & 255);
                this.f11573f = 4;
                this.f11574g = 0;
                return true;
            }
        }
        return false;
    }

    @Override // l1.m
    public void a() {
        this.f11572e = 0;
        this.f11573f = 0;
        this.f11574g = 0;
    }

    @Override // l1.m
    public void c(com.google.android.exoplayer2.util.y yVar) {
        com.google.android.exoplayer2.util.a.i(this.f11571d);
        while (yVar.a() > 0) {
            int i6 = this.f11572e;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 != 2) {
                        throw new IllegalStateException();
                    }
                    int min = Math.min(yVar.a(), this.f11577j - this.f11573f);
                    this.f11571d.a(yVar, min);
                    int i7 = this.f11573f + min;
                    this.f11573f = i7;
                    int i8 = this.f11577j;
                    if (i7 == i8) {
                        this.f11571d.d(this.f11578k, 1, i8, 0, null);
                        this.f11578k += this.f11575h;
                        this.f11572e = 0;
                    }
                } else if (b(yVar, this.f11568a.c(), 18)) {
                    g();
                    this.f11568a.M(0);
                    this.f11571d.a(this.f11568a, 18);
                    this.f11572e = 2;
                }
            } else if (h(yVar)) {
                this.f11572e = 1;
            }
        }
    }

    @Override // l1.m
    public void d() {
    }

    @Override // l1.m
    public void e(long j6, int i6) {
        this.f11578k = j6;
    }

    @Override // l1.m
    public void f(c1.k kVar, i0.d dVar) {
        dVar.a();
        this.f11570c = dVar.b();
        this.f11571d = kVar.e(dVar.c(), 1);
    }
}
