package l1;

import com.google.android.exoplayer2.s0;
import l1.i0;
/* loaded from: classes.dex */
public final class r implements m {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11711a = new com.google.android.exoplayer2.util.y(10);

    /* renamed from: b  reason: collision with root package name */
    private c1.a0 f11712b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11713c;

    /* renamed from: d  reason: collision with root package name */
    private long f11714d;

    /* renamed from: e  reason: collision with root package name */
    private int f11715e;

    /* renamed from: f  reason: collision with root package name */
    private int f11716f;

    @Override // l1.m
    public void a() {
        this.f11713c = false;
    }

    @Override // l1.m
    public void c(com.google.android.exoplayer2.util.y yVar) {
        com.google.android.exoplayer2.util.a.i(this.f11712b);
        if (this.f11713c) {
            int a6 = yVar.a();
            int i6 = this.f11716f;
            if (i6 < 10) {
                int min = Math.min(a6, 10 - i6);
                System.arraycopy(yVar.c(), yVar.d(), this.f11711a.c(), this.f11716f, min);
                if (this.f11716f + min == 10) {
                    this.f11711a.M(0);
                    if (73 != this.f11711a.A() || 68 != this.f11711a.A() || 51 != this.f11711a.A()) {
                        com.google.android.exoplayer2.util.n.h("Id3Reader", "Discarding invalid ID3 tag");
                        this.f11713c = false;
                        return;
                    }
                    this.f11711a.N(3);
                    this.f11715e = this.f11711a.z() + 10;
                }
            }
            int min2 = Math.min(a6, this.f11715e - this.f11716f);
            this.f11712b.a(yVar, min2);
            this.f11716f += min2;
        }
    }

    @Override // l1.m
    public void d() {
        int i6;
        com.google.android.exoplayer2.util.a.i(this.f11712b);
        if (this.f11713c && (i6 = this.f11715e) != 0 && this.f11716f == i6) {
            this.f11712b.d(this.f11714d, 1, i6, 0, null);
            this.f11713c = false;
        }
    }

    @Override // l1.m
    public void e(long j6, int i6) {
        if ((i6 & 4) == 0) {
            return;
        }
        this.f11713c = true;
        this.f11714d = j6;
        this.f11715e = 0;
        this.f11716f = 0;
    }

    @Override // l1.m
    public void f(c1.k kVar, i0.d dVar) {
        dVar.a();
        c1.a0 e6 = kVar.e(dVar.c(), 4);
        this.f11712b = e6;
        e6.e(new s0.b().S(dVar.b()).e0("application/id3").E());
    }
}
