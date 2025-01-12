package g;

import f.InterfaceC0274j$v;
import okhttp3.internal.http2.Http2;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$j2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0316j$j2 extends AbstractC0373j$y {

    /* renamed from: v  reason: collision with root package name */
    public static final /* synthetic */ int f10184v = 0;

    /* renamed from: t  reason: collision with root package name */
    final /* synthetic */ long f10185t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ long f10186u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0316j$j2(j$A j_a, int i6, long j6, long j7) {
        super(j_a, i6);
        this.f10185t = j6;
        this.f10186u = j7;
    }

    static e.j$B T0(e.j$B j_b, long j6, long j7, long j8) {
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
        return new j$o3(j_b, j9, j10);
    }

    @Override // g.AbstractC0285j$c
    final j$B0 E0(e.j$J j_j, InterfaceC0274j$v interfaceC0274j$v, AbstractC0285j$c abstractC0285j$c) {
        long W = abstractC0285j$c.W(j_j);
        return (W <= 0 || !j_j.hasCharacteristics(Http2.INITIAL_MAX_FRAME_SIZE)) ? !j$P2.f10048h.d(abstractC0285j$c.c0()) ? AbstractC0350j$s0.N(this, T0((e.j$B) abstractC0285j$c.N0(j_j), this.f10185t, this.f10186u, W), true) : (j$B0) new C0320j$k2(this, abstractC0285j$c, j_j, interfaceC0274j$v, this.f10185t, this.f10186u).invoke() : AbstractC0350j$s0.N(abstractC0285j$c, AbstractC0350j$s0.G(abstractC0285j$c.A0(), j_j, this.f10185t, this.f10186u), true);
    }

    @Override // g.AbstractC0285j$c
    final e.j$J F0(AbstractC0285j$c abstractC0285j$c, e.j$J j_j) {
        long W = abstractC0285j$c.W(j_j);
        if (W <= 0 || !j_j.hasCharacteristics(Http2.INITIAL_MAX_FRAME_SIZE)) {
            return !j$P2.f10048h.d(abstractC0285j$c.c0()) ? T0((e.j$B) abstractC0285j$c.N0(j_j), this.f10185t, this.f10186u, W) : ((j$B0) new C0320j$k2(this, abstractC0285j$c, j_j, new j$F0(11), this.f10185t, this.f10186u).invoke()).spliterator();
        }
        long j6 = this.f10185t;
        return new j$g3((e.j$B) abstractC0285j$c.N0(j_j), j6, AbstractC0350j$s0.F(j6, this.f10186u));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0285j$c
    public final InterfaceC0284j$b2 H0(int i6, final InterfaceC0284j$b2 interfaceC0284j$b2) {
        return new j$U1(interfaceC0284j$b2) { // from class: g.j$i2

            /* renamed from: b  reason: collision with root package name */
            long f10179b;

            /* renamed from: c  reason: collision with root package name */
            long f10180c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f10179b = C0316j$j2.this.f10185t;
                long j6 = C0316j$j2.this.f10186u;
                this.f10180c = j6 < 0 ? Long.MAX_VALUE : j6;
            }

            @Override // g.InterfaceC0284j$b2
            public final void d(double d6) {
                long j6 = this.f10179b;
                if (j6 != 0) {
                    this.f10179b = j6 - 1;
                    return;
                }
                long j7 = this.f10180c;
                if (j7 > 0) {
                    this.f10180c = j7 - 1;
                    this.f10094a.d(d6);
                }
            }

            @Override // g.InterfaceC0284j$b2
            public final void i(long j6) {
                this.f10094a.i(AbstractC0350j$s0.H(j6, C0316j$j2.this.f10185t, this.f10180c));
            }

            @Override // g.j$U1, g.InterfaceC0284j$b2
            public final boolean o() {
                return this.f10180c == 0 || this.f10094a.o();
            }
        };
    }
}
