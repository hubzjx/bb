package l1;

import com.google.android.exoplayer2.util.s0;
import l1.i0;
/* loaded from: classes.dex */
public final class c0 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    private final b0 f11454a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.y f11455b = new com.google.android.exoplayer2.util.y(32);

    /* renamed from: c  reason: collision with root package name */
    private int f11456c;

    /* renamed from: d  reason: collision with root package name */
    private int f11457d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11458e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11459f;

    public c0(b0 b0Var) {
        this.f11454a = b0Var;
    }

    @Override // l1.i0
    public void a() {
        this.f11459f = true;
    }

    @Override // l1.i0
    public void b(com.google.android.exoplayer2.util.k0 k0Var, c1.k kVar, i0.d dVar) {
        this.f11454a.b(k0Var, kVar, dVar);
        this.f11459f = true;
    }

    @Override // l1.i0
    public void c(com.google.android.exoplayer2.util.y yVar, int i6) {
        boolean z5 = (i6 & 1) != 0;
        int d6 = z5 ? yVar.d() + yVar.A() : -1;
        if (this.f11459f) {
            if (!z5) {
                return;
            }
            this.f11459f = false;
            yVar.M(d6);
            this.f11457d = 0;
        }
        while (yVar.a() > 0) {
            int i7 = this.f11457d;
            if (i7 < 3) {
                if (i7 == 0) {
                    int A = yVar.A();
                    yVar.M(yVar.d() - 1);
                    if (A == 255) {
                        this.f11459f = true;
                        return;
                    }
                }
                int min = Math.min(yVar.a(), 3 - this.f11457d);
                yVar.i(this.f11455b.c(), this.f11457d, min);
                int i8 = this.f11457d + min;
                this.f11457d = i8;
                if (i8 == 3) {
                    this.f11455b.I(3);
                    this.f11455b.N(1);
                    int A2 = this.f11455b.A();
                    int A3 = this.f11455b.A();
                    this.f11458e = (A2 & 128) != 0;
                    this.f11456c = (((A2 & 15) << 8) | A3) + 3;
                    if (this.f11455b.b() < this.f11456c) {
                        byte[] c6 = this.f11455b.c();
                        this.f11455b.I(Math.min(4098, Math.max(this.f11456c, c6.length * 2)));
                        System.arraycopy(c6, 0, this.f11455b.c(), 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(yVar.a(), this.f11456c - this.f11457d);
                yVar.i(this.f11455b.c(), this.f11457d, min2);
                int i9 = this.f11457d + min2;
                this.f11457d = i9;
                int i10 = this.f11456c;
                if (i9 != i10) {
                    continue;
                } else {
                    if (!this.f11458e) {
                        this.f11455b.I(i10);
                    } else if (s0.u(this.f11455b.c(), 0, this.f11456c, -1) != 0) {
                        this.f11459f = true;
                        return;
                    } else {
                        this.f11455b.I(this.f11456c - 4);
                    }
                    this.f11454a.c(this.f11455b);
                    this.f11457d = 0;
                }
            }
        }
    }
}
