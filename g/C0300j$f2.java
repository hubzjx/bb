package g;

import f.InterfaceC0274j$v;
import okhttp3.internal.http2.Http2;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g.j$f2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0300j$f2 extends j$X {

    /* renamed from: v  reason: collision with root package name */
    public static final /* synthetic */ int f10162v = 0;

    /* renamed from: t  reason: collision with root package name */
    final /* synthetic */ long f10163t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ long f10164u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0300j$f2(j$Z j_z, int i6, long j6, long j7) {
        super(j_z, i6);
        this.f10163t = j6;
        this.f10164u = j7;
    }

    static e.j$D T0(e.j$D j_d, long j6, long j7, long j8) {
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
        return new j$p3(j_d, j9, j10);
    }

    @Override // g.AbstractC0285j$c
    final j$B0 E0(e.j$J j_j, InterfaceC0274j$v interfaceC0274j$v, AbstractC0285j$c abstractC0285j$c) {
        long W = abstractC0285j$c.W(j_j);
        return (W <= 0 || !j_j.hasCharacteristics(Http2.INITIAL_MAX_FRAME_SIZE)) ? !j$P2.f10048h.d(abstractC0285j$c.c0()) ? AbstractC0350j$s0.O(this, T0((e.j$D) abstractC0285j$c.N0(j_j), this.f10163t, this.f10164u, W), true) : (j$B0) new C0320j$k2(this, abstractC0285j$c, j_j, interfaceC0274j$v, this.f10163t, this.f10164u).invoke() : AbstractC0350j$s0.O(abstractC0285j$c, AbstractC0350j$s0.G(abstractC0285j$c.A0(), j_j, this.f10163t, this.f10164u), true);
    }

    @Override // g.AbstractC0285j$c
    final e.j$J F0(AbstractC0285j$c abstractC0285j$c, e.j$J j_j) {
        long W = abstractC0285j$c.W(j_j);
        if (W <= 0 || !j_j.hasCharacteristics(Http2.INITIAL_MAX_FRAME_SIZE)) {
            return !j$P2.f10048h.d(abstractC0285j$c.c0()) ? T0((e.j$D) abstractC0285j$c.N0(j_j), this.f10163t, this.f10164u, W) : ((j$B0) new C0320j$k2(this, abstractC0285j$c, j_j, new j$F0(9), this.f10163t, this.f10164u).invoke()).spliterator();
        }
        long j6 = this.f10163t;
        return new j$i3((e.j$D) abstractC0285j$c.N0(j_j), j6, AbstractC0350j$s0.F(j6, this.f10164u));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // g.AbstractC0285j$c
    public final InterfaceC0284j$b2 H0(int i6, final InterfaceC0284j$b2 interfaceC0284j$b2) {
        return new j$V1(interfaceC0284j$b2) { // from class: g.j$e2

            /* renamed from: b  reason: collision with root package name */
            long f10150b;

            /* renamed from: c  reason: collision with root package name */
            long f10151c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f10150b = C0300j$f2.this.f10163t;
                long j6 = C0300j$f2.this.f10164u;
                this.f10151c = j6 < 0 ? Long.MAX_VALUE : j6;
            }

            @Override // g.InterfaceC0284j$b2
            public final void e(int i7) {
                long j6 = this.f10150b;
                if (j6 != 0) {
                    this.f10150b = j6 - 1;
                    return;
                }
                long j7 = this.f10151c;
                if (j7 > 0) {
                    this.f10151c = j7 - 1;
                    this.f10096a.e(i7);
                }
            }

            @Override // g.InterfaceC0284j$b2
            public final void i(long j6) {
                this.f10096a.i(AbstractC0350j$s0.H(j6, C0300j$f2.this.f10163t, this.f10151c));
            }

            @Override // g.j$V1, g.InterfaceC0284j$b2
            public final boolean o() {
                return this.f10151c == 0 || this.f10096a.o();
            }
        };
    }
}
