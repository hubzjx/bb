package g;

import f.InterfaceC0274j$v;
import okhttp3.internal.http2.Http2;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$d2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0292j$d2 extends j$R1 {

    /* renamed from: t  reason: collision with root package name */
    final /* synthetic */ long f10137t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ long f10138u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0292j$d2(j$T1 j_t1, int i6, long j6, long j7) {
        super(j_t1, i6);
        this.f10137t = j6;
        this.f10138u = j7;
    }

    static e.j$J R0(e.j$J j_j, long j6, long j7, long j8) {
        long j9;
        long j10;
        if (j6 <= j8) {
            long j11 = j8 - j6;
            j10 = j7 >= 0 ? Math.min(j7, j11) : j11;
            j9 = 0;
        } else {
            j9 = j6;
            j10 = j7;
        }
        return new j$s3(j_j, j9, j10);
    }

    @Override // g.AbstractC0285j$c
    final j$B0 E0(e.j$J j_j, InterfaceC0274j$v interfaceC0274j$v, AbstractC0285j$c abstractC0285j$c) {
        long W = abstractC0285j$c.W(j_j);
        return (W <= 0 || !j_j.hasCharacteristics(Http2.INITIAL_MAX_FRAME_SIZE)) ? !j$P2.f10048h.d(abstractC0285j$c.c0()) ? AbstractC0350j$s0.M(this, R0(abstractC0285j$c.N0(j_j), this.f10137t, this.f10138u, W), true, interfaceC0274j$v) : (j$B0) new C0320j$k2(this, abstractC0285j$c, j_j, interfaceC0274j$v, this.f10137t, this.f10138u).invoke() : AbstractC0350j$s0.M(abstractC0285j$c, AbstractC0350j$s0.G(abstractC0285j$c.A0(), j_j, this.f10137t, this.f10138u), true, interfaceC0274j$v);
    }

    @Override // g.AbstractC0285j$c
    final e.j$J F0(AbstractC0285j$c abstractC0285j$c, e.j$J j_j) {
        long W = abstractC0285j$c.W(j_j);
        if (W <= 0 || !j_j.hasCharacteristics(Http2.INITIAL_MAX_FRAME_SIZE)) {
            return !j$P2.f10048h.d(abstractC0285j$c.c0()) ? R0(abstractC0285j$c.N0(j_j), this.f10137t, this.f10138u, W) : ((j$B0) new C0320j$k2(this, abstractC0285j$c, j_j, new j$F0(8), this.f10137t, this.f10138u).invoke()).spliterator();
        }
        e.j$J N0 = abstractC0285j$c.N0(j_j);
        long j6 = this.f10137t;
        return new j$m3(N0, j6, AbstractC0350j$s0.F(j6, this.f10138u));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0285j$c
    public final InterfaceC0284j$b2 H0(int i6, final InterfaceC0284j$b2 interfaceC0284j$b2) {
        return new j$X1(interfaceC0284j$b2) { // from class: g.j$c2

            /* renamed from: b  reason: collision with root package name */
            long f10130b;

            /* renamed from: c  reason: collision with root package name */
            long f10131c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f10130b = C0292j$d2.this.f10137t;
                long j6 = C0292j$d2.this.f10138u;
                this.f10131c = j6 < 0 ? Long.MAX_VALUE : j6;
            }

            @Override // g.InterfaceC0284j$b2
            public final void i(long j6) {
                this.f10102a.i(AbstractC0350j$s0.H(j6, C0292j$d2.this.f10137t, this.f10131c));
            }

            @Override // f.InterfaceC0257j$e
            public final void j(Object obj) {
                long j6 = this.f10130b;
                if (j6 != 0) {
                    this.f10130b = j6 - 1;
                    return;
                }
                long j7 = this.f10131c;
                if (j7 > 0) {
                    this.f10131c = j7 - 1;
                    this.f10102a.j(obj);
                }
            }

            @Override // g.j$X1, g.InterfaceC0284j$b2
            public final boolean o() {
                return this.f10131c == 0 || this.f10102a.o();
            }
        };
    }
}
