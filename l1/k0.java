package l1;

import com.google.android.exoplayer2.s0;
import java.util.List;
import l1.i0;
/* loaded from: classes.dex */
final class k0 {

    /* renamed from: a  reason: collision with root package name */
    private final List f11579a;

    /* renamed from: b  reason: collision with root package name */
    private final c1.a0[] f11580b;

    public k0(List list) {
        this.f11579a = list;
        this.f11580b = new c1.a0[list.size()];
    }

    public void a(long j6, com.google.android.exoplayer2.util.y yVar) {
        if (yVar.a() < 9) {
            return;
        }
        int k6 = yVar.k();
        int k7 = yVar.k();
        int A = yVar.A();
        if (k6 == 434 && k7 == 1195456820 && A == 3) {
            c1.c.b(j6, yVar, this.f11580b);
        }
    }

    public void b(c1.k kVar, i0.d dVar) {
        for (int i6 = 0; i6 < this.f11580b.length; i6++) {
            dVar.a();
            c1.a0 e6 = kVar.e(dVar.c(), 3);
            s0 s0Var = (s0) this.f11579a.get(i6);
            String str = s0Var.f4056n;
            boolean z5 = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String valueOf = String.valueOf(str);
            com.google.android.exoplayer2.util.a.b(z5, valueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(valueOf) : new String("Invalid closed caption mime type provided: "));
            e6.e(new s0.b().S(dVar.b()).e0(str).g0(s0Var.f4048d).V(s0Var.f4047c).F(s0Var.F).T(s0Var.f4058p).E());
            this.f11580b[i6] = e6;
        }
    }
}
