package l1;

import com.google.android.exoplayer2.audio.c1;
import com.google.android.exoplayer2.s0;
import l1.i0;
import okio.internal._BufferKt;
/* loaded from: classes.dex */
public final class t implements m {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11738a;

    /* renamed from: b  reason: collision with root package name */
    private final c1.a f11739b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11740c;

    /* renamed from: d  reason: collision with root package name */
    private c1.a0 f11741d;

    /* renamed from: e  reason: collision with root package name */
    private String f11742e;

    /* renamed from: f  reason: collision with root package name */
    private int f11743f;

    /* renamed from: g  reason: collision with root package name */
    private int f11744g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11745h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11746i;

    /* renamed from: j  reason: collision with root package name */
    private long f11747j;

    /* renamed from: k  reason: collision with root package name */
    private int f11748k;

    /* renamed from: l  reason: collision with root package name */
    private long f11749l;

    public t() {
        this(null);
    }

    private void b(com.google.android.exoplayer2.util.y yVar) {
        byte[] c6 = yVar.c();
        int e6 = yVar.e();
        for (int d6 = yVar.d(); d6 < e6; d6++) {
            byte b6 = c6[d6];
            boolean z5 = (b6 & 255) == 255;
            boolean z6 = this.f11746i && (b6 & 224) == 224;
            this.f11746i = z5;
            if (z6) {
                yVar.M(d6 + 1);
                this.f11746i = false;
                this.f11738a.c()[1] = c6[d6];
                this.f11744g = 2;
                this.f11743f = 1;
                return;
            }
        }
        yVar.M(e6);
    }

    private void g(com.google.android.exoplayer2.util.y yVar) {
        int min = Math.min(yVar.a(), this.f11748k - this.f11744g);
        this.f11741d.a(yVar, min);
        int i6 = this.f11744g + min;
        this.f11744g = i6;
        int i7 = this.f11748k;
        if (i6 < i7) {
            return;
        }
        this.f11741d.d(this.f11749l, 1, i7, 0, null);
        this.f11749l += this.f11747j;
        this.f11744g = 0;
        this.f11743f = 0;
    }

    private void h(com.google.android.exoplayer2.util.y yVar) {
        int min = Math.min(yVar.a(), 4 - this.f11744g);
        yVar.i(this.f11738a.c(), this.f11744g, min);
        int i6 = this.f11744g + min;
        this.f11744g = i6;
        if (i6 < 4) {
            return;
        }
        this.f11738a.M(0);
        if (!this.f11739b.a(this.f11738a.k())) {
            this.f11744g = 0;
            this.f11743f = 1;
            return;
        }
        c1.a aVar = this.f11739b;
        this.f11748k = aVar.f3346c;
        if (!this.f11745h) {
            this.f11747j = (aVar.f3350g * 1000000) / aVar.f3347d;
            this.f11741d.e(new s0.b().S(this.f11742e).e0(this.f11739b.f3345b).W(_BufferKt.SEGMENTING_THRESHOLD).H(this.f11739b.f3348e).f0(this.f11739b.f3347d).V(this.f11740c).E());
            this.f11745h = true;
        }
        this.f11738a.M(0);
        this.f11741d.a(this.f11738a, 4);
        this.f11743f = 2;
    }

    @Override // l1.m
    public void a() {
        this.f11743f = 0;
        this.f11744g = 0;
        this.f11746i = false;
    }

    @Override // l1.m
    public void c(com.google.android.exoplayer2.util.y yVar) {
        com.google.android.exoplayer2.util.a.i(this.f11741d);
        while (yVar.a() > 0) {
            int i6 = this.f11743f;
            if (i6 == 0) {
                b(yVar);
            } else if (i6 == 1) {
                h(yVar);
            } else if (i6 != 2) {
                throw new IllegalStateException();
            } else {
                g(yVar);
            }
        }
    }

    @Override // l1.m
    public void d() {
    }

    @Override // l1.m
    public void e(long j6, int i6) {
        this.f11749l = j6;
    }

    @Override // l1.m
    public void f(c1.k kVar, i0.d dVar) {
        dVar.a();
        this.f11742e = dVar.b();
        this.f11741d = kVar.e(dVar.c(), 1);
    }

    public t(String str) {
        this.f11743f = 0;
        com.google.android.exoplayer2.util.y yVar = new com.google.android.exoplayer2.util.y(4);
        this.f11738a = yVar;
        yVar.c()[0] = -1;
        this.f11739b = new c1.a();
        this.f11740c = str;
    }
}
