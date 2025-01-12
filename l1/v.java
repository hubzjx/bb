package l1;

import com.google.android.exoplayer2.s0;
import l1.i0;
/* loaded from: classes.dex */
public final class v implements b0 {

    /* renamed from: a  reason: collision with root package name */
    private s0 f11755a;

    /* renamed from: b  reason: collision with root package name */
    private com.google.android.exoplayer2.util.k0 f11756b;

    /* renamed from: c  reason: collision with root package name */
    private c1.a0 f11757c;

    public v(String str) {
        this.f11755a = new s0.b().e0(str).E();
    }

    private void a() {
        com.google.android.exoplayer2.util.a.i(this.f11756b);
        com.google.android.exoplayer2.util.s0.j(this.f11757c);
    }

    @Override // l1.b0
    public void b(com.google.android.exoplayer2.util.k0 k0Var, c1.k kVar, i0.d dVar) {
        this.f11756b = k0Var;
        dVar.a();
        c1.a0 e6 = kVar.e(dVar.c(), 4);
        this.f11757c = e6;
        e6.e(this.f11755a);
    }

    @Override // l1.b0
    public void c(com.google.android.exoplayer2.util.y yVar) {
        a();
        long e6 = this.f11756b.e();
        if (e6 == -9223372036854775807L) {
            return;
        }
        s0 s0Var = this.f11755a;
        if (e6 != s0Var.f4060r) {
            s0 E = s0Var.e().i0(e6).E();
            this.f11755a = E;
            this.f11757c.e(E);
        }
        int a6 = yVar.a();
        this.f11757c.a(yVar, a6);
        this.f11757c.d(this.f11756b.d(), 1, a6, 0, null);
    }
}
