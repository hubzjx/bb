package l1;

import com.google.android.exoplayer2.s0;
import java.util.List;
import l1.i0;
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    private final List f11460a;

    /* renamed from: b  reason: collision with root package name */
    private final c1.a0[] f11461b;

    public d0(List list) {
        this.f11460a = list;
        this.f11461b = new c1.a0[list.size()];
    }

    public void a(long j6, com.google.android.exoplayer2.util.y yVar) {
        c1.c.a(j6, yVar, this.f11461b);
    }

    public void b(c1.k kVar, i0.d dVar) {
        for (int i6 = 0; i6 < this.f11461b.length; i6++) {
            dVar.a();
            c1.a0 e6 = kVar.e(dVar.c(), 3);
            s0 s0Var = (s0) this.f11460a.get(i6);
            String str = s0Var.f4056n;
            boolean z5 = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String valueOf = String.valueOf(str);
            com.google.android.exoplayer2.util.a.b(z5, valueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(valueOf) : new String("Invalid closed caption mime type provided: "));
            String str2 = s0Var.f4045a;
            if (str2 == null) {
                str2 = dVar.b();
            }
            e6.e(new s0.b().S(str2).e0(str).g0(s0Var.f4048d).V(s0Var.f4047c).F(s0Var.F).T(s0Var.f4058p).E());
            this.f11461b[i6] = e6;
        }
    }
}
