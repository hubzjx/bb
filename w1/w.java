package w1;

import android.net.Uri;
import com.google.android.exoplayer2.drm.i;
import com.google.android.exoplayer2.w0;
import java.util.Map;
import q2.a0;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private a0.b f14077a;

    /* renamed from: b  reason: collision with root package name */
    private String f14078b;

    public com.google.android.exoplayer2.drm.v a(com.google.android.exoplayer2.w0 w0Var) {
        com.google.android.exoplayer2.util.a.e(w0Var.f4702b);
        w0.d dVar = w0Var.f4702b.f4742c;
        if (dVar == null || dVar.f4733b == null || com.google.android.exoplayer2.util.s0.f4673a < 18) {
            return com.google.android.exoplayer2.drm.u.c();
        }
        a0.b bVar = this.f14077a;
        if (bVar == null) {
            String str = this.f14078b;
            if (str == null) {
                str = com.google.android.exoplayer2.r0.f4032a;
            }
            bVar = new q2.v(str);
        }
        com.google.android.exoplayer2.drm.e0 e0Var = new com.google.android.exoplayer2.drm.e0(((Uri) com.google.android.exoplayer2.util.s0.j(dVar.f4733b)).toString(), dVar.f4737f, bVar);
        for (Map.Entry entry : dVar.f4734c.entrySet()) {
            e0Var.e((String) entry.getKey(), (String) entry.getValue());
        }
        com.google.android.exoplayer2.drm.i a6 = new i.b().e(dVar.f4732a, com.google.android.exoplayer2.drm.d0.f3626d).b(dVar.f4735d).c(dVar.f4736e).d(com.google.common.primitives.b.h(dVar.f4738g)).a(e0Var);
        a6.u(0, dVar.a());
        return a6;
    }
}
