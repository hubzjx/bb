package g;

import f.InterfaceC0274j$v;
import okhttp3.internal.http2.Http2;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$h2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0308j$h2 extends AbstractC0298j$f0 {

    /* renamed from: v  reason: collision with root package name */
    public static final /* synthetic */ int f10170v = 0;

    /* renamed from: t  reason: collision with root package name */
    final /* synthetic */ long f10171t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ long f10172u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0308j$h2(AbstractC0306j$h0 abstractC0306j$h0, int i6, long j6, long j7) {
        super(abstractC0306j$h0, i6);
        this.f10171t = j6;
        this.f10172u = j7;
    }

    static e.j$F T0(e.j$F j_f, long j6, long j7, long j8) {
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
        return new j$q3(j_f, j9, j10);
    }

    @Override // g.AbstractC0285j$c
    final j$B0 E0(e.j$J j_j, InterfaceC0274j$v interfaceC0274j$v, AbstractC0285j$c abstractC0285j$c) {
        long W = abstractC0285j$c.W(j_j);
        return (W <= 0 || !j_j.hasCharacteristics(Http2.INITIAL_MAX_FRAME_SIZE)) ? !j$P2.f10048h.d(abstractC0285j$c.c0()) ? AbstractC0350j$s0.P(this, T0((e.j$F) abstractC0285j$c.N0(j_j), this.f10171t, this.f10172u, W), true) : (j$B0) new C0320j$k2(this, abstractC0285j$c, j_j, interfaceC0274j$v, this.f10171t, this.f10172u).invoke() : AbstractC0350j$s0.P(abstractC0285j$c, AbstractC0350j$s0.G(abstractC0285j$c.A0(), j_j, this.f10171t, this.f10172u), true);
    }

    @Override // g.AbstractC0285j$c
    final e.j$J F0(AbstractC0285j$c abstractC0285j$c, e.j$J j_j) {
        long W = abstractC0285j$c.W(j_j);
        if (W <= 0 || !j_j.hasCharacteristics(Http2.INITIAL_MAX_FRAME_SIZE)) {
            return !j$P2.f10048h.d(abstractC0285j$c.c0()) ? T0((e.j$F) abstractC0285j$c.N0(j_j), this.f10171t, this.f10172u, W) : ((j$B0) new C0320j$k2(this, abstractC0285j$c, j_j, new j$F0(10), this.f10171t, this.f10172u).invoke()).spliterator();
        }
        long j6 = this.f10171t;
        return new j$k3((e.j$F) abstractC0285j$c.N0(j_j), j6, AbstractC0350j$s0.F(j6, this.f10172u));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0285j$c
    public final InterfaceC0284j$b2 H0(int i6, final InterfaceC0284j$b2 interfaceC0284j$b2) {
        return new j$W1(interfaceC0284j$b2) { // from class: g.j$g2

            /* renamed from: b  reason: collision with root package name */
            long f10166b;

            /* renamed from: c  reason: collision with root package name */
            long f10167c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f10166b = C0308j$h2.this.f10171t;
                long j6 = C0308j$h2.this.f10172u;
                this.f10167c = j6 < 0 ? Long.MAX_VALUE : j6;
            }

            @Override // g.InterfaceC0284j$b2
            public final void f(long j6) {
                long j7 = this.f10166b;
                if (j7 != 0) {
                    this.f10166b = j7 - 1;
                    return;
                }
                long j8 = this.f10167c;
                if (j8 > 0) {
                    this.f10167c = j8 - 1;
                    this.f10100a.f(j6);
                }
            }

            @Override // g.InterfaceC0284j$b2
            public final void i(long j6) {
                this.f10100a.i(AbstractC0350j$s0.H(j6, C0308j$h2.this.f10171t, this.f10167c));
            }

            @Override // g.j$W1, g.InterfaceC0284j$b2
            public final boolean o() {
                return this.f10167c == 0 || this.f10100a.o();
            }
        };
    }
}
